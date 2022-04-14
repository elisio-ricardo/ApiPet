//package com.gft.ApiPet.controller;
//
//
//import com.gft.ApiPet.dto.atendimento.AtendimendoMapper;
//import com.gft.ApiPet.dto.atendimento.ConsultarAtendimentoDTO;
//import com.gft.ApiPet.dto.atendimento.RegistroAtendimentoDTO;
//import com.gft.ApiPet.entities.Atendimento;
//import com.gft.ApiPet.service.AtendimentoService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
////@RestController
////@RequestMapping("v1/atendimentos")
//public class AtendimentoController {
//
//    public final AtendimentoService atendimentoService;
//
//    public AtendimentoController(AtendimentoService atendimentoService) {
//        this.atendimentoService = atendimentoService;
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<ConsultarAtendimentoDTO>> listarTodosAtendimentos(@PageableDefault Pageable pageable) {
//        return ResponseEntity.ok(atendimentoService.listarTodosAtendimentos(pageable).map(AtendimendoMapper::fromEntity));
//    }
//
//    @PostMapping
//    public ResponseEntity<ConsultarAtendimentoDTO> salvarAtendimento(@RequestBody RegistroAtendimentoDTO dto) {
//        Atendimento atendimento = atendimentoService.salvarAtendimento(AtendimendoMapper.fromDTO(dto));
//
//        return ResponseEntity.ok(AtendimendoMapper.fromEntity(atendimento));
//    }
//
//    @GetMapping("{id}") //localhost:8080/v1/atendimento/1
//    public ResponseEntity<ConsultarAtendimentoDTO> buscarAtendimento(@PathVariable Long id) {
//        Atendimento atendimento = atendimentoService.buscarAtendimento(id);
//        return ResponseEntity.ok(AtendimendoMapper.fromEntity(atendimento));
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<ConsultarAtendimentoDTO> alterarAtendimento(@RequestBody RegistroAtendimentoDTO dto,
//                                                                      @PathVariable Long id) {
//        try {
//            Atendimento atendimento = atendimentoService.atualizarAtendimento(AtendimendoMapper.fromDTO(dto), id);
//            return ResponseEntity.ok(AtendimendoMapper.fromEntity(atendimento));
//        } catch (RuntimeException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<ConsultarAtendimentoDTO> deletarAtendimento(@PathVariable Long id) {
//
//        try {
//            atendimentoService.excluirAtendimento(id);
//            return ResponseEntity.ok().build();
//        } catch (RuntimeException ex) {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//}
