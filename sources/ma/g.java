package ma;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.body.BlockProfileRequest;
import com.coffeemeetsbagel.models.responses.BlockProfileResponse;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import okhttp3.b0;
import okhttp3.z;
import qj.w;
import retrofit2.r;
import vn.a;
import vn.b;
import vn.f;
import vn.o;
import vn.p;
import vn.s;
import vn.t;

public interface g {
    @f("/profile/{id}")
    w<NetworkProfile> a(@s("id") String str);

    @p("/profile/me")
    w<r<b0>> b(@a z zVar);

    @o("/profile/{id}/block")
    w<BlockProfileResponse> c(@s("id") String str, @a BlockProfileRequest blockProfileRequest);

    @b("/profile")
    w<ResponseGeneric> d(@t("on_hold_reason") int i10, @t("on_hold_reason_text") String str);

    @f("/profile/me")
    w<NetworkProfile> getProfile();
}
