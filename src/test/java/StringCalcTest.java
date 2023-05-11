import org.example.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class StringCalcTest {
    final StringCalculator calc=new StringCalculator();

    @Test
    public void adding_test(){
        assertEquals(-1,calc.adding("-1,2,-4\n-6"));
        assertEquals(-1,calc.adding("-2"));
        assertEquals(2,calc.adding("2"));
        assertEquals(12,calc.adding("10,1001,2\n4596"));
        calc.delimiters.add("000");
        calc.delimiters.add("00");
        calc.delimiters.add("0");
        calc.delimiters.add("+");
        assertEquals(33,calc.adding("404,50006+2\n7005"));
    }
    @Test
    public void add_test(){
        assertEquals(0,calc.add(""));
        assertEquals(-1,calc.add("//\n1,2"));
    }

    @Test
    public void custom_del_test(){
        assertEquals("",calc.custom_del("//\n1,2"));
        calc.custom_del("//.\n1+2");
        assertEquals(".",calc.delimiters.get(2));
        calc.custom_del("//[0][+][++][+++]\n1+2");
        assertEquals("+++",calc.delimiters.get(4));
        assertEquals("++",calc.delimiters.get(5));
        assertEquals("+",calc.delimiters.get(6));
        assertEquals("0",calc.delimiters.get(3));

    }
    @Test
    public void edit_clean_test(){
        List<String> delimiters = new ArrayList<>();
        delimiters.add("000");
        delimiters.add("=");
        delimiters.add(".");
        calc.edit(delimiters);
        assertEquals("000",calc.delimiters.get(2));
        assertEquals("=",calc.delimiters.get(3));
        assertEquals(".",calc.delimiters.get(4));
        calc.list_clean();
        assertEquals(2,calc.delimiters.size());
    }
}
