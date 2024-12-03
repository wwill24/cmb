package com.coffeemeetsbagel.qna;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetTextAnswersUseCase$invoke$1 extends Lambda implements Function1<List<? extends QnaPair>, List<? extends QnaPair>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetTextAnswersUseCase$invoke$1 f36206a = new GetTextAnswersUseCase$invoke$1();

    GetTextAnswersUseCase$invoke$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<QnaPair> invoke(List<QnaPair> list) {
        boolean z10;
        j.g(list, "qnaPairs");
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (((QnaPair) next).a().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
