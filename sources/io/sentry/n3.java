package io.sentry;

import io.sentry.clientreport.b;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.util.j;
import io.sentry.util.l;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class n3 {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f31349d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final o3 f31350a;

    /* renamed from: b  reason: collision with root package name */
    private final Callable<byte[]> f31351b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f31352c;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f31353a;

        /* renamed from: b  reason: collision with root package name */
        private final Callable<byte[]> f31354b;

        public a(Callable<byte[]> callable) {
            this.f31354b = callable;
        }

        private static byte[] b(byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }

        public byte[] a() throws Exception {
            Callable<byte[]> callable;
            if (this.f31353a == null && (callable = this.f31354b) != null) {
                this.f31353a = callable.call();
            }
            return b(this.f31353a);
        }
    }

    n3(o3 o3Var, byte[] bArr) {
        this.f31350a = (o3) l.c(o3Var, "SentryEnvelopeItemHeader is required.");
        this.f31352c = bArr;
        this.f31351b = null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] A(b bVar, long j10, l0 l0Var, h0 h0Var) throws Exception {
        if (bVar.d() != null) {
            byte[] d10 = bVar.d();
            p((long) d10.length, j10, bVar.f());
            return d10;
        }
        if (bVar.h() != null) {
            byte[] b10 = j.b(l0Var, h0Var, bVar.h());
            if (b10 != null) {
                p((long) b10.length, j10, bVar.f());
                return b10;
            }
        } else if (bVar.g() != null) {
            return N(bVar.g(), j10);
        }
        throw new SentryEnvelopeException(String.format("Couldn't attach the attachment %s.\nPlease check that either bytes, serializable or a path is set.", new Object[]{bVar.f()}));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] B(l0 l0Var, b bVar) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f31349d));
            l0Var.a(bVar, bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] E(l0 l0Var, p2 p2Var) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f31349d));
            l0Var.a(p2Var, bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] H(File file, long j10, z1 z1Var, l0 l0Var) throws Exception {
        BufferedWriter bufferedWriter;
        if (file.exists()) {
            String c10 = io.sentry.vendor.a.c(N(file.getPath(), j10), 3);
            if (!c10.isEmpty()) {
                z1Var.G(c10);
                z1Var.F();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f31349d));
                        l0Var.a(z1Var, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        file.delete();
                        return byteArray;
                    } catch (Throwable th2) {
                        byteArrayOutputStream.close();
                        throw th2;
                    }
                } catch (IOException e10) {
                    try {
                        throw new SentryEnvelopeException(String.format("Failed to serialize profiling trace data\n%s", new Object[]{e10.getMessage()}));
                    } catch (Throwable th3) {
                        file.delete();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
            } else {
                throw new SentryEnvelopeException("Profiling trace file is empty");
            }
        } else {
            throw new SentryEnvelopeException(String.format("Dropping profiling trace data, because the file '%s' doesn't exists", new Object[]{file.getName()}));
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] K(l0 l0Var, Session session) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f31349d));
            l0Var.a(session, bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
        throw th;
    }

    private static byte[] N(String str, long j10) throws SentryEnvelopeException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.isFile()) {
                throw new SentryEnvelopeException(String.format("Reading the item %s failed, because the file located at the path is not a file.", new Object[]{str}));
            } else if (!file.canRead()) {
                throw new SentryEnvelopeException(String.format("Reading the item %s failed, because can't read the file.", new Object[]{str}));
            } else if (file.length() <= j10) {
                FileInputStream fileInputStream = new FileInputStream(str);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                bufferedInputStream.close();
                                fileInputStream.close();
                                return byteArray;
                            }
                        }
                    } catch (Throwable th2) {
                        bufferedInputStream.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    fileInputStream.close();
                    throw th3;
                }
            } else {
                throw new SentryEnvelopeException(String.format("Dropping item, because its size located at '%s' with %d bytes is bigger than the maximum allowed size of %d bytes.", new Object[]{str, Long.valueOf(file.length()), Long.valueOf(j10)}));
            }
            throw th;
        } catch (IOException | SecurityException e10) {
            throw new SentryEnvelopeException(String.format("Reading the item %s failed.\n%s", new Object[]{str, e10.getMessage()}));
        } catch (Throwable th4) {
            th3.addSuppressed(th4);
        }
    }

    private static void p(long j10, long j11, String str) throws SentryEnvelopeException {
        if (j10 > j11) {
            throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", new Object[]{str, Long.valueOf(j10), Long.valueOf(j11)}));
        }
    }

    public static n3 q(l0 l0Var, h0 h0Var, b bVar, long j10) {
        a aVar = new a(new m3(bVar, j10, l0Var, h0Var));
        return new n3(new o3(SentryItemType.Attachment, (Callable<Integer>) new z2(aVar), bVar.e(), bVar.f(), bVar.c()), (Callable<byte[]>) new a3(aVar));
    }

    public static n3 r(l0 l0Var, b bVar) throws IOException {
        l.c(l0Var, "ISerializer is required.");
        l.c(bVar, "ClientReport is required.");
        a aVar = new a(new g3(l0Var, bVar));
        return new n3(new o3(SentryItemType.resolve(bVar), new h3(aVar), "application/json", (String) null), (Callable<byte[]>) new i3(aVar));
    }

    public static n3 s(l0 l0Var, p2 p2Var) throws IOException {
        l.c(l0Var, "ISerializer is required.");
        l.c(p2Var, "SentryEvent is required.");
        a aVar = new a(new j3(l0Var, p2Var));
        return new n3(new o3(SentryItemType.resolve(p2Var), new k3(aVar), "application/json", (String) null), (Callable<byte[]>) new l3(aVar));
    }

    public static n3 t(z1 z1Var, long j10, l0 l0Var) throws SentryEnvelopeException {
        File B = z1Var.B();
        a aVar = new a(new b3(B, j10, z1Var, l0Var));
        return new n3(new o3(SentryItemType.Profile, new c3(aVar), "application-json", B.getName()), (Callable<byte[]>) new d3(aVar));
    }

    public static n3 u(l0 l0Var, Session session) throws IOException {
        l.c(l0Var, "ISerializer is required.");
        l.c(session, "Session is required.");
        a aVar = new a(new y2(l0Var, session));
        return new n3(new o3(SentryItemType.Session, new e3(aVar), "application/json", (String) null), (Callable<byte[]>) new f3(aVar));
    }

    public b v(l0 l0Var) throws Exception {
        o3 o3Var = this.f31350a;
        if (o3Var == null || o3Var.b() != SentryItemType.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(w()), f31349d));
        try {
            b bVar = (b) l0Var.c(bufferedReader, b.class);
            bufferedReader.close();
            return bVar;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public byte[] w() throws Exception {
        Callable<byte[]> callable;
        if (this.f31352c == null && (callable = this.f31351b) != null) {
            this.f31352c = callable.call();
        }
        return this.f31352c;
    }

    public o3 x() {
        return this.f31350a;
    }

    n3(o3 o3Var, Callable<byte[]> callable) {
        this.f31350a = (o3) l.c(o3Var, "SentryEnvelopeItemHeader is required.");
        this.f31351b = (Callable) l.c(callable, "DataFactory is required.");
        this.f31352c = null;
    }
}
