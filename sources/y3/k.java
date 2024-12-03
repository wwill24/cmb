package y3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final a f18640a;

    /* renamed from: b  reason: collision with root package name */
    private final m f18641b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<k> f18642c;

    /* renamed from: d  reason: collision with root package name */
    private h f18643d;

    /* renamed from: e  reason: collision with root package name */
    private k f18644e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f18645f;

    private class a implements m {
        a() {
        }

        @NonNull
        public Set<h> a() {
            Set<k> b10 = k.this.b();
            HashSet hashSet = new HashSet(b10.size());
            for (k next : b10) {
                if (next.e() != null) {
                    hashSet.add(next.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new a());
    }

    private void a(k kVar) {
        this.f18642c.add(kVar);
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f18645f;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        k h10 = c.c(activity).k().h(activity);
        this.f18644e = h10;
        if (!equals(h10)) {
            this.f18644e.a(this);
        }
    }

    private void i(k kVar) {
        this.f18642c.remove(kVar);
    }

    private void l() {
        k kVar = this.f18644e;
        if (kVar != null) {
            kVar.i(this);
            this.f18644e = null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    @NonNull
    public Set<k> b() {
        if (equals(this.f18644e)) {
            return Collections.unmodifiableSet(this.f18642c);
        }
        if (this.f18644e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (k next : this.f18644e.b()) {
            if (g(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public a c() {
        return this.f18640a;
    }

    public h e() {
        return this.f18643d;
    }

    @NonNull
    public m f() {
        return this.f18641b;
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        this.f18645f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(h hVar) {
        this.f18643d = hVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f18640a.c();
        l();
    }

    public void onDetach() {
        super.onDetach();
        l();
    }

    public void onStart() {
        super.onStart();
        this.f18640a.d();
    }

    public void onStop() {
        super.onStop();
        this.f18640a.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    k(@NonNull a aVar) {
        this.f18641b = new a();
        this.f18642c = new HashSet();
        this.f18640a = aVar;
    }
}
