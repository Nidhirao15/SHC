package com.simplilearn.hibernate.dao;

import com.simplilearn.hibernate.entity.ProductDetails;
import com.simplilearn.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductDetailsDao {

    public List<ProductDetails> getProductDetails(String productname){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        List<ProductDetails> productDetailsList = null;

        try{
            productDetailsList =  session.createQuery("from ProductDetails where name = '"+ productname +"'", ProductDetails.class).list();

        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
        return productDetailsList;
    }
}
