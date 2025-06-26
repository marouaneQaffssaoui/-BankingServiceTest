import org.example.Entities.TransactionType;
import org.example.Service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private AccountServiceImpl accountService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountServiceImpl();
    }

    @Test
    void testDepositNegativeAmount(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                accountService.deposit(-50)
        );
        assertEquals("amount should be positive !!", exception.getMessage());
    }

    @Test
    void testDepositPositiveAmount(){
        accountService.deposit(1000);
        assertEquals(1000, accountService.account.getBalance());
        assertEquals(1, accountService.account.getTransactions().size());
        assertEquals(TransactionType.DEPOSIT, accountService.account.getTransactions().get(0).getTransactionType());
    }
    @Test
    void testWithdrawNigativeAmount(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> accountService.withdraw(-2000)
        );
        assertEquals("amount should be positive !!", exception.getMessage());
    }

    @Test
    void testWithdrawRightAmount() {
        accountService.deposit(1000);
        accountService.withdraw(500);
        assertEquals(500, accountService.account.getBalance());
        assertEquals(2, accountService.account.getTransactions().size());
        assertEquals(TransactionType.WITHDRAW, accountService.account.getTransactions().get(1).getTransactionType());
    }

    @Test
    void testPrintStatement(){
        accountService.deposit(1000);
        accountService.printStatement();
        assertEquals("26/06/2025 || 1000 || 1000", accountService.account.getTransactions().get(0).toString());
    }
}
