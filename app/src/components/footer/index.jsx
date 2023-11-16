import React from 'react'
import { CopyToClipboard } from 'react-copy-to-clipboard';

// Redux
import { useDispatch } from 'react-redux'
import { showToast } from '../../redux/reducers/components/overlays/toast'

// Primefaces
import { Button } from 'primereact/button';

// Resources

export default function Footer() {

    // Redux
    const dispatch = useDispatch()

    return (
        <div className='flex flex-wrap justify-content-center card-container gap-3'>
            <CopyToClipboard text="michel.pech@outlook.com.br" onCopy={() => dispatch(showToast({ severity: 'info', summary: 'E-mail copied!' }))}>
                <Button
                    tooltip='E-Mail'
                    tooltipOptions={{ position: 'top' }}
                    icon="pi pi-envelope"
                    rounded outlined />
            </CopyToClipboard>
            <a target='_blank' href='https://api.whatsapp.com/send?phone=5551989249247' style={{ textDecoration: 'none' }}>
                <Button
                    tooltip='WhatsApp'
                    tooltipOptions={{ position: 'top' }}
                    icon="pi pi-whatsapp"
                    severity="success"
                    rounded outlined />
            </a>
            <a target='_blank' href='https://github.com/devStraub' style={{ textDecoration: 'none' }}>
                <Button
                    tooltip='GitHub'
                    tooltipOptions={{ position: 'top' }}
                    icon="pi pi-github"
                    severity="secondary"
                    rounded outlined />
            </a>
            <a target='_blank' href='https://www.linkedin.com/in/michel-henrique-straub-pech-ba2a0b75/' style={{ textDecoration: 'none' }}>
                <Button
                    tooltip='LinkedIn'
                    tooltipOptions={{ position: 'top' }}
                    icon="pi pi-linkedin"
                    severity="info"
                    rounded outlined />
            </a>
        </div>
    )
}