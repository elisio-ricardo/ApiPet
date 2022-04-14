package com.gft.ApiPet.dto.atendimento;

import com.gft.ApiPet.entities.Atendimento;

public class AtendimendoMapper {

    public static Atendimento fromDTO(RegistroAtendimentoDTO dto) {
        return new Atendimento(null, dto.getProduto(), dto.getPreco(), dto.getDonoPet());
    }

    public static ConsultarAtendimentoDTO fromEntity(Atendimento aten) {
        return new ConsultarAtendimentoDTO(aten.getId(), aten.getProduto(), aten.getPreco(), aten.getDonoPet());
    }
}
