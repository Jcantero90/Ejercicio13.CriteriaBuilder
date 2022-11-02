package com.bosonit3.CriteriaBuilder.domain;

import com.bosonit3.CriteriaBuilder.infrastructure.inputPersonaDto.InputPersonaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;

    @Column(nullable = false)
    private String usuario;
    private String password;
    private String name;
    private String supername;
    private String company_Email;
    private String city;
    @Column(nullable = false)
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public boolean getActive() {
        return true;
    }

    public Persona(InputPersonaDto inputPersonaDto) {
        setUsuario(inputPersonaDto.getUsuario());
        setPassword(inputPersonaDto.getPassword());
        setName(inputPersonaDto.getName());
        setSupername(inputPersonaDto.getSupername());
        setCompany_Email(inputPersonaDto.getCompany_Email());
        setCity(inputPersonaDto.getCity());
        setActive(inputPersonaDto.getActive());
        setCreated_date(inputPersonaDto.getCreated_date());
        setImagen_url(inputPersonaDto.getImagen_url());
        setTermination_date(inputPersonaDto.getTermination_date());
    }

}
