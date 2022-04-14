package com.gft.ApiPet.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_donoPet")
public class DonoPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dono_pet_id")
    private List<Pet> pet;

    public DonoPet() {
    }

    public DonoPet(Long id, String nome, String cpf, List<Pet> pet) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.pet = pet;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
