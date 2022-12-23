import axios from 'axios';
import React, { useEffect,useState } from 'react'
import { useLocalStorage } from '../util/useLocalStorage';

const Dashboard = (props) => {
  const [jwt,setJwt]= useLocalStorage("","jwt");
  const [assignments,setAssignments] = useState(null);

  const auth = `Bearer ${jwt}`;
  //const auth = jwt;

  useEffect(()=>{
    axios("http://localhost:8080/api/assignments")
    .then(response=>{
      setAssignments(response.data);
    })
    .catch(error => console.log(error));
  },[]);
  
  const createAssignment=()=>{
    console.log('Jwt is',auth);
    axios.post("http://localhost:8080/api/assignments",{
      headers:{
        Authorization: auth
      }
    })
    .then((response)=>{
      console.log(response.data);
    })
    .catch((error)=>{
      console.log("error is",error);
    });
  };
  return (
    <div>
      Assignment Id: 
    <button onClick={()=>createAssignment()}>Submit New Assignment</button>
    <div>This is {props.pass}</div>
    </div>
  )
}

export default Dashboard