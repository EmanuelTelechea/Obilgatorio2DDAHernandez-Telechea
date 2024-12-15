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

const RegularUsuarios = (props) => {
    const [listaRegulares, setListaRegulares] = useState(props.listaRegulares);
    const [usuario, setUsuario] = useState(null);
    const [nombre, setNombre] = useState('');
    const [email, setEmail] = useState('');
    const [fechaRegistro, setFechaRegistro] = useState('');

    const fillForm = (idUsuario) => {
        fetchs.getRegulares(idUsuario)
            .then(data => {
                setUsuario(data);
                setNombre(data.nombre);
                setEmail(data.email);
                setFechaRegistro(data.fechaRegistro);
            })
            .catch(error => {
                console.error('Error al obtener el usuario:', error);
            });
    }

    return (
        <div className='RegularUsuarios' style={{ marginTop: "5%" }}>
            <Container>
                <Row>
                    <Col>
                        <Form>
                            <Form.Group className="mb-3">
                                <Form.Label>Nombre</Form.Label>
                                <Form.Control value={nombre} onChange={(e) => setNombre(e.target.value)} type="text" placeholder="Nombre del usuario" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Email</Form.Label>
                                <Form.Control value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="Email" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Fecha de Registro</Form.Label>
                                <Form.Control value={fechaRegistro} onChange={(e) => setFechaRegistro(e.target.value)} type="date" />
                            </Form.Group>
                            <Button
                                variant="primary"
                                type="button"
                                onClick={() => {
                                    fetchs.createUsuario(nombre, email, fechaRegistro, 'regular', setListaRegulares);
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
                                    <th>Email</th>
                                    <th>Fecha de Registro</th>
                                </tr>
                            </thead>
                            <tbody>
                                {listaRegulares.map((usuario) => (
                                    <tr key={usuario.id}>
                                        <td>{usuario.nombre}</td>
                                        <td>{usuario.email}</td>
                                        <td>{usuario.fechaRegistro}</td>
                                        <td>
                                            <ButtonGroup size="sm">
                                                <Button variant='danger' onClick={() => {
                                                    fetchs.deleteregulares(usuario.id, setListaRegulares);
                                                }}>Eliminar</Button>
                                                <Button style={{ backgroundColor: '#007BFF', color: 'white', border: 'none' }} onClick={() => fillForm(usuario.id)}>Modificar</Button>
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

export default RegularUsuarios;