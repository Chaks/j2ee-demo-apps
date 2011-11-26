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
package com.mycompany.demoapps.camel.service;

import com.mycompany.demoapps.camel.bean.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.camel.Exchange;

/**
 *
 * @author dchakr
 */
public class CustomerHTTPService {

  private static final Logger logger = Logger.getLogger(CustomerHTTPService.class.getName());

  public List<Customer> invokeService(Exchange exchng) {
    logger.info("::: exchng ::: " + exchng);

    HttpServletRequest req = exchng.getIn().getBody(HttpServletRequest.class);
    //CUSTOMER_ID
    logger.info("::: customerId ::: " + req.getParameter("customerId"));

    List<Customer> customerList = new ArrayList<Customer>();

    Customer customer = new Customer();
    customer.setCustomerName("Jumbo Eagle Corp");
    customer.setEmailId("jumboeaglecorp@example.com");
    customer.setPhone("305-555-0188");

    /*Customer customer1 = new Customer();
    customer1.setCustomerName("New Enterprises");
    customer1.setEmailId("newenterprises@example.com");
    customer1.setPhone("305-555-0148");*/

    customerList.add(customer);
    //customerList.add(customer1);

    return customerList;
  }
}
