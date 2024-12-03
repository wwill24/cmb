package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import pk.o;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0001R \u0010\u000f\u001a\u000e\u0012\n\b\u0000\u0012\u0006\u0012\u0002\b\u00030\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/squareup/workflow1/ui/NamedViewFactory;", "Lcom/squareup/workflow1/ui/r;", "Lcom/squareup/workflow1/ui/h;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "b", "Lwk/c;", "getType", "()Lwk/c;", "type", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class NamedViewFactory implements r<h<?>> {

    /* renamed from: b  reason: collision with root package name */
    public static final NamedViewFactory f23174b = new NamedViewFactory();

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ DecorativeViewFactory<h<?>, Object> f23175a = new DecorativeViewFactory(l.b(h.class), AnonymousClass1.f23176a, (u) null, (o) null, 12, (DefaultConstructorMarker) null);

    private NamedViewFactory() {
    }

    /* renamed from: b */
    public View a(h<?> hVar, p pVar, Context context, ViewGroup viewGroup) {
        j.g(hVar, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        return this.f23175a.a(hVar, pVar, context, viewGroup);
    }

    public c<? super h<?>> getType() {
        return this.f23175a.getType();
    }
}
