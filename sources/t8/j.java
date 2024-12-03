package t8;

import android.os.Bundle;
import c7.d;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.body.PhotoUploadData;
import com.coffeemeetsbagel.models.body.ReorderPhotosBody;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.responses.ResponsePhoto;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.e;
import com.uber.autodispose.t;
import fa.a;
import h5.i;
import java.io.File;
import java.util.List;
import jc.b;
import okhttp3.s;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import retrofit2.r;

public class j implements k {

    /* renamed from: a  reason: collision with root package name */
    private final p f17906a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthenticationScopeProvider f17907b;

    public j(d dVar, AuthenticationScopeProvider authenticationScopeProvider) {
        this.f17906a = (p) dVar.c(p.class);
        this.f17907b = authenticationScopeProvider;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void j(b bVar, int i10, r rVar) throws Exception {
        if (rVar.g()) {
            bVar.a(Integer.valueOf(i10), new SuccessStatus("Succeeded in deleting photo"));
        } else {
            bVar.b(new CmbErrorCode(rVar.h(), rVar.b()));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l(r rVar) throws Exception {
        if (!rVar.g()) {
            a.f("PhotosApi", "Failed to reorder photos");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(Bundle bundle, String str, r rVar) throws Exception {
        if (rVar.g()) {
            ResponsePhoto responsePhoto = (ResponsePhoto) rVar.a();
            if (responsePhoto != null) {
                bundle.putString(Extra.PHOTO_ID, responsePhoto.getPhotoId());
                bundle.putString(Extra.IMAGE_URI, responsePhoto.getPhotoUrl());
                bundle.putString("caption", str);
                i.c(EventType.PHOTO_UPLOAD_SUCCESS, bundle);
                return;
            }
            i.c(EventType.PHOTO_UPLOAD_ERROR, bundle);
            return;
        }
        i.c(EventType.PHOTO_UPLOAD_ERROR, bundle);
    }

    public void b(List<NetworkPhoto> list) {
        ReorderPhotosBody[] reorderPhotosBodyArr = new ReorderPhotosBody[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            NetworkPhoto networkPhoto = list.get(i10);
            reorderPhotosBodyArr[i10] = new ReorderPhotosBody(networkPhoto.getId(), networkPhoto.getCaption(), i10);
        }
        ((t) this.f17906a.c(reorderPhotosBodyArr).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f17907b))).b(new h(), new i());
    }

    public void c(b<Integer> bVar, String str, int i10) {
        ((t) this.f17906a.a(str).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f17907b))).b(new d(bVar, i10), new e(bVar));
    }

    public void d(String str, int i10, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt(Extra.PHOTO_INDEX, i10);
        i.c(EventType.PHOTO_UPLOADING, bundle);
        ((t) this.f17906a.b(new w.a().e(w.f33202l).b(s.m("Content-Disposition", "form-data; name=\"data\""), z.d(x4.a.f18538b, new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b().u(new PhotoUploadData(str, str2, i10)))).b(s.m("Content-Disposition", "form-data; name=\"image\"; filename=\"myfile.jpg\""), z.c(v.g("image/jpeg"), new File(str3))).d()).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f17907b))).b(new f(bundle, str2), new g(bundle));
    }
}
