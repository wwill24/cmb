package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.l;

final class a extends LifecycleCameraRepository.a {

    /* renamed from: a  reason: collision with root package name */
    private final l f2977a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraUseCaseAdapter.a f2978b;

    a(l lVar, CameraUseCaseAdapter.a aVar) {
        if (lVar != null) {
            this.f2977a = lVar;
            if (aVar != null) {
                this.f2978b = aVar;
                return;
            }
            throw new NullPointerException("Null cameraId");
        }
        throw new NullPointerException("Null lifecycleOwner");
    }

    @NonNull
    public CameraUseCaseAdapter.a b() {
        return this.f2978b;
    }

    @NonNull
    public l c() {
        return this.f2977a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LifecycleCameraRepository.a)) {
            return false;
        }
        LifecycleCameraRepository.a aVar = (LifecycleCameraRepository.a) obj;
        if (!this.f2977a.equals(aVar.c()) || !this.f2978b.equals(aVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2977a.hashCode() ^ 1000003) * 1000003) ^ this.f2978b.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.f2977a + ", cameraId=" + this.f2978b + "}";
    }
}
