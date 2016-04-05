/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtry;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Runnable generating sequence of numbers from 0 to 50
 * 
 * @author xcambal
 */
public class SequenceRunnable implements Runnable {
    
    private final int MAX = 50;
    private final AtomicInteger currentValue = new AtomicInteger( -1 );
    //This CAN be FINAL, because it references always the same object, just his inner value is modified
    //no need for VOLATILE then
    

    @Override
    public void run() {
        int value;
        
        for(;;) {
            value = currentValue.incrementAndGet();
            //Much much better than synchronized getNext() 
            
            if (value <= MAX) {
                System.out.println(Thread.currentThread().getName() + ": " + value);
            } else {
                break;
            }  
            
            
            //With this its much more obvious it is not sorted: //tzv. Aktivni cekaci smycka
            for (long l = 0l; l < 100000; l++) {}
        }
    }
  
    /*
    private synchronized int getNext(){
        return ++currentValue;
    }
    */
}