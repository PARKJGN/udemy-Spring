import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import LogoutComponent from './LogoutComponent'
import FooterComponent from './FooterComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponent from './ListTodosComponent'
import WelcomeComponent from './WelcomeComponent'
import ErrorComponent from './ErrorComponent'
import LoginComponent from './LoginComponent'
import TodoComponent from './TodoComponent'
import AuthProvider from './security/AuthContext'
import { useAuth } from './security/AuthContext'
import './TodoApp.css'

function AuthenticatedRoute({children}){
    const authContext = useAuth()
    if(authContext.isAuthenticated)
        return(
            children
        )
    return <Navigate to="/"></Navigate>
}
export default function TodoApp(){

    return(
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                <HeaderComponent/>
                    <Routes>
                        <Route path='/' element={<LoginComponent/>}></Route>
                        <Route path='login' element={<LoginComponent/>}></Route>
                        <Route path='welcome/:username' element={
                        <AuthenticatedRoute>
                            <WelcomeComponent/>
                        </AuthenticatedRoute>
                        }/>
                        <Route path='todos' element={
                        <AuthenticatedRoute>
                            <ListTodosComponent/>
                        </AuthenticatedRoute>
                        }/>
                        <Route path='todo/:id' element={
                            <AuthenticatedRoute>
                                <TodoComponent/>
                            </AuthenticatedRoute>
                        }/>
                        <Route path='logout' element={
                        <AuthenticatedRoute>
                            <LogoutComponent/>
                        </AuthenticatedRoute>
                        }/>
                        <Route path='*' element={<ErrorComponent/>}></Route>
                    </Routes>
                    <FooterComponent/>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}













