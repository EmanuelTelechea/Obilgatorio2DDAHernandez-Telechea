package com.obligatorio2dda.obligatorio2dda.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.VideoJuegos;
import com.obligatorio2dda.obligatorio2dda.Service.VideoJuegosService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/videoJuego")
public class VideoJuegosController {

    @Autowired
    private VideoJuegosService videoJuegosService;

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody VideoJuegos vj) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosService.agregarVJ(vj));
        } 
        catch (AppException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosService.eliminarVJ(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificar(@RequestBody VideoJuegos vj) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosService.modificarVJ(vj));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> conseguirVideoJuego(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videoJuegosService.conseguirVideoJuego(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/filtrarPorStock")
    public ResponseEntity<?> listarPorStock(@RequestParam int cantStock) {
        return ResponseEntity.status(HttpStatus.OK).body(videoJuegosService.filtrarPorStock(cantStock));
    }
}