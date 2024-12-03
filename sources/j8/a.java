package j8;

import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.chat.features.photoupload.api.endpoints.ChatPhotoUploadResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import j8.c;
import java.io.File;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import retrofit2.b;
import retrofit2.r;
import retrofit2.s;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f15633a;

    /* renamed from: b  reason: collision with root package name */
    private final d f15634b;

    /* renamed from: c  reason: collision with root package name */
    private final s f15635c;

    /* renamed from: d  reason: collision with root package name */
    private final b f15636d;

    /* renamed from: j8.a$a  reason: collision with other inner class name */
    class C0165a implements retrofit2.d<ChatPhotoUploadResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.a f15637a;

        C0165a(c.a aVar) {
            this.f15637a = aVar;
        }

        public void onFailure(b<ChatPhotoUploadResponse> bVar, Throwable th2) {
            this.f15637a.onFailure();
        }

        public void onResponse(b<ChatPhotoUploadResponse> bVar, r<ChatPhotoUploadResponse> rVar) {
            if (rVar.g()) {
                this.f15637a.a(rVar.a().getImageUrl());
            } else {
                this.f15637a.onFailure();
            }
        }
    }

    public a() {
        String str = x4.a.f18540d;
        this.f15633a = str;
        d b10 = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();
        this.f15634b = b10;
        s e10 = new s.b().c(str).b(tn.a.f(b10)).g(lc.r.d()).e();
        this.f15635c = e10;
        this.f15636d = (b) e10.b(b.class);
    }

    public String a() {
        return Bakery.w().getFilesDir() + "/chat_image.jpg";
    }

    public void b(String str, String str2, c.a aVar) {
        org.json.b bVar = new org.json.b();
        try {
            bVar.put("couple_id", (Object) str2);
        } catch (Exception e10) {
            fa.a.f("CmbMediaUpload", "uploadMedia JSON Exception");
            fa.a.i(e10);
        }
        File file = new File(str);
        this.f15636d.a(w.c.b("image", file.getName(), z.c(v.g("image/*"), file)), z.d(x4.a.f18538b, bVar.toString())).L(new C0165a(aVar));
    }
}
