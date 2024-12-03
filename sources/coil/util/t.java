package coil.util;

import android.content.Context;
import coil.disk.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcoil/util/t;", "", "Landroid/content/Context;", "context", "Lcoil/disk/a;", "a", "b", "Lcoil/disk/a;", "instance", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f8450a = new t();

    /* renamed from: b  reason: collision with root package name */
    private static a f8451b;

    private t() {
    }

    public final synchronized a a(Context context) {
        a aVar;
        aVar = f8451b;
        if (aVar == null) {
            aVar = new a.C0101a().b(j.n(j.n(context), "image_cache")).a();
            f8451b = aVar;
        }
        return aVar;
    }
}
