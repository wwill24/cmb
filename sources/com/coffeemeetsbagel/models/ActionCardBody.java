package com.coffeemeetsbagel.models;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ActionCardBody {

    /* renamed from: id  reason: collision with root package name */
    private final String f34704id;

    public ActionCardBody(String str) {
        j.g(str, "id");
        this.f34704id = str;
    }

    public static /* synthetic */ ActionCardBody copy$default(ActionCardBody actionCardBody, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionCardBody.f34704id;
        }
        return actionCardBody.copy(str);
    }

    public final String component1() {
        return this.f34704id;
    }

    public final ActionCardBody copy(String str) {
        j.g(str, "id");
        return new ActionCardBody(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActionCardBody) && j.b(this.f34704id, ((ActionCardBody) obj).f34704id);
    }

    public final String getId() {
        return this.f34704id;
    }

    public int hashCode() {
        return this.f34704id.hashCode();
    }

    public String toString() {
        return "ActionCardBody(id=" + this.f34704id + PropertyUtils.MAPPED_DELIM2;
    }
}
