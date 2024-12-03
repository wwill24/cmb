package f3;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.facebook.appevents.AppEventsConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final File f14663a;

    /* renamed from: b  reason: collision with root package name */
    private final File f14664b;

    /* renamed from: c  reason: collision with root package name */
    private final File f14665c;

    /* renamed from: d  reason: collision with root package name */
    private final File f14666d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14667e;

    /* renamed from: f  reason: collision with root package name */
    private long f14668f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f14669g;

    /* renamed from: h  reason: collision with root package name */
    private long f14670h = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Writer f14671j;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, d> f14672k = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f14673l;

    /* renamed from: m  reason: collision with root package name */
    private long f14674m = 0;

    /* renamed from: n  reason: collision with root package name */
    final ThreadPoolExecutor f14675n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C0157b((a) null));

    /* renamed from: p  reason: collision with root package name */
    private final Callable<Void> f14676p = new a();

    class a implements Callable<Void> {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                f3.b r0 = f3.b.this
                monitor-enter(r0)
                f3.b r1 = f3.b.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f14671j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                f3.b r1 = f3.b.this     // Catch:{ all -> 0x0028 }
                r1.S()     // Catch:{ all -> 0x0028 }
                f3.b r1 = f3.b.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.F()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                f3.b r1 = f3.b.this     // Catch:{ all -> 0x0028 }
                r1.N()     // Catch:{ all -> 0x0028 }
                f3.b r1 = f3.b.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f14673l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: f3.b.a.call():java.lang.Void");
        }
    }

    /* renamed from: f3.b$b  reason: collision with other inner class name */
    private static final class C0157b implements ThreadFactory {
        private C0157b() {
        }

        /* synthetic */ C0157b(a aVar) {
            this();
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final d f14678a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f14679b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14680c;

        /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }

        public void a() throws IOException {
            b.this.n(this, false);
        }

        public void b() {
            if (!this.f14680c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            b.this.n(this, true);
            this.f14680c = true;
        }

        public File f(int i10) throws IOException {
            File k10;
            synchronized (b.this) {
                if (this.f14678a.f14687f == this) {
                    if (!this.f14678a.f14686e) {
                        this.f14679b[i10] = true;
                    }
                    k10 = this.f14678a.k(i10);
                    if (!b.this.f14663a.exists()) {
                        b.this.f14663a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k10;
        }

        private c(d dVar) {
            this.f14678a = dVar;
            this.f14679b = dVar.f14686e ? null : new boolean[b.this.f14669g];
        }
    }

    private final class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f14682a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f14683b;

        /* renamed from: c  reason: collision with root package name */
        File[] f14684c;

        /* renamed from: d  reason: collision with root package name */
        File[] f14685d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f14686e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public c f14687f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f14688g;

        /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == b.this.f14669g) {
                int i10 = 0;
                while (i10 < strArr.length) {
                    try {
                        this.f14683b[i10] = Long.parseLong(strArr[i10]);
                        i10++;
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i10) {
            return this.f14684c[i10];
        }

        public File k(int i10) {
            return this.f14685d[i10];
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long append : this.f14683b) {
                sb2.append(' ');
                sb2.append(append);
            }
            return sb2.toString();
        }

        private d(String str) {
            this.f14682a = str;
            this.f14683b = new long[b.this.f14669g];
            this.f14684c = new File[b.this.f14669g];
            this.f14685d = new File[b.this.f14669g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < b.this.f14669g; i10++) {
                sb2.append(i10);
                this.f14684c[i10] = new File(b.this.f14663a, sb2.toString());
                sb2.append(".tmp");
                this.f14685d[i10] = new File(b.this.f14663a, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private final String f14690a;

        /* renamed from: b  reason: collision with root package name */
        private final long f14691b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f14692c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f14693d;

        /* synthetic */ e(b bVar, String str, long j10, File[] fileArr, long[] jArr, a aVar) {
            this(str, j10, fileArr, jArr);
        }

        public File a(int i10) {
            return this.f14693d[i10];
        }

        private e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f14690a = str;
            this.f14691b = j10;
            this.f14693d = fileArr;
            this.f14692c = jArr;
        }
    }

    private b(File file, int i10, int i11, long j10) {
        File file2 = file;
        this.f14663a = file2;
        this.f14667e = i10;
        this.f14664b = new File(file2, "journal");
        this.f14665c = new File(file2, "journal.tmp");
        this.f14666d = new File(file2, "journal.bkp");
        this.f14669g = i11;
        this.f14668f = j10;
    }

    @TargetApi(26)
    private static void C(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    public boolean F() {
        int i10 = this.f14673l;
        if (i10 < 2000 || i10 < this.f14672k.size()) {
            return false;
        }
        return true;
    }

    public static b G(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i11 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    P(file2, file3, false);
                }
            }
            b bVar = new b(file, i10, i11, j10);
            if (bVar.f14664b.exists()) {
                try {
                    bVar.J();
                    bVar.I();
                    return bVar;
                } catch (IOException e10) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                    bVar.u();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i10, i11, j10);
            bVar2.N();
            return bVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void I() throws IOException {
        v(this.f14665c);
        Iterator<d> it = this.f14672k.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f14687f == null) {
                while (i10 < this.f14669g) {
                    this.f14670h += next.f14683b[i10];
                    i10++;
                }
            } else {
                c unused = next.f14687f = null;
                while (i10 < this.f14669g) {
                    v(next.j(i10));
                    v(next.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f14673l = r0 - r9.f14672k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.c() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        N();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f14671j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f14664b, true), f3.d.f14701a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            f3.c r1 = new f3.c
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f14664b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = f3.d.f14701a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.e()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.e()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.e()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.e()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.e()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f14667e     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f14669g     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.e()     // Catch:{ EOFException -> 0x005f }
            r9.L(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, f3.b$d> r2 = r9.f14672k     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f14673l = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.c()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.N()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f14664b     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = f3.d.f14701a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f14671j = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            f3.d.a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            f3.d.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.J():void");
    }

    private void L(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                str2 = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f14672k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, indexOf2);
            }
            d dVar = this.f14672k.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, (a) null);
                this.f14672k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = dVar.f14686e = true;
                c unused2 = dVar.f14687f = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c unused3 = dVar.f14687f = new c(this, dVar, (a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void N() throws IOException {
        Writer writer = this.f14671j;
        if (writer != null) {
            m(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14665c), d.f14701a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f14667e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f14669g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d next : this.f14672k.values()) {
                if (next.f14687f != null) {
                    bufferedWriter.write("DIRTY " + next.f14682a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f14682a + next.l() + 10);
                }
            }
            m(bufferedWriter);
            if (this.f14664b.exists()) {
                P(this.f14664b, this.f14666d, true);
            }
            P(this.f14665c, this.f14664b, false);
            this.f14666d.delete();
            this.f14671j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14664b, true), d.f14701a));
        } catch (Throwable th2) {
            m(bufferedWriter);
            throw th2;
        }
    }

    private static void P(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            v(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void S() throws IOException {
        while (this.f14670h > this.f14668f) {
            O((String) this.f14672k.entrySet().iterator().next().getKey());
        }
    }

    private void l() {
        if (this.f14671j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void m(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void n(f3.b.c r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            f3.b$d r0 = r10.f14678a     // Catch:{ all -> 0x010e }
            f3.b$c r1 = r0.f14687f     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f14686e     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r9.f14669g     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f14679b     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.a()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.a()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.f14669g     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f14683b     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f14683b     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f14670h     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f14670h = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            v(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f14673l     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.f14673l = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            f3.b.c unused = r0.f14687f = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f14686e     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f14686e = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.f14682a     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.l()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.f14674m     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.f14674m = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f14688g = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, f3.b$d> r10 = r9.f14672k     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f14682a     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f14682a     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f14671j     // Catch:{ all -> 0x010e }
            C(r10)     // Catch:{ all -> 0x010e }
            long r10 = r9.f14670h     // Catch:{ all -> 0x010e }
            long r0 = r9.f14668f     // Catch:{ all -> 0x010e }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ff
            boolean r10 = r9.F()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f14675n     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f14676p     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.n(f3.b$c, boolean):void");
    }

    private static void v(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized f3.b.c y(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.l()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, f3.b$d> r0 = r5.f14672k     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            f3.b$d r0 = (f3.b.d) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r3 = r0.f14688g     // Catch:{ all -> 0x005d }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r2
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            f3.b$d r0 = new f3.b$d     // Catch:{ all -> 0x005d }
            r0.<init>(r5, r6, r2)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, f3.b$d> r7 = r5.f14672k     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            f3.b$c r7 = r0.f14687f     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r2
        L_0x0034:
            f3.b$c r7 = new f3.b$c     // Catch:{ all -> 0x005d }
            r7.<init>(r5, r0, r2)     // Catch:{ all -> 0x005d }
            f3.b.c unused = r0.f14687f = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f14671j     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f14671j     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f14671j     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f14671j     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f14671j     // Catch:{ all -> 0x005d }
            C(r6)     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.y(java.lang.String, long):f3.b$c");
    }

    public synchronized e E(String str) throws IOException {
        l();
        d dVar = this.f14672k.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f14686e) {
            return null;
        }
        for (File exists : dVar.f14684c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f14673l++;
        this.f14671j.append("READ");
        this.f14671j.append(' ');
        this.f14671j.append(str);
        this.f14671j.append(10);
        if (F()) {
            this.f14675n.submit(this.f14676p);
        }
        return new e(this, str, dVar.f14688g, dVar.f14684c, dVar.f14683b, (a) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean O(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.l()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, f3.b$d> r0 = r7.f14672k     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            f3.b$d r0 = (f3.b.d) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            f3.b$c r2 = r0.f14687f     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f14669g     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.f14670h     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f14683b     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f14670h = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f14683b     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.f14673l     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.f14673l = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f14671j     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f14671j     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f14671j     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f14671j     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, f3.b$d> r0 = r7.f14672k     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.F()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f14675n     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f14676p     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.O(java.lang.String):boolean");
    }

    public synchronized void close() throws IOException {
        if (this.f14671j != null) {
            Iterator it = new ArrayList(this.f14672k.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f14687f != null) {
                    dVar.f14687f.a();
                }
            }
            S();
            m(this.f14671j);
            this.f14671j = null;
        }
    }

    public void u() throws IOException {
        close();
        d.b(this.f14663a);
    }

    public c x(String str) throws IOException {
        return y(str, -1);
    }
}
