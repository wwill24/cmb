package com.squareup.workflow1.ui;

import android.widget.EditText;
import gk.g;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "com.squareup.workflow1.ui.TextControllerControlEditTextKt$control$subscription$1", f = "TextControllerControlEditText.kt", l = {47}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class TextControllerControlEditTextKt$control$subscription$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ k $this_control;
    final /* synthetic */ EditText $view;
    private /* synthetic */ Object L$0;
    int label;

    @d(c = "com.squareup.workflow1.ui.TextControllerControlEditTextKt$control$subscription$1$1", f = "TextControllerControlEditText.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "textValue", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* renamed from: com.squareup.workflow1.ui.TextControllerControlEditTextKt$control$subscription$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<String, c<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            AnonymousClass1 r02 = new AnonymousClass1(editText, cVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(String str, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(str, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = b.d();
            if (this.label == 0) {
                g.b(obj);
                String str = (String) this.L$0;
                if (!j.b(str, editText.getText().toString())) {
                    editText.setText(str);
                }
                return Unit.f32013a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextControllerControlEditTextKt$control$subscription$1(k kVar, EditText editText, c<? super TextControllerControlEditTextKt$control$subscription$1> cVar) {
        super(2, cVar);
        this.$this_control = kVar;
        this.$view = editText;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        TextControllerControlEditTextKt$control$subscription$1 textControllerControlEditTextKt$control$subscription$1 = new TextControllerControlEditTextKt$control$subscription$1(this.$this_control, this.$view, cVar);
        textControllerControlEditTextKt$control$subscription$1.L$0 = obj;
        return textControllerControlEditTextKt$control$subscription$1;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((TextControllerControlEditTextKt$control$subscription$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            b<String> a10 = this.$this_control.a();
            final EditText editText = this.$view;
            kotlinx.coroutines.flow.d.z(kotlinx.coroutines.flow.d.D(a10, new AnonymousClass1((c<? super AnonymousClass1>) null)), (k0) this.L$0);
            EditText editText2 = this.$view;
            final k kVar = this.$this_control;
            AnonymousClass2 r12 = new Function1<CharSequence, Unit>() {
                public final void a(CharSequence charSequence) {
                    k kVar = kVar;
                    String obj = charSequence == null ? null : charSequence.toString();
                    if (obj == null) {
                        obj = "";
                    }
                    kVar.d(obj);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((CharSequence) obj);
                    return Unit.f32013a;
                }
            };
            this.label = 1;
            if (TextControllerControlEditTextKt.c(editText2, r12, this) == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            g.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
