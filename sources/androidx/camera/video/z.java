package androidx.camera.video;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.Recorder;
import androidx.core.util.a;

public final /* synthetic */ class z implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ParcelFileDescriptor f3427a;

    public /* synthetic */ z(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3427a = parcelFileDescriptor;
    }

    public final void accept(Object obj) {
        Recorder.h.J(this.f3427a, (Uri) obj);
    }
}
