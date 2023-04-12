import java.util.concurrent.atomic.AtomicInteger;

class Foo {

    public Foo() {

    }

    private AtomicInteger count = new AtomicInteger(1);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count.intValue() < 2) {
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count.intValue() < 3) {
        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        count.getAndIncrement();
    }
}