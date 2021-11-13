import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import powerhouse.Jake;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Jake.class)
public class Joker {

    @Test
    public void jakeTest() throws Exception {
        Jake jake = new Jake();
        Jake jakeSpy = PowerMockito.spy(jake);
        PowerMockito.doReturn(true).when(jakeSpy, "isNewMethod", "abcd");
        PowerMockito.doNothing().when(jakeSpy, "performDB", Mockito.any(), Mockito.any(), Mockito.any(), Mockito.anyInt());
        jakeSpy.sendRequest("json", "abcde");
    }
}
