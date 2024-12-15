package com.obligatorio2dda.obligatorio2dda.Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Compras;
import com.obligatorio2dda.obligatorio2dda.Entity.Usuarios;
import com.obligatorio2dda.obligatorio2dda.Repository.UsuarioRepository;
import com.obligatorio2dda.obligatorio2dda.Service.ComprasService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/compras")
public class ComprasController {
    @Autowired
    private ComprasService comprasService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Compras c) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(comprasService.agregarCompra(c));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(comprasService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/filtrarPorUsuario")
    public ResponseEntity<?> conseguirPorUsuario(@RequestParam int id) {
        try {
            List<Usuarios> usuarios = usuarioRepository.findById(id);

            if (usuarios.isEmpty()) {
                throw new AppException("Usuario no encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body(usuarios.get(0));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/filtrarPorFecha")
    public ResponseEntity<?> conseguirPorFecha(@RequestParam LocalDate fecha) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(comprasService.conseguirCompraPorFecha(fecha));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
}

