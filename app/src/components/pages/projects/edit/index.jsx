import React from 'react'

// Router
import { useNavigate } from 'react-router-dom';

// Redux
import { useSelector, useDispatch } from 'react-redux'
import { setPage } from '../../../../redux/reducers/components/pages';
import { showWarning } from '../../../../redux/reducers/components/overlays/toast';
import { setEdit } from '../../../../redux/reducers/components/pages/edit'

// Primefaces
import { Panel } from 'primereact/panel';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { InputTextarea } from 'primereact/inputtextarea';
import { InputText } from 'primereact/inputtext';
import { Calendar } from 'primereact/calendar';
import { Dropdown } from 'primereact/dropdown';
import { TabView, TabPanel } from 'primereact/tabview';
import { InputNumber } from 'primereact/inputnumber';

// Bootstrap
import {
    Container,
    Row,
    Col,
} from 'react-bootstrap';

// Service
import ProjectService from '../../../../api/services/projectService';
import PessoaService from '../../../../api/services/pessoaService';
import MembroProjetoService from '../../../../api/services/membroProjetoService';

// Module
import ProjectList from '../list'

//Others
import { riscoList, statusList } from '../constants';

export default function PersonEdit() {

    // Service
    const projectService = ProjectService();
    const pessoaService = PessoaService();
    const membroProjetoService = MembroProjetoService();

    // Router
    const navigate = useNavigate();

    // Redux
    const navigationMode = useSelector(state => state.ConfigController.navigationMode)
    const isEdit = useSelector(state => state.editController.isEdit)
    const register = useSelector(state => state.editController.register)
    const dispatch = useDispatch()

    // Module States        
    const [editForm, setEditForm] = React.useState({
        id: '',
        nome: '',
        dataInicio: '',
        dataPrevisaoFim: '',
        dataFim: '',
        descricao: '',
        status: '',
        orcamento: '',
        risco: '',
        gerente: null,
    })
    const [detail1, setDetail1] = React.useState([])
    const [gerenteList, setGerenteList] = React.useState([])

    React.useEffect(() => {
        loadGerente()

        if (isEdit) {
            loadObject()
            loadDetail()
        }

    }, [])

    // API
    async function loadObject() {
        try {
            setEditForm(await projectService.getById(register.id))
        } catch (error) {
            console.error('Erro:', error);
        }
    }

    async function loadGerente() {
        try {
            setGerenteList(await pessoaService.getFuncionario())
        } catch (error) {
            console.error('Erro:', error);
        }
    }

    async function loadDetail() {
        try {
            setDetail1(await membroProjetoService.getByProject(register))
        } catch (error) {
            console.error('Erro:', error);
        }
    }

    async function save() {
        console.log(editForm)

        // validacoes
        if (!editForm.nome){
            dispatch(showWarning('Informe o nome'))
            return
        }

        if (!editForm.gerente){
            dispatch(showWarning('Informe o gerente'))
            return
        }
        
        
        if (isEdit) {
            try {
                await projectService.update(editForm);
            } catch (error) {
                console.error('Erro:', error);
            }
        }
        else {
            try {
                let response = await projectService.insert(editForm);              
                
                if (response){
                    setEditForm(response)
                    dispatch(setEdit(response))
                    navigate('/project/edit')
                }                
            } catch (error) {
                console.error('Erro:', error);
            }
        }
    }

    async function remove() {
        try {
            let response = await projectService.remove(editForm)            

            if (response){
                redirectToList()
            }
        } catch (error) {
            console.error('Erro:', error);
        }        
    }

    // Functions
    function redirectToList(){
        if (navigationMode === 'monopage'){
            dispatch(setPage(<ProjectList />))
        }
        else {
            navigate('/project/list')
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

    const searchPanelTemplate = (options) => {
        const className = `${options.className} justify-content-start`;
        const titleClassName = `${options.titleClassName} ml-2 text-secondary`;
        const style = { fontSize: '1rem' };

        return (
            <div className={className}>
                <span className={titleClassName} style={style}>{isEdit ? `Projeto #${editForm.id} ` : 'Projeto #Novo'}</span>
            </div>
        );
    };

    const listPanelTemplate = (options) => {
        const className = `${options.className} justify-content-space-between`;
        const titleClassName = `${options.titleClassName} ml-2 text-secondary`;
        const style = { fontSize: '1rem' };

        return (
            <div className={className}>
                <span className={titleClassName} style={style}>Detalhes</span>
            </div>
        );
    };

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
                        headerTemplate={searchPanelTemplate}
                    >
                        <Container>
                            <TabView>
                                <TabPanel header="Dados do Projeto">
                                    <Row>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="gerente">Gerente</label>
                                                <Dropdown
                                                    id="gerente"
                                                    className="w-full p-inputtext-sm"
                                                    value={editForm.gerente}
                                                    onChange={(e) => {
                                                        setEditForm({
                                                            ...editForm,
                                                            gerente: e.value
                                                        })
                                                    }}
                                                    options={gerenteList}
                                                    optionLabel='nome' />
                                            </div>
                                        </Col>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="nome">Nome</label>
                                                <InputText
                                                    id="nome"
                                                    className="w-full p-inputtext-sm"
                                                    type="text"
                                                    value={editForm.nome}
                                                    onChange={(e) => setEditForm({
                                                        ...editForm,
                                                        nome: e.target.value
                                                    })}
                                                />
                                            </div>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="dataInicio">Data Início</label>
                                                <Calendar
                                                    id="dataInicio"
                                                    className="w-full p-inputtext-sm"
                                                    dateFormat="dd/mm/yy"
                                                    value={editForm.dataInicio ? new Date(editForm.dataInicio) : null}
                                                    onChange={(e) => setEditForm({
                                                        ...editForm,
                                                        dataInicio: e.value
                                                    })}
                                                />
                                            </div>
                                        </Col>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="dataPrevisaoFim">Data Previsão Fim</label>
                                                <Calendar
                                                    id="dataPrevisaoFim"
                                                    className="w-full p-inputtext-sm"
                                                    dateFormat="dd/mm/yy"
                                                    value={editForm.dataInicio ? new Date(editForm.dataPrevisaoFim) : null}
                                                    onChange={(e) => setEditForm({
                                                        ...editForm,
                                                        dataPrevisaoFim: e.value
                                                    })}
                                                />
                                            </div>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="dataFim">Data Fim</label>
                                                <Calendar
                                                    id="dataFim"
                                                    className="w-full p-inputtext-sm"
                                                    dateFormat="dd/mm/yy"
                                                    value={editForm.dataFim ? new Date(editForm.dataFim) : null}
                                                    onChange={(e) => setEditForm({
                                                        ...editForm,
                                                        dataFim: e.value
                                                    })}
                                                />
                                            </div>
                                        </Col>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="status">Status</label>
                                                <Dropdown
                                                    id="status"
                                                    className="w-full p-inputtext-sm"
                                                    value={editForm.status}
                                                    onChange={(e) => {
                                                        setEditForm({
                                                            ...editForm,
                                                            status: e.value
                                                        })
                                                    }}
                                                    options={statusList}
                                                    optionValue='value'
                                                    optionLabel='value' />
                                            </div>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="orcamento">Orçamento</label>
                                                <InputNumber
                                                    id="orcamento"
                                                    className="w-full p-inputtext-sm"
                                                    value={editForm.orcamento}
                                                    onValueChange={(e) => {
                                                        setEditForm({
                                                            ...editForm,
                                                            orcamento: e.value
                                                        })
                                                    }}
                                                    mode="currency"
                                                    currency="BRL"
                                                    locale="en-US" />
                                            </div>
                                        </Col>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="risco">Risco</label>
                                                <Dropdown
                                                    id="risco"
                                                    className="w-full p-inputtext-sm"
                                                    value={editForm.risco}
                                                    onChange={(e) => {
                                                        setEditForm({
                                                            ...editForm,
                                                            risco: e.value
                                                        })
                                                    }}
                                                    options={riscoList}
                                                    optionValue='value'
                                                    optionLabel='value' />
                                            </div>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col>
                                            <div className="flex flex-column align-items-start gap-1">
                                                <label htmlFor="risco">Descrição</label>
                                                <InputTextarea
                                                    id="descricao"
                                                    className="w-full p-inputtext-sm"
                                                    value={editForm.descricao}
                                                    onChange={(e) => {
                                                        setEditForm({
                                                            ...editForm,
                                                            descricao: e.target.value
                                                        })
                                                    }}
                                                    rows={5}
                                                    cols={30}
                                                />
                                            </div>
                                        </Col>
                                    </Row>
                                </TabPanel>
                            </TabView>

                            <Row style={{ margin: '1rem' }}>
                                <Col className='flex flex-wrap gap-3 justify-content-center align-items-center'>
                                    <Button
                                        type="button"
                                        severity='secondary'
                                        rounded
                                        icon="pi pi-arrow-left"
                                        tooltip="Voltar"
                                        tooltipOptions={{ position: 'bottom' }}
                                        onClick={(e) => {
                                            redirectToList()
                                        }}
                                    />
                                    <Button
                                        type="button"
                                        severity='success'
                                        rounded
                                        icon="pi pi-save"
                                        tooltip="Salvar"
                                        tooltipOptions={{ position: 'bottom' }}
                                        onClick={(e) => {
                                            save()
                                        }}
                                    />
                                    {isEdit &&
                                        <>
                                            <Button
                                                type="button"
                                                severity='help'
                                                rounded
                                                icon="pi pi-replay"
                                                tooltip="Restaurar"
                                                tooltipOptions={{ position: 'bottom' }}
                                                onClick={(e) => {
                                                    loadObject()
                                                }}
                                            />

                                            <Button
                                                type="button"
                                                severity='danger'
                                                rounded
                                                icon="pi pi-trash"
                                                tooltip="Remover"
                                                tooltipOptions={{ position: 'bottom' }}
                                                onClick={(e) => {
                                                    remove()
                                                }}
                                            />
                                        </>
                                    }
                                </Col>
                            </Row>
                        </Container>
                    </Panel>
                </Row>
                {isEdit &&
                    <Row>
                        <Panel
                            headerTemplate={listPanelTemplate}
                        >
                            <TabView>
                                <TabPanel header="Membros">
                                    <DataTable
                                        value={detail1}
                                        size='small'
                                        showGridlines
                                        stripedRows
                                        paginator
                                        rows={10}
                                        emptyMessage="Nenhum membro associado ao projeto">
                                        <Column
                                            header="Código"
                                            field="id"
                                            align={'center'} />
                                        <Column
                                            header="Nome"
                                            field="nome"
                                            align={'center'} />
                                    </DataTable>
                                </TabPanel>
                            </TabView>
                        </Panel>

                    </Row>
                }
            </Container>
        </Panel>
    )
}