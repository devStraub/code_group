import React from 'react';
import { Route, Routes, Navigate } from 'react-router-dom';

import ProjectList from './components/pages/projects/list'
import ProjectEdit from './components/pages/projects/edit'

export const routes = [   
  {
    path: '/',
    component: <Navigate to="/project/list" />,
  },  
  {
    path: '/project/list',
    component: <ProjectList/>,
    exact: true,
    label: 'List', 
  },       
  {
    path: '/project/edit',
    component: <ProjectEdit/>,
    exact: true,
    label: 'Edit',   
  },        
];

export const RouteList = () => (
  <Routes>
    {routes.map((route) => (
      <Route
        key={route.path}
        path={route.path}
        exact={route.exact}
        element={route.component}
      />
    ))}
  </Routes>
);

export default {
  RouteList,
  routes
}
