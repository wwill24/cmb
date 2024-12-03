package p9;

import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;
import retrofit2.b;
import vn.a;
import vn.o;

public interface e {
    @o("twitter_share")
    b<ResponseSocialMedia> a(@a String str);

    @o("twitter_follow")
    b<ResponseSocialMedia> b(@a String str);
}
