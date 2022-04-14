package com.gft.ApiPet.controller;

import com.gft.ApiPet.dto.donoPet.DonoPetMapper;
import com.gft.ApiPet.dto.pet.ConsultarPetDTO;
import com.gft.ApiPet.dto.pet.ConsultarPetDTOSemLista;
import com.gft.ApiPet.dto.pet.PetMapper;
import com.gft.ApiPet.dto.pet.RegistroPetDTO;
import com.gft.ApiPet.entities.DonoPet;
import com.gft.ApiPet.entities.Pet;
import com.gft.ApiPet.service.DonoPetService;
import com.gft.ApiPet.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna o Pet"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
})
@RestController
@RequestMapping("v1/pets")
@Api(tags = "Pet")
public class PetController {

    public final PetService petService;
    public final DonoPetService donoPetService;

    public PetController(PetService petService, DonoPetService donoPetService) {
        this.petService = petService;
        this.donoPetService = donoPetService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultarPetDTOSemLista>> listarTodosOSPets(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(petService.listarTodosPets(pageable).map(PetMapper::fromEntitySemLista));
    }

    @PostMapping
    public ResponseEntity<ConsultarPetDTOSemLista> salvarPet(@RequestBody RegistroPetDTO dto) {

        DonoPet donoPet = donoPetService.buscarDonoPet(dto.getDonoId());


        Pet pet = petService.salvarPet(PetMapper.fromDTOPet(dto, donoPet));
        return ResponseEntity.ok(PetMapper.fromEntitySemLista(pet));
    }

    @GetMapping("{id}")//localhost:8080/v1/pets/1
    public ResponseEntity<ConsultarPetDTOSemLista> buscarPet(@PathVariable Long id) {
        Pet pet = petService.buscarPet(id);
        return ResponseEntity.ok(PetMapper.fromEntitySemLista(pet));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultarPetDTO> alterarPet(@RequestBody RegistroPetDTO dto, @PathVariable Long id) {
        try {
            Pet pet = petService.atualizarPet(PetMapper.fromDTO(dto), id);
            return ResponseEntity.ok(PetMapper.fromEntity(pet));

        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultarPetDTO> deletarPet(@PathVariable Long id) {
        try {
            petService.excluirPet(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
