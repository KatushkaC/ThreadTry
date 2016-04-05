/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtry;

/**
 * Just trying threads behaviour
 * 
 * @author xcambal
 */
public class SimpleRunnable implements Runnable {

    @Override
    public void run() {
        // As can be seen here: every thread has its own localVal and i value
        int localVal = 0;
        for (int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + (++localVal));
            for (long l = 0l; l < 10000; l++) {} //brzda
            
        }
    }
}