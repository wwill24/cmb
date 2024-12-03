package v6;

import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import fa.a;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f18074a = new b();

    private b() {
    }

    public final PhotoEntity a(NetworkPhoto networkPhoto, String str) {
        boolean z10;
        j.g(networkPhoto, "networkPhoto");
        j.g(str, "profileId");
        String idProfile = networkPhoto.getIdProfile();
        boolean z11 = false;
        if (idProfile == null || idProfile.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            str = networkPhoto.getIdProfile();
        }
        String str2 = str;
        j.f(str2, "profileIdNonNull");
        if (str2.length() == 0) {
            z11 = true;
        }
        if (z11) {
            a.f40771d.c("PhotoMapper", "", new IllegalStateException("orphan photos, can't determine profile id"));
            return null;
        }
        String id2 = networkPhoto.getId();
        j.f(id2, "networkPhoto.id");
        String caption = networkPhoto.getCaption();
        int position = networkPhoto.getPosition();
        String url = networkPhoto.getUrl();
        j.f(url, "networkPhoto.url");
        return new PhotoEntity(id2, caption, position, str2, url);
    }
}
