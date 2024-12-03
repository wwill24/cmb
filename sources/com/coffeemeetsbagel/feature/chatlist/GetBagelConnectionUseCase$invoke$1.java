package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.feature.chatlist.ConnectionHolder;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;

final class GetBagelConnectionUseCase$invoke$1 extends Lambda implements Function1<Pair<? extends Optional<a>, ? extends Pair<? extends Integer, ? extends String>>, List<ConnectionHolder>> {
    final /* synthetic */ GetBagelConnectionUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetBagelConnectionUseCase$invoke$1(GetBagelConnectionUseCase getBagelConnectionUseCase) {
        super(1);
        this.this$0 = getBagelConnectionUseCase;
    }

    /* renamed from: a */
    public final List<ConnectionHolder> invoke(Pair<? extends Optional<a>, Pair<Integer, String>> pair) {
        boolean z10;
        j.g(pair, "<name for destructuring parameter 0>");
        Optional optional = (Optional) pair.a();
        Pair b10 = pair.b();
        ArrayList arrayList = new ArrayList();
        if (!optional.d() || !((a) optional.c()).h(BenefitKeys.LIKES_YOU)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 && ((Number) b10.c()).intValue() > 1) {
            if (this.this$0.f12886f.A("UpsellLikesYouInChatsV2.Enabled.Android")) {
                arrayList.add(new ConnectionHolder((MatchContract) null, (ConnectionDetails) null, 0, (String) null, (String) b10.d(), Integer.valueOf(((Number) b10.c()).intValue()), ConnectionHolder.ConnectionHolderType.UPSELL_LIKES_YOU_V2, 15, (DefaultConstructorMarker) null));
            } else {
                arrayList.add(new ConnectionHolder((MatchContract) null, (ConnectionDetails) null, 0, (String) null, (String) null, (Integer) b10.c(), ConnectionHolder.ConnectionHolderType.UPSELL_LIKES_YOU, 31, (DefaultConstructorMarker) null));
            }
        }
        arrayList.addAll(this.this$0.f12881a.a());
        List<ConnectionHolder> b11 = this.this$0.f12881a.b();
        if (!b11.isEmpty()) {
            arrayList.add(new ConnectionHolder((MatchContract) null, (ConnectionDetails) null, 0, (String) null, (String) null, (Integer) null, ConnectionHolder.ConnectionHolderType.INACTIVE_HEADER, 63, (DefaultConstructorMarker) null));
            arrayList.addAll(b11);
        }
        return arrayList;
    }
}
