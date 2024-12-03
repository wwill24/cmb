package net.bytebuddy.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface Implementation extends InstrumentedType.Prepareable {

    public interface Composable extends Implementation {
        Composable andThen(Composable composable);

        Implementation andThen(Implementation implementation);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements Implementation {
        /* access modifiers changed from: private */
        public final List<Implementation> implementations;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Composable implements Composable {
            /* access modifiers changed from: private */
            public final Composable composable;
            /* access modifiers changed from: private */
            public final List<Implementation> implementations;

            public Composable(Implementation implementation, Composable composable2) {
                this((List<? extends Implementation>) Collections.singletonList(implementation), composable2);
            }

            public Implementation andThen(Implementation implementation) {
                return new Compound((List<? extends Implementation>) CompoundList.of(this.implementations, this.composable.andThen(implementation)));
            }

            public ByteCodeAppender appender(Target target) {
                ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[(this.implementations.size() + 1)];
                int i10 = 0;
                for (Implementation appender : this.implementations) {
                    byteCodeAppenderArr[i10] = appender.appender(target);
                    i10++;
                }
                byteCodeAppenderArr[i10] = this.composable.appender(target);
                return new ByteCodeAppender.Compound(byteCodeAppenderArr);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Composable composable2 = (Composable) obj;
                return this.composable.equals(composable2.composable) && this.implementations.equals(composable2.implementations);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.composable.hashCode()) * 31) + this.implementations.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                for (Implementation prepare : this.implementations) {
                    instrumentedType = prepare.prepare(instrumentedType);
                }
                return this.composable.prepare(instrumentedType);
            }

            public Composable(List<? extends Implementation> list, Composable composable2) {
                this.implementations = new ArrayList();
                for (Implementation implementation : list) {
                    if (implementation instanceof Composable) {
                        Composable composable3 = (Composable) implementation;
                        this.implementations.addAll(composable3.implementations);
                        this.implementations.add(composable3.composable);
                    } else if (implementation instanceof Compound) {
                        this.implementations.addAll(((Compound) implementation).implementations);
                    } else {
                        this.implementations.add(implementation);
                    }
                }
                if (composable2 instanceof Composable) {
                    Composable composable4 = (Composable) composable2;
                    this.implementations.addAll(composable4.implementations);
                    this.composable = composable4.composable;
                    return;
                }
                this.composable = composable2;
            }

            public Composable andThen(Composable composable2) {
                return new Composable((List<? extends Implementation>) this.implementations, this.composable.andThen(composable2));
            }
        }

        public Compound(Implementation... implementationArr) {
            this((List<? extends Implementation>) Arrays.asList(implementationArr));
        }

        public ByteCodeAppender appender(Target target) {
            ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[this.implementations.size()];
            int i10 = 0;
            for (Implementation appender : this.implementations) {
                byteCodeAppenderArr[i10] = appender.appender(target);
                i10++;
            }
            return new ByteCodeAppender.Compound(byteCodeAppenderArr);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.implementations.equals(((Compound) obj).implementations);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.implementations.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (Implementation prepare : this.implementations) {
                instrumentedType = prepare.prepare(instrumentedType);
            }
            return instrumentedType;
        }

        public Compound(List<? extends Implementation> list) {
            this.implementations = new ArrayList();
            for (Implementation implementation : list) {
                if (implementation instanceof Composable) {
                    Composable composable = (Composable) implementation;
                    this.implementations.addAll(composable.implementations);
                    this.implementations.add(composable.composable);
                } else if (implementation instanceof Compound) {
                    this.implementations.addAll(((Compound) implementation).implementations);
                } else {
                    this.implementations.add(implementation);
                }
            }
        }
    }

    public interface Context extends MethodAccessorFactory {

        public static class Default extends ExtractableView.AbstractBase {
            public static final String ACCESSOR_METHOD_SUFFIX = "accessor";
            public static final String FIELD_CACHE_PREFIX = "cachedValue";
            private final ClassFileVersion auxiliaryClassFileVersion;
            private final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
            private final Map<AuxiliaryType, DynamicType> auxiliaryTypes = new HashMap();
            private boolean fieldCacheCanAppendEntries = true;
            private final Map<SpecialMethodInvocation, DelegationRecord> registeredAccessorMethods = new HashMap();
            private final Map<FieldCacheEntry, FieldDescription.InDefinedShape> registeredFieldCacheEntries = new HashMap();
            private final Set<FieldDescription.InDefinedShape> registeredFieldCacheFields = new HashSet();
            private final Map<FieldDescription, DelegationRecord> registeredGetters = new HashMap();
            private final Map<FieldDescription, DelegationRecord> registeredSetters = new HashMap();
            private final String suffix;
            private final TypeInitializer typeInitializer;

            protected static abstract class AbstractPropertyAccessorMethod extends MethodDescription.InDefinedShape.AbstractBase {
                protected AbstractPropertyAccessorMethod() {
                }

                /* access modifiers changed from: protected */
                public abstract int getBaseModifiers();

                public int getModifiers() {
                    return getBaseModifiers() | Opcodes.ACC_SYNTHETIC | (getDeclaringType().isInterface() ? 1 : 16);
                }
            }

            protected static class AccessorMethod extends AbstractPropertyAccessorMethod {
                private final TypeDescription instrumentedType;
                private final MethodDescription methodDescription;
                private final String name;

                protected AccessorMethod(TypeDescription typeDescription, MethodDescription methodDescription2, TypeDescription typeDescription2, String str) {
                    String str2;
                    this.instrumentedType = typeDescription;
                    this.methodDescription = methodDescription2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(methodDescription2.getInternalName());
                    sb2.append("$");
                    sb2.append(Default.ACCESSOR_METHOD_SUFFIX);
                    sb2.append("$");
                    sb2.append(str);
                    if (typeDescription2.isInterface()) {
                        str2 = "$" + RandomString.hashOf(typeDescription2.hashCode());
                    } else {
                        str2 = "";
                    }
                    sb2.append(str2);
                    this.name = sb2.toString();
                }

                /* access modifiers changed from: protected */
                public int getBaseModifiers() {
                    return this.methodDescription.isStatic() ? 8 : 0;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @MaybeNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                public String getInternalName() {
                    return this.name;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.methodDescription.getParameters().asTypeList().asRawTypes());
                }

                public TypeDescription.Generic getReturnType() {
                    return this.methodDescription.getReturnType().asRawType();
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            protected static class CacheValueField extends FieldDescription.InDefinedShape.AbstractBase {
                private final TypeDescription.Generic fieldType;
                private final TypeDescription instrumentedType;
                private final String name;

                protected CacheValueField(TypeDescription typeDescription, TypeDescription.Generic generic, String str, int i10) {
                    this.instrumentedType = typeDescription;
                    this.fieldType = generic;
                    this.name = "cachedValue$" + str + "$" + RandomString.hashOf(i10);
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public int getModifiers() {
                    return (this.instrumentedType.isInterface() ? 1 : 2) | 4120;
                }

                public String getName() {
                    return this.name;
                }

                public TypeDescription.Generic getType() {
                    return this.fieldType;
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static abstract class DelegationRecord extends TypeWriter.MethodPool.Record.ForDefinedMethod implements ByteCodeAppender {
                protected final MethodDescription.InDefinedShape methodDescription;
                protected final Visibility visibility;

                protected DelegationRecord(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility2) {
                    this.methodDescription = inDefinedShape;
                    this.visibility = visibility2;
                }

                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                }

                public void applyBody(MethodVisitor methodVisitor, Context context, AnnotationValueFilter.Factory factory) {
                    methodVisitor.visitCode();
                    ByteCodeAppender.Size applyCode = applyCode(methodVisitor, context);
                    methodVisitor.visitMaxs(applyCode.getOperandStackSize(), applyCode.getLocalVariableSize());
                }

                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Context context) {
                    return apply(methodVisitor, context, getMethod());
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
                    DelegationRecord delegationRecord = (DelegationRecord) obj;
                    return this.visibility.equals(delegationRecord.visibility) && this.methodDescription.equals(delegationRecord.methodDescription);
                }

                public TypeWriter.MethodPool.Record.Sort getSort() {
                    return TypeWriter.MethodPool.Record.Sort.IMPLEMENTED;
                }

                public Visibility getVisibility() {
                    return this.visibility;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.visibility.hashCode();
                }

                public TypeWriter.MethodPool.Record prepend(ByteCodeAppender byteCodeAppender) {
                    throw new UnsupportedOperationException("Cannot prepend code to a delegation for " + this.methodDescription);
                }

                /* access modifiers changed from: protected */
                public abstract DelegationRecord with(MethodAccessorFactory.AccessType accessType);

                public MethodDescription.InDefinedShape getMethod() {
                    return this.methodDescription;
                }
            }

            protected static class FieldCacheEntry implements StackManipulation {
                private final TypeDescription fieldType;
                private final StackManipulation fieldValue;

                protected FieldCacheEntry(StackManipulation stackManipulation, TypeDescription typeDescription) {
                    this.fieldValue = stackManipulation;
                    this.fieldType = typeDescription;
                }

                public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                    return this.fieldValue.apply(methodVisitor, context);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    FieldCacheEntry fieldCacheEntry = (FieldCacheEntry) obj;
                    if (!this.fieldValue.equals(fieldCacheEntry.fieldValue) || !this.fieldType.equals(fieldCacheEntry.fieldType)) {
                        return false;
                    }
                    return true;
                }

                /* access modifiers changed from: protected */
                public TypeDescription getFieldType() {
                    return this.fieldType;
                }

                public int hashCode() {
                    return (this.fieldValue.hashCode() * 31) + this.fieldType.hashCode();
                }

                public boolean isValid() {
                    return this.fieldValue.isValid();
                }

                /* access modifiers changed from: protected */
                public ByteCodeAppender storeIn(FieldDescription fieldDescription) {
                    return new ByteCodeAppender.Simple(this, FieldAccess.forField(fieldDescription).write());
                }
            }

            protected static class FieldGetter extends AbstractPropertyAccessorMethod {
                private final FieldDescription fieldDescription;
                private final TypeDescription instrumentedType;
                private final String name;

                protected FieldGetter(TypeDescription typeDescription, FieldDescription fieldDescription2, String str) {
                    this.instrumentedType = typeDescription;
                    this.fieldDescription = fieldDescription2;
                    this.name = fieldDescription2.getName() + "$" + Default.ACCESSOR_METHOD_SUFFIX + "$" + str;
                }

                /* access modifiers changed from: protected */
                public int getBaseModifiers() {
                    return this.fieldDescription.isStatic() ? 8 : 0;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @MaybeNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return new TypeList.Generic.Empty();
                }

                public String getInternalName() {
                    return this.name;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Empty();
                }

                public TypeDescription.Generic getReturnType() {
                    return this.fieldDescription.getType().asRawType();
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class FieldGetterDelegation extends DelegationRecord {
                private final FieldDescription fieldDescription;

                protected FieldGetterDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, FieldDescription fieldDescription2) {
                    this(new FieldGetter(typeDescription, fieldDescription2, str), accessType.getVisibility(), fieldDescription2);
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    StackManipulation stackManipulation;
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (this.fieldDescription.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(this.fieldDescription).read();
                    stackManipulationArr[2] = MethodReturn.of(this.fieldDescription.getType());
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldGetterDelegation) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }

                /* access modifiers changed from: protected */
                public DelegationRecord with(MethodAccessorFactory.AccessType accessType) {
                    return new FieldGetterDelegation(this.methodDescription, this.visibility.expandTo(accessType.getVisibility()), this.fieldDescription);
                }

                private FieldGetterDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, FieldDescription fieldDescription2) {
                    super(inDefinedShape, visibility);
                    this.fieldDescription = fieldDescription2;
                }
            }

            protected static class FieldSetter extends AbstractPropertyAccessorMethod {
                private final FieldDescription fieldDescription;
                private final TypeDescription instrumentedType;
                private final String name;

                protected FieldSetter(TypeDescription typeDescription, FieldDescription fieldDescription2, String str) {
                    this.instrumentedType = typeDescription;
                    this.fieldDescription = fieldDescription2;
                    this.name = fieldDescription2.getName() + "$" + Default.ACCESSOR_METHOD_SUFFIX + "$" + str;
                }

                /* access modifiers changed from: protected */
                public int getBaseModifiers() {
                    return this.fieldDescription.isStatic() ? 8 : 0;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @MaybeNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return new TypeList.Generic.Empty();
                }

                public String getInternalName() {
                    return this.name;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) Collections.singletonList(this.fieldDescription.getType().asRawType()));
                }

                public TypeDescription.Generic getReturnType() {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class FieldSetterDelegation extends DelegationRecord {
                private final FieldDescription fieldDescription;

                protected FieldSetterDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, FieldDescription fieldDescription2) {
                    this(new FieldSetter(typeDescription, fieldDescription2, str), accessType.getVisibility(), fieldDescription2);
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldSetterDelegation) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }

                /* access modifiers changed from: protected */
                public DelegationRecord with(MethodAccessorFactory.AccessType accessType) {
                    return new FieldSetterDelegation(this.methodDescription, this.visibility.expandTo(accessType.getVisibility()), this.fieldDescription);
                }

                private FieldSetterDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, FieldDescription fieldDescription2) {
                    super(inDefinedShape, visibility);
                    this.fieldDescription = fieldDescription2;
                }
            }

            protected Default(TypeDescription typeDescription, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer2, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration, String str) {
                super(typeDescription, classFileVersion, frameGeneration);
                this.auxiliaryTypeNamingStrategy = namingStrategy;
                this.typeInitializer = typeInitializer2;
                this.auxiliaryClassFileVersion = classFileVersion2;
                this.suffix = str;
            }

            public FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription) {
                FieldCacheEntry fieldCacheEntry = new FieldCacheEntry(stackManipulation, typeDescription);
                FieldDescription.InDefinedShape inDefinedShape = this.registeredFieldCacheEntries.get(fieldCacheEntry);
                if (inDefinedShape != null) {
                    return inDefinedShape;
                }
                if (this.fieldCacheCanAppendEntries) {
                    int hashCode = stackManipulation.hashCode();
                    while (true) {
                        int i10 = hashCode + 1;
                        CacheValueField cacheValueField = new CacheValueField(this.instrumentedType, typeDescription.asGenericType(), this.suffix, hashCode);
                        if (this.registeredFieldCacheFields.add(cacheValueField)) {
                            this.registeredFieldCacheEntries.put(fieldCacheEntry, cacheValueField);
                            return cacheValueField;
                        }
                        hashCode = i10;
                    }
                } else {
                    throw new IllegalStateException("Cached values cannot be registered after defining the type initializer for " + this.instrumentedType);
                }
            }

            public void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                this.fieldCacheCanAppendEntries = false;
                TypeInitializer typeInitializer2 = this.typeInitializer;
                for (Map.Entry next : this.registeredFieldCacheEntries.entrySet()) {
                    FieldVisitor visitField = classVisitor.visitField(((FieldDescription.InDefinedShape) next.getValue()).getModifiers(), ((FieldDescription.InDefinedShape) next.getValue()).getInternalName(), ((FieldDescription.InDefinedShape) next.getValue()).getDescriptor(), ((FieldDescription.InDefinedShape) next.getValue()).getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (visitField != null) {
                        visitField.visitEnd();
                        typeInitializer2 = typeInitializer2.expandWith(((FieldCacheEntry) next.getKey()).storeIn((FieldDescription) next.getValue()));
                    }
                }
                drain.apply(classVisitor, typeInitializer2, this);
                for (DelegationRecord apply : this.registeredAccessorMethods.values()) {
                    apply.apply(classVisitor, this, factory);
                }
                for (DelegationRecord apply2 : this.registeredGetters.values()) {
                    apply2.apply(classVisitor, this, factory);
                }
                for (DelegationRecord apply3 : this.registeredSetters.values()) {
                    apply3.apply(classVisitor, this, factory);
                }
            }

            public List<DynamicType> getAuxiliaryTypes() {
                return new ArrayList(this.auxiliaryTypes.values());
            }

            public boolean isEnabled() {
                return true;
            }

            public TypeDescription register(AuxiliaryType auxiliaryType) {
                DynamicType dynamicType = this.auxiliaryTypes.get(auxiliaryType);
                if (dynamicType == null) {
                    dynamicType = auxiliaryType.make(this.auxiliaryTypeNamingStrategy.name(this.instrumentedType, auxiliaryType), this.auxiliaryClassFileVersion, this);
                    this.auxiliaryTypes.put(auxiliaryType, dynamicType);
                }
                return dynamicType.getTypeDescription();
            }

            public MethodDescription.InDefinedShape registerAccessorFor(SpecialMethodInvocation specialMethodInvocation, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord;
                DelegationRecord delegationRecord2 = this.registeredAccessorMethods.get(specialMethodInvocation);
                if (delegationRecord2 == null) {
                    delegationRecord = new AccessorMethodDelegation(this.instrumentedType, this.suffix, accessType, specialMethodInvocation);
                } else {
                    delegationRecord = delegationRecord2.with(accessType);
                }
                this.registeredAccessorMethods.put(specialMethodInvocation, delegationRecord);
                return delegationRecord.getMethod();
            }

            public MethodDescription.InDefinedShape registerGetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord;
                DelegationRecord delegationRecord2 = this.registeredGetters.get(fieldDescription);
                if (delegationRecord2 == null) {
                    delegationRecord = new FieldGetterDelegation(this.instrumentedType, this.suffix, accessType, fieldDescription);
                } else {
                    delegationRecord = delegationRecord2.with(accessType);
                }
                this.registeredGetters.put(fieldDescription, delegationRecord);
                return delegationRecord.getMethod();
            }

            public MethodDescription.InDefinedShape registerSetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord;
                DelegationRecord delegationRecord2 = this.registeredSetters.get(fieldDescription);
                if (delegationRecord2 == null) {
                    delegationRecord = new FieldSetterDelegation(this.instrumentedType, this.suffix, accessType, fieldDescription);
                } else {
                    delegationRecord = delegationRecord2.with(accessType);
                }
                this.registeredSetters.put(fieldDescription, delegationRecord);
                return delegationRecord.getMethod();
            }

            public enum Factory implements Factory {
                INSTANCE;

                @Deprecated
                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                    return make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion2, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6) ? FrameGeneration.GENERATE : FrameGeneration.DISABLED);
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithFixedSuffix implements Factory {
                    private final String suffix;

                    public WithFixedSuffix(String str) {
                        this.suffix = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.suffix.equals(((WithFixedSuffix) obj).suffix);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.suffix.hashCode();
                    }

                    @Deprecated
                    public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                        return make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion2, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6) ? FrameGeneration.GENERATE : FrameGeneration.DISABLED);
                    }

                    public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration) {
                        return new Default(typeDescription, classFileVersion, namingStrategy, typeInitializer, classFileVersion2, frameGeneration, this.suffix);
                    }
                }

                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration) {
                    return new Default(typeDescription, classFileVersion, namingStrategy, typeInitializer, classFileVersion2, frameGeneration, RandomString.make());
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class AccessorMethodDelegation extends DelegationRecord {
                private final StackManipulation accessorMethodInvocation;

                protected AccessorMethodDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, SpecialMethodInvocation specialMethodInvocation) {
                    this(new AccessorMethod(typeDescription, specialMethodInvocation.getMethodDescription(), specialMethodInvocation.getTypeDescription(), str), accessType.getVisibility(), specialMethodInvocation);
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), this.accessorMethodInvocation, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.accessorMethodInvocation.equals(((AccessorMethodDelegation) obj).accessorMethodInvocation);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.accessorMethodInvocation.hashCode();
                }

                /* access modifiers changed from: protected */
                public DelegationRecord with(MethodAccessorFactory.AccessType accessType) {
                    return new AccessorMethodDelegation(this.methodDescription, this.visibility.expandTo(accessType.getVisibility()), this.accessorMethodInvocation);
                }

                private AccessorMethodDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, StackManipulation stackManipulation) {
                    super(inDefinedShape, visibility);
                    this.accessorMethodInvocation = stackManipulation;
                }
            }
        }

        public interface ExtractableView extends Context {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements ExtractableView {
                protected final ClassFileVersion classFileVersion;
                protected final FrameGeneration frameGeneration;
                protected final TypeDescription instrumentedType;

                protected AbstractBase(TypeDescription typeDescription, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration2) {
                    this.instrumentedType = typeDescription;
                    this.classFileVersion = classFileVersion2;
                    this.frameGeneration = frameGeneration2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.frameGeneration.equals(abstractBase.frameGeneration) && this.instrumentedType.equals(abstractBase.instrumentedType) && this.classFileVersion.equals(abstractBase.classFileVersion);
                }

                public ClassFileVersion getClassFileVersion() {
                    return this.classFileVersion;
                }

                public FrameGeneration getFrameGeneration() {
                    return this.frameGeneration;
                }

                public TypeDescription getInstrumentedType() {
                    return this.instrumentedType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.classFileVersion.hashCode()) * 31) + this.frameGeneration.hashCode();
                }
            }

            void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            List<DynamicType> getAuxiliaryTypes();

            boolean isEnabled();
        }

        public interface Factory {
            @Deprecated
            ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2);

            ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration);
        }

        public enum FrameGeneration {
            GENERATE(true) {
                public void generate(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2, int i13, @MaybeNull Object[] objArr3) {
                    methodVisitor.visitFrame(i10, i12, objArr2, i11, objArr);
                }
            },
            EXPAND(true) {
                public void generate(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2, int i13, @MaybeNull Object[] objArr3) {
                    methodVisitor.visitFrame(-1, i13, objArr3, i11, objArr);
                }
            },
            DISABLED(false) {
                public void generate(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2, int i13, @MaybeNull Object[] objArr3) {
                }
            };
            
            private static final Object[] EMPTY = null;
            private final boolean active;

            static {
                EMPTY = new Object[0];
            }

            private static Object toStackMapFrame(TypeDefinition typeDefinition) {
                if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                    return Opcodes.INTEGER;
                }
                if (typeDefinition.represents(Long.TYPE)) {
                    return Opcodes.LONG;
                }
                if (typeDefinition.represents(Float.TYPE)) {
                    return Opcodes.FLOAT;
                }
                if (typeDefinition.represents(Double.TYPE)) {
                    return Opcodes.DOUBLE;
                }
                return typeDefinition.asErasure().getInternalName();
            }

            private static Object[] toStackMapFrames(List<? extends TypeDefinition> list) {
                Object[] objArr;
                if (list.isEmpty()) {
                    objArr = EMPTY;
                } else {
                    objArr = new Object[list.size()];
                }
                for (int i10 = 0; i10 < list.size(); i10++) {
                    objArr[i10] = toStackMapFrame((TypeDefinition) list.get(i10));
                }
                return objArr;
            }

            public void append(MethodVisitor methodVisitor, List<? extends TypeDefinition> list, List<? extends TypeDefinition> list2) {
                Object[] objArr = EMPTY;
                generate(methodVisitor, 1, objArr.length, objArr, list.size(), toStackMapFrames(list), list2.size() + list.size(), toStackMapFrames(CompoundList.of(list2, list)));
            }

            public void chop(MethodVisitor methodVisitor, int i10, List<? extends TypeDefinition> list) {
                Object[] objArr = EMPTY;
                generate(methodVisitor, 2, objArr.length, objArr, i10, objArr, list.size(), toStackMapFrames(list));
            }

            public void full(MethodVisitor methodVisitor, List<? extends TypeDefinition> list, List<? extends TypeDefinition> list2) {
                generate(methodVisitor, 0, list.size(), toStackMapFrames(list), list2.size(), toStackMapFrames(list2), list2.size(), toStackMapFrames(list2));
            }

            /* access modifiers changed from: protected */
            public abstract void generate(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2, int i13, @MaybeNull Object[] objArr3);

            public boolean isActive() {
                return this.active;
            }

            public void same(MethodVisitor methodVisitor, List<? extends TypeDefinition> list) {
                Object[] objArr = EMPTY;
                generate(methodVisitor, 3, objArr.length, objArr, objArr.length, objArr, list.size(), toStackMapFrames(list));
            }

            public void same1(MethodVisitor methodVisitor, TypeDefinition typeDefinition, List<? extends TypeDefinition> list) {
                Object[] objArr = {toStackMapFrame(typeDefinition)};
                Object[] objArr2 = EMPTY;
                generate(methodVisitor, 4, 1, objArr, objArr2.length, objArr2, list.size(), toStackMapFrames(list));
            }

            private FrameGeneration(boolean z10) {
                this.active = z10;
            }
        }

        FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription);

        ClassFileVersion getClassFileVersion();

        FrameGeneration getFrameGeneration();

        TypeDescription getInstrumentedType();

        TypeDescription register(AuxiliaryType auxiliaryType);

        public static class Disabled extends ExtractableView.AbstractBase {
            protected Disabled(TypeDescription typeDescription, ClassFileVersion classFileVersion, FrameGeneration frameGeneration) {
                super(typeDescription, classFileVersion, frameGeneration);
            }

            public FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription) {
                throw new IllegalStateException("Field values caching was disabled: " + typeDescription);
            }

            public void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                drain.apply(classVisitor, TypeInitializer.None.INSTANCE, this);
            }

            public List<DynamicType> getAuxiliaryTypes() {
                return Collections.emptyList();
            }

            public boolean isEnabled() {
                return false;
            }

            public TypeDescription register(AuxiliaryType auxiliaryType) {
                throw new IllegalStateException("Registration of auxiliary types was disabled: " + auxiliaryType);
            }

            public MethodDescription.InDefinedShape registerAccessorFor(SpecialMethodInvocation specialMethodInvocation, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of method accessors was disabled: " + specialMethodInvocation.getMethodDescription());
            }

            public MethodDescription.InDefinedShape registerGetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of field accessor was disabled: " + fieldDescription);
            }

            public MethodDescription.InDefinedShape registerSetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of field accessor was disabled: " + fieldDescription);
            }

            public enum Factory implements Factory {
                INSTANCE;

                @Deprecated
                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                    return make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion2, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6) ? FrameGeneration.GENERATE : FrameGeneration.DISABLED);
                }

                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration) {
                    if (!typeInitializer.isDefined()) {
                        return new Disabled(typeDescription, classFileVersion, frameGeneration);
                    }
                    throw new IllegalStateException("Cannot define type initializer which was explicitly disabled: " + typeInitializer);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements Implementation {
        private static final int NO_ADDITIONAL_VARIABLES = 0;
        private final ByteCodeAppender byteCodeAppender;

        public interface Dispatcher {
            StackManipulation apply(Target target, MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ForDispatcher implements Implementation {
            /* access modifiers changed from: private */
            public final int additionalVariableLength;
            /* access modifiers changed from: private */
            public final Dispatcher dispatcher;
            private final InstrumentedType.Prepareable prepareable;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class Appender implements ByteCodeAppender {
                private final Target implementationTarget;

                protected Appender(Target target) {
                    this.implementationTarget = target;
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(ForDispatcher.this.dispatcher.apply(this.implementationTarget, methodDescription).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize() + ForDispatcher.this.additionalVariableLength);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Appender appender = (Appender) obj;
                    return this.implementationTarget.equals(appender.implementationTarget) && ForDispatcher.this.equals(ForDispatcher.this);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.implementationTarget.hashCode()) * 31) + ForDispatcher.this.hashCode();
                }
            }

            protected ForDispatcher(Dispatcher dispatcher2, InstrumentedType.Prepareable prepareable2, int i10) {
                this.dispatcher = dispatcher2;
                this.prepareable = prepareable2;
                this.additionalVariableLength = i10;
            }

            public ByteCodeAppender appender(Target target) {
                return new Appender(target);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDispatcher forDispatcher = (ForDispatcher) obj;
                return this.additionalVariableLength == forDispatcher.additionalVariableLength && this.dispatcher.equals(forDispatcher.dispatcher) && this.prepareable.equals(forDispatcher.prepareable);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.dispatcher.hashCode()) * 31) + this.prepareable.hashCode()) * 31) + this.additionalVariableLength;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return this.prepareable.prepare(instrumentedType);
            }
        }

        public Simple(ByteCodeAppender... byteCodeAppenderArr) {
            this.byteCodeAppender = new ByteCodeAppender.Compound(byteCodeAppenderArr);
        }

        public static Implementation of(Dispatcher dispatcher) {
            return of(dispatcher, 0);
        }

        public ByteCodeAppender appender(Target target) {
            return this.byteCodeAppender;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Simple) obj).byteCodeAppender);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.byteCodeAppender.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public static Implementation of(Dispatcher dispatcher, int i10) {
            return of(dispatcher, InstrumentedType.Prepareable.NoOp.INSTANCE, i10);
        }

        public Simple(StackManipulation... stackManipulationArr) {
            this.byteCodeAppender = new ByteCodeAppender.Simple(stackManipulationArr);
        }

        public static Implementation of(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable) {
            return of(dispatcher, prepareable, 0);
        }

        public static Implementation of(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable, int i10) {
            if (i10 >= 0) {
                return new ForDispatcher(dispatcher, prepareable, i10);
            }
            throw new IllegalArgumentException("Additional variable length cannot be negative: " + i10);
        }
    }

    public interface SpecialMethodInvocation extends StackManipulation {

        public static abstract class AbstractBase extends StackManipulation.AbstractBase implements SpecialMethodInvocation {
            private transient /* synthetic */ int hashCode;

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SpecialMethodInvocation)) {
                    return false;
                }
                SpecialMethodInvocation specialMethodInvocation = (SpecialMethodInvocation) obj;
                if (!getMethodDescription().asSignatureToken().equals(specialMethodInvocation.getMethodDescription().asSignatureToken()) || !getTypeDescription().equals(specialMethodInvocation.getTypeDescription())) {
                    return false;
                }
                return true;
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : (getMethodDescription().asSignatureToken().hashCode() * 31) + getTypeDescription().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }
        }

        public enum Illegal implements SpecialMethodInvocation {
            INSTANCE;

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                throw new IllegalStateException("Cannot implement an undefined method");
            }

            public MethodDescription getMethodDescription() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            public TypeDescription getTypeDescription() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            public boolean isValid() {
                return false;
            }

            public JavaConstant.MethodHandle toMethodHandle() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            public SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
                return this;
            }
        }

        public static class Simple extends AbstractBase {
            private final MethodDescription methodDescription;
            private final StackManipulation stackManipulation;
            private final TypeDescription typeDescription;

            protected Simple(MethodDescription methodDescription2, TypeDescription typeDescription2, StackManipulation stackManipulation2) {
                this.methodDescription = methodDescription2;
                this.typeDescription = typeDescription2;
                this.stackManipulation = stackManipulation2;
            }

            public static SpecialMethodInvocation of(MethodDescription methodDescription2, TypeDescription typeDescription2) {
                StackManipulation special = MethodInvocation.invoke(methodDescription2).special(typeDescription2);
                if (special.isValid()) {
                    return new Simple(methodDescription2, typeDescription2, special);
                }
                return Illegal.INSTANCE;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                return this.stackManipulation.apply(methodVisitor, context);
            }

            public MethodDescription getMethodDescription() {
                return this.methodDescription;
            }

            public TypeDescription getTypeDescription() {
                return this.typeDescription;
            }

            public JavaConstant.MethodHandle toMethodHandle() {
                return JavaConstant.MethodHandle.ofSpecial((MethodDescription.InDefinedShape) this.methodDescription.asDefined(), this.typeDescription);
            }

            public SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
                if (this.methodDescription.asTypeToken().equals(typeToken)) {
                    return this;
                }
                return Illegal.INSTANCE;
            }
        }

        MethodDescription getMethodDescription();

        TypeDescription getTypeDescription();

        JavaConstant.MethodHandle toMethodHandle();

        SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken);
    }

    ByteCodeAppender appender(Target target);

    public interface Target {

        public interface Factory {
            Target make(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion);
        }

        TypeDescription getInstrumentedType();

        TypeDefinition getOriginType();

        SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken);

        SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken, TypeDescription typeDescription);

        SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken signatureToken);

        SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken signatureToken);

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class AbstractBase implements Target {
            protected final DefaultMethodInvocation defaultMethodInvocation;
            protected final TypeDescription instrumentedType;
            protected final MethodGraph.Linked methodGraph;

            protected enum DefaultMethodInvocation {
                ENABLED {
                    /* access modifiers changed from: protected */
                    public SpecialMethodInvocation apply(MethodGraph.Node node, TypeDescription typeDescription) {
                        if (node.getSort().isUnique()) {
                            return SpecialMethodInvocation.Simple.of(node.getRepresentative(), typeDescription);
                        }
                        return SpecialMethodInvocation.Illegal.INSTANCE;
                    }
                },
                DISABLED {
                    /* access modifiers changed from: protected */
                    public SpecialMethodInvocation apply(MethodGraph.Node node, TypeDescription typeDescription) {
                        return SpecialMethodInvocation.Illegal.INSTANCE;
                    }
                };

                public static DefaultMethodInvocation of(ClassFileVersion classFileVersion) {
                    return classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? ENABLED : DISABLED;
                }

                /* access modifiers changed from: protected */
                public abstract SpecialMethodInvocation apply(MethodGraph.Node node, TypeDescription typeDescription);
            }

            protected AbstractBase(TypeDescription typeDescription, MethodGraph.Linked linked, DefaultMethodInvocation defaultMethodInvocation2) {
                this.instrumentedType = typeDescription;
                this.methodGraph = linked;
                this.defaultMethodInvocation = defaultMethodInvocation2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                AbstractBase abstractBase = (AbstractBase) obj;
                return this.defaultMethodInvocation.equals(abstractBase.defaultMethodInvocation) && this.instrumentedType.equals(abstractBase.instrumentedType) && this.methodGraph.equals(abstractBase.methodGraph);
            }

            public TypeDescription getInstrumentedType() {
                return this.instrumentedType;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.methodGraph.hashCode()) * 31) + this.defaultMethodInvocation.hashCode();
            }

            public SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken) {
                SpecialMethodInvocation specialMethodInvocation = SpecialMethodInvocation.Illegal.INSTANCE;
                for (TypeDescription invokeDefault : this.instrumentedType.getInterfaces().asErasures()) {
                    SpecialMethodInvocation withCheckedCompatibilityTo = invokeDefault(signatureToken, invokeDefault).withCheckedCompatibilityTo(signatureToken.asTypeToken());
                    if (withCheckedCompatibilityTo.isValid()) {
                        if (specialMethodInvocation.isValid()) {
                            return SpecialMethodInvocation.Illegal.INSTANCE;
                        }
                        specialMethodInvocation = withCheckedCompatibilityTo;
                    }
                }
                return specialMethodInvocation;
            }

            public SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken signatureToken) {
                SpecialMethodInvocation invokeSuper = invokeSuper(signatureToken);
                if (invokeSuper.isValid()) {
                    return invokeSuper;
                }
                return invokeDefault(signatureToken);
            }

            public SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken, TypeDescription typeDescription) {
                return this.defaultMethodInvocation.apply(this.methodGraph.getInterfaceGraph(typeDescription).locate(signatureToken), typeDescription);
            }
        }
    }
}
