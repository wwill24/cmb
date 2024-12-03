package hl;

import bl.d;
import com.google.android.gms.common.api.a;
import hl.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0003\u001d\u001a\u0017B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u0018¢\u0006\u0004\b)\u0010*J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lhl/f;", "Ljava/io/Closeable;", "Lhl/f$c;", "handler", "", "length", "flags", "streamId", "", "h", "padding", "", "Lhl/a;", "g", "e", "m", "l", "u", "v", "n", "k", "f", "x", "c", "", "requireSettings", "b", "close", "Lokio/BufferedSource;", "a", "Lokio/BufferedSource;", "source", "Z", "client", "Lhl/f$b;", "Lhl/f$b;", "continuation", "Lhl/b$a;", "d", "Lhl/b$a;", "hpackReader", "<init>", "(Lokio/BufferedSource;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public static final a f29885e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f29886f;

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f29887a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29888b;

    /* renamed from: c  reason: collision with root package name */
    private final b f29889c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a f29890d;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lhl/f$a;", "", "", "length", "flags", "padding", "b", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return f.f29886f;
        }

        public final int b(int i10, int i11, int i12) throws IOException {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i12 + " > remaining length " + i10);
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\r\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006%"}, d2 = {"Lhl/f$b;", "Lokio/Source;", "", "b", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Lokio/Timeout;", "p", "close", "Lokio/BufferedSource;", "a", "Lokio/BufferedSource;", "source", "", "I", "getLength", "()I", "f", "(I)V", "length", "c", "getFlags", "flags", "d", "getStreamId", "h", "streamId", "e", "left", "getPadding", "g", "padding", "<init>", "(Lokio/BufferedSource;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b implements Source {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedSource f29891a;

        /* renamed from: b  reason: collision with root package name */
        private int f29892b;

        /* renamed from: c  reason: collision with root package name */
        private int f29893c;

        /* renamed from: d  reason: collision with root package name */
        private int f29894d;

        /* renamed from: e  reason: collision with root package name */
        private int f29895e;

        /* renamed from: f  reason: collision with root package name */
        private int f29896f;

        public b(BufferedSource bufferedSource) {
            j.g(bufferedSource, "source");
            this.f29891a = bufferedSource;
        }

        private final void b() throws IOException {
            int i10 = this.f29894d;
            int J = d.J(this.f29891a);
            this.f29895e = J;
            this.f29892b = J;
            int d10 = d.d(this.f29891a.readByte(), 255);
            this.f29893c = d.d(this.f29891a.readByte(), 255);
            a aVar = f.f29885e;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(c.f29781a.c(true, this.f29894d, this.f29892b, d10, this.f29893c));
            }
            int readInt = this.f29891a.readInt() & a.e.API_PRIORITY_OTHER;
            this.f29894d = readInt;
            if (d10 != 9) {
                throw new IOException(d10 + " != TYPE_CONTINUATION");
            } else if (readInt != i10) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public long N1(Buffer buffer, long j10) throws IOException {
            j.g(buffer, "sink");
            while (true) {
                int i10 = this.f29895e;
                if (i10 == 0) {
                    this.f29891a.skip((long) this.f29896f);
                    this.f29896f = 0;
                    if ((this.f29893c & 4) != 0) {
                        return -1;
                    }
                    b();
                } else {
                    long N1 = this.f29891a.N1(buffer, Math.min(j10, (long) i10));
                    if (N1 == -1) {
                        return -1;
                    }
                    this.f29895e -= (int) N1;
                    return N1;
                }
            }
        }

        public final int a() {
            return this.f29895e;
        }

        public final void c(int i10) {
            this.f29893c = i10;
        }

        public void close() throws IOException {
        }

        public final void e(int i10) {
            this.f29895e = i10;
        }

        public final void f(int i10) {
            this.f29892b = i10;
        }

        public final void g(int i10) {
            this.f29896f = i10;
        }

        public final void h(int i10) {
            this.f29894d = i10;
        }

        public Timeout p() {
            return this.f29891a.p();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\tH&J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H&J \u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J(\u0010&\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H&J&\u0010)\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006*"}, d2 = {"Lhl/f$c;", "", "", "inFinished", "", "streamId", "Lokio/BufferedSource;", "source", "length", "", "h", "associatedStreamId", "", "Lhl/a;", "headerBlock", "a", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "k", "clearPrevious", "Lhl/k;", "settings", "c", "f", "ack", "payload1", "payload2", "i", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "m", "", "windowSizeIncrement", "d", "streamDependency", "weight", "exclusive", "j", "promisedStreamId", "requestHeaders", "e", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface c {
        void a(boolean z10, int i10, int i11, List<a> list);

        void c(boolean z10, k kVar);

        void d(int i10, long j10);

        void e(int i10, int i11, List<a> list) throws IOException;

        void f();

        void h(boolean z10, int i10, BufferedSource bufferedSource, int i11) throws IOException;

        void i(boolean z10, int i10, int i11);

        void j(int i10, int i11, int i12, boolean z10);

        void k(int i10, ErrorCode errorCode);

        void m(int i10, ErrorCode errorCode, ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(c.class.getName());
        j.f(logger, "getLogger(Http2::class.java.name)");
        f29886f = logger;
    }

    public f(BufferedSource bufferedSource, boolean z10) {
        j.g(bufferedSource, "source");
        this.f29887a = bufferedSource;
        this.f29888b = z10;
        b bVar = new b(bufferedSource);
        this.f29889c = bVar;
        this.f29890d = new b.a(bVar, Opcodes.ACC_SYNTHETIC, 0, 4, (DefaultConstructorMarker) null);
    }

    private final void e(c cVar, int i10, int i11, int i12) throws IOException {
        boolean z10;
        if (i12 != 0) {
            int i13 = 0;
            boolean z11 = true;
            if ((i11 & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((i11 & 32) == 0) {
                z11 = false;
            }
            if (!z11) {
                if ((i11 & 8) != 0) {
                    i13 = d.d(this.f29887a.readByte(), 255);
                }
                cVar.h(z10, i12, this.f29887a, f29885e.b(i10, i11, i13));
                this.f29887a.skip((long) i13);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void f(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 < 8) {
            throw new IOException(j.p("TYPE_GOAWAY length < 8: ", Integer.valueOf(i10)));
        } else if (i12 == 0) {
            int readInt = this.f29887a.readInt();
            int readInt2 = this.f29887a.readInt();
            int i13 = i10 - 8;
            ErrorCode a10 = ErrorCode.f33089a.a(readInt2);
            if (a10 != null) {
                ByteString byteString = ByteString.f33309d;
                if (i13 > 0) {
                    byteString = this.f29887a.O0((long) i13);
                }
                cVar.m(readInt, a10, byteString);
                return;
            }
            throw new IOException(j.p("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(readInt2)));
        } else {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
    }

    private final List<a> g(int i10, int i11, int i12, int i13) throws IOException {
        this.f29889c.e(i10);
        b bVar = this.f29889c;
        bVar.f(bVar.a());
        this.f29889c.g(i11);
        this.f29889c.c(i12);
        this.f29889c.h(i13);
        this.f29890d.k();
        return this.f29890d.e();
    }

    private final void h(c cVar, int i10, int i11, int i12) throws IOException {
        boolean z10;
        if (i12 != 0) {
            int i13 = 0;
            if ((i11 & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((i11 & 8) != 0) {
                i13 = d.d(this.f29887a.readByte(), 255);
            }
            if ((i11 & 32) != 0) {
                l(cVar, i12);
                i10 -= 5;
            }
            cVar.a(z10, i12, -1, g(f29885e.b(i10, i11, i13), i13, i11, i12));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void k(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 8) {
            throw new IOException(j.p("TYPE_PING length != 8: ", Integer.valueOf(i10)));
        } else if (i12 == 0) {
            int readInt = this.f29887a.readInt();
            int readInt2 = this.f29887a.readInt();
            boolean z10 = true;
            if ((i11 & 1) == 0) {
                z10 = false;
            }
            cVar.i(z10, readInt, readInt2);
        } else {
            throw new IOException("TYPE_PING streamId != 0");
        }
    }

    private final void l(c cVar, int i10) throws IOException {
        boolean z10;
        int readInt = this.f29887a.readInt();
        if ((Integer.MIN_VALUE & readInt) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.j(i10, readInt & a.e.API_PRIORITY_OTHER, d.d(this.f29887a.readByte(), 255) + 1, z10);
    }

    private final void m(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 5) {
            throw new IOException("TYPE_PRIORITY length: " + i10 + " != 5");
        } else if (i12 != 0) {
            l(cVar, i12);
        } else {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
    }

    private final void n(c cVar, int i10, int i11, int i12) throws IOException {
        int i13;
        if (i12 != 0) {
            if ((i11 & 8) != 0) {
                i13 = d.d(this.f29887a.readByte(), 255);
            } else {
                i13 = 0;
            }
            cVar.e(i12, this.f29887a.readInt() & a.e.API_PRIORITY_OTHER, g(f29885e.b(i10 - 4, i11, i13), i13, i11, i12));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void u(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i10 + " != 4");
        } else if (i12 != 0) {
            int readInt = this.f29887a.readInt();
            ErrorCode a10 = ErrorCode.f33089a.a(readInt);
            if (a10 != null) {
                cVar.k(i12, a10);
                return;
            }
            throw new IOException(j.p("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(readInt)));
        } else {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
    }

    private final void v(c cVar, int i10, int i11, int i12) throws IOException {
        int readInt;
        if (i12 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        } else if ((i11 & 1) != 0) {
            if (i10 == 0) {
                cVar.f();
                return;
            }
            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
        } else if (i10 % 6 == 0) {
            k kVar = new k();
            kotlin.ranges.a n10 = j.n(j.o(0, i10), 6);
            int b10 = n10.b();
            int d10 = n10.d();
            int f10 = n10.f();
            if ((f10 > 0 && b10 <= d10) || (f10 < 0 && d10 <= b10)) {
                while (true) {
                    int i13 = b10 + f10;
                    int e10 = d.e(this.f29887a.readShort(), 65535);
                    readInt = this.f29887a.readInt();
                    if (e10 != 2) {
                        if (e10 == 3) {
                            e10 = 4;
                        } else if (e10 == 4) {
                            e10 = 7;
                            if (readInt < 0) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                            }
                        } else if (e10 == 5 && (readInt < 16384 || readInt > 16777215)) {
                        }
                    } else if (!(readInt == 0 || readInt == 1)) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    }
                    kVar.h(e10, readInt);
                    if (b10 == d10) {
                        break;
                    }
                    b10 = i13;
                }
                throw new IOException(j.p("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(readInt)));
            }
            cVar.c(false, kVar);
        } else {
            throw new IOException(j.p("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i10)));
        }
    }

    private final void x(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 == 4) {
            long f10 = d.f(this.f29887a.readInt(), 2147483647L);
            if (f10 != 0) {
                cVar.d(i12, f10);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException(j.p("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i10)));
    }

    public final boolean b(boolean z10, c cVar) throws IOException {
        j.g(cVar, "handler");
        try {
            this.f29887a.G0(9);
            int J = d.J(this.f29887a);
            if (J <= 16384) {
                int d10 = d.d(this.f29887a.readByte(), 255);
                int d11 = d.d(this.f29887a.readByte(), 255);
                int readInt = this.f29887a.readInt() & a.e.API_PRIORITY_OTHER;
                Logger logger = f29886f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(c.f29781a.c(true, readInt, J, d10, d11));
                }
                if (!z10 || d10 == 4) {
                    switch (d10) {
                        case 0:
                            e(cVar, J, d11, readInt);
                            return true;
                        case 1:
                            h(cVar, J, d11, readInt);
                            return true;
                        case 2:
                            m(cVar, J, d11, readInt);
                            return true;
                        case 3:
                            u(cVar, J, d11, readInt);
                            return true;
                        case 4:
                            v(cVar, J, d11, readInt);
                            return true;
                        case 5:
                            n(cVar, J, d11, readInt);
                            return true;
                        case 6:
                            k(cVar, J, d11, readInt);
                            return true;
                        case 7:
                            f(cVar, J, d11, readInt);
                            return true;
                        case 8:
                            x(cVar, J, d11, readInt);
                            return true;
                        default:
                            this.f29887a.skip((long) J);
                            return true;
                    }
                } else {
                    throw new IOException(j.p("Expected a SETTINGS frame but was ", c.f29781a.b(d10)));
                }
            } else {
                throw new IOException(j.p("FRAME_SIZE_ERROR: ", Integer.valueOf(J)));
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void c(c cVar) throws IOException {
        j.g(cVar, "handler");
        if (!this.f29888b) {
            BufferedSource bufferedSource = this.f29887a;
            ByteString byteString = c.f29782b;
            ByteString O0 = bufferedSource.O0((long) byteString.H());
            Logger logger = f29886f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(d.t(j.p("<< CONNECTION ", O0.p()), new Object[0]));
            }
            if (!j.b(byteString, O0)) {
                throw new IOException(j.p("Expected a connection header but was ", O0.Q()));
            }
        } else if (!b(true, cVar)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }

    public void close() throws IOException {
        this.f29887a.close();
    }
}
