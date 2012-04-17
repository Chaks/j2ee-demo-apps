/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.jpademo.entity.controller;

import com.mycompany.demoapps.jpademo.entity.Country;
import com.mycompany.demoapps.jpademo.entity.exceptions.NonexistentEntityException;
import com.mycompany.demoapps.jpademo.entity.exceptions.PreexistingEntityException;
import com.mycompany.demoapps.jpademo.entity.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.transaction.UserTransaction;

/**
 *
 * @author dchakr
 */
public class CountryJpaController implements Serializable {

  public CountryJpaController(UserTransaction utx, EntityManagerFactory emf) {
    this.utx = utx;
    this.emf = emf;
  }
  private UserTransaction utx = null;
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Country country) throws PreexistingEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      em.persist(country);
      utx.commit();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception re) {
        throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
      }
      if (findCountry(country.getCode()) != null) {
        throw new PreexistingEntityException("Country " + country + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Country country) throws NonexistentEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      country = em.merge(country);
      utx.commit();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception re) {
        throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
      }
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        String id = country.getCode();
        if (findCountry(id) == null) {
          throw new NonexistentEntityException("The country with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      Country country;
      try {
        country = em.getReference(Country.class, id);
        country.getCode();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The country with id " + id + " no longer exists.", enfe);
      }
      em.remove(country);
      utx.commit();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception re) {
        throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Country> findCountryEntities() {
    return findCountryEntities(true, -1, -1);
  }

  public List<Country> findCountryEntities(int maxResults, int firstResult) {
    return findCountryEntities(false, maxResults, firstResult);
  }

  private List<Country> findCountryEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      Query q = em.createQuery("select object(o) from Country as o");
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    } finally {
      em.close();
    }
  }

  public Country findCountry(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Country.class, id);
    } finally {
      em.close();
    }
  }

  public int getCountryCount() {
    EntityManager em = getEntityManager();
    try {
      Query q = em.createQuery("select count(o) from Country as o");
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
