package com.google.android.material.internal;

import android.widget.Checkable;
import com.google.android.material.internal.k;

public interface k<T extends k<T>> extends Checkable {

    public interface a<C> {
        void a(C c10, boolean z10);
    }

    int getId();

    void setInternalOnCheckedChangeListener(a<T> aVar);
}
