package a0;

import androidx.annotation.NonNull;
import androidx.core.util.a;
import kotlin.jvm.internal.j;

public class l<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private a<T> f64a;

    public void a(@NonNull a<T> aVar) {
        this.f64a = aVar;
    }

    public void accept(@NonNull T t10) {
        j.e(this.f64a, "Listener is not set.");
        this.f64a.accept(t10);
    }
}
