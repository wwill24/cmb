package c8;

import android.net.Uri;
import android.text.TextUtils;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$InstagramError;
import com.coffeemeetsbagel.feature.instagram.a;
import com.coffeemeetsbagel.feature.instagram.api.endpoints.CmbInstagramService;
import com.coffeemeetsbagel.feature.instagram.api.endpoints.InstagramService;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramEnvelope;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import com.coffeemeetsbagel.feature.instagram.b;
import com.coffeemeetsbagel.models.EmptyBodyObject;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.r;
import retrofit2.s;

public class a implements com.coffeemeetsbagel.feature.instagram.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f7972a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7973b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7974c;

    /* renamed from: d  reason: collision with root package name */
    private final Pattern f7975d;

    /* renamed from: e  reason: collision with root package name */
    private final Pattern f7976e;

    /* renamed from: f  reason: collision with root package name */
    private final s f7977f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final InstagramService f7978g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final d f7979h;

    /* renamed from: i  reason: collision with root package name */
    private final c7.d f7980i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f7981j;

    /* renamed from: c8.a$a  reason: collision with other inner class name */
    class C0095a extends c<InstagramMediaItem[]> {
        C0095a(b.a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: protected */
        public void c() {
            a.this.f7978g.getRecentMedia(a.this.f7981j).L(this.f7985g);
        }

        /* access modifiers changed from: protected */
        public void d(String str) {
            a.this.f7978g.getRecentMediaPaging(str).L(this.f7985g);
        }
    }

    class b implements retrofit2.d<ResponseSocialMedia> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0137a f7983a;

        b(a.C0137a aVar) {
            this.f7983a = aVar;
        }

        public void onFailure(retrofit2.b<ResponseSocialMedia> bVar, Throwable th2) {
            this.f7983a.a();
        }

        public void onResponse(retrofit2.b<ResponseSocialMedia> bVar, r<ResponseSocialMedia> rVar) {
            if (rVar.g()) {
                this.f7983a.b(rVar.a());
            } else {
                this.f7983a.a();
            }
        }
    }

    private abstract class c<T> extends b<T> {

        /* renamed from: g  reason: collision with root package name */
        retrofit2.d<InstagramEnvelope<T>> f7985g = new C0096a();

        /* renamed from: c8.a$c$a  reason: collision with other inner class name */
        class C0096a implements retrofit2.d<InstagramEnvelope<T>> {
            C0096a() {
            }

            public void onFailure(retrofit2.b<InstagramEnvelope<T>> bVar, Throwable th2) {
                c.this.e(InstagramContract$InstagramError.GENERIC);
            }

            public void onResponse(retrofit2.b<InstagramEnvelope<T>> bVar, r<InstagramEnvelope<T>> rVar) {
                if (rVar.g()) {
                    c.this.f(rVar.a());
                    return;
                }
                c cVar = c.this;
                cVar.e(cVar.g(rVar));
            }
        }

        c(b.a<T, InstagramContract$InstagramError> aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public InstagramContract$InstagramError g(r<InstagramEnvelope<T>> rVar) {
            InstagramContract$InstagramError instagramContract$InstagramError = InstagramContract$InstagramError.GENERIC;
            try {
                InstagramEnvelope.Meta meta = ((InstagramEnvelope) a.this.f7979h.k(rVar.e().string(), InstagramEnvelope.class)).meta;
                if (meta == null || !"OAuthAccessTokenException".equals(meta.errorType)) {
                    return instagramContract$InstagramError;
                }
                return InstagramContract$InstagramError.NOT_AUTHORIZED;
            } catch (IOException e10) {
                fa.a.i(e10);
                return instagramContract$InstagramError;
            } catch (IllegalStateException e11) {
                fa.a.i(e11);
                return instagramContract$InstagramError;
            }
        }
    }

    public a(c7.d dVar) {
        this("https://api.instagram.com/", "e0c3fac7439f44e6aeb82012e4f61d94", "https://coffeemeetsbagel.com/instagram", dVar);
    }

    private CmbInstagramService k() {
        return (CmbInstagramService) this.f7980i.c(CmbInstagramService.class);
    }

    private Map<String, String> l(String str) {
        HashMap hashMap = new HashMap();
        Uri parse = Uri.parse(str);
        for (String next : parse.getQueryParameterNames()) {
            hashMap.put(next, parse.getQueryParameter(next));
        }
        return hashMap;
    }

    public String a() {
        try {
            return this.f7972a + String.format("oauth/authorize/?client_id=%s&redirect_uri=%s&response_type=token", new Object[]{this.f7973b, URLEncoder.encode(this.f7974c, "utf-8")});
        } catch (UnsupportedEncodingException unused) {
            ha.a.b("unsupported encoding exception due to insta auth url");
            return null;
        }
    }

    public boolean b(String str) {
        if (this.f7976e.matcher(str).matches()) {
            return !TextUtils.isEmpty(l(str).get("error"));
        }
        return false;
    }

    public void c(String str) {
        this.f7981j = str;
    }

    public void d(a.C0137a aVar) {
        k().recordFollow(new EmptyBodyObject()).L(new b(aVar));
    }

    public com.coffeemeetsbagel.feature.instagram.b<InstagramMediaItem[], InstagramContract$InstagramError> e(b.a<InstagramMediaItem[], InstagramContract$InstagramError> aVar) {
        return new C0095a(aVar);
    }

    public String f(String str) {
        Matcher matcher = this.f7975d.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public boolean g(String str) {
        if (!this.f7976e.matcher(str).matches()) {
            return false;
        }
        Map<String, String> l10 = l(str);
        boolean equals = "access_denied".equals(l10.get("error"));
        boolean equals2 = "user_denied".equals(l10.get("error_reason"));
        if (!equals || !equals2) {
            return false;
        }
        return true;
    }

    public a(String str, String str2, String str3, c7.d dVar) {
        this.f7972a = str;
        this.f7973b = str2;
        this.f7974c = str3;
        this.f7980i = dVar;
        this.f7975d = Pattern.compile(str3 + "\\#access_token=(.*)");
        this.f7976e = Pattern.compile(str3 + ".*");
        d b10 = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();
        this.f7979h = b10;
        s e10 = new s.b().c(str).b(tn.a.f(b10)).e();
        this.f7977f = e10;
        this.f7978g = (InstagramService) e10.b(InstagramService.class);
    }
}
