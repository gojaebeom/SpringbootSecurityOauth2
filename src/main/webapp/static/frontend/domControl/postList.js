import { asyncPostIndex } from '../asyncAPI/index.js';

const postCardWrap = document.getElementById('post-card-wrap');

export const postList = () => {
    asyncPostIndex().then((data)=> {

        data.forEach( e => {
            postCardWrap.innerHTML += 
            `
            <div class="post-card" style="width:500px;height:500px;background:white;margin-bottom:20px;">
                <div class="post-card-title">
                    ${e.title}
                </div>
                <div class="post-card-content">
                    ${e.content}
                </div>
            </div>
            `;

            console.log(e);
        })
        
    });
}