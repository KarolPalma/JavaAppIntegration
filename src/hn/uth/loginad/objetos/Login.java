/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.loginad.objetos;

import java.time.LocalDateTime;

/**
 *
 * @author Miriam
 */
public class Login {

    private String usuario;
    private String contrasenia;
    private boolean ingreso;
    private String error;
    private LocalDateTime fechaHora;
    private String dominio;

    public Login(String usuario, String contrasenia, boolean ingreso, String error, String dominio) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.ingreso = ingreso;
        this.error = error;
        this.fechaHora = LocalDateTime.now();
        this.dominio = dominio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

}
