/*
 *  Copyright 2011 156655.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.mycompany.camelcxfdemo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


/**
 *
 * @author Darimireddi Chakravarthi
 */
public class GreetProcessor implements Processor {
  public void process(Exchange exchng) throws Exception {
    Object[] args = exchng.getIn().getBody(Object[].class);
    exchng.getOut().setBody("Hello " + (String) args[0] + "!");
  }
}
