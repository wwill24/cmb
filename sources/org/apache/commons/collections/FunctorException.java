package org.apache.commons.collections;

import java.io.PrintStream;
import java.io.PrintWriter;

public class FunctorException extends RuntimeException {
    private static final boolean JDK_SUPPORTS_NESTED;
    static /* synthetic */ Class class$java$lang$Throwable;
    private final Throwable rootCause;

    static {
        boolean z10 = false;
        try {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            cls.getDeclaredMethod("getCause", new Class[0]);
            z10 = true;
        } catch (NoSuchMethodException unused) {
        }
        JDK_SUPPORTS_NESTED = z10;
    }

    public FunctorException() {
        this.rootCause = null;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public Throwable getCause() {
        return this.rootCause;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter(printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public FunctorException(String str) {
        super(str);
        this.rootCause = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctorException(Throwable th2) {
        super(th2 == null ? null : th2.getMessage());
        this.rootCause = th2;
    }

    public FunctorException(String str, Throwable th2) {
        super(str);
        this.rootCause = th2;
    }

    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            super.printStackTrace(printWriter);
            if (this.rootCause != null && !JDK_SUPPORTS_NESTED) {
                printWriter.print("Caused by: ");
                this.rootCause.printStackTrace(printWriter);
            }
        }
    }
}
