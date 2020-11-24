const profileBox = document.querySelector('.menu-profile-wrap');
const dropbox = document.querySelector('.menu-profile-dropbox');
const loginImg = document.querySelector('.login-img');
const loginTextWrap = document.querySelector('.login-text-wrap');

/* ---------------------------------
 *        매뉴 드롭박스 토글
 * --------------------------------- */
export const dropboxToggle = () => {
	if(profileBox !== null){
		profileBox.onclick = () => {
			dropbox.style.display=(dropbox.style.display==='block')?'none':'block'; 
		};

		document.body.addEventListener('click', e =>{
			
			if(e.target == profileBox || 
				e.target == loginImg ||
				e.target == loginTextWrap){
			}else{
				if(dropbox.style.display === 'block'){
					dropbox.style.display='none';
				}
			}
		});
	}
}


