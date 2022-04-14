package com.gft.ApiPet.dto.atendimento;

import com.gft.ApiPet.entities.DonoPet;

public class ConsultarAtendimentoDTO {

    private Long id;
    private String produto;
    private String preco;
    private DonoPet donoPet;

    public ConsultarAtendimentoDTO() {
    }

    public ConsultarAtendimentoDTO(Long id, String produto, String preco, DonoPet donoPet) {
        this.id = id;
        this.produto = produto;
        this.donoPet = donoPet;
        this.preco = preco;
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
