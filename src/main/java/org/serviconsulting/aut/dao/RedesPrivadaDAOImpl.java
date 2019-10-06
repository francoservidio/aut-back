package org.serviconsulting.aut.dao;

import com.jcraft.jsch.*;
import org.serviconsulting.aut.model.Dispositivo;
import org.serviconsulting.aut.model.RedesPrivada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

@Service
@Transactional
public class RedesPrivadaDAOImpl implements RedesPrivadaDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    DispositivoDAO dispositivoDAO;

    @Override
    public void createRedesPrivada(RedesPrivada redesPrivada) {
        entityManager.persist(redesPrivada);
        entityManager.flush();
    }

    @Override
    public RedesPrivada getRedesPrivadaById(Long id) {
        return entityManager.find(RedesPrivada.class, id);
    }

    @Override
    public List<RedesPrivada> getAllRedesPrivada() {
        return entityManager.createQuery("select red from RedesPrivada red").getResultList();
    }

    @Override
    public RedesPrivada updateRedesPrivada(RedesPrivada redesPrivada) {
        entityManager.merge(redesPrivada);
        return redesPrivada;
    }

    @Override
    public void deleteRedesPrivada(Long id) {
        RedesPrivada redesPrivada = entityManager.find(RedesPrivada.class, id);
        entityManager.remove(redesPrivada);
    }

    @Override
    public void connectToDevices(List<Long> devices, Long id){
        //RedesPrivada redesPrivada = entityManager.find(RedesPrivada.class, id);
        //Dispositivo dis = entityManager.find(Dispositivo.class, devices.get(0));
        //String ipDispositivo = dis.getIp();

        String host="10.20.200.23";
        String user="admin_fservidio";
        String password="";


        try{

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");

            Channel channel = session.openChannel("shell");
            OutputStream ops = channel.getOutputStream();
            PrintStream ps = new PrintStream(ops, true);

            channel.connect();
            ps.println("configure terminal");
            ps.println("vlan 3800");
            ps.println("name sarasa");
            //give commands to be executed inside println.and can have any no of commands sent.
            ps.close();

            InputStream in=channel.getInputStream();
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }

            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
