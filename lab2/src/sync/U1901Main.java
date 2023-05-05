package sync;

public class U1901Main {
    public static void main(String[] args) {
        // Создаем объект банка
        U1901Bank bankMain = new U1901Bank();

        // Создаем первый поток
        U1901Thread threadOne = new U1901Thread(bankMain, 100, 2000);
        threadOne.setName("Thread One");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        // Создаем второй поток
        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);
        threadTwo.setName("Thread Two");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        // Выводим имя текущего потока для контрольного выстрела
        System.out.println(Thread.currentThread().getName());
    }
}

