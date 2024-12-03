package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.f0;
import com.coffeemeetsbagel.dialogs.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import lc.c;

final class MatchPreferencesFragment$setupEthnicityDialog$2$1 extends Lambda implements Function1<List<k>, Unit> {
    final /* synthetic */ f0<k> $multiSelectPickerDls;
    final /* synthetic */ MatchPreferencesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPreferencesFragment$setupEthnicityDialog$2$1(MatchPreferencesFragment matchPreferencesFragment, f0<k> f0Var) {
        super(1);
        this.this$0 = matchPreferencesFragment;
        this.$multiSelectPickerDls = f0Var;
    }

    public final void a(List<k> list) {
        CmbTextView cmbTextView = this.this$0.T0().f15837t;
        j.f(list, "list");
        ArrayList arrayList = new ArrayList();
        for (k a10 : list) {
            String a11 = a10.a();
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        cmbTextView.setText(CollectionsKt___CollectionsKt.W(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        this.this$0.f13284l.clear();
        MatchPreferencesFragment matchPreferencesFragment = this.this$0;
        for (k b10 : list) {
            matchPreferencesFragment.f13284l.add(b10.b());
        }
        c.h(this.$multiSelectPickerDls);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
