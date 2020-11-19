import Template from '../Template.js';

export class PostCreate extends Template {
    constructor(){
        super();
        this.setTitle("스터디북 - 게시글 작성");
    }

    async getHtml(){
        return `
        <form id="post-form" class="form post-form">
            <input id="userId" name="userId" type="hidden" value="${sessionScope.login.id}">
            <div class="post-form-header">
                <h1>게시물 작성</h1>
            </div>
            <div class="form-input-wrap">
                <label for="title">제목</label>
                <input id="title" name="title">
            </div>
            <div class="form-input-wrap">
                <label for="content">내용</label>
                <textarea id="editor" name="content"></textarea>
            </div>
            
            <button type="submit">생성</button>
        </form>
        `;
    }
} 