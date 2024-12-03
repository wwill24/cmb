package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.enums.QuestionType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

final class FragmentMyProfileDetails$onCreateView$7 extends Lambda implements Function1<List<? extends QuestionWAnswers>, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$onCreateView$7(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    /* access modifiers changed from: private */
    public static final void d(FragmentMyProfileDetails fragmentMyProfileDetails, Option option) {
        j.g(fragmentMyProfileDetails, "this$0");
        j.g(option, "<name for destructuring parameter 0>");
        fragmentMyProfileDetails.f13532k0.put(option.component1(), option.component3());
    }

    public final void c(List<QuestionWAnswers> list) {
        j.g(list, MamElements.MamResultExtension.ELEMENT);
        for (QuestionWAnswers next : list) {
            Question a10 = next.a();
            List<Answer> c10 = next.c();
            if (a10.getType() == QuestionType.TEXT) {
                this.this$0.f13547t0 = a10.getId();
                if (!c10.isEmpty()) {
                    this.this$0.f13545s0 = c10.get(0).getTextValue();
                }
                FragmentMyProfileDetails fragmentMyProfileDetails = this.this$0;
                fragmentMyProfileDetails.k4(fragmentMyProfileDetails.f13545s0);
            } else if (a10.getType() == QuestionType.MULTIPLE_CHOICE) {
                this.this$0.f13548u0 = a10.getId();
                a10.getOptions().forEach(new h4(this.this$0));
                for (Answer component2 : c10) {
                    String component22 = component2.component2();
                    this.this$0.f13534l0.add((String) this.this$0.f13532k0.get(component22));
                }
                FragmentMyProfileDetails fragmentMyProfileDetails2 = this.this$0;
                fragmentMyProfileDetails2.n4(fragmentMyProfileDetails2.f13534l0);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((List) obj);
        return Unit.f32013a;
    }
}
