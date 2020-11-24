import Template from './Template.js';

export class Home extends Template {
    constructor(){
        super();
        this.setTitle("스터디북");
    }

    async render(){
        return `
        <h1>hello</h1>
        <p>
            this is content!
        </p>
        `
    }
} 