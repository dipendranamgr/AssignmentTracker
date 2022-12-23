import React, { useState } from 'react';
import axios from 'axios';
import {useLocalStorage} from './../../util/useLocalStorage';

const Login = () => {

    const [username,setUsername] = useState("");
    const [password,setPassword] = useState("");

    const [jwt,setJwt] = useLocalStorage("","jwt");
    
    
     const mogin=()=>{

      console.log("calling mogin");
      const user = {
        username: username,
        password: password
      };

      console.log(`username is ${username}`);


      axios.post("http://localhost:8080/api/auth/login",user)
        .then((response)=>{
          if(response.status === 200){
          console.log(`Jwt is : ${response.data.accessToken}`);
          setJwt(response.data.accessToken);
          window.location.href = "shipping";
          }
          else
           console.log("Invalid login attempt");
        })
        .catch((error)=>{
          console.log(error);
        }); 
    }
  return (
    <>
        <form>
            <div>
                <label htmlFor="username">Username</label>
                <input type="text" value={username} onChange={(e)=> setUsername(e.target.value)} />
            </div>
            <div>
                <label htmlFor="password">Password</label>
                <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)} />
            </div>
            <div>
                
                <input type="submit" value="Login" onClick={()=>mogin()} />
            </div>
        </form>
    </>

  )

}
export default Login;