import { asyncPost } from '../asyncAPI/index.js';

const postForm = document.getElementById('post-form');

export class PostValidation{
    constructor(){
        postForm.addEventListener('submit', e => {
            e.preventDefault();
            console.log(postForm.title);
            console.log(postForm.content);
            console.log(postForm.content.value);   

            asyncPost({
                'userId' : postForm.userId.value,
                'title' : postForm.title.value,
                'content' : postForm.content.value
            }).then((res)=>{
                if(!res)
                    return false;
                
                location.href = "/";
            })
        })
    }
}