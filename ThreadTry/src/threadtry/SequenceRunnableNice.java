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
    
    private final int MAX = 50;
    private volatile int currentValue = 0;

    @Override
    public void run() {
        
        for(;;) {
            for (long l = 0l; l < 1000000; l++) {}
            
            synchronized (this) {
                if (currentValue <= MAX) {
                    System.out.println(Thread.currentThread().getName() + ": " + currentValue);
                    currentValue++;
                } else {
                    break;
                }
            }
            
        }
        
    }
    
}