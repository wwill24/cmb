package com.withpersona.sdk2.inquiry.ui;

import android.content.Context;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.withpersona.sdk2.inquiry.steps.ui.components.d;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import ti.a;

final class InputSelectBottomSheetController$show$adapter$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ BottomSheetBehavior<LinearLayout> $behavior;
    final /* synthetic */ d $component;
    final /* synthetic */ Ref$ObjectRef<Function1<List<String>, Unit>> $currentOnItemsSelectedListener;
    final /* synthetic */ Integer $originalStatusBarColor;
    final /* synthetic */ InputSelectBottomSheetController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputSelectBottomSheetController$show$adapter$1(d dVar, Integer num, BottomSheetBehavior<LinearLayout> bottomSheetBehavior, Ref$ObjectRef<Function1<List<String>, Unit>> ref$ObjectRef, InputSelectBottomSheetController inputSelectBottomSheetController) {
        super(1);
        this.$component = dVar;
        this.$originalStatusBarColor = num;
        this.$behavior = bottomSheetBehavior;
        this.$currentOnItemsSelectedListener = ref$ObjectRef;
        this.this$0 = inputSelectBottomSheetController;
    }

    public final void a(String str) {
        j.g(str, "selectedItem");
        if (!this.$component.l()) {
            Integer num = this.$originalStatusBarColor;
            if (num != null) {
                InputSelectBottomSheetController inputSelectBottomSheetController = this.this$0;
                int intValue = num.intValue();
                Context context = inputSelectBottomSheetController.g().getRoot().getContext();
                j.f(context, "binding.root.context");
                a.f(context, intValue);
            }
            this.$behavior.Q0(4);
            Function1 function1 = (Function1) this.$currentOnItemsSelectedListener.element;
            if (function1 != null) {
                function1.invoke(p.e(str));
            }
            this.$currentOnItemsSelectedListener.element = null;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
