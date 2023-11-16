import React from 'react'

//Redux
import { useSelector, useDispatch } from 'react-redux'
import { closeConfirmDialog, acceptConfirmDialog } from '../../../../redux/reducers/components/overlays/dialog/confirm'

// Primefaces
import { ConfirmDialog } from 'primereact/confirmdialog';
import { Toast } from 'primereact/toast';

export default function DialogConfirm(){

    const toast = React.useRef(null);

    const visible = useSelector(state => state.dialogConfirmView.visible)
    const header = useSelector(state => state.dialogConfirmView.header)
    const message = useSelector(state => state.dialogConfirmView.message)
    const dispatch = useDispatch()           

    const accept = () => {
        dispatch(acceptConfirmDialog())
        toast.current.show({ severity: 'info', summary: 'Confirmado', detail: '', life: 3000 });
    }

    const reject = () => {
        toast.current.show({ severity: 'warn', summary: 'Abortado', detail: '', life: 3000 });
    }    

    return(
        <>
            <Toast ref={toast} />
            <ConfirmDialog 
                visible={visible} 
                onHide={() => dispatch(closeConfirmDialog())} 
                closable={false}
                message={message}
                header={header}
                accept={accept} 
                reject={reject}
                acceptLabel='Sim'
                rejectLabel='Não' />     
        </>
    )
}