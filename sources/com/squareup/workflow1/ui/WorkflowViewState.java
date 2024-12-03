package com.squareup.workflow1.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001:\u0002\u0013\tB\t\b\u0004¢\u0006\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0007\u001a\u00028\u00008 X¡\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00028\u0000`\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowViewState;", "", "RenderingT", "c", "()Ljava/lang/Object;", "getShowing$annotations", "()V", "showing", "Lcom/squareup/workflow1/ui/p;", "a", "()Lcom/squareup/workflow1/ui/p;", "environment", "Lkotlin/Function2;", "", "Lcom/squareup/workflow1/ui/ViewShowRendering;", "b", "()Lkotlin/jvm/functions/Function2;", "showRendering", "<init>", "New", "Lcom/squareup/workflow1/ui/WorkflowViewState$New;", "Lcom/squareup/workflow1/ui/WorkflowViewState$a;", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public abstract class WorkflowViewState<RenderingT> {

    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B;\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00028\u0001`\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000f\u001a\u00028\u00018\u0010X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R6\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00028\u0001`\u00178\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowViewState$a;", "", "RenderingT", "Lcom/squareup/workflow1/ui/WorkflowViewState;", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "showing", "Lcom/squareup/workflow1/ui/p;", "b", "Lcom/squareup/workflow1/ui/p;", "()Lcom/squareup/workflow1/ui/p;", "environment", "Lkotlin/Function2;", "", "Lcom/squareup/workflow1/ui/ViewShowRendering;", "c", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "showRendering", "<init>", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Lkotlin/jvm/functions/Function2;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class a<RenderingT> extends WorkflowViewState<RenderingT> {

        /* renamed from: a  reason: collision with root package name */
        private final RenderingT f23193a;

        /* renamed from: b  reason: collision with root package name */
        private final p f23194b;

        /* renamed from: c  reason: collision with root package name */
        private final Function2<RenderingT, p, Unit> f23195c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RenderingT renderingt, p pVar, Function2<? super RenderingT, ? super p, Unit> function2) {
            super((DefaultConstructorMarker) null);
            j.g(renderingt, "showing");
            j.g(pVar, "environment");
            j.g(function2, "showRendering");
            this.f23193a = renderingt;
            this.f23194b = pVar;
            this.f23195c = function2;
        }

        public p a() {
            return this.f23194b;
        }

        public Function2<RenderingT, p, Unit> b() {
            return this.f23195c;
        }

        /* renamed from: d */
        public RenderingT c() {
            return this.f23193a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(c(), aVar.c()) && j.b(a(), aVar.a()) && j.b(b(), aVar.b());
        }

        public int hashCode() {
            return (((c().hashCode() * 31) + a().hashCode()) * 31) + b().hashCode();
        }

        public String toString() {
            return "Started(showing=" + c() + ", environment=" + a() + ", showRendering=" + b() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    private WorkflowViewState() {
    }

    public /* synthetic */ WorkflowViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract p a();

    public abstract Function2<RenderingT, p, Unit> b();

    public abstract RenderingT c();

    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003BQ\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0001`\t\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b$\u0010%Jf\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00052$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0001`\t2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0004\u001a\u00028\u00018\u0010X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001b\u0010 R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowViewState$New;", "", "RenderingT", "Lcom/squareup/workflow1/ui/WorkflowViewState;", "showing", "Lcom/squareup/workflow1/ui/p;", "environment", "Lkotlin/Function2;", "", "Lcom/squareup/workflow1/ui/ViewShowRendering;", "showRendering", "Lkotlin/Function1;", "Landroid/view/View;", "starter", "d", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/squareup/workflow1/ui/WorkflowViewState$New;", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "b", "Lcom/squareup/workflow1/ui/p;", "()Lcom/squareup/workflow1/ui/p;", "c", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "g", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class New<RenderingT> extends WorkflowViewState<RenderingT> {

        /* renamed from: a  reason: collision with root package name */
        private final RenderingT f23188a;

        /* renamed from: b  reason: collision with root package name */
        private final p f23189b;

        /* renamed from: c  reason: collision with root package name */
        private final Function2<RenderingT, p, Unit> f23190c;

        /* renamed from: d  reason: collision with root package name */
        private final Function1<View, Unit> f23191d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ New(Object obj, p pVar, Function2 function2, Function1 function1, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, pVar, function2, (i10 & 8) != 0 ? AnonymousClass1.f23192a : function1);
        }

        public static /* synthetic */ New e(New newR, Object obj, p pVar, Function2 function2, Function1<View, Unit> function1, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = newR.c();
            }
            if ((i10 & 2) != 0) {
                pVar = newR.a();
            }
            if ((i10 & 4) != 0) {
                function2 = newR.b();
            }
            if ((i10 & 8) != 0) {
                function1 = newR.f23191d;
            }
            return newR.d(obj, pVar, function2, function1);
        }

        public p a() {
            return this.f23189b;
        }

        public Function2<RenderingT, p, Unit> b() {
            return this.f23190c;
        }

        public final New<RenderingT> d(RenderingT renderingt, p pVar, Function2<? super RenderingT, ? super p, Unit> function2, Function1<? super View, Unit> function1) {
            j.g(renderingt, "showing");
            j.g(pVar, "environment");
            j.g(function2, "showRendering");
            j.g(function1, "starter");
            return new New<>(renderingt, pVar, function2, function1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof New)) {
                return false;
            }
            New newR = (New) obj;
            return j.b(c(), newR.c()) && j.b(a(), newR.a()) && j.b(b(), newR.b()) && j.b(this.f23191d, newR.f23191d);
        }

        /* renamed from: f */
        public RenderingT c() {
            return this.f23188a;
        }

        public final Function1<View, Unit> g() {
            return this.f23191d;
        }

        public int hashCode() {
            return (((((c().hashCode() * 31) + a().hashCode()) * 31) + b().hashCode()) * 31) + this.f23191d.hashCode();
        }

        public String toString() {
            return "New(showing=" + c() + ", environment=" + a() + ", showRendering=" + b() + ", starter=" + this.f23191d + PropertyUtils.MAPPED_DELIM2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public New(RenderingT renderingt, p pVar, Function2<? super RenderingT, ? super p, Unit> function2, Function1<? super View, Unit> function1) {
            super((DefaultConstructorMarker) null);
            j.g(renderingt, "showing");
            j.g(pVar, "environment");
            j.g(function2, "showRendering");
            j.g(function1, "starter");
            this.f23188a = renderingt;
            this.f23189b = pVar;
            this.f23190c = function2;
            this.f23191d = function1;
        }
    }
}
