package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.j;

public final class q {
    public static final void a(View view, n nVar) {
        j.g(view, "<this>");
        j.g(nVar, "onBackPressedDispatcherOwner");
        view.setTag(o.view_tree_on_back_pressed_dispatcher_owner, nVar);
    }
}
