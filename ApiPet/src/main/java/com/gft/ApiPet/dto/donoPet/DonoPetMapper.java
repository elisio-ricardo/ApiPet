package com.gft.ApiPet.dto.donoPet;

import com.gft.ApiPet.dto.pet.PetMapper;
import com.gft.ApiPet.entities.DonoPet;

import java.util.stream.Collectors;

public class DonoPetMapper {

    public static DonoPet fromDTO(RegistroDonoPetDTO dto) {
        return new DonoPet(null, dto.getNome(), dto.getCpf(), dto.getPet().stream().map(PetMapper::fromDTO).collect(Collectors.toList()));
    }

    public static ConsultarDonoPetDTO fromEntity(DonoPet donoPet) {
        return new ConsultarDonoPetDTO(donoPet.getId(), donoPet.getNome(), donoPet.getCpf(), donoPet.getPet().stream().map(PetMapper::fromEntity).collect(Collectors.toList()));
    }

    public static ConsultarDonoPetDTOSemLista fromEntityDonoSemLista(DonoPet donoPet) {
        return new ConsultarDonoPetDTOSemLista(donoPet.getId(), donoPet.getNome(), donoPet.getCpf());
    }


}
