package net.bytebuddy.pool;

import androidx.camera.view.h;
import com.google.firebase.sessions.settings.RemoteSettings;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.TypeReference;
import net.bytebuddy.jar.asm.signature.SignatureReader;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;

public interface TypePool {

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AbstractBase implements TypePool {
        private static final String ARRAY_SYMBOL = "[";
        protected static final Map<String, String> PRIMITIVE_DESCRIPTORS;
        protected static final Map<String, TypeDescription> PRIMITIVE_TYPES;
        protected final CacheProvider cacheProvider;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ArrayTypeResolution implements Resolution {
            private final int arity;
            private final Resolution resolution;

            protected ArrayTypeResolution(Resolution resolution2, int i10) {
                this.resolution = resolution2;
                this.arity = i10;
            }

            protected static Resolution of(Resolution resolution2, int i10) {
                return i10 == 0 ? resolution2 : new ArrayTypeResolution(resolution2, i10);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ArrayTypeResolution arrayTypeResolution = (ArrayTypeResolution) obj;
                return this.arity == arrayTypeResolution.arity && this.resolution.equals(arrayTypeResolution.resolution);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.resolution.hashCode()) * 31) + this.arity;
            }

            public boolean isResolved() {
                return this.resolution.isResolved();
            }

            public TypeDescription resolve() {
                return TypeDescription.ArrayProjection.of(this.resolution.resolve(), this.arity);
            }
        }

        protected interface ComponentTypeReference {
            @MaybeNull
            public static final String NO_ARRAY = null;

            @MaybeNull
            String resolve();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class Hierarchical extends AbstractBase {
            private final TypePool parent;

            protected Hierarchical(CacheProvider cacheProvider, TypePool typePool) {
                super(cacheProvider);
                this.parent = typePool;
            }

            public void clear() {
                try {
                    this.parent.clear();
                } finally {
                    super.clear();
                }
            }

            public Resolution describe(String str) {
                Resolution describe = this.parent.describe(str);
                if (describe.isResolved()) {
                    return describe;
                }
                return super.describe(str);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.parent.equals(((Hierarchical) obj).parent);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.parent.hashCode();
            }
        }

        static {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
            for (int i10 = 0; i10 < 9; i10++) {
                Class cls = clsArr[i10];
                hashMap.put(cls.getName(), TypeDescription.ForLoadedType.of(cls));
                hashMap2.put(Type.getDescriptor(cls), cls.getName());
            }
            PRIMITIVE_TYPES = Collections.unmodifiableMap(hashMap);
            PRIMITIVE_DESCRIPTORS = Collections.unmodifiableMap(hashMap2);
        }

        protected AbstractBase(CacheProvider cacheProvider2) {
            this.cacheProvider = cacheProvider2;
        }

        public void clear() {
            this.cacheProvider.clear();
        }

        public Resolution describe(String str) {
            Resolution resolution;
            if (!str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                int i10 = 0;
                while (str.startsWith(ARRAY_SYMBOL)) {
                    i10++;
                    str = str.substring(1);
                }
                if (i10 > 0) {
                    String str2 = PRIMITIVE_DESCRIPTORS.get(str);
                    if (str2 == null) {
                        str = str.substring(1, str.length() - 1);
                    } else {
                        str = str2;
                    }
                }
                TypeDescription typeDescription = PRIMITIVE_TYPES.get(str);
                if (typeDescription == null) {
                    resolution = this.cacheProvider.find(str);
                } else {
                    resolution = new Resolution.Simple(typeDescription);
                }
                if (resolution == null) {
                    resolution = doCache(str, doDescribe(str));
                }
                return ArrayTypeResolution.of(resolution, i10);
            }
            throw new IllegalArgumentException(str + " contains the illegal character '/'");
        }

        /* access modifiers changed from: protected */
        public Resolution doCache(String str, Resolution resolution) {
            return this.cacheProvider.register(str, resolution);
        }

        /* access modifiers changed from: protected */
        public abstract Resolution doDescribe(String str);

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cacheProvider.equals(((AbstractBase) obj).cacheProvider);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.cacheProvider.hashCode();
        }
    }

    public interface CacheProvider {
        @MaybeNull
        public static final Resolution UNRESOLVED = null;

        public static class Discriminating implements CacheProvider {
            private final CacheProvider matched;
            private final ElementMatcher<String> matcher;
            private final CacheProvider unmatched;

            public Discriminating(ElementMatcher<String> elementMatcher, CacheProvider cacheProvider, CacheProvider cacheProvider2) {
                this.matcher = elementMatcher;
                this.matched = cacheProvider;
                this.unmatched = cacheProvider2;
            }

            public void clear() {
                try {
                    this.unmatched.clear();
                } finally {
                    this.matched.clear();
                }
            }

            @MaybeNull
            public Resolution find(String str) {
                return (this.matcher.matches(str) ? this.matched : this.unmatched).find(str);
            }

            public Resolution register(String str, Resolution resolution) {
                return (this.matcher.matches(str) ? this.matched : this.unmatched).register(str, resolution);
            }
        }

        public enum NoOp implements CacheProvider {
            INSTANCE;

            public void clear() {
            }

            @MaybeNull
            public Resolution find(String str) {
                return CacheProvider.UNRESOLVED;
            }

            public Resolution register(String str, Resolution resolution) {
                return resolution;
            }
        }

        public static class Simple implements CacheProvider {
            private final ConcurrentMap<String, Resolution> storage;

            public static class UsingSoftReference implements CacheProvider {
                private final AtomicReference<SoftReference<Simple>> delegate = new AtomicReference<>(new SoftReference(new Simple()));

                public void clear() {
                    CacheProvider cacheProvider = (CacheProvider) this.delegate.get().get();
                    if (cacheProvider != null) {
                        cacheProvider.clear();
                    }
                }

                @MaybeNull
                public Resolution find(String str) {
                    CacheProvider cacheProvider = (CacheProvider) this.delegate.get().get();
                    if (cacheProvider == null) {
                        return CacheProvider.UNRESOLVED;
                    }
                    return cacheProvider.find(str);
                }

                public Resolution register(String str, Resolution resolution) {
                    SoftReference softReference = this.delegate.get();
                    Simple simple = (Simple) softReference.get();
                    if (simple == null) {
                        simple = new Simple();
                        while (true) {
                            if (h.a(this.delegate, softReference, new SoftReference(simple))) {
                                break;
                            }
                            softReference = this.delegate.get();
                            Simple simple2 = (Simple) softReference.get();
                            if (simple2 != null) {
                                simple = simple2;
                                break;
                            }
                        }
                    }
                    return simple.register(str, resolution);
                }
            }

            public Simple() {
                this(new ConcurrentHashMap());
            }

            public static CacheProvider withObjectType() {
                Class<Object> cls = Object.class;
                Simple simple = new Simple();
                simple.register(cls.getName(), new Resolution.Simple(TypeDescription.ForLoadedType.of(cls)));
                return simple;
            }

            public void clear() {
                this.storage.clear();
            }

            @MaybeNull
            public Resolution find(String str) {
                return this.storage.get(str);
            }

            public ConcurrentMap<String, Resolution> getStorage() {
                return this.storage;
            }

            public Resolution register(String str, Resolution resolution) {
                Resolution putIfAbsent = this.storage.putIfAbsent(str, resolution);
                return putIfAbsent == null ? resolution : putIfAbsent;
            }

            public Simple(ConcurrentMap<String, Resolution> concurrentMap) {
                this.storage = concurrentMap;
            }
        }

        void clear();

        @MaybeNull
        Resolution find(String str);

        Resolution register(String str, Resolution resolution);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ClassLoading extends AbstractBase.Hierarchical {
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        @MaybeNull
        private final ClassLoader classLoader;

        public ClassLoading(CacheProvider cacheProvider, TypePool typePool, @MaybeNull ClassLoader classLoader2) {
            super(cacheProvider, typePool);
            this.classLoader = classLoader2;
        }

        public static TypePool of(@MaybeNull ClassLoader classLoader2) {
            return of(classLoader2, Empty.INSTANCE);
        }

        public static TypePool ofBootLoader() {
            return of(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static TypePool ofPlatformLoader() {
            return of(ClassLoader.getSystemClassLoader().getParent());
        }

        public static TypePool ofSystemLoader() {
            return of(ClassLoader.getSystemClassLoader());
        }

        /* access modifiers changed from: protected */
        public Resolution doDescribe(String str) {
            try {
                return new Resolution.Simple(TypeDescription.ForLoadedType.of(Class.forName(str, false, this.classLoader)));
            } catch (ClassNotFoundException unused) {
                return new Resolution.Illegal(str);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
            /*
                r4 = this;
                boolean r0 = super.equals(r5)
                r1 = 0
                if (r0 != 0) goto L_0x0008
                return r1
            L_0x0008:
                r0 = 1
                if (r4 != r5) goto L_0x000c
                return r0
            L_0x000c:
                if (r5 != 0) goto L_0x000f
                return r1
            L_0x000f:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L_0x001a
                return r1
            L_0x001a:
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.pool.TypePool$ClassLoading r5 = (net.bytebuddy.pool.TypePool.ClassLoading) r5
                java.lang.ClassLoader r5 = r5.classLoader
                if (r5 == 0) goto L_0x002b
                if (r2 == 0) goto L_0x002d
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x002e
                return r1
            L_0x002b:
                if (r2 == 0) goto L_0x002e
            L_0x002d:
                return r1
            L_0x002e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.pool.TypePool.ClassLoading.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            ClassLoader classLoader2 = this.classLoader;
            return classLoader2 != null ? hashCode + classLoader2.hashCode() : hashCode;
        }

        public static TypePool of(@MaybeNull ClassLoader classLoader2, TypePool typePool) {
            return new ClassLoading(new CacheProvider.Simple(), typePool, classLoader2);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default extends AbstractBase.Hierarchical {
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final MethodVisitor IGNORE_METHOD = null;
        protected final ClassFileLocator classFileLocator;
        protected final ReaderMode readerMode;

        protected interface AnnotationRegistrant {

            public static abstract class AbstractBase implements AnnotationRegistrant {
                private final String descriptor;
                private final Map<String, AnnotationValue<?, ?>> values = new HashMap();

                protected static abstract class ForTypeVariable extends AbstractBase {
                    private final String typePath;

                    protected static abstract class WithIndex extends ForTypeVariable {
                        private final int index;

                        protected static abstract class DoubleIndexed extends WithIndex {
                            private final int preIndex;

                            protected DoubleIndexed(String str, @MaybeNull TypePath typePath, int i10, int i11) {
                                super(str, typePath, i10);
                                this.preIndex = i11;
                            }

                            /* access modifiers changed from: protected */
                            public abstract Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap();

                            /* access modifiers changed from: protected */
                            public Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
                                Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap = getDoubleIndexedPathMap();
                                Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map = doubleIndexedPathMap.get(Integer.valueOf(this.preIndex));
                                if (map != null) {
                                    return map;
                                }
                                HashMap hashMap = new HashMap();
                                doubleIndexedPathMap.put(Integer.valueOf(this.preIndex), hashMap);
                                return hashMap;
                            }
                        }

                        protected WithIndex(String str, @MaybeNull TypePath typePath, int i10) {
                            super(str, typePath);
                            this.index = i10;
                        }

                        /* access modifiers changed from: protected */
                        public abstract Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap();

                        /* access modifiers changed from: protected */
                        public Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap() {
                            Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap = getIndexedPathMap();
                            Map<String, List<LazyTypeDescription.AnnotationToken>> map = indexedPathMap.get(Integer.valueOf(this.index));
                            if (map != null) {
                                return map;
                            }
                            HashMap hashMap = new HashMap();
                            indexedPathMap.put(Integer.valueOf(this.index), hashMap);
                            return hashMap;
                        }
                    }

                    protected ForTypeVariable(String str, @MaybeNull TypePath typePath2) {
                        super(str);
                        String str2;
                        if (typePath2 == null) {
                            str2 = "";
                        } else {
                            str2 = typePath2.toString();
                        }
                        this.typePath = str2;
                    }

                    /* access modifiers changed from: protected */
                    public abstract Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap();

                    /* access modifiers changed from: protected */
                    public List<LazyTypeDescription.AnnotationToken> getTokens() {
                        Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap = getPathMap();
                        List<LazyTypeDescription.AnnotationToken> list = pathMap.get(this.typePath);
                        if (list != null) {
                            return list;
                        }
                        ArrayList arrayList = new ArrayList();
                        pathMap.put(this.typePath, arrayList);
                        return arrayList;
                    }
                }

                protected AbstractBase(String str) {
                    this.descriptor = str;
                }

                /* access modifiers changed from: protected */
                public abstract List<LazyTypeDescription.AnnotationToken> getTokens();

                public void onComplete() {
                    getTokens().add(new LazyTypeDescription.AnnotationToken(this.descriptor, this.values));
                }

                public void register(String str, AnnotationValue<?, ?> annotationValue) {
                    this.values.put(str, annotationValue);
                }
            }

            public static class ForByteCodeElement extends AbstractBase {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens;

                public static class WithIndex extends AbstractBase {
                    private final Map<Integer, List<LazyTypeDescription.AnnotationToken>> annotationTokens;
                    private final int index;

                    protected WithIndex(String str, int i10, Map<Integer, List<LazyTypeDescription.AnnotationToken>> map) {
                        super(str);
                        this.index = i10;
                        this.annotationTokens = map;
                    }

                    /* access modifiers changed from: protected */
                    public List<LazyTypeDescription.AnnotationToken> getTokens() {
                        List<LazyTypeDescription.AnnotationToken> list = this.annotationTokens.get(Integer.valueOf(this.index));
                        if (list != null) {
                            return list;
                        }
                        ArrayList arrayList = new ArrayList();
                        this.annotationTokens.put(Integer.valueOf(this.index), arrayList);
                        return arrayList;
                    }
                }

                protected ForByteCodeElement(String str, List<LazyTypeDescription.AnnotationToken> list) {
                    super(str);
                    this.annotationTokens = list;
                }

                /* access modifiers changed from: protected */
                public List<LazyTypeDescription.AnnotationToken> getTokens() {
                    return this.annotationTokens;
                }
            }

            public static class ForTypeVariable extends AbstractBase.ForTypeVariable {
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap;

                public static class WithIndex extends AbstractBase.ForTypeVariable.WithIndex {
                    private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap;

                    public static class DoubleIndexed extends AbstractBase.ForTypeVariable.WithIndex.DoubleIndexed {
                        private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap;

                        protected DoubleIndexed(String str, @MaybeNull TypePath typePath, int i10, int i11, Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> map) {
                            super(str, typePath, i10, i11);
                            this.doubleIndexedPathMap = map;
                        }

                        /* access modifiers changed from: protected */
                        public Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap() {
                            return this.doubleIndexedPathMap;
                        }
                    }

                    protected WithIndex(String str, @MaybeNull TypePath typePath, int i10, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map) {
                        super(str, typePath, i10);
                        this.indexedPathMap = map;
                    }

                    /* access modifiers changed from: protected */
                    public Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
                        return this.indexedPathMap;
                    }
                }

                protected ForTypeVariable(String str, @MaybeNull TypePath typePath, Map<String, List<LazyTypeDescription.AnnotationToken>> map) {
                    super(str, typePath);
                    this.pathMap = map;
                }

                /* access modifiers changed from: protected */
                public Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap() {
                    return this.pathMap;
                }
            }

            void onComplete();

            void register(String str, AnnotationValue<?, ?> annotationValue);
        }

        protected interface ComponentTypeLocator {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForAnnotationProperty implements ComponentTypeLocator {
                /* access modifiers changed from: private */
                public final String annotationName;
                /* access modifiers changed from: private */
                public final TypePool typePool;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class Bound implements AbstractBase.ComponentTypeReference {
                    private final String name;

                    protected Bound(String str) {
                        this.name = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.name.equals(bound.name) && ForAnnotationProperty.this.equals(ForAnnotationProperty.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + ForAnnotationProperty.this.hashCode();
                    }

                    @MaybeNull
                    public String resolve() {
                        TypeDescription componentType = ((MethodDescription.InDefinedShape) ((MethodList) ForAnnotationProperty.this.typePool.describe(ForAnnotationProperty.this.annotationName).resolve().getDeclaredMethods().filter(ElementMatchers.named(this.name))).getOnly()).getReturnType().asErasure().getComponentType();
                        if (componentType == null) {
                            return AbstractBase.ComponentTypeReference.NO_ARRAY;
                        }
                        return componentType.getName();
                    }
                }

                public ForAnnotationProperty(TypePool typePool2, String str) {
                    this.typePool = typePool2;
                    this.annotationName = str.substring(1, str.length() - 1).replace('/', '.');
                }

                public AbstractBase.ComponentTypeReference bind(String str) {
                    return new Bound(str);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForAnnotationProperty forAnnotationProperty = (ForAnnotationProperty) obj;
                    return this.annotationName.equals(forAnnotationProperty.annotationName) && this.typePool.equals(forAnnotationProperty.typePool);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.typePool.hashCode()) * 31) + this.annotationName.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForArrayType implements ComponentTypeLocator, AbstractBase.ComponentTypeReference {
                private final String componentType;

                public ForArrayType(String str) {
                    String className = Type.getMethodType(str).getReturnType().getClassName();
                    this.componentType = className.substring(0, className.length() - 2);
                }

                public AbstractBase.ComponentTypeReference bind(String str) {
                    return this;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((ForArrayType) obj).componentType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.componentType.hashCode();
                }

                public String resolve() {
                    return this.componentType;
                }
            }

            public enum Illegal implements ComponentTypeLocator {
                INSTANCE;

                public AbstractBase.ComponentTypeReference bind(String str) {
                    throw new IllegalStateException("Unexpected lookup of component type for " + str);
                }
            }

            AbstractBase.ComponentTypeReference bind(String str);
        }

        protected static class GenericTypeExtractor extends GenericTypeRegistrant.RejectingSignatureVisitor implements GenericTypeRegistrant {
            private final GenericTypeRegistrant genericTypeRegistrant;
            @UnknownNull
            private IncompleteToken incompleteToken;

            protected static abstract class ForSignature<T extends LazyTypeDescription.GenericTypeToken.Resolution> extends GenericTypeRegistrant.RejectingSignatureVisitor implements GenericTypeRegistrant {
                @UnknownNull
                protected List<LazyTypeDescription.GenericTypeToken> currentBounds;
                @MaybeNull
                protected String currentTypeParameter;
                protected final List<LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens = new ArrayList();

                protected static class OfField implements GenericTypeRegistrant {
                    @UnknownNull
                    private LazyTypeDescription.GenericTypeToken fieldTypeToken;

                    protected OfField() {
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForField extract(@MaybeNull String str) {
                        if (str == null) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        }
                        SignatureReader signatureReader = new SignatureReader(str);
                        OfField ofField = new OfField();
                        try {
                            signatureReader.acceptType(new GenericTypeExtractor(ofField));
                            return ofField.resolve();
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                        this.fieldTypeToken = genericTypeToken;
                    }

                    /* access modifiers changed from: protected */
                    public LazyTypeDescription.GenericTypeToken.Resolution.ForField resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForField.Tokenized(this.fieldTypeToken);
                    }
                }

                protected static class OfMethod extends ForSignature<LazyTypeDescription.GenericTypeToken.Resolution.ForMethod> {
                    /* access modifiers changed from: private */
                    public final List<LazyTypeDescription.GenericTypeToken> exceptionTypeTokens = new ArrayList();
                    /* access modifiers changed from: private */
                    public final List<LazyTypeDescription.GenericTypeToken> parameterTypeTokens = new ArrayList();
                    /* access modifiers changed from: private */
                    @UnknownNull
                    public LazyTypeDescription.GenericTypeToken returnTypeToken;

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class ExceptionTypeRegistrant implements GenericTypeRegistrant {
                        protected ExceptionTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfMethod.this.hashCode();
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfMethod.this.exceptionTypeTokens.add(genericTypeToken);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class ParameterTypeRegistrant implements GenericTypeRegistrant {
                        protected ParameterTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfMethod.this.hashCode();
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfMethod.this.parameterTypeTokens.add(genericTypeToken);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class ReturnTypeTypeRegistrant implements GenericTypeRegistrant {
                        protected ReturnTypeTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfMethod.this.hashCode();
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            LazyTypeDescription.GenericTypeToken unused = OfMethod.this.returnTypeToken = genericTypeToken;
                        }
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForMethod extract(@MaybeNull String str) {
                        if (str != null) {
                            return (LazyTypeDescription.GenericTypeToken.Resolution.ForMethod) ForSignature.extract(str, new OfMethod());
                        }
                        try {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    public SignatureVisitor visitExceptionType() {
                        return new GenericTypeExtractor(new ExceptionTypeRegistrant());
                    }

                    public SignatureVisitor visitParameterType() {
                        return new GenericTypeExtractor(new ParameterTypeRegistrant());
                    }

                    public SignatureVisitor visitReturnType() {
                        collectTypeParameter();
                        return new GenericTypeExtractor(new ReturnTypeTypeRegistrant());
                    }

                    public LazyTypeDescription.GenericTypeToken.Resolution.ForMethod resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForMethod.Tokenized(this.returnTypeToken, this.parameterTypeTokens, this.exceptionTypeTokens, this.typeVariableTokens);
                    }
                }

                protected static class OfRecordComponent implements GenericTypeRegistrant {
                    @UnknownNull
                    private LazyTypeDescription.GenericTypeToken recordComponentType;

                    protected OfRecordComponent() {
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent extract(@MaybeNull String str) {
                        if (str == null) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        }
                        SignatureReader signatureReader = new SignatureReader(str);
                        OfRecordComponent ofRecordComponent = new OfRecordComponent();
                        try {
                            signatureReader.acceptType(new GenericTypeExtractor(ofRecordComponent));
                            return ofRecordComponent.resolve();
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                        this.recordComponentType = genericTypeToken;
                    }

                    /* access modifiers changed from: protected */
                    public LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent.Tokenized(this.recordComponentType);
                    }
                }

                protected static class OfType extends ForSignature<LazyTypeDescription.GenericTypeToken.Resolution.ForType> {
                    /* access modifiers changed from: private */
                    public final List<LazyTypeDescription.GenericTypeToken> interfaceTypeTokens = new ArrayList();
                    /* access modifiers changed from: private */
                    @UnknownNull
                    public LazyTypeDescription.GenericTypeToken superClassToken;

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class InterfaceTypeRegistrant implements GenericTypeRegistrant {
                        protected InterfaceTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfType.this.equals(OfType.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfType.this.hashCode();
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfType.this.interfaceTypeTokens.add(genericTypeToken);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class SuperClassRegistrant implements GenericTypeRegistrant {
                        protected SuperClassRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfType.this.equals(OfType.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfType.this.hashCode();
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            LazyTypeDescription.GenericTypeToken unused = OfType.this.superClassToken = genericTypeToken;
                        }
                    }

                    protected OfType() {
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForType extract(@MaybeNull String str) {
                        if (str != null) {
                            return (LazyTypeDescription.GenericTypeToken.Resolution.ForType) ForSignature.extract(str, new OfType());
                        }
                        try {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    public SignatureVisitor visitInterface() {
                        return new GenericTypeExtractor(new InterfaceTypeRegistrant());
                    }

                    public SignatureVisitor visitSuperclass() {
                        collectTypeParameter();
                        return new GenericTypeExtractor(new SuperClassRegistrant());
                    }

                    public LazyTypeDescription.GenericTypeToken.Resolution.ForType resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForType.Tokenized(this.superClassToken, this.interfaceTypeTokens, this.typeVariableTokens);
                    }
                }

                protected static <S extends LazyTypeDescription.GenericTypeToken.Resolution> S extract(String str, ForSignature<S> forSignature) {
                    new SignatureReader(str).accept(forSignature);
                    return forSignature.resolve();
                }

                /* access modifiers changed from: protected */
                public void collectTypeParameter() {
                    String str = this.currentTypeParameter;
                    if (str != null) {
                        this.typeVariableTokens.add(new LazyTypeDescription.GenericTypeToken.ForTypeVariable.Formal(str, this.currentBounds));
                    }
                }

                public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                    List<LazyTypeDescription.GenericTypeToken> list = this.currentBounds;
                    if (list != null) {
                        list.add(genericTypeToken);
                        return;
                    }
                    throw new IllegalStateException("Did not expect " + genericTypeToken + " before finding formal parameter");
                }

                public abstract T resolve();

                public SignatureVisitor visitClassBound() {
                    return new GenericTypeExtractor(this);
                }

                public void visitFormalTypeParameter(String str) {
                    collectTypeParameter();
                    this.currentTypeParameter = str;
                    this.currentBounds = new ArrayList();
                }

                public SignatureVisitor visitInterfaceBound() {
                    return new GenericTypeExtractor(this);
                }
            }

            protected interface IncompleteToken {

                public static abstract class AbstractBase implements IncompleteToken {
                    protected final List<LazyTypeDescription.GenericTypeToken> parameters = new ArrayList();

                    protected class ForDirectBound implements GenericTypeRegistrant {
                        protected ForDirectBound() {
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            AbstractBase.this.parameters.add(genericTypeToken);
                        }
                    }

                    protected class ForLowerBound implements GenericTypeRegistrant {
                        protected ForLowerBound() {
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            AbstractBase.this.parameters.add(new LazyTypeDescription.GenericTypeToken.ForLowerBoundWildcard(genericTypeToken));
                        }
                    }

                    protected class ForUpperBound implements GenericTypeRegistrant {
                        protected ForUpperBound() {
                        }

                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            AbstractBase.this.parameters.add(new LazyTypeDescription.GenericTypeToken.ForUpperBoundWildcard(genericTypeToken));
                        }
                    }

                    public SignatureVisitor appendDirectBound() {
                        return new GenericTypeExtractor(new ForDirectBound());
                    }

                    public SignatureVisitor appendLowerBound() {
                        return new GenericTypeExtractor(new ForLowerBound());
                    }

                    public void appendPlaceholder() {
                        this.parameters.add(LazyTypeDescription.GenericTypeToken.ForUnboundWildcard.INSTANCE);
                    }

                    public SignatureVisitor appendUpperBound() {
                        return new GenericTypeExtractor(new ForUpperBound());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForInnerClass extends AbstractBase {
                    private static final char INNER_CLASS_SEPARATOR = '$';
                    private final String internalName;
                    private final IncompleteToken outerTypeToken;

                    public ForInnerClass(String str, IncompleteToken incompleteToken) {
                        this.internalName = str;
                        this.outerTypeToken = incompleteToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForInnerClass forInnerClass = (ForInnerClass) obj;
                        return this.internalName.equals(forInnerClass.internalName) && this.outerTypeToken.equals(forInnerClass.outerTypeToken);
                    }

                    public String getName() {
                        return this.outerTypeToken.getName() + INNER_CLASS_SEPARATOR + this.internalName.replace('/', '.');
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.internalName.hashCode()) * 31) + this.outerTypeToken.hashCode();
                    }

                    public boolean isParameterized() {
                        return !this.parameters.isEmpty() || !this.outerTypeToken.isParameterized();
                    }

                    public LazyTypeDescription.GenericTypeToken toToken() {
                        if (isParameterized() || this.outerTypeToken.isParameterized()) {
                            return new LazyTypeDescription.GenericTypeToken.ForParameterizedType.Nested(getName(), this.parameters, this.outerTypeToken.toToken());
                        }
                        return new LazyTypeDescription.GenericTypeToken.ForRawType(getName());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTopLevelType extends AbstractBase {
                    private final String internalName;

                    public ForTopLevelType(String str) {
                        this.internalName = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.internalName.equals(((ForTopLevelType) obj).internalName);
                    }

                    public String getName() {
                        return this.internalName.replace('/', '.');
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.internalName.hashCode();
                    }

                    public boolean isParameterized() {
                        return !this.parameters.isEmpty();
                    }

                    public LazyTypeDescription.GenericTypeToken toToken() {
                        if (isParameterized()) {
                            return new LazyTypeDescription.GenericTypeToken.ForParameterizedType(getName(), this.parameters);
                        }
                        return new LazyTypeDescription.GenericTypeToken.ForRawType(getName());
                    }
                }

                SignatureVisitor appendDirectBound();

                SignatureVisitor appendLowerBound();

                void appendPlaceholder();

                SignatureVisitor appendUpperBound();

                String getName();

                boolean isParameterized();

                LazyTypeDescription.GenericTypeToken toToken();
            }

            protected GenericTypeExtractor(GenericTypeRegistrant genericTypeRegistrant2) {
                this.genericTypeRegistrant = genericTypeRegistrant2;
            }

            public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                this.genericTypeRegistrant.register(new LazyTypeDescription.GenericTypeToken.ForGenericArray(genericTypeToken));
            }

            public SignatureVisitor visitArrayType() {
                return new GenericTypeExtractor(this);
            }

            public void visitBaseType(char c10) {
                this.genericTypeRegistrant.register(LazyTypeDescription.GenericTypeToken.ForPrimitiveType.of(c10));
            }

            public void visitClassType(String str) {
                this.incompleteToken = new IncompleteToken.ForTopLevelType(str);
            }

            public void visitEnd() {
                this.genericTypeRegistrant.register(this.incompleteToken.toToken());
            }

            public void visitInnerClassType(String str) {
                this.incompleteToken = new IncompleteToken.ForInnerClass(str, this.incompleteToken);
            }

            public void visitTypeArgument() {
                this.incompleteToken.appendPlaceholder();
            }

            public void visitTypeVariable(String str) {
                this.genericTypeRegistrant.register(new LazyTypeDescription.GenericTypeToken.ForTypeVariable(str));
            }

            public SignatureVisitor visitTypeArgument(char c10) {
                if (c10 == '+') {
                    return this.incompleteToken.appendUpperBound();
                }
                if (c10 == '-') {
                    return this.incompleteToken.appendLowerBound();
                }
                if (c10 == '=') {
                    return this.incompleteToken.appendDirectBound();
                }
                throw new IllegalArgumentException("Unknown wildcard: " + c10);
            }
        }

        protected interface GenericTypeRegistrant {

            public static class RejectingSignatureVisitor extends SignatureVisitor {
                private static final String MESSAGE = "Unexpected token in generic signature";

                public RejectingSignatureVisitor() {
                    super(OpenedClassReader.ASM_API);
                }

                public SignatureVisitor visitArrayType() {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitBaseType(char c10) {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitClassBound() {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitClassType(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitEnd() {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitExceptionType() {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitFormalTypeParameter(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitInnerClassType(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitInterface() {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitInterfaceBound() {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitParameterType() {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitReturnType() {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitSuperclass() {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitTypeArgument() {
                    throw new IllegalStateException(MESSAGE);
                }

                public void visitTypeVariable(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                public SignatureVisitor visitTypeArgument(char c10) {
                    throw new IllegalStateException(MESSAGE);
                }
            }

            void register(LazyTypeDescription.GenericTypeToken genericTypeToken);
        }

        protected static class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType {
            @AlwaysNull
            private static final String NO_TYPE = null;
            private final int actualModifiers;
            private final List<AnnotationToken> annotationTokens;
            private final boolean anonymousType;
            private final ClassFileVersion classFileVersion;
            private final List<String> declaredTypes;
            @MaybeNull
            private final String declaringTypeName;
            /* access modifiers changed from: private */
            public final List<FieldToken> fieldTokens;
            @MaybeNull
            private final String genericSignature;
            private final Map<Integer, Map<String, List<AnnotationToken>>> interfaceAnnotationTokens;
            private final List<String> interfaceTypeDescriptors;
            /* access modifiers changed from: private */
            public final List<MethodToken> methodTokens;
            private final int modifiers;
            private final String name;
            @MaybeNull
            private final String nestHost;
            private final List<String> nestMembers;
            private final List<String> permittedSubclasses;
            /* access modifiers changed from: private */
            public final List<RecordComponentToken> recordComponentTokens;
            private final GenericTypeToken.Resolution.ForType signatureResolution;
            private final Map<String, List<AnnotationToken>> superClassAnnotationTokens;
            @MaybeNull
            private final String superClassDescriptor;
            private final TypeContainment typeContainment;
            /* access modifiers changed from: private */
            public final TypePool typePool;
            private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
            private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundsAnnotationTokens;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class AnnotationToken {
                private final String descriptor;
                private final Map<String, AnnotationValue<?, ?>> values;

                protected interface Resolution {

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Illegal implements Resolution {
                        private final String annotationType;

                        public Illegal(String str) {
                            this.annotationType = str;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Illegal) obj).annotationType);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                        }

                        public boolean isResolved() {
                            return false;
                        }

                        public AnnotationDescription resolve() {
                            throw new IllegalStateException("Annotation type is not available: " + this.annotationType);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Simple implements Resolution {
                        private final AnnotationDescription annotationDescription;

                        protected Simple(AnnotationDescription annotationDescription2) {
                            this.annotationDescription = annotationDescription2;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.annotationDescription.equals(((Simple) obj).annotationDescription);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.annotationDescription.hashCode();
                        }

                        public boolean isResolved() {
                            return true;
                        }

                        public AnnotationDescription resolve() {
                            return this.annotationDescription;
                        }
                    }

                    boolean isResolved();

                    AnnotationDescription resolve();
                }

                protected AnnotationToken(String str, Map<String, AnnotationValue<?, ?>> map) {
                    this.descriptor = str;
                    this.values = map;
                }

                /* access modifiers changed from: private */
                public Resolution toAnnotationDescription(TypePool typePool) {
                    Resolution describe = typePool.describe(getBinaryName());
                    if (describe.isResolved()) {
                        return new Resolution.Simple(new LazyAnnotationDescription(typePool, describe.resolve(), this.values));
                    }
                    return new Resolution.Illegal(getBinaryName());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AnnotationToken annotationToken = (AnnotationToken) obj;
                    return this.descriptor.equals(annotationToken.descriptor) && this.values.equals(annotationToken.values);
                }

                /* access modifiers changed from: protected */
                public String getBinaryName() {
                    String str = this.descriptor;
                    return str.substring(1, str.length() - 1).replace('/', '.');
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.descriptor.hashCode()) * 31) + this.values.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class FieldToken {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;
                @UnknownNull
                private final String genericSignature;
                private final int modifiers;
                private final String name;
                private final GenericTypeToken.Resolution.ForField signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                protected FieldToken(String str, int i10, String str2, @MaybeNull String str3, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    GenericTypeToken.Resolution.ForField forField;
                    this.modifiers = i10 & -131073;
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    if (TypeDescription.AbstractBase.RAW_TYPES) {
                        forField = GenericTypeToken.Resolution.Raw.INSTANCE;
                    } else {
                        forField = GenericTypeExtractor.ForSignature.OfField.extract(str3);
                    }
                    this.signatureResolution = forField;
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                /* access modifiers changed from: private */
                public LazyFieldDescription toFieldDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyFieldDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    FieldToken fieldToken = (FieldToken) obj;
                    return this.modifiers == fieldToken.modifiers && this.name.equals(fieldToken.name) && this.descriptor.equals(fieldToken.descriptor) && this.genericSignature.equals(fieldToken.genericSignature) && this.signatureResolution.equals(fieldToken.signatureResolution) && this.typeAnnotationTokens.equals(fieldToken.typeAnnotationTokens) && this.annotationTokens.equals(fieldToken.annotationTokens);
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.modifiers) * 31) + this.descriptor.hashCode()) * 31) + this.genericSignature.hashCode()) * 31) + this.signatureResolution.hashCode()) * 31) + this.typeAnnotationTokens.hashCode()) * 31) + this.annotationTokens.hashCode();
                }
            }

            protected class FieldTokenList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                protected FieldTokenList() {
                }

                public int size() {
                    return LazyTypeDescription.this.fieldTokens.size();
                }

                public FieldDescription.InDefinedShape get(int i10) {
                    return ((FieldToken) LazyTypeDescription.this.fieldTokens.get(i10)).toFieldDescription(LazyTypeDescription.this);
                }
            }

            protected interface GenericTypeToken {
                public static final char COMPONENT_TYPE_PATH = '[';
                public static final String EMPTY_TYPE_PATH = "";
                public static final char INDEXED_TYPE_DELIMITER = ';';
                public static final char INNER_CLASS_PATH = '.';
                public static final char WILDCARD_TYPE_PATH = '*';

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForGenericArray implements GenericTypeToken {
                    private final GenericTypeToken componentTypeToken;

                    protected static class LazyGenericArray extends TypeDescription.Generic.OfGenericArray {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken componentTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        protected LazyGenericArray(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool2;
                            this.typeVariableSource = typeVariableSource2;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.componentTypeToken = genericTypeToken;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        public TypeDescription.Generic getComponentType() {
                            GenericTypeToken genericTypeToken = this.componentTypeToken;
                            TypePool typePool2 = this.typePool;
                            TypeVariableSource typeVariableSource2 = this.typeVariableSource;
                            return genericTypeToken.toGenericType(typePool2, typeVariableSource2, this.typePath + '[', this.annotationTokens);
                        }
                    }

                    protected ForGenericArray(GenericTypeToken genericTypeToken) {
                        this.componentTypeToken = genericTypeToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.componentTypeToken.equals(((ForGenericArray) obj).componentTypeToken);
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A generic array type cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.componentTypeToken.hashCode();
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A generic array type cannot be a type variable bound: " + this);
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyGenericArray(typePool, typeVariableSource, str, map, this.componentTypeToken);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLowerBoundWildcard implements GenericTypeToken {
                    private final GenericTypeToken boundTypeToken;

                    protected static class LazyLowerBoundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken boundTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        protected LazyLowerBoundWildcard(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool2;
                            this.typeVariableSource = typeVariableSource2;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.boundTypeToken = genericTypeToken;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        public TypeList.Generic getLowerBounds() {
                            return new LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
                        }

                        public TypeList.Generic getUpperBounds() {
                            return new TypeList.Generic.Explicit(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class));
                        }
                    }

                    protected ForLowerBoundWildcard(GenericTypeToken genericTypeToken) {
                        this.boundTypeToken = genericTypeToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.boundTypeToken.equals(((ForLowerBoundWildcard) obj).boundTypeToken);
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A lower bound wildcard cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.boundTypeToken.hashCode();
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyLowerBoundWildcard(typePool, typeVariableSource, str, map, this.boundTypeToken);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForParameterizedType implements GenericTypeToken {
                    private final String name;
                    private final List<GenericTypeToken> parameterTypeTokens;

                    protected static class LazyParameterizedType extends TypeDescription.Generic.OfParameterizedType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final String name;
                        private final List<GenericTypeToken> parameterTypeTokens;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        protected LazyParameterizedType(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, String str2, List<GenericTypeToken> list) {
                            this.typePool = typePool2;
                            this.typeVariableSource = typeVariableSource2;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.name = str2;
                            this.parameterTypeTokens = list;
                        }

                        public TypeDescription asErasure() {
                            return this.typePool.describe(this.name).resolve();
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @MaybeNull
                        public TypeDescription.Generic getOwnerType() {
                            TypeDescription enclosingType = this.typePool.describe(this.name).resolve().getEnclosingType();
                            if (enclosingType == null) {
                                return TypeDescription.Generic.UNDEFINED;
                            }
                            return enclosingType.asGenericType();
                        }

                        public TypeList.Generic getTypeArguments() {
                            return new LazyTokenList(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.parameterTypeTokens);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Nested implements GenericTypeToken {
                        private final String name;
                        private final GenericTypeToken ownerTypeToken;
                        private final List<GenericTypeToken> parameterTypeTokens;

                        protected static class LazyParameterizedType extends TypeDescription.Generic.OfParameterizedType {
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final String name;
                            private final GenericTypeToken ownerTypeToken;
                            private final List<GenericTypeToken> parameterTypeTokens;
                            private final String typePath;
                            private final TypePool typePool;
                            private final TypeVariableSource typeVariableSource;

                            protected LazyParameterizedType(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, String str2, List<GenericTypeToken> list, GenericTypeToken genericTypeToken) {
                                this.typePool = typePool2;
                                this.typeVariableSource = typeVariableSource2;
                                this.typePath = str;
                                this.annotationTokens = map;
                                this.name = str2;
                                this.parameterTypeTokens = list;
                                this.ownerTypeToken = genericTypeToken;
                            }

                            public TypeDescription asErasure() {
                                return this.typePool.describe(this.name).resolve();
                            }

                            public AnnotationList getDeclaredAnnotations() {
                                TypePool typePool2 = this.typePool;
                                Map<String, List<AnnotationToken>> map = this.annotationTokens;
                                return LazyAnnotationDescription.asListOfNullable(typePool2, map.get(this.typePath + this.ownerTypeToken.getTypePathPrefix()));
                            }

                            @MaybeNull
                            public TypeDescription.Generic getOwnerType() {
                                return this.ownerTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens);
                            }

                            public TypeList.Generic getTypeArguments() {
                                TypePool typePool2 = this.typePool;
                                TypeVariableSource typeVariableSource2 = this.typeVariableSource;
                                return new LazyTokenList(typePool2, typeVariableSource2, this.typePath + this.ownerTypeToken.getTypePathPrefix(), this.annotationTokens, this.parameterTypeTokens);
                            }
                        }

                        protected Nested(String str, List<GenericTypeToken> list, GenericTypeToken genericTypeToken) {
                            this.name = str;
                            this.parameterTypeTokens = list;
                            this.ownerTypeToken = genericTypeToken;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Nested nested = (Nested) obj;
                            return this.name.equals(nested.name) && this.parameterTypeTokens.equals(nested.parameterTypeTokens) && this.ownerTypeToken.equals(nested.ownerTypeToken);
                        }

                        public String getTypePathPrefix() {
                            return this.ownerTypeToken.getTypePathPrefix() + '.';
                        }

                        public int hashCode() {
                            return (((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.parameterTypeTokens.hashCode()) * 31) + this.ownerTypeToken.hashCode();
                        }

                        public boolean isPrimaryBound(TypePool typePool) {
                            return !typePool.describe(this.name).resolve().isInterface();
                        }

                        public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                            return new LazyParameterizedType(typePool, typeVariableSource, str, map, this.name, this.parameterTypeTokens, this.ownerTypeToken);
                        }
                    }

                    protected ForParameterizedType(String str, List<GenericTypeToken> list) {
                        this.name = str;
                        this.parameterTypeTokens = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForParameterizedType forParameterizedType = (ForParameterizedType) obj;
                        return this.name.equals(forParameterizedType.name) && this.parameterTypeTokens.equals(forParameterizedType.parameterTypeTokens);
                    }

                    public String getTypePathPrefix() {
                        return String.valueOf('.');
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.parameterTypeTokens.hashCode();
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        return !typePool.describe(this.name).resolve().isInterface();
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyParameterizedType(typePool, typeVariableSource, str, map, this.name, this.parameterTypeTokens);
                    }
                }

                public enum ForPrimitiveType implements GenericTypeToken {
                    BOOLEAN(Boolean.TYPE),
                    BYTE(Byte.TYPE),
                    SHORT(Short.TYPE),
                    CHAR(Character.TYPE),
                    INTEGER(Integer.TYPE),
                    LONG(Long.TYPE),
                    FLOAT(Float.TYPE),
                    DOUBLE(Double.TYPE),
                    VOID(Void.TYPE);
                    
                    private final TypeDescription typeDescription;

                    protected static class LazyPrimitiveType extends TypeDescription.Generic.OfNonGenericType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final TypeDescription typeDescription;
                        private final String typePath;
                        private final TypePool typePool;

                        protected LazyPrimitiveType(TypePool typePool2, String str, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription2) {
                            this.typePool = typePool2;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.typeDescription = typeDescription2;
                        }

                        public TypeDescription asErasure() {
                            return this.typeDescription;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @MaybeNull
                        public TypeDescription.Generic getOwnerType() {
                            return TypeDescription.Generic.UNDEFINED;
                        }

                        @MaybeNull
                        public TypeDescription.Generic getComponentType() {
                            return TypeDescription.Generic.UNDEFINED;
                        }
                    }

                    private ForPrimitiveType(Class<?> cls) {
                        this.typeDescription = TypeDescription.ForLoadedType.of(cls);
                    }

                    public static GenericTypeToken of(char c10) {
                        if (c10 == 'F') {
                            return FLOAT;
                        }
                        if (c10 == 'S') {
                            return SHORT;
                        }
                        if (c10 == 'V') {
                            return VOID;
                        }
                        if (c10 == 'Z') {
                            return BOOLEAN;
                        }
                        if (c10 == 'I') {
                            return INTEGER;
                        }
                        if (c10 == 'J') {
                            return LONG;
                        }
                        switch (c10) {
                            case 'B':
                                return BYTE;
                            case 'C':
                                return CHAR;
                            case 'D':
                                return DOUBLE;
                            default:
                                throw new IllegalArgumentException("Not a valid primitive type descriptor: " + c10);
                        }
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A primitive type cannot be the owner of a nested type: " + this);
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A primitive type cannot be a type variable bound: " + this);
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyPrimitiveType(typePool, str, map, this.typeDescription);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForRawType implements GenericTypeToken {
                    private final String name;

                    protected ForRawType(String str) {
                        this.name = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((ForRawType) obj).name);
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A non-generic type cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.name.hashCode();
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        return !typePool.describe(this.name).resolve().isInterface();
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new Resolution.Raw.RawAnnotatedType(typePool, str, map, typePool.describe(this.name).resolve());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTypeVariable implements GenericTypeToken {
                    private final String symbol;

                    protected static class AnnotatedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                        private final List<AnnotationToken> annotationTokens;
                        private final TypePool typePool;
                        private final TypeDescription.Generic typeVariable;

                        protected AnnotatedTypeVariable(TypePool typePool2, List<AnnotationToken> list, TypeDescription.Generic generic) {
                            this.typePool = typePool2;
                            this.annotationTokens = list;
                            this.typeVariable = generic;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
                        }

                        public String getSymbol() {
                            return this.typeVariable.getSymbol();
                        }

                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariable.getTypeVariableSource();
                        }

                        public TypeList.Generic getUpperBounds() {
                            return this.typeVariable.getUpperBounds();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class Formal implements OfFormalTypeVariable {
                        private final List<GenericTypeToken> boundTypeTokens;
                        private final String symbol;

                        protected static class LazyTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final List<GenericTypeToken> boundTypeTokens;
                            private final Map<Integer, Map<String, List<AnnotationToken>>> boundaryAnnotationTokens;
                            private final String symbol;
                            private final TypePool typePool;
                            private final TypeVariableSource typeVariableSource;

                            protected static class LazyBoundTokenList extends TypeList.Generic.AbstractBase {
                                private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                                private final List<GenericTypeToken> boundTypeTokens;
                                private final TypePool typePool;
                                private final TypeVariableSource typeVariableSource;

                                protected LazyBoundTokenList(TypePool typePool2, TypeVariableSource typeVariableSource2, Map<Integer, Map<String, List<AnnotationToken>>> map, List<GenericTypeToken> list) {
                                    this.typePool = typePool2;
                                    this.typeVariableSource = typeVariableSource2;
                                    this.annotationTokens = map;
                                    this.boundTypeTokens = list;
                                }

                                public int size() {
                                    return this.boundTypeTokens.size();
                                }

                                public TypeDescription.Generic get(int i10) {
                                    Map map;
                                    if (this.annotationTokens.containsKey(Integer.valueOf(i10)) || this.annotationTokens.containsKey(Integer.valueOf(i10 + 1))) {
                                        map = this.annotationTokens.get(Integer.valueOf((this.boundTypeTokens.get(0).isPrimaryBound(this.typePool) ^ true ? 1 : 0) + i10));
                                    } else {
                                        map = Collections.emptyMap();
                                    }
                                    GenericTypeToken genericTypeToken = this.boundTypeTokens.get(i10);
                                    TypePool typePool2 = this.typePool;
                                    TypeVariableSource typeVariableSource2 = this.typeVariableSource;
                                    if (map == null) {
                                        map = Collections.emptyMap();
                                    }
                                    return genericTypeToken.toGenericType(typePool2, typeVariableSource2, "", map);
                                }
                            }

                            protected LazyTypeVariable(TypePool typePool2, TypeVariableSource typeVariableSource2, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2, String str, List<GenericTypeToken> list) {
                                this.typePool = typePool2;
                                this.typeVariableSource = typeVariableSource2;
                                this.annotationTokens = map;
                                this.boundaryAnnotationTokens = map2;
                                this.symbol = str;
                                this.boundTypeTokens = list;
                            }

                            public AnnotationList getDeclaredAnnotations() {
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(""));
                            }

                            public String getSymbol() {
                                return this.symbol;
                            }

                            public TypeVariableSource getTypeVariableSource() {
                                return this.typeVariableSource;
                            }

                            public TypeList.Generic getUpperBounds() {
                                return new LazyBoundTokenList(this.typePool, this.typeVariableSource, this.boundaryAnnotationTokens, this.boundTypeTokens);
                            }
                        }

                        protected Formal(String str, List<GenericTypeToken> list) {
                            this.symbol = str;
                            this.boundTypeTokens = list;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Formal formal = (Formal) obj;
                            return this.symbol.equals(formal.symbol) && this.boundTypeTokens.equals(formal.boundTypeTokens);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.symbol.hashCode()) * 31) + this.boundTypeTokens.hashCode();
                        }

                        public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, @MaybeNull Map<String, List<AnnotationToken>> map, @MaybeNull Map<Integer, Map<String, List<AnnotationToken>>> map2) {
                            if (map == null) {
                                map = Collections.emptyMap();
                            }
                            Map<String, List<AnnotationToken>> map3 = map;
                            if (map2 == null) {
                                map2 = Collections.emptyMap();
                            }
                            return new LazyTypeVariable(typePool, typeVariableSource, map3, map2, this.symbol, this.boundTypeTokens);
                        }
                    }

                    protected static class UnresolvedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                        private final List<AnnotationToken> annotationTokens;
                        private final String symbol;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        protected UnresolvedTypeVariable(TypeVariableSource typeVariableSource2, TypePool typePool2, String str, List<AnnotationToken> list) {
                            this.typeVariableSource = typeVariableSource2;
                            this.typePool = typePool2;
                            this.symbol = str;
                            this.annotationTokens = list;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
                        }

                        public String getSymbol() {
                            return this.symbol;
                        }

                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariableSource;
                        }

                        public TypeList.Generic getUpperBounds() {
                            throw new IllegalStateException("Cannot resolve bounds of unresolved type variable " + this + " by " + this.typeVariableSource);
                        }
                    }

                    protected ForTypeVariable(String str) {
                        this.symbol = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.symbol.equals(((ForTypeVariable) obj).symbol);
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A type variable cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.symbol.hashCode();
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        return true;
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        TypeDescription.Generic findVariable = typeVariableSource.findVariable(this.symbol);
                        if (findVariable == null) {
                            return new UnresolvedTypeVariable(typeVariableSource, typePool, this.symbol, map.get(str));
                        }
                        return new AnnotatedTypeVariable(typePool, map.get(str), findVariable);
                    }
                }

                public enum ForUnboundWildcard implements GenericTypeToken {
                    INSTANCE;

                    protected static class LazyUnboundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final String typePath;
                        private final TypePool typePool;

                        protected LazyUnboundWildcard(TypePool typePool2, String str, Map<String, List<AnnotationToken>> map) {
                            this.typePool = typePool2;
                            this.typePath = str;
                            this.annotationTokens = map;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        public TypeList.Generic getLowerBounds() {
                            return new TypeList.Generic.Empty();
                        }

                        public TypeList.Generic getUpperBounds() {
                            return new TypeList.Generic.Explicit(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class));
                        }
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("An unbound wildcard cannot be the owner of a nested type: " + this);
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, @MaybeNull Map<String, List<AnnotationToken>> map) {
                        if (map == null) {
                            map = Collections.emptyMap();
                        }
                        return new LazyUnboundWildcard(typePool, str, map);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForUpperBoundWildcard implements GenericTypeToken {
                    private final GenericTypeToken boundTypeToken;

                    protected static class LazyUpperBoundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken boundTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        protected LazyUpperBoundWildcard(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool2;
                            this.typeVariableSource = typeVariableSource2;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.boundTypeToken = genericTypeToken;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        public TypeList.Generic getLowerBounds() {
                            return new TypeList.Generic.Empty();
                        }

                        public TypeList.Generic getUpperBounds() {
                            return new LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
                        }
                    }

                    protected ForUpperBoundWildcard(GenericTypeToken genericTypeToken) {
                        this.boundTypeToken = genericTypeToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.boundTypeToken.equals(((ForUpperBoundWildcard) obj).boundTypeToken);
                    }

                    public String getTypePathPrefix() {
                        throw new IllegalStateException("An upper bound wildcard cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.boundTypeToken.hashCode();
                    }

                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyUpperBoundWildcard(typePool, typeVariableSource, str, map, this.boundTypeToken);
                    }
                }

                public static class LazyTokenList extends TypeList.Generic.AbstractBase {
                    private final Map<String, List<AnnotationToken>> annotationTokens;
                    private final List<GenericTypeToken> genericTypeTokens;
                    private final String typePath;
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;

                    protected static class ForWildcardBound extends TypeList.Generic.AbstractBase {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken genericTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        protected ForWildcardBound(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken2) {
                            this.typePool = typePool2;
                            this.typeVariableSource = typeVariableSource2;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.genericTypeToken = genericTypeToken2;
                        }

                        public int size() {
                            return 1;
                        }

                        public TypeDescription.Generic get(int i10) {
                            if (i10 == 0) {
                                GenericTypeToken genericTypeToken2 = this.genericTypeToken;
                                TypePool typePool2 = this.typePool;
                                TypeVariableSource typeVariableSource2 = this.typeVariableSource;
                                return genericTypeToken2.toGenericType(typePool2, typeVariableSource2, this.typePath + GenericTypeToken.WILDCARD_TYPE_PATH, this.annotationTokens);
                            }
                            throw new IndexOutOfBoundsException("index = " + i10);
                        }
                    }

                    protected LazyTokenList(TypePool typePool2, TypeVariableSource typeVariableSource2, String str, Map<String, List<AnnotationToken>> map, List<GenericTypeToken> list) {
                        this.typePool = typePool2;
                        this.typeVariableSource = typeVariableSource2;
                        this.typePath = str;
                        this.annotationTokens = map;
                        this.genericTypeTokens = list;
                    }

                    public int size() {
                        return this.genericTypeTokens.size();
                    }

                    public TypeDescription.Generic get(int i10) {
                        TypePool typePool2 = this.typePool;
                        TypeVariableSource typeVariableSource2 = this.typeVariableSource;
                        return this.genericTypeTokens.get(i10).toGenericType(typePool2, typeVariableSource2, this.typePath + i10 + GenericTypeToken.INDEXED_TYPE_DELIMITER, this.annotationTokens);
                    }
                }

                public interface OfFormalTypeVariable {
                    TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2);
                }

                public interface Resolution {

                    public interface ForField {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForField {
                            private final GenericTypeToken fieldTypeToken;

                            protected Tokenized(GenericTypeToken genericTypeToken) {
                                this.fieldTypeToken = genericTypeToken;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.fieldTypeToken.equals(((Tokenized) obj).fieldTypeToken);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.fieldTypeToken.hashCode();
                            }

                            public TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape) {
                                return TokenizedGenericType.of(typePool, this.fieldTypeToken, str, map, inDefinedShape.getDeclaringType());
                            }
                        }

                        TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape);
                    }

                    public interface ForMethod extends Resolution {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForMethod {
                            private final List<GenericTypeToken> exceptionTypeTokens;
                            private final List<GenericTypeToken> parameterTypeTokens;
                            private final GenericTypeToken returnTypeToken;
                            private final List<OfFormalTypeVariable> typeVariableTokens;

                            protected Tokenized(GenericTypeToken genericTypeToken, List<GenericTypeToken> list, List<GenericTypeToken> list2, List<OfFormalTypeVariable> list3) {
                                this.returnTypeToken = genericTypeToken;
                                this.parameterTypeTokens = list;
                                this.exceptionTypeTokens = list2;
                                this.typeVariableTokens = list3;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Tokenized tokenized = (Tokenized) obj;
                                return this.returnTypeToken.equals(tokenized.returnTypeToken) && this.parameterTypeTokens.equals(tokenized.parameterTypeTokens) && this.exceptionTypeTokens.equals(tokenized.exceptionTypeTokens) && this.typeVariableTokens.equals(tokenized.typeVariableTokens);
                            }

                            public int hashCode() {
                                return (((((((getClass().hashCode() * 31) + this.returnTypeToken.hashCode()) * 31) + this.parameterTypeTokens.hashCode()) * 31) + this.exceptionTypeTokens.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                            }

                            public TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                                if (this.exceptionTypeTokens.isEmpty()) {
                                    return Raw.INSTANCE.resolveExceptionTypes(list, typePool, map, inDefinedShape);
                                }
                                return new TokenizedGenericType.TokenList(typePool, this.exceptionTypeTokens, map, list, inDefinedShape);
                            }

                            public TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                                return new TokenizedGenericType.TokenList(typePool, this.parameterTypeTokens, map, list, inDefinedShape);
                            }

                            public TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape) {
                                return TokenizedGenericType.of(typePool, this.returnTypeToken, str, map, inDefinedShape);
                            }

                            public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                                return new TokenizedGenericType.TypeVariableList(typePool, this.typeVariableTokens, typeVariableSource, map, map2);
                            }
                        }

                        TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape);

                        TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape);

                        TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape);
                    }

                    public interface ForRecordComponent {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForRecordComponent {
                            private final GenericTypeToken recordComponentTypeToken;

                            protected Tokenized(GenericTypeToken genericTypeToken) {
                                this.recordComponentTypeToken = genericTypeToken;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.recordComponentTypeToken.equals(((Tokenized) obj).recordComponentTypeToken);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.recordComponentTypeToken.hashCode();
                            }

                            public TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape) {
                                return TokenizedGenericType.of(typePool, this.recordComponentTypeToken, str, map, inDefinedShape.getDeclaringType());
                            }
                        }

                        TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape);
                    }

                    public interface ForType extends Resolution {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForType {
                            private final List<GenericTypeToken> interfaceTypeTokens;
                            private final GenericTypeToken superClassToken;
                            private final List<OfFormalTypeVariable> typeVariableTokens;

                            protected Tokenized(GenericTypeToken genericTypeToken, List<GenericTypeToken> list, List<OfFormalTypeVariable> list2) {
                                this.superClassToken = genericTypeToken;
                                this.interfaceTypeTokens = list;
                                this.typeVariableTokens = list2;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Tokenized tokenized = (Tokenized) obj;
                                return this.superClassToken.equals(tokenized.superClassToken) && this.interfaceTypeTokens.equals(tokenized.interfaceTypeTokens) && this.typeVariableTokens.equals(tokenized.typeVariableTokens);
                            }

                            public int hashCode() {
                                return (((((getClass().hashCode() * 31) + this.superClassToken.hashCode()) * 31) + this.interfaceTypeTokens.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                            }

                            public TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription) {
                                return new TokenizedGenericType.TokenList(typePool, this.interfaceTypeTokens, map, list, typeDescription);
                            }

                            public TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                                return TokenizedGenericType.of(typePool, this.superClassToken, str, map, typeDescription);
                            }

                            public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                                return new TokenizedGenericType.TypeVariableList(typePool, this.typeVariableTokens, typeVariableSource, map, map2);
                            }
                        }

                        TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription);

                        TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription);
                    }

                    public enum Malformed implements ForType, ForField, ForMethod, ForRecordComponent {
                        INSTANCE;

                        public TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, list);
                        }

                        public TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        public TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, list);
                        }

                        public TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, list);
                        }

                        public TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        public TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        public TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                            throw new GenericSignatureFormatError();
                        }
                    }

                    public enum Raw implements ForType, ForField, ForMethod, ForRecordComponent {
                        INSTANCE;

                        protected static class RawAnnotatedType extends TypeDescription.Generic.OfNonGenericType {
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final TypeDescription typeDescription;
                            private final String typePath;
                            private final TypePool typePool;

                            protected static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase {
                                private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                                private final List<String> descriptors;
                                private final TypePool typePool;

                                protected LazyRawAnnotatedTypeList(TypePool typePool2, Map<Integer, Map<String, List<AnnotationToken>>> map, List<String> list) {
                                    this.typePool = typePool2;
                                    this.annotationTokens = map;
                                    this.descriptors = list;
                                }

                                protected static TypeList.Generic of(TypePool typePool2, @MaybeNull Map<Integer, Map<String, List<AnnotationToken>>> map, List<String> list) {
                                    if (map == null) {
                                        map = Collections.emptyMap();
                                    }
                                    return new LazyRawAnnotatedTypeList(typePool2, map, list);
                                }

                                public TypeList asErasures() {
                                    return new LazyTypeList(this.typePool, this.descriptors);
                                }

                                public TypeList.Generic asRawTypes() {
                                    return this;
                                }

                                public int getStackSize() {
                                    int i10 = 0;
                                    for (String type : this.descriptors) {
                                        i10 += Type.getType(type).getSize();
                                    }
                                    return i10;
                                }

                                public int size() {
                                    return this.descriptors.size();
                                }

                                public TypeDescription.Generic get(int i10) {
                                    return RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(i10)), this.descriptors.get(i10));
                                }
                            }

                            protected RawAnnotatedType(TypePool typePool2, String str, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription2) {
                                this.typePool = typePool2;
                                this.typePath = str;
                                this.annotationTokens = map;
                                this.typeDescription = typeDescription2;
                            }

                            protected static TypeDescription.Generic of(TypePool typePool2, @MaybeNull Map<String, List<AnnotationToken>> map, String str) {
                                if (map == null) {
                                    map = Collections.emptyMap();
                                }
                                return new RawAnnotatedType(typePool2, "", map, TokenizedGenericType.toErasure(typePool2, str));
                            }

                            public TypeDescription asErasure() {
                                return this.typeDescription;
                            }

                            public AnnotationList getDeclaredAnnotations() {
                                StringBuilder sb2 = new StringBuilder(this.typePath);
                                for (int i10 = 0; i10 < this.typeDescription.getInnerClassCount(); i10++) {
                                    sb2.append('.');
                                }
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(sb2.toString()));
                            }

                            @MaybeNull
                            public TypeDescription.Generic getOwnerType() {
                                TypeDescription declaringType = this.typeDescription.getDeclaringType();
                                if (declaringType == null) {
                                    return TypeDescription.Generic.UNDEFINED;
                                }
                                return new RawAnnotatedType(this.typePool, this.typePath, this.annotationTokens, declaringType);
                            }

                            @MaybeNull
                            public TypeDescription.Generic getComponentType() {
                                TypeDescription componentType = this.typeDescription.getComponentType();
                                if (componentType == null) {
                                    return TypeDescription.Generic.UNDEFINED;
                                }
                                TypePool typePool2 = this.typePool;
                                return new RawAnnotatedType(typePool2, this.typePath + '[', this.annotationTokens, componentType);
                            }
                        }

                        public TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.of(typePool, map, list);
                        }

                        public TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        public TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.of(typePool, map, list);
                        }

                        public TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.of(typePool, map, list);
                        }

                        public TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        public TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        public TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                            return new TypeList.Generic.Empty();
                        }
                    }

                    TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2);
                }

                String getTypePathPrefix();

                boolean isPrimaryBound(TypePool typePool);

                TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map);
            }

            private static class LazyAnnotationDescription extends AnnotationDescription.AbstractBase {
                private final TypeDescription annotationType;
                protected final TypePool typePool;
                protected final Map<String, AnnotationValue<?, ?>> values;

                private static class Loadable<S extends Annotation> extends LazyAnnotationDescription implements AnnotationDescription.Loadable<S> {
                    private final Class<S> annotationType;

                    public S load() {
                        return AnnotationDescription.AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, this.values);
                    }

                    public /* bridge */ /* synthetic */ AnnotationDescription.Loadable prepare(Class cls) {
                        return super.prepare(cls);
                    }

                    private Loadable(TypePool typePool, Class<S> cls, Map<String, AnnotationValue<?, ?>> map) {
                        super(typePool, TypeDescription.ForLoadedType.of(cls), map);
                        this.annotationType = cls;
                    }
                }

                protected static AnnotationList asList(TypePool typePool2, List<? extends AnnotationToken> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (AnnotationToken access$2000 : list) {
                        AnnotationToken.Resolution access$20002 = access$2000.toAnnotationDescription(typePool2);
                        if (access$20002.isResolved() && access$20002.resolve().getAnnotationType().isAnnotation()) {
                            arrayList.add(access$20002.resolve());
                        }
                    }
                    return new AnnotationList.Explicit((List<? extends AnnotationDescription>) arrayList);
                }

                protected static AnnotationList asListOfNullable(TypePool typePool2, @MaybeNull List<? extends AnnotationToken> list) {
                    if (list == null) {
                        return new AnnotationList.Empty();
                    }
                    return asList(typePool2, list);
                }

                public TypeDescription getAnnotationType() {
                    return this.annotationType;
                }

                public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
                    if (inDefinedShape.getDeclaringType().asErasure().equals(this.annotationType)) {
                        AnnotationValue annotationValue = this.values.get(inDefinedShape.getName());
                        if (annotationValue != null) {
                            return annotationValue.filter(inDefinedShape);
                        }
                        AnnotationValue<?, ?> defaultValue = ((MethodDescription.InDefinedShape) ((MethodList) getAnnotationType().getDeclaredMethods().filter(ElementMatchers.is(inDefinedShape))).getOnly()).getDefaultValue();
                        if (defaultValue == null) {
                            return new AnnotationValue.ForMissingValue(this.annotationType, inDefinedShape.getName());
                        }
                        return defaultValue;
                    }
                    throw new IllegalArgumentException(inDefinedShape + " is not declared by " + getAnnotationType());
                }

                private LazyAnnotationDescription(TypePool typePool2, TypeDescription typeDescription, Map<String, AnnotationValue<?, ?>> map) {
                    this.typePool = typePool2;
                    this.annotationType = typeDescription;
                    this.values = map;
                }

                public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
                    if (this.annotationType.represents(cls)) {
                        return new Loadable<>(this.typePool, cls, this.values);
                    }
                    throw new IllegalArgumentException(cls + " does not represent " + this.annotationType);
                }
            }

            private static abstract class LazyAnnotationValue<U, V> extends AnnotationValue.AbstractBase<U, V> {
                private transient /* synthetic */ int hashCode;

                private static class ForAnnotationValue extends LazyAnnotationValue<AnnotationDescription, Annotation> {
                    private final AnnotationToken annotationToken;
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final TypePool typePool;

                    /* access modifiers changed from: protected */
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<AnnotationDescription, Annotation> doResolve() {
                        AnnotationValue<AnnotationDescription, Annotation> annotationValue = null;
                        if (this.resolved == null) {
                            AnnotationToken.Resolution access$2000 = this.annotationToken.toAnnotationDescription(this.typePool);
                            if (!access$2000.isResolved()) {
                                annotationValue = new AnnotationValue.ForMissingType<>(this.annotationToken.getBinaryName());
                            } else if (!access$2000.resolve().getAnnotationType().isAnnotation()) {
                                annotationValue = new ForMismatchedType<>(access$2000.resolve().getAnnotationType().getName(), AnnotationValue.Sort.ANNOTATION);
                            } else {
                                annotationValue = new AnnotationValue.ForAnnotationDescription<>(access$2000.resolve());
                            }
                        }
                        if (annotationValue == null) {
                            return this.resolved;
                        }
                        this.resolved = annotationValue;
                        return annotationValue;
                    }

                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ANNOTATION;
                    }

                    private ForAnnotationValue(TypePool typePool2, AnnotationToken annotationToken2) {
                        super();
                        this.typePool = typePool2;
                        this.annotationToken = annotationToken2;
                    }
                }

                private static class ForArray extends LazyAnnotationValue<Object, Object> {
                    private final AbstractBase.ComponentTypeReference componentTypeReference;
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final TypePool typePool;
                    private final List<AnnotationValue<?, ?>> values;

                    /* access modifiers changed from: protected */
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<Object, Object> doResolve() {
                        Class<String> cls = String.class;
                        AnnotationValue<Object, Object> annotationValue = null;
                        if (this.resolved == null) {
                            String resolve = this.componentTypeReference.resolve();
                            if (resolve != null) {
                                Resolution describe = this.typePool.describe(resolve);
                                if (!describe.isResolved()) {
                                    annotationValue = new AnnotationValue.ForMissingType<>(resolve);
                                } else if (describe.resolve().isEnum()) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(EnumerationDescription.class, describe.resolve(), this.values);
                                } else if (describe.resolve().isAnnotation()) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(AnnotationDescription.class, describe.resolve(), this.values);
                                } else if (describe.resolve().represents(Class.class)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(TypeDescription.class, describe.resolve(), this.values);
                                } else if (describe.resolve().represents(cls)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(cls, describe.resolve(), this.values);
                                } else {
                                    TypeDescription resolve2 = describe.resolve();
                                    Class cls2 = Boolean.TYPE;
                                    if (resolve2.represents(cls2)) {
                                        annotationValue = new AnnotationValue.ForDescriptionArray<>(cls2, describe.resolve(), this.values);
                                    } else if (describe.resolve().represents(Byte.TYPE)) {
                                        annotationValue = new AnnotationValue.ForDescriptionArray<>(Byte.TYPE, describe.resolve(), this.values);
                                    } else if (describe.resolve().represents(Short.TYPE)) {
                                        annotationValue = new AnnotationValue.ForDescriptionArray<>(Short.TYPE, describe.resolve(), this.values);
                                    } else if (describe.resolve().represents(Character.TYPE)) {
                                        annotationValue = new AnnotationValue.ForDescriptionArray<>(Character.TYPE, describe.resolve(), this.values);
                                    } else {
                                        TypeDescription resolve3 = describe.resolve();
                                        Class cls3 = Integer.TYPE;
                                        if (resolve3.represents(cls3)) {
                                            annotationValue = new AnnotationValue.ForDescriptionArray<>(cls3, describe.resolve(), this.values);
                                        } else {
                                            TypeDescription resolve4 = describe.resolve();
                                            Class cls4 = Long.TYPE;
                                            if (resolve4.represents(cls4)) {
                                                annotationValue = new AnnotationValue.ForDescriptionArray<>(cls4, describe.resolve(), this.values);
                                            } else {
                                                TypeDescription resolve5 = describe.resolve();
                                                Class cls5 = Float.TYPE;
                                                if (resolve5.represents(cls5)) {
                                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(cls5, describe.resolve(), this.values);
                                                } else if (describe.resolve().represents(Double.TYPE)) {
                                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Double.TYPE, describe.resolve(), this.values);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            AnnotationValue.Sort sort = AnnotationValue.Sort.NONE;
                            List<AnnotationValue<?, ?>> list = this.values;
                            ListIterator<AnnotationValue<?, ?>> listIterator = list.listIterator(list.size());
                            while (listIterator.hasPrevious() && !sort.isDefined()) {
                                sort = listIterator.previous().getSort();
                            }
                            annotationValue = new ForMismatchedType<>(AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(sort), sort);
                        }
                        if (annotationValue == null) {
                            return this.resolved;
                        }
                        this.resolved = annotationValue;
                        return annotationValue;
                    }

                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ARRAY;
                    }

                    private ForArray(TypePool typePool2, AbstractBase.ComponentTypeReference componentTypeReference2, List<AnnotationValue<?, ?>> list) {
                        super();
                        this.typePool = typePool2;
                        this.componentTypeReference = componentTypeReference2;
                        this.values = list;
                    }
                }

                private static class ForEnumerationValue extends LazyAnnotationValue<EnumerationDescription, Enum<?>> {
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final String typeName;
                    private final TypePool typePool;
                    private final String value;

                    /* access modifiers changed from: protected */
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<EnumerationDescription, Enum<?>> doResolve() {
                        AnnotationValue<EnumerationDescription, Enum<?>> annotationValue = null;
                        if (this.resolved == null) {
                            Resolution describe = this.typePool.describe(this.typeName);
                            if (!describe.isResolved()) {
                                annotationValue = new AnnotationValue.ForMissingType<>(this.typeName);
                            } else if (!describe.resolve().isEnum()) {
                                annotationValue = new ForMismatchedType<>(this.typeName + "." + this.value, AnnotationValue.Sort.ENUMERATION);
                            } else if (((FieldList) describe.resolve().getDeclaredFields().filter(ElementMatchers.named(this.value))).isEmpty()) {
                                annotationValue = new AnnotationValue.ForEnumerationDescription.WithUnknownConstant<>(describe.resolve(), this.value);
                            } else {
                                annotationValue = new AnnotationValue.ForEnumerationDescription<>(new EnumerationDescription.Latent(describe.resolve(), this.value));
                            }
                        }
                        if (annotationValue == null) {
                            return this.resolved;
                        }
                        this.resolved = annotationValue;
                        return annotationValue;
                    }

                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ENUMERATION;
                    }

                    private ForEnumerationValue(TypePool typePool2, String str, String str2) {
                        super();
                        this.typePool = typePool2;
                        this.typeName = str;
                        this.value = str2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                private static class ForMismatchedType<W, X> extends AnnotationValue.AbstractBase<W, X> {
                    private final AnnotationValue.Sort sort;
                    private final String value;

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMismatchedType forMismatchedType = (ForMismatchedType) obj;
                        return this.sort.equals(forMismatchedType.sort) && this.value.equals(forMismatchedType.value);
                    }

                    public AnnotationValue<W, X> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
                        String str;
                        if (inDefinedShape.getReturnType().isArray()) {
                            str = AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(this.sort);
                        } else {
                            str = this.value;
                        }
                        return new AnnotationValue.ForMismatchedType(inDefinedShape, str);
                    }

                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.NONE;
                    }

                    public AnnotationValue.State getState() {
                        return AnnotationValue.State.UNRESOLVED;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.value.hashCode()) * 31) + this.sort.hashCode();
                    }

                    public AnnotationValue.Loaded<X> load(@MaybeNull ClassLoader classLoader) {
                        throw new IllegalStateException("Expected filtering of this unresolved property");
                    }

                    public W resolve() {
                        throw new IllegalStateException("Expected filtering of this unresolved property");
                    }

                    private ForMismatchedType(String str, AnnotationValue.Sort sort2) {
                        this.value = str;
                        this.sort = sort2;
                    }
                }

                private static class ForTypeValue extends LazyAnnotationValue<TypeDescription, Class<?>> {
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final String typeName;
                    private final TypePool typePool;

                    /* access modifiers changed from: protected */
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<TypeDescription, Class<?>> doResolve() {
                        AnnotationValue<TypeDescription, Class<?>> annotationValue;
                        if (this.resolved != null) {
                            annotationValue = null;
                        } else {
                            Resolution describe = this.typePool.describe(this.typeName);
                            if (describe.isResolved()) {
                                annotationValue = new AnnotationValue.ForTypeDescription<>(describe.resolve());
                            } else {
                                annotationValue = new AnnotationValue.ForMissingType<>(this.typeName);
                            }
                        }
                        if (annotationValue == null) {
                            return this.resolved;
                        }
                        this.resolved = annotationValue;
                        return annotationValue;
                    }

                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.TYPE;
                    }

                    private ForTypeValue(TypePool typePool2, String str) {
                        super();
                        this.typePool = typePool2;
                        this.typeName = str;
                    }
                }

                private LazyAnnotationValue() {
                }

                /* access modifiers changed from: protected */
                public abstract AnnotationValue<U, V> doResolve();

                public boolean equals(@MaybeNull Object obj) {
                    return doResolve().equals(obj);
                }

                public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
                    return doResolve().filter(inDefinedShape, typeDefinition);
                }

                public AnnotationValue.State getState() {
                    return doResolve().getState();
                }

                @CachedReturnPlugin.Enhance("hashCode")
                public int hashCode() {
                    int hashCode2 = this.hashCode != 0 ? 0 : doResolve().hashCode();
                    if (hashCode2 == 0) {
                        return this.hashCode;
                    }
                    this.hashCode = hashCode2;
                    return hashCode2;
                }

                public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader classLoader) {
                    return doResolve().load(classLoader);
                }

                public U resolve() {
                    return doResolve().resolve();
                }

                public String toString() {
                    return doResolve().toString();
                }
            }

            private class LazyFieldDescription extends FieldDescription.InDefinedShape.AbstractBase {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;
                @MaybeNull
                private final String genericSignature;
                private final int modifiers;
                private final String name;
                private final GenericTypeToken.Resolution.ForField signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @MaybeNull
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                public int getModifiers() {
                    return this.modifiers;
                }

                public String getName() {
                    return this.name;
                }

                public TypeDescription.Generic getType() {
                    return this.signatureResolution.resolveFieldType(this.descriptor, LazyTypeDescription.this.typePool, this.typeAnnotationTokens, this);
                }

                private LazyFieldDescription(String str, int i10, String str2, @MaybeNull String str3, GenericTypeToken.Resolution.ForField forField, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    this.modifiers = i10;
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = forField;
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }
            }

            private class LazyMethodDescription extends MethodDescription.InDefinedShape.AbstractBase {
                private final List<AnnotationToken> annotationTokens;
                @MaybeNull
                private final AnnotationValue<?, ?> defaultValue;
                private final Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens;
                private final List<String> exceptionTypeDescriptors;
                @MaybeNull
                private final String genericSignature;
                private final String internalName;
                private final int modifiers;
                /* access modifiers changed from: private */
                public final Map<Integer, List<AnnotationToken>> parameterAnnotationTokens;
                /* access modifiers changed from: private */
                public final Integer[] parameterModifiers;
                /* access modifiers changed from: private */
                public final String[] parameterNames;
                /* access modifiers changed from: private */
                public final Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens;
                /* access modifiers changed from: private */
                public final List<String> parameterTypeDescriptors;
                /* access modifiers changed from: private */
                public final Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> returnTypeAnnotationTokens;
                private final String returnTypeDescriptor;
                /* access modifiers changed from: private */
                public final GenericTypeToken.Resolution.ForMethod signatureResolution;
                final /* synthetic */ LazyTypeDescription this$0;
                private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens;

                protected class LazyNonGenericReceiverType extends TypeDescription.Generic.OfNonGenericType {
                    private final TypeDescription typeDescription;

                    protected LazyNonGenericReceiverType(LazyMethodDescription lazyMethodDescription) {
                        this(lazyMethodDescription.this$0);
                    }

                    public TypeDescription asErasure() {
                        return this.typeDescription;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        StringBuilder sb2 = new StringBuilder();
                        for (int i10 = 0; i10 < this.typeDescription.getInnerClassCount(); i10++) {
                            sb2.append('.');
                        }
                        return LazyAnnotationDescription.asListOfNullable(LazyMethodDescription.this.this$0.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(sb2.toString()));
                    }

                    @MaybeNull
                    public TypeDescription.Generic getOwnerType() {
                        TypeDescription declaringType = this.typeDescription.getDeclaringType();
                        if (declaringType == null) {
                            return TypeDescription.Generic.UNDEFINED;
                        }
                        return new LazyNonGenericReceiverType(declaringType);
                    }

                    protected LazyNonGenericReceiverType(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    @MaybeNull
                    public TypeDescription.Generic getComponentType() {
                        return TypeDescription.Generic.UNDEFINED;
                    }
                }

                private class LazyParameterDescription extends ParameterDescription.InDefinedShape.AbstractBase {
                    private final int index;

                    protected LazyParameterDescription(int i10) {
                        this.index = i10;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return LazyAnnotationDescription.asListOfNullable(LazyMethodDescription.this.this$0.typePool, (List) LazyMethodDescription.this.parameterAnnotationTokens.get(Integer.valueOf(this.index)));
                    }

                    public int getIndex() {
                        return this.index;
                    }

                    public int getModifiers() {
                        if (hasModifiers()) {
                            return LazyMethodDescription.this.parameterModifiers[this.index].intValue();
                        }
                        return super.getModifiers();
                    }

                    public String getName() {
                        if (isNamed()) {
                            return LazyMethodDescription.this.parameterNames[this.index];
                        }
                        return super.getName();
                    }

                    public TypeDescription.Generic getType() {
                        return (TypeDescription.Generic) LazyMethodDescription.this.signatureResolution.resolveParameterTypes(LazyMethodDescription.this.parameterTypeDescriptors, LazyMethodDescription.this.this$0.typePool, LazyMethodDescription.this.parameterTypeAnnotationTokens, LazyMethodDescription.this).get(this.index);
                    }

                    public boolean hasModifiers() {
                        return LazyMethodDescription.this.parameterModifiers[this.index] != null;
                    }

                    public boolean isNamed() {
                        return LazyMethodDescription.this.parameterNames[this.index] != null;
                    }

                    public MethodDescription.InDefinedShape getDeclaringMethod() {
                        return LazyMethodDescription.this;
                    }
                }

                private class LazyParameterList extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape> {
                    private LazyParameterList() {
                    }

                    public TypeList.Generic asTypeList() {
                        return LazyMethodDescription.this.signatureResolution.resolveParameterTypes(LazyMethodDescription.this.parameterTypeDescriptors, LazyMethodDescription.this.this$0.typePool, LazyMethodDescription.this.parameterTypeAnnotationTokens, LazyMethodDescription.this);
                    }

                    public boolean hasExplicitMetaData() {
                        for (int i10 = 0; i10 < size(); i10++) {
                            if (LazyMethodDescription.this.parameterNames[i10] == null || LazyMethodDescription.this.parameterModifiers[i10] == null) {
                                return false;
                            }
                        }
                        return true;
                    }

                    public int size() {
                        return LazyMethodDescription.this.parameterTypeDescriptors.size();
                    }

                    public ParameterDescription.InDefinedShape get(int i10) {
                        return new LazyParameterDescription(i10);
                    }
                }

                private class LazyParameterizedReceiverType extends TypeDescription.Generic.OfParameterizedType {
                    private final TypeDescription typeDescription;

                    protected class TypeArgumentList extends TypeList.Generic.AbstractBase {
                        private final List<? extends TypeDescription.Generic> typeVariables;

                        protected class AnnotatedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                            private final int index;
                            private final TypeDescription.Generic typeVariable;

                            protected AnnotatedTypeVariable(TypeDescription.Generic generic, int i10) {
                                this.typeVariable = generic;
                                this.index = i10;
                            }

                            public AnnotationList getDeclaredAnnotations() {
                                TypePool access$2400 = LazyMethodDescription.this.this$0.typePool;
                                Map access$3200 = LazyMethodDescription.this.receiverTypeAnnotationTokens;
                                return LazyAnnotationDescription.asListOfNullable(access$2400, (List) access$3200.get(LazyParameterizedReceiverType.this.getTypePath() + this.index + GenericTypeToken.INDEXED_TYPE_DELIMITER));
                            }

                            public String getSymbol() {
                                return this.typeVariable.getSymbol();
                            }

                            public TypeVariableSource getTypeVariableSource() {
                                return this.typeVariable.getTypeVariableSource();
                            }

                            public TypeList.Generic getUpperBounds() {
                                return this.typeVariable.getUpperBounds();
                            }
                        }

                        protected TypeArgumentList(List<? extends TypeDescription.Generic> list) {
                            this.typeVariables = list;
                        }

                        public int size() {
                            return this.typeVariables.size();
                        }

                        public TypeDescription.Generic get(int i10) {
                            return new AnnotatedTypeVariable((TypeDescription.Generic) this.typeVariables.get(i10), i10);
                        }
                    }

                    protected LazyParameterizedReceiverType(LazyMethodDescription lazyMethodDescription) {
                        this(lazyMethodDescription.this$0);
                    }

                    /* access modifiers changed from: private */
                    public String getTypePath() {
                        StringBuilder sb2 = new StringBuilder();
                        for (int i10 = 0; i10 < this.typeDescription.getInnerClassCount(); i10++) {
                            sb2.append('.');
                        }
                        return sb2.toString();
                    }

                    public TypeDescription asErasure() {
                        return this.typeDescription;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return LazyAnnotationDescription.asListOfNullable(LazyMethodDescription.this.this$0.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(getTypePath()));
                    }

                    @MaybeNull
                    public TypeDescription.Generic getOwnerType() {
                        TypeDescription declaringType = this.typeDescription.getDeclaringType();
                        if (declaringType == null) {
                            return TypeDescription.Generic.UNDEFINED;
                        }
                        if (this.typeDescription.isStatic() || !declaringType.isGenerified()) {
                            return new LazyNonGenericReceiverType(declaringType);
                        }
                        return new LazyParameterizedReceiverType(declaringType);
                    }

                    public TypeList.Generic getTypeArguments() {
                        return new TypeArgumentList(this.typeDescription.getTypeVariables());
                    }

                    protected LazyParameterizedReceiverType(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }
                }

                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asList(this.this$0.typePool, this.annotationTokens);
                }

                @MaybeNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return this.defaultValue;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.signatureResolution.resolveExceptionTypes(this.exceptionTypeDescriptors, this.this$0.typePool, this.exceptionTypeAnnotationTokens, this);
                }

                @MaybeNull
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                public String getInternalName() {
                    return this.internalName;
                }

                public int getModifiers() {
                    return this.modifiers;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new LazyParameterList();
                }

                @MaybeNull
                public TypeDescription.Generic getReceiverType() {
                    if (isStatic()) {
                        return TypeDescription.Generic.UNDEFINED;
                    }
                    if (isConstructor()) {
                        TypeDescription declaringType = getDeclaringType();
                        TypeDescription enclosingType = declaringType.getEnclosingType();
                        if (enclosingType == null) {
                            if (declaringType.isGenerified()) {
                                return new LazyParameterizedReceiverType(declaringType);
                            }
                            return new LazyNonGenericReceiverType(declaringType);
                        } else if (declaringType.isStatic() || !declaringType.isGenerified()) {
                            return new LazyNonGenericReceiverType(enclosingType);
                        } else {
                            return new LazyParameterizedReceiverType(enclosingType);
                        }
                    } else if (this.this$0.isGenerified()) {
                        return new LazyParameterizedReceiverType(this);
                    } else {
                        return new LazyNonGenericReceiverType(this);
                    }
                }

                public TypeDescription.Generic getReturnType() {
                    return this.signatureResolution.resolveReturnType(this.returnTypeDescriptor, this.this$0.typePool, this.returnTypeAnnotationTokens, this);
                }

                public TypeList.Generic getTypeVariables() {
                    return this.signatureResolution.resolveTypeVariables(this.this$0.typePool, this, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens);
                }

                private LazyMethodDescription(LazyTypeDescription lazyTypeDescription, String str, int i10, @MaybeNull String str2, String str3, @MaybeNull GenericTypeToken.Resolution.ForMethod forMethod, String[] strArr, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2, Map<String, List<AnnotationToken>> map3, Map<Integer, Map<String, List<AnnotationToken>>> map4, Map<Integer, Map<String, List<AnnotationToken>>> map5, Map<String, List<AnnotationToken>> map6, List<AnnotationToken> list, Map<Integer, List<AnnotationToken>> map7, @MaybeNull List<MethodToken.ParameterToken> list2, AnnotationValue<?, ?> annotationValue) {
                    String[] strArr2 = strArr;
                    this.this$0 = lazyTypeDescription;
                    this.modifiers = i10;
                    this.internalName = str;
                    Type methodType = Type.getMethodType(str2);
                    Type returnType = methodType.getReturnType();
                    Type[] argumentTypes = methodType.getArgumentTypes();
                    this.returnTypeDescriptor = returnType.getDescriptor();
                    this.parameterTypeDescriptors = new ArrayList(argumentTypes.length);
                    int i11 = 0;
                    for (Type descriptor : argumentTypes) {
                        this.parameterTypeDescriptors.add(descriptor.getDescriptor());
                    }
                    this.genericSignature = str3;
                    this.signatureResolution = forMethod;
                    if (strArr2 == null) {
                        this.exceptionTypeDescriptors = Collections.emptyList();
                    } else {
                        this.exceptionTypeDescriptors = new ArrayList(strArr2.length);
                        for (String objectType : strArr2) {
                            this.exceptionTypeDescriptors.add(Type.getObjectType(objectType).getDescriptor());
                        }
                    }
                    this.typeVariableAnnotationTokens = map;
                    this.typeVariableBoundAnnotationTokens = map2;
                    this.returnTypeAnnotationTokens = map3;
                    this.parameterTypeAnnotationTokens = map4;
                    this.exceptionTypeAnnotationTokens = map5;
                    this.receiverTypeAnnotationTokens = map6;
                    this.annotationTokens = list;
                    this.parameterAnnotationTokens = map7;
                    this.parameterNames = new String[argumentTypes.length];
                    this.parameterModifiers = new Integer[argumentTypes.length];
                    if (list2.size() == argumentTypes.length) {
                        for (MethodToken.ParameterToken next : list2) {
                            this.parameterNames[i11] = next.getName();
                            this.parameterModifiers[i11] = next.getModifiers();
                            i11++;
                        }
                    }
                    this.defaultValue = annotationValue;
                }

                public TypeDescription getDeclaringType() {
                    return this.this$0;
                }
            }

            protected static class LazyNestMemberList extends TypeList.AbstractBase {
                private final List<String> nestMembers;
                private final TypeDescription typeDescription;
                private final TypePool typePool;

                protected LazyNestMemberList(TypeDescription typeDescription2, TypePool typePool2, List<String> list) {
                    this.typeDescription = typeDescription2;
                    this.typePool = typePool2;
                    this.nestMembers = list;
                }

                public int getStackSize() {
                    return this.nestMembers.size() + 1;
                }

                public int size() {
                    return this.nestMembers.size() + 1;
                }

                public String[] toInternalNames() {
                    int i10 = 1;
                    String[] strArr = new String[(this.nestMembers.size() + 1)];
                    strArr[0] = this.typeDescription.getInternalName();
                    for (String replace : this.nestMembers) {
                        strArr[i10] = replace.replace('.', '/');
                        i10++;
                    }
                    return strArr;
                }

                public TypeDescription get(int i10) {
                    if (i10 == 0) {
                        return this.typeDescription;
                    }
                    return this.typePool.describe(this.nestMembers.get(i10 - 1)).resolve();
                }
            }

            private static class LazyPackageDescription extends PackageDescription.AbstractBase {
                private final String name;
                private final TypePool typePool;

                public AnnotationList getDeclaredAnnotations() {
                    TypePool typePool2 = this.typePool;
                    Resolution describe = typePool2.describe(this.name + "." + PackageDescription.PACKAGE_CLASS_NAME);
                    if (describe.isResolved()) {
                        return describe.resolve().getDeclaredAnnotations();
                    }
                    return new AnnotationList.Empty();
                }

                public String getName() {
                    return this.name;
                }

                private LazyPackageDescription(TypePool typePool2, String str) {
                    this.typePool = typePool2;
                    this.name = str;
                }
            }

            private class LazyRecordComponentDescription extends RecordComponentDescription.InDefinedShape.AbstractBase {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;
                @MaybeNull
                private final String genericSignature;
                private final String name;
                private final GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                public String getActualName() {
                    return this.name;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asList(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @MaybeNull
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                public TypeDescription.Generic getType() {
                    return this.signatureResolution.resolveRecordType(this.descriptor, LazyTypeDescription.this.typePool, this.typeAnnotationTokens, this);
                }

                private LazyRecordComponentDescription(String str, String str2, @MaybeNull String str3, GenericTypeToken.Resolution.ForRecordComponent forRecordComponent, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = forRecordComponent;
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }
            }

            protected static class LazyTypeList extends TypeList.AbstractBase {
                private final List<String> descriptors;
                private final TypePool typePool;

                protected LazyTypeList(TypePool typePool2, List<String> list) {
                    this.typePool = typePool2;
                    this.descriptors = list;
                }

                public int getStackSize() {
                    int i10 = 0;
                    for (String type : this.descriptors) {
                        i10 += Type.getType(type).getSize();
                    }
                    return i10;
                }

                public int size() {
                    return this.descriptors.size();
                }

                @MaybeNull
                public String[] toInternalNames() {
                    int size = this.descriptors.size();
                    String[] strArr = new String[size];
                    int i10 = 0;
                    for (String type : this.descriptors) {
                        strArr[i10] = Type.getType(type).getInternalName();
                        i10++;
                    }
                    if (size == 0) {
                        return TypeList.NO_INTERFACES;
                    }
                    return strArr;
                }

                public TypeDescription get(int i10) {
                    return TokenizedGenericType.toErasure(this.typePool, this.descriptors.get(i10));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class MethodToken {
                private final List<AnnotationToken> annotationTokens;
                @UnknownNull
                private final AnnotationValue<?, ?> defaultValue;
                private final String descriptor;
                @MaybeNull
                private final String[] exceptionName;
                private final Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens;
                @UnknownNull
                private final String genericSignature;
                private final int modifiers;
                private final String name;
                private final Map<Integer, List<AnnotationToken>> parameterAnnotationTokens;
                private final List<ParameterToken> parameterTokens;
                private final Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> returnTypeAnnotationTokens;
                private final GenericTypeToken.Resolution.ForMethod signatureResolution;
                private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ParameterToken {
                    @AlwaysNull
                    protected static final Integer NO_MODIFIERS = null;
                    @AlwaysNull
                    protected static final String NO_NAME = null;
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    @MaybeNull
                    private final Integer modifiers;
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    @MaybeNull
                    private final String name;

                    protected ParameterToken() {
                        this(NO_NAME);
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
                        if (r2 != null) goto L_0x0026;
                     */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                        /*
                            r4 = this;
                            r0 = 1
                            if (r4 != r5) goto L_0x0004
                            return r0
                        L_0x0004:
                            r1 = 0
                            if (r5 != 0) goto L_0x0008
                            return r1
                        L_0x0008:
                            java.lang.Class r2 = r4.getClass()
                            java.lang.Class r3 = r5.getClass()
                            if (r2 == r3) goto L_0x0013
                            return r1
                        L_0x0013:
                            java.lang.Integer r2 = r4.modifiers
                            net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$MethodToken$ParameterToken r5 = (net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken) r5
                            java.lang.Integer r3 = r5.modifiers
                            if (r3 == 0) goto L_0x0024
                            if (r2 == 0) goto L_0x0026
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L_0x0027
                            return r1
                        L_0x0024:
                            if (r2 == 0) goto L_0x0027
                        L_0x0026:
                            return r1
                        L_0x0027:
                            java.lang.String r2 = r4.name
                            java.lang.String r5 = r5.name
                            if (r5 == 0) goto L_0x0036
                            if (r2 == 0) goto L_0x0038
                            boolean r5 = r2.equals(r5)
                            if (r5 != 0) goto L_0x0039
                            return r1
                        L_0x0036:
                            if (r2 == 0) goto L_0x0039
                        L_0x0038:
                            return r1
                        L_0x0039:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken.equals(java.lang.Object):boolean");
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public Integer getModifiers() {
                        return this.modifiers;
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public String getName() {
                        return this.name;
                    }

                    public int hashCode() {
                        int hashCode = getClass().hashCode() * 31;
                        String str = this.name;
                        if (str != null) {
                            hashCode += str.hashCode();
                        }
                        int i10 = hashCode * 31;
                        Integer num = this.modifiers;
                        return num != null ? i10 + num.hashCode() : i10;
                    }

                    protected ParameterToken(@MaybeNull String str) {
                        this(str, NO_MODIFIERS);
                    }

                    protected ParameterToken(@MaybeNull String str, @MaybeNull Integer num) {
                        this.name = str;
                        this.modifiers = num;
                    }
                }

                protected MethodToken(String str, int i10, String str2, @MaybeNull String str3, @MaybeNull String[] strArr, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2, Map<String, List<AnnotationToken>> map3, Map<Integer, Map<String, List<AnnotationToken>>> map4, Map<Integer, Map<String, List<AnnotationToken>>> map5, Map<String, List<AnnotationToken>> map6, List<AnnotationToken> list, Map<Integer, List<AnnotationToken>> map7, List<ParameterToken> list2, @MaybeNull AnnotationValue<?, ?> annotationValue) {
                    GenericTypeToken.Resolution.ForMethod forMethod;
                    this.modifiers = -131073 & i10;
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    if (TypeDescription.AbstractBase.RAW_TYPES) {
                        forMethod = GenericTypeToken.Resolution.Raw.INSTANCE;
                    } else {
                        forMethod = GenericTypeExtractor.ForSignature.OfMethod.extract(str3);
                    }
                    this.signatureResolution = forMethod;
                    this.exceptionName = strArr;
                    this.typeVariableAnnotationTokens = map;
                    this.typeVariableBoundAnnotationTokens = map2;
                    this.returnTypeAnnotationTokens = map3;
                    this.parameterTypeAnnotationTokens = map4;
                    this.exceptionTypeAnnotationTokens = map5;
                    this.receiverTypeAnnotationTokens = map6;
                    this.annotationTokens = list;
                    this.parameterAnnotationTokens = map7;
                    this.parameterTokens = list2;
                    this.defaultValue = annotationValue;
                }

                /* access modifiers changed from: private */
                public MethodDescription.InDefinedShape toMethodDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyMethodDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.exceptionName, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens, this.returnTypeAnnotationTokens, this.parameterTypeAnnotationTokens, this.exceptionTypeAnnotationTokens, this.receiverTypeAnnotationTokens, this.annotationTokens, this.parameterAnnotationTokens, this.parameterTokens, this.defaultValue);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    MethodToken methodToken = (MethodToken) obj;
                    return this.modifiers == methodToken.modifiers && this.name.equals(methodToken.name) && this.descriptor.equals(methodToken.descriptor) && this.genericSignature.equals(methodToken.genericSignature) && this.signatureResolution.equals(methodToken.signatureResolution) && Arrays.equals(this.exceptionName, methodToken.exceptionName) && this.typeVariableAnnotationTokens.equals(methodToken.typeVariableAnnotationTokens) && this.typeVariableBoundAnnotationTokens.equals(methodToken.typeVariableBoundAnnotationTokens) && this.returnTypeAnnotationTokens.equals(methodToken.returnTypeAnnotationTokens) && this.parameterTypeAnnotationTokens.equals(methodToken.parameterTypeAnnotationTokens) && this.exceptionTypeAnnotationTokens.equals(methodToken.exceptionTypeAnnotationTokens) && this.receiverTypeAnnotationTokens.equals(methodToken.receiverTypeAnnotationTokens) && this.annotationTokens.equals(methodToken.annotationTokens) && this.parameterAnnotationTokens.equals(methodToken.parameterAnnotationTokens) && this.parameterTokens.equals(methodToken.parameterTokens) && this.defaultValue.equals(methodToken.defaultValue);
                }

                public int hashCode() {
                    return (((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.modifiers) * 31) + this.descriptor.hashCode()) * 31) + this.genericSignature.hashCode()) * 31) + this.signatureResolution.hashCode()) * 31) + Arrays.hashCode(this.exceptionName)) * 31) + this.typeVariableAnnotationTokens.hashCode()) * 31) + this.typeVariableBoundAnnotationTokens.hashCode()) * 31) + this.returnTypeAnnotationTokens.hashCode()) * 31) + this.parameterTypeAnnotationTokens.hashCode()) * 31) + this.exceptionTypeAnnotationTokens.hashCode()) * 31) + this.receiverTypeAnnotationTokens.hashCode()) * 31) + this.annotationTokens.hashCode()) * 31) + this.parameterAnnotationTokens.hashCode()) * 31) + this.parameterTokens.hashCode()) * 31) + this.defaultValue.hashCode();
                }
            }

            protected class MethodTokenList extends MethodList.AbstractBase<MethodDescription.InDefinedShape> {
                protected MethodTokenList() {
                }

                public int size() {
                    return LazyTypeDescription.this.methodTokens.size();
                }

                public MethodDescription.InDefinedShape get(int i10) {
                    return ((MethodToken) LazyTypeDescription.this.methodTokens.get(i10)).toMethodDescription(LazyTypeDescription.this);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class RecordComponentToken {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;
                @UnknownNull
                private final String genericSignature;
                private final String name;
                private final GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                protected RecordComponentToken(String str, String str2, @MaybeNull String str3, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    GenericTypeToken.Resolution.ForRecordComponent forRecordComponent;
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    if (TypeDescription.AbstractBase.RAW_TYPES) {
                        forRecordComponent = GenericTypeToken.Resolution.Raw.INSTANCE;
                    } else {
                        forRecordComponent = GenericTypeExtractor.ForSignature.OfRecordComponent.extract(str3);
                    }
                    this.signatureResolution = forRecordComponent;
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                /* access modifiers changed from: private */
                public RecordComponentDescription.InDefinedShape toRecordComponentDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyRecordComponentDescription(this.name, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    RecordComponentToken recordComponentToken = (RecordComponentToken) obj;
                    return this.name.equals(recordComponentToken.name) && this.descriptor.equals(recordComponentToken.descriptor) && this.genericSignature.equals(recordComponentToken.genericSignature) && this.signatureResolution.equals(recordComponentToken.signatureResolution) && this.typeAnnotationTokens.equals(recordComponentToken.typeAnnotationTokens) && this.annotationTokens.equals(recordComponentToken.annotationTokens);
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.descriptor.hashCode()) * 31) + this.genericSignature.hashCode()) * 31) + this.signatureResolution.hashCode()) * 31) + this.typeAnnotationTokens.hashCode()) * 31) + this.annotationTokens.hashCode();
                }
            }

            protected class RecordComponentTokenList extends RecordComponentList.AbstractBase<RecordComponentDescription.InDefinedShape> {
                protected RecordComponentTokenList() {
                }

                public int size() {
                    return LazyTypeDescription.this.recordComponentTokens.size();
                }

                public RecordComponentDescription.InDefinedShape get(int i10) {
                    return ((RecordComponentToken) LazyTypeDescription.this.recordComponentTokens.get(i10)).toRecordComponentDescription(LazyTypeDescription.this);
                }
            }

            protected static class TokenizedGenericType extends TypeDescription.Generic.LazyProjection.WithEagerNavigation {
                private final Map<String, List<AnnotationToken>> annotationTokens;
                private transient /* synthetic */ TypeDescription erasure;
                private final GenericTypeToken genericTypeToken;
                private final String rawTypeDescriptor;
                private transient /* synthetic */ TypeDescription.Generic resolved;
                private final TypePool typePool;
                private final TypeVariableSource typeVariableSource;

                protected static class Malformed extends TypeDescription.Generic.LazyProjection.WithEagerNavigation {
                    private final String rawTypeDescriptor;
                    private final TypePool typePool;

                    protected static class TokenList extends TypeList.Generic.AbstractBase {
                        private final List<String> rawTypeDescriptors;
                        private final TypePool typePool;

                        protected TokenList(TypePool typePool2, List<String> list) {
                            this.typePool = typePool2;
                            this.rawTypeDescriptors = list;
                        }

                        public TypeList asErasures() {
                            return new LazyTypeList(this.typePool, this.rawTypeDescriptors);
                        }

                        public int size() {
                            return this.rawTypeDescriptors.size();
                        }

                        public TypeDescription.Generic get(int i10) {
                            return new Malformed(this.typePool, this.rawTypeDescriptors.get(i10));
                        }
                    }

                    protected Malformed(TypePool typePool2, String str) {
                        this.typePool = typePool2;
                        this.rawTypeDescriptor = str;
                    }

                    public TypeDescription asErasure() {
                        return TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptor);
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        throw new GenericSignatureFormatError();
                    }

                    /* access modifiers changed from: protected */
                    public TypeDescription.Generic resolve() {
                        throw new GenericSignatureFormatError();
                    }
                }

                protected static class TokenList extends TypeList.Generic.AbstractBase {
                    private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                    private final List<GenericTypeToken> genericTypeTokens;
                    private final List<String> rawTypeDescriptors;
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;

                    public TypeList asErasures() {
                        return new LazyTypeList(this.typePool, this.rawTypeDescriptors);
                    }

                    public int size() {
                        return this.rawTypeDescriptors.size();
                    }

                    private TokenList(TypePool typePool2, List<GenericTypeToken> list, Map<Integer, Map<String, List<AnnotationToken>>> map, List<String> list2, TypeVariableSource typeVariableSource2) {
                        this.typePool = typePool2;
                        this.genericTypeTokens = list;
                        this.annotationTokens = map;
                        this.rawTypeDescriptors = list2;
                        this.typeVariableSource = typeVariableSource2;
                    }

                    public TypeDescription.Generic get(int i10) {
                        if (this.rawTypeDescriptors.size() == this.genericTypeTokens.size()) {
                            return TokenizedGenericType.of(this.typePool, this.genericTypeTokens.get(i10), this.rawTypeDescriptors.get(i10), this.annotationTokens.get(Integer.valueOf(i10)), this.typeVariableSource);
                        }
                        return TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptors.get(i10)).asGenericType();
                    }
                }

                protected static class TypeVariableList extends TypeList.Generic.AbstractBase {
                    private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                    private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens;
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;
                    private final List<GenericTypeToken.OfFormalTypeVariable> typeVariables;

                    protected TypeVariableList(TypePool typePool2, List<GenericTypeToken.OfFormalTypeVariable> list, TypeVariableSource typeVariableSource2, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                        this.typePool = typePool2;
                        this.typeVariables = list;
                        this.typeVariableSource = typeVariableSource2;
                        this.annotationTokens = map;
                        this.boundAnnotationTokens = map2;
                    }

                    public int size() {
                        return this.typeVariables.size();
                    }

                    public TypeDescription.Generic get(int i10) {
                        return this.typeVariables.get(i10).toGenericType(this.typePool, this.typeVariableSource, this.annotationTokens.get(Integer.valueOf(i10)), this.boundAnnotationTokens.get(Integer.valueOf(i10)));
                    }
                }

                protected TokenizedGenericType(TypePool typePool2, GenericTypeToken genericTypeToken2, String str, Map<String, List<AnnotationToken>> map, TypeVariableSource typeVariableSource2) {
                    this.typePool = typePool2;
                    this.genericTypeToken = genericTypeToken2;
                    this.rawTypeDescriptor = str;
                    this.annotationTokens = map;
                    this.typeVariableSource = typeVariableSource2;
                }

                protected static TypeDescription.Generic of(TypePool typePool2, GenericTypeToken genericTypeToken2, String str, @MaybeNull Map<String, List<AnnotationToken>> map, TypeVariableSource typeVariableSource2) {
                    if (map == null) {
                        map = Collections.emptyMap();
                    }
                    return new TokenizedGenericType(typePool2, genericTypeToken2, str, map, typeVariableSource2);
                }

                protected static TypeDescription toErasure(TypePool typePool2, String str) {
                    String str2;
                    Type type = Type.getType(str);
                    if (type.getSort() == 9) {
                        str2 = type.getInternalName().replace('/', '.');
                    } else {
                        str2 = type.getClassName();
                    }
                    return typePool2.describe(str2).resolve();
                }

                @CachedReturnPlugin.Enhance("erasure")
                public TypeDescription asErasure() {
                    TypeDescription erasure2 = this.erasure != null ? null : toErasure(this.typePool, this.rawTypeDescriptor);
                    if (erasure2 == null) {
                        return this.erasure;
                    }
                    this.erasure = erasure2;
                    return erasure2;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return resolve().getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public TypeDescription.Generic resolve() {
                    TypeDescription.Generic genericType = this.resolved != null ? null : this.genericTypeToken.toGenericType(this.typePool, this.typeVariableSource, "", this.annotationTokens);
                    if (genericType == null) {
                        return this.resolved;
                    }
                    this.resolved = genericType;
                    return genericType;
                }
            }

            protected interface TypeContainment {

                public enum SelfContained implements TypeContainment {
                    INSTANCE;

                    @MaybeNull
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        return MethodDescription.UNDEFINED;
                    }

                    @MaybeNull
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return TypeDescription.UNDEFINED;
                    }

                    public boolean isLocalType() {
                        return false;
                    }

                    public boolean isSelfContained() {
                        return true;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithinMethod implements TypeContainment {
                    private final String methodDescriptor;
                    private final String methodName;
                    private final String name;

                    protected WithinMethod(String str, String str2, String str3) {
                        this.name = str.replace('/', '.');
                        this.methodName = str2;
                        this.methodDescriptor = str3;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithinMethod withinMethod = (WithinMethod) obj;
                        return this.name.equals(withinMethod.name) && this.methodName.equals(withinMethod.methodName) && this.methodDescriptor.equals(withinMethod.methodDescriptor);
                    }

                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        TypeDescription enclosingType = getEnclosingType(typePool);
                        if (enclosingType != null) {
                            MethodList methodList = (MethodList) enclosingType.getDeclaredMethods().filter(ElementMatchers.hasMethodName(this.methodName).and(ElementMatchers.hasDescriptor(this.methodDescriptor)));
                            if (!methodList.isEmpty()) {
                                return (MethodDescription.InDefinedShape) methodList.getOnly();
                            }
                            throw new IllegalStateException(this.methodName + this.methodDescriptor + " not declared by " + enclosingType);
                        }
                        throw new IllegalStateException("Could not resolve enclosing type " + this.name);
                    }

                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return typePool.describe(this.name).resolve();
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.methodName.hashCode()) * 31) + this.methodDescriptor.hashCode();
                    }

                    public boolean isLocalType() {
                        return true;
                    }

                    public boolean isSelfContained() {
                        return false;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithinType implements TypeContainment {
                    private final boolean localType;
                    private final String name;

                    protected WithinType(String str, boolean z10) {
                        this.name = str.replace('/', '.');
                        this.localType = z10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithinType withinType = (WithinType) obj;
                        return this.localType == withinType.localType && this.name.equals(withinType.name);
                    }

                    @MaybeNull
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        return MethodDescription.UNDEFINED;
                    }

                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return typePool.describe(this.name).resolve();
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + (this.localType ? 1 : 0);
                    }

                    public boolean isLocalType() {
                        return this.localType;
                    }

                    public boolean isSelfContained() {
                        return false;
                    }
                }

                @MaybeNull
                MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool);

                @MaybeNull
                TypeDescription getEnclosingType(TypePool typePool);

                boolean isLocalType();

                boolean isSelfContained();
            }

            protected LazyTypeDescription(TypePool typePool2, int i10, int i11, String str, @MaybeNull String str2, @MaybeNull String[] strArr, @MaybeNull String str3, TypeContainment typeContainment2, @MaybeNull String str4, List<String> list, boolean z10, @MaybeNull String str5, List<String> list2, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2, Map<Integer, Map<String, List<AnnotationToken>>> map3, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map4, List<AnnotationToken> list3, List<FieldToken> list4, List<MethodToken> list5, List<RecordComponentToken> list6, List<String> list7, ClassFileVersion classFileVersion2) {
                String str6;
                GenericTypeToken.Resolution.ForType forType;
                String str7;
                String str8;
                String[] strArr2 = strArr;
                String str9 = str4;
                this.typePool = typePool2;
                this.actualModifiers = i10 & -33;
                this.modifiers = -131105 & i11;
                this.name = Type.getObjectType(str).getClassName();
                if (str2 == null) {
                    str6 = NO_TYPE;
                } else {
                    str6 = Type.getObjectType(str2).getDescriptor();
                }
                this.superClassDescriptor = str6;
                this.genericSignature = str3;
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    forType = GenericTypeToken.Resolution.Raw.INSTANCE;
                } else {
                    forType = GenericTypeExtractor.ForSignature.OfType.extract(str3);
                }
                this.signatureResolution = forType;
                if (strArr2 == null) {
                    this.interfaceTypeDescriptors = Collections.emptyList();
                } else {
                    this.interfaceTypeDescriptors = new ArrayList(strArr2.length);
                    for (String objectType : strArr2) {
                        this.interfaceTypeDescriptors.add(Type.getObjectType(objectType).getDescriptor());
                    }
                }
                this.typeContainment = typeContainment2;
                if (str9 == null) {
                    str7 = NO_TYPE;
                } else {
                    str7 = str9.replace('/', '.');
                }
                this.declaringTypeName = str7;
                this.declaredTypes = list;
                this.anonymousType = z10;
                if (str5 == null) {
                    str8 = NO_TYPE;
                } else {
                    str8 = Type.getObjectType(str5).getClassName();
                }
                this.nestHost = str8;
                this.nestMembers = new ArrayList(list2.size());
                for (String objectType2 : list2) {
                    this.nestMembers.add(Type.getObjectType(objectType2).getClassName());
                }
                this.superClassAnnotationTokens = map;
                this.interfaceAnnotationTokens = map2;
                this.typeVariableAnnotationTokens = map3;
                this.typeVariableBoundsAnnotationTokens = map4;
                this.annotationTokens = list3;
                this.fieldTokens = list4;
                this.methodTokens = list5;
                this.recordComponentTokens = list6;
                this.permittedSubclasses = new ArrayList(list7.size());
                for (String objectType3 : list7) {
                    this.permittedSubclasses.add(Type.getObjectType(objectType3).getDescriptor());
                }
                this.classFileVersion = classFileVersion2;
            }

            public int getActualModifiers(boolean z10) {
                return z10 ? this.actualModifiers | 32 : this.actualModifiers;
            }

            public ClassFileVersion getClassFileVersion() {
                return this.classFileVersion;
            }

            public AnnotationList getDeclaredAnnotations() {
                return LazyAnnotationDescription.asList(this.typePool, this.annotationTokens);
            }

            public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
                return new FieldTokenList();
            }

            public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
                return new MethodTokenList();
            }

            public TypeList getDeclaredTypes() {
                return new LazyTypeList(this.typePool, this.declaredTypes);
            }

            @MaybeNull
            public MethodDescription.InDefinedShape getEnclosingMethod() {
                return this.typeContainment.getEnclosingMethod(this.typePool);
            }

            @MaybeNull
            public TypeDescription getEnclosingType() {
                return this.typeContainment.getEnclosingType(this.typePool);
            }

            @MaybeNull
            public String getGenericSignature() {
                return this.genericSignature;
            }

            public TypeList.Generic getInterfaces() {
                return this.signatureResolution.resolveInterfaceTypes(this.interfaceTypeDescriptors, this.typePool, this.interfaceAnnotationTokens, this);
            }

            public int getModifiers() {
                return this.modifiers;
            }

            public String getName() {
                return this.name;
            }

            public TypeDescription getNestHost() {
                String str = this.nestHost;
                if (str == null) {
                    return this;
                }
                return this.typePool.describe(str).resolve();
            }

            public TypeList getNestMembers() {
                String str = this.nestHost;
                if (str == null) {
                    return new LazyNestMemberList(this, this.typePool, this.nestMembers);
                }
                return this.typePool.describe(str).resolve().getNestMembers();
            }

            @MaybeNull
            public PackageDescription getPackage() {
                String str;
                String name2 = getName();
                int lastIndexOf = name2.lastIndexOf(46);
                TypePool typePool2 = this.typePool;
                if (lastIndexOf == -1) {
                    str = "";
                } else {
                    str = name2.substring(0, lastIndexOf);
                }
                return new LazyPackageDescription(typePool2, str);
            }

            public TypeList getPermittedSubtypes() {
                return new LazyTypeList(this.typePool, this.permittedSubclasses);
            }

            public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
                return new RecordComponentTokenList();
            }

            @MaybeNull
            public TypeDescription.Generic getSuperClass() {
                if (this.superClassDescriptor == null || isInterface()) {
                    return TypeDescription.Generic.UNDEFINED;
                }
                return this.signatureResolution.resolveSuperClass(this.superClassDescriptor, this.typePool, this.superClassAnnotationTokens, this);
            }

            public TypeList.Generic getTypeVariables() {
                return this.signatureResolution.resolveTypeVariables(this.typePool, this, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens);
            }

            public boolean isAnonymousType() {
                return this.anonymousType;
            }

            public boolean isLocalType() {
                return !this.anonymousType && this.typeContainment.isLocalType();
            }

            public boolean isRecord() {
                return (this.actualModifiers & 65536) != 0 && JavaType.RECORD.getTypeStub().getDescriptor().equals(this.superClassDescriptor);
            }

            public boolean isSealed() {
                return !this.permittedSubclasses.isEmpty();
            }

            @MaybeNull
            public TypeDescription getDeclaringType() {
                String str = this.declaringTypeName;
                if (str == null) {
                    return TypeDescription.UNDEFINED;
                }
                return this.typePool.describe(str).resolve();
            }
        }

        protected static class ParameterBag {
            private final Map<Integer, String> parameterRegistry = new HashMap();
            private final Type[] parameterType;

            protected ParameterBag(Type[] typeArr) {
                this.parameterType = typeArr;
            }

            /* access modifiers changed from: protected */
            public void register(int i10, String str) {
                this.parameterRegistry.put(Integer.valueOf(i10), str);
            }

            /* access modifiers changed from: protected */
            public List<LazyTypeDescription.MethodToken.ParameterToken> resolve(boolean z10) {
                int i10;
                LazyTypeDescription.MethodToken.ParameterToken parameterToken;
                ArrayList arrayList = new ArrayList(this.parameterType.length);
                if (z10) {
                    i10 = StackSize.ZERO.getSize();
                } else {
                    i10 = StackSize.SINGLE.getSize();
                }
                for (Type type : this.parameterType) {
                    String str = this.parameterRegistry.get(Integer.valueOf(i10));
                    if (str == null) {
                        parameterToken = new LazyTypeDescription.MethodToken.ParameterToken();
                    } else {
                        parameterToken = new LazyTypeDescription.MethodToken.ParameterToken(str);
                    }
                    arrayList.add(parameterToken);
                    i10 += type.getSize();
                }
                return arrayList;
            }
        }

        public enum ReaderMode {
            EXTENDED(4),
            FAST(1);
            
            private final int flags;

            private ReaderMode(int i10) {
                this.flags = i10;
            }

            /* access modifiers changed from: protected */
            public int getFlags() {
                return this.flags;
            }

            public boolean isExtended() {
                return this == EXTENDED;
            }
        }

        protected class TypeExtractor extends ClassVisitor {
            private static final int REAL_MODIFIER_MASK = 65535;
            private static final int SUPER_CLASS_INDEX = -1;
            private int actualModifiers;
            private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();
            private boolean anonymousType = false;
            @MaybeNull
            private ClassFileVersion classFileVersion;
            private final List<String> declaredTypes = new ArrayList();
            @MaybeNull
            private String declaringTypeName;
            /* access modifiers changed from: private */
            public final List<LazyTypeDescription.FieldToken> fieldTokens = new ArrayList();
            @MaybeNull
            private String genericSignature;
            @MaybeNull
            private String[] interfaceName;
            @MaybeNull
            private String internalName;
            /* access modifiers changed from: private */
            public final List<LazyTypeDescription.MethodToken> methodTokens = new ArrayList();
            private int modifiers;
            @MaybeNull
            private String nestHost;
            private final List<String> nestMembers = new ArrayList();
            private final List<String> permittedSubclasses = new ArrayList();
            /* access modifiers changed from: private */
            public final List<LazyTypeDescription.RecordComponentToken> recordComponentTokens = new ArrayList();
            @MaybeNull
            private String superClassName;
            private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> superTypeAnnotationTokens = new HashMap();
            private LazyTypeDescription.TypeContainment typeContainment = LazyTypeDescription.TypeContainment.SelfContained.INSTANCE;
            private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens = new HashMap();
            private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> typeVariableBoundsAnnotationTokens = new HashMap();

            protected class AnnotationExtractor extends AnnotationVisitor {
                /* access modifiers changed from: private */
                public final AnnotationRegistrant annotationRegistrant;
                private final ComponentTypeLocator componentTypeLocator;

                protected class AnnotationLookup implements AnnotationRegistrant {
                    private final String descriptor;
                    private final String name;
                    private final Map<String, AnnotationValue<?, ?>> values = new HashMap();

                    protected AnnotationLookup(String str, String str2) {
                        this.descriptor = str;
                        this.name = str2;
                    }

                    public void onComplete() {
                        AnnotationExtractor.this.annotationRegistrant.register(this.name, new LazyTypeDescription.LazyAnnotationValue.ForAnnotationValue(Default.this, new LazyTypeDescription.AnnotationToken(this.descriptor, this.values)));
                    }

                    public void register(String str, AnnotationValue<?, ?> annotationValue) {
                        this.values.put(str, annotationValue);
                    }
                }

                protected class ArrayLookup implements AnnotationRegistrant {
                    private final AbstractBase.ComponentTypeReference componentTypeReference;
                    private final String name;
                    private final List<AnnotationValue<?, ?>> values;

                    public void onComplete() {
                        AnnotationExtractor.this.annotationRegistrant.register(this.name, new LazyTypeDescription.LazyAnnotationValue.ForArray(Default.this, this.componentTypeReference, this.values));
                    }

                    public void register(String str, AnnotationValue<?, ?> annotationValue) {
                        this.values.add(annotationValue);
                    }

                    private ArrayLookup(String str, AbstractBase.ComponentTypeReference componentTypeReference2) {
                        this.name = str;
                        this.componentTypeReference = componentTypeReference2;
                        this.values = new ArrayList();
                    }
                }

                protected AnnotationExtractor(TypeExtractor typeExtractor, String str, List<LazyTypeDescription.AnnotationToken> list, ComponentTypeLocator componentTypeLocator2) {
                    this(new AnnotationRegistrant.ForByteCodeElement(str, list), componentTypeLocator2);
                }

                public void visit(String str, Object obj) {
                    String str2;
                    if (obj instanceof Type) {
                        Type type = (Type) obj;
                        AnnotationRegistrant annotationRegistrant2 = this.annotationRegistrant;
                        Default defaultR = Default.this;
                        if (type.getSort() == 9) {
                            str2 = type.getInternalName().replace('/', '.');
                        } else {
                            str2 = type.getClassName();
                        }
                        annotationRegistrant2.register(str, new LazyTypeDescription.LazyAnnotationValue.ForTypeValue(defaultR, str2));
                        return;
                    }
                    this.annotationRegistrant.register(str, AnnotationValue.ForConstant.of(obj));
                }

                public AnnotationVisitor visitAnnotation(String str, String str2) {
                    return new AnnotationExtractor(new AnnotationLookup(str2, str), new ComponentTypeLocator.ForAnnotationProperty(Default.this, str2));
                }

                public AnnotationVisitor visitArray(String str) {
                    return new AnnotationExtractor(new ArrayLookup(str, this.componentTypeLocator.bind(str)), ComponentTypeLocator.Illegal.INSTANCE);
                }

                public void visitEnd() {
                    this.annotationRegistrant.onComplete();
                }

                public void visitEnum(String str, String str2, String str3) {
                    this.annotationRegistrant.register(str, new LazyTypeDescription.LazyAnnotationValue.ForEnumerationValue(Default.this, str2.substring(1, str2.length() - 1).replace('/', '.'), str3));
                }

                protected AnnotationExtractor(TypeExtractor typeExtractor, String str, int i10, Map<Integer, List<LazyTypeDescription.AnnotationToken>> map, ComponentTypeLocator componentTypeLocator2) {
                    this(new AnnotationRegistrant.ForByteCodeElement.WithIndex(str, i10, map), componentTypeLocator2);
                }

                protected AnnotationExtractor(AnnotationRegistrant annotationRegistrant2, ComponentTypeLocator componentTypeLocator2) {
                    super(OpenedClassReader.ASM_API);
                    this.annotationRegistrant = annotationRegistrant2;
                    this.componentTypeLocator = componentTypeLocator2;
                }
            }

            protected class FieldExtractor extends FieldVisitor {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();
                private final String descriptor;
                @MaybeNull
                private final String genericSignature;
                private final String internalName;
                private final int modifiers;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> typeAnnotationTokens = new HashMap();

                protected FieldExtractor(int i10, String str, String str2, @MaybeNull String str3) {
                    super(OpenedClassReader.ASM_API);
                    this.modifiers = i10;
                    this.internalName = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                public void visitEnd() {
                    TypeExtractor.this.fieldTokens.add(new LazyTypeDescription.FieldToken(this.internalName, this.modifiers, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
                }

                @MaybeNull
                public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                    TypeReference typeReference = new TypeReference(i10);
                    if (typeReference.getSort() == 19) {
                        AnnotationRegistrant.ForTypeVariable forTypeVariable = new AnnotationRegistrant.ForTypeVariable(str, typePath, this.typeAnnotationTokens);
                        TypeExtractor typeExtractor = TypeExtractor.this;
                        return new AnnotationExtractor(forTypeVariable, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                    }
                    throw new IllegalStateException("Unexpected type reference on field: " + typeReference.getSort());
                }
            }

            protected class MethodExtractor extends MethodVisitor implements AnnotationRegistrant {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();
                @MaybeNull
                private AnnotationValue<?, ?> defaultValue;
                private final String descriptor;
                @MaybeNull
                private final String[] exceptionName;
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> exceptionTypeAnnotationTokens = new HashMap();
                @MaybeNull
                private Label firstLabel;
                @MaybeNull
                private final String genericSignature;
                private final String internalName;
                private int invisibleParameterShift;
                private final ParameterBag legacyParameterBag;
                private final int modifiers;
                private final Map<Integer, List<LazyTypeDescription.AnnotationToken>> parameterAnnotationTokens = new HashMap();
                private final List<LazyTypeDescription.MethodToken.ParameterToken> parameterTokens = new ArrayList();
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> parameterTypeAnnotationTokens = new HashMap();
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> receiverTypeAnnotationTokens = new HashMap();
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> returnTypeAnnotationTokens = new HashMap();
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens = new HashMap();
                private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> typeVariableBoundAnnotationTokens = new HashMap();
                private int visibleParameterShift;

                protected MethodExtractor(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                    super(OpenedClassReader.ASM_API);
                    this.modifiers = i10;
                    this.internalName = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.exceptionName = strArr;
                    this.legacyParameterBag = new ParameterBag(Type.getMethodType(str2).getArgumentTypes());
                }

                public void onComplete() {
                }

                public void register(String str, AnnotationValue<?, ?> annotationValue) {
                    this.defaultValue = annotationValue;
                }

                public void visitAnnotableParameterCount(int i10, boolean z10) {
                    if (z10) {
                        this.visibleParameterShift = Type.getMethodType(this.descriptor).getArgumentTypes().length - i10;
                    } else {
                        this.invisibleParameterShift = Type.getMethodType(this.descriptor).getArgumentTypes().length - i10;
                    }
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                public AnnotationVisitor visitAnnotationDefault() {
                    return new AnnotationExtractor(this, new ComponentTypeLocator.ForArrayType(this.descriptor));
                }

                public void visitEnd() {
                    List list;
                    List<LazyTypeDescription.MethodToken.ParameterToken> list2;
                    boolean z10;
                    List access$4200 = TypeExtractor.this.methodTokens;
                    String str = this.internalName;
                    int i10 = this.modifiers;
                    String str2 = this.descriptor;
                    String str3 = this.genericSignature;
                    String[] strArr = this.exceptionName;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map = this.typeVariableAnnotationTokens;
                    Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> map2 = this.typeVariableBoundAnnotationTokens;
                    Map<String, List<LazyTypeDescription.AnnotationToken>> map3 = this.returnTypeAnnotationTokens;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map4 = this.parameterTypeAnnotationTokens;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map5 = this.exceptionTypeAnnotationTokens;
                    Map<String, List<LazyTypeDescription.AnnotationToken>> map6 = this.receiverTypeAnnotationTokens;
                    List<LazyTypeDescription.AnnotationToken> list3 = this.annotationTokens;
                    Map<Integer, List<LazyTypeDescription.AnnotationToken>> map7 = this.parameterAnnotationTokens;
                    if (this.parameterTokens.isEmpty()) {
                        ParameterBag parameterBag = this.legacyParameterBag;
                        list = access$4200;
                        if ((this.modifiers & 8) != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        list2 = parameterBag.resolve(z10);
                    } else {
                        list = access$4200;
                        list2 = this.parameterTokens;
                    }
                    LazyTypeDescription.MethodToken methodToken = r2;
                    LazyTypeDescription.MethodToken methodToken2 = new LazyTypeDescription.MethodToken(str, i10, str2, str3, strArr, map, map2, map3, map4, map5, map6, list3, map7, list2, this.defaultValue);
                    list.add(methodToken);
                }

                public void visitLabel(Label label) {
                    if (Default.this.readerMode.isExtended() && this.firstLabel == null) {
                        this.firstLabel = label;
                    }
                }

                public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i10) {
                    if (Default.this.readerMode.isExtended() && label == this.firstLabel) {
                        this.legacyParameterBag.register(i10, str);
                    }
                }

                public void visitParameter(String str, int i10) {
                    this.parameterTokens.add(new LazyTypeDescription.MethodToken.ParameterToken(str, Integer.valueOf(i10)));
                }

                public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, i10 + (z10 ? this.visibleParameterShift : this.invisibleParameterShift), this.parameterAnnotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
                /* JADX WARNING: Multi-variable type inference failed */
                @net.bytebuddy.utility.nullability.MaybeNull
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public net.bytebuddy.jar.asm.AnnotationVisitor visitTypeAnnotation(int r7, net.bytebuddy.jar.asm.TypePath r8, java.lang.String r9, boolean r10) {
                    /*
                        r6 = this;
                        net.bytebuddy.jar.asm.TypeReference r10 = new net.bytebuddy.jar.asm.TypeReference
                        r10.<init>(r7)
                        int r7 = r10.getSort()
                        r0 = 1
                        if (r7 == r0) goto L_0x0067
                        switch(r7) {
                            case 18: goto L_0x0054;
                            case 19: goto L_0x0052;
                            case 20: goto L_0x004a;
                            case 21: goto L_0x0042;
                            case 22: goto L_0x0036;
                            case 23: goto L_0x002a;
                            default: goto L_0x000f;
                        }
                    L_0x000f:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder
                        r8.<init>()
                        java.lang.String r9 = "Unexpected type reference on method: "
                        r8.append(r9)
                        int r9 = r10.getSort()
                        r8.append(r9)
                        java.lang.String r8 = r8.toString()
                        r7.<init>(r8)
                        throw r7
                    L_0x002a:
                        net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex r7 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex
                        int r10 = r10.getExceptionIndex()
                        java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>> r0 = r6.exceptionTypeAnnotationTokens
                        r7.<init>(r9, r8, r10, r0)
                        goto L_0x0072
                    L_0x0036:
                        net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex r7 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex
                        int r10 = r10.getFormalParameterIndex()
                        java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>> r0 = r6.parameterTypeAnnotationTokens
                        r7.<init>(r9, r8, r10, r0)
                        goto L_0x0072
                    L_0x0042:
                        net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable r7 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable
                        java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>> r10 = r6.receiverTypeAnnotationTokens
                        r7.<init>(r9, r8, r10)
                        goto L_0x0072
                    L_0x004a:
                        net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable r7 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable
                        java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>> r10 = r6.returnTypeAnnotationTokens
                        r7.<init>(r9, r8, r10)
                        goto L_0x0072
                    L_0x0052:
                        r7 = 0
                        return r7
                    L_0x0054:
                        net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed r7 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed
                        int r3 = r10.getTypeParameterBoundIndex()
                        int r4 = r10.getTypeParameterIndex()
                        java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>>> r5 = r6.typeVariableBoundAnnotationTokens
                        r0 = r7
                        r1 = r9
                        r2 = r8
                        r0.<init>(r1, r2, r3, r4, r5)
                        goto L_0x0072
                    L_0x0067:
                        net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex r7 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex
                        int r10 = r10.getTypeParameterIndex()
                        java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>> r0 = r6.typeVariableAnnotationTokens
                        r7.<init>(r9, r8, r10, r0)
                    L_0x0072:
                        net.bytebuddy.pool.TypePool$Default$TypeExtractor$AnnotationExtractor r8 = new net.bytebuddy.pool.TypePool$Default$TypeExtractor$AnnotationExtractor
                        net.bytebuddy.pool.TypePool$Default$TypeExtractor r10 = net.bytebuddy.pool.TypePool.Default.TypeExtractor.this
                        net.bytebuddy.pool.TypePool$Default$ComponentTypeLocator$ForAnnotationProperty r0 = new net.bytebuddy.pool.TypePool$Default$ComponentTypeLocator$ForAnnotationProperty
                        net.bytebuddy.pool.TypePool$Default r1 = net.bytebuddy.pool.TypePool.Default.this
                        r0.<init>(r1, r9)
                        r8.<init>(r7, r0)
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.pool.TypePool.Default.TypeExtractor.MethodExtractor.visitTypeAnnotation(int, net.bytebuddy.jar.asm.TypePath, java.lang.String, boolean):net.bytebuddy.jar.asm.AnnotationVisitor");
                }
            }

            protected class RecordComponentExtractor extends RecordComponentVisitor {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();
                private final String descriptor;
                @MaybeNull
                private final String genericSignature;
                private final String name;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> typeAnnotationTokens = new HashMap();

                protected RecordComponentExtractor(String str, String str2, @MaybeNull String str3) {
                    super(OpenedClassReader.ASM_API);
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                public void visitEnd() {
                    TypeExtractor.this.recordComponentTokens.add(new LazyTypeDescription.RecordComponentToken(this.name, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
                }

                public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
                    TypeReference typeReference = new TypeReference(i10);
                    if (typeReference.getSort() == 19) {
                        AnnotationRegistrant.ForTypeVariable forTypeVariable = new AnnotationRegistrant.ForTypeVariable(str, typePath, this.typeAnnotationTokens);
                        TypeExtractor typeExtractor = TypeExtractor.this;
                        return new AnnotationExtractor(forTypeVariable, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                    }
                    throw new IllegalStateException("Unexpected type reference on record component: " + typeReference.getSort());
                }
            }

            protected TypeExtractor() {
                super(OpenedClassReader.ASM_API);
            }

            /* access modifiers changed from: protected */
            public TypeDescription toTypeDescription() {
                if (this.internalName == null || this.classFileVersion == null) {
                    throw new IllegalStateException("Internal name or class file version were not set");
                }
                Map remove = this.superTypeAnnotationTokens.remove(-1);
                Default defaultR = Default.this;
                int i10 = this.actualModifiers;
                int i11 = this.modifiers;
                String str = this.internalName;
                String str2 = this.superClassName;
                String[] strArr = this.interfaceName;
                String str3 = this.genericSignature;
                LazyTypeDescription.TypeContainment typeContainment2 = this.typeContainment;
                String str4 = this.declaringTypeName;
                List<String> list = this.declaredTypes;
                boolean z10 = this.anonymousType;
                String str5 = this.nestHost;
                List<String> list2 = this.nestMembers;
                if (remove == null) {
                    remove = Collections.emptyMap();
                }
                return new LazyTypeDescription(defaultR, i10, i11, str, str2, strArr, str3, typeContainment2, str4, list, z10, str5, list2, remove, this.superTypeAnnotationTokens, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens, this.annotationTokens, this.fieldTokens, this.methodTokens, this.recordComponentTokens, this.permittedSubclasses, this.classFileVersion);
            }

            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP2"})
            public void visit(int i10, int i11, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                this.modifiers = 65535 & i11;
                this.actualModifiers = i11;
                this.internalName = str;
                this.genericSignature = str2;
                this.superClassName = str3;
                this.interfaceName = strArr;
                this.classFileVersion = ClassFileVersion.ofMinorMajor(i10);
            }

            public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                return new AnnotationExtractor(this, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
            }

            public FieldVisitor visitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                return new FieldExtractor(i10 & 65535, str, str2, str3);
            }

            public void visitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i10) {
                if (str.equals(this.internalName)) {
                    if (str2 != null) {
                        this.declaringTypeName = str2;
                        if (this.typeContainment.isSelfContained()) {
                            this.typeContainment = new LazyTypeDescription.TypeContainment.WithinType(str2, false);
                        }
                    }
                    if (str3 == null && !this.typeContainment.isSelfContained()) {
                        this.anonymousType = true;
                    }
                    this.modifiers = 65535 & i10;
                } else if (str2 != null && str3 != null && str2.equals(this.internalName)) {
                    List<String> list = this.declaredTypes;
                    list.add("L" + str + ";");
                }
            }

            @MaybeNull
            public MethodVisitor visitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                    return Default.IGNORE_METHOD;
                }
                return new MethodExtractor(i10 & 65535, str, str2, str3, strArr);
            }

            public void visitNestHost(String str) {
                this.nestHost = str;
            }

            public void visitNestMember(String str) {
                this.nestMembers.add(str);
            }

            public void visitOuterClass(@MaybeNull String str, @MaybeNull String str2, String str3) {
                if (str2 != null && !str2.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                    this.typeContainment = new LazyTypeDescription.TypeContainment.WithinMethod(str, str2, str3);
                } else if (str != null) {
                    this.typeContainment = new LazyTypeDescription.TypeContainment.WithinType(str, true);
                }
            }

            public void visitPermittedSubclass(String str) {
                this.permittedSubclasses.add(str);
            }

            public RecordComponentVisitor visitRecordComponent(String str, String str2, @MaybeNull String str3) {
                return new RecordComponentExtractor(str, str2, str3);
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.jar.asm.AnnotationVisitor visitTypeAnnotation(int r8, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.jar.asm.TypePath r9, java.lang.String r10, boolean r11) {
                /*
                    r7 = this;
                    net.bytebuddy.jar.asm.TypeReference r11 = new net.bytebuddy.jar.asm.TypeReference
                    r11.<init>(r8)
                    int r8 = r11.getSort()
                    if (r8 == 0) goto L_0x004d
                    r0 = 16
                    if (r8 == r0) goto L_0x0041
                    r0 = 17
                    if (r8 != r0) goto L_0x0026
                    net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed r8 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed
                    int r4 = r11.getTypeParameterBoundIndex()
                    int r5 = r11.getTypeParameterIndex()
                    java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>>> r6 = r7.typeVariableBoundsAnnotationTokens
                    r1 = r8
                    r2 = r10
                    r3 = r9
                    r1.<init>(r2, r3, r4, r5, r6)
                    goto L_0x0058
                L_0x0026:
                    java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    java.lang.String r10 = "Unexpected type reference: "
                    r9.append(r10)
                    int r10 = r11.getSort()
                    r9.append(r10)
                    java.lang.String r9 = r9.toString()
                    r8.<init>(r9)
                    throw r8
                L_0x0041:
                    net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex r8 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex
                    int r11 = r11.getSuperTypeIndex()
                    java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>> r0 = r7.superTypeAnnotationTokens
                    r8.<init>(r10, r9, r11, r0)
                    goto L_0x0058
                L_0x004d:
                    net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex r8 = new net.bytebuddy.pool.TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex
                    int r11 = r11.getTypeParameterIndex()
                    java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$AnnotationToken>>> r0 = r7.typeVariableAnnotationTokens
                    r8.<init>(r10, r9, r11, r0)
                L_0x0058:
                    net.bytebuddy.pool.TypePool$Default$TypeExtractor$AnnotationExtractor r9 = new net.bytebuddy.pool.TypePool$Default$TypeExtractor$AnnotationExtractor
                    net.bytebuddy.pool.TypePool$Default$ComponentTypeLocator$ForAnnotationProperty r11 = new net.bytebuddy.pool.TypePool$Default$ComponentTypeLocator$ForAnnotationProperty
                    net.bytebuddy.pool.TypePool$Default r0 = net.bytebuddy.pool.TypePool.Default.this
                    r11.<init>(r0, r10)
                    r9.<init>(r8, r11)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.pool.TypePool.Default.TypeExtractor.visitTypeAnnotation(int, net.bytebuddy.jar.asm.TypePath, java.lang.String, boolean):net.bytebuddy.jar.asm.AnnotationVisitor");
            }
        }

        public static class WithLazyResolution extends Default {

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class LazyResolution implements Resolution {
                private final String name;

                protected LazyResolution(String str) {
                    this.name = str;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    LazyResolution lazyResolution = (LazyResolution) obj;
                    return this.name.equals(lazyResolution.name) && WithLazyResolution.this.equals(WithLazyResolution.this);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + WithLazyResolution.this.hashCode();
                }

                public boolean isResolved() {
                    return WithLazyResolution.this.doResolve(this.name).isResolved();
                }

                public TypeDescription resolve() {
                    return new LazyTypeDescription(this.name);
                }
            }

            protected class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
                private transient /* synthetic */ TypeDescription delegate;
                private final String name;

                protected LazyTypeDescription(String str) {
                    this.name = str;
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("delegate")
                public TypeDescription delegate() {
                    TypeDescription resolve = this.delegate != null ? null : WithLazyResolution.this.doResolve(this.name).resolve();
                    if (resolve == null) {
                        return this.delegate;
                    }
                    this.delegate = resolve;
                    return resolve;
                }

                public String getName() {
                    return this.name;
                }
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode) {
                this(cacheProvider, classFileLocator, readerMode, Empty.INSTANCE);
            }

            public static TypePool of(@MaybeNull ClassLoader classLoader) {
                return of(ClassFileLocator.ForClassLoader.of(classLoader));
            }

            public static TypePool ofBootLoader() {
                return of(ClassFileLocator.ForClassLoader.ofBootLoader());
            }

            public static TypePool ofPlatformLoader() {
                return of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
            }

            public static TypePool ofSystemLoader() {
                return of(ClassFileLocator.ForClassLoader.ofSystemLoader());
            }

            /* access modifiers changed from: protected */
            public Resolution doCache(String str, Resolution resolution) {
                return resolution;
            }

            /* access modifiers changed from: protected */
            public Resolution doDescribe(String str) {
                return new LazyResolution(str);
            }

            /* access modifiers changed from: protected */
            public Resolution doResolve(String str) {
                Resolution find = this.cacheProvider.find(str);
                if (find == null) {
                    return this.cacheProvider.register(str, super.doDescribe(str));
                }
                return find;
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, TypePool typePool) {
                super(cacheProvider, classFileLocator, readerMode, typePool);
            }

            public static TypePool of(ClassFileLocator classFileLocator) {
                return new WithLazyResolution(new CacheProvider.Simple(), classFileLocator, ReaderMode.FAST);
            }
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator2, ReaderMode readerMode2) {
            this(cacheProvider, classFileLocator2, readerMode2, Empty.INSTANCE);
        }

        public static TypePool of(@MaybeNull ClassLoader classLoader) {
            return of(ClassFileLocator.ForClassLoader.of(classLoader));
        }

        public static TypePool ofBootLoader() {
            return of(ClassFileLocator.ForClassLoader.ofBootLoader());
        }

        public static TypePool ofPlatformLoader() {
            return of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
        }

        public static TypePool ofSystemLoader() {
            return of(ClassFileLocator.ForClassLoader.ofSystemLoader());
        }

        private TypeDescription parse(byte[] bArr) {
            ClassReader of2 = OpenedClassReader.of(bArr);
            TypeExtractor typeExtractor = new TypeExtractor();
            of2.accept(typeExtractor, this.readerMode.getFlags());
            return typeExtractor.toTypeDescription();
        }

        /* access modifiers changed from: protected */
        public Resolution doDescribe(String str) {
            try {
                ClassFileLocator.Resolution locate = this.classFileLocator.locate(str);
                if (locate.isResolved()) {
                    return new Resolution.Simple(parse(locate.resolve()));
                }
                return new Resolution.Illegal(str);
            } catch (IOException e10) {
                throw new IllegalStateException("Error while reading class file", e10);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.readerMode.equals(defaultR.readerMode) && this.classFileLocator.equals(defaultR.classFileLocator);
        }

        public int hashCode() {
            return (((super.hashCode() * 31) + this.classFileLocator.hashCode()) * 31) + this.readerMode.hashCode();
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator2, ReaderMode readerMode2, TypePool typePool) {
            super(cacheProvider, typePool);
            this.classFileLocator = classFileLocator2;
            this.readerMode = readerMode2;
        }

        public static TypePool of(ClassFileLocator classFileLocator2) {
            return new Default(new CacheProvider.Simple(), classFileLocator2, ReaderMode.FAST);
        }
    }

    public enum Empty implements TypePool {
        INSTANCE;

        public void clear() {
        }

        public Resolution describe(String str) {
            return new Resolution.Illegal(str);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit extends AbstractBase.Hierarchical {
        private final Map<String, TypeDescription> types;

        public Explicit(Map<String, TypeDescription> map) {
            this(Empty.INSTANCE, map);
        }

        public static TypePool wrap(TypeDescription typeDescription, List<? extends DynamicType> list, TypePool typePool) {
            HashMap hashMap = new HashMap();
            hashMap.put(typeDescription.getName(), typeDescription);
            for (DynamicType allTypes : list) {
                for (TypeDescription next : allTypes.getAllTypes().keySet()) {
                    hashMap.put(next.getName(), next);
                }
            }
            return new Explicit(typePool, hashMap);
        }

        /* access modifiers changed from: protected */
        public Resolution doDescribe(String str) {
            TypeDescription typeDescription = this.types.get(str);
            if (typeDescription == null) {
                return new Resolution.Illegal(str);
            }
            return new Resolution.Simple(typeDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.types.equals(((Explicit) obj).types);
        }

        public int hashCode() {
            return (super.hashCode() * 31) + this.types.hashCode();
        }

        public Explicit(TypePool typePool, Map<String, TypeDescription> map) {
            super(CacheProvider.NoOp.INSTANCE, typePool);
            this.types = map;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class LazyFacade extends AbstractBase {
        private final TypePool typePool;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class LazyResolution implements Resolution {
            private final String name;
            private final TypePool typePool;

            protected LazyResolution(TypePool typePool2, String str) {
                this.typePool = typePool2;
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                LazyResolution lazyResolution = (LazyResolution) obj;
                return this.name.equals(lazyResolution.name) && this.typePool.equals(lazyResolution.typePool);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typePool.hashCode()) * 31) + this.name.hashCode();
            }

            public boolean isResolved() {
                return this.typePool.describe(this.name).isResolved();
            }

            public TypeDescription resolve() {
                return new LazyTypeDescription(this.typePool, this.name);
            }
        }

        protected static class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
            private transient /* synthetic */ TypeDescription delegate;
            private final String name;
            private final TypePool typePool;

            protected LazyTypeDescription(TypePool typePool2, String str) {
                this.typePool = typePool2;
                this.name = str;
            }

            /* access modifiers changed from: protected */
            @CachedReturnPlugin.Enhance("delegate")
            public TypeDescription delegate() {
                TypeDescription resolve = this.delegate != null ? null : this.typePool.describe(this.name).resolve();
                if (resolve == null) {
                    return this.delegate;
                }
                this.delegate = resolve;
                return resolve;
            }

            public String getName() {
                return this.name;
            }
        }

        public LazyFacade(TypePool typePool2) {
            super(CacheProvider.NoOp.INSTANCE);
            this.typePool = typePool2;
        }

        public void clear() {
            this.typePool.clear();
        }

        /* access modifiers changed from: protected */
        public Resolution doDescribe(String str) {
            return new LazyResolution(this.typePool, str);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typePool.equals(((LazyFacade) obj).typePool);
        }

        public int hashCode() {
            return (super.hashCode() * 31) + this.typePool.hashCode();
        }
    }

    public interface Resolution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Illegal implements Resolution {
            private final String name;

            public Illegal(String str) {
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((Illegal) obj).name);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.name.hashCode();
            }

            public boolean isResolved() {
                return false;
            }

            public TypeDescription resolve() {
                throw new NoSuchTypeException(this.name);
            }
        }

        public static class NoSuchTypeException extends IllegalStateException {
            private static final long serialVersionUID = 1;
            private final String name;

            public NoSuchTypeException(String str) {
                super("Cannot resolve type description for " + str);
                this.name = str;
            }

            public String getName() {
                return this.name;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Resolution {
            private final TypeDescription typeDescription;

            public Simple(TypeDescription typeDescription2) {
                this.typeDescription = typeDescription2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Simple) obj).typeDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
            }

            public boolean isResolved() {
                return true;
            }

            public TypeDescription resolve() {
                return this.typeDescription;
            }
        }

        boolean isResolved();

        TypeDescription resolve();
    }

    void clear();

    Resolution describe(String str);
}
