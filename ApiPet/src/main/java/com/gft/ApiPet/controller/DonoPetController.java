package com.gft.ApiPet.controller;

import com.gft.ApiPet.dto.donoPet.ConsultarDonoPetDTO;
import com.gft.ApiPet.dto.donoPet.DonoPetMapper;
import com.gft.ApiPet.dto.donoPet.RegistroDonoPetDTO;
import com.gft.ApiPet.entities.DonoPet;
import com.gft.ApiPet.service.DonoPetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de Donos de pets e seus pets"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
})
@RestController
@RequestMapping("v1/donopets")
@Api(tags = "DonoPet")
public class DonoPetController {

    public final DonoPetService donoPetService;

    public DonoPetController(DonoPetService donoPetService) {
        this.donoPetService = donoPetService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultarDonoPetDTO>> listarTodosOsDonosPet(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(donoPetService.listarTodosDonosPets(pageable).map(DonoPetMapper::fromEntity));
    }

    @PostMapping
    public ResponseEntity<DonoPet> salvarDonoPet(@Valid @RequestBody RegistroDonoPetDTO dto) {
        DonoPet donoPet = donoPetService.salvarCliente(DonoPetMapper.fromDTO(dto));

        return ResponseEntity.ok(donoPet);
    }

    @GetMapping("{id}") //localhost:8080/v1/donopets/1
    public ResponseEntity<ConsultarDonoPetDTO> buscarDonoPet(@PathVariable Long id) {
        DonoPet donoPet = donoPetService.buscarDonoPet(id);
        return ResponseEntity.ok(DonoPetMapper.fromEntity(donoPet));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultarDonoPetDTO> alterarDonoPet(@RequestBody RegistroDonoPetDTO dto, @PathVariable Long id) {
        try {
            DonoPet donoPet = donoPetService.atualizarDonoPet(DonoPetMapper.fromDTO(dto), id);
            return ResponseEntity.ok(DonoPetMapper.fromEntity(donoPet));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultarDonoPetDTO> deletarDonoPet(@PathVariable Long id) {
        try {
            donoPetService.excluirDonoPet(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
