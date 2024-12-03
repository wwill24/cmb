package org.jivesoftware.smack.debugger;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.ExceptionUtil;

public class ConsoleDebugger extends AbstractDebugger {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");

    public static final class Factory implements SmackDebuggerFactory {
        public static final SmackDebuggerFactory INSTANCE = new Factory();

        private Factory() {
        }

        public SmackDebugger create(XMPPConnection xMPPConnection) throws IllegalArgumentException {
            return new ConsoleDebugger(xMPPConnection);
        }
    }

    public ConsoleDebugger(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        String format2;
        synchronized (this.dateFormatter) {
            format2 = this.dateFormatter.format(new Date());
        }
        PrintStream printStream = System.out;
        printStream.println(format2 + ' ' + str);
    }

    /* access modifiers changed from: protected */
    public void log(String str, Throwable th2) {
        String stackTrace = ExceptionUtil.getStackTrace(th2);
        log(str + 10 + stackTrace);
    }
}
