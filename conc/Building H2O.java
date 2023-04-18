class H2O {

    public H2O() {

    }

    private Semaphore hySema = new Semaphore(0);
    private Semaphore oxSema = new Semaphore(1);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hySema.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (hySema.availablePermits() == 0) {
            oxSema.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		oxSema.acquire(1);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hySema.release(2);
    }
}