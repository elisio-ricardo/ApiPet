package com.gft.ApiPet.service;


import com.gft.ApiPet.entities.Atendimento;
import com.gft.ApiPet.repository.AtendimentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public Atendimento salvarAtendimento(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Page<Atendimento> listarTodosAtendimentos(Pageable pageable) {
        return atendimentoRepository.findAll(pageable);
    }

    public Atendimento buscarAtendimento(Long id) {
        Optional<Atendimento> optional = atendimentoRepository.findById(id);

        return optional.orElseThrow(() -> new EntityNotFoundException("Atendimento não encontrado"));
    }

    public Atendimento atualizarAtendimento(Atendimento atendimento, Long id) {
        Atendimento atendimentoOriginal = this.buscarAtendimento(id);

        atendimento.setId(atendimentoOriginal.getId());

        return atendimentoRepository.save(atendimento);
    }

    public void excluirAtendimento(Long id) {
        Atendimento atendimento = this.buscarAtendimento(id);

        atendimentoRepository.delete(atendimento);
    }


}
