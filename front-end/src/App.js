
import { Routes,Route } from 'react-router-dom';
import Dashboard from './pages/dashboard';
import Login from './pages/before/Login';
import PrivateRoute from './pages/after/PrivateRoute';

function App() {
  return (
    
    <Routes>
          <Route   path="/shipping" element={<PrivateRoute> <Dashboard /></PrivateRoute>}/>
        
      <Route path="/login" element={<Login/>} />
    </Routes>
    
  );
}

export default App;
