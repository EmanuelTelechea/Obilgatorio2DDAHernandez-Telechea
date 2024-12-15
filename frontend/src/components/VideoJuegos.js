import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Form from 'react-bootstrap/Form';

import { useEffect, useState } from 'react';

import fetchs from '../fetchs'; // Assuming you have a fetchs module for API calls

import 'bootstrap/dist/css/bootstrap.min.css';

const VideoJuegos = (props) => {
    const [listaVideoJuegos, setListaVideoJuegos] = useState(props.listaVideoJuegos);
    const [videoJuego, setVideoJuego] = useState(null);
    const [nombre, setNombre] = useState(null);
    const [descripcion, setDescripcion] = useState(null);
    const [precio, setPrecio] = useState(null);
    const [cantStock, setCantStock] = useState(null);
    const [categoria, setCategoria] = useState(null);

    const fillForm = (idVideoJuego) => {
        fetchs.getVideoJuego(idVideoJuego)
            .then(data => {
                setVideoJuego(data);
                setNombre(data.nombre);
                setDescripcion(data.descripcion);
                setPrecio(data.precio);
                setCantStock(data.cantStock);
                setCategoria(data.categoria);
            })
            .catch(error => {
                console.error('Error al obtener el videojuego:', error);
            });
    }

    return (
        <div className='VideoJuegos' style={{ marginTop: "5%" }}>
            <Container>
                <Row>
                    <Col>
                        <Form>
                            <Form.Group className="mb-3">
                                <Form.Label>Nombre</Form.Label>
                                <Form.Control value={nombre} onChange={(e) => setNombre(e.target.value)} type="text" placeholder="Nombre del videojuego" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Descripción</Form.Label>
                                <Form.Control value={descripcion} onChange={(e) => setDescripcion(e.target.value)} type="text" placeholder="Descripción" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Precio</Form.Label>
                                <Form.Control value={precio} onChange={(e) => setPrecio(e.target.value)} type="number" placeholder="Precio" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Cantidad en Stock</Form.Label>
                                <Form.Control value={cantStock} onChange={(e) => setCantStock(e.target.value)} type="number" placeholder="Cantidad en Stock" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Categoría</Form.Label>
                                <Form.Control value={categoria} onChange={(e) => setCategoria(e.target.value)} type="text" placeholder="Categoría" />
                            </Form.Group>
                            <Button
                                variant="primary"
                                type="button"
                                onClick={() => {
                                    fetchs.createVideoJuego(nombre, descripcion, precio, cantStock, categoria, setListaVideoJuegos);
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
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad en Stock</th>
                                    <th>Categoría</th>
                                </tr>
                            </thead>
                            <tbody>
                                {listaVideoJuegos.map((videoJuego) => (
                                    <tr key={videoJuego.id}>
                                        <td>{videoJuego.nombre}</td>
                                        <td>{videoJuego.descripcion}</td>
                                        <td>{videoJuego.precio}</td>
                                        <td>{videoJuego.cantStock}</td>
                                        <td>{videoJuego.categoria}</td>
                                        <td>
                                            <ButtonGroup size="sm">
                                                <Button variant='danger' onClick={() => {
                                                    fetchs.deleteVideoJuego(videoJuego.id, setListaVideoJuegos);
                                                }}>Eliminar</Button>
                                                <Button style={{ backgroundColor: '#007BFF', color: 'white', border: 'none' }} onClick={() => fillForm(videoJuego.id)}>Modificar</Button>
                                            </ButtonGroup>
                                        </td>
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

export default VideoJuegos;