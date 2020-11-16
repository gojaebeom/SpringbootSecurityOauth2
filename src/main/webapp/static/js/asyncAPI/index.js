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
*  회원가입 데이터 보내기
* --------------------------------- */
export const asyncPostRegister = (user) => {
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