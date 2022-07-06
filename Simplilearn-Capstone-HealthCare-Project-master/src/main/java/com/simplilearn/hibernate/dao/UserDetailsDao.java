package com.simplilearn.hibernate.dao;

import com.simplilearn.hibernate.entity.UserDetails;
import com.simplilearn.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class UserDetailsDao {

    public List<UserDetails> getUserDetails(String firstname){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        List<UserDetails> userDetailsList=null;

        try{
            userDetailsList =  session.createQuery("from UserDetails where first_name = '"+firstname +"'", UserDetails.class).list();

        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
        return userDetailsList;
    }

    public static void main(String[] args) {
        UserDetailsDao userDetailsDao = new UserDetailsDao();

        List<UserDetails> userDetails = userDetailsDao.getUserDetails("Kavita");
        userDetails.forEach(user -> System.out.println(user.getEmail()));
    }
}
