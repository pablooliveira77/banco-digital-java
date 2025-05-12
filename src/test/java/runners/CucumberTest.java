package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features") // onde estão os arquivos .feature
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps") // onde estão os steps
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") // para imprimir os resultados no console
public class CucumberTest {}

