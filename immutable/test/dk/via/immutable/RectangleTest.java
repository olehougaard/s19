package dk.via.immutable;

import dk.via.mutable.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RectangleTest {
    private static Rectangle twoByFour = new Rectangle(2, 4);
    private static Rectangle fourByTwo = new Rectangle(4, 2);

    @Test
    public void RectanglesWithSameWidthAndHeightAreEqual() {
        Rectangle other = new Rectangle(2, 4);
        assertEquals(twoByFour, other);
    }

    @Test
    public void rectanglesAreNotEqualToTheirRotation() {
        assertNotEquals(twoByFour, fourByTwo);
    }

    @Test
    public void youCanScaleARectangle() {
        twoByFour.setWidth(twoByFour.getWidth() * 2);
        twoByFour.setHeight(twoByFour.getHeight() * 2);
        assertEquals(new Rectangle(4, 8), twoByFour);
    }

    @Test
    public void youCanComputeTheArea() {
        assertEquals(8, twoByFour.getWidth() * twoByFour.getHeight(), .00001);
    }

    @Test
    public void youCanRotateARectangle90Degrees() {
        Rectangle fourByTwo = new Rectangle(4, 2);
        twoByFour.rotate90();
        assertEquals(fourByTwo, twoByFour);
    }
}