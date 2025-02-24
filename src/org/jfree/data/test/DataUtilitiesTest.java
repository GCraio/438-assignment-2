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
    
    // Zaid's tests for calculate row total
    
    @Test
    public void testCalculateRowTotal_ValidValues() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(3));
            allowing(mockData).getValue(0, 0); will(returnValue(2.0));
            allowing(mockData).getValue(0, 1); will(returnValue(3.5));
            allowing(mockData).getValue(0, 2); will(returnValue(4.5));
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 0);
        assertEquals(10.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotal_NegativeValues() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(3));
            allowing(mockData).getValue(0, 0); will(returnValue(-2.0));
            allowing(mockData).getValue(0, 1); will(returnValue(-3.5));
            allowing(mockData).getValue(0, 2); will(returnValue(4.5));
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 0);
        assertEquals(-1.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotal_SingleValue() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(1));
            allowing(mockData).getValue(0, 0); will(returnValue(7.0));
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 0);
        assertEquals(7.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotal_Zeroes() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(3));
            allowing(mockData).getValue(0, 0); will(returnValue(0.0));
            allowing(mockData).getValue(0, 1); will(returnValue(0.0));
            allowing(mockData).getValue(0, 2); will(returnValue(0.0));
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 0);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotal_EmptyDataset() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(0));
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 0);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotal_NullValues() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(3));
            allowing(mockData).getValue(0, 0); will(returnValue(5.0));
            allowing(mockData).getValue(0, 1); will(returnValue(null));  // Simulating missing value
            allowing(mockData).getValue(0, 2); will(returnValue(10.0));
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 0);
        assertEquals(15.0, result, 0.0001);  // Null should be ignored
    }

    @Test
    public void testCalculateRowTotal_OutOfBoundsRow() {
        Mockery context = new Mockery();
        Values2D mockData = context.mock(Values2D.class);

        context.checking(new Expectations() {{
            allowing(mockData).getColumnCount(); will(returnValue(3));
            allowing(mockData).getValue(5, 0); will(throwException(new IndexOutOfBoundsException())); // Row doesn't exist
        }});

        double result = DataUtilities.calculateRowTotal(mockData, 5);
        assertEquals(0.0, result, 0.0001);  // Should return 0 or handle gracefully
    }
}
