package kotlin.random;

import java.util.Random;

public abstract class a extends Random {
    public int b(int i10) {
        return c.e(f().nextInt(), i10);
    }

    public int c() {
        return f().nextInt();
    }

    public int d(int i10) {
        return f().nextInt(i10);
    }

    public abstract Random f();
}
