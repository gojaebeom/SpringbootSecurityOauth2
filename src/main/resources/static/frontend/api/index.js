const URL = 'http://localhost:8080';

/* ---------------------------------
*        계정 중복 확인 요청
* --------------------------------- */
export const asyncUsernameCheck = async (username) => {
    console.log(username);
    return await fetch(`${URL}/join/username-check`,{
        method:'POST', 
        body:username,
        headers:{
            'Content-Type': 'application/json',
        }}).then(res=>res.json());
}

/* ---------------------------------
*           회원가입 요청
* --------------------------------- */
export const asyncJoin = async (user) => {
    return await fetch(`${URL}/join`,{
        method:'POST', 
        body:JSON.stringify(user),
        headers:{
        'Content-Type': 'application/json'
        }}).then(res=>res.json());
}


/* ---------------------------------
*           로그인 요청
* --------------------------------- */
export const asyncLogin = async (user) => {
    console.log(user);
    return await fetch(`${URL}/login`,{
        method:'POST', 
        body:JSON.stringify(user),
        headers:{
            'Content-Type': 'application/json',
        }}).then(res => res.text())
            .catch(err => console.log('요청 실패!'));
}

/* ---------------------------------
*       로그인 유저 정보 요청
* --------------------------------- */
export const asyncLoginUserInfo = async (token) => {
    console.log(token);
    return await fetch(`${URL}/user`,{
        method:'GET', 
        headers:{
            'Content-Type': 'application/json',
            'Authorization': token
        }}).then(res => res.text())
            
}

/* ---------------------------------
*       로그아웃 요청
* --------------------------------- */
export const asyncLogout = async (token) => {
    console.log(token);
    return await fetch(`${URL}/logout`,{
        method:'GET', 
        headers:{
            'Content-Type': 'application/json',
            'Authorization': token
        }}).then(res => res.text());
}