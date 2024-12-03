package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import com.uber.autodispose.a;
import com.uber.autodispose.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchContainerInteractor$updateCardsAndGroupsAfterAction$1 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ String $profileId;
    final /* synthetic */ LikesYouMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchContainerInteractor$updateCardsAndGroupsAfterAction$1(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor, String str) {
        super(1);
        this.this$0 = likesYouMatchContainerInteractor;
        this.$profileId = str;
    }

    /* access modifiers changed from: private */
    public static final void d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void c(List<String> list) {
        for (String A : list) {
            LikesYouMatchRepository o22 = this.this$0.o2();
            final LikesYouMatchContainerInteractor likesYouMatchContainerInteractor = this.this$0;
            final String str = this.$profileId;
            ((t) o22.A(A).L().g(a.a(this.this$0))).c(new n0(new Function1<LikesYouGroupEntity, Unit>() {
                public final void a(LikesYouGroupEntity likesYouGroupEntity) {
                    List<String> freeProfileIds = likesYouGroupEntity.getFreeProfileIds();
                    String str = str;
                    ArrayList arrayList = new ArrayList();
                    for (T next : freeProfileIds) {
                        if (!j.b((String) next, str)) {
                            arrayList.add(next);
                        }
                    }
                    j.f(likesYouGroupEntity, "group");
                    ((t) likesYouMatchContainerInteractor.o2().T(LikesYouGroupEntity.copy$default(likesYouGroupEntity, (String) null, (String) null, likesYouGroupEntity.getCount() - 1, 0, arrayList, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16363, (Object) null)).g(a.a(likesYouMatchContainerInteractor))).d();
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((LikesYouGroupEntity) obj);
                    return Unit.f32013a;
                }
            }));
        }
        ((t) this.this$0.o2().r(this.this$0.p2().getProfileId()).g(a.a(this.this$0))).d();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((List) obj);
        return Unit.f32013a;
    }
}
