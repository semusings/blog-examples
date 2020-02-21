package io.github.bhuwanupadhyay.ordering;

import cucumber.api.CucumberOptions;
import io.github.bhuwanupadhyay.junit.FailFastCucumberRunner;
import org.junit.runner.RunWith;


@RunWith(FailFastCucumberRunner.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/payment-service.feature"},
        glue = {"io.github.bhuwanupadhyay.ordering"})
public class PaymentServiceFeatureTest {
}
