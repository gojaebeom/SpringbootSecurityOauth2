/* ---------------------------------
*  계정 중복 확인 요청
* --------------------------------- */
export const asyncAccountCheck = (account) => {
    return new Promise((resolve, reject)=>{
        try{
            let result = fetch('/register/accountCheck',{
                method:'POST', 
                body:account,
                headers:{
                'Content-Type': 'application/json'
                }}).then(res=>res.json());
            resolve(result);
        }catch(e){
            console.error(e);
        }
    });
}

/* ---------------------------------
*           회원가입 요청
* --------------------------------- */
export const asyncRegister = (user) => {
    console.log(user);
    return new Promise((resolve, reject) => {
        try{
            let result = fetch('/register',{
                method:'POST', 
                body:JSON.stringify(user),
                headers:{
                'Content-Type': 'application/json'
                }}).then(res=>res.json());
            resolve(result);
        }catch(e){
            console.error(e);
        }
    });
}

/* ---------------------------------
*            로그인 요청
* --------------------------------- */
export const asyncLogin = (user) => {
    return new Promise((resolve, reject) => {
        try{
            let result = fetch('/login',{
                method:'POST', 
                body:JSON.stringify(user),
                headers:{
                'Content-Type': 'application/json'
                }}).then(res=>res.json());
            resolve(result);
        }catch(e){
            console.error(e);
        }
    });
}

/* ---------------------------------
*          게시물 리스트 요청
* --------------------------------- */
export const asyncPostIndex = () => {
    return new Promise((resolve, reject) => {
        try{
            let result = fetch('/posts',{
                method:'GET', 
                headers:{
                'Content-Type': 'application/json'
                }}).then(res=>res.json());
            resolve(result);
        }catch(e){
            console.error(e);
        }
    });
}

/* ---------------------------------
*          게시물 생성 요청
* --------------------------------- */
export const asyncPost = (post) => {
    console.log(post);
    return new Promise((resolve, reject) => {
        try{
            let result = fetch('/posts',{
                method:'POST', 
                body:JSON.stringify(post),
                headers:{
                'Content-Type': 'application/json'
                }}).then(res=>res.json());
            resolve(result);
        }catch(e){
            console.error(e);
        }
    });
}