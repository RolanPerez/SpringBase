package com.codigo.perezherrera.controller;

import com.codigo.perezherrera.entity.EmpresaEntity;
import com.codigo.perezherrera.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/springbase/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API de mantenimiento de empresas",
        description = "Esta api contiene todos los endpoints para realizar el amntenimiento de empresas"
)

public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa creada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.crear(empresaEntity));
    }

    @Operation(summary = "Buscar una empresa por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @Operation(summary = "Buscar todas las empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Buscar todas las empresasa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> buscarTodos(){
        return ResponseEntity.ok(empresaService.buscarTodos());
    }

    @Operation(summary = "Actualizar una empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Actualizar una empresa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.actualizar(id,empresaEntity));
    }

    @Operation(summary = "Eliminar una empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Eliminar una empresa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.borrar(id));
    }
}