import { createSlice } from '@reduxjs/toolkit'

export const toastSlice = createSlice({
    name: 'toast',
    initialState: {
        value: null
    },
    reducers: {
        showToast: (state, action) => {
            state.value = action.payload
        },
        showSucess: (state, action) => {
            state.value = {
                severity: 'success',
                summary: 'Êxito',
                detail: action.payload,
            }
        },
        showError: (state, action) => {
            state.value = {
                severity: 'error',
                summary: 'Erro',
                detail: 'Não foi possível executar a ação!'
            }
        },
        showWarning: (state, action) => {
            state.value = {
                severity: 'warn',
                summary: 'Atenção',
                detail: action.payload
            }
        },        
    }
})

export const { 
    showToast, 
    showSucess, 
    showError,
    showWarning, 
} = toastSlice.actions

export default toastSlice.reducer