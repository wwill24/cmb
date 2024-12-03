package androidx.lifecycle;

import android.view.View;
import kotlin.jvm.internal.j;
import l1.a;

public final class ViewTreeLifecycleOwner {
    public static final l a(View view) {
        j.g(view, "<this>");
        return (l) SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.r(SequencesKt__SequencesKt.e(view, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.f5986a), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.f5987a));
    }

    public static final void b(View view, l lVar) {
        j.g(view, "<this>");
        view.setTag(a.view_tree_lifecycle_owner, lVar);
    }
}
