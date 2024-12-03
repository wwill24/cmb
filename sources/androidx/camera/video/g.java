package androidx.camera.video;

import android.net.Uri;
import androidx.annotation.NonNull;

final class g extends o {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f3110a;

    g(Uri uri) {
        if (uri != null) {
            this.f3110a = uri;
            return;
        }
        throw new NullPointerException("Null outputUri");
    }

    @NonNull
    public Uri a() {
        return this.f3110a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return this.f3110a.equals(((o) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f3110a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.f3110a + "}";
    }
}
