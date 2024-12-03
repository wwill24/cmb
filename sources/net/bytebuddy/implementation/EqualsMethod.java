package net.bytebuddy.implementation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.InstanceCheck;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class EqualsMethod implements Implementation {
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape EQUALS = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.isEquals())).getOnly());
    private final Comparator<? super FieldDescription.InDefinedShape> comparator;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable;
    private final SuperClassCheck superClassCheck;
    private final TypeCompatibilityCheck typeCompatibilityCheck;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class Appender implements ByteCodeAppender {
        private final StackManipulation baseline;
        private final List<FieldDescription.InDefinedShape> fieldDescriptions;
        private final TypeDescription instrumentedType;
        private final ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable;

        protected Appender(TypeDescription typeDescription, StackManipulation stackManipulation, List<FieldDescription.InDefinedShape> list, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
            this.instrumentedType = typeDescription;
            this.baseline = stackManipulation;
            this.fieldDescriptions = list;
            this.nonNullable = elementMatcher;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            NullValueGuard nullValueGuard;
            if (methodDescription.isStatic()) {
                throw new IllegalStateException("Hash code method must not be static: " + methodDescription);
            } else if (methodDescription.getParameters().size() != 1 || ((ParameterDescription) methodDescription.getParameters().getOnly()).getType().isPrimitive()) {
                throw new IllegalStateException();
            } else if (methodDescription.getReturnType().represents(Boolean.TYPE)) {
                ArrayList arrayList = new ArrayList((this.fieldDescriptions.size() * 8) + 3);
                arrayList.add(this.baseline);
                int i10 = 0;
                for (FieldDescription.InDefinedShape next : this.fieldDescriptions) {
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(FieldAccess.forField(next).read());
                    arrayList.add(MethodVariableAccess.REFERENCE.loadFrom(1));
                    arrayList.add(TypeCasting.to(this.instrumentedType));
                    arrayList.add(FieldAccess.forField(next).read());
                    if (next.getType().isPrimitive() || next.getType().isArray() || this.nonNullable.matches(next)) {
                        nullValueGuard = NullValueGuard.NoOp.INSTANCE;
                    } else {
                        nullValueGuard = new NullValueGuard.UsingJump(methodDescription);
                    }
                    arrayList.add(nullValueGuard.before());
                    arrayList.add(ValueComparator.of(next.getType()));
                    arrayList.add(nullValueGuard.after());
                    i10 = Math.max(i10, nullValueGuard.getRequiredVariablePadding());
                }
                arrayList.add(IntegerConstant.forValue(true));
                arrayList.add(MethodReturn.INTEGER);
                return new ByteCodeAppender.Size(new StackManipulation.Compound((List<? extends StackManipulation>) arrayList).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize() + i10);
            } else {
                throw new IllegalStateException("Hash code method does not return primitive boolean: " + methodDescription);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.instrumentedType.equals(appender.instrumentedType) && this.baseline.equals(appender.baseline) && this.fieldDescriptions.equals(appender.fieldDescriptions) && this.nonNullable.equals(appender.nonNullable);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.baseline.hashCode()) * 31) + this.fieldDescriptions.hashCode()) * 31) + this.nonNullable.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    @SuppressFBWarnings(justification = "Not used within a serializable instance", value = {"SE_COMPARATOR_SHOULD_BE_SERIALIZABLE"})
    protected static class CompoundComparator implements Comparator<FieldDescription.InDefinedShape> {
        private final List<Comparator<? super FieldDescription.InDefinedShape>> comparators;

        protected CompoundComparator(Comparator<? super FieldDescription.InDefinedShape>... comparatorArr) {
            this((List<? extends Comparator<? super FieldDescription.InDefinedShape>>) Arrays.asList(comparatorArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.comparators.equals(((CompoundComparator) obj).comparators);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.comparators.hashCode();
        }

        protected CompoundComparator(List<? extends Comparator<? super FieldDescription.InDefinedShape>> list) {
            this.comparators = new ArrayList();
            for (Comparator comparator : list) {
                if (comparator instanceof CompoundComparator) {
                    this.comparators.addAll(((CompoundComparator) comparator).comparators);
                } else if (!(comparator instanceof NaturalOrderComparator)) {
                    this.comparators.add(comparator);
                }
            }
        }

        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            for (Comparator<? super FieldDescription.InDefinedShape> compare : this.comparators) {
                int compare2 = compare.compare(inDefinedShape, inDefinedShape2);
                if (compare2 != 0) {
                    return compare2;
                }
            }
            return 0;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ConditionalReturn extends StackManipulation.AbstractBase {
        private static final Object[] EMPTY = new Object[0];
        private final int jumpCondition;
        private final int value;

        protected ConditionalReturn(int i10) {
            this(i10, 3);
        }

        protected static ConditionalReturn onIdentity() {
            return new ConditionalReturn(Opcodes.IF_ACMPNE);
        }

        protected static ConditionalReturn onNonEqualInteger() {
            return new ConditionalReturn(Opcodes.IF_ICMPEQ);
        }

        protected static ConditionalReturn onNonIdentity() {
            return new ConditionalReturn(Opcodes.IF_ACMPEQ);
        }

        protected static ConditionalReturn onNonZeroInteger() {
            return new ConditionalReturn(Opcodes.IFEQ);
        }

        protected static ConditionalReturn onNullValue() {
            return new ConditionalReturn(Opcodes.IFNONNULL);
        }

        protected static ConditionalReturn onZeroInteger() {
            return new ConditionalReturn(Opcodes.IFNE);
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            Label label = new Label();
            methodVisitor.visitJumpInsn(this.jumpCondition, label);
            methodVisitor.visitInsn(this.value);
            methodVisitor.visitInsn(Opcodes.IRETURN);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, Arrays.asList(new TypeDescription[]{context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class)}));
            return new StackManipulation.Size(-1, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ConditionalReturn conditionalReturn = (ConditionalReturn) obj;
            return this.jumpCondition == conditionalReturn.jumpCondition && this.value == conditionalReturn.value;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.jumpCondition) * 31) + this.value;
        }

        /* access modifiers changed from: protected */
        public StackManipulation returningTrue() {
            return new ConditionalReturn(this.jumpCondition, 4);
        }

        private ConditionalReturn(int i10, int i11) {
            this.jumpCondition = i10;
            this.value = i11;
        }
    }

    protected enum NaturalOrderComparator implements Comparator<FieldDescription.InDefinedShape> {
        INSTANCE;

        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            return 0;
        }
    }

    protected interface NullValueGuard {

        public enum NoOp implements NullValueGuard {
            INSTANCE;

            public StackManipulation after() {
                return StackManipulation.Trivial.INSTANCE;
            }

            public StackManipulation before() {
                return StackManipulation.Trivial.INSTANCE;
            }

            public int getRequiredVariablePadding() {
                return StackSize.ZERO.getSize();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingJump implements NullValueGuard {
            /* access modifiers changed from: private */
            public final Label endOfBlock = new Label();
            /* access modifiers changed from: private */
            public final Label firstValueNull = new Label();
            /* access modifiers changed from: private */
            public final MethodDescription instrumentedMethod;
            /* access modifiers changed from: private */
            public final Label secondValueNull = new Label();

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class AfterInstruction extends StackManipulation.AbstractBase {
                protected AfterInstruction() {
                }

                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    Class<Object> cls = Object.class;
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, UsingJump.this.endOfBlock);
                    methodVisitor.visitLabel(UsingJump.this.secondValueNull);
                    context.getFrameGeneration().same1(methodVisitor, TypeDescription.ForLoadedType.of(cls), Arrays.asList(new TypeDescription[]{context.getInstrumentedType(), TypeDescription.ForLoadedType.of(cls)}));
                    methodVisitor.visitJumpInsn(Opcodes.IFNULL, UsingJump.this.endOfBlock);
                    methodVisitor.visitLabel(UsingJump.this.firstValueNull);
                    context.getFrameGeneration().same(methodVisitor, Arrays.asList(new TypeDescription[]{context.getInstrumentedType(), TypeDescription.ForLoadedType.of(cls)}));
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitInsn(Opcodes.IRETURN);
                    methodVisitor.visitLabel(UsingJump.this.endOfBlock);
                    context.getFrameGeneration().same(methodVisitor, Arrays.asList(new TypeDescription[]{context.getInstrumentedType(), TypeDescription.ForLoadedType.of(cls)}));
                    return StackManipulation.Size.ZERO;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + UsingJump.this.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            protected class BeforeInstruction extends StackManipulation.AbstractBase {
                protected BeforeInstruction() {
                }

                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    methodVisitor.visitVarInsn(58, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitVarInsn(58, UsingJump.this.instrumentedMethod.getStackSize() + 1);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize() + 1);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitJumpInsn(Opcodes.IFNULL, UsingJump.this.secondValueNull);
                    methodVisitor.visitJumpInsn(Opcodes.IFNULL, UsingJump.this.firstValueNull);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize() + 1);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    return StackManipulation.Size.ZERO;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + UsingJump.this.hashCode();
                }
            }

            protected UsingJump(MethodDescription methodDescription) {
                this.instrumentedMethod = methodDescription;
            }

            public StackManipulation after() {
                return new AfterInstruction();
            }

            public StackManipulation before() {
                return new BeforeInstruction();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingJump usingJump = (UsingJump) obj;
                return this.instrumentedMethod.equals(usingJump.instrumentedMethod) && this.firstValueNull.equals(usingJump.firstValueNull) && this.secondValueNull.equals(usingJump.secondValueNull) && this.endOfBlock.equals(usingJump.endOfBlock);
            }

            public int getRequiredVariablePadding() {
                return 2;
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.firstValueNull.hashCode()) * 31) + this.secondValueNull.hashCode()) * 31) + this.endOfBlock.hashCode();
            }
        }

        StackManipulation after();

        StackManipulation before();

        int getRequiredVariablePadding();
    }

    protected enum SuperClassCheck {
        DISABLED {
            /* access modifiers changed from: protected */
            public StackManipulation resolve(TypeDescription typeDescription) {
                return StackManipulation.Trivial.INSTANCE;
            }
        },
        ENABLED {
            /* access modifiers changed from: protected */
            public StackManipulation resolve(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                if (superClass != null) {
                    return new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodVariableAccess.REFERENCE.loadFrom(1), MethodInvocation.invoke(EqualsMethod.EQUALS).special(superClass.asErasure()), ConditionalReturn.onZeroInteger());
                }
                throw new IllegalStateException(typeDescription + " does not declare a super class");
            }
        };

        /* access modifiers changed from: protected */
        public abstract StackManipulation resolve(TypeDescription typeDescription);
    }

    protected enum TypeCompatibilityCheck {
        EXACT {
            public StackManipulation resolve(TypeDescription typeDescription) {
                MethodVariableAccess methodVariableAccess = MethodVariableAccess.REFERENCE;
                MethodDescription.InDefinedShape inDefinedShape = TypeCompatibilityCheck.GET_CLASS;
                return new StackManipulation.Compound(methodVariableAccess.loadFrom(1), ConditionalReturn.onNullValue(), methodVariableAccess.loadFrom(0), MethodInvocation.invoke(inDefinedShape), methodVariableAccess.loadFrom(1), MethodInvocation.invoke(inDefinedShape), ConditionalReturn.onNonIdentity());
            }
        },
        SUBCLASS {
            /* access modifiers changed from: protected */
            public StackManipulation resolve(TypeDescription typeDescription) {
                return new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(1), InstanceCheck.of(typeDescription), ConditionalReturn.onZeroInteger());
            }
        };
        
        protected static final MethodDescription.InDefinedShape GET_CLASS = null;

        static {
            GET_CLASS = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.named("getClass"))).getOnly();
        }

        /* access modifiers changed from: protected */
        public abstract StackManipulation resolve(TypeDescription typeDescription);
    }

    protected enum TypePropertyComparator implements Comparator<FieldDescription.InDefinedShape> {
        FOR_PRIMITIVE_TYPES {
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return super.compare((FieldDescription.InDefinedShape) obj, (FieldDescription.InDefinedShape) obj2);
            }

            /* access modifiers changed from: protected */
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.isPrimitive();
            }
        },
        FOR_ENUMERATION_TYPES {
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return super.compare((FieldDescription.InDefinedShape) obj, (FieldDescription.InDefinedShape) obj2);
            }

            /* access modifiers changed from: protected */
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.isEnum();
            }
        },
        FOR_STRING_TYPES {
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return super.compare((FieldDescription.InDefinedShape) obj, (FieldDescription.InDefinedShape) obj2);
            }

            /* access modifiers changed from: protected */
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.represents(String.class);
            }
        },
        FOR_PRIMITIVE_WRAPPER_TYPES {
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return super.compare((FieldDescription.InDefinedShape) obj, (FieldDescription.InDefinedShape) obj2);
            }

            /* access modifiers changed from: protected */
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.asErasure().isPrimitiveWrapper();
            }
        };

        /* access modifiers changed from: protected */
        public abstract boolean resolve(TypeDefinition typeDefinition);

        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            if (!resolve(inDefinedShape.getType()) || resolve(inDefinedShape2.getType())) {
                return (resolve(inDefinedShape.getType()) || !resolve(inDefinedShape2.getType())) ? 0 : 1;
            }
            return -1;
        }
    }

    protected enum ValueComparator implements StackManipulation {
        LONG {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitInsn(Opcodes.LCMP);
                return new StackManipulation.Size(-2, 0);
            }
        },
        FLOAT {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "compare", "(FF)I", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        DOUBLE {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "compare", "(DD)I", false);
                return new StackManipulation.Size(-2, 0);
            }
        },
        BOOLEAN_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([Z[Z)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        BYTE_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([B[B)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        SHORT_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([S[S)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        CHARACTER_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([C[C)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        INTEGER_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([I[I)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        LONG_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([J[J)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        FLOAT_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([F[F)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        DOUBLE_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([D[D)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        REFERENCE_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "equals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        NESTED_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "deepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        };

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public static StackManipulation of(TypeDefinition typeDefinition) {
            ValueComparator valueComparator;
            if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                return ConditionalReturn.onNonEqualInteger();
            }
            if (typeDefinition.represents(Long.TYPE)) {
                return new StackManipulation.Compound(LONG, ConditionalReturn.onNonZeroInteger());
            } else if (typeDefinition.represents(Float.TYPE)) {
                return new StackManipulation.Compound(FLOAT, ConditionalReturn.onNonZeroInteger());
            } else if (typeDefinition.represents(Double.TYPE)) {
                return new StackManipulation.Compound(DOUBLE, ConditionalReturn.onNonZeroInteger());
            } else if (typeDefinition.represents(boolean[].class)) {
                return new StackManipulation.Compound(BOOLEAN_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(byte[].class)) {
                return new StackManipulation.Compound(BYTE_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(short[].class)) {
                return new StackManipulation.Compound(SHORT_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(char[].class)) {
                return new StackManipulation.Compound(CHARACTER_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(int[].class)) {
                return new StackManipulation.Compound(INTEGER_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(long[].class)) {
                return new StackManipulation.Compound(LONG_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(float[].class)) {
                return new StackManipulation.Compound(FLOAT_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.represents(double[].class)) {
                return new StackManipulation.Compound(DOUBLE_ARRAY, ConditionalReturn.onZeroInteger());
            } else if (typeDefinition.isArray()) {
                StackManipulation[] stackManipulationArr = new StackManipulation[2];
                if (typeDefinition.getComponentType().isArray()) {
                    valueComparator = NESTED_ARRAY;
                } else {
                    valueComparator = REFERENCE_ARRAY;
                }
                stackManipulationArr[0] = valueComparator;
                stackManipulationArr[1] = ConditionalReturn.onZeroInteger();
                return new StackManipulation.Compound(stackManipulationArr);
            } else {
                return new StackManipulation.Compound(MethodInvocation.invoke(EqualsMethod.EQUALS).virtual(typeDefinition.asErasure()), ConditionalReturn.onZeroInteger());
            }
        }

        public boolean isValid() {
            return true;
        }
    }

    protected EqualsMethod(SuperClassCheck superClassCheck2) {
        this(superClassCheck2, TypeCompatibilityCheck.EXACT, ElementMatchers.none(), ElementMatchers.none(), NaturalOrderComparator.INSTANCE);
    }

    public static EqualsMethod isolated() {
        return new EqualsMethod(SuperClassCheck.DISABLED);
    }

    public static EqualsMethod requiringSuperClassEquality() {
        return new EqualsMethod(SuperClassCheck.ENABLED);
    }

    public ByteCodeAppender appender(Implementation.Target target) {
        if (!target.getInstrumentedType().isInterface()) {
            ArrayList arrayList = new ArrayList(target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic().or(this.ignored))));
            Collections.sort(arrayList, this.comparator);
            return new Appender(target.getInstrumentedType(), new StackManipulation.Compound(this.superClassCheck.resolve(target.getInstrumentedType()), MethodVariableAccess.loadThis(), MethodVariableAccess.REFERENCE.loadFrom(1), ConditionalReturn.onIdentity().returningTrue(), this.typeCompatibilityCheck.resolve(target.getInstrumentedType())), arrayList, this.nonNullable);
        }
        throw new IllegalStateException("Cannot implement meaningful equals method for " + target.getInstrumentedType());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EqualsMethod equalsMethod = (EqualsMethod) obj;
        return this.superClassCheck.equals(equalsMethod.superClassCheck) && this.typeCompatibilityCheck.equals(equalsMethod.typeCompatibilityCheck) && this.ignored.equals(equalsMethod.ignored) && this.nonNullable.equals(equalsMethod.nonNullable) && this.comparator.equals(equalsMethod.comparator);
    }

    public int hashCode() {
        return (((((((((getClass().hashCode() * 31) + this.superClassCheck.hashCode()) * 31) + this.typeCompatibilityCheck.hashCode()) * 31) + this.ignored.hashCode()) * 31) + this.nonNullable.hashCode()) * 31) + this.comparator.hashCode();
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    public EqualsMethod withEnumerationTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_ENUMERATION_TYPES);
    }

    public EqualsMethod withFieldOrder(Comparator<? super FieldDescription.InDefinedShape> comparator2) {
        return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored, this.nonNullable, new CompoundComparator((Comparator<? super FieldDescription.InDefinedShape>[]) new Comparator[]{this.comparator, comparator2}));
    }

    public EqualsMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored.or(elementMatcher), this.nonNullable, this.comparator);
    }

    public EqualsMethod withNonNullableFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored, this.nonNullable.or(elementMatcher), this.comparator);
    }

    public EqualsMethod withPrimitiveTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_PRIMITIVE_TYPES);
    }

    public EqualsMethod withPrimitiveWrapperTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_PRIMITIVE_WRAPPER_TYPES);
    }

    public EqualsMethod withStringTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_STRING_TYPES);
    }

    public Implementation withSubclassEquality() {
        return new EqualsMethod(this.superClassCheck, TypeCompatibilityCheck.SUBCLASS, this.ignored, this.nonNullable, this.comparator);
    }

    private EqualsMethod(SuperClassCheck superClassCheck2, TypeCompatibilityCheck typeCompatibilityCheck2, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction2, Comparator<? super FieldDescription.InDefinedShape> comparator2) {
        this.superClassCheck = superClassCheck2;
        this.typeCompatibilityCheck = typeCompatibilityCheck2;
        this.ignored = junction;
        this.nonNullable = junction2;
        this.comparator = comparator2;
    }
}
