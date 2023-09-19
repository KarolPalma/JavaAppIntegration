/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.loginad.autenticacion;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.*;
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;

/**
 *
 * @author Miriam
 */
public class ADConexion {

    public static boolean login(String username, String password, String domain) throws Exception {

        Hashtable env = new Hashtable();
        String[] dc = domain.split("\\.");

        if (dc.length == 2) {
            try {

                env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

                env.put(Context.PROVIDER_URL, "ldap://" + domain + ":389/DC=" + dc[0] + ",DC=" + dc[1]); //DC: Componentes de Dominio.

                env.put(Context.SECURITY_AUTHENTICATION, "simple");

                env.put(Context.SECURITY_PRINCIPAL, username + "@" + domain);

                env.put(Context.SECURITY_CREDENTIALS, password);

            } catch (Exception e) {
                throw new Exception("No se ha ingresado un servidor valido");
            }
        } else {
            throw new Exception("No se ha ingresado un servidor valido");
        }

        try {

            DirContext ctx = new InitialDirContext(env);

            return true;

        } catch (AuthenticationNotSupportedException ex) {
            throw new Exception("Autenticación inválida para este servidor");
        } catch (AuthenticationException ex) {
            if (ex.toString().contains("data 52e")) {
                throw new Exception("Clave o usuario incorrectos");
            } else {
                throw new Exception("Clave caducada, por favor ingrese a su cuenta y cambiela");
            }
        } catch (NamingException ex) {
            throw new Exception("Servidor no encontrado");
        }

    }

}
