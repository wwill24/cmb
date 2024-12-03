package m8;

import com.coffeemeetsbagel.feature.mongoose.api.models.ChatTokenResponse;
import vn.f;

public interface b {
    @f("/xmpp/token")
    retrofit2.b<ChatTokenResponse> a();
}
