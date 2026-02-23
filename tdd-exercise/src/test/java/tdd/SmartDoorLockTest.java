package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    SmartDoorLock doorLock;
    @BeforeEach
    public void init() {
        this.doorLock = new SmartDoorLockImpl();
    }
    @Test
    public void testSmartDoorLockInitiallyUnlocked() {
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    public void testSmartLockCanBeLocked() {
        this.doorLock.setPin(1234);
        this.doorLock.lock();
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    public void testSmartLockCannotBeLocked() {
        assertThrows(IllegalStateException.class, () -> this.doorLock.lock());
    }

    @Test
    public void testSmartDoorLockCanBeUnlocked() {
        this.doorLock.setPin(1234);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    public void testSmartDoorLockCanChangePin() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(4321);
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    public void testSmartDoorLockCannotChangePin() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    public void testIfSmartDoorLockBlocks() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        assertTrue(this.doorLock.isBlocked());
    }

    @Test
    public void testIfSmartDoorLockDoesNotBlock() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        assertFalse(this.doorLock.isBlocked());
    }

    @Test
    public void testCorrectNumberOfFailedAttempts() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        assertEquals(2, this.doorLock.getFailedAttempts());
    }

    @Test
    public void testCorrectResetOfLockedLock() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.reset();
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    public void testCorrectResetOfBlockedLock() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        this.doorLock.reset();
        assertFalse(this.doorLock.isBlocked());
    }

    @Test
    public void testIfResetNumberOfFailedAttempts() {
        this.doorLock.setPin(4321);
        this.doorLock.lock();
        this.doorLock.unlock(1234);
        this.doorLock.unlock(1234);
        this.doorLock.reset();
        assertEquals(0, this.doorLock.getFailedAttempts());
    }

    @Test
    public void testIfResetPin() {
        this.doorLock.setPin(4321);
        this.doorLock.reset();
        assertThrows(IllegalStateException.class, () -> this.doorLock.lock());
    }
}
