class Foo {

    public Foo() {

    }

    private volatile int count = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count < 2) {
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count < 3) {
        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        count++;
    }
}