import React from 'react';

import { useDispatch } from 'react-redux';
import { showError, showSucess, showWarning } from '../../redux/reducers/components/overlays/toast';

import API from '../index';

const modulo = '/projeto';

function ProjectService() {

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
            console.log(error)
            dispatch(showError());
            throw error;
        }
    }

    async function update(object) {
        const json = {
            ...object,
        };    
        console.log(json)

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
        if (object.status === 'INICIADO' || object.status === 'EM_ANDAMENTO' || object.status === 'ENCERRADO'){
            dispatch(showWarning('Status do projeto não permite exclusão!'))
            return false;
        }

        try {
            const response = await API.delete(`${modulo}/${object.id}`);
            dispatch(showSucess('Registro removido.'))
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
    };
}

export default ProjectService;