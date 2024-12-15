const API_URL = 'http://localhost:5000'; // Base URL de la API

// Función para listar videojuegos
const listVideoJuegos = (setLista) => {
    fetch(`${API_URL}/videoJuego`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            setLista(data);
            console.log('Data:', data);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
};

// Función para obtener un videojuego por ID
const getVideoJuego = (idVideoJuego) => {
    return fetch(`${API_URL}/videoJuego/${idVideoJuego}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        });
};

// Función para crear un nuevo videojuego
const createVideoJuego = (nombre, descripcion, precio, cantStock, categoria, setListaVideoJuegos) => {
    const videoJuegoData = {nombre, descripcion, precio, cantStock, categoria}
    fetch(`${API_URL}/videoJuego`, {
        method: 'POST',
        body: JSON.stringify(videoJuegoData),
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        setListaVideoJuegos(prev => [...prev, data]); // Actualiza la lista de videojuegos
        console.log('Data:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

// Función para eliminar un videojuego por ID
const deleteVideoJuego = (idVideoJuego, setListaVideoJuegos) => {
    fetch(`${API_URL}/videoJuego/${idVideoJuego}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.text();
    })
    .then(data => {
        setListaVideoJuegos(prev => [...prev, data]); // Actualiza la lista de videojuegos
        console.log('Data:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

// Funciones para gestionar usuarios premium
const listPremiumUsuarios = (setLista) => {
    fetch(`${API_URL}/premium`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            setLista(data);
            console.log('Premium Usuarios:', data);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
};

const getPremium = (idUsuario) => {
    return fetch(`${API_URL}/premium/${idUsuario}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        });
};

const createUsuario = (nombre, email, fechaRegistro, tipo, setLista) => {
    const usuarioData = { nombre, email, fechaRegistro, tipo };
    fetch(`${API_URL}/regulares`, {
        method: 'POST',
        body: JSON.stringify(usuarioData),
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        setLista(prev => [...prev, data]); // Agrega el nuevo usuario a la lista
        console.log('Usuario agregado:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

const createPremium = (nombre, email, fechaRegistro, inicio, setLista) => {
    const usuarioData = { nombre, email, fechaRegistro, inicio };
    fetch(`${API_URL}/premium`, {
        method: 'POST',
        body: JSON.stringify(usuarioData),
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        setLista(prev => [...prev, data]); // Agrega el nuevo usuario a la lista
        console.log('Usuario agregado:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

const deleteregulares = (idUsuario, setLista) => {
    fetch(`${API_URL}/regulares/${idUsuario}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.text();
    })
    .then(data => {
        setLista(prev => prev.filter(usuario => usuario.id !== idUsuario)); // Elimina el usuario de la lista
        console.log('Usuario eliminado:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

const deletePremium = (idUsuario, setLista) => {
    fetch(`${API_URL}/premium/${idUsuario}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.text();
    })
    .then(data => {
        setLista(prev => prev.filter(usuario => usuario.id !== idUsuario)); // Elimina el usuario de la lista
        console.log('Usuario eliminado:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

// Funciones para gestionar usuarios regulares
const listRegularUsuarios = (setLista) => {
    fetch(`${API_URL}/regulares`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            setLista(data);
            console.log('Regular Usuarios:', data);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
};

const getRegulares = (idUsuario) => {
    return fetch(`${API_URL}/regulares/${idUsuario}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        });
};

// Funciones para gestionar compras
const listCompras = (setLista) => {
    fetch(`${API_URL}/compras`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            setLista(data);
            console.log('Compras:', data);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
};

const getCompra = (idCompra) => {
    return fetch(`${API_URL}/compras/${idCompra}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        });
};

const createCompra = (idUsuario, idVideoJuego, fecha, monto, setListaCompras) => {
    const CompraData = { idUsuario, idVideoJuego, fecha, monto };
    fetch(`${API_URL}/compras`, {
        method: 'POST',
        body: JSON.stringify(CompraData),
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        setListaCompras(prev => [...prev, data]);
        console.log('Data:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

const deleteCompra = (idCompra, setListaCompras) => {
    fetch(`${API_URL}/compras/${idCompra}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Network response was not ok: ${response.status}`);
        }
        return response.text();
    })
    .then(data => {
        listCompras(setListaCompras); // Actualiza la lista de compras
        console.log('Data:', data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
};

// Exporta las funciones
export default {
    listVideoJuegos,
    getVideoJuego,
    createVideoJuego,
    deleteVideoJuego,
    listPremiumUsuarios,
    getPremium,
    getRegulares,
    createUsuario,
    createPremium,
    deleteregulares,
    deletePremium,
    listRegularUsuarios,
    listCompras,
    getCompra,
    createCompra,
    deleteCompra,
};