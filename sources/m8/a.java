package m8;

import c7.d;
import com.coffeemeetsbagel.feature.mongoose.api.models.ChatTokenResponse;
import l8.g;
import retrofit2.b;
import retrofit2.r;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final d f16343a;

    /* renamed from: m8.a$a  reason: collision with other inner class name */
    class C0173a implements retrofit2.d<ChatTokenResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16344a;

        C0173a(g gVar) {
            this.f16344a = gVar;
        }

        public void onFailure(b<ChatTokenResponse> bVar, Throwable th2) {
            this.f16344a.b(th2.getMessage());
        }

        public void onResponse(b<ChatTokenResponse> bVar, r<ChatTokenResponse> rVar) {
            if (rVar.g()) {
                this.f16344a.a(rVar.a().getToken());
            } else {
                this.f16344a.b(rVar.h());
            }
        }
    }

    public a(d dVar) {
        this.f16343a = dVar;
    }

    private b b() {
        return (b) this.f16343a.c(b.class);
    }

    public void a(g gVar) {
        b().a().L(new C0173a(gVar));
    }
}
