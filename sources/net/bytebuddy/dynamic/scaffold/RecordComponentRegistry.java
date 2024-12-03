package net.bytebuddy.dynamic.scaffold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface RecordComponentRegistry {

    public interface Compiled extends TypeWriter.RecordComponentPool {

        public enum NoOp implements Compiled {
            INSTANCE;

            public TypeWriter.RecordComponentPool.Record target(RecordComponentDescription recordComponentDescription) {
                return new TypeWriter.RecordComponentPool.Record.ForImplicitRecordComponent(recordComponentDescription);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements RecordComponentRegistry {
        private final List<Entry> entries;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Compiled implements Compiled {
            private final List<Entry> entries;
            private final TypeDescription instrumentedType;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Entry implements ElementMatcher<RecordComponentDescription> {
                private final ElementMatcher<? super RecordComponentDescription> matcher;
                private final RecordComponentAttributeAppender recordComponentAttributeAppender;
                private final Transformer<RecordComponentDescription> transformer;

                protected Entry(ElementMatcher<? super RecordComponentDescription> elementMatcher, RecordComponentAttributeAppender recordComponentAttributeAppender2, Transformer<RecordComponentDescription> transformer2) {
                    this.matcher = elementMatcher;
                    this.recordComponentAttributeAppender = recordComponentAttributeAppender2;
                    this.transformer = transformer2;
                }

                /* access modifiers changed from: protected */
                public TypeWriter.RecordComponentPool.Record bind(TypeDescription typeDescription, RecordComponentDescription recordComponentDescription) {
                    return new TypeWriter.RecordComponentPool.Record.ForExplicitRecordComponent(this.recordComponentAttributeAppender, this.transformer.transform(typeDescription, recordComponentDescription));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Entry entry = (Entry) obj;
                    return this.matcher.equals(entry.matcher) && this.recordComponentAttributeAppender.equals(entry.recordComponentAttributeAppender) && this.transformer.equals(entry.transformer);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.recordComponentAttributeAppender.hashCode()) * 31) + this.transformer.hashCode();
                }

                public boolean matches(@MaybeNull RecordComponentDescription recordComponentDescription) {
                    return this.matcher.matches(recordComponentDescription);
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

            public TypeWriter.RecordComponentPool.Record target(RecordComponentDescription recordComponentDescription) {
                for (Entry next : this.entries) {
                    if (next.matches(recordComponentDescription)) {
                        return next.bind(this.instrumentedType, recordComponentDescription);
                    }
                }
                return new TypeWriter.RecordComponentPool.Record.ForImplicitRecordComponent(recordComponentDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Entry implements LatentMatcher<RecordComponentDescription> {
            private final LatentMatcher<? super RecordComponentDescription> matcher;
            private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppender;
            private final Transformer<RecordComponentDescription> transformer;

            protected Entry(LatentMatcher<? super RecordComponentDescription> latentMatcher, RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer2) {
                this.matcher = latentMatcher;
                this.recordComponentAttributeAppender = factory;
                this.transformer = transformer2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.recordComponentAttributeAppender.equals(entry.recordComponentAttributeAppender) && this.transformer.equals(entry.transformer);
            }

            /* access modifiers changed from: protected */
            public RecordComponentAttributeAppender.Factory getRecordComponentAttributeAppender() {
                return this.recordComponentAttributeAppender;
            }

            /* access modifiers changed from: protected */
            public Transformer<RecordComponentDescription> getTransformer() {
                return this.transformer;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.recordComponentAttributeAppender.hashCode()) * 31) + this.transformer.hashCode();
            }

            public ElementMatcher<? super RecordComponentDescription> resolve(TypeDescription typeDescription) {
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
                RecordComponentAttributeAppender recordComponentAttributeAppender = (RecordComponentAttributeAppender) hashMap.get(next.getRecordComponentAttributeAppender());
                if (recordComponentAttributeAppender == null) {
                    recordComponentAttributeAppender = next.getRecordComponentAttributeAppender().make(typeDescription);
                    hashMap.put(next.getRecordComponentAttributeAppender(), recordComponentAttributeAppender);
                }
                arrayList.add(new Compiled.Entry(next.resolve(typeDescription), recordComponentAttributeAppender, next.getTransformer()));
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

        public RecordComponentRegistry prepend(LatentMatcher<? super RecordComponentDescription> latentMatcher, RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer) {
            ArrayList arrayList = new ArrayList(this.entries.size() + 1);
            arrayList.add(new Entry(latentMatcher, factory, transformer));
            arrayList.addAll(this.entries);
            return new Default(arrayList);
        }

        private Default(List<Entry> list) {
            this.entries = list;
        }
    }

    Compiled compile(TypeDescription typeDescription);

    RecordComponentRegistry prepend(LatentMatcher<? super RecordComponentDescription> latentMatcher, RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer);
}
