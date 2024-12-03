package com.squareup.workflow1.ui.modal;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.b;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.modal.AlertScreen;
import com.squareup.workflow1.ui.modal.ModalContainer;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.t;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import pk.o;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB;\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertContainer;", "Lcom/squareup/workflow1/ui/modal/ModalContainer;", "Lcom/squareup/workflow1/ui/modal/AlertScreen;", "Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;", "", "h", "initialModalRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Lcom/squareup/workflow1/ui/modal/ModalContainer$a;", "g", "dialogRef", "", "d", "e", "I", "dialogThemeResId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;III)V", "f", "AlertContainerViewFactory", "a", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public final class AlertContainer extends ModalContainer<AlertScreen> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f23245f = new a((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private final int f23246e;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0001R \u0010\u000f\u001a\u000e\u0012\n\b\u0000\u0012\u0006\u0012\u0002\b\u00030\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertContainer$a;", "Lcom/squareup/workflow1/ui/r;", "Lcom/squareup/workflow1/ui/modal/c;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "b", "Lwk/c;", "getType", "()Lwk/c;", "type", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class a implements r<c<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ AlertContainerViewFactory f23249a;

        private a() {
            this.f23249a = new AlertContainerViewFactory(0, 1, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(c<?> cVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(cVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f23249a.a(cVar, pVar, context, viewGroup);
        }

        public c<? super c<?>> getType() {
            return this.f23249a.getType();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23250a;

        static {
            int[] iArr = new int[AlertScreen.Button.values().length];
            iArr[AlertScreen.Button.POSITIVE.ordinal()] = 1;
            iArr[AlertScreen.Button.NEGATIVE.ordinal()] = 2;
            iArr[AlertScreen.Button.NEUTRAL.ordinal()] = 3;
            f23250a = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlertContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i10, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12);
    }

    private final int h(AlertScreen.Button button) {
        int i10 = b.f23250a[button.ordinal()];
        if (i10 == 1) {
            return -1;
        }
        if (i10 == 2) {
            return -2;
        }
        if (i10 == 3) {
            return -3;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final void i(AlertScreen alertScreen, DialogInterface dialogInterface) {
        j.g(alertScreen, "$rendering");
        alertScreen.d().invoke(AlertScreen.a.b.f23261a);
    }

    /* access modifiers changed from: private */
    public static final void j(AlertScreen alertScreen, AlertScreen.Button button, DialogInterface dialogInterface, int i10) {
        j.g(alertScreen, "$rendering");
        j.g(button, "$button");
        alertScreen.d().invoke(new AlertScreen.a.C0267a(button));
    }

    /* access modifiers changed from: protected */
    public void d(ModalContainer.a<AlertScreen> aVar) {
        Unit unit;
        Button i10;
        j.g(aVar, "dialogRef");
        androidx.appcompat.app.b bVar = (androidx.appcompat.app.b) aVar.d();
        AlertScreen f10 = aVar.f();
        int i11 = 0;
        if (f10.b()) {
            bVar.setOnCancelListener(new a(f10));
            bVar.setCancelable(true);
        } else {
            bVar.setCancelable(false);
        }
        AlertScreen.Button[] values = AlertScreen.Button.values();
        int length = values.length;
        while (i11 < length) {
            AlertScreen.Button button = values[i11];
            i11++;
            String str = f10.a().get(button);
            if (str == null) {
                unit = null;
            } else {
                bVar.l(h(button), str, new b(f10, button));
                unit = Unit.f32013a;
            }
            if (unit == null && (i10 = bVar.i(h(button))) != null) {
                i10.setVisibility(4);
            }
        }
        bVar.m(f10.c());
        bVar.setTitle(f10.e());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public ModalContainer.a<AlertScreen> b(AlertScreen alertScreen, p pVar) {
        j.g(alertScreen, "initialModalRendering");
        j.g(pVar, "initialViewEnvironment");
        androidx.appcompat.app.b a10 = new b.a(getContext(), this.f23246e).a();
        j.f(a10, "Builder(context, dialogThemeResId)\n      .create()");
        ModalContainer.a aVar = new ModalContainer.a(alertScreen, pVar, a10, (Object) null, 8, (DefaultConstructorMarker) null);
        d(aVar);
        return aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f23246e = i12;
    }

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0001R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0013\u001a\u000e\u0012\n\b\u0000\u0012\u0006\u0012\u0002\b\u00030\u00020\u00108\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertContainer$AlertContainerViewFactory;", "Lcom/squareup/workflow1/ui/r;", "Lcom/squareup/workflow1/ui/modal/c;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "b", "", "a", "I", "dialogThemeResId", "Lwk/c;", "getType", "()Lwk/c;", "type", "<init>", "(I)V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    private static final class AlertContainerViewFactory implements r<c<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final int f23247a;

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ com.squareup.workflow1.ui.c<c<?>> f23248b;

        public AlertContainerViewFactory(final int i10) {
            this.f23247a = i10;
            this.f23248b = new com.squareup.workflow1.ui.c<>(l.b(c.class), new o<c<?>, p, Context, ViewGroup, View>() {
                /* renamed from: a */
                public final View g(c<?> cVar, p pVar, Context context, ViewGroup viewGroup) {
                    j.g(cVar, "initialRendering");
                    j.g(pVar, "initialEnv");
                    j.g(context, IdentityHttpResponse.CONTEXT);
                    AlertContainer alertContainer = new AlertContainer(context, (AttributeSet) null, 0, 0, i10, 14, (DefaultConstructorMarker) null);
                    alertContainer.setId(ei.a.workflow_alert_container);
                    alertContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    t.a(alertContainer, cVar, pVar, new AlertContainer$AlertContainerViewFactory$1$1$1(alertContainer));
                    return alertContainer;
                }
            });
        }

        /* renamed from: b */
        public View a(c<?> cVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(cVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f23248b.a(cVar, pVar, context, viewGroup);
        }

        public c<? super c<?>> getType() {
            return this.f23248b.getType();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AlertContainerViewFactory(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 0 : i10);
        }
    }
}
