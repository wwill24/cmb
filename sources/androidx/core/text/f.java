package androidx.core.text;

import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final e f4722a = new e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final e f4723b = new e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final e f4724c;

    /* renamed from: d  reason: collision with root package name */
    public static final e f4725d;

    /* renamed from: e  reason: collision with root package name */
    public static final e f4726e = new e(a.f4728b, false);

    /* renamed from: f  reason: collision with root package name */
    public static final e f4727f = C0043f.f4733b;

    private static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        static final a f4728b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f4729a;

        private a(boolean z10) {
            this.f4729a = z10;
        }

        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = f.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 != 1) {
                        continue;
                        i10++;
                    } else if (!this.f4729a) {
                        return 1;
                    }
                } else if (this.f4729a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f4729a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f4730a = new b();

        private b() {
        }

        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = f.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    private static abstract class d implements e {

        /* renamed from: a  reason: collision with root package name */
        private final c f4731a;

        d(c cVar) {
            this.f4731a = cVar;
        }

        private boolean b(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f4731a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean isRtl(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            } else if (this.f4731a == null) {
                return a();
            } else {
                return b(charSequence, i10, i11);
            }
        }
    }

    private static class e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4732b;

        e(c cVar, boolean z10) {
            super(cVar);
            this.f4732b = z10;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f4732b;
        }
    }

    /* renamed from: androidx.core.text.f$f  reason: collision with other inner class name */
    private static class C0043f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final C0043f f4733b = new C0043f();

        C0043f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return g.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f4730a;
        f4724c = new e(bVar, false);
        f4725d = new e(bVar, true);
    }

    static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
