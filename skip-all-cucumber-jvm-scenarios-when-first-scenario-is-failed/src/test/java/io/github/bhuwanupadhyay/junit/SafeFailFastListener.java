package io.github.bhuwanupadhyay.junit;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import java.util.logging.Logger;

public class SafeFailFastListener extends RunListener {

    private static final Logger LOG = Logger.getLogger(FailFastListener.class.getName());

    private final RunNotifier notifier;

    public SafeFailFastListener(RunNotifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        LOG.info("FAILED: " + failure.getTrace());
        super.testFailure(failure);
        notifier.pleaseStop();
    }

}
