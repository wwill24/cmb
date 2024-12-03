package com.coffeemeetsbagel.models.responses;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseActionCard implements Serializable {
    private final String action;
    @c("action_text")
    private final String actionText;
    @c("header_text")
    private final String headerText;

    /* renamed from: id  reason: collision with root package name */
    private final String f34730id;
    @c("image_url")
    private final String imageUrl;
    @c("message_text")
    private final String messageText;

    public ResponseActionCard(String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "action");
        j.g(str2, "actionText");
        j.g(str3, "headerText");
        j.g(str4, "id");
        j.g(str5, "imageUrl");
        j.g(str6, "messageText");
        this.action = str;
        this.actionText = str2;
        this.headerText = str3;
        this.f34730id = str4;
        this.imageUrl = str5;
        this.messageText = str6;
    }

    public static /* synthetic */ ResponseActionCard copy$default(ResponseActionCard responseActionCard, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = responseActionCard.action;
        }
        if ((i10 & 2) != 0) {
            str2 = responseActionCard.actionText;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = responseActionCard.headerText;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = responseActionCard.f34730id;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = responseActionCard.imageUrl;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = responseActionCard.messageText;
        }
        return responseActionCard.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.actionText;
    }

    public final String component3() {
        return this.headerText;
    }

    public final String component4() {
        return this.f34730id;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final String component6() {
        return this.messageText;
    }

    public final ResponseActionCard copy(String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "action");
        j.g(str2, "actionText");
        j.g(str3, "headerText");
        j.g(str4, "id");
        j.g(str5, "imageUrl");
        j.g(str6, "messageText");
        return new ResponseActionCard(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseActionCard)) {
            return false;
        }
        ResponseActionCard responseActionCard = (ResponseActionCard) obj;
        return j.b(this.action, responseActionCard.action) && j.b(this.actionText, responseActionCard.actionText) && j.b(this.headerText, responseActionCard.headerText) && j.b(this.f34730id, responseActionCard.f34730id) && j.b(this.imageUrl, responseActionCard.imageUrl) && j.b(this.messageText, responseActionCard.messageText);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getActionText() {
        return this.actionText;
    }

    public final String getHeaderText() {
        return this.headerText;
    }

    public final String getId() {
        return this.f34730id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final boolean hasAllValidValues() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this.action.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (this.actionText.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (this.headerText.length() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (this.f34730id.length() > 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        if (this.imageUrl.length() > 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z14) {
                            if (this.messageText.length() > 0) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            if (z15) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.action.hashCode() * 31) + this.actionText.hashCode()) * 31) + this.headerText.hashCode()) * 31) + this.f34730id.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.messageText.hashCode();
    }

    public String toString() {
        return "ResponseActionCard(action=" + this.action + ", actionText=" + this.actionText + ", headerText=" + this.headerText + ", id=" + this.f34730id + ", imageUrl=" + this.imageUrl + ", messageText=" + this.messageText + PropertyUtils.MAPPED_DELIM2;
    }
}
