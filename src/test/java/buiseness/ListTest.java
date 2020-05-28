package buiseness;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void testMockList()
    {
         List mocklist =mock(List.class);
         when(mocklist.size()).thenReturn(2);
         assertEquals(2,mocklist.size());

    }
    @Test
    public void testMockListMultiplevalues()
    {
        List mocklist =mock(List.class);
        when(mocklist.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,mocklist.size());
        assertEquals(3,mocklist.size());


    }

    @Test
    public void testMockListGETvalues()
    {
        List mocklist =mock(List.class);
        when(mocklist.get(0)).thenReturn("String");
        assertEquals("String",mocklist.get(0));


    }

    @Test(expected = RuntimeException.class)
    public void testMockListEx()
    {
        List mocklist =mock(List.class);
        when(mocklist.get(0)).thenThrow(new RuntimeException("Exception"));
//        assertEquals("String",mocklist.get(0));
        mocklist.get(0);


    }
}
