package com.bosonit3.CriteriaBuilder.infrastructure.inputPersonaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputPersonaDto {

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

}
