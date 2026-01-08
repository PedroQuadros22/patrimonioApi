package com.nerds.patrimonio_api.controller;

import com.nerds.patrimonio_api.exception.IdNaoEncontradoException;
import com.nerds.patrimonio_api.exception.NumeroSerieDuplicadoException;
import com.nerds.patrimonio_api.model.Equipamento;
import com.nerds.patrimonio_api.service.EquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/equipamento")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService){
        this.equipamentoService=equipamentoService;
    }

    @GetMapping
    public List<Equipamento> getAll(){
        return equipamentoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Equipamento equipamento = equipamentoService.findById(id);
            return ResponseEntity.ok(equipamento);

        } catch (IdNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno.");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Equipamento equipamento) {
        try {
            Equipamento salvo = equipamentoService.save(equipamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

        } catch (NumeroSerieDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar equipamento.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            equipamentoService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (IdNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar equipamento.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Equipamento equipamento) {
        try {
            Equipamento atualizado = equipamentoService.update(id, equipamento);
            return ResponseEntity.ok(atualizado);

        } catch (IdNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (NumeroSerieDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar equipamento.");
        }
    }

}
