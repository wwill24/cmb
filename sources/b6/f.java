package b6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import b6.g;

public abstract class f<C extends g> extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected C f7854a;

    public C A0() {
        return this.f7854a;
    }

    /* access modifiers changed from: protected */
    public void B0(d dVar) {
        z0(dVar);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        if (this.f7854a == null) {
            this.f7854a = z0((d) getActivity());
        } else {
            B0((d) getActivity());
        }
        this.f7854a.g0(this);
        d dVar = (d) getActivity();
        if (dVar != null) {
            dVar.M0();
        }
    }

    /* access modifiers changed from: protected */
    public abstract C z0(d dVar);
}
