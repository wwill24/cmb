package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "Lkotlin/sequences/Sequence;", "a", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "allViews", "core-ktx_release"}, k = 2, mv = {1, 7, 1})
public final class ViewKt {
    public static final Sequence<View> a(View view) {
        j.g(view, "<this>");
        return j.b(new ViewKt$allViews$1(view, (c<? super ViewKt$allViews$1>) null));
    }
}
