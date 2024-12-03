package androidx.camera.video;

import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.Recorder;
import androidx.core.util.a;
import b0.e;

public final /* synthetic */ class w implements Recorder.h.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f3422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParcelFileDescriptor f3423b;

    public /* synthetic */ w(e eVar, ParcelFileDescriptor parcelFileDescriptor) {
        this.f3422a = eVar;
        this.f3423b = parcelFileDescriptor;
    }

    public final MediaMuxer a(int i10, a aVar) {
        return Recorder.h.E(this.f3422a, this.f3423b, i10, aVar);
    }
}
