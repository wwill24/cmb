package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/c0;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "result", "Lkotlin/Function1;", "", "", "b", "Lkotlin/jvm/functions/Function1;", "onCancellation", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f32288a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Throwable, Unit> f32289b;

    public c0(Object obj, Function1<? super Throwable, Unit> function1) {
        this.f32288a = obj;
        this.f32289b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return j.b(this.f32288a, c0Var.f32288a) && j.b(this.f32289b, c0Var.f32289b);
    }

    public int hashCode() {
        Object obj = this.f32288a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f32289b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f32288a + ", onCancellation=" + this.f32289b + PropertyUtils.MAPPED_DELIM2;
    }
}
