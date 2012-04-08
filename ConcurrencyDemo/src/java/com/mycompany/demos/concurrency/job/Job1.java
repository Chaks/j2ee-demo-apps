/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demos.concurrency.job;

import java.util.concurrent.Callable;

/**
 *
 * @author dchakr
 */
public class Job1 implements Callable<String> {

  private String performJob() {

   for (int i = 0; i <= 1000000000; i++) {
    }
    for (int i = 0; i <= 1000000000; i++) {
    }
    for (int i = 0; i <= 1000000000; i++) {
    }

    return "Job1";
  }

  public String call() throws Exception {
    return performJob();
  }
}
