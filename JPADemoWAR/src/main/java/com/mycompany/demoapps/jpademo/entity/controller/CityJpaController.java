/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.jpademo.entity.controller;

import com.mycompany.demoapps.jpademo.entity.City;
import com.mycompany.demoapps.jpademo.servlet.exceptions.NonexistentEntityException;
import com.mycompany.demoapps.jpademo.servlet.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author dchakr
 */
public class CityJpaController implements Serializable {

  private static final Logger LOG = Logger.getLogger(CityJpaController.class.getName());

  public CityJpaController(UserTransaction utx, EntityManagerFactory emf) {
    this.utx = utx;
    this.emf = emf;
  }
  private UserTransaction utx = null;
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(City city) throws RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      em.persist(city);
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

  public void edit(City city) throws NonexistentEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      city = em.merge(city);
      utx.commit();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception re) {
        throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
      }
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Integer id = city.getId();
        if (findCity(id) == null) {
          throw new NonexistentEntityException("The city with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      City city;
      try {
        city = em.getReference(City.class, id);
        city.getId();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The city with id " + id + " no longer exists.", enfe);
      }
      em.remove(city);
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

  public List<City> findCityEntities() {
    return findCityEntities(true, -1, -1);
  }

  public List<City> findCityEntities(int maxResults, int firstResult) {
    return findCityEntities(false, maxResults, firstResult);
  }

  private List<City> findCityEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      Query q = em.createQuery("select object(o) from City as o");
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    } finally {
      em.close();
    }
  }

  public City findCity(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(City.class, id);
    } finally {
      em.close();
    }
  }

  public int getCityCount() {
    EntityManager em = getEntityManager();
    try {
      Query q = em.createQuery("select count(o) from City as o");
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
}
