/* ---------------------------------
 *  상단 매뉴 네비게이션 url에 따른 클릭 이벤트
 * --------------------------------- */
const homeSpan = document.querySelector('.home-span');
const workSpan = document.querySelector('.work-span');
const tagSpan = document.querySelector('.tag-span');
const loginSpan = document.querySelector('.login-span');
const loggedInSpan = document.querySelector('.logged-in-span');

const homeIcon = document.querySelector('.home-icon');
const workIcon = document.querySelector('.work-icon');
const tagIcon = document.querySelector('.tag-icon');
const loginIcon = document.querySelector('.login-icon');

export const homeActive = () => {
   homeSpan.style.color = '#1877f2';
   homeIcon.style.color = '#1877f2';
   homeIcon.style.fontSize = '27px';
}
export const workActive = () => {
   workSpan.style.color = '#1877f2';
   workIcon.style.color = '#1877f2';
   workIcon.style.fontSize = '27px';
} 
export const tagActive = () => {
   tagSpan.style.color = '#1877f2';
   tagIcon.style.color = '#1877f2';
   tagIcon.style.fontSize = '27px';
}
export const loginActive = () => {
   if(loginSpan !== null && loginIcon !== null){
      loginSpan.style.color = '#1877f2';
      loginIcon.style.color = '#1877f2';
      loginIcon.style.fontSize = '27px';
   }
}
export const profileActive = () => {
   loggedInSpan.style.color = '#1877f2';
}