/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.jpademo.servlet;

import com.mycompany.demoapps.jpademo.entity.City;
import com.mycompany.demoapps.jpademo.entity.controller.CityJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import org.springframework.util.StopWatch;

/**
 *
 * @author dchakr
 */
public class JPATestServlet extends HttpServlet {

  private static final Logger LOG = Logger.getLogger(JPATestServlet.class.getName());
  @PersistenceContext
  EntityManager em;
  @Resource
  UserTransaction utx;

  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    LOG.info("Inside JPATestServlet.");

    LOG.log(Level.INFO, "::: EntityManager :::{0}", em.toString());
    LOG.log(Level.INFO, "::: UserTransaction :::{0}", utx.toString());
    LOG.log(Level.INFO, "::: EntityManager getClass() :::{0}", em.getClass());

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet JPATestServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet JPATestServlet at " + request.getContextPath() + "</h1>");
      
      StopWatch stopWatch = new StopWatch("CityJpaController Stop Watch");
      stopWatch.start("Task findCityEntities()...");
      CityJpaController cityJpaController = new CityJpaController(utx, em.getEntityManagerFactory());
      List<City> cityList = cityJpaController.findCityEntities();

      for (City city : cityList) {
        LOG.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        LOG.log(Level.INFO, "::: City getName() :::{0}", city.getName());
        LOG.log(Level.INFO, "::: City getDistrict() :::{0}", city.getDistrict());
        LOG.log(Level.INFO, "::: City getCountryCode() :::{0}", city.getCountryCode());
        LOG.log(Level.INFO, "::: City getCountryCode() :::{0}", city.getPopulation());
        LOG.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
      }

      stopWatch.stop();
      LOG.info(stopWatch.prettyPrint());
      
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
