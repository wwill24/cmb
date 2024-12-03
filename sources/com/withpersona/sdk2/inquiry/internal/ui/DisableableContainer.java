package com.withpersona.sdk2.inquiry.internal.ui;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.ViewRegistryKt;
import com.squareup.workflow1.ui.WorkflowViewState;
import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import com.squareup.workflow1.ui.backstack.ViewStateCache;
import com.squareup.workflow1.ui.c;
import com.squareup.workflow1.ui.d;
import com.squareup.workflow1.ui.h;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.s;
import com.squareup.workflow1.ui.t;
import com.squareup.workflow1.ui.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import li.a;
import ni.b;
import r1.d;

public final class DisableableContainer extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f26920c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a f26921a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewStateCache f26922b;

    public static final class Companion implements r<b> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ c<b> f26923a;

        private Companion() {
            this.f26923a = new c<>(l.b(b.class), AnonymousClass1.f26924a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(b bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f26923a.a(bVar, pVar, context, viewGroup);
        }

        public wk.c<? super b> getType() {
            return this.f26923a.getType();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DisableableContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    private final View b(b bVar, p pVar) {
        WorkflowLifecycleOwner c10;
        View view;
        h hVar = new h(bVar.a(), "disableable_container");
        View currentView = getCurrentView();
        if (currentView != null) {
            if (t.b(currentView, hVar)) {
                view = currentView;
            } else {
                view = null;
            }
            if (view != null) {
                this.f26922b.d(p.e(hVar));
                t.g(view, hVar, pVar);
                return view;
            }
        }
        Context context = getContext();
        j.f(context, "this.context");
        View c11 = ViewRegistryKt.c((s) pVar.a(s.f23293a), hVar, pVar, context, this, new ni.a());
        t.h(c11);
        this.f26922b.h(q.j(), currentView, c11);
        this.f26921a.f32752c.removeView(currentView);
        this.f26921a.f32752c.addView(c11);
        if (!(currentView == null || (c10 = WorkflowLifecycleOwner.f23206o.c(currentView)) == null)) {
            c10.P();
        }
        return c11;
    }

    /* access modifiers changed from: private */
    public static final void c(View view, Function0 function0) {
        j.g(view, "view");
        j.g(function0, "doStart");
        WorkflowLifecycleOwner.Companion.e(WorkflowLifecycleOwner.f23206o, view, (Function1) null, 2, (Object) null);
        function0.invoke();
    }

    private final View getCurrentView() {
        if (this.f26921a.f32752c.getChildCount() > 0) {
            return this.f26921a.f32752c.getChildAt(0);
        }
        return null;
    }

    public final void d(b bVar, p pVar) {
        j.g(bVar, "newRendering");
        j.g(pVar, "newViewEnvironment");
        View b10 = b(bVar, pVar);
        setEnabled(bVar.b());
        if (!isEnabled()) {
            b10.setAlpha(0.5f);
            this.f26921a.f32751b.setVisibility(0);
            return;
        }
        b10.setAlpha(1.0f);
        this.f26921a.f32751b.setVisibility(8);
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
        this.f26922b.a(d.a.b(aVar, obj, (String) null, 2, (Object) null), c10);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f26922b.b();
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
            this.f26922b.f(savedState.a());
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
            return new SavedState(onSaveInstanceState, this.f26922b.g());
        }
        return null;
    }

    public static final class SavedState extends View.BaseSavedState {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final ViewStateCache.Saved f26925a;

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
            this.f26925a = saved;
        }

        public final ViewStateCache.Saved a() {
            return this.f26925a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f26925a, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            j.g(parcel, "source");
            Parcelable readParcelable = parcel.readParcelable(ViewStateCache.Saved.class.getClassLoader());
            j.d(readParcelable);
            this.f26925a = (ViewStateCache.Saved) readParcelable;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DisableableContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
        a b10 = a.b(LayoutInflater.from(context), this);
        j.f(b10, "inflate(LayoutInflater.from(context), this)");
        this.f26921a = b10;
        this.f26922b = new ViewStateCache();
    }
}
