package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.RedesPrivada;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.List;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Service
@Transactional
public class RedesPrivadaDAOImpl implements RedesPrivadaDAO{
    @PersistenceContext
    private EntityManager entityManager;

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
    public void connectToDevices(List<Long> devices, RedesPrivada redPrivada){
        String host="10.20.200.23";
        String user="admin_fservidio";
        String password="tuvieja";

        try{

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand("show running-config");
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();
            channel.connect();
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
