import { createSlice } from '@reduxjs/toolkit'

import ProjectList from '../../../../components/pages/projects/list'

export const pageSlice = createSlice({
    name: 'page',
    initialState: {
        value: <ProjectList/>
    },
    reducers: {
        setPage: (state, action) => {
            state.value = action.payload
        }
    }
})

export const { setPage } = pageSlice.actions

export default pageSlice.reducer