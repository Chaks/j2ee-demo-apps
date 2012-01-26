/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.transform;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.logging.Logger;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;

/**
 *
 * @author dchakr
 */
public class CustomerCSVToXML {

  private static final Logger logger = Logger.getLogger(CustomerCSVToXML.class.getName());

  public String csvToXML(String csvLine) throws Exception {

    logger.info("::: CustomerCSVToXML ::: " + csvLine);
    logger.info("::: csvLine ::: " + csvLine);

    Smooks smooks = new Smooks("smooks-config.xml");
    try {
      ExecutionContext executionContext = smooks.createExecutionContext();
      StringWriter writer = new StringWriter();
      smooks.filterSource(executionContext,
              new StreamSource(new InputStreamReader(new ByteArrayInputStream(csvLine.getBytes()), "UTF-8")), new StreamResult(writer));

      logger.info("::: writer ::: " + writer.toString());
      return writer.toString();
    } finally {
      smooks.close();
    }
  }
}
