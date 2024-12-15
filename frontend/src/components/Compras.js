import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Form from 'react-bootstrap/Form';

import { useEffect, useState } from 'react';

import fetchs from '../fetchs'; // Asegúrate de tener un módulo fetchs para las llamadas a la API

import 'bootstrap/dist/css/bootstrap.min.css';

const Compras = (props) => {
    const [listaCompras, setListaCompras] = useState(props.listaCompras);
    const [compra, setCompra] = useState(null);
    const [usuario, setUsuario] = useState('');
    const [videojuegos, setVideojuegos] = useState('');
    const [fecha, setFecha] = useState('');
    const [monto, setMonto] = useState(''); // Campo para el monto
    
    // Estado para mensajes y estado de éxito
    const [msg, setMsg] = useState(null);
    const [success, setSuccess] = useState(null);

    const fillForm = (idCompra) => {
        fetchs.getCompra(idCompra)
            .then(data => {
                setCompra(data);
                setUsuario(data.usuario);
                setVideojuegos(data.videojuegos);
                setFecha(data.fecha);
                setMonto(data.monto); // Rellenar el campo de monto
            })
            .catch(error => {
                console.error('Error al obtener la compra:', error);
            });
    }

    return (
        <div className='Compras' style={{ marginTop: "5%" }}>
            <Container>
                <Row>
                    <Col>
                        <Form>
                            <Form.Group className="mb-3">
                                <Form.Label>ID Usuario</Form.Label>
                                <Form.Control value={usuario} onChange={(e) => setUsuario(e.target.value)} type="text" placeholder="ID del usuario" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>ID Videojuego</Form.Label>
                                <Form.Control value={videojuegos} onChange={(e) => setVideojuegos(e.target.value)} type="text" placeholder="ID del videojuego" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Fecha de Compra</Form.Label>
                                <Form.Control value={fecha} onChange={(e) => setFecha(e.target.value)} type="date" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Monto</Form.Label>
                                <Form.Control value={monto} onChange={(e) => setMonto(e.target.value)} type="number" placeholder="Monto de la compra" />
                            </Form.Group>
                            <Button
                                variant="primary"
                                type="button"
                                onClick={() => {
                                    fetchs.createCompra({ usuario, videojuegos, fecha, monto }, setMsg, setSuccess, setListaCompras);
                                }}
                                style={{ marginTop: '2.5%', width: '30%', marginLeft: '33.33%' }}
                            >
                                Agregar
                            </Button>
                        </Form>
                    </Col>
                    <Col>
                        <Table striped bordered hover style={{ marginTop: '2.5%' }}>
                            <thead>
                                <tr>
                                    <th>ID Usuario</th>
                                    <th>ID Videojuego</th>
                                    <th>Fecha de Compra</th>
                                    <th>Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                {listaCompras.map((compra) => (
                                    <tr key={compra.id}>
                                        <td>{compra.usuariosId}</td>
                                        <td>{compra.videojuegoId}</td>
                                        <td>{compra.fecha}</td>
                                        <td>{compra.monto}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}

export default Compras;