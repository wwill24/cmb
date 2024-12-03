package androidx.work.impl;

import android.content.Context;
import b2.f;
import com.mparticle.identity.IdentityHttpResponse;
import gk.h;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Landroidx/work/impl/a0;", "", "Landroid/content/Context;", "context", "", "d", "Ljava/io/File;", "c", "", "e", "b", "a", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f7417a = new a0();

    private a0() {
    }

    private final File c(Context context) {
        return new File(a.f7416a.a(context), "androidx.work.workdb");
    }

    public static final void d(Context context) {
        String str;
        j.g(context, IdentityHttpResponse.CONTEXT);
        a0 a0Var = f7417a;
        if (a0Var.b(context).exists()) {
            f.e().a(b0.f7418a, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry next : a0Var.e(context).entrySet()) {
                File file = (File) next.getKey();
                File file2 = (File) next.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        f.e().k(b0.f7418a, "Over-writing contents of " + file2);
                    }
                    if (file.renameTo(file2)) {
                        str = "Migrated " + file + "to " + file2;
                    } else {
                        str = "Renaming " + file + " to " + file2 + " failed";
                    }
                    f.e().a(b0.f7418a, str);
                }
            }
        }
    }

    public final File a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return c(context);
    }

    public final File b(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        j.f(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    public final Map<File, File> e(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        File b10 = b(context);
        File a10 = a(context);
        String[] a11 = b0.f7419b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(a11.length), 16));
        for (String str : a11) {
            Pair a12 = h.a(new File(b10.getPath() + str), new File(a10.getPath() + str));
            linkedHashMap.put(a12.c(), a12.d());
        }
        return h0.p(linkedHashMap, h.a(b10, a10));
    }
}
