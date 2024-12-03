package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.camera.SelfieDirectionFeed;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.x0;
import org.apache.commons.beanutils.PropertyUtils;

public final class SelfieDetectWorker implements j<a> {

    /* renamed from: b  reason: collision with root package name */
    private final SelfieDirectionFeed f27213b;

    public static abstract class a {

        /* renamed from: com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$a$a  reason: collision with other inner class name */
        public static final class C0327a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final SelfieError f27218a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0327a(SelfieError selfieError) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(selfieError, "error");
                this.f27218a = selfieError;
            }

            public final SelfieError a() {
                return this.f27218a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0327a) && this.f27218a == ((C0327a) obj).f27218a;
            }

            public int hashCode() {
                return this.f27218a.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.f27218a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f27219a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SelfieDetectWorker(SelfieDirectionFeed selfieDirectionFeed) {
        kotlin.jvm.internal.j.g(selfieDirectionFeed, "selfieDirectionFeed");
        this.f27213b = selfieDirectionFeed;
    }

    /* access modifiers changed from: private */
    public final a.C0327a c(SelfieError selfieError) {
        return new a.C0327a(selfieError);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        return jVar instanceof SelfieDetectWorker;
    }

    public b<a> run() {
        return d.y(d.l(d.m(new SelfieDetectWorker$run$$inlined$map$1(this.f27213b, this)), 200), x0.a());
    }
}
