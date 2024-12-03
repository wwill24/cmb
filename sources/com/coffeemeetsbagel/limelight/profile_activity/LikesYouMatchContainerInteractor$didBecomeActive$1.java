package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.match.models.Match;
import com.uber.autodispose.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import tj.b;

final class LikesYouMatchContainerInteractor$didBecomeActive$1 extends Lambda implements Function1<List<? extends Match>, Unit> {
    final /* synthetic */ LikesYouMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchContainerInteractor$didBecomeActive$1(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        super(1);
        this.this$0 = likesYouMatchContainerInteractor;
    }

    /* access modifiers changed from: private */
    public static final void e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        j.g(likesYouMatchContainerInteractor, "this$0");
        ((LikesYouProfilePresenter) likesYouMatchContainerInteractor.f7875e).H(false);
    }

    public final void d(List<Match> list) {
        if (list.isEmpty()) {
            int indexOf = this.this$0.f34402g.indexOf(this.this$0.C);
            a u10 = this.this$0.o2().u(this.this$0.f34402g.subList(indexOf, Math.min(indexOf + 5, this.this$0.f34402g.size())));
            final LikesYouMatchContainerInteractor likesYouMatchContainerInteractor = this.this$0;
            ((m) u10.t(new l0(new Function1<b, Unit>() {
                public final void a(b bVar) {
                    ((LikesYouProfilePresenter) likesYouMatchContainerInteractor.f7875e).H(true);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((b) obj);
                    return Unit.f32013a;
                }
            })).z(this.this$0.s2().a()).u(new m0(this.this$0)).j(com.uber.autodispose.a.a(this.this$0))).d();
            return;
        }
        this.this$0.H2(list.get(0));
        this.this$0.u2(list.get(0));
        ((LikesYouProfilePresenter) this.this$0.f7875e).u();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((List) obj);
        return Unit.f32013a;
    }
}
