package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.l;
import androidx.lifecycle.s;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable;

public class LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter implements e {

    /* renamed from: a  reason: collision with root package name */
    final LifecycleEventsObservable.ArchLifecycleObserver f23317a;

    LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter(LifecycleEventsObservable.ArchLifecycleObserver archLifecycleObserver) {
        this.f23317a = archLifecycleObserver;
    }

    public void a(l lVar, Lifecycle.Event event, boolean z10, s sVar) {
        boolean z11;
        if (sVar != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10) {
            return;
        }
        if (!z11 || sVar.a("onStateChange", 4)) {
            this.f23317a.onStateChange(lVar, event);
        }
    }
}
