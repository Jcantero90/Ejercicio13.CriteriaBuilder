package com.bosonit3.CriteriaBuilder.infrastructure.crud;

import com.bosonit3.CriteriaBuilder.application.PersonaServiceImpl;
import com.bosonit3.CriteriaBuilder.domain.Persona;
import com.bosonit3.CriteriaBuilder.domain.PersonaPage;
import com.bosonit3.CriteriaBuilder.domain.PersonaSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personaCriteriaController {

    private final PersonaServiceImpl personaService;


    public personaCriteriaController(PersonaServiceImpl personaService) {
        this.personaService = personaService;
    }

    @GetMapping ("/personaCriteria")
    public ResponseEntity<Page<Persona>> getPersona(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria){
        return new ResponseEntity<Page<Persona>>(personaService.getPersona(personaPage, personaSearchCriteria), HttpStatus.OK);
    }

    @PostMapping("/personaCriteriaPost")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.addPersona(persona), HttpStatus.OK);
    }
}
