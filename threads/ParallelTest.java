public class ParallelTest {
    public static void main(String[] args) {
        ParallelRunnable runnable = new ParallelRunnable();
        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);
        Thread three = new Thread(runnable);
        Thread four = new Thread(runnable);
        Thread five = new Thread(runnable);


        one.setName("ONE");
        two.setName("TWO");
        three.setName("THREE");
        four.setName("four");
        five.setName("five");

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }
}
