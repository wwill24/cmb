package com.withpersona.sdk2.inquiry.shared.ui;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import ci.b;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.ViewRegistryKt;
import com.squareup.workflow1.ui.WorkflowViewState;
import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import com.squareup.workflow1.ui.backstack.BackStackConfig;
import com.squareup.workflow1.ui.backstack.ViewStateCache;
import com.squareup.workflow1.ui.c;
import com.squareup.workflow1.ui.d;
import com.squareup.workflow1.ui.h;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.s;
import com.squareup.workflow1.ui.t;
import com.squareup.workflow1.ui.v;
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
import x1.n;

public class ScreenWithTransitionContainer extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f27516c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ViewStateCache f27517a;

    /* renamed from: b  reason: collision with root package name */
    private h<?> f27518b;

    public static final class Companion implements r<e> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ c<e> f27519a;

        private Companion() {
            this.f27519a = new c<>(l.b(e.class), AnonymousClass1.f27520a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(e eVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(eVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f27519a.a(eVar, pVar, context, viewGroup);
        }

        public wk.c<? super e> getType() {
            return this.f27519a.getType();
        }
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27522a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition[] r0 = com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition r1 = com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition.SLIDE_IN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition r1 = com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition.SLIDE_OUT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition r1 = com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f27522a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.shared.ui.ScreenWithTransitionContainer.a.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenWithTransitionContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
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
    public void b(View view, View view2, ScreenTransition screenTransition) {
        Pair pair;
        j.g(view2, "newView");
        j.g(screenTransition, "transition");
        if (view != null) {
            int i10 = ti.h.back_stack_body;
            View findViewById = view.findViewById(i10);
            View findViewById2 = view2.findViewById(i10);
            if (findViewById == null || findViewById2 == null) {
                findViewById2 = view2;
            } else {
                view = findViewById;
            }
            int i11 = a.f27522a[screenTransition.ordinal()];
            if (i11 == 1) {
                pair = gk.h.a(8388611, 8388613);
            } else if (i11 == 2) {
                pair = gk.h.a(8388613, 8388611);
            } else if (i11 == 3) {
                x1.p.e(new k(this, view2), (n) null);
                return;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            x1.r u02 = new x1.r().n0(new m(((Number) pair.a()).intValue()).b(view)).n0(new m(((Number) pair.b()).intValue()).b(findViewById2)).f0(new AccelerateDecelerateInterpolator());
            j.f(u02, "TransitionSet()\n        …DecelerateInterpolator())");
            x1.p.c(this);
            x1.p.e(new k(this, view2), u02);
            return;
        }
        addView(view2);
    }

    /* access modifiers changed from: protected */
    public final void c(e eVar, p pVar) {
        WorkflowLifecycleOwner c10;
        View view;
        j.g(eVar, "newRendering");
        j.g(pVar, "newViewEnvironment");
        p c11 = pVar.c(gk.h.a(BackStackConfig.f23215a, BackStackConfig.First));
        h<?> hVar = new h<>(eVar.a(), "screen_with_transition");
        View currentView = getCurrentView();
        if (currentView != null) {
            if (t.b(currentView, hVar)) {
                view = currentView;
            } else {
                view = null;
            }
            if (view != null) {
                this.f27517a.d(p.e(hVar));
                t.g(view, hVar, c11);
                return;
            }
        }
        Context context = getContext();
        j.f(context, "this.context");
        View c12 = ViewRegistryKt.c((s) c11.a(s.f23293a), hVar, c11, context, this, new f());
        t.h(c12);
        b(currentView, c12, eVar.b());
        if (!(currentView == null || (c10 = WorkflowLifecycleOwner.f23206o.c(currentView)) == null)) {
            c10.P();
        }
        this.f27518b = hVar;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Object obj;
        super.onAttachedToWindow();
        d c10 = b.f19008a.c(this);
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
        this.f27517a.a(d.a.b(aVar, obj, (String) null, 2, (Object) null), c10);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f27517a.b();
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
            this.f27517a.f(savedState.a());
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
        if (onSaveInstanceState != null) {
            return new SavedState(onSaveInstanceState, this.f27517a.g());
        }
        return null;
    }

    public static final class SavedState extends View.BaseSavedState {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final ViewStateCache.Saved f27521a;

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
            this.f27521a = saved;
        }

        public final ViewStateCache.Saved a() {
            return this.f27521a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f27521a, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            j.g(parcel, "source");
            Parcelable readParcelable = parcel.readParcelable(ViewStateCache.Saved.class.getClassLoader());
            j.d(readParcelable);
            this.f27521a = (ViewStateCache.Saved) readParcelable;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenWithTransitionContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f27517a = new ViewStateCache();
    }
}
