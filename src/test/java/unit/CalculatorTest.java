package unit;

import fr.tfr.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculatorUnderTest;

    @BeforeEach
    public void setUp() {
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculatorUnderTest = null;
    }

    @Test
    public void testAddition() {

        //ARRANGE
        final int a = 2;
        final int b = 3;

        //ACT
        final int result = calculatorUnderTest.add(a, b);

        //ASSERT
        assertEquals(5, result, "2 + 3 should equal 5");
    }


}

