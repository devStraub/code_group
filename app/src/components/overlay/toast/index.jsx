import React from 'react'

//Redux
import { useSelector } from 'react-redux'

// Primefaces
import { Toast } from 'primereact/toast';

export default function Toasts(){

    const toast = React.useRef(null)
    const showToast = useSelector(state => state.toastView.value)

    React.useEffect(() => {
        if (showToast){
            toast.current.show(showToast);
        }        
    }, [showToast])

    return(
        <Toast ref={toast}/>
    )
}