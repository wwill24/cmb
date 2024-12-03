package net.bytebuddy.implementation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public abstract class FieldAccessor implements Implementation {
    protected final Assigner assigner;
    protected final FieldLocation fieldLocation;
    protected final Assigner.Typing typing;

    public interface AssignerConfigurable extends PropertyConfigurable {
        PropertyConfigurable withAssigner(Assigner assigner, Assigner.Typing typing);
    }

    protected interface FieldLocation {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Absolute implements FieldLocation, Prepared {
            private final FieldDescription fieldDescription;

            protected Absolute(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Absolute) obj).fieldDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public Prepared prepare(TypeDescription typeDescription) {
                if (!this.fieldDescription.isStatic() && !typeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) {
                    throw new IllegalStateException(this.fieldDescription + " is not declared by " + typeDescription);
                } else if (this.fieldDescription.isAccessibleTo(typeDescription)) {
                    return this;
                } else {
                    throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                }
            }

            public FieldDescription resolve(MethodDescription methodDescription) {
                return this.fieldDescription;
            }

            public FieldLocation with(FieldLocator.Factory factory) {
                throw new IllegalStateException("Cannot specify a field locator factory for an absolute field location");
            }
        }

        public interface Prepared {
            FieldDescription resolve(MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Relative implements FieldLocation {
            private final FieldLocator.Factory fieldLocatorFactory;
            private final FieldNameExtractor fieldNameExtractor;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Prepared implements Prepared {
                private final FieldLocator fieldLocator;
                private final FieldNameExtractor fieldNameExtractor;

                protected Prepared(FieldNameExtractor fieldNameExtractor2, FieldLocator fieldLocator2) {
                    this.fieldNameExtractor = fieldNameExtractor2;
                    this.fieldLocator = fieldLocator2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Prepared prepared = (Prepared) obj;
                    return this.fieldNameExtractor.equals(prepared.fieldNameExtractor) && this.fieldLocator.equals(prepared.fieldLocator);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.fieldNameExtractor.hashCode()) * 31) + this.fieldLocator.hashCode();
                }

                public FieldDescription resolve(MethodDescription methodDescription) {
                    FieldLocator.Resolution locate = this.fieldLocator.locate(this.fieldNameExtractor.resolve(methodDescription));
                    if (locate.isResolved()) {
                        return locate.getField();
                    }
                    throw new IllegalStateException("Cannot resolve field for " + methodDescription + " using " + this.fieldLocator);
                }
            }

            protected Relative(FieldNameExtractor fieldNameExtractor2) {
                this(fieldNameExtractor2, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Relative relative = (Relative) obj;
                return this.fieldNameExtractor.equals(relative.fieldNameExtractor) && this.fieldLocatorFactory.equals(relative.fieldLocatorFactory);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldNameExtractor.hashCode()) * 31) + this.fieldLocatorFactory.hashCode();
            }

            public Prepared prepare(TypeDescription typeDescription) {
                return new Prepared(this.fieldNameExtractor, this.fieldLocatorFactory.make(typeDescription));
            }

            public FieldLocation with(FieldLocator.Factory factory) {
                return new Relative(this.fieldNameExtractor, factory);
            }

            private Relative(FieldNameExtractor fieldNameExtractor2, FieldLocator.Factory factory) {
                this.fieldNameExtractor = fieldNameExtractor2;
                this.fieldLocatorFactory = factory;
            }
        }

        Prepared prepare(TypeDescription typeDescription);

        FieldLocation with(FieldLocator.Factory factory);
    }

    public interface FieldNameExtractor {

        public enum ForBeanProperty implements FieldNameExtractor {
            INSTANCE;

            public String resolve(MethodDescription methodDescription) {
                int i10;
                String internalName = methodDescription.getInternalName();
                if (internalName.startsWith("get") || internalName.startsWith("set")) {
                    i10 = 3;
                } else if (internalName.startsWith("is")) {
                    i10 = 2;
                } else {
                    throw new IllegalArgumentException(methodDescription + " does not follow Java bean naming conventions");
                }
                String substring = internalName.substring(i10);
                if (substring.length() != 0) {
                    return Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                }
                throw new IllegalArgumentException(methodDescription + " does not specify a bean name");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFixedValue implements FieldNameExtractor {
            private final String name;

            protected ForFixedValue(String str) {
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((ForFixedValue) obj).name);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.name.hashCode();
            }

            public String resolve(MethodDescription methodDescription) {
                return this.name;
            }
        }

        String resolve(MethodDescription methodDescription);
    }

    protected static class ForImplicitProperty extends FieldAccessor implements OwnerTypeLocatable {

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class Appender implements ByteCodeAppender {
            private final FieldLocation.Prepared fieldLocation;

            protected Appender(FieldLocation.Prepared prepared) {
                this.fieldLocation = prepared;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                StackManipulation.Compound compound;
                if (methodDescription.isMethod()) {
                    FieldDescription resolve = this.fieldLocation.resolve(methodDescription);
                    if (resolve.isStatic() || !methodDescription.isStatic()) {
                        if (resolve.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = MethodVariableAccess.loadThis();
                        }
                        if (!methodDescription.getReturnType().represents(Void.TYPE)) {
                            compound = new StackManipulation.Compound(stackManipulation, FieldAccess.forField(resolve).read(), ForImplicitProperty.this.assigner.assign(resolve.getType(), methodDescription.getReturnType(), ForImplicitProperty.this.typing), MethodReturn.of(methodDescription.getReturnType()));
                        } else if (!methodDescription.getReturnType().represents(Void.TYPE) || methodDescription.getParameters().size() != 1) {
                            throw new IllegalArgumentException("Method " + methodDescription + " is no bean accessor");
                        } else if (!resolve.isFinal() || !methodDescription.isMethod()) {
                            compound = new StackManipulation.Compound(stackManipulation, MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(0)), ForImplicitProperty.this.assigner.assign(((ParameterDescription) methodDescription.getParameters().get(0)).getType(), resolve.getType(), ForImplicitProperty.this.typing), FieldAccess.forField(resolve).write(), MethodReturn.VOID);
                        } else {
                            throw new IllegalStateException("Cannot set final field " + resolve + " from " + methodDescription);
                        }
                        if (compound.isValid()) {
                            return new ByteCodeAppender.Size(compound.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                        }
                        throw new IllegalStateException("Cannot set or get value of " + methodDescription + " using " + resolve);
                    }
                    throw new IllegalStateException("Cannot set instance field " + resolve + " from " + methodDescription);
                }
                throw new IllegalArgumentException(methodDescription + " does not describe a field getter or setter");
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.fieldLocation.equals(appender.fieldLocation) && ForImplicitProperty.this.equals(ForImplicitProperty.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldLocation.hashCode()) * 31) + ForImplicitProperty.this.hashCode();
            }
        }

        protected ForImplicitProperty(FieldLocation fieldLocation) {
            this(fieldLocation, Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(this.fieldLocation.prepare(target.getInstrumentedType()));
        }

        public AssignerConfigurable in(Class<?> cls) {
            return in(TypeDescription.ForLoadedType.of(cls));
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation.Composable setsArgumentAt(int i10) {
            if (i10 >= 0) {
                return new ForSetter.OfParameterValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, i10);
            }
            throw new IllegalArgumentException("A parameter index cannot be negative: " + i10);
        }

        public Implementation.Composable setsDefaultValue() {
            return new ForSetter.OfDefaultValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING);
        }

        public Implementation.Composable setsFieldValueOf(Field field) {
            return setsFieldValueOf((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public Implementation.Composable setsReference(Object obj) {
            return setsReference(obj, "fixedFieldValue$" + RandomString.hashOf(obj));
        }

        public Implementation.Composable setsValue(@MaybeNull Object obj) {
            if (obj == null) {
                return setsDefaultValue();
            }
            ConstantValue wrapOrNull = ConstantValue.Simple.wrapOrNull(obj);
            if (wrapOrNull == null) {
                return setsReference(obj);
            }
            return setsValue(wrapOrNull.toStackManipulation(), wrapOrNull.getTypeDescription().asGenericType());
        }

        public PropertyConfigurable withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForImplicitProperty(this.fieldLocation, assigner, typing);
        }

        private ForImplicitProperty(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing) {
            super(fieldLocation, assigner, typing);
        }

        public AssignerConfigurable in(TypeDescription typeDescription) {
            return in((FieldLocator.Factory) new FieldLocator.ForExactType.Factory(typeDescription));
        }

        public Implementation.Composable setsFieldValueOf(FieldDescription fieldDescription) {
            return new ForSetter.OfFieldValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, new FieldLocation.Absolute(fieldDescription));
        }

        public Implementation.Composable setsReference(Object obj, String str) {
            return new ForSetter.OfReferenceValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, obj, str);
        }

        public AssignerConfigurable in(FieldLocator.Factory factory) {
            return new ForImplicitProperty(this.fieldLocation.with(factory), this.assigner, this.typing);
        }

        public Implementation.Composable setsFieldValueOf(String str) {
            return setsFieldValueOf((FieldNameExtractor) new FieldNameExtractor.ForFixedValue(str));
        }

        public Implementation.Composable setsFieldValueOf(FieldNameExtractor fieldNameExtractor) {
            return new ForSetter.OfFieldValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, new FieldLocation.Relative(fieldNameExtractor));
        }

        public Implementation.Composable setsValue(TypeDescription typeDescription) {
            return setsValue(ClassConstant.of(typeDescription), (Type) Class.class);
        }

        public Implementation.Composable setsValue(ConstantValue constantValue) {
            return setsValue(constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType());
        }

        public Implementation.Composable setsValue(JavaConstant javaConstant) {
            return setsValue((ConstantValue) javaConstant);
        }

        public Implementation.Composable setsValue(StackManipulation stackManipulation, Type type) {
            return setsValue(stackManipulation, TypeDefinition.Sort.describe(type));
        }

        public Implementation.Composable setsValue(StackManipulation stackManipulation, TypeDescription.Generic generic) {
            return new ForSetter.OfConstantValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, generic, stackManipulation);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static abstract class ForSetter<T> extends FieldAccessor implements Implementation.Composable {
        /* access modifiers changed from: private */
        public final TerminationHandler terminationHandler;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class Appender implements ByteCodeAppender {
            private final FieldLocation.Prepared fieldLocation;
            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
            @MaybeNull
            private final T initialized;
            private final TypeDescription instrumentedType;

            protected Appender(TypeDescription typeDescription, @MaybeNull T t10, FieldLocation.Prepared prepared) {
                this.instrumentedType = typeDescription;
                this.initialized = t10;
                this.fieldLocation = prepared;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                FieldDescription resolve = this.fieldLocation.resolve(methodDescription);
                if (!resolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot set instance field " + resolve + " from " + methodDescription);
                } else if (!resolve.isFinal() || !methodDescription.isMethod()) {
                    StackManipulation resolve2 = ForSetter.this.resolve(this.initialized, resolve, this.instrumentedType, methodDescription);
                    if (resolve2.isValid()) {
                        StackManipulation[] stackManipulationArr = new StackManipulation[4];
                        if (methodDescription.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = MethodVariableAccess.loadThis();
                        }
                        stackManipulationArr[0] = stackManipulation;
                        stackManipulationArr[1] = resolve2;
                        stackManipulationArr[2] = FieldAccess.forField(resolve).write();
                        stackManipulationArr[3] = ForSetter.this.terminationHandler.resolve(methodDescription);
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }
                    throw new IllegalStateException("Set value cannot be assigned to " + resolve);
                } else {
                    throw new IllegalStateException("Cannot set final field " + resolve + " from " + methodDescription);
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
                    net.bytebuddy.description.type.TypeDescription r2 = r4.instrumentedType
                    net.bytebuddy.implementation.FieldAccessor$ForSetter$Appender r5 = (net.bytebuddy.implementation.FieldAccessor.ForSetter.Appender) r5
                    net.bytebuddy.description.type.TypeDescription r3 = r5.instrumentedType
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x0020
                    return r1
                L_0x0020:
                    T r2 = r4.initialized
                    T r3 = r5.initialized
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
                    net.bytebuddy.implementation.FieldAccessor$FieldLocation$Prepared r2 = r4.fieldLocation
                    net.bytebuddy.implementation.FieldAccessor$FieldLocation$Prepared r3 = r5.fieldLocation
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x003d
                    return r1
                L_0x003d:
                    net.bytebuddy.implementation.FieldAccessor$ForSetter r2 = net.bytebuddy.implementation.FieldAccessor.ForSetter.this
                    net.bytebuddy.implementation.FieldAccessor$ForSetter r5 = net.bytebuddy.implementation.FieldAccessor.ForSetter.this
                    boolean r5 = r2.equals(r5)
                    if (r5 != 0) goto L_0x0048
                    return r1
                L_0x0048:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.FieldAccessor.ForSetter.Appender.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                int hashCode = ((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31;
                T t10 = this.initialized;
                if (t10 != null) {
                    hashCode += t10.hashCode();
                }
                return (((hashCode * 31) + this.fieldLocation.hashCode()) * 31) + ForSetter.this.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class OfConstantValue extends ForSetter<Void> {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic typeDescription;

            protected OfConstantValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, TypeDescription.Generic generic, StackManipulation stackManipulation2) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.typeDescription = generic;
                this.stackManipulation = stackManipulation2;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfConstantValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), implementation);
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
                OfConstantValue ofConstantValue = (OfConstantValue) obj;
                return this.typeDescription.equals(ofConstantValue.typeDescription) && this.stackManipulation.equals(ofConstantValue.stackManipulation);
            }

            public int hashCode() {
                return (((super.hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.stackManipulation.hashCode();
            }

            /* access modifiers changed from: protected */
            @AlwaysNull
            public Void initialize(TypeDescription typeDescription2) {
                return null;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfConstantValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), composable);
            }

            /* access modifiers changed from: protected */
            public StackManipulation resolve(@MaybeNull Void voidR, FieldDescription fieldDescription, TypeDescription typeDescription2, MethodDescription methodDescription) {
                return new StackManipulation.Compound(this.stackManipulation, this.assigner.assign(this.typeDescription, fieldDescription.getType(), this.typing));
            }
        }

        protected static class OfDefaultValue extends ForSetter<Void> {
            protected OfDefaultValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler) {
                super(fieldLocation, assigner, typing, terminationHandler);
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfDefaultValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL), implementation);
            }

            /* access modifiers changed from: protected */
            @AlwaysNull
            public Void initialize(TypeDescription typeDescription) {
                return null;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfDefaultValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL), composable);
            }

            /* access modifiers changed from: protected */
            public StackManipulation resolve(@MaybeNull Void voidR, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                return DefaultValue.of(fieldDescription.getType());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class OfFieldValue extends ForSetter<FieldLocation.Prepared> {
            private final FieldLocation target;

            protected OfFieldValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, FieldLocation fieldLocation2) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.target = fieldLocation2;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfFieldValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.target), implementation);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((OfFieldValue) obj).target);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.target.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfFieldValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.target), composable);
            }

            /* access modifiers changed from: protected */
            public FieldLocation.Prepared initialize(TypeDescription typeDescription) {
                return this.target.prepare(typeDescription);
            }

            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Expects its own initialized value as argument", value = {"NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE"})
            public StackManipulation resolve(@MaybeNull FieldLocation.Prepared prepared, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                FieldDescription resolve = prepared.resolve(methodDescription);
                if (resolve.isStatic() || !methodDescription.isStatic()) {
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (resolve.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(resolve).read();
                    stackManipulationArr[2] = this.assigner.assign(resolve.getType(), fieldDescription.getType(), this.typing);
                    return new StackManipulation.Compound(stackManipulationArr);
                }
                throw new IllegalStateException("Cannot set instance field " + fieldDescription + " from " + methodDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class OfParameterValue extends ForSetter<Void> {
            private final int index;

            protected OfParameterValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, int i10) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.index = i10;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfParameterValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.index), implementation);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.index == ((OfParameterValue) obj).index;
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.index;
            }

            /* access modifiers changed from: protected */
            @AlwaysNull
            public Void initialize(TypeDescription typeDescription) {
                return null;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfParameterValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.index), composable);
            }

            /* access modifiers changed from: protected */
            public StackManipulation resolve(@MaybeNull Void voidR, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                if (methodDescription.getParameters().size() > this.index) {
                    return new StackManipulation.Compound(MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(this.index)), this.assigner.assign(((ParameterDescription) methodDescription.getParameters().get(this.index)).getType(), fieldDescription.getType(), this.typing));
                }
                throw new IllegalStateException(methodDescription + " does not define a parameter with index " + this.index);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class OfReferenceValue extends ForSetter<FieldDescription.InDefinedShape> {
            protected static final String PREFIX = "fixedFieldValue";
            private final String name;
            private final Object value;

            protected OfReferenceValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, Object obj, String str) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.value = obj;
                this.name = str;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfReferenceValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.value, this.name), implementation);
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
                OfReferenceValue ofReferenceValue = (OfReferenceValue) obj;
                return this.name.equals(ofReferenceValue.name) && this.value.equals(ofReferenceValue.value);
            }

            public int hashCode() {
                return (((super.hashCode() * 31) + this.value.hashCode()) * 31) + this.name.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4105, TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType()), this.value);
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfReferenceValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.value, this.name), composable);
            }

            /* access modifiers changed from: protected */
            public FieldDescription.InDefinedShape initialize(TypeDescription typeDescription) {
                return (FieldDescription.InDefinedShape) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.name))).getOnly();
            }

            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Expects its own initialized value as argument", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public StackManipulation resolve(@MaybeNull FieldDescription.InDefinedShape inDefinedShape, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                if (!fieldDescription.isFinal() || !methodDescription.isMethod()) {
                    return new StackManipulation.Compound(FieldAccess.forField(inDefinedShape).read(), this.assigner.assign(TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType(), fieldDescription.getType(), this.typing));
                }
                throw new IllegalArgumentException("Cannot set final field " + fieldDescription + " from " + methodDescription);
            }
        }

        protected enum TerminationHandler {
            RETURNING {
                /* access modifiers changed from: protected */
                public StackManipulation resolve(MethodDescription methodDescription) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return MethodReturn.VOID;
                    }
                    throw new IllegalStateException("Cannot implement setter with return value for " + methodDescription);
                }
            },
            NON_OPERATIONAL {
                /* access modifiers changed from: protected */
                public StackManipulation resolve(MethodDescription methodDescription) {
                    return StackManipulation.Trivial.INSTANCE;
                }
            };

            /* access modifiers changed from: protected */
            public abstract StackManipulation resolve(MethodDescription methodDescription);
        }

        protected ForSetter(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler2) {
            super(fieldLocation, assigner, typing);
            this.terminationHandler = terminationHandler2;
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType(), initialize(target.getInstrumentedType()), this.fieldLocation.prepare(target.getInstrumentedType()));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!FieldAccessor.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.terminationHandler.equals(((ForSetter) obj).terminationHandler);
        }

        public int hashCode() {
            return (FieldAccessor.super.hashCode() * 31) + this.terminationHandler.hashCode();
        }

        /* access modifiers changed from: protected */
        @MaybeNull
        public abstract T initialize(TypeDescription typeDescription);

        /* access modifiers changed from: protected */
        public abstract StackManipulation resolve(@MaybeNull T t10, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription);
    }

    public interface OwnerTypeLocatable extends AssignerConfigurable {
        AssignerConfigurable in(Class<?> cls);

        AssignerConfigurable in(TypeDescription typeDescription);

        AssignerConfigurable in(FieldLocator.Factory factory);
    }

    public interface PropertyConfigurable extends Implementation {
        Implementation.Composable setsArgumentAt(int i10);

        Implementation.Composable setsDefaultValue();

        Implementation.Composable setsFieldValueOf(String str);

        Implementation.Composable setsFieldValueOf(Field field);

        Implementation.Composable setsFieldValueOf(FieldDescription fieldDescription);

        Implementation.Composable setsFieldValueOf(FieldNameExtractor fieldNameExtractor);

        Implementation.Composable setsReference(Object obj);

        Implementation.Composable setsReference(Object obj, String str);

        Implementation.Composable setsValue(Object obj);

        Implementation.Composable setsValue(TypeDescription typeDescription);

        Implementation.Composable setsValue(StackManipulation stackManipulation, Type type);

        Implementation.Composable setsValue(StackManipulation stackManipulation, TypeDescription.Generic generic);

        Implementation.Composable setsValue(ConstantValue constantValue);

        Implementation.Composable setsValue(JavaConstant javaConstant);
    }

    protected FieldAccessor(FieldLocation fieldLocation2, Assigner assigner2, Assigner.Typing typing2) {
        this.fieldLocation = fieldLocation2;
        this.assigner = assigner2;
        this.typing = typing2;
    }

    public static OwnerTypeLocatable of(FieldNameExtractor fieldNameExtractor) {
        return new ForImplicitProperty(new FieldLocation.Relative(fieldNameExtractor));
    }

    public static OwnerTypeLocatable ofBeanProperty() {
        return of((FieldNameExtractor) FieldNameExtractor.ForBeanProperty.INSTANCE);
    }

    public static OwnerTypeLocatable ofField(String str) {
        return of((FieldNameExtractor) new FieldNameExtractor.ForFixedValue(str));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FieldAccessor fieldAccessor = (FieldAccessor) obj;
        return this.typing.equals(fieldAccessor.typing) && this.fieldLocation.equals(fieldAccessor.fieldLocation) && this.assigner.equals(fieldAccessor.assigner);
    }

    public int hashCode() {
        return (((((getClass().hashCode() * 31) + this.fieldLocation.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode();
    }

    public static AssignerConfigurable of(Field field) {
        return of((FieldDescription) new FieldDescription.ForLoadedField(field));
    }

    public static AssignerConfigurable of(FieldDescription fieldDescription) {
        return new ForImplicitProperty(new FieldLocation.Absolute(fieldDescription));
    }
}
