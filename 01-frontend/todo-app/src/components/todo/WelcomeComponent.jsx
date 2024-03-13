import {useParams, Link} from 'react-router-dom'
import { useState } from 'react'
import {retrieveHelloWorldPathVariabble} from './api/HelloWorldApiService'

function WelcomeComponent(){

    const {username} = useParams()

    const [message, setMessage] = useState(null)

    function callHelloWorldRestApi(){
        retrieveHelloWorldPathVariabble(username)
        .then((response)=>successfulResponse(response))
        .catch((error)=> errorResponse(error))
    }

    function successfulResponse(response){
        setMessage(response.data.message)
    }

    function errorResponse(error){
        console.log(error)
    }

    return( 
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Manage Your todos <Link to='/todos'>Go here</Link>
            </div>
            <div>
                <button className='btn btn-success m-5' onClick={callHelloWorldRestApi}
                >Call Hello World Rest API</button>
            </div>
            <div className='text-info'>{message}</div>
        </div>
    )
}

export default WelcomeComponent