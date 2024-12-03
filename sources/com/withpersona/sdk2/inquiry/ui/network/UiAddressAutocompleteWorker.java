package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;

public final class UiAddressAutocompleteWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f29462b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final UiComponent f29463c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f29464d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final b f29465e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f29466a;

        public a(b bVar) {
            kotlin.jvm.internal.j.g(bVar, "uiService");
            this.f29466a = bVar;
        }

        public final UiAddressAutocompleteWorker a(String str, UiComponent uiComponent, String str2) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(uiComponent, "triggeringComponent");
            kotlin.jvm.internal.j.g(str2, "addressText");
            return new UiAddressAutocompleteWorker(str, uiComponent, str2, this.f29466a, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f29467a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f29467a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f29467a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$b$b  reason: collision with other inner class name */
        public static final class C0334b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final List<Suggestion> f29468a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0334b(List<Suggestion> list) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(list, "results");
                this.f29468a = list;
            }

            public final List<Suggestion> a() {
                return this.f29468a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UiAddressAutocompleteWorker(String str, UiComponent uiComponent, String str2, b bVar) {
        this.f29462b = str;
        this.f29463c = uiComponent;
        this.f29464d = str2;
        this.f29465e = bVar;
    }

    public /* synthetic */ UiAddressAutocompleteWorker(String str, UiComponent uiComponent, String str2, b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uiComponent, str2, bVar);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof UiAddressAutocompleteWorker) || !kotlin.jvm.internal.j.b(this.f29464d, ((UiAddressAutocompleteWorker) jVar).f29464d)) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new UiAddressAutocompleteWorker$run$1(this, (c<? super UiAddressAutocompleteWorker$run$1>) null));
    }
}
