package com.bosonit3.CriteriaBuilder.application;

import com.bosonit3.CriteriaBuilder.domain.Persona;
import com.bosonit3.CriteriaBuilder.infrastructure.inputPersonaDto.InputPersonaDto;
import com.bosonit3.CriteriaBuilder.infrastructure.outPutPersonaDto.OutPutPersonaDto;

public interface PersonaService {

    public OutPutPersonaDto addPersona(InputPersonaDto inputPersonaDto);

    public OutPutPersonaDto findByIdPersona (Integer id_persona);

    public String deletePersonById (Integer id_persona);

    public OutPutPersonaDto updatePersona (Integer id_persona, Persona persona);

}
