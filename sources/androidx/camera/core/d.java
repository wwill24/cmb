package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.n;
import androidx.camera.core.impl.x0;
import java.util.concurrent.Executor;

class d implements x0 {

    /* renamed from: a  reason: collision with root package name */
    private final ImageReader f2208a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f2209b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f2210c = true;

    d(ImageReader imageReader) {
        this.f2208a = imageReader;
    }

    private boolean i(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(x0.a aVar) {
        aVar.a(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Executor executor, x0.a aVar, ImageReader imageReader) {
        synchronized (this.f2209b) {
            if (!this.f2210c) {
                executor.execute(new c(this, aVar));
            }
        }
    }

    public o1 b() {
        Image image;
        synchronized (this.f2209b) {
            try {
                image = this.f2208a.acquireLatestImage();
            } catch (RuntimeException e10) {
                if (i(e10)) {
                    image = null;
                } else {
                    throw e10;
                }
            }
            if (image == null) {
                return null;
            }
            a aVar = new a(image);
            return aVar;
        }
    }

    public int c() {
        int imageFormat;
        synchronized (this.f2209b) {
            imageFormat = this.f2208a.getImageFormat();
        }
        return imageFormat;
    }

    public void close() {
        synchronized (this.f2209b) {
            this.f2208a.close();
        }
    }

    public void d() {
        synchronized (this.f2209b) {
            this.f2210c = true;
            this.f2208a.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
        }
    }

    public int e() {
        int maxImages;
        synchronized (this.f2209b) {
            maxImages = this.f2208a.getMaxImages();
        }
        return maxImages;
    }

    public void f(@NonNull x0.a aVar, @NonNull Executor executor) {
        synchronized (this.f2209b) {
            this.f2210c = false;
            this.f2208a.setOnImageAvailableListener(new b(this, executor, aVar), n.a());
        }
    }

    public o1 g() {
        Image image;
        synchronized (this.f2209b) {
            try {
                image = this.f2208a.acquireNextImage();
            } catch (RuntimeException e10) {
                if (i(e10)) {
                    image = null;
                } else {
                    throw e10;
                }
            }
            if (image == null) {
                return null;
            }
            a aVar = new a(image);
            return aVar;
        }
    }

    public int getHeight() {
        int height;
        synchronized (this.f2209b) {
            height = this.f2208a.getHeight();
        }
        return height;
    }

    public Surface getSurface() {
        Surface surface;
        synchronized (this.f2209b) {
            surface = this.f2208a.getSurface();
        }
        return surface;
    }

    public int getWidth() {
        int width;
        synchronized (this.f2209b) {
            width = this.f2208a.getWidth();
        }
        return width;
    }
}
