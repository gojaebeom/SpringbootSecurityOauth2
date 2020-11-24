import Template from '../Template.js';

export class UserDetail extends Template {
    constructor(){
        super();
        this.setTitle("스터디북 - 프로필");
    }

    async render(){
        return `
        <h1>hello</h1>
        <p>
            1 번 유저 
        </p>
        `
    }
} 