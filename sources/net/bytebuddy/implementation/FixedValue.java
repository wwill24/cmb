package net.bytebuddy.implementation;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public abstract class FixedValue implements Implementation {
    protected final Assigner assigner;
    protected final Assigner.Typing typing;

    public interface AssignerConfigurable extends Implementation {
        Implementation withAssigner(Assigner assigner, Assigner.Typing typing);
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ForArgument extends FixedValue implements AssignerConfigurable, ByteCodeAppender {
        private final int index;

        protected ForArgument(int i10) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, i10);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.getParameters().size() > this.index) {
                ParameterDescription parameterDescription = (ParameterDescription) methodDescription.getParameters().get(this.index);
                StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription), this.assigner.assign(parameterDescription.getType(), methodDescription.getReturnType(), this.typing), MethodReturn.of(methodDescription.getReturnType()));
                if (compound.isValid()) {
                    return new ByteCodeAppender.Size(compound.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }
                throw new IllegalStateException("Cannot assign " + methodDescription.getReturnType() + " to " + parameterDescription);
            }
            throw new IllegalStateException(methodDescription + " does not define a parameter with index " + this.index);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!FixedValue.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.index == ((ForArgument) obj).index;
        }

        public int hashCode() {
            return (FixedValue.super.hashCode() * 31) + this.index;
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForArgument(assigner, typing, this.index);
        }

        private ForArgument(Assigner assigner, Assigner.Typing typing, int i10) {
            super(assigner, typing);
            this.index = i10;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ForConstantValue extends FixedValue implements AssignerConfigurable, ByteCodeAppender {
        private final TypeDescription loadedType;
        private final StackManipulation valueLoadInstruction;

        protected ForConstantValue(StackManipulation stackManipulation, Class<?> cls) {
            this(stackManipulation, TypeDescription.ForLoadedType.of(cls));
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return apply(methodVisitor, context, methodDescription, this.loadedType.asGenericType(), this.valueLoadInstruction);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!FixedValue.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForConstantValue forConstantValue = (ForConstantValue) obj;
            return this.valueLoadInstruction.equals(forConstantValue.valueLoadInstruction) && this.loadedType.equals(forConstantValue.loadedType);
        }

        public int hashCode() {
            return (((FixedValue.super.hashCode() * 31) + this.valueLoadInstruction.hashCode()) * 31) + this.loadedType.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForConstantValue(assigner, typing, this.valueLoadInstruction, this.loadedType);
        }

        protected ForConstantValue(StackManipulation stackManipulation, TypeDescription typeDescription) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, stackManipulation, typeDescription);
        }

        private ForConstantValue(Assigner assigner, Assigner.Typing typing, StackManipulation stackManipulation, TypeDescription typeDescription) {
            super(assigner, typing);
            this.valueLoadInstruction = stackManipulation;
            this.loadedType = typeDescription;
        }
    }

    protected enum ForNullValue implements Implementation, ByteCodeAppender {
        INSTANCE;

        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (!methodDescription.getReturnType().isPrimitive()) {
                return new ByteCodeAppender.Simple(NullConstant.INSTANCE, MethodReturn.REFERENCE).apply(methodVisitor, context, methodDescription);
            }
            throw new IllegalStateException("Cannot return null from " + methodDescription);
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    protected static class ForOriginType extends FixedValue implements AssignerConfigurable {

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        protected class Appender implements ByteCodeAppender {
            private final TypeDescription originType;

            protected Appender(TypeDescription typeDescription) {
                this.originType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                return ForOriginType.this.apply(methodVisitor, context, methodDescription, TypeDescription.ForLoadedType.of(Class.class).asGenericType(), ClassConstant.of(this.originType));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.originType.equals(appender.originType) && ForOriginType.this.equals(ForOriginType.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.originType.hashCode()) * 31) + ForOriginType.this.hashCode();
            }
        }

        protected ForOriginType() {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getOriginType().asErasure());
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForOriginType(assigner, typing);
        }

        private ForOriginType(Assigner assigner, Assigner.Typing typing) {
            super(assigner, typing);
        }
    }

    protected static class ForThisValue extends FixedValue implements AssignerConfigurable {

        @HashCodeAndEqualsPlugin.Enhance
        protected static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            protected Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                if (methodDescription.isStatic() || !this.instrumentedType.isAssignableTo(methodDescription.getReturnType().asErasure())) {
                    throw new IllegalStateException("Cannot return 'this' from " + methodDescription);
                }
                return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), MethodReturn.REFERENCE).apply(methodVisitor, context, methodDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }
        }

        protected ForThisValue() {
            super(Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForThisValue(assigner, typing);
        }

        private ForThisValue(Assigner assigner, Assigner.Typing typing) {
            super(assigner, typing);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ForValue extends FixedValue implements AssignerConfigurable {
        private static final String PREFIX = "value";
        /* access modifiers changed from: private */
        public final String name;
        /* access modifiers changed from: private */
        public final Object value;

        @HashCodeAndEqualsPlugin.Enhance
        private class StaticFieldByteCodeAppender implements ByteCodeAppender {
            private final StackManipulation fieldGetAccess;

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                ForValue forValue = ForValue.this;
                return forValue.apply(methodVisitor, context, methodDescription, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(forValue.value.getClass()), this.fieldGetAccess);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldGetAccess.equals(((StaticFieldByteCodeAppender) obj).fieldGetAccess);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldGetAccess.hashCode();
            }

            private StaticFieldByteCodeAppender(TypeDescription typeDescription) {
                this.fieldGetAccess = FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(ForValue.this.name))).getOnly()).read();
            }
        }

        protected ForValue(Object obj, String str) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, obj, str);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new StaticFieldByteCodeAppender(target.getInstrumentedType());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!FixedValue.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForValue forValue = (ForValue) obj;
            return this.name.equals(forValue.name) && this.value.equals(forValue.value);
        }

        public int hashCode() {
            return (((FixedValue.super.hashCode() * 31) + this.name.hashCode()) * 31) + this.value.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass())), this.value);
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForValue(assigner, typing, this.value, this.name);
        }

        private ForValue(Assigner assigner, Assigner.Typing typing, Object obj, String str) {
            super(assigner, typing);
            this.name = str;
            this.value = obj;
        }
    }

    protected FixedValue(Assigner assigner2, Assigner.Typing typing2) {
        this.assigner = assigner2;
        this.typing = typing2;
    }

    public static AssignerConfigurable argument(int i10) {
        if (i10 >= 0) {
            return new ForArgument(i10);
        }
        throw new IllegalArgumentException("Argument index cannot be negative: " + i10);
    }

    public static Implementation nullValue() {
        return ForNullValue.INSTANCE;
    }

    public static AssignerConfigurable originType() {
        return new ForOriginType();
    }

    public static AssignerConfigurable reference(Object obj) {
        return reference(obj, "value$" + RandomString.hashOf(obj));
    }

    public static AssignerConfigurable self() {
        return new ForThisValue();
    }

    public static AssignerConfigurable value(Object obj) {
        ConstantValue wrapOrNull = ConstantValue.Simple.wrapOrNull(obj);
        if (wrapOrNull == null) {
            return reference(obj);
        }
        return new ForConstantValue(wrapOrNull.toStackManipulation(), wrapOrNull.getTypeDescription());
    }

    /* access modifiers changed from: protected */
    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription, TypeDescription.Generic generic, StackManipulation stackManipulation) {
        StackManipulation assign = this.assigner.assign(generic, methodDescription.getReturnType(), this.typing);
        if (assign.isValid()) {
            return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, assign, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }
        throw new IllegalArgumentException("Cannot return value of type " + generic + " for " + methodDescription);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FixedValue fixedValue = (FixedValue) obj;
        return this.typing.equals(fixedValue.typing) && this.assigner.equals(fixedValue.assigner);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode();
    }

    public static AssignerConfigurable reference(Object obj, String str) {
        return new ForValue(obj, str);
    }

    public static AssignerConfigurable value(TypeDescription typeDescription) {
        return new ForConstantValue(ClassConstant.of(typeDescription), TypeDescription.ForLoadedType.of(Class.class));
    }

    public static AssignerConfigurable value(ConstantValue constantValue) {
        return new ForConstantValue(constantValue.toStackManipulation(), constantValue.getTypeDescription());
    }

    public static AssignerConfigurable value(JavaConstant javaConstant) {
        return value((ConstantValue) javaConstant);
    }
}
