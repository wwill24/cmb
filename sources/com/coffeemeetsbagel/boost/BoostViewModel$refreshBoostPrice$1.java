package com.coffeemeetsbagel.boost;

import androidx.lifecycle.g0;
import com.coffeemeetsbagel.store.k0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;

public final class BoostViewModel$refreshBoostPrice$1 implements k0.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BoostViewModel f11455a;

    BoostViewModel$refreshBoostPrice$1(BoostViewModel boostViewModel) {
        this.f11455a = boostViewModel;
    }

    public void onFailure() {
    }

    public void onSuccess() {
        s1 unused = j.d(g0.a(this.f11455a), (CoroutineContext) null, (CoroutineStart) null, new BoostViewModel$refreshBoostPrice$1$onSuccess$1(this.f11455a, (c<? super BoostViewModel$refreshBoostPrice$1$onSuccess$1>) null), 3, (Object) null);
    }
}
