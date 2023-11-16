import React from 'react'

// Router
import { useNavigate } from 'react-router-dom';

// Redux
import { useDispatch, useSelector } from 'react-redux'
import { setEdit, setNew } from '../../../../redux/reducers/components/pages/edit'
import { setPage } from '../../../../redux/reducers/components/pages';

// Primefaces
import { Panel } from 'primereact/panel';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';

// Bootstrap
import {
    Container,
    Row,
} from 'react-bootstrap';

// Service
import projectService from '../../../../api/services/projectService';

// Module
import ProjectEdit from '../edit'

// Others
import moment from 'moment';

export default function List() {

    // Service
    const service = projectService();

    // Router
    const navigate = useNavigate();

    // Redux
    const navigationMode = useSelector(state => state.ConfigController.navigationMode)
    const dispatch = useDispatch()

    // Module States
    const [items, setItems] = React.useState([])

    React.useEffect(() => {
        loadList();
    }, [])

    // API 
    async function loadList() {
        try {
            setItems(await service.getAll());
        } catch (error) {
            console.error('Erro:', error);
        }
    }

    async function removeItem(data) {
        try {
            await service.remove(data)
        } catch (error) {
            console.error('Erro:', error);
        }

        loadList();
    }

    // Functions
    function goNewItem() {
        dispatch(setNew());
        redirectToEdit();
    }

    function goEditItem(rowData) {
        dispatch(setEdit(rowData))
        redirectToEdit();        
    }

    function redirectToEdit(){
        if (navigationMode === 'monopage'){
            dispatch(setPage(<ProjectEdit />))
        }
        else {
            navigate('/project/edit')
        }
    }

    // Module Components

    const moduleHeader = (options) => {
        const className = `${options.className} justify-content-space-between`;
        const style = { fontSize: '1.25rem' };

        return (
            <div className={className}>
                <span style={style}>Projetos</span>
            </div>
        )
    }

    const listPanelTemplate = (options) => {
        const className = `${options.className} justify-content-space-between`;
        const titleClassName = `${options.titleClassName} ml-2 text-secondary`;
        const style = { fontSize: '1rem' };

        return (
            <div className={className}>
                <span className={titleClassName} style={style}>Lista de Projetos</span>

                <Button
                    type="button"
                    severity='info'
                    rounded text
                    icon="pi pi-plus"
                    tooltip="Novo"
                    tooltipOptions={{ position: 'top' }}
                    onClick={(e) => {
                        goNewItem()
                    }}
                />
            </div>
        );
    };

    const listActions = (data) => {
        return (
            <>
                <Button
                    type="button"
                    severity='info'
                    rounded text
                    icon="pi pi-pencil"
                    tooltip="Editar"
                    tooltipOptions={{ position: 'bottom' }}
                    onClick={(e) => {
                        goEditItem(data)
                    }}
                />
                <Button
                    type="button"
                    severity='danger'
                    rounded text
                    icon="pi pi-trash"
                    tooltip="Remover"
                    tooltipOptions={{ position: 'bottom' }}
                    onClick={(e) => {
                        removeItem(data)
                    }}
                />
            </>
        )
    }

    const dateFormat = (rowData) => {
        return moment(rowData.data).add(3, 'h').format('DD/MM/YYYY')
    }

    // Module Render

    return (
        <Panel
            headerTemplate={moduleHeader}
            style={{
                width: '95vw',
            }}
        >
            <Container className='flex flex-column gap-4'>
                <Row>
                    <Panel
                        headerTemplate={listPanelTemplate}
                    >
                        <DataTable
                            value={items}
                            size='small'
                            showGridlines
                            stripedRows
                            paginator
                            rows={10}
                            emptyMessage="Nenhum projeto cadastrado"
                            sortField="id" 
                            sortOrder={1}>
                            <Column
                                header="Código"
                                field='id'
                                align={'center'} />
                            <Column
                                header="Nome"
                                field="nome"
                                align={'center'} />
                            <Column
                                header="Início"
                                field="dataIncio"
                                body={dateFormat}
                                align={'center'} />
                            <Column
                                header="Previsão"
                                field="dataPrevisaoFim"
                                body={dateFormat}
                                align={'center'} />
                            <Column
                                header="Fim"
                                field="dataFim"
                                body={dateFormat}
                                align={'center'} />
                            <Column
                                header="Status"
                                field="status"
                                align={'center'} />
                            <Column
                                header="Orçamento"
                                field="orcamento"
                                align={'center'} />
                            <Column
                                header="Risco"
                                field="risco"
                                align={'center'} />
                            <Column
                                header="Gerente"
                                field="gerente.nome"
                                align={'center'} />
                            <Column
                                style={{ width: '10rem' }}
                                align={'center'}
                                header="Ações"
                                body={listActions} />
                        </DataTable>
                    </Panel>
                </Row>
            </Container>
        </Panel>
    )
}