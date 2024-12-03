package com.google.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f21603a = new LiteralByteString(w.f21955d);

    /* renamed from: b  reason: collision with root package name */
    private static final e f21604b;

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<ByteString> f21605c = new b();
    private int hash = 0;

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i10, int i11) {
            super(bArr);
            ByteString.j(i10, i10 + i11, bArr.length);
            this.bytesOffset = i10;
            this.bytesLength = i11;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        /* access modifiers changed from: protected */
        public int b0() {
            return this.bytesOffset;
        }

        public byte g(int i10) {
            ByteString.i(i10, size());
            return this.bytes[this.bytesOffset + i10];
        }

        public int size() {
            return this.bytesLength;
        }

        /* access modifiers changed from: protected */
        public void v(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.bytes, b0() + i10, bArr, i11, i12);
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return ByteString.W(N());
        }

        /* access modifiers changed from: package-private */
        public byte y(int i10) {
            return this.bytes[this.bytesOffset + i10];
        }
    }

    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a0(ByteString byteString, int i10, int i11);

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ByteString.super.iterator();
        }

        /* access modifiers changed from: protected */
        public final int w() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean z() {
            return true;
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        public final boolean A() {
            int b02 = b0();
            return Utf8.t(this.bytes, b02, size() + b02);
        }

        public final h D() {
            return h.m(this.bytes, b0(), size(), true);
        }

        /* access modifiers changed from: protected */
        public final int H(int i10, int i11, int i12) {
            return w.i(i10, this.bytes, b0() + i11, i12);
        }

        /* access modifiers changed from: protected */
        public final int J(int i10, int i11, int i12) {
            int b02 = b0() + i11;
            return Utf8.v(i10, this.bytes, b02, i12 + b02);
        }

        public final ByteString M(int i10, int i11) {
            int j10 = ByteString.j(i10, i11, size());
            if (j10 == 0) {
                return ByteString.f21603a;
            }
            return new BoundedByteString(this.bytes, b0() + i10, j10);
        }

        /* access modifiers changed from: protected */
        public final String R(Charset charset) {
            return new String(this.bytes, b0(), size(), charset);
        }

        /* access modifiers changed from: package-private */
        public final void Z(g gVar) throws IOException {
            gVar.b(this.bytes, b0(), size());
        }

        /* access modifiers changed from: package-private */
        public final boolean a0(ByteString byteString, int i10, int i11) {
            if (i11 <= byteString.size()) {
                int i12 = i10 + i11;
                if (i12 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.M(i10, i12).equals(M(0, i11));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = literalByteString.bytes;
                    int b02 = b0() + i11;
                    int b03 = b0();
                    int b04 = literalByteString.b0() + i10;
                    while (b03 < b02) {
                        if (bArr[b03] != bArr2[b04]) {
                            return false;
                        }
                        b03++;
                        b04++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
        }

        /* access modifiers changed from: protected */
        public int b0() {
            return 0;
        }

        public final ByteBuffer d() {
            return ByteBuffer.wrap(this.bytes, b0(), size()).asReadOnlyBuffer();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int K = K();
            int K2 = literalByteString.K();
            if (K == 0 || K2 == 0 || K == K2) {
                return a0(literalByteString, 0, size());
            }
            return false;
        }

        public byte g(int i10) {
            return this.bytes[i10];
        }

        public int size() {
            return this.bytes.length;
        }

        /* access modifiers changed from: protected */
        public void v(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.bytes, i10, bArr, i11, i12);
        }

        /* access modifiers changed from: package-private */
        public byte y(int i10) {
            return this.bytes[i10];
        }
    }

    class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private int f21606a = 0;

        /* renamed from: b  reason: collision with root package name */
        private final int f21607b;

        a() {
            this.f21607b = ByteString.this.size();
        }

        public byte b() {
            int i10 = this.f21606a;
            if (i10 < this.f21607b) {
                this.f21606a = i10 + 1;
                return ByteString.this.y(i10);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f21606a < this.f21607b;
        }
    }

    class b implements Comparator<ByteString> {
        b() {
        }

        /* renamed from: a */
        public int compare(ByteString byteString, ByteString byteString2) {
            f B = byteString.iterator();
            f B2 = byteString2.iterator();
            while (B.hasNext() && B2.hasNext()) {
                int compareTo = Integer.valueOf(ByteString.P(B.b())).compareTo(Integer.valueOf(ByteString.P(B2.b())));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
        }
    }

    static abstract class c implements f {
        c() {
        }

        /* renamed from: a */
        public final Byte next() {
            return Byte.valueOf(b());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class d implements e {
        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        public byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }
    }

    private interface e {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    public interface f extends Iterator<Byte> {
        byte b();
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f21609a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f21610b;

        /* synthetic */ g(int i10, a aVar) {
            this(i10);
        }

        public ByteString a() {
            this.f21609a.d();
            return new LiteralByteString(this.f21610b);
        }

        public CodedOutputStream b() {
            return this.f21609a;
        }

        private g(int i10) {
            byte[] bArr = new byte[i10];
            this.f21610b = bArr;
            this.f21609a = CodedOutputStream.g0(bArr);
        }
    }

    private static final class h implements e {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        public byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }
    }

    static {
        e eVar;
        if (d.c()) {
            eVar = new h((a) null);
        } else {
            eVar = new d((a) null);
        }
        f21604b = eVar;
    }

    ByteString() {
    }

    static g C(int i10) {
        return new g(i10, (a) null);
    }

    /* access modifiers changed from: private */
    public static int P(byte b10) {
        return b10 & 255;
    }

    private String U() {
        if (size() <= 50) {
            return e1.a(this);
        }
        return e1.a(M(0, 47)) + "...";
    }

    static ByteString V(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return X(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    static ByteString W(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    static ByteString X(byte[] bArr, int i10, int i11) {
        return new BoundedByteString(bArr, i10, i11);
    }

    private static ByteString f(Iterator<ByteString> it, int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i10)}));
        } else if (i10 == 1) {
            return it.next();
        } else {
            int i11 = i10 >>> 1;
            return f(it, i11).m(f(it, i10 - i11));
        }
    }

    static void i(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return;
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    static int j(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        } else if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
        }
    }

    public static ByteString n(Iterable<ByteString> iterable) {
        int i10;
        if (!(iterable instanceof Collection)) {
            i10 = 0;
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i10++;
            }
        } else {
            i10 = ((Collection) iterable).size();
        }
        if (i10 == 0) {
            return f21603a;
        }
        return f(iterable.iterator(), i10);
    }

    public static ByteString o(ByteBuffer byteBuffer) {
        return p(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString p(ByteBuffer byteBuffer, int i10) {
        j(0, i10, byteBuffer.remaining());
        byte[] bArr = new byte[i10];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString q(byte[] bArr) {
        return r(bArr, 0, bArr.length);
    }

    public static ByteString r(byte[] bArr, int i10, int i11) {
        j(i10, i10 + i11, bArr.length);
        return new LiteralByteString(f21604b.a(bArr, i10, i11));
    }

    public static ByteString s(String str) {
        return new LiteralByteString(str.getBytes(w.f21953b));
    }

    public abstract boolean A();

    /* renamed from: B */
    public f iterator() {
        return new a();
    }

    public abstract h D();

    /* access modifiers changed from: protected */
    public abstract int H(int i10, int i11, int i12);

    /* access modifiers changed from: protected */
    public abstract int J(int i10, int i11, int i12);

    /* access modifiers changed from: protected */
    public final int K() {
        return this.hash;
    }

    public final ByteString L(int i10) {
        return M(i10, size());
    }

    public abstract ByteString M(int i10, int i11);

    public final byte[] N() {
        int size = size();
        if (size == 0) {
            return w.f21955d;
        }
        byte[] bArr = new byte[size];
        v(bArr, 0, 0, size);
        return bArr;
    }

    public final String Q(Charset charset) {
        return size() == 0 ? "" : R(charset);
    }

    /* access modifiers changed from: protected */
    public abstract String R(Charset charset);

    public final String T() {
        return Q(w.f21953b);
    }

    /* access modifiers changed from: package-private */
    public abstract void Z(g gVar) throws IOException;

    public abstract ByteBuffer d();

    public abstract boolean equals(Object obj);

    public abstract byte g(int i10);

    public final int hashCode() {
        int i10 = this.hash;
        if (i10 == 0) {
            int size = size();
            i10 = H(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.hash = i10;
        }
        return i10;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final ByteString m(ByteString byteString) {
        if (a.e.API_PRIORITY_OTHER - size() >= byteString.size()) {
            return RopeByteString.e0(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract int size();

    @Deprecated
    public final void t(byte[] bArr, int i10, int i11, int i12) {
        j(i10, i10 + i12, size());
        j(i11, i11 + i12, bArr.length);
        if (i12 > 0) {
            v(bArr, i10, i11, i12);
        }
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), U()});
    }

    /* access modifiers changed from: protected */
    public abstract void v(byte[] bArr, int i10, int i11, int i12);

    /* access modifiers changed from: protected */
    public abstract int w();

    /* access modifiers changed from: package-private */
    public abstract byte y(int i10);

    /* access modifiers changed from: protected */
    public abstract boolean z();
}
