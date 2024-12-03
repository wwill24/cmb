package org.jivesoftware.smack.c2s;

import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;

public abstract class ModularXmppClientToServerConnectionModuleDescriptor {

    public static abstract class Builder {
        private final ModularXmppClientToServerConnectionConfiguration.Builder connectionConfigurationBuilder;

        protected Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            this.connectionConfigurationBuilder = builder;
        }

        /* access modifiers changed from: protected */
        public abstract ModularXmppClientToServerConnectionModuleDescriptor build();

        public ModularXmppClientToServerConnectionConfiguration.Builder buildModule() {
            this.connectionConfigurationBuilder.addModule(build());
            return this.connectionConfigurationBuilder;
        }
    }

    /* access modifiers changed from: protected */
    public abstract ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor> constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal);

    /* access modifiers changed from: protected */
    public abstract Set<Class<? extends StateDescriptor>> getStateDescriptors();
}
