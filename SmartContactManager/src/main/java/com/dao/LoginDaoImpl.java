package com.dao;

import com.model.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {

        private SessionFactory sessionFactory;

    @Autowired
    public LoginDaoImpl(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

    @Override
    @Transactional
    public List<Login> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Login> userQuery = session.createQuery("from Login", Login.class);
        List<Login> logins = userQuery.getResultList();
        return logins == null ? new ArrayList<Login>() : logins;
    }

    @Override
    @Transactional
    public Login get(String name) {
        Session session=sessionFactory.getCurrentSession();
        Login login=session.get(Login.class,name);
        return login;
    }
    @Override
    @Transactional
    public void update(Login login) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(login);
    }
}
