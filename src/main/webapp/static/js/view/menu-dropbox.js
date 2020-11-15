/* ---------------------------------
 *        매뉴 드롭박스 토글
 * --------------------------------- */
const profileBox = document.querySelector('.menu-profile-wrap');
const dropbox = document.querySelector('.menu-profile-dropbox');
const loginImg = document.querySelector('.login-img');
const loginTextWrap = document.querySelector('.login-text-wrap');



document.addEventListener("DOMContentLoaded", () => {
	
	if(profileBox !== null){
		
		profileBox.onclick = () => {
			//console.log('프로필 박스 클릭!');
			dropbox.style.display=(dropbox.style.display==='block')?'none':'block'; 
		};

		document.body.addEventListener('click', e =>{
			if(e.target == profileBox || 
			   e.target == loginImg ||
			   e.target == loginTextWrap){
			}else{
				console.log(dropbox);
				if(dropbox.style.display === 'block'){
					dropbox.style.display='none';
				}
			}
		});
	}
	
	
});


