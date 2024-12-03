package t6;

import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import u6.i;
import u6.k;
import v6.c;
import v6.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final k f17859a;

    /* renamed from: b  reason: collision with root package name */
    private final i f17860b;

    public a(k kVar, i iVar) {
        j.g(kVar, "profileDao");
        j.g(iVar, "photoDao");
        this.f17859a = kVar;
        this.f17860b = iVar;
    }

    private final void a(NetworkProfile networkProfile) {
        i iVar = this.f17860b;
        List<NetworkPhoto> photos = networkProfile.getPhotos();
        j.f(photos, "networkProfile.photos");
        ArrayList arrayList = new ArrayList();
        for (NetworkPhoto networkPhoto : photos) {
            j.f(networkPhoto, "it");
            PhotoEntity a10 = c.a(networkPhoto);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        iVar.f(arrayList);
    }

    public final ProfileDataContract b(NetworkProfile networkProfile) {
        j.g(networkProfile, "networkProfile");
        d dVar = d.f18075a;
        ProfileDtoImplementation b10 = dVar.b(networkProfile);
        this.f17859a.c(p.e(dVar.a(networkProfile)));
        a(networkProfile);
        return b10;
    }
}
