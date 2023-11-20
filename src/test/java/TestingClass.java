import com.javapointers.sikuli.SikuliAutomation;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class TestingClass {
    @Test
    public void test(){
        try {
            SikuliAutomation.main(null);
        } catch (FindFailed e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
