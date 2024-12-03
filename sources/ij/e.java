package ij;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;

public abstract class e {

    public interface a {
        @NonNull
        a a(@NonNull i iVar);

        @NonNull
        e build();
    }

    public interface b {
        void a(@NonNull TextView textView, @NonNull Spanned spanned, @NonNull TextView.BufferType bufferType, @NonNull Runnable runnable);
    }

    @NonNull
    public static a a(@NonNull Context context) {
        return new f(context).a(io.noties.markwon.core.a.r());
    }

    @NonNull
    public static e b(@NonNull Context context) {
        return a(context).a(io.noties.markwon.core.a.r()).build();
    }

    public abstract void c(@NonNull TextView textView, @NonNull String str);

    public abstract void d(@NonNull TextView textView, @NonNull Spanned spanned);

    @NonNull
    public abstract Spanned e(@NonNull String str);
}
