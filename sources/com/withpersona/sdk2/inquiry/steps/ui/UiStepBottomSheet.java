package com.withpersona.sdk2.inquiry.steps.ui;

import android.content.Context;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.r;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

public final class UiStepBottomSheet implements com.squareup.workflow1.ui.a<UiStepBottomSheet> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final UiScreen f27544a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final List<Pair<String, Function0<Unit>>> f27545b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Function0<Unit> f27546c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f27547d;

    /* renamed from: e  reason: collision with root package name */
    private final r<UiStepBottomSheet> f27548e = new ViewBindingViewFactory(l.b(UiStepBottomSheet.class), UiStepBottomSheet$viewFactory$1.f27559a, new UiStepBottomSheet$special$$inlined$bind$1(this));

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UiStepBottomSheet f27551a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ vi.a f27552b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f27553c;

        a(UiStepBottomSheet uiStepBottomSheet, vi.a aVar, int i10) {
            this.f27551a = uiStepBottomSheet;
            this.f27552b = aVar;
            this.f27553c = i10;
        }

        public void b(View view, float f10) {
            j.g(view, "bottomSheet");
            if (f10 <= 0.0f) {
                this.f27551a.f27546c.invoke();
                this.f27552b.f33899e.setVisibility(8);
                Context context = this.f27552b.getRoot().getContext();
                j.f(context, "root.context");
                ti.a.f(context, this.f27553c);
                return;
            }
            this.f27552b.f33899e.setVisibility(0);
            this.f27552b.f33899e.setAlpha(f10);
            int color = androidx.core.content.a.getColor(this.f27552b.getRoot().getContext(), d.blackScreenStatusBarColor);
            Context context2 = this.f27552b.getRoot().getContext();
            j.f(context2, "root.context");
            ti.a.f(context2, color);
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<?> f27554a;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BottomSheetBehavior<?> f27555a;

            a(BottomSheetBehavior<?> bottomSheetBehavior) {
                this.f27555a = bottomSheetBehavior;
            }

            public final void run() {
                this.f27555a.Q0(3);
            }
        }

        b(BottomSheetBehavior<?> bottomSheetBehavior) {
            this.f27554a = bottomSheetBehavior;
        }

        public void onViewAttachedToWindow(View view) {
            j.g(view, "view");
            view.post(new a(this.f27554a));
        }

        public void onViewDetachedFromWindow(View view) {
            j.g(view, "view");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f27556a;

        c(Function0<Unit> function0) {
            this.f27556a = function0;
        }

        public final void onClick(View view) {
            this.f27556a.invoke();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<?> f27557a;

        d(BottomSheetBehavior<?> bottomSheetBehavior) {
            this.f27557a = bottomSheetBehavior;
        }

        public final void onClick(View view) {
            this.f27557a.Q0(4);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<?> f27558a;

        e(BottomSheetBehavior<?> bottomSheetBehavior) {
            this.f27558a = bottomSheetBehavior;
        }

        public final void onClick(View view) {
            this.f27558a.Q0(4);
        }
    }

    public UiStepBottomSheet(UiScreen uiScreen, List<? extends Pair<String, ? extends Function0<Unit>>> list, Function0<Unit> function0, String str) {
        j.g(uiScreen, "uiScreen");
        j.g(list, "componentNamesToActions");
        j.g(function0, "onCancelled");
        this.f27544a = uiScreen;
        this.f27545b = list;
        this.f27546c = function0;
        this.f27547d = str;
        f.a aVar = f.f23238a;
    }

    public r<UiStepBottomSheet> a() {
        return this.f27548e;
    }
}
