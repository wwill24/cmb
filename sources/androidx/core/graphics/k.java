package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import com.google.android.gms.common.api.a;
import com.google.firebase.perf.util.Constants;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

class k {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, e.c> f4627a = new ConcurrentHashMap<>();

    class a implements b<g.b> {
        a() {
        }

        /* renamed from: c */
        public int b(g.b bVar) {
            return bVar.e();
        }

        /* renamed from: d */
        public boolean a(g.b bVar) {
            return bVar.f();
        }
    }

    private interface b<T> {
        boolean a(T t10);

        int b(T t10);
    }

    k() {
    }

    private static <T> T e(T[] tArr, int i10, b<T> bVar) {
        return f(tArr, (i10 & 1) == 0 ? 400 : Constants.FROZEN_FRAME_TIME, (i10 & 2) != 0, bVar);
    }

    private static <T> T f(T[] tArr, int i10, boolean z10, b<T> bVar) {
        int i11;
        T t10 = null;
        int i12 = a.e.API_PRIORITY_OTHER;
        for (T t11 : tArr) {
            int abs = Math.abs(bVar.b(t11) - i10) * 2;
            if (bVar.a(t11) == z10) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            int i13 = abs + i11;
            if (t10 == null || i12 > i13) {
                t10 = t11;
                i12 = i13;
            }
        }
        return t10;
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, @NonNull g.b[] bVarArr, int i10) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public Typeface c(Context context, InputStream inputStream) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!l.d(e10, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e10.getPath());
            e10.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!l.c(e10, resources, i10)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e10.getPath());
            e10.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    /* access modifiers changed from: protected */
    public g.b g(g.b[] bVarArr, int i10) {
        return (g.b) e(bVarArr, i10, new a());
    }
}
