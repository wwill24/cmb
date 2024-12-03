package j$.time.format;

import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.jar.asm.Opcodes;

public final class D {

    /* renamed from: a  reason: collision with root package name */
    public static final D f42599a = new D();

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private D() {
    }

    /* access modifiers changed from: package-private */
    public final int a(char c10) {
        int i10 = c10 - '0';
        if (i10 < 0 || i10 > 9) {
            return -1;
        }
        return i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        ((D) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Opcodes.INVOKEVIRTUAL;
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
