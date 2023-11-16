import React from 'react'

//Redux
import { useSelector } from 'react-redux'

// CSS
import './page.css'

// Primefaces

// Components
import Header from '../header'
import Footer from '../footer'

// Routes
import { RouteList } from '../../routes';
import Overlay from '../overlay';

export default function Pages() {

    const page = useSelector(state => state.pageView.value)
    const navigationMode = useSelector(state => state.ConfigController.navigationMode)

    return (
        <>
            <header style={{ backgroundColor: 'var(--surface-0)' }}>
                <Header />
            </header>
            <main style={{ backgroundColor: 'var(--bluegray-100)' }}>
                <div style={{ paddingTop: '7rem', paddingBottom: '7rem' }}>
                    {navigationMode === 'monopage'
                        ?
                        page
                        :
                        <RouteList />
                    }
                </div>
            </main>
            <footer style={{ backgroundColor: 'var(--surface-0)' }}>
                <Footer />
            </footer>
            <Overlay />
        </>
    )
}