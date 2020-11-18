
// DOM Control
import { homeActive, loginActive, profileActive, tagActive, workActive } from './domControl/navigationActive.js';
import { dropboxToggle } from './domControl/dropboxToggle.js';

// Validation and Http Request
import { LoginValidation }  from './validation/loginValidation.js';
import { RegisterValidation }  from './validation/registerValidation.js';
import { PostValidation } from './validation/postValidation.js';

//Cookie Control
import { loginCookie } from './cookies/loginCookie.js';

//LIB
import { ckEditor } from './ckeditor/index.js';


/* ---------------------------------
 *  url에 따라 페이지에 필요한 기능 실행
 * --------------------------------- */
const router = (pathname) => {
    //전역적으로 실행
    dropboxToggle();
    ckEditor();

    //필요한 페이지에서만 실행
    switch(pathname){
        case '/': 
            homeActive();
            break;
        case '/posts/create': 
            new PostValidation();
            break;
        case '/works': 
            workActive();
            break;
        case '/tags': 
            tagActive();
            break;
        case '/login': 
            loginActive();
            loginCookie();
            new LoginValidation();
            break;
        case '/register': 
            loginActive();
            new RegisterValidation();
            break;
        case '/profile': 
            profileActive();
            break;
        default : 
            return false;
    }
}

/* ---------------------------------
 *  화면의 dom이 모두 로딩되었을 때 실행되는 이벤트
 * --------------------------------- */
document.addEventListener("DOMContentLoaded", () => {
    router(location.pathname);
});

