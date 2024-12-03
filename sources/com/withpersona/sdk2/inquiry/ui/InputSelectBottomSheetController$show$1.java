package com.withpersona.sdk2.inquiry.ui;

import android.content.Context;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import ti.a;

final class InputSelectBottomSheetController$show$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ e $adapter;
    final /* synthetic */ Ref$ObjectRef<Function1<List<String>, Unit>> $currentOnItemsSelectedListener;
    final /* synthetic */ Integer $originalStatusBarColor;
    final /* synthetic */ InputSelectBottomSheetController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputSelectBottomSheetController$show$1(Integer num, Ref$ObjectRef<Function1<List<String>, Unit>> ref$ObjectRef, e eVar, InputSelectBottomSheetController inputSelectBottomSheetController) {
        super(1);
        this.$originalStatusBarColor = num;
        this.$currentOnItemsSelectedListener = ref$ObjectRef;
        this.$adapter = eVar;
        this.this$0 = inputSelectBottomSheetController;
    }

    public final void a(int i10) {
        if (i10 == 4) {
            Integer num = this.$originalStatusBarColor;
            if (num != null) {
                InputSelectBottomSheetController inputSelectBottomSheetController = this.this$0;
                int intValue = num.intValue();
                Context context = inputSelectBottomSheetController.g().getRoot().getContext();
                j.f(context, "binding.root.context");
                a.f(context, intValue);
            }
            Function1 function1 = (Function1) this.$currentOnItemsSelectedListener.element;
            if (function1 != null) {
                function1.invoke(CollectionsKt___CollectionsKt.x0(this.$adapter.I()));
            }
            this.$currentOnItemsSelectedListener.element = null;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a(((Number) obj).intValue());
        return Unit.f32013a;
    }
}
