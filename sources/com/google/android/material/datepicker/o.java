package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class o<S> extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected final LinkedHashSet<n<S>> f19664a = new LinkedHashSet<>();

    o() {
    }

    /* access modifiers changed from: package-private */
    public void A0() {
        this.f19664a.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean z0(n<S> nVar) {
        return this.f19664a.add(nVar);
    }
}
