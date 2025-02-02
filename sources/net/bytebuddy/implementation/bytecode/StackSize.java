package net.bytebuddy.implementation.bytecode;

import java.util.Arrays;
import java.util.Collection;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.bytecode.StackManipulation;

public enum StackSize {
    ZERO(0),
    SINGLE(1),
    DOUBLE(2);
    
    private final int size;

    /* renamed from: net.bytebuddy.implementation.bytecode.StackSize$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.bytebuddy.implementation.bytecode.StackSize[] r0 = net.bytebuddy.implementation.bytecode.StackSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize = r0
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.SINGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.ZERO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.bytecode.StackSize.AnonymousClass1.<clinit>():void");
        }
    }

    private StackSize(int i10) {
        this.size = i10;
    }

    public static StackSize of(Class<?> cls) {
        if (cls == Void.TYPE) {
            return ZERO;
        }
        if (cls == Double.TYPE || cls == Long.TYPE) {
            return DOUBLE;
        }
        return SINGLE;
    }

    public int getSize() {
        return this.size;
    }

    public StackSize maximum(StackSize stackSize) {
        int[] iArr = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize;
        int i10 = iArr[ordinal()];
        if (i10 == 1) {
            return this;
        }
        if (i10 == 2) {
            int i11 = iArr[stackSize.ordinal()];
            if (i11 == 1) {
                return stackSize;
            }
            if (i11 == 2 || i11 == 3) {
                return this;
            }
            throw new AssertionError();
        } else if (i10 == 3) {
            return stackSize;
        } else {
            throw new AssertionError();
        }
    }

    public StackManipulation.Size toDecreasingSize() {
        return new StackManipulation.Size(getSize() * -1, 0);
    }

    public StackManipulation.Size toIncreasingSize() {
        return new StackManipulation.Size(getSize(), getSize());
    }

    public static StackSize of(int i10) {
        if (i10 == 0) {
            return ZERO;
        }
        if (i10 == 1) {
            return SINGLE;
        }
        if (i10 == 2) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Unexpected stack size value: " + i10);
    }

    public static int of(TypeDefinition... typeDefinitionArr) {
        return of((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
    }

    public static int of(Collection<? extends TypeDefinition> collection) {
        int i10 = 0;
        for (TypeDefinition stackSize : collection) {
            i10 += stackSize.getStackSize().getSize();
        }
        return i10;
    }
}
