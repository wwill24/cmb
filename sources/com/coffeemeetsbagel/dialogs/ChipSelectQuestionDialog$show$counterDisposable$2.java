package com.coffeemeetsbagel.dialogs;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* synthetic */ class ChipSelectQuestionDialog$show$counterDisposable$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    ChipSelectQuestionDialog$show$counterDisposable$2(Object obj) {
        super(1, obj, ChipSelectQuestionDialog.class, "showCounter", "showCounter(I)V", 0);
    }

    public final void c(int i10) {
        ((ChipSelectQuestionDialog) this.receiver).g(i10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c(((Number) obj).intValue());
        return Unit.f32013a;
    }
}
