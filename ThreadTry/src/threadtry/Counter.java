/*
ThreadsQuiz z semináře z Javy
doplněny komentáře k některým třídám, proč že jsou blbě
*/
package threadtry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
nevim..
*/
class Counter {
    private Integer currentValue = 0;
    public Integer next() {
        synchronized(currentValue) {
            return currentValue++;
        }
    }
}

/*
Není vláknově bezpečná : currentValue je statická, všechny instance Counter1 
proto přistupují k jediné hodnotě. 
eee... mozna
*/
class Counter1 {
    private static int currentValue = 0;
    public synchronized int next() {
        return ++currentValue;
    }
}


/*
Přesynchronizovaná třída: LOCK je statický, takže všechny instance Counter2 
čekají na uvolnení jednoho zámku, přestože by mohly provádět nekonkurentní operace.
Ale je vláknově bezpečná.
*/
class Counter2 {
    private int currentValue = 0;
    private static Object LOCK = new Object();
    public int next() {
        synchronized(LOCK) {
            return ++currentValue;
        }
    }
}


/*
Není vláknově bezpečná. 
SynchronizedList je nutné synchronizovat, pokud čteme pomocí iterátoru (např. ve foreach cyklu)
*/
class SomeThreadSafeClass {

    private List<String> data = Collections.synchronizedList(new ArrayList<String>());

    public void addData(String newObject) {
        data.add(newObject);
    }

    /*
    Nemůžeme synchronizovat vzhledem k this, nýbrž k data
    */
    public void dumpData() { //public synchronized void dumpData() {
	synchronized (data) {  //pridano
            for(String s : data) {
                System.out.println(s);
            }
        } //pridano
    }

}