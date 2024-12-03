package org.jivesoftware.smack.compression;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.compression.CompressionModule;
import org.jivesoftware.smack.fsm.StateDescriptor;

public class CompressionModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    /* access modifiers changed from: private */
    public static final CompressionModuleDescriptor INSTANCE = new CompressionModuleDescriptor();

    public static final class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        private Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        /* access modifiers changed from: protected */
        public ModularXmppClientToServerConnectionModuleDescriptor build() {
            return CompressionModuleDescriptor.INSTANCE;
        }
    }

    /* access modifiers changed from: protected */
    public Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        return Collections.singleton(CompressionModule.CompressionStateDescriptor.class);
    }

    /* access modifiers changed from: protected */
    public CompressionModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new CompressionModule(this, modularXmppClientToServerConnectionInternal);
    }
}
