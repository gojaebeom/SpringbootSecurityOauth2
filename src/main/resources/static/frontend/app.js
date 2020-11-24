// view Page
import { Home } from './views/Home.js';
import { Register } from './views/Register.js';
import { Login } from './views/Login.js';
import { TagList } from './views/tag/TagList.js';
import { UserDetail } from './views/user/UserDetail.js';
import { WorkList } from './views/work/WorkList.js';
import { PostCreate } from './views/post/PostCreate.js';

//validation
import { JoinValidation } from './validation/joinValidation.js';
import { LoginValidation } from './validation/loginValidation.js';

//api
import { asyncLoginUserInfo } from './api/index.js';

//dom event
import { dropboxToggle } from './domControl/dropboxToggle.js';

import { ckEditor } from './ckeditor/index.js';

/* ---------------------------------
 *          Routes Array
 * --------------------------------- */
const routes = [
    { path : '/', view : Home},
    { path : '/login', view : Login, actives: [LoginValidation]},
    { path : '/register', view : Register , actives : [JoinValidation] },
    { path : '/works', view : WorkList},
    { path : '/tags', view : TagList},
    { path : '/users', view : '유저 리스트'},
    { path : '/users/:id', view : UserDetail},
    { path : '/posts/create', view : PostCreate },
];

/* ---------------------------------
 *   URL 변경 , render 함수 호출
 * --------------------------------- */
const urlUpdater = ( pathname ) => {
    history.pushState(null, null, pathname );
    render( pathname ); 
}

/* ---------------------------------
 *   pathname 에 맞는 view 그리기
 * --------------------------------- */
const render = async ( pathname ) => {

    let route = routes.find( route => {
                    //  [pathname 정규표현식 🍰]=> 모든 route 들을 정규표현식으로 바꾸고 patcheck 에 정규표현식 저장 
                    // '/'를 '\/'로 바꾸고 ':[영문, 숫자]'를 모두 '(모든 정수)'를 받게끔 변경
                    let pathCheck = new RegExp('^'+route.path.replace(/\//g , '\\/' ).replace(/:\w+/g,'(\\d+)')+'$');
                    if(pathCheck.test( pathname ))
                        return route;
                });
    
    if(route === undefined)
        route = { ...routes[0] }

    //route에 맞는 view를 생성하여 그리기
    const view = new route.view();
    document.getElementById('app').innerHTML = await view.getHtml(); 

    //route에 기능들이 있다면, 존재하는 기능들 실행
    if(route.actives){
        route.actives.forEach( active => new active);
    }
};

const loginState = (loginCheck, userInfo) => {

    if(loginCheck){
        document.querySelector('.login-menu').style.display = "flex";
        document.querySelector('.logout-menu').style.display = "none";
    }
    
}

/* ---------------------------------
 *   이전, 다음 이벤트에도 화면 갱신
 * --------------------------------- */
window.addEventListener('popstate', render);

/* ---------------------------------
 *  모든 DOM이 로딩되었을 때 클릭 이벤트 
 * --------------------------------- */
document.addEventListener('DOMContentLoaded', async ( ) => {
    let pathname = location.pathname;
    render( pathname );
    

    //토큰
    let token = localStorage.getItem('Authorization');
    console.log(`%c 저장된 토큰 : ${token}`, `color:blue`);
    if(token !== null || token !== 'undefined' || token.length == 0){
        let response = await asyncLoginUserInfo(token);
        console.log(response);
        let json =  JSON.parse(response);
        loginState(true, {'id':json[0].id, 'nickname':json[0].nickname});
    }

    //ckEditor
    ckEditor();

    //드롭박스
    dropboxToggle();

    document.addEventListener('click', e => {
        
        if(e.target.dataset.href){
            console.log('hello');
            e.preventDefault();
            urlUpdater( e.target.dataset.href );
        }else if(e.target.parentNode.dataset != undefined){
            if(e.target.parentNode.dataset.href){
                console.log('hello');
                e.preventDefault();   
                urlUpdater( e.target.parentNode.dataset.href );
            }
        }
        
        if(e.target.parentNode.parentNode){
            if(e.target.parentNode.parentNode.dataset.href){
                e.preventDefault();
                urlUpdater( e.target.parentNode.parentNode.dataset.href );
            }
        }
        
    });
});