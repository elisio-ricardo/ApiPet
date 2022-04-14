package com.gft.ApiPet.service;

import com.gft.ApiPet.entities.DonoPet;
import com.gft.ApiPet.repository.DonoPetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DonoPetService {

    private final DonoPetRepository donoPetRepository;

    public DonoPetService(DonoPetRepository donoPetRepository) {
        this.donoPetRepository = donoPetRepository;
    }

    public DonoPet salvarCliente(DonoPet donoPet) {
        return donoPetRepository.save(donoPet);
    }

    public Page<DonoPet> listarTodosDonosPets(Pageable pageable) {
        return donoPetRepository.findAll(pageable);
    }

    public DonoPet buscarDonoPet(Long id) {
        Optional<DonoPet> optional = donoPetRepository.findById(id);

        return optional.orElseThrow(() -> new EntityNotFoundException("Dono Pet não encontrado"));
    }

    public DonoPet atualizarDonoPet(DonoPet donoPet, Long id) {
        DonoPet donoPetOriginal = this.buscarDonoPet(id);
        donoPet.setId(donoPetOriginal.getId());

        return donoPetRepository.save(donoPet);
    }

    public void excluirDonoPet(Long id) {
        DonoPet donoPet = this.buscarDonoPet(id);

        donoPetRepository.delete(donoPet);
    }


}
