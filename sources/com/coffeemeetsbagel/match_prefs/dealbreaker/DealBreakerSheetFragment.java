package com.coffeemeetsbagel.match_prefs.dealbreaker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

public final class DealBreakerSheetFragment extends b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f34567d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f34568e;

    /* renamed from: b  reason: collision with root package name */
    public d f34569b;

    /* renamed from: c  reason: collision with root package name */
    public ia.a f34570c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return DealBreakerSheetFragment.f34568e;
        }
    }

    static {
        String simpleName = DealBreakerSheetFragment.class.getSimpleName();
        j.f(simpleName, "DealBreakerSheetFragment::class.java.simpleName");
        f34568e = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void H0(DealBreakerSheetFragment dealBreakerSheetFragment, View view) {
        j.g(dealBreakerSheetFragment, "this$0");
        dealBreakerSheetFragment.dismiss();
    }

    public final d F0() {
        d dVar = this.f34569b;
        if (dVar != null) {
            return dVar;
        }
        j.y("factory");
        return null;
    }

    public final ia.a G0() {
        ia.a aVar = this.f34570c;
        if (aVar != null) {
            return aVar;
        }
        j.y("viewBinding");
        return null;
    }

    public final void I0(ia.a aVar) {
        j.g(aVar, "<set-?>");
        this.f34570c = aVar;
    }

    public final void J0(k0 k0Var, c cVar) {
        j.g(k0Var, "coroutineScope");
        j.g(cVar, "activity");
        s1 unused = j.d(k0Var, (CoroutineContext) null, (CoroutineStart) null, new DealBreakerSheetFragment$startWhenReady$1(cVar, this, (kotlin.coroutines.c<? super DealBreakerSheetFragment$startWhenReady$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        ia.a c10 = ia.a.c(layoutInflater);
        j.f(c10, "inflate(inflater)");
        I0(c10);
        G0().f40928c.setOnClickListener(new a(this));
        ConstraintLayout b10 = G0().getRoot();
        j.f(b10, "viewBinding.root");
        return b10;
    }
}
