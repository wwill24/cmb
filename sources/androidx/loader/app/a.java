package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.l;
import androidx.lifecycle.l0;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {

    /* renamed from: androidx.loader.app.a$a  reason: collision with other inner class name */
    public interface C0065a<D> {
        void K(@NonNull b<D> bVar, D d10);

        @NonNull
        b<D> L(int i10, Bundle bundle);

        void b0(@NonNull b<D> bVar);
    }

    @NonNull
    public static <T extends l & l0> a c(@NonNull T t10) {
        return new b(t10, ((l0) t10).getViewModelStore());
    }

    public abstract void a(int i10);

    @Deprecated
    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract <D> b<D> d(int i10, Bundle bundle, @NonNull C0065a<D> aVar);

    public abstract void e();
}
