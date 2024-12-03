package r3;

import androidx.annotation.NonNull;
import f4.j;
import l3.c;

public class b<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f17270a;

    public b(@NonNull T t10) {
        this.f17270a = j.d(t10);
    }

    public void a() {
    }

    @NonNull
    public Class<T> b() {
        return this.f17270a.getClass();
    }

    @NonNull
    public final T get() {
        return this.f17270a;
    }

    public final int getSize() {
        return 1;
    }
}
