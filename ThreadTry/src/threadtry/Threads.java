/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtry;

import java.util.ArrayList;
import java.util.List;

/**
 * Main method running example implementation of threads
 * 
 * @author xcambal
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int threadNum = 3;
        
                                                        //Runs unsorted sequence
        Runnable sequence = new SequenceRunnableNice(); //SequenceRunnable(); //
        List<Thread> sequenceThreads = new ArrayList<>();
        
        
        for(int i=0; i<threadNum; i++)  {
            sequenceThreads.add( new Thread(sequence, "vlakno " + (i+1) ) );
        }
        
        for(Thread th : sequenceThreads){
            th.start();
        }
        
    }
    
}