package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;

final class AgeMatchPreferenceInteractor$didBecomeActive$3 extends Lambda implements Function1<String, f> {
    final /* synthetic */ AgeMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AgeMatchPreferenceInteractor$didBecomeActive$3(AgeMatchPreferenceInteractor ageMatchPreferenceInteractor) {
        super(1);
        this.this$0 = ageMatchPreferenceInteractor;
    }

    /* access modifiers changed from: private */
    public static final void e(AgeMatchPreferenceInteractor ageMatchPreferenceInteractor) {
        j.g(ageMatchPreferenceInteractor, "this$0");
        ageMatchPreferenceInteractor.O1().onSuccess("age");
    }

    /* access modifiers changed from: private */
    public static final void f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* renamed from: d */
    public final f invoke(String str) {
        j.g(str, "it");
        a q10 = this.this$0.S1().f(((k) this.this$0.f7875e).l(), ((k) this.this$0.f7875e).m()).q(new f(this.this$0));
        final AgeMatchPreferenceInteractor ageMatchPreferenceInteractor = this.this$0;
        return q10.r(new g(new Function1<Throwable, Unit>() {
            public final void a(Throwable th2) {
                ageMatchPreferenceInteractor.O1().onError(((k) ageMatchPreferenceInteractor.f7875e).o());
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return Unit.f32013a;
            }
        }));
    }
}
