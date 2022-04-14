package com.gft.ApiPet.dto.pet;

import com.gft.ApiPet.entities.DonoPet;

public class PetDTO {

    private String nome;
    private String tipo;
    private String peso;
    private DonoPet donoPet;

    public PetDTO() {
    }

    public PetDTO(String nome, String tipo, String peso) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
    }

    public PetDTO(String nome, String tipo, String peso, DonoPet donoPet) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.donoPet = donoPet;
    }

    public DonoPet getDonoPet() {
        return donoPet;
    }

    public void setDonoPet(DonoPet donoPet) {
        this.donoPet = donoPet;
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
}
