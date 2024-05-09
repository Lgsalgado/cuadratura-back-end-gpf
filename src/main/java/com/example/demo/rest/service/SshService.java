package com.example.demo.rest.service;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


@Service
public class SshService {
    private  JdbcTemplate jdbcTemplate;
    @Autowired
    public void DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Value("${ssh.host}")
    private String sshHost;

    @Value("${ssh.port}")
    private int sshPort;

    @Value("${ssh.username}")
    private String sshUsername;

    @Value("${ssh.private-key-path}")
    private String privateKeyResource;


    private Session session;

    @PostConstruct
    public void establishSshConnection() {
        JSch jsch = new JSch();
        try {
            // Cargar la clave privada desde el archivo
            File privateKeyFile = new File(privateKeyResource);
            jsch.addIdentity(privateKeyFile.getAbsolutePath());

            // Configurar la sesión
            session = jsch.getSession(sshUsername, sshHost, sshPort);

            // Desactivar la verificación de clave del host (por razones de demostración)
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            // Establecer la conexión
            session.connect();
            System.out.println("Conectado");


        } catch (JSchException e) {
            // Agregar registros adicionales para ayudar a diagnosticar el problema
            System.err.println("Error estableciendo la conexión SSH:");
            System.err.println("Ruta de la clave privada: " + privateKeyResource);
            System.err.println("Host: " + sshHost);
            System.err.println("Puerto: " + sshPort);
            System.err.println("Nombre de usuario: " + sshUsername);
            e.printStackTrace(); // Maneja las excepciones de manera adecuada
        }
    }


    // Agrega métodos para realizar operaciones SSH según sea necesario
    public String executeRemoteCommand(String command) {
        try {
            // Abrir un canal SSH
            Channel channel = session.openChannel("exec");

            // Configurar el comando a ejecutar
            ((ChannelExec) channel).setCommand(command);

            // Conectar el canal
            channel.connect();

            // Leer la salida del comando
            InputStream in = channel.getInputStream();
            byte[] buffer = new byte[1024];
            StringBuilder result = new StringBuilder();

            while (true) {
                int bytesRead = in.read(buffer);
                if (bytesRead == -1) {
                    break;
                }
                result.append(new String(buffer, 0, bytesRead));
            }

            // Desconectar el canal
            channel.disconnect();

            return "mensaje "+result.toString();
        } catch (JSchException | IOException e) {
            // Manejar excepciones
            e.printStackTrace();
            return "Error al ejecutar el comando remoto: " + e.getMessage();
        }
    }

    // Método para cerrar la conexión al finalizar
    public void closeSshConnection() {
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }
}