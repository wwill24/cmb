package com.squareup.workflow1.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import r1.d;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0005\u0012\b\b\u0002\u00105\u001a\u00020\u0005¢\u0006\u0004\b6\u00107J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010R$\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00018\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010/\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00068"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowViewStub;", "Landroid/view/View;", "newView", "", "b", "", "id", "setId", "visibility", "setVisibility", "getVisibility", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "", "rendering", "Lcom/squareup/workflow1/ui/p;", "viewEnvironment", "c", "<set-?>", "a", "Landroid/view/View;", "getActual", "()Landroid/view/View;", "actual", "", "Z", "getUpdatesVisibility", "()Z", "setUpdatesVisibility", "(Z)V", "updatesVisibility", "value", "I", "getInflatedId", "()I", "setInflatedId", "(I)V", "inflatedId", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "d", "Lkotlin/jvm/functions/Function2;", "getReplaceOldViewInParent", "()Lkotlin/jvm/functions/Function2;", "setReplaceOldViewInParent", "(Lkotlin/jvm/functions/Function2;)V", "replaceOldViewInParent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class WorkflowViewStub extends View {

    /* renamed from: a  reason: collision with root package name */
    private View f23196a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23197b;

    /* renamed from: c  reason: collision with root package name */
    private int f23198c;

    /* renamed from: d  reason: collision with root package name */
    private Function2<? super ViewGroup, ? super View, Unit> f23199d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkflowViewStub(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkflowViewStub(Context context, AttributeSet attributeSet, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    private final void b(View view) {
        ViewGroup viewGroup;
        d a10 = ViewTreeSavedStateRegistryOwner.a(this);
        ViewParent parent = getParent();
        d dVar = null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            dVar = ViewTreeSavedStateRegistryOwner.a(viewGroup);
        }
        if (a10 != dVar) {
            ViewTreeSavedStateRegistryOwner.b(view, a10);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(View view, Function0 function0) {
        j.g(view, "view");
        j.g(function0, "doStart");
        WorkflowLifecycleOwner.Companion.e(WorkflowLifecycleOwner.f23206o, view, (Function1) null, 2, (Object) null);
        function0.invoke();
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View c(java.lang.Object r10, com.squareup.workflow1.ui.p r11) {
        /*
            r9 = this;
            java.lang.String r0 = "rendering"
            kotlin.jvm.internal.j.g(r10, r0)
            java.lang.String r0 = "viewEnvironment"
            kotlin.jvm.internal.j.g(r11, r0)
            android.view.View r0 = r9.f23196a
            boolean r1 = com.squareup.workflow1.ui.t.b(r0, r10)
            r2 = 0
            if (r1 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            if (r0 != 0) goto L_0x0091
            android.view.View r0 = r9.f23196a
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0024
            r2 = r0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L_0x0024:
            if (r2 == 0) goto L_0x0089
            android.view.View r0 = r9.f23196a
            if (r0 == r9) goto L_0x0036
            com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner$Companion r1 = com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner.f23206o
            com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner r0 = r1.c(r0)
            if (r0 != 0) goto L_0x0033
            goto L_0x0036
        L_0x0033:
            r0.P()
        L_0x0036:
            com.squareup.workflow1.ui.s$a r0 = com.squareup.workflow1.ui.s.f23293a
            java.lang.Object r0 = r11.a(r0)
            r3 = r0
            com.squareup.workflow1.ui.s r3 = (com.squareup.workflow1.ui.s) r3
            android.content.Context r6 = r2.getContext()
            java.lang.String r0 = "parent.context"
            kotlin.jvm.internal.j.f(r6, r0)
            com.squareup.workflow1.ui.w r8 = new com.squareup.workflow1.ui.w
            r8.<init>()
            r4 = r10
            r5 = r11
            r7 = r2
            android.view.View r10 = com.squareup.workflow1.ui.ViewRegistryKt.c(r3, r4, r5, r6, r7, r8)
            com.squareup.workflow1.ui.t.h(r10)
            int r11 = r9.getInflatedId()
            r0 = -1
            if (r11 == r0) goto L_0x0065
            int r11 = r9.getInflatedId()
            r10.setId(r11)
        L_0x0065:
            boolean r11 = r9.getUpdatesVisibility()
            if (r11 == 0) goto L_0x0072
            int r11 = r9.getVisibility()
            r10.setVisibility(r11)
        L_0x0072:
            android.graphics.drawable.Drawable r11 = r9.getBackground()
            if (r11 != 0) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            r10.setBackground(r11)
        L_0x007c:
            r9.b(r10)
            kotlin.jvm.functions.Function2 r11 = r9.getReplaceOldViewInParent()
            r11.invoke(r2, r10)
            r9.f23196a = r10
            return r10
        L_0x0089:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "WorkflowViewStub must have a non-null ViewGroup parent"
            r10.<init>(r11)
            throw r10
        L_0x0091:
            com.squareup.workflow1.ui.t.g(r0, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.WorkflowViewStub.c(java.lang.Object, com.squareup.workflow1.ui.p):android.view.View");
    }

    public final View getActual() {
        return this.f23196a;
    }

    public final int getInflatedId() {
        return this.f23198c;
    }

    public final Function2<ViewGroup, View, Unit> getReplaceOldViewInParent() {
        return this.f23199d;
    }

    public final boolean getUpdatesVisibility() {
        return this.f23197b;
    }

    public int getVisibility() {
        View view = this.f23196a;
        boolean z10 = true;
        if (!j.b(view, this) && view != null) {
            z10 = false;
        }
        if (z10) {
            return super.getVisibility();
        }
        return this.f23196a.getVisibility();
    }

    public void setBackground(Drawable drawable) {
        View view;
        super.setBackground(drawable);
        if (!j.b(this.f23196a, this) && (view = this.f23196a) != null && drawable != null) {
            view.setBackground(drawable);
        }
    }

    public void setId(int i10) {
        boolean z10;
        if (i10 == -1 || i10 != this.f23198c) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            super.setId(i10);
            return;
        }
        throw new IllegalArgumentException(j.p("id must be distinct from inflatedId: ", getResources().getResourceName(i10)).toString());
    }

    public final void setInflatedId(int i10) {
        boolean z10;
        if (i10 == -1 || i10 != getId()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f23198c = i10;
            return;
        }
        throw new IllegalArgumentException(j.p("inflatedId must be distinct from id: ", getResources().getResourceName(getId())).toString());
    }

    public final void setReplaceOldViewInParent(Function2<? super ViewGroup, ? super View, Unit> function2) {
        j.g(function2, "<set-?>");
        this.f23199d = function2;
    }

    public final void setUpdatesVisibility(boolean z10) {
        this.f23197b = z10;
    }

    public void setVisibility(int i10) {
        View view;
        super.setVisibility(i10);
        if (!j.b(this.f23196a, this) && (view = this.f23196a) != null) {
            view.setVisibility(i10);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkflowViewStub(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f23196a = this;
        this.f23197b = true;
        this.f23198c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.WorkflowViewStub, i10, i11);
        j.f(obtainStyledAttributes, "context.obtainStyledAttr…fStyle, defStyleRes\n    )");
        setInflatedId(obtainStyledAttributes.getResourceId(j.WorkflowViewStub_inflatedId, -1));
        this.f23197b = obtainStyledAttributes.getBoolean(j.WorkflowViewStub_updatesVisibility, true);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        this.f23199d = new WorkflowViewStub$replaceOldViewInParent$1(this);
    }
}
