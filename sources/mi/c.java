package mi;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.BuildConfig;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f32793b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f32794c = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final File f32795a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f32795a = new File(new File(context.getFilesDir(), ".com.withpersona.sdk2.inquiry"), IdentityHttpResponse.ERRORS);
    }

    private final String b(Throwable th2) {
        while (th2 != null) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            j.f(stackTrace, "currentError.stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                j.f(className, "it.className");
                if (r.J(className, BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, (Object) null)) {
                    return stackTraceElement.getClassName() + " in " + stackTraceElement.getMethodName() + " at line " + stackTraceElement.getLineNumber();
                }
            }
            th2 = th2.getCause();
        }
        return null;
    }

    private final String c(Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        j.f(stackTrace, "this.stackTrace");
        StackTraceElement stackTraceElement = (StackTraceElement) l.A(stackTrace);
        if (stackTraceElement == null) {
            return null;
        }
        return stackTraceElement.getClassName() + " in " + stackTraceElement.getMethodName() + " at line " + stackTraceElement.getLineNumber();
    }

    private final File d() {
        return new File(this.f32795a, "last_error.txt");
    }

    private final void h(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                file.delete();
            } else {
                return;
            }
        }
        file.mkdirs();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        kotlin.io.b.a(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String i(java.io.File r6) {
        /*
            r5 = this;
            boolean r0 = r6.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0047
            boolean r0 = r6.isFile()
            if (r0 != 0) goto L_0x000e
            goto L_0x0047
        L_0x000e:
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r6)
        L_0x001c:
            int r6 = r3.read(r0)     // Catch:{ all -> 0x0040 }
            if (r6 <= 0) goto L_0x0027
            r4 = 0
            r2.write(r0, r4, r6)     // Catch:{ all -> 0x0040 }
            goto L_0x001c
        L_0x0027:
            byte[] r6 = r2.toByteArray()     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = "bos.toByteArray()"
            kotlin.jvm.internal.j.f(r6, r0)     // Catch:{ all -> 0x0040 }
            java.nio.charset.Charset r0 = f32794c     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = "UTF_8"
            kotlin.jvm.internal.j.f(r0, r2)     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0040 }
            r2.<init>(r6, r0)     // Catch:{ all -> 0x0040 }
            kotlin.io.b.a(r3, r1)
            return r2
        L_0x0040:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
            kotlin.io.b.a(r3, r6)
            throw r0
        L_0x0047:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: mi.c.i(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void j(java.io.File r3, java.lang.String r4) {
        /*
            r2 = this;
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r3)
            java.nio.charset.Charset r3 = f32794c
            r0.<init>(r1, r3)
            r0.write(r4)     // Catch:{ all -> 0x0016 }
            kotlin.Unit r3 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0016 }
            r3 = 0
            kotlin.io.b.a(r0, r3)
            return
        L_0x0016:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r4 = move-exception
            kotlin.io.b.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: mi.c.j(java.io.File, java.lang.String):void");
    }

    public final void a() {
        d().delete();
    }

    public final String e() {
        return i(d());
    }

    public final boolean f() {
        return d().exists();
    }

    public final void g(Throwable th2) {
        j.g(th2, "error");
        h(this.f32795a);
        File d10 = d();
        if (d10.isDirectory()) {
            d10.delete();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(th2.getClass().getCanonicalName());
        sb2.append(" in ");
        String b10 = b(th2);
        if (b10 == null) {
            b10 = c(th2);
        }
        sb2.append(b10);
        j(d10, sb2.toString());
    }
}
