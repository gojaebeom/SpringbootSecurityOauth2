const postFormBackground = document.getElementById('post-form-background');
const postForm = document.getElementById('post-form');
const openButton = document.getElementById('open-post-button');
const closeButton = document.getElementById('close-post-button');


/* ---------------------------------
 *       게시글 작성 폼 모달창
 * --------------------------------- */
export const postFormModal = () => {
	if(openButton !== null){
		openButton.onclick = () => {
			postFormBackground.style.display=(postFormBackground.style.display==='flex')?'none':'flex'; 
			postForm.style.display=(postForm.style.display==='flex')?'none':'flex'; 
		};

		document.body.addEventListener('click', e =>{
			if(e.target == postFormBackground || e.target == closeButton){
                postFormBackground.style.display='none';
                postForm.style.display='none';
			}
		});
	}
}


