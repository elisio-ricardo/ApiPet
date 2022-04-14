package com.gft.ApiPet.dto.donoPet;

import com.gft.ApiPet.dto.pet.PetDTO;
import com.gft.ApiPet.dto.pet.RegistroPetDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RegistroDonoPetDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotEmpty
    private List<RegistroPetDTO> pet;

    public List<RegistroPetDTO> getPet() {
        return pet;
    }

    public void setPet(List<RegistroPetDTO> pet) {
        this.pet = pet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
