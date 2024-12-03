package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.j;
import r1.a;
import r1.d;

public final class ViewTreeSavedStateRegistryOwner {
    public static final d a(View view) {
        j.g(view, "<this>");
        return (d) SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.r(SequencesKt__SequencesKt.e(view, ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1.f6975a), ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2.f6976a));
    }

    public static final void b(View view, d dVar) {
        j.g(view, "<this>");
        view.setTag(a.view_tree_saved_state_registry_owner, dVar);
    }
}
