package com.withpersona.sdk2.inquiry.steps.ui;

import aj.o;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.components.ButtonsKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.ComplexWidgetsKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.ESignatureKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.InputsKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.QRCodeKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.StacksKt;
import com.withpersona.sdk2.inquiry.steps.ui.components.TextsKt;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ti.a;
import ti.b;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f27597a = new m();

    private m() {
    }

    private final void b(ViewGroup viewGroup, View view, c cVar, View view2, int i10) {
        view.setId(View.generateViewId());
        viewGroup.addView(view);
        cVar.h(view.getId(), 6, viewGroup.getId(), 6);
        cVar.h(view.getId(), 7, viewGroup.getId(), 7);
        cVar.h(view.getId(), 3, view2.getId(), 4);
        cVar.h(view2.getId(), 4, view.getId(), 3);
        cVar.k(view.getId(), 1);
        cVar.l(view.getId(), i10);
    }

    private final void c(ConstraintLayout constraintLayout) {
        T t10;
        ArrayList<View> focusables = constraintLayout.getFocusables(2);
        j.f(focusables, "parentView.getFocusables(View.FOCUS_FORWARD)");
        Iterator<T> it = focusables.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((View) t10) instanceof EditText) {
                break;
            }
        }
        View view = (View) t10;
        if (view != null) {
            view.requestFocus();
            view.post(new l(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void d(View view) {
        j.g(view, "$it");
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: mf.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: mf.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: mf.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x030d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View e(android.content.Context r19, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Footer r20, boolean r21, java.util.Map<java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.a> r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r21
            r9 = r22
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r19)
            aj.f r10 = aj.f.c(r0)
            java.lang.String r0 = "inflate(LayoutInflater.from(context))"
            kotlin.jvm.internal.j.f(r10, r0)
            java.lang.String r0 = r20.D()
            if (r0 == 0) goto L_0x0024
            androidx.constraintlayout.widget.ConstraintLayout r1 = r10.f24855c
            int r0 = android.graphics.Color.parseColor(r0)
            r1.setBackgroundColor(r0)
        L_0x0024:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r0 = r20.F()
            if (r0 == 0) goto L_0x009d
            android.content.res.Resources r1 = r19.getResources()
            int r2 = com.withpersona.sdk2.inquiry.steps.ui.e.startEndMargin
            int r1 = r1.getDimensionPixelOffset(r2)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r2 = r0.c()
            if (r2 == 0) goto L_0x004a
            java.lang.Double r2 = r2.a()
            if (r2 == 0) goto L_0x004a
            double r2 = r2.doubleValue()
            double r2 = ti.b.a(r2)
            int r2 = (int) r2
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            int r2 = vk.j.c(r2, r1)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r3 = r0.d()
            if (r3 == 0) goto L_0x0065
            java.lang.Double r3 = r3.a()
            if (r3 == 0) goto L_0x0065
            double r3 = r3.doubleValue()
            double r3 = ti.b.a(r3)
            int r3 = (int) r3
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            int r1 = vk.j.c(r3, r1)
            androidx.constraintlayout.widget.ConstraintLayout r3 = r10.f24855c
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r0.e()
            if (r4 == 0) goto L_0x0082
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0082
            double r4 = r4.doubleValue()
            double r4 = ti.b.a(r4)
            int r4 = (int) r4
            goto L_0x0083
        L_0x0082:
            r4 = 0
        L_0x0083:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = r0.a()
            if (r0 == 0) goto L_0x0099
            java.lang.Double r0 = r0.a()
            if (r0 == 0) goto L_0x0099
            double r12 = r0.doubleValue()
            double r12 = ti.b.a(r12)
            int r0 = (int) r12
            goto L_0x009a
        L_0x0099:
            r0 = 0
        L_0x009a:
            r3.setPadding(r2, r4, r1, r0)
        L_0x009d:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r0 = r20.E()
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            java.lang.String r2 = "binding.hairline"
            if (r0 == 0) goto L_0x00d5
            android.view.View r3 = r10.f24857e
            kotlin.jvm.internal.j.f(r3, r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            if (r4 == 0) goto L_0x00cf
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = r0.e()
            if (r0 == 0) goto L_0x00c8
            java.lang.Double r0 = r0.a()
            if (r0 == 0) goto L_0x00c8
            double r0 = r0.doubleValue()
            double r0 = ti.b.a(r0)
            int r0 = (int) r0
            goto L_0x00c9
        L_0x00c8:
            r0 = 0
        L_0x00c9:
            r4.height = r0
            r3.setLayoutParams(r4)
            goto L_0x00ec
        L_0x00cf:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r1)
            throw r0
        L_0x00d5:
            android.view.View r0 = r10.f24857e
            kotlin.jvm.internal.j.f(r0, r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            if (r3 == 0) goto L_0x034d
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = ti.b.a(r4)
            int r1 = (int) r4
            r3.height = r1
            r0.setLayoutParams(r3)
        L_0x00ec:
            androidx.constraintlayout.widget.c r12 = new androidx.constraintlayout.widget.c
            r12.<init>()
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.f24855c
            r12.f(r0)
            android.view.View r0 = r10.f24857e
            kotlin.jvm.internal.j.f(r0, r2)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Footer$Attributes r1 = r20.z()
            r13 = 0
            if (r1 == 0) goto L_0x0107
            java.util.List r1 = r1.a()
            goto L_0x0108
        L_0x0107:
            r1 = r13
        L_0x0108:
            if (r1 != 0) goto L_0x010e
            java.util.List r1 = kotlin.collections.q.j()
        L_0x010e:
            java.util.Iterator r14 = r1.iterator()
        L_0x0112:
            r15 = r0
        L_0x0113:
            boolean r0 = r14.hasNext()
            java.lang.String r1 = "binding.root"
            if (r0 == 0) goto L_0x031b
            java.lang.Object r0 = r14.next()
            r5 = r0
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent) r5
            boolean r0 = r5 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button
            if (r0 == 0) goto L_0x0177
            boolean r0 = r5 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.SubmitButton
            if (r0 != 0) goto L_0x0152
            boolean r0 = r5 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ActionButton
            if (r0 != 0) goto L_0x0152
            boolean r0 = r5 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.CombinedStepButton
            if (r0 == 0) goto L_0x0133
            goto L_0x0152
        L_0x0133:
            r0 = r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Button r0 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button) r0
            com.google.android.material.button.MaterialButton r16 = com.withpersona.sdk2.inquiry.steps.ui.components.ButtonsKt.b(r7, r0)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r17 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r11 = r5
            r5 = r17
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x0152:
            r11 = r5
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Button r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button) r5
            cj.b r5 = com.withpersona.sdk2.inquiry.steps.ui.components.ButtonsKt.c(r7, r5)
            r5.setIsLoading(r8)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r16 = 0
            r0 = r18
            r1 = r2
            r2 = r5
            r3 = r12
            r4 = r15
            r17 = r5
            r5 = r16
            r0.b(r1, r2, r3, r4, r5)
        L_0x0173:
            r0 = r17
            goto L_0x030b
        L_0x0177:
            r11 = r5
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Branding
            if (r0 == 0) goto L_0x01d7
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Branding r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Branding) r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Branding$Attributes r0 = r5.z()
            if (r0 == 0) goto L_0x0190
            java.lang.Boolean r0 = r0.a()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.j.b(r0, r2)
            goto L_0x0191
        L_0x0190:
            r0 = 0
        L_0x0191:
            if (r0 != 0) goto L_0x030a
            mf.a r5 = new mf.a
            r5.<init>(r7)
            int r0 = com.withpersona.sdk2.inquiry.steps.ui.f.pi2_inquiry_persona_branding
            r5.setImageResource(r0)
            r0 = 1
            r5.setAdjustViewBounds(r0)
            android.content.res.Resources r0 = r19.getResources()
            int r2 = com.withpersona.sdk2.inquiry.steps.ui.e.startEndMargin
            float r0 = r0.getDimension(r2)
            int r0 = (int) r0
            int r2 = r5.getPaddingTop()
            int r3 = r5.getPaddingBottom()
            r5.setPadding(r0, r2, r0, r3)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r16 = 1
            r0 = r18
            r1 = r2
            r2 = r5
            r3 = r12
            r4 = r15
            r17 = r5
            r5 = r16
            r0.b(r1, r2, r3, r4, r5)
            int r0 = r17.getId()
            r1 = 1065353216(0x3f800000, float:1.0)
            r12.E(r0, r1)
            goto L_0x0173
        L_0x01d7:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.PrivacyPolicy
            if (r0 == 0) goto L_0x01f8
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$PrivacyPolicy r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.PrivacyPolicy) r5
            android.widget.TextView r16 = com.withpersona.sdk2.inquiry.steps.ui.components.TextsKt.b(r7, r5)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
        L_0x01f4:
            r0 = r16
            goto L_0x030b
        L_0x01f8:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Text
            if (r0 == 0) goto L_0x0216
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Text r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Text) r5
            android.widget.TextView r16 = com.withpersona.sdk2.inquiry.steps.ui.components.TextsKt.a(r7, r5)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x0216:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Title
            if (r0 == 0) goto L_0x0234
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Title r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Title) r5
            android.widget.TextView r16 = com.withpersona.sdk2.inquiry.steps.ui.components.TextsKt.d(r7, r5)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x0234:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ClickableStack
            if (r0 == 0) goto L_0x026f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$ClickableStack r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ClickableStack) r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$ClickableStack$Attributes r2 = r5.z()
            if (r2 == 0) goto L_0x024c
            java.util.List r2 = r2.e()
            if (r2 != 0) goto L_0x0250
        L_0x024c:
            java.util.List r2 = kotlin.collections.q.j()
        L_0x0250:
            java.util.List r2 = r6.j(r2, r7, r8, r0)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$ClickableStackComponentStyle r3 = r5.D()
            androidx.constraintlayout.widget.ConstraintLayout r16 = com.withpersona.sdk2.inquiry.steps.ui.components.StacksKt.a(r7, r0, r2, r3)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x026f:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.HorizontalStack
            if (r0 == 0) goto L_0x02ab
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$HorizontalStack r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.HorizontalStack) r5
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$HorizontalStack$Attributes r2 = r5.z()
            if (r2 == 0) goto L_0x0287
            java.util.List r2 = r2.c()
            if (r2 != 0) goto L_0x028b
        L_0x0287:
            java.util.List r2 = kotlin.collections.q.j()
        L_0x028b:
            java.util.List r2 = r6.j(r2, r7, r8, r0)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$HorizontalStackComponentStyle r3 = r5.F()
            androidx.constraintlayout.widget.ConstraintLayout r16 = com.withpersona.sdk2.inquiry.steps.ui.components.StacksKt.d(r7, r0, r2, r3)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x02ab:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Spacer
            if (r0 == 0) goto L_0x02ca
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Spacer r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Spacer) r5
            android.view.View r16 = com.withpersona.sdk2.inquiry.steps.ui.components.ComplexWidgetsKt.c(r7, r5)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 1
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x02ca:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage
            if (r0 == 0) goto L_0x02eb
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage) r5
            android.view.View r16 = com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.g(r7, r5)
            if (r16 == 0) goto L_0x030a
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x02eb:
            boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage
            if (r0 == 0) goto L_0x030a
            r5 = r11
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage r5 = (com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage) r5
            android.view.View r16 = com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.k(r7, r5)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            kotlin.jvm.internal.j.f(r2, r1)
            r5 = 0
            r0 = r18
            r1 = r2
            r2 = r16
            r3 = r12
            r4 = r15
            r0.b(r1, r2, r3, r4, r5)
            goto L_0x01f4
        L_0x030a:
            r0 = r13
        L_0x030b:
            if (r0 == 0) goto L_0x0113
            java.lang.String r1 = r11.A()
            com.withpersona.sdk2.inquiry.steps.ui.a r2 = new com.withpersona.sdk2.inquiry.steps.ui.a
            r2.<init>(r11, r0)
            r9.put(r1, r2)
            goto L_0x0112
        L_0x031b:
            int r0 = r15.getId()
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            int r2 = r2.getId()
            r3 = 4
            r12.h(r0, r3, r2, r3)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.f24855c
            r12.c(r0)
            java.lang.String r0 = r20.A()
            com.withpersona.sdk2.inquiry.steps.ui.a r2 = new com.withpersona.sdk2.inquiry.steps.ui.a
            androidx.constraintlayout.widget.ConstraintLayout r3 = r10.getRoot()
            kotlin.jvm.internal.j.f(r3, r1)
            r4 = r20
            r2.<init>(r4, r3)
            r9.put(r0, r2)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.getRoot()
            kotlin.jvm.internal.j.f(r0, r1)
            return r0
        L_0x034d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.m.e(android.content.Context, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Footer, boolean, java.util.Map):android.view.View");
    }

    private final View f(Context context, UiScreen uiScreen, boolean z10, Map<String, a> map) {
        c cVar;
        a aVar;
        View d10;
        Map<String, a> map2 = map;
        o c10 = o.c(LayoutInflater.from(context));
        j.f(c10, "inflate(LayoutInflater.from(context))");
        ConstraintLayout b10 = c10.getRoot();
        j.f(b10, "binding.root");
        List<UiComponent> components = uiScreen.getComponents();
        if (components == null) {
            components = q.j();
        }
        ArrayList arrayList = new ArrayList();
        List<View> j10 = j(components, context, z10, arrayList);
        c cVar2 = new c();
        cVar2.f(b10);
        for (View next : j10) {
            next.setId(View.generateViewId());
            b10.addView(next);
            cVar2.h(next.getId(), 6, 0, 6);
            cVar2.h(next.getId(), 7, 0, 7);
            cVar2.m(next.getId(), -2);
            cVar2.l(next.getId(), 0);
            cVar2.H(next.getId(), 0.5f);
        }
        for (Object next2 : arrayList) {
            map2.put(((a) next2).c().A(), next2);
        }
        if (j10.size() > 1) {
            ArrayList arrayList2 = new ArrayList(r.t(j10, 10));
            for (View id2 : j10) {
                arrayList2.add(Integer.valueOf(id2.getId()));
            }
            cVar = cVar2;
            cVar2.t(0, 3, 0, 4, CollectionsKt___CollectionsKt.w0(arrayList2), (float[]) null, 3);
            int i10 = 0;
            for (UiComponent next3 : components) {
                int i11 = i10 + 1;
                if (!((next3 instanceof UiComponent.Spacer) || uiScreen.b() != null || (aVar = map2.get(next3.A())) == null || (d10 = aVar.d()) == null || i10 == q.l(components))) {
                    cVar.G(d10.getId(), 4, (int) b.a(16.0d));
                }
                i10 = i11;
            }
        } else {
            cVar = cVar2;
        }
        b10.setPadding(b10.getPaddingLeft(), b10.getPaddingTop(), b10.getPaddingRight(), (int) b.a(24.0d));
        cVar.c(b10);
        Context context2 = c10.getRoot().getContext();
        j.f(context2, "binding.root.context");
        if (!a.d(context2)) {
            c(b10);
        }
        ConstraintLayout b11 = c10.getRoot();
        j.f(b11, "binding.root");
        return b11;
    }

    public static /* synthetic */ UiStepBottomSheet i(m mVar, UiScreen uiScreen, List list, Function0 function0, String str, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = null;
        }
        return mVar.h(uiScreen, list, function0, str);
    }

    private final List<View> j(List<? extends UiComponent> list, Context context, boolean z10, List<a> list2) {
        List<UiComponent> list3;
        List<UiComponent> list4;
        ArrayList arrayList = new ArrayList();
        for (UiComponent uiComponent : list) {
            View view = null;
            if (uiComponent instanceof UiComponent.Text) {
                view = TextsKt.a(context, (UiComponent.Text) uiComponent);
            } else if (uiComponent instanceof UiComponent.Title) {
                view = TextsKt.d(context, (UiComponent.Title) uiComponent);
            } else if (uiComponent instanceof UiComponent.PrivacyPolicy) {
                view = TextsKt.b(context, (UiComponent.PrivacyPolicy) uiComponent);
            } else if (uiComponent instanceof UiComponent.LocalImage) {
                view = ImagesKt.g(context, (UiComponent.LocalImage) uiComponent);
            } else if (uiComponent instanceof UiComponent.RemoteImage) {
                view = ImagesKt.k(context, (UiComponent.RemoteImage) uiComponent);
            } else if (uiComponent instanceof UiComponent.CompleteButton) {
                view = ButtonsKt.b(context, (UiComponent.Button) uiComponent);
            } else if (uiComponent instanceof UiComponent.SubmitButton) {
                view = ButtonsKt.c(context, (UiComponent.Button) uiComponent);
            } else if (uiComponent instanceof UiComponent.ActionButton) {
                view = ButtonsKt.c(context, (UiComponent.Button) uiComponent);
            } else if (uiComponent instanceof UiComponent.CancelButton) {
                view = ButtonsKt.b(context, (UiComponent.Button) uiComponent);
            } else if (uiComponent instanceof UiComponent.CombinedStepButton) {
                view = ButtonsKt.c(context, (UiComponent.Button) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputMaskedText) {
                view = InputsKt.p(context, (UiComponent.InputMaskedText) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputText) {
                view = InputsKt.q(context, (UiComponent.InputText) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputPhoneNumber) {
                view = InputsKt.m(context, (UiComponent.InputPhoneNumber) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputAddress) {
                view = InputsKt.g(context, (UiComponent.InputAddress) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputSelect) {
                view = ComplexWidgetsKt.b(context, (UiComponent.InputSelect) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputMultiSelect) {
                view = ComplexWidgetsKt.a(context, (UiComponent.InputMultiSelect) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputRadioGroup) {
                view = InputsKt.n(context, (UiComponent.InputRadioGroup) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputCheckbox) {
                view = InputsKt.h(context, (UiComponent.InputCheckbox) uiComponent);
            } else if (uiComponent instanceof UiComponent.Spacer) {
                view = ComplexWidgetsKt.c(context, (UiComponent.Spacer) uiComponent);
            } else if (uiComponent instanceof UiComponent.HorizontalStack) {
                m mVar = f27597a;
                UiComponent.HorizontalStack horizontalStack = (UiComponent.HorizontalStack) uiComponent;
                UiComponent.HorizontalStack.Attributes E = horizontalStack.z();
                if (E == null || (list4 = E.c()) == null) {
                    list4 = q.j();
                }
                view = StacksKt.d(context, list2, mVar.j(list4, context, z10, list2), horizontalStack.F());
            } else if (uiComponent instanceof UiComponent.ClickableStack) {
                m mVar2 = f27597a;
                UiComponent.ClickableStack clickableStack = (UiComponent.ClickableStack) uiComponent;
                UiComponent.ClickableStack.Attributes B = clickableStack.z();
                if (B == null || (list3 = B.e()) == null) {
                    list3 = q.j();
                }
                view = StacksKt.a(context, list2, mVar2.j(list3, context, z10, list2), clickableStack.D());
            } else if (uiComponent instanceof UiComponent.InputDate) {
                view = InputsKt.k(context, (UiComponent.InputDate) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputConfirmationCode) {
                view = InputsKt.j(context, (UiComponent.InputConfirmationCode) uiComponent);
            } else if (uiComponent instanceof UiComponent.InputNumber) {
                view = InputsKt.l(context, (UiComponent.InputNumber) uiComponent);
            } else if (uiComponent instanceof UiComponent.QRCode) {
                view = QRCodeKt.a(context, (UiComponent.QRCode) uiComponent);
            } else if (uiComponent instanceof UiComponent.CombinedStepImagePreview) {
                view = ImagesKt.d(context, (UiComponent.CombinedStepImagePreview) uiComponent);
            } else if (uiComponent instanceof UiComponent.ESignature) {
                view = ESignatureKt.c(context, (UiComponent.ESignature) uiComponent);
            } else if (!(uiComponent instanceof UiComponent.Footer) && !(uiComponent instanceof UiComponent.Branding)) {
                boolean z11 = uiComponent instanceof UiComponent.Unknown;
            }
            if (view != null) {
                list2.add(new a(uiComponent, view));
            }
            if (view != null) {
                arrayList.add(view);
            }
        }
        return arrayList;
    }

    public final j g(Context context, UiScreen uiScreen, boolean z10) {
        UiComponent.Footer footer;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(uiScreen, "uiScreen");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        View f10 = f(context, uiScreen, z10, linkedHashMap);
        List<UiComponent> components = uiScreen.getComponents();
        View view = null;
        if (components != null) {
            ArrayList arrayList = new ArrayList();
            for (T next : components) {
                if (next instanceof UiComponent.Footer) {
                    arrayList.add(next);
                }
            }
            footer = (UiComponent.Footer) CollectionsKt___CollectionsKt.P(arrayList);
        } else {
            footer = null;
        }
        if (footer != null) {
            view = e(context, footer, z10, linkedHashMap);
        }
        return new j(new k(linkedHashMap), f10, view);
    }

    public final UiStepBottomSheet h(UiScreen uiScreen, List<? extends Pair<String, ? extends Function0<Unit>>> list, Function0<Unit> function0, String str) {
        j.g(uiScreen, "uiScreen");
        j.g(list, "componentNamesToActions");
        j.g(function0, "onCancelled");
        return new UiStepBottomSheet(uiScreen, list, function0, str);
    }

    public final j k(vi.b bVar, UiScreen uiScreen, Function2<? super vi.b, ? super Map<String, a>, Unit> function2) {
        j.g(bVar, "binding");
        j.g(uiScreen, "uiScreen");
        Context context = bVar.getRoot().getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        j g10 = g(context, uiScreen, false);
        if (uiScreen.d() == StyleElements.PositionType.CENTER) {
            bVar.f33902c.setFillViewport(true);
            g10.a().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            View a10 = g10.a();
            ViewGroup.LayoutParams layoutParams = a10.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = 16;
                a10.setLayoutParams(layoutParams2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
        bVar.f33901b.addView(g10.a());
        if (g10.b() != null) {
            bVar.f33903d.addView(g10.b());
        }
        if (function2 != null) {
            function2.invoke(bVar, g10.c().a());
        }
        String a11 = uiScreen.a();
        if (a11 != null) {
            bVar.getRoot().setBackgroundColor(Color.parseColor(a11));
            a.f(context, Color.parseColor(a11));
        }
        Drawable r12 = uiScreen.r1(context);
        if (r12 != null) {
            bVar.getRoot().setBackground(r12);
            bVar.f33903d.setBackgroundColor(0);
        }
        String c10 = uiScreen.c();
        if (c10 != null) {
            bVar.f33904e.setControlsColor(Color.parseColor(c10));
        }
        return g10;
    }
}
