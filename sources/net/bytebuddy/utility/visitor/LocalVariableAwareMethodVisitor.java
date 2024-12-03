package net.bytebuddy.utility.visitor;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.OpenedClassReader;

public class LocalVariableAwareMethodVisitor extends MethodVisitor {
    private int freeOffset;

    public LocalVariableAwareMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        super(OpenedClassReader.ASM_API, methodVisitor);
        this.freeOffset = methodDescription.getStackSize();
    }

    public int getFreeOffset() {
        return this.freeOffset;
    }

    @SuppressFBWarnings(justification = "No action required on default option.", value = {"SF_SWITCH_NO_DEFAULT"})
    public void visitVarInsn(int i10, int i11) {
        switch (i10) {
            case 54:
            case 56:
            case 58:
                this.freeOffset = Math.max(this.freeOffset, i11 + 1);
                break;
            case 55:
            case 57:
                this.freeOffset = Math.max(this.freeOffset, i11 + 2);
                break;
        }
        super.visitVarInsn(i10, i11);
    }
}
