/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Entity;
import play.data.validation.*;
import play.db.jpa.Model;

/**
 *
 * @author riamair
 */
@Entity
public class Usuario extends Model {

    @Required
    @MaxSize(10)
    public String usuario;
    
    @Required
    @Email
    public String email;
    
    @Required
    @Password
    public String password;
    
    public String nombre;
    public String aPaterno;
    public String aMaterno;
    
    @InPast
    public Date fechaNacimiento;

    @Override
    public String toString() {
        return String.format("%s %s %s", this.nombre, this.aPaterno,
                this.aMaterno);
    }
}
