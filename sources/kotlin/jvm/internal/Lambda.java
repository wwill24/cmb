package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class Lambda<R> implements g<R>, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String j10 = l.j(this);
        j.f(j10, "renderLambdaToString(this)");
        return j10;
    }
}
