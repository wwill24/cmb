package v7;

import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import java.util.List;
import w7.j;

public interface a {

    /* renamed from: v7.a$a  reason: collision with other inner class name */
    public interface C0214a {
        void a(List<GiveTake> list);

        void onFailure();
    }

    public interface b {
        void a(String str, int i10);

        void b(ResponseGeneric responseGeneric);
    }

    public interface c {
        void a(List<GiveTake> list);

        void onFailure();
    }

    void clearInfiniteScrollCursors();

    void filterTakes(j jVar, C0214a aVar);

    void getBagelsInfiniteScroll(c cVar);

    void markGiveTakeAsSeen(String str, b bVar);

    void markRisingGiveTakeAsSeen(String str, b bVar);

    void sendLikeBackRisingGiveTake(String str, b bVar);
}
