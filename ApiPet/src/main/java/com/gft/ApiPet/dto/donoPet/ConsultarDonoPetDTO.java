package com.gft.ApiPet.dto.donoPet;

import com.gft.ApiPet.dto.pet.ConsultarPetDTO;

import java.util.List;

public class ConsultarDonoPetDTO {

    private Long id;
    private String nome;
    private String cpf;
    private List<ConsultarPetDTO> petDTO;

    public ConsultarDonoPetDTO() {
    }

    public ConsultarDonoPetDTO(Long id, String nome, String cpf, List<ConsultarPetDTO> petDTO) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.petDTO = petDTO;
    }

    public ConsultarDonoPetDTO(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public List<ConsultarPetDTO> getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(List<ConsultarPetDTO> petDTO) {
        this.petDTO = petDTO;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
