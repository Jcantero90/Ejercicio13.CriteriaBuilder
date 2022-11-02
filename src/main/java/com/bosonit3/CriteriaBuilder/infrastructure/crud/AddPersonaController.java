package com.bosonit3.CriteriaBuilder.infrastructure.crud;

import com.bosonit3.CriteriaBuilder.application.PersonaServiceImpl;
import com.bosonit3.CriteriaBuilder.infrastructure.inputPersonaDto.InputPersonaDto;
import com.bosonit3.CriteriaBuilder.infrastructure.outPutPersonaDto.OutPutPersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AddPersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping("/addPersona")
    public OutPutPersonaDto addPersona (@RequestBody InputPersonaDto inputPersonaDto){
        return personaService.addPersona(inputPersonaDto);
    }
}
