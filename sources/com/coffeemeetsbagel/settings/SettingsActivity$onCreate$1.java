package com.coffeemeetsbagel.settings;

import com.coffeemeetsbagel.profile.l;
import ja.b;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SettingsActivity$onCreate$1 extends Lambda implements Function1<Pair<? extends b, ? extends l>, Unit> {
    final /* synthetic */ SettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsActivity$onCreate$1(SettingsActivity settingsActivity) {
        super(1);
        this.this$0 = settingsActivity;
    }

    public final void a(Pair<b, l> pair) {
        this.this$0.N0(pair.c().x());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
