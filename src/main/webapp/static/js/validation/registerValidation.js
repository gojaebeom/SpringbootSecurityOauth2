import { asyncAccountCheck, asyncPostRegister } from '../asyncAPI/index.js';

const form = document.querySelector('.form');
const account = document.getElementById('account');
const password = document.getElementById('password');
const nickname = document.getElementById('nickname');
const email = document.getElementById('email');
const messageSpan = document.querySelector('.message-span');

export class RegisterValidation{
    constructor(){
        this.accountReg = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/; //계정 정규식
        this.passwordReg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; //비밀번호
        this.nicknameReg = /^[가-힣a-zA-Z0-9]+$/; //닉네임 정규식      
        this.emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/; //이메일 정규식
        this.init();
    }

    /* ---------------------------------
     * 로그인 조건 미완료시 경고 메시지 띄우기
     * --------------------------------- */
    warningMessage(message){
        console.log(message);
        messageSpan.style.display='inline';
        messageSpan.textContent = message;
        return false;
    }

    /* ---------------------------------
    *     계정 정규식 검사, 중복 검사
    * --------------------------------- */
    accountCheck(){
        if(account.value === ''){
            account.focus();
            account.style.border='1px solid #F78181';
            this.warningMessage('아이디가 입력되지 않았습니다 💡');
            return new Promise((resovle, reject) => {
                resovle(false);
            })
        }

        return asyncAccountCheck(account.value)
        .then((res) => {
            if(!this.accountReg.test(account.value)){
                account.focus();
                account.style.border='1px solid #F78181';
                return this.warningMessage('영문 대소문자 또는 숫자를 포함한 총 4-15자리를 입력해주세요 💡');
            }
            if(!res){
                account.focus();
                account.style.border='1px solid #F78181';
                this.warningMessage('중복된 아이디 입니다 💡');
                return false;
            }
            account.style.border='1px solid #04B45F';
            messageSpan.style.display='none';
            return true;
        });
    }

    /* ---------------------------------
    *     비밀번호 정규식 검사
    * --------------------------------- */
    passwordCheck(){
        if(password.value === ''){
            password.focus();
            password.style.border='1px solid #F78181';
            return this.warningMessage('비밀번호가 입력되지 않았습니다 💡');
        }
        if(!this.passwordReg.test(password.value)){
            password.focus();
            password.style.border='1px solid #F78181';
            return this.warningMessage('비밀번호는 최소 8글자 이상, 특수문자1개 이상을 포함해야 합니다 💡');
        }
        password.style.border='1px solid #04B45F';
        messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *     이름 정규식 검사
    * --------------------------------- */
    nicknameCheck(){
        if(nickname.value === ''){
            nickname.focus();
            nickname.style.border='1px solid #F78181';
            return this.warningMessage('닉네임이 입력되지 않았습니다 💡');
        }
        if(!this.nicknameReg.test(nickname.value)){
            nickname.focus();
            nickname.style.border='1px solid #F78181';
            return this.warningMessage('닉네임은 특수문자를 제외한 한글, 또는 영문을 입력해주세요 💡');
        }
        nickname.style.border='1px solid #04B45F';
        messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *     이름 정규식 검사
    * --------------------------------- */
    emailCheck(){
        if(email.value === ''){
            email.focus();
            email.style.border='1px solid #F78181';
            return this.warningMessage('이메일이 입력되지 않았습니다. 💡');
        }
        if(!this.emailReg.test(email.value)){
            email.focus();
            email.style.border='1px solid #F78181';
            return this.warningMessage('이메일의 형식이 올바르지 않습니다 💡');
        }
        email.style.border='1px solid #04B45F';
        messageSpan.style.display='none';
        return true;
    }

    /* ---------------------------------
    *   모든 검사를 완료하고 form data 전송
    * --------------------------------- */
    init(){
        account.onblur = () => this.accountCheck();
        password.onblur = () => this.passwordCheck();
        nickname.onblur = () => this.nicknameCheck();
        email.onblur = () => this.emailCheck();

        form.addEventListener('submit', (e)=> {
            e.preventDefault(); 

            this.accountCheck().then((result)=> {
                if(!result)
                    return false; 
                if(!this.passwordCheck())
                    return false;
                if(!this.nicknameCheck())
                    return false;
                if(!this.emailCheck())
                    return false;

                asyncPostRegister({
                    'account' : account.value,
                    'password' : password.value,
                    'nickname' : nickname.value,
                    'email' : email.value
                }).then((res)=>{
                    if(res){
                        let result = confirm('회원가입이 완료되었습니다 😊 \n바로 로그인 하시겠습니까?');
                        if(result)
                            location.href='/login';
                        else
                            location.href='/';
                    }     
                });
            });
        });
    }
}