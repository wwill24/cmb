package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.StreamInfo;

final class k extends StreamInfo {

    /* renamed from: d  reason: collision with root package name */
    private final int f3386d;

    /* renamed from: e  reason: collision with root package name */
    private final StreamInfo.StreamState f3387e;

    k(int i10, StreamInfo.StreamState streamState) {
        this.f3386d = i10;
        if (streamState != null) {
            this.f3387e = streamState;
            return;
        }
        throw new NullPointerException("Null streamState");
    }

    public int a() {
        return this.f3386d;
    }

    @NonNull
    public StreamInfo.StreamState b() {
        return this.f3387e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamInfo)) {
            return false;
        }
        StreamInfo streamInfo = (StreamInfo) obj;
        if (this.f3386d != streamInfo.a() || !this.f3387e.equals(streamInfo.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f3386d ^ 1000003) * 1000003) ^ this.f3387e.hashCode();
    }

    public String toString() {
        return "StreamInfo{id=" + this.f3386d + ", streamState=" + this.f3387e + "}";
    }
}
