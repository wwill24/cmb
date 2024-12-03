package org.jivesoftware.smack.isr;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.isr.InstantStreamResumptionModule;

public class InstantStreamResumptionModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    /* access modifiers changed from: private */
    public static final InstantStreamResumptionModuleDescriptor INSTANCE = new InstantStreamResumptionModuleDescriptor();

    public static final class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        private Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        /* access modifiers changed from: protected */
        public ModularXmppClientToServerConnectionModuleDescriptor build() {
            return InstantStreamResumptionModuleDescriptor.INSTANCE;
        }
    }

    /* access modifiers changed from: protected */
    public Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        return Collections.singleton(InstantStreamResumptionModule.InstantStreamResumptionStateDescriptor.class);
    }

    /* access modifiers changed from: protected */
    public InstantStreamResumptionModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new InstantStreamResumptionModule(this, modularXmppClientToServerConnectionInternal);
    }
}
