package com.coffeemeetsbagel.preferences;

import android.view.View;
import android.view.ViewGroup;
import com.coffeemeetsbagel.new_user_experience.g;
import com.coffeemeetsbagel.preferences.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchPrefsContainerRouter$errorAnimation$2 extends Lambda implements Function0<g> {
    final /* synthetic */ l.a $component;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsContainerRouter$errorAnimation$2(l.a aVar) {
        super(0);
        this.$component = aVar;
    }

    /* renamed from: a */
    public final g invoke() {
        View findViewById = this.$component.a().getWindow().findViewById(16908290);
        j.f(findViewById, "component.componentActiv…yId(android.R.id.content)");
        return new g((ViewGroup) findViewById);
    }
}
