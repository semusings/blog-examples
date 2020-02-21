package io.github.bhuwanupadhyay.junit;

import cucumber.api.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class FailFastCucumberRunner extends Cucumber {

    /**
     * Constructor called by JUnit.
     *
     * @param clazz the class with the @RunWith annotation.
     * @throws InitializationError if there is another problem
     */
    public FailFastCucumberRunner(Class clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new SafeFailFastListener(notifier));
        super.run(notifier);
    }

}
