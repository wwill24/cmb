package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends Lambda implements Function1<View, View> {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 f5986a = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1() {
        super(1);
    }

    /* renamed from: a */
    public final View invoke(View view) {
        j.g(view, "currentView");
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
