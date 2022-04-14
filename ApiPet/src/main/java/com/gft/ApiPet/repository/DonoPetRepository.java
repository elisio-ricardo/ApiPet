package com.gft.ApiPet.repository;

import com.gft.ApiPet.entities.DonoPet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DonoPetRepository extends JpaRepository<DonoPet, Long> {
    Page<DonoPet> findAll(Pageable pageable);
}
