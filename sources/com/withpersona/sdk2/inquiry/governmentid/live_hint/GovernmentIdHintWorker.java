package com.withpersona.sdk2.inquiry.governmentid.live_hint;

import android.content.Context;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.ImageLightCondition;
import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class GovernmentIdHintWorker implements j<Hint> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f25785f = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final Context f25786b;

    /* renamed from: c  reason: collision with root package name */
    private final IdConfig.Side f25787c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25788d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final GovernmentIdFeed f25789e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f25790a;

        /* renamed from: b  reason: collision with root package name */
        private final GovernmentIdFeed f25791b;

        public b(Context context, GovernmentIdFeed governmentIdFeed) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(governmentIdFeed, "governmentIdFeed");
            this.f25790a = context;
            this.f25791b = governmentIdFeed;
        }

        public final GovernmentIdHintWorker a(IdConfig.Side side, String str) {
            kotlin.jvm.internal.j.g(side, "side");
            kotlin.jvm.internal.j.g(str, "idClassKey");
            return new GovernmentIdHintWorker(this.f25790a, side, str, this.f25791b);
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Hint f25792a;

        /* renamed from: b  reason: collision with root package name */
        private final long f25793b;

        public c(Hint hint, long j10) {
            kotlin.jvm.internal.j.g(hint, ViewHierarchyConstants.HINT_KEY);
            this.f25792a = hint;
            this.f25793b = j10;
        }

        public final Hint a() {
            return this.f25792a;
        }

        public final long b() {
            return this.f25793b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.j.b(this.f25792a, cVar.f25792a) && this.f25793b == cVar.f25793b;
        }

        public int hashCode() {
            return (this.f25792a.hashCode() * 31) + Long.hashCode(this.f25793b);
        }

        public String toString() {
            return "HintEvent(hint=" + this.f25792a + ", minDurationMs=" + this.f25793b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public GovernmentIdHintWorker(Context context, IdConfig.Side side, String str, GovernmentIdFeed governmentIdFeed) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(side, "side");
        kotlin.jvm.internal.j.g(str, "idClassKey");
        kotlin.jvm.internal.j.g(governmentIdFeed, "governmentIdFeed");
        this.f25786b = context;
        this.f25787c = side;
        this.f25788d = str;
        this.f25789e = governmentIdFeed;
    }

    /* access modifiers changed from: private */
    public final c d(ParsedIdSideOrNone parsedIdSideOrNone) {
        boolean z10;
        if (parsedIdSideOrNone instanceof ParsedIdSideOrNone.b) {
            return new c(HoldStillHint.f25797a, 1000);
        }
        ImageLightCondition a10 = parsedIdSideOrNone.a();
        if (a10 == null) {
            return null;
        }
        boolean z11 = false;
        if (a10.d() < 0.2d || a10.a() < 0.2d) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (a10.d() > 0.3d && a10.a() > 0.5d) {
            z11 = true;
        }
        if ((a10.c() >= 0.34d || z11) && (a10.c() >= 0.45d || !z10)) {
            return null;
        }
        return new c(LowLightHint.f25798a, 1000);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof GovernmentIdHintWorker) || ((GovernmentIdHintWorker) jVar).f25787c != this.f25787c) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GovernmentIdHintWorker)) {
            return false;
        }
        GovernmentIdHintWorker governmentIdHintWorker = (GovernmentIdHintWorker) obj;
        return kotlin.jvm.internal.j.b(this.f25786b, governmentIdHintWorker.f25786b) && this.f25787c == governmentIdHintWorker.f25787c && kotlin.jvm.internal.j.b(this.f25788d, governmentIdHintWorker.f25788d) && kotlin.jvm.internal.j.b(this.f25789e, governmentIdHintWorker.f25789e);
    }

    public int hashCode() {
        return (((((this.f25786b.hashCode() * 31) + this.f25787c.hashCode()) * 31) + this.f25788d.hashCode()) * 31) + this.f25789e.hashCode();
    }

    public kotlinx.coroutines.flow.b<Hint> run() {
        return d.m(d.v(new GovernmentIdHintWorker$run$1(d.v(new GovernmentIdHintWorker$run$hintFlow$1(this, (kotlin.coroutines.c<? super GovernmentIdHintWorker$run$hintFlow$1>) null)), (kotlin.coroutines.c<? super GovernmentIdHintWorker$run$1>) null)));
    }

    public String toString() {
        return "GovernmentIdHintWorker(context=" + this.f25786b + ", side=" + this.f25787c + ", idClassKey=" + this.f25788d + ", governmentIdFeed=" + this.f25789e + PropertyUtils.MAPPED_DELIM2;
    }
}
