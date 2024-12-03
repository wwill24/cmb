package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0003B+\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012R$\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0004\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/squareup/workflow1/ui/BackButtonScreen;", "", "W", "Lcom/squareup/workflow1/ui/a;", "a", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "wrapped", "", "b", "Z", "c", "()Z", "shadow", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "onBackPressed", "Lcom/squareup/workflow1/ui/r;", "Lcom/squareup/workflow1/ui/r;", "()Lcom/squareup/workflow1/ui/r;", "viewFactory", "<init>", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class BackButtonScreen<W> implements a<BackButtonScreen<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final W f23157a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23158b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f23159c;

    /* renamed from: d  reason: collision with root package name */
    private final r<BackButtonScreen<?>> f23160d;

    public BackButtonScreen(W w10, boolean z10, Function0<Unit> function0) {
        j.g(w10, "wrapped");
        this.f23157a = w10;
        this.f23158b = z10;
        this.f23159c = function0;
        this.f23160d = new DecorativeViewFactory(l.b(BackButtonScreen.class), BackButtonScreen$viewFactory$1.f23161a, (u) null, BackButtonScreen$viewFactory$2.f23162a, 4, (DefaultConstructorMarker) null);
    }

    public r<BackButtonScreen<?>> a() {
        return this.f23160d;
    }

    public final Function0<Unit> b() {
        return this.f23159c;
    }

    public final boolean c() {
        return this.f23158b;
    }

    public final W d() {
        return this.f23157a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackButtonScreen(Object obj, boolean z10, Function0 function0, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : function0);
    }
}
