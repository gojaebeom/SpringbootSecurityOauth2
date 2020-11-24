export default class {
    constructor( ){ }
    
    //Head의 title 값을 바꿀 때 사용
    setTitle(title){ document.title = title; }

    //DOM에 접근하고자 할 때 사용할 메서드 : getHtml 메서드가 호출된 이후에 호출된다.
    domIsCreated() { }

    //화면을 그리는 메서드
    async render(){ return 'DOM'; }
}