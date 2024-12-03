package ed;

import com.google.android.datatransport.Priority;
import ed.p;
import java.util.Arrays;

final class d extends p {

    /* renamed from: a  reason: collision with root package name */
    private final String f40725a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f40726b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f40727c;

    static final class b extends p.a {

        /* renamed from: a  reason: collision with root package name */
        private String f40728a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f40729b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f40730c;

        b() {
        }

        public p a() {
            String str = "";
            if (this.f40728a == null) {
                str = str + " backendName";
            }
            if (this.f40730c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f40728a, this.f40729b, this.f40730c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public p.a b(String str) {
            if (str != null) {
                this.f40728a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public p.a c(byte[] bArr) {
            this.f40729b = bArr;
            return this;
        }

        public p.a d(Priority priority) {
            if (priority != null) {
                this.f40730c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public String b() {
        return this.f40725a;
    }

    public byte[] c() {
        return this.f40726b;
    }

    public Priority d() {
        return this.f40727c;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f40725a.equals(pVar.b())) {
            byte[] bArr2 = this.f40726b;
            if (pVar instanceof d) {
                bArr = ((d) pVar).f40726b;
            } else {
                bArr = pVar.c();
            }
            if (Arrays.equals(bArr2, bArr) && this.f40727c.equals(pVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f40725a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f40726b)) * 1000003) ^ this.f40727c.hashCode();
    }

    private d(String str, byte[] bArr, Priority priority) {
        this.f40725a = str;
        this.f40726b = bArr;
        this.f40727c = priority;
    }
}
