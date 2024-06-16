package matheusbelo.todosimple.CucumberConfiguracao;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/resources", glue={"matheusbelo.todosimple.PecienteSteps", "matheusbelo.todosimple.CucumberConfiguracao"}, monochrome = true)
public class CucumberRunner {
}