package com.coffeemeetsbagel.new_user_experience.introductions;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import na.b;
import org.jivesoftware.smackx.mam.element.MamElements;

final class IntroductionsInteractor$onNext$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ IntroductionsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntroductionsInteractor$onNext$1$1(IntroductionsInteractor introductionsInteractor) {
        super(1);
        this.this$0 = introductionsInteractor;
    }

    public final void a(Integer num) {
        j.f(num, MamElements.MamResultExtension.ELEMENT);
        if (num.intValue() > 0) {
            b.f(this.this$0.R1(), (Map) null, 1, (Object) null);
        } else {
            this.this$0.R1().onError(((IntroductionsPresenter) this.this$0.f7875e).z());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
