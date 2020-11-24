// view Page
import { Home } from './views/Home.js';
import { Join } from './views/Join.js';
import { Login } from './views/Login.js';
import { TagList } from './views/tag/TagList.js';
import { UserDetail } from './views/user/UserDetail.js';
import { WorkList } from './views/work/WorkList.js';
import { PostCreate } from './views/post/PostCreate.js';
//components
import { Navigation } from './components/Nav.js';
//api
import { asyncLoginUserInfo } from './api/index.js';
//dom event
import { dropboxToggle } from './domControl/dropboxToggle.js';


//기본적인 DOM 생성
const createMainDom = () => {
    const app = document.getElementById('app');
    const header = document.createElement('header')
    const section = document.createElement('section');
    header.innerHTML = Navigation();
    header.className = 'header';
    section.className = 'section';
    app.appendChild(header);
    app.appendChild(section);
}

//Routes Array
const routes = [
    { path : '/', view : Home },
    { path : '/login', view : Login },
    { path : '/join', view : Join },
    { path : '/works', view : WorkList },
    { path : '/tags', view : TagList },
    { path : '/users', view : '유저 리스트' },
    { path : '/users/:id', view : UserDetail },
    { path : '/posts/create', view : PostCreate },
];

//URL 변경 , render 함수 호출
const urlUpdater = ( pathname ) => {
    history.pushState(null, null, pathname );
    viewRender( pathname ); 
}

//pathname 에 맞는 view 그리기
const viewRender = async ( pathname ) => {
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
    document.querySelector('.section').innerHTML = 
    await view.render();
    await view.domIsCreated(); 
};

const loginState = (loginCheck, userInfo) => {
    if(loginCheck){
        document.querySelector('.login-menu').style.display = "flex";
        document.querySelector('.logout-menu').style.display = "none";
    }
}

//이전, 다음 이벤트에도 화면 갱신 🚀
window.addEventListener('popstate', viewRender);

//모든 DOM이 로딩되었을 때 콜백함수 실행 🚀
document.addEventListener('DOMContentLoaded', ( ) => {

    createMainDom();
    dropboxToggle();

    //pathname 을 인자값으로 넘겨 viewRender 함수 실행 🚀
    let pathname = location.pathname;
    viewRender( pathname );
    

    // //토큰
    // let token = localStorage.getItem('Authorization');
    // console.log(`%c 저장된 토큰 : ${token}`, `color:blue`);
    // if(token !== null || token !== 'undefined' || token.length == 0){
    //     let response = await asyncLoginUserInfo(token);
    //     console.log(response);
    //     let json =  JSON.parse(response);
    //     loginState(true, {'id':json[0].id, 'nickname':json[0].nickname});
    // }

    document.addEventListener('click', e => {
        
        if(e.target.dataset.href){
            e.preventDefault();
            urlUpdater( e.target.dataset.href );
        }else if(e.target.parentNode.dataset != undefined){
            if(e.target.parentNode.dataset.href){
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