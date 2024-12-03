package net.bytebuddy.asm;

import com.google.firebase.analytics.FirebaseAnalytics;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.Throw;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import net.bytebuddy.utility.visitor.LineNumberPrependingMethodVisitor;
import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.packet.Session;

@HashCodeAndEqualsPlugin.Enhance
public class Advice implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper, Implementation {
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape BACKUP_ARGUMENTS;
    private static final MethodDescription.InDefinedShape INLINE_ENTER;
    private static final MethodDescription.InDefinedShape INLINE_EXIT;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape ON_THROWABLE;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape PREPEND_LINE_NUMBER;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape REPEAT_ON;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape REPEAT_ON_INDEX;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SKIP_ON;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SKIP_ON_INDEX;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SUPPRESS_ENTER;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SUPPRESS_EXIT;
    @AlwaysNull
    private static final ClassReader UNDEFINED = null;
    private final Assigner assigner;
    private final Implementation delegate;
    private final ExceptionHandler exceptionHandler;
    private final Dispatcher.Resolved.ForMethodEnter methodEnter;
    private final Dispatcher.Resolved.ForMethodExit methodExit;

    protected static abstract class AdviceVisitor extends ExceptionTableSensitiveMethodVisitor implements Dispatcher.RelocationHandler.Relocation {
        private static final int THIS_VARIABLE_INDEX = 0;
        private static final String THIS_VARIABLE_NAME = "this";
        protected final ArgumentHandler.ForInstrumentedMethod argumentHandler;
        protected final MethodDescription instrumentedMethod;
        private final Dispatcher.Bound methodEnter;
        protected final Dispatcher.Bound methodExit;
        protected final MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
        private final Label preparationStart;
        protected final StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;

        protected static abstract class WithExitAdvice extends AdviceVisitor {
            protected final Label returnHandler = new Label();

            protected static class WithExceptionHandling extends WithExitAdvice {
                private final Label exceptionHandler;
                private final TypeDescription throwable;
                protected final Label userStart;

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected WithExceptionHandling(net.bytebuddy.jar.asm.MethodVisitor r14, net.bytebuddy.implementation.Implementation.Context r15, net.bytebuddy.implementation.bytecode.assign.Assigner r16, net.bytebuddy.implementation.bytecode.StackManipulation r17, net.bytebuddy.description.type.TypeDescription r18, net.bytebuddy.description.method.MethodDescription r19, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter r20, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit r21, int r22, int r23, net.bytebuddy.description.type.TypeDescription r24) {
                    /*
                        r13 = this;
                        r12 = r13
                        net.bytebuddy.description.type.TypeDescription$Generic r0 = r19.getReturnType()
                        java.lang.Class r1 = java.lang.Void.TYPE
                        boolean r0 = r0.represents(r1)
                        if (r0 == 0) goto L_0x0018
                        java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                        net.bytebuddy.description.type.TypeDescription r0 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(r0)
                        java.util.List r0 = java.util.Collections.singletonList(r0)
                        goto L_0x0033
                    L_0x0018:
                        r0 = 2
                        net.bytebuddy.description.type.TypeDescription[] r0 = new net.bytebuddy.description.type.TypeDescription[r0]
                        r1 = 0
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r19.getReturnType()
                        net.bytebuddy.description.type.TypeDescription r2 = r2.asErasure()
                        r0[r1] = r2
                        r1 = 1
                        java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
                        net.bytebuddy.description.type.TypeDescription r2 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(r2)
                        r0[r1] = r2
                        java.util.List r0 = java.util.Arrays.asList(r0)
                    L_0x0033:
                        r9 = r0
                        r0 = r13
                        r1 = r14
                        r2 = r15
                        r3 = r16
                        r4 = r17
                        r5 = r18
                        r6 = r19
                        r7 = r20
                        r8 = r21
                        r10 = r22
                        r11 = r23
                        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                        r0 = r24
                        r12.throwable = r0
                        net.bytebuddy.jar.asm.Label r0 = new net.bytebuddy.jar.asm.Label
                        r0.<init>()
                        r12.exceptionHandler = r0
                        net.bytebuddy.jar.asm.Label r0 = new net.bytebuddy.jar.asm.Label
                        r0.<init>()
                        r12.userStart = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice.WithExceptionHandling.<init>(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.implementation.Implementation$Context, net.bytebuddy.implementation.bytecode.assign.Assigner, net.bytebuddy.implementation.bytecode.StackManipulation, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodEnter, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodExit, int, int, net.bytebuddy.description.type.TypeDescription):void");
                }

                /* access modifiers changed from: protected */
                public void onExitAdviceReturn() {
                    this.mv.visitVarInsn(25, this.argumentHandler.thrown());
                    Label label = new Label();
                    this.mv.visitJumpInsn(Opcodes.IFNULL, label);
                    this.mv.visitVarInsn(25, this.argumentHandler.thrown());
                    this.mv.visitInsn(Opcodes.ATHROW);
                    this.mv.visitLabel(label);
                    this.stackMapFrameHandler.injectPostCompletionFrame(this.mv);
                }

                /* access modifiers changed from: protected */
                public void onUserPrepare() {
                    this.mv.visitTryCatchBlock(this.userStart, this.returnHandler, this.exceptionHandler, this.throwable.getInternalName());
                }

                /* access modifiers changed from: protected */
                public void onUserReturn() {
                    this.stackMapFrameHandler.injectReturnFrame(this.mv);
                    TypeDescription.Generic returnType = this.instrumentedMethod.getReturnType();
                    Class cls = Boolean.TYPE;
                    if (returnType.represents(cls) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                    this.mv.visitInsn(1);
                    this.mv.visitVarInsn(58, this.argumentHandler.thrown());
                    Label label = new Label();
                    this.mv.visitJumpInsn(Opcodes.GOTO, label);
                    this.mv.visitLabel(this.exceptionHandler);
                    this.stackMapFrameHandler.injectExceptionFrame(this.mv);
                    this.mv.visitVarInsn(58, this.argumentHandler.thrown());
                    if (this.instrumentedMethod.getReturnType().represents(cls) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                        this.mv.visitInsn(3);
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                        this.mv.visitInsn(9);
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                        this.mv.visitInsn(11);
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                        this.mv.visitInsn(14);
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                        this.mv.visitInsn(1);
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                    this.mv.visitLabel(label);
                    this.methodSizeHandler.requireStackSize(StackSize.SINGLE.getSize());
                }

                /* access modifiers changed from: protected */
                public void onUserStart() {
                    this.mv.visitLabel(this.userStart);
                }
            }

            protected static class WithoutExceptionHandling extends WithExitAdvice {
                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected WithoutExceptionHandling(net.bytebuddy.jar.asm.MethodVisitor r14, net.bytebuddy.implementation.Implementation.Context r15, net.bytebuddy.implementation.bytecode.assign.Assigner r16, net.bytebuddy.implementation.bytecode.StackManipulation r17, net.bytebuddy.description.type.TypeDescription r18, net.bytebuddy.description.method.MethodDescription r19, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter r20, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit r21, int r22, int r23) {
                    /*
                        r13 = this;
                        net.bytebuddy.description.type.TypeDescription$Generic r0 = r19.getReturnType()
                        java.lang.Class r1 = java.lang.Void.TYPE
                        boolean r0 = r0.represents(r1)
                        if (r0 == 0) goto L_0x0011
                        java.util.List r0 = java.util.Collections.emptyList()
                        goto L_0x001d
                    L_0x0011:
                        net.bytebuddy.description.type.TypeDescription$Generic r0 = r19.getReturnType()
                        net.bytebuddy.description.type.TypeDescription r0 = r0.asErasure()
                        java.util.List r0 = java.util.Collections.singletonList(r0)
                    L_0x001d:
                        r10 = r0
                        r1 = r13
                        r2 = r14
                        r3 = r15
                        r4 = r16
                        r5 = r17
                        r6 = r18
                        r7 = r19
                        r8 = r20
                        r9 = r21
                        r11 = r22
                        r12 = r23
                        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice.WithoutExceptionHandling.<init>(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.implementation.Implementation$Context, net.bytebuddy.implementation.bytecode.assign.Assigner, net.bytebuddy.implementation.bytecode.StackManipulation, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodEnter, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodExit, int, int):void");
                }

                /* access modifiers changed from: protected */
                public void onExitAdviceReturn() {
                }

                /* access modifiers changed from: protected */
                public void onUserPrepare() {
                }

                /* access modifiers changed from: protected */
                public void onUserReturn() {
                    if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                }

                /* access modifiers changed from: protected */
                public void onUserStart() {
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected WithExitAdvice(net.bytebuddy.jar.asm.MethodVisitor r13, net.bytebuddy.implementation.Implementation.Context r14, net.bytebuddy.implementation.bytecode.assign.Assigner r15, net.bytebuddy.implementation.bytecode.StackManipulation r16, net.bytebuddy.description.type.TypeDescription r17, net.bytebuddy.description.method.MethodDescription r18, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter r19, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit r20, java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r21, int r22, int r23) {
                /*
                    r12 = this;
                    r0 = r13
                    r6 = r18
                    net.bytebuddy.jar.asm.MethodVisitor r1 = net.bytebuddy.utility.visitor.StackAwareMethodVisitor.of(r13, r6)
                    r0 = r12
                    r2 = r14
                    r3 = r15
                    r4 = r16
                    r5 = r17
                    r7 = r19
                    r8 = r20
                    r9 = r21
                    r10 = r22
                    r11 = r23
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                    net.bytebuddy.jar.asm.Label r0 = new net.bytebuddy.jar.asm.Label
                    r0.<init>()
                    r1 = r12
                    r1.returnHandler = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice.<init>(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.implementation.Implementation$Context, net.bytebuddy.implementation.bytecode.assign.Assigner, net.bytebuddy.implementation.bytecode.StackManipulation, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodEnter, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodExit, java.util.List, int, int):void");
            }

            public void apply(MethodVisitor methodVisitor) {
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(1);
                }
                methodVisitor.visitJumpInsn(Opcodes.GOTO, this.returnHandler);
            }

            /* access modifiers changed from: protected */
            public abstract void onExitAdviceReturn();

            /* access modifiers changed from: protected */
            public void onUserEnd() {
                this.mv.visitLabel(this.returnHandler);
                onUserReturn();
                this.stackMapFrameHandler.injectCompletionFrame(this.mv);
                this.methodExit.apply();
                onExitAdviceReturn();
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    this.mv.visitVarInsn(21, this.argumentHandler.returned());
                    this.mv.visitInsn(Opcodes.IRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    this.mv.visitVarInsn(22, this.argumentHandler.returned());
                    this.mv.visitInsn(Opcodes.LRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    this.mv.visitVarInsn(23, this.argumentHandler.returned());
                    this.mv.visitInsn(Opcodes.FRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    this.mv.visitVarInsn(24, this.argumentHandler.returned());
                    this.mv.visitInsn(Opcodes.DRETURN);
                } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    this.mv.visitVarInsn(25, this.argumentHandler.returned());
                    this.mv.visitInsn(Opcodes.ARETURN);
                } else {
                    this.mv.visitInsn(Opcodes.RETURN);
                }
                this.methodSizeHandler.requireStackSize(this.instrumentedMethod.getReturnType().getStackSize().getSize());
            }

            /* access modifiers changed from: protected */
            public abstract void onUserReturn();

            /* access modifiers changed from: protected */
            public void onVisitInsn(int i10) {
                switch (i10) {
                    case Opcodes.IRETURN:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(54, 21, StackSize.SINGLE));
                        break;
                    case Opcodes.LRETURN:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(55, 22, StackSize.DOUBLE));
                        break;
                    case Opcodes.FRETURN:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(56, 23, StackSize.SINGLE));
                        break;
                    case Opcodes.DRETURN:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(57, 24, StackSize.DOUBLE));
                        break;
                    case Opcodes.ARETURN:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(58, 25, StackSize.SINGLE));
                        break;
                    case Opcodes.RETURN:
                        ((StackAwareMethodVisitor) this.mv).drainStack();
                        break;
                    default:
                        this.mv.visitInsn(i10);
                        return;
                }
                this.mv.visitJumpInsn(Opcodes.GOTO, this.returnHandler);
            }
        }

        protected static class WithoutExitAdvice extends AdviceVisitor {
            protected WithoutExitAdvice(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, int i10, int i11) {
                super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription, forMethodEnter, Dispatcher.Inactive.INSTANCE, Collections.emptyList(), i10, i11);
            }

            public void apply(MethodVisitor methodVisitor) {
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitInsn(Opcodes.IRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                    methodVisitor.visitInsn(Opcodes.LRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                    methodVisitor.visitInsn(Opcodes.FRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                    methodVisitor.visitInsn(Opcodes.DRETURN);
                } else if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(Opcodes.RETURN);
                } else {
                    methodVisitor.visitInsn(1);
                    methodVisitor.visitInsn(Opcodes.ARETURN);
                }
            }

            /* access modifiers changed from: protected */
            public void onUserEnd() {
            }

            /* access modifiers changed from: protected */
            public void onUserPrepare() {
            }

            /* access modifiers changed from: protected */
            public void onUserStart() {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @SuppressFBWarnings(justification = "Self reference is not used before constructor completion.", value = {"MC_OVERRIDABLE_METHOD_CALL_IN_CONSTRUCTOR"})
        protected AdviceVisitor(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, List<? extends TypeDescription> list, int i10, int i11) {
            super(OpenedClassReader.ASM_API, methodVisitor);
            List list2;
            List list3;
            List list4;
            MethodDescription methodDescription2 = methodDescription;
            this.instrumentedMethod = methodDescription2;
            Label label = new Label();
            this.preparationStart = label;
            TreeMap treeMap = new TreeMap();
            treeMap.putAll(forMethodEnter.getNamedTypes());
            treeMap.putAll(forMethodExit.getNamedTypes());
            ArgumentHandler.ForInstrumentedMethod resolve = forMethodExit.getArgumentHandlerFactory().resolve(methodDescription2, forMethodEnter.getAdviceType(), forMethodExit.getAdviceType(), treeMap);
            this.argumentHandler = resolve;
            if (forMethodExit.getAdviceType().represents(Void.TYPE)) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.singletonList(forMethodExit.getAdviceType().asErasure());
            }
            List<S> of2 = CompoundList.of(list2, (List) resolve.getNamedTypes());
            if (forMethodEnter.getActualAdviceType().represents(Void.TYPE)) {
                list3 = Collections.emptyList();
            } else {
                list3 = Collections.singletonList(forMethodEnter.getActualAdviceType().asErasure());
            }
            List list5 = list3;
            if (forMethodEnter.getAdviceType().represents(Void.TYPE)) {
                list4 = Collections.emptyList();
            } else {
                list4 = Collections.singletonList(forMethodEnter.getAdviceType().asErasure());
            }
            List list6 = list4;
            MethodSizeHandler.ForInstrumentedMethod of3 = MethodSizeHandler.Default.of(methodDescription, of2, list6, list, resolve.isCopyingArguments(), i10);
            this.methodSizeHandler = of3;
            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod = of3;
            StackMapFrameHandler.ForInstrumentedMethod of4 = StackMapFrameHandler.Default.of(typeDescription, methodDescription, of2, list5, list6, list, forMethodExit.isAlive(), resolve.isCopyingArguments(), context.getClassFileVersion(), i10, i11);
            this.stackMapFrameHandler = of4;
            TypeDescription typeDescription2 = typeDescription;
            MethodDescription methodDescription3 = methodDescription;
            MethodVisitor methodVisitor2 = methodVisitor;
            Implementation.Context context2 = context;
            Assigner assigner2 = assigner;
            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod2 = resolve;
            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod3 = forInstrumentedMethod;
            StackManipulation stackManipulation2 = stackManipulation;
            this.methodEnter = forMethodEnter.bind(typeDescription2, methodDescription3, methodVisitor2, context2, assigner2, forInstrumentedMethod2, forInstrumentedMethod3, of4, stackManipulation2, this);
            this.methodExit = forMethodExit.bind(typeDescription2, methodDescription3, methodVisitor2, context2, assigner2, forInstrumentedMethod2, forInstrumentedMethod3, of4, stackManipulation2, new Dispatcher.RelocationHandler.Relocation.ForLabel(label));
        }

        /* access modifiers changed from: protected */
        public void onAfterExceptionTable() {
            this.methodEnter.prepare();
            onUserPrepare();
            this.methodExit.prepare();
            this.methodEnter.initialize();
            this.methodExit.initialize();
            this.stackMapFrameHandler.injectInitializationFrame(this.mv);
            this.methodEnter.apply();
            this.mv.visitLabel(this.preparationStart);
            this.methodSizeHandler.requireStackSize(this.argumentHandler.prepare(this.mv));
            this.stackMapFrameHandler.injectStartFrame(this.mv);
            this.mv.visitInsn(0);
            onUserStart();
        }

        /* access modifiers changed from: protected */
        public abstract void onUserEnd();

        /* access modifiers changed from: protected */
        public abstract void onUserPrepare();

        /* access modifiers changed from: protected */
        public abstract void onUserStart();

        public void onVisitFrame(int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
            this.stackMapFrameHandler.translateFrame(this.mv, i10, i11, objArr, i12, objArr2);
        }

        /* access modifiers changed from: protected */
        public void onVisitIincInsn(int i10, int i11) {
            this.mv.visitIincInsn(this.argumentHandler.argument(i10), i11);
        }

        /* access modifiers changed from: protected */
        public void onVisitVarInsn(int i10, int i11) {
            this.mv.visitVarInsn(i10, this.argumentHandler.argument(i11));
        }

        public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i10) {
            MethodVisitor methodVisitor = this.mv;
            if (i10 != 0 || !THIS_VARIABLE_NAME.equals(str)) {
                i10 = this.argumentHandler.argument(i10);
            }
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i10);
        }

        public AnnotationVisitor visitLocalVariableAnnotation(int i10, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z10) {
            int[] iArr2 = iArr;
            int[] iArr3 = new int[iArr2.length];
            for (int i11 = 0; i11 < iArr2.length; i11++) {
                iArr3[i11] = this.argumentHandler.argument(iArr2[i11]);
            }
            return this.mv.visitLocalVariableAnnotation(i10, typePath, labelArr, labelArr2, iArr3, str, z10);
        }

        public void visitMaxs(int i10, int i11) {
            onUserEnd();
            this.mv.visitMaxs(this.methodSizeHandler.compoundStackSize(i10), this.methodSizeHandler.compoundLocalVariableLength(i11));
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AllArguments {
        boolean includeSelf() default false;

        boolean nullIfEmpty() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class Appender implements ByteCodeAppender {
        private final Advice advice;
        private final ByteCodeAppender delegate;
        private final Implementation.Target implementationTarget;

        protected static class EmulatingMethodVisitor extends MethodVisitor {
            private final ByteCodeAppender delegate;
            private int localVariableLength;
            private int stackSize;

            protected EmulatingMethodVisitor(MethodVisitor methodVisitor, ByteCodeAppender byteCodeAppender) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.delegate = byteCodeAppender;
            }

            /* access modifiers changed from: protected */
            public ByteCodeAppender.Size resolve(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                methodVisitor.visitCode();
                ByteCodeAppender.Size apply = this.delegate.apply(methodVisitor, context, methodDescription);
                methodVisitor.visitMaxs(apply.getOperandStackSize(), apply.getLocalVariableSize());
                methodVisitor.visitEnd();
                return new ByteCodeAppender.Size(this.stackSize, this.localVariableLength);
            }

            public void visitCode() {
            }

            public void visitEnd() {
            }

            public void visitMaxs(int i10, int i11) {
                this.stackSize = i10;
                this.localVariableLength = i11;
            }
        }

        protected Appender(Advice advice2, Implementation.Target target, ByteCodeAppender byteCodeAppender) {
            this.advice = advice2;
            this.implementationTarget = target;
            this.delegate = byteCodeAppender;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            EmulatingMethodVisitor emulatingMethodVisitor = new EmulatingMethodVisitor(methodVisitor, this.delegate);
            return emulatingMethodVisitor.resolve(this.advice.doWrap(this.implementationTarget.getInstrumentedType(), methodDescription, emulatingMethodVisitor, context, 0, 0), context, methodDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.advice.equals(appender.advice) && this.implementationTarget.equals(appender.implementationTarget) && this.delegate.equals(appender.delegate);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.advice.hashCode()) * 31) + this.implementationTarget.hashCode()) * 31) + this.delegate.hashCode();
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        int value();
    }

    public interface ArgumentHandler {
        public static final int THIS_REFERENCE = 0;

        public enum Factory {
            SIMPLE {
                /* access modifiers changed from: protected */
                public ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Simple(methodDescription, typeDefinition2, sortedMap, typeDefinition);
                }
            },
            COPYING {
                /* access modifiers changed from: protected */
                public ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Copying(methodDescription, typeDefinition2, sortedMap, typeDefinition);
                }
            };

            /* access modifiers changed from: protected */
            public abstract ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap);
        }

        public interface ForAdvice extends ArgumentHandler {

            public static abstract class Default implements ForAdvice {
                protected final MethodDescription adviceMethod;
                protected final TypeDefinition exitType;
                protected final MethodDescription instrumentedMethod;
                protected final SortedMap<String, TypeDefinition> namedTypes;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ForMethodEnter extends Default {
                    protected ForMethodEnter(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                        super(methodDescription, methodDescription2, typeDefinition, sortedMap);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    public int mapped(int i10) {
                        return (((this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize()) + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values())) - this.adviceMethod.getStackSize()) + i10;
                    }

                    public int returned() {
                        throw new IllegalStateException("Cannot resolve the return value offset during enter advice");
                    }

                    public int thrown() {
                        throw new IllegalStateException("Cannot resolve the thrown value offset during enter advice");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static class ForMethodExit extends Default {
                    private final TypeDefinition enterType;
                    private final StackSize throwableSize;

                    protected ForMethodExit(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2, StackSize stackSize) {
                        super(methodDescription, methodDescription2, typeDefinition, sortedMap);
                        this.enterType = typeDefinition2;
                        this.throwableSize = stackSize;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.throwableSize.equals(forMethodExit.throwableSize) && this.enterType.equals(forMethodExit.enterType);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.enterType.hashCode()) * 31) + this.throwableSize.hashCode();
                    }

                    public int mapped(int i10) {
                        return ((((((this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize()) + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values())) + this.enterType.getStackSize().getSize()) + this.instrumentedMethod.getReturnType().getStackSize().getSize()) + this.throwableSize.getSize()) - this.adviceMethod.getStackSize()) + i10;
                    }

                    public int returned() {
                        return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize();
                    }

                    public int thrown() {
                        return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize() + this.instrumentedMethod.getReturnType().getStackSize().getSize();
                    }
                }

                protected Default(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                    this.instrumentedMethod = methodDescription;
                    this.adviceMethod = methodDescription2;
                    this.exitType = typeDefinition;
                    this.namedTypes = sortedMap;
                }

                public int argument(int i10) {
                    return i10;
                }

                public int enter() {
                    return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values());
                }

                public int exit() {
                    return this.instrumentedMethod.getStackSize();
                }

                public int named(String str) {
                    return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.headMap(str).values());
                }
            }

            int mapped(int i10);
        }

        public interface ForInstrumentedMethod extends ArgumentHandler {

            public static abstract class Default implements ForInstrumentedMethod {
                protected final TypeDefinition enterType;
                protected final TypeDefinition exitType;
                protected final MethodDescription instrumentedMethod;
                protected final SortedMap<String, TypeDefinition> namedTypes;

                @HashCodeAndEqualsPlugin.Enhance
                protected static class Copying extends Default {
                    protected Copying(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    public int argument(int i10) {
                        return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize() + i10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    public boolean isCopyingArguments() {
                        return true;
                    }

                    public int prepare(MethodVisitor methodVisitor) {
                        StackSize stackSize;
                        if (!this.instrumentedMethod.isStatic()) {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitVarInsn(58, this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize());
                            stackSize = StackSize.SINGLE;
                        } else {
                            stackSize = StackSize.ZERO;
                        }
                        Iterator<E> it = this.instrumentedMethod.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            Type type = Type.getType(parameterDescription.getType().asErasure().getDescriptor());
                            methodVisitor.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
                            methodVisitor.visitVarInsn(type.getOpcode(54), this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize() + parameterDescription.getOffset());
                            stackSize = stackSize.maximum(parameterDescription.getType().getStackSize());
                        }
                        return stackSize.getSize();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static class Simple extends Default {
                    protected Simple(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    public int argument(int i10) {
                        if (i10 < this.instrumentedMethod.getStackSize()) {
                            return i10;
                        }
                        return i10 + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize();
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    public boolean isCopyingArguments() {
                        return false;
                    }

                    public int prepare(MethodVisitor methodVisitor) {
                        return 0;
                    }
                }

                protected Default(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                    this.instrumentedMethod = methodDescription;
                    this.namedTypes = sortedMap;
                    this.exitType = typeDefinition;
                    this.enterType = typeDefinition2;
                }

                public ForAdvice bindEnter(MethodDescription methodDescription) {
                    return new ForAdvice.Default.ForMethodEnter(this.instrumentedMethod, methodDescription, this.exitType, this.namedTypes);
                }

                public ForAdvice bindExit(MethodDescription methodDescription, boolean z10) {
                    return new ForAdvice.Default.ForMethodExit(this.instrumentedMethod, methodDescription, this.exitType, this.namedTypes, this.enterType, z10 ? StackSize.ZERO : StackSize.SINGLE);
                }

                public int enter() {
                    return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values());
                }

                public int exit() {
                    return this.instrumentedMethod.getStackSize();
                }

                public List<TypeDescription> getNamedTypes() {
                    ArrayList arrayList = new ArrayList(this.namedTypes.size());
                    for (TypeDefinition asErasure : this.namedTypes.values()) {
                        arrayList.add(asErasure.asErasure());
                    }
                    return arrayList;
                }

                public int named(String str) {
                    return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.headMap(str).values());
                }

                public int returned() {
                    return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize();
                }

                public int thrown() {
                    return this.instrumentedMethod.getStackSize() + this.exitType.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.namedTypes.values()) + this.enterType.getStackSize().getSize() + this.instrumentedMethod.getReturnType().getStackSize().getSize();
                }
            }

            ForAdvice bindEnter(MethodDescription methodDescription);

            ForAdvice bindExit(MethodDescription methodDescription, boolean z10);

            List<TypeDescription> getNamedTypes();

            boolean isCopyingArguments();

            int prepare(MethodVisitor methodVisitor);
        }

        int argument(int i10);

        int enter();

        int exit();

        int named(String str);

        int returned();

        int thrown();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AssignReturned implements PostProcessor {
        public static final int NO_INDEX = -1;
        protected final ExceptionHandler.Factory exceptionHandlerFactory;
        protected final boolean exit;
        protected final boolean skipOnDefaultValue;
        protected final TypeDescription.Generic type;

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface AsScalar {
            boolean skipOnDefaultValue() default true;
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class DefaultValueSkip implements StackManipulation {
            private final Dispatcher dispatcher;
            private final int offset;
            private final StackManipulation stackManipulation;
            private final StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;

            protected enum Dispatcher {
                INTEGER {
                    /* access modifiers changed from: protected */
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i10, Label label) {
                        methodVisitor.visitVarInsn(21, i10);
                        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
                        return new StackManipulation.Size(0, 1);
                    }
                },
                LONG {
                    /* access modifiers changed from: protected */
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i10, Label label) {
                        methodVisitor.visitVarInsn(22, i10);
                        methodVisitor.visitInsn(9);
                        methodVisitor.visitInsn(Opcodes.LCMP);
                        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
                        return new StackManipulation.Size(0, 4);
                    }
                },
                FLOAT {
                    /* access modifiers changed from: protected */
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i10, Label label) {
                        methodVisitor.visitVarInsn(23, i10);
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(Opcodes.FCMPL);
                        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
                        return new StackManipulation.Size(0, 2);
                    }
                },
                DOUBLE {
                    /* access modifiers changed from: protected */
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i10, Label label) {
                        methodVisitor.visitVarInsn(24, i10);
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(Opcodes.DCMPL);
                        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
                        return new StackManipulation.Size(0, 4);
                    }
                },
                REFERENCE {
                    /* access modifiers changed from: protected */
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i10, Label label) {
                        methodVisitor.visitVarInsn(25, i10);
                        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
                        return new StackManipulation.Size(0, 2);
                    }
                };

                /* access modifiers changed from: protected */
                public abstract StackManipulation.Size apply(MethodVisitor methodVisitor, int i10, Label label);
            }

            protected DefaultValueSkip(StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor, int i10, Dispatcher dispatcher2) {
                this.stackManipulation = stackManipulation2;
                this.stackMapFrameHandler = forPostProcessor;
                this.offset = i10;
                this.dispatcher = dispatcher2;
            }

            protected static StackManipulation of(StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor, int i10, TypeDefinition typeDefinition) {
                Dispatcher dispatcher2;
                if (!typeDefinition.isPrimitive()) {
                    dispatcher2 = Dispatcher.REFERENCE;
                } else if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                    dispatcher2 = Dispatcher.INTEGER;
                } else if (typeDefinition.represents(Long.TYPE)) {
                    dispatcher2 = Dispatcher.LONG;
                } else if (typeDefinition.represents(Float.TYPE)) {
                    dispatcher2 = Dispatcher.FLOAT;
                } else if (typeDefinition.represents(Double.TYPE)) {
                    dispatcher2 = Dispatcher.DOUBLE;
                } else {
                    throw new IllegalArgumentException("Cannot apply skip for " + typeDefinition);
                }
                return new DefaultValueSkip(stackManipulation2, forPostProcessor, i10, dispatcher2);
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                StackManipulation.Size aggregate = this.dispatcher.apply(methodVisitor, this.offset, label).aggregate(this.stackManipulation.apply(methodVisitor, context));
                methodVisitor.visitLabel(label);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.emptyList());
                methodVisitor.visitInsn(0);
                return aggregate;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                DefaultValueSkip defaultValueSkip = (DefaultValueSkip) obj;
                return this.offset == defaultValueSkip.offset && this.dispatcher.equals(defaultValueSkip.dispatcher) && this.stackManipulation.equals(defaultValueSkip.stackManipulation) && this.stackMapFrameHandler.equals(defaultValueSkip.stackMapFrameHandler);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.stackMapFrameHandler.hashCode()) * 31) + this.offset) * 31) + this.dispatcher.hashCode();
            }

            public boolean isValid() {
                return this.stackManipulation.isValid();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ExceptionHandler implements StackManipulation {
            private final StackManipulation exceptionHandler;
            private final TypeDescription exceptionType;
            private final StackManipulation stackManipulation;
            private final StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;

            public interface Factory {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Enabled implements Factory {
                    private final TypeDescription exceptionType;

                    protected Enabled(TypeDescription typeDescription) {
                        this.exceptionType = typeDescription;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.exceptionType.equals(((Enabled) obj).exceptionType);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.exceptionType.hashCode();
                    }

                    public StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                        return new ExceptionHandler(stackManipulation, stackManipulation2, this.exceptionType, forPostProcessor);
                    }
                }

                public enum NoOp implements Factory {
                    INSTANCE;

                    public StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                        return stackManipulation;
                    }
                }

                StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor);
            }

            protected ExceptionHandler(StackManipulation stackManipulation2, StackManipulation stackManipulation3, TypeDescription typeDescription, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                this.stackManipulation = stackManipulation2;
                this.exceptionHandler = stackManipulation3;
                this.exceptionType = typeDescription;
                this.stackMapFrameHandler = forPostProcessor;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                methodVisitor.visitTryCatchBlock(label, label2, label2, this.exceptionType.getInternalName());
                methodVisitor.visitLabel(label);
                StackManipulation.Size apply = this.stackManipulation.apply(methodVisitor, context);
                methodVisitor.visitJumpInsn(Opcodes.GOTO, label3);
                methodVisitor.visitLabel(label2);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.singletonList(this.exceptionType));
                StackManipulation.Size aggregate = this.exceptionHandler.apply(methodVisitor, context).aggregate(apply);
                methodVisitor.visitLabel(label3);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.emptyList());
                return aggregate;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ExceptionHandler exceptionHandler2 = (ExceptionHandler) obj;
                return this.stackManipulation.equals(exceptionHandler2.stackManipulation) && this.exceptionHandler.equals(exceptionHandler2.exceptionHandler) && this.exceptionType.equals(exceptionHandler2.exceptionType) && this.stackMapFrameHandler.equals(exceptionHandler2.stackMapFrameHandler);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.exceptionHandler.hashCode()) * 31) + this.exceptionType.hashCode()) * 31) + this.stackMapFrameHandler.hashCode();
            }

            public boolean isValid() {
                return this.stackManipulation.isValid() && this.exceptionHandler.isValid();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory implements PostProcessor.Factory {
            private static final MethodDescription.InDefinedShape SKIP_ON_DEFAULT_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(AsScalar.class).getDeclaredMethods().filter(ElementMatchers.named("skipOnDefaultValue"))).getOnly());
            private final ExceptionHandler.Factory exceptionHandlerFactory;
            private final List<? extends Handler.Factory<?>> factories;

            public Factory() {
                this(Arrays.asList(new Enum[]{ToArguments.Handler.Factory.INSTANCE, ToAllArguments.Handler.Factory.INSTANCE, ToThis.Handler.Factory.INSTANCE, ToFields.Handler.Factory.INSTANCE, ToReturned.Handler.Factory.INSTANCE, ToThrown.Handler.Factory.INSTANCE}), ExceptionHandler.Factory.NoOp.INSTANCE);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Factory factory = (Factory) obj;
                return this.factories.equals(factory.factories) && this.exceptionHandlerFactory.equals(factory.exceptionHandlerFactory);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.factories.hashCode()) * 31) + this.exceptionHandlerFactory.hashCode();
            }

            public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                if (inDefinedShape.getReturnType().represents(Void.TYPE)) {
                    return PostProcessor.NoOp.INSTANCE;
                }
                HashMap hashMap = new HashMap();
                for (Handler.Factory factory : this.factories) {
                    if (hashMap.put(factory.getAnnotationType().getName(), factory) != null) {
                        throw new IllegalStateException("Duplicate registration of handler for " + factory.getAnnotationType());
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                boolean z11 = false;
                boolean z12 = true;
                for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
                    if (annotationDescription.getAnnotationType().represents(AsScalar.class)) {
                        z12 = ((Boolean) annotationDescription.getValue(SKIP_ON_DEFAULT_VALUE).resolve(Boolean.class)).booleanValue();
                        z11 = true;
                    } else {
                        Handler.Factory factory2 = (Handler.Factory) hashMap.get(annotationDescription.getAnnotationType().getName());
                        if (!(factory2 == null || linkedHashMap.put(factory2.getAnnotationType(), factory2.make(inDefinedShape, z10, annotationDescription.prepare(factory2.getAnnotationType()))) == null)) {
                            throw new IllegalStateException("Duplicate handler registration for " + annotationDescription.getAnnotationType());
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    return PostProcessor.NoOp.INSTANCE;
                }
                if (!z11 && inDefinedShape.getReturnType().isArray()) {
                    return new ForArray(inDefinedShape.getReturnType(), this.exceptionHandlerFactory, z10, linkedHashMap.values());
                }
                return new ForScalar(inDefinedShape.getReturnType(), this.exceptionHandlerFactory, z10, z12, linkedHashMap.values());
            }

            public Factory with(Class<? extends Annotation> cls, Handler... handlerArr) {
                return with(cls, (List<Handler>) Arrays.asList(handlerArr));
            }

            public PostProcessor.Factory withSuppressed(Class<? extends Throwable> cls) {
                return withSuppressed(TypeDescription.ForLoadedType.of(cls));
            }

            protected Factory(List<? extends Handler.Factory<?>> list, ExceptionHandler.Factory factory) {
                this.factories = list;
                this.exceptionHandlerFactory = factory;
            }

            public Factory with(Class<? extends Annotation> cls, List<Handler> list) {
                return with(new Handler.Factory.Simple(cls, list));
            }

            public PostProcessor.Factory withSuppressed(TypeDescription typeDescription) {
                if (typeDescription.isAssignableTo((Class<?>) Throwable.class)) {
                    return new Factory(this.factories, new ExceptionHandler.Factory.Enabled(typeDescription));
                }
                throw new IllegalArgumentException(typeDescription + " is not a throwable type");
            }

            public Factory with(Handler.Factory<?> factory) {
                return new Factory(CompoundList.of(this.factories, factory), this.exceptionHandlerFactory);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ForArray extends AssignReturned {
            private final Map<Handler, Integer> handlers = new LinkedHashMap();

            protected ForArray(TypeDescription.Generic generic, ExceptionHandler.Factory factory, boolean z10, Collection<List<Handler>> collection) {
                super(generic, factory, z10, true);
                for (List<Handler> it : collection) {
                    Iterator it2 = it.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Handler handler = (Handler) it2.next();
                            int index = handler.getIndex();
                            if (index > -1) {
                                this.handlers.put(handler, Integer.valueOf(index));
                            } else {
                                throw new IllegalStateException("Handler on array requires positive index for " + handler);
                            }
                        }
                    }
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForArray) obj).handlers);
            }

            /* access modifiers changed from: protected */
            public Collection<Handler> getHandlers() {
                return this.handlers.keySet();
            }

            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public TypeDescription.Generic getType() {
                return this.type.getComponentType();
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.handlers.hashCode();
            }

            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public StackManipulation toLoadInstruction(Handler handler, int i10) {
                return new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(i10), IntegerConstant.forValue(this.handlers.get(handler).intValue()), ArrayAccess.of(this.type.getComponentType()).load());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ForScalar extends AssignReturned {
            private final List<Handler> handlers = new ArrayList();

            protected ForScalar(TypeDescription.Generic generic, ExceptionHandler.Factory factory, boolean z10, boolean z11, Collection<List<Handler>> collection) {
                super(generic, factory, z10, z11);
                for (List<Handler> it : collection) {
                    Iterator it2 = it.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Handler handler = (Handler) it2.next();
                            if (handler.getIndex() <= -1) {
                                this.handlers.add(handler);
                            } else {
                                throw new IllegalStateException("Handler on array requires negative index for " + handler);
                            }
                        }
                    }
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForScalar) obj).handlers);
            }

            /* access modifiers changed from: protected */
            public Collection<Handler> getHandlers() {
                return this.handlers;
            }

            /* access modifiers changed from: protected */
            public TypeDescription.Generic getType() {
                return this.type;
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.handlers.hashCode();
            }

            /* access modifiers changed from: protected */
            public StackManipulation toLoadInstruction(Handler handler, int i10) {
                return MethodVariableAccess.of(this.type).loadFrom(i10);
            }
        }

        public interface Handler {

            public interface Factory<T extends Annotation> {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple<S extends Annotation> implements Factory<S> {
                    private final List<Handler> handlers;
                    private final Class<S> type;

                    public Simple(Class<S> cls, List<Handler> list) {
                        this.type = cls;
                        this.handlers = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.type.equals(simple.type) && this.handlers.equals(simple.handlers);
                    }

                    public Class<S> getAnnotationType() {
                        return this.type;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.handlers.hashCode();
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends S> loadable) {
                        return this.handlers;
                    }
                }

                Class<T> getAnnotationType();

                List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends T> loadable);
            }

            int getIndex();

            StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation);
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToAllArguments {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToAllArguments> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_TYPING = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToAllArguments.class).getDeclaredMethods();
                        TO_ALL_ARGUMENTS_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToAllArguments> getAnnotationType() {
                        return ToAllArguments.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends ToAllArguments> loadable) {
                        return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_ALL_ARGUMENTS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_ALL_ARGUMENTS_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                    }
                }

                protected Handler(int i10, Assigner.Typing typing2) {
                    this.index = i10;
                    this.typing = typing2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode();
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    Class<Object[]> cls = Object[].class;
                    ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                    if (!generic.isArray()) {
                        StackManipulation assign = assigner.assign(generic, TypeDefinition.Sort.describe(cls), this.typing);
                        if (assign.isValid()) {
                            generic = TypeDefinition.Sort.describe(cls);
                            stackManipulation = new StackManipulation.Compound(stackManipulation, assign);
                        } else {
                            throw new IllegalStateException("Cannot assign " + generic + " to " + cls);
                        }
                    }
                    Iterator<E> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        StackManipulation assign2 = assigner.assign(generic.getComponentType(), parameterDescription.getType(), this.typing);
                        if (assign2.isValid()) {
                            arrayList.add(new StackManipulation.Compound(assign2, MethodVariableAccess.of(parameterDescription.getType()).storeAt(argumentHandler.argument(parameterDescription.getOffset()))));
                        } else {
                            throw new IllegalStateException("Cannot assign " + generic.getComponentType() + " to " + parameterDescription);
                        }
                    }
                    return new StackManipulation.Compound(stackManipulation, ArrayAccess.of(generic.getComponentType()).forEach(arrayList), Removal.SINGLE);
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToArguments {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;
                private final int value;

                public enum Factory implements Handler.Factory<ToArguments> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_ARGUMENTS_VALUE = null;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_TYPING = null;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_VALUE = null;

                    static {
                        TO_ARGUMENTS_VALUE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(ToArguments.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly();
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToArgument.class).getDeclaredMethods();
                        TO_ARGUMENT_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        TO_ARGUMENT_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_ARGUMENT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToArguments> getAnnotationType() {
                        return ToArguments.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends ToArguments> loadable) {
                        Class<Integer> cls = Integer.class;
                        ArrayList arrayList = new ArrayList();
                        AnnotationDescription[] annotationDescriptionArr = (AnnotationDescription[]) loadable.getValue(TO_ARGUMENTS_VALUE).resolve(AnnotationDescription[].class);
                        int length = annotationDescriptionArr.length;
                        int i10 = 0;
                        while (i10 < length) {
                            AnnotationDescription annotationDescription = annotationDescriptionArr[i10];
                            int intValue = ((Integer) annotationDescription.getValue(TO_ARGUMENT_VALUE).resolve(cls)).intValue();
                            if (intValue >= 0) {
                                arrayList.add(new Handler(intValue, ((Integer) annotationDescription.getValue(TO_ARGUMENT_INDEX).resolve(cls)).intValue(), (Assigner.Typing) ((EnumerationDescription) annotationDescription.getValue(TO_ARGUMENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                                i10++;
                            } else {
                                throw new IllegalStateException("An argument cannot have a negative index for " + inDefinedShape);
                            }
                        }
                        return arrayList;
                    }
                }

                protected Handler(int i10, int i11, Assigner.Typing typing2) {
                    this.value = i10;
                    this.index = i11;
                    this.typing = typing2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.value == handler.value && this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.value) * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getParameters().size() >= this.value) {
                        StackManipulation assign = assigner.assign(generic, ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType(), this.typing);
                        if (assign.isValid()) {
                            return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.of(((ParameterDescription) methodDescription.getParameters().get(this.value)).getType()).storeAt(argumentHandler.argument(((ParameterDescription) methodDescription.getParameters().get(this.value)).getOffset())));
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType());
                    }
                    throw new IllegalStateException(methodDescription + " declares less then " + this.value + " parameters");
                }
            }

            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToArguments.class)
            @Repeatable(ToArguments.class)
            public @interface ToArgument {
                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                int value();
            }

            ToArgument[] value();
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToFields {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final TypeDescription declaringType;
                private final int index;
                private final String name;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToFields> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_FIELDS_VALUE = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_DECLARING_TYPE = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_TYPING = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_VALUE = null;

                    static {
                        TO_FIELDS_VALUE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(ToFields.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly();
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToField.class).getDeclaredMethods();
                        TO_FIELD_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        TO_FIELD_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                        TO_FIELD_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToFields> getAnnotationType() {
                        return ToFields.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends ToFields> loadable) {
                        ArrayList arrayList = new ArrayList();
                        for (AnnotationDescription annotationDescription : (AnnotationDescription[]) loadable.getValue(TO_FIELDS_VALUE).resolve(AnnotationDescription[].class)) {
                            arrayList.add(new Handler(((Integer) annotationDescription.getValue(TO_FIELD_INDEX).resolve(Integer.class)).intValue(), (String) annotationDescription.getValue(TO_FIELD_VALUE).resolve(String.class), (TypeDescription) annotationDescription.getValue(TO_FIELD_DECLARING_TYPE).resolve(TypeDescription.class), (Assigner.Typing) ((EnumerationDescription) annotationDescription.getValue(TO_FIELD_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                        }
                        return arrayList;
                    }
                }

                protected Handler(int i10, String str, TypeDescription typeDescription, Assigner.Typing typing2) {
                    this.index = i10;
                    this.name = str;
                    this.declaringType = typeDescription;
                    this.typing = typing2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing) && this.name.equals(handler.name) && this.declaringType.equals(handler.declaringType);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.index) * 31) + this.name.hashCode()) * 31) + this.declaringType.hashCode()) * 31) + this.typing.hashCode();
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    FieldLocator fieldLocator;
                    FieldLocator.Resolution resolution;
                    StackManipulation stackManipulation2;
                    if (this.declaringType.represents(Void.TYPE)) {
                        fieldLocator = new FieldLocator.ForClassHierarchy(typeDescription);
                    } else {
                        fieldLocator = new FieldLocator.ForExactType(this.declaringType);
                    }
                    if (this.name.equals("")) {
                        resolution = FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription);
                    } else {
                        resolution = fieldLocator.locate(this.name);
                    }
                    if (!resolution.isResolved()) {
                        throw new IllegalStateException("Cannot resolve field " + this.name + " for " + typeDescription);
                    } else if (resolution.getField().isVisibleTo(typeDescription)) {
                        if (resolution.getField().isStatic()) {
                            stackManipulation2 = StackManipulation.Trivial.INSTANCE;
                        } else if (methodDescription.isStatic()) {
                            throw new IllegalStateException("Cannot access member field " + resolution.getField() + " from static " + methodDescription);
                        } else if (typeDescription.isAssignableTo(resolution.getField().getDeclaringType().asErasure())) {
                            stackManipulation2 = MethodVariableAccess.loadThis();
                        } else {
                            throw new IllegalStateException(typeDescription + " does not define " + resolution.getField());
                        }
                        StackManipulation assign = assigner.assign(generic, resolution.getField().getType(), this.typing);
                        if (assign.isValid()) {
                            return new StackManipulation.Compound(stackManipulation2, stackManipulation, assign, FieldAccess.forField(resolution.getField()).write());
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + resolution.getField());
                    } else {
                        throw new IllegalStateException(resolution.getField() + " is not visible to " + typeDescription);
                    }
                }
            }

            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToFields.class)
            @Repeatable(ToFields.class)
            public @interface ToField {
                Class<?> declaringType() default void.class;

                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                String value() default "";
            }

            ToField[] value();
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToReturned {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToReturned> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_RETURNED_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_RETURNED_TYPING = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToReturned.class).getDeclaredMethods();
                        TO_RETURNED_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_RETURNED_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToReturned> getAnnotationType() {
                        return ToReturned.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends ToReturned> loadable) {
                        if (z10) {
                            return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_RETURNED_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_RETURNED_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                        }
                        throw new IllegalStateException("Cannot write returned value from enter advice " + inDefinedShape);
                    }
                }

                protected Handler(int i10, Assigner.Typing typing2) {
                    this.index = i10;
                    this.typing = typing2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    StackManipulation assign = assigner.assign(generic, methodDescription.getReturnType(), this.typing);
                    if (assign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.of(methodDescription.getReturnType()).storeAt(argumentHandler.returned()));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + methodDescription.getReturnType());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThis {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final boolean exit;
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToThis> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_THIS_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_THIS_TYPING = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToThis.class).getDeclaredMethods();
                        TO_THIS_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_THIS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToThis> getAnnotationType() {
                        return ToThis.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends ToThis> loadable) {
                        return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_THIS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_THIS_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), z10));
                    }
                }

                protected Handler(int i10, Assigner.Typing typing2, boolean z10) {
                    this.index = i10;
                    this.typing = typing2;
                    this.exit = z10;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.exit == handler.exit && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode()) * 31) + (this.exit ? 1 : 0);
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.isStatic()) {
                        throw new IllegalStateException("Cannot assign this reference for static method " + methodDescription);
                    } else if (this.exit || !methodDescription.isConstructor()) {
                        StackManipulation assign = assigner.assign(generic, typeDescription.asGenericType(), this.typing);
                        if (assign.isValid()) {
                            return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.argument(0)));
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + typeDescription);
                    } else {
                        throw new IllegalStateException("Cannot assign this reference in constructor prior to initialization for " + methodDescription);
                    }
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThrown {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToThrown> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_THROWN_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_THROWN_TYPING = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToThrown.class).getDeclaredMethods();
                        TO_THROWN_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_THROWN_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToThrown> getAnnotationType() {
                        return ToThrown.class;
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z10, AnnotationDescription.Loadable<? extends ToThrown> loadable) {
                        if (!z10) {
                            throw new IllegalStateException("Cannot assign thrown value from enter advice " + inDefinedShape);
                        } else if (!((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class)).represents(NoExceptionHandler.class)) {
                            return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_THROWN_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_THROWN_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                        } else {
                            throw new IllegalStateException("Cannot assign thrown value for non-catching exit advice " + inDefinedShape);
                        }
                    }
                }

                protected Handler(int i10, Assigner.Typing typing2) {
                    this.index = i10;
                    this.typing = typing2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    StackManipulation assign = assigner.assign(generic, TypeDefinition.Sort.describe(Throwable.class), this.typing);
                    if (assign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.thrown()));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + Throwable.class.getName());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        protected AssignReturned(TypeDescription.Generic generic, ExceptionHandler.Factory factory, boolean z10, boolean z11) {
            this.type = generic;
            this.exceptionHandlerFactory = factory;
            this.exit = z10;
            this.skipOnDefaultValue = z11;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AssignReturned assignReturned = (AssignReturned) obj;
            return this.exit == assignReturned.exit && this.skipOnDefaultValue == assignReturned.skipOnDefaultValue && this.type.equals(assignReturned.type) && this.exceptionHandlerFactory.equals(assignReturned.exceptionHandlerFactory);
        }

        /* access modifiers changed from: protected */
        public abstract Collection<Handler> getHandlers();

        /* access modifiers changed from: protected */
        public abstract TypeDescription.Generic getType();

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.exceptionHandlerFactory.hashCode()) * 31) + (this.exit ? 1 : 0)) * 31) + (this.skipOnDefaultValue ? 1 : 0);
        }

        public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
            int i10;
            int i11;
            StackMapFrameHandler.ForPostProcessor forPostProcessor2 = forPostProcessor;
            ArrayList arrayList = new ArrayList(getHandlers().size());
            for (Handler next : getHandlers()) {
                TypeDescription.Generic type2 = getType();
                if (this.exit) {
                    i11 = argumentHandler.exit();
                } else {
                    i11 = argumentHandler.enter();
                }
                arrayList.add(next.resolve(typeDescription, methodDescription, assigner, argumentHandler, type2, toLoadInstruction(next, i11)));
            }
            StackManipulation wrap = this.exceptionHandlerFactory.wrap(new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), stackManipulation, forPostProcessor2);
            if (!this.skipOnDefaultValue) {
                return wrap;
            }
            if (this.exit) {
                i10 = argumentHandler.exit();
            } else {
                i10 = argumentHandler.enter();
            }
            return DefaultValueSkip.of(wrap, forPostProcessor2, i10, this.type);
        }

        /* access modifiers changed from: protected */
        public abstract StackManipulation toLoadInstruction(Handler handler, int i10);
    }

    public interface BootstrapArgumentResolver {

        public interface Factory {
            BootstrapArgumentResolver resolve(MethodDescription.InDefinedShape inDefinedShape, boolean z10);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDefaultValues implements BootstrapArgumentResolver {
            private final MethodDescription.InDefinedShape adviceMethod;
            private final boolean exit;

            public enum Factory implements Factory {
                INSTANCE;

                public BootstrapArgumentResolver resolve(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                    return new ForDefaultValues(inDefinedShape, z10);
                }
            }

            protected ForDefaultValues(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                this.adviceMethod = inDefinedShape;
                this.exit = z10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDefaultValues forDefaultValues = (ForDefaultValues) obj;
                return this.exit == forDefaultValues.exit && this.adviceMethod.equals(forDefaultValues.adviceMethod);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.adviceMethod.hashCode()) * 31) + (this.exit ? 1 : 0);
            }

            public List<JavaConstant> resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                if (methodDescription.isTypeInitializer()) {
                    return Arrays.asList(new JavaConstant[]{JavaConstant.Simple.ofLoaded(this.adviceMethod.getDeclaringType().getName()), JavaConstant.Simple.ofLoaded(Integer.valueOf(this.exit ? 1 : 0)), JavaConstant.Simple.of(typeDescription), JavaConstant.Simple.ofLoaded(methodDescription.getInternalName())});
                }
                return Arrays.asList(new JavaConstant[]{JavaConstant.Simple.ofLoaded(this.adviceMethod.getDeclaringType().getName()), JavaConstant.Simple.ofLoaded(Integer.valueOf(this.exit ? 1 : 0)), JavaConstant.Simple.of(typeDescription), JavaConstant.Simple.ofLoaded(methodDescription.getInternalName()), JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) methodDescription.asDefined())});
            }
        }

        List<JavaConstant> resolve(TypeDescription typeDescription, MethodDescription methodDescription);
    }

    protected interface Delegator {

        public interface Factory {
            Delegator make(MethodDescription.InDefinedShape inDefinedShape, boolean z10);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDynamicInvocation implements Delegator {
            private final MethodDescription.InDefinedShape adviceMethod;
            private final MethodDescription.InDefinedShape bootstrapMethod;
            private final BootstrapArgumentResolver resolver;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Factory implements Factory {
                private final MethodDescription.InDefinedShape bootstrapMethod;
                private final BootstrapArgumentResolver.Factory resolverFactory;

                protected Factory(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                    this.bootstrapMethod = inDefinedShape;
                    this.resolverFactory = factory;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.bootstrapMethod.equals(factory.bootstrapMethod) && this.resolverFactory.equals(factory.resolverFactory);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.bootstrapMethod.hashCode()) * 31) + this.resolverFactory.hashCode();
                }

                public Delegator make(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                    return new ForDynamicInvocation(this.bootstrapMethod, inDefinedShape, this.resolverFactory.resolve(inDefinedShape, z10));
                }
            }

            protected ForDynamicInvocation(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2, BootstrapArgumentResolver bootstrapArgumentResolver) {
                this.bootstrapMethod = inDefinedShape;
                this.adviceMethod = inDefinedShape2;
                this.resolver = bootstrapArgumentResolver;
            }

            protected static Factory of(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                if (inDefinedShape.isInvokeBootstrap()) {
                    return new Factory(inDefinedShape, factory);
                }
                throw new IllegalArgumentException("Not a suitable bootstrap target: " + inDefinedShape);
            }

            public StackManipulation apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                List<JavaConstant> resolve = this.resolver.resolve(typeDescription, methodDescription);
                if (this.bootstrapMethod.isInvokeBootstrap(TypeList.Explicit.of(resolve))) {
                    return MethodInvocation.invoke(this.bootstrapMethod).dynamic(this.adviceMethod.getInternalName(), this.adviceMethod.getReturnType().asErasure(), this.adviceMethod.getParameters().asTypeList().asErasures(), resolve);
                }
                throw new IllegalStateException("Cannot invoke " + this.bootstrapMethod + " with arguments: " + resolve);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDynamicInvocation forDynamicInvocation = (ForDynamicInvocation) obj;
                return this.bootstrapMethod.equals(forDynamicInvocation.bootstrapMethod) && this.adviceMethod.equals(forDynamicInvocation.adviceMethod) && this.resolver.equals(forDynamicInvocation.resolver);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.bootstrapMethod.hashCode()) * 31) + this.adviceMethod.hashCode()) * 31) + this.resolver.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForRegularInvocation implements Delegator {
            private final MethodDescription.InDefinedShape adviceMethod;

            protected enum Factory implements Factory {
                INSTANCE;

                public Delegator make(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                    return new ForRegularInvocation(inDefinedShape);
                }
            }

            protected ForRegularInvocation(MethodDescription.InDefinedShape inDefinedShape) {
                this.adviceMethod = inDefinedShape;
            }

            public StackManipulation apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                return MethodInvocation.invoke(this.adviceMethod);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.adviceMethod.equals(((ForRegularInvocation) obj).adviceMethod);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.adviceMethod.hashCode();
            }
        }

        StackManipulation apply(TypeDescription typeDescription, MethodDescription methodDescription);
    }

    protected interface Dispatcher {
        @AlwaysNull
        public static final AnnotationVisitor IGNORE_ANNOTATION = null;
        @AlwaysNull
        public static final MethodVisitor IGNORE_METHOD = null;

        public interface Bound {
            void apply();

            void initialize();

            void prepare();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Delegating implements Unresolved {
            protected final MethodDescription.InDefinedShape adviceMethod;
            protected final Delegator.Factory delegatorFactory;

            protected static abstract class Resolved extends Resolved.AbstractBase {
                protected final Delegator delegator;

                protected static abstract class AdviceMethodWriter implements Bound {
                    protected final MethodDescription.InDefinedShape adviceMethod;
                    protected final ArgumentHandler.ForAdvice argumentHandler;
                    private final Assigner assigner;
                    private final Delegator delegator;
                    private final StackManipulation exceptionHandler;
                    protected final Implementation.Context implementationContext;
                    private final MethodDescription instrumentedMethod;
                    private final TypeDescription instrumentedType;
                    protected final MethodSizeHandler.ForAdvice methodSizeHandler;
                    protected final MethodVisitor methodVisitor;
                    private final List<OffsetMapping.Target> offsetMappings;
                    private final PostProcessor postProcessor;
                    private final RelocationHandler.Bound relocationHandler;
                    protected final StackMapFrameHandler.ForAdvice stackMapFrameHandler;
                    private final SuppressionHandler.Bound suppressionHandler;

                    protected static class ForMethodEnter extends AdviceMethodWriter {
                        protected ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, Delegator delegator) {
                            super(inDefinedShape, typeDescription, methodDescription, assigner, postProcessor, list, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, delegator);
                        }

                        public void initialize() {
                        }

                        /* access modifiers changed from: protected */
                        public boolean isExitAdvice() {
                            return false;
                        }
                    }

                    protected static class ForMethodExit extends AdviceMethodWriter {
                        protected ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, Delegator delegator) {
                            super(inDefinedShape, typeDescription, methodDescription, assigner, postProcessor, list, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, delegator);
                        }

                        public void initialize() {
                            if (this.adviceMethod.getReturnType().represents(Boolean.TYPE) || this.adviceMethod.getReturnType().represents(Byte.TYPE) || this.adviceMethod.getReturnType().represents(Short.TYPE) || this.adviceMethod.getReturnType().represents(Character.TYPE) || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                                this.methodVisitor.visitInsn(3);
                                this.methodVisitor.visitVarInsn(54, this.argumentHandler.exit());
                            } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                                this.methodVisitor.visitInsn(9);
                                this.methodVisitor.visitVarInsn(55, this.argumentHandler.exit());
                            } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                                this.methodVisitor.visitInsn(11);
                                this.methodVisitor.visitVarInsn(56, this.argumentHandler.exit());
                            } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                                this.methodVisitor.visitInsn(14);
                                this.methodVisitor.visitVarInsn(57, this.argumentHandler.exit());
                            } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                                this.methodVisitor.visitInsn(1);
                                this.methodVisitor.visitVarInsn(58, this.argumentHandler.exit());
                            }
                            this.methodSizeHandler.requireStackSize(this.adviceMethod.getReturnType().getStackSize().getSize());
                        }

                        /* access modifiers changed from: protected */
                        public boolean isExitAdvice() {
                            return true;
                        }
                    }

                    protected AdviceMethodWriter(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner2, PostProcessor postProcessor2, List<OffsetMapping.Target> list, MethodVisitor methodVisitor2, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, Delegator delegator2) {
                        this.adviceMethod = inDefinedShape;
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.assigner = assigner2;
                        this.postProcessor = postProcessor2;
                        this.offsetMappings = list;
                        this.methodVisitor = methodVisitor2;
                        this.implementationContext = context;
                        this.argumentHandler = forAdvice;
                        this.methodSizeHandler = forAdvice2;
                        this.stackMapFrameHandler = forAdvice3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.exceptionHandler = stackManipulation;
                        this.delegator = delegator2;
                    }

                    public void apply() {
                        int i10;
                        int i11;
                        int i12;
                        int i13;
                        int i14;
                        int i15;
                        this.suppressionHandler.onStart(this.methodVisitor);
                        int i16 = 0;
                        int i17 = 0;
                        int i18 = 0;
                        for (OffsetMapping.Target resolveRead : this.offsetMappings) {
                            i17 += ((ParameterDescription.InDefinedShape) this.adviceMethod.getParameters().get(i18)).getType().getStackSize().getSize();
                            i16 = Math.max(i16, resolveRead.resolveRead().apply(this.methodVisitor, this.implementationContext).getMaximalSize() + i17);
                            i18++;
                        }
                        int max = Math.max(i16, this.delegator.apply(this.instrumentedType, this.instrumentedMethod).apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                        this.suppressionHandler.onEndWithSkip(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, this.adviceMethod.getReturnType());
                        if (this.adviceMethod.getReturnType().represents(Boolean.TYPE) || this.adviceMethod.getReturnType().represents(Byte.TYPE) || this.adviceMethod.getReturnType().represents(Short.TYPE) || this.adviceMethod.getReturnType().represents(Character.TYPE) || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                            MethodVisitor methodVisitor2 = this.methodVisitor;
                            if (isExitAdvice()) {
                                i11 = this.argumentHandler.exit();
                            } else {
                                i11 = this.argumentHandler.enter();
                            }
                            methodVisitor2.visitVarInsn(54, i11);
                        } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                            MethodVisitor methodVisitor3 = this.methodVisitor;
                            if (isExitAdvice()) {
                                i15 = this.argumentHandler.exit();
                            } else {
                                i15 = this.argumentHandler.enter();
                            }
                            methodVisitor3.visitVarInsn(55, i15);
                        } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                            MethodVisitor methodVisitor4 = this.methodVisitor;
                            if (isExitAdvice()) {
                                i14 = this.argumentHandler.exit();
                            } else {
                                i14 = this.argumentHandler.enter();
                            }
                            methodVisitor4.visitVarInsn(56, i14);
                        } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                            MethodVisitor methodVisitor5 = this.methodVisitor;
                            if (isExitAdvice()) {
                                i13 = this.argumentHandler.exit();
                            } else {
                                i13 = this.argumentHandler.enter();
                            }
                            methodVisitor5.visitVarInsn(57, i13);
                        } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                            MethodVisitor methodVisitor6 = this.methodVisitor;
                            if (isExitAdvice()) {
                                i12 = this.argumentHandler.exit();
                            } else {
                                i12 = this.argumentHandler.enter();
                            }
                            methodVisitor6.visitVarInsn(58, i12);
                        }
                        this.methodSizeHandler.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler).apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                        MethodSizeHandler.ForAdvice forAdvice = this.methodSizeHandler;
                        RelocationHandler.Bound bound = this.relocationHandler;
                        MethodVisitor methodVisitor7 = this.methodVisitor;
                        Implementation.Context context = this.implementationContext;
                        if (isExitAdvice()) {
                            i10 = this.argumentHandler.exit();
                        } else {
                            i10 = this.argumentHandler.enter();
                        }
                        forAdvice.requireStackSize(bound.apply(methodVisitor7, context, i10));
                        this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
                        this.methodSizeHandler.requireStackSize(Math.max(max, this.adviceMethod.getReturnType().getStackSize().getSize()));
                        this.methodSizeHandler.requireLocalVariableLength(this.instrumentedMethod.getStackSize() + this.adviceMethod.getReturnType().getStackSize().getSize());
                    }

                    /* access modifiers changed from: protected */
                    public abstract boolean isExitAdvice();

                    public void prepare() {
                        this.suppressionHandler.onPrepare(this.methodVisitor);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final boolean prependLineNumber;

                    protected static class WithDiscardedEnterType extends ForMethodEnter {
                        protected WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        /* access modifiers changed from: protected */
                        public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                            forAdvice2.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize());
                            return super.doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation);
                        }

                        public TypeDefinition getAdviceType() {
                            return TypeDescription.ForLoadedType.of(Void.TYPE);
                        }
                    }

                    protected static class WithRetainedEnterType extends ForMethodEnter {
                        protected WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        public TypeDefinition getAdviceType() {
                            return this.adviceMethod.getReturnType();
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected ForMethodEnter(net.bytebuddy.description.method.MethodDescription.InDefinedShape r9, net.bytebuddy.asm.Advice.PostProcessor r10, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r11, net.bytebuddy.description.type.TypeDefinition r12, net.bytebuddy.asm.Advice.Delegator r13) {
                        /*
                            r8 = this;
                            r0 = 15
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r2 = 0
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r2 = 1
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r2 = 2
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r2 = 3
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$ReaderFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE
                            r2 = 4
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$WriterFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE
                            r2 = 5
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r2 = 6
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForSelfCallHandle$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle.Factory.INSTANCE
                            r2 = 7
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r2 = 8
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r2 = 9
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r12 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.of(r12)
                            r1 = 10
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Thrown> r1 = net.bytebuddy.asm.Advice.Thrown.class
                            r12.<init>(r1)
                            r1 = 11
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Enter> r1 = net.bytebuddy.asm.Advice.Enter.class
                            r12.<init>(r1)
                            r1 = 12
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Local> r1 = net.bytebuddy.asm.Advice.Local.class
                            r12.<init>(r1)
                            r1 = 13
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Return> r1 = net.bytebuddy.asm.Advice.Return.class
                            r12.<init>(r1)
                            r1 = 14
                            r0[r1] = r12
                            java.util.List r12 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r12, r11)
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r12 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.SUPPRESS_ENTER
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r12 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r12)
                            r4 = r11
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r12 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.SKIP_ON
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r12 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r12)
                            r5 = r11
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r12 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.SKIP_ON_INDEX
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<java.lang.Integer> r12 = java.lang.Integer.class
                            java.lang.Object r11 = r11.resolve(r12)
                            java.lang.Integer r11 = (java.lang.Integer) r11
                            int r6 = r11.intValue()
                            r0 = r8
                            r1 = r9
                            r2 = r10
                            r7 = r13
                            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                            net.bytebuddy.description.annotation.AnnotationList r9 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r10 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r9 = r9.ofType(r10)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r10 = net.bytebuddy.asm.Advice.PREPEND_LINE_NUMBER
                            net.bytebuddy.description.annotation.AnnotationValue r9 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r10)
                            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
                            java.lang.Object r9 = r9.resolve(r10)
                            java.lang.Boolean r9 = (java.lang.Boolean) r9
                            boolean r9 = r9.booleanValue()
                            r8.prependLineNumber = r9
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodEnter.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.List, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.asm.Advice$Delegator):void");
                    }

                    protected static Resolved.ForMethodEnter of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Delegator delegator, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, boolean z10) {
                        return z10 ? new WithRetainedEnterType(inDefinedShape, postProcessor, list, typeDefinition, delegator) : new WithDiscardedEnterType(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                    }

                    /* access modifiers changed from: protected */
                    public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                        for (OffsetMapping resolve : this.offsetMappings.values()) {
                            arrayList.add(resolve.resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new AdviceMethodWriter.ForMethodEnter(this.adviceMethod, typeDescription, methodDescription, assigner, this.postProcessor, arrayList, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, this.delegator);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.prependLineNumber == ((ForMethodEnter) obj).prependLineNumber;
                    }

                    public TypeDefinition getActualAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }

                    /* access modifiers changed from: protected */
                    public Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        StackManipulation stackManipulation2 = stackManipulation;
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod.bindEnter(this.adviceMethod), forInstrumentedMethod2.bindEnter(this.adviceMethod), forInstrumentedMethod3.bindEnter(this.adviceMethod), this.suppressionHandler.bind(stackManipulation2), this.relocationHandler.bind(methodDescription, relocation), stackManipulation2);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        protected WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, TypeDescription typeDescription, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                            this.throwable = typeDescription;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + this.throwable.hashCode();
                        }
                    }

                    protected static class WithoutExceptionHandler extends ForMethodExit {
                        protected WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                        }

                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected ForMethodExit(net.bytebuddy.description.method.MethodDescription.InDefinedShape r9, net.bytebuddy.asm.Advice.PostProcessor r10, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r11, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r12, net.bytebuddy.description.type.TypeDefinition r13, net.bytebuddy.asm.Advice.Delegator r14) {
                        /*
                            r8 = this;
                            r0 = 15
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r2 = 0
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r2 = 1
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r2 = 2
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r2 = 3
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$ReaderFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE
                            r2 = 4
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$WriterFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE
                            r2 = 5
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r2 = 6
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForSelfCallHandle$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle.Factory.INSTANCE
                            r2 = 7
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r2 = 8
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r2 = 9
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r13 = net.bytebuddy.asm.Advice.OffsetMapping.ForEnterValue.Factory.of(r13)
                            r1 = 10
                            r0[r1] = r13
                            net.bytebuddy.description.type.TypeDescription$Generic r13 = r9.getReturnType()
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r13 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.of(r13)
                            r1 = 11
                            r0[r1] = r13
                            net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory r13 = new net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory
                            r13.<init>(r11)
                            r11 = 12
                            r0[r11] = r13
                            net.bytebuddy.asm.Advice$OffsetMapping$ForReturnValue$Factory r11 = net.bytebuddy.asm.Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE
                            r13 = 13
                            r0[r13] = r11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r11 = net.bytebuddy.asm.Advice.OffsetMapping.ForThrowable.Factory.of(r9)
                            r13 = 14
                            r0[r13] = r11
                            java.util.List r11 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r11, r12)
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r12 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.SUPPRESS_EXIT
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r12 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r12)
                            r4 = r11
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r12 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.REPEAT_ON
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r12 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r12)
                            r5 = r11
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r12 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.REPEAT_ON_INDEX
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<java.lang.Integer> r12 = java.lang.Integer.class
                            java.lang.Object r11 = r11.resolve(r12)
                            java.lang.Integer r11 = (java.lang.Integer) r11
                            int r6 = r11.intValue()
                            r0 = r8
                            r1 = r9
                            r2 = r10
                            r7 = r14
                            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                            net.bytebuddy.description.annotation.AnnotationList r9 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r10 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r9 = r9.ofType(r10)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r10 = net.bytebuddy.asm.Advice.BACKUP_ARGUMENTS
                            net.bytebuddy.description.annotation.AnnotationValue r9 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r10)
                            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
                            java.lang.Object r9 = r9.resolve(r10)
                            java.lang.Boolean r9 = (java.lang.Boolean) r9
                            boolean r9 = r9.booleanValue()
                            r8.backupArguments = r9
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodExit.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.Map, java.util.List, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.asm.Advice$Delegator):void");
                    }

                    private Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                        for (OffsetMapping resolve : this.offsetMappings.values()) {
                            arrayList.add(resolve.resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new AdviceMethodWriter.ForMethodExit(this.adviceMethod, typeDescription, methodDescription, assigner, this.postProcessor, arrayList, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, this.delegator);
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    protected static Resolved.ForMethodExit of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Delegator delegator, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class);
                        if (typeDescription.represents(NoExceptionHandler.class)) {
                            return new WithoutExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                        }
                        return new WithExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition, typeDescription, delegator);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.backupArguments == ((ForMethodExit) obj).backupArguments;
                    }

                    public TypeDefinition getAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.backupArguments ? 1 : 0);
                    }

                    /* access modifiers changed from: protected */
                    public Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        StackManipulation stackManipulation2 = stackManipulation;
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod.bindExit(this.adviceMethod, getThrowable().represents(NoExceptionHandler.class)), forInstrumentedMethod2.bindExit(this.adviceMethod), forInstrumentedMethod3.bindExit(this.adviceMethod), this.suppressionHandler.bind(stackManipulation2), this.relocationHandler.bind(methodDescription, relocation), stackManipulation2);
                    }
                }

                protected Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, int i10, Delegator delegator2) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, i10, OffsetMapping.Factory.AdviceType.DELEGATION);
                    this.delegator = delegator2;
                }

                public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                    if (this.adviceMethod.isVisibleTo(typeDescription)) {
                        return resolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, stackManipulation, relocation);
                    }
                    throw new IllegalStateException(this.adviceMethod + " is not visible to " + methodDescription.getDeclaringType());
                }

                public Map<String, TypeDefinition> getNamedTypes() {
                    return Collections.emptyMap();
                }

                /* access modifiers changed from: protected */
                public abstract Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation);
            }

            protected Delegating(MethodDescription.InDefinedShape inDefinedShape, Delegator.Factory factory) {
                this.adviceMethod = inDefinedShape;
                this.delegatorFactory = factory;
            }

            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodEnter.of(inDefinedShape, factory.make(inDefinedShape, false), this.delegatorFactory.make(this.adviceMethod, false), list, unresolved.getAdviceType(), unresolved.isAlive());
            }

            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                Map<String, TypeDefinition> namedTypes = unresolved.getNamedTypes();
                for (ParameterDescription parameterDescription : this.adviceMethod.getParameters()) {
                    AnnotationDescription.Loadable<Local> ofType = parameterDescription.getDeclaredAnnotations().ofType(Local.class);
                    if (ofType != null) {
                        String str = (String) ofType.getValue(OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class);
                        TypeDefinition typeDefinition = namedTypes.get(str);
                        if (typeDefinition == null) {
                            throw new IllegalStateException(this.adviceMethod + " attempts use of undeclared local variable " + str);
                        } else if (!typeDefinition.equals(parameterDescription.getType())) {
                            throw new IllegalStateException(this.adviceMethod + " does not read variable " + str + " as " + typeDefinition);
                        }
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodExit.of(inDefinedShape, factory.make(inDefinedShape, true), this.delegatorFactory.make(this.adviceMethod, true), namedTypes, list, unresolved.getAdviceType());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Delegating delegating = (Delegating) obj;
                return this.adviceMethod.equals(delegating.adviceMethod) && this.delegatorFactory.equals(delegating.delegatorFactory);
            }

            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.emptyMap();
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.adviceMethod.hashCode()) * 31) + this.delegatorFactory.hashCode();
            }

            public boolean isAlive() {
                return true;
            }

            public boolean isBinary() {
                return false;
            }

            public TypeDescription getAdviceType() {
                return this.adviceMethod.getReturnType().asErasure();
            }
        }

        public enum Inactive implements Unresolved, Resolved.ForMethodEnter, Resolved.ForMethodExit, Bound {
            INSTANCE;

            public void apply() {
            }

            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                return this;
            }

            public TypeDefinition getActualAdviceType() {
                return TypeDescription.ForLoadedType.of(Void.TYPE);
            }

            public ArgumentHandler.Factory getArgumentHandlerFactory() {
                return ArgumentHandler.Factory.SIMPLE;
            }

            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.emptyMap();
            }

            public TypeDescription getThrowable() {
                return NoExceptionHandler.DESCRIPTION;
            }

            public void initialize() {
            }

            public boolean isAlive() {
                return false;
            }

            public boolean isBinary() {
                return false;
            }

            public boolean isPrependLineNumber() {
                return false;
            }

            public void prepare() {
            }

            public TypeDescription getAdviceType() {
                return TypeDescription.ForLoadedType.of(Void.TYPE);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Inlining implements Unresolved {
            protected final MethodDescription.InDefinedShape adviceMethod;
            private final Map<String, TypeDefinition> namedTypes = new HashMap();

            protected static class CodeTranslationVisitor extends MethodVisitor {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final ArgumentHandler.ForAdvice argumentHandler;
                private final Assigner assigner;
                protected final Label endOfMethod = new Label();
                private final StackManipulation exceptionHandler;
                private final boolean exit;
                protected final Implementation.Context implementationContext;
                private final MethodDescription instrumentedMethod;
                private final TypeDescription instrumentedType;
                protected final MethodSizeHandler.ForAdvice methodSizeHandler;
                protected final MethodVisitor methodVisitor;
                private final Map<Integer, OffsetMapping.Target> offsetMappings;
                private final PostProcessor postProcessor;
                private final RelocationHandler.Bound relocationHandler;
                protected final StackMapFrameHandler.ForAdvice stackMapFrameHandler;
                private final SuppressionHandler.Bound suppressionHandler;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                protected CodeTranslationVisitor(MethodVisitor methodVisitor2, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner2, MethodDescription.InDefinedShape inDefinedShape, Map<Integer, OffsetMapping.Target> map, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, PostProcessor postProcessor2, boolean z10) {
                    super(OpenedClassReader.ASM_API, StackAwareMethodVisitor.of(methodVisitor2, methodDescription));
                    this.methodVisitor = methodVisitor2;
                    this.implementationContext = context;
                    this.argumentHandler = forAdvice;
                    this.methodSizeHandler = forAdvice2;
                    this.stackMapFrameHandler = forAdvice3;
                    this.instrumentedType = typeDescription;
                    this.instrumentedMethod = methodDescription;
                    this.assigner = assigner2;
                    this.adviceMethod = inDefinedShape;
                    this.offsetMappings = map;
                    this.suppressionHandler = bound;
                    this.relocationHandler = bound2;
                    this.exceptionHandler = stackManipulation;
                    this.postProcessor = postProcessor2;
                    this.exit = z10;
                }

                /* access modifiers changed from: protected */
                public void propagateHandler(Label label) {
                    ((StackAwareMethodVisitor) this.mv).register(label, Collections.singletonList(StackSize.SINGLE));
                }

                public void visitAnnotableParameterCount(int i10, boolean z10) {
                }

                @MaybeNull
                public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @MaybeNull
                public AnnotationVisitor visitAnnotationDefault() {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                public void visitAttribute(Attribute attribute) {
                }

                public void visitCode() {
                    this.suppressionHandler.onStart(this.methodVisitor);
                }

                public void visitEnd() {
                    int i10;
                    int i11;
                    int i12;
                    int i13;
                    int i14;
                    int i15;
                    this.suppressionHandler.onEnd(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, this.adviceMethod.getReturnType());
                    this.methodVisitor.visitLabel(this.endOfMethod);
                    if (this.adviceMethod.getReturnType().represents(Boolean.TYPE) || this.adviceMethod.getReturnType().represents(Byte.TYPE) || this.adviceMethod.getReturnType().represents(Short.TYPE) || this.adviceMethod.getReturnType().represents(Character.TYPE) || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        MethodVisitor methodVisitor2 = this.methodVisitor;
                        if (this.exit) {
                            i11 = this.argumentHandler.exit();
                        } else {
                            i11 = this.argumentHandler.enter();
                        }
                        methodVisitor2.visitVarInsn(54, i11);
                    } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        MethodVisitor methodVisitor3 = this.methodVisitor;
                        if (this.exit) {
                            i15 = this.argumentHandler.exit();
                        } else {
                            i15 = this.argumentHandler.enter();
                        }
                        methodVisitor3.visitVarInsn(55, i15);
                    } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        MethodVisitor methodVisitor4 = this.methodVisitor;
                        if (this.exit) {
                            i14 = this.argumentHandler.exit();
                        } else {
                            i14 = this.argumentHandler.enter();
                        }
                        methodVisitor4.visitVarInsn(56, i14);
                    } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        MethodVisitor methodVisitor5 = this.methodVisitor;
                        if (this.exit) {
                            i13 = this.argumentHandler.exit();
                        } else {
                            i13 = this.argumentHandler.enter();
                        }
                        methodVisitor5.visitVarInsn(57, i13);
                    } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        MethodVisitor methodVisitor6 = this.methodVisitor;
                        if (this.exit) {
                            i12 = this.argumentHandler.exit();
                        } else {
                            i12 = this.argumentHandler.enter();
                        }
                        methodVisitor6.visitVarInsn(58, i12);
                    }
                    this.methodSizeHandler.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler).apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                    MethodSizeHandler.ForAdvice forAdvice = this.methodSizeHandler;
                    RelocationHandler.Bound bound = this.relocationHandler;
                    MethodVisitor methodVisitor7 = this.methodVisitor;
                    Implementation.Context context = this.implementationContext;
                    if (this.exit) {
                        i10 = this.argumentHandler.exit();
                    } else {
                        i10 = this.argumentHandler.enter();
                    }
                    forAdvice.requireStackSize(bound.apply(methodVisitor7, context, i10));
                    this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
                }

                public void visitFrame(int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                    this.stackMapFrameHandler.translateFrame(this.methodVisitor, i10, i11, objArr, i12, objArr2);
                }

                public void visitIincInsn(int i10, int i11) {
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i10));
                    if (target != null) {
                        this.methodSizeHandler.requireStackSizePadding(target.resolveIncrement(i11).apply(this.mv, this.implementationContext).getMaximalSize());
                    } else {
                        this.mv.visitIincInsn(this.argumentHandler.mapped(i10), i11);
                    }
                }

                public void visitInsn(int i10) {
                    switch (i10) {
                        case Opcodes.IRETURN:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(54, 21, StackSize.SINGLE));
                            break;
                        case Opcodes.LRETURN:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(55, 22, StackSize.DOUBLE));
                            break;
                        case Opcodes.FRETURN:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(56, 23, StackSize.SINGLE));
                            break;
                        case Opcodes.DRETURN:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(57, 24, StackSize.DOUBLE));
                            break;
                        case Opcodes.ARETURN:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(58, 25, StackSize.SINGLE));
                            break;
                        case Opcodes.RETURN:
                            ((StackAwareMethodVisitor) this.mv).drainStack();
                            break;
                        default:
                            this.mv.visitInsn(i10);
                            return;
                    }
                    this.mv.visitJumpInsn(Opcodes.GOTO, this.endOfMethod);
                }

                public void visitMaxs(int i10, int i11) {
                    this.methodSizeHandler.recordMaxima(i10, i11);
                }

                public void visitParameter(String str, int i10) {
                }

                @MaybeNull
                public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @MaybeNull
                public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                public void visitVarInsn(int i10, int i11) {
                    StackSize stackSize;
                    StackManipulation stackManipulation;
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i11));
                    if (target != null) {
                        switch (i10) {
                            case 21:
                            case 23:
                            case 25:
                                stackManipulation = target.resolveRead();
                                stackSize = StackSize.SINGLE;
                                break;
                            case 22:
                            case 24:
                                stackManipulation = target.resolveRead();
                                stackSize = StackSize.DOUBLE;
                                break;
                            default:
                                switch (i10) {
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                        stackManipulation = target.resolveWrite();
                                        stackSize = StackSize.ZERO;
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected opcode: " + i10);
                                }
                        }
                        this.methodSizeHandler.requireStackSizePadding(stackManipulation.apply(this.mv, this.implementationContext).getMaximalSize() - stackSize.getSize());
                        return;
                    }
                    this.mv.visitVarInsn(i10, this.argumentHandler.mapped(i11));
                }
            }

            protected static abstract class Resolved extends Resolved.AbstractBase {
                protected final ClassReader classReader;

                @HashCodeAndEqualsPlugin.Enhance
                protected static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final Map<String, TypeDefinition> namedTypes;
                    private final boolean prependLineNumber;

                    protected static class WithDiscardedEnterType extends ForMethodEnter {
                        protected WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                        }

                        /* access modifiers changed from: protected */
                        public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                            forAdvice2.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize());
                            return super.doApply(methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, bound, bound2, stackManipulation);
                        }

                        public TypeDefinition getAdviceType() {
                            return TypeDescription.ForLoadedType.of(Void.TYPE);
                        }
                    }

                    protected static class WithRetainedEnterType extends ForMethodEnter {
                        protected WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                        }

                        public TypeDefinition getAdviceType() {
                            return this.adviceMethod.getReturnType();
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected ForMethodEnter(net.bytebuddy.description.method.MethodDescription.InDefinedShape r9, net.bytebuddy.asm.Advice.PostProcessor r10, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r11, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r12, net.bytebuddy.description.type.TypeDefinition r13, net.bytebuddy.jar.asm.ClassReader r14) {
                        /*
                            r8 = this;
                            r0 = 16
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r2 = 0
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r2 = 1
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r2 = 2
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r2 = 3
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$ReaderFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE
                            r2 = 4
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$WriterFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE
                            r2 = 5
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r2 = 6
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForSelfCallHandle$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle.Factory.INSTANCE
                            r2 = 7
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r2 = 8
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r2 = 9
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThrowable$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForThrowable.Factory.INSTANCE
                            r2 = 10
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r13 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.of(r13)
                            r1 = 11
                            r0[r1] = r13
                            net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory r13 = new net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory
                            r13.<init>(r11)
                            r1 = 12
                            r0[r1] = r13
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r13 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Thrown> r1 = net.bytebuddy.asm.Advice.Thrown.class
                            r13.<init>(r1)
                            r1 = 13
                            r0[r1] = r13
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r13 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Enter> r1 = net.bytebuddy.asm.Advice.Enter.class
                            r13.<init>(r1)
                            r1 = 14
                            r0[r1] = r13
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r13 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Return> r1 = net.bytebuddy.asm.Advice.Return.class
                            r13.<init>(r1)
                            r1 = 15
                            r0[r1] = r13
                            java.util.List r13 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r13, r12)
                            net.bytebuddy.description.annotation.AnnotationList r12 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r13 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r12 = r12.ofType(r13)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r13 = net.bytebuddy.asm.Advice.SUPPRESS_ENTER
                            net.bytebuddy.description.annotation.AnnotationValue r12 = r12.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r13 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r12 = r12.resolve(r13)
                            r4 = r12
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r12 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r13 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r12 = r12.ofType(r13)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r13 = net.bytebuddy.asm.Advice.SKIP_ON
                            net.bytebuddy.description.annotation.AnnotationValue r12 = r12.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r13 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r12 = r12.resolve(r13)
                            r5 = r12
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            net.bytebuddy.description.annotation.AnnotationList r12 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r13 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r12 = r12.ofType(r13)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r13 = net.bytebuddy.asm.Advice.SKIP_ON_INDEX
                            net.bytebuddy.description.annotation.AnnotationValue r12 = r12.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                            java.lang.Class<java.lang.Integer> r13 = java.lang.Integer.class
                            java.lang.Object r12 = r12.resolve(r13)
                            java.lang.Integer r12 = (java.lang.Integer) r12
                            int r6 = r12.intValue()
                            r0 = r8
                            r1 = r9
                            r2 = r10
                            r7 = r14
                            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                            r8.namedTypes = r11
                            net.bytebuddy.description.annotation.AnnotationList r9 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r10 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r9 = r9.ofType(r10)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r10 = net.bytebuddy.asm.Advice.PREPEND_LINE_NUMBER
                            net.bytebuddy.description.annotation.AnnotationValue r9 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r10)
                            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
                            java.lang.Object r9 = r9.resolve(r10)
                            java.lang.Boolean r9 = (java.lang.Boolean) r9
                            boolean r9 = r9.booleanValue()
                            r8.prependLineNumber = r9
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodEnter.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.Map, java.util.List, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.jar.asm.ClassReader):void");
                    }

                    protected static Resolved.ForMethodEnter of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader, boolean z10) {
                        return z10 ? new WithRetainedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition, classReader) : new WithDiscardedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                    }

                    /* access modifiers changed from: protected */
                    public MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        return doApply(methodVisitor, context, assigner, forInstrumentedMethod.bindEnter(this.adviceMethod), forInstrumentedMethod2.bindEnter(this.adviceMethod), forInstrumentedMethod3.bindEnter(this.adviceMethod), typeDescription, methodDescription, bound, bound2, stackManipulation);
                    }

                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        StackManipulation stackManipulation2 = stackManipulation;
                        MethodDescription methodDescription2 = methodDescription;
                        return new AdviceMethodInliner(typeDescription, methodDescription2, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, this.suppressionHandler.bind(stackManipulation2), this.relocationHandler.bind(methodDescription2, relocation), stackManipulation2, this.classReader);
                    }

                    /* access modifiers changed from: protected */
                    public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry next : this.offsetMappings.entrySet()) {
                            hashMap.put(next.getKey(), ((OffsetMapping) next.getValue()).resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, assigner, this.adviceMethod, hashMap, bound, bound2, stackManipulation, this.postProcessor, false);
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
                        ForMethodEnter forMethodEnter = (ForMethodEnter) obj;
                        return this.prependLineNumber == forMethodEnter.prependLineNumber && this.namedTypes.equals(forMethodEnter.namedTypes);
                    }

                    public TypeDefinition getActualAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.namedTypes;
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.namedTypes.hashCode()) * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }

                    /* access modifiers changed from: protected */
                    public Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry next : this.namedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named((String) next.getKey())), next.getValue());
                        }
                        return treeMap;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;
                    private final Map<String, TypeDefinition> uninitializedNamedTypes;

                    @HashCodeAndEqualsPlugin.Enhance
                    protected static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        protected WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition, TypeDescription typeDescription) {
                            super(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                            this.throwable = typeDescription;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + this.throwable.hashCode();
                        }
                    }

                    protected static class WithoutExceptionHandler extends ForMethodExit {
                        protected WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                            super(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                        }

                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected ForMethodExit(net.bytebuddy.description.method.MethodDescription.InDefinedShape r9, net.bytebuddy.asm.Advice.PostProcessor r10, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r11, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r12, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r13, net.bytebuddy.jar.asm.ClassReader r14, net.bytebuddy.description.type.TypeDefinition r15) {
                        /*
                            r8 = this;
                            r0 = 15
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r2 = 0
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r2 = 1
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r2 = 2
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r2 = 3
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$ReaderFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE
                            r2 = 4
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForFieldHandle$Unresolved$WriterFactory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE
                            r2 = 5
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r2 = 6
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForSelfCallHandle$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle.Factory.INSTANCE
                            r2 = 7
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r2 = 8
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r2 = 9
                            r0[r2] = r1
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r15 = net.bytebuddy.asm.Advice.OffsetMapping.ForEnterValue.Factory.of(r15)
                            r1 = 10
                            r0[r1] = r15
                            net.bytebuddy.description.type.TypeDescription$Generic r15 = r9.getReturnType()
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r15 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.of(r15)
                            r1 = 11
                            r0[r1] = r15
                            net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory r15 = new net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory
                            r15.<init>(r11)
                            r11 = 12
                            r0[r11] = r15
                            net.bytebuddy.asm.Advice$OffsetMapping$ForReturnValue$Factory r11 = net.bytebuddy.asm.Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE
                            r15 = 13
                            r0[r15] = r11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r11 = net.bytebuddy.asm.Advice.OffsetMapping.ForThrowable.Factory.of(r9)
                            r15 = 14
                            r0[r15] = r11
                            java.util.List r11 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r11, r13)
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r13 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r13)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r13 = net.bytebuddy.asm.Advice.SUPPRESS_EXIT
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r13 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r13)
                            r4 = r11
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r13 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r13)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r13 = net.bytebuddy.asm.Advice.REPEAT_ON
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r13 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r13)
                            r5 = r11
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            net.bytebuddy.description.annotation.AnnotationList r11 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r13 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r13)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r13 = net.bytebuddy.asm.Advice.REPEAT_ON_INDEX
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                            java.lang.Class<java.lang.Integer> r13 = java.lang.Integer.class
                            java.lang.Object r11 = r11.resolve(r13)
                            java.lang.Integer r11 = (java.lang.Integer) r11
                            int r6 = r11.intValue()
                            r0 = r8
                            r1 = r9
                            r2 = r10
                            r7 = r14
                            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                            r8.uninitializedNamedTypes = r12
                            net.bytebuddy.description.annotation.AnnotationList r9 = r9.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r10 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r9 = r9.ofType(r10)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r10 = net.bytebuddy.asm.Advice.BACKUP_ARGUMENTS
                            net.bytebuddy.description.annotation.AnnotationValue r9 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r10)
                            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
                            java.lang.Object r9 = r9.resolve(r10)
                            java.lang.Boolean r9 = (java.lang.Boolean) r9
                            boolean r9 = r9.booleanValue()
                            r8.backupArguments = r9
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodExit.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.Map, java.util.Map, java.util.List, net.bytebuddy.jar.asm.ClassReader, net.bytebuddy.description.type.TypeDefinition):void");
                    }

                    private MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry next : this.offsetMappings.entrySet()) {
                            hashMap.put(next.getKey(), ((OffsetMapping) next.getValue()).resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, assigner, this.adviceMethod, hashMap, bound, bound2, stackManipulation, this.postProcessor, true);
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    protected static Resolved.ForMethodExit of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class);
                        if (typeDescription.represents(NoExceptionHandler.class)) {
                            return new WithoutExceptionHandler(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                        }
                        return new WithExceptionHandler(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition, typeDescription);
                    }

                    /* access modifiers changed from: protected */
                    public MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        return doApply(methodVisitor, context, assigner, forInstrumentedMethod.bindExit(this.adviceMethod, getThrowable().represents(NoExceptionHandler.class)), forInstrumentedMethod2.bindExit(this.adviceMethod), forInstrumentedMethod3.bindExit(this.adviceMethod), typeDescription, methodDescription, bound, bound2, stackManipulation);
                    }

                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        StackManipulation stackManipulation2 = stackManipulation;
                        MethodDescription methodDescription2 = methodDescription;
                        return new AdviceMethodInliner(typeDescription, methodDescription2, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, this.suppressionHandler.bind(stackManipulation2), this.relocationHandler.bind(methodDescription2, relocation), stackManipulation2, this.classReader);
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
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.backupArguments == forMethodExit.backupArguments && this.uninitializedNamedTypes.equals(forMethodExit.uninitializedNamedTypes);
                    }

                    public TypeDefinition getAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.uninitializedNamedTypes;
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.uninitializedNamedTypes.hashCode()) * 31) + (this.backupArguments ? 1 : 0);
                    }

                    /* access modifiers changed from: protected */
                    public Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry next : this.uninitializedNamedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named((String) next.getKey())), next.getValue());
                        }
                        if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                            treeMap.put(Integer.valueOf(argumentHandler.exit()), this.adviceMethod.getReturnType());
                        }
                        return treeMap;
                    }
                }

                protected Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, int i10, ClassReader classReader2) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, i10, OffsetMapping.Factory.AdviceType.INLINING);
                    this.classReader = classReader2;
                }

                /* access modifiers changed from: protected */
                public abstract MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation);

                /* access modifiers changed from: protected */
                public abstract Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler);

                protected class AdviceMethodInliner extends ClassVisitor implements Bound {
                    protected final ArgumentHandler.ForInstrumentedMethod argumentHandler;
                    protected final Assigner assigner;
                    protected final ClassReader classReader;
                    protected final StackManipulation exceptionHandler;
                    protected final Implementation.Context implementationContext;
                    protected final MethodDescription instrumentedMethod;
                    protected final TypeDescription instrumentedType;
                    protected final List<Label> labels = new ArrayList();
                    protected final MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
                    protected final MethodVisitor methodVisitor;
                    protected final RelocationHandler.Bound relocationHandler;
                    protected final StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;
                    protected final SuppressionHandler.Bound suppressionHandler;

                    protected class ExceptionTableCollector extends MethodVisitor {
                        private final MethodVisitor methodVisitor;

                        protected ExceptionTableCollector(MethodVisitor methodVisitor2) {
                            super(OpenedClassReader.ASM_API);
                            this.methodVisitor = methodVisitor2;
                        }

                        @MaybeNull
                        public AnnotationVisitor visitTryCatchAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                            return this.methodVisitor.visitTryCatchAnnotation(i10, typePath, str, z10);
                        }

                        public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
                            this.methodVisitor.visitTryCatchBlock(label, label2, label3, str);
                            AdviceMethodInliner.this.labels.addAll(Arrays.asList(new Label[]{label, label2, label3}));
                        }
                    }

                    protected class ExceptionTableExtractor extends ClassVisitor {
                        protected ExceptionTableExtractor() {
                            super(OpenedClassReader.ASM_API);
                        }

                        @MaybeNull
                        public MethodVisitor visitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                            if (!Resolved.this.adviceMethod.getInternalName().equals(str) || !Resolved.this.adviceMethod.getDescriptor().equals(str2)) {
                                return Dispatcher.IGNORE_METHOD;
                            }
                            AdviceMethodInliner adviceMethodInliner = AdviceMethodInliner.this;
                            return new ExceptionTableCollector(adviceMethodInliner.methodVisitor);
                        }
                    }

                    protected AdviceMethodInliner(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor2, Implementation.Context context, Assigner assigner2, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, ClassReader classReader2) {
                        super(OpenedClassReader.ASM_API);
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.methodVisitor = methodVisitor2;
                        this.implementationContext = context;
                        this.assigner = assigner2;
                        this.argumentHandler = forInstrumentedMethod;
                        this.methodSizeHandler = forInstrumentedMethod2;
                        this.stackMapFrameHandler = forInstrumentedMethod3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.exceptionHandler = stackManipulation;
                        this.classReader = classReader2;
                    }

                    public void apply() {
                        this.classReader.accept(this, this.stackMapFrameHandler.getReaderHint() | 2);
                    }

                    public void initialize() {
                        for (Map.Entry next : Resolved.this.resolveInitializationTypes(this.argumentHandler).entrySet()) {
                            if (((TypeDefinition) next.getValue()).represents(Boolean.TYPE) || ((TypeDefinition) next.getValue()).represents(Byte.TYPE) || ((TypeDefinition) next.getValue()).represents(Short.TYPE) || ((TypeDefinition) next.getValue()).represents(Character.TYPE) || ((TypeDefinition) next.getValue()).represents(Integer.TYPE)) {
                                this.methodVisitor.visitInsn(3);
                                this.methodVisitor.visitVarInsn(54, ((Integer) next.getKey()).intValue());
                            } else if (((TypeDefinition) next.getValue()).represents(Long.TYPE)) {
                                this.methodVisitor.visitInsn(9);
                                this.methodVisitor.visitVarInsn(55, ((Integer) next.getKey()).intValue());
                            } else if (((TypeDefinition) next.getValue()).represents(Float.TYPE)) {
                                this.methodVisitor.visitInsn(11);
                                this.methodVisitor.visitVarInsn(56, ((Integer) next.getKey()).intValue());
                            } else if (((TypeDefinition) next.getValue()).represents(Double.TYPE)) {
                                this.methodVisitor.visitInsn(14);
                                this.methodVisitor.visitVarInsn(57, ((Integer) next.getKey()).intValue());
                            } else {
                                this.methodVisitor.visitInsn(1);
                                this.methodVisitor.visitVarInsn(58, ((Integer) next.getKey()).intValue());
                            }
                            this.methodSizeHandler.requireStackSize(((TypeDefinition) next.getValue()).getStackSize().getSize());
                        }
                    }

                    public void prepare() {
                        this.classReader.accept(new ExceptionTableExtractor(), 6);
                        this.suppressionHandler.onPrepare(this.methodVisitor);
                    }

                    @MaybeNull
                    public MethodVisitor visitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                        if (!Resolved.this.adviceMethod.getInternalName().equals(str) || !Resolved.this.adviceMethod.getDescriptor().equals(str2)) {
                            return Dispatcher.IGNORE_METHOD;
                        }
                        return new ExceptionTableSubstitutor(Resolved.this.apply(this.methodVisitor, this.implementationContext, this.assigner, this.argumentHandler, this.methodSizeHandler, this.stackMapFrameHandler, this.instrumentedType, this.instrumentedMethod, this.suppressionHandler, this.relocationHandler, this.exceptionHandler));
                    }

                    protected class ExceptionTableSubstitutor extends MethodVisitor {
                        private int index;
                        private final Map<Label, Label> substitutions = new IdentityHashMap();

                        protected ExceptionTableSubstitutor(MethodVisitor methodVisitor) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                        }

                        private Label[] resolve(Label[] labelArr) {
                            Label[] labelArr2 = new Label[labelArr.length];
                            int length = labelArr.length;
                            int i10 = 0;
                            int i11 = 0;
                            while (i10 < length) {
                                labelArr2[i11] = resolve(labelArr[i10]);
                                i10++;
                                i11++;
                            }
                            return labelArr2;
                        }

                        public void visitJumpInsn(int i10, Label label) {
                            super.visitJumpInsn(i10, resolve(label));
                        }

                        public void visitLabel(Label label) {
                            super.visitLabel(resolve(label));
                        }

                        public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
                            super.visitLookupSwitchInsn(resolve(label), iArr, resolve(labelArr));
                        }

                        public void visitTableSwitchInsn(int i10, int i11, Label label, Label... labelArr) {
                            super.visitTableSwitchInsn(i10, i11, label, resolve(labelArr));
                        }

                        @MaybeNull
                        public AnnotationVisitor visitTryCatchAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                            return Dispatcher.IGNORE_ANNOTATION;
                        }

                        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
                            Map<Label, Label> map = this.substitutions;
                            List<Label> list = AdviceMethodInliner.this.labels;
                            int i10 = this.index;
                            this.index = i10 + 1;
                            map.put(label, list.get(i10));
                            Map<Label, Label> map2 = this.substitutions;
                            List<Label> list2 = AdviceMethodInliner.this.labels;
                            int i11 = this.index;
                            this.index = i11 + 1;
                            map2.put(label2, list2.get(i11));
                            List<Label> list3 = AdviceMethodInliner.this.labels;
                            int i12 = this.index;
                            this.index = i12 + 1;
                            Label label4 = list3.get(i12);
                            this.substitutions.put(label3, label4);
                            ((CodeTranslationVisitor) this.mv).propagateHandler(label4);
                        }

                        private Label resolve(Label label) {
                            Label label2 = this.substitutions.get(label);
                            return label2 == null ? label : label2;
                        }
                    }
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
                r1 = (java.lang.String) r1.getValue(net.bytebuddy.asm.Advice.OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(java.lang.String.class);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected Inlining(net.bytebuddy.description.method.MethodDescription.InDefinedShape r5) {
                /*
                    r4 = this;
                    r4.<init>()
                    r4.adviceMethod = r5
                    java.util.HashMap r0 = new java.util.HashMap
                    r0.<init>()
                    r4.namedTypes = r0
                    net.bytebuddy.description.method.ParameterList r5 = r5.getParameters()
                    java.util.Iterator r5 = r5.iterator()
                L_0x0014:
                    boolean r0 = r5.hasNext()
                    if (r0 == 0) goto L_0x006f
                    java.lang.Object r0 = r5.next()
                    net.bytebuddy.description.method.ParameterDescription r0 = (net.bytebuddy.description.method.ParameterDescription) r0
                    net.bytebuddy.description.annotation.AnnotationList r1 = r0.getDeclaredAnnotations()
                    java.lang.Class<net.bytebuddy.asm.Advice$Local> r2 = net.bytebuddy.asm.Advice.Local.class
                    net.bytebuddy.description.annotation.AnnotationDescription$Loadable r1 = r1.ofType(r2)
                    if (r1 == 0) goto L_0x0014
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE
                    net.bytebuddy.description.annotation.AnnotationValue r1 = r1.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r2)
                    java.lang.Class<java.lang.String> r2 = java.lang.String.class
                    java.lang.Object r1 = r1.resolve(r2)
                    java.lang.String r1 = (java.lang.String) r1
                    java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r2 = r4.namedTypes
                    net.bytebuddy.description.type.TypeDescription$Generic r3 = r0.getType()
                    java.lang.Object r2 = r2.put(r1, r3)
                    net.bytebuddy.description.type.TypeDefinition r2 = (net.bytebuddy.description.type.TypeDefinition) r2
                    if (r2 == 0) goto L_0x0014
                    net.bytebuddy.description.type.TypeDescription$Generic r0 = r0.getType()
                    boolean r0 = r2.equals(r0)
                    if (r0 == 0) goto L_0x0053
                    goto L_0x0014
                L_0x0053:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Local variable for "
                    r0.append(r2)
                    r0.append(r1)
                    java.lang.String r1 = " is defined with inconsistent types"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    r5.<init>(r0)
                    throw r5
                L_0x006f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Inlining.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape):void");
            }

            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                if (classReader != null) {
                    MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                    return Resolved.ForMethodEnter.of(inDefinedShape, factory.make(inDefinedShape, false), this.namedTypes, list, unresolved.getAdviceType(), classReader, unresolved.isAlive());
                }
                throw new IllegalStateException("Class reader not expected null");
            }

            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                HashMap hashMap = new HashMap(unresolved.getNamedTypes());
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : this.namedTypes.entrySet()) {
                    TypeDefinition typeDefinition = (TypeDefinition) hashMap.get(next.getKey());
                    TypeDefinition typeDefinition2 = (TypeDefinition) hashMap2.get(next.getKey());
                    if (typeDefinition == null && typeDefinition2 == null) {
                        hashMap.put(next.getKey(), next.getValue());
                        hashMap2.put(next.getKey(), next.getValue());
                    } else {
                        if (typeDefinition == null) {
                            typeDefinition = typeDefinition2;
                        }
                        if (!typeDefinition.equals(next.getValue())) {
                            throw new IllegalStateException("Local variable for " + ((String) next.getKey()) + " is defined with inconsistent types");
                        }
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodExit.of(inDefinedShape, factory.make(inDefinedShape, true), hashMap, hashMap2, list, classReader, unresolved.getAdviceType());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Inlining inlining = (Inlining) obj;
                return this.adviceMethod.equals(inlining.adviceMethod) && this.namedTypes.equals(inlining.namedTypes);
            }

            public Map<String, TypeDefinition> getNamedTypes() {
                return this.namedTypes;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.adviceMethod.hashCode()) * 31) + this.namedTypes.hashCode();
            }

            public boolean isAlive() {
                return true;
            }

            public boolean isBinary() {
                return true;
            }

            public TypeDescription getAdviceType() {
                return this.adviceMethod.getReturnType().asErasure();
            }
        }

        public interface RelocationHandler {

            public interface Bound {
                public static final int NO_REQUIRED_SIZE = 0;

                int apply(MethodVisitor methodVisitor, Implementation.Context context, int i10);
            }

            public enum Disabled implements RelocationHandler, Bound {
                INSTANCE;

                public int apply(MethodVisitor methodVisitor, Implementation.Context context, int i10) {
                    return 0;
                }

                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForType implements RelocationHandler {
                /* access modifiers changed from: private */
                public final int index;
                /* access modifiers changed from: private */
                public final TypeDescription typeDescription;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class Bound implements Bound {
                    private final MethodDescription instrumentedMethod;
                    private final Relocation relocation;

                    protected Bound(MethodDescription methodDescription, Relocation relocation2) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation2;
                    }

                    public int apply(MethodVisitor methodVisitor, Implementation.Context context, int i10) {
                        int i11;
                        if (!this.instrumentedMethod.isConstructor()) {
                            methodVisitor.visitVarInsn(25, i10);
                            Label label = new Label();
                            if (ForType.this.index < 0) {
                                i11 = 0;
                            } else {
                                methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
                                methodVisitor.visitVarInsn(25, i10);
                                i11 = IntegerConstant.forValue(ForType.this.index).apply(methodVisitor, context).getMaximalSize() + 1;
                                methodVisitor.visitInsn(50);
                            }
                            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, ForType.this.typeDescription.getInternalName());
                            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
                            this.relocation.apply(methodVisitor);
                            methodVisitor.visitLabel(label);
                            return i11;
                        }
                        throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.instrumentedMethod.equals(bound.instrumentedMethod) && this.relocation.equals(bound.relocation) && ForType.this.equals(ForType.this);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.relocation.hashCode()) * 31) + ForType.this.hashCode();
                    }
                }

                protected ForType(TypeDescription typeDescription2, int i10) {
                    this.typeDescription = typeDescription2;
                    this.index = i10;
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                protected static RelocationHandler of(TypeDescription typeDescription2, int i10, TypeDefinition typeDefinition) {
                    if (i10 >= 0) {
                        if (typeDefinition.isArray()) {
                            typeDefinition = typeDefinition.getComponentType();
                        } else {
                            throw new IllegalStateException(typeDefinition + " is not an array type but an index for a relocation is defined");
                        }
                    }
                    if (typeDescription2.represents(Void.TYPE)) {
                        return Disabled.INSTANCE;
                    }
                    if (typeDescription2.represents(OnDefaultValue.class)) {
                        return ForValue.of(typeDefinition, i10, false);
                    }
                    if (typeDescription2.represents(OnNonDefaultValue.class)) {
                        return ForValue.of(typeDefinition, i10, true);
                    }
                    if (!typeDescription2.isPrimitive() && !typeDefinition.isPrimitive()) {
                        return new ForType(typeDescription2, i10);
                    }
                    throw new IllegalStateException("Cannot relocate execution by instance type for primitive type");
                }

                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return new Bound(methodDescription, relocation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForType forType = (ForType) obj;
                    return this.index == forType.index && this.typeDescription.equals(forType.typeDescription);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.index;
                }
            }

            public enum ForValue {
                BOOLEAN(21, 51, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                BYTE(21, 51, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                SHORT(21, 53, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                CHARACTER(21, 52, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                INTEGER(21, 46, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                LONG(22, 47, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(136);
                    }
                },
                FLOAT(23, 48, Opcodes.IFNE, Opcodes.IFEQ, 2) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(Opcodes.FCMPL);
                    }
                },
                DOUBLE(24, 49, Opcodes.IFNE, Opcodes.IFEQ, 4) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(Opcodes.DCMPL);
                    }
                },
                REFERENCE(25, 50, Opcodes.IFNONNULL, Opcodes.IFNULL, 0) {
                    /* access modifiers changed from: protected */
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                };
                
                /* access modifiers changed from: private */
                public final int arrayLoad;
                /* access modifiers changed from: private */
                public final int defaultJump;
                /* access modifiers changed from: private */
                public final int load;
                /* access modifiers changed from: private */
                public final int nonDefaultJump;
                /* access modifiers changed from: private */
                public final int requiredSize;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class Bound implements Bound {
                    private final int index;
                    private final MethodDescription instrumentedMethod;
                    private final boolean inverted;
                    private final Relocation relocation;

                    protected Bound(MethodDescription methodDescription, Relocation relocation2, int i10, boolean z10) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation2;
                        this.index = i10;
                        this.inverted = z10;
                    }

                    public int apply(MethodVisitor methodVisitor, Implementation.Context context, int i10) {
                        int i11;
                        int i12;
                        if (!this.instrumentedMethod.isConstructor()) {
                            Label label = new Label();
                            if (this.index < 0) {
                                i11 = ForValue.this.requiredSize;
                                methodVisitor.visitVarInsn(ForValue.this.load, i10);
                            } else {
                                methodVisitor.visitVarInsn(25, i10);
                                methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
                                methodVisitor.visitVarInsn(25, i10);
                                i11 = Math.max(ForValue.this.requiredSize, IntegerConstant.forValue(this.index).apply(methodVisitor, context).getMaximalSize() + 1);
                                methodVisitor.visitInsn(ForValue.this.arrayLoad);
                            }
                            ForValue.this.convertValue(methodVisitor);
                            if (this.inverted) {
                                i12 = ForValue.this.nonDefaultJump;
                            } else {
                                i12 = ForValue.this.defaultJump;
                            }
                            methodVisitor.visitJumpInsn(i12, label);
                            this.relocation.apply(methodVisitor);
                            methodVisitor.visitLabel(label);
                            return i11;
                        }
                        throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.index == bound.index && this.inverted == bound.inverted && ForValue.this.equals(ForValue.this) && this.instrumentedMethod.equals(bound.instrumentedMethod) && this.relocation.equals(bound.relocation);
                    }

                    public int hashCode() {
                        return (((((((((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.relocation.hashCode()) * 31) + this.index) * 31) + (this.inverted ? 1 : 0)) * 31) + ForValue.this.hashCode();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class OfDefault implements RelocationHandler {
                    private final int index;

                    public OfDefault(int i10) {
                        this.index = i10;
                    }

                    public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                        return new Bound(methodDescription, relocation, this.index, false);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfDefault ofDefault = (OfDefault) obj;
                        return this.index == ofDefault.index && ForValue.this.equals(ForValue.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.index) * 31) + ForValue.this.hashCode();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                protected class OfNonDefault implements RelocationHandler {
                    private final int index;

                    protected OfNonDefault(int i10) {
                        this.index = i10;
                    }

                    public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                        return new Bound(methodDescription, relocation, this.index, true);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfNonDefault ofNonDefault = (OfNonDefault) obj;
                        return this.index == ofNonDefault.index && ForValue.this.equals(ForValue.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.index) * 31) + ForValue.this.hashCode();
                    }
                }

                protected static RelocationHandler of(TypeDefinition typeDefinition, int i10, boolean z10) {
                    ForValue forValue;
                    if (typeDefinition.represents(Boolean.TYPE)) {
                        forValue = BOOLEAN;
                    } else if (typeDefinition.represents(Byte.TYPE)) {
                        forValue = BYTE;
                    } else if (typeDefinition.represents(Short.TYPE)) {
                        forValue = SHORT;
                    } else if (typeDefinition.represents(Character.TYPE)) {
                        forValue = CHARACTER;
                    } else if (typeDefinition.represents(Integer.TYPE)) {
                        forValue = INTEGER;
                    } else if (typeDefinition.represents(Long.TYPE)) {
                        forValue = LONG;
                    } else if (typeDefinition.represents(Float.TYPE)) {
                        forValue = FLOAT;
                    } else if (typeDefinition.represents(Double.TYPE)) {
                        forValue = DOUBLE;
                    } else if (!typeDefinition.represents(Void.TYPE)) {
                        forValue = REFERENCE;
                    } else {
                        throw new IllegalStateException("Cannot skip on default value for void return type");
                    }
                    if (z10) {
                        forValue.getClass();
                        return new OfNonDefault(i10);
                    }
                    forValue.getClass();
                    return new OfDefault(i10);
                }

                /* access modifiers changed from: protected */
                public abstract void convertValue(MethodVisitor methodVisitor);

                private ForValue(int i10, int i11, int i12, int i13, int i14) {
                    this.load = i10;
                    this.arrayLoad = i11;
                    this.defaultJump = i12;
                    this.nonDefaultJump = i13;
                    this.requiredSize = i14;
                }
            }

            public interface Relocation {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLabel implements Relocation {
                    private final Label label;

                    public ForLabel(Label label2) {
                        this.label = label2;
                    }

                    public void apply(MethodVisitor methodVisitor) {
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, this.label);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.label.equals(((ForLabel) obj).label);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.label.hashCode();
                    }
                }

                void apply(MethodVisitor methodVisitor);
            }

            Bound bind(MethodDescription methodDescription, Relocation relocation);
        }

        public interface Resolved extends Dispatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements Resolved {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final Map<Integer, OffsetMapping> offsetMappings;
                protected final PostProcessor postProcessor;
                protected final RelocationHandler relocationHandler;
                protected final SuppressionHandler suppressionHandler;

                protected AbstractBase(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor2, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, int i10, OffsetMapping.Factory.AdviceType adviceType) {
                    this.adviceMethod = inDefinedShape;
                    this.postProcessor = postProcessor2;
                    HashMap hashMap = new HashMap();
                    for (OffsetMapping.Factory factory : list) {
                        hashMap.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
                    }
                    this.offsetMappings = new LinkedHashMap();
                    for (ParameterDescription.InDefinedShape inDefinedShape2 : inDefinedShape.getParameters()) {
                        OffsetMapping offsetMapping = null;
                        for (AnnotationDescription annotationDescription : inDefinedShape2.getDeclaredAnnotations()) {
                            OffsetMapping.Factory factory2 = (OffsetMapping.Factory) hashMap.get(annotationDescription.getAnnotationType());
                            if (factory2 != null) {
                                OffsetMapping make = factory2.make(inDefinedShape2, annotationDescription.prepare(factory2.getAnnotationType()), adviceType);
                                if (offsetMapping == null) {
                                    offsetMapping = make;
                                } else {
                                    throw new IllegalStateException(inDefinedShape2 + " is bound to both " + make + " and " + offsetMapping);
                                }
                            }
                        }
                        Map<Integer, OffsetMapping> map = this.offsetMappings;
                        Integer valueOf = Integer.valueOf(inDefinedShape2.getOffset());
                        if (offsetMapping == null) {
                            offsetMapping = new OffsetMapping.ForArgument.Unresolved(inDefinedShape2);
                        }
                        map.put(valueOf, offsetMapping);
                    }
                    this.suppressionHandler = SuppressionHandler.Suppressing.of(typeDescription);
                    this.relocationHandler = RelocationHandler.ForType.of(typeDescription2, i10, inDefinedShape.getReturnType());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.adviceMethod.equals(abstractBase.adviceMethod) && this.postProcessor.equals(abstractBase.postProcessor) && this.offsetMappings.equals(abstractBase.offsetMappings) && this.suppressionHandler.equals(abstractBase.suppressionHandler) && this.relocationHandler.equals(abstractBase.relocationHandler);
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.adviceMethod.hashCode()) * 31) + this.postProcessor.hashCode()) * 31) + this.offsetMappings.hashCode()) * 31) + this.suppressionHandler.hashCode()) * 31) + this.relocationHandler.hashCode();
                }

                public boolean isAlive() {
                    return true;
                }
            }

            public interface ForMethodEnter extends Resolved {
                TypeDefinition getActualAdviceType();

                boolean isPrependLineNumber();
            }

            public interface ForMethodExit extends Resolved {
                ArgumentHandler.Factory getArgumentHandlerFactory();

                TypeDescription getThrowable();
            }

            Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation);

            Map<String, TypeDefinition> getNamedTypes();
        }

        public interface SuppressionHandler {

            public interface Bound {
                void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition);

                void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition);

                void onPrepare(MethodVisitor methodVisitor);

                void onStart(MethodVisitor methodVisitor);
            }

            public enum NoOp implements SuppressionHandler, Bound {
                INSTANCE;

                public Bound bind(StackManipulation stackManipulation) {
                    return this;
                }

                public void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                }

                public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                }

                public void onPrepare(MethodVisitor methodVisitor) {
                }

                public void onStart(MethodVisitor methodVisitor) {
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Suppressing implements SuppressionHandler {
                private final TypeDescription suppressedType;

                protected static class Bound implements Bound {
                    private final Label endOfMethod = new Label();
                    private final StackManipulation exceptionHandler;
                    private final Label startOfMethod = new Label();
                    private final TypeDescription suppressedType;

                    protected Bound(TypeDescription typeDescription, StackManipulation stackManipulation) {
                        this.suppressedType = typeDescription;
                        this.exceptionHandler = stackManipulation;
                    }

                    public void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                        methodVisitor.visitLabel(this.endOfMethod);
                        forAdvice2.injectExceptionFrame(methodVisitor);
                        forAdvice.requireStackSize(this.exceptionHandler.apply(methodVisitor, context).getMaximalSize() + 1);
                        if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                            methodVisitor.visitInsn(3);
                        } else if (typeDefinition.represents(Long.TYPE)) {
                            methodVisitor.visitInsn(9);
                        } else if (typeDefinition.represents(Float.TYPE)) {
                            methodVisitor.visitInsn(11);
                        } else if (typeDefinition.represents(Double.TYPE)) {
                            methodVisitor.visitInsn(14);
                        } else if (!typeDefinition.represents(Void.TYPE)) {
                            methodVisitor.visitInsn(1);
                        }
                    }

                    public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
                        onEnd(methodVisitor, context, forAdvice, forAdvice2, typeDefinition);
                        methodVisitor.visitLabel(label);
                        forAdvice2.injectReturnFrame(methodVisitor);
                    }

                    public void onPrepare(MethodVisitor methodVisitor) {
                        Label label = this.startOfMethod;
                        Label label2 = this.endOfMethod;
                        methodVisitor.visitTryCatchBlock(label, label2, label2, this.suppressedType.getInternalName());
                    }

                    public void onStart(MethodVisitor methodVisitor) {
                        methodVisitor.visitLabel(this.startOfMethod);
                    }
                }

                protected Suppressing(TypeDescription typeDescription) {
                    this.suppressedType = typeDescription;
                }

                protected static SuppressionHandler of(TypeDescription typeDescription) {
                    return typeDescription.represents(NoExceptionHandler.class) ? NoOp.INSTANCE : new Suppressing(typeDescription);
                }

                public Bound bind(StackManipulation stackManipulation) {
                    return new Bound(this.suppressedType, stackManipulation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.suppressedType.equals(((Suppressing) obj).suppressedType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.suppressedType.hashCode();
                }
            }

            Bound bind(StackManipulation stackManipulation);
        }

        public interface Unresolved extends Dispatcher {
            Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory);

            Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory);

            Map<String, TypeDefinition> getNamedTypes();

            boolean isBinary();
        }

        TypeDefinition getAdviceType();

        boolean isAlive();
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enter {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    public interface ExceptionHandler {

        public enum Default implements ExceptionHandler {
            SUPPRESSING {
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Removal.SINGLE;
                }
            },
            PRINTING {
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    try {
                        return MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Throwable.class.getMethod("printStackTrace", new Class[0])));
                    } catch (NoSuchMethodException unused) {
                        throw new IllegalStateException("Cannot locate Throwable::printStackTrace");
                    }
                }
            },
            RETHROWING {
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Throw.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements ExceptionHandler {
            private final StackManipulation stackManipulation;

            public Simple(StackManipulation stackManipulation2) {
                this.stackManipulation = stackManipulation2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((Simple) obj).stackManipulation);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.stackManipulation.hashCode();
            }

            public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                return this.stackManipulation;
            }
        }

        StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exit {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldGetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldSetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldValue {
        Class<?> declaringType() default void.class;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Local {
        String value();
    }

    protected interface MethodSizeHandler {
        public static final int UNDEFINED_SIZE = 32767;

        public static abstract class Default implements ForInstrumentedMethod {
            protected final List<? extends TypeDescription> initialTypes;
            protected final MethodDescription instrumentedMethod;
            protected int localVariableLength;
            protected final List<? extends TypeDescription> postMethodTypes;
            protected final List<? extends TypeDescription> preMethodTypes;
            protected int stackSize;

            protected class ForAdvice implements ForAdvice {
                private final MethodDescription.InDefinedShape adviceMethod;
                private final int baseLocalVariableLength;
                private int localVariableLengthPadding;
                private int stackSizePadding;

                protected ForAdvice(MethodDescription.InDefinedShape inDefinedShape, int i10) {
                    this.adviceMethod = inDefinedShape;
                    this.baseLocalVariableLength = i10;
                }

                public void recordMaxima(int i10, int i11) {
                    Default.this.requireStackSize(i10 + this.stackSizePadding);
                    Default.this.requireLocalVariableLength((i11 - this.adviceMethod.getStackSize()) + this.baseLocalVariableLength + this.localVariableLengthPadding);
                }

                public void requireLocalVariableLength(int i10) {
                    Default.this.requireLocalVariableLength(i10);
                }

                public void requireLocalVariableLengthPadding(int i10) {
                    this.localVariableLengthPadding = Math.max(this.localVariableLengthPadding, i10);
                }

                public void requireStackSize(int i10) {
                    Default.this.requireStackSize(i10);
                }

                public void requireStackSizePadding(int i10) {
                    this.stackSizePadding = Math.max(this.stackSizePadding, i10);
                }
            }

            protected static class WithCopiedArguments extends Default {
                protected WithCopiedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, (this.instrumentedMethod.getStackSize() * 2) + StackSize.of((Collection<? extends TypeDefinition>) this.initialTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.preMethodTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.postMethodTypes));
                }

                public int compoundLocalVariableLength(int i10) {
                    return Math.max(this.localVariableLength, i10 + this.instrumentedMethod.getStackSize() + StackSize.of((Collection<? extends TypeDefinition>) this.postMethodTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.initialTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.preMethodTypes));
                }
            }

            protected static class WithRetainedArguments extends Default {
                protected WithRetainedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, this.instrumentedMethod.getStackSize() + StackSize.of((Collection<? extends TypeDefinition>) this.postMethodTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.initialTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.preMethodTypes));
                }

                public int compoundLocalVariableLength(int i10) {
                    return Math.max(this.localVariableLength, i10 + StackSize.of((Collection<? extends TypeDefinition>) this.postMethodTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.initialTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.preMethodTypes));
                }
            }

            protected Default(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                this.instrumentedMethod = methodDescription;
                this.initialTypes = list;
                this.preMethodTypes = list2;
                this.postMethodTypes = list3;
            }

            protected static ForInstrumentedMethod of(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z10, int i10) {
                if ((i10 & 3) != 0) {
                    return NoOp.INSTANCE;
                }
                if (z10) {
                    return new WithCopiedArguments(methodDescription, list, list2, list3);
                }
                return new WithRetainedArguments(methodDescription, list, list2, list3);
            }

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return new ForAdvice(inDefinedShape, this.instrumentedMethod.getStackSize() + StackSize.of((Collection<? extends TypeDefinition>) this.initialTypes));
            }

            public int compoundLocalVariableLength(int i10) {
                return Math.max(this.localVariableLength, i10 + StackSize.of((Collection<? extends TypeDefinition>) this.postMethodTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.initialTypes) + StackSize.of((Collection<? extends TypeDefinition>) this.preMethodTypes));
            }

            public int compoundStackSize(int i10) {
                return Math.max(this.stackSize, i10);
            }

            public void requireLocalVariableLength(int i10) {
                this.localVariableLength = Math.max(this.localVariableLength, i10);
            }

            public void requireStackSize(int i10) {
                this.stackSize = Math.max(this.stackSize, i10);
            }
        }

        public interface ForAdvice extends MethodSizeHandler {
            void recordMaxima(int i10, int i11);

            void requireLocalVariableLengthPadding(int i10);

            void requireStackSizePadding(int i10);
        }

        public interface ForInstrumentedMethod extends MethodSizeHandler {
            ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape);

            ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape);

            int compoundLocalVariableLength(int i10);

            int compoundStackSize(int i10);
        }

        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public int compoundLocalVariableLength(int i10) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            public int compoundStackSize(int i10) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            public void recordMaxima(int i10, int i11) {
            }

            public void requireLocalVariableLength(int i10) {
            }

            public void requireLocalVariableLengthPadding(int i10) {
            }

            public void requireStackSize(int i10) {
            }

            public void requireStackSizePadding(int i10) {
            }
        }

        void requireLocalVariableLength(int i10);

        void requireStackSize(int i10);
    }

    private static class NoExceptionHandler extends Throwable {
        /* access modifiers changed from: private */
        public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(NoExceptionHandler.class);
        private static final long serialVersionUID = 1;

        private NoExceptionHandler() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    public interface OffsetMapping {

        public interface Factory<T extends Annotation> {

            public enum AdviceType {
                DELEGATION(true),
                INLINING(false);
                
                private final boolean delegation;

                private AdviceType(boolean z10) {
                    this.delegation = z10;
                }

                public boolean isDelegation() {
                    return this.delegation;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Illegal<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public Illegal(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Illegal) obj).annotationType);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    throw new IllegalStateException("Usage of " + this.annotationType + " is not allowed on " + inDefinedShape);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final OffsetMapping offsetMapping;

                public Simple(Class<T> cls, OffsetMapping offsetMapping2) {
                    this.annotationType = cls;
                    this.offsetMapping = offsetMapping2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Simple simple = (Simple) obj;
                    return this.annotationType.equals(simple.annotationType) && this.offsetMapping.equals(simple.offsetMapping);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.offsetMapping.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    return this.offsetMapping;
                }
            }

            Class<T> getAnnotationType();

            OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForFieldHandle implements OffsetMapping {
            private final Access access;

            public enum Access {
                GETTER {
                    /* access modifiers changed from: protected */
                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                        return JavaConstant.MethodHandle.ofGetter(inDefinedShape);
                    }
                },
                SETTER {
                    /* access modifiers changed from: protected */
                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                        return JavaConstant.MethodHandle.ofSetter(inDefinedShape);
                    }
                };

                /* access modifiers changed from: protected */
                public abstract JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForFieldHandle {
                private final FieldDescription fieldDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Access access;
                    private final Class<T> annotationType;
                    private final FieldDescription fieldDescription;

                    public Factory(Class<T> cls, FieldDescription fieldDescription2, Access access2) {
                        this.annotationType = cls;
                        this.fieldDescription = fieldDescription2;
                        this.access = access2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.access.equals(factory.access) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                    }

                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.fieldDescription.hashCode()) * 31) + this.access.hashCode();
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                            return new Resolved(this.access, this.fieldDescription);
                        }
                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                    }
                }

                public Resolved(Access access, FieldDescription fieldDescription2) {
                    super(access);
                    this.fieldDescription = fieldDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }

                /* access modifiers changed from: protected */
                @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                    } else if (this.fieldDescription.isVisibleTo(typeDescription)) {
                        return this.fieldDescription;
                    } else {
                        throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Unresolved extends ForFieldHandle {
                protected static final String BEAN_PROPERTY = "";
                private final String name;

                protected enum ReaderFactory implements Factory<FieldGetterHandle> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_DECLARING_TYPE = null;
                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_VALUE = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldGetterHandle.class).getDeclaredMethods();
                        FIELD_GETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        FIELD_GETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                    }

                    public Class<FieldGetterHandle> getAnnotationType() {
                        return FieldGetterHandle.class;
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldGetterHandle> loadable, Factory.AdviceType adviceType) {
                        Class<String> cls = String.class;
                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(FIELD_GETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                            if (typeDescription.represents(Void.TYPE)) {
                                return new WithImplicitType(Access.GETTER, (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(cls));
                            }
                            return new WithExplicitType(Access.GETTER, (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(cls), typeDescription);
                        }
                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends Unresolved {
                    private final TypeDescription declaringType;

                    public WithExplicitType(Access access, String str, TypeDescription typeDescription) {
                        super(access, str);
                        this.declaringType = typeDescription;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                    }

                    /* access modifiers changed from: protected */
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                        }
                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.declaringType.hashCode();
                    }
                }

                public static class WithImplicitType extends Unresolved {
                    public WithImplicitType(Access access, String str) {
                        super(access, str);
                    }

                    /* access modifiers changed from: protected */
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        return new FieldLocator.ForClassHierarchy(typeDescription);
                    }
                }

                protected enum WriterFactory implements Factory<FieldSetterHandle> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_DECLARING_TYPE = null;
                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_VALUE = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldSetterHandle.class).getDeclaredMethods();
                        FIELD_SETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        FIELD_SETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                    }

                    public Class<FieldSetterHandle> getAnnotationType() {
                        return FieldSetterHandle.class;
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldSetterHandle> loadable, Factory.AdviceType adviceType) {
                        Class<String> cls = String.class;
                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(FIELD_SETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                            if (typeDescription.represents(Void.TYPE)) {
                                return new WithImplicitType(Access.SETTER, (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(cls));
                            }
                            return new WithExplicitType(Access.SETTER, (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(cls), typeDescription);
                        }
                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                    }
                }

                public Unresolved(Access access, String str) {
                    super(access);
                    this.name = str;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                }

                /* access modifiers changed from: protected */
                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                public int hashCode() {
                    return (super.hashCode() * 31) + this.name.hashCode();
                }

                /* access modifiers changed from: protected */
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    FieldLocator.Resolution resolution;
                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                    if (this.name.equals("")) {
                        resolution = FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription);
                    } else {
                        resolution = fieldLocator.locate(this.name);
                    }
                    if (resolution.isResolved()) {
                        return resolution.getField();
                    }
                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                }
            }

            protected ForFieldHandle(Access access2) {
                this.access = access2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.access.equals(((ForFieldHandle) obj).access);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.access.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                FieldDescription resolve = resolve(typeDescription, methodDescription);
                if (!resolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot access non-static field " + resolve + " from static method " + methodDescription);
                } else if (sort.isPremature(methodDescription) && !resolve.isStatic()) {
                    throw new IllegalStateException("Cannot access " + resolve + " before super constructor call");
                } else if (resolve.isStatic()) {
                    return new Target.ForStackManipulation(this.access.resolve((FieldDescription.InDefinedShape) resolve.asDefined()).toStackManipulation());
                } else {
                    JavaType javaType = JavaType.METHOD_HANDLE;
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.access.resolve((FieldDescription.InDefinedShape) resolve.asDefined()).toStackManipulation(), MethodVariableAccess.REFERENCE.loadFrom(argumentHandler.argument(0)), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class)))))));
                }
            }

            /* access modifiers changed from: protected */
            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);
        }

        public enum ForInstrumentedMethod implements OffsetMapping {
            METHOD {
                /* access modifiers changed from: protected */
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return methodDescription.isMethod();
                }

                /* access modifiers changed from: protected */
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(inDefinedShape);
                }
            },
            CONSTRUCTOR {
                /* access modifiers changed from: protected */
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }

                /* access modifiers changed from: protected */
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(inDefinedShape);
                }
            },
            EXECUTABLE {
                /* access modifiers changed from: protected */
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                /* access modifiers changed from: protected */
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(inDefinedShape);
                }
            },
            METHOD_HANDLE {
                /* access modifiers changed from: protected */
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                /* access modifiers changed from: protected */
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return new Target.ForStackManipulation(JavaConstant.MethodHandle.of(inDefinedShape).toStackManipulation());
                }
            },
            METHOD_TYPE {
                /* access modifiers changed from: protected */
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                /* access modifiers changed from: protected */
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return new Target.ForStackManipulation(JavaConstant.MethodType.of((MethodDescription) inDefinedShape).toStackManipulation());
                }
            };

            /* access modifiers changed from: protected */
            public abstract boolean isRepresentable(MethodDescription methodDescription);

            /* access modifiers changed from: protected */
            public abstract Target resolve(MethodDescription.InDefinedShape inDefinedShape);

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (isRepresentable(methodDescription)) {
                    return resolve((MethodDescription.InDefinedShape) methodDescription.asDefined());
                }
                throw new IllegalStateException("Cannot represent " + methodDescription + " as the specified constant");
            }
        }

        public enum ForInstrumentedType implements OffsetMapping {
            INSTANCE;

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return Target.ForStackManipulation.of(typeDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForLocalValue implements OffsetMapping {
            private final TypeDescription.Generic localType;
            private final String name;
            private final TypeDescription.Generic target;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Factory implements Factory<Local> {
                protected static final MethodDescription.InDefinedShape LOCAL_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Local.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
                private final Map<String, TypeDefinition> namedTypes;

                protected Factory(Map<String, TypeDefinition> map) {
                    this.namedTypes = map;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.namedTypes.equals(((Factory) obj).namedTypes);
                }

                public Class<Local> getAnnotationType() {
                    return Local.class;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.namedTypes.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Local> loadable, Factory.AdviceType adviceType) {
                    String str = (String) loadable.getValue(LOCAL_VALUE).resolve(String.class);
                    TypeDefinition typeDefinition = this.namedTypes.get(str);
                    if (typeDefinition != null) {
                        return new ForLocalValue(inDefinedShape.getType(), typeDefinition.asGenericType(), str);
                    }
                    throw new IllegalStateException("Named local variable is unknown: " + str);
                }
            }

            public ForLocalValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, String str) {
                this.target = generic;
                this.localType = generic2;
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForLocalValue forLocalValue = (ForLocalValue) obj;
                return this.name.equals(forLocalValue.name) && this.target.equals(forLocalValue.target) && this.localType.equals(forLocalValue.localType);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.localType.hashCode()) * 31) + this.name.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                TypeDescription.Generic generic = this.localType;
                TypeDescription.Generic generic2 = this.target;
                Assigner.Typing typing = Assigner.Typing.STATIC;
                StackManipulation assign = assigner.assign(generic, generic2, typing);
                StackManipulation assign2 = assigner.assign(this.target, this.localType, typing);
                if (assign.isValid() && assign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.named(this.name), assign, assign2);
                }
                throw new IllegalStateException("Cannot assign " + this.localType + " to " + this.target);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForOrigin implements OffsetMapping {
            private static final char DELIMITER = '#';
            private static final char ESCAPE = '\\';
            private final List<Renderer> renderers;

            protected enum Factory implements Factory<Origin> {
                INSTANCE;
                
                private static final MethodDescription.InDefinedShape ORIGIN_VALUE = null;

                static {
                    ORIGIN_VALUE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly();
                }

                public Class<Origin> getAnnotationType() {
                    return Origin.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable, Factory.AdviceType adviceType) {
                    Class<String> cls = String.class;
                    if (inDefinedShape.getType().asErasure().represents(Class.class)) {
                        return ForInstrumentedType.INSTANCE;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Method.class)) {
                        return ForInstrumentedMethod.METHOD;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Constructor.class)) {
                        return ForInstrumentedMethod.CONSTRUCTOR;
                    }
                    if (JavaType.EXECUTABLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.EXECUTABLE;
                    }
                    if (JavaType.METHOD_HANDLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.METHOD_HANDLE;
                    }
                    if (JavaType.METHOD_TYPE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.METHOD_TYPE;
                    }
                    JavaType javaType = JavaType.METHOD_HANDLES_LOOKUP;
                    if (javaType.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return new ForStackManipulation(MethodInvocation.lookup(), javaType.getTypeStub().asGenericType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                    }
                    if (inDefinedShape.getType().asErasure().isAssignableFrom((Class<?>) cls)) {
                        return ForOrigin.parse((String) loadable.getValue(ORIGIN_VALUE).resolve(cls));
                    }
                    throw new IllegalStateException("Non-supported type " + inDefinedShape.getType() + " for @Origin annotation");
                }
            }

            public interface Renderer {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForConstantValue implements Renderer {
                    private final String value;

                    public ForConstantValue(String str) {
                        this.value = str;
                    }

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this.value;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.value.equals(((ForConstantValue) obj).value);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.value.hashCode();
                    }
                }

                public enum ForDescriptor implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'd';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getDescriptor();
                    }
                }

                public enum ForJavaSignature implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 's';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        StringBuilder sb2 = new StringBuilder("(");
                        boolean z10 = false;
                        for (TypeDescription typeDescription2 : methodDescription.getParameters().asTypeList().asErasures()) {
                            if (z10) {
                                sb2.append(',');
                            } else {
                                z10 = true;
                            }
                            sb2.append(typeDescription2.getName());
                        }
                        sb2.append(PropertyUtils.MAPPED_DELIM2);
                        return sb2.toString();
                    }
                }

                public enum ForMethodName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'm';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getInternalName();
                    }
                }

                public enum ForPropertyName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'p';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return FieldAccessor.FieldNameExtractor.ForBeanProperty.INSTANCE.resolve(methodDescription);
                    }
                }

                public enum ForReturnTypeName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'r';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getReturnType().asErasure().getName();
                    }
                }

                public enum ForStringRepresentation implements Renderer {
                    INSTANCE;

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.toString();
                    }
                }

                public enum ForTypeName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 't';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return typeDescription.getName();
                    }
                }

                String apply(TypeDescription typeDescription, MethodDescription methodDescription);
            }

            public ForOrigin(List<Renderer> list) {
                this.renderers = list;
            }

            public static OffsetMapping parse(String str) {
                int i10;
                if (str.equals("")) {
                    return new ForOrigin(Collections.singletonList(Renderer.ForStringRepresentation.INSTANCE));
                }
                ArrayList arrayList = new ArrayList(str.length());
                int indexOf = str.indexOf(35);
                int i11 = 0;
                while (indexOf != -1) {
                    if (indexOf != 0) {
                        int i12 = indexOf - 1;
                        if (str.charAt(i12) == '\\' && (indexOf == 1 || str.charAt(indexOf - 2) != '\\')) {
                            arrayList.add(new Renderer.ForConstantValue(str.substring(i11, Math.max(0, i12)) + DELIMITER));
                            i10 = indexOf + 1;
                            i11 = i10;
                            indexOf = str.indexOf(35, i11);
                        }
                    }
                    int i13 = indexOf + 1;
                    if (str.length() != i13) {
                        arrayList.add(new Renderer.ForConstantValue(str.substring(i11, indexOf).replace("\\\\", "\\")));
                        char charAt = str.charAt(i13);
                        if (charAt == 'd') {
                            arrayList.add(Renderer.ForDescriptor.INSTANCE);
                        } else if (charAt == 'm') {
                            arrayList.add(Renderer.ForMethodName.INSTANCE);
                        } else if (charAt != 'p') {
                            switch (charAt) {
                                case 'r':
                                    arrayList.add(Renderer.ForReturnTypeName.INSTANCE);
                                    break;
                                case 's':
                                    arrayList.add(Renderer.ForJavaSignature.INSTANCE);
                                    break;
                                case 't':
                                    arrayList.add(Renderer.ForTypeName.INSTANCE);
                                    break;
                                default:
                                    throw new IllegalStateException("Illegal sort descriptor " + str.charAt(i13) + " for " + str);
                            }
                        } else {
                            arrayList.add(Renderer.ForPropertyName.INSTANCE);
                        }
                        i10 = indexOf + 2;
                        i11 = i10;
                        indexOf = str.indexOf(35, i11);
                    } else {
                        throw new IllegalStateException("Missing sort descriptor for " + str + " at index " + indexOf);
                    }
                }
                arrayList.add(new Renderer.ForConstantValue(str.substring(i11)));
                return new ForOrigin(arrayList);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.renderers.equals(((ForOrigin) obj).renderers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.renderers.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StringBuilder sb2 = new StringBuilder();
                for (Renderer apply : this.renderers) {
                    sb2.append(apply.apply(typeDescription, methodDescription));
                }
                return Target.ForStackManipulation.of((Object) sb2.toString());
            }
        }

        public enum ForSelfCallHandle implements OffsetMapping {
            BOUND {
                /* access modifiers changed from: protected */
                public StackManipulation decorate(MethodDescription methodDescription, StackManipulation stackManipulation) {
                    int i10;
                    Object obj;
                    Class<Object> cls = Object.class;
                    if (methodDescription.isStatic()) {
                        i10 = 0;
                    } else {
                        i10 = 2;
                    }
                    ArrayList arrayList = new ArrayList(i10 + 1 + (methodDescription.getParameters().size() * 3));
                    arrayList.add(stackManipulation);
                    if (!methodDescription.isStatic()) {
                        arrayList.add(MethodVariableAccess.loadThis());
                        JavaType javaType = JavaType.METHOD_HANDLE;
                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(cls))))));
                    }
                    if (!methodDescription.getParameters().isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                        Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            if (parameterDescription.getType().isPrimitive()) {
                                obj = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription), Assigner.DEFAULT.assign(parameterDescription.getType(), parameterDescription.getType().asErasure().asBoxed().asGenericType(), Assigner.Typing.STATIC));
                            } else {
                                obj = MethodVariableAccess.load(parameterDescription);
                            }
                            arrayList2.add(obj);
                        }
                        arrayList.add(IntegerConstant.forValue(0));
                        arrayList.add(ArrayFactory.forType(TypeDescription.ForLoadedType.of(cls).asGenericType()).withValues(arrayList2));
                        TypeDescription typeStub = JavaType.METHOD_HANDLES.getTypeStub();
                        JavaType javaType2 = JavaType.METHOD_HANDLE;
                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub, new MethodDescription.Token("insertArguments", 9, javaType2.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(javaType2.getTypeStub(), TypeDefinition.Sort.describe(Integer.TYPE), TypeDefinition.Sort.describe(Object[].class))))));
                    }
                    return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                }
            },
            UNBOUND {
                /* access modifiers changed from: protected */
                public StackManipulation decorate(MethodDescription methodDescription, StackManipulation stackManipulation) {
                    return stackManipulation;
                }
            };

            protected enum Factory implements Factory<SelfCallHandle> {
                INSTANCE;
                
                private static final MethodDescription.InDefinedShape SELF_CALL_HANDLE_BOUND = null;

                static {
                    SELF_CALL_HANDLE_BOUND = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(SelfCallHandle.class).getDeclaredMethods().filter(ElementMatchers.named("bound"))).getOnly();
                }

                public Class<SelfCallHandle> getAnnotationType() {
                    return SelfCallHandle.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<SelfCallHandle> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                        throw new IllegalStateException("Cannot assign a MethodHandle to " + inDefinedShape);
                    } else if (((Boolean) loadable.getValue(SELF_CALL_HANDLE_BOUND).resolve(Boolean.class)).booleanValue()) {
                        return ForSelfCallHandle.BOUND;
                    } else {
                        return ForSelfCallHandle.UNBOUND;
                    }
                }
            }

            /* access modifiers changed from: protected */
            public abstract StackManipulation decorate(MethodDescription methodDescription, StackManipulation stackManipulation);

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                JavaConstant.MethodHandle methodHandle;
                if (methodDescription.isMethod()) {
                    if (methodDescription.isStatic()) {
                        methodHandle = JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) methodDescription.asDefined());
                    } else {
                        methodHandle = JavaConstant.MethodHandle.ofSpecial((MethodDescription.InDefinedShape) methodDescription.asDefined(), typeDescription);
                    }
                    return new Target.ForStackManipulation(decorate(methodDescription, methodHandle.toStackManipulation()));
                }
                throw new IllegalStateException();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForSerializedValue implements OffsetMapping {
            private final StackManipulation deserialization;
            private final TypeDescription.Generic target;
            private final TypeDescription typeDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation deserialization;
                private final TypeDescription typeDescription;

                protected Factory(Class<T> cls, TypeDescription typeDescription2, StackManipulation stackManipulation) {
                    this.annotationType = cls;
                    this.typeDescription = typeDescription2;
                    this.deserialization = stackManipulation;
                }

                public static <S extends Annotation, U extends Serializable> Factory<S> of(Class<S> cls, U u10, Class<? super U> cls2) {
                    if (cls2.isInstance(u10)) {
                        return new Factory(cls, TypeDescription.ForLoadedType.of(cls2), SerializedConstant.of(u10));
                    }
                    throw new IllegalArgumentException(u10 + " is no instance of " + cls2);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType) && this.typeDescription.equals(factory.typeDescription) && this.deserialization.equals(factory.deserialization);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.deserialization.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForSerializedValue(inDefinedShape.getType(), this.typeDescription, this.deserialization);
                }
            }

            public ForSerializedValue(TypeDescription.Generic generic, TypeDescription typeDescription2, StackManipulation stackManipulation) {
                this.target = generic;
                this.typeDescription = typeDescription2;
                this.deserialization = stackManipulation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForSerializedValue forSerializedValue = (ForSerializedValue) obj;
                return this.target.equals(forSerializedValue.target) && this.typeDescription.equals(forSerializedValue.typeDescription) && this.deserialization.equals(forSerializedValue.deserialization);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.deserialization.hashCode();
            }

            public Target resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.typeDescription.asGenericType(), this.target, Assigner.Typing.DYNAMIC);
                if (assign.isValid()) {
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.deserialization, assign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.target);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStackManipulation implements OffsetMapping {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic targetType;
            private final TypeDescription.Generic typeDescription;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation stackManipulation;
                private final TypeDescription.Generic typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription2) {
                    this(cls, ClassConstant.of(typeDescription2), TypeDescription.ForLoadedType.of(Class.class).asGenericType());
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, @MaybeNull Object obj) {
                    if (obj == null) {
                        return new OfDefaultValue(cls);
                    }
                    return new Factory(cls, ConstantValue.Simple.wrap(obj));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType) && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(this.stackManipulation, this.typeDescription, inDefinedShape.getType(), Assigner.Typing.STATIC);
                }

                public Factory(Class<T> cls, EnumerationDescription enumerationDescription) {
                    this(cls, FieldAccess.forEnumeration(enumerationDescription), enumerationDescription.getEnumerationType().asGenericType());
                }

                public Factory(Class<T> cls, ConstantValue constantValue) {
                    this(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType());
                }

                public Factory(Class<T> cls, StackManipulation stackManipulation2, TypeDescription.Generic generic) {
                    this.annotationType = cls;
                    this.stackManipulation = stackManipulation2;
                    this.typeDescription = generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfAnnotationProperty<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final MethodDescription.InDefinedShape property;

                protected OfAnnotationProperty(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape) {
                    this.annotationType = cls;
                    this.property = inDefinedShape;
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, String str) {
                    if (cls.isAnnotation()) {
                        try {
                            return new OfAnnotationProperty(cls, new MethodDescription.ForLoadedMethod(cls.getMethod(str, new Class[0])));
                        } catch (NoSuchMethodException e10) {
                            throw new IllegalArgumentException("Cannot find a property " + str + " on " + cls, e10);
                        }
                    } else {
                        throw new IllegalArgumentException("Not an annotation type: " + cls);
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfAnnotationProperty ofAnnotationProperty = (OfAnnotationProperty) obj;
                    return this.annotationType.equals(ofAnnotationProperty.annotationType) && this.property.equals(ofAnnotationProperty.property);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.property.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    ConstantValue wrapOrNull = ConstantValue.Simple.wrapOrNull(loadable.getValue(this.property).resolve());
                    if (wrapOrNull != null) {
                        return new ForStackManipulation(wrapOrNull.toStackManipulation(), wrapOrNull.getTypeDescription().asGenericType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                    }
                    throw new IllegalStateException("Property does not represent a constant value: " + this.property);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDefaultValue<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public OfDefaultValue(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((OfDefaultValue) obj).annotationType);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(DefaultValue.of(inDefinedShape.getType()), inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDynamicInvocation<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final List<? extends JavaConstant> arguments;
                private final MethodDescription.InDefinedShape bootstrapMethod;

                public OfDynamicInvocation(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list) {
                    this.annotationType = cls;
                    this.bootstrapMethod = inDefinedShape;
                    this.arguments = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfDynamicInvocation ofDynamicInvocation = (OfDynamicInvocation) obj;
                    return this.annotationType.equals(ofDynamicInvocation.annotationType) && this.bootstrapMethod.equals(ofDynamicInvocation.bootstrapMethod) && this.arguments.equals(ofDynamicInvocation.arguments);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.bootstrapMethod.hashCode()) * 31) + this.arguments.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().isInterface()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is not an interface");
                    } else if (!inDefinedShape.getType().getInterfaces().isEmpty()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " must not extend other interfaces");
                    } else if (inDefinedShape.getType().isPublic()) {
                        MethodList methodList = (MethodList) inDefinedShape.getType().getDeclaredMethods().filter(ElementMatchers.isAbstract());
                        if (methodList.size() == 1) {
                            return new ForStackManipulation(MethodInvocation.invoke(this.bootstrapMethod).dynamic(((MethodDescription) methodList.getOnly()).getInternalName(), inDefinedShape.getType().asErasure(), Collections.emptyList(), this.arguments), inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                        }
                        throw new IllegalArgumentException(inDefinedShape.getType() + " must declare exactly one abstract method");
                    } else {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is mot public");
                    }
                }
            }

            public ForStackManipulation(StackManipulation stackManipulation2, TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing2) {
                this.stackManipulation = stackManipulation2;
                this.typeDescription = generic;
                this.targetType = generic2;
                this.typing = typing2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                return this.typing.equals(forStackManipulation.typing) && this.stackManipulation.equals(forStackManipulation.stackManipulation) && this.typeDescription.equals(forStackManipulation.typeDescription) && this.targetType.equals(forStackManipulation.targetType);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.targetType.hashCode()) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.typeDescription, this.targetType, this.typing);
                if (assign.isValid()) {
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.stackManipulation, assign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
            }
        }

        public enum ForStubValue implements OffsetMapping, Factory<StubValue> {
            INSTANCE;

            public Class<StubValue> getAnnotationType() {
                return StubValue.class;
            }

            public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable, Factory.AdviceType adviceType) {
                if (inDefinedShape.getType().represents(Object.class)) {
                    return this;
                }
                throw new IllegalStateException("Cannot use StubValue on non-Object parameter type " + inDefinedShape);
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadOnly(methodDescription.getReturnType(), assigner.assign(methodDescription.getReturnType(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Assigner.Typing.DYNAMIC));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnusedValue implements OffsetMapping {
            private final TypeDefinition target;

            protected enum Factory implements Factory<Unused> {
                INSTANCE;

                public Class<Unused> getAnnotationType() {
                    return Unused.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Unused> loadable, Factory.AdviceType adviceType) {
                    return new ForUnusedValue(inDefinedShape.getType());
                }
            }

            public ForUnusedValue(TypeDefinition typeDefinition) {
                this.target = typeDefinition;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForUnusedValue) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadWrite(this.target);
            }
        }

        public enum Sort {
            ENTER {
                public boolean isPremature(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }
            },
            EXIT {
                public boolean isPremature(MethodDescription methodDescription) {
                    return false;
                }
            };

            public abstract boolean isPremature(MethodDescription methodDescription);
        }

        public interface Target {

            public static abstract class AbstractReadOnlyAdapter implements Target {
                public StackManipulation resolveIncrement(int i10) {
                    throw new IllegalStateException("Cannot write to read-only value");
                }

                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to read-only value");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForArray implements Target {
                protected final TypeDescription.Generic target;
                protected final List<? extends StackManipulation> valueReads;

                public static class ReadOnly extends ForArray {
                    public ReadOnly(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                        super(generic, list);
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only array value");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForArray {
                    private final List<? extends StackManipulation> valueWrites;

                    public ReadWrite(TypeDescription.Generic generic, List<? extends StackManipulation> list, List<? extends StackManipulation> list2) {
                        super(generic, list);
                        this.valueWrites = list2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.valueWrites.equals(((ReadWrite) obj).valueWrites);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.valueWrites.hashCode();
                    }

                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(ArrayAccess.of(this.target).forEach(this.valueWrites), Removal.SINGLE);
                    }
                }

                protected ForArray(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                    this.target = generic;
                    this.valueReads = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForArray forArray = (ForArray) obj;
                    return this.target.equals(forArray.target) && this.valueReads.equals(forArray.valueReads);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.valueReads.hashCode();
                }

                public StackManipulation resolveIncrement(int i10) {
                    throw new IllegalStateException("Cannot increment read-only array value");
                }

                public StackManipulation resolveRead() {
                    return ArrayFactory.forType(this.target).withValues(this.valueReads);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForDefaultValue implements Target {
                protected final StackManipulation readAssignment;
                protected final TypeDefinition typeDefinition;

                public static class ReadOnly extends ForDefaultValue {
                    public ReadOnly(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    public ReadOnly(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                public static class ReadWrite extends ForDefaultValue {
                    public ReadWrite(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        return StackManipulation.Trivial.INSTANCE;
                    }

                    public StackManipulation resolveWrite() {
                        return Removal.of(this.typeDefinition);
                    }

                    public ReadWrite(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                protected ForDefaultValue(TypeDefinition typeDefinition2, StackManipulation stackManipulation) {
                    this.typeDefinition = typeDefinition2;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForDefaultValue forDefaultValue = (ForDefaultValue) obj;
                    return this.typeDefinition.equals(forDefaultValue.typeDefinition) && this.readAssignment.equals(forDefaultValue.readAssignment);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.typeDefinition.hashCode()) * 31) + this.readAssignment.hashCode();
                }

                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(DefaultValue.of(this.typeDefinition), this.readAssignment);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForField implements Target {
                protected final FieldDescription fieldDescription;
                protected final StackManipulation readAssignment;

                public static class ReadOnly extends ForField {
                    public ReadOnly(FieldDescription fieldDescription) {
                        this(fieldDescription, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    public ReadOnly(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                        super(fieldDescription, stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForField {
                    private final StackManipulation writeAssignment;

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ReadWrite(net.bytebuddy.description.field.FieldDescription r2) {
                        /*
                            r1 = this;
                            net.bytebuddy.implementation.bytecode.StackManipulation$Trivial r0 = net.bytebuddy.implementation.bytecode.StackManipulation.Trivial.INSTANCE
                            r1.<init>(r2, r0, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.Target.ForField.ReadWrite.<init>(net.bytebuddy.description.field.FieldDescription):void");
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.writeAssignment.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        return new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(i10), Addition.INTEGER, resolveWrite());
                    }

                    public StackManipulation resolveWrite() {
                        StackManipulation stackManipulation;
                        if (this.fieldDescription.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = new StackManipulation.Compound(MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver(this.fieldDescription.getType()), Removal.SINGLE);
                        }
                        return new StackManipulation.Compound(this.writeAssignment, stackManipulation, FieldAccess.forField(this.fieldDescription).write());
                    }

                    public ReadWrite(FieldDescription fieldDescription, StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        super(fieldDescription, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WriteOnly implements Target {
                    private final FieldDescription fieldDescription;
                    private final StackManipulation writeAssignment;

                    protected WriteOnly(FieldDescription fieldDescription2, StackManipulation stackManipulation) {
                        this.fieldDescription = fieldDescription2;
                        this.writeAssignment = stackManipulation;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WriteOnly writeOnly = (WriteOnly) obj;
                        return this.fieldDescription.equals(writeOnly.fieldDescription) && this.writeAssignment.equals(writeOnly.writeAssignment);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + this.writeAssignment.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        throw new IllegalStateException("Cannot increment write-only field value");
                    }

                    public StackManipulation resolveRead() {
                        throw new IllegalStateException("Cannot read write-only field value");
                    }

                    public StackManipulation resolveWrite() {
                        StackManipulation stackManipulation;
                        if (this.fieldDescription.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = new StackManipulation.Compound(MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver(this.fieldDescription.getType()), Removal.SINGLE);
                        }
                        return new StackManipulation.Compound(this.writeAssignment, stackManipulation, FieldAccess.forField(this.fieldDescription).write());
                    }
                }

                protected ForField(FieldDescription fieldDescription2, StackManipulation stackManipulation) {
                    this.fieldDescription = fieldDescription2;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForField forField = (ForField) obj;
                    return this.fieldDescription.equals(forField.fieldDescription) && this.readAssignment.equals(forField.readAssignment);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + this.readAssignment.hashCode();
                }

                public StackManipulation resolveRead() {
                    StackManipulation stackManipulation;
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (this.fieldDescription.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(this.fieldDescription).read();
                    stackManipulationArr[2] = this.readAssignment;
                    return new StackManipulation.Compound(stackManipulationArr);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForStackManipulation implements Target {
                private final StackManipulation stackManipulation;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Writable implements Target {
                    private final StackManipulation read;
                    private final StackManipulation write;

                    public Writable(StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        this.read = stackManipulation;
                        this.write = stackManipulation2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Writable writable = (Writable) obj;
                        return this.read.equals(writable.read) && this.write.equals(writable.write);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.read.hashCode()) * 31) + this.write.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        throw new IllegalStateException("Cannot increment mutable constant value: " + this.write);
                    }

                    public StackManipulation resolveRead() {
                        return this.read;
                    }

                    public StackManipulation resolveWrite() {
                        return this.write;
                    }
                }

                public ForStackManipulation(StackManipulation stackManipulation2) {
                    this.stackManipulation = stackManipulation2;
                }

                public static Target of(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForStackManipulation(MethodConstant.of(inDefinedShape));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((ForStackManipulation) obj).stackManipulation);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.stackManipulation.hashCode();
                }

                public StackManipulation resolveIncrement(int i10) {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                public StackManipulation resolveRead() {
                    return this.stackManipulation;
                }

                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                public static Target of(TypeDescription typeDescription) {
                    return new ForStackManipulation(ClassConstant.of(typeDescription));
                }

                public static Target of(@MaybeNull Object obj) {
                    StackManipulation stackManipulation2;
                    if (obj == null) {
                        stackManipulation2 = NullConstant.INSTANCE;
                    } else {
                        stackManipulation2 = ConstantValue.Simple.wrap(obj).toStackManipulation();
                    }
                    return new ForStackManipulation(stackManipulation2);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForVariable implements Target {
                protected final int offset;
                protected final StackManipulation readAssignment;
                protected final TypeDefinition typeDefinition;

                public static class ReadOnly extends ForVariable {
                    public ReadOnly(TypeDefinition typeDefinition, int i10) {
                        this(typeDefinition, i10, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        throw new IllegalStateException("Cannot write to read-only variable " + this.typeDefinition + " at " + this.offset);
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only parameter " + this.typeDefinition + " at " + this.offset);
                    }

                    public ReadOnly(TypeDefinition typeDefinition, int i10, StackManipulation stackManipulation) {
                        super(typeDefinition, i10, stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForVariable {
                    private final StackManipulation writeAssignment;

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ReadWrite(net.bytebuddy.description.type.TypeDefinition r2, int r3) {
                        /*
                            r1 = this;
                            net.bytebuddy.implementation.bytecode.StackManipulation$Trivial r0 = net.bytebuddy.implementation.bytecode.StackManipulation.Trivial.INSTANCE
                            r1.<init>(r2, r3, r0, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.Target.ForVariable.ReadWrite.<init>(net.bytebuddy.description.type.TypeDefinition, int):void");
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.writeAssignment.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i10) {
                        if (this.typeDefinition.represents(Integer.TYPE)) {
                            return MethodVariableAccess.of(this.typeDefinition).increment(this.offset, i10);
                        }
                        return new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(1), Addition.INTEGER, resolveWrite());
                    }

                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, MethodVariableAccess.of(this.typeDefinition).storeAt(this.offset));
                    }

                    public ReadWrite(TypeDefinition typeDefinition, int i10, StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        super(typeDefinition, i10, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                protected ForVariable(TypeDefinition typeDefinition2, int i10, StackManipulation stackManipulation) {
                    this.typeDefinition = typeDefinition2;
                    this.offset = i10;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForVariable forVariable = (ForVariable) obj;
                    return this.offset == forVariable.offset && this.typeDefinition.equals(forVariable.typeDefinition) && this.readAssignment.equals(forVariable.readAssignment);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.typeDefinition.hashCode()) * 31) + this.offset) * 31) + this.readAssignment.hashCode();
                }

                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(MethodVariableAccess.of(this.typeDefinition).loadFrom(this.offset), this.readAssignment);
                }
            }

            StackManipulation resolveIncrement(int i10);

            StackManipulation resolveRead();

            StackManipulation resolveWrite();
        }

        Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort);

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForField implements OffsetMapping {
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape FIELD_DECLARING_TYPE;
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape FIELD_READ_ONLY;
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape FIELD_TYPING;
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape FIELD_VALUE;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForField {
                private final FieldDescription fieldDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final FieldDescription fieldDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, FieldDescription fieldDescription2) {
                        this(cls, fieldDescription2, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                    }

                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.fieldDescription.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing, this.fieldDescription);
                    }

                    public Factory(Class<T> cls, FieldDescription fieldDescription2, boolean z10, Assigner.Typing typing2) {
                        this.annotationType = cls;
                        this.fieldDescription = fieldDescription2;
                        this.readOnly = z10;
                        this.typing = typing2;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, FieldDescription fieldDescription2) {
                    super(generic, z10, typing);
                    this.fieldDescription = fieldDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }

                /* access modifiers changed from: protected */
                @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                    } else if (this.fieldDescription.isVisibleTo(typeDescription)) {
                        return this.fieldDescription;
                    } else {
                        throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                    }
                }
            }

            static {
                MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldValue.class).getDeclaredMethods();
                FIELD_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                FIELD_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                FIELD_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
            }

            protected ForField(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z10;
                this.typing = typing2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForField forField = (ForField) obj;
                return this.readOnly == forField.readOnly && this.typing.equals(forField.typing) && this.target.equals(forField.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                FieldDescription resolve = resolve(typeDescription, methodDescription);
                if (!resolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot access non-static field " + resolve + " from static method " + methodDescription);
                } else if (!sort.isPremature(methodDescription) || resolve.isStatic()) {
                    StackManipulation assign = assigner.assign(resolve.getType(), this.target, this.typing);
                    if (!assign.isValid()) {
                        throw new IllegalStateException("Cannot assign " + resolve + " to " + this.target);
                    } else if (this.readOnly) {
                        return new Target.ForField.ReadOnly(resolve, assign);
                    } else {
                        StackManipulation assign2 = assigner.assign(this.target, resolve.getType(), this.typing);
                        if (assign2.isValid()) {
                            return new Target.ForField.ReadWrite((FieldDescription) resolve.asDefined(), assign, assign2);
                        }
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + resolve);
                    }
                } else if (!this.readOnly) {
                    StackManipulation assign3 = assigner.assign(this.target, resolve.getType(), this.typing);
                    if (assign3.isValid()) {
                        return new Target.ForField.WriteOnly((FieldDescription) resolve.asDefined(), assign3);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + resolve);
                } else {
                    throw new IllegalStateException("Cannot read " + resolve + " before super constructor call");
                }
            }

            /* access modifiers changed from: protected */
            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Unresolved extends ForField {
                protected static final String BEAN_PROPERTY = "";
                private final String name;

                protected enum Factory implements Factory<FieldValue> {
                    INSTANCE;

                    public Class<FieldValue> getAnnotationType() {
                        return FieldValue.class;
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ForField.FIELD_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.FIELD_DECLARING_TYPE).resolve(TypeDescription.class);
                            if (typeDescription.represents(Void.TYPE)) {
                                return new WithImplicitType(inDefinedShape.getType(), loadable);
                            }
                            return new WithExplicitType(inDefinedShape.getType(), loadable, typeDescription);
                        }
                        throw new IllegalStateException("Cannot write to field for " + inDefinedShape + " in read-only context");
                    }
                }

                protected Unresolved(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, String str) {
                    super(generic, z10, typing);
                    this.name = str;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                }

                /* access modifiers changed from: protected */
                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                public int hashCode() {
                    return (super.hashCode() * 31) + this.name.hashCode();
                }

                /* access modifiers changed from: protected */
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    FieldLocator.Resolution resolution;
                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                    if (this.name.equals("")) {
                        resolution = FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription);
                    } else {
                        resolution = fieldLocator.locate(this.name);
                    }
                    if (resolution.isResolved()) {
                        return resolution.getField();
                    }
                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends Unresolved {
                    private final TypeDescription declaringType;

                    protected WithExplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable, TypeDescription typeDescription) {
                        this(generic, ((Boolean) loadable.getValue(ForField.FIELD_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (String) loadable.getValue(ForField.FIELD_VALUE).resolve(String.class), typeDescription);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                    }

                    /* access modifiers changed from: protected */
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                        }
                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.declaringType.hashCode();
                    }

                    public WithExplicitType(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, String str, TypeDescription typeDescription) {
                        super(generic, z10, typing, str);
                        this.declaringType = typeDescription;
                    }
                }

                public static class WithImplicitType extends Unresolved {
                    protected WithImplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable) {
                        this(generic, ((Boolean) loadable.getValue(ForField.FIELD_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (String) loadable.getValue(ForField.FIELD_VALUE).resolve(String.class));
                    }

                    /* access modifiers changed from: protected */
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        return new FieldLocator.ForClassHierarchy(typeDescription);
                    }

                    public WithImplicitType(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, String str) {
                        super(generic, z10, typing, str);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForArgument implements OffsetMapping {
            protected final boolean readOnly;
            protected final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForArgument {
                private final ParameterDescription parameterDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final ParameterDescription parameterDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, ParameterDescription parameterDescription2) {
                        this(cls, parameterDescription2, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.parameterDescription.equals(factory.parameterDescription);
                    }

                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.parameterDescription.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing, this.parameterDescription);
                    }

                    public Factory(Class<T> cls, ParameterDescription parameterDescription2, boolean z10, Assigner.Typing typing2) {
                        this.annotationType = cls;
                        this.parameterDescription = parameterDescription2;
                        this.readOnly = z10;
                        this.typing = typing2;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, ParameterDescription parameterDescription2) {
                    super(generic, z10, typing);
                    this.parameterDescription = parameterDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterDescription.equals(((Resolved) obj).parameterDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.parameterDescription.hashCode();
                }

                /* access modifiers changed from: protected */
                public ParameterDescription resolve(MethodDescription methodDescription) {
                    if (this.parameterDescription.getDeclaringMethod().equals(methodDescription)) {
                        return this.parameterDescription;
                    }
                    throw new IllegalStateException(this.parameterDescription + " is not a parameter of " + methodDescription);
                }
            }

            protected ForArgument(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z10;
                this.typing = typing2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForArgument forArgument = (ForArgument) obj;
                return this.readOnly == forArgument.readOnly && this.typing.equals(forArgument.typing) && this.target.equals(forArgument.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                ParameterDescription resolve = resolve(methodDescription);
                StackManipulation assign = assigner.assign(resolve.getType(), this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + resolve + " to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(resolve.getType(), argumentHandler.argument(resolve.getOffset()), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, resolve.getType(), this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(resolve.getType(), argumentHandler.argument(resolve.getOffset()), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + resolve + " to " + this.target);
                }
            }

            /* access modifiers changed from: protected */
            public abstract ParameterDescription resolve(MethodDescription methodDescription);

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unresolved extends ForArgument {
                private final int index;
                private final boolean optional;

                protected enum Factory implements Factory<Argument> {
                    INSTANCE;
                    
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL = null;
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_READ_ONLY = null;
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_TYPING = null;
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_VALUE = null;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
                        ARGUMENT_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        ARGUMENT_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                        ARGUMENT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                        ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(Session.Feature.OPTIONAL_ELEMENT))).getOnly();
                    }

                    public Class<Argument> getAnnotationType() {
                        return Argument.class;
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ARGUMENT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                            return new Unresolved(inDefinedShape.getType(), loadable);
                        }
                        throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape + " when using delegation");
                    }
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected Unresolved(net.bytebuddy.description.type.TypeDescription.Generic r9, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.Argument> r10) {
                    /*
                        r8 = this;
                        java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_READ_ONLY
                        net.bytebuddy.description.annotation.AnnotationValue r1 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                        java.lang.Object r1 = r1.resolve(r0)
                        java.lang.Boolean r1 = (java.lang.Boolean) r1
                        boolean r4 = r1.booleanValue()
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_TYPING
                        net.bytebuddy.description.annotation.AnnotationValue r1 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                        java.lang.Class<net.bytebuddy.description.enumeration.EnumerationDescription> r2 = net.bytebuddy.description.enumeration.EnumerationDescription.class
                        java.lang.Object r1 = r1.resolve(r2)
                        net.bytebuddy.description.enumeration.EnumerationDescription r1 = (net.bytebuddy.description.enumeration.EnumerationDescription) r1
                        java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r2 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                        java.lang.Enum r1 = r1.load(r2)
                        r5 = r1
                        net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r5 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r5
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_VALUE
                        net.bytebuddy.description.annotation.AnnotationValue r1 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                        java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
                        java.lang.Object r1 = r1.resolve(r2)
                        java.lang.Integer r1 = (java.lang.Integer) r1
                        int r6 = r1.intValue()
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_OPTIONAL
                        net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                        java.lang.Object r10 = r10.resolve(r0)
                        java.lang.Boolean r10 = (java.lang.Boolean) r10
                        boolean r7 = r10.booleanValue()
                        r2 = r8
                        r3 = r9
                        r2.<init>(r3, r4, r5, r6, r7)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
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
                    Unresolved unresolved = (Unresolved) obj;
                    return this.index == unresolved.index && this.optional == unresolved.optional;
                }

                public int hashCode() {
                    return (((super.hashCode() * 31) + this.index) * 31) + (this.optional ? 1 : 0);
                }

                /* access modifiers changed from: protected */
                public ParameterDescription resolve(MethodDescription methodDescription) {
                    ParameterList<?> parameters = methodDescription.getParameters();
                    int size = parameters.size();
                    int i10 = this.index;
                    if (size > i10) {
                        return (ParameterDescription) parameters.get(i10);
                    }
                    throw new IllegalStateException(methodDescription + " does not define an index " + this.index);
                }

                public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                    if (!this.optional || methodDescription.getParameters().size() > this.index) {
                        return super.resolve(typeDescription, methodDescription, assigner, argumentHandler, sort);
                    }
                    return this.readOnly ? new Target.ForDefaultValue.ReadOnly(this.target) : new Target.ForDefaultValue.ReadWrite(this.target);
                }

                protected Unresolved(ParameterDescription parameterDescription) {
                    this(parameterDescription.getType(), true, Assigner.Typing.STATIC, parameterDescription.getIndex());
                }

                public Unresolved(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, int i10) {
                    this(generic, z10, typing, i10, false);
                }

                public Unresolved(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing, int i10, boolean z11) {
                    super(generic, z10, typing);
                    this.index = i10;
                    this.optional = z11;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForEnterValue implements OffsetMapping {
            private final TypeDescription.Generic enterType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Factory implements Factory<Enter> {
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ENTER_READ_ONLY;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ENTER_TYPING;
                private final TypeDefinition enterType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Enter.class).getDeclaredMethods();
                    ENTER_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    ENTER_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                protected Factory(TypeDefinition typeDefinition) {
                    this.enterType = typeDefinition;
                }

                protected static Factory<Enter> of(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Enter.class) : new Factory(typeDefinition);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.enterType.equals(((Factory) obj).enterType);
                }

                public Class<Enter> getAnnotationType() {
                    return Enter.class;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.enterType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Enter> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForEnterValue(inDefinedShape.getType(), this.enterType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            protected ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, AnnotationDescription.Loadable<Enter> loadable) {
                this(generic, generic2, ((Boolean) loadable.getValue(Factory.ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.ENTER_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForEnterValue forEnterValue = (ForEnterValue) obj;
                return this.readOnly == forEnterValue.readOnly && this.typing.equals(forEnterValue.typing) && this.target.equals(forEnterValue.target) && this.enterType.equals(forEnterValue.enterType);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.enterType.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.enterType, this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.enterType + " to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.enter(), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, this.enterType, this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(this.target, argumentHandler.enter(), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + this.enterType);
                }
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z10, Assigner.Typing typing2) {
                this.target = generic;
                this.enterType = generic2;
                this.readOnly = z10;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExitValue implements OffsetMapping {
            private final TypeDescription.Generic exitType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class Factory implements Factory<Exit> {
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape EXIT_READ_ONLY;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape EXIT_TYPING;
                private final TypeDefinition exitType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Exit.class).getDeclaredMethods();
                    EXIT_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    EXIT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                protected Factory(TypeDefinition typeDefinition) {
                    this.exitType = typeDefinition;
                }

                protected static Factory<Exit> of(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Exit.class) : new Factory(typeDefinition);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.exitType.equals(((Factory) obj).exitType);
                }

                public Class<Exit> getAnnotationType() {
                    return Exit.class;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.exitType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Exit> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForExitValue(inDefinedShape.getType(), this.exitType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            protected ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, AnnotationDescription.Loadable<Exit> loadable) {
                this(generic, generic2, ((Boolean) loadable.getValue(Factory.EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.EXIT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForExitValue forExitValue = (ForExitValue) obj;
                return this.readOnly == forExitValue.readOnly && this.typing.equals(forExitValue.typing) && this.target.equals(forExitValue.target) && this.exitType.equals(forExitValue.exitType);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.exitType.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.exitType, this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.exitType + " to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.exit(), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, this.exitType, this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(this.target, argumentHandler.exit(), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + this.exitType);
                }
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z10, Assigner.Typing typing2) {
                this.target = generic;
                this.exitType = generic2;
                this.readOnly = z10;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForReturnValue implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            protected enum Factory implements Factory<Return> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape RETURN_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape RETURN_TYPING = null;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Return.class).getDeclaredMethods();
                    RETURN_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    RETURN_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                public Class<Return> getAnnotationType() {
                    return Return.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Return> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForReturnValue(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot write return value for " + inDefinedShape + " in read-only context");
                }
            }

            protected ForReturnValue(TypeDescription.Generic generic, AnnotationDescription.Loadable<Return> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.RETURN_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForReturnValue forReturnValue = (ForReturnValue) obj;
                return this.readOnly == forReturnValue.readOnly && this.typing.equals(forReturnValue.typing) && this.target.equals(forReturnValue.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(methodDescription.getReturnType(), this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + methodDescription.getReturnType() + " to " + this.target);
                } else if (!this.readOnly) {
                    StackManipulation assign2 = assigner.assign(this.target, methodDescription.getReturnType(), this.typing);
                    if (!assign2.isValid()) {
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + methodDescription.getReturnType());
                    } else if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return new Target.ForDefaultValue.ReadWrite(this.target);
                    } else {
                        return new Target.ForVariable.ReadWrite(methodDescription.getReturnType(), argumentHandler.returned(), assign, assign2);
                    }
                } else if (methodDescription.getReturnType().represents(Void.TYPE)) {
                    return new Target.ForDefaultValue.ReadOnly(this.target);
                } else {
                    return new Target.ForVariable.ReadOnly(methodDescription.getReturnType(), argumentHandler.returned(), assign);
                }
            }

            public ForReturnValue(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z10;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThrowable implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            protected enum Factory implements Factory<Thrown> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THROWN_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THROWN_TYPING = null;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Thrown.class).getDeclaredMethods();
                    THROWN_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    THROWN_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                protected static Factory<?> of(MethodDescription.InDefinedShape inDefinedShape) {
                    if (((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class)).represents(NoExceptionHandler.class)) {
                        return new Factory.Illegal(Thrown.class);
                    }
                    return INSTANCE;
                }

                public Class<Thrown> getAnnotationType() {
                    return Thrown.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Thrown> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThrowable(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            protected ForThrowable(TypeDescription.Generic generic, AnnotationDescription.Loadable<Thrown> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.THROWN_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThrowable forThrowable = (ForThrowable) obj;
                return this.readOnly == forThrowable.readOnly && this.typing.equals(forThrowable.typing) && this.target.equals(forThrowable.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign Throwable to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(TypeDescription.ForLoadedType.of(Throwable.class), argumentHandler.thrown(), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(TypeDescription.ForLoadedType.of(Throwable.class), argumentHandler.thrown(), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to Throwable");
                }
            }

            public ForThrowable(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z10;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThisReference implements OffsetMapping {
            private final boolean optional;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            protected enum Factory implements Factory<This> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THIS_OPTIONAL = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THIS_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THIS_TYPING = null;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(This.class).getDeclaredMethods();
                    THIS_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    THIS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    THIS_OPTIONAL = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(Session.Feature.OPTIONAL_ELEMENT))).getOnly();
                }

                public Class<This> getAnnotationType() {
                    return This.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(THIS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThisReference(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot write to this reference for " + inDefinedShape + " in read-only context");
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected ForThisReference(net.bytebuddy.description.type.TypeDescription.Generic r5, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.This> r6) {
                /*
                    r4 = this;
                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.THIS_READ_ONLY
                    net.bytebuddy.description.annotation.AnnotationValue r1 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                    java.lang.Object r1 = r1.resolve(r0)
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r1 = r1.booleanValue()
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.THIS_TYPING
                    net.bytebuddy.description.annotation.AnnotationValue r2 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r2)
                    java.lang.Class<net.bytebuddy.description.enumeration.EnumerationDescription> r3 = net.bytebuddy.description.enumeration.EnumerationDescription.class
                    java.lang.Object r2 = r2.resolve(r3)
                    net.bytebuddy.description.enumeration.EnumerationDescription r2 = (net.bytebuddy.description.enumeration.EnumerationDescription) r2
                    java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r3 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                    java.lang.Enum r2 = r2.load(r3)
                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r2
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r3 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.THIS_OPTIONAL
                    net.bytebuddy.description.annotation.AnnotationValue r6 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r3)
                    java.lang.Object r6 = r6.resolve(r0)
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r6 = r6.booleanValue()
                    r4.<init>(r5, r1, r2, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThisReference forThisReference = (ForThisReference) obj;
                return this.readOnly == forThisReference.readOnly && this.optional == forThisReference.optional && this.typing.equals(forThisReference.typing) && this.target.equals(forThisReference.target);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode()) * 31) + (this.optional ? 1 : 0);
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (!methodDescription.isStatic() && !sort.isPremature(methodDescription)) {
                    StackManipulation assign = assigner.assign(typeDescription.asGenericType(), this.target, this.typing);
                    if (!assign.isValid()) {
                        throw new IllegalStateException("Cannot assign " + typeDescription + " to " + this.target);
                    } else if (this.readOnly) {
                        return new Target.ForVariable.ReadOnly(typeDescription.asGenericType(), argumentHandler.argument(0), assign);
                    } else {
                        StackManipulation assign2 = assigner.assign(this.target, typeDescription.asGenericType(), this.typing);
                        if (assign2.isValid()) {
                            return new Target.ForVariable.ReadWrite(typeDescription.asGenericType(), argumentHandler.argument(0), assign, assign2);
                        }
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + typeDescription);
                    }
                } else if (!this.optional) {
                    throw new IllegalStateException("Cannot map this reference for static method or constructor start: " + methodDescription);
                } else if (this.readOnly) {
                    return new Target.ForDefaultValue.ReadOnly(typeDescription);
                } else {
                    return new Target.ForDefaultValue.ReadWrite(typeDescription);
                }
            }

            public ForThisReference(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing2, boolean z11) {
                this.target = generic;
                this.readOnly = z10;
                this.typing = typing2;
                this.optional = z11;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAllArguments implements OffsetMapping {
            private final boolean includeSelf;
            private final boolean nullIfEmpty;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            protected enum Factory implements Factory<AllArguments> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_INCLUDE_SELF = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING = null;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods();
                    ALL_ARGUMENTS_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    ALL_ARGUMENTS_INCLUDE_SELF = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("includeSelf"))).getOnly();
                    ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfEmpty"))).getOnly();
                }

                public Class<AllArguments> getAnnotationType() {
                    return AllArguments.class;
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable, Factory.AdviceType adviceType) {
                    TypeDescription.Generic generic;
                    Class<Object> cls = Object.class;
                    if (!inDefinedShape.getType().represents(cls) && !inDefinedShape.getType().isArray()) {
                        throw new IllegalStateException("Cannot use AllArguments annotation on a non-array type");
                    } else if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        if (inDefinedShape.getType().represents(cls)) {
                            generic = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls);
                        } else {
                            generic = inDefinedShape.getType().getComponentType();
                        }
                        return new ForAllArguments(generic, loadable);
                    } else {
                        throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape);
                    }
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected ForAllArguments(net.bytebuddy.description.type.TypeDescription.Generic r9, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.AllArguments> r10) {
                /*
                    r8 = this;
                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_READ_ONLY
                    net.bytebuddy.description.annotation.AnnotationValue r1 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                    java.lang.Object r1 = r1.resolve(r0)
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r4 = r1.booleanValue()
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_TYPING
                    net.bytebuddy.description.annotation.AnnotationValue r1 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                    java.lang.Class<net.bytebuddy.description.enumeration.EnumerationDescription> r2 = net.bytebuddy.description.enumeration.EnumerationDescription.class
                    java.lang.Object r1 = r1.resolve(r2)
                    net.bytebuddy.description.enumeration.EnumerationDescription r1 = (net.bytebuddy.description.enumeration.EnumerationDescription) r1
                    java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r2 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                    java.lang.Enum r1 = r1.load(r2)
                    r5 = r1
                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r5 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r5
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_INCLUDE_SELF
                    net.bytebuddy.description.annotation.AnnotationValue r1 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                    java.lang.Object r1 = r1.resolve(r0)
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r6 = r1.booleanValue()
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_NULL_IF_EMPTY
                    net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                    java.lang.Object r10 = r10.resolve(r0)
                    java.lang.Boolean r10 = (java.lang.Boolean) r10
                    boolean r7 = r10.booleanValue()
                    r2 = r8
                    r3 = r9
                    r2.<init>(r3, r4, r5, r6, r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAllArguments forAllArguments = (ForAllArguments) obj;
                return this.readOnly == forAllArguments.readOnly && this.includeSelf == forAllArguments.includeSelf && this.nullIfEmpty == forAllArguments.nullIfEmpty && this.typing.equals(forAllArguments.typing) && this.target.equals(forAllArguments.target);
            }

            public int hashCode() {
                return (((((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode()) * 31) + (this.includeSelf ? 1 : 0)) * 31) + (this.nullIfEmpty ? 1 : 0);
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (this.nullIfEmpty && methodDescription.getParameters().isEmpty() && (!this.includeSelf || methodDescription.isStatic())) {
                    return this.readOnly ? new Target.ForStackManipulation(NullConstant.INSTANCE) : new Target.ForStackManipulation.Writable(NullConstant.INSTANCE, Removal.SINGLE);
                }
                ArrayList arrayList = new ArrayList(((!this.includeSelf || methodDescription.isStatic()) ? 0 : 1) + methodDescription.getParameters().size());
                if (this.includeSelf && !methodDescription.isStatic()) {
                    if (!sort.isPremature(methodDescription) || !methodDescription.isConstructor()) {
                        StackManipulation assign = assigner.assign(methodDescription.getDeclaringType().asGenericType(), this.target, this.typing);
                        if (assign.isValid()) {
                            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(argumentHandler.argument(0)), assign));
                        } else {
                            throw new IllegalStateException("Cannot assign " + methodDescription.getDeclaringType() + " to " + this.target);
                        }
                    } else {
                        throw new IllegalStateException("Cannot include self in all arguments array from " + methodDescription);
                    }
                }
                Iterator<E> it = methodDescription.getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    StackManipulation assign2 = assigner.assign(parameterDescription.getType(), this.target, this.typing);
                    if (assign2.isValid()) {
                        arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(parameterDescription.getType()).loadFrom(argumentHandler.argument(parameterDescription.getOffset())), assign2));
                    } else {
                        throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target);
                    }
                }
                if (this.readOnly) {
                    return new Target.ForArray.ReadOnly(this.target, arrayList);
                }
                ArrayList arrayList2 = new ArrayList((((!this.includeSelf || methodDescription.isStatic()) ? 0 : 1) + methodDescription.getParameters().size()) * 2);
                if (this.includeSelf && !methodDescription.isStatic()) {
                    StackManipulation assign3 = assigner.assign(this.target, methodDescription.getDeclaringType().asGenericType(), this.typing);
                    if (assign3.isValid()) {
                        arrayList2.add(new StackManipulation.Compound(assign3, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.argument(0))));
                    } else {
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + methodDescription.getDeclaringType());
                    }
                }
                Iterator<E> it2 = methodDescription.getParameters().iterator();
                while (it2.hasNext()) {
                    ParameterDescription parameterDescription2 = (ParameterDescription) it2.next();
                    StackManipulation assign4 = assigner.assign(this.target, parameterDescription2.getType(), this.typing);
                    if (assign4.isValid()) {
                        arrayList2.add(new StackManipulation.Compound(assign4, MethodVariableAccess.of(parameterDescription2.getType()).storeAt(argumentHandler.argument(parameterDescription2.getOffset()))));
                    } else {
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + parameterDescription2);
                    }
                }
                return new Target.ForArray.ReadWrite(this.target, arrayList, arrayList2);
            }

            public ForAllArguments(TypeDescription.Generic generic, boolean z10, Assigner.Typing typing2, boolean z11, boolean z12) {
                this.target = generic;
                this.readOnly = z10;
                this.typing = typing2;
                this.includeSelf = z11;
                this.nullIfEmpty = z12;
            }
        }
    }

    public static final class OnDefaultValue {
        private OnDefaultValue() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodEnter {
        boolean inline() default true;

        boolean prependLineNumber() default true;

        Class<?> skipOn() default void.class;

        int skipOnIndex() default -1;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodExit {
        boolean backupArguments() default true;

        boolean inline() default true;

        Class<? extends Throwable> onThrowable() default NoExceptionHandler.class;

        Class<?> repeatOn() default void.class;

        int repeatOnIndex() default -1;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    public static final class OnNonDefaultValue {
        private OnNonDefaultValue() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Origin {
        public static final String DEFAULT = "";

        String value() default "";
    }

    public interface PostProcessor {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements PostProcessor {
            private final List<PostProcessor> postProcessors;

            protected Compound(List<PostProcessor> list) {
                this.postProcessors = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.postProcessors.equals(((Compound) obj).postProcessors);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.postProcessors.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
                ArrayList arrayList = new ArrayList(this.postProcessors.size());
                for (PostProcessor resolve : this.postProcessors) {
                    arrayList.add(resolve.resolve(typeDescription, methodDescription, assigner, argumentHandler, forPostProcessor, stackManipulation));
                }
                return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
            }
        }

        public interface Factory {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                public Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.factories.hashCode();
                }

                public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                    ArrayList arrayList = new ArrayList(this.factories.size());
                    for (Factory make : this.factories) {
                        arrayList.add(make.make(inDefinedShape, z10));
                    }
                    return new Compound(arrayList);
                }

                public Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z10);
        }

        public enum NoOp implements PostProcessor, Factory {
            INSTANCE;

            public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z10) {
                return this;
            }

            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
                return StackManipulation.Trivial.INSTANCE;
            }
        }

        StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Return {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SelfCallHandle {
        boolean bound() default true;
    }

    public interface StackMapFrameHandler {

        public static abstract class Default implements ForInstrumentedMethod {
            protected static final Object[] EMPTY = new Object[0];
            protected int currentFrameDivergence;
            protected final boolean expandFrames;
            protected final List<? extends TypeDescription> initialTypes;
            protected final MethodDescription instrumentedMethod;
            protected final TypeDescription instrumentedType;
            protected final List<? extends TypeDescription> latentTypes;
            protected final List<? extends TypeDescription> postMethodTypes;
            protected final List<? extends TypeDescription> preMethodTypes;

            protected class ForAdvice implements ForAdvice {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final List<? extends TypeDescription> endTypes;
                private final Initialization initialization;
                private boolean intermedate = false;
                private final List<? extends TypeDescription> intermediateTypes;
                protected final List<? extends TypeDescription> startTypes;
                protected final TranslationMode translationMode;

                protected ForAdvice(MethodDescription.InDefinedShape inDefinedShape, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, TranslationMode translationMode2, Initialization initialization2) {
                    this.adviceMethod = inDefinedShape;
                    this.startTypes = list;
                    this.intermediateTypes = list2;
                    this.endTypes = list3;
                    this.translationMode = translationMode2;
                    this.initialization = initialization2;
                }

                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    Default defaultR = Default.this;
                    if (defaultR.expandFrames) {
                        defaultR.injectFullFrame(methodVisitor, this.initialization, CompoundList.of(this.startTypes, this.endTypes), Collections.emptyList());
                        return;
                    }
                    int i10 = 0;
                    if (defaultR.currentFrameDivergence != 0 || (!this.intermedate && this.endTypes.size() >= 4)) {
                        if (Default.this.currentFrameDivergence >= 3 || !this.endTypes.isEmpty()) {
                            Default.this.injectFullFrame(methodVisitor, this.initialization, CompoundList.of(this.startTypes, this.endTypes), Collections.emptyList());
                            return;
                        }
                        int i11 = Default.this.currentFrameDivergence;
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(2, i11, objArr, objArr.length, objArr);
                        Default.this.currentFrameDivergence = 0;
                    } else if (this.intermedate || this.endTypes.isEmpty()) {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr2.length, objArr2, objArr2.length, objArr2);
                    } else {
                        int size = this.endTypes.size();
                        Object[] objArr3 = new Object[size];
                        for (TypeDescription frame : this.endTypes) {
                            objArr3[i10] = Initialization.INITIALIZED.toFrame(frame);
                            i10++;
                        }
                        Object[] objArr4 = Default.EMPTY;
                        methodVisitor.visitFrame(1, size, objArr3, objArr4.length, objArr4);
                    }
                }

                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    Default defaultR = Default.this;
                    if (defaultR.expandFrames || defaultR.currentFrameDivergence != 0) {
                        defaultR.injectFullFrame(methodVisitor, this.initialization, this.startTypes, Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
                        return;
                    }
                    Object[] objArr = Default.EMPTY;
                    methodVisitor.visitFrame(4, objArr.length, objArr, 1, new Object[]{Type.getInternalName(Throwable.class)});
                }

                public void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list) {
                    Default defaultR = Default.this;
                    if (defaultR.expandFrames) {
                        defaultR.injectFullFrame(methodVisitor, this.initialization, CompoundList.of(this.startTypes, this.intermediateTypes), list);
                    } else {
                        int i10 = 0;
                        if (!this.intermedate || list.size() >= 2) {
                            if (Default.this.currentFrameDivergence != 0 || this.intermediateTypes.size() >= 4 || (!list.isEmpty() && (list.size() >= 2 || !this.intermediateTypes.isEmpty()))) {
                                if (Default.this.currentFrameDivergence >= 3 || !this.intermediateTypes.isEmpty() || !list.isEmpty()) {
                                    Default.this.injectFullFrame(methodVisitor, this.initialization, CompoundList.of(this.startTypes, this.intermediateTypes), list);
                                } else {
                                    int i11 = Default.this.currentFrameDivergence;
                                    Object[] objArr = Default.EMPTY;
                                    methodVisitor.visitFrame(2, i11, objArr, objArr.length, objArr);
                                }
                            } else if (!this.intermediateTypes.isEmpty()) {
                                int size = this.intermediateTypes.size();
                                Object[] objArr2 = new Object[size];
                                for (TypeDescription frame : this.intermediateTypes) {
                                    objArr2[i10] = Initialization.INITIALIZED.toFrame(frame);
                                    i10++;
                                }
                                Object[] objArr3 = Default.EMPTY;
                                methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                            } else if (list.isEmpty()) {
                                Object[] objArr4 = Default.EMPTY;
                                methodVisitor.visitFrame(3, objArr4.length, objArr4, objArr4.length, objArr4);
                            } else {
                                Object[] objArr5 = Default.EMPTY;
                                methodVisitor.visitFrame(4, objArr5.length, objArr5, 1, new Object[]{Initialization.INITIALIZED.toFrame((TypeDescription) list.get(0))});
                            }
                        } else if (list.isEmpty()) {
                            Object[] objArr6 = Default.EMPTY;
                            methodVisitor.visitFrame(3, objArr6.length, objArr6, objArr6.length, objArr6);
                        } else {
                            Object[] objArr7 = Default.EMPTY;
                            methodVisitor.visitFrame(4, objArr7.length, objArr7, 1, new Object[]{Initialization.INITIALIZED.toFrame((TypeDescription) list.get(0))});
                        }
                    }
                    Default.this.currentFrameDivergence = this.intermediateTypes.size() - this.endTypes.size();
                    this.intermedate = true;
                }

                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    List list;
                    Default defaultR = Default.this;
                    if (defaultR.expandFrames || defaultR.currentFrameDivergence != 0) {
                        Initialization initialization2 = this.initialization;
                        List<? extends TypeDescription> list2 = this.startTypes;
                        if (this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                            list = Collections.emptyList();
                        } else {
                            list = Collections.singletonList(this.adviceMethod.getReturnType().asErasure());
                        }
                        defaultR.injectFullFrame(methodVisitor, initialization2, list2, list);
                    } else if (this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1, new Object[]{Initialization.INITIALIZED.toFrame(this.adviceMethod.getReturnType().asErasure())});
                    }
                }

                public void translateFrame(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                    Default.this.translateFrame(methodVisitor, this.translationMode, this.adviceMethod, this.startTypes, i10, i11, objArr, i12, objArr2);
                }
            }

            protected enum Initialization {
                UNITIALIZED {
                    /* access modifiers changed from: protected */
                    public Object toFrame(TypeDescription typeDescription) {
                        if (!typeDescription.isPrimitive()) {
                            return Opcodes.UNINITIALIZED_THIS;
                        }
                        throw new IllegalArgumentException("Cannot assume primitive uninitialized value: " + typeDescription);
                    }
                },
                INITIALIZED {
                    /* access modifiers changed from: protected */
                    public Object toFrame(TypeDescription typeDescription) {
                        if (typeDescription.represents(Boolean.TYPE) || typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Character.TYPE) || typeDescription.represents(Integer.TYPE)) {
                            return Opcodes.INTEGER;
                        }
                        if (typeDescription.represents(Long.TYPE)) {
                            return Opcodes.LONG;
                        }
                        if (typeDescription.represents(Float.TYPE)) {
                            return Opcodes.FLOAT;
                        }
                        if (typeDescription.represents(Double.TYPE)) {
                            return Opcodes.DOUBLE;
                        }
                        return typeDescription.getInternalName();
                    }
                };

                /* access modifiers changed from: protected */
                public abstract Object toFrame(TypeDescription typeDescription);
            }

            protected enum TranslationMode {
                COPY {
                    /* access modifiers changed from: protected */
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int size = methodDescription.getParameters().size() + (methodDescription.isStatic() ^ true ? 1 : 0);
                        System.arraycopy(objArr, 0, objArr2, 0, size);
                        return size;
                    }

                    /* access modifiers changed from: protected */
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return (methodDescription.isConstructor() && Opcodes.UNINITIALIZED_THIS.equals(obj)) || Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                },
                ENTER {
                    /* access modifiers changed from: protected */
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        Object obj;
                        int i10 = 0;
                        if (!methodDescription.isStatic()) {
                            if (methodDescription.isConstructor()) {
                                obj = Opcodes.UNINITIALIZED_THIS;
                            } else {
                                obj = Initialization.INITIALIZED.toFrame(typeDescription);
                            }
                            objArr2[0] = obj;
                            i10 = 1;
                        }
                        for (TypeDescription frame : methodDescription.getParameters().asTypeList().asErasures()) {
                            objArr2[i10] = Initialization.INITIALIZED.toFrame(frame);
                            i10++;
                        }
                        return i10;
                    }

                    /* access modifiers changed from: protected */
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        if (methodDescription.isConstructor()) {
                            return Opcodes.UNINITIALIZED_THIS.equals(obj);
                        }
                        return Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                },
                EXIT {
                    /* access modifiers changed from: protected */
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int i10 = 0;
                        if (!methodDescription.isStatic()) {
                            objArr2[0] = Initialization.INITIALIZED.toFrame(typeDescription);
                            i10 = 1;
                        }
                        for (TypeDescription frame : methodDescription.getParameters().asTypeList().asErasures()) {
                            objArr2[i10] = Initialization.INITIALIZED.toFrame(frame);
                            i10++;
                        }
                        return i10;
                    }

                    /* access modifiers changed from: protected */
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                };

                /* access modifiers changed from: protected */
                public abstract int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2);

                /* access modifiers changed from: protected */
                public abstract boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj);
            }

            protected static class Trivial extends Default {
                protected Trivial(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, boolean z10) {
                    super(typeDescription, methodDescription, Collections.emptyList(), list, Collections.emptyList(), Collections.emptyList(), z10);
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    throw new IllegalStateException("Did not expect exit advice " + inDefinedShape + " for " + this.instrumentedMethod);
                }

                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect completion frame for " + this.instrumentedMethod);
                }

                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect exception frame for " + this.instrumentedMethod);
                }

                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                }

                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect post completion frame for " + this.instrumentedMethod);
                }

                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect return frame for " + this.instrumentedMethod);
                }

                public void injectStartFrame(MethodVisitor methodVisitor) {
                }

                public void translateFrame(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                    methodVisitor.visitFrame(i10, i11, objArr, i12, objArr2);
                }
            }

            protected static abstract class WithPreservedArguments extends Default {
                protected boolean allowCompactCompletionFrame;

                protected static class WithArgumentCopy extends WithPreservedArguments {
                    protected WithArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z10) {
                        super(typeDescription, methodDescription, list, list2, list3, list4, z10, true);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d A[LOOP:0: B:16:0x0077->B:18:0x007d, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc A[LOOP:1: B:33:0x00f6->B:35:0x00fc, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:39:0x011a A[LOOP:2: B:37:0x0114->B:39:0x011a, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:43:0x0138 A[LOOP:3: B:41:0x0132->B:43:0x0138, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x0152  */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x015a  */
                    /* JADX WARNING: Removed duplicated region for block: B:54:0x0187 A[LOOP:4: B:52:0x0181->B:54:0x0187, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:57:0x019d  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void injectStartFrame(net.bytebuddy.jar.asm.MethodVisitor r11) {
                        /*
                            r10 = this;
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isStatic()
                            r1 = 1
                            if (r0 == 0) goto L_0x0015
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r0 = r0.getParameters()
                            boolean r0 = r0.isEmpty()
                            if (r0 != 0) goto L_0x01a6
                        L_0x0015:
                            boolean r0 = r10.expandFrames
                            r2 = 0
                            if (r0 != 0) goto L_0x0099
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isStatic()
                            r0 = r0 ^ r1
                            net.bytebuddy.description.method.MethodDescription r3 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            int r3 = r3.size()
                            int r0 = r0 + r3
                            r3 = 4
                            if (r0 >= r3) goto L_0x0099
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isStatic()
                            r0 = r0 ^ r1
                            net.bytebuddy.description.method.MethodDescription r3 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            int r3 = r3.size()
                            int r6 = r0 + r3
                            java.lang.Object[] r7 = new java.lang.Object[r6]
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isConstructor()
                            if (r0 == 0) goto L_0x0052
                            java.lang.Integer r0 = net.bytebuddy.jar.asm.Opcodes.UNINITIALIZED_THIS
                            r7[r2] = r0
                        L_0x0050:
                            r2 = r1
                            goto L_0x0065
                        L_0x0052:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isStatic()
                            if (r0 != 0) goto L_0x0065
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r0 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            net.bytebuddy.description.type.TypeDescription r3 = r10.instrumentedType
                            java.lang.Object r0 = r0.toFrame(r3)
                            r7[r2] = r0
                            goto L_0x0050
                        L_0x0065:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r0 = r0.getParameters()
                            net.bytebuddy.description.type.TypeList$Generic r0 = r0.asTypeList()
                            net.bytebuddy.description.type.TypeList r0 = r0.asErasures()
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0077:
                            boolean r3 = r0.hasNext()
                            if (r3 == 0) goto L_0x008f
                            java.lang.Object r3 = r0.next()
                            net.bytebuddy.description.type.TypeDescription r3 = (net.bytebuddy.description.type.TypeDescription) r3
                            int r4 = r2 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r5 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r3 = r5.toFrame(r3)
                            r7[r2] = r3
                            r2 = r4
                            goto L_0x0077
                        L_0x008f:
                            r5 = 1
                            java.lang.Object[] r9 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.EMPTY
                            int r8 = r9.length
                            r4 = r11
                            r4.visitFrame(r5, r6, r7, r8, r9)
                            goto L_0x01a6
                        L_0x0099:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isStatic()
                            r3 = 2
                            if (r0 == 0) goto L_0x00a4
                            r0 = r2
                            goto L_0x00a5
                        L_0x00a4:
                            r0 = r3
                        L_0x00a5:
                            net.bytebuddy.description.method.MethodDescription r4 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r4 = r4.getParameters()
                            int r4 = r4.size()
                            int r4 = r4 * r3
                            int r0 = r0 + r4
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.initialTypes
                            int r3 = r3.size()
                            int r0 = r0 + r3
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.preMethodTypes
                            int r3 = r3.size()
                            int r6 = r0 + r3
                            java.lang.Object[] r7 = new java.lang.Object[r6]
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isConstructor()
                            if (r0 == 0) goto L_0x00d0
                            java.lang.Integer r0 = net.bytebuddy.jar.asm.Opcodes.UNINITIALIZED_THIS
                            r7[r2] = r0
                        L_0x00ce:
                            r0 = r1
                            goto L_0x00e4
                        L_0x00d0:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            boolean r0 = r0.isStatic()
                            if (r0 != 0) goto L_0x00e3
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r0 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            net.bytebuddy.description.type.TypeDescription r3 = r10.instrumentedType
                            java.lang.Object r0 = r0.toFrame(r3)
                            r7[r2] = r0
                            goto L_0x00ce
                        L_0x00e3:
                            r0 = r2
                        L_0x00e4:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            net.bytebuddy.description.type.TypeList$Generic r3 = r3.asTypeList()
                            net.bytebuddy.description.type.TypeList r3 = r3.asErasures()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x00f6:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x010e
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.toFrame(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x00f6
                        L_0x010e:
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.initialTypes
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0114:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x012c
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.toFrame(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x0114
                        L_0x012c:
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.preMethodTypes
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0132:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x014a
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.toFrame(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x0132
                        L_0x014a:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.instrumentedMethod
                            boolean r3 = r3.isConstructor()
                            if (r3 == 0) goto L_0x015a
                            int r3 = r0 + 1
                            java.lang.Integer r4 = net.bytebuddy.jar.asm.Opcodes.UNINITIALIZED_THIS
                            r7[r0] = r4
                        L_0x0158:
                            r0 = r3
                            goto L_0x016f
                        L_0x015a:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.instrumentedMethod
                            boolean r3 = r3.isStatic()
                            if (r3 != 0) goto L_0x016f
                            int r3 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r4 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            net.bytebuddy.description.type.TypeDescription r5 = r10.instrumentedType
                            java.lang.Object r4 = r4.toFrame(r5)
                            r7[r0] = r4
                            goto L_0x0158
                        L_0x016f:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            net.bytebuddy.description.type.TypeList$Generic r3 = r3.asTypeList()
                            net.bytebuddy.description.type.TypeList r3 = r3.asErasures()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0181:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x0199
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.toFrame(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x0181
                        L_0x0199:
                            boolean r0 = r10.expandFrames
                            if (r0 == 0) goto L_0x019e
                            r2 = -1
                        L_0x019e:
                            r5 = r2
                            java.lang.Object[] r9 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.EMPTY
                            int r8 = r9.length
                            r4 = r11
                            r4.visitFrame(r5, r6, r7, r8, r9)
                        L_0x01a6:
                            net.bytebuddy.description.method.MethodDescription r11 = r10.instrumentedMethod
                            boolean r11 = r11.isStatic()
                            r11 = r11 ^ r1
                            net.bytebuddy.description.method.MethodDescription r0 = r10.instrumentedMethod
                            net.bytebuddy.description.method.ParameterList r0 = r0.getParameters()
                            int r0 = r0.size()
                            int r11 = r11 + r0
                            r10.currentFrameDivergence = r11
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.WithPreservedArguments.WithArgumentCopy.injectStartFrame(net.bytebuddy.jar.asm.MethodVisitor):void");
                    }

                    @SuppressFBWarnings(justification = "ASM models frames by reference identity.", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
                    public void translateFrame(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                        Object[] objArr3;
                        int i13;
                        int i14 = i10;
                        int i15 = i11;
                        Object[] objArr4 = objArr;
                        int i16 = 1;
                        if (i14 == -1 || i14 == 0) {
                            int size = (this.instrumentedMethod.isStatic() ^ true ? 1 : 0) + i15 + this.instrumentedMethod.getParameters().size() + this.initialTypes.size() + this.preMethodTypes.size();
                            Object[] objArr5 = new Object[size];
                            if (this.instrumentedMethod.isConstructor()) {
                                Initialization initialization = Initialization.INITIALIZED;
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= i15) {
                                        break;
                                    } else if (objArr4[i17] == Opcodes.UNINITIALIZED_THIS) {
                                        initialization = Initialization.UNITIALIZED;
                                        break;
                                    } else {
                                        i17++;
                                    }
                                }
                                objArr5[0] = initialization.toFrame(this.instrumentedType);
                            } else if (!this.instrumentedMethod.isStatic()) {
                                objArr5[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                            } else {
                                i16 = 0;
                            }
                            for (TypeDescription frame : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
                                objArr5[i16] = Initialization.INITIALIZED.toFrame(frame);
                                i16++;
                            }
                            for (TypeDescription frame2 : this.initialTypes) {
                                objArr5[i16] = Initialization.INITIALIZED.toFrame(frame2);
                                i16++;
                            }
                            for (TypeDescription frame3 : this.preMethodTypes) {
                                objArr5[i16] = Initialization.INITIALIZED.toFrame(frame3);
                                i16++;
                            }
                            if (i15 > 0) {
                                System.arraycopy(objArr4, 0, objArr5, i16, i11);
                            }
                            this.currentFrameDivergence = size;
                            i13 = size;
                            objArr3 = objArr5;
                        } else {
                            if (i14 == 1) {
                                this.currentFrameDivergence += i15;
                            } else if (i14 == 2) {
                                this.currentFrameDivergence -= i15;
                            } else if (!(i14 == 3 || i14 == 4)) {
                                throw new IllegalArgumentException("Unexpected frame type: " + i10);
                            }
                            objArr3 = objArr4;
                            i13 = i15;
                        }
                        methodVisitor.visitFrame(i10, i13, objArr3, i12, objArr2);
                    }
                }

                protected static class WithoutArgumentCopy extends WithPreservedArguments {
                    protected WithoutArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z10, boolean z11) {
                        super(typeDescription, methodDescription, list, list2, list3, list4, z10, z11);
                    }

                    public void injectStartFrame(MethodVisitor methodVisitor) {
                    }

                    public void translateFrame(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                        translateFrame(methodVisitor, TranslationMode.COPY, this.instrumentedMethod, CompoundList.of(this.initialTypes, this.preMethodTypes), i10, i11, objArr, i12, objArr2);
                    }
                }

                protected WithPreservedArguments(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z10, boolean z11) {
                    super(typeDescription, methodDescription, list, list2, list3, list4, z10);
                    this.allowCompactCompletionFrame = z11;
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.emptyList(), Collections.emptyList(), TranslationMode.EXIT, Initialization.INITIALIZED);
                }

                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    if (!this.allowCompactCompletionFrame || this.expandFrames || this.currentFrameDivergence != 0 || this.postMethodTypes.size() >= 4) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.emptyList());
                    } else if (this.postMethodTypes.isEmpty()) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        int size = this.postMethodTypes.size();
                        Object[] objArr2 = new Object[size];
                        int i10 = 0;
                        for (TypeDescription frame : this.postMethodTypes) {
                            objArr2[i10] = Initialization.INITIALIZED.toFrame(frame);
                            i10++;
                        }
                        Object[] objArr3 = Default.EMPTY;
                        methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                    }
                }

                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes), Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
                        return;
                    }
                    Object[] objArr = Default.EMPTY;
                    methodVisitor.visitFrame(4, objArr.length, objArr, 1, new Object[]{Type.getInternalName(Throwable.class)});
                }

                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                    if (!this.initialTypes.isEmpty()) {
                        int i10 = 0;
                        if (this.expandFrames || this.initialTypes.size() >= 4) {
                            int i11 = 1;
                            int size = (this.instrumentedMethod.isStatic() ^ true ? 1 : 0) + this.instrumentedMethod.getParameters().size() + this.initialTypes.size();
                            Object[] objArr = new Object[size];
                            if (this.instrumentedMethod.isConstructor()) {
                                objArr[0] = Opcodes.UNINITIALIZED_THIS;
                            } else if (!this.instrumentedMethod.isStatic()) {
                                objArr[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                            } else {
                                i11 = 0;
                            }
                            for (TypeDescription frame : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
                                objArr[i11] = Initialization.INITIALIZED.toFrame(frame);
                                i11++;
                            }
                            for (TypeDescription frame2 : this.initialTypes) {
                                objArr[i11] = Initialization.INITIALIZED.toFrame(frame2);
                                i11++;
                            }
                            if (this.expandFrames) {
                                i10 = -1;
                            }
                            Object[] objArr2 = Default.EMPTY;
                            methodVisitor.visitFrame(i10, size, objArr, objArr2.length, objArr2);
                            return;
                        }
                        int size2 = this.initialTypes.size();
                        Object[] objArr3 = new Object[size2];
                        for (TypeDescription frame3 : this.initialTypes) {
                            objArr3[i10] = Initialization.INITIALIZED.toFrame(frame3);
                            i10++;
                        }
                        Object[] objArr4 = Default.EMPTY;
                        methodVisitor.visitFrame(1, size2, objArr3, objArr4.length, objArr4);
                    }
                }

                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.emptyList());
                        return;
                    }
                    Object[] objArr = Default.EMPTY;
                    methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                }

                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    List list;
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        Initialization initialization = Initialization.INITIALIZED;
                        List<S> of2 = CompoundList.of(this.initialTypes, this.preMethodTypes);
                        if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                            list = Collections.emptyList();
                        } else {
                            list = Collections.singletonList(this.instrumentedMethod.getReturnType().asErasure());
                        }
                        injectFullFrame(methodVisitor, initialization, of2, list);
                    } else if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1, new Object[]{Initialization.INITIALIZED.toFrame(this.instrumentedMethod.getReturnType().asErasure())});
                    }
                }

                /* access modifiers changed from: protected */
                @SuppressFBWarnings(justification = "ASM models frames by reference identity.", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
                public void translateFrame(MethodVisitor methodVisitor, TranslationMode translationMode, MethodDescription methodDescription, List<? extends TypeDescription> list, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                    if (i10 == 0 && i11 > 0 && objArr[0] != Opcodes.UNINITIALIZED_THIS) {
                        this.allowCompactCompletionFrame = true;
                    }
                    super.translateFrame(methodVisitor, translationMode, methodDescription, list, i10, i11, objArr, i12, objArr2);
                }
            }

            protected Default(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z10) {
                this.instrumentedType = typeDescription;
                this.instrumentedMethod = methodDescription;
                this.initialTypes = list;
                this.latentTypes = list2;
                this.preMethodTypes = list3;
                this.postMethodTypes = list4;
                this.expandFrames = z10;
            }

            protected static ForInstrumentedMethod of(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z10, boolean z11, ClassFileVersion classFileVersion, int i10, int i11) {
                boolean z12;
                boolean z13;
                if ((i10 & 2) == 0) {
                    if (!classFileVersion.isLessThan(ClassFileVersion.JAVA_V6)) {
                        boolean z14 = false;
                        if (z10 || !list.isEmpty()) {
                            TypeDescription typeDescription2 = typeDescription;
                            MethodDescription methodDescription2 = methodDescription;
                            List<? extends TypeDescription> list5 = list2;
                            if (z11) {
                                if ((i11 & 8) != 0) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                return new WithPreservedArguments.WithArgumentCopy(typeDescription, methodDescription, list, list2, list3, list4, z13);
                            }
                            if ((i11 & 8) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            return new WithPreservedArguments.WithoutArgumentCopy(typeDescription, methodDescription, list, list2, list3, list4, z12, !methodDescription.isConstructor());
                        }
                        TypeDescription typeDescription3 = typeDescription;
                        MethodDescription methodDescription3 = methodDescription;
                        List<? extends TypeDescription> list6 = list2;
                        if ((i11 & 8) != 0) {
                            z14 = true;
                        }
                        return new Trivial(typeDescription, methodDescription, list2, z14);
                    }
                }
                return NoOp.INSTANCE;
            }

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return new ForAdvice(inDefinedShape, this.initialTypes, this.latentTypes, this.preMethodTypes, TranslationMode.ENTER, this.instrumentedMethod.isConstructor() ? Initialization.UNITIALIZED : Initialization.INITIALIZED);
            }

            public int getReaderHint() {
                return this.expandFrames ? 8 : 0;
            }

            /* access modifiers changed from: protected */
            public void injectFullFrame(MethodVisitor methodVisitor, Initialization initialization, List<? extends TypeDescription> list, List<? extends TypeDescription> list2) {
                int i10;
                int i11 = 1;
                int size = this.instrumentedMethod.getParameters().size() + (this.instrumentedMethod.isStatic() ^ true ? 1 : 0) + list.size();
                Object[] objArr = new Object[size];
                if (!this.instrumentedMethod.isStatic()) {
                    objArr[0] = initialization.toFrame(this.instrumentedType);
                } else {
                    i11 = 0;
                }
                for (TypeDescription frame : this.instrumentedMethod.getParameters().asTypeList().asErasures()) {
                    objArr[i11] = Initialization.INITIALIZED.toFrame(frame);
                    i11++;
                }
                for (TypeDescription frame2 : list) {
                    objArr[i11] = Initialization.INITIALIZED.toFrame(frame2);
                    i11++;
                }
                int size2 = list2.size();
                Object[] objArr2 = new Object[size2];
                int i12 = 0;
                for (TypeDescription frame3 : list2) {
                    objArr2[i12] = Initialization.INITIALIZED.toFrame(frame3);
                    i12++;
                }
                if (this.expandFrames) {
                    i10 = -1;
                } else {
                    i10 = 0;
                }
                methodVisitor.visitFrame(i10, size, objArr, size2, objArr2);
                this.currentFrameDivergence = 0;
            }

            /* access modifiers changed from: protected */
            public void translateFrame(MethodVisitor methodVisitor, TranslationMode translationMode, MethodDescription methodDescription, List<? extends TypeDescription> list, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
                Object[] objArr3;
                int i13;
                int i14;
                MethodDescription methodDescription2 = methodDescription;
                int i15 = i10;
                int i16 = i11;
                Object[] objArr4 = objArr;
                if (i15 != -1 && i15 != 0) {
                    if (i15 == 1) {
                        this.currentFrameDivergence += i16;
                    } else if (i15 == 2) {
                        int i17 = this.currentFrameDivergence - i16;
                        this.currentFrameDivergence = i17;
                        if (i17 < 0) {
                            throw new IllegalStateException(methodDescription2 + " dropped " + Math.abs(this.currentFrameDivergence) + " implicit frames");
                        }
                    } else if (!(i15 == 3 || i15 == 4)) {
                        throw new IllegalArgumentException("Unexpected frame type: " + i15);
                    }
                    i13 = i16;
                    objArr3 = objArr4;
                } else if (methodDescription.getParameters().size() + (methodDescription.isStatic() ^ true ? 1 : 0) <= i16) {
                    int i18 = 0;
                    if (methodDescription.isStatic()) {
                        TranslationMode translationMode2 = translationMode;
                        i14 = 0;
                    } else {
                        if (translationMode.isPossibleThisFrameValue(this.instrumentedType, this.instrumentedMethod, objArr4[0])) {
                            i14 = 1;
                        } else {
                            throw new IllegalStateException(methodDescription2 + " is inconsistent for 'this' reference: " + objArr4[0]);
                        }
                    }
                    while (i18 < methodDescription.getParameters().size()) {
                        int i19 = i18 + i14;
                        if (Initialization.INITIALIZED.toFrame(((ParameterDescription) methodDescription.getParameters().get(i18)).getType().asErasure()).equals(objArr4[i19])) {
                            i18++;
                        } else {
                            throw new IllegalStateException(methodDescription2 + " is inconsistent at " + i18 + ": " + objArr4[i19]);
                        }
                    }
                    int size = ((i16 - (methodDescription.isStatic() ^ true ? 1 : 0)) - methodDescription.getParameters().size()) + (this.instrumentedMethod.isStatic() ^ true ? 1 : 0) + this.instrumentedMethod.getParameters().size() + list.size();
                    Object[] objArr5 = new Object[size];
                    int copy = translationMode.copy(this.instrumentedType, this.instrumentedMethod, methodDescription, objArr, objArr5);
                    for (TypeDescription frame : list) {
                        objArr5[copy] = Initialization.INITIALIZED.toFrame(frame);
                        copy++;
                    }
                    int i20 = size - copy;
                    System.arraycopy(objArr4, methodDescription.getParameters().size() + (methodDescription.isStatic() ^ true ? 1 : 0), objArr5, copy, i20);
                    this.currentFrameDivergence = i20;
                    i13 = size;
                    objArr3 = objArr5;
                } else {
                    throw new IllegalStateException("Inconsistent frame length for " + methodDescription2 + ": " + i16);
                }
                methodVisitor.visitFrame(i10, i13, objArr3, i12, objArr2);
            }
        }

        public interface ForAdvice extends StackMapFrameHandler, ForPostProcessor {
        }

        public interface ForInstrumentedMethod extends StackMapFrameHandler {
            ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape);

            ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape);

            int getReaderHint();

            void injectInitializationFrame(MethodVisitor methodVisitor);

            void injectPostCompletionFrame(MethodVisitor methodVisitor);

            void injectStartFrame(MethodVisitor methodVisitor);
        }

        public interface ForPostProcessor {
            void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list);
        }

        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public int getReaderHint() {
                return 4;
            }

            public void injectCompletionFrame(MethodVisitor methodVisitor) {
            }

            public void injectExceptionFrame(MethodVisitor methodVisitor) {
            }

            public void injectInitializationFrame(MethodVisitor methodVisitor) {
            }

            public void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list) {
            }

            public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
            }

            public void injectReturnFrame(MethodVisitor methodVisitor) {
            }

            public void injectStartFrame(MethodVisitor methodVisitor) {
            }

            public void translateFrame(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
            }
        }

        void injectCompletionFrame(MethodVisitor methodVisitor);

        void injectExceptionFrame(MethodVisitor methodVisitor);

        void injectReturnFrame(MethodVisitor methodVisitor);

        void translateFrame(MethodVisitor methodVisitor, int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StubValue {
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface This {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Thrown {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.DYNAMIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Unused {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class WithCustomMapping {
        private final Delegator.Factory delegatorFactory;
        private final Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> offsetMappings;
        private final PostProcessor.Factory postProcessorFactory;

        protected WithCustomMapping() {
            this(PostProcessor.NoOp.INSTANCE, Collections.emptyMap(), Delegator.ForRegularInvocation.Factory.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, @MaybeNull Object obj) {
            return bind(OffsetMapping.ForStackManipulation.Factory.of(cls, obj));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, Object... objArr) {
            return bindDynamic(cls, method, (List<?>) Arrays.asList(objArr));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bindProperty(Class<T> cls, String str) {
            return bind(OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(cls, str));
        }

        public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> cls, Serializable serializable) {
            return bindSerialized(cls, serializable, serializable.getClass());
        }

        public WithCustomMapping bootstrap(Constructor<?> constructor) {
            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithCustomMapping withCustomMapping = (WithCustomMapping) obj;
            return this.postProcessorFactory.equals(withCustomMapping.postProcessorFactory) && this.delegatorFactory.equals(withCustomMapping.delegatorFactory) && this.offsetMappings.equals(withCustomMapping.offsetMappings);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.postProcessorFactory.hashCode()) * 31) + this.delegatorFactory.hashCode()) * 31) + this.offsetMappings.hashCode();
        }

        public Advice to(Class<?> cls) {
            return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
        }

        public WithCustomMapping with(PostProcessor.Factory factory) {
            return new WithCustomMapping(new PostProcessor.Factory.Compound(this.postProcessorFactory, factory), this.offsetMappings, this.delegatorFactory);
        }

        protected WithCustomMapping(PostProcessor.Factory factory, Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> map, Delegator.Factory factory2) {
            this.postProcessorFactory = factory;
            this.offsetMappings = map;
            this.delegatorFactory = factory2;
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Field field) {
            return bind(cls, (FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, List<?> list) {
            return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
        }

        public <T extends Annotation, S extends Serializable> WithCustomMapping bindSerialized(Class<T> cls, S s10, Class<? super S> cls2) {
            return bind(OffsetMapping.ForSerializedValue.Factory.of(cls, s10, cls2));
        }

        public WithCustomMapping bootstrap(Constructor<?> constructor, BootstrapArgumentResolver.Factory factory) {
            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), factory);
        }

        public Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, FieldDescription fieldDescription) {
            return bind(new OffsetMapping.ForField.Resolved.Factory(cls, fieldDescription));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, Object... objArr) {
            return bindDynamic(cls, constructor, (List<?>) Arrays.asList(objArr));
        }

        public WithCustomMapping bootstrap(Method method) {
            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
        }

        public Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            return Advice.to(typeDescription, this.postProcessorFactory, classFileLocator, new ArrayList(this.offsetMappings.values()), this.delegatorFactory);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Method method, int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("A parameter cannot be negative: " + i10);
            } else if (method.getParameterTypes().length > i10) {
                return bind(cls, (ParameterDescription) new MethodDescription.ForLoadedMethod(method).getParameters().get(i10));
            } else {
                throw new IllegalArgumentException(method + " does not declare a parameter with index " + i10);
            }
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, List<?> list) {
            return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public WithCustomMapping bootstrap(Method method, BootstrapArgumentResolver.Factory factory) {
            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), factory);
        }

        public Advice to(Class<?> cls, Class<?> cls2) {
            ClassFileLocator classFileLocator;
            ClassLoader classLoader = cls.getClassLoader();
            ClassLoader classLoader2 = cls2.getClassLoader();
            if (classLoader == classLoader2) {
                classFileLocator = ClassFileLocator.ForClassLoader.of(classLoader);
            } else {
                classFileLocator = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader), ClassFileLocator.ForClassLoader.of(classLoader2));
            }
            return to(cls, cls2, classFileLocator);
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bindDynamic(cls, inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape) {
            return bootstrap(inDefinedShape, (BootstrapArgumentResolver.Factory) BootstrapArgumentResolver.ForDefaultValues.Factory.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            List<JavaConstant> wrap = JavaConstant.Simple.wrap(list);
            if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of(wrap))) {
                return bind(new OffsetMapping.ForStackManipulation.OfDynamicInvocation(cls, inDefinedShape, wrap));
            }
            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + wrap);
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
            return new WithCustomMapping(this.postProcessorFactory, this.offsetMappings, Delegator.ForDynamicInvocation.of(inDefinedShape, factory));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Constructor<?> constructor, int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("A parameter cannot be negative: " + i10);
            } else if (constructor.getParameterTypes().length > i10) {
                return bind(cls, (ParameterDescription) new MethodDescription.ForLoadedConstructor(constructor).getParameters().get(i10));
            } else {
                throw new IllegalArgumentException(constructor + " does not declare a parameter with index " + i10);
            }
        }

        public Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
            return to(typeDescription, typeDescription2, (ClassFileLocator) ClassFileLocator.NoOp.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
            return Advice.to(typeDescription, typeDescription2, this.postProcessorFactory, classFileLocator, new ArrayList(this.offsetMappings.values()), this.delegatorFactory);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ParameterDescription parameterDescription) {
            return bind(new OffsetMapping.ForArgument.Resolved.Factory(cls, parameterDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Class<?> cls2) {
            return bind(cls, TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            return bindLambda(cls, inDefinedShape, typeDescription, MethodGraph.Compiler.DEFAULT);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, TypeDescription typeDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, typeDescription));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodGraph.Compiler compiler) {
            TypeDescription typeDescription2 = typeDescription;
            if (typeDescription.isInterface()) {
                MethodList methodList = (MethodList) compiler.compile((TypeDefinition) typeDescription2).listNodes().asMethodList().filter(ElementMatchers.isAbstract());
                if (methodList.size() == 1) {
                    TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDescription.Generic[0]);
                    List emptyList = Collections.emptyList();
                    TypeDescription.Generic asGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                    JavaType javaType = JavaType.METHOD_TYPE;
                    return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.Latent(latent, "metafactory", 9, emptyList, asGenericType, Arrays.asList(new ParameterDescription.Token[]{new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType()), new ParameterDescription.Token(TypeDescription.ForLoadedType.of(String.class).asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType())}), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), JavaConstant.MethodType.ofSignature((MethodDescription) methodList.asDefined().getOnly()), JavaConstant.MethodHandle.of(inDefinedShape), JavaConstant.MethodType.ofSignature((MethodDescription) methodList.asDefined().getOnly()));
                }
                throw new IllegalArgumentException(typeDescription2 + " does not define exactly one abstract method: " + methodList);
            }
            throw new IllegalArgumentException(typeDescription2 + " is not an interface type");
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Enum<?> enumR) {
            return bind(cls, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(enumR));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, EnumerationDescription enumerationDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, enumerationDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, JavaConstant javaConstant) {
            return bind(cls, (ConstantValue) javaConstant);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ConstantValue constantValue) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType()));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, java.lang.reflect.Type type) {
            return bind(cls, stackManipulation, TypeDefinition.Sort.describe(type));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, stackManipulation, generic));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, OffsetMapping offsetMapping) {
            return bind(new OffsetMapping.Factory.Simple(cls, offsetMapping));
        }

        public WithCustomMapping bind(OffsetMapping.Factory<?> factory) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.offsetMappings);
            if (!factory.getAnnotationType().isAnnotation()) {
                throw new IllegalArgumentException("Not an annotation type: " + factory.getAnnotationType());
            } else if (linkedHashMap.put(factory.getAnnotationType(), factory) == null) {
                return new WithCustomMapping(this.postProcessorFactory, linkedHashMap, this.delegatorFactory);
            } else {
                throw new IllegalArgumentException("Annotation type already mapped: " + factory.getAnnotationType());
            }
        }
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(OnMethodEnter.class).getDeclaredMethods();
        SKIP_ON = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("skipOn"))).getOnly();
        SKIP_ON_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("skipOnIndex"))).getOnly();
        PREPEND_LINE_NUMBER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("prependLineNumber"))).getOnly();
        INLINE_ENTER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("inline"))).getOnly();
        SUPPRESS_ENTER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("suppress"))).getOnly();
        MethodList<MethodDescription.InDefinedShape> declaredMethods2 = TypeDescription.ForLoadedType.of(OnMethodExit.class).getDeclaredMethods();
        REPEAT_ON = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("repeatOn"))).getOnly();
        REPEAT_ON_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("repeatOnIndex"))).getOnly();
        ON_THROWABLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("onThrowable"))).getOnly();
        BACKUP_ARGUMENTS = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("backupArguments"))).getOnly();
        INLINE_EXIT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("inline"))).getOnly();
        SUPPRESS_EXIT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("suppress"))).getOnly();
    }

    protected Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit) {
        this(forMethodEnter, forMethodExit, Assigner.DEFAULT, ExceptionHandler.Default.SUPPRESSING, SuperMethodCall.INSTANCE);
    }

    private static Dispatcher.Unresolved locate(Class<? extends Annotation> cls, MethodDescription.InDefinedShape inDefinedShape, Dispatcher.Unresolved unresolved, MethodDescription.InDefinedShape inDefinedShape2, Delegator.Factory factory) {
        AnnotationDescription.Loadable<? extends Annotation> ofType = inDefinedShape2.getDeclaredAnnotations().ofType(cls);
        if (ofType == null) {
            return unresolved;
        }
        if (unresolved.isAlive()) {
            throw new IllegalStateException("Duplicate advice for " + unresolved + " and " + inDefinedShape2);
        } else if (!inDefinedShape2.isStatic()) {
            throw new IllegalStateException("Advice for " + inDefinedShape2 + " is not static");
        } else if (((Boolean) ofType.getValue(inDefinedShape).resolve(Boolean.class)).booleanValue()) {
            return new Dispatcher.Inlining(inDefinedShape2);
        } else {
            return new Dispatcher.Delegating(inDefinedShape2, factory);
        }
    }

    public static Advice to(Class<?> cls) {
        return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static WithCustomMapping withCustomMapping() {
        return new WithCustomMapping();
    }

    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(this, target, this.delegate.appender(target));
    }

    /* access modifiers changed from: protected */
    public MethodVisitor doWrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, int i10, int i11) {
        LineNumberPrependingMethodVisitor lineNumberPrependingMethodVisitor;
        TypeDescription typeDescription2 = typeDescription;
        MethodDescription methodDescription2 = methodDescription;
        if (this.methodEnter.isPrependLineNumber()) {
            lineNumberPrependingMethodVisitor = new LineNumberPrependingMethodVisitor(methodVisitor);
        } else {
            lineNumberPrependingMethodVisitor = methodVisitor;
        }
        if (!this.methodExit.isAlive()) {
            return new AdviceVisitor.WithoutExitAdvice(lineNumberPrependingMethodVisitor, context, this.assigner, this.exceptionHandler.resolve(methodDescription2, typeDescription), typeDescription, methodDescription, this.methodEnter, i10, i11);
        } else if (this.methodExit.getThrowable().represents(NoExceptionHandler.class)) {
            return new AdviceVisitor.WithExitAdvice.WithoutExceptionHandling(lineNumberPrependingMethodVisitor, context, this.assigner, this.exceptionHandler.resolve(methodDescription2, typeDescription), typeDescription, methodDescription, this.methodEnter, this.methodExit, i10, i11);
        } else if (!methodDescription.isConstructor()) {
            Assigner assigner2 = this.assigner;
            StackManipulation resolve = this.exceptionHandler.resolve(methodDescription2, typeDescription);
            Dispatcher.Resolved.ForMethodEnter forMethodEnter = this.methodEnter;
            Dispatcher.Resolved.ForMethodExit forMethodExit = this.methodExit;
            return new AdviceVisitor.WithExitAdvice.WithExceptionHandling(lineNumberPrependingMethodVisitor, context, assigner2, resolve, typeDescription, methodDescription, forMethodEnter, forMethodExit, i10, i11, forMethodExit.getThrowable());
        } else {
            throw new IllegalStateException("Cannot catch exception during constructor call for " + methodDescription2);
        }
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Advice advice = (Advice) obj;
        return this.methodEnter.equals(advice.methodEnter) && this.methodExit.equals(advice.methodExit) && this.assigner.equals(advice.assigner) && this.exceptionHandler.equals(advice.exceptionHandler) && this.delegate.equals(advice.delegate);
    }

    public int hashCode() {
        return (((((((((getClass().hashCode() * 31) + this.methodEnter.hashCode()) * 31) + this.methodExit.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.exceptionHandler.hashCode()) * 31) + this.delegate.hashCode();
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.delegate.prepare(instrumentedType);
    }

    public Advice withAssigner(Assigner assigner2) {
        return new Advice(this.methodEnter, this.methodExit, assigner2, this.exceptionHandler, this.delegate);
    }

    public Advice withExceptionHandler(StackManipulation stackManipulation) {
        return withExceptionHandler((ExceptionHandler) new ExceptionHandler.Simple(stackManipulation));
    }

    public Advice withExceptionPrinting() {
        return withExceptionHandler((ExceptionHandler) ExceptionHandler.Default.PRINTING);
    }

    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i10, int i11) {
        return (methodDescription.isAbstract() || methodDescription.isNative()) ? methodVisitor : doWrap(typeDescription, methodDescription, methodVisitor, context, i10, i11);
    }

    private Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, Assigner assigner2, ExceptionHandler exceptionHandler2, Implementation implementation) {
        this.methodEnter = forMethodEnter;
        this.methodExit = forMethodExit;
        this.assigner = assigner2;
        this.exceptionHandler = exceptionHandler2;
        this.delegate = implementation;
    }

    public static Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public Advice withExceptionHandler(ExceptionHandler exceptionHandler2) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, exceptionHandler2, this.delegate);
    }

    public static Advice to(TypeDescription typeDescription) {
        return to(typeDescription, (ClassFileLocator) ClassFileLocator.NoOp.INSTANCE);
    }

    public Implementation wrap(Implementation implementation) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, this.exceptionHandler, implementation);
    }

    public static Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return to(typeDescription, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.emptyList(), Delegator.ForRegularInvocation.Factory.INSTANCE);
    }

    protected static Advice to(TypeDescription typeDescription, PostProcessor.Factory factory, ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list, Delegator.Factory factory2) {
        ClassReader classReader;
        Dispatcher.Unresolved unresolved = Dispatcher.Inactive.INSTANCE;
        Dispatcher.Unresolved unresolved2 = unresolved;
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
            unresolved = locate(OnMethodEnter.class, INLINE_ENTER, unresolved, inDefinedShape, factory2);
            unresolved2 = locate(OnMethodExit.class, INLINE_EXIT, unresolved2, inDefinedShape, factory2);
        }
        if (unresolved.isAlive() || unresolved2.isAlive()) {
            try {
                if (!unresolved.isBinary()) {
                    if (!unresolved2.isBinary()) {
                        classReader = UNDEFINED;
                        return new Advice(unresolved.asMethodEnter(list, classReader, unresolved2, factory), unresolved2.asMethodExit(list, classReader, unresolved, factory));
                    }
                }
                classReader = OpenedClassReader.of(classFileLocator.locate(typeDescription.getName()).resolve());
                return new Advice(unresolved.asMethodEnter(list, classReader, unresolved2, factory), unresolved2.asMethodExit(list, classReader, unresolved, factory));
            } catch (IOException e10) {
                throw new IllegalStateException("Error reading class file of " + typeDescription, e10);
            }
        } else {
            throw new IllegalArgumentException("No advice defined by " + typeDescription);
        }
    }

    public static Advice to(Class<?> cls, Class<?> cls2) {
        ClassFileLocator classFileLocator;
        ClassLoader classLoader = cls.getClassLoader();
        ClassLoader classLoader2 = cls2.getClassLoader();
        if (classLoader == classLoader2) {
            classFileLocator = ClassFileLocator.ForClassLoader.of(classLoader);
        } else {
            classFileLocator = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader), ClassFileLocator.ForClassLoader.of(classLoader2));
        }
        return to(cls, cls2, classFileLocator);
    }

    public static Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
        return to(typeDescription, typeDescription2, (ClassFileLocator) ClassFileLocator.NoOp.INSTANCE);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
        return to(typeDescription, typeDescription2, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.emptyList(), Delegator.ForRegularInvocation.Factory.INSTANCE);
    }

    protected static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, PostProcessor.Factory factory, ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list, Delegator.Factory factory2) {
        Dispatcher.Unresolved unresolved = Dispatcher.Inactive.INSTANCE;
        Dispatcher.Unresolved unresolved2 = unresolved;
        for (MethodDescription.InDefinedShape locate : typeDescription.getDeclaredMethods()) {
            unresolved2 = locate(OnMethodEnter.class, INLINE_ENTER, unresolved2, locate, factory2);
        }
        if (unresolved2.isAlive()) {
            for (MethodDescription.InDefinedShape locate2 : typeDescription2.getDeclaredMethods()) {
                unresolved = locate(OnMethodExit.class, INLINE_EXIT, unresolved, locate2, factory2);
            }
            if (unresolved.isAlive()) {
                try {
                    return new Advice(unresolved2.asMethodEnter(list, unresolved2.isBinary() ? OpenedClassReader.of(classFileLocator.locate(typeDescription.getName()).resolve()) : UNDEFINED, unresolved, factory), unresolved.asMethodExit(list, unresolved.isBinary() ? OpenedClassReader.of(classFileLocator.locate(typeDescription2.getName()).resolve()) : UNDEFINED, unresolved2, factory));
                } catch (IOException e10) {
                    throw new IllegalStateException("Error reading class file of " + typeDescription + " or " + typeDescription2, e10);
                }
            } else {
                throw new IllegalArgumentException("No exit advice defined by " + typeDescription2);
            }
        } else {
            throw new IllegalArgumentException("No enter advice defined by " + typeDescription);
        }
    }
}
