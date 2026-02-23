import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;

import static example.model.SimpleBankAccount.WITHDRAW_FEE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        int depositAmount = 100;
        bankAccount.deposit(accountHolder.id(), depositAmount);
        assertEquals(depositAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int bankAmount = 100;
        int depositAmount = 50;
        bankAccount.deposit(accountHolder.id(), bankAmount);
        bankAccount.deposit(2, depositAmount);
        assertEquals(bankAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int amount = 100;
        int withdrawAmount = 70;
        bankAccount.deposit(accountHolder.id(), amount);
        bankAccount.withdraw(accountHolder.id(), withdrawAmount);
        assertEquals(amount - withdrawAmount - WITHDRAW_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int amount = 100;
        int withdrawAmount = 70;
        bankAccount.deposit(accountHolder.id(), amount);
        bankAccount.withdraw(2, withdrawAmount);
        assertEquals(amount, bankAccount.getBalance());
    }
}
