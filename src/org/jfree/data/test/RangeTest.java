package org.jfree.data.test;
import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
	
	// Gabriel's implementation
    @Test
    public void testGetLength_NormalRange() {
        Range range = new Range(0, 10);
        assertEquals(10, range.getLength(), 0.0001);
    }
    
    // Gabriel's implementation
    @Test
    public void testContains_Positive() {
        Range range = new Range(0, 10);
        assertTrue(range.contains(5));  // Correct assertion for boolean return value
    }
}