package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.internal.e;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0016\u0018\u0000 M2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001NB\u0011\b\u0000\u0012\u0006\u0010=\u001a\u00020 ¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u0000J\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\u001c\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0014H\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010!\u001a\u00020 H\u0016J\u000f\u0010\"\u001a\u00020 H\u0010¢\u0006\u0004\b\"\u0010#J'\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0014H\u0010¢\u0006\u0004\b(\u0010)J(\u0010-\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0014H\u0016J(\u0010.\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0014H\u0016J\u000e\u00100\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0000J\u000e\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020\u0000J\u001a\u00104\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00002\b\b\u0002\u00103\u001a\u00020\u0014H\u0007J\u001a\u00105\u001a\u00020\u00142\u0006\u0010*\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020\u0014H\u0017J\u001a\u00106\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00002\b\b\u0002\u00103\u001a\u00020\u0014H\u0007J\u001a\u00107\u001a\u00020\u00142\u0006\u0010*\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020\u0014H\u0017J\u0013\u00109\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u000108H\u0002J\b\u0010:\u001a\u00020\u0014H\u0016J\u0011\u0010;\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0000H\u0002J\b\u0010<\u001a\u00020\nH\u0016R\u001a\u0010=\u001a\u00020 8\u0000X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010#R\"\u0010:\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\f\u00100\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010BR$\u0010H\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b;\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010J\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\bI\u0010\u001f¨\u0006O"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "", "readObject", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "", "Q", "a", "D", "G", "algorithm", "d", "(Ljava/lang/String;)Lokio/ByteString;", "p", "M", "", "beginIndex", "endIndex", "J", "pos", "", "v", "(I)B", "index", "i", "l", "()I", "", "N", "t", "()[B", "Lokio/Buffer;", "buffer", "offset", "byteCount", "R", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "z", "A", "prefix", "I", "suffix", "h", "fromIndex", "q", "r", "w", "x", "", "equals", "hashCode", "b", "toString", "data", "[B", "j", "k", "B", "(I)V", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "C", "(Ljava/lang/String;)V", "utf8", "H", "size", "<init>", "([B)V", "c", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f33308c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f33309d = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private transient int f33310a;

    /* renamed from: b  reason: collision with root package name */
    private transient String f33311b;
    private final byte[] data;

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\n\u001a\u00020\u0006*\u00020\tH\u0007J\u001d\u0010\r\u001a\u00020\u0006*\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u000f\u001a\u00020\u0006*\u00020\tH\u0007J\u001b\u0010\u0011\u001a\u00020\u0006*\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokio/ByteString$Companion;", "", "", "", "offset", "byteCount", "Lokio/ByteString;", "d", "([BII)Lokio/ByteString;", "", "c", "Ljava/nio/charset/Charset;", "charset", "b", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "a", "Ljava/io/InputStream;", "f", "(Ljava/io/InputStream;I)Lokio/ByteString;", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString e(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = _UtilKt.c();
            }
            return companion.d(bArr, i10, i11);
        }

        public final ByteString a(String str) {
            boolean z10;
            j.g(str, "<this>");
            if (str.length() % 2 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = i10 * 2;
                    bArr[i10] = (byte) ((e.e(str.charAt(i11)) << 4) + e.e(str.charAt(i11 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final ByteString b(String str, Charset charset) {
            j.g(str, "<this>");
            j.g(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            j.f(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString c(String str) {
            j.g(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.a(str));
            byteString.C(str);
            return byteString;
        }

        public final ByteString d(byte[] bArr, int i10, int i11) {
            j.g(bArr, "<this>");
            int e10 = _UtilKt.e(bArr, i11);
            _UtilKt.b((long) bArr.length, (long) i10, (long) e10);
            return new ByteString(k.j(bArr, i10, e10 + i10));
        }

        public final ByteString f(InputStream inputStream, int i10) throws IOException {
            boolean z10;
            j.g(inputStream, "<this>");
            int i11 = 0;
            if (i10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                byte[] bArr = new byte[i10];
                while (i11 < i10) {
                    int read = inputStream.read(bArr, i11, i10 - i11);
                    if (read != -1) {
                        i11 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
        }
    }

    public ByteString(byte[] bArr) {
        j.g(bArr, "data");
        this.data = bArr;
    }

    public static /* synthetic */ ByteString K(ByteString byteString, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = _UtilKt.c();
            }
            return byteString.J(i10, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public static final ByteString c(String str) {
        return f33308c.a(str);
    }

    public static final ByteString e(String str) {
        return f33308c.c(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString f10 = f33308c.f(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, f10.data);
    }

    public static /* synthetic */ int s(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return byteString.q(byteString2, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public static /* synthetic */ int y(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = _UtilKt.c();
            }
            return byteString.w(byteString2, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public boolean A(int i10, byte[] bArr, int i11, int i12) {
        j.g(bArr, "other");
        if (i10 < 0 || i10 > j().length - i12 || i11 < 0 || i11 > bArr.length - i12 || !_UtilKt.a(j(), i10, bArr, i11, i12)) {
            return false;
        }
        return true;
    }

    public final void B(int i10) {
        this.f33310a = i10;
    }

    public final void C(String str) {
        this.f33311b = str;
    }

    public final ByteString D() {
        return d("SHA-1");
    }

    public final ByteString G() {
        return d("SHA-256");
    }

    public final int H() {
        return l();
    }

    public final boolean I(ByteString byteString) {
        j.g(byteString, "prefix");
        return z(0, byteString, 0, byteString.H());
    }

    public ByteString J(int i10, int i11) {
        boolean z10;
        boolean z11;
        int d10 = _UtilKt.d(this, i11);
        boolean z12 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (d10 <= j().length) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (d10 - i10 < 0) {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i10 == 0 && d10 == j().length) {
                    return this;
                } else {
                    return new ByteString(k.j(j(), i10, d10));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + j().length + PropertyUtils.MAPPED_DELIM2).toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public ByteString M() {
        byte b10;
        int i10 = 0;
        while (i10 < j().length) {
            byte b11 = j()[i10];
            byte b12 = (byte) 65;
            if (b11 < b12 || b11 > (b10 = (byte) 90)) {
                i10++;
            } else {
                byte[] j10 = j();
                byte[] copyOf = Arrays.copyOf(j10, j10.length);
                j.f(copyOf, "copyOf(this, size)");
                copyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] N() {
        byte[] j10 = j();
        byte[] copyOf = Arrays.copyOf(j10, j10.length);
        j.f(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public String Q() {
        String o10 = o();
        if (o10 != null) {
            return o10;
        }
        String b10 = _JvmPlatformKt.b(t());
        C(b10);
        return b10;
    }

    public void R(Buffer buffer, int i10, int i11) {
        j.g(buffer, "buffer");
        e.d(this, buffer, i10, i11);
    }

    public String a() {
        return _Base64Kt.b(j(), (byte[]) null, 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r7 < r8) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r0 < r1) goto L_0x0030;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.j.g(r10, r0)
            int r0 = r9.H()
            int r1 = r10.H()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.i(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.i(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = r5
            goto L_0x0033
        L_0x0032:
            r3 = r6
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public ByteString d(String str) {
        j.g(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(this.data, 0, H());
        byte[] digest = instance.digest();
        j.f(digest, "digestBytes");
        return new ByteString(digest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.H() == j().length && byteString.A(0, j(), 0, j().length)) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(ByteString byteString) {
        j.g(byteString, "suffix");
        return z(H() - byteString.H(), byteString, 0, byteString.H());
    }

    public int hashCode() {
        int k10 = k();
        if (k10 != 0) {
            return k10;
        }
        int hashCode = Arrays.hashCode(j());
        B(hashCode);
        return hashCode;
    }

    public final byte i(int i10) {
        return v(i10);
    }

    public final byte[] j() {
        return this.data;
    }

    public final int k() {
        return this.f33310a;
    }

    public int l() {
        return j().length;
    }

    public final String o() {
        return this.f33311b;
    }

    public String p() {
        char[] cArr = new char[(j().length * 2)];
        int i10 = 0;
        for (byte b10 : j()) {
            int i11 = i10 + 1;
            cArr[i10] = e.f()[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = e.f()[b10 & 15];
        }
        return r.p(cArr);
    }

    public final int q(ByteString byteString, int i10) {
        j.g(byteString, "other");
        return r(byteString.t(), i10);
    }

    public int r(byte[] bArr, int i10) {
        j.g(bArr, "other");
        int length = j().length - bArr.length;
        int max = Math.max(i10, 0);
        if (max <= length) {
            while (!_UtilKt.a(j(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public byte[] t() {
        return j();
    }

    public String toString() {
        boolean z10;
        boolean z11;
        ByteString byteString;
        String str;
        boolean z12 = true;
        if (j().length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            str = "[size=0]";
        } else {
            int a10 = e.c(j(), 64);
            if (a10 != -1) {
                String Q = Q();
                String substring = Q.substring(0, a10);
                j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String D = r.D(r.D(r.D(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (a10 < Q.length()) {
                    return "[size=" + j().length + " text=" + D + "…]";
                }
                return "[text=" + D + PropertyUtils.INDEXED_DELIM2;
            } else if (j().length <= 64) {
                str = "[hex=" + p() + PropertyUtils.INDEXED_DELIM2;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(j().length);
                sb2.append(" hex=");
                int d10 = _UtilKt.d(this, 64);
                if (d10 <= j().length) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (d10 + 0 < 0) {
                        z12 = false;
                    }
                    if (z12) {
                        if (d10 == j().length) {
                            byteString = this;
                        } else {
                            byteString = new ByteString(k.j(j(), 0, d10));
                        }
                        sb2.append(byteString.p());
                        sb2.append("…]");
                        return sb2.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + j().length + PropertyUtils.MAPPED_DELIM2).toString());
            }
        }
        return str;
    }

    public byte v(int i10) {
        return j()[i10];
    }

    public final int w(ByteString byteString, int i10) {
        j.g(byteString, "other");
        return x(byteString.t(), i10);
    }

    public int x(byte[] bArr, int i10) {
        j.g(bArr, "other");
        for (int min = Math.min(_UtilKt.d(this, i10), j().length - bArr.length); -1 < min; min--) {
            if (_UtilKt.a(j(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean z(int i10, ByteString byteString, int i11, int i12) {
        j.g(byteString, "other");
        return byteString.A(i11, j(), i10, i12);
    }
}
