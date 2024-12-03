package di;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u001d\u0012\u0006\u0010\u0019\u001a\u00028\u0000\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u001d"}, d2 = {"Ldi/b;", "", "StackedT", "R", "Lkotlin/Function1;", "transform", "d", "other", "", "equals", "", "hashCode", "", "toString", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "frames", "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", "top", "backStack", "bottom", "rest", "<init>", "(Ljava/lang/Object;Ljava/util/List;)V", "wf1-container-common"}, k = 1, mv = {1, 6, 0})
public final class b<StackedT> {

    /* renamed from: a  reason: collision with root package name */
    private final List<StackedT> f23369a;

    /* renamed from: b  reason: collision with root package name */
    private final StackedT f23370b;

    /* renamed from: c  reason: collision with root package name */
    private final List<StackedT> f23371c;

    public b(StackedT stackedt, List<? extends StackedT> list) {
        j.g(stackedt, "bottom");
        j.g(list, "rest");
        List<StackedT> h02 = CollectionsKt___CollectionsKt.h0(p.e(stackedt), list);
        this.f23369a = h02;
        this.f23370b = CollectionsKt___CollectionsKt.Y(h02);
        this.f23371c = h02.subList(0, h02.size() - 1);
    }

    public final List<StackedT> a() {
        return this.f23371c;
    }

    public final List<StackedT> b() {
        return this.f23369a;
    }

    public final StackedT c() {
        return this.f23370b;
    }

    public final <R> b<R> d(Function1<? super StackedT, ? extends R> function1) {
        j.g(function1, "transform");
        List<StackedT> list = this.f23369a;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (StackedT invoke : list) {
            arrayList.add(function1.invoke(invoke));
        }
        return c.a(arrayList);
    }

    public boolean equals(Object obj) {
        List<StackedT> list = null;
        b bVar = obj instanceof b ? (b) obj : null;
        if (bVar != null) {
            list = bVar.f23369a;
        }
        return j.b(list, this.f23369a);
    }

    public int hashCode() {
        return this.f23369a.hashCode();
    }

    public String toString() {
        return b.class.getSimpleName() + PropertyUtils.MAPPED_DELIM + this.f23369a + PropertyUtils.MAPPED_DELIM2;
    }
}
