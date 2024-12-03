package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import net.bytebuddy.jar.asm.Opcodes;

final class RopeByteString extends ByteString {

    /* renamed from: d  reason: collision with root package name */
    static final int[] f21694d = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, Opcodes.D2F, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, a.e.API_PRIORITY_OTHER};
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final ByteString left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    class a extends ByteString.c {

        /* renamed from: a  reason: collision with root package name */
        final c f21695a;

        /* renamed from: b  reason: collision with root package name */
        ByteString.f f21696b = c();

        a() {
            this.f21695a = new c(RopeByteString.this, (a) null);
        }

        private ByteString.f c() {
            if (this.f21695a.hasNext()) {
                return this.f21695a.next().iterator();
            }
            return null;
        }

        public byte b() {
            ByteString.f fVar = this.f21696b;
            if (fVar != null) {
                byte b10 = fVar.b();
                if (!this.f21696b.hasNext()) {
                    this.f21696b = c();
                }
                return b10;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f21696b != null;
        }
    }

    private static final class c implements Iterator<ByteString.LeafByteString> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<RopeByteString> f21699a;

        /* renamed from: b  reason: collision with root package name */
        private ByteString.LeafByteString f21700b;

        /* synthetic */ c(ByteString byteString, a aVar) {
            this(byteString);
        }

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f21699a.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString c() {
            ByteString.LeafByteString a10;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.f21699a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                a10 = a(this.f21699a.pop().right);
            } while (a10.isEmpty());
            return a10;
        }

        /* renamed from: d */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f21700b;
            if (leafByteString != null) {
                this.f21700b = c();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f21700b != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.w());
                this.f21699a = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.f21700b = a(ropeByteString.left);
                return;
            }
            this.f21699a = null;
            this.f21700b = (ByteString.LeafByteString) byteString;
        }
    }

    /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, a aVar) {
        this(byteString, byteString2);
    }

    static ByteString e0(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return g0(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, g0(ropeByteString.right, byteString2));
            } else if (ropeByteString.left.w() > ropeByteString.right.w() && ropeByteString.w() > byteString2.w()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size >= j0(Math.max(byteString.w(), byteString2.w()) + 1)) {
            return new RopeByteString(byteString, byteString2);
        }
        return new b((a) null).b(byteString, byteString2);
    }

    private static ByteString g0(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.t(bArr, 0, 0, size);
        byteString2.t(bArr, 0, size, size2);
        return ByteString.W(bArr);
    }

    private boolean h0(ByteString byteString) {
        boolean z10;
        c cVar = new c(this, (a) null);
        ByteString.LeafByteString leafByteString = (ByteString.LeafByteString) cVar.next();
        c cVar2 = new c(byteString, (a) null);
        ByteString.LeafByteString leafByteString2 = (ByteString.LeafByteString) cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = leafByteString.size() - i10;
            int size2 = leafByteString2.size() - i11;
            int min = Math.min(size, size2);
            if (i10 == 0) {
                z10 = leafByteString.a0(leafByteString2, i11, min);
            } else {
                z10 = leafByteString2.a0(leafByteString, i10, min);
            }
            if (!z10) {
                return false;
            }
            i12 += min;
            int i13 = this.totalLength;
            if (i12 < i13) {
                if (min == size) {
                    leafByteString = (ByteString.LeafByteString) cVar.next();
                    i10 = 0;
                } else {
                    i10 += min;
                }
                if (min == size2) {
                    leafByteString2 = (ByteString.LeafByteString) cVar2.next();
                    i11 = 0;
                } else {
                    i11 += min;
                }
            } else if (i12 == i13) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    static int j0(int i10) {
        int[] iArr = f21694d;
        if (i10 >= iArr.length) {
            return a.e.API_PRIORITY_OTHER;
        }
        return iArr[i10];
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    public boolean A() {
        int J = this.left.J(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.J(J, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: B */
    public ByteString.f iterator() {
        return new a();
    }

    public h D() {
        return h.h(d0(), true);
    }

    /* access modifiers changed from: protected */
    public int H(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            return this.left.H(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.right.H(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.right.H(this.left.H(i10, i11, i15), 0, i12 - i15);
    }

    /* access modifiers changed from: protected */
    public int J(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            return this.left.J(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.right.J(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.right.J(this.left.J(i10, i11, i15), 0, i12 - i15);
    }

    public ByteString M(int i10, int i11) {
        int j10 = ByteString.j(i10, i11, this.totalLength);
        if (j10 == 0) {
            return ByteString.f21603a;
        }
        if (j10 == this.totalLength) {
            return this;
        }
        int i12 = this.leftLength;
        if (i11 <= i12) {
            return this.left.M(i10, i11);
        }
        if (i10 >= i12) {
            return this.right.M(i10 - i12, i11 - i12);
        }
        return new RopeByteString(this.left.L(i10), this.right.M(0, i11 - this.leftLength));
    }

    /* access modifiers changed from: protected */
    public String R(Charset charset) {
        return new String(N(), charset);
    }

    /* access modifiers changed from: package-private */
    public void Z(g gVar) throws IOException {
        this.left.Z(gVar);
        this.right.Z(gVar);
    }

    public ByteBuffer d() {
        return ByteBuffer.wrap(N()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> d0() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, (a) null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().d());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int K = K();
        int K2 = byteString.K();
        if (K == 0 || K2 == 0 || K == K2) {
            return h0(byteString);
        }
        return false;
    }

    public byte g(int i10) {
        ByteString.i(i10, this.totalLength);
        return y(i10);
    }

    public int size() {
        return this.totalLength;
    }

    /* access modifiers changed from: protected */
    public void v(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            this.left.v(bArr, i10, i11, i12);
        } else if (i10 >= i14) {
            this.right.v(bArr, i10 - i14, i11, i12);
        } else {
            int i15 = i14 - i10;
            this.left.v(bArr, i10, i11, i15);
            this.right.v(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    /* access modifiers changed from: protected */
    public int w() {
        return this.treeDepth;
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return ByteString.W(N());
    }

    /* access modifiers changed from: package-private */
    public byte y(int i10) {
        int i11 = this.leftLength;
        if (i10 < i11) {
            return this.left.y(i10);
        }
        return this.right.y(i10 - i11);
    }

    /* access modifiers changed from: protected */
    public boolean z() {
        return this.totalLength >= j0(this.treeDepth);
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<ByteString> f21698a;

        private b() {
            this.f21698a = new ArrayDeque<>();
        }

        /* access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f21698a.pop();
            while (!this.f21698a.isEmpty()) {
                pop = new RopeByteString(this.f21698a.pop(), pop, (a) null);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.z()) {
                e(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.left);
                c(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i10) {
            int binarySearch = Arrays.binarySearch(RopeByteString.f21694d, i10);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(ByteString byteString) {
            int d10 = d(byteString.size());
            int j02 = RopeByteString.j0(d10 + 1);
            if (this.f21698a.isEmpty() || this.f21698a.peek().size() >= j02) {
                this.f21698a.push(byteString);
                return;
            }
            int j03 = RopeByteString.j0(d10);
            ByteString pop = this.f21698a.pop();
            while (!this.f21698a.isEmpty() && this.f21698a.peek().size() < j03) {
                pop = new RopeByteString(this.f21698a.pop(), pop, (a) null);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString, (a) null);
            while (!this.f21698a.isEmpty() && this.f21698a.peek().size() < RopeByteString.j0(d(ropeByteString.size()) + 1)) {
                ropeByteString = new RopeByteString(this.f21698a.pop(), ropeByteString, (a) null);
            }
            this.f21698a.push(ropeByteString);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.w(), byteString2.w()) + 1;
    }
}
