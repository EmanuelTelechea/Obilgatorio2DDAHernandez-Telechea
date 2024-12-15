import React, { useEffect, useState } from 'react';
import { Container, Navbar, Nav, Alert } from 'react-bootstrap';
import fetchs from './fetchs'; // Ensure you have a fetchs.js file to handle API requests
import VideoJuego from './components/VideoJuegos'; // Component for managing video games
import PremiumUsuarios from './components/Premium'; // Component for managing premium users
import RegularUsuarios from './components/Regulares'; // Component for managing regular users
import Compras from './components/Compras'; // Component for managing purchases
import Filtros from './components/Filtros';

import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [showVideoJuegosMenu, setShowVideoJuegosMenu] = useState(false);
  const [showPremiumUsuariosMenu, setShowPremiumUsuariosMenu] = useState(false);
  const [showRegularUsuariosMenu, setShowRegularUsuariosMenu] = useState(false);
  const [showComprasMenu, setShowComprasMenu] = useState(false);
  const [showFiltrosMenu, setShowFiltrosMenu] = useState(false);

  const [listaVideoJuegos, setListaVideoJuegos] = useState([]);
  const [listaPremium, setListaPremium] = useState([]);
  const [listaRegulares, setListaRegulares] = useState([]);
  const [listaCompras, setListaCompras] = useState([]);
  
  const [msg, setMsg] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleShowVideoJuegosMenu = () => {
    setShowVideoJuegosMenu(true);
    setShowPremiumUsuariosMenu(false);
    setShowRegularUsuariosMenu(false);
    setShowComprasMenu(false);
    setShowFiltrosMenu(false);
  };

  const handleShowPremiumUsuariosMenu = () => {
    setShowPremiumUsuariosMenu(true);
    setShowVideoJuegosMenu(false);
    setShowRegularUsuariosMenu(false);
    setShowComprasMenu(false);
    setShowFiltrosMenu(false);
  };

  const handleShowRegularUsuariosMenu = () => {
    setShowRegularUsuariosMenu(true);
    setShowVideoJuegosMenu(false);
    setShowPremiumUsuariosMenu(false);
    setShowComprasMenu(false);
    setShowFiltrosMenu(false);
  };

  const handleShowComprasMenu = () => {
    setShowComprasMenu(true);
    setShowVideoJuegosMenu(false);
    setShowPremiumUsuariosMenu(false);
    setShowRegularUsuariosMenu(false);
    setShowFiltrosMenu(false);

  };
  const handleShowFiltrosMenu = () => {
    setShowComprasMenu(false);
    setShowVideoJuegosMenu(false);
    setShowPremiumUsuariosMenu(false);
    setShowRegularUsuariosMenu(false);
    setShowFiltrosMenu(true);
  };

  useEffect(() => {
    fetchs.listVideoJuegos(setListaVideoJuegos);
    fetchs.listPremiumUsuarios(setListaPremium); // Fetch premium users
    fetchs.listRegularUsuarios(setListaRegulares); // Fetch regular users
    fetchs.listCompras(setListaCompras); // Fetch purchases
  }, []);

  return (
    <div className="App">
      <Navbar bg="primary" data-bs-theme="dark" expand="sm">
        <Container>
          <Navbar.Brand href="#home">Tienda de Videojuegos Online</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link onClick={handleShowVideoJuegosMenu}>Videojuegos</Nav.Link>
            <Nav.Link onClick={handleShowPremiumUsuariosMenu}>Usuarios Premium</Nav.Link>
            <Nav.Link onClick={handleShowRegularUsuariosMenu}>Usuarios Regulares</Nav.Link>
            <Nav.Link onClick={handleShowComprasMenu}>Compras</Nav.Link>
            <Nav.Link onClick={handleShowFiltrosMenu}>Filtros</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      {success ? (
        <Alert variant={"success"} style={{ width: "30%", margin: 'auto', marginTop: '2.5%', textAlign: "center" }}>
          {msg}
        </Alert>
      ) : null}
      {success !== null && !success ? (
        <Alert variant={"danger"} style={{ width: "30%", margin: 'auto', marginTop: '2.5%', textAlign: "center" }}>
          {msg}
        </Alert>
      ) : null}

      {showVideoJuegosMenu ? (
        <VideoJuego listaVideoJuegos={listaVideoJuegos} />
      ) : null}

      {showPremiumUsuariosMenu ? (
        <PremiumUsuarios listaPremium={listaPremium} />
      ) : null}

      {showRegularUsuariosMenu ? (
        <RegularUsuarios listaRegulares={listaRegulares} />
      ) : null}

      {showComprasMenu ? (
        <Compras listaCompras={listaCompras} />
      ) : null}
      {showFiltrosMenu ? (
        <Filtros />
      ) : null}
    </div>
  );
}

export default App;