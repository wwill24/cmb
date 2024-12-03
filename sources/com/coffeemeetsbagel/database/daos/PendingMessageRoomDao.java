package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.util.DateUtils;
import dk.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;
import u6.h;

public abstract class PendingMessageRoomDao implements l<PendingMessageEntity>, h {
    /* access modifiers changed from: private */
    public static final List w(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public abstract int A(long j10, String str);

    public List<PendingMessage> a(String str) {
        j.g(str, "bagelId");
        return x(MessageStatus.NOT_SENT, str);
    }

    public w<Long> c(PendingMessageEntity pendingMessageEntity) {
        j.g(pendingMessageEntity, "pendingMessageEntity");
        return insert(pendingMessageEntity);
    }

    public w<Integer> f(long j10, MessageStatus messageStatus) {
        j.g(messageStatus, "messageStatus");
        return z(j10, messageStatus);
    }

    public w<Integer> g(long j10) {
        return u(j10);
    }

    public List<PendingMessage> i() {
        MessageStatus messageStatus = MessageStatus.NOT_SENT;
        String formattedTimestampThreeDaysPrior = DateUtils.getFormattedTimestampThreeDaysPrior();
        j.f(formattedTimestampThreeDaysPrior, "getFormattedTimestampThreeDaysPrior()");
        return v(messageStatus, formattedTimestampThreeDaysPrior);
    }

    public int j(long j10, String str) {
        j.g(str, "timeSent");
        return A(j10, str);
    }

    public w<List<PendingMessage>> n(String str) {
        j.g(str, "bagelId");
        w<R> D = y(str).K(a.c()).D(new z(PendingMessageRoomDao$getPendingMessages$1.f11610a));
        j.f(D, "getPendingMessagesFromBa…{ t -> t.map { p -> p } }");
        return D;
    }

    public abstract w<Integer> u(long j10);

    public abstract List<PendingMessageEntity> v(MessageStatus messageStatus, String str);

    public abstract List<PendingMessageEntity> x(MessageStatus messageStatus, String str);

    public abstract w<List<PendingMessageEntity>> y(String str);

    public abstract w<Integer> z(long j10, MessageStatus messageStatus);
}
