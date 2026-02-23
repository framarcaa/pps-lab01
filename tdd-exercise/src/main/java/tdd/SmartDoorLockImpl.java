package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {
    private boolean isLocked;
    private boolean isBlocked;
    private int pin;
    private int failedAttempts;
    public static final int MAX_ATTEMPTS = 3;

    @Override
    public void setPin(int pin) {
        if(!(this.isLocked && this.isBlocked)) {
            this.pin = pin;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void unlock(int pin) {
        if(this.pin == pin) {
            this.isLocked = false;
        } else {
            this.failedAttempts++;
        }
    }

    @Override
    public void lock() {
        if (this.pin > 0) {
            this.isLocked = true;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        if(failedAttempts > MAX_ATTEMPTS) {
            this.isBlocked = true;
        }
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.isBlocked = false;
        this.isLocked = false;
        this.pin = 0;
        this.failedAttempts = 0;
    }
}
