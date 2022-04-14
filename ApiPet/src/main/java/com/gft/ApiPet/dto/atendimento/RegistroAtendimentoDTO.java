package com.gft.ApiPet.dto.atendimento;

import com.gft.ApiPet.entities.DonoPet;

public class RegistroAtendimentoDTO {

    private String produto;
    private String preco;

    private DonoPet donoPet;

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
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
