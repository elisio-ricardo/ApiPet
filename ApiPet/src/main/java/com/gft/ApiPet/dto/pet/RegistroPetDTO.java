package com.gft.ApiPet.dto.pet;

import com.gft.ApiPet.dto.donoPet.RegistroDonoPetDTO;

import javax.validation.constraints.NotBlank;

public class RegistroPetDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @NotBlank
    private String peso;

    private Long donoId;

    private RegistroDonoPetDTO donoPet;

    public Long getDonoId() {
        return donoId;
    }

    public void setDonoId(Long donoId) {
        this.donoId = donoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public RegistroDonoPetDTO getDonoPet() {
        return donoPet;
    }

    public void setDonoPet(RegistroDonoPetDTO donoPet) {
        this.donoPet = donoPet;
    }
}
