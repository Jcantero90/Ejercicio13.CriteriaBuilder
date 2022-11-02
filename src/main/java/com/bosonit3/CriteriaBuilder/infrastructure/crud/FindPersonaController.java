package com.bosonit3.CriteriaBuilder.infrastructure.crud;

import com.bosonit3.CriteriaBuilder.application.PersonaServiceImpl;
import com.bosonit3.CriteriaBuilder.infrastructure.outPutPersonaDto.OutPutPersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class FindPersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/getPersona/{id}")
    public OutPutPersonaDto findPersona (@PathVariable("id") Integer id_persona){
        return personaService.findByIdPersona(id_persona);
    }

}
