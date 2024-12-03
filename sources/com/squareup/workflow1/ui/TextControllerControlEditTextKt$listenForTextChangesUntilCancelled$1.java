package com.squareup.workflow1.ui;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;

@d(c = "com.squareup.workflow1.ui.TextControllerControlEditTextKt", f = "TextControllerControlEditText.kt", l = {91}, m = "listenForTextChangesUntilCancelled")
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1(c<? super TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TextControllerControlEditTextKt.c((TextView) null, (Function1<? super CharSequence, Unit>) null, this);
    }
}
