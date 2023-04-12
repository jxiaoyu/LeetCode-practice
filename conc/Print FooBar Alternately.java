class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag) {

            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            flag = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag) {

            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            flag = true;
        }
    }
}