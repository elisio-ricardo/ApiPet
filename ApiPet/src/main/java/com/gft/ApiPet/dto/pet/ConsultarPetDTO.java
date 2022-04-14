package com.gft.ApiPet.dto.pet;

import com.gft.ApiPet.dto.donoPet.ConsultarDonoPetDTO;
import com.gft.ApiPet.dto.donoPet.ConsultarDonoPetDTOSemLista;

public class ConsultarPetDTO {

    private String nome;
    private String tipo;
    private String peso;
    private ConsultarDonoPetDTO donoPet;

    public ConsultarPetDTO() {
    }

    public ConsultarPetDTO(String nome, String tipo, String peso) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
    }

    public ConsultarPetDTO(String nome, String tipo, String peso, ConsultarDonoPetDTO donoPet) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.donoPet = donoPet;
    }

    public ConsultarDonoPetDTO getDonoPet() {
        return donoPet;
    }

    public void setDonoPet(ConsultarDonoPetDTO donoPet) {
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
