/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cameljdbcdemo.camel.transform;

import org.apache.camel.Exchange;
import org.apache.camel.NoTypeConversionAvailableException;
import org.apache.camel.TypeConverter;

/**
 *
 * @author dchakr
 */
public class CustomerCSVTypeConverter implements TypeConverter {

  public <T> T convertTo(Class<T> type, Object o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> T convertTo(Class<T> type, Exchange exchng, Object o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> T mandatoryConvertTo(Class<T> type, Object o) throws NoTypeConversionAvailableException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> T mandatoryConvertTo(Class<T> type, Exchange exchng, Object o) throws NoTypeConversionAvailableException {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
