package org.apache.commons.digester.plugins;

public class PluginInvalidInputException extends PluginException {
    private Throwable cause;

    public PluginInvalidInputException(Throwable th2) {
        this(th2.getMessage());
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public PluginInvalidInputException(String str) {
        super(str);
        this.cause = null;
    }

    public PluginInvalidInputException(String str, Throwable th2) {
        this(str);
        this.cause = th2;
    }
}
