import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Inicio from './components/Inicio';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/inicio" element={<Inicio />} />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;





/*

<Login/>

    <div className='contenedor'>
      <Formulario/>
    </div>

import './App.css'
import Formulario from './components/Formulario'
import Contador from './components/Contador'
import Boton from './components/Boton'
import PrimerComponente from './components/PrimerComponente'
import EjemploFuncionFlecha from './components/EjemploFuncionFlecha'
import InfoCompClase from './components/InfoCompClase'
import InfoCompFuncional from './components/InfoCompFuncional'
import InfoCompClase from './components/InfoCompClase'

//funcion JS
function javascriptFunction(){
  return "Como un componente"
}
//componente
function ReactComponente(props){
  return <h2>{props.content}</h2>
}

funciones flecha JS
const greet = name => `Hello, ${name}`;
const add = (a, b) => a+b

function App() {
  return (
    <section className="todo">
      <div>
        <PrimerComponente/>
        <EjemploFuncionFlecha nombre="Pepito" precio={5000}/>
        <h3>{javascriptFunction}</h3>
        <h4>{ReactComponente}</h4>
      </div>
      <div>
        <h1 className="titulo" >Angela Gisella rocha torres</h1>
        <h3 className= "uni">Universidad del Tolima</h3>
        <h3>Ingeniería de Sistemas</h3>
        <h4>Semestre Quinto</h4>
      </div>
      <div>
        <InfoCompClase/>
      </div>
      <div>
        <InfoCompClase tipo="CLASE"/>
        <InfoCompFuncional tipo="FUNCIONAL"/>
      </div>
      <div
        <h1>Botón básico:</h1>
        <Boton text="Presione el botón"/>
        <Contador />
      </div>
      <div className="contenedor">
       <Formulario/>
      </div>
    </section>
  )
}


export default App

*/