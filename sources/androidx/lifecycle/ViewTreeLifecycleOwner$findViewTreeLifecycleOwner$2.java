package androidx.lifecycle;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import l1.a;

final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends Lambda implements Function1<View, l> {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 f5987a = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2() {
        super(1);
    }

    /* renamed from: a */
    public final l invoke(View view) {
        j.g(view, "viewParent");
        Object tag = view.getTag(a.view_tree_lifecycle_owner);
        if (tag instanceof l) {
            return (l) tag;
        }
        return null;
    }
}
