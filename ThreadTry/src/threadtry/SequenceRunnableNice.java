/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtry;

/**
 * Runnable generating sorted sequence of numbers from 0 to 50
 * 
 * @author xcambal
 */
public class SequenceRunnableNice implements Runnable {
    
    private volatile int currentValue = 0;

    @Override
    public void run() {
        
        for(;;) {
            //With this its much more obvious it is not sorted:
            for (long l = 0l; l < 100000; l++) {}
            
            synchronized (this) {
                if (currentValue <= 50) {
                    System.out.println(Thread.currentThread().getName() + ": " + currentValue);
                    currentValue++;
                } else {
                    break;
                }
            }
            
        }
        
    }
    
}