package mint.utils;

import mint.Mint;

public class Timer {
    private long time = -1L;
    private final long current;
    long startTime;
    long delay;
    boolean paused;

    public Timer() {
        this.startTime = System.currentTimeMillis();
        this.delay = 0L;
        this.paused = false;
        current = -1;
    }

    public final boolean hasReached(final long delay) {
        return System.currentTimeMillis() - this.current >= delay;
    }


    public boolean passedS(double s) {
        return this.getMs(System.nanoTime() - this.time) >= (long) (s * 1000.0);
    }

    public boolean passedM(double m) {
        return this.getMs(System.nanoTime() - this.time) >= (long) (m * 1000.0 * 60.0);
    }

    public boolean passedDms(double dms) {
        return this.getMs(System.nanoTime() - this.time) >= (long) (dms * 10.0);
    }

    public boolean passedDs(double ds) {
        return this.getMs(System.nanoTime() - this.time) >= (long) (ds * 100.0);
    }

    public boolean passedMs(long ms) {
        return this.getMs(System.nanoTime() - this.time) >= ms;
    }

    public boolean passedNS(long ns) {
        return System.nanoTime() - this.time >= ns;
    }

    public void setMs(long ms) {
        this.time = System.nanoTime() - ms * 1000000L;
    }

    public long getPassedTimeMs() {
        return this.getMs(System.nanoTime() - this.time);
    }

    public void reset() {
        this.time = System.nanoTime();
    }

    public long getMs(long time) {
        return time / 1000000L;
    }

    public boolean isPassed() {
        return !this.paused && System.currentTimeMillis() - this.startTime >= this.delay;
    }

    public void setDelay(final long delay) {
        this.delay = delay;
    }

    public void setPaused(final boolean paused) {
        this.paused = paused;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public long getTime() {
        return this.time;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public static float getTimer() {
        return Mint.INSTANCE.mc.timer.tickLength;
    }

    public static void setTimer(float speed) {
        Mint.INSTANCE.mc.timer.tickLength = 50 / speed;
    }

    public static void resetTimer() {
        Mint.INSTANCE.mc.timer.tickLength = 50;
    }
}

