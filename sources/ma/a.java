package ma;

import com.coffeemeetsbagel.models.ActionCardBody;
import com.coffeemeetsbagel.models.responses.ResponseActionCards;
import qj.w;
import vn.f;
import vn.o;

public interface a {
    @f("/v4/actioncards/endofsuggested")
    w<ResponseActionCards> a();

    @o("/v4/actioncards/shown")
    w<ResponseActionCards> b(@vn.a ActionCardBody actionCardBody);
}
