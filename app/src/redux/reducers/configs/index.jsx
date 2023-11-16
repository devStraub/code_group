import { createSlice } from '@reduxjs/toolkit'

export const configSlice = createSlice({
    name: 'config',
    initialState: {
        navigationMode: 'routes', // routes or monopage
    },
    reducers: {

    }
})

export const { 

} = configSlice.actions

export default configSlice.reducer