import React from 'react'

// Redux
import { useDispatch } from 'react-redux'
import { setPage } from '../../redux/reducers/components/pages';

// Primefaces
import { Button } from 'primereact/button';

// Icons
import { DiCode } from "react-icons/di";

// Components
import ProjectList from '../pages/projects/list';

export default function Header() {

    const dispatch = useDispatch()

    return (
        <>
            <div className='header-left'>

            </div>
            <div className='header-center'>
                <Button rounded text onClick={() => dispatch(setPage(<ProjectList/>))}>
                    <div style={{ display: 'flex', alignItems: 'center' }}>
                        <DiCode style={{ fontSize: '30px' }} />
                        <strong>CodeGroup</strong>
                    </div>
                </Button>
            </div>
            <div className='header-right' style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>

            </div>
        </>
    )
}