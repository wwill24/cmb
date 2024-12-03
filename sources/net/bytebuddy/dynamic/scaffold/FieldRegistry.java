package net.bytebuddy.dynamic.scaffold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface FieldRegistry {

    public interface Compiled extends TypeWriter.FieldPool {

        public enum NoOp implements Compiled {
            INSTANCE;

            public TypeWriter.FieldPool.Record target(FieldDescription fieldDescription) {
                return new TypeWriter.FieldPool.Record.ForImplicitField(fieldDescription);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements FieldRegistry {
        private final List<Entry> entries;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Compiled implements Compiled {
            private final List<Entry> entries;
            private final TypeDescription instrumentedType;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Entry implements ElementMatcher<FieldDescription> {
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final Object defaultValue;
                private final FieldAttributeAppender fieldAttributeAppender;
                private final ElementMatcher<? super FieldDescription> matcher;
                private final Transformer<FieldDescription> transformer;

                protected Entry(ElementMatcher<? super FieldDescription> elementMatcher, FieldAttributeAppender fieldAttributeAppender2, @MaybeNull Object obj, Transformer<FieldDescription> transformer2) {
                    this.matcher = elementMatcher;
                    this.fieldAttributeAppender = fieldAttributeAppender2;
                    this.defaultValue = obj;
                    this.transformer = transformer2;
                }

                /* access modifiers changed from: protected */
                public TypeWriter.FieldPool.Record bind(TypeDescription typeDescription, FieldDescription fieldDescription) {
                    return new TypeWriter.FieldPool.Record.ForExplicitField(this.fieldAttributeAppender, this.defaultValue, this.transformer.transform(typeDescription, fieldDescription));
                }

                /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
                    if (r2 != null) goto L_0x003c;
                 */
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
                        net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.field.FieldDescription> r2 = r4.matcher
                        net.bytebuddy.dynamic.scaffold.FieldRegistry$Default$Compiled$Entry r5 = (net.bytebuddy.dynamic.scaffold.FieldRegistry.Default.Compiled.Entry) r5
                        net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.field.FieldDescription> r3 = r5.matcher
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0020
                        return r1
                    L_0x0020:
                        net.bytebuddy.implementation.attribute.FieldAttributeAppender r2 = r4.fieldAttributeAppender
                        net.bytebuddy.implementation.attribute.FieldAttributeAppender r3 = r5.fieldAttributeAppender
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x002b
                        return r1
                    L_0x002b:
                        java.lang.Object r2 = r4.defaultValue
                        java.lang.Object r3 = r5.defaultValue
                        if (r3 == 0) goto L_0x003a
                        if (r2 == 0) goto L_0x003c
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x003d
                        return r1
                    L_0x003a:
                        if (r2 == 0) goto L_0x003d
                    L_0x003c:
                        return r1
                    L_0x003d:
                        net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r2 = r4.transformer
                        net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r5 = r5.transformer
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x0048
                        return r1
                    L_0x0048:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.FieldRegistry.Default.Compiled.Entry.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int hashCode = ((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.fieldAttributeAppender.hashCode()) * 31;
                    Object obj = this.defaultValue;
                    if (obj != null) {
                        hashCode += obj.hashCode();
                    }
                    return (hashCode * 31) + this.transformer.hashCode();
                }

                public boolean matches(@MaybeNull FieldDescription fieldDescription) {
                    return this.matcher.matches(fieldDescription);
                }
            }

            protected Compiled(TypeDescription typeDescription, List<Entry> list) {
                this.instrumentedType = typeDescription;
                this.entries = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Compiled compiled = (Compiled) obj;
                return this.instrumentedType.equals(compiled.instrumentedType) && this.entries.equals(compiled.entries);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.entries.hashCode();
            }

            public TypeWriter.FieldPool.Record target(FieldDescription fieldDescription) {
                for (Entry next : this.entries) {
                    if (next.matches(fieldDescription)) {
                        return next.bind(this.instrumentedType, fieldDescription);
                    }
                }
                return new TypeWriter.FieldPool.Record.ForImplicitField(fieldDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Entry implements LatentMatcher<FieldDescription> {
            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
            @MaybeNull
            private final Object defaultValue;
            private final FieldAttributeAppender.Factory fieldAttributeAppenderFactory;
            private final LatentMatcher<? super FieldDescription> matcher;
            private final Transformer<FieldDescription> transformer;

            protected Entry(LatentMatcher<? super FieldDescription> latentMatcher, FieldAttributeAppender.Factory factory, @MaybeNull Object obj, Transformer<FieldDescription> transformer2) {
                this.matcher = latentMatcher;
                this.fieldAttributeAppenderFactory = factory;
                this.defaultValue = obj;
                this.transformer = transformer2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
                if (r2 != null) goto L_0x003c;
             */
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
                    net.bytebuddy.matcher.LatentMatcher<? super net.bytebuddy.description.field.FieldDescription> r2 = r4.matcher
                    net.bytebuddy.dynamic.scaffold.FieldRegistry$Default$Entry r5 = (net.bytebuddy.dynamic.scaffold.FieldRegistry.Default.Entry) r5
                    net.bytebuddy.matcher.LatentMatcher<? super net.bytebuddy.description.field.FieldDescription> r3 = r5.matcher
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x0020
                    return r1
                L_0x0020:
                    net.bytebuddy.implementation.attribute.FieldAttributeAppender$Factory r2 = r4.fieldAttributeAppenderFactory
                    net.bytebuddy.implementation.attribute.FieldAttributeAppender$Factory r3 = r5.fieldAttributeAppenderFactory
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x002b
                    return r1
                L_0x002b:
                    java.lang.Object r2 = r4.defaultValue
                    java.lang.Object r3 = r5.defaultValue
                    if (r3 == 0) goto L_0x003a
                    if (r2 == 0) goto L_0x003c
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x003d
                    return r1
                L_0x003a:
                    if (r2 == 0) goto L_0x003d
                L_0x003c:
                    return r1
                L_0x003d:
                    net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r2 = r4.transformer
                    net.bytebuddy.dynamic.Transformer<net.bytebuddy.description.field.FieldDescription> r5 = r5.transformer
                    boolean r5 = r2.equals(r5)
                    if (r5 != 0) goto L_0x0048
                    return r1
                L_0x0048:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.FieldRegistry.Default.Entry.equals(java.lang.Object):boolean");
            }

            /* access modifiers changed from: protected */
            @MaybeNull
            public Object getDefaultValue() {
                return this.defaultValue;
            }

            /* access modifiers changed from: protected */
            public FieldAttributeAppender.Factory getFieldAttributeAppenderFactory() {
                return this.fieldAttributeAppenderFactory;
            }

            /* access modifiers changed from: protected */
            public Transformer<FieldDescription> getTransformer() {
                return this.transformer;
            }

            public int hashCode() {
                int hashCode = ((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.fieldAttributeAppenderFactory.hashCode()) * 31;
                Object obj = this.defaultValue;
                if (obj != null) {
                    hashCode += obj.hashCode();
                }
                return (hashCode * 31) + this.transformer.hashCode();
            }

            public ElementMatcher<? super FieldDescription> resolve(TypeDescription typeDescription) {
                return this.matcher.resolve(typeDescription);
            }
        }

        public Default() {
            this(Collections.emptyList());
        }

        public Compiled compile(TypeDescription typeDescription) {
            ArrayList arrayList = new ArrayList(this.entries.size());
            HashMap hashMap = new HashMap();
            for (Entry next : this.entries) {
                FieldAttributeAppender fieldAttributeAppender = (FieldAttributeAppender) hashMap.get(next.getFieldAttributeAppenderFactory());
                if (fieldAttributeAppender == null) {
                    fieldAttributeAppender = next.getFieldAttributeAppenderFactory().make(typeDescription);
                    hashMap.put(next.getFieldAttributeAppenderFactory(), fieldAttributeAppender);
                }
                arrayList.add(new Compiled.Entry(next.resolve(typeDescription), fieldAttributeAppender, next.getDefaultValue(), next.getTransformer()));
            }
            return new Compiled(typeDescription, arrayList);
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

        public FieldRegistry prepend(LatentMatcher<? super FieldDescription> latentMatcher, FieldAttributeAppender.Factory factory, @MaybeNull Object obj, Transformer<FieldDescription> transformer) {
            ArrayList arrayList = new ArrayList(this.entries.size() + 1);
            arrayList.add(new Entry(latentMatcher, factory, obj, transformer));
            arrayList.addAll(this.entries);
            return new Default(arrayList);
        }

        private Default(List<Entry> list) {
            this.entries = list;
        }
    }

    Compiled compile(TypeDescription typeDescription);

    FieldRegistry prepend(LatentMatcher<? super FieldDescription> latentMatcher, FieldAttributeAppender.Factory factory, @MaybeNull Object obj, Transformer<FieldDescription> transformer);
}
