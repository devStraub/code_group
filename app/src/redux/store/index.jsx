import { configureStore } from '@reduxjs/toolkit'

// Reducers
import ConfigReducer from '../reducers/configs'
import pageReducer from '../reducers/components/pages'
import modalReducer from '../reducers/components/overlays/dialog/modal'
import dialogConfirmReducer from '../reducers/components/overlays/dialog/confirm'
import toastReducer from '../reducers/components/overlays/toast'

import editReducer from '../reducers/components/pages/edit'

export default configureStore({
  reducer: {
    ConfigController: ConfigReducer,
    pageView: pageReducer,
    modalView: modalReducer,
    dialogConfirmView: dialogConfirmReducer,
    toastView: toastReducer,
    editController: editReducer,
  },
  middleware: getDefaultMiddleware =>
  getDefaultMiddleware({
    serializableCheck: false,
  }),  
})