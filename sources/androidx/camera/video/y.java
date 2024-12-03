package androidx.camera.video;

import android.content.Context;
import android.net.Uri;
import androidx.camera.video.Recorder;
import androidx.core.util.a;
import b0.d;

public final /* synthetic */ class y implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f3425a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f3426b;

    public /* synthetic */ y(d dVar, Context context) {
        this.f3425a = dVar;
        this.f3426b = context;
    }

    public final void accept(Object obj) {
        Recorder.h.I(this.f3425a, this.f3426b, (Uri) obj);
    }
}
