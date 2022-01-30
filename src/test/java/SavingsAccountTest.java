import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SavingsAccountTest {
    SavingsAccount sut;
    private static long suiteStartTime;
    private long testStartTime;
    @BeforeAll
    public static void initSuite() {
        System.out.println("Running SavingsAccountTest");
        suiteStartTime = System.nanoTime();
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("SavingsAccountTest complete: " + (System.nanoTime() - suiteStartTime));
    }
    @BeforeEach
    public void initTest() {
        System.out.println("\nStarting new test");
        testStartTime = System.nanoTime();
    }
    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }
    @Test
    public void testConstructorPropertyName() {
        // given:
        double money = 100;
        String name = "Сберегательный счет";
        double expected = 100;

        // when:
        sut = new SavingsAccount(money, name);

        // then:
        Assertions.assertEquals(name, sut.getName());
    }
    @Test
    public void testConstructorPropertyAmount() {
        // given:
        double money = 100;
        String name = "Сберегательный счет";
        double expected = 100;

        // when:
        sut = new SavingsAccount(money, name);

        // then:
        Assertions.assertEquals(expected, sut.getAmount());
    }
    @Test
    public void testConstructorMinus() {
        // given:
        double moneyMinus = -100;
        String name = "Сберегательный счет";
        double expected = 100;

        // when:
        sut = new SavingsAccount(moneyMinus, name);

        // then:
        Assertions.assertEquals(expected, sut.getAmount());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-50, 0, 50})
    public void testPay(double argument) {
        // given:
        sut = new SavingsAccount(100, "Сберегательный счет");
        boolean expected;

        // when:
        expected = sut.pay(argument);

        // then:
        Assertions.assertFalse(expected);
    }

    @Test
    public void testAddMoney() {
        // given:
        double money = 100;
        double amount = 50;
        String name = "Сберегательный счет";
        double expected = 150;
        sut = new SavingsAccount(money, name);

        // when:
        sut.addMoney(amount);

        // then:
        Assertions.assertEquals(expected, sut.getAmount());
    }
    @Test
    public void testAddMoneyTrue() {
        // given:
        double money = 100;
        double amount = 50;
        String name = "Сберегательный счет";
        double expected = 150;
        sut = new SavingsAccount(money, name);

        // when:
        boolean result = sut.addMoney(amount);

        // then:
        Assertions.assertTrue(result);
    }
    @Test
    public void testAddAmountMinus() {
        // given:
        double money = 100;
        double amount = -50;
        String name = "Сберегательный счет";
        double expected = 100;
        sut = new SavingsAccount(money, name);

        // when:
        sut.addMoney(amount);

        // then:
        Assertions.assertEquals(expected, sut.getAmount());
    }
    @Test
    public void testAddAmountMinusFalse() {
        // given:
        double money = 100;
        double amount = -50;
        String name = "Сберегательный счет";
        double expected = 100;
        sut = new SavingsAccount(money, name);

        // when:
        boolean result = sut.addMoney(amount);

        // then:
        Assertions.assertFalse(result);
    }
}
