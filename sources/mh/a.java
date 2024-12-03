package mh;

import net.bytebuddy.jar.asm.Opcodes;

final class a extends d {
    a() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    public int b(int i10) {
        return i10 <= 8 ? Opcodes.IFGE : Opcodes.IFLT;
    }

    public int f() {
        return 10;
    }
}
