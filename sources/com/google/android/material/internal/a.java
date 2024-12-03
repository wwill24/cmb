package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.internal.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a<T extends k<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, T> f19808a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f19809b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private b f19810c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19811d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f19812e;

    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    class C0237a implements k.a<T> {
        C0237a() {
        }

        /* renamed from: b */
        public void a(T t10, boolean z10) {
            if (!z10) {
                a aVar = a.this;
                if (!aVar.r(t10, aVar.f19812e)) {
                    return;
                }
            } else if (!a.this.g(t10)) {
                return;
            }
            a.this.m();
        }
    }

    public interface b {
        void a(@NonNull Set<Integer> set);
    }

    /* access modifiers changed from: private */
    public boolean g(@NonNull k<T> kVar) {
        int id2 = kVar.getId();
        if (this.f19809b.contains(Integer.valueOf(id2))) {
            return false;
        }
        k kVar2 = (k) this.f19808a.get(Integer.valueOf(k()));
        if (kVar2 != null) {
            r(kVar2, false);
        }
        boolean add = this.f19809b.add(Integer.valueOf(id2));
        if (!kVar.isChecked()) {
            kVar.setChecked(true);
        }
        return add;
    }

    /* access modifiers changed from: private */
    public void m() {
        b bVar = this.f19810c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* access modifiers changed from: private */
    public boolean r(@NonNull k<T> kVar, boolean z10) {
        int id2 = kVar.getId();
        if (!this.f19809b.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (!z10 || this.f19809b.size() != 1 || !this.f19809b.contains(Integer.valueOf(id2))) {
            boolean remove = this.f19809b.remove(Integer.valueOf(id2));
            if (kVar.isChecked()) {
                kVar.setChecked(false);
            }
            return remove;
        }
        kVar.setChecked(true);
        return false;
    }

    public void e(T t10) {
        this.f19808a.put(Integer.valueOf(t10.getId()), t10);
        if (t10.isChecked()) {
            g(t10);
        }
        t10.setInternalOnCheckedChangeListener(new C0237a());
    }

    public void f(int i10) {
        k kVar = (k) this.f19808a.get(Integer.valueOf(i10));
        if (kVar != null && g(kVar)) {
            m();
        }
    }

    public void h() {
        boolean z10 = !this.f19809b.isEmpty();
        for (T r10 : this.f19808a.values()) {
            r(r10, false);
        }
        if (z10) {
            m();
        }
    }

    @NonNull
    public Set<Integer> i() {
        return new HashSet(this.f19809b);
    }

    @NonNull
    public List<Integer> j(@NonNull ViewGroup viewGroup) {
        Set<Integer> i10 = i();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof k) && i10.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.f19811d || this.f19809b.isEmpty()) {
            return -1;
        }
        return this.f19809b.iterator().next().intValue();
    }

    public boolean l() {
        return this.f19811d;
    }

    public void n(T t10) {
        t10.setInternalOnCheckedChangeListener((k.a) null);
        this.f19808a.remove(Integer.valueOf(t10.getId()));
        this.f19809b.remove(Integer.valueOf(t10.getId()));
    }

    public void o(b bVar) {
        this.f19810c = bVar;
    }

    public void p(boolean z10) {
        this.f19812e = z10;
    }

    public void q(boolean z10) {
        if (this.f19811d != z10) {
            this.f19811d = z10;
            h();
        }
    }
}
