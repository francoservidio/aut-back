package org.serviconsulting.aut.dao;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Service;
import org.serviconsulting.aut.model.Dispositivo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

@Service
@Transactional
public class DispositivoDAOImpl implements DispositivoDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createDispositivo(Dispositivo dispositivo) {
        entityManager.persist(dispositivo);
        entityManager.flush();
        //backupDevices(dispositivo.getIp());
        //logsDevices(dispositivo.getIp());

    }

    @Override
    public Dispositivo getDispositivoById(Long id) {
        return entityManager.find(Dispositivo.class, id);
    }

    @Override
    public List<Dispositivo> getAllDispositivos() {
        List<Dispositivo> dispositivos = entityManager.createQuery("select dis from Dispositivo dis").getResultList();
        for (Dispositivo d: dispositivos) {
            d.setStatus(this.isReachable(d.getIp()));
        }
        return dispositivos;
    }

    @Override
    public Dispositivo updateDispositivo(Dispositivo dispositivo) {
        entityManager.merge(dispositivo);
        //backupDevices(dispositivo.getIp());
        //logsDevices(dispositivo.getIp());
        return dispositivo;
    }

    @Override
    public void deleteDispositivo(Long id) {
        Dispositivo dispositivo = entityManager.find(Dispositivo.class, id);
        entityManager.remove(dispositivo);
    }
    @Override
    public void backupDevices(String host) {

        String user="admin_fservidio";
        String password="Barcelona.12";

        try {

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");


            ChannelExec channel=(ChannelExec) session.openChannel("exec");
            BufferedReader in=new BufferedReader(new InputStreamReader(channel.getInputStream()));
            channel.setCommand("show running\n");
            channel.connect();
            PrintStream fileStream = new PrintStream(host +".txt");
            System.setOut(fileStream);
            String msg=null;
            while((msg=in.readLine())!=null){
                System.out.println(msg);
            }

            channel.disconnect();
            session.disconnect();

            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public boolean isReachable( String host) {
        int openPort = 22;
        int timeOutMillis = 500;
        try {
            try (Socket soc = new Socket()) {
                soc.connect(new InetSocketAddress(host, openPort), timeOutMillis);
            }
            System.out.println("funciona");
            return true;
        } catch (IOException ex) {
            System.out.println("no funciona");
            return false;

        }
    }

    @Override
    public void logsDevices(String host) {
        //http-server -p 8081

        String user="admin_fservidio";
        String password="Barcelona.12";

        try {

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");


            ChannelExec channel=(ChannelExec) session.openChannel("exec");
            BufferedReader in=new BufferedReader(new InputStreamReader(channel.getInputStream()));
            channel.setCommand("show logging\n");
            channel.connect();
            PrintStream fileStream = new PrintStream(host + "log.txt");
            System.setOut(fileStream);
            String msg=null;
            while((msg=in.readLine())!=null){
                System.out.println(msg);
            }

            channel.disconnect();
            session.disconnect();

            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
