/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demos.concurrency.servlet;

import com.mycompany.demos.concurrency.job.Job1;
import com.mycompany.demos.concurrency.job.Job2;
import com.mycompany.demos.concurrency.job.Job3;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.commonj.WorkManagerTaskExecutor;

/**
 *
 * @author dchakr
 */
public class ConcurrencyTestServlet extends HttpServlet {

  /** 
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      /* TODO output your page here
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ConcurrencyTestServlet</title>");  
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet ConcurrencyTestServlet at " + request.getContextPath () + "</h1>");
      out.println("</body>");
      out.println("</html>");
       */
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
      System.out.println("::: taskExecutor :::" + applicationContext.getBean("taskExecutor"));

      WorkManagerTaskExecutor wmte = (WorkManagerTaskExecutor) applicationContext.getBean("taskExecutor");

      long startTime = System.currentTimeMillis();

      Future<String> job1Future = wmte.submit(new Job1());
      Future<String> job2Future = wmte.submit(new Job2());
      Future<String> job3Future = wmte.submit(new Job3());

      System.out.println("::: job1Future ::: " + job1Future.get(7, TimeUnit.SECONDS));
      System.out.println("::: job2Future ::: " + job2Future.get(7, TimeUnit.SECONDS));
      System.out.println("::: job3Future ::: " + job3Future.get(7, TimeUnit.SECONDS));

      long endTime = System.currentTimeMillis();

      System.out.println("::: startTime ::: " + startTime);
      System.out.println("::: endTime ::: " + endTime);
      System.out.println("::: Time taken in seconds ::: " + (endTime - startTime) / 1000);

    } catch (Exception e) {
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /** 
   * Handles the HTTP <code>GET</code> method.
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
   * Handles the HTTP <code>POST</code> method.
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
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
