package org.jivesoftware.smack.c2s;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.util.CollectionUtil;

public final class ModularXmppClientToServerConnectionConfiguration extends ConnectionConfiguration {
    final StateDescriptorGraph.GraphVertex<StateDescriptor> initialStateDescriptorVertex;
    final Set<ModularXmppClientToServerConnectionModuleDescriptor> moduleDescriptors;

    public static final class Builder extends ConnectionConfiguration.Builder<Builder, ModularXmppClientToServerConnectionConfiguration> {
        /* access modifiers changed from: private */
        public final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, ModularXmppClientToServerConnectionModuleDescriptor> modulesDescriptors;

        /* access modifiers changed from: package-private */
        public void addModule(ModularXmppClientToServerConnectionModuleDescriptor modularXmppClientToServerConnectionModuleDescriptor) {
            Class<?> cls = modularXmppClientToServerConnectionModuleDescriptor.getClass();
            if (!this.modulesDescriptors.containsKey(cls)) {
                this.modulesDescriptors.put(cls, modularXmppClientToServerConnectionModuleDescriptor);
                return;
            }
            throw new IllegalArgumentException("A connection module for " + cls + " is already configured");
        }

        /* access modifiers changed from: protected */
        public Builder getThis() {
            return this;
        }

        public Builder removeAllModules() {
            this.modulesDescriptors.clear();
            return getThis();
        }

        public Builder removeModule(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
            this.modulesDescriptors.remove(cls);
            return getThis();
        }

        public <B extends ModularXmppClientToServerConnectionModuleDescriptor.Builder> B with(Class<? extends B> cls) {
            try {
                Constructor<? extends B> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Builder.class});
                declaredConstructor.setAccessible(true);
                try {
                    return (ModularXmppClientToServerConnectionModuleDescriptor.Builder) declaredConstructor.newInstance(new Object[]{this});
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e10) {
                    throw new IllegalArgumentException(e10);
                }
            } catch (NoSuchMethodException | SecurityException e11) {
                throw new IllegalArgumentException(e11);
            }
        }

        private Builder() {
            this.modulesDescriptors = new HashMap();
            SmackConfiguration.addAllKnownModulesTo(this);
        }

        public ModularXmppClientToServerConnectionConfiguration build() {
            return new ModularXmppClientToServerConnectionConfiguration(this);
        }

        public Builder addModule(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
            Class cls2;
            Class[] declaredClasses = cls.getDeclaredClasses();
            int length = declaredClasses.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    cls2 = null;
                    break;
                }
                cls2 = declaredClasses[i10];
                if (ModularXmppClientToServerConnectionModuleDescriptor.Builder.class.isAssignableFrom(cls2)) {
                    break;
                }
                i10++;
            }
            if (cls2 != null) {
                return with(cls2).buildModule();
            }
            throw new IllegalArgumentException("Found no builder for " + cls + ". Delcared classes: " + Arrays.toString(declaredClasses));
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getStateGraphInDotFormat() {
        StringWriter stringWriter = new StringWriter();
        printStateGraphInDotFormat(new PrintWriter(stringWriter), true);
        return stringWriter.toString();
    }

    public void printStateGraphInDotFormat(PrintWriter printWriter, boolean z10) {
        StateDescriptorGraph.stateDescriptorGraphToDot(Collections.singleton(this.initialStateDescriptorVertex), printWriter, z10);
    }

    private ModularXmppClientToServerConnectionConfiguration(Builder builder) {
        super(builder);
        Set<ModularXmppClientToServerConnectionModuleDescriptor> unmodifiableSet = Collections.unmodifiableSet(CollectionUtil.newSetWith(builder.modulesDescriptors.values()));
        this.moduleDescriptors = unmodifiableSet;
        HashSet hashSet = new HashSet();
        for (ModularXmppClientToServerConnectionModuleDescriptor stateDescriptors : unmodifiableSet) {
            hashSet.addAll(stateDescriptors.getStateDescriptors());
        }
        try {
            this.initialStateDescriptorVertex = StateDescriptorGraph.constructStateDescriptorGraph(hashSet);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e10) {
            throw new IllegalStateException(e10);
        }
    }
}
