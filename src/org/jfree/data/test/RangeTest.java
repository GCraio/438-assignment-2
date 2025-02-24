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
    
    // Zaid test for getLowerBound
    @Test
    public void testGetLowerBound_Zero() {
    	Range range = new Range(0,10);
    	assertEquals(0, range.getLowerBound(), 0.0);
    }
    
    @Test
    public void testGetLowerBound_Negative() {
    	Range range = new Range(-10,10);
    	assertEquals(-10, range.getLowerBound(), 0.0);
    }
    
    @Test
    public void testGetLowerBound_Positive() {
    	Range range = new Range(10,20);
    	assertEquals(10, range.getLowerBound(), 0.0);
    	    
    }
    
    // Tests for getUpperBound
    @Test
    public void testGetUpperBound_Zero() {
    	Range range = new Range(-10,0);
    	assertEquals(0, range.getUpperBound(), 0.0);
    }
   
    @Test
    public void testGetUpperBound_Negative() {
    	Range range = new Range(-10,-5);
    	assertEquals(-5, range.getUpperBound(), 0.0);
    }
    
    @Test
    public void testGetUpperBound_Positive() {
    	Range range = new Range(0,10);
    	assertEquals(10, range.getUpperBound(), 0.0);
    }
    
    // Test for getCentralValue
    @Test
    public void testGetCentralValue_Whole() {
    	Range range = new Range(0,10);
    	assertEquals(5, range.getCentralValue(), 0.0);
    }
    
    @Test
    public void testGetCentralValue_Fractional() {
    	Range range = new Range(1,2);
    	assertEquals(1.5, range.getCentralValue(), 0.0);
    }
}