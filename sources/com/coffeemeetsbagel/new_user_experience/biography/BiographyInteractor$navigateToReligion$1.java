package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fa.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyInteractor$navigateToReligion$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToReligion$1(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        String str;
        String str2;
        List<Option> options = questionWAnswers.e().getOptions();
        ArrayList arrayList = new ArrayList(r.t(options, 10));
        Iterator<T> it = options.iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            Option option = (Option) it.next();
            arrayList.add(new Resource(option.getId(), option.getTitle(), str));
        }
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer != null) {
            str2 = answer.getOptionId();
        } else {
            str2 = null;
        }
        try {
            for (T next : questionWAnswers.e().getOptions()) {
                if (j.b(((Option) next).getId(), str2)) {
                    str = ((Option) next).getTitle();
                    a.C0491a aVar = a.f40771d;
                    String v22 = this.this$0.f34810f;
                    aVar.a(v22, "showReligion: " + arrayList);
                    ((BiographyPresenter) this.this$0.f7875e).R(arrayList, str, this.$goingForwards);
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            a.f40771d.a(this.this$0.f34810f, "Exception trying to find the pre-selected Religion");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
