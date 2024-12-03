package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;
import u6.e;

public abstract class ConnectionDetailsRoomDao implements l<ConnectionDetailsEntity>, e {
    private final ConnectionDetailsEntity t(ConnectionDetails connectionDetails) {
        String profileId = connectionDetails.getProfileId();
        int unreadMessageCount = connectionDetails.getUnreadMessageCount();
        String lastMessageText = connectionDetails.getLastMessageText();
        String lastMessageDate = connectionDetails.getLastMessageDate();
        String lastSenderProfileId = connectionDetails.getLastSenderProfileId();
        String lastMessageReadTimestamp = connectionDetails.getLastMessageReadTimestamp();
        String pairReadReceiptDate = connectionDetails.getPairReadReceiptDate();
        j.f(profileId, "profileId");
        return new ConnectionDetailsEntity(profileId, unreadMessageCount, lastMessageText, lastMessageDate, pairReadReceiptDate, lastSenderProfileId, lastMessageReadTimestamp);
    }

    /* access modifiers changed from: private */
    public static final List u(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final ConnectionDetails y(ConnectionDetailsEntity connectionDetailsEntity) {
        return new ConnectionDetails(connectionDetailsEntity.getProfileId(), connectionDetailsEntity.getUnreadMessageCount(), connectionDetailsEntity.getLastMessageText(), connectionDetailsEntity.getLastMessageDate(), connectionDetailsEntity.getPairReadReceiptDate(), connectionDetailsEntity.getLastSenderProfileId(), false);
    }

    public abstract void A(List<ConnectionDetailsEntity> list);

    public void a(List<? extends ConnectionDetails> list) {
        j.g(list, "connectionDetails");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (ConnectionDetails t10 : list) {
            arrayList.add(t(t10));
        }
        A(arrayList);
    }

    public ConnectionDetails c(String str) {
        j.g(str, "profileId");
        ConnectionDetailsEntity v10 = v(str);
        if (v10 != null) {
            return y(v10);
        }
        return null;
    }

    public w<List<ConnectionDetails>> f(List<String> list) {
        j.g(list, "profileIds");
        w<R> D = w(list).D(new r(new ConnectionDetailsRoomDao$getConnectionDetails$1(this)));
        j.f(D, "override fun getConnecti…p { it.toPoJo() } }\n    }");
        return D;
    }

    public void g(ConnectionDetails connectionDetails) {
        j.g(connectionDetails, "connectionDetails");
        z(t(connectionDetails));
    }

    public void i(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "timestamp");
        x(str, str2);
    }

    public abstract ConnectionDetailsEntity v(String str);

    public abstract w<List<ConnectionDetailsEntity>> w(List<String> list);

    public abstract void x(String str, String str2);

    public abstract void z(ConnectionDetailsEntity connectionDetailsEntity);
}
