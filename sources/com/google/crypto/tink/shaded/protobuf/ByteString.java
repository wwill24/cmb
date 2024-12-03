package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f20615a = new LiteralByteString(x.f20919c);

    /* renamed from: b  reason: collision with root package name */
    private static final e f20616b;

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<ByteString> f20617c = new b();
    private int hash = 0;

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i10, int i11) {
            super(bArr);
            ByteString.g(i10, i10 + i11, bArr.length);
            this.bytesOffset = i10;
            this.bytesLength = i11;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        /* access modifiers changed from: protected */
        public int M() {
            return this.bytesOffset;
        }

        public byte d(int i10) {
            ByteString.f(i10, size());
            return this.bytes[this.bytesOffset + i10];
        }

        /* access modifiers changed from: protected */
        public void n(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.bytes, M() + i10, bArr, i11, i12);
        }

        /* access modifiers changed from: package-private */
        public byte o(int i10) {
            return this.bytes[this.bytesOffset + i10];
        }

        public int size() {
            return this.bytesLength;
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return ByteString.H(y());
        }
    }

    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        /* access modifiers changed from: protected */
        public final String B(Charset charset) {
            return new String(this.bytes, M(), size(), charset);
        }

        /* access modifiers changed from: package-private */
        public final void K(h hVar) throws IOException {
            hVar.a(this.bytes, M(), size());
        }

        /* access modifiers changed from: package-private */
        public final boolean L(ByteString byteString, int i10, int i11) {
            if (i11 <= byteString.size()) {
                int i12 = i10 + i11;
                if (i12 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.w(i10, i12).equals(w(0, i11));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = literalByteString.bytes;
                    int M = M() + i11;
                    int M2 = M();
                    int M3 = literalByteString.M() + i10;
                    while (M2 < M) {
                        if (bArr[M2] != bArr2[M3]) {
                            return false;
                        }
                        M2++;
                        M3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
        }

        /* access modifiers changed from: protected */
        public int M() {
            return 0;
        }

        public byte d(int i10) {
            return this.bytes[i10];
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
            int v10 = v();
            int v11 = literalByteString.v();
            if (v10 == 0 || v11 == 0 || v10 == v11) {
                return L(literalByteString, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void n(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.bytes, i10, bArr, i11, i12);
        }

        /* access modifiers changed from: package-private */
        public byte o(int i10) {
            return this.bytes[i10];
        }

        public final boolean p() {
            int M = M();
            return Utf8.n(this.bytes, M, size() + M);
        }

        public final i s() {
            return i.h(this.bytes, M(), size(), true);
        }

        public int size() {
            return this.bytes.length;
        }

        /* access modifiers changed from: protected */
        public final int t(int i10, int i11, int i12) {
            return x.i(i10, this.bytes, M() + i11, i12);
        }

        public final ByteString w(int i10, int i11) {
            int g10 = ByteString.g(i10, i11, size());
            if (g10 == 0) {
                return ByteString.f20615a;
            }
            return new BoundedByteString(this.bytes, M() + i10, g10);
        }
    }

    class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private int f20618a = 0;

        /* renamed from: b  reason: collision with root package name */
        private final int f20619b;

        a() {
            this.f20619b = ByteString.this.size();
        }

        public byte b() {
            int i10 = this.f20618a;
            if (i10 < this.f20619b) {
                this.f20618a = i10 + 1;
                return ByteString.this.o(i10);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f20618a < this.f20619b;
        }
    }

    class b implements Comparator<ByteString> {
        b() {
        }

        /* renamed from: a */
        public int compare(ByteString byteString, ByteString byteString2) {
            f q10 = byteString.iterator();
            f q11 = byteString2.iterator();
            while (q10.hasNext() && q11.hasNext()) {
                int compare = Integer.compare(ByteString.z(q10.b()), ByteString.z(q11.b()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
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
        private final CodedOutputStream f20621a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f20622b;

        /* synthetic */ g(int i10, a aVar) {
            this(i10);
        }

        public ByteString a() {
            this.f20621a.c();
            return new LiteralByteString(this.f20622b);
        }

        public CodedOutputStream b() {
            return this.f20621a;
        }

        private g(int i10) {
            byte[] bArr = new byte[i10];
            this.f20622b = bArr;
            this.f20621a = CodedOutputStream.d0(bArr);
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
        f20616b = eVar;
    }

    ByteString() {
    }

    private String D() {
        if (size() <= 50) {
            return e1.a(this);
        }
        return e1.a(w(0, 47)) + "...";
    }

    static ByteString H(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    static ByteString J(byte[] bArr, int i10, int i11) {
        return new BoundedByteString(bArr, i10, i11);
    }

    static void f(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return;
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    static int g(int i10, int i11, int i12) {
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

    public static ByteString i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static ByteString j(byte[] bArr, int i10, int i11) {
        g(i10, i10 + i11, bArr.length);
        return new LiteralByteString(f20616b.a(bArr, i10, i11));
    }

    public static ByteString m(String str) {
        return new LiteralByteString(str.getBytes(x.f20917a));
    }

    static g r(int i10) {
        return new g(i10, (a) null);
    }

    /* access modifiers changed from: private */
    public static int z(byte b10) {
        return b10 & 255;
    }

    public final String A(Charset charset) {
        return size() == 0 ? "" : B(charset);
    }

    /* access modifiers changed from: protected */
    public abstract String B(Charset charset);

    public final String C() {
        return A(x.f20917a);
    }

    /* access modifiers changed from: package-private */
    public abstract void K(h hVar) throws IOException;

    public abstract byte d(int i10);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.hash;
        if (i10 == 0) {
            int size = size();
            i10 = t(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.hash = i10;
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public abstract void n(byte[] bArr, int i10, int i11, int i12);

    /* access modifiers changed from: package-private */
    public abstract byte o(int i10);

    public abstract boolean p();

    /* renamed from: q */
    public f iterator() {
        return new a();
    }

    public abstract i s();

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int t(int i10, int i11, int i12);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), D()});
    }

    /* access modifiers changed from: protected */
    public final int v() {
        return this.hash;
    }

    public abstract ByteString w(int i10, int i11);

    public final byte[] y() {
        int size = size();
        if (size == 0) {
            return x.f20919c;
        }
        byte[] bArr = new byte[size];
        n(bArr, 0, 0, size);
        return bArr;
    }
}
