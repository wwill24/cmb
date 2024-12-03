package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004JQ\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001e¨\u0006\""}, d2 = {"Lkotlinx/coroutines/a0;", "", "Lkotlinx/coroutines/o;", "cont", "", "cause", "", "d", "result", "Lkotlinx/coroutines/l;", "cancelHandler", "Lkotlin/Function1;", "onCancellation", "idempotentResume", "cancelCause", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "b", "Lkotlinx/coroutines/l;", "c", "Lkotlin/jvm/functions/Function1;", "e", "Ljava/lang/Throwable;", "()Z", "cancelled", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/l;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f32268a;

    /* renamed from: b  reason: collision with root package name */
    public final l f32269b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1<Throwable, Unit> f32270c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f32271d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f32272e;

    public a0(Object obj, l lVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th2) {
        this.f32268a = obj;
        this.f32269b = lVar;
        this.f32270c = function1;
        this.f32271d = obj2;
        this.f32272e = th2;
    }

    public static /* synthetic */ a0 b(a0 a0Var, Object obj, l lVar, Function1<Throwable, Unit> function1, Object obj2, Throwable th2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = a0Var.f32268a;
        }
        if ((i10 & 2) != 0) {
            lVar = a0Var.f32269b;
        }
        l lVar2 = lVar;
        if ((i10 & 4) != 0) {
            function1 = a0Var.f32270c;
        }
        Function1<Throwable, Unit> function12 = function1;
        if ((i10 & 8) != 0) {
            obj2 = a0Var.f32271d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th2 = a0Var.f32272e;
        }
        return a0Var.a(obj, lVar2, function12, obj4, th2);
    }

    public final a0 a(Object obj, l lVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th2) {
        return new a0(obj, lVar, function1, obj2, th2);
    }

    public final boolean c() {
        return this.f32272e != null;
    }

    public final void d(o<?> oVar, Throwable th2) {
        l lVar = this.f32269b;
        if (lVar != null) {
            oVar.k(lVar, th2);
        }
        Function1<Throwable, Unit> function1 = this.f32270c;
        if (function1 != null) {
            oVar.l(function1, th2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return j.b(this.f32268a, a0Var.f32268a) && j.b(this.f32269b, a0Var.f32269b) && j.b(this.f32270c, a0Var.f32270c) && j.b(this.f32271d, a0Var.f32271d) && j.b(this.f32272e, a0Var.f32272e);
    }

    public int hashCode() {
        Object obj = this.f32268a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        l lVar = this.f32269b;
        int hashCode2 = (hashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f32270c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f32271d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f32272e;
        if (th2 != null) {
            i10 = th2.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f32268a + ", cancelHandler=" + this.f32269b + ", onCancellation=" + this.f32270c + ", idempotentResume=" + this.f32271d + ", cancelCause=" + this.f32272e + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, l lVar, Function1 function1, Object obj2, Throwable th2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i10 & 2) != 0 ? null : lVar, (i10 & 4) != 0 ? null : function1, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th2);
    }
}
