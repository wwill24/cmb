package net.bytebuddy.dynamic.loading;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;

public class MultipleParentClassLoader extends InjectionClassLoader {
    private final List<? extends ClassLoader> parents;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Builder {
        private final List<? extends ClassLoader> classLoaders;
        private final boolean sealed;

        public Builder() {
            this(true);
        }

        @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        private ClassLoader doBuild(@MaybeNull ClassLoader classLoader) {
            return new MultipleParentClassLoader(classLoader, this.classLoaders, this.sealed);
        }

        public Builder append(Class<?>... clsArr) {
            return append((Collection<? extends Class<?>>) Arrays.asList(clsArr));
        }

        public Builder appendMostSpecific(Class<?>... clsArr) {
            return appendMostSpecific((Collection<? extends Class<?>>) Arrays.asList(clsArr));
        }

        public ClassLoader build() {
            if (this.classLoaders.size() == 1) {
                return (ClassLoader) this.classLoaders.get(0);
            }
            return doBuild(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            return this.sealed == builder.sealed && this.classLoaders.equals(builder.classLoaders);
        }

        public Builder filter(ElementMatcher<? super ClassLoader> elementMatcher) {
            ArrayList arrayList = new ArrayList(this.classLoaders.size());
            for (ClassLoader classLoader : this.classLoaders) {
                if (elementMatcher.matches(classLoader)) {
                    arrayList.add(classLoader);
                }
            }
            return new Builder(arrayList, this.sealed);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + (this.sealed ? 1 : 0)) * 31) + this.classLoaders.hashCode();
        }

        public Builder(boolean z10) {
            this(Collections.emptyList(), z10);
        }

        public Builder append(Collection<? extends Class<?>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (Class classLoader : collection) {
                arrayList.add(classLoader.getClassLoader());
            }
            return append((List<? extends ClassLoader>) arrayList);
        }

        public Builder appendMostSpecific(Collection<? extends Class<?>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (Class classLoader : collection) {
                arrayList.add(classLoader.getClassLoader());
            }
            return appendMostSpecific((List<? extends ClassLoader>) arrayList);
        }

        private Builder(List<? extends ClassLoader> list, boolean z10) {
            this.classLoaders = list;
            this.sealed = z10;
        }

        public ClassLoader build(ClassLoader classLoader) {
            if (!this.classLoaders.isEmpty()) {
                return (this.classLoaders.size() != 1 || !this.classLoaders.contains(classLoader)) ? filter(ElementMatchers.not(ElementMatchers.is((Object) classLoader))).doBuild(classLoader) : classLoader;
            }
            return classLoader;
        }

        public Builder append(ClassLoader... classLoaderArr) {
            return append((List<? extends ClassLoader>) Arrays.asList(classLoaderArr));
        }

        public Builder appendMostSpecific(ClassLoader... classLoaderArr) {
            return appendMostSpecific((List<? extends ClassLoader>) Arrays.asList(classLoaderArr));
        }

        public Builder append(List<? extends ClassLoader> list) {
            ArrayList arrayList = new ArrayList(this.classLoaders.size() + list.size());
            arrayList.addAll(this.classLoaders);
            HashSet hashSet = new HashSet(this.classLoaders);
            for (ClassLoader classLoader : list) {
                if (classLoader != null && hashSet.add(classLoader)) {
                    arrayList.add(classLoader);
                }
            }
            return new Builder(arrayList, this.sealed);
        }

        public Builder appendMostSpecific(List<? extends ClassLoader> list) {
            ArrayList arrayList = new ArrayList(this.classLoaders.size() + list.size());
            arrayList.addAll(this.classLoaders);
            for (ClassLoader classLoader : list) {
                if (classLoader != null) {
                    ClassLoader classLoader2 = classLoader;
                    do {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (((ClassLoader) it.next()).equals(classLoader2)) {
                                it.remove();
                            }
                        }
                        classLoader2 = classLoader2.getParent();
                    } while (classLoader2 != null);
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            arrayList.add(classLoader);
                            break;
                        }
                        ClassLoader classLoader3 = (ClassLoader) it2.next();
                        while (true) {
                            if (classLoader3.equals(classLoader)) {
                                break;
                            }
                            classLoader3 = classLoader3.getParent();
                            if (classLoader3 == null) {
                            }
                        }
                    }
                }
            }
            return new Builder(arrayList, this.sealed);
        }
    }

    protected static class CompoundEnumeration implements Enumeration<URL> {
        private static final int FIRST = 0;
        @UnknownNull
        private Enumeration<URL> current;
        private final List<Enumeration<URL>> enumerations;

        protected CompoundEnumeration(List<Enumeration<URL>> list) {
            this.enumerations = list;
        }

        public boolean hasMoreElements() {
            Enumeration<URL> enumeration = this.current;
            if (enumeration != null && enumeration.hasMoreElements()) {
                return true;
            }
            if (this.enumerations.isEmpty()) {
                return false;
            }
            this.current = this.enumerations.remove(0);
            return hasMoreElements();
        }

        @SuppressFBWarnings(justification = "Null reference is avoided by element check.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
        public URL nextElement() {
            if (hasMoreElements()) {
                return this.current.nextElement();
            }
            throw new NoSuchElementException();
        }
    }

    static {
        doRegisterAsParallelCapable();
    }

    public MultipleParentClassLoader(List<? extends ClassLoader> list) {
        this(ClassLoadingStrategy.BOOTSTRAP_LOADER, list);
    }

    @SuppressFBWarnings(justification = "Must be invoked from targeting class loader type.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
    private static void doRegisterAsParallelCapable() {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Class<?>> doDefineClasses(Map<String, byte[]> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), defineClass((String) next.getKey(), (byte[]) next.getValue(), 0, ((byte[]) next.getValue()).length));
        }
        return hashMap;
    }

    public URL getResource(String str) {
        for (ClassLoader resource : this.parents) {
            URL resource2 = resource.getResource(str);
            if (resource2 != null) {
                return resource2;
            }
        }
        return super.getResource(str);
    }

    public Enumeration<URL> getResources(String str) throws IOException {
        ArrayList arrayList = new ArrayList(this.parents.size() + 1);
        for (ClassLoader resources : this.parents) {
            arrayList.add(resources.getResources(str));
        }
        arrayList.add(super.getResources(str));
        return new CompoundEnumeration(arrayList);
    }

    /* access modifiers changed from: protected */
    public Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        for (ClassLoader loadClass : this.parents) {
            try {
                Class<?> loadClass2 = loadClass.loadClass(str);
                if (z10) {
                    resolveClass(loadClass2);
                }
                return loadClass2;
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z10);
    }

    public MultipleParentClassLoader(@MaybeNull ClassLoader classLoader, List<? extends ClassLoader> list) {
        this(classLoader, list, true);
    }

    public MultipleParentClassLoader(@MaybeNull ClassLoader classLoader, List<? extends ClassLoader> list, boolean z10) {
        super(classLoader, z10);
        this.parents = list;
    }
}
