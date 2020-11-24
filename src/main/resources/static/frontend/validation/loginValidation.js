import { asyncLogin } from '../api/index.js';

export class LoginValidation{
    constructor(){
        this.form = document.querySelector('#login-form');
        this.username = this.form.username;
        this.password = this.form.password;
        this.remember = this.form.remember;
        this.messageSpan = document.querySelector('.message-span');

        this.init();
    }

    /* ---------------------------------
    * 로그인 조건 미완료시 경고 메시지 띄우기
    * --------------------------------- */
    warningMessage(message){
        console.log(message);
        this.messageSpan.style.display='inline';
        this.messageSpan.textContent = message;
    }

    /* ---------------------------------
    *        인풋박스 빈칸 채크
    * --------------------------------- */
    checkInput(){
        if(this.username.value === '' || this.password.value === ''){
            return false;
        }
        return true;
    }

    /* ---------------------------------
    *      로그인 검사, 로그인 요청
    * --------------------------------- */
    init(){
        this.form.addEventListener('submit', async (e)=>{
            console.log('hello');
            e.preventDefault();

            if(this.checkInput() === false){
                return this.warningMessage('아이디나 비밀번호를 입력하지 않았습니다 🤔');
            }

            let response = await asyncLogin({
                'username':this.username.value,
                'password':this.password.value
            });

            let json = JSON.parse(response);
            localStorage.setItem("Authorization", json.token);

            location.href = "/";
        });
    }
}