package com.example.thuc_hanh_ss5.repository;

import com.example.thuc_hanh_ss5.entity.Customers;
import com.sun.jdi.Type;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomersRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customers> findAll() {
        TypedQuery<Customers> customersTypedQuery = entityManager.createQuery("from Customers", Customers.class);
        return customersTypedQuery.getResultList();
    }

    @Transactional
    @Override
    public void save(Customers customer) {
        try {
            entityManager.persist(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
@Transactional
    @Override
    public void update(Customers customer) {
        try {
            entityManager.merge(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        Customers customers = entityManager.find(Customers.class, id);
        try {
            entityManager.remove(customers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public Customers findById(int id) {
        return entityManager.find(Customers.class, id);
    }

    @Override
    public List<Customers> searchByName(String name) {
        TypedQuery<Customers> query = entityManager.createQuery(
                "SELECT c FROM Customers c WHERE c.name LIKE :name", Customers.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
