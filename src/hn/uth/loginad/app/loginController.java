/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.loginad.app;

import hn.uth.loginad.objetos.Login;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Miriam
 */
public class loginController {

    public static void guardarLogin(Login log) {
        String mensajeIngreso = "";
        if (log.isIngreso()) {
            mensajeIngreso = "Ingreso exitoso";
            log.setError("");
        } else {
            mensajeIngreso = "Ingreso fallido";
        }

        Random random = new Random();
        char[] claveCaracteres = log.getContrasenia().toCharArray();
        String claveCensurada = "";
        for (int i = 0; i < claveCaracteres.length; i++) {
            claveCensurada = claveCensurada + (random.nextInt(10));
        }

        String[] fechaHoraIngreso = log.getFechaHora().toString().split("T");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("ingreso", new String[]{mensajeIngreso, log.getError()});
        data.put("fechaHora", fechaHoraIngreso[0] + ", " + fechaHoraIngreso[1]);
        data.put("contrasenia", claveCensurada);
        data.put("usuario", log.getUsuario());
        data.put("dominio", log.getDominio());
        data.put("-- -- -- -- -- -- -- -- -- ", " -- -- -- -- -- -- -- -- --");
        Yaml yaml = new Yaml();
        FileWriter writer = null;
        try {
          //writer = new FileWriter("C:\\Users\\miria\\Documents\\NetBeansProjects\\ADConexion\\src\\documentos\\logins.yaml", true);
            writer = new FileWriter("Z:\\ADConexion\\src\\documentos\\logins.yaml", true);
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo");
        }
        yaml.dump(data, writer);
    }

}
