package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.match.models.Match;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.entities.MatchEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.models.enums.MatchType;
import fa.a;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import v6.d;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f34495a = new b0();

    private b0() {
    }

    private final MatchEntity b(MatchContract matchContract, ProfileEntity profileEntity) {
        return new MatchEntity(matchContract.getId(), matchContract.getAction(), matchContract.getEndAt(), matchContract.isBlocked(), matchContract.isRising(), matchContract.getLikeComment(), matchContract.getMessage(), matchContract.getProfileId(), matchContract.getRisingCount(), matchContract.getShowOrder(), matchContract.getStartAt(), matchContract.getType(), matchContract.getWooCount(), 0, matchContract.getPurchaseAttribution(), matchContract.getMatchToMe(), profileEntity, 8192, (DefaultConstructorMarker) null);
    }

    public final Match a(MatchEntity matchEntity) {
        j.g(matchEntity, "entity");
        return new Match(matchEntity.getId(), matchEntity.getAction(), matchEntity.getLikeComment(), matchEntity.getEndAt(), matchEntity.isBlocked(), matchEntity.isRising(), matchEntity.getMessage(), matchEntity.getProfileId(), matchEntity.getRisingCount(), matchEntity.getShowOrder(), matchEntity.getStartAt(), matchEntity.getType(), matchEntity.getWooCount(), matchEntity.getWooSeenCount(), matchEntity.getPurchaseAttribution(), matchEntity.getMatchToMe());
    }

    public final List<MatchEntity> c(List<? extends Bagel> list, d dVar) {
        j.g(list, "networkResponseResults");
        j.g(dVar, "profileMapper");
        ArrayList arrayList = new ArrayList();
        for (Bagel bagel : list) {
            MatchContract match = bagel.toMatch(MatchType.LIKES_YOU);
            NetworkProfile profile = bagel.getProfile();
            if (profile != null) {
                j.f(profile, "profile");
                if (profile.getPhotos().isEmpty()) {
                    a.C0491a aVar = a.f40771d;
                    aVar.c("MatchMapper", "profile without any photo", new InvalidObjectException("profile with id " + profile.getId() + " has no photos"));
                }
                ProfileEntity a10 = dVar.a(profile);
                b0 b0Var = f34495a;
                j.f(match, "domainMatch");
                arrayList.add(b0Var.b(match, a10));
            } else {
                a.C0491a aVar2 = a.f40771d;
                aVar2.c("MatchMapper", "bagel without profiles", new InvalidObjectException("bagel with id " + bagel.getId() + " has no profile"));
            }
        }
        return arrayList;
    }
}
