package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.collection.g;
import androidx.core.provider.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.apache.commons.cli.HelpFormatter;

class f {

    /* renamed from: a  reason: collision with root package name */
    static final androidx.collection.f<String, Typeface> f4660a = new androidx.collection.f<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f4661b = h.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f4662c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final g<String, ArrayList<androidx.core.util.a<e>>> f4663d = new g<>();

    class a implements Callable<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f4665b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f4666c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f4667d;

        a(String str, Context context, e eVar, int i10) {
            this.f4664a = str;
            this.f4665b = context;
            this.f4666c = eVar;
            this.f4667d = i10;
        }

        /* renamed from: a */
        public e call() {
            return f.c(this.f4664a, this.f4665b, this.f4666c, this.f4667d);
        }
    }

    class b implements androidx.core.util.a<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f4668a;

        b(a aVar) {
            this.f4668a = aVar;
        }

        /* renamed from: a */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f4668a.b(eVar);
        }
    }

    class c implements Callable<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4669a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f4670b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f4671c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f4672d;

        c(String str, Context context, e eVar, int i10) {
            this.f4669a = str;
            this.f4670b = context;
            this.f4671c = eVar;
            this.f4672d = i10;
        }

        /* renamed from: a */
        public e call() {
            try {
                return f.c(this.f4669a, this.f4670b, this.f4671c, this.f4672d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements androidx.core.util.a<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4673a;

        d(String str) {
            this.f4673a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            ((androidx.core.util.a) r2.get(r0)).accept(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(androidx.core.provider.f.e r5) {
            /*
                r4 = this;
                java.lang.Object r0 = androidx.core.provider.f.f4662c
                monitor-enter(r0)
                androidx.collection.g<java.lang.String, java.util.ArrayList<androidx.core.util.a<androidx.core.provider.f$e>>> r1 = androidx.core.provider.f.f4663d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.f4673a     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.f4673a     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                androidx.core.util.a r1 = (androidx.core.util.a) r1
                r1.accept(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.f.d.accept(androidx.core.provider.f$e):void");
        }
    }

    private static String a(@NonNull e eVar, int i10) {
        return eVar.d() + HelpFormatter.DEFAULT_OPT_PREFIX + i10;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(@NonNull g.a aVar) {
        int i10 = 1;
        if (aVar.c() == 0) {
            g.b[] b10 = aVar.b();
            if (!(b10 == null || b10.length == 0)) {
                int length = b10.length;
                i10 = 0;
                int i11 = 0;
                while (i11 < length) {
                    int b11 = b10[i11].b();
                    if (b11 == 0) {
                        i11++;
                    } else if (b11 < 0) {
                        return -3;
                    } else {
                        return b11;
                    }
                }
            }
            return i10;
        } else if (aVar.c() != 1) {
            return -3;
        } else {
            return -2;
        }
    }

    @NonNull
    static e c(@NonNull String str, @NonNull Context context, @NonNull e eVar, int i10) {
        androidx.collection.f<String, Typeface> fVar = f4660a;
        Typeface typeface = fVar.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a e10 = d.e(context, eVar, (CancellationSignal) null);
            int b10 = b(e10);
            if (b10 != 0) {
                return new e(b10);
            }
            Typeface b11 = androidx.core.graphics.e.b(context, (CancellationSignal) null, e10.b(), i10);
            if (b11 == null) {
                return new e(-3);
            }
            fVar.put(str, b11);
            return new e(b11);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r9 = new androidx.core.provider.f.c(r0, r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r8 = f4661b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        androidx.core.provider.h.b(r8, r9, new androidx.core.provider.f.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Typeface d(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull androidx.core.provider.e r6, int r7, java.util.concurrent.Executor r8, @androidx.annotation.NonNull androidx.core.provider.a r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            androidx.collection.f<java.lang.String, android.graphics.Typeface> r1 = f4660a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.f$e r5 = new androidx.core.provider.f$e
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            androidx.core.provider.f$b r1 = new androidx.core.provider.f$b
            r1.<init>(r9)
            java.lang.Object r9 = f4662c
            monitor-enter(r9)
            androidx.collection.g<java.lang.String, java.util.ArrayList<androidx.core.util.a<androidx.core.provider.f$e>>> r2 = f4663d     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004d }
            r4 = 0
            if (r3 == 0) goto L_0x002f
            r3.add(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            return r4
        L_0x002f:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            r3.add(r1)     // Catch:{ all -> 0x004d }
            r2.put(r0, r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            androidx.core.provider.f$c r9 = new androidx.core.provider.f$c
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r8 = f4661b
        L_0x0044:
            androidx.core.provider.f$d r5 = new androidx.core.provider.f$d
            r5.<init>(r0)
            androidx.core.provider.h.b(r8, r9, r5)
            return r4
        L_0x004d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.f.d(android.content.Context, androidx.core.provider.e, int, java.util.concurrent.Executor, androidx.core.provider.a):android.graphics.Typeface");
    }

    static Typeface e(@NonNull Context context, @NonNull e eVar, @NonNull a aVar, int i10, int i11) {
        String a10 = a(eVar, i10);
        Typeface typeface = f4660a.get(a10);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        } else if (i11 == -1) {
            e c10 = c(a10, context, eVar, i10);
            aVar.b(c10);
            return c10.f4674a;
        } else {
            try {
                e eVar2 = (e) h.c(f4661b, new a(a10, context, eVar, i10), i11);
                aVar.b(eVar2);
                return eVar2.f4674a;
            } catch (InterruptedException unused) {
                aVar.b(new e(-3));
                return null;
            }
        }
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f4674a;

        /* renamed from: b  reason: collision with root package name */
        final int f4675b;

        e(int i10) {
            this.f4674a = null;
            this.f4675b = i10;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f4675b == 0;
        }

        @SuppressLint({"WrongConstant"})
        e(@NonNull Typeface typeface) {
            this.f4674a = typeface;
            this.f4675b = 0;
        }
    }
}
