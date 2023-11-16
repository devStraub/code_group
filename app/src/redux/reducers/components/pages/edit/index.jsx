import { createSlice } from '@reduxjs/toolkit'

export const editSlice = createSlice({
    name: 'edit',
    initialState: {
        isEdit: false,
        register: {}
    },
    reducers: {
        setEdit: (state, action) => {
            state.isEdit = true
            state.register = action.payload
        },
        setNew: (state, action) => {
            state.isEdit = false
            state.register = {}
        }
    }
})

export const { 
    setEdit,
    setNew 
} = editSlice.actions

export default editSlice.reducer