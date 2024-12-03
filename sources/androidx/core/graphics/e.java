package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.collection.f;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import androidx.core.provider.g;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final k f4608a;

    /* renamed from: b  reason: collision with root package name */
    private static final f<String, Typeface> f4609b = new f<>(16);

    public static class a extends g.c {

        /* renamed from: a  reason: collision with root package name */
        private h.f f4610a;

        public a(h.f fVar) {
            this.f4610a = fVar;
        }

        public void a(int i10) {
            h.f fVar = this.f4610a;
            if (fVar != null) {
                fVar.f(i10);
            }
        }

        public void b(@NonNull Typeface typeface) {
            h.f fVar = this.f4610a;
            if (fVar != null) {
                fVar.g(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f4608a = new j();
        } else if (i10 >= 28) {
            f4608a = new i();
        } else if (i10 >= 26) {
            f4608a = new h();
        } else if (g.j()) {
            f4608a = new g();
        } else {
            f4608a = new f();
        }
    }

    @NonNull
    public static Typeface a(@NonNull Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull g.b[] bVarArr, int i10) {
        return f4608a.b(context, cancellationSignal, bVarArr, i10);
    }

    public static Typeface c(@NonNull Context context, @NonNull e.b bVar, @NonNull Resources resources, int i10, String str, int i11, int i12, h.f fVar, Handler handler, boolean z10) {
        Typeface typeface;
        boolean z11;
        int i13;
        e.b bVar2 = bVar;
        h.f fVar2 = fVar;
        Handler handler2 = handler;
        if (bVar2 instanceof e.C0036e) {
            e.C0036e eVar = (e.C0036e) bVar2;
            Typeface g10 = g(eVar.c());
            if (g10 != null) {
                if (fVar2 != null) {
                    fVar2.d(g10, handler2);
                }
                return g10;
            }
            if (!z10 ? fVar2 != null : eVar.a() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z10) {
                i13 = eVar.d();
            } else {
                i13 = -1;
            }
            Context context2 = context;
            typeface = g.c(context2, eVar.b(), i12, z11, i13, h.f.e(handler), new a(fVar2));
            Resources resources2 = resources;
            int i14 = i12;
        } else {
            Context context3 = context;
            Resources resources3 = resources;
            typeface = f4608a.a(context, (e.c) bVar2, resources, i12);
            if (fVar2 != null) {
                if (typeface != null) {
                    fVar2.d(typeface, handler2);
                } else {
                    fVar2.c(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f4609b.put(e(resources, i10, str, i11, i12), typeface);
        }
        return typeface;
    }

    public static Typeface d(@NonNull Context context, @NonNull Resources resources, int i10, String str, int i11, int i12) {
        Typeface d10 = f4608a.d(context, resources, i10, str, i12);
        if (d10 != null) {
            f4609b.put(e(resources, i10, str, i11, i12), d10);
        }
        return d10;
    }

    private static String e(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + SignatureVisitor.SUPER + str + SignatureVisitor.SUPER + i11 + SignatureVisitor.SUPER + i10 + SignatureVisitor.SUPER + i12;
    }

    public static Typeface f(@NonNull Resources resources, int i10, String str, int i11, int i12) {
        return f4609b.get(e(resources, i10, str, i11, i12));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
