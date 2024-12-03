package com.coffeemeetsbagel.like_pass.view;

import android.content.Context;
import android.util.AttributeSet;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lc.h;

public final class InstantLikeFab extends MatchActionFab {
    private final String E;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InstantLikeFab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InstantLikeFab(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public void a() {
        a.f40771d.a(this.E, "show");
        super.a();
        h.f41110a.a(this, 300, new InstantLikeFab$show$1(this));
    }

    public void c() {
        a.f40771d.a(this.E, "hide");
        setVisibility(8);
        clearAnimation();
        super.c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstantLikeFab(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.E = "InstantLikeFab";
    }
}
