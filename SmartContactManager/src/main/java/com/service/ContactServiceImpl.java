package com.service;

import com.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private SessionFactory sessionFactory;

    @Autowired
    public ContactServiceImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

//    @Override
//    @Transactional
//    public LinkedHashMap<String, String> getAll() {
//
//        Session session=sessionFactory.getCurrentSession();
//        Query<Sim> categoryQuery=session.createQuery("from Sim ",Sim.class);
//        List<Sim> categories=categoryQuery.getResultList();
//
//        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
//        for (Sim category: categories)
//        {
//            hashMap.put(category.getName(),category.getName());
//        }
//        return hashMap;
//    }
    @Override
    @Transactional
    public List<Contact> getContact(String query) {
        Session session = sessionFactory.getCurrentSession();

        Query<Contact> userQuery = session.createQuery("from Credential where name Like "+"'%"+query+"%'", Contact.class);
        List<Contact> contacts = userQuery.getResultList();
        return contacts == null ? new ArrayList<Contact>() : contacts;
    }

}
