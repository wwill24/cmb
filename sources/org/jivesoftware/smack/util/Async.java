package org.jivesoftware.smack.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Async {

    public static abstract class ThrowingRunnable implements Runnable {
        public static final Logger LOGGER = Logger.getLogger(ThrowingRunnable.class.getName());

        public final void run() {
            try {
                runOrThrow();
            } catch (Exception e10) {
                if (!(e10 instanceof RuntimeException)) {
                    LOGGER.log(Level.WARNING, "Caught Exception", e10);
                    return;
                }
                throw ((RuntimeException) e10);
            }
        }

        public abstract void runOrThrow() throws Exception;
    }

    public static Thread daemonThreadFrom(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    public static Thread go(Runnable runnable) {
        Thread daemonThreadFrom = daemonThreadFrom(runnable);
        daemonThreadFrom.start();
        return daemonThreadFrom;
    }

    public static Thread go(Runnable runnable, String str) {
        Thread daemonThreadFrom = daemonThreadFrom(runnable);
        daemonThreadFrom.setName(str);
        daemonThreadFrom.start();
        return daemonThreadFrom;
    }
}
