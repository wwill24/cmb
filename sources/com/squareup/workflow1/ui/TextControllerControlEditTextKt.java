package com.squareup.workflow1.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a-\u0010\n\u001a\u00020\t*\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\u0006H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/squareup/workflow1/ui/k;", "Landroid/widget/EditText;", "view", "", "b", "Landroid/widget/TextView;", "Lkotlin/Function1;", "", "handler", "", "c", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/c;)Ljava/lang/Object;", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class TextControllerControlEditTextKt {

    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"com/squareup/workflow1/ui/TextControllerControlEditTextKt$a", "Landroid/text/TextWatcher;", "", "s", "", "start", "before", "count", "", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "after", "beforeTextChanged", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function1<CharSequence, Unit> f23179a;

        a(Function1<? super CharSequence, Unit> function1) {
            this.f23179a = function1;
        }

        public void afterTextChanged(Editable editable) {
            j.g(editable, "s");
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            this.f23179a.invoke(charSequence);
        }
    }

    public static final void b(k kVar, EditText editText) {
        n nVar;
        k kVar2;
        s1 b10;
        j.g(kVar, "<this>");
        j.g(editText, "view");
        int i10 = i.text_controller_rendering;
        Object tag = editText.getTag(i10);
        if (tag instanceof n) {
            nVar = (n) tag;
        } else {
            nVar = null;
        }
        if (nVar == null) {
            kVar2 = null;
        } else {
            kVar2 = nVar.a();
        }
        if (kVar2 != kVar || !nVar.b().a()) {
            if (!(nVar == null || (b10 = nVar.b()) == null)) {
                s1.a.a(b10, (CancellationException) null, 1, (Object) null);
            }
            editText.setText(kVar.c());
            editText.setTag(i10, new n(kVar, ViewLaunchWhenAttachedKt.c(editText, (CoroutineContext) null, new TextControllerControlEditTextKt$control$subscription$1(kVar, editText, (c<? super TextControllerControlEditTextKt$control$subscription$1>) null), 1, (Object) null)));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(android.widget.TextView r4, kotlin.jvm.functions.Function1<? super java.lang.CharSequence, kotlin.Unit> r5, kotlin.coroutines.c<?> r6) {
        /*
            boolean r0 = r6 instanceof com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1 r0 = (com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1 r0 = new com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x002d:
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r4 = r0.L$0
            android.widget.TextView r4 = (android.widget.TextView) r4
            gk.g.b(r6)
            goto L_0x006e
        L_0x0039:
            gk.g.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlinx.coroutines.o r6 = new kotlinx.coroutines.o
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)
            r6.<init>(r2, r3)
            r6.y()
            com.squareup.workflow1.ui.TextControllerControlEditTextKt$a r2 = new com.squareup.workflow1.ui.TextControllerControlEditTextKt$a
            r2.<init>(r5)
            r4.addTextChangedListener(r2)
            com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$2$1 r5 = new com.squareup.workflow1.ui.TextControllerControlEditTextKt$listenForTextChangesUntilCancelled$2$1
            r5.<init>(r4, r2)
            r6.o(r5)
            java.lang.Object r4 = r6.v()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.b.d()
            if (r4 != r5) goto L_0x006b
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x006b:
            if (r4 != r1) goto L_0x006e
            return r1
        L_0x006e:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.TextControllerControlEditTextKt.c(android.widget.TextView, kotlin.jvm.functions.Function1, kotlin.coroutines.c):java.lang.Object");
    }
}
