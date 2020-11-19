import { Home } from './views/Home.js';
import { Register } from './views/Register.js';
import { Login } from './views/Login.js';
import { TagList } from './views/tag/TagList.js';
import { UserDetail } from './views/user/UserDetail.js';
import { WorkList } from './views/work/WorkList.js';
import { PostCreate } from './views/post/PostCreate.js';


/* ---------------------------------
 *          Routes Array
 * --------------------------------- */
const routes = [
    { path : '/', view : Home},
    { path : '/login', view : Login},
    { path : '/register', view : Register },
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

    const view = new route.view();
    document.getElementById('app').innerHTML = await view.getHtml(); 
};

/* ---------------------------------
 *   이전, 다음 이벤트에도 화면 갱신
 * --------------------------------- */
window.addEventListener('popstate', render);


/* ---------------------------------
 *  모든 DOM이 로딩되었을 때 클릭 이벤트 
 * --------------------------------- */
document.addEventListener('DOMContentLoaded', ( ) => {
    let pathname = location.pathname;
    render( pathname );

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