package com.coffeemeetsbagel.dialogs.question_chips;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f12141a;

    public /* synthetic */ a(Function2 function2) {
        this.f12141a = function2;
    }

    public final int compare(Object obj, Object obj2) {
        return QuestionGroupAdapter.L(this.f12141a, obj, obj2);
    }
}
