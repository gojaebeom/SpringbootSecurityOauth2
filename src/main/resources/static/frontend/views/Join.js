import Template from './Template.js';

export class Join extends Template {
    constructor(){
        super();
        this.setTitle("스터디북 - 회원가입");
    }

    domIsCreated(){
         //Properties
         this.form = document.querySelector('#Join-form');
         this.messageSpan = document.querySelector('.message-span');
         this.username = this.form.username;
         this.password = this.form.password;
         this.nickname = this.form.nickname;
         this.email = this.form.email;
         //ExpReg
         this.usernameReg = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/; //계정 정규식
         this.passwordReg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; //비밀번호
         this.nicknameReg = /^[가-힣a-zA-Z0-9]+$/; //닉네임 정규식      
         this.emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/; //이메일 정규식
         //실행 함수
         this.init();
    }

    /* ---------------------------------
     * 로그인 조건 미완료시 경고 메시지 띄우기
     * --------------------------------- */
    warningMessage(message){
        console.log(message);
        this.messageSpan.style.display='inline';
        this.messageSpan.textContent = message;
        return false;
    }

    /* ---------------------------------
    *     계정 정규식 검사, 중복 검사
    * --------------------------------- */
    async usernameCheck(){
        if(this.username.value === ''){
            this.username.focus();
            this.username.style.border='1px solid #F78181';
            this.warningMessage('아이디가 입력되지 않았습니다 💡');
            return false;
        }

        let result = await asyncUsernameCheck(username.value);

        if(!this.usernameReg.test(this.username.value)){
            this.username.focus();
            this.username.style.border='1px solid #F78181';
            return this.warningMessage('영문 대소문자 또는 숫자를 포함한 총 4-15자리를 입력해주세요 💡');
        }
        if(!result){
            this.username.focus();
            this.username.style.border='1px solid #F78181';
            this.warningMessage('중복된 아이디 입니다 💡');
            return false;
        }

        this.username.style.border='1px solid #04B45F';
        this.messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *     비밀번호 정규식 검사
    * --------------------------------- */
    passwordCheck(){
        if(this.password.value === ''){
            this.password.focus();
            this.password.style.border='1px solid #F78181';
            return this.warningMessage('비밀번호가 입력되지 않았습니다 💡');
        }
        if(!this.passwordReg.test(this.password.value)){
            this.password.focus();
            this.password.style.border='1px solid #F78181';
            return this.warningMessage('비밀번호는 최소 8글자 이상, 특수문자1개 이상을 포함해야 합니다 💡');
        }
        this.password.style.border='1px solid #04B45F';
        this.messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *     이름 정규식 검사
    * --------------------------------- */
    nicknameCheck(){
        if(nickname.value === ''){
            this.nickname.focus();
            this.nickname.style.border='1px solid #F78181';
            return this.warningMessage('닉네임이 입력되지 않았습니다 💡');
        }
        if(!this.nicknameReg.test(nickname.value)){
            this.nickname.focus();
            this.nickname.style.border='1px solid #F78181';
            return this.warningMessage('닉네임은 특수문자를 제외한 한글, 또는 영문을 입력해주세요 💡');
        }
        this.nickname.style.border='1px solid #04B45F';
        this.messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *     이메일 정규식 검사
    * --------------------------------- */
    emailCheck(){
        if(this.email.value === ''){
            this.email.focus();
            this.email.style.border='1px solid #F78181';
            return this.warningMessage('이메일이 입력되지 않았습니다. 💡');
        }
        if(!this.emailReg.test(email.value)){
            this.email.focus();
            this.email.style.border='1px solid #F78181';
            return this.warningMessage('이메일의 형식이 올바르지 않습니다 💡');
        }
        this.email.style.border='1px solid #04B45F';
        this.messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *   모든 검사를 완료하고 form data 전송
    * --------------------------------- */
    init(){
        this.username.onblur = () => this.usernameCheck();
        this.password.onblur = () => this.passwordCheck();
        this.nickname.onblur = () => this.nicknameCheck();
        this.email.onblur = () => this.emailCheck();

        this.form.addEventListener('submit', async (e)=> {
            e.preventDefault(); 
            if(!await this.usernameCheck())
                return false; 
            if(!this.passwordCheck())
                return false;
            if(!this.nicknameCheck())
                return false;
            if(!this.emailCheck())
                return false;

            let res = await asyncJoin({
                'username' : this.username.value,
                'password' : this.password.value,
                'nickname' : this.nickname.value,
                'email' : this.email.value
            });

            if(res){
                let result = confirm('회원가입이 완료되었습니다 😊 \n바로 로그인 하시겠습니까?');
                if(result)
                    location.href='/login';
                else
                    location.href='/';
            }
        });
    }

    async render(){
        return `
        <form id="Join-form" class="form">
            <div class="form-input-wrap">
                <label for="username">아이디</label>
                <input id="username" name="username" placeholder="영문 대소문자 또는 숫자를 포함한 총 4-15자리 입력">
            </div>
            <div class="form-input-wrap">
                <label for="password">비밀번호</label>
                <input id="password" name="password" type="password" placeholder="최소 8글자 이상, 특수문자1개 이상을 포함">
            </div>
            <div class="form-input-wrap">
                <label for="nickname">닉네임</label>
                <input id="nickname" name="nickname" placeholder="이름 또는 닉네임을 입력해주세요">
            </div>
            <div class="form-input-wrap">
                <label for="email">이메일</label>
                <input id="email" name="email" placeholder="시용가능한 email을 입력해주세요">
            </div>
            <br>
            <span class="message-span"></span>
            <button type="submit">회원가입</button>
            <br>
            <span>
                이미 계정을 가지고 계신가요? 바로 <a data-href="/login" data-link class="form-info-text">로그인</a> 하세요.
            </span>
        </form>
        `;
    }
} 