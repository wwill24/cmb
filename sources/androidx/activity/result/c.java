package androidx.activity.result;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import c.a;

public abstract class c<I> {
    @NonNull
    public abstract a<I, ?> a();

    public void b(@SuppressLint({"UnknownNullness"}) I i10) {
        c(i10, (androidx.core.app.c) null);
    }

    public abstract void c(@SuppressLint({"UnknownNullness"}) I i10, androidx.core.app.c cVar);

    public abstract void d();
}
