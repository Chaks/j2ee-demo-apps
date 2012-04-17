/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.jpademo.entity.controller;

import com.mycompany.demoapps.jpademo.entity.CountryLanguage;
import com.mycompany.demoapps.jpademo.entity.CountryLanguagePK;
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
public class CountryLanguageJpaController implements Serializable {

  public CountryLanguageJpaController(UserTransaction utx, EntityManagerFactory emf) {
    this.utx = utx;
    this.emf = emf;
  }
  private UserTransaction utx = null;
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(CountryLanguage countryLanguage) throws PreexistingEntityException, RollbackFailureException, Exception {
    if (countryLanguage.getCountryLanguagePK() == null) {
      countryLanguage.setCountryLanguagePK(new CountryLanguagePK());
    }
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      em.persist(countryLanguage);
      utx.commit();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception re) {
        throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
      }
      if (findCountryLanguage(countryLanguage.getCountryLanguagePK()) != null) {
        throw new PreexistingEntityException("CountryLanguage " + countryLanguage + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(CountryLanguage countryLanguage) throws NonexistentEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      countryLanguage = em.merge(countryLanguage);
      utx.commit();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception re) {
        throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
      }
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        CountryLanguagePK id = countryLanguage.getCountryLanguagePK();
        if (findCountryLanguage(id) == null) {
          throw new NonexistentEntityException("The countryLanguage with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(CountryLanguagePK id) throws NonexistentEntityException, RollbackFailureException, Exception {
    EntityManager em = null;
    try {
      utx.begin();
      em = getEntityManager();
      CountryLanguage countryLanguage;
      try {
        countryLanguage = em.getReference(CountryLanguage.class, id);
        countryLanguage.getCountryLanguagePK();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The countryLanguage with id " + id + " no longer exists.", enfe);
      }
      em.remove(countryLanguage);
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

  public List<CountryLanguage> findCountryLanguageEntities() {
    return findCountryLanguageEntities(true, -1, -1);
  }

  public List<CountryLanguage> findCountryLanguageEntities(int maxResults, int firstResult) {
    return findCountryLanguageEntities(false, maxResults, firstResult);
  }

  private List<CountryLanguage> findCountryLanguageEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      Query q = em.createQuery("select object(o) from CountryLanguage as o");
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    } finally {
      em.close();
    }
  }

  public CountryLanguage findCountryLanguage(CountryLanguagePK id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(CountryLanguage.class, id);
    } finally {
      em.close();
    }
  }

  public int getCountryLanguageCount() {
    EntityManager em = getEntityManager();
    try {
      Query q = em.createQuery("select count(o) from CountryLanguage as o");
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
