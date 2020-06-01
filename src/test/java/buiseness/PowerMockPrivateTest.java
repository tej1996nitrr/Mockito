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
import org.powermock.reflect.Whitebox;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class PowerMockPrivateTest {
    @Mock
    Dependency dependencyMock;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void powerMockito_CallingAPrivateMethod() throws Exception {
        when(dependencyMock.retrieveAllStats()).thenReturn(
                Arrays.asList(1, 2, 3));
        long value = (Long) Whitebox.invokeMethod(systemUnderTest,
                "privateMethodUnderTest");
        assertEquals(6, value);
    }
}
