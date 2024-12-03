package com.coffeemeetsbagel.models;

import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MultimediaBody {
    private final List<String> invited_participants;

    public MultimediaBody(List<String> list) {
        j.g(list, "invited_participants");
        this.invited_participants = list;
    }

    public static /* synthetic */ MultimediaBody copy$default(MultimediaBody multimediaBody, List<String> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = multimediaBody.invited_participants;
        }
        return multimediaBody.copy(list);
    }

    public final List<String> component1() {
        return this.invited_participants;
    }

    public final MultimediaBody copy(List<String> list) {
        j.g(list, "invited_participants");
        return new MultimediaBody(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultimediaBody) && j.b(this.invited_participants, ((MultimediaBody) obj).invited_participants);
    }

    public final List<String> getInvited_participants() {
        return this.invited_participants;
    }

    public int hashCode() {
        return this.invited_participants.hashCode();
    }

    public String toString() {
        return "MultimediaBody(invited_participants=" + this.invited_participants + PropertyUtils.MAPPED_DELIM2;
    }
}
