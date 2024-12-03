package org.jivesoftware.smack.c2s;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;

public abstract class ModularXmppClientToServerConnectionModule<MD extends ModularXmppClientToServerConnectionModuleDescriptor> {
    protected final ModularXmppClientToServerConnectionInternal connectionInternal;
    protected final MD moduleDescriptor;

    protected ModularXmppClientToServerConnectionModule(MD md2, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        this.moduleDescriptor = md2;
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
    }

    public MD getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    /* access modifiers changed from: protected */
    public XmppClientToServerTransport getTransport() {
        return null;
    }
}
