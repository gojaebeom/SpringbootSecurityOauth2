import Template from './Template.js';
import { asyncLogin } from '../api/index.js';

export class Login extends Template {
    constructor(){
        super();
		this.setTitle("스터디북 - 로그인");
	}
	
	domIsCreated(){
		this.form = document.querySelector('#login-form');
        this.username = this.form.username;
        this.password = this.form.password;
        this.remember = this.form.remember;
		this.messageSpan = document.querySelector('.message-span');
		console.log(this.form);

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

    async render(){
        return `
        <form id="login-form" class="form">
			<div class="form-input-wrap">
				<label for="username">아이디</label>
				<input id="username" name="username">
			</div>
			<div class="form-input-wrap">
				<label for="password">비밀번호</label>
				<input id="password" name="password" type="password">
			</div>
			<div class="form-checkbox-wrap">
				<input id="remember" name="remember" type="checkbox">
				<label for="remember">아이디 기억하기</label>
			</div>
			<span class="message-span"></span>
			<button type="submit">로그인</button>
			<br>
			<span>
				<a data-href="/join" class="form-info-text">비밀번호를 잊으셨나요?</a>
			</span>
			<br>
			<hr>
			<br>
			<span>
				계정이 없으신가요? 먼저 
				<a data-href="/join" class="form-info-text">회원가입</a>을 진행하세요.
			</span><br>
		</form>`;
    }
} 