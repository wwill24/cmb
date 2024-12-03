package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

final class v extends f0 {

    /* renamed from: k  reason: collision with root package name */
    private static final i0.b f5894k = new a();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Fragment> f5895d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, v> f5896e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, k0> f5897f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5898g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5899h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5900i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5901j = false;

    class a implements i0.b {
        a() {
        }

        @NonNull
        public <T extends f0> T a(@NonNull Class<T> cls) {
            return new v(true);
        }
    }

    v(boolean z10) {
        this.f5898g = z10;
    }

    private void i(@NonNull String str) {
        v vVar = this.f5896e.get(str);
        if (vVar != null) {
            vVar.d();
            this.f5896e.remove(str);
        }
        k0 k0Var = this.f5897f.get(str);
        if (k0Var != null) {
            k0Var.a();
            this.f5897f.remove(str);
        }
    }

    @NonNull
    static v l(k0 k0Var) {
        return (v) new i0(k0Var, f5894k).a(v.class);
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCleared called for ");
            sb2.append(this);
        }
        this.f5899h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (!this.f5895d.equals(vVar.f5895d) || !this.f5896e.equals(vVar.f5896e) || !this.f5897f.equals(vVar.f5897f)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull Fragment fragment) {
        if (this.f5901j) {
            FragmentManager.J0(2);
        } else if (!this.f5895d.containsKey(fragment.mWho)) {
            this.f5895d.put(fragment.mWho, fragment);
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Updating retained Fragments: Added ");
                sb2.append(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Fragment fragment) {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for ");
            sb2.append(fragment);
        }
        i(fragment.mWho);
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull String str) {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for saved state of Fragment ");
            sb2.append(str);
        }
        i(str);
    }

    public int hashCode() {
        return (((this.f5895d.hashCode() * 31) + this.f5896e.hashCode()) * 31) + this.f5897f.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Fragment j(String str) {
        return this.f5895d.get(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public v k(@NonNull Fragment fragment) {
        v vVar = this.f5896e.get(fragment.mWho);
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this.f5898g);
        this.f5896e.put(fragment.mWho, vVar2);
        return vVar2;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Collection<Fragment> m() {
        return new ArrayList(this.f5895d.values());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public k0 n(@NonNull Fragment fragment) {
        k0 k0Var = this.f5897f.get(fragment.mWho);
        if (k0Var != null) {
            return k0Var;
        }
        k0 k0Var2 = new k0();
        this.f5897f.put(fragment.mWho, k0Var2);
        return k0Var2;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f5899h;
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull Fragment fragment) {
        boolean z10;
        if (this.f5901j) {
            FragmentManager.J0(2);
            return;
        }
        if (this.f5895d.remove(fragment.mWho) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating retained Fragments: Removed ");
            sb2.append(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z10) {
        this.f5901j = z10;
    }

    /* access modifiers changed from: package-private */
    public boolean r(@NonNull Fragment fragment) {
        if (!this.f5895d.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f5898g) {
            return this.f5899h;
        }
        return !this.f5900i;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f5895d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f5896e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f5897f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }
}
