package com.skydoves.balloon;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class g implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f22800a;

    public /* synthetic */ g(Function2 function2) {
        this.f22800a = function2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return Balloon.A0(this.f22800a, view, motionEvent);
    }
}
