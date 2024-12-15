import React, { useState } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import 'bootstrap/dist/css/bootstrap.min.css';

const Filtros = () => {
    const [cantStock, setCantStock] = useState('');
    const [videoJuegos, setVideoJuegos] = useState([]);
    const [error, setError] = useState(null);

    const buscarVideoJuegos = () => {
        // Construir la URL con los filtros
        const url = new URL('http://localhost:5000/videoJuego/filtrarPorStock');
        if (cantStock) url.searchParams.append('cantStock', cantStock);

        fetch(url.toString())
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la búsqueda de videojuegos');
                }
                return response.json();
            })
            .then(data => {
                setVideoJuegos(data);
                setError(null);
            })
            .catch(err => {
                setError(err.message);
                setVideoJuegos([]);
            });
    };

    return (
        <Container style={{ marginTop: '5%' }}>
            <Row>
                <Col>
                    <Form>
                        <Form.Group className="mb-3">
                            <Form.Label>Buscar por stock</Form.Label>
                            <Form.Control 
                                type="text" 
                                placeholder="Ingrese el stock del videojuego" 
                                value={cantStock} 
                                onChange={(e) => setCantStock(e.target.value)} 
                            />
                        </Form.Group>
                        <Button variant="primary" onClick={buscarVideoJuegos}>
                            Buscar
                        </Button>
                    </Form>
                </Col>
            </Row>
            <Row style={{ marginTop: '3%' }}>
                <Col>
                    {error ? (
                        <p style={{ color: 'red' }}>{error}</p>
                    ) : (
                        <Table striped bordered hover>
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
                                {videoJuegos.map((videoJuego) => (
                                    <tr key={videoJuego.id}>
                                    <td>{videoJuego.nombre}</td>
                                    <td>{videoJuego.descripcion}</td>
                                    <td>{videoJuego.precio}</td>
                                    <td>{videoJuego.cantStock}</td>
                                    <td>{videoJuego.categoria}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>
                    )}
                </Col>
            </Row>
        </Container>
    );
};

export default Filtros;
