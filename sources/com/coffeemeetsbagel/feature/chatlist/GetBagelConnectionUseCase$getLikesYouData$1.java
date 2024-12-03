package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import java.util.Iterator;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetBagelConnectionUseCase$getLikesYouData$1 extends Lambda implements Function1<Optional<LikesYouGroupWithCards>, Pair<? extends Integer, ? extends String>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetBagelConnectionUseCase$getLikesYouData$1 f12888a = new GetBagelConnectionUseCase$getLikesYouData$1();

    GetBagelConnectionUseCase$getLikesYouData$1() {
        super(1);
    }

    /* renamed from: a */
    public final Pair<Integer, String> invoke(Optional<LikesYouGroupWithCards> optional) {
        T t10;
        j.g(optional, "cardsOptional");
        String str = "";
        if (!optional.isPresent()) {
            return new Pair<>(0, str);
        }
        LikesYouGroupWithCards likesYouGroupWithCards = optional.get();
        j.f(likesYouGroupWithCards, "cardsOptional.get()");
        LikesYouGroupWithCards likesYouGroupWithCards2 = likesYouGroupWithCards;
        int size = likesYouGroupWithCards2.getCards().size() + likesYouGroupWithCards2.getPaywallCards().size();
        String str2 = null;
        if (!likesYouGroupWithCards2.getGroup().getFreeProfileIds().isEmpty()) {
            Iterator<T> it = likesYouGroupWithCards2.getCards().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t10 = null;
                    break;
                }
                t10 = it.next();
                if (j.b(((LikesYouCardEntity) t10).getProfileId(), CollectionsKt___CollectionsKt.N(likesYouGroupWithCards2.getGroup().getFreeProfileIds()))) {
                    break;
                }
            }
            LikesYouCardEntity likesYouCardEntity = (LikesYouCardEntity) t10;
            if (likesYouCardEntity != null) {
                str2 = likesYouCardEntity.getImageUrl();
            }
        } else if (!likesYouGroupWithCards2.getPaywallCards().isEmpty()) {
            str2 = ((LikesYouPaywallCard) CollectionsKt___CollectionsKt.N(likesYouGroupWithCards2.getPaywallCards())).getImageUrl();
        }
        Integer valueOf = Integer.valueOf(size);
        if (str2 != null) {
            str = str2;
        }
        return new Pair<>(valueOf, str);
    }
}
