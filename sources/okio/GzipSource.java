package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0001¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010$¨\u0006("}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "", "b", "c", "Lokio/Buffer;", "buffer", "", "offset", "byteCount", "e", "", "name", "", "expected", "actual", "a", "sink", "N1", "Lokio/Timeout;", "p", "close", "", "B", "section", "Lokio/RealBufferedSource;", "Lokio/RealBufferedSource;", "source", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "Lokio/InflaterSource;", "d", "Lokio/InflaterSource;", "inflaterSource", "Ljava/util/zip/CRC32;", "Ljava/util/zip/CRC32;", "crc", "<init>", "(Lokio/Source;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class GzipSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private byte f33355a;

    /* renamed from: b  reason: collision with root package name */
    private final RealBufferedSource f33356b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f33357c;

    /* renamed from: d  reason: collision with root package name */
    private final InflaterSource f33358d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f33359e = new CRC32();

    public GzipSource(Source source) {
        j.g(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.f33356b = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f33357c = inflater;
        this.f33358d = new InflaterSource((BufferedSource) realBufferedSource, inflater);
    }

    private final void a(String str, int i10, int i11) {
        if (i11 != i10) {
            String format2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
            j.f(format2, "format(this, *args)");
            throw new IOException(format2);
        }
    }

    private final void b() throws IOException {
        boolean z10;
        boolean z11;
        boolean z12;
        this.f33356b.G0(10);
        byte l10 = this.f33356b.f33404b.l(3);
        boolean z13 = true;
        if (((l10 >> 1) & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            e(this.f33356b.f33404b, 0, 10);
        }
        a("ID1ID2", 8075, this.f33356b.readShort());
        this.f33356b.skip(8);
        if (((l10 >> 2) & 1) == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.f33356b.G0(2);
            if (z10) {
                e(this.f33356b.f33404b, 0, 2);
            }
            long C0 = (long) this.f33356b.f33404b.C0();
            this.f33356b.G0(C0);
            if (z10) {
                e(this.f33356b.f33404b, 0, C0);
            }
            this.f33356b.skip(C0);
        }
        if (((l10 >> 3) & 1) == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            long a10 = this.f33356b.a((byte) 0);
            if (a10 != -1) {
                if (z10) {
                    e(this.f33356b.f33404b, 0, a10 + 1);
                }
                this.f33356b.skip(a10 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((l10 >> 4) & 1) != 1) {
            z13 = false;
        }
        if (z13) {
            long a11 = this.f33356b.a((byte) 0);
            if (a11 != -1) {
                if (z10) {
                    e(this.f33356b.f33404b, 0, a11 + 1);
                }
                this.f33356b.skip(a11 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z10) {
            a("FHCRC", this.f33356b.C0(), (short) ((int) this.f33359e.getValue()));
            this.f33359e.reset();
        }
    }

    private final void c() throws IOException {
        a("CRC", this.f33356b.D1(), (int) this.f33359e.getValue());
        a("ISIZE", this.f33356b.D1(), (int) this.f33357c.getBytesWritten());
    }

    private final void e(Buffer buffer, long j10, long j11) {
        Segment segment = buffer.f33298a;
        j.d(segment);
        while (true) {
            int i10 = segment.f33410c;
            int i11 = segment.f33409b;
            if (j10 < ((long) (i10 - i11))) {
                break;
            }
            j10 -= (long) (i10 - i11);
            segment = segment.f33413f;
            j.d(segment);
        }
        while (j11 > 0) {
            int i12 = (int) (((long) segment.f33409b) + j10);
            int min = (int) Math.min((long) (segment.f33410c - i12), j11);
            this.f33359e.update(segment.f33408a, i12, min);
            j11 -= (long) min;
            segment = segment.f33413f;
            j.d(segment);
            j10 = 0;
        }
    }

    public long N1(Buffer buffer, long j10) throws IOException {
        boolean z10;
        j.g(buffer, "sink");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            if (this.f33355a == 0) {
                b();
                this.f33355a = 1;
            }
            if (this.f33355a == 1) {
                long size = buffer.size();
                long N1 = this.f33358d.N1(buffer, j10);
                if (N1 != -1) {
                    e(buffer, size, N1);
                    return N1;
                }
                this.f33355a = 2;
            }
            if (this.f33355a == 2) {
                c();
                this.f33355a = 3;
                if (!this.f33356b.Y0()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public void close() throws IOException {
        this.f33358d.close();
    }

    public Timeout p() {
        return this.f33356b.p();
    }
}
