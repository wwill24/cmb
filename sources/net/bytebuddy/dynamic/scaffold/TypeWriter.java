package net.bytebuddy.dynamic.scaffold;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.dynamic.scaffold.inline.RebaseImplementationTarget;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.commons.ClassRemapper;
import net.bytebuddy.jar.asm.commons.Remapper;
import net.bytebuddy.jar.asm.commons.SimpleRemapper;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import net.bytebuddy.utility.visitor.ContextClassVisitor;
import net.bytebuddy.utility.visitor.MetadataAwareClassVisitor;

public interface TypeWriter<T> {
    public static final String DUMP_PROPERTY = "net.bytebuddy.dump";

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class Default<S> implements TypeWriter<S> {
        private static final boolean ACCESS_CONTROLLER;
        @MaybeNull
        protected static final String DUMP_FOLDER;
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final String NO_REFERENCE = null;
        protected final AnnotationRetention annotationRetention;
        protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
        protected final AsmVisitorWrapper asmVisitorWrapper;
        protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
        protected final List<? extends DynamicType> auxiliaryTypes;
        protected final ClassFileVersion classFileVersion;
        protected final ClassWriterStrategy classWriterStrategy;
        protected final FieldPool fieldPool;
        protected final FieldList<FieldDescription.InDefinedShape> fields;
        protected final Implementation.Context.Factory implementationContextFactory;
        protected final MethodList<?> instrumentedMethods;
        protected final TypeDescription instrumentedType;
        protected final LoadedTypeInitializer loadedTypeInitializer;
        protected final MethodList<?> methods;
        protected final RecordComponentPool recordComponentPool;
        protected final RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents;
        protected final TypeAttributeAppender typeAttributeAppender;
        protected final TypeInitializer typeInitializer;
        protected final TypePool typePool;
        protected final TypeValidation typeValidation;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ClassDumpAction implements PrivilegedExceptionAction<Void> {
            @AlwaysNull
            private static final Void NOTHING = null;
            private final byte[] binaryRepresentation;
            private final TypeDescription instrumentedType;
            private final boolean original;
            private final long suffix;
            private final String target;

            protected interface Dispatcher {

                public enum Disabled implements Dispatcher {
                    INSTANCE;

                    public void dump(TypeDescription typeDescription, boolean z10, byte[] bArr) {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Enabled implements Dispatcher {
                    private final String folder;
                    private final long timestamp;

                    protected Enabled(String str, long j10) {
                        this.folder = str;
                        this.timestamp = j10;
                    }

                    public void dump(TypeDescription typeDescription, boolean z10, byte[] bArr) {
                        try {
                            Object unused = Default.doPrivileged(new ClassDumpAction(this.folder, typeDescription, z10, this.timestamp, bArr));
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Enabled enabled = (Enabled) obj;
                        return this.timestamp == enabled.timestamp && this.folder.equals(enabled.folder);
                    }

                    public int hashCode() {
                        long j10 = this.timestamp;
                        return (((getClass().hashCode() * 31) + this.folder.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)));
                    }
                }

                void dump(TypeDescription typeDescription, boolean z10, byte[] bArr);
            }

            protected ClassDumpAction(String str, TypeDescription typeDescription, boolean z10, long j10, byte[] bArr) {
                this.target = str;
                this.instrumentedType = typeDescription;
                this.original = z10;
                this.suffix = j10;
                this.binaryRepresentation = bArr;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ClassDumpAction classDumpAction = (ClassDumpAction) obj;
                return this.original == classDumpAction.original && this.suffix == classDumpAction.suffix && this.target.equals(classDumpAction.target) && this.instrumentedType.equals(classDumpAction.instrumentedType) && Arrays.equals(this.binaryRepresentation, classDumpAction.binaryRepresentation);
            }

            public int hashCode() {
                long j10 = this.suffix;
                return (((((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + (this.original ? 1 : 0)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            public Void run() throws Exception {
                String str = this.target;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.instrumentedType.getName());
                sb2.append(this.original ? "-original." : ".");
                sb2.append(this.suffix);
                sb2.append(".class");
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str, sb2.toString()));
                try {
                    fileOutputStream.write(this.binaryRepresentation);
                    return NOTHING;
                } finally {
                    fileOutputStream.close();
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForCreation<U> extends Default<U> {
            /* access modifiers changed from: private */
            public final MethodPool methodPool;

            protected class CreationClassVisitor extends MetadataAwareClassVisitor {
                private final Set<String> declaredTypes = new HashSet();
                private final Implementation.Context.ExtractableView implementationContext;
                private final Set<SignatureKey> visitedFields = new HashSet();
                private final Set<SignatureKey> visitedMethods = new HashSet();

                protected CreationClassVisitor(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                    super(OpenedClassReader.ASM_API, classVisitor);
                    this.implementationContext = extractableView;
                }

                /* access modifiers changed from: protected */
                public void onAfterAttributes() {
                    ForCreation forCreation = ForCreation.this;
                    TypeAttributeAppender typeAttributeAppender = forCreation.typeAttributeAppender;
                    ClassVisitor classVisitor = this.cv;
                    TypeDescription typeDescription = forCreation.instrumentedType;
                    typeAttributeAppender.apply(classVisitor, typeDescription, forCreation.annotationValueFilterFactory.on(typeDescription));
                }

                /* access modifiers changed from: protected */
                public void onVisitEnd() {
                    String str;
                    String str2;
                    for (TypeDescription typeDescription : ForCreation.this.instrumentedType.getDeclaredTypes()) {
                        if (!this.declaredTypes.contains(typeDescription.getInternalName())) {
                            ClassVisitor classVisitor = this.cv;
                            String internalName = typeDescription.getInternalName();
                            if (typeDescription.isMemberType()) {
                                str = ForCreation.this.instrumentedType.getInternalName();
                            } else {
                                str = Default.NO_REFERENCE;
                            }
                            if (typeDescription.isAnonymousType()) {
                                str2 = Default.NO_REFERENCE;
                            } else {
                                str2 = typeDescription.getSimpleName();
                            }
                            classVisitor.visitInnerClass(internalName, str, str2, typeDescription.getModifiers());
                        }
                    }
                    for (FieldDescription fieldDescription : ForCreation.this.fields) {
                        if (!this.visitedFields.contains(new SignatureKey(fieldDescription.getName(), fieldDescription.getDescriptor()))) {
                            ForCreation.this.fieldPool.target(fieldDescription).apply(this.cv, ForCreation.this.annotationValueFilterFactory);
                        }
                    }
                    Iterator<E> it = ForCreation.this.instrumentedMethods.iterator();
                    while (it.hasNext()) {
                        MethodDescription methodDescription = (MethodDescription) it.next();
                        if (!this.visitedMethods.contains(new SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()))) {
                            ForCreation.this.methodPool.target(methodDescription).apply(this.cv, this.implementationContext, ForCreation.this.annotationValueFilterFactory);
                        }
                    }
                    Implementation.Context.ExtractableView extractableView = this.implementationContext;
                    ForCreation forCreation = ForCreation.this;
                    extractableView.drain(new TypeInitializer.Drain.Default(forCreation.instrumentedType, forCreation.methodPool, ForCreation.this.annotationValueFilterFactory), this.cv, ForCreation.this.annotationValueFilterFactory);
                    super.onVisitEnd();
                }

                /* access modifiers changed from: protected */
                public FieldVisitor onVisitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                    this.visitedFields.add(new SignatureKey(str, str2));
                    return super.onVisitField(i10, str, str2, str3, obj);
                }

                /* access modifiers changed from: protected */
                public void onVisitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i10) {
                    this.declaredTypes.add(str);
                    super.onVisitInnerClass(str, str2, str3, i10);
                }

                /* access modifiers changed from: protected */
                public MethodVisitor onVisitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                    this.visitedMethods.add(new SignatureKey(str, str2));
                    return super.onVisitMethod(i10, str, str2, str3, strArr);
                }
            }

            protected class ImplementationContextClassVisitor extends ContextClassVisitor {
                private final Implementation.Context.ExtractableView implementationContext;

                protected ImplementationContextClassVisitor(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                    super(classVisitor);
                    this.implementationContext = extractableView;
                }

                public List<DynamicType> getAuxiliaryTypes() {
                    return CompoundList.of(ForCreation.this.auxiliaryTypes, (List<? extends DynamicType>) this.implementationContext.getAuxiliaryTypes());
                }

                public LoadedTypeInitializer getLoadedTypeInitializer() {
                    return ForCreation.this.loadedTypeInitializer;
                }
            }

            protected ForCreation(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, MethodPool methodPool2, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
                super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
                this.methodPool = methodPool2;
            }

            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Relying on correlated type properties.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public Default<U>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                Implementation.Context.FrameGeneration frameGeneration;
                TypeDescription typeDescription;
                String str;
                String str2;
                int mergeWriter = this.asmVisitorWrapper.mergeWriter(0);
                int mergeReader = this.asmVisitorWrapper.mergeReader(0);
                ClassWriter resolve = this.classWriterStrategy.resolve(mergeWriter, this.typePool);
                Implementation.Context.Factory factory = this.implementationContextFactory;
                TypeDescription typeDescription2 = this.instrumentedType;
                AuxiliaryType.NamingStrategy namingStrategy = this.auxiliaryTypeNamingStrategy;
                ClassFileVersion classFileVersion = this.classFileVersion;
                if ((mergeWriter & 2) != 0 || !classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6)) {
                    frameGeneration = Implementation.Context.FrameGeneration.DISABLED;
                } else if ((mergeReader & 8) == 0) {
                    frameGeneration = Implementation.Context.FrameGeneration.GENERATE;
                } else {
                    frameGeneration = Implementation.Context.FrameGeneration.EXPAND;
                }
                Implementation.Context.ExtractableView make = factory.make(typeDescription2, namingStrategy, typeInitializer, classFileVersion, classFileVersion, frameGeneration);
                ClassVisitor wrap = this.asmVisitorWrapper.wrap(this.instrumentedType, ValidatingClassVisitor.of(resolve, this.typeValidation), make, this.typePool, this.fields, this.methods, mergeWriter, mergeReader);
                int minorMajorVersion = this.classFileVersion.getMinorMajorVersion();
                TypeDescription typeDescription3 = this.instrumentedType;
                int actualModifiers = typeDescription3.getActualModifiers(!typeDescription3.isInterface());
                String internalName = this.instrumentedType.getInternalName();
                String genericSignature = this.instrumentedType.getGenericSignature();
                if (this.instrumentedType.getSuperClass() == null) {
                    typeDescription = TypeDescription.ForLoadedType.of(Object.class);
                } else {
                    typeDescription = this.instrumentedType.getSuperClass().asErasure();
                }
                wrap.visit(minorMajorVersion, actualModifiers, internalName, genericSignature, typeDescription.getInternalName(), this.instrumentedType.getInterfaces().asErasures().toInternalNames());
                if (!this.instrumentedType.isNestHost()) {
                    wrap.visitNestHost(this.instrumentedType.getNestHost().getInternalName());
                }
                MethodDescription.InDefinedShape enclosingMethod = this.instrumentedType.getEnclosingMethod();
                if (enclosingMethod != null) {
                    wrap.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                } else if (this.instrumentedType.isLocalType() || this.instrumentedType.isAnonymousType()) {
                    wrap.visitOuterClass(this.instrumentedType.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                }
                TypeAttributeAppender typeAttributeAppender = this.typeAttributeAppender;
                TypeDescription typeDescription4 = this.instrumentedType;
                typeAttributeAppender.apply(wrap, typeDescription4, this.annotationValueFilterFactory.on(typeDescription4));
                if (this.instrumentedType.isNestHost()) {
                    for (TypeDescription internalName2 : (TypeList) this.instrumentedType.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is((Object) this.instrumentedType)))) {
                        wrap.visitNestMember(internalName2.getInternalName());
                    }
                }
                for (TypeDescription internalName3 : this.instrumentedType.getPermittedSubtypes()) {
                    wrap.visitPermittedSubclass(internalName3.getInternalName());
                }
                TypeDescription declaringType = this.instrumentedType.getDeclaringType();
                if (declaringType != null) {
                    wrap.visitInnerClass(this.instrumentedType.getInternalName(), declaringType.getInternalName(), this.instrumentedType.getSimpleName(), this.instrumentedType.getModifiers());
                } else if (this.instrumentedType.isLocalType()) {
                    wrap.visitInnerClass(this.instrumentedType.getInternalName(), Default.NO_REFERENCE, this.instrumentedType.getSimpleName(), this.instrumentedType.getModifiers());
                } else if (this.instrumentedType.isAnonymousType()) {
                    wrap.visitInnerClass(this.instrumentedType.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, this.instrumentedType.getModifiers());
                }
                for (TypeDescription typeDescription5 : this.instrumentedType.getDeclaredTypes()) {
                    String internalName4 = typeDescription5.getInternalName();
                    if (typeDescription5.isMemberType()) {
                        str = this.instrumentedType.getInternalName();
                    } else {
                        str = Default.NO_REFERENCE;
                    }
                    if (typeDescription5.isAnonymousType()) {
                        str2 = Default.NO_REFERENCE;
                    } else {
                        str2 = typeDescription5.getSimpleName();
                    }
                    wrap.visitInnerClass(internalName4, str, str2, typeDescription5.getModifiers());
                }
                for (RecordComponentDescription target : this.recordComponents) {
                    this.recordComponentPool.target(target).apply(wrap, this.annotationValueFilterFactory);
                }
                for (FieldDescription target2 : this.fields) {
                    this.fieldPool.target(target2).apply(wrap, this.annotationValueFilterFactory);
                }
                Iterator<E> it = this.instrumentedMethods.iterator();
                while (it.hasNext()) {
                    this.methodPool.target((MethodDescription) it.next()).apply(wrap, make, this.annotationValueFilterFactory);
                }
                make.drain(new TypeInitializer.Drain.Default(this.instrumentedType, this.methodPool, this.annotationValueFilterFactory), wrap, this.annotationValueFilterFactory);
                wrap.visitEnd();
                return new UnresolvedType(resolve.toByteArray(), make.getAuxiliaryTypes());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodPool.equals(((ForCreation) obj).methodPool);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.methodPool.hashCode();
            }

            public ContextClassVisitor wrap(ClassVisitor classVisitor, int i10, int i11) {
                Implementation.Context.FrameGeneration frameGeneration;
                int i12 = i10;
                int i13 = i11;
                Implementation.Context.Factory factory = this.implementationContextFactory;
                TypeDescription typeDescription = this.instrumentedType;
                AuxiliaryType.NamingStrategy namingStrategy = this.auxiliaryTypeNamingStrategy;
                TypeInitializer typeInitializer = this.typeInitializer;
                ClassFileVersion classFileVersion = this.classFileVersion;
                if ((i12 & 2) != 0 || !classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6)) {
                    frameGeneration = Implementation.Context.FrameGeneration.DISABLED;
                } else if ((i13 & 8) == 0) {
                    frameGeneration = Implementation.Context.FrameGeneration.GENERATE;
                } else {
                    frameGeneration = Implementation.Context.FrameGeneration.EXPAND;
                }
                Implementation.Context.ExtractableView make = factory.make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion, frameGeneration);
                return new ImplementationContextClassVisitor(new CreationClassVisitor(this.asmVisitorWrapper.wrap(this.instrumentedType, ValidatingClassVisitor.of(classVisitor, this.typeValidation), make, this.typePool, this.fields, this.methods, this.asmVisitorWrapper.mergeWriter(i12), this.asmVisitorWrapper.mergeReader(i13)), make), make);
            }
        }

        protected static class SignatureKey {
            private final String descriptor;
            private final String internalName;

            public SignatureKey(String str, String str2) {
                this.internalName = str;
                this.descriptor = str2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                SignatureKey signatureKey = (SignatureKey) obj;
                if (!this.internalName.equals(signatureKey.internalName) || !this.descriptor.equals(signatureKey.descriptor)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return this.internalName.hashCode() + 17 + (this.descriptor.hashCode() * 31);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class UnresolvedType {
            private final List<? extends DynamicType> auxiliaryTypes;
            private final byte[] binaryRepresentation;

            protected UnresolvedType(byte[] bArr, List<? extends DynamicType> list) {
                this.binaryRepresentation = bArr;
                this.auxiliaryTypes = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UnresolvedType unresolvedType = (UnresolvedType) obj;
                return Arrays.equals(this.binaryRepresentation, unresolvedType.binaryRepresentation) && this.auxiliaryTypes.equals(unresolvedType.auxiliaryTypes) && Default.this.equals(Default.this);
            }

            /* access modifiers changed from: protected */
            public byte[] getBinaryRepresentation() {
                return this.binaryRepresentation;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + this.auxiliaryTypes.hashCode()) * 31) + Default.this.hashCode();
            }

            /* access modifiers changed from: protected */
            public DynamicType.Unloaded<S> toDynamicType(TypeResolutionStrategy.Resolved resolved) {
                Default defaultR = Default.this;
                return new DynamicType.Default.Unloaded(defaultR.instrumentedType, this.binaryRepresentation, defaultR.loadedTypeInitializer, CompoundList.of(defaultR.auxiliaryTypes, this.auxiliaryTypes), resolved);
            }
        }

        protected static class ValidatingClassVisitor extends ClassVisitor {
            @AlwaysNull
            private static final FieldVisitor IGNORE_FIELD = null;
            @AlwaysNull
            private static final MethodVisitor IGNORE_METHOD = null;
            private static final String NO_PARAMETERS = "()";
            private static final String RETURNS_VOID = "V";
            private static final String STRING_DESCRIPTOR = "Ljava/lang/String;";
            /* access modifiers changed from: private */
            @UnknownNull
            public Constraint constraint;

            protected interface Constraint {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Compound implements Constraint {
                    private final List<Constraint> constraints = new ArrayList();

                    public Compound(List<? extends Constraint> list) {
                        for (Constraint constraint : list) {
                            if (constraint instanceof Compound) {
                                this.constraints.addAll(((Compound) constraint).constraints);
                            } else {
                                this.constraints.add(constraint);
                            }
                        }
                    }

                    public void assertAnnotation() {
                        for (Constraint assertAnnotation : this.constraints) {
                            assertAnnotation.assertAnnotation();
                        }
                    }

                    public void assertDefaultMethodCall() {
                        for (Constraint assertDefaultMethodCall : this.constraints) {
                            assertDefaultMethodCall.assertDefaultMethodCall();
                        }
                    }

                    public void assertDefaultValue(String str) {
                        for (Constraint assertDefaultValue : this.constraints) {
                            assertDefaultValue.assertDefaultValue(str);
                        }
                    }

                    public void assertDynamicValueInConstantPool() {
                        for (Constraint assertDynamicValueInConstantPool : this.constraints) {
                            assertDynamicValueInConstantPool.assertDynamicValueInConstantPool();
                        }
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                        for (Constraint assertField : this.constraints) {
                            assertField.assertField(str, z10, z11, z12, z13);
                        }
                    }

                    public void assertHandleInConstantPool() {
                        for (Constraint assertHandleInConstantPool : this.constraints) {
                            assertHandleInConstantPool.assertHandleInConstantPool();
                        }
                    }

                    public void assertInvokeDynamic() {
                        for (Constraint assertInvokeDynamic : this.constraints) {
                            assertInvokeDynamic.assertInvokeDynamic();
                        }
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                        for (Constraint assertMethod : this.constraints) {
                            assertMethod.assertMethod(str, z10, z11, z12, z13, z14, z15, z16, z17);
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                        for (Constraint assertMethodTypeInConstantPool : this.constraints) {
                            assertMethodTypeInConstantPool.assertMethodTypeInConstantPool();
                        }
                    }

                    public void assertNestMate() {
                        for (Constraint assertNestMate : this.constraints) {
                            assertNestMate.assertNestMate();
                        }
                    }

                    public void assertPermittedSubclass() {
                        for (Constraint assertPermittedSubclass : this.constraints) {
                            assertPermittedSubclass.assertPermittedSubclass();
                        }
                    }

                    public void assertRecord() {
                        for (Constraint assertRecord : this.constraints) {
                            assertRecord.assertRecord();
                        }
                    }

                    public void assertSubRoutine() {
                        for (Constraint assertSubRoutine : this.constraints) {
                            assertSubRoutine.assertSubRoutine();
                        }
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                        for (Constraint assertType : this.constraints) {
                            assertType.assertType(i10, z10, z11);
                        }
                    }

                    public void assertTypeAnnotation() {
                        for (Constraint assertTypeAnnotation : this.constraints) {
                            assertTypeAnnotation.assertTypeAnnotation();
                        }
                    }

                    public void assertTypeInConstantPool() {
                        for (Constraint assertTypeInConstantPool : this.constraints) {
                            assertTypeInConstantPool.assertTypeInConstantPool();
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.constraints.equals(((Compound) obj).constraints);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.constraints.hashCode();
                    }
                }

                public enum ForAnnotation implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);
                    
                    private final boolean classic;

                    private ForAnnotation(boolean z10) {
                        this.classic = z10;
                    }

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (!z11 || !z10 || !z12) {
                            throw new IllegalStateException("Cannot only define public, static, final field '" + str + "' for interface type");
                        }
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                        if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            return;
                        }
                        if (z15) {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        } else if (this.classic && !z14) {
                            throw new IllegalStateException("Cannot define non-virtual method '" + str + "' for a pre-Java 8 annotation type");
                        } else if (!z13 && z16) {
                            throw new IllegalStateException("Cannot define method '" + str + "' with the given signature as an annotation type method");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                        if ((i10 & 512) == 0) {
                            throw new IllegalStateException("Cannot define annotation type without interface modifier");
                        }
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForClass implements Constraint {
                    MANIFEST(true),
                    ABSTRACT(false);
                    
                    private final boolean manifestType;

                    private ForClass(boolean z10) {
                        this.manifestType = z10;
                    }

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                        throw new IllegalStateException("Cannot define default value for '" + str + "' for non-annotation type");
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                        if (z10 && this.manifestType) {
                            throw new IllegalStateException("Cannot define abstract method '" + str + "' for non-abstract class");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForClassFileVersion implements Constraint {
                    private final ClassFileVersion classFileVersion;

                    protected ForClassFileVersion(ClassFileVersion classFileVersion2) {
                        this.classFileVersion = classFileVersion2;
                    }

                    public void assertAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write annotations for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertDefaultMethodCall() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V8)) {
                            throw new IllegalStateException("Cannot invoke default method for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot write dynamic constant for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (z13 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define generic field '" + str + "' for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertHandleInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method handle to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertInvokeDynamic() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write invoke dynamic instruction for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                        if (z17 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define generic method '" + str + "' for class file version " + this.classFileVersion);
                        } else if (!z14 && z10) {
                            throw new IllegalStateException("Cannot define static or non-virtual method '" + str + "' to be abstract");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertNestMate() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot define nest mate for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertPermittedSubclass() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V17)) {
                            throw new IllegalStateException("Cannot define permitted subclasses for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertRecord() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V14)) {
                            throw new IllegalStateException("Cannot define record for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertSubRoutine() {
                        if (this.classFileVersion.isGreaterThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write subroutine for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                        if ((i10 & 8192) != 0 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot define annotation type for class file version " + this.classFileVersion);
                        } else if (z11 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define a generic type for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertTypeAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type annotations for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((ForClassFileVersion) obj).classFileVersion);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.classFileVersion.hashCode();
                    }
                }

                public enum ForInterface implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);
                    
                    private final boolean classic;

                    private ForInterface(boolean z10) {
                        this.classic = z10;
                    }

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                        throw new IllegalStateException("Cannot define default value for '" + str + "' for non-annotation type");
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (!z11 || !z10 || !z12) {
                            throw new IllegalStateException("Cannot only define public, static, final field '" + str + "' for interface type");
                        }
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                        if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            return;
                        }
                        if (!z15) {
                            boolean z18 = this.classic;
                            if (z18 && !z11) {
                                throw new IllegalStateException("Cannot define non-public method '" + str + "' for interface type");
                            } else if (z18 && !z14) {
                                throw new IllegalStateException("Cannot define non-virtual method '" + str + "' for a pre-Java 8 interface type");
                            } else if (z18 && !z10) {
                                throw new IllegalStateException("Cannot define default method '" + str + "' for pre-Java 8 interface type");
                            }
                        } else {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForPackageType implements Constraint {
                    INSTANCE;

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                        throw new IllegalStateException("Cannot define a field for a package description type");
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                        throw new IllegalStateException("Cannot define a method for a package description type");
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                        if (i10 != 5632) {
                            throw new IllegalStateException("A package description type must define 5632 as modifier");
                        } else if (z10) {
                            throw new IllegalStateException("Cannot implement interface for package type");
                        }
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForRecord implements Constraint {
                    INSTANCE;

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i10, boolean z10, boolean z11) {
                        if ((i10 & 1024) != 0) {
                            throw new IllegalStateException("Cannot define a record class as abstract");
                        }
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                void assertAnnotation();

                void assertDefaultMethodCall();

                void assertDefaultValue(String str);

                void assertDynamicValueInConstantPool();

                void assertField(String str, boolean z10, boolean z11, boolean z12, boolean z13);

                void assertHandleInConstantPool();

                void assertInvokeDynamic();

                void assertMethod(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17);

                void assertMethodTypeInConstantPool();

                void assertNestMate();

                void assertPermittedSubclass();

                void assertRecord();

                void assertSubRoutine();

                void assertType(int i10, boolean z10, boolean z11);

                void assertTypeAnnotation();

                void assertTypeInConstantPool();
            }

            protected class ValidatingFieldVisitor extends FieldVisitor {
                protected ValidatingFieldVisitor(FieldVisitor fieldVisitor) {
                    super(OpenedClassReader.ASM_API, fieldVisitor);
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return super.visitAnnotation(str, z10);
                }
            }

            protected class ValidatingMethodVisitor extends MethodVisitor {
                private final String name;

                protected ValidatingMethodVisitor(MethodVisitor methodVisitor, String str) {
                    super(OpenedClassReader.ASM_API, methodVisitor);
                    this.name = str;
                }

                @MaybeNull
                public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return super.visitAnnotation(str, z10);
                }

                @MaybeNull
                public AnnotationVisitor visitAnnotationDefault() {
                    ValidatingClassVisitor.this.constraint.assertDefaultValue(this.name);
                    return super.visitAnnotationDefault();
                }

                public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                    ValidatingClassVisitor.this.constraint.assertInvokeDynamic();
                    for (Object obj : objArr) {
                        if (obj instanceof ConstantDynamic) {
                            ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                        }
                    }
                    super.visitInvokeDynamicInsn(str, str2, handle, objArr);
                }

                public void visitJumpInsn(int i10, Label label) {
                    if (i10 == 168) {
                        ValidatingClassVisitor.this.constraint.assertSubRoutine();
                    }
                    super.visitJumpInsn(i10, label);
                }

                @SuppressFBWarnings(justification = "Fall through to default case is intentional.", value = {"SF_SWITCH_NO_DEFAULT"})
                public void visitLdcInsn(Object obj) {
                    if (obj instanceof Type) {
                        switch (((Type) obj).getSort()) {
                            case 9:
                            case 10:
                                ValidatingClassVisitor.this.constraint.assertTypeInConstantPool();
                                break;
                            case 11:
                                ValidatingClassVisitor.this.constraint.assertMethodTypeInConstantPool();
                                break;
                        }
                    } else if (obj instanceof Handle) {
                        ValidatingClassVisitor.this.constraint.assertHandleInConstantPool();
                    } else if (obj instanceof ConstantDynamic) {
                        ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                    }
                    super.visitLdcInsn(obj);
                }

                public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
                    if (z10 && i10 == 183) {
                        ValidatingClassVisitor.this.constraint.assertDefaultMethodCall();
                    }
                    super.visitMethodInsn(i10, str, str2, str3, z10);
                }
            }

            protected ValidatingClassVisitor(ClassVisitor classVisitor) {
                super(OpenedClassReader.ASM_API, classVisitor);
            }

            protected static ClassVisitor of(ClassVisitor classVisitor, TypeValidation typeValidation) {
                return typeValidation.isEnabled() ? new ValidatingClassVisitor(classVisitor) : classVisitor;
            }

            public void visit(int i10, int i11, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                boolean z10;
                boolean z11;
                Constraint.ForInterface forInterface;
                Constraint.ForAnnotation forAnnotation;
                ClassFileVersion ofMinorMajor = ClassFileVersion.ofMinorMajor(i10);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Constraint.ForClassFileVersion(ofMinorMajor));
                if (str.endsWith("/package-info")) {
                    arrayList.add(Constraint.ForPackageType.INSTANCE);
                } else if ((i11 & 8192) != 0) {
                    if (ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V5)) {
                        if (ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V8)) {
                            forAnnotation = Constraint.ForAnnotation.JAVA_8;
                        } else {
                            forAnnotation = Constraint.ForAnnotation.CLASSIC;
                        }
                        arrayList.add(forAnnotation);
                    } else {
                        throw new IllegalStateException("Cannot define an annotation type for class file version " + ofMinorMajor);
                    }
                } else if ((i11 & 512) != 0) {
                    if (ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V8)) {
                        forInterface = Constraint.ForInterface.JAVA_8;
                    } else {
                        forInterface = Constraint.ForInterface.CLASSIC;
                    }
                    arrayList.add(forInterface);
                } else if ((i11 & 1024) != 0) {
                    arrayList.add(Constraint.ForClass.ABSTRACT);
                } else {
                    arrayList.add(Constraint.ForClass.MANIFEST);
                }
                boolean z12 = true;
                if ((65536 & i11) != 0) {
                    arrayList.add(Constraint.ForRecord.INSTANCE);
                    z10 = true;
                } else {
                    z10 = false;
                }
                Constraint.Compound compound = new Constraint.Compound(arrayList);
                this.constraint = compound;
                if (strArr != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (str2 == null) {
                    z12 = false;
                }
                compound.assertType(i11, z11, z12);
                if (z10) {
                    this.constraint.assertRecord();
                }
                super.visit(i10, i11, str, str2, str3, strArr);
            }

            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                this.constraint.assertAnnotation();
                return super.visitAnnotation(str, z10);
            }

            @MaybeNull
            public FieldVisitor visitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                Class cls;
                int i11;
                int i12;
                Class<Integer> cls2 = Integer.class;
                if (obj != null) {
                    char charAt = str2.charAt(0);
                    if (charAt != 'F') {
                        if (!(charAt == 'S' || charAt == 'Z' || charAt == 'I')) {
                            if (charAt != 'J') {
                                switch (charAt) {
                                    case 'B':
                                    case 'C':
                                        break;
                                    case 'D':
                                        cls = Double.class;
                                        break;
                                    default:
                                        if (str2.equals(STRING_DESCRIPTOR)) {
                                            cls = String.class;
                                            break;
                                        } else {
                                            throw new IllegalStateException("Cannot define a default value for type of field " + str);
                                        }
                                }
                            } else {
                                cls = Long.class;
                            }
                        }
                        cls = cls2;
                    } else {
                        cls = Float.class;
                    }
                    if (!cls.isInstance(obj)) {
                        throw new IllegalStateException("Field " + str + " defines an incompatible default value " + obj);
                    } else if (cls == cls2) {
                        char charAt2 = str2.charAt(0);
                        if (charAt2 != 'B') {
                            if (charAt2 == 'C') {
                                i11 = 65535;
                            } else if (charAt2 == 'S') {
                                i12 = -32768;
                                i11 = Advice.MethodSizeHandler.UNDEFINED_SIZE;
                            } else if (charAt2 != 'Z') {
                                i12 = Integer.MIN_VALUE;
                                i11 = a.e.API_PRIORITY_OTHER;
                            } else {
                                i11 = 1;
                            }
                            i12 = 0;
                        } else {
                            i12 = -128;
                            i11 = Opcodes.LAND;
                        }
                        Integer num = (Integer) obj;
                        if (num.intValue() < i12 || num.intValue() > i11) {
                            throw new IllegalStateException("Field " + str + " defines an incompatible default value " + obj);
                        }
                    }
                }
                Constraint constraint2 = this.constraint;
                if ((i10 & 1) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((i10 & 8) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i10 & 16) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (str3 != null) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                constraint2.assertField(str, z10, z11, z12, z13);
                FieldVisitor visitField = super.visitField(i10, str, str2, str3, obj);
                if (visitField == null) {
                    return IGNORE_FIELD;
                }
                return new ValidatingFieldVisitor(visitField);
            }

            @MaybeNull
            public MethodVisitor visitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                boolean z15;
                boolean z16;
                int i11 = i10;
                String str4 = str;
                String str5 = str2;
                Constraint constraint2 = this.constraint;
                if ((i11 & 1024) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((i11 & 1) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i11 & 2) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i11 & 8) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (str4.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) || str4.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME) || (i11 & 10) != 0) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                boolean equals = str4.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME);
                if (!str5.startsWith(NO_PARAMETERS) || str5.endsWith(RETURNS_VOID)) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (str3 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                constraint2.assertMethod(str, z10, z11, z12, z13, z14, equals, z15, z16);
                MethodVisitor visitMethod = super.visitMethod(i10, str, str2, str3, strArr);
                if (visitMethod == null) {
                    return IGNORE_METHOD;
                }
                return new ValidatingMethodVisitor(visitMethod, str4);
            }

            public void visitNestHost(String str) {
                this.constraint.assertNestMate();
                super.visitNestHost(str);
            }

            public void visitNestMember(String str) {
                this.constraint.assertNestMate();
                super.visitNestMember(str);
            }

            public void visitPermittedSubclass(String str) {
                this.constraint.assertPermittedSubclass();
                super.visitPermittedSubclass(str);
            }

            @MaybeNull
            public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                this.constraint.assertTypeAnnotation();
                return super.visitTypeAnnotation(i10, typePath, str, z10);
            }
        }

        static {
            boolean z10 = false;
            String str = null;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z10 = true;
            }
            try {
                str = (String) doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (RuntimeException unused3) {
            }
            DUMP_FOLDER = str;
            ACCESS_CONTROLLER = z10;
            str = (String) doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            DUMP_FOLDER = str;
        }

        protected Default(TypeDescription typeDescription, ClassFileVersion classFileVersion2, FieldPool fieldPool2, RecordComponentPool recordComponentPool2, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer2, TypeInitializer typeInitializer2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation2, ClassWriterStrategy classWriterStrategy2, TypePool typePool2) {
            this.instrumentedType = typeDescription;
            this.classFileVersion = classFileVersion2;
            this.fieldPool = fieldPool2;
            this.recordComponentPool = recordComponentPool2;
            this.auxiliaryTypes = list;
            this.fields = fieldList;
            this.methods = methodList;
            this.instrumentedMethods = methodList2;
            this.recordComponents = recordComponentList;
            this.loadedTypeInitializer = loadedTypeInitializer2;
            this.typeInitializer = typeInitializer2;
            this.typeAttributeAppender = typeAttributeAppender2;
            this.asmVisitorWrapper = asmVisitorWrapper2;
            this.auxiliaryTypeNamingStrategy = namingStrategy;
            this.annotationValueFilterFactory = factory;
            this.annotationRetention = annotationRetention2;
            this.implementationContextFactory = factory2;
            this.typeValidation = typeValidation2;
            this.classWriterStrategy = classWriterStrategy2;
            this.typePool = typePool2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static <U> TypeWriter<U> forCreation(MethodRegistry.Compiled compiled, List<? extends DynamicType> list, FieldPool fieldPool2, RecordComponentPool recordComponentPool2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, ClassFileVersion classFileVersion2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation2, ClassWriterStrategy classWriterStrategy2, TypePool typePool2) {
            FieldPool fieldPool3 = fieldPool2;
            RecordComponentPool recordComponentPool3 = recordComponentPool2;
            ClassFileVersion classFileVersion3 = classFileVersion2;
            return new ForCreation(compiled.getInstrumentedType(), classFileVersion3, fieldPool3, compiled, recordComponentPool3, list, compiled.getInstrumentedType().getDeclaredFields(), compiled.getMethods(), compiled.getInstrumentedMethods(), compiled.getInstrumentedType().getRecordComponents(), compiled.getLoadedTypeInitializer(), compiled.getTypeInitializer(), typeAttributeAppender2, asmVisitorWrapper2, factory, annotationRetention2, namingStrategy, factory2, typeValidation2, classWriterStrategy2, typePool2);
        }

        public static <U> TypeWriter<U> forDecoration(TypeDescription typeDescription, ClassFileVersion classFileVersion2, List<? extends DynamicType> list, List<? extends MethodDescription> list2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation2, ClassWriterStrategy classWriterStrategy2, TypePool typePool2, ClassFileLocator classFileLocator) {
            return new ForInlining.WithDecorationOnly(typeDescription, classFileVersion2, list, new MethodList.Explicit(list2), typeAttributeAppender2, asmVisitorWrapper2, factory, annotationRetention2, namingStrategy, factory2, typeValidation2, classWriterStrategy2, typePool2, classFileLocator);
        }

        public static <U> TypeWriter<U> forRebasing(MethodRegistry.Prepared prepared, List<? extends DynamicType> list, FieldPool fieldPool2, RecordComponentPool recordComponentPool2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, ClassFileVersion classFileVersion2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation2, ClassWriterStrategy classWriterStrategy2, TypePool typePool2, TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodRebaseResolver methodRebaseResolver) {
            FieldPool fieldPool3 = fieldPool2;
            RecordComponentPool recordComponentPool3 = recordComponentPool2;
            TypeAttributeAppender typeAttributeAppender3 = typeAttributeAppender2;
            AsmVisitorWrapper asmVisitorWrapper3 = asmVisitorWrapper2;
            ClassFileVersion classFileVersion3 = classFileVersion2;
            AnnotationValueFilter.Factory factory3 = factory;
            AnnotationRetention annotationRetention3 = annotationRetention2;
            AuxiliaryType.NamingStrategy namingStrategy2 = namingStrategy;
            Implementation.Context.Factory factory4 = factory2;
            TypeValidation typeValidation3 = typeValidation2;
            ClassWriterStrategy classWriterStrategy3 = classWriterStrategy2;
            TypePool typePool3 = typePool2;
            TypeDescription typeDescription2 = typeDescription;
            ClassFileLocator classFileLocator2 = classFileLocator;
            TypeDescription instrumentedType2 = prepared.getInstrumentedType();
            List<S> of2 = CompoundList.of(list, (List<? extends DynamicType>) methodRebaseResolver.getAuxiliaryTypes());
            FieldList<FieldDescription.InDefinedShape> declaredFields = prepared.getInstrumentedType().getDeclaredFields();
            MethodList<?> methods2 = prepared.getMethods();
            MethodList<?> instrumentedMethods2 = prepared.getInstrumentedMethods();
            RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents2 = prepared.getInstrumentedType().getRecordComponents();
            LoadedTypeInitializer loadedTypeInitializer2 = prepared.getLoadedTypeInitializer();
            TypeInitializer typeInitializer2 = prepared.getTypeInitializer();
            RebaseImplementationTarget.Factory factory5 = r0;
            RebaseImplementationTarget.Factory factory6 = new RebaseImplementationTarget.Factory(methodRebaseResolver);
            return new ForInlining.WithFullProcessing(instrumentedType2, classFileVersion3, fieldPool3, recordComponentPool3, of2, declaredFields, methods2, instrumentedMethods2, recordComponents2, loadedTypeInitializer2, typeInitializer2, typeAttributeAppender3, asmVisitorWrapper3, factory3, annotationRetention3, namingStrategy2, factory4, typeValidation3, classWriterStrategy3, typePool3, typeDescription2, classFileLocator2, prepared, factory5, methodRebaseResolver);
        }

        public static <U> TypeWriter<U> forRedefinition(MethodRegistry.Prepared prepared, List<? extends DynamicType> list, FieldPool fieldPool2, RecordComponentPool recordComponentPool2, TypeAttributeAppender typeAttributeAppender2, AsmVisitorWrapper asmVisitorWrapper2, ClassFileVersion classFileVersion2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention2, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation2, ClassWriterStrategy classWriterStrategy2, TypePool typePool2, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            List<? extends DynamicType> list2 = list;
            FieldPool fieldPool3 = fieldPool2;
            RecordComponentPool recordComponentPool3 = recordComponentPool2;
            TypeAttributeAppender typeAttributeAppender3 = typeAttributeAppender2;
            AsmVisitorWrapper asmVisitorWrapper3 = asmVisitorWrapper2;
            ClassFileVersion classFileVersion3 = classFileVersion2;
            AnnotationValueFilter.Factory factory3 = factory;
            AnnotationRetention annotationRetention3 = annotationRetention2;
            AuxiliaryType.NamingStrategy namingStrategy2 = namingStrategy;
            Implementation.Context.Factory factory4 = factory2;
            TypeValidation typeValidation3 = typeValidation2;
            ClassWriterStrategy classWriterStrategy3 = classWriterStrategy2;
            TypePool typePool3 = typePool2;
            TypeDescription typeDescription2 = typeDescription;
            ClassFileLocator classFileLocator2 = classFileLocator;
            return new ForInlining.WithFullProcessing(prepared.getInstrumentedType(), classFileVersion3, fieldPool3, recordComponentPool3, list2, prepared.getInstrumentedType().getDeclaredFields(), prepared.getMethods(), prepared.getInstrumentedMethods(), prepared.getInstrumentedType().getRecordComponents(), prepared.getLoadedTypeInitializer(), prepared.getTypeInitializer(), typeAttributeAppender3, asmVisitorWrapper3, factory3, annotationRetention3, namingStrategy2, factory4, typeValidation3, classWriterStrategy3, typePool3, typeDescription2, classFileLocator2, prepared, SubclassImplementationTarget.Factory.LEVEL_TYPE, MethodRebaseResolver.Disabled.INSTANCE);
        }

        /* access modifiers changed from: protected */
        public abstract Default<S>.UnresolvedType create(TypeInitializer typeInitializer2, ClassDumpAction.Dispatcher dispatcher);

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.annotationRetention.equals(defaultR.annotationRetention) && this.typeValidation.equals(defaultR.typeValidation) && this.instrumentedType.equals(defaultR.instrumentedType) && this.classFileVersion.equals(defaultR.classFileVersion) && this.fieldPool.equals(defaultR.fieldPool) && this.recordComponentPool.equals(defaultR.recordComponentPool) && this.auxiliaryTypes.equals(defaultR.auxiliaryTypes) && this.fields.equals(defaultR.fields) && this.methods.equals(defaultR.methods) && this.instrumentedMethods.equals(defaultR.instrumentedMethods) && this.recordComponents.equals(defaultR.recordComponents) && this.loadedTypeInitializer.equals(defaultR.loadedTypeInitializer) && this.typeInitializer.equals(defaultR.typeInitializer) && this.typeAttributeAppender.equals(defaultR.typeAttributeAppender) && this.asmVisitorWrapper.equals(defaultR.asmVisitorWrapper) && this.annotationValueFilterFactory.equals(defaultR.annotationValueFilterFactory) && this.auxiliaryTypeNamingStrategy.equals(defaultR.auxiliaryTypeNamingStrategy) && this.implementationContextFactory.equals(defaultR.implementationContextFactory) && this.classWriterStrategy.equals(defaultR.classWriterStrategy) && this.typePool.equals(defaultR.typePool);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.classFileVersion.hashCode()) * 31) + this.fieldPool.hashCode()) * 31) + this.recordComponentPool.hashCode()) * 31) + this.auxiliaryTypes.hashCode()) * 31) + this.fields.hashCode()) * 31) + this.methods.hashCode()) * 31) + this.instrumentedMethods.hashCode()) * 31) + this.recordComponents.hashCode()) * 31) + this.loadedTypeInitializer.hashCode()) * 31) + this.typeInitializer.hashCode()) * 31) + this.typeAttributeAppender.hashCode()) * 31) + this.asmVisitorWrapper.hashCode()) * 31) + this.annotationValueFilterFactory.hashCode()) * 31) + this.annotationRetention.hashCode()) * 31) + this.auxiliaryTypeNamingStrategy.hashCode()) * 31) + this.implementationContextFactory.hashCode()) * 31) + this.typeValidation.hashCode()) * 31) + this.classWriterStrategy.hashCode()) * 31) + this.typePool.hashCode();
        }

        @SuppressFBWarnings(justification = "Setting a debugging property should never change the program outcome.", value = {"REC_CATCH_EXCEPTION"})
        public DynamicType.Unloaded<S> make(TypeResolutionStrategy.Resolved resolved) {
            ClassDumpAction.Dispatcher dispatcher;
            String str = DUMP_FOLDER;
            if (str == null) {
                dispatcher = ClassDumpAction.Dispatcher.Disabled.INSTANCE;
            } else {
                dispatcher = new ClassDumpAction.Dispatcher.Enabled(str, System.currentTimeMillis());
            }
            Default<S>.UnresolvedType create = create(resolved.injectedInto(this.typeInitializer), dispatcher);
            dispatcher.dump(this.instrumentedType, false, create.getBinaryRepresentation());
            return create.toDynamicType(resolved);
        }

        /* access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction) throws Exception {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedExceptionAction) : privilegedExceptionAction.run();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForInlining<U> extends Default<U> {
            /* access modifiers changed from: private */
            @AlwaysNull
            public static final AnnotationVisitor IGNORE_ANNOTATION = null;
            /* access modifiers changed from: private */
            @AlwaysNull
            public static final FieldVisitor IGNORE_FIELD = null;
            /* access modifiers changed from: private */
            @AlwaysNull
            public static final MethodVisitor IGNORE_METHOD = null;
            /* access modifiers changed from: private */
            @AlwaysNull
            public static final RecordComponentVisitor IGNORE_RECORD_COMPONENT = null;
            protected final ClassFileLocator classFileLocator;
            protected final TypeDescription originalType;

            protected static class ContextRegistry {
                @UnknownNull
                private Implementation.Context.ExtractableView implementationContext;

                protected ContextRegistry() {
                }

                @SuppressFBWarnings(justification = "Lazy value definition is intended.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public List<DynamicType> getAuxiliaryTypes() {
                    return this.implementationContext.getAuxiliaryTypes();
                }

                public void setImplementationContext(Implementation.Context.ExtractableView extractableView) {
                    this.implementationContext = extractableView;
                }
            }

            protected class RegistryContextClassVisitor extends ContextClassVisitor {
                private final ContextRegistry contextRegistry;

                protected RegistryContextClassVisitor(ClassVisitor classVisitor, ContextRegistry contextRegistry2) {
                    super(classVisitor);
                    this.contextRegistry = contextRegistry2;
                }

                public List<DynamicType> getAuxiliaryTypes() {
                    return CompoundList.of(ForInlining.this.auxiliaryTypes, (List<? extends DynamicType>) this.contextRegistry.getAuxiliaryTypes());
                }

                public LoadedTypeInitializer getLoadedTypeInitializer() {
                    return ForInlining.this.loadedTypeInitializer;
                }
            }

            protected static class WithDecorationOnly<V> extends ForInlining<V> {

                @SuppressFBWarnings(justification = "Field access order is implied by ASM.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                protected class DecorationClassVisitor extends MetadataAwareClassVisitor implements TypeInitializer.Drain {
                    private final ContextRegistry contextRegistry;
                    @UnknownNull
                    private Implementation.Context.ExtractableView implementationContext;
                    private final int readerFlags;
                    private final int writerFlags;

                    protected DecorationClassVisitor(ClassVisitor classVisitor, ContextRegistry contextRegistry2, int i10, int i11) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.contextRegistry = contextRegistry2;
                        this.writerFlags = i10;
                        this.readerFlags = i11;
                    }

                    public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                    }

                    /* access modifiers changed from: protected */
                    public void onAfterAttributes() {
                        WithDecorationOnly withDecorationOnly = WithDecorationOnly.this;
                        TypeAttributeAppender typeAttributeAppender = withDecorationOnly.typeAttributeAppender;
                        ClassVisitor classVisitor = this.cv;
                        TypeDescription typeDescription = withDecorationOnly.instrumentedType;
                        typeAttributeAppender.apply(classVisitor, typeDescription, withDecorationOnly.annotationValueFilterFactory.on(typeDescription));
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public AnnotationVisitor onVisitAnnotation(String str, boolean z10) {
                        if (WithDecorationOnly.this.annotationRetention.isEnabled()) {
                            return this.cv.visitAnnotation(str, z10);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitEnd() {
                        this.implementationContext.drain(this, this.cv, WithDecorationOnly.this.annotationValueFilterFactory);
                        this.cv.visitEnd();
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public AnnotationVisitor onVisitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
                        if (WithDecorationOnly.this.annotationRetention.isEnabled()) {
                            return this.cv.visitTypeAnnotation(i10, typePath, str, z10);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    public void visit(int i10, int i11, String str, String str2, String str3, String[] strArr) {
                        Implementation.Context.FrameGeneration frameGeneration;
                        ClassFileVersion ofMinorMajor = ClassFileVersion.ofMinorMajor(i10);
                        WithDecorationOnly withDecorationOnly = WithDecorationOnly.this;
                        Implementation.Context.Factory factory = withDecorationOnly.implementationContextFactory;
                        TypeDescription typeDescription = withDecorationOnly.instrumentedType;
                        AuxiliaryType.NamingStrategy namingStrategy = withDecorationOnly.auxiliaryTypeNamingStrategy;
                        TypeInitializer typeInitializer = withDecorationOnly.typeInitializer;
                        ClassFileVersion classFileVersion = withDecorationOnly.classFileVersion;
                        if ((this.writerFlags & 2) != 0 || !ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V6)) {
                            frameGeneration = Implementation.Context.FrameGeneration.DISABLED;
                        } else if ((this.readerFlags & 8) == 0) {
                            frameGeneration = Implementation.Context.FrameGeneration.GENERATE;
                        } else {
                            frameGeneration = Implementation.Context.FrameGeneration.EXPAND;
                        }
                        Implementation.Context.ExtractableView make = factory.make(typeDescription, namingStrategy, typeInitializer, ofMinorMajor, classFileVersion, frameGeneration);
                        this.implementationContext = make;
                        this.contextRegistry.setImplementationContext(make);
                        WithDecorationOnly withDecorationOnly2 = WithDecorationOnly.this;
                        ClassVisitor wrap = withDecorationOnly2.asmVisitorWrapper.wrap(withDecorationOnly2.instrumentedType, this.cv, this.implementationContext, withDecorationOnly2.typePool, withDecorationOnly2.fields, withDecorationOnly2.methods, this.writerFlags, this.readerFlags);
                        this.cv = wrap;
                        wrap.visit(i10, i11, str, str2, str3, strArr);
                    }
                }

                protected static class LazyFieldList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                    private final TypeDescription instrumentedType;

                    protected LazyFieldList(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }

                    public int size() {
                        return this.instrumentedType.getDeclaredFields().size();
                    }

                    public FieldDescription.InDefinedShape get(int i10) {
                        return (FieldDescription.InDefinedShape) this.instrumentedType.getDeclaredFields().get(i10);
                    }
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected WithDecorationOnly(net.bytebuddy.description.type.TypeDescription r24, net.bytebuddy.ClassFileVersion r25, java.util.List<? extends net.bytebuddy.dynamic.DynamicType> r26, net.bytebuddy.description.method.MethodList<?> r27, net.bytebuddy.implementation.attribute.TypeAttributeAppender r28, net.bytebuddy.asm.AsmVisitorWrapper r29, net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory r30, net.bytebuddy.implementation.attribute.AnnotationRetention r31, net.bytebuddy.implementation.auxiliary.AuxiliaryType.NamingStrategy r32, net.bytebuddy.implementation.Implementation.Context.Factory r33, net.bytebuddy.dynamic.scaffold.TypeValidation r34, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy r35, net.bytebuddy.pool.TypePool r36, net.bytebuddy.dynamic.ClassFileLocator r37) {
                    /*
                        r23 = this;
                        r0 = r23
                        r1 = r24
                        r21 = r24
                        r2 = r25
                        r5 = r26
                        r7 = r27
                        r12 = r28
                        r13 = r29
                        r14 = r30
                        r15 = r31
                        r16 = r32
                        r17 = r33
                        r18 = r34
                        r19 = r35
                        r20 = r36
                        r22 = r37
                        net.bytebuddy.dynamic.scaffold.TypeWriter$FieldPool$Disabled r3 = net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Disabled.INSTANCE
                        net.bytebuddy.dynamic.scaffold.TypeWriter$RecordComponentPool$Disabled r4 = net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Disabled.INSTANCE
                        net.bytebuddy.dynamic.scaffold.TypeWriter$Default$ForInlining$WithDecorationOnly$LazyFieldList r8 = new net.bytebuddy.dynamic.scaffold.TypeWriter$Default$ForInlining$WithDecorationOnly$LazyFieldList
                        r6 = r8
                        r9 = r24
                        r8.<init>(r9)
                        net.bytebuddy.description.method.MethodList$Empty r9 = new net.bytebuddy.description.method.MethodList$Empty
                        r8 = r9
                        r9.<init>()
                        net.bytebuddy.description.type.RecordComponentList$Empty r10 = new net.bytebuddy.description.type.RecordComponentList$Empty
                        r9 = r10
                        r10.<init>()
                        net.bytebuddy.implementation.LoadedTypeInitializer$NoOp r10 = net.bytebuddy.implementation.LoadedTypeInitializer.NoOp.INSTANCE
                        net.bytebuddy.dynamic.scaffold.TypeInitializer$None r11 = net.bytebuddy.dynamic.scaffold.TypeInitializer.None.INSTANCE
                        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithDecorationOnly.<init>(net.bytebuddy.description.type.TypeDescription, net.bytebuddy.ClassFileVersion, java.util.List, net.bytebuddy.description.method.MethodList, net.bytebuddy.implementation.attribute.TypeAttributeAppender, net.bytebuddy.asm.AsmVisitorWrapper, net.bytebuddy.implementation.attribute.AnnotationValueFilter$Factory, net.bytebuddy.implementation.attribute.AnnotationRetention, net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy, net.bytebuddy.implementation.Implementation$Context$Factory, net.bytebuddy.dynamic.scaffold.TypeValidation, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy, net.bytebuddy.pool.TypePool, net.bytebuddy.dynamic.ClassFileLocator):void");
                }

                /* access modifiers changed from: protected */
                public ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i10, int i11) {
                    if (!typeInitializer.isDefined()) {
                        return new DecorationClassVisitor(classVisitor, contextRegistry, i10, i11);
                    }
                    throw new UnsupportedOperationException("Cannot apply a type initializer for a decoration");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            protected ForInlining(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription2, ClassFileLocator classFileLocator2) {
                super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
                this.originalType = typeDescription2;
                this.classFileLocator = classFileLocator2;
            }

            /* access modifiers changed from: protected */
            public Default<U>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                try {
                    int mergeWriter = this.asmVisitorWrapper.mergeWriter(0);
                    int mergeReader = this.asmVisitorWrapper.mergeReader(0);
                    byte[] resolve = this.classFileLocator.locate(this.originalType.getName()).resolve();
                    dispatcher.dump(this.instrumentedType, true, resolve);
                    ClassReader of2 = OpenedClassReader.of(resolve);
                    ClassWriter resolve2 = this.classWriterStrategy.resolve(mergeWriter, this.typePool, of2);
                    ContextRegistry contextRegistry = new ContextRegistry();
                    of2.accept(writeTo(ValidatingClassVisitor.of(resolve2, this.typeValidation), typeInitializer, contextRegistry, mergeWriter, mergeReader), mergeReader);
                    return new UnresolvedType(resolve2.toByteArray(), contextRegistry.getAuxiliaryTypes());
                } catch (IOException e10) {
                    throw new RuntimeException("The class file could not be written", e10);
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
                ForInlining forInlining = (ForInlining) obj;
                return this.originalType.equals(forInlining.originalType) && this.classFileLocator.equals(forInlining.classFileLocator);
            }

            public int hashCode() {
                return (((super.hashCode() * 31) + this.originalType.hashCode()) * 31) + this.classFileLocator.hashCode();
            }

            public ContextClassVisitor wrap(ClassVisitor classVisitor, int i10, int i11) {
                ContextRegistry contextRegistry = new ContextRegistry();
                return new RegistryContextClassVisitor(writeTo(ValidatingClassVisitor.of(classVisitor, this.typeValidation), this.typeInitializer, contextRegistry, this.asmVisitorWrapper.mergeWriter(i10), this.asmVisitorWrapper.mergeReader(i11)), contextRegistry);
            }

            /* access modifiers changed from: protected */
            public abstract ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i10, int i11);

            @HashCodeAndEqualsPlugin.Enhance
            protected static class WithFullProcessing<V> extends ForInlining<V> {
                /* access modifiers changed from: private */
                public static final Object[] EMPTY = new Object[0];
                /* access modifiers changed from: private */
                public final Implementation.Target.Factory implementationTargetFactory;
                /* access modifiers changed from: private */
                public final MethodRebaseResolver methodRebaseResolver;
                /* access modifiers changed from: private */
                public final MethodRegistry.Prepared methodRegistry;

                protected interface InitializationHandler {

                    public static abstract class Appending extends MethodVisitor implements InitializationHandler, TypeInitializer.Drain {
                        protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
                        protected final FrameWriter frameWriter;
                        protected final TypeDescription instrumentedType;
                        protected int localVariableLength;
                        protected final MethodPool.Record record;
                        protected int stackSize;

                        protected interface FrameWriter {
                            public static final Object[] EMPTY = new Object[0];

                            public static class Active implements FrameWriter {
                                private int currentLocalVariableLength;

                                public void emitFrame(MethodVisitor methodVisitor) {
                                    int i10 = this.currentLocalVariableLength;
                                    if (i10 == 0) {
                                        Object[] objArr = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                                    } else if (i10 > 3) {
                                        Object[] objArr2 = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(0, objArr2.length, objArr2, objArr2.length, objArr2);
                                    } else {
                                        Object[] objArr3 = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(2, i10, objArr3, objArr3.length, objArr3);
                                    }
                                    methodVisitor.visitInsn(0);
                                    this.currentLocalVariableLength = 0;
                                }

                                public void onFrame(int i10, int i11) {
                                    if (i10 == -1 || i10 == 0) {
                                        this.currentLocalVariableLength = i11;
                                    } else if (i10 == 1) {
                                        this.currentLocalVariableLength += i11;
                                    } else if (i10 == 2) {
                                        this.currentLocalVariableLength -= i11;
                                    } else if (i10 != 3 && i10 != 4) {
                                        throw new IllegalStateException("Unexpected frame type: " + i10);
                                    }
                                }
                            }

                            public enum Expanding implements FrameWriter {
                                INSTANCE;

                                public void emitFrame(MethodVisitor methodVisitor) {
                                    Object[] objArr = FrameWriter.EMPTY;
                                    methodVisitor.visitFrame(-1, objArr.length, objArr, objArr.length, objArr);
                                    methodVisitor.visitInsn(0);
                                }

                                public void onFrame(int i10, int i11) {
                                }
                            }

                            public enum NoOp implements FrameWriter {
                                INSTANCE;

                                public void emitFrame(MethodVisitor methodVisitor) {
                                }

                                public void onFrame(int i10, int i11) {
                                }
                            }

                            void emitFrame(MethodVisitor methodVisitor);

                            void onFrame(int i10, int i11);
                        }

                        protected static abstract class WithDrain extends Appending {
                            protected final Label appended = new Label();
                            protected final Label original = new Label();

                            protected static class WithActiveRecord extends WithDrain {
                                private final Label label = new Label();

                                protected WithActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                                    super(methodVisitor, typeDescription, record, factory, z10, z11);
                                }

                                /* access modifiers changed from: protected */
                                public void onAfterComplete(Implementation.Context context) {
                                    this.mv.visitLabel(this.label);
                                    this.frameWriter.emitFrame(this.mv);
                                    ByteCodeAppender.Size applyCode = this.record.applyCode(this.mv, context);
                                    this.stackSize = Math.max(this.stackSize, applyCode.getOperandStackSize());
                                    this.localVariableLength = Math.max(this.localVariableLength, applyCode.getLocalVariableSize());
                                }

                                public void visitInsn(int i10) {
                                    if (i10 == 177) {
                                        this.mv.visitJumpInsn(Opcodes.GOTO, this.label);
                                    } else {
                                        super.visitInsn(i10);
                                    }
                                }
                            }

                            protected static class WithoutActiveRecord extends WithDrain {
                                protected WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                                    super(methodVisitor, typeDescription, record, factory, z10, z11);
                                }

                                /* access modifiers changed from: protected */
                                public void onAfterComplete(Implementation.Context context) {
                                }
                            }

                            protected WithDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                                super(methodVisitor, typeDescription, record, factory, z10, z11);
                            }

                            /* access modifiers changed from: protected */
                            public abstract void onAfterComplete(Implementation.Context context);

                            /* access modifiers changed from: protected */
                            public void onComplete(Implementation.Context context) {
                                this.mv.visitJumpInsn(Opcodes.GOTO, this.original);
                                onAfterComplete(context);
                            }

                            /* access modifiers changed from: protected */
                            public void onStart() {
                                this.mv.visitJumpInsn(Opcodes.GOTO, this.appended);
                                this.mv.visitLabel(this.original);
                                this.frameWriter.emitFrame(this.mv);
                            }

                            public void visitEnd() {
                                this.mv.visitLabel(this.appended);
                                this.frameWriter.emitFrame(this.mv);
                            }
                        }

                        protected static abstract class WithoutDrain extends Appending {

                            protected static class WithActiveRecord extends WithoutDrain {
                                private final Label label = new Label();

                                protected WithActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                                    super(methodVisitor, typeDescription, record, factory, z10, z11);
                                }

                                /* access modifiers changed from: protected */
                                public void onComplete(Implementation.Context context) {
                                    this.mv.visitLabel(this.label);
                                    this.frameWriter.emitFrame(this.mv);
                                    ByteCodeAppender.Size applyCode = this.record.applyCode(this.mv, context);
                                    this.stackSize = Math.max(this.stackSize, applyCode.getOperandStackSize());
                                    this.localVariableLength = Math.max(this.localVariableLength, applyCode.getLocalVariableSize());
                                }

                                public void visitInsn(int i10) {
                                    if (i10 == 177) {
                                        this.mv.visitJumpInsn(Opcodes.GOTO, this.label);
                                    } else {
                                        super.visitInsn(i10);
                                    }
                                }
                            }

                            protected static class WithoutActiveRecord extends WithoutDrain {
                                protected WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory) {
                                    super(methodVisitor, typeDescription, record, factory, false, false);
                                }

                                /* access modifiers changed from: protected */
                                public void onComplete(Implementation.Context context) {
                                }
                            }

                            protected WithoutDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                                super(methodVisitor, typeDescription, record, factory, z10, z11);
                            }

                            /* access modifiers changed from: protected */
                            public void onStart() {
                            }

                            public void visitEnd() {
                            }
                        }

                        protected Appending(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record2, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.instrumentedType = typeDescription;
                            this.record = record2;
                            this.annotationValueFilterFactory = factory;
                            if (!z10) {
                                this.frameWriter = FrameWriter.NoOp.INSTANCE;
                            } else if (z11) {
                                this.frameWriter = FrameWriter.Expanding.INSTANCE;
                            } else {
                                this.frameWriter = new FrameWriter.Active();
                            }
                        }

                        protected static InitializationHandler of(boolean z10, MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                            if (z10) {
                                return withDrain(methodVisitor, typeDescription, methodPool, factory, z11, z12);
                            }
                            return withoutDrain(methodVisitor, typeDescription, methodPool, factory, z11, z12);
                        }

                        private static WithDrain withDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                            MethodPool.Record target = methodPool.target(new MethodDescription.Latent.TypeInitializer(typeDescription));
                            if (target.getSort().isImplemented()) {
                                return new WithDrain.WithActiveRecord(methodVisitor, typeDescription, target, factory, z10, z11);
                            }
                            return new WithDrain.WithoutActiveRecord(methodVisitor, typeDescription, target, factory, z10, z11);
                        }

                        private static WithoutDrain withoutDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z10, boolean z11) {
                            MethodPool.Record target = methodPool.target(new MethodDescription.Latent.TypeInitializer(typeDescription));
                            if (target.getSort().isImplemented()) {
                                return new WithoutDrain.WithActiveRecord(methodVisitor, typeDescription, target, factory, z10, z11);
                            }
                            return new WithoutDrain.WithoutActiveRecord(methodVisitor, typeDescription, target, factory);
                        }

                        public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                            ByteCodeAppender.Size apply = typeInitializer.apply(this.mv, context, new MethodDescription.Latent.TypeInitializer(this.instrumentedType));
                            this.stackSize = Math.max(this.stackSize, apply.getOperandStackSize());
                            this.localVariableLength = Math.max(this.localVariableLength, apply.getLocalVariableSize());
                            onComplete(context);
                        }

                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                            extractableView.drain(this, classVisitor, this.annotationValueFilterFactory);
                            this.mv.visitMaxs(this.stackSize, this.localVariableLength);
                            this.mv.visitEnd();
                        }

                        /* access modifiers changed from: protected */
                        public abstract void onComplete(Implementation.Context context);

                        /* access modifiers changed from: protected */
                        public abstract void onStart();

                        public void visitCode() {
                            this.record.applyAttributes(this.mv, this.annotationValueFilterFactory);
                            super.visitCode();
                            onStart();
                        }

                        public abstract void visitEnd();

                        public void visitFrame(int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                            super.visitFrame(i10, i11, objArr, i12, objArr2);
                            this.frameWriter.onFrame(i10, i11);
                        }

                        public void visitMaxs(int i10, int i11) {
                            this.stackSize = i10;
                            this.localVariableLength = i11;
                        }
                    }

                    public static class Creating extends TypeInitializer.Drain.Default implements InitializationHandler {
                        protected Creating(TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory) {
                            super(typeDescription, methodPool, factory);
                        }

                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                            extractableView.drain(this, classVisitor, this.annotationValueFilterFactory);
                        }
                    }

                    void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView);
                }

                protected static class OpenedClassRemapper extends ClassRemapper {
                    protected OpenedClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
                        super(OpenedClassReader.ASM_API, classVisitor, remapper);
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                protected WithFullProcessing(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription2, ClassFileLocator classFileLocator, MethodRegistry.Prepared prepared, Implementation.Target.Factory factory3, MethodRebaseResolver methodRebaseResolver2) {
                    super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, typeDescription2, classFileLocator);
                    this.methodRegistry = prepared;
                    this.implementationTargetFactory = factory3;
                    this.methodRebaseResolver = methodRebaseResolver2;
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
                    WithFullProcessing withFullProcessing = (WithFullProcessing) obj;
                    return this.methodRegistry.equals(withFullProcessing.methodRegistry) && this.implementationTargetFactory.equals(withFullProcessing.implementationTargetFactory) && this.methodRebaseResolver.equals(withFullProcessing.methodRebaseResolver);
                }

                public int hashCode() {
                    return (((((super.hashCode() * 31) + this.methodRegistry.hashCode()) * 31) + this.implementationTargetFactory.hashCode()) * 31) + this.methodRebaseResolver.hashCode();
                }

                /* access modifiers changed from: protected */
                public ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i10, int i11) {
                    RedefinitionClassVisitor redefinitionClassVisitor = new RedefinitionClassVisitor(classVisitor, typeInitializer, contextRegistry, i10, i11);
                    if (this.originalType.getName().equals(this.instrumentedType.getName())) {
                        return redefinitionClassVisitor;
                    }
                    return new OpenedClassRemapper(redefinitionClassVisitor, new SimpleRemapper(this.originalType.getInternalName(), this.instrumentedType.getInternalName()));
                }

                @SuppressFBWarnings(justification = "Field access order is implied by ASM.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                protected class RedefinitionClassVisitor extends MetadataAwareClassVisitor {
                    private final ContextRegistry contextRegistry;
                    private final LinkedHashMap<SignatureKey, FieldDescription> declarableFields;
                    private final LinkedHashMap<SignatureKey, MethodDescription> declarableMethods;
                    private final LinkedHashMap<String, RecordComponentDescription> declarableRecordComponents;
                    private final LinkedHashMap<String, TypeDescription> declaredTypes;
                    /* access modifiers changed from: private */
                    @UnknownNull
                    public Implementation.Context.ExtractableView implementationContext;
                    @UnknownNull
                    private InitializationHandler initializationHandler;
                    @UnknownNull
                    private MethodPool methodPool;
                    private final Set<String> nestMembers;
                    @MaybeNull
                    private final Set<String> permittedSubclasses;
                    /* access modifiers changed from: private */
                    public final int readerFlags;
                    private boolean retainDeprecationModifiers;
                    private final TypeInitializer typeInitializer;
                    private final int writerFlags;

                    protected class AttributeObtainingFieldVisitor extends FieldVisitor {
                        private final FieldPool.Record record;

                        protected AttributeObtainingFieldVisitor(FieldVisitor fieldVisitor, FieldPool.Record record2) {
                            super(OpenedClassReader.ASM_API, fieldVisitor);
                            this.record = record2;
                        }

                        @MaybeNull
                        public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitAnnotation(str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitEnd() {
                            this.record.apply(this.fv, WithFullProcessing.this.annotationValueFilterFactory);
                            super.visitEnd();
                        }

                        @MaybeNull
                        public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitTypeAnnotation(i10, typePath, str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    protected class AttributeObtainingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;

                        protected AttributeObtainingMethodVisitor(MethodVisitor methodVisitor, MethodPool.Record record2) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.actualMethodVisitor = methodVisitor;
                            this.record = record2;
                            record2.applyHead(methodVisitor);
                        }

                        public void visitAnnotableParameterCount(int i10, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                super.visitAnnotableParameterCount(i10, z10);
                            }
                        }

                        @MaybeNull
                        public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitAnnotation(str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @MaybeNull
                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitCode() {
                            this.mv = ForInlining.IGNORE_METHOD;
                        }

                        public void visitEnd() {
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                            this.actualMethodVisitor.visitEnd();
                        }

                        @MaybeNull
                        public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitParameterAnnotation(i10, str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @MaybeNull
                        public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitTypeAnnotation(i10, typePath, str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    protected class AttributeObtainingRecordComponentVisitor extends RecordComponentVisitor {
                        private final RecordComponentPool.Record record;

                        protected AttributeObtainingRecordComponentVisitor(RecordComponentVisitor recordComponentVisitor, RecordComponentPool.Record record2) {
                            super(OpenedClassReader.ASM_API, recordComponentVisitor);
                            this.record = record2;
                        }

                        public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitAnnotation(str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitEnd() {
                            this.record.apply(getDelegate(), WithFullProcessing.this.annotationValueFilterFactory);
                            super.visitEnd();
                        }

                        public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitTypeAnnotation(i10, typePath, str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    protected class CodePreservingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;
                        private final MethodRebaseResolver.Resolution resolution;

                        protected CodePreservingMethodVisitor(MethodVisitor methodVisitor, MethodPool.Record record2, MethodRebaseResolver.Resolution resolution2) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.actualMethodVisitor = methodVisitor;
                            this.record = record2;
                            this.resolution = resolution2;
                            record2.applyHead(methodVisitor);
                        }

                        public void visitAnnotableParameterCount(int i10, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                super.visitAnnotableParameterCount(i10, z10);
                            }
                        }

                        @MaybeNull
                        public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitAnnotation(str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @MaybeNull
                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitCode() {
                            int i10;
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                            this.actualMethodVisitor.visitEnd();
                            if (this.resolution.isRebased()) {
                                this.mv = RedefinitionClassVisitor.this.cv.visitMethod(this.resolution.getResolvedMethod().getActualModifiers(), this.resolution.getResolvedMethod().getInternalName(), this.resolution.getResolvedMethod().getDescriptor(), this.resolution.getResolvedMethod().getGenericSignature(), this.resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                                super.visitCode();
                                if (!this.resolution.getAppendedParameters().isEmpty() && RedefinitionClassVisitor.this.implementationContext.getFrameGeneration().isActive()) {
                                    if (RedefinitionClassVisitor.this.implementationContext.getFrameGeneration() != Implementation.Context.FrameGeneration.GENERATE || this.resolution.getAppendedParameters().size() >= 4) {
                                        int size = (this.resolution.getResolvedMethod().getParameters().size() - this.resolution.getAppendedParameters().size()) + 1;
                                        Object[] objArr = new Object[size];
                                        objArr[0] = Opcodes.UNINITIALIZED_THIS;
                                        for (int i11 = 1; i11 < size; i11++) {
                                            TypeDescription.Generic type = ((ParameterDescription.InDefinedShape) this.resolution.getResolvedMethod().getParameters().get(i11 - 1)).getType();
                                            if (type.represents(Boolean.TYPE) || type.represents(Byte.TYPE) || type.represents(Short.TYPE) || type.represents(Character.TYPE) || type.represents(Integer.TYPE)) {
                                                objArr[i11] = Opcodes.INTEGER;
                                            } else if (type.represents(Long.TYPE)) {
                                                objArr[i11] = Opcodes.LONG;
                                            } else if (type.represents(Float.TYPE)) {
                                                objArr[i11] = Opcodes.FLOAT;
                                            } else if (type.represents(Double.TYPE)) {
                                                objArr[i11] = Opcodes.DOUBLE;
                                            } else {
                                                objArr[i11] = type.asErasure().getInternalName();
                                            }
                                        }
                                        if ((RedefinitionClassVisitor.this.readerFlags & 8) == 0) {
                                            i10 = 0;
                                        } else {
                                            i10 = -1;
                                        }
                                        super.visitFrame(i10, size, objArr, WithFullProcessing.EMPTY.length, WithFullProcessing.EMPTY);
                                    } else {
                                        super.visitFrame(2, this.resolution.getAppendedParameters().size(), WithFullProcessing.EMPTY, WithFullProcessing.EMPTY.length, WithFullProcessing.EMPTY);
                                    }
                                    super.visitInsn(0);
                                    return;
                                }
                                return;
                            }
                            this.mv = ForInlining.IGNORE_METHOD;
                            super.visitCode();
                        }

                        public void visitMaxs(int i10, int i11) {
                            super.visitMaxs(i10, Math.max(i11, this.resolution.getResolvedMethod().getStackSize()));
                        }

                        @MaybeNull
                        public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitParameterAnnotation(i10, str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @MaybeNull
                        public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return super.visitTypeAnnotation(i10, typePath, str, z10);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    protected RedefinitionClassVisitor(ClassVisitor classVisitor, TypeInitializer typeInitializer2, ContextRegistry contextRegistry2, int i10, int i11) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.typeInitializer = typeInitializer2;
                        this.contextRegistry = contextRegistry2;
                        this.writerFlags = i10;
                        this.readerFlags = i11;
                        this.declarableFields = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.fields.size()) / 0.75d));
                        for (FieldDescription fieldDescription : WithFullProcessing.this.fields) {
                            this.declarableFields.put(new SignatureKey(fieldDescription.getInternalName(), fieldDescription.getDescriptor()), fieldDescription);
                        }
                        this.declarableMethods = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.instrumentedMethods.size()) / 0.75d));
                        Iterator<E> it = WithFullProcessing.this.instrumentedMethods.iterator();
                        while (it.hasNext()) {
                            MethodDescription methodDescription = (MethodDescription) it.next();
                            this.declarableMethods.put(new SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()), methodDescription);
                        }
                        this.declarableRecordComponents = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.recordComponents.size()) / 0.75d));
                        for (RecordComponentDescription recordComponentDescription : WithFullProcessing.this.recordComponents) {
                            this.declarableRecordComponents.put(recordComponentDescription.getActualName(), recordComponentDescription);
                        }
                        if (WithFullProcessing.this.instrumentedType.isNestHost()) {
                            this.nestMembers = new LinkedHashSet((int) Math.ceil(((double) WithFullProcessing.this.instrumentedType.getNestMembers().size()) / 0.75d));
                            for (TypeDescription internalName : (TypeList) WithFullProcessing.this.instrumentedType.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is((Object) WithFullProcessing.this.instrumentedType)))) {
                                this.nestMembers.add(internalName.getInternalName());
                            }
                        } else {
                            this.nestMembers = Collections.emptySet();
                        }
                        this.declaredTypes = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.instrumentedType.getDeclaredTypes().size()) / 0.75d));
                        for (TypeDescription typeDescription : WithFullProcessing.this.instrumentedType.getDeclaredTypes()) {
                            this.declaredTypes.put(typeDescription.getInternalName(), typeDescription);
                        }
                        if (WithFullProcessing.this.instrumentedType.isSealed()) {
                            this.permittedSubclasses = new LinkedHashSet((int) Math.ceil(((double) WithFullProcessing.this.instrumentedType.getPermittedSubtypes().size()) / 0.75d));
                            for (TypeDescription internalName2 : WithFullProcessing.this.instrumentedType.getPermittedSubtypes()) {
                                this.permittedSubclasses.add(internalName2.getInternalName());
                            }
                            return;
                        }
                        this.permittedSubclasses = null;
                    }

                    private int resolveDeprecationModifiers(int i10) {
                        if (!this.retainDeprecationModifiers || (i10 & Opcodes.ACC_DEPRECATED) == 0) {
                            return 0;
                        }
                        return Opcodes.ACC_DEPRECATED;
                    }

                    /* access modifiers changed from: protected */
                    public void onAfterAttributes() {
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        TypeAttributeAppender typeAttributeAppender = withFullProcessing.typeAttributeAppender;
                        ClassVisitor classVisitor = this.cv;
                        TypeDescription typeDescription = withFullProcessing.instrumentedType;
                        typeAttributeAppender.apply(classVisitor, typeDescription, withFullProcessing.annotationValueFilterFactory.on(typeDescription));
                    }

                    /* access modifiers changed from: protected */
                    public void onNestHost() {
                        if (!WithFullProcessing.this.instrumentedType.isNestHost()) {
                            this.cv.visitNestHost(WithFullProcessing.this.instrumentedType.getNestHost().getInternalName());
                        }
                    }

                    /* access modifiers changed from: protected */
                    @SuppressFBWarnings(justification = "Relying on correlated type properties.", value = {"NP_NULL_ON_SOME_PATH"})
                    public void onOuterType() {
                        MethodDescription.InDefinedShape enclosingMethod = WithFullProcessing.this.instrumentedType.getEnclosingMethod();
                        if (enclosingMethod != null) {
                            this.cv.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                        } else if (WithFullProcessing.this.instrumentedType.isLocalType() || WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            this.cv.visitOuterClass(WithFullProcessing.this.instrumentedType.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                        }
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public AnnotationVisitor onVisitAnnotation(String str, boolean z10) {
                        if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                            return this.cv.visitAnnotation(str, z10);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitEnd() {
                        String str;
                        String str2;
                        for (String visitNestMember : this.nestMembers) {
                            this.cv.visitNestMember(visitNestMember);
                        }
                        Set<String> set = this.permittedSubclasses;
                        if (set != null) {
                            for (String visitPermittedSubclass : set) {
                                this.cv.visitPermittedSubclass(visitPermittedSubclass);
                            }
                        }
                        TypeDescription declaringType = WithFullProcessing.this.instrumentedType.getDeclaringType();
                        if (declaringType != null) {
                            this.cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), declaringType.getInternalName(), WithFullProcessing.this.instrumentedType.getSimpleName(), WithFullProcessing.this.instrumentedType.getModifiers());
                        } else if (WithFullProcessing.this.instrumentedType.isLocalType()) {
                            this.cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), Default.NO_REFERENCE, WithFullProcessing.this.instrumentedType.getSimpleName(), WithFullProcessing.this.instrumentedType.getModifiers());
                        } else if (WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            this.cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, WithFullProcessing.this.instrumentedType.getModifiers());
                        }
                        for (TypeDescription next : this.declaredTypes.values()) {
                            ClassVisitor classVisitor = this.cv;
                            String internalName = next.getInternalName();
                            if (next.isMemberType()) {
                                str = WithFullProcessing.this.instrumentedType.getInternalName();
                            } else {
                                str = Default.NO_REFERENCE;
                            }
                            if (next.isAnonymousType()) {
                                str2 = Default.NO_REFERENCE;
                            } else {
                                str2 = next.getSimpleName();
                            }
                            classVisitor.visitInnerClass(internalName, str, str2, next.getModifiers());
                        }
                        for (RecordComponentDescription target : this.declarableRecordComponents.values()) {
                            WithFullProcessing.this.recordComponentPool.target(target).apply(this.cv, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        for (FieldDescription target2 : this.declarableFields.values()) {
                            WithFullProcessing.this.fieldPool.target(target2).apply(this.cv, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        for (MethodDescription target3 : this.declarableMethods.values()) {
                            this.methodPool.target(target3).apply(this.cv, this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        this.initializationHandler.complete(this.cv, this.implementationContext);
                        this.cv.visitEnd();
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public FieldVisitor onVisitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                        FieldDescription remove = this.declarableFields.remove(new SignatureKey(str, str2));
                        if (remove != null) {
                            FieldPool.Record target = WithFullProcessing.this.fieldPool.target(remove);
                            if (!target.isImplicit()) {
                                return redefine(target, obj, i10, str3);
                            }
                        }
                        return this.cv.visitField(i10, str, str2, str3, obj);
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i10) {
                        String str4;
                        String str5;
                        if (!str.equals(WithFullProcessing.this.instrumentedType.getInternalName())) {
                            TypeDescription remove = this.declaredTypes.remove(str);
                            if (remove == null) {
                                this.cv.visitInnerClass(str, str2, str3, i10);
                                return;
                            }
                            ClassVisitor classVisitor = this.cv;
                            if (remove.isMemberType() || (str2 != null && str3 == null && remove.isAnonymousType())) {
                                str4 = WithFullProcessing.this.instrumentedType.getInternalName();
                            } else {
                                str4 = Default.NO_REFERENCE;
                            }
                            if (remove.isAnonymousType()) {
                                str5 = Default.NO_REFERENCE;
                            } else {
                                str5 = remove.getSimpleName();
                            }
                            classVisitor.visitInnerClass(str, str4, str5, remove.getModifiers());
                        }
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public MethodVisitor onVisitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                        String str4;
                        boolean z10;
                        boolean z11;
                        int i11 = i10;
                        String str5 = str;
                        boolean z12 = true;
                        if (str5.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            MethodVisitor visitMethod = this.cv.visitMethod(i10, str, str2, str3, strArr);
                            if (visitMethod == null) {
                                return ForInlining.IGNORE_METHOD;
                            }
                            boolean isEnabled = this.implementationContext.isEnabled();
                            WithFullProcessing withFullProcessing = WithFullProcessing.this;
                            TypeDescription typeDescription = withFullProcessing.instrumentedType;
                            MethodPool methodPool2 = this.methodPool;
                            AnnotationValueFilter.Factory factory = withFullProcessing.annotationValueFilterFactory;
                            if ((this.writerFlags & 2) != 0 || !this.implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                                z10 = false;
                            } else {
                                z10 = true;
                            }
                            if ((this.readerFlags & 8) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            InitializationHandler of2 = InitializationHandler.Appending.of(isEnabled, visitMethod, typeDescription, methodPool2, factory, z10, z11);
                            this.initializationHandler = of2;
                            return (MethodVisitor) of2;
                        }
                        MethodDescription remove = this.declarableMethods.remove(new SignatureKey(str5, str2));
                        if (remove == null) {
                            return this.cv.visitMethod(i10, str, str2, str3, strArr);
                        }
                        if ((i11 & 1024) != 0) {
                            str4 = str3;
                        } else {
                            str4 = str3;
                            z12 = false;
                        }
                        return redefine(remove, z12, i11, str4);
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitNestHost(String str) {
                        onNestHost();
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitNestMember(String str) {
                        if (WithFullProcessing.this.instrumentedType.isNestHost() && this.nestMembers.remove(str)) {
                            this.cv.visitNestMember(str);
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitOuterClass(String str, @MaybeNull String str2, @MaybeNull String str3) {
                        try {
                            onOuterType();
                        } catch (Throwable unused) {
                            this.cv.visitOuterClass(str, str2, str3);
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onVisitPermittedSubclass(String str) {
                        Set<String> set = this.permittedSubclasses;
                        if (set != null && set.remove(str)) {
                            this.cv.visitPermittedSubclass(str);
                        }
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public RecordComponentVisitor onVisitRecordComponent(String str, String str2, @MaybeNull String str3) {
                        RecordComponentDescription remove = this.declarableRecordComponents.remove(str);
                        if (remove != null) {
                            RecordComponentPool.Record target = WithFullProcessing.this.recordComponentPool.target(remove);
                            if (!target.isImplicit()) {
                                return redefine(target, str3);
                            }
                        }
                        return this.cv.visitRecordComponent(str, str2, str3);
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public AnnotationVisitor onVisitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
                        if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                            return this.cv.visitTypeAnnotation(i10, typePath, str, z10);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public RecordComponentVisitor redefine(RecordComponentPool.Record record, @MaybeNull String str) {
                        RecordComponentDescription recordComponent = record.getRecordComponent();
                        ClassVisitor classVisitor = this.cv;
                        String actualName = recordComponent.getActualName();
                        String descriptor = recordComponent.getDescriptor();
                        if (!TypeDescription.AbstractBase.RAW_TYPES) {
                            str = recordComponent.getGenericSignature();
                        }
                        RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(actualName, descriptor, str);
                        return visitRecordComponent == null ? ForInlining.IGNORE_RECORD_COMPONENT : new AttributeObtainingRecordComponentVisitor(visitRecordComponent, record);
                    }

                    @SuppressFBWarnings(justification = "Relying on correlated type properties.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public void visit(int i10, int i11, String str, String str2, String str3, String[] strArr) {
                        Implementation.Context.FrameGeneration frameGeneration;
                        boolean z10;
                        String str4;
                        String str5;
                        int i12 = i11;
                        ClassFileVersion ofMinorMajor = ClassFileVersion.ofMinorMajor(i10);
                        MethodRegistry.Compiled compile = WithFullProcessing.this.methodRegistry.compile(WithFullProcessing.this.implementationTargetFactory, ofMinorMajor);
                        this.methodPool = compile;
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        this.initializationHandler = new InitializationHandler.Creating(withFullProcessing.instrumentedType, compile, withFullProcessing.annotationValueFilterFactory);
                        WithFullProcessing withFullProcessing2 = WithFullProcessing.this;
                        Implementation.Context.Factory factory = withFullProcessing2.implementationContextFactory;
                        TypeDescription typeDescription = withFullProcessing2.instrumentedType;
                        AuxiliaryType.NamingStrategy namingStrategy = withFullProcessing2.auxiliaryTypeNamingStrategy;
                        TypeInitializer typeInitializer2 = this.typeInitializer;
                        ClassFileVersion classFileVersion = withFullProcessing2.classFileVersion;
                        if ((this.writerFlags & 2) != 0 || !ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V6)) {
                            frameGeneration = Implementation.Context.FrameGeneration.DISABLED;
                        } else if ((this.readerFlags & 8) == 0) {
                            frameGeneration = Implementation.Context.FrameGeneration.GENERATE;
                        } else {
                            frameGeneration = Implementation.Context.FrameGeneration.EXPAND;
                        }
                        this.implementationContext = factory.make(typeDescription, namingStrategy, typeInitializer2, ofMinorMajor, classFileVersion, frameGeneration);
                        this.retainDeprecationModifiers = ofMinorMajor.isLessThan(ClassFileVersion.JAVA_V5);
                        this.contextRegistry.setImplementationContext(this.implementationContext);
                        WithFullProcessing withFullProcessing3 = WithFullProcessing.this;
                        ClassVisitor wrap = withFullProcessing3.asmVisitorWrapper.wrap(withFullProcessing3.instrumentedType, this.cv, this.implementationContext, withFullProcessing3.typePool, withFullProcessing3.fields, withFullProcessing3.methods, this.writerFlags, this.readerFlags);
                        this.cv = wrap;
                        TypeDescription typeDescription2 = WithFullProcessing.this.instrumentedType;
                        int i13 = 0;
                        if ((i12 & 32) == 0 || typeDescription2.isInterface()) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        int actualModifiers = typeDescription2.getActualModifiers(z10) | resolveDeprecationModifiers(i12);
                        if ((i12 & 16) != 0 && WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            i13 = 16;
                        }
                        int i14 = actualModifiers | i13;
                        String internalName = WithFullProcessing.this.instrumentedType.getInternalName();
                        if (TypeDescription.AbstractBase.RAW_TYPES) {
                            str4 = str2;
                        } else {
                            str4 = WithFullProcessing.this.instrumentedType.getGenericSignature();
                        }
                        if (WithFullProcessing.this.instrumentedType.getSuperClass() != null) {
                            str5 = WithFullProcessing.this.instrumentedType.getSuperClass().asErasure().getInternalName();
                        } else if (WithFullProcessing.this.instrumentedType.isInterface()) {
                            str5 = TypeDescription.ForLoadedType.of(Object.class).getInternalName();
                        } else {
                            str5 = Default.NO_REFERENCE;
                        }
                        wrap.visit(i10, i14, internalName, str4, str5, WithFullProcessing.this.instrumentedType.getInterfaces().asErasures().toInternalNames());
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public FieldVisitor redefine(FieldPool.Record record, @MaybeNull Object obj, int i10, @MaybeNull String str) {
                        FieldDescription field = record.getField();
                        ClassVisitor classVisitor = this.cv;
                        int actualModifiers = field.getActualModifiers() | resolveDeprecationModifiers(i10);
                        String internalName = field.getInternalName();
                        String descriptor = field.getDescriptor();
                        if (!TypeDescription.AbstractBase.RAW_TYPES) {
                            str = field.getGenericSignature();
                        }
                        FieldVisitor visitField = classVisitor.visitField(actualModifiers, internalName, descriptor, str, record.resolveDefault(obj));
                        return visitField == null ? ForInlining.IGNORE_FIELD : new AttributeObtainingFieldVisitor(visitField, record);
                    }

                    /* access modifiers changed from: protected */
                    @MaybeNull
                    public MethodVisitor redefine(MethodDescription methodDescription, boolean z10, int i10, @MaybeNull String str) {
                        String str2;
                        String str3;
                        String str4;
                        int i11 = i10;
                        MethodDescription methodDescription2 = methodDescription;
                        MethodPool.Record target = this.methodPool.target(methodDescription);
                        if (!target.getSort().isDefined()) {
                            ClassVisitor classVisitor = this.cv;
                            int actualModifiers = methodDescription.getActualModifiers() | resolveDeprecationModifiers(i11);
                            String internalName = methodDescription.getInternalName();
                            String descriptor = methodDescription.getDescriptor();
                            if (TypeDescription.AbstractBase.RAW_TYPES) {
                                str4 = str;
                            } else {
                                str4 = methodDescription.getGenericSignature();
                            }
                            return classVisitor.visitMethod(actualModifiers, internalName, descriptor, str4, methodDescription.getExceptionTypes().asErasures().toInternalNames());
                        }
                        MethodDescription method = target.getMethod();
                        ClassVisitor classVisitor2 = this.cv;
                        int resolve = ModifierContributor.Resolver.of(Collections.singleton(target.getVisibility())).resolve(method.getActualModifiers(target.getSort().isImplemented())) | resolveDeprecationModifiers(i11);
                        String internalName2 = method.getInternalName();
                        String descriptor2 = method.getDescriptor();
                        boolean z11 = TypeDescription.AbstractBase.RAW_TYPES;
                        if (z11) {
                            str2 = str;
                        } else {
                            str2 = method.getGenericSignature();
                        }
                        MethodVisitor visitMethod = classVisitor2.visitMethod(resolve, internalName2, descriptor2, str2, method.getExceptionTypes().asErasures().toInternalNames());
                        if (visitMethod == null) {
                            return ForInlining.IGNORE_METHOD;
                        }
                        if (z10) {
                            return new AttributeObtainingMethodVisitor(visitMethod, target);
                        }
                        if (!methodDescription.isNative()) {
                            return new CodePreservingMethodVisitor(visitMethod, target, WithFullProcessing.this.methodRebaseResolver.resolve((MethodDescription.InDefinedShape) method.asDefined()));
                        }
                        MethodRebaseResolver.Resolution resolve2 = WithFullProcessing.this.methodRebaseResolver.resolve((MethodDescription.InDefinedShape) method.asDefined());
                        if (resolve2.isRebased()) {
                            int actualModifiers2 = resolve2.getResolvedMethod().getActualModifiers() | resolveDeprecationModifiers(i11);
                            String internalName3 = resolve2.getResolvedMethod().getInternalName();
                            String descriptor3 = resolve2.getResolvedMethod().getDescriptor();
                            if (z11) {
                                str3 = str;
                            } else {
                                str3 = method.getGenericSignature();
                            }
                            MethodVisitor visitMethod2 = super.visitMethod(actualModifiers2, internalName3, descriptor3, str3, resolve2.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                            if (visitMethod2 != null) {
                                visitMethod2.visitEnd();
                            }
                        }
                        return new AttributeObtainingMethodVisitor(visitMethod, target);
                    }
                }
            }
        }
    }

    public interface MethodPool {

        public interface Record {

            @HashCodeAndEqualsPlugin.Enhance
            public static class AccessBridgeWrapper implements Record {
                private final MethodAttributeAppender attributeAppender;
                private final MethodDescription bridgeTarget;
                private final Set<MethodDescription.TypeToken> bridgeTypes;
                private final Record delegate;
                private final TypeDescription instrumentedType;

                protected static class AccessorBridge extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final MethodDescription.TypeToken bridgeType;
                    private final TypeDescription instrumentedType;

                    protected AccessorBridge(MethodDescription methodDescription, MethodDescription.TypeToken typeToken, TypeDescription typeDescription) {
                        this.bridgeTarget = methodDescription;
                        this.bridgeType = typeToken;
                        this.instrumentedType = typeDescription;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }

                    @MaybeNull
                    public AnnotationValue<?, ?> getDefaultValue() {
                        return AnnotationValue.UNDEFINED;
                    }

                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes().accept(TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
                    }

                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }

                    public int getModifiers() {
                        return (this.bridgeTarget.getModifiers() | 64 | Opcodes.ACC_SYNTHETIC) & -1281;
                    }

                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.bridgeType.getParameterTypes());
                    }

                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeType.getReturnType().asGenericType();
                    }

                    public TypeList.Generic getTypeVariables() {
                        return new TypeList.Generic.Empty();
                    }

                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }
                }

                protected static class BridgeTarget extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription instrumentedType;

                    protected BridgeTarget(MethodDescription methodDescription, TypeDescription typeDescription) {
                        this.bridgeTarget = methodDescription;
                        this.instrumentedType = typeDescription;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return this.bridgeTarget.getDeclaredAnnotations();
                    }

                    @MaybeNull
                    public AnnotationValue<?, ?> getDefaultValue() {
                        return this.bridgeTarget.getDefaultValue();
                    }

                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes();
                    }

                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }

                    public int getModifiers() {
                        return this.bridgeTarget.getModifiers();
                    }

                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.ForTokens(this, this.bridgeTarget.getParameters().asTokenList(ElementMatchers.is((Object) this.instrumentedType)));
                    }

                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeTarget.getReturnType();
                    }

                    public TypeList.Generic getTypeVariables() {
                        return this.bridgeTarget.getTypeVariables();
                    }

                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }
                }

                protected AccessBridgeWrapper(Record record, TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, MethodAttributeAppender methodAttributeAppender) {
                    this.delegate = record;
                    this.instrumentedType = typeDescription;
                    this.bridgeTarget = methodDescription;
                    this.bridgeTypes = set;
                    this.attributeAppender = methodAttributeAppender;
                }

                public static Record of(Record record, TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, MethodAttributeAppender methodAttributeAppender) {
                    HashSet hashSet = new HashSet();
                    for (MethodDescription.TypeToken next : set) {
                        if (methodDescription.isBridgeCompatible(next)) {
                            hashSet.add(next);
                        }
                    }
                    if (hashSet.isEmpty()) {
                        return record;
                    }
                    if (!typeDescription.isInterface() || record.getSort().isImplemented()) {
                        return new AccessBridgeWrapper(record, typeDescription, methodDescription, hashSet, methodAttributeAppender);
                    }
                    return record;
                }

                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    StackManipulation stackManipulation;
                    this.delegate.apply(classVisitor, context, factory);
                    for (MethodDescription.TypeToken accessorBridge : this.bridgeTypes) {
                        AccessorBridge accessorBridge2 = new AccessorBridge(this.bridgeTarget, accessorBridge, this.instrumentedType);
                        BridgeTarget bridgeTarget2 = new BridgeTarget(this.bridgeTarget, this.instrumentedType);
                        MethodVisitor visitMethod = classVisitor.visitMethod(accessorBridge2.getActualModifiers(true, getVisibility()), accessorBridge2.getInternalName(), accessorBridge2.getDescriptor(), NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE, accessorBridge2.getExceptionTypes().asErasures().toInternalNames());
                        if (visitMethod != null) {
                            this.attributeAppender.apply(visitMethod, accessorBridge2, factory.on(this.instrumentedType));
                            visitMethod.visitCode();
                            StackManipulation[] stackManipulationArr = new StackManipulation[4];
                            stackManipulationArr[0] = MethodVariableAccess.allArgumentsOf(accessorBridge2).asBridgeOf(bridgeTarget2).prependThisReference();
                            stackManipulationArr[1] = MethodInvocation.invoke((MethodDescription.InDefinedShape) bridgeTarget2).virtual(this.instrumentedType);
                            if (bridgeTarget2.getReturnType().asErasure().isAssignableTo(accessorBridge2.getReturnType().asErasure())) {
                                stackManipulation = StackManipulation.Trivial.INSTANCE;
                            } else {
                                stackManipulation = TypeCasting.to(accessorBridge2.getReturnType().asErasure());
                            }
                            stackManipulationArr[2] = stackManipulation;
                            stackManipulationArr[3] = MethodReturn.of(accessorBridge2.getReturnType());
                            ByteCodeAppender.Size apply = new ByteCodeAppender.Simple(stackManipulationArr).apply(visitMethod, context, accessorBridge2);
                            visitMethod.visitMaxs(apply.getOperandStackSize(), apply.getLocalVariableSize());
                            visitMethod.visitEnd();
                        }
                    }
                }

                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                    this.delegate.applyAttributes(methodVisitor, factory);
                }

                public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    this.delegate.applyBody(methodVisitor, context, factory);
                }

                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                    return this.delegate.applyCode(methodVisitor, context);
                }

                public void applyHead(MethodVisitor methodVisitor) {
                    this.delegate.applyHead(methodVisitor);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AccessBridgeWrapper accessBridgeWrapper = (AccessBridgeWrapper) obj;
                    return this.delegate.equals(accessBridgeWrapper.delegate) && this.instrumentedType.equals(accessBridgeWrapper.instrumentedType) && this.bridgeTarget.equals(accessBridgeWrapper.bridgeTarget) && this.bridgeTypes.equals(accessBridgeWrapper.bridgeTypes) && this.attributeAppender.equals(accessBridgeWrapper.attributeAppender);
                }

                public MethodDescription getMethod() {
                    return this.bridgeTarget;
                }

                public Sort getSort() {
                    return this.delegate.getSort();
                }

                public Visibility getVisibility() {
                    return this.delegate.getVisibility();
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + this.bridgeTarget.hashCode()) * 31) + this.bridgeTypes.hashCode()) * 31) + this.attributeAppender.hashCode();
                }

                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    return new AccessBridgeWrapper(this.delegate.prepend(byteCodeAppender), this.instrumentedType, this.bridgeTarget, this.bridgeTypes, this.attributeAppender);
                }
            }

            public static abstract class ForDefinedMethod implements Record {

                @HashCodeAndEqualsPlugin.Enhance
                public static class OfVisibilityBridge extends ForDefinedMethod implements ByteCodeAppender {
                    private final MethodAttributeAppender attributeAppender;
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription bridgeType;
                    private final MethodDescription visibilityBridge;

                    protected static class VisibilityBridge extends MethodDescription.InDefinedShape.AbstractBase {
                        private final MethodDescription bridgeTarget;
                        private final TypeDescription instrumentedType;

                        protected VisibilityBridge(TypeDescription typeDescription, MethodDescription methodDescription) {
                            this.instrumentedType = typeDescription;
                            this.bridgeTarget = methodDescription;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return this.bridgeTarget.getDeclaredAnnotations();
                        }

                        @MaybeNull
                        public AnnotationValue<?, ?> getDefaultValue() {
                            return AnnotationValue.UNDEFINED;
                        }

                        public TypeList.Generic getExceptionTypes() {
                            return this.bridgeTarget.getExceptionTypes().asRawTypes();
                        }

                        public String getInternalName() {
                            return this.bridgeTarget.getName();
                        }

                        public int getModifiers() {
                            return (this.bridgeTarget.getModifiers() | Opcodes.ACC_SYNTHETIC | 64) & -257;
                        }

                        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                            return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.bridgeTarget.getParameters().asTypeList().asRawTypes());
                        }

                        public TypeDescription.Generic getReturnType() {
                            return this.bridgeTarget.getReturnType().asRawType();
                        }

                        public TypeList.Generic getTypeVariables() {
                            return new TypeList.Generic.Empty();
                        }

                        public TypeDescription getDeclaringType() {
                            return this.instrumentedType;
                        }
                    }

                    protected OfVisibilityBridge(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDescription typeDescription, MethodAttributeAppender methodAttributeAppender) {
                        this.visibilityBridge = methodDescription;
                        this.bridgeTarget = methodDescription2;
                        this.bridgeType = typeDescription;
                        this.attributeAppender = methodAttributeAppender;
                    }

                    public static Record of(TypeDescription typeDescription, MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender) {
                        TypeDefinition typeDefinition = null;
                        if (methodDescription.isDefaultMethod()) {
                            TypeDescription asErasure = methodDescription.getDeclaringType().asErasure();
                            for (TypeDescription typeDescription2 : (TypeList) typeDescription.getInterfaces().asErasures().filter(ElementMatchers.isSubTypeOf(asErasure))) {
                                if (typeDefinition == null || asErasure.isAssignableTo(typeDefinition.asErasure())) {
                                    typeDefinition = typeDescription2;
                                }
                            }
                        }
                        if (typeDefinition == null && (typeDefinition = typeDescription.getSuperClass()) == null) {
                            typeDefinition = TypeDescription.ForLoadedType.of(Object.class);
                        }
                        return new OfVisibilityBridge(new VisibilityBridge(typeDescription, methodDescription), methodDescription, typeDefinition.asErasure(), methodAttributeAppender);
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        return new ByteCodeAppender.Simple(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), MethodInvocation.invoke(this.bridgeTarget).special(this.bridgeType), MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context, methodDescription);
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender = this.attributeAppender;
                        MethodDescription methodDescription = this.visibilityBridge;
                        methodAttributeAppender.apply(methodVisitor, methodDescription, factory.on(methodDescription));
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size applyCode = applyCode(methodVisitor, context);
                        methodVisitor.visitMaxs(applyCode.getOperandStackSize(), applyCode.getLocalVariableSize());
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        return apply(methodVisitor, context, this.visibilityBridge);
                    }

                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfVisibilityBridge ofVisibilityBridge = (OfVisibilityBridge) obj;
                        return this.visibilityBridge.equals(ofVisibilityBridge.visibilityBridge) && this.bridgeTarget.equals(ofVisibilityBridge.bridgeTarget) && this.bridgeType.equals(ofVisibilityBridge.bridgeType) && this.attributeAppender.equals(ofVisibilityBridge.attributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.visibilityBridge;
                    }

                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    public Visibility getVisibility() {
                        return this.bridgeTarget.getVisibility();
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.visibilityBridge.hashCode()) * 31) + this.bridgeTarget.hashCode()) * 31) + this.bridgeType.hashCode()) * 31) + this.attributeAppender.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        return new WithBody(this.visibilityBridge, new ByteCodeAppender.Compound(this, byteCodeAppender), this.attributeAppender, this.bridgeTarget.getVisibility());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithAnnotationDefaultValue extends ForDefinedMethod {
                    private final AnnotationValue<?, ?> annotationValue;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;

                    public WithAnnotationDefaultValue(MethodDescription methodDescription2, AnnotationValue<?, ?> annotationValue2, MethodAttributeAppender methodAttributeAppender2) {
                        this.methodDescription = methodDescription2;
                        this.annotationValue = annotationValue2;
                        this.methodAttributeAppender = methodAttributeAppender2;
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        throw new IllegalStateException("Cannot apply attributes for default value on " + this.methodDescription);
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender2 = this.methodAttributeAppender;
                        MethodDescription methodDescription2 = this.methodDescription;
                        methodAttributeAppender2.apply(methodVisitor, methodDescription2, factory.on(methodDescription2));
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        throw new IllegalStateException("Cannot apply code for default value on " + this.methodDescription);
                    }

                    public void applyHead(MethodVisitor methodVisitor) {
                        if (this.methodDescription.isDefaultValue(this.annotationValue)) {
                            AnnotationVisitor visitAnnotationDefault = methodVisitor.visitAnnotationDefault();
                            AnnotationAppender.Default.apply(visitAnnotationDefault, this.methodDescription.getReturnType().asErasure(), AnnotationAppender.NO_NAME, this.annotationValue.resolve());
                            visitAnnotationDefault.visitEnd();
                            return;
                        }
                        throw new IllegalStateException("Cannot set " + this.annotationValue + " as default for " + this.methodDescription);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithAnnotationDefaultValue withAnnotationDefaultValue = (WithAnnotationDefaultValue) obj;
                        return this.methodDescription.equals(withAnnotationDefaultValue.methodDescription) && this.annotationValue.equals(withAnnotationDefaultValue.annotationValue) && this.methodAttributeAppender.equals(withAnnotationDefaultValue.methodAttributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    public Visibility getVisibility() {
                        return this.methodDescription.getVisibility();
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.annotationValue.hashCode()) * 31) + this.methodAttributeAppender.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for default value on " + this.methodDescription);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithBody extends ForDefinedMethod {
                    private final ByteCodeAppender byteCodeAppender;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;
                    private final Visibility visibility;

                    public WithBody(MethodDescription methodDescription2, ByteCodeAppender byteCodeAppender2) {
                        this(methodDescription2, byteCodeAppender2, MethodAttributeAppender.NoOp.INSTANCE, methodDescription2.getVisibility());
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender2 = this.methodAttributeAppender;
                        MethodDescription methodDescription2 = this.methodDescription;
                        methodAttributeAppender2.apply(methodVisitor, methodDescription2, factory.on(methodDescription2));
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size applyCode = applyCode(methodVisitor, context);
                        methodVisitor.visitMaxs(applyCode.getOperandStackSize(), applyCode.getLocalVariableSize());
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        return this.byteCodeAppender.apply(methodVisitor, context, this.methodDescription);
                    }

                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithBody withBody = (WithBody) obj;
                        return this.visibility.equals(withBody.visibility) && this.methodDescription.equals(withBody.methodDescription) && this.byteCodeAppender.equals(withBody.byteCodeAppender) && this.methodAttributeAppender.equals(withBody.methodAttributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.byteCodeAppender.hashCode()) * 31) + this.methodAttributeAppender.hashCode()) * 31) + this.visibility.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender2) {
                        return new WithBody(this.methodDescription, new ByteCodeAppender.Compound(byteCodeAppender2, this.byteCodeAppender), this.methodAttributeAppender, this.visibility);
                    }

                    public WithBody(MethodDescription methodDescription2, ByteCodeAppender byteCodeAppender2, MethodAttributeAppender methodAttributeAppender2, Visibility visibility2) {
                        this.methodDescription = methodDescription2;
                        this.byteCodeAppender = byteCodeAppender2;
                        this.methodAttributeAppender = methodAttributeAppender2;
                        this.visibility = visibility2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithoutBody extends ForDefinedMethod {
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;
                    private final Visibility visibility;

                    public WithoutBody(MethodDescription methodDescription2, MethodAttributeAppender methodAttributeAppender2, Visibility visibility2) {
                        this.methodDescription = methodDescription2;
                        this.methodAttributeAppender = methodAttributeAppender2;
                        this.visibility = visibility2;
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender2 = this.methodAttributeAppender;
                        MethodDescription methodDescription2 = this.methodDescription;
                        methodAttributeAppender2.apply(methodVisitor, methodDescription2, factory.on(methodDescription2));
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        throw new IllegalStateException("Cannot apply code for abstract method on " + this.methodDescription);
                    }

                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithoutBody withoutBody = (WithoutBody) obj;
                        return this.visibility.equals(withoutBody.visibility) && this.methodDescription.equals(withoutBody.methodDescription) && this.methodAttributeAppender.equals(withoutBody.methodAttributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.methodAttributeAppender.hashCode()) * 31) + this.visibility.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for abstract method on " + this.methodDescription);
                    }
                }

                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    MethodVisitor visitMethod = classVisitor.visitMethod(getMethod().getActualModifiers(getSort().isImplemented(), getVisibility()), getMethod().getInternalName(), getMethod().getDescriptor(), getMethod().getGenericSignature(), getMethod().getExceptionTypes().asErasures().toInternalNames());
                    if (visitMethod != null) {
                        ParameterList<?> parameters = getMethod().getParameters();
                        if (parameters.hasExplicitMetaData()) {
                            Iterator<E> it = parameters.iterator();
                            while (it.hasNext()) {
                                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                                visitMethod.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
                            }
                        }
                        applyHead(visitMethod);
                        applyBody(visitMethod, context, factory);
                        visitMethod.visitEnd();
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForNonImplementedMethod implements Record {
                private final MethodDescription methodDescription;

                public ForNonImplementedMethod(MethodDescription methodDescription2) {
                    this.methodDescription = methodDescription2;
                }

                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                }

                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                }

                public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("Cannot apply body for non-implemented method on " + this.methodDescription);
                }

                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                    throw new IllegalStateException("Cannot apply code for non-implemented method on " + this.methodDescription);
                }

                public void applyHead(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Cannot apply head for non-implemented method on " + this.methodDescription);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForNonImplementedMethod) obj).methodDescription);
                }

                public MethodDescription getMethod() {
                    return this.methodDescription;
                }

                public Sort getSort() {
                    return Sort.SKIPPED;
                }

                public Visibility getVisibility() {
                    return this.methodDescription.getVisibility();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                }

                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    MethodDescription methodDescription2 = this.methodDescription;
                    return new ForDefinedMethod.WithBody(methodDescription2, new ByteCodeAppender.Compound(byteCodeAppender, new ByteCodeAppender.Simple(DefaultValue.of(methodDescription2.getReturnType()), MethodReturn.of(this.methodDescription.getReturnType()))));
                }
            }

            public enum Sort {
                SKIPPED(false, false),
                DEFINED(true, false),
                IMPLEMENTED(true, true);
                
                private final boolean define;
                private final boolean implement;

                private Sort(boolean z10, boolean z11) {
                    this.define = z10;
                    this.implement = z11;
                }

                public boolean isDefined() {
                    return this.define;
                }

                public boolean isImplemented() {
                    return this.implement;
                }
            }

            void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory);

            void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context);

            void applyHead(MethodVisitor methodVisitor);

            MethodDescription getMethod();

            Sort getSort();

            Visibility getVisibility();

            Record prepend(ByteCodeAppender byteCodeAppender);
        }

        Record target(MethodDescription methodDescription);
    }

    DynamicType.Unloaded<T> make(TypeResolutionStrategy.Resolved resolved);

    ContextClassVisitor wrap(ClassVisitor classVisitor, int i10, int i11);

    public interface RecordComponentPool {

        public enum Disabled implements RecordComponentPool {
            INSTANCE;

            public Record target(RecordComponentDescription recordComponentDescription) {
                throw new IllegalStateException("Cannot look up record component from disabled pool");
            }
        }

        Record target(RecordComponentDescription recordComponentDescription);

        public interface Record {
            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory);

            RecordComponentDescription getRecordComponent();

            RecordComponentAttributeAppender getRecordComponentAppender();

            boolean isImplicit();

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitRecordComponent implements Record {
                private final RecordComponentAttributeAppender attributeAppender;
                private final RecordComponentDescription recordComponentDescription;

                public ForExplicitRecordComponent(RecordComponentAttributeAppender recordComponentAttributeAppender, RecordComponentDescription recordComponentDescription2) {
                    this.attributeAppender = recordComponentAttributeAppender;
                    this.recordComponentDescription = recordComponentDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (visitRecordComponent != null) {
                        RecordComponentAttributeAppender recordComponentAttributeAppender = this.attributeAppender;
                        RecordComponentDescription recordComponentDescription2 = this.recordComponentDescription;
                        recordComponentAttributeAppender.apply(visitRecordComponent, recordComponentDescription2, factory.on(recordComponentDescription2));
                        visitRecordComponent.visitEnd();
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForExplicitRecordComponent forExplicitRecordComponent = (ForExplicitRecordComponent) obj;
                    return this.attributeAppender.equals(forExplicitRecordComponent.attributeAppender) && this.recordComponentDescription.equals(forExplicitRecordComponent.recordComponentDescription);
                }

                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    return this.attributeAppender;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.attributeAppender.hashCode()) * 31) + this.recordComponentDescription.hashCode();
                }

                public boolean isImplicit() {
                    return false;
                }

                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentAttributeAppender recordComponentAttributeAppender = this.attributeAppender;
                    RecordComponentDescription recordComponentDescription2 = this.recordComponentDescription;
                    recordComponentAttributeAppender.apply(recordComponentVisitor, recordComponentDescription2, factory.on(recordComponentDescription2));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForImplicitRecordComponent implements Record {
                private final RecordComponentDescription recordComponentDescription;

                public ForImplicitRecordComponent(RecordComponentDescription recordComponentDescription2) {
                    this.recordComponentDescription = recordComponentDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (visitRecordComponent != null) {
                        RecordComponentAttributeAppender.ForInstrumentedRecordComponent forInstrumentedRecordComponent = RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE;
                        RecordComponentDescription recordComponentDescription2 = this.recordComponentDescription;
                        forInstrumentedRecordComponent.apply(visitRecordComponent, recordComponentDescription2, factory.on(recordComponentDescription2));
                        visitRecordComponent.visitEnd();
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.recordComponentDescription.equals(((ForImplicitRecordComponent) obj).recordComponentDescription);
                }

                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.recordComponentDescription.hashCode();
                }

                public boolean isImplicit() {
                    return true;
                }

                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }
        }
    }

    public interface FieldPool {

        public enum Disabled implements FieldPool {
            INSTANCE;

            public Record target(FieldDescription fieldDescription) {
                throw new IllegalStateException("Cannot look up field from disabled pool");
            }
        }

        Record target(FieldDescription fieldDescription);

        public interface Record {
            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory);

            FieldDescription getField();

            FieldAttributeAppender getFieldAppender();

            boolean isImplicit();

            @MaybeNull
            Object resolveDefault(@MaybeNull Object obj);

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitField implements Record {
                private final FieldAttributeAppender attributeAppender;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final Object defaultValue;
                private final FieldDescription fieldDescription;

                public ForExplicitField(FieldAttributeAppender fieldAttributeAppender, @MaybeNull Object obj, FieldDescription fieldDescription2) {
                    this.attributeAppender = fieldAttributeAppender;
                    this.defaultValue = obj;
                    this.fieldDescription = fieldDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    FieldVisitor visitField = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), resolveDefault(FieldDescription.NO_DEFAULT_VALUE));
                    if (visitField != null) {
                        FieldAttributeAppender fieldAttributeAppender = this.attributeAppender;
                        FieldDescription fieldDescription2 = this.fieldDescription;
                        fieldAttributeAppender.apply(visitField, fieldDescription2, factory.on(fieldDescription2));
                        visitField.visitEnd();
                    }
                }

                /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
                    if (r2 != null) goto L_0x0031;
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
                        net.bytebuddy.implementation.attribute.FieldAttributeAppender r2 = r4.attributeAppender
                        net.bytebuddy.dynamic.scaffold.TypeWriter$FieldPool$Record$ForExplicitField r5 = (net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record.ForExplicitField) r5
                        net.bytebuddy.implementation.attribute.FieldAttributeAppender r3 = r5.attributeAppender
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0020
                        return r1
                    L_0x0020:
                        java.lang.Object r2 = r4.defaultValue
                        java.lang.Object r3 = r5.defaultValue
                        if (r3 == 0) goto L_0x002f
                        if (r2 == 0) goto L_0x0031
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0032
                        return r1
                    L_0x002f:
                        if (r2 == 0) goto L_0x0032
                    L_0x0031:
                        return r1
                    L_0x0032:
                        net.bytebuddy.description.field.FieldDescription r2 = r4.fieldDescription
                        net.bytebuddy.description.field.FieldDescription r5 = r5.fieldDescription
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x003d
                        return r1
                    L_0x003d:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record.ForExplicitField.equals(java.lang.Object):boolean");
                }

                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                public FieldAttributeAppender getFieldAppender() {
                    return this.attributeAppender;
                }

                public int hashCode() {
                    int hashCode = ((getClass().hashCode() * 31) + this.attributeAppender.hashCode()) * 31;
                    Object obj = this.defaultValue;
                    if (obj != null) {
                        hashCode += obj.hashCode();
                    }
                    return (hashCode * 31) + this.fieldDescription.hashCode();
                }

                public boolean isImplicit() {
                    return false;
                }

                @MaybeNull
                public Object resolveDefault(@MaybeNull Object obj) {
                    Object obj2 = this.defaultValue;
                    return obj2 == null ? obj : obj2;
                }

                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory) {
                    FieldAttributeAppender fieldAttributeAppender = this.attributeAppender;
                    FieldDescription fieldDescription2 = this.fieldDescription;
                    fieldAttributeAppender.apply(fieldVisitor, fieldDescription2, factory.on(fieldDescription2));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForImplicitField implements Record {
                private final FieldDescription fieldDescription;

                public ForImplicitField(FieldDescription fieldDescription2) {
                    this.fieldDescription = fieldDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    FieldVisitor visitField = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (visitField != null) {
                        FieldAttributeAppender.ForInstrumentedField forInstrumentedField = FieldAttributeAppender.ForInstrumentedField.INSTANCE;
                        FieldDescription fieldDescription2 = this.fieldDescription;
                        forInstrumentedField.apply(visitField, fieldDescription2, factory.on(fieldDescription2));
                        visitField.visitEnd();
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForImplicitField) obj).fieldDescription);
                }

                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                public FieldAttributeAppender getFieldAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public boolean isImplicit() {
                    return true;
                }

                public Object resolveDefault(@MaybeNull Object obj) {
                    throw new IllegalStateException("An implicit field record does not expose a default value: " + this);
                }

                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }
        }
    }
}
