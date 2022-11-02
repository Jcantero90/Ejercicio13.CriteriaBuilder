package com.bosonit3.CriteriaBuilder.infrastructure.outPutPersonaDto;

import com.bosonit3.CriteriaBuilder.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPutPersonaDto {

    private String usuario;
    private String password;
    private String name;
    private String supername;
    private String company_Email;
    private String city;

    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public OutPutPersonaDto(Persona persona){
        this.usuario=persona.getUsuario();
        this.password=persona.getPassword();
        this.supername=persona.getSupername();
        this.company_Email=persona.getCompany_Email();
        this.city=persona.getCity();
        this.created_date=persona.getCreated_date();
        this.imagen_url=persona.getImagen_url();
        this.termination_date=persona.getTermination_date();
        this.active=persona.getActive();
    }

}