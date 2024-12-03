package com.withpersona.sdk2.inquiry.governmentid.nfc;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import coil.ImageLoader;
import coil.request.g;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.a;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcConfirmDetailsPage;
import com.withpersona.sdk2.inquiry.governmentid.i0;
import com.withpersona.sdk2.inquiry.governmentid.j0;
import com.withpersona.sdk2.inquiry.governmentid.o0;
import com.withpersona.sdk2.inquiry.nfc.PassportInfo;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.steps.ui.UiScreen;
import com.withpersona.sdk2.inquiry.steps.ui.m;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import vi.b;

public final class PassportNfcConfirmDetailsView implements a<PassportNfcConfirmDetailsView> {

    /* renamed from: a  reason: collision with root package name */
    private final UiScreen f25913a;

    /* renamed from: b  reason: collision with root package name */
    private final PassportNfcConfirmDetailsPage f25914b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25915c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f25916d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25917e;

    /* renamed from: f  reason: collision with root package name */
    private final Function0<Unit> f25918f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f25919g;

    /* renamed from: h  reason: collision with root package name */
    private final Function0<Unit> f25920h;

    /* renamed from: j  reason: collision with root package name */
    private final PassportInfo f25921j;

    /* renamed from: k  reason: collision with root package name */
    private final ImageLoader f25922k;

    public PassportNfcConfirmDetailsView(UiScreen uiScreen, PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage, boolean z10, Function0<Unit> function0, boolean z11, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, PassportInfo passportInfo, ImageLoader imageLoader) {
        j.g(uiScreen, "uiScreen");
        j.g(passportNfcConfirmDetailsPage, "passportNfcConfirmDetailsPage");
        j.g(function0, "onBack");
        j.g(function02, "onCancel");
        j.g(function03, "onNext");
        j.g(function04, "onRetry");
        j.g(passportInfo, "passportInfo");
        j.g(imageLoader, "imageLoader");
        this.f25913a = uiScreen;
        this.f25914b = passportNfcConfirmDetailsPage;
        this.f25915c = z10;
        this.f25916d = function0;
        this.f25917e = z11;
        this.f25918f = function02;
        this.f25919g = function03;
        this.f25920h = function04;
        this.f25921j = passportInfo;
        this.f25922k = imageLoader;
    }

    /* access modifiers changed from: private */
    public final void h(b bVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View view;
        ImageView imageView;
        UiComponent uiComponent;
        UiComponent.CombinedStepImagePreview combinedStepImagePreview;
        Context context = bVar.getRoot().getContext();
        com.withpersona.sdk2.inquiry.steps.ui.a aVar = map.get(this.f25914b.h());
        UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle = null;
        if (aVar != null) {
            view = aVar.d();
        } else {
            view = null;
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        if (aVar != null) {
            uiComponent = aVar.c();
        } else {
            uiComponent = null;
        }
        if (uiComponent instanceof UiComponent.CombinedStepImagePreview) {
            combinedStepImagePreview = (UiComponent.CombinedStepImagePreview) uiComponent;
        } else {
            combinedStepImagePreview = null;
        }
        if (combinedStepImagePreview != null) {
            combinedStepImagePreviewComponentStyle = combinedStepImagePreview.D();
        }
        if (combinedStepImagePreviewComponentStyle == null) {
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.height = context.getResources().getDimensionPixelSize(j0.pi2_passport_nfc_image_preview_height);
                    imageView.setLayoutParams(marginLayoutParams);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
            if (imageView != null) {
                imageView.setBackground(new ColorDrawable(context.getColor(i0.pi2_review_upload_background)));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void i(b bVar, PassportNfcConfirmDetailsView passportNfcConfirmDetailsView, p pVar, Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map) {
        View view;
        ImageView imageView;
        View view2;
        TextView textView;
        View view3;
        TextView textView2;
        View view4;
        TextView textView3;
        View view5;
        TextView textView4;
        View view6;
        TextView textView5;
        View view7;
        TextView textView6;
        View view8;
        TextView textView7;
        View view9;
        TextView textView8;
        View view10;
        TextView textView9;
        View view11;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        View view12;
        String str;
        String str2;
        PassportNfcConfirmDetailsView passportNfcConfirmDetailsView2 = passportNfcConfirmDetailsView;
        Map<String, com.withpersona.sdk2.inquiry.steps.ui.a> map2 = map;
        Context context = bVar.getRoot().getContext();
        PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage = passportNfcConfirmDetailsView2.f25914b;
        com.withpersona.sdk2.inquiry.steps.ui.a aVar = map2.get(passportNfcConfirmDetailsPage.h());
        View view13 = null;
        if (aVar != null) {
            view = aVar.d();
        } else {
            view = null;
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar2 = map2.get(passportNfcConfirmDetailsPage.l());
        if (aVar2 != null) {
            view2 = aVar2.d();
        } else {
            view2 = null;
        }
        if (view2 instanceof TextView) {
            textView = (TextView) view2;
        } else {
            textView = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar3 = map2.get(passportNfcConfirmDetailsPage.d());
        if (aVar3 != null) {
            view3 = aVar3.d();
        } else {
            view3 = null;
        }
        if (view3 instanceof TextView) {
            textView2 = (TextView) view3;
        } else {
            textView2 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar4 = map2.get(passportNfcConfirmDetailsPage.e());
        if (aVar4 != null) {
            view4 = aVar4.d();
        } else {
            view4 = null;
        }
        if (view4 instanceof TextView) {
            textView3 = (TextView) view4;
        } else {
            textView3 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar5 = map2.get(passportNfcConfirmDetailsPage.f());
        if (aVar5 != null) {
            view5 = aVar5.d();
        } else {
            view5 = null;
        }
        if (view5 instanceof TextView) {
            textView4 = (TextView) view5;
        } else {
            textView4 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar6 = map2.get(passportNfcConfirmDetailsPage.j());
        if (aVar6 != null) {
            view6 = aVar6.d();
        } else {
            view6 = null;
        }
        if (view6 instanceof TextView) {
            textView5 = (TextView) view6;
        } else {
            textView5 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar7 = map2.get(passportNfcConfirmDetailsPage.g());
        if (aVar7 != null) {
            view7 = aVar7.d();
        } else {
            view7 = null;
        }
        if (view7 instanceof TextView) {
            textView6 = (TextView) view7;
        } else {
            textView6 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar8 = map2.get(passportNfcConfirmDetailsPage.i());
        if (aVar8 != null) {
            view8 = aVar8.d();
        } else {
            view8 = null;
        }
        if (view8 instanceof TextView) {
            textView7 = (TextView) view8;
        } else {
            textView7 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar9 = map2.get(passportNfcConfirmDetailsPage.k());
        if (aVar9 != null) {
            view9 = aVar9.d();
        } else {
            view9 = null;
        }
        if (view9 instanceof TextView) {
            textView8 = (TextView) view9;
        } else {
            textView8 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar10 = map2.get(passportNfcConfirmDetailsPage.a());
        if (aVar10 != null) {
            view10 = aVar10.d();
        } else {
            view10 = null;
        }
        if (view10 instanceof TextView) {
            textView9 = (TextView) view10;
        } else {
            textView9 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar11 = map2.get(passportNfcConfirmDetailsPage.c());
        if (aVar11 != null) {
            view11 = aVar11.d();
        } else {
            view11 = null;
        }
        com.withpersona.sdk2.inquiry.steps.ui.a aVar12 = map2.get(passportNfcConfirmDetailsPage.m());
        if (aVar12 != null) {
            view13 = aVar12.d();
        }
        DateFormat dateInstance = DateFormat.getDateInstance();
        Date a10 = passportNfcConfirmDetailsView2.f25921j.a();
        View view14 = view13;
        Date c10 = passportNfcConfirmDetailsView2.f25921j.c();
        if (imageView != null) {
            view12 = view11;
            File a11 = androidx.core.net.b.a(passportNfcConfirmDetailsView2.f25921j.f());
            textView13 = textView9;
            BitmapFactory.Options options = new BitmapFactory.Options();
            textView12 = textView8;
            options.inJustDecodeBounds = true;
            ImageLoader imageLoader = passportNfcConfirmDetailsView2.f25922k;
            textView11 = textView7;
            textView10 = textView6;
            g.a p10 = new g.a(imageView.getContext()).d(a11).p(imageView);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setSize(options.outWidth, options.outHeight);
            gradientDrawable.setColor(0);
            p10.g(gradientDrawable);
            imageLoader.a(p10.a());
        } else {
            textView10 = textView6;
            textView11 = textView7;
            textView12 = textView8;
            textView13 = textView9;
            view12 = view11;
        }
        if (textView != null) {
            textView.setText(passportNfcConfirmDetailsView2.f25921j.j());
        }
        if (textView2 != null) {
            if (a10 != null) {
                str2 = dateInstance.format(a10);
            } else {
                str2 = context.getString(o0.pi2_passport_nfc_field_unknown);
            }
            textView2.setText(str2);
        }
        if (textView3 != null) {
            if (c10 != null) {
                str = dateInstance.format(c10);
            } else {
                str = context.getString(o0.pi2_passport_nfc_field_unknown);
            }
            textView3.setText(str);
        }
        if (textView4 != null) {
            textView4.setText(passportNfcConfirmDetailsView2.f25921j.d());
        }
        if (textView5 != null) {
            textView5.setText(passportNfcConfirmDetailsView2.f25921j.h());
        }
        if (textView10 != null) {
            textView10.setText(passportNfcConfirmDetailsView2.f25921j.e());
        }
        if (textView11 != null) {
            textView11.setText(passportNfcConfirmDetailsView2.f25921j.g());
        }
        if (textView12 != null) {
            textView12.setText(passportNfcConfirmDetailsView2.f25921j.i());
        }
        if (textView13 != null) {
            String k10 = passportNfcConfirmDetailsView2.f25921j.k();
            if (k10 == null) {
                k10 = context.getString(o0.pi2_passport_nfc_field_unknown);
            }
            textView13.setText(k10);
        }
        if (view12 != null) {
            view12.setOnClickListener(new a(passportNfcConfirmDetailsView2));
        }
        if (view14 != null) {
            view14.setOnClickListener(new b(passportNfcConfirmDetailsView2));
        }
        bVar.f33904e.setState(new NavigationUiState(passportNfcConfirmDetailsView2.f25915c, new PassportNfcConfirmDetailsView$showRendering$1$4(passportNfcConfirmDetailsView2), passportNfcConfirmDetailsView2.f25917e, new PassportNfcConfirmDetailsView$showRendering$1$5(passportNfcConfirmDetailsView2)));
    }

    /* access modifiers changed from: private */
    public static final void j(PassportNfcConfirmDetailsView passportNfcConfirmDetailsView, View view) {
        j.g(passportNfcConfirmDetailsView, "$this_with");
        passportNfcConfirmDetailsView.f25919g.invoke();
    }

    /* access modifiers changed from: private */
    public static final void k(PassportNfcConfirmDetailsView passportNfcConfirmDetailsView, View view) {
        j.g(passportNfcConfirmDetailsView, "$this_with");
        passportNfcConfirmDetailsView.f25920h.invoke();
    }

    public r<PassportNfcConfirmDetailsView> a() {
        m mVar = m.f27597a;
        UiScreen uiScreen = this.f25913a;
        PassportNfcConfirmDetailsView$viewFactory$1 passportNfcConfirmDetailsView$viewFactory$1 = new PassportNfcConfirmDetailsView$viewFactory$1(this);
        PassportNfcConfirmDetailsView$viewFactory$2 passportNfcConfirmDetailsView$viewFactory$2 = new PassportNfcConfirmDetailsView$viewFactory$2(this);
        f.a aVar = f.f23238a;
        return new ViewBindingViewFactory(l.b(PassportNfcConfirmDetailsView.class), PassportNfcConfirmDetailsView$special$$inlined$getViewFactoryForScreen$1.f25923a, new PassportNfcConfirmDetailsView$special$$inlined$getViewFactoryForScreen$2(uiScreen, passportNfcConfirmDetailsView$viewFactory$1, passportNfcConfirmDetailsView$viewFactory$2));
    }

    public final Function0<Unit> f() {
        return this.f25916d;
    }

    public final Function0<Unit> g() {
        return this.f25918f;
    }
}
