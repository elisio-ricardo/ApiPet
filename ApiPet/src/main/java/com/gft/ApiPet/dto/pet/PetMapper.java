package com.gft.ApiPet.dto.pet;

import com.gft.ApiPet.dto.donoPet.DonoPetMapper;
import com.gft.ApiPet.entities.DonoPet;
import com.gft.ApiPet.entities.Pet;

public class PetMapper {

    public static Pet fromDTO(RegistroPetDTO dto) {
        return new Pet(dto.getNome(), dto.getTipo(), dto.getPeso());
    }

    public static ConsultarPetDTOSemLista fromEntitySemLista(Pet pet) {
        return new ConsultarPetDTOSemLista(pet.getNomePet(), pet.getTipo(), pet.getPeso(), DonoPetMapper.fromEntityDonoSemLista(pet.getDonoPet()));
    }

    public static ConsultarPetDTO fromEntity(Pet pet) {
        return new ConsultarPetDTO(pet.getNomePet(), pet.getTipo(), pet.getPeso(), DonoPetMapper.fromEntity(pet.getDonoPet()));
    }

    public static Pet fromDTOPet(RegistroPetDTO dto, DonoPet donoPet) {
        return new Pet(dto.getNome(), dto.getTipo(), dto.getPeso(), donoPet);
    }

    public static ConsultarPetDTO fromEntityPet(Pet pet) {
        return new ConsultarPetDTO(pet.getNomePet(), pet.getTipo(), pet.getPeso(), DonoPetMapper.fromEntity(pet.getDonoPet()));
    }

}
