package com.squareup.workflow1.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0010\"J\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006*\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u00068F@FX\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\" \u0010\u0013\u001a\u0004\u0018\u00010\u000f*\u00020\u00038BX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011*\u0018\b\u0007\u0010\u0014\"\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0015"}, d2 = {"Landroid/content/Context;", "Landroidx/activity/n;", "b", "Landroid/view/View;", "Lkotlin/Function0;", "", "Lcom/squareup/workflow1/ui/BackPressHandler;", "value", "getBackPressedHandler", "(Landroid/view/View;)Lkotlin/jvm/functions/Function0;", "c", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "getBackPressedHandler$annotations", "(Landroid/view/View;)V", "backPressedHandler", "Lcom/squareup/workflow1/ui/HandleBackPressWhenAttached;", "a", "(Landroid/view/View;)Lcom/squareup/workflow1/ui/HandleBackPressWhenAttached;", "getHandlerWrapperOrNull$annotations", "handlerWrapperOrNull", "BackPressHandler", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class b {
    private static final HandleBackPressWhenAttached a(View view) {
        return (HandleBackPressWhenAttached) view.getTag(i.view_back_handler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.activity.n b(android.content.Context r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.g(r2, r0)
        L_0x0005:
            boolean r0 = r2 instanceof androidx.activity.n
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r1 = r2
            androidx.activity.n r1 = (androidx.activity.n) r1
            goto L_0x001f
        L_0x000e:
            boolean r0 = r2 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L_0x0015
            android.content.ContextWrapper r2 = (android.content.ContextWrapper) r2
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            if (r2 != 0) goto L_0x0019
            goto L_0x001f
        L_0x0019:
            android.content.Context r2 = r2.getBaseContext()
            if (r2 != 0) goto L_0x0005
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.b.b(android.content.Context):androidx.activity.n");
    }

    public static final void c(View view, Function0<Unit> function0) {
        HandleBackPressWhenAttached handleBackPressWhenAttached;
        j.g(view, "<this>");
        HandleBackPressWhenAttached a10 = a(view);
        if (a10 != null) {
            a10.c();
        }
        if (function0 == null) {
            handleBackPressWhenAttached = null;
        } else {
            HandleBackPressWhenAttached handleBackPressWhenAttached2 = new HandleBackPressWhenAttached(view, function0);
            handleBackPressWhenAttached2.b();
            handleBackPressWhenAttached = handleBackPressWhenAttached2;
        }
        view.setTag(i.view_back_handler, handleBackPressWhenAttached);
    }
}
