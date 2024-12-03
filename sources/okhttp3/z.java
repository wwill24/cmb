package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import okhttp3.v;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lokhttp3/z;", "", "Lokhttp3/v;", "b", "", "a", "Lokio/BufferedSink;", "sink", "", "i", "", "g", "h", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33274a = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000f\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u0005*\u00020\u00112\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0007J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0007J.\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0011H\u0007¨\u0006\u001c"}, d2 = {"Lokhttp3/z$a;", "", "", "Lokhttp3/v;", "contentType", "Lokhttp3/z;", "b", "(Ljava/lang/String;Lokhttp3/v;)Lokhttp3/z;", "Lokio/ByteString;", "h", "(Lokio/ByteString;Lokhttp3/v;)Lokhttp3/z;", "", "", "offset", "byteCount", "i", "([BLokhttp3/v;II)Lokhttp3/z;", "Ljava/io/File;", "a", "(Ljava/io/File;Lokhttp3/v;)Lokhttp3/z;", "content", "d", "e", "g", "file", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"okhttp3/z$a$a", "Lokhttp3/z;", "Lokhttp3/v;", "b", "", "a", "Lokio/BufferedSink;", "sink", "", "i", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: okhttp3.z$a$a  reason: collision with other inner class name */
        public static final class C0382a extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ v f33275b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f33276c;

            C0382a(v vVar, File file) {
                this.f33275b = vVar;
                this.f33276c = file;
            }

            public long a() {
                return this.f33276c.length();
            }

            public v b() {
                return this.f33275b;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
                throw r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
                kotlin.io.b.a(r0, r3);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void i(okio.BufferedSink r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "sink"
                    kotlin.jvm.internal.j.g(r3, r0)
                    java.io.File r0 = r2.f33276c
                    okio.Source r0 = okio.Okio.i(r0)
                    r3.o0(r0)     // Catch:{ all -> 0x0013 }
                    r3 = 0
                    kotlin.io.b.a(r0, r3)
                    return
                L_0x0013:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x0015 }
                L_0x0015:
                    r1 = move-exception
                    kotlin.io.b.a(r0, r3)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.z.a.C0382a.i(okio.BufferedSink):void");
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"okhttp3/z$a$b", "Lokhttp3/z;", "Lokhttp3/v;", "b", "", "a", "Lokio/BufferedSink;", "sink", "", "i", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class b extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ v f33277b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ByteString f33278c;

            b(v vVar, ByteString byteString) {
                this.f33277b = vVar;
                this.f33278c = byteString;
            }

            public long a() {
                return (long) this.f33278c.H();
            }

            public v b() {
                return this.f33277b;
            }

            public void i(BufferedSink bufferedSink) {
                j.g(bufferedSink, "sink");
                bufferedSink.K1(this.f33278c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"okhttp3/z$a$c", "Lokhttp3/z;", "Lokhttp3/v;", "b", "", "a", "Lokio/BufferedSink;", "sink", "", "i", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class c extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ v f33279b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f33280c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ byte[] f33281d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f33282e;

            c(v vVar, int i10, byte[] bArr, int i11) {
                this.f33279b = vVar;
                this.f33280c = i10;
                this.f33281d = bArr;
                this.f33282e = i11;
            }

            public long a() {
                return (long) this.f33280c;
            }

            public v b() {
                return this.f33279b;
            }

            public void i(BufferedSink bufferedSink) {
                j.g(bufferedSink, "sink");
                bufferedSink.write(this.f33281d, this.f33282e, this.f33280c);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ z j(a aVar, String str, v vVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                vVar = null;
            }
            return aVar.b(str, vVar);
        }

        public static /* synthetic */ z k(a aVar, v vVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return aVar.g(vVar, bArr, i10, i11);
        }

        public static /* synthetic */ z l(a aVar, byte[] bArr, v vVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                vVar = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return aVar.i(bArr, vVar, i10, i11);
        }

        public final z a(File file, v vVar) {
            j.g(file, "<this>");
            return new C0382a(vVar, file);
        }

        public final z b(String str, v vVar) {
            j.g(str, "<this>");
            Charset charset = d.f32216b;
            if (vVar != null) {
                Charset d10 = v.d(vVar, (Charset) null, 1, (Object) null);
                if (d10 == null) {
                    v.a aVar = v.f33190e;
                    vVar = aVar.b(vVar + "; charset=utf-8");
                } else {
                    charset = d10;
                }
            }
            byte[] bytes = str.getBytes(charset);
            j.f(bytes, "this as java.lang.String).getBytes(charset)");
            return i(bytes, vVar, 0, bytes.length);
        }

        public final z c(v vVar, File file) {
            j.g(file, "file");
            return a(file, vVar);
        }

        public final z d(v vVar, String str) {
            j.g(str, "content");
            return b(str, vVar);
        }

        public final z e(v vVar, ByteString byteString) {
            j.g(byteString, "content");
            return h(byteString, vVar);
        }

        public final z f(v vVar, byte[] bArr) {
            j.g(bArr, "content");
            return k(this, vVar, bArr, 0, 0, 12, (Object) null);
        }

        public final z g(v vVar, byte[] bArr, int i10, int i11) {
            j.g(bArr, "content");
            return i(bArr, vVar, i10, i11);
        }

        public final z h(ByteString byteString, v vVar) {
            j.g(byteString, "<this>");
            return new b(vVar, byteString);
        }

        public final z i(byte[] bArr, v vVar, int i10, int i11) {
            j.g(bArr, "<this>");
            bl.d.l((long) bArr.length, (long) i10, (long) i11);
            return new c(vVar, i11, bArr, i10);
        }
    }

    public static final z c(v vVar, File file) {
        return f33274a.c(vVar, file);
    }

    public static final z d(v vVar, String str) {
        return f33274a.d(vVar, str);
    }

    public static final z e(v vVar, ByteString byteString) {
        return f33274a.e(vVar, byteString);
    }

    public static final z f(v vVar, byte[] bArr) {
        return f33274a.f(vVar, bArr);
    }

    public long a() throws IOException {
        return -1;
    }

    public abstract v b();

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public abstract void i(BufferedSink bufferedSink) throws IOException;
}
