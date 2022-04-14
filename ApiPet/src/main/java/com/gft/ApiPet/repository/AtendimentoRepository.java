package com.gft.ApiPet.repository;

import com.gft.ApiPet.entities.Atendimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    Page<Atendimento> findAll(Pageable pageable);
}
