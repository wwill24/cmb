package pg;

import com.google.gson.r;
import java.sql.Timestamp;
import java.util.Date;
import mg.d;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f24377a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.b<? extends Date> f24378b;

    /* renamed from: c  reason: collision with root package name */
    public static final d.b<? extends Date> f24379c;

    /* renamed from: d  reason: collision with root package name */
    public static final r f24380d;

    /* renamed from: e  reason: collision with root package name */
    public static final r f24381e;

    /* renamed from: f  reason: collision with root package name */
    public static final r f24382f;

    class a extends d.b<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public java.sql.Date d(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    class b extends d.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public Timestamp d(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f24377a = z10;
        if (z10) {
            f24378b = new a(java.sql.Date.class);
            f24379c = new b(Timestamp.class);
            f24380d = a.f24371b;
            f24381e = b.f24373b;
            f24382f = c.f24375b;
            return;
        }
        f24378b = null;
        f24379c = null;
        f24380d = null;
        f24381e = null;
        f24382f = null;
    }
}
