package com.bosonit3.CriteriaBuilder.infrastructure.crud;

import com.bosonit3.CriteriaBuilder.application.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DeletePersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @DeleteMapping("/deletePersona/{id}")
    public String deletePersona(@PathVariable("id") Integer id_persona){
        return personaService.deletePersonById(id_persona);
    }
}
