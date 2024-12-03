package b2;

import androidx.annotation.NonNull;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f7738a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile f f7739b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7740c = 20;

    public static class a extends f {

        /* renamed from: d  reason: collision with root package name */
        private final int f7741d;

        public a(int i10) {
            super(i10);
            this.f7741d = i10;
        }

        public void a(@NonNull String str, @NonNull String str2) {
        }

        public void b(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        }

        public void c(@NonNull String str, @NonNull String str2) {
        }

        public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        }

        public void f(@NonNull String str, @NonNull String str2) {
        }

        public void g(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        }

        public void j(@NonNull String str, @NonNull String str2) {
        }

        public void k(@NonNull String str, @NonNull String str2) {
        }

        public void l(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        }
    }

    public f(int i10) {
    }

    @NonNull
    public static f e() {
        f fVar;
        synchronized (f7738a) {
            if (f7739b == null) {
                f7739b = new a(3);
            }
            fVar = f7739b;
        }
        return fVar;
    }

    public static void h(@NonNull f fVar) {
        synchronized (f7738a) {
            f7739b = fVar;
        }
    }

    @NonNull
    public static String i(@NonNull String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        int i10 = f7740c;
        if (length >= i10) {
            sb2.append(str.substring(0, i10));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public abstract void a(@NonNull String str, @NonNull String str2);

    public abstract void b(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);

    public abstract void c(@NonNull String str, @NonNull String str2);

    public abstract void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);

    public abstract void f(@NonNull String str, @NonNull String str2);

    public abstract void g(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);

    public abstract void j(@NonNull String str, @NonNull String str2);

    public abstract void k(@NonNull String str, @NonNull String str2);

    public abstract void l(@NonNull String str, @NonNull String str2, @NonNull Throwable th2);
}
