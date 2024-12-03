package com.withpersona.sdk2.inquiry.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.components.d;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import gk.f;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;

public final class InputSelectBottomSheetController {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f29298a;

    /* renamed from: b  reason: collision with root package name */
    private final f<ej.a> f29299b = b.b(new InputSelectBottomSheetController$lazyBinding$1(this));

    /* renamed from: c  reason: collision with root package name */
    private boolean f29300c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Function1<? super Integer, Unit> f29301d;

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputSelectBottomSheetController f29302a;

        a(InputSelectBottomSheetController inputSelectBottomSheetController) {
            this.f29302a = inputSelectBottomSheetController;
        }

        public void b(View view, float f10) {
            j.g(view, "bottomSheet");
            if (f10 <= 0.0f) {
                this.f29302a.g().f29587f.setVisibility(8);
                return;
            }
            this.f29302a.g().f29587f.setVisibility(0);
            this.f29302a.g().f29587f.setAlpha(f10);
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
            Function1 d10 = this.f29302a.f29301d;
            if (d10 != null) {
                d10.invoke(Integer.valueOf(i10));
            }
        }
    }

    public InputSelectBottomSheetController(ViewGroup viewGroup) {
        j.g(viewGroup, "contentView");
        this.f29298a = viewGroup;
    }

    /* access modifiers changed from: private */
    public final ej.a g() {
        return this.f29299b.getValue();
    }

    private final void h() {
        if (!this.f29300c) {
            this.f29300c = true;
            BottomSheetBehavior k02 = BottomSheetBehavior.k0(g().f29584c);
            j.f(k02, "from(binding.listContent)");
            k02.S0(true);
            k02.Y(new a(this));
            g().f29583b.setOnClickListener(new b(k02));
        }
    }

    /* access modifiers changed from: private */
    public static final void i(BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(bottomSheetBehavior, "$behavior");
        bottomSheetBehavior.Q0(4);
    }

    /* access modifiers changed from: private */
    public static final void k(BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(bottomSheetBehavior, "$behavior");
        bottomSheetBehavior.Q0(4);
    }

    public final boolean f() {
        if (!this.f29299b.isInitialized()) {
            return false;
        }
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(g().f29584c);
        j.f(k02, "from(binding.listContent)");
        if (k02.p0() == 4) {
            return false;
        }
        k02.Q0(4);
        return true;
    }

    public final void j(d dVar, Function1<? super List<String>, Unit> function1) {
        Integer num;
        Window window;
        Function1<? super List<String>, Unit> function12 = function1;
        j.g(dVar, "component");
        j.g(function12, "onItemsSelectedListener");
        h();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = function12;
        Context context = g().getRoot().getContext();
        j.f(context, "binding.root.context");
        c a10 = ti.a.a(context);
        if (a10 == null || (window = a10.getWindow()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(window.getStatusBarColor());
        }
        Integer num2 = num;
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(g().f29584c);
        j.f(k02, "from(binding.listContent)");
        Context context2 = g().f29586e.getContext();
        j.f(context2, "binding.recyclerviewInquirySelectList.context");
        e eVar = r12;
        e eVar2 = new e(context2, dVar.p(), dVar.b(), dVar.l(), dVar.t(), new InputSelectBottomSheetController$show$adapter$1(dVar, num2, k02, ref$ObjectRef, this));
        int color = androidx.core.content.a.getColor(g().getRoot().getContext(), g.blackScreenStatusBarColor);
        Context context3 = g().getRoot().getContext();
        j.f(context3, "binding.root.context");
        ti.a.f(context3, color);
        this.f29301d = new InputSelectBottomSheetController$show$1(num2, ref$ObjectRef, eVar, this);
        g().f29588g.setText(dVar.getLabel());
        g().f29586e.setAdapter(eVar);
        g().f29587f.setOnClickListener(new a(k02));
        UiComponent.InputSelectComponentStyle b10 = dVar.b();
        if (b10 != null) {
            TextView textView = g().f29588g;
            j.f(textView, "binding.textviewInputSelectSheetTitle");
            m.e(textView, b10.w());
            String V1 = b10.V1();
            if (V1 != null) {
                g().f29584c.setBackgroundColor(Color.parseColor(V1));
            }
            String d10 = b10.d();
            if (d10 != null) {
                g().f29585d.setBackgroundColor(Color.parseColor(d10));
            }
            String n10 = b10.n();
            if (n10 != null) {
                g().f29583b.setColorFilter(Color.parseColor(n10));
            }
        }
        g().f29586e.setLayoutManager(new LinearLayoutManager(g().getRoot().getContext()));
        g().f29586e.setHasFixedSize(true);
        FrameLayout b11 = g().getRoot();
        j.f(b11, "binding.root");
        k.b(b11, new InputSelectBottomSheetController$show$4(k02));
    }
}
