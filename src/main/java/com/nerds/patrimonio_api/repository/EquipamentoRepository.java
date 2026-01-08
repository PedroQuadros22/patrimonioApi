package com.nerds.patrimonio_api.repository;

import com.nerds.patrimonio_api.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    boolean existsByNumeroSerie(String numeroSerie);
}
