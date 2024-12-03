package y3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class o extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final a f18659a;

    /* renamed from: b  reason: collision with root package name */
    private final m f18660b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<o> f18661c;

    /* renamed from: d  reason: collision with root package name */
    private o f18662d;

    /* renamed from: e  reason: collision with root package name */
    private h f18663e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f18664f;

    private class a implements m {
        a() {
        }

        @NonNull
        public Set<h> a() {
            Set<o> A0 = o.this.A0();
            HashSet hashSet = new HashSet(A0.size());
            for (o next : A0) {
                if (next.D0() != null) {
                    hashSet.add(next.D0());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new a());
    }

    private Fragment C0() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f18664f;
    }

    private static FragmentManager F0(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean G0(@NonNull Fragment fragment) {
        Fragment C0 = C0();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(C0)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void H0(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        M0();
        o j10 = c.c(context).k().j(context, fragmentManager);
        this.f18662d = j10;
        if (!equals(j10)) {
            this.f18662d.z0(this);
        }
    }

    private void I0(o oVar) {
        this.f18661c.remove(oVar);
    }

    private void M0() {
        o oVar = this.f18662d;
        if (oVar != null) {
            oVar.I0(this);
            this.f18662d = null;
        }
    }

    private void z0(o oVar) {
        this.f18661c.add(oVar);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Set<o> A0() {
        o oVar = this.f18662d;
        if (oVar == null) {
            return Collections.emptySet();
        }
        if (equals(oVar)) {
            return Collections.unmodifiableSet(this.f18661c);
        }
        HashSet hashSet = new HashSet();
        for (o next : this.f18662d.A0()) {
            if (G0(next.C0())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public a B0() {
        return this.f18659a;
    }

    public h D0() {
        return this.f18663e;
    }

    @NonNull
    public m E0() {
        return this.f18660b;
    }

    /* access modifiers changed from: package-private */
    public void J0(Fragment fragment) {
        FragmentManager F0;
        this.f18664f = fragment;
        if (fragment != null && fragment.getContext() != null && (F0 = F0(fragment)) != null) {
            H0(fragment.getContext(), F0);
        }
    }

    public void L0(h hVar) {
        this.f18663e = hVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager F0 = F0(this);
        if (F0 == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            H0(getContext(), F0);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f18659a.c();
        M0();
    }

    public void onDetach() {
        super.onDetach();
        this.f18664f = null;
        M0();
    }

    public void onStart() {
        super.onStart();
        this.f18659a.d();
    }

    public void onStop() {
        super.onStop();
        this.f18659a.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + C0() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public o(@NonNull a aVar) {
        this.f18660b = new a();
        this.f18661c = new HashSet();
        this.f18659a = aVar;
    }
}
