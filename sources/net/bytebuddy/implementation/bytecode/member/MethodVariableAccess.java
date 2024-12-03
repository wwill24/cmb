package net.bytebuddy.implementation.bytecode.member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum MethodVariableAccess {
    INTEGER(21, 54, r13),
    LONG(22, 55, r19),
    FLOAT(23, 56, r12),
    DOUBLE(24, 57, r19),
    REFERENCE(25, 58, r12);
    
    /* access modifiers changed from: private */
    public final int loadOpcode;
    /* access modifiers changed from: private */
    public final StackSize size;
    /* access modifiers changed from: private */
    public final int storeOpcode;

    @HashCodeAndEqualsPlugin.Enhance
    public static class MethodLoading extends StackManipulation.AbstractBase {
        private final MethodDescription methodDescription;
        private final TypeCastingHandler typeCastingHandler;

        protected interface TypeCastingHandler {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForBridgeTarget implements TypeCastingHandler {
                private final MethodDescription bridgeTarget;

                public ForBridgeTarget(MethodDescription methodDescription) {
                    this.bridgeTarget = methodDescription;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.bridgeTarget.equals(((ForBridgeTarget) obj).bridgeTarget);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.bridgeTarget.hashCode();
                }

                public StackManipulation ofIndex(TypeDescription typeDescription, int i10) {
                    TypeDescription asErasure = ((ParameterDescription) this.bridgeTarget.getParameters().get(i10)).getType().asErasure();
                    if (typeDescription.equals(asErasure)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    return TypeCasting.to(asErasure);
                }
            }

            public enum NoOp implements TypeCastingHandler {
                INSTANCE;

                public StackManipulation ofIndex(TypeDescription typeDescription, int i10) {
                    return StackManipulation.Trivial.INSTANCE;
                }
            }

            StackManipulation ofIndex(TypeDescription typeDescription, int i10);
        }

        protected MethodLoading(MethodDescription methodDescription2, TypeCastingHandler typeCastingHandler2) {
            this.methodDescription = methodDescription2;
            this.typeCastingHandler = typeCastingHandler2;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            ArrayList arrayList = new ArrayList();
            Iterator<E> it = this.methodDescription.getParameters().iterator();
            while (it.hasNext()) {
                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                TypeDescription asErasure = parameterDescription.getType().asErasure();
                arrayList.add(MethodVariableAccess.of(asErasure).loadFrom(parameterDescription.getOffset()));
                arrayList.add(this.typeCastingHandler.ofIndex(asErasure, parameterDescription.getIndex()));
            }
            return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList).apply(methodVisitor, context);
        }

        public MethodLoading asBridgeOf(MethodDescription methodDescription2) {
            return new MethodLoading(this.methodDescription, new TypeCastingHandler.ForBridgeTarget(methodDescription2));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodLoading methodLoading = (MethodLoading) obj;
            return this.methodDescription.equals(methodLoading.methodDescription) && this.typeCastingHandler.equals(methodLoading.typeCastingHandler);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.typeCastingHandler.hashCode();
        }

        public StackManipulation prependThisReference() {
            if (this.methodDescription.isStatic()) {
                return this;
            }
            return new StackManipulation.Compound(MethodVariableAccess.loadThis(), this);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class OffsetIncrementing extends StackManipulation.AbstractBase {
        private final int offset;
        private final int value;

        protected OffsetIncrementing(int i10, int i11) {
            this.offset = i10;
            this.value = i11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIincInsn(this.offset, this.value);
            return StackManipulation.Size.ZERO;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OffsetIncrementing offsetIncrementing = (OffsetIncrementing) obj;
            return this.offset == offsetIncrementing.offset && this.value == offsetIncrementing.value;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.offset) * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class OffsetLoading extends StackManipulation.AbstractBase {
        private final int offset;

        protected OffsetLoading(int i10) {
            this.offset = i10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitVarInsn(MethodVariableAccess.this.loadOpcode, this.offset);
            return MethodVariableAccess.this.size.toIncreasingSize();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OffsetLoading offsetLoading = (OffsetLoading) obj;
            return this.offset == offsetLoading.offset && MethodVariableAccess.this.equals(MethodVariableAccess.this);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.offset) * 31) + MethodVariableAccess.this.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    protected class OffsetWriting extends StackManipulation.AbstractBase {
        private final int offset;

        protected OffsetWriting(int i10) {
            this.offset = i10;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitVarInsn(MethodVariableAccess.this.storeOpcode, this.offset);
            return MethodVariableAccess.this.size.toDecreasingSize();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OffsetWriting offsetWriting = (OffsetWriting) obj;
            return this.offset == offsetWriting.offset && MethodVariableAccess.this.equals(MethodVariableAccess.this);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.offset) * 31) + MethodVariableAccess.this.hashCode();
        }
    }

    private MethodVariableAccess(int i10, int i11, StackSize stackSize) {
        this.loadOpcode = i10;
        this.size = stackSize;
        this.storeOpcode = i11;
    }

    public static MethodLoading allArgumentsOf(MethodDescription methodDescription) {
        return new MethodLoading(methodDescription, MethodLoading.TypeCastingHandler.NoOp.INSTANCE);
    }

    public static StackManipulation load(ParameterDescription parameterDescription) {
        return of(parameterDescription.getType()).loadFrom(parameterDescription.getOffset());
    }

    @CachedReturnPlugin.Enhance("loadThis")
    public static StackManipulation loadThis() {
        StackManipulation loadFrom = loadThis != null ? null : REFERENCE.loadFrom(0);
        if (loadFrom == null) {
            return loadThis;
        }
        loadThis = loadFrom;
        return loadFrom;
    }

    public static MethodVariableAccess of(TypeDefinition typeDefinition) {
        if (!typeDefinition.isPrimitive()) {
            return REFERENCE;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (!typeDefinition.represents(Void.TYPE)) {
            return INTEGER;
        }
        throw new IllegalArgumentException("Variable type cannot be void");
    }

    public static StackManipulation store(ParameterDescription parameterDescription) {
        return of(parameterDescription.getType()).storeAt(parameterDescription.getOffset());
    }

    public StackManipulation increment(int i10, int i11) {
        if (this == INTEGER) {
            return new OffsetIncrementing(i10, i11);
        }
        throw new IllegalStateException("Cannot increment type: " + this);
    }

    public StackManipulation loadFrom(int i10) {
        return new OffsetLoading(i10);
    }

    public StackManipulation storeAt(int i10) {
        return new OffsetWriting(i10);
    }

    public static StackManipulation increment(ParameterDescription parameterDescription, int i10) {
        return of(parameterDescription.getType()).increment(parameterDescription.getOffset(), i10);
    }
}
