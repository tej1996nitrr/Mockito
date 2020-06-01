package buiseness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;

import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SystemUnderTest.class
        /*To be able to mock the Constructor, we need to add in the Class that creates the new object*/})
public class PowerMockConstructorTest {
    private static final int SOME_DUMMY_SIZE = 10;

    @Mock
    ArrayList mockList;
    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void powerMockito_CallingAPrivateMethod() throws Exception {
        List<Integer> stats = Arrays.asList(1, 2, 3);
        when(mockList.size()).thenReturn(10);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
        int size = systemUnderTest.methodUsingAnArrayListConstructor();

        assertEquals(SOME_DUMMY_SIZE, size);
    }
}