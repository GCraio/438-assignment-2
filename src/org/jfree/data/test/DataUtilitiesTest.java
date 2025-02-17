package org.jfree.data.test;
import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.Test;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.jmock.Expectations;

public class DataUtilitiesTest extends DataUtilities {

	// Gabriel's implementation
    @Test
    public void testCalculateColumnTotal_ValidValues() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);
        
        context.checking(new Expectations() {{
            allowing(mockData).getRowCount(); will(returnValue(3));
            allowing(mockData).getValue(0, 0); will(returnValue(2.0));
            allowing(mockData).getValue(1, 0); will(returnValue(3.5));
            allowing(mockData).getValue(2, 0); will(returnValue(4.5));
        }});
        
        double result = DataUtilities.calculateColumnTotal(mockData, 0);
        assertEquals(10.0, result, 0.0001);
    }
}
