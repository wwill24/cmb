package org.jivesoftware.smack.tcp;

import java.util.HashSet;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.tcp.XmppTcpTransportModule;

public class XmppTcpTransportModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    private final boolean directTls;
    private final boolean startTls;

    public static final class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        /* access modifiers changed from: private */
        public boolean directTls = false;
        /* access modifiers changed from: private */
        public boolean startTls = true;

        private Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        public Builder disableDirectTls() {
            this.directTls = false;
            return this;
        }

        public Builder disableStartTls() {
            this.startTls = false;
            return this;
        }

        /* access modifiers changed from: protected */
        public XmppTcpTransportModuleDescriptor build() {
            return new XmppTcpTransportModuleDescriptor(this);
        }
    }

    public XmppTcpTransportModuleDescriptor(Builder builder) {
        this.startTls = builder.startTls;
        this.directTls = builder.directTls;
    }

    /* access modifiers changed from: protected */
    public Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        HashSet hashSet = new HashSet();
        hashSet.add(XmppTcpTransportModule.EstablishingTcpConnectionStateDescriptor.class);
        if (this.startTls) {
            hashSet.add(XmppTcpTransportModule.EstablishTlsStateDescriptor.class);
        }
        if (!this.directTls) {
            return hashSet;
        }
        throw new IllegalArgumentException("DirectTLS is not implemented yet");
    }

    public boolean isDirectTlsEnabled() {
        return this.directTls;
    }

    public boolean isStartTlsEnabled() {
        return this.startTls;
    }

    /* access modifiers changed from: protected */
    public XmppTcpTransportModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new XmppTcpTransportModule(this, modularXmppClientToServerConnectionInternal);
    }
}
