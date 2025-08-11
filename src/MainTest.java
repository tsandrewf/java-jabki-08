import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testListOutputOneLine() {
        ArrayList<Integer> alInt = new ArrayList<>() {{
            add(2);
            add(4);
            add(6);
            add(8);
            add(12);
        }};
        Main.listOutputOneLine(alInt);

        Assertions.assertEquals("2 4 6 8 12", outputStreamCaptor.toString().trim());
    }

    @Test
    void testInvertList() {
        outputStreamCaptor.reset();
        ArrayList<Integer> list = new ArrayList<>() {{
            add(3);
            add(5);
            add(7);
            add(9);
            add(13);
        }};
        Main.listOutputOneLine(Main.invertList(list));
        Assertions.assertEquals("13 9 7 5 3", outputStreamCaptor.toString().trim());
    }

    @Test
    void testListOutput() {
        outputStreamCaptor.reset();
        ArrayList<Integer> list = new ArrayList<>() {{
            add(4);
            add(6);
            add(8);
            add(10);
            add(14);
        }};
        Main.listOutput(list, "Тестовый список целых чисел");
        Assertions.assertEquals("Тестовый список целых чисел:\r\n4\r\n6\r\n8\r\n10\r\n14", outputStreamCaptor.toString().trim());
    }
}