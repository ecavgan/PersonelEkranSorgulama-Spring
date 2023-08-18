import React, {useState, useEffect} from "react";
import ReactDOM from "react-dom";

function Personel() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [personelList, setPersonelList] = useState([]);

    useEffect(() => {
        fetch("/personels")
        .then(res => res.json())
        .then(
            (result) => {
                setIsLoaded(true);
                setPersonelList(result);
            },
            (error) => {
                setIsLoaded(true);
                setError(true);
            }
        )
    }, [])

    if(error) {
        return <div>Error</div>
    }
    else if(!isLoaded) {
        return <div>Loading</div>
    }
    else{
        return(
            <ul>
                {personelList.map(personel => (
                    <li>
                        {personel.id}
                        {personel.firstName}
                        {personel.lastName}
                        {personel.address}
                        {personel.age}
                    </li>
                ))}
            </ul>
        )
    }
}

export default Personel;