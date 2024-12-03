package androidx.savedstate;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import r1.a;
import r1.d;

final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 extends Lambda implements Function1<View, d> {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 f6976a = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2();

    ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2() {
        super(1);
    }

    /* renamed from: a */
    public final d invoke(View view) {
        j.g(view, "view");
        Object tag = view.getTag(a.view_tree_saved_state_registry_owner);
        if (tag instanceof d) {
            return (d) tag;
        }
        return null;
    }
}
