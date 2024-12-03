package fd;

import ed.i;
import fd.e;
import java.util.Arrays;

final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<i> f40795a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f40796b;

    static final class b extends e.a {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<i> f40797a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f40798b;

        b() {
        }

        public e a() {
            String str = "";
            if (this.f40797a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new a(this.f40797a, this.f40798b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public e.a b(Iterable<i> iterable) {
            if (iterable != null) {
                this.f40797a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public e.a c(byte[] bArr) {
            this.f40798b = bArr;
            return this;
        }
    }

    public Iterable<i> b() {
        return this.f40795a;
    }

    public byte[] c() {
        return this.f40796b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f40795a.equals(eVar.b())) {
            byte[] bArr2 = this.f40796b;
            if (eVar instanceof a) {
                bArr = ((a) eVar).f40796b;
            } else {
                bArr = eVar.c();
            }
            if (Arrays.equals(bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f40795a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f40796b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f40795a + ", extras=" + Arrays.toString(this.f40796b) + "}";
    }

    private a(Iterable<i> iterable, byte[] bArr) {
        this.f40795a = iterable;
        this.f40796b = bArr;
    }
}
