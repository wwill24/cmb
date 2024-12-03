package org.jivesoftware.smack.bind2;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.bind2.Bind2Module;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;

public class Bind2ModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    /* access modifiers changed from: private */
    public static final Bind2ModuleDescriptor INSTANCE = new Bind2ModuleDescriptor();

    public static class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        protected Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        /* access modifiers changed from: protected */
        public Bind2ModuleDescriptor build() {
            return Bind2ModuleDescriptor.INSTANCE;
        }
    }

    /* access modifiers changed from: protected */
    public Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        return Collections.singleton(Bind2Module.Bind2StateDescriptor.class);
    }

    /* access modifiers changed from: protected */
    public Bind2Module constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new Bind2Module(this, modularXmppClientToServerConnectionInternal);
    }
}
