package mk;

import kotlin.random.Random;

public class a extends lk.a {

    /* renamed from: mk.a$a  reason: collision with other inner class name */
    private static final class C0375a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0375a f32800a = new C0375a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f32801b;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
        static {
            /*
                mk.a$a r0 = new mk.a$a
                r0.<init>()
                f32800a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x001f }
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch:{ all -> 0x001f }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x001f }
                boolean r2 = r1 instanceof java.lang.Integer     // Catch:{ all -> 0x001f }
                if (r2 == 0) goto L_0x001f
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001f }
                goto L_0x0020
            L_0x001f:
                r1 = r0
            L_0x0020:
                if (r1 == 0) goto L_0x002e
                int r2 = r1.intValue()
                if (r2 <= 0) goto L_0x002a
                r2 = 1
                goto L_0x002b
            L_0x002a:
                r2 = 0
            L_0x002b:
                if (r2 == 0) goto L_0x002e
                r0 = r1
            L_0x002e:
                f32801b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: mk.a.C0375a.<clinit>():void");
        }

        private C0375a() {
        }
    }

    private final boolean c(int i10) {
        Integer num = C0375a.f32801b;
        return num == null || num.intValue() >= i10;
    }

    public Random b() {
        return c(34) ? new uk.a() : super.b();
    }
}
