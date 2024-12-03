package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.match.models.Match;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.internal.ServerProtocol;
import gk.h;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import vb.a;

final class LikesYouMatchContainerInteractor$trackAction$1 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ String $action;
    final /* synthetic */ Match $match;
    final /* synthetic */ LikesYouMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchContainerInteractor$trackAction$1(String str, Match match, LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        super(1);
        this.$action = str;
        this.$match = match;
        this.this$0 = likesYouMatchContainerInteractor;
    }

    public final void a(Optional<a> optional) {
        String str;
        String str2;
        if (j.b(this.$action, "like")) {
            str = "connected";
        } else {
            str = "not connected";
        }
        Map l10 = h0.l(h.a("is_subscriber", String.valueOf(optional.d())), h.a(Extra.BAGEL_ID, this.$match.getId()), h.a("bagel_profile_id", this.$match.getProfileId()), h.a("connection state", str), h.a("action", this.$action), h.a("source", this.this$0.f34404j), h.a("pair_action", "liked"));
        j.e(l10, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String?>");
        Map c10 = p.c(l10);
        if (this.$match.getPurchaseAttribution() != null) {
            if (this.$match.getPurchaseAttribution() == PurchaseAttribution.PAID_LIKE) {
                str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            } else {
                str2 = "false";
            }
            c10.putAll(g0.f(h.a("received_paid_like", str2)));
        }
        this.this$0.l2().j("Bagel Action", c10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
