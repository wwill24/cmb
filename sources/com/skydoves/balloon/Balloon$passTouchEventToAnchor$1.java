package com.skydoves.balloon;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class Balloon$passTouchEventToAnchor$1 extends Lambda implements Function2<View, MotionEvent, Boolean> {
    final /* synthetic */ View $anchor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Balloon$passTouchEventToAnchor$1(View view) {
        super(2);
        this.$anchor = view;
    }

    /* renamed from: a */
    public final Boolean invoke(View view, MotionEvent motionEvent) {
        boolean z10;
        j.g(view, "view");
        j.g(motionEvent, "event");
        view.performClick();
        Rect rect = new Rect();
        this.$anchor.getGlobalVisibleRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            this.$anchor.getRootView().dispatchTouchEvent(motionEvent);
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
