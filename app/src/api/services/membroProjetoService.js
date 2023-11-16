import React from 'react';

import { useDispatch } from 'react-redux';
import { showError, showSucess } from '../../redux/reducers/components/overlays/toast';

import API from '../index';

const modulo = '/membro_projeto';

function MembroProjetoService() {

    const dispatch = useDispatch();  

    React.useEffect(() => {

    }, [])    

    async function getAll() {
        try {
            const response = await API.get(modulo);
            return response.data;
        } catch (error) {
            dispatch(showError());
            throw error;
        }
    }

    async function getById(id) {
        try {
            const response = await API.get(`${modulo}/${id}`);
            return response.data;
        } catch (error) {
            dispatch(showError());
            throw error;
        }
    }    

    async function insert(object) {
        const json = {
            ...object,
        };

        try {
            const response = await API.post(modulo, json);
            dispatch(showSucess('Registro inserido.'))
            return response.data;
        } catch (error) {
            dispatch(showError());
            throw error;
        }
    }

    async function update(object) {
        const json = {
            ...object,
        };    
        
        try {
            const response = await API.put(modulo, json);
            dispatch(showSucess('Registro atualizado.'))
            return response.data;
        } catch (error) {
            dispatch(showError());
            throw error;
        }        
    }

    async function remove(object) {
        try {
            const response = await API.delete(`${modulo}/${object.id}`);
            dispatch(showSucess('Registro removido.'))
            return response.data;
        } catch (error) {
            dispatch(showError());
            throw error;
        } 
    }

    async function getByProject(object) {
        const json = {
            ...object,
        };

        try {
            const response = await API.post(`${modulo}/pessoaByProjeto`, json);
            console.log(response.data)
            return response.data;
        } catch (error) {
            dispatch(showError());
            throw error;
        }
    }    

    return {
        getAll,
        getById,
        insert,
        update,
        remove,
        getByProject,
    };
}

export default MembroProjetoService;