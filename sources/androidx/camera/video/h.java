package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.q;

final class h extends q.b {

    /* renamed from: j  reason: collision with root package name */
    private final int f3138j;

    /* renamed from: k  reason: collision with root package name */
    private final String f3139k;

    h(int i10, String str) {
        this.f3138j = i10;
        if (str != null) {
            this.f3139k = str;
            return;
        }
        throw new NullPointerException("Null name");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String c() {
        return this.f3139k;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f3138j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q.b)) {
            return false;
        }
        q.b bVar = (q.b) obj;
        if (this.f3138j != bVar.d() || !this.f3139k.equals(bVar.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f3138j ^ 1000003) * 1000003) ^ this.f3139k.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.f3138j + ", name=" + this.f3139k + "}";
    }
}
