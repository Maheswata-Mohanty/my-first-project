package ThreadExample;

public class DeadlockEx {
    public  static void main(String[] args) {
        Employee e1 = new Employee(101, "Maheswata", 20000);
        Employee e2 = new Employee(102, "Manish", 50000);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (e1) {
                    System.out.println("Thread is created " + e1);
                    synchronized (e2) {
                        System.out.println("After occupied object " + e2);
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (e1) {
                    System.out.println("Thread after created " + e1);
                    synchronized (e2) {
                        System.out.println("After updated " + e2);
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }
}
