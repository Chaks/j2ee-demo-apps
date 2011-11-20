/*
 * Copyright 2011 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.demoapps.camel.transform;

import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 *
 * @author dchakr
 */
public class CustomerCSVBean {

  private static final Logger logger = Logger.getLogger(CustomerCSVBean.class.getName());

  public static String map(String body) {
    logger.info("::: CustomerCSVBean :::");
    logger.info("::: body ::: " + body);

    StringBuilder customerDataBuilder = new StringBuilder();
    StringTokenizer columnWithValues = new StringTokenizer(body, ",");

    while (columnWithValues.hasMoreTokens()) {
      String[] valuesOnly = columnWithValues.nextToken().split("=");
      //customerDataBuilder.append(",");
      customerDataBuilder.append(valuesOnly[1]).append(",");
    }
    customerDataBuilder.deleteCharAt(customerDataBuilder.length() - 2);

    logger.info("::: customerDataBuilder ::: " + customerDataBuilder);
    customerDataBuilder.append("\n");
    return customerDataBuilder.toString();
  }
}
