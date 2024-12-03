package org.apache.commons.digester.plugins;

public class PluginAssertionFailure extends RuntimeException {
    private Throwable cause;

    public PluginAssertionFailure(Throwable th2) {
        this(th2.getMessage());
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public PluginAssertionFailure(String str) {
        super(str);
        this.cause = null;
    }

    public PluginAssertionFailure(String str, Throwable th2) {
        this(str);
        this.cause = th2;
    }
}
