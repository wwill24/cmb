package io.sentry.cache;

import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.g;
import io.sentry.n3;
import io.sentry.transport.r;
import io.sentry.util.l;
import io.sentry.w2;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class d extends b implements e {

    /* renamed from: f  reason: collision with root package name */
    private final Map<w2, String> f31165f = new WeakHashMap();

    public d(SentryOptions sentryOptions, String str, int i10) {
        super(sentryOptions, str, i10);
    }

    private Date A(File file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), b.f31160e));
            String readLine = bufferedReader.readLine();
            this.f31161a.getLogger().c(SentryLevel.DEBUG, "Crash marker file has %s timestamp.", readLine);
            Date e10 = g.e(readLine);
            bufferedReader.close();
            return e10;
        } catch (IOException e11) {
            this.f31161a.getLogger().b(SentryLevel.ERROR, "Error reading the crash marker file.", e11);
            return null;
        } catch (IllegalArgumentException e12) {
            this.f31161a.getLogger().a(SentryLevel.ERROR, e12, "Error converting the crash timestamp.", new Object[0]);
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private void C(File file, w2 w2Var) {
        BufferedReader bufferedReader;
        Iterable<n3> c10 = w2Var.c();
        if (c10.iterator().hasNext()) {
            n3 next = c10.iterator().next();
            if (SentryItemType.Session.equals(next.x().b())) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.w()), b.f31160e));
                    Session session = (Session) this.f31162b.c(bufferedReader, Session.class);
                    if (session == null) {
                        this.f31161a.getLogger().c(SentryLevel.ERROR, "Item of type %s returned null by the parser.", next.x().b());
                    } else {
                        F(file, session);
                    }
                    bufferedReader.close();
                    return;
                } catch (Throwable th2) {
                    this.f31161a.getLogger().b(SentryLevel.ERROR, "Item failed to process.", th2);
                    return;
                }
            } else {
                this.f31161a.getLogger().c(SentryLevel.INFO, "Current envelope has a different envelope type %s", next.x().b());
                return;
            }
        } else {
            this.f31161a.getLogger().c(SentryLevel.INFO, "Current envelope %s is empty", file.getAbsolutePath());
            return;
        }
        throw th;
    }

    private void D() {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(this.f31161a.getCacheDirPath(), "last_crash"));
            fileOutputStream.write(g.g(g.c()).getBytes(b.f31160e));
            fileOutputStream.flush();
            fileOutputStream.close();
            return;
        } catch (Throwable th2) {
            this.f31161a.getLogger().b(SentryLevel.ERROR, "Error writing the crash marker file to the disk", th2);
            return;
        }
        throw th;
    }

    private void E(File file, w2 w2Var) {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            this.f31161a.getLogger().c(SentryLevel.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.f31161a.getLogger().c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            this.f31162b.b(w2Var, fileOutputStream);
            fileOutputStream.close();
            return;
        } catch (Throwable th2) {
            this.f31161a.getLogger().a(SentryLevel.ERROR, th2, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
            return;
        }
        throw th;
    }

    private void F(File file, Session session) {
        BufferedWriter bufferedWriter;
        if (file.exists()) {
            this.f31161a.getLogger().c(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", session.i());
            if (!file.delete()) {
                this.f31161a.getLogger().c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, b.f31160e));
                this.f31162b.a(session, bufferedWriter);
                bufferedWriter.close();
                fileOutputStream.close();
                return;
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
            throw th;
        } catch (Throwable th3) {
            this.f31161a.getLogger().a(SentryLevel.ERROR, th3, "Error writing Session to offline storage: %s", session.i());
        }
    }

    private File[] v() {
        File[] listFiles;
        if (!g() || (listFiles = this.f31163c.listFiles(new c())) == null) {
            return new File[0];
        }
        return listFiles;
    }

    public static e w(SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        int maxCacheItems = sentryOptions.getMaxCacheItems();
        if (cacheDirPath != null) {
            return new d(sentryOptions, cacheDirPath, maxCacheItems);
        }
        sentryOptions.getLogger().c(SentryLevel.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
        return r.b();
    }

    private File y() {
        return new File(this.f31163c.getAbsolutePath(), "session.json");
    }

    private synchronized File z(w2 w2Var) {
        String str;
        String str2;
        if (this.f31165f.containsKey(w2Var)) {
            str = this.f31165f.get(w2Var);
        } else {
            if (w2Var.b().a() != null) {
                str2 = w2Var.b().a().toString();
            } else {
                str2 = UUID.randomUUID().toString();
            }
            String str3 = str2 + ".envelope";
            this.f31165f.put(w2Var, str3);
            str = str3;
        }
        return new File(this.f31163c.getAbsolutePath(), str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f5, code lost:
        r1 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:30:0x00e4, B:35:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a1(io.sentry.w2 r13, io.sentry.w r14) {
        /*
            r12 = this;
            java.lang.String r0 = "Envelope is required."
            io.sentry.util.l.c(r13, r0)
            java.io.File[] r0 = r12.v()
            r12.r(r0)
            java.io.File r0 = r12.y()
            java.lang.Class<io.sentry.hints.h> r1 = io.sentry.hints.h.class
            boolean r1 = io.sentry.util.i.g(r14, r1)
            r2 = 0
            if (r1 == 0) goto L_0x002e
            boolean r1 = r0.delete()
            if (r1 != 0) goto L_0x002e
            io.sentry.SentryOptions r1 = r12.f31161a
            io.sentry.h0 r1 = r1.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "Current envelope doesn't exist."
            r1.c(r3, r5, r4)
        L_0x002e:
            java.lang.Class<io.sentry.hints.j> r1 = io.sentry.hints.j.class
            boolean r1 = io.sentry.util.i.g(r14, r1)
            r3 = 1
            if (r1 == 0) goto L_0x0165
            boolean r1 = r0.exists()
            java.lang.String r4 = "Failed to delete the crash marker file. %s."
            if (r1 == 0) goto L_0x011c
            io.sentry.SentryOptions r1 = r12.f31161a
            io.sentry.h0 r1 = r1.getLogger()
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r7 = "Current session is not ended, we'd need to end it."
            r1.c(r5, r7, r6)
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x00f7 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x00f7 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x00f7 }
            r6.<init>(r0)     // Catch:{ all -> 0x00f7 }
            java.nio.charset.Charset r7 = io.sentry.cache.b.f31160e     // Catch:{ all -> 0x00f7 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00f7 }
            r1.<init>(r5)     // Catch:{ all -> 0x00f7 }
            io.sentry.l0 r5 = r12.f31162b     // Catch:{ all -> 0x00ea }
            java.lang.Class<io.sentry.Session> r6 = io.sentry.Session.class
            java.lang.Object r5 = r5.c(r1, r6)     // Catch:{ all -> 0x00ea }
            io.sentry.Session r5 = (io.sentry.Session) r5     // Catch:{ all -> 0x00ea }
            if (r5 != 0) goto L_0x0082
            io.sentry.SentryOptions r5 = r12.f31161a     // Catch:{ all -> 0x00ea }
            io.sentry.h0 r5 = r5.getLogger()     // Catch:{ all -> 0x00ea }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = "Stream from path %s resulted in a null envelope."
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = r0.getAbsolutePath()     // Catch:{ all -> 0x00ea }
            r8[r2] = r9     // Catch:{ all -> 0x00ea }
            r5.c(r6, r7, r8)     // Catch:{ all -> 0x00ea }
            r6 = r2
            goto L_0x00e4
        L_0x0082:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00ea }
            io.sentry.SentryOptions r7 = r12.f31161a     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = r7.getCacheDirPath()     // Catch:{ all -> 0x00ea }
            java.lang.String r8 = ".sentry-native/last_crash"
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00ea }
            boolean r7 = r6.exists()     // Catch:{ all -> 0x00ea }
            r8 = 0
            if (r7 == 0) goto L_0x00cd
            io.sentry.SentryOptions r7 = r12.f31161a     // Catch:{ all -> 0x00ea }
            io.sentry.h0 r7 = r7.getLogger()     // Catch:{ all -> 0x00ea }
            io.sentry.SentryLevel r9 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = "Crash marker file exists, last Session is gonna be Crashed."
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r7.c(r9, r10, r11)     // Catch:{ all -> 0x00ea }
            java.util.Date r7 = r12.A(r6)     // Catch:{ all -> 0x00ea }
            boolean r9 = r6.delete()     // Catch:{ all -> 0x00ca }
            if (r9 != 0) goto L_0x00c2
            io.sentry.SentryOptions r9 = r12.f31161a     // Catch:{ all -> 0x00ca }
            io.sentry.h0 r9 = r9.getLogger()     // Catch:{ all -> 0x00ca }
            io.sentry.SentryLevel r10 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00ca }
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x00ca }
            r11[r2] = r6     // Catch:{ all -> 0x00ca }
            r9.c(r10, r4, r11)     // Catch:{ all -> 0x00ca }
        L_0x00c2:
            io.sentry.Session$State r6 = io.sentry.Session.State.Crashed     // Catch:{ all -> 0x00ca }
            r5.n(r6, r8, r3)     // Catch:{ all -> 0x00ca }
            r6 = r3
            r8 = r7
            goto L_0x00ce
        L_0x00ca:
            r5 = move-exception
            r6 = r3
            goto L_0x00ec
        L_0x00cd:
            r6 = r2
        L_0x00ce:
            r5.d(r8)     // Catch:{ all -> 0x00e8 }
            io.sentry.l0 r7 = r12.f31162b     // Catch:{ all -> 0x00e8 }
            io.sentry.SentryOptions r8 = r12.f31161a     // Catch:{ all -> 0x00e8 }
            io.sentry.protocol.m r8 = r8.getSdkVersion()     // Catch:{ all -> 0x00e8 }
            io.sentry.w2 r5 = io.sentry.w2.a(r7, r5, r8)     // Catch:{ all -> 0x00e8 }
            java.io.File r7 = r12.z(r5)     // Catch:{ all -> 0x00e8 }
            r12.E(r7, r5)     // Catch:{ all -> 0x00e8 }
        L_0x00e4:
            r1.close()     // Catch:{ all -> 0x00f5 }
            goto L_0x0106
        L_0x00e8:
            r5 = move-exception
            goto L_0x00ec
        L_0x00ea:
            r5 = move-exception
            r6 = r2
        L_0x00ec:
            r1.close()     // Catch:{ all -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r1 = move-exception
            r5.addSuppressed(r1)     // Catch:{ all -> 0x00f5 }
        L_0x00f4:
            throw r5     // Catch:{ all -> 0x00f5 }
        L_0x00f5:
            r1 = move-exception
            goto L_0x00f9
        L_0x00f7:
            r1 = move-exception
            r6 = r2
        L_0x00f9:
            io.sentry.SentryOptions r5 = r12.f31161a
            io.sentry.h0 r5 = r5.getLogger()
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR
            java.lang.String r8 = "Error processing session."
            r5.b(r7, r8, r1)
        L_0x0106:
            boolean r1 = r0.delete()
            if (r1 != 0) goto L_0x011d
            io.sentry.SentryOptions r1 = r12.f31161a
            io.sentry.h0 r1 = r1.getLogger()
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.String r8 = "Failed to delete the current session file."
            r1.c(r5, r8, r7)
            goto L_0x011d
        L_0x011c:
            r6 = r2
        L_0x011d:
            r12.C(r0, r13)
            if (r6 != 0) goto L_0x015e
            java.io.File r0 = new java.io.File
            io.sentry.SentryOptions r1 = r12.f31161a
            java.lang.String r1 = r1.getCacheDirPath()
            java.lang.String r5 = "last_crash"
            r0.<init>(r1, r5)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x015e
            io.sentry.SentryOptions r1 = r12.f31161a
            io.sentry.h0 r1 = r1.getLogger()
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r7 = "Crash marker file exists, crashedLastRun will return true."
            r1.c(r5, r7, r6)
            boolean r1 = r0.delete()
            if (r1 != 0) goto L_0x015d
            io.sentry.SentryOptions r1 = r12.f31161a
            io.sentry.h0 r1 = r1.getLogger()
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.String r0 = r0.getAbsolutePath()
            r6[r2] = r0
            r1.c(r5, r4, r6)
        L_0x015d:
            r6 = r3
        L_0x015e:
            io.sentry.t2 r0 = io.sentry.t2.a()
            r0.b(r6)
        L_0x0165:
            java.io.File r0 = r12.z(r13)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0185
            io.sentry.SentryOptions r13 = r12.f31161a
            io.sentry.h0 r13 = r13.getLogger()
            io.sentry.SentryLevel r14 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r0 = r0.getAbsolutePath()
            r1[r2] = r0
            java.lang.String r0 = "Not adding Envelope to offline storage because it already exists: %s"
            r13.c(r14, r0, r1)
            return
        L_0x0185:
            io.sentry.SentryOptions r1 = r12.f31161a
            io.sentry.h0 r1 = r1.getLogger()
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r5 = r0.getAbsolutePath()
            r3[r2] = r5
            java.lang.String r2 = "Adding Envelope to offline storage: %s"
            r1.c(r4, r2, r3)
            r12.E(r0, r13)
            java.lang.Class<io.sentry.hints.d> r13 = io.sentry.hints.d.class
            boolean r13 = io.sentry.util.i.g(r14, r13)
            if (r13 == 0) goto L_0x01a8
            r12.D()
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.d.a1(io.sentry.w2, io.sentry.w):void");
    }

    public Iterator<w2> iterator() {
        BufferedInputStream bufferedInputStream;
        File[] v10 = v();
        ArrayList arrayList = new ArrayList(v10.length);
        for (File file : v10) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                arrayList.add(this.f31162b.d(bufferedInputStream));
                bufferedInputStream.close();
            } catch (FileNotFoundException unused) {
                this.f31161a.getLogger().c(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e10) {
                this.f31161a.getLogger().b(SentryLevel.ERROR, String.format("Error while reading cached envelope from file %s", new Object[]{file.getAbsolutePath()}), e10);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return arrayList.iterator();
        throw th;
    }

    public void x(w2 w2Var) {
        l.c(w2Var, "Envelope is required.");
        File z10 = z(w2Var);
        if (z10.exists()) {
            this.f31161a.getLogger().c(SentryLevel.DEBUG, "Discarding envelope from cache: %s", z10.getAbsolutePath());
            if (!z10.delete()) {
                this.f31161a.getLogger().c(SentryLevel.ERROR, "Failed to delete envelope: %s", z10.getAbsolutePath());
                return;
            }
            return;
        }
        this.f31161a.getLogger().c(SentryLevel.DEBUG, "Envelope was not cached: %s", z10.getAbsolutePath());
    }
}
