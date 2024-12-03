package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;
import androidx.camera.core.o1;
import java.nio.ByteBuffer;

final class a implements o1 {

    /* renamed from: a  reason: collision with root package name */
    private final Image f2167a;

    /* renamed from: b  reason: collision with root package name */
    private final C0016a[] f2168b;

    /* renamed from: c  reason: collision with root package name */
    private final l1 f2169c;

    /* renamed from: androidx.camera.core.a$a  reason: collision with other inner class name */
    private static final class C0016a implements o1.a {

        /* renamed from: a  reason: collision with root package name */
        private final Image.Plane f2170a;

        C0016a(Image.Plane plane) {
            this.f2170a = plane;
        }

        @NonNull
        public ByteBuffer d() {
            return this.f2170a.getBuffer();
        }

        public int e() {
            return this.f2170a.getRowStride();
        }

        public int f() {
            return this.f2170a.getPixelStride();
        }
    }

    a(@NonNull Image image) {
        this.f2167a = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.f2168b = new C0016a[planes.length];
            for (int i10 = 0; i10 < planes.length; i10++) {
                this.f2168b[i10] = new C0016a(planes[i10]);
            }
        } else {
            this.f2168b = new C0016a[0];
        }
        this.f2169c = u1.e(a2.a(), image.getTimestamp(), 0, new Matrix());
    }

    @NonNull
    public o1.a[] M0() {
        return this.f2168b;
    }

    @NonNull
    public Rect X0() {
        return this.f2167a.getCropRect();
    }

    public void close() {
        this.f2167a.close();
    }

    public int getFormat() {
        return this.f2167a.getFormat();
    }

    public int getHeight() {
        return this.f2167a.getHeight();
    }

    public int getWidth() {
        return this.f2167a.getWidth();
    }

    public void p0(Rect rect) {
        this.f2167a.setCropRect(rect);
    }

    public Image t() {
        return this.f2167a;
    }

    @NonNull
    public l1 z1() {
        return this.f2169c;
    }
}
