/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cameljdbcdemo.svc.impl;

import com.mycompany.cameljdbcdemo.svc.IGreetService;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author dchakr
 */
public class GreetServiceJDBCImpl implements IGreetService {

  private static final Logger logger = Logger.getLogger(GreetServiceJDBCImpl.class.getName());

  public String greet(String name) throws Exception {
    InitialContext namingContext = new InitialContext();
    DataSource dataSource =
            (DataSource) namingContext.lookup("osgi:service/javax.sql.DataSource/(osgi.jndi.service.name=derbyDataSource)");

    logger.info("::: dataSource.getConnection().toString() ::: " + dataSource.getConnection().toString());

    return "";
  }
}
