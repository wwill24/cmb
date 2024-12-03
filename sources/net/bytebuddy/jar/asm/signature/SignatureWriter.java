package net.bytebuddy.jar.asm.signature;

import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class SignatureWriter extends SignatureVisitor {
    private int argumentStack;
    private boolean hasFormals;
    private boolean hasParameters;
    private final StringBuilder stringBuilder;

    public SignatureWriter() {
        this(new StringBuilder());
    }

    private void endArguments() {
        if ((this.argumentStack & 1) == 1) {
            this.stringBuilder.append('>');
        }
        this.argumentStack >>>= 1;
    }

    private void endFormals() {
        if (this.hasFormals) {
            this.hasFormals = false;
            this.stringBuilder.append('>');
        }
    }

    public String toString() {
        return this.stringBuilder.toString();
    }

    public SignatureVisitor visitArrayType() {
        this.stringBuilder.append('[');
        return this;
    }

    public void visitBaseType(char c10) {
        this.stringBuilder.append(c10);
    }

    public SignatureVisitor visitClassBound() {
        return this;
    }

    public void visitClassType(String str) {
        this.stringBuilder.append(Matrix.MATRIX_TYPE_RANDOM_LT);
        this.stringBuilder.append(str);
        this.argumentStack <<= 1;
    }

    public void visitEnd() {
        endArguments();
        this.stringBuilder.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public SignatureVisitor visitExceptionType() {
        this.stringBuilder.append('^');
        return this;
    }

    public void visitFormalTypeParameter(String str) {
        if (!this.hasFormals) {
            this.hasFormals = true;
            this.stringBuilder.append('<');
        }
        this.stringBuilder.append(str);
        this.stringBuilder.append(':');
    }

    public void visitInnerClassType(String str) {
        endArguments();
        this.stringBuilder.append('.');
        this.stringBuilder.append(str);
        this.argumentStack <<= 1;
    }

    public SignatureVisitor visitInterface() {
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        this.stringBuilder.append(':');
        return this;
    }

    public SignatureVisitor visitParameterType() {
        endFormals();
        if (!this.hasParameters) {
            this.hasParameters = true;
            this.stringBuilder.append(PropertyUtils.MAPPED_DELIM);
        }
        return this;
    }

    public SignatureVisitor visitReturnType() {
        endFormals();
        if (!this.hasParameters) {
            this.stringBuilder.append(PropertyUtils.MAPPED_DELIM);
        }
        this.stringBuilder.append(PropertyUtils.MAPPED_DELIM2);
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        endFormals();
        return this;
    }

    public void visitTypeArgument() {
        int i10 = this.argumentStack;
        if ((i10 & 1) == 0) {
            this.argumentStack = i10 | 1;
            this.stringBuilder.append('<');
        }
        this.stringBuilder.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
    }

    public void visitTypeVariable(String str) {
        this.stringBuilder.append('T');
        this.stringBuilder.append(str);
        this.stringBuilder.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    private SignatureWriter(StringBuilder sb2) {
        super(Opcodes.ASM9);
        this.argumentStack = 1;
        this.stringBuilder = sb2;
    }

    public SignatureVisitor visitTypeArgument(char c10) {
        int i10 = this.argumentStack;
        if ((i10 & 1) == 0) {
            this.argumentStack = i10 | 1;
            this.stringBuilder.append('<');
        }
        if (c10 != '=') {
            this.stringBuilder.append(c10);
        }
        return (this.argumentStack & Integer.MIN_VALUE) == 0 ? this : new SignatureWriter(this.stringBuilder);
    }
}
