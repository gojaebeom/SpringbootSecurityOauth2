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

const homeActive = () => {
   homeSpan.style.color = '#0174DF';
   homeIcon.style.color = '#0174DF';
   homeIcon.style.fontSize = '27px';

}
const workActive = () => {
   workSpan.style.color = '#0174DF';
   workIcon.style.color = '#0174DF';
   workIcon.style.fontSize = '27px';
} 
const tagActive = () => {
   tagSpan.style.color = '#0174DF';
   tagIcon.style.color = '#0174DF';
   tagIcon.style.fontSize = '27px';
}
const loginActive = () => {
   loginSpan.style.color = '#0174DF';
   loginIcon.style.color = '#0174DF';
   loginIcon.style.fontSize = '27px';
}
const profileActive = () => {
   loggedInSpan.style.color = '#0174DF';
}

const clickMenuEffect = (pathname) => {
	console.log(pathname);
   
   switch(pathname){
      case '/': homeActive();
         break;
      case '/works': workActive();
         break;
      case '/tags': tagActive();
         break;
      case '/login': loginActive();
         break;
      case '/register': loginActive();
         break;
      case '/profile': profileActive();
         break;
      default : return false;
   }
}
document.addEventListener("DOMContentLoaded", () => {
   clickMenuEffect(location.pathname);
});