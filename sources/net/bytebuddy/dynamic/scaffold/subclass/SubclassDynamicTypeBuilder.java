package net.bytebuddy.dynamic.scaffold.subclass;

import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class SubclassDynamicTypeBuilder<T> extends DynamicType.Builder.AbstractBase.Adapter<T> {
    private final ConstructorStrategy constructorStrategy;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class InstrumentableMatcher implements LatentMatcher<MethodDescription> {
        private final LatentMatcher<? super MethodDescription> ignoredMethods;

        protected InstrumentableMatcher(LatentMatcher<? super MethodDescription> latentMatcher) {
            this.ignoredMethods = latentMatcher;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.ignoredMethods.equals(((InstrumentableMatcher) obj).ignoredMethods);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.ignoredMethods.hashCode();
        }

        public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
            return ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isFinal())).and(ElementMatchers.isVisibleTo(typeDescription)).and(ElementMatchers.not(this.ignoredMethods.resolve(typeDescription))).or(ElementMatchers.isDeclaredBy(typeDescription));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SubclassDynamicTypeBuilder(net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName r20, net.bytebuddy.ClassFileVersion r21, net.bytebuddy.implementation.auxiliary.AuxiliaryType.NamingStrategy r22, net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory r23, net.bytebuddy.implementation.attribute.AnnotationRetention r24, net.bytebuddy.implementation.Implementation.Context.Factory r25, net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler r26, net.bytebuddy.dynamic.scaffold.TypeValidation r27, net.bytebuddy.dynamic.VisibilityBridgeStrategy r28, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy r29, net.bytebuddy.matcher.LatentMatcher<? super net.bytebuddy.description.method.MethodDescription> r30, net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy r31) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r28
            r15 = r29
            r16 = r30
            r18 = r31
            net.bytebuddy.dynamic.scaffold.FieldRegistry$Default r3 = new net.bytebuddy.dynamic.scaffold.FieldRegistry$Default
            r2 = r3
            r3.<init>()
            net.bytebuddy.dynamic.scaffold.MethodRegistry$Default r4 = new net.bytebuddy.dynamic.scaffold.MethodRegistry$Default
            r3 = r4
            r4.<init>()
            net.bytebuddy.dynamic.scaffold.RecordComponentRegistry$Default r5 = new net.bytebuddy.dynamic.scaffold.RecordComponentRegistry$Default
            r4 = r5
            r5.<init>()
            net.bytebuddy.implementation.attribute.TypeAttributeAppender$ForInstrumentedType r5 = net.bytebuddy.implementation.attribute.TypeAttributeAppender.ForInstrumentedType.INSTANCE
            net.bytebuddy.asm.AsmVisitorWrapper$NoOp r6 = net.bytebuddy.asm.AsmVisitorWrapper.NoOp.INSTANCE
            java.util.List r17 = java.util.Collections.emptyList()
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder.<init>(net.bytebuddy.dynamic.scaffold.InstrumentedType$WithFlexibleName, net.bytebuddy.ClassFileVersion, net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy, net.bytebuddy.implementation.attribute.AnnotationValueFilter$Factory, net.bytebuddy.implementation.attribute.AnnotationRetention, net.bytebuddy.implementation.Implementation$Context$Factory, net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler, net.bytebuddy.dynamic.scaffold.TypeValidation, net.bytebuddy.dynamic.VisibilityBridgeStrategy, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy, net.bytebuddy.matcher.LatentMatcher, net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy):void");
    }

    private InstrumentedType applyConstructorStrategy(InstrumentedType instrumentedType) {
        if (!instrumentedType.isInterface()) {
            for (MethodDescription.Token withMethod : this.constructorStrategy.extractConstructors(instrumentedType)) {
                instrumentedType = instrumentedType.withMethod(withMethod);
            }
        }
        return instrumentedType;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.constructorStrategy.equals(((SubclassDynamicTypeBuilder) obj).constructorStrategy);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.constructorStrategy.hashCode();
    }

    /* access modifiers changed from: protected */
    public DynamicType.Builder<T> materialize(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list) {
        return new SubclassDynamicTypeBuilder(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, classWriterStrategy, latentMatcher, list, this.constructorStrategy);
    }

    /* access modifiers changed from: protected */
    public TypeWriter<T> toTypeWriter() {
        return toTypeWriter(TypePool.ClassLoading.ofSystemLoader());
    }

    /* access modifiers changed from: protected */
    public TypeWriter<T> toTypeWriter(TypePool typePool) {
        MethodRegistry.Compiled compile = this.constructorStrategy.inject(this.instrumentedType, this.methodRegistry).prepare(applyConstructorStrategy(this.instrumentedType), this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, new InstrumentableMatcher(this.ignoredMethods)).compile(SubclassImplementationTarget.Factory.SUPER_CLASS, this.classFileVersion);
        return TypeWriter.Default.forCreation(compile, this.auxiliaryTypes, this.fieldRegistry.compile(compile.getInstrumentedType()), this.recordComponentRegistry.compile(compile.getInstrumentedType()), this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classWriterStrategy, TypePool.Explicit.wrap(this.instrumentedType, this.auxiliaryTypes, typePool));
    }

    protected SubclassDynamicTypeBuilder(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list, ConstructorStrategy constructorStrategy2) {
        super(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, classWriterStrategy, latentMatcher, list);
        this.constructorStrategy = constructorStrategy2;
    }
}
