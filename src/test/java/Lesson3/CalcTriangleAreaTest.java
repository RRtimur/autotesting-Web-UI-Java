package Lesson3;
import static org.junit.jupiter.api.Assertions.assertThrows;
import Lesson4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static Lesson4.Triangle.calcTriangleArea;

public class CalcTriangleAreaTest {
    private static Logger logger = LoggerFactory.getLogger(CalcTriangleAreaTest.class);

    @Test
    void checkCalcTriangleArea() throws Exception {
        Assertions.assertEquals(12, calcTriangleArea(5, 5, 6));
        logger.info("checkCalcTriangleArea - Тест успешен!");
    }

    @Test
    void checkExceptionWithZeroOrLessSideOfTriangle(){
//        Assertions.assertThrows(Exception.class, () -> calcTriangleArea(0,2,6) );
//        <-- подсмотрел уже на подсказке в 5 уроке
        assertThrows(Exception.class,
                () -> calcTriangleArea(-1,2,2),"нельзя 0 или меньше !");
        // <-- так бы я сделал сам с помощью гугла =\
        logger.info("checkExceptionWithZeroOrLessSideOfTriangle - Тест успешен!");
    }
}
