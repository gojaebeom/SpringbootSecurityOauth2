import { asyncAccountCheck } from '../asyncAPI/index.js';

const form = document.querySelector('.form');
const account = document.getElementById('account');
const password = document.getElementById('password');
const remember = document.getElementById('.remember');
const messageSpan = document.querySelector('.message-span');

export class RegisterValidation{
    constructor(){
        this.accountReg = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;//계정 정규식
        this.passwordReg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; //비밀번호

        this.accountCheck();
        this.passwordCheck();

        /* ---------------------------------
        *   form submit 버튼 클릭 이벤트
        * --------------------------------- */
        form.addEventListener('submit', (e)=>{
            e.preventDefault();
        });
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
        account.addEventListener('blur', () => {

            if(account.value === ''){
                account.focus();
                account.style.border='1px solid #F78181';
                return this.warningMessage('아이디가 입력되지 않았습니다 💡');
            }

            if(!this.accountReg.test(account.value)){
                account.focus();
                account.style.border='1px solid #F78181';
                return this.warningMessage('영문 대소문자 또는 숫자를 포함한 총 4-15자리를 입력해주세요 💡');
            }

            asyncAccountCheck(account.value)
            .then((res) => {
                if(!res){
                    account.focus();
                    account.style.border='1px solid #F78181';
                    return this.warningMessage('중복된 아이디 입니다 💡');
                }
                account.style.border='1px solid #04B45F';
                messageSpan.style.display='none';
            });
        });
    }

    passwordCheck(){
        password.addEventListener('blur', () => {
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
        });
    }
}