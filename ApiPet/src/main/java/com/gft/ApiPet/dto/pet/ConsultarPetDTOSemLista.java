package com.gft.ApiPet.dto.pet;

import com.gft.ApiPet.dto.donoPet.ConsultarDonoPetDTOSemLista;

public class ConsultarPetDTOSemLista {

    private String nome;
    private String tipo;
    private String peso;
    private ConsultarDonoPetDTOSemLista donoPet;

    public ConsultarPetDTOSemLista() {
    }


    public ConsultarPetDTOSemLista(String nome, String tipo, String peso, ConsultarDonoPetDTOSemLista donoPet) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.donoPet = donoPet;
    }

    public ConsultarDonoPetDTOSemLista getDonoPet() {
        return donoPet;
    }

    public void setDonoPet(ConsultarDonoPetDTOSemLista donoPet) {
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
