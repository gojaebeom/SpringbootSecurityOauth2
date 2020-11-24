import Template from '../Template.js';

export class WorkList extends Template {
    constructor(){
        super();
        this.setTitle("스터디북 - 작업물");
    }

    async render(){
        return `
        <h1>hello</h1>
        <p>
            전시회
        </p>
        `
    }
} 