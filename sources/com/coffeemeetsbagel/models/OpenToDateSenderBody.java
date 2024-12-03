package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.constants.Extra;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class OpenToDateSenderBody {
    private final String bagel_id;
    private final List<String> date_ideas;

    public OpenToDateSenderBody(List<String> list, String str) {
        j.g(str, Extra.BAGEL_ID);
        this.date_ideas = list;
        this.bagel_id = str;
    }

    public static /* synthetic */ OpenToDateSenderBody copy$default(OpenToDateSenderBody openToDateSenderBody, List<String> list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = openToDateSenderBody.date_ideas;
        }
        if ((i10 & 2) != 0) {
            str = openToDateSenderBody.bagel_id;
        }
        return openToDateSenderBody.copy(list, str);
    }

    public final List<String> component1() {
        return this.date_ideas;
    }

    public final String component2() {
        return this.bagel_id;
    }

    public final OpenToDateSenderBody copy(List<String> list, String str) {
        j.g(str, Extra.BAGEL_ID);
        return new OpenToDateSenderBody(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenToDateSenderBody)) {
            return false;
        }
        OpenToDateSenderBody openToDateSenderBody = (OpenToDateSenderBody) obj;
        return j.b(this.date_ideas, openToDateSenderBody.date_ideas) && j.b(this.bagel_id, openToDateSenderBody.bagel_id);
    }

    public final String getBagel_id() {
        return this.bagel_id;
    }

    public final List<String> getDate_ideas() {
        return this.date_ideas;
    }

    public int hashCode() {
        List<String> list = this.date_ideas;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.bagel_id.hashCode();
    }

    public String toString() {
        return "OpenToDateSenderBody(date_ideas=" + this.date_ideas + ", bagel_id=" + this.bagel_id + PropertyUtils.MAPPED_DELIM2;
    }
}
