import Template from '../Template.js';

export class TagList extends Template {
    constructor(){
        super();
        this.setTitle("스터디북 - 태그");
    }

    async getHtml(){
        return `
        <h1>hello</h1>
        <p>
            태그 리스트
        </p>
        `
    }
} 