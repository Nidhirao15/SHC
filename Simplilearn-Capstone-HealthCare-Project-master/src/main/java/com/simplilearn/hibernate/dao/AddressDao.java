package com.simplilearn.hibernate.dao;

import com.simplilearn.hibernate.entity.AddressDetails;
import com.simplilearn.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AddressDao {

    public List<AddressDetails> getAddressDetails(int userId){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        List<AddressDetails> addressDetailsList = null;

        try{
            addressDetailsList =  session.createQuery("from AddressDetails where userId = '"+ userId +"'", AddressDetails.class).list();

        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
        return addressDetailsList;
    }
}
