import { createSlice } from '@reduxjs/toolkit'

export const confirmDialogSlice = createSlice({
    name: 'confirmDialog',
    initialState: {
        visible: false,
        header: '',
        message: '',
        response: false
    },
    reducers: {
        showConfirmDialog: state => {
            state.visible = true
            state.response = false
        },
        closeConfirmDialog: state => {
            state.visible = false
            state.response = false
        },
        setHeaderConfirmDialog: (state, action) => {
            state.header = action.payload
        },
        setMessageConfirmDialog: (state, action) => {
            state.message = action.payload
        },
        acceptConfirmDialog: state => {
            state.response = true
            state.visible = false
        },
        resetConfirmDialog: state => {
            state.visible = false
            state.header = ''
            state.message = ''
            state.response = false            
        }
    }
})

export const { 
    showConfirmDialog, 
    closeConfirmDialog, 
    setHeaderConfirmDialog, 
    setMessageConfirmDialog,
    acceptConfirmDialog,
    resetConfirmDialog,
} = confirmDialogSlice.actions

export default confirmDialogSlice.reducer