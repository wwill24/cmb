package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f5732a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, z> f5733b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, FragmentState> f5734c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private v f5735d;

    a0() {
    }

    /* access modifiers changed from: package-private */
    public void A(@NonNull v vVar) {
        this.f5735d = vVar;
    }

    /* access modifiers changed from: package-private */
    public FragmentState B(@NonNull String str, FragmentState fragmentState) {
        if (fragmentState != null) {
            return this.f5734c.put(str, fragmentState);
        }
        return this.f5734c.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Fragment fragment) {
        if (!this.f5732a.contains(fragment)) {
            synchronized (this.f5732a) {
                this.f5732a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f5733b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(@NonNull String str) {
        return this.f5733b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        for (z next : this.f5733b.values()) {
            if (next != null) {
                next.u(i10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f5733b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (z next : this.f5733b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment k10 = next.k();
                    printWriter.println(k10);
                    k10.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f5732a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.f5732a.get(i10).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment f(@NonNull String str) {
        z zVar = this.f5733b.get(str);
        if (zVar != null) {
            return zVar.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment g(int i10) {
        for (int size = this.f5732a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f5732a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (z next : this.f5733b.values()) {
            if (next != null) {
                Fragment k10 = next.k();
                if (k10.mFragmentId == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f5732a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f5732a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (z next : this.f5733b.values()) {
            if (next != null) {
                Fragment k10 = next.k();
                if (str.equals(k10.mTag)) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment i(@NonNull String str) {
        Fragment findFragmentByWho;
        for (z next : this.f5733b.values()) {
            if (next != null && (findFragmentByWho = next.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int j(@NonNull Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f5732a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f5732a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f5732a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f5732a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<z> k() {
        ArrayList arrayList = new ArrayList();
        for (z next : this.f5733b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (z next : this.f5733b.values()) {
            if (next != null) {
                arrayList.add(next.k());
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ArrayList<FragmentState> m() {
        return new ArrayList<>(this.f5734c.values());
    }

    /* access modifiers changed from: package-private */
    public z n(@NonNull String str) {
        return this.f5733b.get(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> o() {
        ArrayList arrayList;
        if (this.f5732a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f5732a) {
            arrayList = new ArrayList(this.f5732a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public v p() {
        return this.f5735d;
    }

    /* access modifiers changed from: package-private */
    public FragmentState q(@NonNull String str) {
        return this.f5734c.get(str);
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull z zVar) {
        Fragment k10 = zVar.k();
        if (!c(k10.mWho)) {
            this.f5733b.put(k10.mWho, zVar);
            if (k10.mRetainInstanceChangedWhileDetached) {
                if (k10.mRetainInstance) {
                    this.f5735d.f(k10);
                } else {
                    this.f5735d.p(k10);
                }
                k10.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Added fragment to active set ");
                sb2.append(k10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull z zVar) {
        Fragment k10 = zVar.k();
        if (k10.mRetainInstance) {
            this.f5735d.p(k10);
        }
        if (this.f5733b.put(k10.mWho, (Object) null) != null && FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Removed fragment from active set ");
            sb2.append(k10);
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        boolean z10;
        Iterator<Fragment> it = this.f5732a.iterator();
        while (it.hasNext()) {
            z zVar = this.f5733b.get(it.next().mWho);
            if (zVar != null) {
                zVar.m();
            }
        }
        for (z next : this.f5733b.values()) {
            if (next != null) {
                next.m();
                Fragment k10 = next.k();
                if (!k10.mRemoving || k10.isInBackStack()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    if (k10.mBeingSaved && !this.f5734c.containsKey(k10.mWho)) {
                        next.s();
                    }
                    s(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(@NonNull Fragment fragment) {
        synchronized (this.f5732a) {
            this.f5732a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.f5733b.clear();
    }

    /* access modifiers changed from: package-private */
    public void w(List<String> list) {
        this.f5732a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f10 = f(next);
                if (f10 != null) {
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("restoreSaveState: added (");
                        sb2.append(next);
                        sb2.append("): ");
                        sb2.append(f10);
                    }
                    a(f10);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x(@NonNull ArrayList<FragmentState> arrayList) {
        this.f5734c.clear();
        Iterator<FragmentState> it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            this.f5734c.put(next.f5686b, next);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f5733b.size());
        for (z next : this.f5733b.values()) {
            if (next != null) {
                Fragment k10 = next.k();
                next.s();
                arrayList.add(k10.mWho);
                if (FragmentManager.J0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Saved state of ");
                    sb2.append(k10);
                    sb2.append(": ");
                    sb2.append(k10.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> z() {
        synchronized (this.f5732a) {
            if (this.f5732a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f5732a.size());
            Iterator<Fragment> it = this.f5732a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.J0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("saveAllState: adding fragment (");
                    sb2.append(next.mWho);
                    sb2.append("): ");
                    sb2.append(next);
                }
            }
            return arrayList;
        }
    }
}
