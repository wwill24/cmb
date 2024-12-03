package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.ActionCard;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetFirstEligibleActionCardUseCase$invoke$1 extends Lambda implements Function1<List<? extends ActionCard>, ActionCard> {
    final /* synthetic */ GetFirstEligibleActionCardUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetFirstEligibleActionCardUseCase$invoke$1(GetFirstEligibleActionCardUseCase getFirstEligibleActionCardUseCase) {
        super(1);
        this.this$0 = getFirstEligibleActionCardUseCase;
    }

    /* renamed from: a */
    public final ActionCard invoke(List<? extends ActionCard> list) {
        j.g(list, "actionCards");
        if (!list.isEmpty()) {
            GetFirstEligibleActionCardUseCase getFirstEligibleActionCardUseCase = this.this$0;
            for (ActionCard e10 : list) {
                NetworkProfile j10 = getFirstEligibleActionCardUseCase.f37270d.j();
                j.d(j10);
                Pair e11 = getFirstEligibleActionCardUseCase.h(e10, j10);
                if (((Boolean) e11.d()).booleanValue()) {
                    return (ActionCard) e11.c();
                }
            }
            int size = list.size();
            throw new NoEligibleActionCardFound(size, "No eligible card found among " + list + ".size action cards");
        }
        throw new NoSuchElementException("action card list empty");
    }
}
