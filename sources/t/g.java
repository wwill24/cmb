package t;

import androidx.annotation.NonNull;
import androidx.camera.core.o1;
import t.a0;

final class g extends a0.b {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f17566a;

    /* renamed from: b  reason: collision with root package name */
    private final o1 f17567b;

    g(b0 b0Var, o1 o1Var) {
        if (b0Var != null) {
            this.f17566a = b0Var;
            if (o1Var != null) {
                this.f17567b = o1Var;
                return;
            }
            throw new NullPointerException("Null imageProxy");
        }
        throw new NullPointerException("Null processingRequest");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public o1 a() {
        return this.f17567b;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public b0 b() {
        return this.f17566a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0.b)) {
            return false;
        }
        a0.b bVar = (a0.b) obj;
        if (!this.f17566a.equals(bVar.b()) || !this.f17567b.equals(bVar.a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f17566a.hashCode() ^ 1000003) * 1000003) ^ this.f17567b.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.f17566a + ", imageProxy=" + this.f17567b + "}";
    }
}
