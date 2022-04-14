package com.gft.ApiPet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePet;

    private String tipo;

    private String peso;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private DonoPet donoPet;

    public Pet() {
    }

    public Pet(Long id, String nomePet, String tipo, String peso, DonoPet donoPet) {
        this.id = id;
        this.nomePet = nomePet;
        this.tipo = tipo;
        this.peso = peso;
        this.donoPet = donoPet;
    }

    public Pet(String nome, String tipo, String peso) {
        this.nomePet = nome;
        this.tipo = tipo;
        this.peso = peso;
    }

    public Pet(String nomePet, String tipo, String peso, DonoPet donoPet) {
        this.nomePet = nomePet;
        this.tipo = tipo;
        this.peso = peso;
        this.donoPet = donoPet;
    }


    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public DonoPet getDonoPet() {
        return donoPet;
    }

    public void setDonoPet(DonoPet donoPet) {
        this.donoPet = donoPet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
