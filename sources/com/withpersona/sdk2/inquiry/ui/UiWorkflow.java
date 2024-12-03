package com.withpersona.sdk2.inquiry.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.h;
import com.squareup.workflow1.o;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HeaderButtonColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker;
import com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import okio.ByteString;

public final class UiWorkflow extends h<a, UiState, b, c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f29336a;

    /* renamed from: b  reason: collision with root package name */
    private final UiTransitionWorker.a f29337b;

    /* renamed from: c  reason: collision with root package name */
    private final UiAddressAutocompleteWorker.a f29338c;

    /* renamed from: d  reason: collision with root package name */
    private final UiAddressDetailsWorker.a f29339d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f29340a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29341b;

        /* renamed from: c  reason: collision with root package name */
        private final List<UiComponent> f29342c;

        /* renamed from: d  reason: collision with root package name */
        private final String f29343d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f29344e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f29345f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f29346g;

        /* renamed from: h  reason: collision with root package name */
        private final StepStyles$UiStepStyle f29347h;

        public a(String str, String str2, List<? extends UiComponent> list, String str3, boolean z10, boolean z11, boolean z12, StepStyles$UiStepStyle stepStyles$UiStepStyle) {
            j.g(str, "sessionToken");
            j.g(str2, "inquiryId");
            j.g(list, "components");
            j.g(str3, "stepName");
            this.f29340a = str;
            this.f29341b = str2;
            this.f29342c = list;
            this.f29343d = str3;
            this.f29344e = z10;
            this.f29345f = z11;
            this.f29346g = z12;
            this.f29347h = stepStyles$UiStepStyle;
        }

        public final boolean a() {
            return this.f29344e;
        }

        public final boolean b() {
            return this.f29345f;
        }

        public final List<UiComponent> c() {
            return this.f29342c;
        }

        public final boolean d() {
            return this.f29346g;
        }

        public final String e() {
            return this.f29341b;
        }

        public final String f() {
            return this.f29340a;
        }

        public final String g() {
            return this.f29343d;
        }

        public final StepStyles$UiStepStyle h() {
            return this.f29347h;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f29348a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.ui.UiWorkflow$b$b  reason: collision with other inner class name */
        public static final class C0333b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0333b f29349a = new C0333b();

            private C0333b() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f29350a = new c();

            private c() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class d extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f29351a;

            /* renamed from: b  reason: collision with root package name */
            private final InternalErrorInfo f29352b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str, InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                j.g(internalErrorInfo, "cause");
                this.f29351a = str;
                this.f29352b = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f29352b;
            }

            public final String b() {
                return this.f29351a;
            }
        }

        public static final class e extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final e f29353a = new e();

            private e() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            private final List<UiComponent> f29354a;

            /* renamed from: b  reason: collision with root package name */
            private final List<UiTransitionErrorResponse.UiComponentError> f29355b;

            /* renamed from: c  reason: collision with root package name */
            private final Function2<UiComponent, Map<String, ? extends ComponentParam>, Unit> f29356c;

            /* renamed from: d  reason: collision with root package name */
            private final Function0<Unit> f29357d;

            /* renamed from: e  reason: collision with root package name */
            private final Function0<Unit> f29358e;

            /* renamed from: f  reason: collision with root package name */
            private final boolean f29359f;

            /* renamed from: g  reason: collision with root package name */
            private final boolean f29360g;

            /* renamed from: h  reason: collision with root package name */
            private final Function0<Unit> f29361h;

            /* renamed from: i  reason: collision with root package name */
            private final Function2<UiComponent.InputAddress, String, Unit> f29362i;

            /* renamed from: j  reason: collision with root package name */
            private final boolean f29363j;

            /* renamed from: k  reason: collision with root package name */
            private final StepStyles$UiStepStyle f29364k;

            /* renamed from: l  reason: collision with root package name */
            private final String f29365l;

            /* renamed from: m  reason: collision with root package name */
            private final Function0<Unit> f29366m;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(List<? extends UiComponent> list, List<? extends UiTransitionErrorResponse.UiComponentError> list2, Function2<? super UiComponent, ? super Map<String, ? extends ComponentParam>, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, boolean z10, boolean z11, Function0<Unit> function03, Function2<? super UiComponent.InputAddress, ? super String, Unit> function22, boolean z12, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str, Function0<Unit> function04) {
                super((DefaultConstructorMarker) null);
                j.g(list, "components");
                j.g(list2, "componentErrors");
                j.g(function2, "onClick");
                j.g(function0, "onComplete");
                j.g(function02, "onCancel");
                j.g(function03, "onBack");
                j.g(function22, "onSuggestionSelected");
                j.g(function04, "onErrorDismissed");
                this.f29354a = list;
                this.f29355b = list2;
                this.f29356c = function2;
                this.f29357d = function0;
                this.f29358e = function02;
                this.f29359f = z10;
                this.f29360g = z11;
                this.f29361h = function03;
                this.f29362i = function22;
                this.f29363j = z12;
                this.f29364k = stepStyles$UiStepStyle;
                this.f29365l = str;
                this.f29366m = function04;
            }

            public final Drawable a(Context context) {
                j.g(context, IdentityHttpResponse.CONTEXT);
                StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f29364k;
                if (stepStyles$UiStepStyle != null) {
                    return stepStyles$UiStepStyle.r1(context);
                }
                return null;
            }

            public final boolean b() {
                return this.f29359f;
            }

            public final String c() {
                StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f29364k;
                if (stepStyles$UiStepStyle != null) {
                    return stepStyles$UiStepStyle.V1();
                }
                return null;
            }

            public final boolean d() {
                return this.f29360g;
            }

            public final List<UiTransitionErrorResponse.UiComponentError> e() {
                return this.f29355b;
            }

            public final List<UiComponent> f() {
                return this.f29354a;
            }

            public final String g() {
                return this.f29365l;
            }

            public final String h() {
                AttributeStyles$HeaderButtonColorStyle i10;
                StyleElements.SimpleElementColor a10;
                StyleElements.SimpleElementColorValue a11;
                StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f29364k;
                if (stepStyles$UiStepStyle == null || (i10 = stepStyles$UiStepStyle.i()) == null || (a10 = i10.a()) == null || (a11 = a10.a()) == null) {
                    return null;
                }
                return a11.a();
            }

            public final Function0<Unit> i() {
                return this.f29361h;
            }

            public final Function0<Unit> j() {
                return this.f29358e;
            }

            public final Function2<UiComponent, Map<String, ? extends ComponentParam>, Unit> k() {
                return this.f29356c;
            }

            public final Function0<Unit> l() {
                return this.f29357d;
            }

            public final Function0<Unit> m() {
                return this.f29366m;
            }

            public final Function2<UiComponent.InputAddress, String, Unit> n() {
                return this.f29362i;
            }

            public final StyleElements.PositionType o() {
                StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f29364k;
                if (stepStyles$UiStepStyle != null) {
                    return stepStyles$UiStepStyle.k();
                }
                return null;
            }

            public final StepStyles$UiStepStyle p() {
                return this.f29364k;
            }

            public final boolean q() {
                return this.f29363j;
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UiWorkflow(Context context, UiTransitionWorker.a aVar, UiAddressAutocompleteWorker.a aVar2, UiAddressDetailsWorker.a aVar3) {
        j.g(context, "applicationContext");
        j.g(aVar, "transitionWorker");
        j.g(aVar2, "addressAutocompleteWorker");
        j.g(aVar3, "addressDetailsWorker");
        this.f29336a = context;
        this.f29337b = aVar;
        this.f29338c = aVar2;
        this.f29339d = aVar3;
    }

    private final void k(List<? extends UiComponent> list, Function1<? super UiComponent, Unit> function1) {
        List<UiComponent> c10;
        for (UiComponent uiComponent : list) {
            if (uiComponent instanceof UiComponent.HorizontalStack) {
                UiComponent.HorizontalStack.Attributes E = ((UiComponent.HorizontalStack) uiComponent).z();
                if (!(E == null || (c10 = E.c()) == null)) {
                    k(c10, new UiWorkflow$recurse$1(function1));
                }
            } else {
                function1.invoke(uiComponent);
            }
        }
    }

    /* access modifiers changed from: private */
    public final List<UiComponent> m(List<? extends UiComponent> list, UiComponent uiComponent, UiComponent uiComponent2) {
        UiComponent.HorizontalStack.Attributes attributes;
        List<UiComponent> c10;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (UiComponent uiComponent3 : list) {
            if (uiComponent3 instanceof UiComponent.HorizontalStack) {
                UiComponent.HorizontalStack horizontalStack = (UiComponent.HorizontalStack) uiComponent3;
                UiComponent.HorizontalStack.Attributes E = horizontalStack.z();
                List<UiComponent> list2 = null;
                if (E != null) {
                    UiComponent.HorizontalStack.Attributes E2 = horizontalStack.z();
                    if (!(E2 == null || (c10 = E2.c()) == null)) {
                        list2 = m(c10, uiComponent, uiComponent2);
                    }
                    attributes = E.a(list2);
                } else {
                    attributes = null;
                }
                uiComponent3 = UiComponent.HorizontalStack.D(horizontalStack, (String) null, attributes, (UiComponent.HorizontalStackComponentStyle) null, 5, (Object) null);
            } else if (j.b(uiComponent3, uiComponent)) {
                uiComponent3 = uiComponent2;
            }
            arrayList.add(uiComponent3);
        }
        return arrayList;
    }

    /* renamed from: j */
    public UiState d(a aVar, Snapshot snapshot) {
        boolean z10;
        j.g(aVar, "props");
        if (snapshot != null) {
            ByteString b10 = snapshot.b();
            if (b10.H() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Parcelable parcelable = null;
            if (!z10) {
                b10 = null;
            }
            if (b10 != null) {
                Parcel obtain = Parcel.obtain();
                j.f(obtain, "obtain()");
                byte[] N = b10.N();
                obtain.unmarshall(N, 0, N.length);
                obtain.setDataPosition(0);
                parcelable = obtain.readParcelable(Snapshot.class.getClassLoader());
                j.d(parcelable);
                j.f(parcelable, "parcel.readParcelable<T>…class.java.classLoader)!!");
                obtain.recycle();
            }
            UiState uiState = (UiState) parcelable;
            if (uiState != null) {
                return uiState;
            }
        }
        return new UiState.Displaying(aVar.c(), aVar.g(), (List) null, aVar.h(), (String) null, 20, (DefaultConstructorMarker) null);
    }

    /* renamed from: l */
    public c f(a aVar, UiState uiState, h<? super a, UiState, ? extends b, ? extends c>.defpackage.a aVar2) {
        String E;
        String A;
        a aVar3 = aVar;
        UiState uiState2 = uiState;
        h<? super a, UiState, ? extends b, ? extends c>.defpackage.a aVar4 = aVar2;
        j.g(aVar3, "renderProps");
        j.g(uiState2, "renderState");
        j.g(aVar4, IdentityHttpResponse.CONTEXT);
        if (uiState2 instanceof UiState.Displaying) {
            UiState.Displaying displaying = (UiState.Displaying) uiState2;
            List<UiComponent> components = displaying.getComponents();
            ArrayList<UiComponent.InputAddress> arrayList = new ArrayList<>();
            for (T next : components) {
                if (next instanceof UiComponent.InputAddress) {
                    arrayList.add(next);
                }
            }
            for (UiComponent.InputAddress inputAddress : arrayList) {
                UiComponent.InputAddress.Attributes F = inputAddress.z();
                if (!(F == null || (A = F.A()) == null)) {
                    o.l(aVar4, this.f29338c.a(aVar.f(), inputAddress, A), l.k(UiAddressAutocompleteWorker.class), inputAddress.A(), new UiWorkflow$render$1$1$1(this, uiState2, inputAddress));
                }
                UiComponent.InputAddress.Attributes F2 = inputAddress.z();
                if (!(F2 == null || (E = F2.E()) == null)) {
                    o.l(aVar4, this.f29339d.a(aVar.f(), E), l.k(UiAddressDetailsWorker.class), "", new UiWorkflow$render$1$2$1(this, uiState2, inputAddress));
                }
            }
            k(displaying.getComponents(), new UiWorkflow$render$2(aVar4, this, uiState2));
            return new c.a(displaying.getComponents(), displaying.d(), new UiWorkflow$render$3(aVar4, this, uiState2), new UiWorkflow$render$4(aVar4, this), new UiWorkflow$render$5(aVar4, this, aVar3), aVar.a(), aVar.b(), new UiWorkflow$render$6(aVar4, this), new UiWorkflow$render$7(aVar4, this, uiState2), false, displaying.b(), displaying.getError(), new UiWorkflow$render$8(aVar4, this, uiState2));
        } else if (uiState2 instanceof UiState.Submitting) {
            UiState.Submitting submitting = (UiState.Submitting) uiState2;
            o.l(aVar4, this.f29337b.a(aVar.f(), aVar.e(), submitting.e(), submitting.d(), submitting.c()), l.k(UiTransitionWorker.class), "", new UiWorkflow$render$9(this, uiState2));
            return new c.a(submitting.getComponents(), submitting.a(), UiWorkflow$render$10.f29367a, UiWorkflow$render$11.f29368a, new UiWorkflow$render$12(aVar4, this), aVar.a(), aVar.b(), new UiWorkflow$render$13(aVar4, this), UiWorkflow$render$14.f29371a, true, submitting.b(), (String) null, UiWorkflow$render$15.f29372a);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: n */
    public Snapshot g(UiState uiState) {
        j.g(uiState, "state");
        return SnapshotParcelsKt.a(uiState);
    }
}
