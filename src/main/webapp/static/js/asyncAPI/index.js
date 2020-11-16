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