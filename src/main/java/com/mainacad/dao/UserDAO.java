package com.mainacad.dao;

import com.mainacad.factory.HibernateFactory;
import com.mainacad.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO extends BaseDAO<User>{

    public List<User> findAll(){
        Session session = super.sessionFactory.openSession();
        session.getTransaction().begin();

        String sql = "SELECT * FROM users";
        List<User> result = session.createNativeQuery(sql).getResultList();

        session.close();
        return result;
    }



}
