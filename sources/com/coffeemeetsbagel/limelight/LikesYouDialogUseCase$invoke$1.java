package com.coffeemeetsbagel.limelight;

import com.coffeemeetsbagel.limelight.LikesYouDialogUseCase;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouDialogUseCase$invoke$1 extends Lambda implements Function1<Pair<? extends List<? extends LikesYouCardEntity>, ? extends List<? extends LikesYouPaywallCard>>, LikesYouDialogUseCase.a> {
    final /* synthetic */ LikesYouDialogUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouDialogUseCase$invoke$1(LikesYouDialogUseCase likesYouDialogUseCase) {
        super(1);
        this.this$0 = likesYouDialogUseCase;
    }

    /* renamed from: a */
    public final LikesYouDialogUseCase.a invoke(Pair<? extends List<LikesYouCardEntity>, ? extends List<LikesYouPaywallCard>> pair) {
        j.g(pair, "it");
        NetworkProfile j10 = this.this$0.c().j();
        List<LikesYouCardEntity> list = (List) pair.c();
        List<LikesYouPaywallCard> list2 = (List) pair.d();
        int size = list.size() + list2.size();
        ArrayList arrayList = new ArrayList();
        for (LikesYouCardEntity imageUrl : list) {
            String imageUrl2 = imageUrl.getImageUrl();
            j.d(imageUrl2);
            arrayList.add(imageUrl2);
        }
        for (LikesYouPaywallCard imageUrl3 : list2) {
            arrayList.add(imageUrl3.getImageUrl());
        }
        j.d(j10);
        boolean isEligibleForFirstLike = DateUtils.isEligibleForFirstLike(j10.getRegisteredDate());
        boolean z10 = true;
        boolean z11 = false;
        if (this.this$0.b().a("first_like_dialog") || !isEligibleForFirstLike || size <= 0) {
            if (size > 6) {
                long t10 = this.this$0.d().t("key_last_time_multiple_likes_dialog_shown");
                long currentTimestamp = DateUtils.getCurrentTimestamp();
                long j11 = 0;
                int i10 = (t10 > 0 ? 1 : (t10 == 0 ? 0 : -1));
                if (i10 != 0) {
                    j11 = (currentTimestamp - t10) / DateUtils.MILLIS_IN_HOUR;
                }
                if (i10 == 0 || j11 > 72) {
                    z11 = true;
                    z10 = false;
                }
            }
            z10 = false;
        } else {
            z11 = true;
        }
        return new LikesYouDialogUseCase.a(size, arrayList, z10, z11);
    }
}
