package sync;

import static java.lang.Thread.currentThread;

public class U1901Bank {

    private int intTo;
    private int intFrom = 220;

    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.printf("Before - intTo = %d, intFrom = %d, Thread = %s%n",
                intTo, intFrom, Thread.currentThread().getName());

        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intTo += intTransaction;

        System.out.printf("After - intTo = %d, intFrom = %d, Thread = %s%n",
                intTo, intFrom, Thread.currentThread().getName());
    }

}

