package com.gft.ApiPet.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produto;

    private String preco;

    @OneToOne
    private DonoPet donoPet;

    public Atendimento() {
    }

    public Atendimento(Long id, String produto, String preco, DonoPet donoPet) {
        this.id = id;
        this.produto = produto;
        this.preco = preco;
        this.donoPet = donoPet;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public DonoPet getDonoPet() {
        return donoPet;
    }

    public void setDonoPet(DonoPet donoPet) {
        this.donoPet = donoPet;
    }
}
