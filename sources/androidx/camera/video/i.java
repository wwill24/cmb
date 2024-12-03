package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.Recorder;
import androidx.core.util.a;
import b0.e;
import java.util.concurrent.Executor;

final class i extends Recorder.h {

    /* renamed from: f  reason: collision with root package name */
    private final e f3142f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f3143g;

    /* renamed from: h  reason: collision with root package name */
    private final a<i0> f3144h;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f3145j;

    /* renamed from: k  reason: collision with root package name */
    private final long f3146k;

    i(e eVar, Executor executor, a<i0> aVar, boolean z10, long j10) {
        if (eVar != null) {
            this.f3142f = eVar;
            this.f3143g = executor;
            this.f3144h = aVar;
            this.f3145j = z10;
            this.f3146k = j10;
            return;
        }
        throw new NullPointerException("Null getOutputOptions");
    }

    public boolean equals(Object obj) {
        Executor executor;
        a<i0> aVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Recorder.h)) {
            return false;
        }
        Recorder.h hVar = (Recorder.h) obj;
        if (!this.f3142f.equals(hVar.v()) || ((executor = this.f3143g) != null ? !executor.equals(hVar.n()) : hVar.n() != null) || ((aVar = this.f3144h) != null ? !aVar.equals(hVar.u()) : hVar.u() != null) || this.f3145j != hVar.y() || this.f3146k != hVar.x()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int i11;
        int hashCode = (this.f3142f.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.f3143g;
        int i12 = 0;
        if (executor == null) {
            i10 = 0;
        } else {
            i10 = executor.hashCode();
        }
        int i13 = (hashCode ^ i10) * 1000003;
        a<i0> aVar = this.f3144h;
        if (aVar != null) {
            i12 = aVar.hashCode();
        }
        int i14 = (i13 ^ i12) * 1000003;
        if (this.f3145j) {
            i11 = 1231;
        } else {
            i11 = 1237;
        }
        long j10 = this.f3146k;
        return ((i14 ^ i11) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    /* access modifiers changed from: package-private */
    public Executor n() {
        return this.f3143g;
    }

    public String toString() {
        return "RecordingRecord{getOutputOptions=" + this.f3142f + ", getCallbackExecutor=" + this.f3143g + ", getEventListener=" + this.f3144h + ", hasAudioEnabled=" + this.f3145j + ", getRecordingId=" + this.f3146k + "}";
    }

    /* access modifiers changed from: package-private */
    public a<i0> u() {
        return this.f3144h;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e v() {
        return this.f3142f;
    }

    /* access modifiers changed from: package-private */
    public long x() {
        return this.f3146k;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.f3145j;
    }
}
