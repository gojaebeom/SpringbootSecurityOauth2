import { getCookie, setCookie, deleteCookie } from './index.js';

const account = document.getElementById('account');
const remember = document.getElementById('remember');

export const loginCookie = () => {
    const loginC = getCookie('loginId');
    account.value = loginC;

    if(account.value !== ''){
        remember.checked = true;
    }

    remember.onchange = () => {
        if(remember.checked){
            setCookie('loginId', account.value, 7);
        }else{
            deleteCookie('loginId');
        }
    }

    account.onkeyup = () => {
        if(remember.checked){
            setCookie('loginId', account.value, 7);
        }
    }
}