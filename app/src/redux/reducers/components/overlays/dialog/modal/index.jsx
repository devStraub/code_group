import { createSlice } from '@reduxjs/toolkit'

export const modalSlice = createSlice({
    name: 'modal',
    initialState: {
        visible: false,
        header: '',
        content: null
    },
    reducers: {
        showModal: state => {
            state.visible = true
        },
        closeModal: state => {
            state.visible = false
        },
        setHeader: (state, action) => {
            state.header = action.payload
        },
        setContent: (state, action) => {
            state.content = action.payload
        }
    }
})

export const { showModal, closeModal, setHeader, setContent } = modalSlice.actions

export default modalSlice.reducer