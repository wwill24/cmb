package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.dto.ActionCard;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ActionCardEntity implements ActionCard {
    private final String action;
    private final String actionText;
    private final String headerText;

    /* renamed from: id  reason: collision with root package name */
    private final String f34720id;
    private final String imageUrl;
    private final String messageText;

    public ActionCardEntity(String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "id");
        j.g(str2, "action");
        j.g(str3, "actionText");
        j.g(str4, "headerText");
        j.g(str5, "imageUrl");
        j.g(str6, "messageText");
        this.f34720id = str;
        this.action = str2;
        this.actionText = str3;
        this.headerText = str4;
        this.imageUrl = str5;
        this.messageText = str6;
    }

    public static /* synthetic */ ActionCardEntity copy$default(ActionCardEntity actionCardEntity, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionCardEntity.getId();
        }
        if ((i10 & 2) != 0) {
            str2 = actionCardEntity.getAction();
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = actionCardEntity.getActionText();
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = actionCardEntity.getHeaderText();
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = actionCardEntity.getImageUrl();
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = actionCardEntity.getMessageText();
        }
        return actionCardEntity.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getAction();
    }

    public final String component3() {
        return getActionText();
    }

    public final String component4() {
        return getHeaderText();
    }

    public final String component5() {
        return getImageUrl();
    }

    public final String component6() {
        return getMessageText();
    }

    public final ActionCardEntity copy(String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "id");
        j.g(str2, "action");
        j.g(str3, "actionText");
        j.g(str4, "headerText");
        j.g(str5, "imageUrl");
        j.g(str6, "messageText");
        return new ActionCardEntity(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionCardEntity)) {
            return false;
        }
        ActionCardEntity actionCardEntity = (ActionCardEntity) obj;
        return j.b(getId(), actionCardEntity.getId()) && j.b(getAction(), actionCardEntity.getAction()) && j.b(getActionText(), actionCardEntity.getActionText()) && j.b(getHeaderText(), actionCardEntity.getHeaderText()) && j.b(getImageUrl(), actionCardEntity.getImageUrl()) && j.b(getMessageText(), actionCardEntity.getMessageText());
    }

    public String getAction() {
        return this.action;
    }

    public String getActionText() {
        return this.actionText;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public String getId() {
        return this.f34720id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public int hashCode() {
        return (((((((((getId().hashCode() * 31) + getAction().hashCode()) * 31) + getActionText().hashCode()) * 31) + getHeaderText().hashCode()) * 31) + getImageUrl().hashCode()) * 31) + getMessageText().hashCode();
    }

    public String toString() {
        return "ActionCardEntity(id=" + getId() + ", action=" + getAction() + ", actionText=" + getActionText() + ", headerText=" + getHeaderText() + ", imageUrl=" + getImageUrl() + ", messageText=" + getMessageText() + PropertyUtils.MAPPED_DELIM2;
    }
}
