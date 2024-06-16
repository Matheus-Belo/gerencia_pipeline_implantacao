package matheusbelo.todosimple.CucumberConfiguracao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest(classes = SpringBootApplication.class)
public class CucumberSpringConfiguration {
}