package com.squareup.workflow1.ui.backstack;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.WorkflowViewState;
import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import com.squareup.workflow1.ui.backstack.ViewStateCache;
import com.squareup.workflow1.ui.c;
import com.squareup.workflow1.ui.d;
import com.squareup.workflow1.ui.h;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.v;
import di.b;
import ei.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import r1.d;
import x1.k;
import x1.m;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00072\u00020\u0001:\u0002'(B1\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J\"\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/BackStackContainer;", "Landroid/widget/FrameLayout;", "Ldi/b;", "newRendering", "Lcom/squareup/workflow1/ui/p;", "newViewEnvironment", "", "c", "Landroid/view/View;", "oldViewMaybe", "newView", "", "popped", "b", "Landroid/os/Parcelable;", "onSaveInstanceState", "state", "onRestoreInstanceState", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache;", "a", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache;", "viewStateCache", "Lcom/squareup/workflow1/ui/h;", "Ldi/b;", "currentRendering", "getCurrentView", "()Landroid/view/View;", "currentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "SavedState", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public class BackStackContainer extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f23221c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ViewStateCache f23222a;

    /* renamed from: b  reason: collision with root package name */
    private b<h<?>> f23223b;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0001R \u0010\u000f\u001a\u000e\u0012\n\b\u0000\u0012\u0006\u0012\u0002\b\u00030\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/BackStackContainer$Companion;", "Lcom/squareup/workflow1/ui/r;", "Ldi/b;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "b", "Lwk/c;", "getType", "()Lwk/c;", "type", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class Companion implements r<b<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ c<b<?>> f23224a;

        private Companion() {
            this.f23224a = new c<>(l.b(b.class), AnonymousClass1.f23225a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(b<?> bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f23224a.a(bVar, pVar, context, viewGroup);
        }

        public wk.c<? super b<?>> getType() {
            return this.f23224a.getType();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BackStackContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackStackContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    public static final void d(View view, Function0 function0) {
        j.g(view, "view");
        j.g(function0, "doStart");
        WorkflowLifecycleOwner.Companion.e(WorkflowLifecycleOwner.f23206o, view, (Function1) null, 2, (Object) null);
        function0.invoke();
    }

    private final View getCurrentView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void b(View view, View view2, boolean z10) {
        Pair pair;
        j.g(view2, "newView");
        if (view == null) {
            addView(view2);
            return;
        }
        int i10 = a.back_stack_body;
        View findViewById = view.findViewById(i10);
        View findViewById2 = view2.findViewById(i10);
        if (findViewById == null || findViewById2 == null) {
            findViewById2 = view2;
        } else {
            view = findViewById;
        }
        if (!z10) {
            pair = gk.h.a(8388611, 8388613);
        } else if (z10) {
            pair = gk.h.a(8388613, 8388611);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        x1.r u02 = new x1.r().n0(new m(((Number) pair.a()).intValue()).b(view)).n0(new m(((Number) pair.b()).intValue()).b(findViewById2)).f0(new AccelerateDecelerateInterpolator());
        j.f(u02, "TransitionSet()\n        …DecelerateInterpolator())");
        x1.p.c(this);
        x1.p.e(new k(this, view2), u02);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009d, code lost:
        if (r1 == true) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(di.b<?> r8, com.squareup.workflow1.ui.p r9) {
        /*
            r7 = this;
            java.lang.String r0 = "newRendering"
            kotlin.jvm.internal.j.g(r8, r0)
            java.lang.String r0 = "newViewEnvironment"
            kotlin.jvm.internal.j.g(r9, r0)
            java.util.List r0 = r8.a()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0017
            com.squareup.workflow1.ui.backstack.BackStackConfig r0 = com.squareup.workflow1.ui.backstack.BackStackConfig.First
            goto L_0x0019
        L_0x0017:
            com.squareup.workflow1.ui.backstack.BackStackConfig r0 = com.squareup.workflow1.ui.backstack.BackStackConfig.Other
        L_0x0019:
            com.squareup.workflow1.ui.backstack.BackStackConfig$a r1 = com.squareup.workflow1.ui.backstack.BackStackConfig.f23215a
            kotlin.Pair r0 = gk.h.a(r1, r0)
            com.squareup.workflow1.ui.p r3 = r9.c(r0)
            com.squareup.workflow1.ui.backstack.BackStackContainer$update$named$1 r9 = com.squareup.workflow1.ui.backstack.BackStackContainer$update$named$1.f23227a
            di.b r8 = r8.d(r9)
            android.view.View r9 = r7.getCurrentView()
            if (r9 != 0) goto L_0x0030
            goto L_0x003f
        L_0x0030:
            java.lang.Object r0 = r8.c()
            boolean r0 = com.squareup.workflow1.ui.t.b(r9, r0)
            if (r0 == 0) goto L_0x003c
            r0 = r9
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 != 0) goto L_0x00b4
        L_0x003f:
            com.squareup.workflow1.ui.s$a r0 = com.squareup.workflow1.ui.s.f23293a
            java.lang.Object r0 = r3.a(r0)
            r1 = r0
            com.squareup.workflow1.ui.s r1 = (com.squareup.workflow1.ui.s) r1
            java.lang.Object r2 = r8.c()
            android.content.Context r4 = r7.getContext()
            java.lang.String r0 = "this.context"
            kotlin.jvm.internal.j.f(r4, r0)
            di.a r6 = new di.a
            r6.<init>()
            r5 = r7
            android.view.View r0 = com.squareup.workflow1.ui.ViewRegistryKt.c(r1, r2, r3, r4, r5, r6)
            com.squareup.workflow1.ui.t.h(r0)
            com.squareup.workflow1.ui.backstack.ViewStateCache r1 = r7.f23222a
            java.util.List r2 = r8.a()
            r1.h(r2, r9, r0)
            di.b<com.squareup.workflow1.ui.h<?>> r1 = r7.f23223b
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0073
        L_0x0071:
            r2 = r3
            goto L_0x009f
        L_0x0073:
            java.util.List r1 = r1.a()
            if (r1 != 0) goto L_0x007a
            goto L_0x0071
        L_0x007a:
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0082
        L_0x0080:
            r1 = r3
            goto L_0x009d
        L_0x0082:
            java.util.Iterator r1 = r1.iterator()
        L_0x0086:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r1.next()
            com.squareup.workflow1.ui.h r4 = (com.squareup.workflow1.ui.h) r4
            java.lang.Object r5 = r8.c()
            boolean r4 = com.squareup.workflow1.ui.e.a(r4, r5)
            if (r4 == 0) goto L_0x0086
            r1 = r2
        L_0x009d:
            if (r1 != r2) goto L_0x0071
        L_0x009f:
            r7.b(r9, r0, r2)
            if (r9 != 0) goto L_0x00a5
            goto L_0x00b1
        L_0x00a5:
            com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner$Companion r0 = com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner.f23206o
            com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner r9 = r0.c(r9)
            if (r9 != 0) goto L_0x00ae
            goto L_0x00b1
        L_0x00ae:
            r9.P()
        L_0x00b1:
            r7.f23223b = r8
            return
        L_0x00b4:
            com.squareup.workflow1.ui.backstack.ViewStateCache r9 = r7.f23222a
            java.util.List r1 = r8.b()
            r9.d(r1)
            java.lang.Object r8 = r8.c()
            com.squareup.workflow1.ui.t.g(r0, r8, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.backstack.BackStackContainer.c(di.b, com.squareup.workflow1.ui.p):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Object obj;
        super.onAttachedToWindow();
        d c10 = ci.b.f19008a.c(this);
        d.a aVar = com.squareup.workflow1.ui.d.f23236a;
        WorkflowViewState<?> d10 = v.d(this);
        if (d10 == null) {
            obj = null;
        } else {
            obj = d10.c();
        }
        if (obj == null) {
            obj = null;
        }
        j.d(obj);
        this.f23222a.a(d.a.b(aVar, obj, (String) null, 2, (Object) null), c10);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f23222a.b();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState;
        j.g(parcelable, "state");
        Unit unit = null;
        if (parcelable instanceof SavedState) {
            savedState = (SavedState) parcelable;
        } else {
            savedState = null;
        }
        if (savedState != null) {
            this.f23222a.f(savedState.a());
            super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
            unit = Unit.f32013a;
        }
        if (unit == null) {
            super.onRestoreInstanceState(super.onSaveInstanceState());
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            return null;
        }
        return new SavedState(onSaveInstanceState, this.f23222a.g());
    }

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/BackStackContainer$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "out", "", "flags", "", "writeToParcel", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "a", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "()Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "savedViewState", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;)V", "source", "(Landroid/os/Parcel;)V", "CREATOR", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class SavedState extends View.BaseSavedState {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final ViewStateCache.Saved f23226a;

        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/BackStackContainer$SavedState$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/backstack/BackStackContainer$SavedState;", "Landroid/os/Parcel;", "source", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/backstack/BackStackContainer$SavedState;", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
        public static final class a implements Parcelable.Creator<SavedState> {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                j.g(parcel, "source");
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable, ViewStateCache.Saved saved) {
            super(parcelable);
            j.g(parcelable, "superState");
            j.g(saved, "savedViewState");
            this.f23226a = saved;
        }

        public final ViewStateCache.Saved a() {
            return this.f23226a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f23226a, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            j.g(parcel, "source");
            Parcelable readParcelable = parcel.readParcelable(ViewStateCache.Saved.class.getClassLoader());
            j.d(readParcelable);
            j.f(readParcelable, "source.readParcelable(Vi…class.java.classLoader)!!");
            this.f23226a = (ViewStateCache.Saved) readParcelable;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackStackContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f23222a = new ViewStateCache();
    }
}
