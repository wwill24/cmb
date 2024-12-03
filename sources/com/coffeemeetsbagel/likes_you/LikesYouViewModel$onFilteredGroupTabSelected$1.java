package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likes_you.LikesYouViewModel;
import com.coffeemeetsbagel.likes_you.presentation.MainGroups;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$onFilteredGroupTabSelected$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $tabId;
    final /* synthetic */ String $tabName;
    final /* synthetic */ int $tabPosition;
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$onFilteredGroupTabSelected$1(LikesYouViewModel likesYouViewModel, String str, String str2, int i10) {
        super(1);
        this.this$0 = likesYouViewModel;
        this.$tabId = str;
        this.$tabName = str2;
        this.$tabPosition = i10;
    }

    public final void a(Boolean bool) {
        j.f(bool, "hasLimelight");
        if (bool.booleanValue()) {
            this.this$0.X().accept(new Triple(this.$tabId, this.$tabName, Integer.valueOf(this.$tabPosition)));
        } else {
            this.this$0.X().accept(new Triple(MainGroups.ALL.b(), "", 0));
            this.this$0.f34133n.o(new LikesYouViewModel.a.e(this.this$0.f34124e.a("likes_you_curation_v2_dialog_once"), this.this$0.f34124e.a("likes_you_curation_v2_dialog_twice"), this.$tabName));
        }
        this.this$0.r0((String) null, true, this.$tabName);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
