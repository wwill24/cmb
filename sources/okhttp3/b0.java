package okhttp3;

import bl.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.v;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b \u0010!JB\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0005H&J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lokhttp3/b0;", "Ljava/io/Closeable;", "", "T", "Lkotlin/Function1;", "Lokio/BufferedSource;", "consumer", "", "sizeMapper", "consumeSource", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "Lokhttp3/v;", "contentType", "", "contentLength", "Ljava/io/InputStream;", "byteStream", "source", "", "bytes", "Lokio/ByteString;", "byteString", "Ljava/io/Reader;", "charStream", "", "string", "", "close", "reader", "Ljava/io/Reader;", "<init>", "()V", "Companion", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class b0 implements Closeable {
    public static final b Companion = new b((DefaultConstructorMarker) null);
    private Reader reader;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lokhttp3/b0$a;", "Ljava/io/Reader;", "", "cbuf", "", "off", "len", "read", "", "close", "Lokio/BufferedSource;", "a", "Lokio/BufferedSource;", "source", "Ljava/nio/charset/Charset;", "b", "Ljava/nio/charset/Charset;", "charset", "", "c", "Z", "closed", "d", "Ljava/io/Reader;", "delegate", "<init>", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedSource f32889a;

        /* renamed from: b  reason: collision with root package name */
        private final Charset f32890b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f32891c;

        /* renamed from: d  reason: collision with root package name */
        private Reader f32892d;

        public a(BufferedSource bufferedSource, Charset charset) {
            j.g(bufferedSource, "source");
            j.g(charset, "charset");
            this.f32889a = bufferedSource;
            this.f32890b = charset;
        }

        public void close() throws IOException {
            Unit unit;
            this.f32891c = true;
            Reader reader = this.f32892d;
            if (reader == null) {
                unit = null;
            } else {
                reader.close();
                unit = Unit.f32013a;
            }
            if (unit == null) {
                this.f32889a.close();
            }
        }

        public int read(char[] cArr, int i10, int i11) throws IOException {
            j.g(cArr, "cbuf");
            if (!this.f32891c) {
                Reader reader = this.f32892d;
                if (reader == null) {
                    reader = new InputStreamReader(this.f32889a.Z1(), d.I(this.f32889a, this.f32890b));
                    this.f32892d = reader;
                }
                return reader.read(cArr, i10, i11);
            }
            throw new IOException("Stream closed");
        }
    }

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0011\u001a\u00020\u0005*\u00020\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0007J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0007J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\"\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000eH\u0007¨\u0006\u001a"}, d2 = {"Lokhttp3/b0$b;", "", "", "Lokhttp3/v;", "contentType", "Lokhttp3/b0;", "a", "(Ljava/lang/String;Lokhttp3/v;)Lokhttp3/b0;", "", "h", "([BLokhttp3/v;)Lokhttp3/b0;", "Lokio/ByteString;", "g", "(Lokio/ByteString;Lokhttp3/v;)Lokhttp3/b0;", "Lokio/BufferedSource;", "", "contentLength", "f", "(Lokio/BufferedSource;Lokhttp3/v;J)Lokhttp3/b0;", "content", "c", "e", "d", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"okhttp3/b0$b$a", "Lokhttp3/b0;", "Lokhttp3/v;", "contentType", "", "contentLength", "Lokio/BufferedSource;", "source", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends b0 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ v f32893a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f32894b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BufferedSource f32895c;

            a(v vVar, long j10, BufferedSource bufferedSource) {
                this.f32893a = vVar;
                this.f32894b = j10;
                this.f32895c = bufferedSource;
            }

            public long contentLength() {
                return this.f32894b;
            }

            public v contentType() {
                return this.f32893a;
            }

            public BufferedSource source() {
                return this.f32895c;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ b0 i(b bVar, byte[] bArr, v vVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                vVar = null;
            }
            return bVar.h(bArr, vVar);
        }

        public final b0 a(String str, v vVar) {
            j.g(str, "<this>");
            Charset charset = kotlin.text.d.f32216b;
            if (vVar != null) {
                Charset d10 = v.d(vVar, (Charset) null, 1, (Object) null);
                if (d10 == null) {
                    v.a aVar = v.f33190e;
                    vVar = aVar.b(vVar + "; charset=utf-8");
                } else {
                    charset = d10;
                }
            }
            Buffer u02 = new Buffer().u0(str, charset);
            return f(u02, vVar, u02.size());
        }

        public final b0 b(v vVar, long j10, BufferedSource bufferedSource) {
            j.g(bufferedSource, "content");
            return f(bufferedSource, vVar, j10);
        }

        public final b0 c(v vVar, String str) {
            j.g(str, "content");
            return a(str, vVar);
        }

        public final b0 d(v vVar, ByteString byteString) {
            j.g(byteString, "content");
            return g(byteString, vVar);
        }

        public final b0 e(v vVar, byte[] bArr) {
            j.g(bArr, "content");
            return h(bArr, vVar);
        }

        public final b0 f(BufferedSource bufferedSource, v vVar, long j10) {
            j.g(bufferedSource, "<this>");
            return new a(vVar, j10, bufferedSource);
        }

        public final b0 g(ByteString byteString, v vVar) {
            j.g(byteString, "<this>");
            return f(new Buffer().K1(byteString), vVar, (long) byteString.H());
        }

        public final b0 h(byte[] bArr, v vVar) {
            j.g(bArr, "<this>");
            return f(new Buffer().write(bArr), vVar, (long) bArr.length);
        }
    }

    private final Charset charset() {
        v contentType = contentType();
        Charset c10 = contentType == null ? null : contentType.c(kotlin.text.d.f32216b);
        return c10 == null ? kotlin.text.d.f32216b : c10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        kotlin.jvm.internal.h.b(1);
        kotlin.io.b.a(r2, r6);
        kotlin.jvm.internal.h.a(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T consumeSource(kotlin.jvm.functions.Function1<? super okio.BufferedSource, ? extends T> r6, kotlin.jvm.functions.Function1<? super T, java.lang.Integer> r7) {
        /*
            r5 = this;
            long r0 = r5.contentLength()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0066
            okio.BufferedSource r2 = r5.source()
            r3 = 0
            r4 = 1
            java.lang.Object r6 = r6.invoke(r2)     // Catch:{ all -> 0x0059 }
            kotlin.jvm.internal.h.b(r4)
            kotlin.io.b.a(r2, r3)
            kotlin.jvm.internal.h.a(r4)
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0058
            long r2 = (long) r7
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0034
            goto L_0x0058
        L_0x0034:
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Content-Length ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") and stream length ("
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = ") disagree"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r6.<init>(r7)
            throw r6
        L_0x0058:
            return r6
        L_0x0059:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005b }
        L_0x005b:
            r7 = move-exception
            kotlin.jvm.internal.h.b(r4)
            kotlin.io.b.a(r2, r6)
            kotlin.jvm.internal.h.a(r4)
            throw r7
        L_0x0066:
            java.io.IOException r6 = new java.io.IOException
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "Cannot buffer entire body for content length: "
            java.lang.String r7 = kotlin.jvm.internal.j.p(r0, r7)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.b0.consumeSource(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final b0 create(String str, v vVar) {
        return Companion.a(str, vVar);
    }

    public static final b0 create(v vVar, long j10, BufferedSource bufferedSource) {
        return Companion.b(vVar, j10, bufferedSource);
    }

    public static final b0 create(v vVar, String str) {
        return Companion.c(vVar, str);
    }

    public static final b0 create(v vVar, ByteString byteString) {
        return Companion.d(vVar, byteString);
    }

    public static final b0 create(v vVar, byte[] bArr) {
        return Companion.e(vVar, bArr);
    }

    public static final b0 create(BufferedSource bufferedSource, v vVar, long j10) {
        return Companion.f(bufferedSource, vVar, j10);
    }

    public static final b0 create(ByteString byteString, v vVar) {
        return Companion.g(byteString, vVar);
    }

    public static final b0 create(byte[] bArr, v vVar) {
        return Companion.h(bArr, vVar);
    }

    public final InputStream byteStream() {
        return source().Z1();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        kotlin.io.b.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okio.ByteString byteString() throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.contentLength()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0053
            okio.BufferedSource r2 = r7.source()
            r3 = 0
            okio.ByteString r4 = r2.y1()     // Catch:{ all -> 0x004c }
            kotlin.io.b.a(r2, r3)
            int r2 = r4.H()
            r5 = -1
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x004b
            long r5 = (long) r2
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0027
            goto L_0x004b
        L_0x0027:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Length ("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ") and stream length ("
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ") disagree"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x004b:
            return r4
        L_0x004c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            kotlin.io.b.a(r2, r0)
            throw r1
        L_0x0053:
            java.io.IOException r2 = new java.io.IOException
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "Cannot buffer entire body for content length: "
            java.lang.String r0 = kotlin.jvm.internal.j.p(r1, r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.b0.byteString():okio.ByteString");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        kotlin.io.b.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] bytes() throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.contentLength()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0050
            okio.BufferedSource r2 = r7.source()
            r3 = 0
            byte[] r4 = r2.V0()     // Catch:{ all -> 0x0049 }
            kotlin.io.b.a(r2, r3)
            int r2 = r4.length
            r5 = -1
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0048
            long r5 = (long) r2
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0024
            goto L_0x0048
        L_0x0024:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Length ("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ") and stream length ("
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ") disagree"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x0048:
            return r4
        L_0x0049:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004b:
            r1 = move-exception
            kotlin.io.b.a(r2, r0)
            throw r1
        L_0x0050:
            java.io.IOException r2 = new java.io.IOException
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "Cannot buffer entire body for content length: "
            java.lang.String r0 = kotlin.jvm.internal.j.p(r1, r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.b0.bytes():byte[]");
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    public void close() {
        d.m(source());
    }

    public abstract long contentLength();

    public abstract v contentType();

    public abstract BufferedSource source();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String string() throws java.io.IOException {
        /*
            r3 = this;
            okio.BufferedSource r0 = r3.source()
            java.nio.charset.Charset r1 = r3.charset()     // Catch:{ all -> 0x0015 }
            java.nio.charset.Charset r1 = bl.d.I(r0, r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r0.s1(r1)     // Catch:{ all -> 0x0015 }
            r2 = 0
            kotlin.io.b.a(r0, r2)
            return r1
        L_0x0015:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.b0.string():java.lang.String");
    }
}
