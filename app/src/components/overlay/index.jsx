import React from 'react'

// Components
import Modal from './dialog/modal'
import DialogConfirm from './dialog/confirm'
import Toasts from './toast'

export default function Overlay(){

    return(
        <>  
            <Modal/>
            <DialogConfirm/>
            <Toasts/>
        </>
    )
}