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
import org.springframework.stereotype.Controller;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Regulares;
import com.obligatorio2dda.obligatorio2dda.Service.RegularService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/regulares")
public class RegularesController {

    @Autowired
    private RegularService regularService;

    @PostMapping
    public ResponseEntity<?> altaRegular(@RequestBody Regulares r) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularService.altaRegular(r));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRegular(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularService.eliminarRegular(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificar(@RequestBody Regulares r) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularService.modificarRegular(r));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> conseguirRegular(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(regularService.conseguirRegular(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor");
        }
    }
}
