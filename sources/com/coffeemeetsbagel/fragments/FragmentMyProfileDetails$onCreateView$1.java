package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;
import s7.b;

final class FragmentMyProfileDetails$onCreateView$1 extends Lambda implements Function1<List<? extends QuestionWAnswers>, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$onCreateView$1(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    public final void a(List<QuestionWAnswers> list) {
        j.g(list, MamElements.MamResultExtension.ELEMENT);
        b k22 = this.this$0.f13551w0;
        j.d(k22);
        k22.H(list);
        b k23 = this.this$0.f13551w0;
        j.d(k23);
        k23.l();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
