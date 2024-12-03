package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import com.google.firebase.sessions.settings.RemoteSettings;

final class m {

    /* renamed from: a  reason: collision with root package name */
    private final long f2684a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2685b;

    m(long j10, long j11) {
        this.f2684a = j10;
        this.f2685b = j11;
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f2685b;
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f2684a;
    }

    @NonNull
    public String toString() {
        return this.f2684a + RemoteSettings.FORWARD_SLASH_STRING + this.f2685b;
    }

    m(double d10) {
        this((long) (d10 * 10000.0d), 10000);
    }
}
