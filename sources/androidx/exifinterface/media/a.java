package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.location.Location;
import android.media.MediaDataSource;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.b;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.a;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.AppsFlyerKit;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.util.StringUtils;

public class a {
    public static final int[] A = {8};
    static final byte[] B = {-1, -40, -1};
    private static final byte[] C = {102, 116, 121, 112};
    private static final byte[] D = {109, 105, 102, Framer.STDOUT_FRAME_PREFIX};
    private static final byte[] E = {104, 101, 105, 99};
    private static final byte[] F = {79, 76, 89, 77, 80, 0};
    private static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] H = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] I = {101, 88, 73, 102};
    private static final byte[] J = {73, 72, 68, 82};
    private static final byte[] K = {73, 69, 78, 68};
    private static final byte[] L = {82, 73, 70, 70};
    private static final byte[] M = {87, 69, 66, 80};
    private static final byte[] N = {69, 88, 73, 70};
    private static final byte[] O = {-99, 1, 42};
    private static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    static final String[] W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final e[] Z;

    /* renamed from: a0  reason: collision with root package name */
    private static final e[] f5502a0;

    /* renamed from: b0  reason: collision with root package name */
    private static final e[] f5503b0;

    /* renamed from: c0  reason: collision with root package name */
    private static final e[] f5504c0;

    /* renamed from: d0  reason: collision with root package name */
    private static final e[] f5505d0;

    /* renamed from: e0  reason: collision with root package name */
    private static final e f5506e0 = new e("StripOffsets", 273, 3);

    /* renamed from: f0  reason: collision with root package name */
    private static final e[] f5507f0;

    /* renamed from: g0  reason: collision with root package name */
    private static final e[] f5508g0;

    /* renamed from: h0  reason: collision with root package name */
    private static final e[] f5509h0;

    /* renamed from: i0  reason: collision with root package name */
    private static final e[] f5510i0;

    /* renamed from: j0  reason: collision with root package name */
    static final e[][] f5511j0;

    /* renamed from: k0  reason: collision with root package name */
    private static final e[] f5512k0 = {new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: l0  reason: collision with root package name */
    private static final HashMap<Integer, e>[] f5513l0;

    /* renamed from: m0  reason: collision with root package name */
    private static final HashMap<String, e>[] f5514m0;

    /* renamed from: n0  reason: collision with root package name */
    private static final HashSet<String> f5515n0 = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: o0  reason: collision with root package name */
    private static final HashMap<Integer, Integer> f5516o0 = new HashMap<>();

    /* renamed from: p0  reason: collision with root package name */
    static final Charset f5517p0;

    /* renamed from: q0  reason: collision with root package name */
    static final byte[] f5518q0;

    /* renamed from: r0  reason: collision with root package name */
    private static final byte[] f5519r0;

    /* renamed from: s0  reason: collision with root package name */
    private static final Pattern f5520s0 = Pattern.compile(".*[1-9].*");

    /* renamed from: t0  reason: collision with root package name */
    private static final Pattern f5521t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: u0  reason: collision with root package name */
    private static final Pattern f5522u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f5523v = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v0  reason: collision with root package name */
    private static final Pattern f5524v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: w  reason: collision with root package name */
    private static final List<Integer> f5525w = Arrays.asList(new Integer[]{1, 6, 3, 8});

    /* renamed from: x  reason: collision with root package name */
    private static final List<Integer> f5526x = Arrays.asList(new Integer[]{2, 7, 4, 5});

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f5527y = {8, 8, 8};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f5528z = {4};

    /* renamed from: a  reason: collision with root package name */
    private String f5529a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f5530b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f5531c;

    /* renamed from: d  reason: collision with root package name */
    private int f5532d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5533e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, d>[] f5534f;

    /* renamed from: g  reason: collision with root package name */
    private Set<Integer> f5535g;

    /* renamed from: h  reason: collision with root package name */
    private ByteOrder f5536h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5537i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5538j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5539k;

    /* renamed from: l  reason: collision with root package name */
    private int f5540l;

    /* renamed from: m  reason: collision with root package name */
    private int f5541m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f5542n;

    /* renamed from: o  reason: collision with root package name */
    private int f5543o;

    /* renamed from: p  reason: collision with root package name */
    private int f5544p;

    /* renamed from: q  reason: collision with root package name */
    private int f5545q;

    /* renamed from: r  reason: collision with root package name */
    private int f5546r;

    /* renamed from: s  reason: collision with root package name */
    private int f5547s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f5548t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f5549u;

    /* renamed from: androidx.exifinterface.media.a$a  reason: collision with other inner class name */
    class C0056a extends MediaDataSource {

        /* renamed from: a  reason: collision with root package name */
        long f5550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f5551b;

        C0056a(g gVar) {
            this.f5551b = gVar;
        }

        public void close() throws IOException {
        }

        public long getSize() throws IOException {
            return -1;
        }

        public int readAt(long j10, byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f5550a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + ((long) this.f5551b.available())) {
                        return -1;
                    }
                    this.f5551b.f(j10);
                    this.f5550a = j10;
                }
                if (i11 > this.f5551b.available()) {
                    i11 = this.f5551b.available();
                }
                int read = this.f5551b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f5550a += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f5550a = -1;
            return -1;
        }
    }

    private static class b extends InputStream implements DataInput {

        /* renamed from: e  reason: collision with root package name */
        private static final ByteOrder f5553e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f  reason: collision with root package name */
        private static final ByteOrder f5554f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        final DataInputStream f5555a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f5556b;

        /* renamed from: c  reason: collision with root package name */
        int f5557c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f5558d;

        b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f5557c;
        }

        public int available() throws IOException {
            return this.f5555a.available();
        }

        public long b() throws IOException {
            return ((long) readInt()) & UInt32.MAX_VALUE_LONG;
        }

        public void c(ByteOrder byteOrder) {
            this.f5556b = byteOrder;
        }

        public void e(int i10) throws IOException {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f5555a.skip((long) i12);
                if (skip <= 0) {
                    if (this.f5558d == null) {
                        this.f5558d = new byte[8192];
                    }
                    skip = this.f5555a.read(this.f5558d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f5557c += i11;
        }

        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() throws IOException {
            this.f5557c++;
            return this.f5555a.read();
        }

        public boolean readBoolean() throws IOException {
            this.f5557c++;
            return this.f5555a.readBoolean();
        }

        public byte readByte() throws IOException {
            this.f5557c++;
            int read = this.f5555a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f5557c += 2;
            return this.f5555a.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i10, int i11) throws IOException {
            this.f5557c += i11;
            this.f5555a.readFully(bArr, i10, i11);
        }

        public int readInt() throws IOException {
            this.f5557c += 4;
            int read = this.f5555a.read();
            int read2 = this.f5555a.read();
            int read3 = this.f5555a.read();
            int read4 = this.f5555a.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f5556b;
                if (byteOrder == f5553e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f5554f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f5556b);
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            return null;
        }

        public long readLong() throws IOException {
            this.f5557c += 8;
            int read = this.f5555a.read();
            int read2 = this.f5555a.read();
            int read3 = this.f5555a.read();
            int read4 = this.f5555a.read();
            int read5 = this.f5555a.read();
            int read6 = this.f5555a.read();
            int read7 = this.f5555a.read();
            int read8 = this.f5555a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f5556b;
                if (byteOrder == f5553e) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i10 = read2;
                if (byteOrder == f5554f) {
                    return (((long) read) << 56) + (((long) i10) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.f5556b);
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.f5557c += 2;
            int read = this.f5555a.read();
            int read2 = this.f5555a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f5556b;
                if (byteOrder == f5553e) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f5554f) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f5556b);
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f5557c += 2;
            return this.f5555a.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f5557c++;
            return this.f5555a.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            this.f5557c += 2;
            int read = this.f5555a.read();
            int read2 = this.f5555a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f5556b;
                if (byteOrder == f5553e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f5554f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f5556b);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i10) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f5556b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f5555a = dataInputStream;
            dataInputStream.mark(0);
            this.f5557c = 0;
            this.f5556b = byteOrder;
        }

        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int read = this.f5555a.read(bArr, i10, i11);
            this.f5557c += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            this.f5557c += bArr.length;
            this.f5555a.readFully(bArr);
        }
    }

    private static class c extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        final OutputStream f5559a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f5560b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f5559a = outputStream;
            this.f5560b = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f5560b = byteOrder;
        }

        public void b(int i10) throws IOException {
            this.f5559a.write(i10);
        }

        public void c(int i10) throws IOException {
            ByteOrder byteOrder = this.f5560b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f5559a.write((i10 >>> 0) & 255);
                this.f5559a.write((i10 >>> 8) & 255);
                this.f5559a.write((i10 >>> 16) & 255);
                this.f5559a.write((i10 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f5559a.write((i10 >>> 24) & 255);
                this.f5559a.write((i10 >>> 16) & 255);
                this.f5559a.write((i10 >>> 8) & 255);
                this.f5559a.write((i10 >>> 0) & 255);
            }
        }

        public void e(short s10) throws IOException {
            ByteOrder byteOrder = this.f5560b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f5559a.write((s10 >>> 0) & 255);
                this.f5559a.write((s10 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f5559a.write((s10 >>> 8) & 255);
                this.f5559a.write((s10 >>> 0) & 255);
            }
        }

        public void f(long j10) throws IOException {
            c((int) j10);
        }

        public void g(int i10) throws IOException {
            e((short) i10);
        }

        public void write(byte[] bArr) throws IOException {
            this.f5559a.write(bArr);
        }

        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f5559a.write(bArr, i10, i11);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f5561a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5562b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5563c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f5564d;

        d(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1, bArr);
        }

        public static d a(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(a.f5517p0);
                return new d(1, bytes.length, bytes);
            }
            return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[10] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f5569a);
                wrap.putInt((int) fVar.f5570b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + 0).getBytes(a.f5517p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j10, ByteOrder byteOrder) {
            return g(new long[]{j10}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[5] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f5569a);
                wrap.putInt((int) fVar.f5570b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i10, ByteOrder byteOrder) {
            return k(new int[]{i10}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (o10 instanceof String) {
                return Double.parseDouble((String) o10);
            } else {
                if (o10 instanceof long[]) {
                    long[] jArr = (long[]) o10;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof int[]) {
                    int[] iArr = (int[]) o10;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof double[]) {
                    double[] dArr = (double[]) o10;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof f[]) {
                    f[] fVarArr = (f[]) o10;
                    if (fVarArr.length == 1) {
                        return fVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int m(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (o10 instanceof String) {
                return Integer.parseInt((String) o10);
            } else {
                if (o10 instanceof long[]) {
                    long[] jArr = (long[]) o10;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof int[]) {
                    int[] iArr = (int[]) o10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String n(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                return null;
            }
            if (o10 instanceof String) {
                return (String) o10;
            }
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            if (o10 instanceof long[]) {
                long[] jArr = (long[]) o10;
                while (i10 < jArr.length) {
                    sb2.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb2.append(AppsFlyerKit.COMMA);
                    }
                }
                return sb2.toString();
            } else if (o10 instanceof int[]) {
                int[] iArr = (int[]) o10;
                while (i10 < iArr.length) {
                    sb2.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb2.append(AppsFlyerKit.COMMA);
                    }
                }
                return sb2.toString();
            } else if (o10 instanceof double[]) {
                double[] dArr = (double[]) o10;
                while (i10 < dArr.length) {
                    sb2.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb2.append(AppsFlyerKit.COMMA);
                    }
                }
                return sb2.toString();
            } else if (!(o10 instanceof f[])) {
                return null;
            } else {
                f[] fVarArr = (f[]) o10;
                while (i10 < fVarArr.length) {
                    sb2.append(fVarArr[i10].f5569a);
                    sb2.append('/');
                    sb2.append(fVarArr[i10].f5570b);
                    i10++;
                    if (i10 != fVarArr.length) {
                        sb2.append(AppsFlyerKit.COMMA);
                    }
                }
                return sb2.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0147 A[SYNTHETIC, Splitter:B:139:0x0147] */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x014e A[SYNTHETIC, Splitter:B:147:0x014e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object o(java.nio.ByteOrder r9) {
            /*
                r8 = this;
                r0 = 0
                androidx.exifinterface.media.a$b r1 = new androidx.exifinterface.media.a$b     // Catch:{ IOException -> 0x014b, all -> 0x0144 }
                byte[] r2 = r8.f5564d     // Catch:{ IOException -> 0x014b, all -> 0x0144 }
                r1.<init>((byte[]) r2)     // Catch:{ IOException -> 0x014b, all -> 0x0144 }
                r1.c(r9)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r9 = r8.f5561a     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r2 = 0
                r3 = 1
                switch(r9) {
                    case 1: goto L_0x0117;
                    case 2: goto L_0x00d1;
                    case 3: goto L_0x00bc;
                    case 4: goto L_0x00a7;
                    case 5: goto L_0x0089;
                    case 6: goto L_0x0117;
                    case 7: goto L_0x00d1;
                    case 8: goto L_0x0074;
                    case 9: goto L_0x005f;
                    case 10: goto L_0x003f;
                    case 11: goto L_0x0029;
                    case 12: goto L_0x0014;
                    default: goto L_0x0012;
                }     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x0012:
                goto L_0x013d
            L_0x0014:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x0018:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x0025
                double r3 = r1.readDouble()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x0018
            L_0x0025:
                r1.close()     // Catch:{ IOException -> 0x0028 }
            L_0x0028:
                return r9
            L_0x0029:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x002d:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x003b
                float r3 = r1.readFloat()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                double r3 = (double) r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x002d
            L_0x003b:
                r1.close()     // Catch:{ IOException -> 0x003e }
            L_0x003e:
                return r9
            L_0x003f:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                androidx.exifinterface.media.a$f[] r9 = new androidx.exifinterface.media.a.f[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x0043:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x005b
                int r3 = r1.readInt()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                long r3 = (long) r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r5 = r1.readInt()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                long r5 = (long) r5     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                androidx.exifinterface.media.a$f r7 = new androidx.exifinterface.media.a$f     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r7.<init>(r3, r5)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r7     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x0043
            L_0x005b:
                r1.close()     // Catch:{ IOException -> 0x005e }
            L_0x005e:
                return r9
            L_0x005f:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x0063:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x0070
                int r3 = r1.readInt()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x0063
            L_0x0070:
                r1.close()     // Catch:{ IOException -> 0x0073 }
            L_0x0073:
                return r9
            L_0x0074:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x0078:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x0085
                short r3 = r1.readShort()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x0078
            L_0x0085:
                r1.close()     // Catch:{ IOException -> 0x0088 }
            L_0x0088:
                return r9
            L_0x0089:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                androidx.exifinterface.media.a$f[] r9 = new androidx.exifinterface.media.a.f[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x008d:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x00a3
                long r3 = r1.b()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                long r5 = r1.b()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                androidx.exifinterface.media.a$f r7 = new androidx.exifinterface.media.a$f     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r7.<init>(r3, r5)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r7     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x008d
            L_0x00a3:
                r1.close()     // Catch:{ IOException -> 0x00a6 }
            L_0x00a6:
                return r9
            L_0x00a7:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                long[] r9 = new long[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x00ab:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x00b8
                long r3 = r1.b()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x00ab
            L_0x00b8:
                r1.close()     // Catch:{ IOException -> 0x00bb }
            L_0x00bb:
                return r9
            L_0x00bc:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x00c0:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x00cd
                int r3 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9[r2] = r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r2 = r2 + 1
                goto L_0x00c0
            L_0x00cd:
                r1.close()     // Catch:{ IOException -> 0x00d0 }
            L_0x00d0:
                return r9
            L_0x00d1:
                int r9 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                byte[] r4 = androidx.exifinterface.media.a.Y     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r4 = r4.length     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r9 < r4) goto L_0x00ee
                r9 = r2
            L_0x00d9:
                byte[] r4 = androidx.exifinterface.media.a.Y     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r5 = r4.length     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r9 >= r5) goto L_0x00eb
                byte[] r5 = r8.f5564d     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                byte r5 = r5[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                byte r6 = r4[r9]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r5 == r6) goto L_0x00e8
                r3 = r2
                goto L_0x00eb
            L_0x00e8:
                int r9 = r9 + 1
                goto L_0x00d9
            L_0x00eb:
                if (r3 == 0) goto L_0x00ee
                int r2 = r4.length     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x00ee:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9.<init>()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x00f3:
                int r3 = r8.f5562b     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r2 >= r3) goto L_0x010f
                byte[] r3 = r8.f5564d     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                byte r3 = r3[r2]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r3 != 0) goto L_0x00fe
                goto L_0x010f
            L_0x00fe:
                r4 = 32
                if (r3 < r4) goto L_0x0107
                char r3 = (char) r3     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9.append(r3)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                goto L_0x010c
            L_0x0107:
                r3 = 63
                r9.append(r3)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
            L_0x010c:
                int r2 = r2 + 1
                goto L_0x00f3
            L_0x010f:
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r1.close()     // Catch:{ IOException -> 0x0116 }
            L_0x0116:
                return r9
            L_0x0117:
                byte[] r9 = r8.f5564d     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r4 = r9.length     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r4 != r3) goto L_0x0132
                byte r4 = r9[r2]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                if (r4 < 0) goto L_0x0132
                if (r4 > r3) goto L_0x0132
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                char[] r3 = new char[r3]     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                int r4 = r4 + 48
                char r4 = (char) r4     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r3[r2] = r4     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r9.<init>(r3)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r1.close()     // Catch:{ IOException -> 0x0131 }
            L_0x0131:
                return r9
            L_0x0132:
                java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                java.nio.charset.Charset r3 = androidx.exifinterface.media.a.f5517p0     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r2.<init>(r9, r3)     // Catch:{ IOException -> 0x014c, all -> 0x0141 }
                r1.close()     // Catch:{ IOException -> 0x013c }
            L_0x013c:
                return r2
            L_0x013d:
                r1.close()     // Catch:{ IOException -> 0x0140 }
            L_0x0140:
                return r0
            L_0x0141:
                r9 = move-exception
                r0 = r1
                goto L_0x0145
            L_0x0144:
                r9 = move-exception
            L_0x0145:
                if (r0 == 0) goto L_0x014a
                r0.close()     // Catch:{ IOException -> 0x014a }
            L_0x014a:
                throw r9
            L_0x014b:
                r1 = r0
            L_0x014c:
                if (r1 == 0) goto L_0x0151
                r1.close()     // Catch:{ IOException -> 0x0151 }
            L_0x0151:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return a.X[this.f5561a] * this.f5562b;
        }

        public String toString() {
            return "(" + a.W[this.f5561a] + ", data length:" + this.f5564d.length + ")";
        }

        d(int i10, int i11, long j10, byte[] bArr) {
            this.f5561a = i10;
            this.f5562b = i11;
            this.f5563c = j10;
            this.f5564d = bArr;
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        public final long f5569a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5570b;

        f(double d10) {
            this((long) (d10 * 10000.0d), 10000);
        }

        public double a() {
            return ((double) this.f5569a) / ((double) this.f5570b);
        }

        public String toString() {
            return this.f5569a + RemoteSettings.FORWARD_SLASH_STRING + this.f5570b;
        }

        f(long j10, long j11) {
            if (j11 == 0) {
                this.f5569a = 0;
                this.f5570b = 1;
                return;
            }
            this.f5569a = j10;
            this.f5570b = j11;
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", Height.CENTIMETRES_MAX, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", Constants.FROZEN_FRAME_TIME, 1)};
        Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", ModifierContributor.ForParameter.MASK, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f5502a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f5503b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f5504c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", Height.CENTIMETRES_MAX, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f5505d0 = eVarArr5;
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f5507f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f5508g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f5509h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f5510i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f5511j0 = eVarArr10;
        f5513l0 = new HashMap[eVarArr10.length];
        f5514m0 = new HashMap[eVarArr10.length];
        Charset forName = Charset.forName(StringUtils.USASCII);
        f5517p0 = forName;
        f5518q0 = "Exif\u0000\u0000".getBytes(forName);
        f5519r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateUtils.DATE_WITH_TIME_PATTERN, locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            e[][] eVarArr11 = f5511j0;
            if (i10 < eVarArr11.length) {
                f5513l0[i10] = new HashMap<>();
                f5514m0[i10] = new HashMap<>();
                for (e eVar : eVarArr11[i10]) {
                    f5513l0[i10].put(Integer.valueOf(eVar.f5565a), eVar);
                    f5514m0[i10].put(eVar.f5566b, eVar);
                }
                i10++;
            } else {
                HashMap<Integer, Integer> hashMap = f5516o0;
                e[] eVarArr12 = f5512k0;
                hashMap.put(Integer.valueOf(eVarArr12[0].f5565a), 5);
                hashMap.put(Integer.valueOf(eVarArr12[1].f5565a), 1);
                hashMap.put(Integer.valueOf(eVarArr12[2].f5565a), 2);
                hashMap.put(Integer.valueOf(eVarArr12[3].f5565a), 3);
                hashMap.put(Integer.valueOf(eVarArr12[4].f5565a), 7);
                hashMap.put(Integer.valueOf(eVarArr12[5].f5565a), 8);
                return;
            }
        }
    }

    public a(@NonNull String str) throws IOException {
        e[][] eVarArr = f5511j0;
        this.f5534f = new HashMap[eVarArr.length];
        this.f5535g = new HashSet(eVarArr.length);
        this.f5536h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            B(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    private void A(b bVar, HashMap hashMap) throws IOException {
        b bVar2 = bVar;
        HashMap hashMap2 = hashMap;
        d dVar = (d) hashMap2.get("StripOffsets");
        d dVar2 = (d) hashMap2.get("StripByteCounts");
        if (dVar != null && dVar2 != null) {
            long[] d10 = b.d(dVar.o(this.f5536h));
            long[] d11 = b.d(dVar2.o(this.f5536h));
            if (d10 != null && d10.length != 0 && d11 != null && d11.length != 0 && d10.length == d11.length) {
                long j10 = 0;
                for (long j11 : d11) {
                    j10 += j11;
                }
                int i10 = (int) j10;
                byte[] bArr = new byte[i10];
                this.f5539k = true;
                this.f5538j = true;
                this.f5537i = true;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i11 < d10.length) {
                    int i14 = (int) d10[i11];
                    int i15 = (int) d11[i11];
                    if (i11 < d10.length - 1 && ((long) (i14 + i15)) != d10[i11 + 1]) {
                        this.f5539k = false;
                    }
                    int i16 = i14 - i12;
                    if (i16 >= 0) {
                        long j12 = (long) i16;
                        if (bVar2.skip(j12) != j12) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to skip ");
                            sb2.append(i16);
                            sb2.append(" bytes.");
                            return;
                        }
                        int i17 = i12 + i16;
                        byte[] bArr2 = new byte[i15];
                        if (bVar2.read(bArr2) != i15) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Failed to read ");
                            sb3.append(i15);
                            sb3.append(" bytes.");
                            return;
                        }
                        i12 = i17 + i15;
                        System.arraycopy(bArr2, 0, bArr, i13, i15);
                        i13 += i15;
                        i11++;
                    } else {
                        return;
                    }
                }
                this.f5542n = bArr;
                if (this.f5539k) {
                    this.f5540l = (int) d10[0];
                    this.f5541m = i10;
                }
            }
        }
    }

    private void B(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f5531c = null;
            this.f5529a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (K(fileInputStream2.getFD())) {
                        this.f5530b = fileInputStream2.getFD();
                    } else {
                        this.f5530b = null;
                    }
                    P(fileInputStream2);
                    b.c(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    b.c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                b.c(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean C(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f5518q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f5518q0;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0090, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean E(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.a$b r2 = new androidx.exifinterface.media.a$b     // Catch:{ Exception -> 0x008c }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008c }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = C     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r8 = 16
            r10 = 8
            if (r7 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r8 = r10
        L_0x0035:
            int r7 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r12 = (long) r7     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r8
            int r15 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r7 = 0
            r9 = r0
            r10 = r9
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = D     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r9 = r12
            goto L_0x0077
        L_0x006e:
            byte[] r11 = E     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r10 = r12
        L_0x0077:
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r7 = r7 + r5
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x0093
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x0094
        L_0x0088:
            r1 = r2
            goto L_0x008c
        L_0x008a:
            r15 = move-exception
            goto L_0x0094
        L_0x008c:
            boolean r15 = f5523v     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            return r0
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.E(byte[]):boolean");
    }

    private static boolean F(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = B;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean G(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.a$b r2 = new androidx.exifinterface.media.a$b     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.S(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f5536h = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.c(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.G(byte[]):boolean");
    }

    private boolean H(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    private boolean I(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean J(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.a$b r2 = new androidx.exifinterface.media.a$b     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.S(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f5536h = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.c(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x0029
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.J(byte[]):boolean");
    }

    private static boolean K(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean L(HashMap hashMap) throws IOException {
        d dVar;
        d dVar2 = (d) hashMap.get("BitsPerSample");
        if (dVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) dVar2.o(this.f5536h);
        int[] iArr2 = f5527y;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f5532d != 3 || (dVar = (d) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int m10 = dVar.m(this.f5536h);
        if ((m10 != 1 || !Arrays.equals(iArr, A)) && (m10 != 6 || !Arrays.equals(iArr, iArr2))) {
            return false;
        }
        return true;
    }

    private static boolean M(int i10) {
        return i10 == 4 || i10 == 13 || i10 == 14;
    }

    private boolean N(HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        int m10 = dVar.m(this.f5536h);
        int m11 = dVar2.m(this.f5536h);
        if (m10 > 512 || m11 > 512) {
            return false;
        }
        return true;
    }

    private boolean O(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[L.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else if (bArr[i10] != bArr2[i10]) {
                return false;
            } else {
                i10++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r5 = f5523v;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0096, code lost:
        if (r5 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        if (f5523v != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a3, code lost:
        R();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a6, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0091 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void P(@androidx.annotation.NonNull java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00a7
            r0 = 0
            r1 = r0
        L_0x0004:
            androidx.exifinterface.media.a$e[][] r2 = f5511j0     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r2 = r2.length     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r1 >= r2) goto L_0x0015
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r4.f5534f     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r3.<init>()     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r2[r1] = r3     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0015:
            boolean r1 = r4.f5533e     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r1 != 0) goto L_0x0027
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r5 = r4.n(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r4.f5532d = r5     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r5 = r1
        L_0x0027:
            int r1 = r4.f5532d     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            boolean r1 = h0(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r1 == 0) goto L_0x0062
            androidx.exifinterface.media.a$g r0 = new androidx.exifinterface.media.a$g     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r0.<init>((java.io.InputStream) r5)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            boolean r5 = r4.f5533e     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r5 == 0) goto L_0x003c
            r4.u(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x003c:
            int r5 = r4.f5532d     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r1 = 12
            if (r5 != r1) goto L_0x0046
            r4.k(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x0046:
            r1 = 7
            if (r5 != r1) goto L_0x004d
            r4.o(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x004d:
            r1 = 10
            if (r5 != r1) goto L_0x0055
            r4.t(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x0055:
            r4.r(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
        L_0x0058:
            int r5 = r4.f5544p     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            long r1 = (long) r5     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r0.f(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r4.g0(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0062:
            androidx.exifinterface.media.a$b r1 = new androidx.exifinterface.media.a$b     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r1.<init>((java.io.InputStream) r5)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r5 = r4.f5532d     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r2 = 4
            if (r5 != r2) goto L_0x0070
            r4.l(r1, r0, r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0070:
            r0 = 13
            if (r5 != r0) goto L_0x0078
            r4.p(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0078:
            r0 = 9
            if (r5 != r0) goto L_0x0080
            r4.q(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0080:
            r0 = 14
            if (r5 != r0) goto L_0x0087
            r4.x(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
        L_0x0087:
            r4.a()
            boolean r5 = f5523v
            if (r5 == 0) goto L_0x009b
            goto L_0x0098
        L_0x008f:
            r5 = move-exception
            goto L_0x009c
        L_0x0091:
            boolean r5 = f5523v     // Catch:{ all -> 0x008f }
            r4.a()
            if (r5 == 0) goto L_0x009b
        L_0x0098:
            r4.R()
        L_0x009b:
            return
        L_0x009c:
            r4.a()
            boolean r0 = f5523v
            if (r0 == 0) goto L_0x00a6
            r4.R()
        L_0x00a6:
            throw r5
        L_0x00a7:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.P(java.io.InputStream):void");
    }

    private void Q(b bVar) throws IOException {
        ByteOrder S2 = S(bVar);
        this.f5536h = S2;
        bVar.c(S2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.f5532d;
        if (i10 == 7 || i10 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i11 = readInt - 8;
                if (i11 > 0) {
                    bVar.e(i11);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void R() {
        for (int i10 = 0; i10 < this.f5534f.length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The size of tag group[");
            sb2.append(i10);
            sb2.append("]: ");
            sb2.append(this.f5534f[i10].size());
            for (Map.Entry next : this.f5534f[i10].entrySet()) {
                d dVar = (d) next.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tagName: ");
                sb3.append((String) next.getKey());
                sb3.append(", tagType: ");
                sb3.append(dVar.toString());
                sb3.append(", tagValue: '");
                sb3.append(dVar.n(this.f5536h));
                sb3.append("'");
            }
        }
    }

    private ByteOrder S(b bVar) throws IOException {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void T(byte[] bArr, int i10) throws IOException {
        g gVar = new g(bArr);
        Q(gVar);
        U(gVar, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0242  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void U(androidx.exifinterface.media.a.g r26, int r27) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            java.util.Set<java.lang.Integer> r3 = r0.f5535g
            int r4 = r1.f5557c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r26.readShort()
            boolean r4 = f5523v
            if (r4 == 0) goto L_0x0026
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "numberOfDirectoryEntry: "
            r4.append(r5)
            r4.append(r3)
        L_0x0026:
            if (r3 > 0) goto L_0x0029
            return
        L_0x0029:
            r4 = 0
            r5 = r4
        L_0x002b:
            r6 = 5
            r9 = 1
            if (r5 >= r3) goto L_0x02da
            int r11 = r26.readUnsignedShort()
            int r12 = r26.readUnsignedShort()
            int r15 = r26.readInt()
            int r13 = r26.a()
            long r13 = (long) r13
            r16 = 4
            long r13 = r13 + r16
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.a$e>[] r18 = f5513l0
            r7 = r18[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            java.lang.Object r7 = r7.get(r8)
            androidx.exifinterface.media.a$e r7 = (androidx.exifinterface.media.a.e) r7
            boolean r8 = f5523v
            r10 = 3
            if (r8 == 0) goto L_0x0082
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r20 = java.lang.Integer.valueOf(r27)
            r6[r4] = r20
            java.lang.Integer r20 = java.lang.Integer.valueOf(r11)
            r6[r9] = r20
            if (r7 == 0) goto L_0x006a
            java.lang.String r9 = r7.f5566b
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            r19 = 2
            r6[r19] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r6[r10] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r15)
            r18 = 4
            r6[r18] = r9
            java.lang.String r9 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String.format(r9, r6)
        L_0x0082:
            r6 = 7
            if (r7 != 0) goto L_0x0099
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = "Skip the tag entry since tag number is not defined: "
            r9.append(r4)
            r9.append(r11)
        L_0x0094:
            r21 = r7
            r9 = r11
            goto L_0x0104
        L_0x0099:
            if (r12 <= 0) goto L_0x00f2
            int[] r4 = X
            int r9 = r4.length
            if (r12 < r9) goto L_0x00a1
            goto L_0x00f2
        L_0x00a1:
            boolean r9 = r7.a(r12)
            if (r9 != 0) goto L_0x00c5
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "Skip the tag entry since data format ("
            r4.append(r9)
            java.lang.String[] r9 = W
            r9 = r9[r12]
            r4.append(r9)
            java.lang.String r9 = ") is unexpected for tag: "
            r4.append(r9)
            java.lang.String r9 = r7.f5566b
            r4.append(r9)
            goto L_0x0094
        L_0x00c5:
            if (r12 != r6) goto L_0x00c9
            int r12 = r7.f5567c
        L_0x00c9:
            r9 = r11
            long r10 = (long) r15
            r4 = r4[r12]
            r21 = r7
            long r6 = (long) r4
            long r6 = r6 * r10
            r10 = 0
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x00e1
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x00df
            goto L_0x00e1
        L_0x00df:
            r4 = 1
            goto L_0x0107
        L_0x00e1:
            if (r8 == 0) goto L_0x00f0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = "Skip the tag entry since the number of components is invalid: "
            r4.append(r10)
            r4.append(r15)
        L_0x00f0:
            r4 = 0
            goto L_0x0107
        L_0x00f2:
            r21 = r7
            r9 = r11
            if (r8 == 0) goto L_0x0104
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Skip the tag entry since data format is invalid: "
            r4.append(r6)
            r4.append(r12)
        L_0x0104:
            r4 = 0
            r6 = 0
        L_0x0107:
            if (r4 != 0) goto L_0x0112
            r1.f(r13)
            r22 = r3
            r21 = r5
            goto L_0x02d0
        L_0x0112:
            int r4 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            java.lang.String r10 = "Compression"
            if (r4 <= 0) goto L_0x019b
            int r4 = r26.readInt()
            if (r8 == 0) goto L_0x012e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r22 = r3
            java.lang.String r3 = "seek to data offset: "
            r11.append(r3)
            r11.append(r4)
            goto L_0x0130
        L_0x012e:
            r22 = r3
        L_0x0130:
            int r3 = r0.f5532d
            r11 = 7
            if (r3 != r11) goto L_0x0190
            r3 = r21
            java.lang.String r11 = r3.f5566b
            r21 = r5
            java.lang.String r5 = "MakerNote"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0146
            r0.f5545q = r4
            goto L_0x018d
        L_0x0146:
            r5 = 6
            if (r2 != r5) goto L_0x018d
            java.lang.String r11 = r3.f5566b
            java.lang.String r5 = "ThumbnailImage"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x018d
            r0.f5546r = r4
            r0.f5547s = r15
            java.nio.ByteOrder r5 = r0.f5536h
            r11 = 6
            androidx.exifinterface.media.a$d r5 = androidx.exifinterface.media.a.d.j(r11, r5)
            int r11 = r0.f5546r
            r16 = r13
            long r13 = (long) r11
            java.nio.ByteOrder r11 = r0.f5536h
            androidx.exifinterface.media.a$d r11 = androidx.exifinterface.media.a.d.f(r13, r11)
            int r13 = r0.f5547s
            long r13 = (long) r13
            java.nio.ByteOrder r2 = r0.f5536h
            androidx.exifinterface.media.a$d r2 = androidx.exifinterface.media.a.d.f(r13, r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r13 = r0.f5534f
            r14 = 4
            r13 = r13[r14]
            r13.put(r10, r5)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r5 = r0.f5534f
            r5 = r5[r14]
            java.lang.String r13 = "JPEGInterchangeFormat"
            r5.put(r13, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r5 = r0.f5534f
            r5 = r5[r14]
            java.lang.String r11 = "JPEGInterchangeFormatLength"
            r5.put(r11, r2)
            goto L_0x0196
        L_0x018d:
            r16 = r13
            goto L_0x0196
        L_0x0190:
            r16 = r13
            r3 = r21
            r21 = r5
        L_0x0196:
            long r4 = (long) r4
            r1.f(r4)
            goto L_0x01a3
        L_0x019b:
            r22 = r3
            r16 = r13
            r3 = r21
            r21 = r5
        L_0x01a3:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = f5516o0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r8 == 0) goto L_0x01c6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "nextIfdType: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " byteCount: "
            r4.append(r5)
            r4.append(r6)
        L_0x01c6:
            r4 = 8
            if (r2 == 0) goto L_0x0258
            r5 = -1
            r7 = 3
            if (r12 == r7) goto L_0x01ec
            r7 = 4
            if (r12 == r7) goto L_0x01e7
            if (r12 == r4) goto L_0x01e2
            r4 = 9
            if (r12 == r4) goto L_0x01dd
            r4 = 13
            if (r12 == r4) goto L_0x01dd
            goto L_0x01f1
        L_0x01dd:
            int r4 = r26.readInt()
            goto L_0x01f0
        L_0x01e2:
            short r4 = r26.readShort()
            goto L_0x01f0
        L_0x01e7:
            long r5 = r26.b()
            goto L_0x01f1
        L_0x01ec:
            int r4 = r26.readUnsignedShort()
        L_0x01f0:
            long r5 = (long) r4
        L_0x01f1:
            if (r8 == 0) goto L_0x0207
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Long r7 = java.lang.Long.valueOf(r5)
            r9 = 0
            r4[r9] = r7
            java.lang.String r3 = r3.f5566b
            r7 = 1
            r4[r7] = r3
            java.lang.String r3 = "Offset: %d, tagName: %s"
            java.lang.String.format(r3, r4)
        L_0x0207:
            r3 = 0
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0242
            java.util.Set<java.lang.Integer> r3 = r0.f5535g
            int r4 = (int) r5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x0225
            r1.f(r5)
            int r2 = r2.intValue()
            r0.U(r1, r2)
            goto L_0x0251
        L_0x0225:
            if (r8 == 0) goto L_0x0251
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r5)
            java.lang.String r2 = ")"
            r3.append(r2)
            goto L_0x0251
        L_0x0242:
            if (r8 == 0) goto L_0x0251
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r5)
        L_0x0251:
            r13 = r16
            r1.f(r13)
            goto L_0x02d0
        L_0x0258:
            r13 = r16
            int r2 = r26.a()
            int r5 = r0.f5544p
            int r2 = r2 + r5
            int r5 = (int) r6
            byte[] r5 = new byte[r5]
            r1.readFully(r5)
            androidx.exifinterface.media.a$d r6 = new androidx.exifinterface.media.a$d
            long r7 = (long) r2
            r23 = r13
            r13 = r6
            r14 = r12
            r16 = r7
            r18 = r5
            r13.<init>(r14, r15, r16, r18)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r0.f5534f
            r2 = r2[r27]
            java.lang.String r5 = r3.f5566b
            r2.put(r5, r6)
            java.lang.String r2 = r3.f5566b
            java.lang.String r5 = "DNGVersion"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x028b
            r2 = 3
            r0.f5532d = r2
        L_0x028b:
            java.lang.String r2 = r3.f5566b
            java.lang.String r5 = "Make"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x029f
            java.lang.String r2 = r3.f5566b
            java.lang.String r5 = "Model"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x02ad
        L_0x029f:
            java.nio.ByteOrder r2 = r0.f5536h
            java.lang.String r2 = r6.n(r2)
            java.lang.String r5 = "PENTAX"
            boolean r2 = r2.contains(r5)
            if (r2 != 0) goto L_0x02c0
        L_0x02ad:
            java.lang.String r2 = r3.f5566b
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x02c2
            java.nio.ByteOrder r2 = r0.f5536h
            int r2 = r6.m(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x02c2
        L_0x02c0:
            r0.f5532d = r4
        L_0x02c2:
            int r2 = r26.a()
            long r2 = (long) r2
            r13 = r23
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x02d0
            r1.f(r13)
        L_0x02d0:
            int r5 = r21 + 1
            short r5 = (short) r5
            r2 = r27
            r3 = r22
            r4 = 0
            goto L_0x002b
        L_0x02da:
            int r2 = r26.readInt()
            boolean r3 = f5523v
            if (r3 == 0) goto L_0x02f1
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r7 = 0
            r4[r7] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String.format(r5, r4)
        L_0x02f1:
            long r4 = (long) r2
            r7 = 0
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0334
            java.util.Set<java.lang.Integer> r7 = r0.f5535g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L_0x0324
            r1.f(r4)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r0.f5534f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0316
            r0.U(r1, r3)
            goto L_0x0343
        L_0x0316:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r2 = r0.f5534f
            r2 = r2[r6]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0343
            r0.U(r1, r6)
            goto L_0x0343
        L_0x0324:
            if (r3 == 0) goto L_0x0343
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            goto L_0x0343
        L_0x0334:
            if (r3 == 0) goto L_0x0343
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
        L_0x0343:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.U(androidx.exifinterface.media.a$g, int):void");
    }

    private void V(String str) {
        for (int i10 = 0; i10 < f5511j0.length; i10++) {
            this.f5534f[i10].remove(str);
        }
    }

    private void W(int i10, String str, String str2) {
        if (!this.f5534f[i10].isEmpty() && this.f5534f[i10].get(str) != null) {
            HashMap<String, d> hashMap = this.f5534f[i10];
            hashMap.put(str2, hashMap.get(str));
            this.f5534f[i10].remove(str);
        }
    }

    private void X(g gVar, int i10) throws IOException {
        d dVar = this.f5534f[i10].get("ImageLength");
        d dVar2 = this.f5534f[i10].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f5534f[i10].get("JPEGInterchangeFormat");
            d dVar4 = this.f5534f[i10].get("JPEGInterchangeFormatLength");
            if (dVar3 != null && dVar4 != null) {
                int m10 = dVar3.m(this.f5536h);
                int m11 = dVar3.m(this.f5536h);
                gVar.f((long) m10);
                byte[] bArr = new byte[m11];
                gVar.read(bArr);
                l(new b(bArr), m10, i10);
            }
        }
    }

    private void Z(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f5523v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveJpegAttributes starting with (inputStream: ");
            sb2.append(inputStream);
            sb2.append(", outputStream: ");
            sb2.append(outputStream);
            sb2.append(")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.b(-1);
            if (bVar.readByte() == -40) {
                cVar.b(-40);
                d dVar = null;
                if (g("Xmp") != null && this.f5549u) {
                    dVar = this.f5534f[0].remove("Xmp");
                }
                cVar.b(-1);
                cVar.b(-31);
                l0(cVar);
                if (dVar != null) {
                    this.f5534f[0].put("Xmp", dVar);
                }
                byte[] bArr = new byte[Opcodes.ACC_SYNTHETIC];
                while (bVar.readByte() == -1) {
                    byte readByte = bVar.readByte();
                    if (readByte == -39 || readByte == -38) {
                        cVar.b(-1);
                        cVar.b(readByte);
                        b.e(bVar, cVar);
                        return;
                    } else if (readByte != -31) {
                        cVar.b(-1);
                        cVar.b(readByte);
                        int readUnsignedShort = bVar.readUnsignedShort();
                        cVar.g(readUnsignedShort);
                        int i10 = readUnsignedShort - 2;
                        if (i10 >= 0) {
                            while (i10 > 0) {
                                int read = bVar.read(bArr, 0, Math.min(i10, Opcodes.ACC_SYNTHETIC));
                                if (read < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read);
                                i10 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = bVar.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (bVar.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, f5518q0)) {
                                    bVar.e(readUnsignedShort2 - 6);
                                }
                            }
                            cVar.b(-1);
                            cVar.b(readByte);
                            cVar.g(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                cVar.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = bVar.read(bArr, 0, Math.min(readUnsignedShort2, Opcodes.ACC_SYNTHETIC));
                                if (read2 < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void a() {
        String g10 = g("DateTimeOriginal");
        if (g10 != null && g("DateTime") == null) {
            this.f5534f[0].put("DateTime", d.e(g10));
        }
        if (g("ImageWidth") == null) {
            this.f5534f[0].put("ImageWidth", d.f(0, this.f5536h));
        }
        if (g("ImageLength") == null) {
            this.f5534f[0].put("ImageLength", d.f(0, this.f5536h));
        }
        if (g("Orientation") == null) {
            this.f5534f[0].put("Orientation", d.f(0, this.f5536h));
        }
        if (g("LightSource") == null) {
            this.f5534f[1].put("LightSource", d.f(0, this.f5536h));
        }
    }

    private void a0(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f5523v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("savePngAttributes starting with (inputStream: ");
            sb2.append(inputStream);
            sb2.append(", outputStream: ");
            sb2.append(outputStream);
            sb2.append(")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = H;
        b.f(bVar, cVar, bArr.length);
        int i10 = this.f5544p;
        if (i10 == 0) {
            int readInt = bVar.readInt();
            cVar.c(readInt);
            b.f(bVar, cVar, readInt + 4 + 4);
        } else {
            b.f(bVar, cVar, ((i10 - bArr.length) - 4) - 4);
            bVar.e(bVar.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                l0(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f5559a).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.c((int) crc32.getValue());
                b.c(byteArrayOutputStream2);
                b.e(bVar, cVar);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b.c(byteArrayOutputStream);
            throw th;
        }
    }

    private String b(double d10) {
        long j10 = (long) d10;
        double d11 = d10 - ((double) j10);
        long j11 = (long) (d11 * 60.0d);
        long round = Math.round((d11 - (((double) j11) / 60.0d)) * 3600.0d * 1.0E7d);
        return j10 + "/1," + j11 + "/1," + round + "/10000000";
    }

    private void b0(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (f5523v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveWebpAttributes starting with (inputStream: ");
            sb2.append(inputStream2);
            sb2.append(", outputStream: ");
            sb2.append(outputStream2);
            sb2.append(")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream2, byteOrder);
        c cVar = new c(outputStream2, byteOrder);
        byte[] bArr = L;
        b.f(bVar, cVar, bArr.length);
        byte[] bArr2 = M;
        bVar.e(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                int i15 = this.f5544p;
                if (i15 != 0) {
                    b.f(bVar, cVar2, ((i15 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                    bVar.e(4);
                    int readInt = bVar.readInt();
                    if (readInt % 2 != 0) {
                        readInt++;
                    }
                    bVar.e(readInt);
                    l0(cVar2);
                } else {
                    byte[] bArr3 = new byte[4];
                    if (bVar.read(bArr3) == 4) {
                        byte[] bArr4 = P;
                        boolean z10 = false;
                        boolean z11 = true;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int readInt2 = bVar.readInt();
                            if (readInt2 % 2 == 1) {
                                i14 = readInt2 + 1;
                            } else {
                                i14 = readInt2;
                            }
                            byte[] bArr5 = new byte[i14];
                            bVar.read(bArr5);
                            byte b10 = (byte) (8 | bArr5[0]);
                            bArr5[0] = b10;
                            if (((b10 >> 1) & 1) == 1) {
                                z10 = true;
                            }
                            cVar2.write(bArr4);
                            cVar2.c(readInt2);
                            cVar2.write(bArr5);
                            if (z10) {
                                d(bVar, cVar2, S, (byte[]) null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream2.read(bArr6);
                                    if (!Arrays.equals(bArr6, T)) {
                                        break;
                                    }
                                    e(bVar, cVar2, bArr6);
                                }
                                l0(cVar2);
                            } else {
                                d(bVar, cVar2, R, Q);
                                l0(cVar2);
                            }
                        } else {
                            byte[] bArr7 = R;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, Q)) {
                                int readInt3 = bVar.readInt();
                                if (readInt3 % 2 == 1) {
                                    i10 = readInt3 + 1;
                                } else {
                                    i10 = readInt3;
                                }
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    bVar.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (bVar.read(bArr9) != 3 || !Arrays.equals(O, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i13 = bVar.readInt();
                                    i10 -= 10;
                                    i11 = (i13 << 2) >> 18;
                                    i12 = (i13 << 18) >> 18;
                                    z11 = false;
                                } else if (!Arrays.equals(bArr3, Q)) {
                                    i13 = 0;
                                    z11 = false;
                                    i12 = 0;
                                    i11 = 0;
                                } else if (bVar.readByte() == 47) {
                                    i13 = bVar.readInt();
                                    i12 = (i13 & 16383) + 1;
                                    i11 = ((i13 & 268419072) >>> 14) + 1;
                                    if ((i13 & 268435456) == 0) {
                                        z11 = false;
                                    }
                                    i10 -= 5;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                cVar2.write(bArr4);
                                cVar2.c(10);
                                byte[] bArr10 = new byte[10];
                                if (z11) {
                                    bArr10[0] = (byte) (bArr10[0] | Tnaf.POW_2_WIDTH);
                                }
                                bArr10[0] = (byte) (bArr10[0] | 8);
                                int i16 = i12 - 1;
                                int i17 = i11 - 1;
                                bArr10[4] = (byte) i16;
                                bArr10[5] = (byte) (i16 >> 8);
                                bArr10[6] = (byte) (i16 >> 16);
                                bArr10[7] = (byte) i17;
                                bArr10[8] = (byte) (i17 >> 8);
                                bArr10[9] = (byte) (i17 >> 16);
                                cVar2.write(bArr10);
                                cVar2.write(bArr3);
                                cVar2.c(readInt3);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    cVar2.write(bArr8);
                                    cVar2.write(O);
                                    cVar2.c(i13);
                                } else if (Arrays.equals(bArr3, Q)) {
                                    cVar2.write(47);
                                    cVar2.c(i13);
                                }
                                b.f(bVar, cVar2, i10);
                                l0(cVar2);
                            }
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                b.e(bVar, cVar2);
                int size = byteArrayOutputStream2.size();
                byte[] bArr11 = M;
                cVar.c(size + bArr11.length);
                cVar.write(bArr11);
                byteArrayOutputStream2.writeTo(cVar);
                b.c(byteArrayOutputStream2);
            } catch (Exception e10) {
                e = e10;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th2) {
                    th = th2;
                    b.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    private static double c(String str, String str2) {
        try {
            String[] split = str.split(AppsFlyerKit.COMMA, -1);
            String[] split2 = split[0].split(RemoteSettings.FORWARD_SLASH_STRING, -1);
            String[] split3 = split[1].split(RemoteSettings.FORWARD_SLASH_STRING, -1);
            String[] split4 = split[2].split(RemoteSettings.FORWARD_SLASH_STRING, -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals("S")) {
                if (!str2.equals("W")) {
                    if (!str2.equals("N")) {
                        if (!str2.equals("E")) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void d(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f5517p0;
                sb2.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb2.append(str);
                throw new IOException(sb2.toString());
            }
            e(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void e(b bVar, c cVar, byte[] bArr) throws IOException {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.c(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        b.f(bVar, cVar, readInt);
    }

    private void g0(b bVar) throws IOException {
        HashMap<String, d> hashMap = this.f5534f[4];
        d dVar = hashMap.get("Compression");
        if (dVar != null) {
            int m10 = dVar.m(this.f5536h);
            this.f5543o = m10;
            if (m10 != 1) {
                if (m10 == 6) {
                    z(bVar, hashMap);
                    return;
                } else if (m10 != 7) {
                    return;
                }
            }
            if (L(hashMap)) {
                A(bVar, hashMap);
                return;
            }
            return;
        }
        this.f5543o = 6;
        z(bVar, hashMap);
    }

    private static boolean h0(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    private void i0(int i10, int i11) throws IOException {
        if (!this.f5534f[i10].isEmpty() && !this.f5534f[i11].isEmpty()) {
            d dVar = this.f5534f[i10].get("ImageLength");
            d dVar2 = this.f5534f[i10].get("ImageWidth");
            d dVar3 = this.f5534f[i11].get("ImageLength");
            d dVar4 = this.f5534f[i11].get("ImageWidth");
            if (dVar != null && dVar2 != null && dVar3 != null && dVar4 != null) {
                int m10 = dVar.m(this.f5536h);
                int m11 = dVar2.m(this.f5536h);
                int m12 = dVar3.m(this.f5536h);
                int m13 = dVar4.m(this.f5536h);
                if (m10 < m12 && m11 < m13) {
                    HashMap<String, d>[] hashMapArr = this.f5534f;
                    HashMap<String, d> hashMap = hashMapArr[i10];
                    hashMapArr[i10] = hashMapArr[i11];
                    hashMapArr[i11] = hashMap;
                }
            }
        }
    }

    private d j(@NonNull String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                str = "PhotographicSensitivity";
            }
            for (int i10 = 0; i10 < f5511j0.length; i10++) {
                d dVar = this.f5534f[i10].get(str);
                if (dVar != null) {
                    return dVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private void j0(g gVar, int i10) throws IOException {
        d dVar;
        d dVar2;
        d dVar3 = this.f5534f[i10].get("DefaultCropSize");
        d dVar4 = this.f5534f[i10].get("SensorTopBorder");
        d dVar5 = this.f5534f[i10].get("SensorLeftBorder");
        d dVar6 = this.f5534f[i10].get("SensorBottomBorder");
        d dVar7 = this.f5534f[i10].get("SensorRightBorder");
        if (dVar3 != null) {
            if (dVar3.f5561a == 5) {
                f[] fVarArr = (f[]) dVar3.o(this.f5536h);
                if (fVarArr == null || fVarArr.length != 2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid crop size values. cropSize=");
                    sb2.append(Arrays.toString(fVarArr));
                    return;
                }
                dVar2 = d.h(fVarArr[0], this.f5536h);
                dVar = d.h(fVarArr[1], this.f5536h);
            } else {
                int[] iArr = (int[]) dVar3.o(this.f5536h);
                if (iArr == null || iArr.length != 2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid crop size values. cropSize=");
                    sb3.append(Arrays.toString(iArr));
                    return;
                }
                dVar2 = d.j(iArr[0], this.f5536h);
                dVar = d.j(iArr[1], this.f5536h);
            }
            this.f5534f[i10].put("ImageWidth", dVar2);
            this.f5534f[i10].put("ImageLength", dVar);
        } else if (dVar4 == null || dVar5 == null || dVar6 == null || dVar7 == null) {
            X(gVar, i10);
        } else {
            int m10 = dVar4.m(this.f5536h);
            int m11 = dVar6.m(this.f5536h);
            int m12 = dVar7.m(this.f5536h);
            int m13 = dVar5.m(this.f5536h);
            if (m11 > m10 && m12 > m13) {
                d j10 = d.j(m11 - m10, this.f5536h);
                d j11 = d.j(m12 - m13, this.f5536h);
                this.f5534f[i10].put("ImageLength", j10);
                this.f5534f[i10].put("ImageWidth", j11);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012f, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0138, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013c, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0131 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(androidx.exifinterface.media.a.g r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x013d
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.a$a r2 = new androidx.exifinterface.media.a$a     // Catch:{ RuntimeException -> 0x0131 }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x0131 }
            androidx.exifinterface.media.b.C0057b.a(r1, r2)     // Catch:{ RuntimeException -> 0x0131 }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x0131 }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x0131 }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0131 }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0131 }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x0131 }
            r6 = 0
            if (r4 == 0) goto L_0x0047
            r0 = 29
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r0 = 30
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r4 = 31
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0131 }
            goto L_0x0062
        L_0x0047:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x0131 }
            if (r0 == 0) goto L_0x0060
            r0 = 18
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r0 = 19
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r4 = 24
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0131 }
            goto L_0x0062
        L_0x0060:
            r0 = r6
            r4 = r0
        L_0x0062:
            r5 = 0
            if (r6 == 0) goto L_0x0078
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r12.f5534f     // Catch:{ RuntimeException -> 0x0131 }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r6)     // Catch:{ RuntimeException -> 0x0131 }
            java.nio.ByteOrder r10 = r12.f5536h     // Catch:{ RuntimeException -> 0x0131 }
            androidx.exifinterface.media.a$d r9 = androidx.exifinterface.media.a.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x0131 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x0078:
            if (r0 == 0) goto L_0x008d
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r12.f5534f     // Catch:{ RuntimeException -> 0x0131 }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x0131 }
            java.nio.ByteOrder r10 = r12.f5536h     // Catch:{ RuntimeException -> 0x0131 }
            androidx.exifinterface.media.a$d r9 = androidx.exifinterface.media.a.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x0131 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x008d:
            r7 = 6
            if (r4 == 0) goto L_0x00b7
            r8 = 1
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x0131 }
            r10 = 90
            if (r9 == r10) goto L_0x00a7
            r10 = 180(0xb4, float:2.52E-43)
            if (r9 == r10) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            if (r9 == r10) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r8 = 8
            goto L_0x00a8
        L_0x00a5:
            r8 = 3
            goto L_0x00a8
        L_0x00a7:
            r8 = r7
        L_0x00a8:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r9 = r12.f5534f     // Catch:{ RuntimeException -> 0x0131 }
            r9 = r9[r5]     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.f5536h     // Catch:{ RuntimeException -> 0x0131 }
            androidx.exifinterface.media.a$d r8 = androidx.exifinterface.media.a.d.j(r8, r11)     // Catch:{ RuntimeException -> 0x0131 }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x00b7:
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x0131 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x0131 }
            if (r3 <= r7) goto L_0x0102
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x0131 }
            r13.f(r8)     // Catch:{ RuntimeException -> 0x0131 }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x0131 }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x0131 }
            if (r9 != r7) goto L_0x00fa
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = f5518q0     // Catch:{ RuntimeException -> 0x0131 }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x0131 }
            if (r7 == 0) goto L_0x00f2
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x0131 }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x0131 }
            if (r13 != r3) goto L_0x00ea
            r12.f5544p = r2     // Catch:{ RuntimeException -> 0x0131 }
            r12.T(r7, r5)     // Catch:{ RuntimeException -> 0x0131 }
            goto L_0x010a
        L_0x00ea:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x00f2:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x00fa:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x0102:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x010a:
            boolean r13 = f5523v     // Catch:{ RuntimeException -> 0x0131 }
            if (r13 == 0) goto L_0x012b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0131 }
            r13.<init>()     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r2 = "Heif meta: "
            r13.append(r2)     // Catch:{ RuntimeException -> 0x0131 }
            r13.append(r6)     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r2 = "x"
            r13.append(r2)     // Catch:{ RuntimeException -> 0x0131 }
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = ", rotation "
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r13.append(r4)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x012b:
            r1.release()
            return
        L_0x012f:
            r13 = move-exception
            goto L_0x0139
        L_0x0131:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x012f }
            throw r13     // Catch:{ all -> 0x012f }
        L_0x0139:
            r1.release()
            throw r13
        L_0x013d:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.k(androidx.exifinterface.media.a$g):void");
    }

    private void k0() throws IOException {
        i0(0, 5);
        i0(0, 4);
        i0(5, 4);
        d dVar = this.f5534f[1].get("PixelXDimension");
        d dVar2 = this.f5534f[1].get("PixelYDimension");
        if (!(dVar == null || dVar2 == null)) {
            this.f5534f[0].put("ImageWidth", dVar);
            this.f5534f[0].put("ImageLength", dVar2);
        }
        if (this.f5534f[4].isEmpty() && N(this.f5534f[5])) {
            HashMap<String, d>[] hashMapArr = this.f5534f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        N(this.f5534f[4]);
        W(0, "ThumbnailOrientation", "Orientation");
        W(0, "ThumbnailImageLength", "ImageLength");
        W(0, "ThumbnailImageWidth", "ImageWidth");
        W(5, "ThumbnailOrientation", "Orientation");
        W(5, "ThumbnailImageLength", "ImageLength");
        W(5, "ThumbnailImageWidth", "ImageWidth");
        W(4, "Orientation", "ThumbnailOrientation");
        W(4, "ImageLength", "ThumbnailImageLength");
        W(4, "ImageWidth", "ThumbnailImageWidth");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0162 A[LOOP:0: B:8:0x002f->B:57:0x0162, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(androidx.exifinterface.media.a.b r20, int r21, int r22) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = f5523v
            if (r3 == 0) goto L_0x0017
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getJpegAttributes starting with: "
            r3.append(r4)
            r3.append(r1)
        L_0x0017:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.c(r3)
            byte r3 = r20.readByte()
            java.lang.String r4 = "Invalid marker: "
            r5 = -1
            if (r3 != r5) goto L_0x01b4
            byte r6 = r20.readByte()
            r7 = -40
            if (r6 != r7) goto L_0x0199
            r3 = 2
            r4 = r3
        L_0x002f:
            byte r6 = r20.readByte()
            if (r6 != r5) goto L_0x017c
            r6 = 1
            int r4 = r4 + r6
            byte r7 = r20.readByte()
            boolean r8 = f5523v
            if (r8 == 0) goto L_0x0052
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Found JPEG segment indicator: "
            r9.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r9.append(r10)
        L_0x0052:
            int r4 = r4 + r6
            r9 = -39
            if (r7 == r9) goto L_0x0176
            r9 = -38
            if (r7 != r9) goto L_0x005d
            goto L_0x0176
        L_0x005d:
            int r9 = r20.readUnsignedShort()
            int r9 = r9 - r3
            int r4 = r4 + r3
            if (r8 == 0) goto L_0x0087
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "JPEG segment: "
            r8.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r8.append(r10)
            java.lang.String r10 = " (length: "
            r8.append(r10)
            int r10 = r9 + 2
            r8.append(r10)
            java.lang.String r10 = ")"
            r8.append(r10)
        L_0x0087:
            java.lang.String r8 = "Invalid length"
            if (r9 < 0) goto L_0x0170
            r10 = -31
            r11 = 0
            if (r7 == r10) goto L_0x0106
            r10 = -2
            if (r7 == r10) goto L_0x00db
            switch(r7) {
                case -64: goto L_0x00a1;
                case -63: goto L_0x00a1;
                case -62: goto L_0x00a1;
                case -61: goto L_0x00a1;
                default: goto L_0x0096;
            }
        L_0x0096:
            switch(r7) {
                case -59: goto L_0x00a1;
                case -58: goto L_0x00a1;
                case -57: goto L_0x00a1;
                default: goto L_0x0099;
            }
        L_0x0099:
            switch(r7) {
                case -55: goto L_0x00a1;
                case -54: goto L_0x00a1;
                case -53: goto L_0x00a1;
                default: goto L_0x009c;
            }
        L_0x009c:
            switch(r7) {
                case -51: goto L_0x00a1;
                case -50: goto L_0x00a1;
                case -49: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x0160
        L_0x00a1:
            r1.e(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r0.f5534f
            r6 = r6[r2]
            r7 = 4
            if (r2 == r7) goto L_0x00ae
            java.lang.String r10 = "ImageLength"
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r10 = "ThumbnailImageLength"
        L_0x00b0:
            int r11 = r20.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f5536h
            androidx.exifinterface.media.a$d r11 = androidx.exifinterface.media.a.d.f(r11, r13)
            r6.put(r10, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r0.f5534f
            r6 = r6[r2]
            if (r2 == r7) goto L_0x00c7
            java.lang.String r7 = "ImageWidth"
            goto L_0x00c9
        L_0x00c7:
            java.lang.String r7 = "ThumbnailImageWidth"
        L_0x00c9:
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.f5536h
            androidx.exifinterface.media.a$d r10 = androidx.exifinterface.media.a.d.f(r10, r12)
            r6.put(r7, r10)
            int r9 = r9 + -5
            goto L_0x0160
        L_0x00db:
            byte[] r7 = new byte[r9]
            int r10 = r1.read(r7)
            if (r10 != r9) goto L_0x00fe
            java.lang.String r9 = "UserComment"
            java.lang.String r10 = r0.g(r9)
            if (r10 != 0) goto L_0x015f
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r10 = r0.f5534f
            r6 = r10[r6]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r12 = f5517p0
            r10.<init>(r7, r12)
            androidx.exifinterface.media.a$d r7 = androidx.exifinterface.media.a.d.e(r10)
            r6.put(r9, r7)
            goto L_0x015f
        L_0x00fe:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0106:
            byte[] r7 = new byte[r9]
            r1.readFully(r7)
            int r10 = r4 + r9
            byte[] r12 = f5518q0
            boolean r13 = androidx.exifinterface.media.b.g(r7, r12)
            if (r13 == 0) goto L_0x012c
            int r6 = r12.length
            byte[] r6 = java.util.Arrays.copyOfRange(r7, r6, r9)
            int r4 = r21 + r4
            int r7 = r12.length
            int r4 = r4 + r7
            r0.f5544p = r4
            r0.T(r6, r2)
            androidx.exifinterface.media.a$b r4 = new androidx.exifinterface.media.a$b
            r4.<init>((byte[]) r6)
            r0.g0(r4)
            goto L_0x015e
        L_0x012c:
            byte[] r12 = f5519r0
            boolean r13 = androidx.exifinterface.media.b.g(r7, r12)
            if (r13 == 0) goto L_0x015e
            int r13 = r12.length
            int r4 = r4 + r13
            int r12 = r12.length
            byte[] r7 = java.util.Arrays.copyOfRange(r7, r12, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r12 = r0.g(r9)
            if (r12 != 0) goto L_0x015e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r12 = r0.f5534f
            r12 = r12[r11]
            androidx.exifinterface.media.a$d r15 = new androidx.exifinterface.media.a$d
            r14 = 1
            int r13 = r7.length
            long r3 = (long) r4
            r16 = r13
            r13 = r15
            r5 = r15
            r15 = r16
            r16 = r3
            r18 = r7
            r13.<init>(r14, r15, r16, r18)
            r12.put(r9, r5)
            r0.f5549u = r6
        L_0x015e:
            r4 = r10
        L_0x015f:
            r9 = r11
        L_0x0160:
            if (r9 < 0) goto L_0x016a
            r1.e(r9)
            int r4 = r4 + r9
            r3 = 2
            r5 = -1
            goto L_0x002f
        L_0x016a:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r8)
            throw r1
        L_0x0170:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r8)
            throw r1
        L_0x0176:
            java.nio.ByteOrder r2 = r0.f5536h
            r1.c(r2)
            return
        L_0x017c:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r6 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0199:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b4:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.l(androidx.exifinterface.media.a$b, int, int):void");
    }

    private int l0(c cVar) throws IOException {
        short s10;
        c cVar2 = cVar;
        e[][] eVarArr = f5511j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f5512k0) {
            V(eVar.f5566b);
        }
        if (this.f5537i) {
            if (this.f5538j) {
                V("StripOffsets");
                V("StripByteCounts");
            } else {
                V("JPEGInterchangeFormat");
                V("JPEGInterchangeFormatLength");
            }
        }
        for (int i10 = 0; i10 < f5511j0.length; i10++) {
            for (Object obj : this.f5534f[i10].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f5534f[i10].remove(entry.getKey());
                }
            }
        }
        if (!this.f5534f[1].isEmpty()) {
            this.f5534f[0].put(f5512k0[1].f5566b, d.f(0, this.f5536h));
        }
        if (!this.f5534f[2].isEmpty()) {
            this.f5534f[0].put(f5512k0[2].f5566b, d.f(0, this.f5536h));
        }
        if (!this.f5534f[3].isEmpty()) {
            this.f5534f[1].put(f5512k0[3].f5566b, d.f(0, this.f5536h));
        }
        if (this.f5537i) {
            if (this.f5538j) {
                this.f5534f[4].put("StripOffsets", d.j(0, this.f5536h));
                this.f5534f[4].put("StripByteCounts", d.j(this.f5541m, this.f5536h));
            } else {
                this.f5534f[4].put("JPEGInterchangeFormat", d.f(0, this.f5536h));
                this.f5534f[4].put("JPEGInterchangeFormatLength", d.f((long) this.f5541m, this.f5536h));
            }
        }
        for (int i11 = 0; i11 < f5511j0.length; i11++) {
            int i12 = 0;
            for (Map.Entry<String, d> value : this.f5534f[i11].entrySet()) {
                int p10 = ((d) value.getValue()).p();
                if (p10 > 4) {
                    i12 += p10;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
        }
        int i13 = 8;
        for (int i14 = 0; i14 < f5511j0.length; i14++) {
            if (!this.f5534f[i14].isEmpty()) {
                iArr[i14] = i13;
                i13 += (this.f5534f[i14].size() * 12) + 2 + 4 + iArr2[i14];
            }
        }
        if (this.f5537i) {
            if (this.f5538j) {
                this.f5534f[4].put("StripOffsets", d.j(i13, this.f5536h));
            } else {
                this.f5534f[4].put("JPEGInterchangeFormat", d.f((long) i13, this.f5536h));
            }
            this.f5540l = i13;
            i13 += this.f5541m;
        }
        if (this.f5532d == 4) {
            i13 += 8;
        }
        if (f5523v) {
            for (int i15 = 0; i15 < f5511j0.length; i15++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i15), Integer.valueOf(iArr[i15]), Integer.valueOf(this.f5534f[i15].size()), Integer.valueOf(iArr2[i15]), Integer.valueOf(i13)});
            }
        }
        if (!this.f5534f[1].isEmpty()) {
            this.f5534f[0].put(f5512k0[1].f5566b, d.f((long) iArr[1], this.f5536h));
        }
        if (!this.f5534f[2].isEmpty()) {
            this.f5534f[0].put(f5512k0[2].f5566b, d.f((long) iArr[2], this.f5536h));
        }
        if (!this.f5534f[3].isEmpty()) {
            this.f5534f[1].put(f5512k0[3].f5566b, d.f((long) iArr[3], this.f5536h));
        }
        int i16 = this.f5532d;
        if (i16 == 4) {
            cVar2.g(i13);
            cVar2.write(f5518q0);
        } else if (i16 == 13) {
            cVar2.c(i13);
            cVar2.write(I);
        } else if (i16 == 14) {
            cVar2.write(N);
            cVar2.c(i13);
        }
        if (this.f5536h == ByteOrder.BIG_ENDIAN) {
            s10 = 19789;
        } else {
            s10 = 18761;
        }
        cVar2.e(s10);
        cVar2.a(this.f5536h);
        cVar2.g(42);
        cVar2.f(8);
        for (int i17 = 0; i17 < f5511j0.length; i17++) {
            if (!this.f5534f[i17].isEmpty()) {
                cVar2.g(this.f5534f[i17].size());
                int size = iArr[i17] + 2 + (this.f5534f[i17].size() * 12) + 4;
                for (Map.Entry next : this.f5534f[i17].entrySet()) {
                    int i18 = f5514m0[i17].get(next.getKey()).f5565a;
                    d dVar = (d) next.getValue();
                    int p11 = dVar.p();
                    cVar2.g(i18);
                    cVar2.g(dVar.f5561a);
                    cVar2.c(dVar.f5562b);
                    if (p11 > 4) {
                        cVar2.f((long) size);
                        size += p11;
                    } else {
                        cVar2.write(dVar.f5564d);
                        if (p11 < 4) {
                            while (p11 < 4) {
                                cVar2.b(0);
                                p11++;
                            }
                        }
                    }
                }
                if (i17 != 0 || this.f5534f[4].isEmpty()) {
                    cVar2.f(0);
                } else {
                    cVar2.f((long) iArr[4]);
                }
                for (Map.Entry<String, d> value2 : this.f5534f[i17].entrySet()) {
                    byte[] bArr = ((d) value2.getValue()).f5564d;
                    if (bArr.length > 4) {
                        cVar2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f5537i) {
            cVar2.write(w());
        }
        if (this.f5532d == 14 && i13 % 2 == 1) {
            cVar2.b(0);
        }
        cVar2.a(ByteOrder.BIG_ENDIAN);
        return i13;
    }

    private int n(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(FacebookParse.FB_NO_LIMIT);
        byte[] bArr = new byte[FacebookParse.FB_NO_LIMIT];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (F(bArr)) {
            return 4;
        }
        if (I(bArr)) {
            return 9;
        }
        if (E(bArr)) {
            return 12;
        }
        if (G(bArr)) {
            return 7;
        }
        if (J(bArr)) {
            return 10;
        }
        if (H(bArr)) {
            return 13;
        }
        if (O(bArr)) {
            return 14;
        }
        return 0;
    }

    private void o(g gVar) throws IOException {
        int i10;
        int i11;
        r(gVar);
        d dVar = this.f5534f[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f5564d);
            gVar2.c(this.f5536h);
            byte[] bArr = F;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.f(0);
            byte[] bArr3 = G;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.f(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.f(12);
            }
            U(gVar2, 6);
            d dVar2 = this.f5534f[7].get("PreviewImageStart");
            d dVar3 = this.f5534f[7].get("PreviewImageLength");
            if (!(dVar2 == null || dVar3 == null)) {
                this.f5534f[5].put("JPEGInterchangeFormat", dVar2);
                this.f5534f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = this.f5534f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.f5536h);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid aspect frame values. frame=");
                    sb2.append(Arrays.toString(iArr));
                    return;
                }
                int i12 = iArr[2];
                int i13 = iArr[0];
                if (i12 > i13 && (i10 = iArr[3]) > (i11 = iArr[1])) {
                    int i14 = (i12 - i13) + 1;
                    int i15 = (i10 - i11) + 1;
                    if (i14 < i15) {
                        int i16 = i14 + i15;
                        i15 = i16 - i15;
                        i14 = i16 - i15;
                    }
                    d j10 = d.j(i14, this.f5536h);
                    d j11 = d.j(i15, this.f5536h);
                    this.f5534f[0].put("ImageWidth", j10);
                    this.f5534f[0].put("ImageLength", j11);
                }
            }
        }
    }

    private void p(b bVar) throws IOException {
        if (f5523v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPngAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        bVar.e(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i10 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i11 = i10 + 4;
                    if (i11 == 16) {
                        if (!Arrays.equals(bArr2, J)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, K)) {
                        if (Arrays.equals(bArr2, I)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f5544p = i11;
                                    T(bArr3, 0);
                                    k0();
                                    g0(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + b.a(bArr2));
                        }
                        int i12 = readInt + 4;
                        bVar.e(i12);
                        length = i11 + i12;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void q(b bVar) throws IOException {
        boolean z10 = f5523v;
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRafAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.e(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.e(i10 - bVar.a());
        bVar.read(bArr4);
        l(new b(bArr4), i10, 5);
        bVar.e(i12 - bVar.a());
        bVar.c(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("numberOfDirectoryEntry: ");
            sb3.append(readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f5506e0.f5565a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j10 = d.j(readShort, this.f5536h);
                d j11 = d.j(readShort2, this.f5536h);
                this.f5534f[0].put("ImageLength", j10);
                this.f5534f[0].put("ImageWidth", j11);
                if (f5523v) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Updated to length: ");
                    sb4.append(readShort);
                    sb4.append(", width: ");
                    sb4.append(readShort2);
                    return;
                }
                return;
            }
            bVar.e(readUnsignedShort2);
        }
    }

    private void r(g gVar) throws IOException {
        d dVar;
        Q(gVar);
        U(gVar, 0);
        j0(gVar, 0);
        j0(gVar, 5);
        j0(gVar, 4);
        k0();
        if (this.f5532d == 8 && (dVar = this.f5534f[1].get("MakerNote")) != null) {
            g gVar2 = new g(dVar.f5564d);
            gVar2.c(this.f5536h);
            gVar2.e(6);
            U(gVar2, 9);
            d dVar2 = this.f5534f[9].get("ColorSpace");
            if (dVar2 != null) {
                this.f5534f[1].put("ColorSpace", dVar2);
            }
        }
    }

    private void t(g gVar) throws IOException {
        if (f5523v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRw2Attributes starting with: ");
            sb2.append(gVar);
        }
        r(gVar);
        d dVar = this.f5534f[0].get("JpgFromRaw");
        if (dVar != null) {
            l(new b(dVar.f5564d), (int) dVar.f5563c, 5);
        }
        d dVar2 = this.f5534f[0].get("ISO");
        d dVar3 = this.f5534f[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            this.f5534f[1].put("PhotographicSensitivity", dVar2);
        }
    }

    private void u(g gVar) throws IOException {
        byte[] bArr = f5518q0;
        gVar.e(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f5544p = bArr.length;
        T(bArr2, 0);
    }

    private void x(b bVar) throws IOException {
        if (f5523v) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebpAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.c(ByteOrder.LITTLE_ENDIAN);
        bVar.e(L.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = M;
        bVar.e(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 4 + 4;
                    if (Arrays.equals(N, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f5544p = i10;
                            T(bArr3, 0);
                            g0(new b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.e(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> y(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = y(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = y(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r12 < 0) goto L_0x00f5
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r12 > 0) goto L_0x00eb
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r2 = 4
            if (r1 < 0) goto L_0x0130
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.y(java.lang.String):android.util.Pair");
    }

    private void z(b bVar, HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int m10 = dVar.m(this.f5536h);
            int m11 = dVar2.m(this.f5536h);
            if (this.f5532d == 7) {
                m10 += this.f5545q;
            }
            if (m10 > 0 && m11 > 0) {
                this.f5537i = true;
                if (this.f5529a == null && this.f5531c == null && this.f5530b == null) {
                    byte[] bArr = new byte[m11];
                    bVar.skip((long) m10);
                    bVar.read(bArr);
                    this.f5542n = bArr;
                }
                this.f5540l = m10;
                this.f5541m = m11;
            }
            if (f5523v) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting thumbnail attributes with offset: ");
                sb2.append(m10);
                sb2.append(", length: ");
                sb2.append(m11);
            }
        }
    }

    public boolean D() {
        int i10 = i("Orientation", 1);
        return i10 == 2 || i10 == 7 || i10 == 4 || i10 == 5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c7, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c8, code lost:
        r9 = null;
        r1 = r6;
        r6 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cd, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ce, code lost:
        r8 = null;
        r9 = null;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d3, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e4, code lost:
        androidx.exifinterface.media.b.a.c(r13.f5530b, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r13.f5530b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f3, code lost:
        r1 = new java.io.FileOutputStream(r13.f5529a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0145, code lost:
        r2.delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:27:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e4 A[Catch:{ Exception -> 0x010e, all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f3 A[Catch:{ Exception -> 0x010e, all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Y() throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r13.f5532d
            boolean r0 = M(r0)
            if (r0 == 0) goto L_0x016a
            java.io.FileDescriptor r0 = r13.f5530b
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r13.f5529a
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r13.f5537i
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.f5538j
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.f5539k
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r13.f5548t = r0
            byte[] r1 = r13.v()
            r13.f5542n = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.lang.String r3 = r13.f5529a     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r4 = 0
            if (r3 == 0) goto L_0x004e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.lang.String r6 = r13.f5529a     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            goto L_0x005c
        L_0x004e:
            java.io.FileDescriptor r3 = r13.f5530b     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            androidx.exifinterface.media.b.a.c(r3, r4, r6)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            java.io.FileDescriptor r6 = r13.f5530b     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
        L_0x005c:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0151, all -> 0x014d }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0151, all -> 0x014d }
            androidx.exifinterface.media.b.e(r3, r6)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            androidx.exifinterface.media.b.c(r3)
            androidx.exifinterface.media.b.c(r6)
            r3 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            java.lang.String r7 = r13.f5529a     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            if (r7 == 0) goto L_0x007c
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            java.lang.String r8 = r13.f5529a     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            goto L_0x008a
        L_0x007c:
            java.io.FileDescriptor r7 = r13.f5530b     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            int r8 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            androidx.exifinterface.media.b.a.c(r7, r4, r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            java.io.FileDescriptor r8 = r13.f5530b     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00d2 }
        L_0x008a:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c7, all -> 0x00d2 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00c7, all -> 0x00d2 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            int r10 = r13.f5532d     // Catch:{ Exception -> 0x00b8 }
            r11 = 4
            if (r10 != r11) goto L_0x009d
            r13.Z(r8, r9)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ac
        L_0x009d:
            r11 = 13
            if (r10 != r11) goto L_0x00a5
            r13.a0(r8, r9)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ac
        L_0x00a5:
            r11 = 14
            if (r10 != r11) goto L_0x00ac
            r13.b0(r8, r9)     // Catch:{ Exception -> 0x00b8 }
        L_0x00ac:
            androidx.exifinterface.media.b.c(r8)
            androidx.exifinterface.media.b.c(r9)
            r2.delete()
            r13.f5542n = r1
            return
        L_0x00b8:
            r1 = move-exception
            r12 = r6
            r6 = r1
            r1 = r12
            goto L_0x00db
        L_0x00bd:
            r0 = move-exception
            r9 = r1
            goto L_0x013c
        L_0x00c1:
            r9 = move-exception
            r12 = r9
            r9 = r1
            r1 = r6
            r6 = r12
            goto L_0x00db
        L_0x00c7:
            r8 = move-exception
            r9 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            goto L_0x00db
        L_0x00cd:
            r7 = move-exception
            r8 = r1
            r9 = r8
            r1 = r6
            goto L_0x00d9
        L_0x00d2:
            r0 = move-exception
            r9 = r1
            goto L_0x013d
        L_0x00d6:
            r7 = move-exception
            r8 = r1
            r9 = r8
        L_0x00d9:
            r6 = r7
            r7 = r9
        L_0x00db:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = r13.f5529a     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            if (r1 != 0) goto L_0x00f3
            java.io.FileDescriptor r1 = r13.f5530b     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            int r11 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            androidx.exifinterface.media.b.a.c(r1, r4, r11)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.io.FileDescriptor r4 = r13.f5530b     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            goto L_0x00fa
        L_0x00f3:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.lang.String r4 = r13.f5529a     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
        L_0x00fa:
            r7 = r1
            androidx.exifinterface.media.b.e(r10, r7)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            androidx.exifinterface.media.b.c(r10)     // Catch:{ all -> 0x013b }
            androidx.exifinterface.media.b.c(r7)     // Catch:{ all -> 0x013b }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013b }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r6)     // Catch:{ all -> 0x013b }
            throw r0     // Catch:{ all -> 0x013b }
        L_0x010c:
            r0 = move-exception
            goto L_0x0133
        L_0x010e:
            r1 = move-exception
            goto L_0x0115
        L_0x0110:
            r0 = move-exception
            goto L_0x0134
        L_0x0112:
            r3 = move-exception
            r10 = r1
            r1 = r3
        L_0x0115:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r4.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x0130 }
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0130 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0130 }
            throw r3     // Catch:{ all -> 0x0130 }
        L_0x0130:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x0133:
            r1 = r10
        L_0x0134:
            androidx.exifinterface.media.b.c(r1)     // Catch:{ all -> 0x013b }
            androidx.exifinterface.media.b.c(r7)     // Catch:{ all -> 0x013b }
            throw r0     // Catch:{ all -> 0x013b }
        L_0x013b:
            r0 = move-exception
        L_0x013c:
            r1 = r8
        L_0x013d:
            androidx.exifinterface.media.b.c(r1)
            androidx.exifinterface.media.b.c(r9)
            if (r3 != 0) goto L_0x0148
            r2.delete()
        L_0x0148:
            throw r0
        L_0x0149:
            r0 = move-exception
            goto L_0x014f
        L_0x014b:
            r0 = move-exception
            goto L_0x0153
        L_0x014d:
            r0 = move-exception
            r6 = r1
        L_0x014f:
            r1 = r3
            goto L_0x0163
        L_0x0151:
            r0 = move-exception
            r6 = r1
        L_0x0153:
            r1 = r3
            goto L_0x015a
        L_0x0155:
            r0 = move-exception
            r6 = r1
            goto L_0x0163
        L_0x0158:
            r0 = move-exception
            r6 = r1
        L_0x015a:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0162 }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0162 }
            throw r2     // Catch:{ all -> 0x0162 }
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            androidx.exifinterface.media.b.c(r1)
            androidx.exifinterface.media.b.c(r6)
            throw r0
        L_0x016a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.Y():void");
    }

    public void c0(double d10) {
        String str;
        if (d10 >= 0.0d) {
            str = "0";
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        d0("GPSAltitude", new f(Math.abs(d10)).toString());
        d0("GPSAltitudeRef", str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x028a, code lost:
        r15 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d0(@androidx.annotation.NonNull java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            if (r1 == 0) goto L_0x0336
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            if (r3 != 0) goto L_0x0024
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0024
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0064
        L_0x0024:
            if (r2 == 0) goto L_0x0064
            java.util.regex.Pattern r3 = f5522u0
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r6 = f5524v0
            java.util.regex.Matcher r6 = r6.matcher(r2)
            boolean r6 = r6.find()
            int r7 = r18.length()
            r8 = 19
            if (r7 != r8) goto L_0x0052
            if (r3 != 0) goto L_0x0047
            if (r6 != 0) goto L_0x0047
            goto L_0x0052
        L_0x0047:
            if (r6 == 0) goto L_0x0064
            java.lang.String r3 = "-"
            java.lang.String r6 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r6)
            goto L_0x0064
        L_0x0052:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            return
        L_0x0064:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x006e
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x006e:
            r3 = 2
            r6 = 1
            if (r2 == 0) goto L_0x00f9
            java.util.HashSet<java.lang.String> r7 = f5515n0
            boolean r7 = r7.contains(r1)
            if (r7 == 0) goto L_0x00f9
            java.lang.String r7 = "GPSTimeStamp"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x00d9
            java.util.regex.Pattern r7 = f5521t0
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r8 = r7.find()
            if (r8 != 0) goto L_0x00a0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            return
        L_0x00a0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r7.group(r6)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r7.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r7.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x00f9
        L_0x00d9:
            double r7 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x00e7 }
            androidx.exifinterface.media.a$f r9 = new androidx.exifinterface.media.a$f     // Catch:{ NumberFormatException -> 0x00e7 }
            r9.<init>(r7)     // Catch:{ NumberFormatException -> 0x00e7 }
            java.lang.String r2 = r9.toString()     // Catch:{ NumberFormatException -> 0x00e7 }
            goto L_0x00f9
        L_0x00e7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            return
        L_0x00f9:
            r4 = 0
            r5 = r4
        L_0x00fb:
            androidx.exifinterface.media.a$e[][] r7 = f5511j0
            int r7 = r7.length
            if (r5 >= r7) goto L_0x0335
            r7 = 4
            if (r5 != r7) goto L_0x0109
            boolean r7 = r0.f5537i
            if (r7 != 0) goto L_0x0109
            goto L_0x032d
        L_0x0109:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$e>[] r7 = f5514m0
            r7 = r7[r5]
            java.lang.Object r7 = r7.get(r1)
            androidx.exifinterface.media.a$e r7 = (androidx.exifinterface.media.a.e) r7
            if (r7 == 0) goto L_0x032d
            if (r2 != 0) goto L_0x0120
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r0.f5534f
            r7 = r7[r5]
            r7.remove(r1)
            goto L_0x032d
        L_0x0120:
            android.util.Pair r8 = y(r2)
            int r9 = r7.f5567c
            java.lang.Object r10 = r8.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r11 = -1
            if (r9 == r10) goto L_0x01e9
            int r9 = r7.f5567c
            java.lang.Object r10 = r8.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 != r10) goto L_0x013f
            goto L_0x01e9
        L_0x013f:
            int r9 = r7.f5568d
            if (r9 == r11) goto L_0x015d
            java.lang.Object r10 = r8.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 == r10) goto L_0x0159
            int r9 = r7.f5568d
            java.lang.Object r10 = r8.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 != r10) goto L_0x015d
        L_0x0159:
            int r7 = r7.f5568d
            goto L_0x01eb
        L_0x015d:
            int r9 = r7.f5567c
            if (r9 == r6) goto L_0x01e7
            r10 = 7
            if (r9 == r10) goto L_0x01e7
            if (r9 != r3) goto L_0x0168
            goto L_0x01e7
        L_0x0168:
            boolean r9 = f5523v
            if (r9 == 0) goto L_0x032d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Given tag ("
            r9.append(r10)
            r9.append(r1)
            java.lang.String r10 = ") value didn't match with one of expected formats: "
            r9.append(r10)
            java.lang.String[] r10 = W
            int r12 = r7.f5567c
            r12 = r10[r12]
            r9.append(r12)
            int r12 = r7.f5568d
            java.lang.String r13 = ""
            java.lang.String r14 = ", "
            if (r12 != r11) goto L_0x0191
            r7 = r13
            goto L_0x01a4
        L_0x0191:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r14)
            int r7 = r7.f5568d
            r7 = r10[r7]
            r12.append(r7)
            java.lang.String r7 = r12.toString()
        L_0x01a4:
            r9.append(r7)
            java.lang.String r7 = " (guess: "
            r9.append(r7)
            java.lang.Object r7 = r8.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r7 = r10[r7]
            r9.append(r7)
            java.lang.Object r7 = r8.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != r11) goto L_0x01c4
            goto L_0x01dd
        L_0x01c4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r14)
            java.lang.Object r8 = r8.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r10[r8]
            r7.append(r8)
            java.lang.String r13 = r7.toString()
        L_0x01dd:
            r9.append(r13)
            java.lang.String r7 = ")"
            r9.append(r7)
            goto L_0x032d
        L_0x01e7:
            r7 = r9
            goto L_0x01eb
        L_0x01e9:
            int r7 = r7.f5567c
        L_0x01eb:
            java.lang.String r8 = "/"
            java.lang.String r9 = ","
            switch(r7) {
                case 1: goto L_0x0320;
                case 2: goto L_0x0313;
                case 3: goto L_0x02ee;
                case 4: goto L_0x02c9;
                case 5: goto L_0x028d;
                case 6: goto L_0x01f2;
                case 7: goto L_0x0313;
                case 8: goto L_0x01f2;
                case 9: goto L_0x0267;
                case 10: goto L_0x022b;
                case 11: goto L_0x01f2;
                case 12: goto L_0x0206;
                default: goto L_0x01f2;
            }
        L_0x01f2:
            r15 = r6
            boolean r3 = f5523v
            if (r3 == 0) goto L_0x032e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Data format isn't one of expected formats: "
            r3.append(r4)
            r3.append(r7)
            goto L_0x032e
        L_0x0206:
            java.lang.String[] r7 = r2.split(r9, r11)
            int r8 = r7.length
            double[] r8 = new double[r8]
            r9 = r4
        L_0x020e:
            int r10 = r7.length
            if (r9 >= r10) goto L_0x021c
            r10 = r7[r9]
            double r10 = java.lang.Double.parseDouble(r10)
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x020e
        L_0x021c:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r7 = r0.f5534f
            r7 = r7[r5]
            java.nio.ByteOrder r9 = r0.f5536h
            androidx.exifinterface.media.a$d r8 = androidx.exifinterface.media.a.d.b(r8, r9)
            r7.put(r1, r8)
            goto L_0x032d
        L_0x022b:
            java.lang.String[] r7 = r2.split(r9, r11)
            int r9 = r7.length
            androidx.exifinterface.media.a$f[] r9 = new androidx.exifinterface.media.a.f[r9]
            r10 = r4
        L_0x0233:
            int r12 = r7.length
            if (r10 >= r12) goto L_0x0259
            r12 = r7[r10]
            java.lang.String[] r12 = r12.split(r8, r11)
            androidx.exifinterface.media.a$f r13 = new androidx.exifinterface.media.a$f
            r14 = r12[r4]
            double r14 = java.lang.Double.parseDouble(r14)
            long r14 = (long) r14
            r12 = r12[r6]
            r18 = r7
            double r6 = java.lang.Double.parseDouble(r12)
            long r6 = (long) r6
            r13.<init>(r14, r6)
            r9[r10] = r13
            int r10 = r10 + 1
            r7 = r18
            r6 = 1
            goto L_0x0233
        L_0x0259:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r0.f5534f
            r6 = r6[r5]
            java.nio.ByteOrder r7 = r0.f5536h
            androidx.exifinterface.media.a$d r7 = androidx.exifinterface.media.a.d.d(r9, r7)
            r6.put(r1, r7)
            goto L_0x028a
        L_0x0267:
            java.lang.String[] r6 = r2.split(r9, r11)
            int r7 = r6.length
            int[] r7 = new int[r7]
            r8 = r4
        L_0x026f:
            int r9 = r6.length
            if (r8 >= r9) goto L_0x027d
            r9 = r6[r8]
            int r9 = java.lang.Integer.parseInt(r9)
            r7[r8] = r9
            int r8 = r8 + 1
            goto L_0x026f
        L_0x027d:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r6 = r0.f5534f
            r6 = r6[r5]
            java.nio.ByteOrder r8 = r0.f5536h
            androidx.exifinterface.media.a$d r7 = androidx.exifinterface.media.a.d.c(r7, r8)
            r6.put(r1, r7)
        L_0x028a:
            r15 = 1
            goto L_0x032e
        L_0x028d:
            java.lang.String[] r6 = r2.split(r9, r11)
            int r7 = r6.length
            androidx.exifinterface.media.a$f[] r7 = new androidx.exifinterface.media.a.f[r7]
            r9 = r4
        L_0x0295:
            int r10 = r6.length
            if (r9 >= r10) goto L_0x02b9
            r10 = r6[r9]
            java.lang.String[] r10 = r10.split(r8, r11)
            androidx.exifinterface.media.a$f r12 = new androidx.exifinterface.media.a$f
            r13 = r10[r4]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r15 = 1
            r10 = r10[r15]
            double r3 = java.lang.Double.parseDouble(r10)
            long r3 = (long) r3
            r12.<init>(r13, r3)
            r7[r9] = r12
            int r9 = r9 + 1
            r3 = 2
            r4 = 0
            goto L_0x0295
        L_0x02b9:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f5534f
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.f5536h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.i(r7, r4)
            r3.put(r1, r4)
            goto L_0x032e
        L_0x02c9:
            r15 = r6
            java.lang.String[] r3 = r2.split(r9, r11)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r6 = 0
        L_0x02d2:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x02e0
            r7 = r3[r6]
            long r7 = java.lang.Long.parseLong(r7)
            r4[r6] = r7
            int r6 = r6 + 1
            goto L_0x02d2
        L_0x02e0:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f5534f
            r3 = r3[r5]
            java.nio.ByteOrder r6 = r0.f5536h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.g(r4, r6)
            r3.put(r1, r4)
            goto L_0x032e
        L_0x02ee:
            r15 = r6
            java.lang.String[] r3 = r2.split(r9, r11)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r6 = 0
        L_0x02f7:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x0305
            r7 = r3[r6]
            int r7 = java.lang.Integer.parseInt(r7)
            r4[r6] = r7
            int r6 = r6 + 1
            goto L_0x02f7
        L_0x0305:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f5534f
            r3 = r3[r5]
            java.nio.ByteOrder r6 = r0.f5536h
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.k(r4, r6)
            r3.put(r1, r4)
            goto L_0x032e
        L_0x0313:
            r15 = r6
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f5534f
            r3 = r3[r5]
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.e(r2)
            r3.put(r1, r4)
            goto L_0x032e
        L_0x0320:
            r15 = r6
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$d>[] r3 = r0.f5534f
            r3 = r3[r5]
            androidx.exifinterface.media.a$d r4 = androidx.exifinterface.media.a.d.a(r2)
            r3.put(r1, r4)
            goto L_0x032e
        L_0x032d:
            r15 = r6
        L_0x032e:
            int r5 = r5 + 1
            r6 = r15
            r3 = 2
            r4 = 0
            goto L_0x00fb
        L_0x0335:
            return
        L_0x0336:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "tag shouldn't be null"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.d0(java.lang.String, java.lang.String):void");
    }

    public void e0(Location location) {
        if (location != null) {
            d0("GPSProcessingMethod", location.getProvider());
            f0(location.getLatitude(), location.getLongitude());
            c0(location.getAltitude());
            d0("GPSSpeedRef", "K");
            d0("GPSSpeed", new f((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = U.format(new Date(location.getTime())).split("\\s+", -1);
            d0("GPSDateStamp", split[0]);
            d0("GPSTimeStamp", split[1]);
        }
    }

    public double f(double d10) {
        double h10 = h("GPSAltitude", -1.0d);
        int i10 = -1;
        int i11 = i("GPSAltitudeRef", -1);
        if (h10 < 0.0d || i11 < 0) {
            return d10;
        }
        if (i11 != 1) {
            i10 = 1;
        }
        return h10 * ((double) i10);
    }

    public void f0(double d10, double d11) {
        String str;
        String str2;
        if (d10 < -90.0d || d10 > 90.0d || Double.isNaN(d10)) {
            throw new IllegalArgumentException("Latitude value " + d10 + " is not valid.");
        } else if (d11 < -180.0d || d11 > 180.0d || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Longitude value " + d11 + " is not valid.");
        } else {
            if (d10 >= 0.0d) {
                str = "N";
            } else {
                str = "S";
            }
            d0("GPSLatitudeRef", str);
            d0("GPSLatitude", b(Math.abs(d10)));
            if (d11 >= 0.0d) {
                str2 = "E";
            } else {
                str2 = "W";
            }
            d0("GPSLongitudeRef", str2);
            d0("GPSLongitude", b(Math.abs(d11)));
        }
    }

    public String g(@NonNull String str) {
        if (str != null) {
            d j10 = j(str);
            if (j10 != null) {
                if (!f5515n0.contains(str)) {
                    return j10.n(this.f5536h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i10 = j10.f5561a;
                    if (i10 == 5 || i10 == 10) {
                        f[] fVarArr = (f[]) j10.o(this.f5536h);
                        if (fVarArr == null || fVarArr.length != 3) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid GPS Timestamp array. array=");
                            sb2.append(Arrays.toString(fVarArr));
                            return null;
                        }
                        f fVar = fVarArr[0];
                        f fVar2 = fVarArr[1];
                        f fVar3 = fVarArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) fVar.f5569a) / ((float) fVar.f5570b))), Integer.valueOf((int) (((float) fVar2.f5569a) / ((float) fVar2.f5570b))), Integer.valueOf((int) (((float) fVar3.f5569a) / ((float) fVar3.f5570b)))});
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("GPS Timestamp format is not rational. format=");
                    sb3.append(j10.f5561a);
                    return null;
                }
                try {
                    return Double.toString(j10.l(this.f5536h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double h(@NonNull String str, double d10) {
        if (str != null) {
            d j10 = j(str);
            if (j10 == null) {
                return d10;
            }
            try {
                return j10.l(this.f5536h);
            } catch (NumberFormatException unused) {
                return d10;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int i(@NonNull String str, int i10) {
        if (str != null) {
            d j10 = j(str);
            if (j10 == null) {
                return i10;
            }
            try {
                return j10.m(this.f5536h);
            } catch (NumberFormatException unused) {
                return i10;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public double[] m() {
        String g10 = g("GPSLatitude");
        String g11 = g("GPSLatitudeRef");
        String g12 = g("GPSLongitude");
        String g13 = g("GPSLongitudeRef");
        if (g10 == null || g11 == null || g12 == null || g13 == null) {
            return null;
        }
        try {
            return new double[]{c(g10, g11), c(g12, g13)};
        } catch (IllegalArgumentException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Latitude/longitude values are not parsable. ");
            sb2.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{g10, g11, g12, g13}));
            return null;
        }
    }

    public int s() {
        switch (i("Orientation", 1)) {
            case 3:
            case 4:
                return Opcodes.GETFIELD;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public byte[] v() {
        int i10 = this.f5543o;
        if (i10 == 6 || i10 == 7) {
            return w();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[SYNTHETIC, Splitter:B:33:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c A[Catch:{ Exception -> 0x009c, all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] w() {
        /*
            r8 = this;
            boolean r0 = r8.f5537i
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r0 = r8.f5542n
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            android.content.res.AssetManager$AssetInputStream r0 = r8.f5531c     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            if (r0 == 0) goto L_0x0028
            boolean r2 = r0.markSupported()     // Catch:{ Exception -> 0x0025, all -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r0.reset()     // Catch:{ Exception -> 0x0025, all -> 0x001e }
        L_0x0018:
            r2 = r1
            goto L_0x0049
        L_0x001a:
            androidx.exifinterface.media.b.c(r0)
            return r1
        L_0x001e:
            r2 = move-exception
            r7 = r1
            r1 = r0
            r0 = r2
            r2 = r7
            goto L_0x0091
        L_0x0025:
            r2 = r1
            goto L_0x009c
        L_0x0028:
            java.lang.String r0 = r8.f5529a     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            if (r0 == 0) goto L_0x0034
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            java.lang.String r2 = r8.f5529a     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            r0.<init>(r2)     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            goto L_0x0018
        L_0x0034:
            java.io.FileDescriptor r0 = r8.f5530b     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            java.io.FileDescriptor r0 = androidx.exifinterface.media.b.a.b(r0)     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            r2 = 0
            int r4 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            androidx.exifinterface.media.b.a.c(r0, r2, r4)     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            r7 = r2
            r2 = r0
            r0 = r7
        L_0x0049:
            int r3 = r8.f5540l     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r4 = r8.f5544p     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r3 = r3 + r4
            long r3 = (long) r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            long r3 = r0.skip(r3)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r5 = r8.f5540l     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r6 = r8.f5544p     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r5 = r5 + r6
            long r5 = (long) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            java.lang.String r4 = "Corrupted image"
            if (r3 != 0) goto L_0x007c
            int r3 = r8.f5541m     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r5 = r0.read(r3)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r6 = r8.f5541m     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            if (r5 != r6) goto L_0x0076
            r8.f5542n = r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            androidx.exifinterface.media.b.c(r0)
            if (r2 == 0) goto L_0x0075
            androidx.exifinterface.media.b.b(r2)
        L_0x0075:
            return r3
        L_0x0076:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            throw r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
        L_0x007c:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            throw r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
        L_0x0082:
            r1 = move-exception
            r7 = r1
            r1 = r0
        L_0x0085:
            r0 = r7
            goto L_0x0091
        L_0x0087:
            r2 = move-exception
            r7 = r2
            r2 = r0
            goto L_0x0085
        L_0x008b:
            r2 = r0
            r0 = r1
            goto L_0x009c
        L_0x008e:
            r2 = move-exception
            r0 = r2
            r2 = r1
        L_0x0091:
            androidx.exifinterface.media.b.c(r1)
            if (r2 == 0) goto L_0x0099
            androidx.exifinterface.media.b.b(r2)
        L_0x0099:
            throw r0
        L_0x009a:
            r0 = r1
            r2 = r0
        L_0x009c:
            androidx.exifinterface.media.b.c(r0)
            if (r2 == 0) goto L_0x00a4
            androidx.exifinterface.media.b.b(r2)
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.w():byte[]");
    }

    private static class g extends b {
        g(byte[] bArr) throws IOException {
            super(bArr);
            this.f5555a.mark(a.e.API_PRIORITY_OTHER);
        }

        public void f(long j10) throws IOException {
            int i10 = this.f5557c;
            if (((long) i10) > j10) {
                this.f5557c = 0;
                this.f5555a.reset();
            } else {
                j10 -= (long) i10;
            }
            e((int) j10);
        }

        g(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f5555a.mark(a.e.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f5565a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5566b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5567c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5568d;

        e(String str, int i10, int i11) {
            this.f5566b = str;
            this.f5565a = i10;
            this.f5567c = i11;
            this.f5568d = -1;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i10) {
            int i11;
            int i12 = this.f5567c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f5568d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            if ((i12 == 12 || i11 == 12) && i10 == 11) {
                return true;
            }
            return false;
        }

        e(String str, int i10, int i11, int i12) {
            this.f5566b = str;
            this.f5565a = i10;
            this.f5567c = i11;
            this.f5568d = i12;
        }
    }

    public a(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public a(@NonNull InputStream inputStream, int i10) throws IOException {
        e[][] eVarArr = f5511j0;
        this.f5534f = new HashMap[eVarArr.length];
        this.f5535g = new HashSet(eVarArr.length);
        this.f5536h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f5529a = null;
            if (i10 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f5518q0.length);
                if (C(bufferedInputStream)) {
                    this.f5533e = true;
                    this.f5531c = null;
                    this.f5530b = null;
                    inputStream = bufferedInputStream;
                } else {
                    return;
                }
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f5531c = (AssetManager.AssetInputStream) inputStream;
                this.f5530b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (K(fileInputStream.getFD())) {
                        this.f5531c = null;
                        this.f5530b = fileInputStream.getFD();
                    }
                }
                this.f5531c = null;
                this.f5530b = null;
            }
            P(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
