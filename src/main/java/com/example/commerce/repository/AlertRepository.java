package com.example.commerce.repository;

import com.example.commerce.domain.Alert;
import com.example.commerce.domain.Member;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class AlertRepository {

    private final EntityManager em;

    public AlertRepository(EntityManager em){
        this.em = em;
    }

    public Alert save(Alert alert) {
        em.persist(alert);
        return alert;
    }


    public List<Alert> findAll() {

        List<Alert> alerts = em.createQuery("select m from Alert m" , Alert.class)
                .getResultList();

        for(int i = 0; i < alerts.size();i++){
            System.out.println(alerts.get(i).getAppid());
            System.out.println(alerts.get(i).getHostname());
            System.out.println(alerts.get(i).getFile());
            System.out.println(alerts.get(i).getTimestamp());
            System.out.println(alerts.get(i).getChangeprocess());
        }


        return alerts ;
    }


    @Transactional
    public void updataAck(Long id){

        Alert alert = em.find(Alert.class, id);

        if("Y".equals(alert.getAckstatus())){
            alert.setAckstatus("N");
        }else{
            alert.setAckstatus("Y");
        }


    }

    public List<Alert> findAlertByAppId(String appid) {

        List<Alert> alerts = em.createQuery("select m from Alert m where m.appid = :appid" , Alert.class)
                .setParameter("appid", appid)
                .getResultList();

        for(int i = 0; i < alerts.size();i++){
            System.out.println(alerts.get(i).getAppid());
            System.out.println(alerts.get(i).getHostname());
            System.out.println(alerts.get(i).getFile());
            System.out.println(alerts.get(i).getTimestamp());
            System.out.println(alerts.get(i).getChangeprocess());
        }


        return alerts ;
    }

}
