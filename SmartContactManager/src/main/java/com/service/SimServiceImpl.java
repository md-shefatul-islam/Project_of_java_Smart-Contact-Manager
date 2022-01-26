package com.service;

import com.model.Sim;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class SimServiceImpl implements SimService{

    private SessionFactory sessionFactory;

    @Autowired
    public SimServiceImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public LinkedHashMap<String, String> getAll() {

        Session session=sessionFactory.getCurrentSession();
        Query<Sim> categoryQuery=session.createQuery("from Sim ",Sim.class);
        List<Sim> categories=categoryQuery.getResultList();

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        for (Sim category: categories)
        {
            hashMap.put(category.getName(),category.getName());
        }
        return hashMap;
    }
}
