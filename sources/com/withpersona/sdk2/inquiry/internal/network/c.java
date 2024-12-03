package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.h;
import com.squareup.workflow1.ui.ViewRegistryKt;
import com.squareup.workflow1.ui.backstack.BackStackContainer;
import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.s;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.governmentid.network.b;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryFieldMap;
import com.withpersona.sdk2.inquiry.internal.InquiryInitializingRunner;
import com.withpersona.sdk2.inquiry.internal.network.CreateInquiryRequest;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.internal.ui.DisableableContainer;
import com.withpersona.sdk2.inquiry.network.JsonAdapterBinding;
import com.withpersona.sdk2.inquiry.shared.ui.ScreenWithTransitionContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean;
import com.withpersona.sdk2.inquiry.steps.ui.network.NumberAdapter;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26899b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f26900a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<Object> a() {
            return n0.i(CreateInquiryRequest.Data.f26424c, ComponentParam.Adapter.f29416a, InquiryFieldMap.f26121b, NextStep.GovernmentId.SelectPage.f26657f, NextStep.GovernmentId.PassportNfcOption.Companion, NextStep.GovernmentId.CaptureFileType.Companion, NextStep.Selfie.CaptureFileType.Companion, UiComponent.Button.ButtonType.Companion, UiComponent.InputText.InputType.Companion, UiComponent.InputText.AutofillHint.Companion, UiComponent.RemoteImage.ContentType.Companion, UiTransitionErrorResponse.UiComponentError.f29482a, StyleElements.PositionType.Companion, StyleElements.ComplexElementColor.f29173f, StyleElements.DPSize.f29181c, StyleElements.Size.f29194a, StyleElements.FontName.f29187b, StyleElements.FontWeight.Companion, StyleElements.Axis.Companion, JsonLogicBoolean.f27598c, NumberAdapter.f27603a);
        }

        public final Set<JsonAdapterBinding<?>> b() {
            return n0.e();
        }

        public final Set<h.e> c() {
            return n0.i(NextStep.f26465b.a(), UiComponent.f27604b.a(), UiComponent.LocalImage.f27941f.b(), InquiryField.f26099b.a(), Id.f25837f.b());
        }

        public final Set<r<?>> d() {
            return n0.i(InquiryInitializingRunner.f26148f, BackStackContainer.f23221c, DisableableContainer.f26920c, ScreenWithTransitionContainer.f27516c);
        }

        public final String e() {
            return "Persona/1.0 (Android) Inquiry/2.6.0";
        }

        public final s f(Set<r<?>> set) {
            j.g(set, "viewBindings");
            r[] rVarArr = (r[]) set.toArray(new r[0]);
            return ViewRegistryKt.b((r[]) Arrays.copyOf(rVarArr, rVarArr.length));
        }
    }

    public c(String str) {
        j.g(str, "serverEndpoint");
        this.f26900a = str;
    }

    public static final Set<Object> d() {
        return f26899b.a();
    }

    public static final Set<JsonAdapterBinding<?>> e() {
        return f26899b.b();
    }

    public static final Set<h.e> f() {
        return f26899b.c();
    }

    public static final Set<r<?>> g() {
        return f26899b.d();
    }

    public static final s k(Set<r<?>> set) {
        return f26899b.f(set);
    }

    public final com.withpersona.sdk2.inquiry.document.network.a a(retrofit2.s sVar) {
        j.g(sVar, "retrofit");
        Object b10 = sVar.b(com.withpersona.sdk2.inquiry.document.network.a.class);
        j.f(b10, "retrofit.create(DocumentService::class.java)");
        return (com.withpersona.sdk2.inquiry.document.network.a) b10;
    }

    public final b b(retrofit2.s sVar) {
        j.g(sVar, "retrofit");
        Object b10 = sVar.b(b.class);
        j.f(b10, "retrofit.create(GovernmentIdService::class.java)");
        return (b) b10;
    }

    public final p c(retrofit2.s sVar) {
        j.g(sVar, "retrofit");
        Object b10 = sVar.b(p.class);
        j.f(b10, "retrofit.create(InquiryService::class.java)");
        return (p) b10;
    }

    public final com.withpersona.sdk2.inquiry.selfie.network.a h(retrofit2.s sVar) {
        j.g(sVar, "retrofit");
        Object b10 = sVar.b(com.withpersona.sdk2.inquiry.selfie.network.a.class);
        j.f(b10, "retrofit.create(SelfieService::class.java)");
        return (com.withpersona.sdk2.inquiry.selfie.network.a) b10;
    }

    public final String i() {
        return this.f26900a;
    }

    public final com.withpersona.sdk2.inquiry.ui.network.b j(retrofit2.s sVar) {
        j.g(sVar, "retrofit");
        Object b10 = sVar.b(com.withpersona.sdk2.inquiry.ui.network.b.class);
        j.f(b10, "retrofit.create(\n    UiService::class.java\n  )");
        return (com.withpersona.sdk2.inquiry.ui.network.b) b10;
    }
}
