package net.bytebuddy.dynamic;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.NexusAccessor;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface TypeResolutionStrategy {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Active implements TypeResolutionStrategy {
        private final NexusAccessor nexusAccessor;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Resolved implements Resolved {
            private final int identification;
            private final NexusAccessor nexusAccessor;

            protected Resolved(NexusAccessor nexusAccessor2, int i10) {
                this.nexusAccessor = nexusAccessor2;
                this.identification = i10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Resolved resolved = (Resolved) obj;
                return this.identification == resolved.identification && this.nexusAccessor.equals(resolved.nexusAccessor);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.nexusAccessor.hashCode()) * 31) + this.identification;
            }

            public <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType dynamicType, @MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy) {
                HashMap hashMap = new HashMap(dynamicType.getLoadedTypeInitializers());
                TypeDescription typeDescription = dynamicType.getTypeDescription();
                Map<TypeDescription, Class<?>> load = classLoadingStrategy.load(s10, dynamicType.getAllTypes());
                this.nexusAccessor.register(typeDescription.getName(), load.get(typeDescription).getClassLoader(), this.identification, (LoadedTypeInitializer) hashMap.remove(typeDescription));
                for (Map.Entry entry : hashMap.entrySet()) {
                    ((LoadedTypeInitializer) entry.getValue()).onLoad(load.get(entry.getKey()));
                }
                return load;
            }

            public TypeInitializer injectedInto(TypeInitializer typeInitializer) {
                return typeInitializer.expandWith(new NexusAccessor.InitializationAppender(this.identification));
            }
        }

        public Active() {
            this(new NexusAccessor());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.nexusAccessor.equals(((Active) obj).nexusAccessor);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.nexusAccessor.hashCode();
        }

        @SuppressFBWarnings(justification = "Avoids thread-contention.", value = {"DMI_RANDOM_USED_ONLY_ONCE"})
        public Resolved resolve() {
            return new Resolved(this.nexusAccessor, new Random().nextInt());
        }

        public Active(NexusAccessor nexusAccessor2) {
            this.nexusAccessor = nexusAccessor2;
        }
    }

    public enum Disabled implements TypeResolutionStrategy, Resolved {
        INSTANCE;

        public <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType dynamicType, @MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy) {
            throw new IllegalStateException("Cannot initialize a dynamic type for a disabled type resolution strategy");
        }

        public TypeInitializer injectedInto(TypeInitializer typeInitializer) {
            return typeInitializer;
        }

        public Resolved resolve() {
            return this;
        }
    }

    public enum Lazy implements TypeResolutionStrategy, Resolved {
        INSTANCE;

        public <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType dynamicType, @MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy) {
            return classLoadingStrategy.load(s10, dynamicType.getAllTypes());
        }

        public TypeInitializer injectedInto(TypeInitializer typeInitializer) {
            return typeInitializer;
        }

        public Resolved resolve() {
            return this;
        }
    }

    public enum Passive implements TypeResolutionStrategy, Resolved {
        INSTANCE;

        public <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType dynamicType, @MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy) {
            Map<TypeDescription, Class<?>> load = classLoadingStrategy.load(s10, dynamicType.getAllTypes());
            for (Map.Entry next : dynamicType.getLoadedTypeInitializers().entrySet()) {
                ((LoadedTypeInitializer) next.getValue()).onLoad(load.get(next.getKey()));
            }
            return new HashMap(load);
        }

        public TypeInitializer injectedInto(TypeInitializer typeInitializer) {
            return typeInitializer;
        }

        public Resolved resolve() {
            return this;
        }
    }

    public interface Resolved {
        <S extends ClassLoader> Map<TypeDescription, Class<?>> initialize(DynamicType dynamicType, @MaybeNull S s10, ClassLoadingStrategy<? super S> classLoadingStrategy);

        TypeInitializer injectedInto(TypeInitializer typeInitializer);
    }

    Resolved resolve();
}
