package net.bytebuddy.utility.visitor;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class StackAwareMethodVisitor extends MethodVisitor {
    private static final boolean ACCESS_CONTROLLER;
    private static final int[] SIZE_CHANGE = new int[202];
    public static final boolean UNADJUSTED;
    public static final String UNADJUSTED_PROPERTY = "net.bytebuddy.unadjusted";
    private List<StackSize> current = new ArrayList();
    private int freeIndex;
    private final Map<Label, List<StackSize>> sizes = new HashMap();

    /* renamed from: net.bytebuddy.utility.visitor.StackAwareMethodVisitor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.bytebuddy.implementation.bytecode.StackSize[] r0 = net.bytebuddy.implementation.bytecode.StackSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize = r0
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.SINGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.visitor.StackAwareMethodVisitor.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        boolean z10;
        int i10 = 0;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = false;
        } catch (SecurityException unused2) {
            ACCESS_CONTROLLER = true;
        }
        try {
            z10 = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(UNADJUSTED_PROPERTY)));
        } catch (Exception unused3) {
            z10 = false;
        }
        UNADJUSTED = z10;
        while (true) {
            int[] iArr = SIZE_CHANGE;
            if (i10 < iArr.length) {
                iArr[i10] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEEEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i10) - 'E';
                i10++;
            } else {
                return;
            }
        }
    }

    protected StackAwareMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        super(OpenedClassReader.ASM_API, methodVisitor);
        this.freeIndex = methodDescription.getStackSize();
    }

    private void adjustStack(int i10) {
        adjustStack(i10, 0);
    }

    private void doDrain(List<StackSize> list) {
        ListIterator<StackSize> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            StackSize previous = listIterator.previous();
            int i10 = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[previous.ordinal()];
            if (i10 == 1) {
                super.visitInsn(87);
            } else if (i10 == 2) {
                super.visitInsn(88);
            } else {
                throw new IllegalStateException("Unexpected stack size: " + previous);
            }
        }
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static MethodVisitor of(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        return UNADJUSTED ? methodVisitor : new StackAwareMethodVisitor(methodVisitor, methodDescription);
    }

    public void drainStack() {
        doDrain(this.current);
    }

    public void register(Label label, List<StackSize> list) {
        this.sizes.put(label, list);
    }

    public void visitFieldInsn(int i10, String str, String str2, String str3) {
        int size = Type.getType(str3).getSize();
        switch (i10) {
            case Opcodes.GETSTATIC:
                adjustStack(size);
                break;
            case Opcodes.PUTSTATIC:
                adjustStack(-size);
                break;
            case Opcodes.GETFIELD:
                adjustStack(-1);
                adjustStack(size);
                break;
            case Opcodes.PUTFIELD:
                adjustStack((-size) - 1);
                break;
            default:
                throw new IllegalStateException("Unexpected opcode: " + i10);
        }
        super.visitFieldInsn(i10, str, str2, str3);
    }

    @SuppressFBWarnings(justification = "ASM models frames by reference identity.", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
    public void visitFrame(int i10, int i11, @MaybeNull Object[] objArr, int i12, @MaybeNull Object[] objArr2) {
        if (i10 == -1 || i10 == 0) {
            this.current.clear();
            for (int i13 = 0; i13 < i12; i13++) {
                Integer num = objArr2[i13];
                if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                    this.current.add(StackSize.DOUBLE);
                } else {
                    this.current.add(StackSize.SINGLE);
                }
            }
        } else if (i10 == 1 || i10 == 2 || i10 == 3) {
            this.current.clear();
        } else if (i10 == 4) {
            this.current.clear();
            Integer num2 = objArr2[0];
            if (num2 == Opcodes.LONG || num2 == Opcodes.DOUBLE) {
                this.current.add(StackSize.DOUBLE);
            } else {
                this.current.add(StackSize.SINGLE);
            }
        } else {
            throw new IllegalStateException("Unknown frame type: " + i10);
        }
        super.visitFrame(i10, i11, objArr, i12, objArr2);
    }

    public void visitInsn(int i10) {
        if (i10 == 47 || i10 == 49) {
            adjustStack(-2);
            adjustStack(2);
        } else {
            if (i10 != 133) {
                if (i10 != 144) {
                    if (i10 != 191) {
                        if (i10 != 90) {
                            if (i10 != 91) {
                                if (i10 != 93) {
                                    if (i10 != 94) {
                                        switch (i10) {
                                            case 135:
                                                break;
                                            case 136:
                                            case Opcodes.L2F:
                                                break;
                                            default:
                                                switch (i10) {
                                                    case Opcodes.F2L:
                                                    case Opcodes.F2D:
                                                        break;
                                                    case Opcodes.D2I:
                                                        break;
                                                    default:
                                                        switch (i10) {
                                                            case Opcodes.IRETURN:
                                                            case Opcodes.LRETURN:
                                                            case Opcodes.FRETURN:
                                                            case Opcodes.DRETURN:
                                                            case Opcodes.ARETURN:
                                                            case Opcodes.RETURN:
                                                                break;
                                                            default:
                                                                adjustStack(SIZE_CHANGE[i10]);
                                                                break;
                                                        }
                                                }
                                        }
                                    }
                                }
                            }
                            int i11 = SIZE_CHANGE[i10];
                            adjustStack(i11, i11 + 2);
                        }
                        int i12 = SIZE_CHANGE[i10];
                        adjustStack(i12, i12 + 1);
                    }
                    this.current.clear();
                }
                adjustStack(-2);
                adjustStack(1);
            }
            adjustStack(-1);
            adjustStack(2);
        }
        super.visitInsn(i10);
    }

    public void visitIntInsn(int i10, int i11) {
        adjustStack(SIZE_CHANGE[i10]);
        super.visitIntInsn(i10, i11);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str2);
        adjustStack((-(argumentsAndReturnSizes >> 2)) + 1);
        adjustStack(argumentsAndReturnSizes & 3);
        super.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    public void visitJumpInsn(int i10, Label label) {
        List<StackSize> list;
        adjustStack(SIZE_CHANGE[i10]);
        Map<Label, List<StackSize>> map = this.sizes;
        if (i10 == 168) {
            list = CompoundList.of(this.current, StackSize.SINGLE);
        } else {
            list = this.current;
        }
        map.put(label, new ArrayList(list));
        if (i10 == 167) {
            this.current.clear();
        }
        super.visitJumpInsn(i10, label);
    }

    public void visitLabel(Label label) {
        List list = this.sizes.get(label);
        if (list != null) {
            this.current = new ArrayList(list);
        }
        super.visitLabel(label);
    }

    public void visitLdcInsn(Object obj) {
        int i10;
        if ((obj instanceof Long) || (obj instanceof Double)) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        adjustStack(i10);
        super.visitLdcInsn(obj);
    }

    public void visitLineNumber(int i10, Label label) {
        super.visitLineNumber(i10, label);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        adjustStack(-1);
        ArrayList arrayList = new ArrayList(this.current);
        this.sizes.put(label, arrayList);
        for (Label put : labelArr) {
            this.sizes.put(put, arrayList);
        }
        super.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
        int i11;
        int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str3);
        int i12 = -(argumentsAndReturnSizes >> 2);
        if (i10 == 184) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        adjustStack(i12 + i11);
        adjustStack(argumentsAndReturnSizes & 3);
        super.visitMethodInsn(i10, str, str2, str3, z10);
    }

    public void visitMultiANewArrayInsn(String str, int i10) {
        adjustStack(1 - i10);
        super.visitMultiANewArrayInsn(str, i10);
    }

    public void visitTableSwitchInsn(int i10, int i11, Label label, Label... labelArr) {
        adjustStack(-1);
        ArrayList arrayList = new ArrayList(this.current);
        this.sizes.put(label, arrayList);
        for (Label put : labelArr) {
            this.sizes.put(put, arrayList);
        }
        super.visitTableSwitchInsn(i10, i11, label, labelArr);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
        this.sizes.put(label3, Collections.singletonList(StackSize.SINGLE));
        super.visitTryCatchBlock(label, label2, label3, str);
    }

    public void visitTypeInsn(int i10, String str) {
        adjustStack(SIZE_CHANGE[i10]);
        super.visitTypeInsn(i10, str);
    }

    @SuppressFBWarnings(justification = "No action required on default option.", value = {"SF_SWITCH_NO_DEFAULT"})
    public void visitVarInsn(int i10, int i11) {
        if (i10 != 169) {
            switch (i10) {
                case 54:
                case 56:
                case 58:
                    this.freeIndex = Math.max(this.freeIndex, i11 + 1);
                    break;
                case 55:
                case 57:
                    this.freeIndex = Math.max(this.freeIndex, i11 + 2);
                    break;
            }
        } else {
            this.current.clear();
        }
        adjustStack(SIZE_CHANGE[i10]);
        super.visitVarInsn(i10, i11);
    }

    private void adjustStack(int i10, int i11) {
        if (i10 > 2) {
            throw new IllegalStateException("Cannot push multiple values onto the operand stack: " + i10);
        } else if (i10 > 0) {
            int size = this.current.size();
            while (i11 > 0 && size > 0) {
                size--;
                i11 -= this.current.get(size).getSize();
            }
            if (i11 >= 0) {
                this.current.add(size, StackSize.of(i10));
                return;
            }
            throw new IllegalStateException("Unexpected offset underflow: " + i11);
        } else if (i11 == 0) {
            while (i10 < 0) {
                if (!this.current.isEmpty()) {
                    List<StackSize> list = this.current;
                    i10 += list.remove(list.size() - 1).getSize();
                } else {
                    return;
                }
            }
            if (i10 == 1) {
                this.current.add(StackSize.SINGLE);
            } else if (i10 != 0) {
                throw new IllegalStateException("Unexpected remainder on the operand stack: " + i10);
            }
        } else {
            throw new IllegalStateException("Cannot specify non-zero offset " + i11 + " for non-incrementing value: " + i10);
        }
    }

    public int drainStack(int i10, int i11, StackSize stackSize) {
        if (this.current.isEmpty()) {
            return 0;
        }
        List<StackSize> list = this.current;
        int size = list.get(list.size() - 1).getSize() - stackSize.getSize();
        if (this.current.size() == 1 && size == 0) {
            return 0;
        }
        super.visitVarInsn(i10, this.freeIndex);
        if (size == 1) {
            super.visitInsn(87);
        } else if (size != 0) {
            throw new IllegalStateException("Unexpected remainder on the operand stack: " + size);
        }
        List<StackSize> list2 = this.current;
        doDrain(list2.subList(0, list2.size() - 1));
        super.visitVarInsn(i11, this.freeIndex);
        return this.freeIndex + stackSize.getSize();
    }
}
