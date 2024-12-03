package p9;

import c7.d;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;
import p9.c;
import retrofit2.r;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d f17066a;

    /* renamed from: b  reason: collision with root package name */
    private e f17067b;

    class a implements retrofit2.d<ResponseSocialMedia> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.a f17068a;

        a(c.a aVar) {
            this.f17068a = aVar;
        }

        public void onFailure(retrofit2.b<ResponseSocialMedia> bVar, Throwable th2) {
            this.f17068a.onFailure();
        }

        public void onResponse(retrofit2.b<ResponseSocialMedia> bVar, r<ResponseSocialMedia> rVar) {
            if (rVar.g()) {
                this.f17068a.a(rVar.a());
            } else {
                this.f17068a.onFailure();
            }
        }
    }

    /* renamed from: p9.b$b  reason: collision with other inner class name */
    class C0190b implements retrofit2.d<ResponseSocialMedia> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.a f17070a;

        C0190b(c.a aVar) {
            this.f17070a = aVar;
        }

        public void onFailure(retrofit2.b<ResponseSocialMedia> bVar, Throwable th2) {
            this.f17070a.onFailure();
        }

        public void onResponse(retrofit2.b<ResponseSocialMedia> bVar, r<ResponseSocialMedia> rVar) {
            if (rVar.g()) {
                this.f17070a.a(rVar.a());
            } else {
                this.f17070a.onFailure();
            }
        }
    }

    public b(d dVar) {
        this.f17066a = dVar;
        this.f17067b = (e) dVar.c(e.class);
    }

    public void a(c.a aVar) {
        this.f17067b.b("").L(new C0190b(aVar));
    }

    public void b(c.a aVar) {
        this.f17067b.a("").L(new a(aVar));
    }
}
