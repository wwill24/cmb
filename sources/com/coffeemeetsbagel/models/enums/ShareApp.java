package com.coffeemeetsbagel.models.enums;

import com.facebook.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;

public enum ShareApp {
    MESSENGER(BuildConfig.LIBRARY_PACKAGE_NAME),
    WHATSAPP(""),
    KAKAOTALK(""),
    WECHAT(""),
    LINE(""),
    SMS(""),
    GMAIL(""),
    FACEBOOK(""),
    TWEET(""),
    HANGOUTS(""),
    KIK(""),
    SNAPCHAT(""),
    TANGO_CHAT(""),
    VIBER(""),
    SLACK(""),
    COPY_TO_CLIPBOARD("");
    
    private String mNameSpace;

    static class Helper {
        static List<String> sNames;

        static {
            sNames = new ArrayList();
        }

        Helper() {
        }
    }

    private ShareApp(String str) {
        this.mNameSpace = str;
        Helper.sNames.add(toString());
    }

    public String getNameSpace() {
        return this.mNameSpace;
    }

    public String toString() {
        return name().replace(JavaConstant.Dynamic.DEFAULT_NAME, " ").toLowerCase();
    }
}
