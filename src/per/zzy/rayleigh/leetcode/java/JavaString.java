package per.zzy.rayleigh.leetcode.java;

public class JavaString {

    public static volatile int lock = 1;

    public static volatile int num = 1;

    public static Thread thread1 = new Thread(() -> {
        while (num <= 100) {
            if (lock == 1) {
                System.out.println("1:" + num);
                num ++;
                lock = 2;
            }
        }
    });

    public static Thread thread2 = new Thread(() -> {
        while (num <= 100) {
            if (lock == 2) {
                System.out.println("2:" + num);
                num ++;
                lock = 3;
            }
        }
    });

    public static Thread thread3 = new Thread(() -> {
        while (num <= 100) {
            if (lock == 3) {
                System.out.println("3:" + num);
                num ++;
                lock = 1;
            }
        }
    });

    public static void main(String[] args) {

        lock = 1;
        thread1.start();
        thread2.start();
        thread3.start();


    }



}
