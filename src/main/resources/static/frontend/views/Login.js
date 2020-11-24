import Template from './Template.js';

export class Login extends Template {
    constructor(){
        super();
        this.setTitle("스터디북 - 로그인");
    }

    async getHtml(){
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
				<a href="/register" class="form-info-text">비밀번호를 잊으셨나요?</a>
			</span>
			<br>
			<hr>
			<br>
			<span>
				계정이 없으신가요? 먼저 
				<a data-href="/register" class="form-info-text">회원가입</a>을 진행하세요.
			</span><br>
		</form>
        `;
    }
} 