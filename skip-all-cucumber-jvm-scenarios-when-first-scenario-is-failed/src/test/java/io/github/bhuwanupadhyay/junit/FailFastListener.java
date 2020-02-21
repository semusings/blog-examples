package io.github.bhuwanupadhyay.junit;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.logging.Logger;

public class FailFastListener extends RunListener {

    private static final Logger LOG = Logger.getLogger(FailFastListener.class.getName());

    @Override
    public void testFailure(Failure failure) throws Exception {
        LOG.info("Failed: " + failure.getTrace());
        super.testFailure(failure);
        System.exit(-1);
    }

}
