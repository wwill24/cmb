package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class UiAddressDetailsWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f29469b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f29470c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f29471d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f29472a;

        public a(b bVar) {
            kotlin.jvm.internal.j.g(bVar, "uiService");
            this.f29472a = bVar;
        }

        public final UiAddressDetailsWorker a(String str, String str2) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "addressId");
            return new UiAddressDetailsWorker(str, str2, this.f29472a, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f29473a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f29473a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f29473a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker$b$b  reason: collision with other inner class name */
        public static final class C0335b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final LocationData f29474a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0335b(LocationData locationData) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(locationData, MamElements.MamResultExtension.ELEMENT);
                this.f29474a = locationData;
            }

            public final LocationData a() {
                return this.f29474a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UiAddressDetailsWorker(String str, String str2, b bVar) {
        this.f29469b = str;
        this.f29470c = str2;
        this.f29471d = bVar;
    }

    public /* synthetic */ UiAddressDetailsWorker(String str, String str2, b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bVar);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof UiAddressDetailsWorker) || !kotlin.jvm.internal.j.b(this.f29470c, ((UiAddressDetailsWorker) jVar).f29470c)) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new UiAddressDetailsWorker$run$1(this, (c<? super UiAddressDetailsWorker$run$1>) null));
    }
}
