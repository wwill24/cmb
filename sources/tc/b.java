package tc;

import android.view.View;
import com.facebook.appevents.aam.MetadataViewObserver;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f41943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MetadataViewObserver f41944b;

    public /* synthetic */ b(View view, MetadataViewObserver metadataViewObserver) {
        this.f41943a = view;
        this.f41944b = metadataViewObserver;
    }

    public final void run() {
        MetadataViewObserver.m55process$lambda0(this.f41943a, this.f41944b);
    }
}
