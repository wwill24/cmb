package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.g;
import androidx.core.util.h;
import androidx.emoji2.text.e;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class j extends e.c {

    /* renamed from: j  reason: collision with root package name */
    private static final a f5474j = new a();

    public static class a {
        public Typeface a(@NonNull Context context, @NonNull g.b bVar) throws PackageManager.NameNotFoundException {
            return g.a(context, (CancellationSignal) null, new g.b[]{bVar});
        }

        @NonNull
        public g.a b(@NonNull Context context, @NonNull androidx.core.provider.e eVar) throws PackageManager.NameNotFoundException {
            return g.b(context, (CancellationSignal) null, eVar);
        }

        public void c(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    private static class b implements e.g {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Context f5475a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.provider.e f5476b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final a f5477c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final Object f5478d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Handler f5479e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f5480f;

        /* renamed from: g  reason: collision with root package name */
        private ThreadPoolExecutor f5481g;

        /* renamed from: h  reason: collision with root package name */
        e.h f5482h;

        /* renamed from: i  reason: collision with root package name */
        private ContentObserver f5483i;

        /* renamed from: j  reason: collision with root package name */
        private Runnable f5484j;

        b(@NonNull Context context, @NonNull androidx.core.provider.e eVar, @NonNull a aVar) {
            h.h(context, "Context cannot be null");
            h.h(eVar, "FontRequest cannot be null");
            this.f5475a = context.getApplicationContext();
            this.f5476b = eVar;
            this.f5477c = aVar;
        }

        private void b() {
            synchronized (this.f5478d) {
                this.f5482h = null;
                ContentObserver contentObserver = this.f5483i;
                if (contentObserver != null) {
                    this.f5477c.c(this.f5475a, contentObserver);
                    this.f5483i = null;
                }
                Handler handler = this.f5479e;
                if (handler != null) {
                    handler.removeCallbacks(this.f5484j);
                }
                this.f5479e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f5481g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f5480f = null;
                this.f5481g = null;
            }
        }

        private g.b e() {
            try {
                g.a b10 = this.f5477c.b(this.f5475a, this.f5476b);
                if (b10.c() == 0) {
                    g.b[] b11 = b10.b();
                    if (b11 != null && b11.length != 0) {
                        return b11[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b10.c() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        public void a(@NonNull e.h hVar) {
            h.h(hVar, "LoaderCallback cannot be null");
            synchronized (this.f5478d) {
                this.f5482h = hVar;
            }
            d();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            if (r1 != 2) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            r2 = r4.f5478d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x001e, code lost:
            if (r1 != 0) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            androidx.core.os.m.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
            r1 = r4.f5477c.a(r4.f5475a, r0);
            r0 = androidx.core.graphics.l.f(r4.f5475a, (android.os.CancellationSignal) null, r0.d());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
            if (r0 == null) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
            if (r1 == null) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
            r0 = androidx.emoji2.text.m.b(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            androidx.core.os.m.b();
            r1 = r4.f5478d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0045, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r2 = r4.f5482h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
            if (r2 == null) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
            r2.b(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x004d, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x005c, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            androidx.core.os.m.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0061, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x007d, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x007e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0081, code lost:
            monitor-enter(r4.f5478d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r2 = r4.f5482h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0084, code lost:
            if (r2 != null) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0086, code lost:
            r2.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x008a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r0 = e();
            r1 = r0.b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.f5478d
                monitor-enter(r0)
                androidx.emoji2.text.e$h r1 = r4.f5482h     // Catch:{ all -> 0x0091 }
                if (r1 != 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0091 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0091 }
                androidx.core.provider.g$b r0 = r4.e()     // Catch:{ all -> 0x007e }
                int r1 = r0.b()     // Catch:{ all -> 0x007e }
                r2 = 2
                if (r1 != r2) goto L_0x001e
                java.lang.Object r2 = r4.f5478d     // Catch:{ all -> 0x007e }
                monitor-enter(r2)     // Catch:{ all -> 0x007e }
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                goto L_0x001e
            L_0x001a:
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                throw r0     // Catch:{ all -> 0x007e }
            L_0x001c:
                r0 = move-exception
                goto L_0x001a
            L_0x001e:
                if (r1 != 0) goto L_0x0062
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.m.a(r1)     // Catch:{ all -> 0x005d }
                androidx.emoji2.text.j$a r1 = r4.f5477c     // Catch:{ all -> 0x005d }
                android.content.Context r2 = r4.f5475a     // Catch:{ all -> 0x005d }
                android.graphics.Typeface r1 = r1.a(r2, r0)     // Catch:{ all -> 0x005d }
                android.content.Context r2 = r4.f5475a     // Catch:{ all -> 0x005d }
                r3 = 0
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x005d }
                java.nio.ByteBuffer r0 = androidx.core.graphics.l.f(r2, r3, r0)     // Catch:{ all -> 0x005d }
                if (r0 == 0) goto L_0x0055
                if (r1 == 0) goto L_0x0055
                androidx.emoji2.text.m r0 = androidx.emoji2.text.m.b(r1, r0)     // Catch:{ all -> 0x005d }
                androidx.core.os.m.b()     // Catch:{ all -> 0x007e }
                java.lang.Object r1 = r4.f5478d     // Catch:{ all -> 0x007e }
                monitor-enter(r1)     // Catch:{ all -> 0x007e }
                androidx.emoji2.text.e$h r2 = r4.f5482h     // Catch:{ all -> 0x0052 }
                if (r2 == 0) goto L_0x004d
                r2.b(r0)     // Catch:{ all -> 0x0052 }
            L_0x004d:
                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                r4.b()     // Catch:{ all -> 0x007e }
                goto L_0x008d
            L_0x0052:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                throw r0     // Catch:{ all -> 0x007e }
            L_0x0055:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x005d }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x005d }
                throw r0     // Catch:{ all -> 0x005d }
            L_0x005d:
                r0 = move-exception
                androidx.core.os.m.b()     // Catch:{ all -> 0x007e }
                throw r0     // Catch:{ all -> 0x007e }
            L_0x0062:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x007e }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
                r2.<init>()     // Catch:{ all -> 0x007e }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x007e }
                r2.append(r1)     // Catch:{ all -> 0x007e }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x007e }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x007e }
                r0.<init>(r1)     // Catch:{ all -> 0x007e }
                throw r0     // Catch:{ all -> 0x007e }
            L_0x007e:
                r0 = move-exception
                java.lang.Object r1 = r4.f5478d
                monitor-enter(r1)
                androidx.emoji2.text.e$h r2 = r4.f5482h     // Catch:{ all -> 0x008e }
                if (r2 == 0) goto L_0x0089
                r2.a(r0)     // Catch:{ all -> 0x008e }
            L_0x0089:
                monitor-exit(r1)     // Catch:{ all -> 0x008e }
                r4.b()
            L_0x008d:
                return
            L_0x008e:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x008e }
                throw r0
            L_0x0091:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0091 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.j.b.c():void");
        }

        /* access modifiers changed from: package-private */
        public void d() {
            synchronized (this.f5478d) {
                if (this.f5482h != null) {
                    if (this.f5480f == null) {
                        ThreadPoolExecutor b10 = b.b("emojiCompat");
                        this.f5481g = b10;
                        this.f5480f = b10;
                    }
                    this.f5480f.execute(new k(this));
                }
            }
        }

        public void f(@NonNull Executor executor) {
            synchronized (this.f5478d) {
                this.f5480f = executor;
            }
        }
    }

    public j(@NonNull Context context, @NonNull androidx.core.provider.e eVar) {
        super(new b(context, eVar, f5474j));
    }

    @NonNull
    public j c(@NonNull Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
