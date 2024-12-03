package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.impl.x0;
import java.util.concurrent.Executor;

public final /* synthetic */ class b implements ImageReader.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f2175a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f2176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x0.a f2177c;

    public /* synthetic */ b(d dVar, Executor executor, x0.a aVar) {
        this.f2175a = dVar;
        this.f2176b = executor;
        this.f2177c = aVar;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.f2175a.k(this.f2176b, this.f2177c, imageReader);
    }
}
