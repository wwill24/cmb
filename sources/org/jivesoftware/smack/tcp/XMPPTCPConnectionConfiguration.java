package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.ConnectionConfiguration;

public final class XMPPTCPConnectionConfiguration extends ConnectionConfiguration {
    public static int DEFAULT_CONNECT_TIMEOUT = 30000;
    private final int connectTimeout;

    public static final class Builder extends ConnectionConfiguration.Builder<Builder, XMPPTCPConnectionConfiguration> {
        /* access modifiers changed from: private */
        public int connectTimeout;

        /* access modifiers changed from: protected */
        public Builder getThis() {
            return this;
        }

        public Builder setConnectTimeout(int i10) {
            this.connectTimeout = i10;
            return this;
        }

        private Builder() {
            this.connectTimeout = XMPPTCPConnectionConfiguration.DEFAULT_CONNECT_TIMEOUT;
        }

        public XMPPTCPConnectionConfiguration build() {
            return new XMPPTCPConnectionConfiguration(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    private XMPPTCPConnectionConfiguration(Builder builder) {
        super(builder);
        this.connectTimeout = builder.connectTimeout;
    }
}
