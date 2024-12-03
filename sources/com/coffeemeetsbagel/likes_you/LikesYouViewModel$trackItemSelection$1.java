package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class LikesYouViewModel$trackItemSelection$1 extends Lambda implements Function1<Pair<? extends List<? extends String>, ? extends LikesYouGroupEntity>, b0<? extends Pair<? extends List<? extends String>, ? extends String>>> {
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$trackItemSelection$1(LikesYouViewModel likesYouViewModel) {
        super(1);
        this.this$0 = likesYouViewModel;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Pair<List<String>, String>> invoke(Pair<? extends List<String>, LikesYouGroupEntity> pair) {
        j.g(pair, "<name for destructuring parameter 0>");
        List list = (List) pair.a();
        final LikesYouGroupEntity b10 = pair.b();
        LikesYouMatchRepository F = this.this$0.f34127h;
        j.f(list, "ids");
        return F.D(list).D(new l0(new Function1<List<? extends String>, Pair<? extends List<? extends String>, ? extends String>>() {
            /* renamed from: a */
            public final Pair<List<String>, String> invoke(List<String> list) {
                j.g(list, "it");
                return new Pair<>(list, b10.getName());
            }
        }));
    }
}
