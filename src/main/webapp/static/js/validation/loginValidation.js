import { asyncPostLogin } from '../asyncAPI/index.js';

const form = document.querySelector('.form');
const account = document.getElementById('account');
const password = document.getElementById('password');
const remember = document.getElementById('.remember');
const messageSpan = document.querySelector('.message-span');

export class LoginValidation{
    constructor(){
        this.init();
    }

    /* ---------------------------------
    * 로그인 조건 미완료시 경고 메시지 띄우기
    * --------------------------------- */
    warningMessage(message){
        console.log(message);
        messageSpan.style.display='inline';
        messageSpan.textContent = message;
    }

    /* ---------------------------------
    *        인풋박스 빈칸 채크
    * --------------------------------- */
    checkInput(){
        if(account.value === '' || password.value === ''){
            return false;
        }
        return true;
    }

    /* ---------------------------------
    *      로그인 검사, 로그인 요청
    * --------------------------------- */
    init(){
        form.addEventListener('submit', (e)=>{
            e.preventDefault();

            if(this.checkInput() === false){
                return this.warningMessage('아이디나 비밀번호를 입력하지 않았습니다 🤔');
            }

            asyncPostLogin({
                'account':account.value,
                'password':password.value
            }).then((res)=>{
                if(res === 0)
                    this.warningMessage('존재하지 않는 아이디 입니다 😕');
                if(res === -1)
                    this.warningMessage('비밀번호가 일치하지 않습니다 😕');
                if(res === 1)
                    location.href="/";
            });
        });
    }
}