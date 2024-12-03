package com.coffeemeetsbagel.view;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.l;
import com.coffeemeetsbagel.R;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class e {
    public static final Balloon.a b(Balloon.a aVar, l lVar, Resources resources) {
        j.g(aVar, "<this>");
        j.g(lVar, "lifecycle");
        j.g(resources, "resources");
        return aVar.G1(1.0f).g1(Integer.MIN_VALUE).v1(resources.getDimensionPixelOffset(R.dimen.baseline_1x)).d1(12.0f).b1(R.color.white).c1(BalloonAnimation.ELASTIC).m1(lVar).e1(8).B1(R.color.black).F1(14.0f).C1(8388611).j1(38).i1(38).k1(true).a1(R.dimen.baseline_1x).U0(R.drawable.tooltip_arrow).Y0(ArrowPositionRules.ALIGN_ANCHOR).V0(8);
    }

    public static final void c(View view) {
        j.g(view, "<this>");
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static final void d(EditText editText, Function1<? super String, Unit> function1) {
        j.g(editText, "<this>");
        j.g(function1, "consumer");
        editText.setOnEditorActionListener(new d(function1, editText));
    }

    /* access modifiers changed from: private */
    public static final boolean e(Function1 function1, EditText editText, TextView textView, int i10, KeyEvent keyEvent) {
        j.g(function1, "$consumer");
        j.g(editText, "$this_onKeyboardEnter");
        if (i10 != 6) {
            return false;
        }
        function1.invoke(editText.getText().toString());
        return false;
    }
}
