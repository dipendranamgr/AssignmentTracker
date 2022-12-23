import React from 'react'
import { Navigate } from 'react-router-dom';
import { useLocalStorage } from '../../util/useLocalStorage'

const PrivateRoute = ({children}) => {
    const [jwt,setJwt] = useLocalStorage("","jwt");

        return jwt ? children : <Navigate to="/login"/>;
//   return (
//     <div>PrivateRoute</div>
//   )
}

export default PrivateRoute