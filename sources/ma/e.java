package ma;

import com.coffeemeetsbagel.likesyou.EncountersRequestBody;
import com.coffeemeetsbagel.likesyou.EncountersResponse;
import com.coffeemeetsbagel.likesyou.LikesYouNetworkResponseV5;
import qj.w;
import vn.a;
import vn.f;
import vn.o;

public interface e {
    @f("/v5/likes_you")
    w<LikesYouNetworkResponseV5> a();

    @o("/v5/encounters")
    w<EncountersResponse> b(@a EncountersRequestBody encountersRequestBody);
}
