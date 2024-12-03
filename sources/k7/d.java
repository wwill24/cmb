package k7;

import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.dto.PendingMessage;
import j5.q;
import java.util.List;

public interface d extends q {
    void g(List<PendingMessage> list);

    void m();

    void n();

    void s(List<SavedMessage> list, ConnectionDetails connectionDetails);
}
