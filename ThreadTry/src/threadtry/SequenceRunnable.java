/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtry;

/**
 * Runnable generating sequence of numbers from 0 to 50
 * 
 * @author xcambal
 */
public class SequenceRunnable implements Runnable {
    
    private volatile int currentValue = -1;

    @Override
    public void run() {
        int value;
        
        for(;;) {
            value = getNext();
            
            //With this its much more obvious it is not sorted:
            for (long l = 0l; l < 100000; l++) {}
            
            if (value < 51) {
                System.out.println(Thread.currentThread().getName() + ": " + value);
            } else {
                break;
            }  
            
        }
    }
    
    private synchronized int getNext(){
        return ++currentValue;
    }
    
}