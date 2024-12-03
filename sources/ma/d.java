package ma;

import com.coffeemeetsbagel.models.FeedbackBody;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import kotlin.coroutines.c;
import vn.a;
import vn.o;

public interface d {
    @o("/feedback")
    Object a(@a FeedbackBody feedbackBody, c<? super ResponseGeneric> cVar);
}
