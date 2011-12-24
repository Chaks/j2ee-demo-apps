/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cameljdbcdemo.camel.transform;

import java.util.StringTokenizer;
import java.util.logging.Logger;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dchakr
 */
public class CustomerCSVProcessor implements Processor {

  private static final Logger logger = Logger.getLogger(CustomerCSVProcessor.class.getName());

  public void process(Exchange exchng) throws Exception {
    logger.info("::: CustomerCSVProcessor :::");
    logger.info("::: exchng ::: " + exchng);

    logger.info("::: getExchangeId ::: " + exchng.getExchangeId());
    logger.info("::: getFromRouteId ::: " + exchng.getFromRouteId());
    logger.info("::: getMessageId ::: " + exchng.getIn().getMessageId());
    logger.info("::: getHeaders ::: " + exchng.getIn().getHeaders());

    StringBuilder customerDataBuilder = new StringBuilder();

    String body = exchng.getIn().getBody(String.class);
    StringTokenizer columnWithValues = new StringTokenizer(body, ",");

    while (columnWithValues.hasMoreTokens()) {
      String[] valuesOnly = columnWithValues.nextToken().split("=");
      //customerDataBuilder.append(",");
      customerDataBuilder.append(valuesOnly[1]).append(",");
    }
    customerDataBuilder.deleteCharAt(customerDataBuilder.length() - 2);

    logger.info("::: customerDataBuilder ::: " + customerDataBuilder);
    customerDataBuilder.append("\n");
    exchng.getIn().setBody(customerDataBuilder.toString());
  }
}
