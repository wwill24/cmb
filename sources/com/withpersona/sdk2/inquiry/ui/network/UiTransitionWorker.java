package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.s;
import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;

public final class UiTransitionWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f29499b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f29500c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f29501d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final UiComponent f29502e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, ComponentParam> f29503f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final b f29504g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final s f29505h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ui.a f29506i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ji.a f29507j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f29508a;

        /* renamed from: b  reason: collision with root package name */
        private final s f29509b;

        /* renamed from: c  reason: collision with root package name */
        private final ui.a f29510c;

        /* renamed from: d  reason: collision with root package name */
        private final ji.a f29511d;

        public a(b bVar, s sVar, ui.a aVar, ji.a aVar2) {
            kotlin.jvm.internal.j.g(bVar, "uiService");
            kotlin.jvm.internal.j.g(sVar, "moshi");
            kotlin.jvm.internal.j.g(aVar, "dataCollector");
            kotlin.jvm.internal.j.g(aVar2, "fallbackModeManager");
            this.f29508a = bVar;
            this.f29509b = sVar;
            this.f29510c = aVar;
            this.f29511d = aVar2;
        }

        public final UiTransitionWorker a(String str, String str2, UiComponent uiComponent, String str3, Map<String, ? extends ComponentParam> map) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "inquiryId");
            UiComponent uiComponent2 = uiComponent;
            kotlin.jvm.internal.j.g(uiComponent2, "triggeringComponent");
            String str4 = str3;
            kotlin.jvm.internal.j.g(str4, "fromStep");
            Map<String, ? extends ComponentParam> map2 = map;
            kotlin.jvm.internal.j.g(map2, "componentParams");
            return new UiTransitionWorker(str, str2, str4, uiComponent2, map2, this.f29508a, this.f29509b, this.f29510c, this.f29511d, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final List<UiTransitionErrorResponse.UiComponentError> f29512a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(List<? extends UiTransitionErrorResponse.UiComponentError> list) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(list, "componentErrors");
                this.f29512a = list;
            }

            public final List<UiTransitionErrorResponse.UiComponentError> a() {
                return this.f29512a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$b$b  reason: collision with other inner class name */
        public static final class C0336b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f29513a;

            /* renamed from: b  reason: collision with root package name */
            private final InternalErrorInfo.NetworkErrorInfo f29514b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0336b(String str, InternalErrorInfo.NetworkErrorInfo networkErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(networkErrorInfo, "cause");
                this.f29513a = str;
                this.f29514b = networkErrorInfo;
            }

            public final InternalErrorInfo.NetworkErrorInfo a() {
                return this.f29514b;
            }

            public final String b() {
                return this.f29513a;
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f29515a = new c();

            private c() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UiTransitionWorker(String str, String str2, String str3, UiComponent uiComponent, Map<String, ? extends ComponentParam> map, b bVar, s sVar, ui.a aVar, ji.a aVar2) {
        this.f29499b = str;
        this.f29500c = str2;
        this.f29501d = str3;
        this.f29502e = uiComponent;
        this.f29503f = map;
        this.f29504g = bVar;
        this.f29505h = sVar;
        this.f29506i = aVar;
        this.f29507j = aVar2;
    }

    public /* synthetic */ UiTransitionWorker(String str, String str2, String str3, UiComponent uiComponent, Map map, b bVar, s sVar, ui.a aVar, ji.a aVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, uiComponent, map, bVar, sVar, aVar, aVar2);
    }

    public boolean a(j<?> jVar) {
        return j.b.a(this, jVar);
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new UiTransitionWorker$run$1(this, (c<? super UiTransitionWorker$run$1>) null));
    }
}
