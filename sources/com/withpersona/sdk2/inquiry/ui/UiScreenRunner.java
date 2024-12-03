package com.withpersona.sdk2.inquiry.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import cj.e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.leanplum.internal.Constants;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.TextControllerControlEditTextKt;
import com.squareup.workflow1.ui.c;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.k;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.steps.ui.UiScreen;
import com.withpersona.sdk2.inquiry.steps.ui.components.d;
import com.withpersona.sdk2.inquiry.steps.ui.m;
import com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.view.ShadowedNestedScrollView;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import com.withpersona.sdk2.inquiry.ui.network.Suggestion;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import ej.b;
import gk.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.o;

@SuppressLint({"ResourceType"})
public final class UiScreenRunner implements f<UiWorkflow.c.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f29310i = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b f29311b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, View> f29312c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final InputSelectBottomSheetController f29313d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final SignatureBottomSheetController f29314e;

    /* renamed from: f  reason: collision with root package name */
    private Function0<Unit> f29315f = UiScreenRunner$onComplete$1.f29324a;

    /* renamed from: g  reason: collision with root package name */
    private Function0<Unit> f29316g = UiScreenRunner$onCancel$1.f29322a;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Function1<? super UiComponent, Unit> f29317h = UiScreenRunner$onClick$1.f29323a;

    public static final class Companion implements r<UiWorkflow.c.a> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ c<UiWorkflow.c.a> f29318a;

        private Companion() {
            this.f29318a = new c<>(l.b(UiWorkflow.c.a.class), AnonymousClass1.f29319a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(UiWorkflow.c.a aVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(aVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f29318a.a(aVar, pVar, context, viewGroup);
        }

        public wk.c<? super UiWorkflow.c.a> getType() {
            return this.f29318a.getType();
        }
    }

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UiScreenRunner f29320a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<NestedScrollView> f29321b;

        a(UiScreenRunner uiScreenRunner, BottomSheetBehavior<NestedScrollView> bottomSheetBehavior) {
            this.f29320a = uiScreenRunner;
            this.f29321b = bottomSheetBehavior;
        }

        public void b(View view, float f10) {
            j.g(view, "bottomSheet");
            this.f29320a.f29311b.f29597j.setPadding(this.f29320a.f29311b.f29597j.getPaddingLeft(), this.f29320a.f29311b.f29597j.getPaddingTop(), this.f29320a.f29311b.f29597j.getPaddingRight(), this.f29321b.o0() + ((int) (f10 * ((float) (this.f29320a.f29311b.f29595g.getHeight() - this.f29321b.o0())))));
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
        }
    }

    public UiScreenRunner(b bVar, UiWorkflow.c.a aVar) {
        j.g(bVar, "binding");
        j.g(aVar, "initialRendering");
        this.f29311b = bVar;
        CoordinatorLayout b10 = bVar.getRoot();
        j.f(b10, "binding.root");
        this.f29313d = new InputSelectBottomSheetController(b10);
        CoordinatorLayout b11 = bVar.getRoot();
        j.f(b11, "binding.root");
        this.f29314e = new SignatureBottomSheetController(b11);
        Context context = bVar.getRoot().getContext();
        m mVar = m.f27597a;
        j.f(context, IdentityHttpResponse.CONTEXT);
        com.withpersona.sdk2.inquiry.steps.ui.j g10 = mVar.g(context, new UiScreen(aVar.f(), aVar.p()), aVar.q());
        String c10 = aVar.c();
        if (c10 != null) {
            bVar.f29598k.setBackgroundColor(Color.parseColor(c10));
            ti.a.f(context, Color.parseColor(c10));
        }
        Drawable a10 = aVar.a(context);
        if (a10 != null) {
            bVar.f29598k.setBackground(a10);
            bVar.f29591c.setBackgroundColor(0);
        }
        String h10 = aVar.h();
        if (h10 != null) {
            bVar.f29596h.setControlsColor(Color.parseColor(h10));
        }
        Set<Map.Entry<String, com.withpersona.sdk2.inquiry.steps.ui.a>> entrySet = g10.c().a().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair a11 = h.a(entry.getKey(), ((com.withpersona.sdk2.inquiry.steps.ui.a) entry.getValue()).d());
            linkedHashMap.put(a11.c(), a11.d());
        }
        this.f29312c = linkedHashMap;
        this.f29311b.f29599l.addView(g10.a());
        if (aVar.o() == StyleElements.PositionType.CENTER) {
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.f(this.f29311b.f29590b);
            cVar.h(this.f29311b.f29599l.getId(), 4, this.f29311b.f29590b.getId(), 4);
            cVar.c(this.f29311b.f29590b);
        }
        if (g10.b() != null) {
            v(g10, aVar.f());
        }
    }

    private final void A(com.withpersona.sdk2.inquiry.steps.ui.j jVar, int i10, UiComponent.Footer footer) {
        Drawable drawable;
        ColorDrawable colorDrawable;
        int i11;
        LayerDrawable layerDrawable;
        Drawable drawable2;
        GradientDrawable gradientDrawable;
        UiComponent uiComponent;
        this.f29311b.f29593e.setVisibility(0);
        View b10 = jVar.b();
        String str = null;
        if (b10 != null) {
            drawable = b10.getBackground();
        } else {
            drawable = null;
        }
        if (drawable instanceof ColorDrawable) {
            colorDrawable = (ColorDrawable) drawable;
        } else {
            colorDrawable = null;
        }
        if (colorDrawable != null) {
            i11 = colorDrawable.getColor();
        } else {
            i11 = 0;
        }
        Drawable background = this.f29311b.f29595g.getBackground();
        if (background instanceof LayerDrawable) {
            layerDrawable = (LayerDrawable) background;
        } else {
            layerDrawable = null;
        }
        if (layerDrawable != null) {
            drawable2 = layerDrawable.findDrawableByLayerId(h.footer_sheet_rectangle);
        } else {
            drawable2 = null;
        }
        if (drawable2 instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) drawable2;
        } else {
            gradientDrawable = null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(i11);
        }
        this.f29311b.f29592d.addView(jVar.b());
        List<UiComponent> children = footer.getChildren();
        if (!(children == null || (uiComponent = (UiComponent) CollectionsKt___CollectionsKt.Q(children, i10)) == null)) {
            str = uiComponent.A();
        }
        View view = this.f29312c.get(str);
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(this.f29311b.f29595g);
        j.f(k02, "from(binding.footerSheetScrollView)");
        this.f29311b.f29597j.setVerticalFadingEdgeEnabled(false);
        if (view != null) {
            this.f29311b.f29594f.setVisibility(0);
            this.f29311b.f29592d.addOnLayoutChangeListener(new b0(this, view, k02));
        } else {
            this.f29311b.f29594f.setVisibility(4);
            this.f29311b.f29592d.addOnLayoutChangeListener(new r(this, k02));
        }
        k02.Y(new a(this, k02));
    }

    /* access modifiers changed from: private */
    public static final void B(UiScreenRunner uiScreenRunner, View view, BottomSheetBehavior bottomSheetBehavior, View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        j.g(uiScreenRunner, "this$0");
        j.g(bottomSheetBehavior, "$behavior");
        int bottom = uiScreenRunner.f29311b.f29592d.getBottom();
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        uiScreenRunner.f29311b.f29595g.offsetDescendantRectToMyCoords(view, rect);
        int o02 = bottomSheetBehavior.o0();
        bottomSheetBehavior.L0(rect.top);
        if (o02 != bottomSheetBehavior.o0()) {
            ShadowedNestedScrollView shadowedNestedScrollView = uiScreenRunner.f29311b.f29597j;
            shadowedNestedScrollView.setPadding(shadowedNestedScrollView.getPaddingLeft(), uiScreenRunner.f29311b.f29597j.getPaddingTop(), uiScreenRunner.f29311b.f29597j.getPaddingRight(), bottomSheetBehavior.o0());
        }
        bottomSheetBehavior.J0(bottom);
    }

    /* access modifiers changed from: private */
    public static final void C(UiScreenRunner uiScreenRunner, BottomSheetBehavior bottomSheetBehavior, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        j.g(uiScreenRunner, "this$0");
        j.g(bottomSheetBehavior, "$behavior");
        int bottom = uiScreenRunner.f29311b.f29592d.getBottom();
        bottomSheetBehavior.L0(bottom);
        bottomSheetBehavior.J0(bottom);
        ShadowedNestedScrollView shadowedNestedScrollView = uiScreenRunner.f29311b.f29597j;
        shadowedNestedScrollView.setPadding(shadowedNestedScrollView.getPaddingLeft(), uiScreenRunner.f29311b.f29597j.getPaddingTop(), uiScreenRunner.f29311b.f29597j.getPaddingRight(), bottom);
    }

    private final ComponentParam.ComponentNumber E(Number number) {
        return new ComponentParam.ComponentNumber(number);
    }

    private final ComponentParam.ComponentString F(String str) {
        return new ComponentParam.ComponentString(str);
    }

    private final ComponentParam.ComponentStringList G(List<String> list) {
        return new ComponentParam.ComponentStringList(list);
    }

    private final void H(UiWorkflow.c.a aVar, UiComponent uiComponent, View view, Map<String, ? extends Object> map, Map<String, ? extends UiTransitionErrorResponse.UiComponentError> map2) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        List<UiComponent> a10;
        List<UiComponent> c10;
        List<Suggestion> list;
        aj.c cVar;
        aj.c cVar2;
        UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError uiInputAddressComponentError;
        Map<String, String> c11;
        Map<String, String> c12;
        Map<String, String> c13;
        Map<String, String> c14;
        Map<String, String> c15;
        String u10;
        String z20;
        String t10;
        String x10;
        String w10;
        List<UiComponent> e10;
        UiWorkflow.c.a aVar2 = aVar;
        UiComponent uiComponent2 = uiComponent;
        View view2 = view;
        Map<String, ? extends Object> map3 = map;
        Map<String, ? extends UiTransitionErrorResponse.UiComponentError> map4 = map2;
        if (uiComponent2 instanceof UiComponent.CompleteButton) {
            j.e(view2, "null cannot be cast to non-null type android.widget.Button");
            ((Button) view2).setOnClickListener(new q(this, view, map, uiComponent, aVar));
        } else if (uiComponent2 instanceof UiComponent.SubmitButton) {
            j.e(view2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.view.ButtonWithLoadingIndicator");
            cj.b bVar = (cj.b) view2;
            bVar.setOnClickListener(new t(this, uiComponent2));
            bVar.setIsLoading(aVar.q());
            s(view2, map3, uiComponent2, aVar.q());
        } else if (uiComponent2 instanceof UiComponent.ActionButton) {
            j.e(view2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.view.ButtonWithLoadingIndicator");
            cj.b bVar2 = (cj.b) view2;
            bVar2.setOnClickListener(new u(this, uiComponent2));
            bVar2.setIsLoading(aVar.q());
            s(view2, map3, uiComponent2, aVar.q());
        } else if (uiComponent2 instanceof UiComponent.ClickableStack) {
            UiComponent.ClickableStack clickableStack = (UiComponent.ClickableStack) uiComponent2;
            UiComponent.ClickableStack.Attributes B = clickableStack.z();
            if (!(B == null || (e10 = B.e()) == null)) {
                for (UiComponent uiComponent3 : e10) {
                    View view3 = this.f29312c.get(uiComponent3.A());
                    if (view3 != null) {
                        H(aVar, uiComponent3, view3, map, map2);
                    }
                }
                Unit unit = Unit.f32013a;
            }
            if (view2 instanceof ConstraintLayout) {
                y(aVar2, clickableStack, (ConstraintLayout) view2);
            }
            s(view2, map3, uiComponent2, aVar.q());
        } else if (uiComponent2 instanceof UiComponent.CancelButton) {
            j.e(view2, "null cannot be cast to non-null type android.widget.Button");
            ((Button) view2).setOnClickListener(new v(aVar, this, view, map, uiComponent));
        } else if (uiComponent2 instanceof UiComponent.InputText) {
            j.e(view2, "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
            TextInputLayout textInputLayout = (TextInputLayout) view2;
            k a11 = ((UiComponent.InputText) uiComponent2).a();
            EditText editText = textInputLayout.getEditText();
            j.d(editText);
            TextControllerControlEditTextKt.b(a11, editText);
            Object obj = map4.get(uiComponent.A());
            UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError = obj instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj : null;
            String c16 = uiInputComponentError != null ? uiInputComponentError.c() : null;
            UiComponent.InputTextBasedComponentStyle F = ((UiComponent.InputText) uiComponent2).F();
            e.d(textInputLayout, c16, F != null ? F.w() : null);
            s(view2, map3, uiComponent2, aVar.q());
        } else if (uiComponent2 instanceof UiComponent.InputConfirmationCode) {
            ((UiComponent.InputConfirmationCode) uiComponent2).G().b(new UiScreenRunner$updateRendering$6(view2, aVar2, this));
            s(view2, map3, uiComponent2, aVar.q());
        } else {
            boolean z21 = true;
            if (uiComponent2 instanceof UiComponent.InputAddress) {
                Object tag = view.getTag();
                j.e(tag, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiAddressFieldBinding");
                aj.c cVar3 = (aj.c) tag;
                List<TextInputLayout> m10 = q.m(cVar3.f24837c, cVar3.f24842h, cVar3.f24836b, cVar3.f24841g, cVar3.f24840f);
                UiComponent.InputAddress inputAddress = (UiComponent.InputAddress) uiComponent2;
                UiComponent.InputAddress.Attributes F2 = inputAddress.z();
                if (!(F2 == null || (w10 = F2.w()) == null)) {
                    inputAddress.n().d(w10);
                    Unit unit2 = Unit.f32013a;
                }
                UiComponent.InputAddress.Attributes F3 = inputAddress.z();
                if (!(F3 == null || (x10 = F3.x()) == null)) {
                    inputAddress.r().d(x10);
                    Unit unit3 = Unit.f32013a;
                }
                UiComponent.InputAddress.Attributes F4 = inputAddress.z();
                if (!(F4 == null || (t10 = F4.t()) == null)) {
                    inputAddress.d().d(t10);
                    Unit unit4 = Unit.f32013a;
                }
                UiComponent.InputAddress.Attributes F5 = inputAddress.z();
                if (!(F5 == null || (z20 = F5.z()) == null)) {
                    inputAddress.f().d(z20);
                    Unit unit5 = Unit.f32013a;
                }
                UiComponent.InputAddress.Attributes F6 = inputAddress.z();
                if (!(F6 == null || (u10 = F6.u()) == null)) {
                    inputAddress.e().d(u10);
                    Unit unit6 = Unit.f32013a;
                }
                UiComponent.InputAddress.Attributes F7 = inputAddress.z();
                if (F7 == null || (list = F7.B()) == null) {
                    list = q.j();
                }
                List<Suggestion> list2 = list;
                Context context = view.getContext();
                j.f(context, "view.context");
                ArrayList arrayList = new ArrayList(r.t(list2, 10));
                for (Suggestion suggestion : list2) {
                    arrayList.add(suggestion.toString());
                }
                List x02 = CollectionsKt___CollectionsKt.x0(arrayList);
                UiComponent.InputTextBasedComponentStyle G = inputAddress.G();
                xi.a aVar3 = new xi.a(context, 17367043, x02, G != null ? G.B() : null);
                EditText editText2 = cVar3.f24837c.getEditText();
                MaterialAutoCompleteTextView materialAutoCompleteTextView = editText2 instanceof MaterialAutoCompleteTextView ? (MaterialAutoCompleteTextView) editText2 : null;
                if (materialAutoCompleteTextView != null) {
                    materialAutoCompleteTextView.setAdapter(aVar3);
                    materialAutoCompleteTextView.setThreshold(1);
                    cVar = cVar3;
                    materialAutoCompleteTextView.setOnItemClickListener(new w(m10, view, aVar, uiComponent, list2));
                    Unit unit7 = Unit.f32013a;
                } else {
                    cVar = cVar3;
                }
                UiComponent.InputAddress.Attributes F8 = inputAddress.z();
                if (F8 != null ? j.b(F8.F(), Boolean.FALSE) : false) {
                    for (TextInputLayout enabled : m10) {
                        enabled.setEnabled(true);
                    }
                    view2.findViewById(h.progress_indicator).setVisibility(8);
                }
                u(view2, map3, uiComponent2);
                for (TextInputLayout textInputLayout2 : m10) {
                    j.f(textInputLayout2, "it");
                    t(textInputLayout2, map3, uiComponent2, aVar.q());
                }
                Object obj2 = map4.get(uiComponent.A());
                if (obj2 instanceof UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError) {
                    uiInputAddressComponentError = (UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError) obj2;
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                    uiInputAddressComponentError = null;
                }
                TextInputLayout textInputLayout3 = cVar2.f24837c;
                j.f(textInputLayout3, "addressField");
                String str2 = (uiInputAddressComponentError == null || (c15 = uiInputAddressComponentError.c()) == null) ? null : c15.get("street_1");
                UiComponent.InputAddress inputAddress2 = (UiComponent.InputAddress) uiComponent2;
                UiComponent.InputTextBasedComponentStyle G2 = inputAddress2.G();
                e.d(textInputLayout3, str2, G2 != null ? G2.w() : null);
                TextInputLayout textInputLayout4 = cVar2.f24842h;
                j.f(textInputLayout4, "addressSuite");
                String str3 = (uiInputAddressComponentError == null || (c14 = uiInputAddressComponentError.c()) == null) ? null : c14.get("street_2");
                UiComponent.InputTextBasedComponentStyle G3 = inputAddress2.G();
                e.d(textInputLayout4, str3, G3 != null ? G3.w() : null);
                TextInputLayout textInputLayout5 = cVar2.f24836b;
                j.f(textInputLayout5, "addressCity");
                String str4 = (uiInputAddressComponentError == null || (c13 = uiInputAddressComponentError.c()) == null) ? null : c13.get(Constants.Keys.CITY);
                UiComponent.InputTextBasedComponentStyle G4 = inputAddress2.G();
                e.d(textInputLayout5, str4, G4 != null ? G4.w() : null);
                TextInputLayout textInputLayout6 = cVar2.f24841g;
                j.f(textInputLayout6, "addressSubdivision");
                String str5 = (uiInputAddressComponentError == null || (c12 = uiInputAddressComponentError.c()) == null) ? null : c12.get("subdivision");
                UiComponent.InputTextBasedComponentStyle G5 = inputAddress2.G();
                e.d(textInputLayout6, str5, G5 != null ? G5.w() : null);
                TextInputLayout textInputLayout7 = cVar2.f24840f;
                j.f(textInputLayout7, "addressPostalCode");
                String str6 = (uiInputAddressComponentError == null || (c11 = uiInputAddressComponentError.c()) == null) ? null : c11.get("postal_code");
                UiComponent.InputTextBasedComponentStyle G6 = inputAddress2.G();
                e.d(textInputLayout7, str6, G6 != null ? G6.w() : null);
                Unit unit8 = Unit.f32013a;
                return;
            }
            if (uiComponent2 instanceof UiComponent.InputSelect) {
                z10 = true;
            } else {
                z10 = uiComponent2 instanceof UiComponent.InputMultiSelect;
            }
            if (z10) {
                j.e(view2, "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
                TextInputLayout textInputLayout8 = (TextInputLayout) view2;
                j.e(uiComponent2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.components.InputSelectBoxComponent");
                d dVar = (d) uiComponent2;
                textInputLayout8.setOnClickListener(new x(this, textInputLayout8, uiComponent2));
                EditText editText3 = textInputLayout8.getEditText();
                if (editText3 != null) {
                    editText3.setOnClickListener(new y(this, textInputLayout8, uiComponent2));
                    Unit unit9 = Unit.f32013a;
                }
                Object obj3 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError2 = obj3 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj3 : null;
                String c17 = uiInputComponentError2 != null ? uiInputComponentError2.c() : null;
                UiComponent.InputSelectComponentStyle b10 = ((d) uiComponent2).b();
                e.d(textInputLayout8, c17, b10 != null ? b10.j() : null);
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.InputRadioGroup) {
                Object obj4 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError3 = obj4 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj4 : null;
                String c18 = uiInputComponentError3 != null ? uiInputComponentError3.c() : null;
                TextView textView = (TextView) view2.findViewById(h.radio_group_error);
                if (c18 != null && !r.w(c18)) {
                    z21 = false;
                }
                if (z21) {
                    textView.setVisibility(8);
                    textView.setText("");
                } else {
                    textView.setVisibility(0);
                    textView.setText(c18);
                }
                s(view2, map3, uiComponent2, aVar.q());
                View findViewById = view2.findViewById(h.radio_group);
                j.f(findViewById, "view.findViewById<RadioGroup>(R.id.radio_group)");
                for (View t11 : ViewGroupKt.a((ViewGroup) findViewById)) {
                    t(t11, map3, uiComponent2, aVar.q());
                }
            } else if (uiComponent2 instanceof UiComponent.HorizontalStack) {
                UiComponent.HorizontalStack.Attributes E = ((UiComponent.HorizontalStack) uiComponent2).z();
                if (!(E == null || (c10 = E.c()) == null)) {
                    for (UiComponent uiComponent4 : c10) {
                        View view4 = this.f29312c.get(uiComponent4.A());
                        if (view4 != null) {
                            H(aVar, uiComponent4, view4, map, map2);
                        }
                    }
                    Unit unit10 = Unit.f32013a;
                }
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.Footer) {
                UiComponent.Footer.Attributes B2 = ((UiComponent.Footer) uiComponent2).z();
                if (!(B2 == null || (a10 = B2.a()) == null)) {
                    for (UiComponent uiComponent5 : a10) {
                        View view5 = this.f29312c.get(uiComponent5.A());
                        if (view5 != null) {
                            H(aVar, uiComponent5, view5, map, map2);
                        }
                    }
                    Unit unit11 = Unit.f32013a;
                }
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.Button) {
                view2.setOnClickListener(new z(this, uiComponent2));
                cj.b bVar3 = view2 instanceof cj.b ? (cj.b) view2 : null;
                if (bVar3 != null) {
                    bVar3.setIsLoading(aVar.q());
                }
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.InputDate) {
                Object tag2 = view.getTag();
                j.e(tag2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiDateFieldBinding");
                aj.e eVar = (aj.e) tag2;
                Object obj5 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError4 = obj5 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj5 : null;
                if (uiInputComponentError4 != null) {
                    eVar.f24850d.setText(uiInputComponentError4.c());
                    eVar.f24850d.setVisibility(0);
                } else {
                    eVar.f24850d.setText("");
                    eVar.f24850d.setVisibility(8);
                }
                u(view2, map3, uiComponent2);
                TextInputLayout textInputLayout9 = eVar.f24851e;
                j.f(textInputLayout9, "month");
                t(textInputLayout9, map3, uiComponent2, aVar.q());
                TextInputLayout textInputLayout10 = eVar.f24849c;
                j.f(textInputLayout10, "day");
                t(textInputLayout10, map3, uiComponent2, aVar.q());
                TextInputLayout textInputLayout11 = eVar.f24852f;
                j.f(textInputLayout11, "year");
                t(textInputLayout11, map3, uiComponent2, aVar.q());
                Unit unit12 = Unit.f32013a;
            } else if (uiComponent2 instanceof UiComponent.InputMaskedText) {
                Object obj6 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError5 = obj6 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj6 : null;
                j.e(view2, "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
                TextInputLayout textInputLayout12 = (TextInputLayout) view2;
                String c19 = uiInputComponentError5 != null ? uiInputComponentError5.c() : null;
                UiComponent.InputTextBasedComponentStyle F9 = ((UiComponent.InputMaskedText) uiComponent2).F();
                e.d(textInputLayout12, c19, F9 != null ? F9.w() : null);
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.InputPhoneNumber) {
                Object obj7 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError6 = obj7 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj7 : null;
                j.e(view2, "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
                TextInputLayout textInputLayout13 = (TextInputLayout) view2;
                String c20 = uiInputComponentError6 != null ? uiInputComponentError6.c() : null;
                UiComponent.InputTextBasedComponentStyle F10 = ((UiComponent.InputPhoneNumber) uiComponent2).F();
                e.d(textInputLayout13, c20, F10 != null ? F10.w() : null);
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.InputNumber) {
                Object obj8 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError7 = obj8 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj8 : null;
                j.e(view2, "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
                TextInputLayout textInputLayout14 = (TextInputLayout) view2;
                String c21 = uiInputComponentError7 != null ? uiInputComponentError7.c() : null;
                UiComponent.InputTextBasedComponentStyle F11 = ((UiComponent.InputNumber) uiComponent2).F();
                e.d(textInputLayout14, c21, F11 != null ? F11.w() : null);
                s(view2, map3, uiComponent2, aVar.q());
            } else if (uiComponent2 instanceof UiComponent.ESignature) {
                Object tag3 = view.getTag();
                j.e(tag3, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                aj.r rVar = (aj.r) tag3;
                Object obj9 = map4.get(uiComponent.A());
                UiTransitionErrorResponse.UiComponentError.UiInputComponentError uiInputComponentError8 = obj9 instanceof UiTransitionErrorResponse.UiComponentError.UiInputComponentError ? (UiTransitionErrorResponse.UiComponentError.UiInputComponentError) obj9 : null;
                if (uiInputComponentError8 != null) {
                    rVar.f24885d.setText(uiInputComponentError8.c());
                    rVar.f24885d.setVisibility(0);
                } else {
                    rVar.f24885d.setText("");
                    rVar.f24885d.setVisibility(8);
                }
                UiComponent.ESignature eSignature = (UiComponent.ESignature) uiComponent2;
                Bitmap b11 = eSignature.h().b();
                if (b11 == null) {
                    Object tag4 = view.getTag();
                    j.e(tag4, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag4).f24883b.setVisibility(0);
                    Object tag5 = view.getTag();
                    j.e(tag5, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    TextView textView2 = ((aj.r) tag5).f24883b;
                    UiComponent.ESignature.Attributes E2 = eSignature.z();
                    if (E2 == null || (str = E2.e()) == null) {
                        str = "+ Add signature";
                    }
                    textView2.setText(str);
                    Object tag6 = view.getTag();
                    j.e(tag6, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag6).f24887f.setVisibility(8);
                    Object tag7 = view.getTag();
                    j.e(tag7, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag7).f24884c.setVisibility(8);
                } else {
                    Object tag8 = view.getTag();
                    j.e(tag8, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag8).f24887f.setImageBitmap(b11);
                    Object tag9 = view.getTag();
                    j.e(tag9, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag9).f24883b.setVisibility(8);
                    Object tag10 = view.getTag();
                    j.e(tag10, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag10).f24887f.setVisibility(0);
                    Object tag11 = view.getTag();
                    j.e(tag11, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.databinding.Pi2UiSignatureFieldBinding");
                    ((aj.r) tag11).f24884c.setVisibility(0);
                }
                rVar.f24886e.setOnClickListener(new a0(this, uiComponent2, aVar2));
                u(view2, map3, uiComponent2);
                MaterialCardView materialCardView = rVar.f24886e;
                j.f(materialCardView, "signatureContainer");
                t(materialCardView, map3, uiComponent2, aVar.q());
                Unit unit13 = Unit.f32013a;
            } else {
                if (uiComponent2 instanceof UiComponent.RemoteImage) {
                    z11 = true;
                } else {
                    z11 = uiComponent2 instanceof UiComponent.Text;
                }
                if (z11) {
                    z12 = true;
                } else {
                    z12 = uiComponent2 instanceof UiComponent.Title;
                }
                if (z12) {
                    z13 = true;
                } else {
                    z13 = uiComponent2 instanceof UiComponent.InputCheckbox;
                }
                if (z13) {
                    z14 = true;
                } else {
                    z14 = uiComponent2 instanceof UiComponent.Branding;
                }
                if (z14) {
                    z15 = true;
                } else {
                    z15 = uiComponent2 instanceof UiComponent.LocalImage;
                }
                if (z15) {
                    z16 = true;
                } else {
                    z16 = uiComponent2 instanceof UiComponent.PrivacyPolicy;
                }
                if (z16) {
                    z17 = true;
                } else {
                    z17 = uiComponent2 instanceof UiComponent.Spacer;
                }
                if (z17) {
                    z18 = true;
                } else {
                    z18 = uiComponent2 instanceof UiComponent.QRCode;
                }
                if (z18) {
                    z19 = true;
                } else {
                    z19 = uiComponent2 instanceof UiComponent.CombinedStepImagePreview;
                }
                if (!z19) {
                    z21 = j.b(uiComponent2, UiComponent.Unknown.f28004c);
                }
                if (z21) {
                    s(view2, map3, uiComponent2, aVar.q());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void I(UiScreenRunner uiScreenRunner, UiComponent uiComponent, View view) {
        j.g(uiScreenRunner, "this$0");
        j.g(uiComponent, "$component");
        uiScreenRunner.f29317h.invoke(uiComponent);
    }

    /* access modifiers changed from: private */
    public static final void J(UiScreenRunner uiScreenRunner, UiComponent uiComponent, View view) {
        j.g(uiScreenRunner, "this$0");
        j.g(uiComponent, "$component");
        uiScreenRunner.f29317h.invoke(uiComponent);
    }

    /* access modifiers changed from: private */
    public static final void K(UiWorkflow.c.a aVar, UiScreenRunner uiScreenRunner, View view, Map map, UiComponent uiComponent, View view2) {
        j.g(aVar, "$rendering");
        j.g(uiScreenRunner, "this$0");
        j.g(view, "$view");
        j.g(map, "$componentParams");
        j.g(uiComponent, "$component");
        aVar.j().invoke();
        uiScreenRunner.s(view, map, uiComponent, aVar.q());
    }

    /* access modifiers changed from: private */
    public static final void L(List list, View view, UiWorkflow.c.a aVar, UiComponent uiComponent, List list2, AdapterView adapterView, View view2, int i10, long j10) {
        j.g(list, "$allInputLayouts");
        j.g(view, "$view");
        j.g(aVar, "$rendering");
        j.g(uiComponent, "$component");
        j.g(list2, "$data");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((TextInputLayout) it.next()).setEnabled(false);
        }
        view.findViewById(h.progress_indicator).setVisibility(0);
        aVar.n().invoke(uiComponent, ((Suggestion) list2.get(i10)).c());
    }

    /* access modifiers changed from: private */
    public static final void M(UiScreenRunner uiScreenRunner, TextInputLayout textInputLayout, UiComponent uiComponent, View view) {
        j.g(uiScreenRunner, "this$0");
        j.g(textInputLayout, "$textInputLayout");
        j.g(uiComponent, "$component");
        R(uiScreenRunner, textInputLayout, uiComponent);
    }

    /* access modifiers changed from: private */
    public static final void N(UiScreenRunner uiScreenRunner, TextInputLayout textInputLayout, UiComponent uiComponent, View view) {
        j.g(uiScreenRunner, "this$0");
        j.g(textInputLayout, "$textInputLayout");
        j.g(uiComponent, "$component");
        R(uiScreenRunner, textInputLayout, uiComponent);
    }

    /* access modifiers changed from: private */
    public static final void O(UiScreenRunner uiScreenRunner, UiComponent uiComponent, View view) {
        j.g(uiScreenRunner, "this$0");
        j.g(uiComponent, "$component");
        uiScreenRunner.f29317h.invoke(uiComponent);
    }

    /* access modifiers changed from: private */
    public static final void P(UiScreenRunner uiScreenRunner, UiComponent uiComponent, UiWorkflow.c.a aVar, View view) {
        j.g(uiScreenRunner, "this$0");
        j.g(uiComponent, "$component");
        j.g(aVar, "$rendering");
        uiScreenRunner.f29311b.f29596h.getBackButton().setEnabled(false);
        uiScreenRunner.f29311b.f29596h.setImportantForAccessibility(4);
        uiScreenRunner.f29311b.f29599l.setImportantForAccessibility(4);
        uiScreenRunner.f29314e.r((UiComponent.ESignature) uiComponent, aVar.p(), new UiScreenRunner$updateRendering$16$1$1(uiScreenRunner, uiComponent));
    }

    /* access modifiers changed from: private */
    public static final void Q(UiScreenRunner uiScreenRunner, View view, Map map, UiComponent uiComponent, UiWorkflow.c.a aVar, View view2) {
        j.g(uiScreenRunner, "this$0");
        j.g(view, "$view");
        j.g(map, "$componentParams");
        j.g(uiComponent, "$component");
        j.g(aVar, "$rendering");
        uiScreenRunner.f29315f.invoke();
        uiScreenRunner.s(view, map, uiComponent, aVar.q());
    }

    private static final void R(UiScreenRunner uiScreenRunner, TextInputLayout textInputLayout, UiComponent uiComponent) {
        uiScreenRunner.f29311b.f29596h.getBackButton().setEnabled(false);
        textInputLayout.setEnabled(false);
        uiScreenRunner.f29311b.f29596h.setImportantForAccessibility(4);
        uiScreenRunner.f29311b.f29599l.setImportantForAccessibility(4);
        uiScreenRunner.f29313d.j((d) uiComponent, new UiScreenRunner$updateRendering$showInputSelectBottomSheet$1(uiScreenRunner, textInputLayout, uiComponent));
    }

    private final void s(View view, Map<String, ? extends Object> map, UiComponent uiComponent, boolean z10) {
        u(view, map, uiComponent);
        t(view, map, uiComponent, z10);
    }

    private final void t(View view, Map<String, ? extends Object> map, UiComponent uiComponent, boolean z10) {
        com.withpersona.sdk2.inquiry.steps.ui.network.a aVar;
        boolean z11;
        Boolean d10;
        UiComponentAttributes z12 = uiComponent.z();
        JsonLogicBoolean jsonLogicBoolean = null;
        if (z12 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.a) {
            aVar = (com.withpersona.sdk2.inquiry.steps.ui.network.a) z12;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            jsonLogicBoolean = aVar.d();
        }
        boolean z13 = false;
        if (jsonLogicBoolean == null || (d10 = jsonLogicBoolean.d(map, map.get(uiComponent.A()))) == null) {
            z11 = false;
        } else {
            z11 = d10.booleanValue();
        }
        if (!z10 && !z11) {
            z13 = true;
        }
        view.setEnabled(z13);
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void u(android.view.View r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r7) {
        /*
            r4 = this;
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes r0 = r7.z()
            boolean r1 = r0 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.c
            r2 = 0
            if (r1 == 0) goto L_0x000c
            com.withpersona.sdk2.inquiry.steps.ui.network.c r0 = (com.withpersona.sdk2.inquiry.steps.ui.network.c) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x0014
            com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean r0 = r0.c()
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            r1 = 0
            if (r0 == 0) goto L_0x002b
            java.lang.String r3 = r7.A()
            java.lang.Object r3 = r6.get(r3)
            java.lang.Boolean r0 = r0.d(r6, r3)
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.booleanValue()
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0030
            r1 = 8
        L_0x0030:
            r5.setVisibility(r1)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes r5 = r7.z()
            boolean r7 = r5 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.c
            if (r7 == 0) goto L_0x003e
            r2 = r5
            com.withpersona.sdk2.inquiry.steps.ui.network.c r2 = (com.withpersona.sdk2.inquiry.steps.ui.network.c) r2
        L_0x003e:
            if (r2 == 0) goto L_0x005a
            java.util.List r5 = r2.a()
            if (r5 == 0) goto L_0x005a
            java.util.Iterator r5 = r5.iterator()
        L_0x004a:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x005a
            java.lang.Object r7 = r5.next()
            cj.a r7 = (cj.a) r7
            r7.a(r6, r0)
            goto L_0x004a
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.ui.UiScreenRunner.u(android.view.View, java.util.Map, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent):void");
    }

    private final void v(com.withpersona.sdk2.inquiry.steps.ui.j jVar, List<? extends UiComponent> list) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (next instanceof UiComponent.Footer) {
                arrayList.add(next);
            }
        }
        UiComponent.Footer footer = (UiComponent.Footer) CollectionsKt___CollectionsKt.P(arrayList);
        if (footer != null) {
            UiComponent.Footer.Attributes B = footer.z();
            if (B != null) {
                num = B.c();
            } else {
                num = null;
            }
            if (num != null) {
                A(jVar, num.intValue(), footer);
            } else {
                this.f29311b.f29591c.addView(jVar.b());
            }
        }
    }

    /* access modifiers changed from: private */
    public final Map<String, ComponentParam> w(List<com.withpersona.sdk2.inquiry.steps.ui.a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        x(linkedHashMap, list);
        return linkedHashMap;
    }

    /* JADX WARNING: type inference failed for: r7v4, types: [android.text.Editable] */
    /* JADX WARNING: type inference failed for: r7v16, types: [android.text.Editable] */
    /* JADX WARNING: type inference failed for: r7v18, types: [android.text.Editable] */
    /* JADX WARNING: type inference failed for: r7v20, types: [android.text.Editable] */
    /* JADX WARNING: type inference failed for: r7v32, types: [android.text.Editable] */
    /* JADX WARNING: type inference failed for: r7v34, types: [android.text.Editable] */
    /* JADX WARNING: type inference failed for: r7v36, types: [android.text.Editable] */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019d, code lost:
        if (r6 == null) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d6, code lost:
        if (r5 == null) goto L_0x01d8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void x(java.util.Map<java.lang.String, com.withpersona.sdk2.inquiry.ui.network.ComponentParam> r19, java.util.List<com.withpersona.sdk2.inquiry.steps.ui.a> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.util.Iterator r2 = r20.iterator()
        L_0x0008:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04af
            java.lang.Object r3 = r2.next()
            com.withpersona.sdk2.inquiry.steps.ui.a r3 = (com.withpersona.sdk2.inquiry.steps.ui.a) r3
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r4 = r3.a()
            android.view.View r3 = r3.b()
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText
            java.lang.String r6 = "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout"
            r7 = 0
            if (r5 == 0) goto L_0x0042
            kotlin.jvm.internal.j.e(r3, r6)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x0032
            android.text.Editable r7 = r3.getText()
        L_0x0032:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.String r4 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r3 = r0.F(r3)
            r1.put(r4, r3)
            goto L_0x0008
        L_0x0042:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputPhoneNumber
            if (r5 == 0) goto L_0x0065
            kotlin.jvm.internal.j.e(r3, r6)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x0055
            android.text.Editable r7 = r3.getText()
        L_0x0055:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.String r4 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r3 = r0.F(r3)
            r1.put(r4, r3)
            goto L_0x0008
        L_0x0065:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputConfirmationCode
            if (r5 == 0) goto L_0x007b
            zi.a r5 = zi.a.f34000a
            java.lang.String r3 = r5.a(r3)
            java.lang.String r4 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r3 = r0.F(r3)
            r1.put(r4, r3)
            goto L_0x0008
        L_0x007b:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputDate
            java.lang.String r8 = ""
            r9 = -1
            r10 = 0
            r11 = 1
            if (r5 == 0) goto L_0x0136
            int r5 = com.withpersona.sdk2.inquiry.ui.h.year
            android.view.View r5 = r3.findViewById(r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            int r6 = com.withpersona.sdk2.inquiry.ui.h.month
            android.view.View r6 = r3.findViewById(r6)
            com.google.android.material.textfield.TextInputLayout r6 = (com.google.android.material.textfield.TextInputLayout) r6
            int r12 = com.withpersona.sdk2.inquiry.ui.h.day
            android.view.View r3 = r3.findViewById(r12)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r5 = r5.getEditText()
            if (r5 == 0) goto L_0x00a7
            android.text.Editable r5 = r5.getText()
            goto L_0x00a8
        L_0x00a7:
            r5 = r7
        L_0x00a8:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            android.widget.EditText r6 = r6.getEditText()
            if (r6 == 0) goto L_0x00b7
            android.text.Editable r6 = r6.getText()
            goto L_0x00b8
        L_0x00b7:
            r6 = r7
        L_0x00b8:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r12 = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputDate r12 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputDate) r12
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputDate$Attributes r12 = r12.z()
            if (r12 == 0) goto L_0x00d0
            java.util.List r12 = r12.k()
            if (r12 == 0) goto L_0x00d0
            int r6 = r12.indexOf(r6)
            goto L_0x00d1
        L_0x00d0:
            r6 = r9
        L_0x00d1:
            if (r6 <= r9) goto L_0x00e1
            int r6 = r6 + 1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r9 = 2
            r12 = 48
            java.lang.String r6 = kotlin.text.StringsKt__StringsKt.o0(r6, r9, r12)
            goto L_0x00e2
        L_0x00e1:
            r6 = r8
        L_0x00e2:
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x00ec
            android.text.Editable r7 = r3.getText()
        L_0x00ec:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            int r7 = r5.length()
            if (r7 <= 0) goto L_0x00f8
            r7 = r11
            goto L_0x00f9
        L_0x00f8:
            r7 = r10
        L_0x00f9:
            if (r7 == 0) goto L_0x0129
            int r7 = r6.length()
            if (r7 <= 0) goto L_0x0103
            r7 = r11
            goto L_0x0104
        L_0x0103:
            r7 = r10
        L_0x0104:
            if (r7 == 0) goto L_0x0129
            int r7 = r3.length()
            if (r7 <= 0) goto L_0x010d
            r10 = r11
        L_0x010d:
            if (r10 == 0) goto L_0x0129
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r5 = 45
            r7.append(r5)
            r7.append(r6)
            r7.append(r5)
            r7.append(r3)
            java.lang.String r8 = r7.toString()
        L_0x0129:
            java.lang.String r3 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r4 = r0.F(r8)
            r1.put(r3, r4)
            goto L_0x0008
        L_0x0136:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputMaskedText
            if (r5 == 0) goto L_0x015a
            kotlin.jvm.internal.j.e(r3, r6)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x0149
            android.text.Editable r7 = r3.getText()
        L_0x0149:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.String r4 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r3 = r0.F(r3)
            r1.put(r4, r3)
            goto L_0x0008
        L_0x015a:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputSelect
            r12 = 10
            if (r5 == 0) goto L_0x01fd
            kotlin.jvm.internal.j.e(r3, r6)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            r5 = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputSelect r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputSelect) r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputSelect$Attributes r6 = r5.z()
            if (r6 == 0) goto L_0x019f
            java.util.List r6 = r6.h()
            if (r6 == 0) goto L_0x019f
            java.util.ArrayList r8 = new java.util.ArrayList
            int r11 = kotlin.collections.r.t(r6, r12)
            r8.<init>(r11)
            java.util.Iterator r6 = r6.iterator()
        L_0x0181:
            boolean r11 = r6.hasNext()
            if (r11 == 0) goto L_0x0195
            java.lang.Object r11 = r6.next()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputSelect$Option r11 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputSelect.Option) r11
            java.lang.String r11 = r11.a()
            r8.add(r11)
            goto L_0x0181
        L_0x0195:
            java.lang.String[] r6 = new java.lang.String[r10]
            java.lang.Object[] r6 = r8.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            if (r6 != 0) goto L_0x01a1
        L_0x019f:
            java.lang.String[] r6 = new java.lang.String[r10]
        L_0x01a1:
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputSelect$Attributes r5 = r5.z()
            if (r5 == 0) goto L_0x01d8
            java.util.List r5 = r5.h()
            if (r5 == 0) goto L_0x01d8
            java.util.ArrayList r8 = new java.util.ArrayList
            int r11 = kotlin.collections.r.t(r5, r12)
            r8.<init>(r11)
            java.util.Iterator r5 = r5.iterator()
        L_0x01ba:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x01ce
            java.lang.Object r11 = r5.next()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputSelect$Option r11 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputSelect.Option) r11
            java.lang.String r11 = r11.c()
            r8.add(r11)
            goto L_0x01ba
        L_0x01ce:
            java.lang.String[] r5 = new java.lang.String[r10]
            java.lang.Object[] r5 = r8.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            if (r5 != 0) goto L_0x01da
        L_0x01d8:
            java.lang.String[] r5 = new java.lang.String[r10]
        L_0x01da:
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x01e4
            android.text.Editable r7 = r3.getText()
        L_0x01e4:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            int r3 = kotlin.collections.l.H(r6, r3)
            if (r3 == r9) goto L_0x0008
            java.lang.String r4 = r4.A()
            r3 = r5[r3]
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r3 = r0.F(r3)
            r1.put(r4, r3)
            goto L_0x0008
        L_0x01fd:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputMultiSelect
            if (r5 == 0) goto L_0x027c
            kotlin.jvm.internal.j.e(r3, r6)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x0211
            android.text.Editable r3 = r3.getText()
            goto L_0x0212
        L_0x0211:
            r3 = r7
        L_0x0212:
            java.lang.String r12 = java.lang.String.valueOf(r3)
            java.lang.String[] r13 = new java.lang.String[r11]
            com.withpersona.sdk2.inquiry.steps.ui.components.j$a r3 = com.withpersona.sdk2.inquiry.steps.ui.components.j.f27586r
            java.lang.String r3 = r3.a()
            r13[r10] = r3
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.util.List r3 = kotlin.text.StringsKt__StringsKt.C0(r12, r13, r14, r15, r16, r17)
            r5 = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputMultiSelect r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputMultiSelect) r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputMultiSelect$Attributes r5 = r5.z()
            if (r5 == 0) goto L_0x0264
            java.util.List r5 = r5.h()
            if (r5 == 0) goto L_0x0264
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0242:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0268
            java.lang.Object r8 = r5.next()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputMultiSelect$Option r8 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputMultiSelect.Option) r8
            java.lang.String r9 = r8.a()
            boolean r9 = r3.contains(r9)
            if (r9 == 0) goto L_0x025d
            java.lang.String r8 = r8.c()
            goto L_0x025e
        L_0x025d:
            r8 = r7
        L_0x025e:
            if (r8 == 0) goto L_0x0242
            r6.add(r8)
            goto L_0x0242
        L_0x0264:
            java.util.List r6 = kotlin.collections.q.j()
        L_0x0268:
            boolean r3 = r6.isEmpty()
            r3 = r3 ^ r11
            if (r3 == 0) goto L_0x0008
            java.lang.String r3 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentStringList r4 = r0.G(r6)
            r1.put(r3, r4)
            goto L_0x0008
        L_0x027c:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputAddress
            if (r5 == 0) goto L_0x0305
            int r5 = com.withpersona.sdk2.inquiry.ui.h.address_field
            android.view.View r5 = r3.findViewById(r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            android.widget.EditText r5 = r5.getEditText()
            if (r5 == 0) goto L_0x0293
            android.text.Editable r5 = r5.getText()
            goto L_0x0294
        L_0x0293:
            r5 = r7
        L_0x0294:
            java.lang.String r9 = java.lang.String.valueOf(r5)
            int r5 = com.withpersona.sdk2.inquiry.ui.h.address_suite
            android.view.View r5 = r3.findViewById(r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            android.widget.EditText r5 = r5.getEditText()
            if (r5 == 0) goto L_0x02ab
            android.text.Editable r5 = r5.getText()
            goto L_0x02ac
        L_0x02ab:
            r5 = r7
        L_0x02ac:
            java.lang.String r10 = java.lang.String.valueOf(r5)
            int r5 = com.withpersona.sdk2.inquiry.ui.h.address_city
            android.view.View r5 = r3.findViewById(r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            android.widget.EditText r5 = r5.getEditText()
            if (r5 == 0) goto L_0x02c3
            android.text.Editable r5 = r5.getText()
            goto L_0x02c4
        L_0x02c3:
            r5 = r7
        L_0x02c4:
            java.lang.String r11 = java.lang.String.valueOf(r5)
            int r5 = com.withpersona.sdk2.inquiry.ui.h.address_subdivision
            android.view.View r5 = r3.findViewById(r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            android.widget.EditText r5 = r5.getEditText()
            if (r5 == 0) goto L_0x02db
            android.text.Editable r5 = r5.getText()
            goto L_0x02dc
        L_0x02db:
            r5 = r7
        L_0x02dc:
            java.lang.String r12 = java.lang.String.valueOf(r5)
            int r5 = com.withpersona.sdk2.inquiry.ui.h.address_postal_code
            android.view.View r3 = r3.findViewById(r5)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x02f2
            android.text.Editable r7 = r3.getText()
        L_0x02f2:
            java.lang.String r13 = java.lang.String.valueOf(r7)
            java.lang.String r3 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$Address r4 = new com.withpersona.sdk2.inquiry.ui.network.ComponentParam$Address
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13)
            r1.put(r3, r4)
            goto L_0x0008
        L_0x0305:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.HorizontalStack
            if (r5 == 0) goto L_0x0388
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r6 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout"
            kotlin.jvm.internal.j.e(r3, r6)
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            kotlin.ranges.IntRange r6 = new kotlin.ranges.IntRange
            int r7 = r3.getChildCount()
            r6.<init>(r10, r7)
            java.util.Iterator r6 = r6.iterator()
        L_0x0322:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x033d
            r7 = r6
            kotlin.collections.b0 r7 = (kotlin.collections.b0) r7
            int r7 = r7.nextInt()
            android.view.View r7 = r3.getChildAt(r7)
            if (r7 == 0) goto L_0x0322
            boolean r8 = r7 instanceof androidx.constraintlayout.widget.Guideline
            if (r8 != 0) goto L_0x0322
            r5.add(r7)
            goto L_0x0322
        L_0x033d:
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$HorizontalStack r4 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.HorizontalStack) r4
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$HorizontalStack$Attributes r3 = r4.z()
            if (r3 == 0) goto L_0x037f
            java.util.List r3 = r3.c()
            if (r3 == 0) goto L_0x037f
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.E0(r3, r5)
            if (r3 == 0) goto L_0x037f
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.collections.r.t(r3, r12)
            r4.<init>(r5)
            java.util.Iterator r3 = r3.iterator()
        L_0x035e:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0383
            java.lang.Object r5 = r3.next()
            kotlin.Pair r5 = (kotlin.Pair) r5
            com.withpersona.sdk2.inquiry.steps.ui.a r6 = new com.withpersona.sdk2.inquiry.steps.ui.a
            java.lang.Object r7 = r5.c()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r7 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent) r7
            java.lang.Object r5 = r5.d()
            android.view.View r5 = (android.view.View) r5
            r6.<init>(r7, r5)
            r4.add(r6)
            goto L_0x035e
        L_0x037f:
            java.util.List r4 = kotlin.collections.q.j()
        L_0x0383:
            r0.x(r1, r4)
            goto L_0x0008
        L_0x0388:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputCheckbox
            if (r5 == 0) goto L_0x03a5
            java.lang.String r5 = "null cannot be cast to non-null type android.widget.CheckBox"
            kotlin.jvm.internal.j.e(r3, r5)
            android.widget.CheckBox r3 = (android.widget.CheckBox) r3
            java.lang.String r4 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentBoolean r5 = new com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentBoolean
            boolean r3 = r3.isChecked()
            r5.<init>(r3)
            r1.put(r4, r5)
            goto L_0x0008
        L_0x03a5:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputRadioGroup
            if (r5 == 0) goto L_0x0414
            int r5 = com.withpersona.sdk2.inquiry.ui.h.radio_group
            android.view.View r3 = r3.findViewById(r5)
            java.lang.String r5 = "view.findViewById(R.id.radio_group)"
            kotlin.jvm.internal.j.f(r3, r5)
            android.widget.RadioGroup r3 = (android.widget.RadioGroup) r3
            int r5 = r3.getCheckedRadioButtonId()
            if (r5 <= r9) goto L_0x0406
            int r5 = r3.getCheckedRadioButtonId()
            android.view.View r3 = r3.findViewById(r5)
            com.google.android.material.radiobutton.MaterialRadioButton r3 = (com.google.android.material.radiobutton.MaterialRadioButton) r3
            java.lang.CharSequence r3 = r3.getText()
            r5 = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputRadioGroup r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputRadioGroup) r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputRadioGroup$Attributes r5 = r5.z()
            if (r5 == 0) goto L_0x0406
            java.util.List r5 = r5.i()
            if (r5 == 0) goto L_0x0406
            java.util.Iterator r5 = r5.iterator()
        L_0x03dd:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x03fe
            java.lang.Object r6 = r5.next()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputRadioGroup$Option r6 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputRadioGroup.Option) r6
            java.lang.String r7 = r6.a()
            boolean r7 = kotlin.jvm.internal.j.b(r7, r3)
            if (r7 == 0) goto L_0x03dd
            if (r6 == 0) goto L_0x0406
            java.lang.String r3 = r6.c()
            if (r3 != 0) goto L_0x03fc
            goto L_0x0406
        L_0x03fc:
            r8 = r3
            goto L_0x0406
        L_0x03fe:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            java.lang.String r2 = "Collection contains no element matching the predicate."
            r1.<init>(r2)
            throw r1
        L_0x0406:
            java.lang.String r3 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString r4 = new com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentString
            r4.<init>(r8)
            r1.put(r3, r4)
            goto L_0x0008
        L_0x0414:
            boolean r5 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputNumber
            if (r5 == 0) goto L_0x043e
            kotlin.jvm.internal.j.e(r3, r6)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x0427
            android.text.Editable r7 = r3.getText()
        L_0x0427:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.Double r3 = kotlin.text.p.i(r3)
            if (r3 == 0) goto L_0x0008
            java.lang.String r4 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ComponentNumber r3 = r0.E(r3)
            r1.put(r4, r3)
            goto L_0x0008
        L_0x043e:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ESignature
            if (r3 == 0) goto L_0x0461
            r3 = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$ESignature r3 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ESignature) r3
            yi.a r3 = r3.h()
            android.graphics.Bitmap r3 = r3.b()
            if (r3 == 0) goto L_0x0453
            java.lang.String r7 = com.withpersona.sdk2.inquiry.steps.ui.components.ESignatureKt.d(r3)
        L_0x0453:
            java.lang.String r3 = r4.A()
            com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ESignature r4 = new com.withpersona.sdk2.inquiry.ui.network.ComponentParam$ESignature
            r4.<init>(r7)
            r1.put(r3, r4)
            goto L_0x0008
        L_0x0461:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Branding
            if (r3 == 0) goto L_0x0467
            r3 = r11
            goto L_0x0469
        L_0x0467:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button
        L_0x0469:
            if (r3 == 0) goto L_0x046d
            r3 = r11
            goto L_0x046f
        L_0x046d:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ClickableStack
        L_0x046f:
            if (r3 == 0) goto L_0x0473
            r3 = r11
            goto L_0x0475
        L_0x0473:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Footer
        L_0x0475:
            if (r3 == 0) goto L_0x0479
            r3 = r11
            goto L_0x047b
        L_0x0479:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage
        L_0x047b:
            if (r3 == 0) goto L_0x047f
            r3 = r11
            goto L_0x0481
        L_0x047f:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.PrivacyPolicy
        L_0x0481:
            if (r3 == 0) goto L_0x0485
            r3 = r11
            goto L_0x0487
        L_0x0485:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage
        L_0x0487:
            if (r3 == 0) goto L_0x048b
            r3 = r11
            goto L_0x048d
        L_0x048b:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Spacer
        L_0x048d:
            if (r3 == 0) goto L_0x0491
            r3 = r11
            goto L_0x0493
        L_0x0491:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Text
        L_0x0493:
            if (r3 == 0) goto L_0x0497
            r3 = r11
            goto L_0x0499
        L_0x0497:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Title
        L_0x0499:
            if (r3 == 0) goto L_0x049d
            r3 = r11
            goto L_0x049f
        L_0x049d:
            boolean r3 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.QRCode
        L_0x049f:
            if (r3 == 0) goto L_0x04a2
            goto L_0x04a4
        L_0x04a2:
            boolean r11 = r4 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.CombinedStepImagePreview
        L_0x04a4:
            if (r11 == 0) goto L_0x04a8
            goto L_0x0008
        L_0x04a8:
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Unknown r3 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Unknown.f28004c
            kotlin.jvm.internal.j.b(r4, r3)
            goto L_0x0008
        L_0x04af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.ui.UiScreenRunner.x(java.util.Map, java.util.List):void");
    }

    private final void y(UiWorkflow.c.a aVar, UiComponent.ClickableStack clickableStack, ConstraintLayout constraintLayout) {
        constraintLayout.setOnClickListener(new s(clickableStack, this));
        if (clickableStack.E()) {
            com.withpersona.sdk2.inquiry.steps.ui.styling.d.a(constraintLayout, clickableStack.D());
        } else if (aVar.q()) {
            com.withpersona.sdk2.inquiry.steps.ui.styling.d.d(constraintLayout, clickableStack.D());
        }
    }

    /* access modifiers changed from: private */
    public static final void z(UiComponent.ClickableStack clickableStack, UiScreenRunner uiScreenRunner, View view) {
        j.g(clickableStack, "$component");
        j.g(uiScreenRunner, "this$0");
        clickableStack.F(true);
        uiScreenRunner.f29317h.invoke(clickableStack);
    }

    /* renamed from: D */
    public void a(UiWorkflow.c.a aVar, p pVar) {
        com.withpersona.sdk2.inquiry.steps.ui.a aVar2;
        j.g(aVar, "rendering");
        j.g(pVar, "viewEnvironment");
        List<UiComponent> f10 = aVar.f();
        ArrayList<com.withpersona.sdk2.inquiry.steps.ui.a> arrayList = new ArrayList<>();
        for (UiComponent uiComponent : f10) {
            View view = this.f29312c.get(uiComponent.A());
            if (view == null) {
                aVar2 = null;
            } else {
                aVar2 = new com.withpersona.sdk2.inquiry.steps.ui.a(uiComponent, view);
            }
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
        }
        Set<Map.Entry<String, ComponentParam>> entrySet = w(arrayList).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair a10 = h.a(entry.getKey(), com.withpersona.sdk2.inquiry.ui.network.a.a((ComponentParam) entry.getValue()));
            linkedHashMap.put(a10.c(), a10.d());
        }
        List<UiTransitionErrorResponse.UiComponentError> e10 = aVar.e();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j.c(g0.e(r.t(e10, 10)), 16));
        for (T next : e10) {
            linkedHashMap2.put(((UiTransitionErrorResponse.UiComponentError) next).a(), next);
        }
        for (com.withpersona.sdk2.inquiry.steps.ui.a aVar3 : arrayList) {
            H(aVar, aVar3.a(), aVar3.b(), linkedHashMap, linkedHashMap2);
        }
        this.f29311b.f29596h.setState(new NavigationUiState(aVar.b(), new UiScreenRunner$showRendering$2(aVar), aVar.d(), new UiScreenRunner$showRendering$3(aVar)));
        this.f29311b.f29596h.getBackButton().setEnabled(!aVar.q());
        CoordinatorLayout b10 = this.f29311b.getRoot();
        j.f(b10, "binding.root");
        com.squareup.workflow1.ui.b.c(b10, new UiScreenRunner$showRendering$4(this, aVar));
        CoordinatorLayout b11 = this.f29311b.getRoot();
        j.f(b11, "binding.root");
        o.b(b11, aVar.g(), aVar.m(), (View) null, 0, 0, 56, (Object) null);
        this.f29315f = aVar.l();
        this.f29316g = aVar.j();
        this.f29317h = new UiScreenRunner$showRendering$5(aVar, this, arrayList);
    }
}
