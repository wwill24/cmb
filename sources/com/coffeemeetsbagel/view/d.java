package com.coffeemeetsbagel.view;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37592a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f37593b;

    public /* synthetic */ d(Function1 function1, EditText editText) {
        this.f37592a = function1;
        this.f37593b = editText;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return e.e(this.f37592a, this.f37593b, textView, i10, keyEvent);
    }
}
