/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author riamair
 */
@Entity
public class Producto extends Model {

    @Required
    public String clave;

    @Required
    public Double precio;

    @Required
    public String descripcion;

}
