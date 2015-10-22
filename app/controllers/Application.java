package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        String user = Security.connected();
        render();
    }
    
    public static void login() {
        
        System.out.println("** Todos los usuarios **");
        List<Usuario> usuarios = Usuario.findAll();
        
        for (Usuario usuario : usuarios) {
            System.out.println("usuario = " + usuario);
        }
        
        System.out.println("** Todos los usuarios con apellido Corona**");
        List<Usuario> usuariosCorona = Usuario.find("aPaterno", "Corona").fetch();
        //Fetch lo convierte en una lista y lo coloca donde va.
        
        for (Usuario usuarioCorona : usuariosCorona) {
            System.out.println("usuarioCorona = " + usuarioCorona);
        }
        
        System.out.println("** Todos los usuarios con apellido Corona y nombre Oscar Arturo**");
        usuariosCorona = Usuario.find("aPaterno = ? AND nombre = ?", "Corona", "Oscar Arturo").fetch();
        
        for (Usuario usuarioCorona : usuariosCorona) {
            System.out.println("usuarioCorona = " + usuarioCorona);
        }
        
        render();
    }
    
    public static void autenticar(String usuario, String pass){
        //en puts recibe el parametro identificador, en este caso seria usuario
        session.put("usuario", usuario);
        //prohibido meter objetos enteros aqui =)
        //renderText("US: %s Pass: %s", usuario, pass);
        index();
    }
}