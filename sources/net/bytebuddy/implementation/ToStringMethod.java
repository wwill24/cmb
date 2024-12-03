package net.bytebuddy.implementation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ToStringMethod implements Implementation {
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape STRING_BUILDER_CONSTRUCTOR;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape TO_STRING;
    private final String definer;
    private final String end;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
    private final PrefixResolver prefixResolver;
    private final String separator;
    private final String start;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class Appender implements ByteCodeAppender {
        private final String definer;
        private final String end;
        private final List<? extends FieldDescription.InDefinedShape> fieldDescriptions;
        private final String prefix;
        private final String separator;
        private final String start;

        protected Appender(String str, String str2, String str3, String str4, String str5, List<? extends FieldDescription.InDefinedShape> list) {
            this.prefix = str;
            this.start = str2;
            this.end = str3;
            this.separator = str4;
            this.definer = str5;
            this.fieldDescriptions = list;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.isStatic()) {
                throw new IllegalStateException("toString method must not be static: " + methodDescription);
            } else if (methodDescription.getReturnType().asErasure().isAssignableFrom((Class<?>) String.class)) {
                ArrayList arrayList = new ArrayList(Math.max(0, (this.fieldDescriptions.size() * 7) - 2) + 10);
                arrayList.add(TypeCreation.of(TypeDescription.ForLoadedType.of(StringBuilder.class)));
                arrayList.add(Duplication.SINGLE);
                arrayList.add(new TextConstant(this.prefix));
                arrayList.add(MethodInvocation.invoke(ToStringMethod.STRING_BUILDER_CONSTRUCTOR));
                arrayList.add(new TextConstant(this.start));
                arrayList.add(ValueConsumer.STRING);
                boolean z10 = true;
                for (FieldDescription.InDefinedShape inDefinedShape : this.fieldDescriptions) {
                    if (z10) {
                        z10 = false;
                    } else {
                        arrayList.add(new TextConstant(this.separator));
                        arrayList.add(ValueConsumer.STRING);
                    }
                    arrayList.add(new TextConstant(inDefinedShape.getName() + this.definer));
                    arrayList.add(ValueConsumer.STRING);
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(FieldAccess.forField(inDefinedShape).read());
                    arrayList.add(ValueConsumer.of(inDefinedShape.getType().asErasure()));
                }
                arrayList.add(new TextConstant(this.end));
                arrayList.add(ValueConsumer.STRING);
                arrayList.add(MethodInvocation.invoke(ToStringMethod.TO_STRING));
                arrayList.add(MethodReturn.REFERENCE);
                return new ByteCodeAppender.Size(new StackManipulation.Compound((List<? extends StackManipulation>) arrayList).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            } else {
                throw new IllegalStateException("toString method does not return String-compatible type: " + methodDescription);
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
            return this.prefix.equals(appender.prefix) && this.start.equals(appender.start) && this.end.equals(appender.end) && this.separator.equals(appender.separator) && this.definer.equals(appender.definer) && this.fieldDescriptions.equals(appender.fieldDescriptions);
        }

        public int hashCode() {
            return (((((((((((getClass().hashCode() * 31) + this.prefix.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.separator.hashCode()) * 31) + this.definer.hashCode()) * 31) + this.fieldDescriptions.hashCode();
        }
    }

    public interface PrefixResolver {

        public enum Default implements PrefixResolver {
            FULLY_QUALIFIED_CLASS_NAME {
                public String resolve(TypeDescription typeDescription) {
                    return typeDescription.getName();
                }
            },
            CANONICAL_CLASS_NAME {
                @MaybeNull
                public String resolve(TypeDescription typeDescription) {
                    return typeDescription.getCanonicalName();
                }
            },
            SIMPLE_CLASS_NAME {
                public String resolve(TypeDescription typeDescription) {
                    return typeDescription.getSimpleName();
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFixedValue implements PrefixResolver {
            private final String prefix;

            protected ForFixedValue(String str) {
                this.prefix = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.prefix.equals(((ForFixedValue) obj).prefix);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.prefix.hashCode();
            }

            public String resolve(TypeDescription typeDescription) {
                return this.prefix;
            }
        }

        @MaybeNull
        String resolve(TypeDescription typeDescription);
    }

    protected enum ValueConsumer implements StackManipulation {
        BOOLEAN {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Z)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(C)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        INTEGER {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        LONG {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        FLOAT {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(F)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(D)Ljava/lang/StringBuilder;", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        STRING {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER_SEQUENCE {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        OBJECT {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        BOOLEAN_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([Z)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        BYTE_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([B)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        SHORT_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([S)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([C)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        INTEGER_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([I)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        LONG_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([J)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        FLOAT_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([F)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([D)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        REFERENCE_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "toString", "([Ljava/lang/Object;)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        NESTED_ARRAY {
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "deepToString", "([Ljava/lang/Object;)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        };

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        protected static StackManipulation of(TypeDescription typeDescription) {
            if (typeDescription.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDescription.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Integer.TYPE)) {
                return INTEGER;
            }
            if (typeDescription.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDescription.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDescription.represents(Double.TYPE)) {
                return DOUBLE;
            }
            if (typeDescription.represents(String.class)) {
                return STRING;
            }
            if (typeDescription.isAssignableTo((Class<?>) CharSequence.class)) {
                return CHARACTER_SEQUENCE;
            }
            if (typeDescription.represents(boolean[].class)) {
                return BOOLEAN_ARRAY;
            }
            if (typeDescription.represents(byte[].class)) {
                return BYTE_ARRAY;
            }
            if (typeDescription.represents(short[].class)) {
                return SHORT_ARRAY;
            }
            if (typeDescription.represents(char[].class)) {
                return CHARACTER_ARRAY;
            }
            if (typeDescription.represents(int[].class)) {
                return INTEGER_ARRAY;
            }
            if (typeDescription.represents(long[].class)) {
                return LONG_ARRAY;
            }
            if (typeDescription.represents(float[].class)) {
                return FLOAT_ARRAY;
            }
            if (typeDescription.represents(double[].class)) {
                return DOUBLE_ARRAY;
            }
            if (!typeDescription.isArray()) {
                return OBJECT;
            }
            if (typeDescription.getComponentType().isArray()) {
                return NESTED_ARRAY;
            }
            return REFERENCE_ARRAY;
        }

        public boolean isValid() {
            return true;
        }
    }

    static {
        Class<StringBuilder> cls = StringBuilder.class;
        STRING_BUILDER_CONSTRUCTOR = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(cls).getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class})))).getOnly();
        TO_STRING = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(cls).getDeclaredMethods().filter(ElementMatchers.isToString())).getOnly();
    }

    protected ToStringMethod(PrefixResolver prefixResolver2) {
        this(prefixResolver2, "{", "}", ", ", "=", ElementMatchers.none());
    }

    public static ToStringMethod prefixedBy(String str) {
        if (str != null) {
            return prefixedBy((PrefixResolver) new PrefixResolver.ForFixedValue(str));
        }
        throw new IllegalArgumentException("Prefix cannot be null");
    }

    public static ToStringMethod prefixedByCanonicalClassName() {
        return prefixedBy((PrefixResolver) PrefixResolver.Default.CANONICAL_CLASS_NAME);
    }

    public static ToStringMethod prefixedByFullyQualifiedClassName() {
        return prefixedBy((PrefixResolver) PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME);
    }

    public static ToStringMethod prefixedBySimpleClassName() {
        return prefixedBy((PrefixResolver) PrefixResolver.Default.SIMPLE_CLASS_NAME);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ToStringMethod toStringMethod = (ToStringMethod) obj;
        return this.start.equals(toStringMethod.start) && this.end.equals(toStringMethod.end) && this.separator.equals(toStringMethod.separator) && this.definer.equals(toStringMethod.definer) && this.prefixResolver.equals(toStringMethod.prefixResolver) && this.ignored.equals(toStringMethod.ignored);
    }

    public int hashCode() {
        return (((((((((((getClass().hashCode() * 31) + this.prefixResolver.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.separator.hashCode()) * 31) + this.definer.hashCode()) * 31) + this.ignored.hashCode();
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    public ToStringMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new ToStringMethod(this.prefixResolver, this.start, this.end, this.separator, this.definer, this.ignored.or(elementMatcher));
    }

    public Implementation withTokens(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            throw new IllegalArgumentException("Token values cannot be null");
        }
        return new ToStringMethod(this.prefixResolver, str, str2, str3, str4, this.ignored);
    }

    private ToStringMethod(PrefixResolver prefixResolver2, String str, String str2, String str3, String str4, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction) {
        this.prefixResolver = prefixResolver2;
        this.start = str;
        this.end = str2;
        this.separator = str3;
        this.definer = str4;
        this.ignored = junction;
    }

    public Appender appender(Implementation.Target target) {
        if (!target.getInstrumentedType().isInterface()) {
            String resolve = this.prefixResolver.resolve(target.getInstrumentedType());
            if (resolve != null) {
                return new Appender(resolve, this.start, this.end, this.separator, this.definer, target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic().or(this.ignored))));
            }
            throw new IllegalStateException("Prefix for toString method cannot be null");
        }
        throw new IllegalStateException("Cannot implement meaningful toString method for " + target.getInstrumentedType());
    }

    public static ToStringMethod prefixedBy(PrefixResolver prefixResolver2) {
        return new ToStringMethod(prefixResolver2);
    }
}
