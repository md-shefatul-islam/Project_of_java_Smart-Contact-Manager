package com.dao;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

        private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        @Transactional
        public List<User> getAll() {
            Session session = sessionFactory.getCurrentSession();
            Query<User> userQuery = session.createQuery("from User", User.class);
            List<User> users = userQuery.getResultList();
            return users == null ? new ArrayList<User>() : users;
        }


        @Override
        @Transactional
        public User getById(int id) {
            Session session=sessionFactory.getCurrentSession();
            User user=session.get(User.class,id);
            return user;
        }
    @Override
    @Transactional
    public User get(String name) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,name);
        return user;
    }

        @Override
        @Transactional
        public void create(User user) {
            Session session=sessionFactory.getCurrentSession();
            session.save(user);
        }
    @Override
    @Transactional
    public void update(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.update(user);
    }

        @Override
        @Transactional
        public void delete(int id) {
            Session session=sessionFactory.getCurrentSession();
            User user=session.byId(User.class).load(id);
            session.delete(user);
        }
}
