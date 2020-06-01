package buiseness;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class PowerMockTest {
    //specify runner - PowerMockRunner
    //initialize the class to mock - PrepareForTest, PowerMockito.mockStatic(UtilityClass.class);
    //mock
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    Dependency dependency;
    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public  void MockingStaticMethodTest()
    {
        when(dependency.retrieveAllStats()).thenReturn(
                Arrays.asList(1, 2, 3));
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
        assertEquals(150, systemUnderTest.methodCallingAStaticMethod());

        //To verify a specific method call
        //First : Call PowerMockito.verifyStatic()
        //Second : Call the method to be verified
        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(1 + 2 + 3);

        // verify exact number of calls
        //PowerMockito.verifyStatic(Mockito.times(1));

    }
}
