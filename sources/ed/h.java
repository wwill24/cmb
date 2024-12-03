package ed;

import androidx.annotation.NonNull;
import cd.b;
import java.util.Arrays;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final b f40745a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f40746b;

    public h(@NonNull b bVar, @NonNull byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f40745a = bVar;
            this.f40746b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public byte[] a() {
        return this.f40746b;
    }

    public b b() {
        return this.f40745a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f40745a.equals(hVar.f40745a)) {
            return false;
        }
        return Arrays.equals(this.f40746b, hVar.f40746b);
    }

    public int hashCode() {
        return ((this.f40745a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f40746b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f40745a + ", bytes=[...]}";
    }
}
