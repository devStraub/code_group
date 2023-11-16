import React from 'react'

// Router
import { BrowserRouter as Router } from 'react-router-dom';

// Primefaces
import "primereact/resources/themes/arya-orange/theme.css";
import "primereact/resources/primereact.min.css";
import 'primeicons/primeicons.css';
import '/node_modules/primeflex/primeflex.css'

// Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';

// CSS
import './App.css';

// Components
import Pages from './components/pages'

function App() {

  return (
    <Router>
      <Pages />
    </Router>
  );
}

export default App;
