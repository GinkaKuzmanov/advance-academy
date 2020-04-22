package exercises.P05_Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(5,10);
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }
    @Test(expected = IllegalArgumentException.class)
    public void getSquareSidesTest() {
        BaseRect rect = new Square(5,10);
    }


    @Test
    public void getSquareAreaTest() {
        BaseRect rect = new Square(10,10);
        Assert.assertEquals(100,rect.getArea());
    }


    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5,10);
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(50, rect.getArea());
    }
}
