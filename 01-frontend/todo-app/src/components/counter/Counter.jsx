import { useState } from 'react';
import './Counter.css';

import CounterButton from './CountButton'

export default function Counter(){

    const [count, setCount] = useState(0)

    function incrementCounterParentFunction(by){
        setCount(count+by)
    }

    function decrementCounterParentFunction(by){
        setCount(count-by)
    }

    function resetCounter(){
        setCount(0)
    }

    return (
    <div>
        <span className="totalCount">{count}</span>
      <CounterButton 
        incrementMethod ={incrementCounterParentFunction} 
        decrementMethod = {decrementCounterParentFunction}/>
      <CounterButton by={2}
        incrementMethod ={incrementCounterParentFunction}
        decrementMethod = {decrementCounterParentFunction}/>
      <CounterButton by={5}
        incrementMethod ={incrementCounterParentFunction}
        decrementMethod = {decrementCounterParentFunction}/>
        <button className='counterButton' onClick={resetCounter}>Reset</button>
    </div>
    )
}

