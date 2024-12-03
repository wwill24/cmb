package l8;

import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import j5.x;
import java.util.List;
import n8.s;
import org.jxmpp.jid.Jid;
import qj.q;
import qj.w;

public interface h {

    public interface a {
    }

    public interface b {
        void h(ConnectionDetails connectionDetails, Bagel bagel);
    }

    public interface c {
        void v();
    }

    public interface d {
        void a(Throwable th2);

        void b(String str);
    }

    void b(c cVar);

    void c(b bVar);

    void d(String str);

    void e(Bagel bagel, String str, d dVar, Long l10);

    q<List<SavedMessage>> f(String str);

    w<Long> g(PendingMessageEntity pendingMessageEntity);

    void h(Bagel bagel, String str, ChatMediaType chatMediaType, String str2, String str3, d dVar);

    void i(boolean z10, String str);

    s j();

    void k(a aVar);

    void l();

    void m(Long l10);

    q<List<SavedMessage>> n(String str);

    w<Optional<RosterElement>> o(Jid jid);

    com.jakewharton.rxrelay2.b<x> p();

    void q(ConnectionDetails connectionDetails, Bagel bagel);

    List<SavedMessage> s(RosterElement rosterElement);

    void t(a aVar);

    void u(b bVar);

    long v(String str);
}
