package org.jivesoftware.smack.sm;

import java.util.HashSet;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.sm.StreamManagementModule;

public class StreamManagementModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    /* access modifiers changed from: private */
    public static final StreamManagementModuleDescriptor INSTANCE = new StreamManagementModuleDescriptor();

    public static class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        protected Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        /* access modifiers changed from: protected */
        public StreamManagementModuleDescriptor build() {
            return StreamManagementModuleDescriptor.INSTANCE;
        }
    }

    /* access modifiers changed from: protected */
    public Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        HashSet hashSet = new HashSet();
        hashSet.add(StreamManagementModule.EnableStreamManagementStateDescriptor.class);
        hashSet.add(StreamManagementModule.ResumeStreamStateDescriptor.class);
        return hashSet;
    }

    /* access modifiers changed from: protected */
    public StreamManagementModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new StreamManagementModule(this, modularXmppClientToServerConnectionInternal);
    }
}
