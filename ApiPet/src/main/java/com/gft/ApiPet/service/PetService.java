package com.gft.ApiPet.service;


import com.gft.ApiPet.entities.Pet;
import com.gft.ApiPet.repository.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet salvarPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> buscarListaDono(Long id) {
        List<Pet> pets = petRepository.findBydonoPet(id);
        return pets;
    }

    public Page<Pet> listarTodosPets(Pageable pageable) {
        return petRepository.findAll(pageable);
    }

    public Pet buscarPet(Long id) {
        Optional<Pet> optional = petRepository.findById(id);

        return optional.orElseThrow(() -> new EntityNotFoundException("Pet não encontrado"));
    }

    public Pet atualizarPet(Pet pet, Long id) {
        Pet petOriginal = this.buscarPet(id);
        pet.setId(petOriginal.getId());

        return petRepository.save(pet);
    }

    public void excluirPet(Long id) {
        Pet pet = this.buscarPet(id);

        petRepository.delete(pet);
    }
}
