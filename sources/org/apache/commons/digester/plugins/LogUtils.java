package org.apache.commons.digester.plugins;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.NoOpLog;

class LogUtils {
    LogUtils() {
    }

    static Log getLogger(Digester digester) {
        if (digester == null) {
            return new NoOpLog();
        }
        return digester.getLogger();
    }
}
