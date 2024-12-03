package x8;

import android.os.Bundle;
import androidx.fragment.app.h;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.bakery.Bakery;
import kotlin.jvm.internal.j;

public final class f extends b6.a<a, ActivityProfileEdit> {

    public interface a extends b6.b<ActivityProfileEdit> {
        void T(f fVar);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private ActivityProfileEdit f18569a;

        public b(ActivityProfileEdit activityProfileEdit) {
            this.f18569a = activityProfileEdit;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D0 */
    public a z0(ActivityProfileEdit activityProfileEdit) {
        a a10 = b.a().b(new b(activityProfileEdit)).c(Bakery.j()).a();
        j.f(a10, "builder()\n              …\n                .build()");
        return a10;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.ActivityProfileEdit");
        ActivityProfileEdit activityProfileEdit = (ActivityProfileEdit) activity;
        if (this.f7846a == null) {
            this.f7846a = z0(activityProfileEdit);
        } else {
            C0(activityProfileEdit);
        }
        a aVar = (a) this.f7846a;
        if (aVar != null) {
            aVar.T(this);
        }
        activityProfileEdit.V1();
    }
}
