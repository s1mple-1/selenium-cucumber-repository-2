import com.aplana.chameleon.ChameleonCucumberRunner;
import com.aplana.chameleon.elements.selenium.Button;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Nikolay Streltsov on 02.09.2018
 */
@RunWith(ChameleonCucumberRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.aplana.chameleon"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
)
public class TestRunner {

}
