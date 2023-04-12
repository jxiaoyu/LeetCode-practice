class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private volatile boolean printZero = true;

    private volatile int index = 1;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (index < n) {
            if (printZero) {
                printNumber.accept(0);
                printZero = false;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            if (index % 2 == 0 && !printZero) {
                printNumber.accept(index);
                printZero = true;
                index++;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            if (index % 2 == 1 && !printZero) {
                printNumber.accept(index);
                printZero = true;
                index++;
            }
        }
    }
}