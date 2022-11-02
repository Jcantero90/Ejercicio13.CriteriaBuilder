package com.bosonit3.CriteriaBuilder.infrastructure.crud;

import com.bosonit3.CriteriaBuilder.application.PersonaServiceImpl;
import com.bosonit3.CriteriaBuilder.domain.Persona;
import com.bosonit3.CriteriaBuilder.infrastructure.outPutPersonaDto.OutPutPersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UpdatePersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @PutMapping("/updatePersona/{id}")
    public OutPutPersonaDto updatePersona (@PathVariable("id") Integer id_persona, @RequestBody Persona persona){
        return personaService.updatePersona(id_persona, persona);
    }

}
