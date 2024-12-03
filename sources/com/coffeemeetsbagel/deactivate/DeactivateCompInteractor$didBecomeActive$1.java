package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.utils.model.Optional;
import ja.b;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.a;

final class DeactivateCompInteractor$didBecomeActive$1 extends Lambda implements Function1<Pair<? extends Triple<? extends b, ? extends l, ? extends List<? extends Photo>>, ? extends Optional<a>>, Unit> {
    final /* synthetic */ DeactivateCompInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompInteractor$didBecomeActive$1(DeactivateCompInteractor deactivateCompInteractor) {
        super(1);
        this.this$0 = deactivateCompInteractor;
    }

    public final void a(Pair<? extends Triple<b, l, ? extends List<Photo>>, ? extends Optional<a>> pair) {
        l lVar = (l) ((Triple) pair.c()).b();
        this.this$0.f11996y.set(new CmbLinks.PayItForwardSurveyParameters(lVar.a(), lVar.h().getApiKey(), ((b) ((Triple) pair.c()).a()).r(), lVar.c(), ((Optional) pair.d()).d(), lVar.j()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
