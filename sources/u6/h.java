package u6;

import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import java.util.List;
import qj.w;

public interface h {
    List<PendingMessage> a(String str);

    w<Long> c(PendingMessageEntity pendingMessageEntity);

    w<Integer> f(long j10, MessageStatus messageStatus);

    w<Integer> g(long j10);

    List<PendingMessage> i();

    int j(long j10, String str);

    w<List<PendingMessage>> n(String str);
}
