package com.dao;

import com.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

        private SessionFactory sessionFactory;

    @Autowired
    public ContactDaoImpl(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        @Transactional
        public List<Contact> getAll() {
            Session session = sessionFactory.getCurrentSession();
            Query<Contact> userQuery = session.createQuery("from Contact", Contact.class);
            List<Contact> contacts = userQuery.getResultList();
            return contacts == null ? new ArrayList<Contact>() : contacts;
        }


        @Override
        @Transactional
        public Contact get(int id) {
            Session session=sessionFactory.getCurrentSession();
            Contact contact=session.get(Contact.class,id);
            return contact;
        }


    @Override
    @Transactional
    public void create(Contact contact) {
        Session session=sessionFactory.getCurrentSession();
        session.save(contact);
    }

        @Override
        @Transactional
        public void update(Contact contact) {
            Session session=sessionFactory.getCurrentSession();
            session.update(contact);
        }

        @Override
        @Transactional
        public void delete(int id) {
            Session session=sessionFactory.getCurrentSession();
            Contact contact=session.byId(Contact.class).load(id);
            session.delete(contact);
        }
}
