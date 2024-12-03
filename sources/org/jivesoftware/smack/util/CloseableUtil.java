package org.jivesoftware.smack.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloseableUtil {
    public static void maybeClose(Closeable closeable) {
        maybeClose(closeable, (Logger) null);
    }

    public static void maybeClose(Closeable closeable, Logger logger) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                if (logger != null) {
                    Level level = Level.WARNING;
                    logger.log(level, "Could not close " + closeable, e10);
                }
            }
        }
    }
}
