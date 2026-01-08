package com.nerds.patrimonio_api.service;

import com.nerds.patrimonio_api.exception.IdNaoEncontradoException;
import com.nerds.patrimonio_api.exception.NumeroSerieDuplicadoException;
import com.nerds.patrimonio_api.model.Equipamento;
import com.nerds.patrimonio_api.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {
    private EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository){
        this.equipamentoRepository=equipamentoRepository;
    }

    //LISTAR
    public List<Equipamento> getAll(){
        return equipamentoRepository.findAll();
    }


    //ENCONTRAR POR ID
    public Equipamento findById(Long id) {
        Optional<Equipamento> resultado = equipamentoRepository.findById(id);

        if (resultado.isEmpty()) {
            throw new IdNaoEncontradoException("Equipamento não encontrado com ID: " + id);
        }
        return resultado.get();
    }

    //CRIAR
    public Equipamento save(Equipamento equipamento) {
        if (equipamento.getId() == null && equipamentoRepository.existsByNumeroSerie(equipamento.getNumeroSerie())) {
            throw new NumeroSerieDuplicadoException("Já existe um equipamento com este número de série");
        }
        return equipamentoRepository.save(equipamento);
    }

    //DELETE
    public void delete(Long id) {
        if (!equipamentoRepository.existsById(id)) {
            throw new IdNaoEncontradoException("Equipamento não encontrado com ID: " + id);
        }
        equipamentoRepository.deleteById(id);
    }

    //ATUALIZAR
    public Equipamento update(Long id, Equipamento equipamentoAtualizado) {
        Optional<Equipamento> box = equipamentoRepository.findById(id);

        if (box.isEmpty()) {
            throw new IdNaoEncontradoException("Equipamento não encontrado com ID: " + id);
        }
        Equipamento equipamentoExistente = box.get();

        if (!equipamentoAtualizado.getNumeroSerie().equals(equipamentoExistente.getNumeroSerie()) &&
                equipamentoRepository.existsByNumeroSerie(equipamentoAtualizado.getNumeroSerie())) {

            throw new NumeroSerieDuplicadoException("Já existe outro equipamento com este número de série!");
        }
        equipamentoAtualizado.setId(id);
        return equipamentoRepository.save(equipamentoAtualizado);
    }

}
