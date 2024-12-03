package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.m;

final class e extends m.b {

    /* renamed from: b  reason: collision with root package name */
    private final q f3098b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3099c;

    e(q qVar, int i10) {
        if (qVar != null) {
            this.f3098b = qVar;
            this.f3099c = i10;
            return;
        }
        throw new NullPointerException("Null fallbackQuality");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public q b() {
        return this.f3098b;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f3099c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m.b)) {
            return false;
        }
        m.b bVar = (m.b) obj;
        if (!this.f3098b.equals(bVar.b()) || this.f3099c != bVar.c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f3098b.hashCode() ^ 1000003) * 1000003) ^ this.f3099c;
    }

    public String toString() {
        return "RuleStrategy{fallbackQuality=" + this.f3098b + ", fallbackRule=" + this.f3099c + "}";
    }
}
