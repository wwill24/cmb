package t8;

import android.os.Bundle;
import com.coffeemeetsbagel.models.enums.EventType;
import h5.i;
import vj.f;

public final /* synthetic */ class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f17905a;

    public /* synthetic */ g(Bundle bundle) {
        this.f17905a = bundle;
    }

    public final void accept(Object obj) {
        i.c(EventType.PHOTO_UPLOAD_ERROR, this.f17905a);
    }
}
