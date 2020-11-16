const form = document.querySelector('.form');
const account = document.getElementById('account');
const password = document.getElementById('password');
const remember = document.getElementById('.remember');
const messageSpan = document.querySelector('.message-span');

export class LoginValidation{

    constructor(){
        console.log('로그인');
        /* ---------------------------------
        *   form submit 버튼 클릭 이벤트
        * --------------------------------- */
        form.addEventListener('submit', (e)=>{
            e.preventDefault();

            if(this.checkInput() === false){
                return this.warningMessage('아이디나 비밀번호를 입력하지 않았습니다🤔');
            }
        });
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
}