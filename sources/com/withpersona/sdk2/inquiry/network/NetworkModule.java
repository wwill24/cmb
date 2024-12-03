package com.withpersona.sdk2.inquiry.network;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.h;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.shared.device.a;
import com.withpersona.sdk2.inquiry.shared.device.c;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.x;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import retrofit2.s;

public final class NetworkModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean useServerStyle;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<h.e> provideMoshiJsonAdapterFactory() {
            return n0.i(ErrorResponse.Companion.getAdapter(), InternalErrorInfo.Companion.createAdapter());
        }
    }

    public NetworkModule(boolean z10) {
        this.useServerStyle = z10;
    }

    /* access modifiers changed from: private */
    public static final a0 interceptor$lambda$3(s sVar, u.a aVar) {
        String str = "";
        Class<ErrorResponse> cls = ErrorResponse.class;
        j.g(sVar, "$moshi");
        j.g(aVar, "chain");
        try {
            return aVar.a(aVar.g());
        } catch (ConnectException e10) {
            a0.a g10 = new a0.a().s(aVar.g()).q(Protocol.HTTP_2).g(0);
            String localizedMessage = e10.getLocalizedMessage();
            if (localizedMessage != null) {
                str = localizedMessage;
            }
            a0.a n10 = g10.n(str);
            b0.b bVar = b0.Companion;
            v a10 = v.f33190e.a("application/json");
            String json = sVar.c(cls).toJson(ErrorResponse.Companion.create(e10.getLocalizedMessage()));
            j.f(json, "moshi.adapter(ErrorRespo…le = e.localizedMessage))");
            return n10.b(bVar.c(a10, json)).c();
        } catch (UnknownHostException e11) {
            a0.a g11 = new a0.a().s(aVar.g()).q(Protocol.HTTP_2).g(0);
            String localizedMessage2 = e11.getLocalizedMessage();
            if (localizedMessage2 != null) {
                str = localizedMessage2;
            }
            a0.a n11 = g11.n(str);
            b0.b bVar2 = b0.Companion;
            v a11 = v.f33190e.a("application/json");
            String json2 = sVar.c(cls).toJson(ErrorResponse.Companion.create(e11.getLocalizedMessage()));
            j.f(json2, "moshi.adapter(ErrorRespo…le = e.localizedMessage))");
            return n11.b(bVar2.c(a11, json2)).c();
        } catch (SocketTimeoutException e12) {
            a0.a g12 = new a0.a().s(aVar.g()).q(Protocol.HTTP_2).g(0);
            String localizedMessage3 = e12.getLocalizedMessage();
            if (localizedMessage3 != null) {
                str = localizedMessage3;
            }
            a0.a n12 = g12.n(str);
            b0.b bVar3 = b0.Companion;
            v a12 = v.f33190e.a("application/json");
            String json3 = sVar.c(cls).toJson(ErrorResponse.Companion.create(e12.getLocalizedMessage()));
            j.f(json3, "moshi.adapter(ErrorRespo…le = e.localizedMessage))");
            return n12.b(bVar3.c(a12, json3)).c();
        } catch (IOException e13) {
            a0.a g13 = new a0.a().s(aVar.g()).q(Protocol.HTTP_2).g(0);
            String localizedMessage4 = e13.getLocalizedMessage();
            if (localizedMessage4 != null) {
                str = localizedMessage4;
            }
            a0.a n13 = g13.n(str);
            b0.b bVar4 = b0.Companion;
            v a13 = v.f33190e.a("application/json");
            String json4 = sVar.c(cls).toJson(ErrorResponse.Companion.create(e13.getLocalizedMessage()));
            j.f(json4, "moshi.adapter(ErrorRespo…le = e.localizedMessage))");
            return n13.b(bVar4.c(a13, json4)).c();
        }
    }

    public static final Set<h.e> provideMoshiJsonAdapterFactory() {
        return Companion.provideMoshiJsonAdapterFactory();
    }

    public final u interceptor(s sVar) {
        j.g(sVar, "moshi");
        return new a(sVar);
    }

    public final String keyInflection() {
        return "camel";
    }

    public final s moshi(Set<Object> set, Set<JsonAdapterBinding<?>> set2, Set<h.e> set3) {
        j.g(set, "jsonAdapters");
        j.g(set2, "jsonAdapterBindings");
        j.g(set3, "jsonAdapterFactory");
        s.b bVar = new s.b();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            bVar.b(it.next());
        }
        for (JsonAdapterBinding jsonAdapterBinding : set2) {
            bVar.c(jsonAdapterBinding.getClazz(), jsonAdapterBinding.getJsonAdapter());
        }
        for (h.e a10 : set3) {
            bVar.a(a10);
        }
        s d10 = bVar.d();
        j.f(d10, "Builder()\n    .also { bu….add(it) } }\n    .build()");
        return d10;
    }

    public final x okhttpClient(Set<u> set, Map<String, String> map, Context context, a aVar, c cVar) {
        j.g(set, "interceptors");
        j.g(map, HeadersExtension.ELEMENT);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "appSetIDHelper");
        j.g(cVar, "deviceInfoProvider");
        x.a b10 = new x.a().b(new NetworkModule$okhttpClient$$inlined$addNetworkInterceptor$1(cVar, aVar, context, map));
        TimeUnit timeUnit = TimeUnit.MINUTES;
        x.a d10 = b10.J(1, timeUnit).O(1, timeUnit).d(1, timeUnit);
        for (u a10 : set) {
            d10.a(a10);
        }
        return d10.c();
    }

    public final retrofit2.s retrofit(String str, x xVar, s sVar) {
        j.g(str, "serverEndpoint");
        j.g(xVar, "okHttpClient");
        j.g(sVar, "moshi");
        retrofit2.s e10 = new s.b().g(xVar).c(str).b(un.a.f(sVar)).e();
        j.f(e10, "Builder()\n    .client(ok…eate(moshi))\n    .build()");
        return e10;
    }

    public final String useServerStyles() {
        return String.valueOf(this.useServerStyle);
    }
}
