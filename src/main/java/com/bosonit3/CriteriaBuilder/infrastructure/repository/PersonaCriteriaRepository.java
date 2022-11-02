package com.bosonit3.CriteriaBuilder.infrastructure.repository;

import com.bosonit3.CriteriaBuilder.domain.Persona;
import com.bosonit3.CriteriaBuilder.domain.PersonaPage;
import com.bosonit3.CriteriaBuilder.domain.PersonaSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonaCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public PersonaCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Persona> FindAllWithfilters(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria){
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);
        Predicate predicate = getPredicate(personaSearchCriteria, personaRoot);
        criteriaQuery.where(predicate);
        setOrder(personaPage, criteriaQuery, personaRoot);

        TypedQuery<Persona> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(personaPage.getPageNumber() * personaPage.getPageSize());
        typedQuery.setMaxResults(personaPage.getPageSize());

        Pageable pageable = getPageable(personaPage);

        long personaCount = getPersonaCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, personaCount);
    }

    private long getPersonaCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Persona> countRoot = countQuery.from(Persona.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(PersonaPage personaPage){
        Sort sort = Sort.by(personaPage.getSortDirection(), personaPage.getSortBy());
        return PageRequest.of(personaPage.getPageNumber(), personaPage.getPageSize(), sort);
    }

    //Aquí debemos de añadir los valores de busqueda. Solo he puesto usuario para probar la aplicación.
    //TODO añadir el resto de valores de busqueda.
    private Predicate getPredicate(PersonaSearchCriteria personaSearchCriteria, Root<Persona> personaRoot){
     List<Predicate> predicates = new ArrayList<>();
     if(Objects.nonNull(personaSearchCriteria.getUsuario())){
         predicates.add(criteriaBuilder.like(personaRoot.get("usuario"), "%" + personaSearchCriteria.getUsuario()));
     }
        if(Objects.nonNull(personaSearchCriteria.getUsuario())){
            predicates.add(criteriaBuilder.like(personaRoot.get("name"), "%" + personaSearchCriteria.getName()));
        }
        if(Objects.nonNull(personaSearchCriteria.getUsuario())){
            predicates.add(criteriaBuilder.like(personaRoot.get("supername"), "%" + personaSearchCriteria.getSupername()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(PersonaPage personaPage, CriteriaQuery<Persona> criteriaQuery, Root<Persona> personaRoot){
       if(personaPage.getSortDirection().equals(Sort.Direction.ASC)){
        criteriaQuery.orderBy(criteriaBuilder.asc(personaRoot.get(personaPage.getSortBy())));
       } else {
           criteriaQuery.orderBy(criteriaBuilder.desc(personaRoot.get(personaPage.getSortBy())));
       }
    }
}
