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
package com.mycompany.camelcxfdemo.callback;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

/**
 *
 * @author Darimireddi Chakravarthi
 */
public class ClientPasswordCallback implements CallbackHandler {

  private static final Logger logger = Logger.getLogger(ClientPasswordCallback.class.getName());
  private Map<String, String> passwords = new HashMap<String, String>();

  public ClientPasswordCallback() {
    passwords.put("abcd", "dcba");
    passwords.put("server-keystore", "importkey");
  }

  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    logger.info("::: ClientPasswordCallback :::");

    for (int i = 0; i < callbacks.length; i++) {
      logger.info("::: callback type ::: " + callbacks[i].toString());
      WSPasswordCallback passwordCallback = (WSPasswordCallback) callbacks[i];

      logger.info("::: identifier ::: " + passwordCallback.getIdentifier());
      logger.info("::: usage ::: " + passwordCallback.getUsage());

      String pass = passwords.get(passwordCallback.getIdentifier());
      if (pass != null) {
        passwordCallback.setPassword(pass);
        return;
      }
    }

  }
}
