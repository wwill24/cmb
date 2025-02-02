package net.bytebuddy.dynamic.scaffold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface MethodRegistry {

    public interface Compiled extends TypeWriter.MethodPool {
        MethodList<?> getInstrumentedMethods();

        TypeDescription getInstrumentedType();

        LoadedTypeInitializer getLoadedTypeInitializer();

        MethodList<?> getMethods();

        TypeInitializer getTypeInitializer();
    }

    public interface Handler extends InstrumentedType.Prepareable {

        public interface Compiled {
            TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility);
        }

        public enum ForAbstractMethod implements Handler, Compiled {
            INSTANCE;

            public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithoutBody(methodDescription, methodAttributeAppender, visibility);
            }

            public Compiled compile(Implementation.Target target) {
                return this;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAnnotationValue implements Handler, Compiled {
            private final AnnotationValue<?, ?> annotationValue;

            public ForAnnotationValue(AnnotationValue<?, ?> annotationValue2) {
                this.annotationValue = annotationValue2;
            }

            public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue(methodDescription, this.annotationValue, methodAttributeAppender);
            }

            public Compiled compile(Implementation.Target target) {
                return this;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.annotationValue.equals(((ForAnnotationValue) obj).annotationValue);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.annotationValue.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForImplementation implements Handler {
            private final Implementation implementation;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Compiled implements Compiled {
                private final ByteCodeAppender byteCodeAppender;

                protected Compiled(ByteCodeAppender byteCodeAppender2) {
                    this.byteCodeAppender = byteCodeAppender2;
                }

                public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                    return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithBody(methodDescription, this.byteCodeAppender, methodAttributeAppender, visibility);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Compiled) obj).byteCodeAppender);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.byteCodeAppender.hashCode();
                }
            }

            public ForImplementation(Implementation implementation2) {
                this.implementation = implementation2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.implementation.equals(((ForImplementation) obj).implementation);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.implementation.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return this.implementation.prepare(instrumentedType);
            }

            public Compiled compile(Implementation.Target target) {
                return new Compiled(this.implementation.appender(target));
            }
        }

        public enum ForVisibilityBridge implements Handler {
            INSTANCE;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Compiled implements Compiled {
                private final TypeDescription instrumentedType;

                protected Compiled(TypeDescription typeDescription) {
                    this.instrumentedType = typeDescription;
                }

                public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                    return TypeWriter.MethodPool.Record.ForDefinedMethod.OfVisibilityBridge.of(this.instrumentedType, methodDescription, methodAttributeAppender);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Compiled) obj).instrumentedType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
                }
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                throw new IllegalStateException("A visibility bridge handler must not apply any preparations");
            }

            public Compiled compile(Implementation.Target target) {
                return new Compiled(target.getInstrumentedType());
            }
        }

        Compiled compile(Implementation.Target target);
    }

    public interface Prepared {
        Compiled compile(Implementation.Target.Factory factory, ClassFileVersion classFileVersion);

        MethodList<?> getInstrumentedMethods();

        TypeDescription getInstrumentedType();

        LoadedTypeInitializer getLoadedTypeInitializer();

        MethodList<?> getMethods();

        TypeInitializer getTypeInitializer();
    }

    MethodRegistry append(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer);

    Prepared prepare(InstrumentedType instrumentedType, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, LatentMatcher<? super MethodDescription> latentMatcher);

    MethodRegistry prepend(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer);

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements MethodRegistry {
        private final List<Entry> entries;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Compiled implements Compiled {
            private final LinkedHashMap<MethodDescription, Entry> implementations;
            private final TypeDescription instrumentedType;
            private final LoadedTypeInitializer loadedTypeInitializer;
            private final MethodList<?> methods;
            private final boolean supportsBridges;
            private final TypeInitializer typeInitializer;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Entry {
                private final MethodAttributeAppender attributeAppender;
                private final boolean bridgeMethod;
                private final Set<MethodDescription.TypeToken> bridgeTypes;
                private final Handler.Compiled handler;
                private final MethodDescription methodDescription;
                private final Visibility visibility;

                protected Entry(Handler.Compiled compiled, MethodAttributeAppender methodAttributeAppender, MethodDescription methodDescription2, Set<MethodDescription.TypeToken> set, Visibility visibility2, boolean z10) {
                    this.handler = compiled;
                    this.attributeAppender = methodAttributeAppender;
                    this.methodDescription = methodDescription2;
                    this.bridgeTypes = set;
                    this.visibility = visibility2;
                    this.bridgeMethod = z10;
                }

                /* access modifiers changed from: protected */
                public TypeWriter.MethodPool.Record bind(TypeDescription typeDescription, boolean z10) {
                    if (this.bridgeMethod && !z10) {
                        return new TypeWriter.MethodPool.Record.ForNonImplementedMethod(this.methodDescription);
                    }
                    TypeWriter.MethodPool.Record assemble = this.handler.assemble(this.methodDescription, this.attributeAppender, this.visibility);
                    if (z10) {
                        return TypeWriter.MethodPool.Record.AccessBridgeWrapper.of(assemble, typeDescription, this.methodDescription, this.bridgeTypes, this.attributeAppender);
                    }
                    return assemble;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Entry entry = (Entry) obj;
                    return this.bridgeMethod == entry.bridgeMethod && this.visibility.equals(entry.visibility) && this.handler.equals(entry.handler) && this.attributeAppender.equals(entry.attributeAppender) && this.methodDescription.equals(entry.methodDescription) && this.bridgeTypes.equals(entry.bridgeTypes);
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.handler.hashCode()) * 31) + this.attributeAppender.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.bridgeTypes.hashCode()) * 31) + this.visibility.hashCode()) * 31) + (this.bridgeMethod ? 1 : 0);
                }
            }

            protected Compiled(TypeDescription typeDescription, LoadedTypeInitializer loadedTypeInitializer2, TypeInitializer typeInitializer2, MethodList<?> methodList, LinkedHashMap<MethodDescription, Entry> linkedHashMap, boolean z10) {
                this.instrumentedType = typeDescription;
                this.loadedTypeInitializer = loadedTypeInitializer2;
                this.typeInitializer = typeInitializer2;
                this.methods = methodList;
                this.implementations = linkedHashMap;
                this.supportsBridges = z10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Compiled compiled = (Compiled) obj;
                return this.supportsBridges == compiled.supportsBridges && this.instrumentedType.equals(compiled.instrumentedType) && this.loadedTypeInitializer.equals(compiled.loadedTypeInitializer) && this.typeInitializer.equals(compiled.typeInitializer) && this.methods.equals(compiled.methods) && this.implementations.equals(compiled.implementations);
            }

            public MethodList<?> getInstrumentedMethods() {
                return (MethodList) new MethodList.Explicit(new ArrayList(this.implementations.keySet())).filter(ElementMatchers.not(ElementMatchers.isTypeInitializer()));
            }

            public TypeDescription getInstrumentedType() {
                return this.instrumentedType;
            }

            public LoadedTypeInitializer getLoadedTypeInitializer() {
                return this.loadedTypeInitializer;
            }

            public MethodList<?> getMethods() {
                return this.methods;
            }

            public TypeInitializer getTypeInitializer() {
                return this.typeInitializer;
            }

            public int hashCode() {
                return (((((((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.loadedTypeInitializer.hashCode()) * 31) + this.typeInitializer.hashCode()) * 31) + this.methods.hashCode()) * 31) + this.implementations.hashCode()) * 31) + (this.supportsBridges ? 1 : 0);
            }

            public TypeWriter.MethodPool.Record target(MethodDescription methodDescription) {
                Entry entry = this.implementations.get(methodDescription);
                if (entry == null) {
                    return new TypeWriter.MethodPool.Record.ForNonImplementedMethod(methodDescription);
                }
                return entry.bind(this.instrumentedType, this.supportsBridges);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Entry implements LatentMatcher<MethodDescription> {
            private final MethodAttributeAppender.Factory attributeAppenderFactory;
            private final Handler handler;
            private final LatentMatcher<? super MethodDescription> matcher;
            private final Transformer<MethodDescription> transformer;

            protected Entry(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler2, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer2) {
                this.matcher = latentMatcher;
                this.handler = handler2;
                this.attributeAppenderFactory = factory;
                this.transformer = transformer2;
            }

            /* access modifiers changed from: protected */
            public Prepared.Entry asPreparedEntry(TypeDescription typeDescription, MethodDescription methodDescription, Visibility visibility) {
                return asPreparedEntry(typeDescription, methodDescription, Collections.emptySet(), visibility);
            }

            /* access modifiers changed from: protected */
            public Prepared.Entry asSupplementaryEntry(MethodDescription methodDescription) {
                return new Prepared.Entry(this.handler, MethodAttributeAppender.Explicit.of(methodDescription), methodDescription, Collections.emptySet(), methodDescription.getVisibility(), false);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.handler.equals(entry.handler) && this.attributeAppenderFactory.equals(entry.attributeAppenderFactory) && this.transformer.equals(entry.transformer);
            }

            /* access modifiers changed from: protected */
            public Handler getHandler() {
                return this.handler;
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.handler.hashCode()) * 31) + this.attributeAppenderFactory.hashCode()) * 31) + this.transformer.hashCode();
            }

            public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
                return this.matcher.resolve(typeDescription);
            }

            /* access modifiers changed from: protected */
            public Prepared.Entry asPreparedEntry(TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, Visibility visibility) {
                return new Prepared.Entry(this.handler, this.attributeAppenderFactory, this.transformer.transform(typeDescription, methodDescription), set, visibility, false);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Prepared implements Prepared {
            private final LinkedHashMap<MethodDescription, Entry> implementations;
            private final TypeDescription instrumentedType;
            private final LoadedTypeInitializer loadedTypeInitializer;
            private final MethodGraph.Linked methodGraph;
            private final MethodList<?> methods;
            private final TypeInitializer typeInitializer;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Entry {
                private final MethodAttributeAppender.Factory attributeAppenderFactory;
                private final boolean bridgeMethod;
                private final Handler handler;
                private final MethodDescription methodDescription;
                private final Set<MethodDescription.TypeToken> typeTokens;
                private final Visibility visibility;

                protected Entry(Handler handler2, MethodAttributeAppender.Factory factory, MethodDescription methodDescription2, Set<MethodDescription.TypeToken> set, Visibility visibility2, boolean z10) {
                    this.handler = handler2;
                    this.attributeAppenderFactory = factory;
                    this.methodDescription = methodDescription2;
                    this.typeTokens = set;
                    this.visibility = visibility2;
                    this.bridgeMethod = z10;
                }

                protected static Entry forVisibilityBridge(MethodDescription methodDescription2, Visibility visibility2) {
                    return new Entry(Handler.ForVisibilityBridge.INSTANCE, MethodAttributeAppender.Explicit.of(methodDescription2), methodDescription2, Collections.emptySet(), visibility2, true);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Entry entry = (Entry) obj;
                    return this.bridgeMethod == entry.bridgeMethod && this.visibility.equals(entry.visibility) && this.handler.equals(entry.handler) && this.attributeAppenderFactory.equals(entry.attributeAppenderFactory) && this.methodDescription.equals(entry.methodDescription) && this.typeTokens.equals(entry.typeTokens);
                }

                /* access modifiers changed from: protected */
                public MethodAttributeAppender.Factory getAppenderFactory() {
                    return this.attributeAppenderFactory;
                }

                /* access modifiers changed from: protected */
                public Handler getHandler() {
                    return this.handler;
                }

                /* access modifiers changed from: protected */
                public MethodDescription getMethodDescription() {
                    return this.methodDescription;
                }

                /* access modifiers changed from: protected */
                public Visibility getVisibility() {
                    return this.visibility;
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.handler.hashCode()) * 31) + this.attributeAppenderFactory.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.typeTokens.hashCode()) * 31) + this.visibility.hashCode()) * 31) + (this.bridgeMethod ? 1 : 0);
                }

                /* access modifiers changed from: protected */
                public boolean isBridgeMethod() {
                    return this.bridgeMethod;
                }

                /* access modifiers changed from: protected */
                public Set<MethodDescription.TypeToken> resolveBridgeTypes() {
                    HashSet hashSet = new HashSet(this.typeTokens);
                    hashSet.remove(this.methodDescription.asTypeToken());
                    return hashSet;
                }
            }

            protected Prepared(LinkedHashMap<MethodDescription, Entry> linkedHashMap, LoadedTypeInitializer loadedTypeInitializer2, TypeInitializer typeInitializer2, TypeDescription typeDescription, MethodGraph.Linked linked, MethodList<?> methodList) {
                this.implementations = linkedHashMap;
                this.loadedTypeInitializer = loadedTypeInitializer2;
                this.typeInitializer = typeInitializer2;
                this.instrumentedType = typeDescription;
                this.methodGraph = linked;
                this.methods = methodList;
            }

            public Compiled compile(Implementation.Target.Factory factory, ClassFileVersion classFileVersion) {
                ClassFileVersion classFileVersion2 = classFileVersion;
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Implementation.Target make = factory.make(this.instrumentedType, this.methodGraph, classFileVersion2);
                for (Map.Entry next : this.implementations.entrySet()) {
                    Handler.Compiled compiled = (Handler.Compiled) hashMap.get(((Entry) next.getValue()).getHandler());
                    if (compiled == null) {
                        compiled = ((Entry) next.getValue()).getHandler().compile(make);
                        hashMap.put(((Entry) next.getValue()).getHandler(), compiled);
                    }
                    Handler.Compiled compiled2 = compiled;
                    MethodAttributeAppender methodAttributeAppender = (MethodAttributeAppender) hashMap2.get(((Entry) next.getValue()).getAppenderFactory());
                    if (methodAttributeAppender == null) {
                        methodAttributeAppender = ((Entry) next.getValue()).getAppenderFactory().make(this.instrumentedType);
                        hashMap2.put(((Entry) next.getValue()).getAppenderFactory(), methodAttributeAppender);
                    }
                    linkedHashMap.put(next.getKey(), new Compiled.Entry(compiled2, methodAttributeAppender, ((Entry) next.getValue()).getMethodDescription(), ((Entry) next.getValue()).resolveBridgeTypes(), ((Entry) next.getValue()).getVisibility(), ((Entry) next.getValue()).isBridgeMethod()));
                }
                return new Compiled(this.instrumentedType, this.loadedTypeInitializer, this.typeInitializer, this.methods, linkedHashMap, classFileVersion2.isAtLeast(ClassFileVersion.JAVA_V5));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Prepared prepared = (Prepared) obj;
                return this.implementations.equals(prepared.implementations) && this.loadedTypeInitializer.equals(prepared.loadedTypeInitializer) && this.typeInitializer.equals(prepared.typeInitializer) && this.instrumentedType.equals(prepared.instrumentedType) && this.methodGraph.equals(prepared.methodGraph) && this.methods.equals(prepared.methods);
            }

            public MethodList<?> getInstrumentedMethods() {
                return (MethodList) new MethodList.Explicit(new ArrayList(this.implementations.keySet())).filter(ElementMatchers.not(ElementMatchers.isTypeInitializer()));
            }

            public TypeDescription getInstrumentedType() {
                return this.instrumentedType;
            }

            public LoadedTypeInitializer getLoadedTypeInitializer() {
                return this.loadedTypeInitializer;
            }

            public MethodList<?> getMethods() {
                return this.methods;
            }

            public TypeInitializer getTypeInitializer() {
                return this.typeInitializer;
            }

            public int hashCode() {
                return (((((((((((getClass().hashCode() * 31) + this.implementations.hashCode()) * 31) + this.loadedTypeInitializer.hashCode()) * 31) + this.typeInitializer.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + this.methodGraph.hashCode()) * 31) + this.methods.hashCode();
            }
        }

        public Default() {
            this.entries = Collections.emptyList();
        }

        public MethodRegistry append(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
            return new Default(CompoundList.of(this.entries, new Entry(latentMatcher, handler, factory, transformer)));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.entries.equals(((Default) obj).entries);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.entries.hashCode();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0019, code lost:
            r11 = r11;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared prepare(net.bytebuddy.dynamic.scaffold.InstrumentedType r11, net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler r12, net.bytebuddy.dynamic.scaffold.TypeValidation r13, net.bytebuddy.dynamic.VisibilityBridgeStrategy r14, net.bytebuddy.matcher.LatentMatcher<? super net.bytebuddy.description.method.MethodDescription> r15) {
            /*
                r10 = this;
                java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
                r1.<init>()
                java.util.HashSet r0 = new java.util.HashSet
                r0.<init>()
                java.util.HashSet r2 = new java.util.HashSet
                net.bytebuddy.description.method.MethodList r3 = r11.getDeclaredMethods()
                r2.<init>(r3)
                java.util.List<net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Entry> r3 = r10.entries
                java.util.Iterator r3 = r3.iterator()
            L_0x0019:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0060
                java.lang.Object r4 = r3.next()
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Entry r4 = (net.bytebuddy.dynamic.scaffold.MethodRegistry.Default.Entry) r4
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Handler r5 = r4.getHandler()
                boolean r5 = r0.add(r5)
                if (r5 == 0) goto L_0x0019
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Handler r5 = r4.getHandler()
                net.bytebuddy.dynamic.scaffold.InstrumentedType r5 = r5.prepare(r11)
                if (r11 == r5) goto L_0x0019
                net.bytebuddy.description.method.MethodList r11 = r5.getDeclaredMethods()
                java.util.Iterator r11 = r11.iterator()
            L_0x0041:
                boolean r6 = r11.hasNext()
                if (r6 == 0) goto L_0x005e
                java.lang.Object r6 = r11.next()
                net.bytebuddy.description.method.MethodDescription r6 = (net.bytebuddy.description.method.MethodDescription) r6
                boolean r7 = r2.contains(r6)
                if (r7 != 0) goto L_0x0041
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Prepared$Entry r7 = r4.asSupplementaryEntry(r6)
                r1.put(r6, r7)
                r2.add(r6)
                goto L_0x0041
            L_0x005e:
                r11 = r5
                goto L_0x0019
            L_0x0060:
                net.bytebuddy.dynamic.scaffold.MethodGraph$Linked r5 = r12.compile((net.bytebuddy.description.type.TypeDefinition) r11)
                java.util.Set r12 = r1.keySet()
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = net.bytebuddy.matcher.ElementMatchers.anyOf((java.lang.Iterable<?>) r12)
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = net.bytebuddy.matcher.ElementMatchers.not(r12)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.isVisibleTo((net.bytebuddy.description.type.TypeDescription) r11)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.returns((net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.type.TypeDescription>) r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = r12.and(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.isVisibleTo((net.bytebuddy.description.type.TypeDescription) r11)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.not(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.hasType(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.whereNone(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.hasParameters(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = r12.and(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = net.bytebuddy.matcher.ElementMatchers.failSafe(r12)
                net.bytebuddy.matcher.ElementMatcher r15 = r15.resolve(r11)
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = r12.and(r15)
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                net.bytebuddy.dynamic.scaffold.MethodGraph$NodeList r0 = r5.listNodes()
                java.util.Iterator r0 = r0.iterator()
            L_0x00ad:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x013e
                java.lang.Object r2 = r0.next()
                net.bytebuddy.dynamic.scaffold.MethodGraph$Node r2 = (net.bytebuddy.dynamic.scaffold.MethodGraph.Node) r2
                net.bytebuddy.description.method.MethodDescription r3 = r2.getRepresentative()
                boolean r4 = r11.isPublic()
                r6 = 0
                if (r4 == 0) goto L_0x00cc
                boolean r4 = r11.isInterface()
                if (r4 != 0) goto L_0x00cc
                r4 = 1
                goto L_0x00cd
            L_0x00cc:
                r4 = r6
            L_0x00cd:
                boolean r7 = r12.matches(r3)
                if (r7 == 0) goto L_0x00ff
                java.util.List<net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Entry> r7 = r10.entries
                java.util.Iterator r7 = r7.iterator()
            L_0x00d9:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x00ff
                java.lang.Object r8 = r7.next()
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Entry r8 = (net.bytebuddy.dynamic.scaffold.MethodRegistry.Default.Entry) r8
                net.bytebuddy.matcher.ElementMatcher r9 = r8.resolve(r11)
                boolean r9 = r9.matches(r3)
                if (r9 == 0) goto L_0x00d9
                java.util.Set r4 = r2.getMethodTypes()
                net.bytebuddy.description.modifier.Visibility r7 = r2.getVisibility()
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Prepared$Entry r4 = r8.asPreparedEntry(r11, r3, r4, r7)
                r1.put(r3, r4)
                goto L_0x0100
            L_0x00ff:
                r6 = r4
            L_0x0100:
                if (r6 == 0) goto L_0x0139
                net.bytebuddy.dynamic.scaffold.MethodGraph$Node$Sort r4 = r2.getSort()
                boolean r4 = r4.isMadeVisible()
                if (r4 != 0) goto L_0x0139
                boolean r4 = r3.isPublic()
                if (r4 == 0) goto L_0x0139
                boolean r4 = r3.isAbstract()
                if (r4 != 0) goto L_0x0139
                boolean r4 = r3.isFinal()
                if (r4 != 0) goto L_0x0139
                net.bytebuddy.description.type.TypeDefinition r4 = r3.getDeclaringType()
                boolean r4 = r4.isPackagePrivate()
                if (r4 == 0) goto L_0x0139
                boolean r4 = r14.generateVisibilityBridge(r3)
                if (r4 == 0) goto L_0x0139
                net.bytebuddy.description.modifier.Visibility r2 = r2.getVisibility()
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Prepared$Entry r2 = net.bytebuddy.dynamic.scaffold.MethodRegistry.Default.Prepared.Entry.forVisibilityBridge(r3, r2)
                r1.put(r3, r2)
            L_0x0139:
                r15.add(r3)
                goto L_0x00ad
            L_0x013e:
                net.bytebuddy.description.method.MethodList r14 = r11.getDeclaredMethods()
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.isVirtual()
                net.bytebuddy.matcher.ElementMatcher$Junction r0 = net.bytebuddy.matcher.ElementMatchers.not(r0)
                net.bytebuddy.matcher.ElementMatcher$Junction r12 = r0.and(r12)
                net.bytebuddy.matcher.FilterableList r12 = r14.filter(r12)
                net.bytebuddy.description.method.MethodDescription$Latent$TypeInitializer r14 = new net.bytebuddy.description.method.MethodDescription$Latent$TypeInitializer
                r14.<init>(r11)
                java.util.List r12 = net.bytebuddy.utility.CompoundList.of(r12, r14)
                java.util.Iterator r12 = r12.iterator()
            L_0x015f:
                boolean r14 = r12.hasNext()
                if (r14 == 0) goto L_0x0196
                java.lang.Object r14 = r12.next()
                net.bytebuddy.description.method.MethodDescription r14 = (net.bytebuddy.description.method.MethodDescription) r14
                java.util.List<net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Entry> r0 = r10.entries
                java.util.Iterator r0 = r0.iterator()
            L_0x0171:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0192
                java.lang.Object r2 = r0.next()
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Entry r2 = (net.bytebuddy.dynamic.scaffold.MethodRegistry.Default.Entry) r2
                net.bytebuddy.matcher.ElementMatcher r3 = r2.resolve(r11)
                boolean r3 = r3.matches(r14)
                if (r3 == 0) goto L_0x0171
                net.bytebuddy.description.modifier.Visibility r0 = r14.getVisibility()
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Prepared$Entry r0 = r2.asPreparedEntry(r11, r14, r0)
                r1.put(r14, r0)
            L_0x0192:
                r15.add(r14)
                goto L_0x015f
            L_0x0196:
                net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Prepared r12 = new net.bytebuddy.dynamic.scaffold.MethodRegistry$Default$Prepared
                net.bytebuddy.implementation.LoadedTypeInitializer r2 = r11.getLoadedTypeInitializer()
                net.bytebuddy.dynamic.scaffold.TypeInitializer r3 = r11.getTypeInitializer()
                boolean r13 = r13.isEnabled()
                if (r13 == 0) goto L_0x01aa
                net.bytebuddy.description.type.TypeDescription r11 = r11.validated()
            L_0x01aa:
                r4 = r11
                net.bytebuddy.description.method.MethodList$Explicit r6 = new net.bytebuddy.description.method.MethodList$Explicit
                r6.<init>(r15)
                r0 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.MethodRegistry.Default.prepare(net.bytebuddy.dynamic.scaffold.InstrumentedType, net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler, net.bytebuddy.dynamic.scaffold.TypeValidation, net.bytebuddy.dynamic.VisibilityBridgeStrategy, net.bytebuddy.matcher.LatentMatcher):net.bytebuddy.dynamic.scaffold.MethodRegistry$Prepared");
        }

        public MethodRegistry prepend(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
            return new Default(CompoundList.of(new Entry(latentMatcher, handler, factory, transformer), this.entries));
        }

        private Default(List<Entry> list) {
            this.entries = list;
        }
    }
}
