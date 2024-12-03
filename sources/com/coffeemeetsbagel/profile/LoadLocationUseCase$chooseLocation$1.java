package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class LoadLocationUseCase$chooseLocation$1 extends Lambda implements Function1<Optional<QuestionWAnswers>, com.coffeemeetsbagel.utils.model.Optional<Location>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LoadLocationUseCase$chooseLocation$1 f36024a = new LoadLocationUseCase$chooseLocation$1();

    LoadLocationUseCase$chooseLocation$1() {
        super(1);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Optional, java.util.Optional<com.coffeemeetsbagel.qna.QuestionWAnswers>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.coffeemeetsbagel.utils.model.Optional<com.coffeemeetsbagel.models.dto.Location> invoke(java.util.Optional<com.coffeemeetsbagel.qna.QuestionWAnswers> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "question"
            kotlin.jvm.internal.j.g(r2, r0)
            java.lang.Object r2 = rk.a.a(r2)
            com.coffeemeetsbagel.qna.QuestionWAnswers r2 = (com.coffeemeetsbagel.qna.QuestionWAnswers) r2
            if (r2 == 0) goto L_0x0020
            java.util.List r2 = r2.d()
            if (r2 == 0) goto L_0x0020
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
            com.coffeemeetsbagel.models.dto.Answer r2 = (com.coffeemeetsbagel.models.dto.Answer) r2
            if (r2 == 0) goto L_0x0020
            com.coffeemeetsbagel.models.dto.Location r2 = r2.getLocation()
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            com.coffeemeetsbagel.utils.model.Optional r2 = com.coffeemeetsbagel.utils.model.Optional.b(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.profile.LoadLocationUseCase$chooseLocation$1.invoke(java.util.Optional):com.coffeemeetsbagel.utils.model.Optional");
    }
}
