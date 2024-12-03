package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import com.withpersona.sdk2.camera.SelfieDirectionFeed;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.x0;

public final class SelfieAnalyzeWorker implements j<c> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f27192f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f27193b;

    /* renamed from: c  reason: collision with root package name */
    private final SelfieDirectionFeed f27194c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Selfie.Direction f27195d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f27196e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f27201a;

        /* renamed from: b  reason: collision with root package name */
        private final SelfieDirectionFeed f27202b;

        public b(Context context, SelfieDirectionFeed selfieDirectionFeed) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(selfieDirectionFeed, "selfieDirectionFeed");
            this.f27201a = context;
            this.f27202b = selfieDirectionFeed;
        }

        public final SelfieAnalyzeWorker a(Selfie.Direction direction) {
            kotlin.jvm.internal.j.g(direction, "direction");
            return new SelfieAnalyzeWorker(this.f27201a, this.f27202b, direction);
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f27203a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            private final Selfie f27204a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Selfie selfie) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(selfie, "selfie");
                this.f27204a = selfie;
            }

            public final Selfie a() {
                return this.f27204a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$c  reason: collision with other inner class name */
        public static final class C0326c extends c {

            /* renamed from: a  reason: collision with root package name */
            private final SelfieError f27205a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0326c(SelfieError selfieError) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(selfieError, "error");
                this.f27205a = selfieError;
            }

            public final SelfieError a() {
                return this.f27205a;
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SelfieAnalyzeWorker(Context context, SelfieDirectionFeed selfieDirectionFeed, Selfie.Direction direction) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(selfieDirectionFeed, "selfieDirectionFeed");
        kotlin.jvm.internal.j.g(direction, "direction");
        this.f27193b = context;
        this.f27194c = selfieDirectionFeed;
        this.f27195d = direction;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof SelfieAnalyzeWorker) || ((SelfieAnalyzeWorker) jVar).f27195d != this.f27195d) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<c> run() {
        return d.y(new SelfieAnalyzeWorker$run$$inlined$mapNotNull$1(d.n(this.f27194c, 1), this), x0.a());
    }
}
