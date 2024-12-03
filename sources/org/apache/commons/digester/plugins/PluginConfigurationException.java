package org.apache.commons.digester.plugins;

public class PluginConfigurationException extends RuntimeException {
    private Throwable cause;

    public PluginConfigurationException(Throwable th2) {
        this(th2.getMessage());
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public PluginConfigurationException(String str) {
        super(str);
        this.cause = null;
    }

    public PluginConfigurationException(String str, Throwable th2) {
        this(str);
        this.cause = th2;
    }
}
