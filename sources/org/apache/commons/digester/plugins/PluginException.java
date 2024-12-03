package org.apache.commons.digester.plugins;

public class PluginException extends Exception {
    private Throwable cause;

    public PluginException(Throwable th2) {
        this(th2.getMessage());
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public PluginException(String str) {
        super(str);
        this.cause = null;
    }

    public PluginException(String str, Throwable th2) {
        this(str);
        this.cause = th2;
    }
}
