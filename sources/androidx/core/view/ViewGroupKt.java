package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0002\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Landroid/view/ViewGroup;", "", "Landroid/view/View;", "c", "Lkotlin/sequences/Sequence;", "a", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "children", "b", "descendants", "core-ktx_release"}, k = 2, mv = {1, 7, 1})
public final class ViewGroupKt {

    @Metadata(bv = {}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"androidx/core/view/ViewGroupKt$a", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "", "iterator", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements Sequence<View> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f4744a;

        a(ViewGroup viewGroup) {
            this.f4744a = viewGroup;
        }

        public Iterator<View> iterator() {
            return ViewGroupKt.c(this.f4744a);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"androidx/core/view/ViewGroupKt$b", "", "Landroid/view/View;", "", "hasNext", "a", "", "remove", "", "I", "index", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    public static final class b implements Iterator<View>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private int f4745a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f4746b;

        b(ViewGroup viewGroup) {
            this.f4746b = viewGroup;
        }

        /* renamed from: a */
        public View next() {
            ViewGroup viewGroup = this.f4746b;
            int i10 = this.f4745a;
            this.f4745a = i10 + 1;
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        public boolean hasNext() {
            return this.f4745a < this.f4746b.getChildCount();
        }

        public void remove() {
            ViewGroup viewGroup = this.f4746b;
            int i10 = this.f4745a - 1;
            this.f4745a = i10;
            viewGroup.removeViewAt(i10);
        }
    }

    public static final Sequence<View> a(ViewGroup viewGroup) {
        j.g(viewGroup, "<this>");
        return new a(viewGroup);
    }

    public static final Sequence<View> b(ViewGroup viewGroup) {
        j.g(viewGroup, "<this>");
        return j.b(new ViewGroupKt$descendants$1(viewGroup, (c<? super ViewGroupKt$descendants$1>) null));
    }

    public static final Iterator<View> c(ViewGroup viewGroup) {
        j.g(viewGroup, "<this>");
        return new b(viewGroup);
    }
}
