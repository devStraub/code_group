import React from 'react'

//Redux
import { useSelector, useDispatch } from 'react-redux'
import { closeModal } from '../../../../redux/reducers/components/overlays/dialog/modal'

// Primefaces
import { Dialog } from 'primereact/dialog';


export default function Modal() {

    const visible = useSelector(state => state.modalView.visible)
    const header = useSelector(state => state.modalView.header)
    const content = useSelector(state => state.modalView.content)
    const dispatch = useDispatch()

    return (
        <Dialog header={header} visible={visible} style={{ width: '50vw' }} onHide={() => dispatch(closeModal())}>
            {content}
        </Dialog>
    )
}