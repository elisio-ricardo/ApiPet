package com.gft.ApiPet.dto.donoPet;

public class ConsultarDonoPetDTOSemLista {

    private Long id;
    private String nome;
    private String cpf;

    public ConsultarDonoPetDTOSemLista() {
    }


    public ConsultarDonoPetDTOSemLista(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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
