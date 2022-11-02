package com.bosonit3.CriteriaBuilder.application;

import com.bosonit3.CriteriaBuilder.domain.Persona;
import com.bosonit3.CriteriaBuilder.domain.PersonaPage;
import com.bosonit3.CriteriaBuilder.domain.PersonaSearchCriteria;
import com.bosonit3.CriteriaBuilder.infrastructure.inputPersonaDto.InputPersonaDto;
import com.bosonit3.CriteriaBuilder.infrastructure.outPutPersonaDto.OutPutPersonaDto;
import com.bosonit3.CriteriaBuilder.infrastructure.repository.PersonaCriteriaRepository;
import com.bosonit3.CriteriaBuilder.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    //Services del criteria builder
    private final PersonaRepository personaRepositoryCriteriaBuilder;
    private final PersonaCriteriaRepository personaCriteriaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepositoryCriteriaBuilder, PersonaCriteriaRepository personaCriteriaRepository) {
        this.personaRepositoryCriteriaBuilder = personaRepositoryCriteriaBuilder;
        this.personaCriteriaRepository = personaCriteriaRepository;
    }


    public Page<Persona> getPersona(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria){
        return personaCriteriaRepository.FindAllWithfilters(personaPage, personaSearchCriteria);
    }

    public Persona addPersona(Persona persona){
    return personaRepository.save(persona);
    }
    //Services del CRUD.
    public OutPutPersonaDto addPersona(InputPersonaDto inputPersonaDto){
        Persona persona = new Persona(inputPersonaDto);
        personaRepository.save(persona);
        return new OutPutPersonaDto(persona);
    }

    public OutPutPersonaDto findByIdPersona (Integer id_persona){
        Optional<Persona> personaReporitory = personaRepository.findById(id_persona);
        Persona persona = personaReporitory.get();
        return new OutPutPersonaDto(persona);
    }

    public String deletePersonById (Integer id_persona){
        personaRepository.deleteById(id_persona);
        return "persona borrada";
    }

    public OutPutPersonaDto updatePersona (Integer id_persona, Persona persona){
        Optional<Persona> updatePer = personaRepository.findById(id_persona);
        Persona p1 = updatePer.get();
        persona.setUsuario(persona.getUsuario());
        p1.setPassword(persona.getPassword());
        p1.setName(persona.getName());
        p1.setSupername(persona.getSupername());
        p1.setCompany_Email(persona.getCompany_Email());
        p1.setCity(persona.getCity());
        p1.setActive(persona.getActive());
        p1.setCreated_date(persona.getCreated_date());
        p1.setImagen_url(persona.getImagen_url());
        p1.setTermination_date(persona.getTermination_date());
        personaRepository.save(p1);
        return new OutPutPersonaDto(p1);
    }
}
