package zg;

import android.media.Image;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Image f24800a;

    b(Image image) {
        this.f24800a = image;
    }

    /* access modifiers changed from: package-private */
    public final Image a() {
        return this.f24800a;
    }

    /* access modifiers changed from: package-private */
    public final Image.Plane[] b() {
        return this.f24800a.getPlanes();
    }
}
