package b2;

import android.app.Notification;
import androidx.annotation.NonNull;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f7734a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7735b;

    /* renamed from: c  reason: collision with root package name */
    private final Notification f7736c;

    public b(int i10, @NonNull Notification notification, int i11) {
        this.f7734a = i10;
        this.f7736c = notification;
        this.f7735b = i11;
    }

    public int a() {
        return this.f7735b;
    }

    @NonNull
    public Notification b() {
        return this.f7736c;
    }

    public int c() {
        return this.f7734a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f7734a == bVar.f7734a && this.f7735b == bVar.f7735b) {
            return this.f7736c.equals(bVar.f7736c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f7734a * 31) + this.f7735b) * 31) + this.f7736c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f7734a + ", mForegroundServiceType=" + this.f7735b + ", mNotification=" + this.f7736c + '}';
    }
}
