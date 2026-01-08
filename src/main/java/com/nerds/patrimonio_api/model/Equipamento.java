package com.nerds.patrimonio_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name= "equipamentosTable")
public class Equipamento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    @NotBlank(message = "O tipo é obrigatório")
    private String tipo;
    @NotBlank(message = "O numero de serie é obrigatório")
    private String numeroSerie;
    @NotNull(message = "A data de aquisição é obrigatória (dd/MM/yyyy)")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;
    @NotBlank(message = "O status é obrigatório")
    private String status;

    public Equipamento(){}
    public Equipamento(String name, String tipo, String numeroSerie, LocalDate dataAquisicao, String Status){
        setName(name);
        setTipo(tipo);
        setNumeroSerie(numeroSerie);
        setDataAquisicao(dataAquisicao);
        setStatus(status);
    }

    public void setId(Long id) {
        if(id>0){
            this.id=id;
        }
    }
    public Long getId(){
        return id;
    }

    public void setName(String name){
        if (name!=null){
            this.name=name;
        }
    }
    public String getName(){
        return name;
    }

    public void setTipo(String tipo){
        if(tipo!=null){
            this.tipo=tipo;
        }
    }
    public String getTipo(){
        return tipo;
    }

    public void setNumeroSerie(String numeroSerie){
        if(numeroSerie!=null){
            this.numeroSerie=numeroSerie;
        }
    }
    public String getNumeroSerie(){
        return numeroSerie;
    }

    public void setDataAquisicao(LocalDate dataAquisicao){
        if(dataAquisicao!=null){
            this.dataAquisicao=dataAquisicao;
        }
    }
    public LocalDate getDataAquisicao(){
        return dataAquisicao;
    }

    public void setStatus(String status){
        if(status!=null){
            this.status=status;
        }
    }
    public String getStatus(){
        return status;
    }

}
