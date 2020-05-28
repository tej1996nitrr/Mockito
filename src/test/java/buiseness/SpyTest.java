package buiseness;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpyTest {
    @Test
    public void  test()
    {
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0,arrayListSpy.size());
        arrayListSpy.add("Test");
        assertEquals(1,arrayListSpy.size());
        arrayListSpy.remove("Test");
        assertEquals(0,arrayListSpy.size());

    }
    @Test
    public void  test2()
    {
        List arrayListSpy = spy(ArrayList.class);
        stub(arrayListSpy.size()).toReturn(5);//stub=>substitute/override
        assertEquals(5,arrayListSpy.size());

    }
}
