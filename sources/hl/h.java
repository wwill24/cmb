package hl;

import bl.d;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.google.android.gms.common.api.a;
import hl.b;
import java.io.Closeable;
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
import okio.BufferedSink;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u00102\u001a\u000200\u0012\u0006\u00104\u001a\u00020\u0016¢\u0006\u0004\b@\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0002J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0002J(\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002J\u001e\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%J\u0016\u0010)\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0004J&\u0010,\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002J\b\u0010-\u001a\u00020\u0006H\u0016J$\u0010/\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u00102\u001a\u0002008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u00101R\u0014\u00104\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u00103R\u0014\u00106\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00105R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u00103R\u0017\u0010?\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lhl/h;", "Ljava/io/Closeable;", "", "streamId", "", "byteCount", "", "x", "b", "Lhl/k;", "peerSettings", "a", "promisedStreamId", "", "Lhl/a;", "requestHeaders", "m", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "n", "k", "", "outFinished", "Lokio/Buffer;", "source", "c", "flags", "buffer", "e", "settings", "u", "ack", "payload1", "payload2", "l", "lastGoodStreamId", "", "debugData", "g", "windowSizeIncrement", "v", "length", "type", "f", "close", "headerBlock", "h", "Lokio/BufferedSink;", "Lokio/BufferedSink;", "sink", "Z", "client", "Lokio/Buffer;", "hpackBuffer", "d", "I", "maxFrameSize", "closed", "Lhl/b$b;", "Lhl/b$b;", "getHpackWriter", "()Lhl/b$b;", "hpackWriter", "<init>", "(Lokio/BufferedSink;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    public static final a f29925g = new a((DefaultConstructorMarker) null);

    /* renamed from: h  reason: collision with root package name */
    private static final Logger f29926h = Logger.getLogger(c.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f29927a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29928b;

    /* renamed from: c  reason: collision with root package name */
    private final Buffer f29929c;

    /* renamed from: d  reason: collision with root package name */
    private int f29930d = Opcodes.ACC_ENUM;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29931e;

    /* renamed from: f  reason: collision with root package name */
    private final b.C0346b f29932f;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lhl/h$a;", "", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(BufferedSink bufferedSink, boolean z10) {
        j.g(bufferedSink, "sink");
        this.f29927a = bufferedSink;
        this.f29928b = z10;
        Buffer buffer = new Buffer();
        this.f29929c = buffer;
        this.f29932f = new b.C0346b(0, false, buffer, 3, (DefaultConstructorMarker) null);
    }

    private final void x(int i10, long j10) throws IOException {
        int i11;
        while (j10 > 0) {
            long min = Math.min((long) this.f29930d, j10);
            j10 -= min;
            int i12 = (int) min;
            if (j10 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            f(i10, i12, 9, i11);
            this.f29927a.k0(this.f29929c, min);
        }
    }

    public final synchronized void a(k kVar) throws IOException {
        j.g(kVar, "peerSettings");
        if (!this.f29931e) {
            this.f29930d = kVar.e(this.f29930d);
            if (kVar.b() != -1) {
                this.f29932f.e(kVar.b());
            }
            f(0, 0, 4, 1);
            this.f29927a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void b() throws IOException {
        if (this.f29931e) {
            throw new IOException("closed");
        } else if (this.f29928b) {
            Logger logger = f29926h;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(d.t(j.p(">> CONNECTION ", c.f29782b.p()), new Object[0]));
            }
            this.f29927a.K1(c.f29782b);
            this.f29927a.flush();
        }
    }

    public final synchronized void c(boolean z10, int i10, Buffer buffer, int i11) throws IOException {
        if (!this.f29931e) {
            e(i10, z10 ? 1 : 0, buffer, i11);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() throws IOException {
        this.f29931e = true;
        this.f29927a.close();
    }

    public final void e(int i10, int i11, Buffer buffer, int i12) throws IOException {
        f(i10, i12, 0, i11);
        if (i12 > 0) {
            BufferedSink bufferedSink = this.f29927a;
            j.d(buffer);
            bufferedSink.k0(buffer, (long) i12);
        }
    }

    public final void f(int i10, int i11, int i12, int i13) throws IOException {
        boolean z10;
        Logger logger = f29926h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.f29781a.c(false, i10, i11, i12, i13));
        }
        boolean z11 = true;
        if (i11 <= this.f29930d) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if ((Integer.MIN_VALUE & i10) != 0) {
                z11 = false;
            }
            if (z11) {
                d.Z(this.f29927a, i11);
                this.f29927a.writeByte(i12 & 255);
                this.f29927a.writeByte(i13 & 255);
                this.f29927a.writeInt(i10 & a.e.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException(j.p("reserved bit set: ", Integer.valueOf(i10)).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f29930d + ": " + i11).toString());
    }

    public final synchronized void flush() throws IOException {
        if (!this.f29931e) {
            this.f29927a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void g(int i10, ErrorCode errorCode, byte[] bArr) throws IOException {
        boolean z10;
        j.g(errorCode, "errorCode");
        j.g(bArr, "debugData");
        if (!this.f29931e) {
            boolean z11 = false;
            if (errorCode.b() != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                f(0, bArr.length + 8, 7, 0);
                this.f29927a.writeInt(i10);
                this.f29927a.writeInt(errorCode.b());
                if (bArr.length == 0) {
                    z11 = true;
                }
                if (!z11) {
                    this.f29927a.write(bArr);
                }
                this.f29927a.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void h(boolean z10, int i10, List<a> list) throws IOException {
        int i11;
        j.g(list, "headerBlock");
        if (!this.f29931e) {
            this.f29932f.g(list);
            long size = this.f29929c.size();
            long min = Math.min((long) this.f29930d, size);
            int i12 = (size > min ? 1 : (size == min ? 0 : -1));
            if (i12 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            if (z10) {
                i11 |= 1;
            }
            f(i10, (int) min, 1, i11);
            this.f29927a.k0(this.f29929c, min);
            if (i12 > 0) {
                x(i10, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int k() {
        return this.f29930d;
    }

    public final synchronized void l(boolean z10, int i10, int i11) throws IOException {
        int i12;
        if (!this.f29931e) {
            if (z10) {
                i12 = 1;
            } else {
                i12 = 0;
            }
            f(0, 8, 6, i12);
            this.f29927a.writeInt(i10);
            this.f29927a.writeInt(i11);
            this.f29927a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void m(int i10, int i11, List<a> list) throws IOException {
        int i12;
        j.g(list, "requestHeaders");
        if (!this.f29931e) {
            this.f29932f.g(list);
            long size = this.f29929c.size();
            int min = (int) Math.min(((long) this.f29930d) - 4, size);
            int i13 = min + 4;
            long j10 = (long) min;
            int i14 = (size > j10 ? 1 : (size == j10 ? 0 : -1));
            if (i14 == 0) {
                i12 = 4;
            } else {
                i12 = 0;
            }
            f(i10, i13, 5, i12);
            this.f29927a.writeInt(i11 & a.e.API_PRIORITY_OTHER);
            this.f29927a.k0(this.f29929c, j10);
            if (i14 > 0) {
                x(i10, size - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void n(int i10, ErrorCode errorCode) throws IOException {
        boolean z10;
        j.g(errorCode, "errorCode");
        if (!this.f29931e) {
            if (errorCode.b() != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                f(i10, 4, 3, 0);
                this.f29927a.writeInt(errorCode.b());
                this.f29927a.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void u(k kVar) throws IOException {
        int i10;
        j.g(kVar, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        if (!this.f29931e) {
            int i11 = 0;
            f(0, kVar.i() * 6, 4, 0);
            while (i11 < 10) {
                int i12 = i11 + 1;
                if (kVar.f(i11)) {
                    if (i11 == 4) {
                        i10 = 3;
                    } else if (i11 != 7) {
                        i10 = i11;
                    } else {
                        i10 = 4;
                    }
                    this.f29927a.writeShort(i10);
                    this.f29927a.writeInt(kVar.a(i11));
                }
                i11 = i12;
            }
            this.f29927a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void v(int i10, long j10) throws IOException {
        boolean z10;
        if (!this.f29931e) {
            if (j10 == 0 || j10 > 2147483647L) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                f(i10, 4, 8, 0);
                this.f29927a.writeInt((int) j10);
                this.f29927a.flush();
            } else {
                throw new IllegalArgumentException(j.p("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j10)).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }
}
