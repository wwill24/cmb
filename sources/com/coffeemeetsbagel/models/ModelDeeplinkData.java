package com.coffeemeetsbagel.models;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.google.gson.d;
import java.io.Serializable;
import lg.c;

public class ModelDeeplinkData implements Serializable {
    public static final String CMB_AUTHORITY = "cmb";
    public static final String KEY_REDEEM_PROFILE_GUID = "redeem_profile_guid";
    public static final String KEY_SENT_BY_PROFILE_GUID = "sent_by_profile_guid";
    public static final String VALUE_DISCOVER_FILTERS = "discoverfilters";
    public static final String VALUE_EDIT_DATING = "edit_dating_style";
    public static final String VALUE_EDIT_PROFILE = "edit_profile_details";
    public static final String VALUE_LIKES_YOU = "likesyou";
    public static final String VALUE_PAGE_BASICS = "basics";
    public static final String VALUE_PAGE_BEAN_SHOP = "beanshop";
    public static final String VALUE_PAGE_BOOST = "boost";
    public static final String VALUE_PAGE_CHAT = "chat";
    public static final String VALUE_PAGE_CHATS = "chats";
    public static final String VALUE_PAGE_CONNECTION = "connection";
    public static final String VALUE_PAGE_DISCOVER = "discover";
    public static final String VALUE_PAGE_EDUCATION = "education";
    public static final String VALUE_PAGE_HISTORY = "history";
    public static final String VALUE_PAGE_INVITES = "invites";
    public static final String VALUE_PAGE_ME = "me";
    public static final String VALUE_PAGE_MEMBERSHIP = "membership";
    public static final String VALUE_PAGE_PHOTOS = "photos";
    public static final String VALUE_PAGE_PREFERENCES = "preferences";
    @Deprecated
    public static final String VALUE_PAGE_PREFS = "prefs";
    public static final String VALUE_PAGE_PROFILE = "profile";
    public static final String VALUE_PAGE_REDEEM_BAGEL = "redeem_bagel";
    public static final String VALUE_PAGE_REWARDS = "rewards";
    public static final String VALUE_PAGE_SEEMORE = "seemore";
    public static final String VALUE_PAGE_SETTINGS = "settings";
    public static final String VALUE_PAGE_SUGGESTED = "suggested";
    public static final String VALUE_PAGE_TEN = "ten";
    public static final String VALUE_PAGE_TIPS = "tips";
    public static final String VALUE_PAGE_TODAY = "today";
    public static final String VALUE_PAGE_WHO_YOU_WANT = "who-you-want";
    public static final String VALUE_VIDEO_FEED = "videofeed";
    @c("bagel_id")
    private long mBagelId;
    @c("page")
    private String mPage;
    @c("redeem_profile_guid")
    private String mRedeemProfileGuid;
    @c("redeem_profile_id")
    private long mRedeemProfileId;
    @c("sender_first_name")
    private String mSenderFirstName;
    @c("sent_by_profile_guid")
    private String mSenderProfileGuid;
    @c("sent_by_profile_id")
    private long mSenderProfileId;
    @c("validation_code")
    private String mValidationCode;

    public ModelDeeplinkData(String str) {
        this.mPage = str;
    }

    public long getBagelId() {
        return this.mBagelId;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getSenderFirstName() {
        return this.mSenderFirstName;
    }

    public boolean isRedeemDataComplete() {
        if (TextUtils.isEmpty(this.mPage)) {
            return false;
        }
        if (VALUE_PAGE_REDEEM_BAGEL.equals(this.mPage)) {
            if (this.mSenderProfileId < 1 && TextUtils.isEmpty(this.mSenderProfileGuid)) {
                return false;
            }
            if ((this.mRedeemProfileId >= 1 || !TextUtils.isEmpty(this.mRedeemProfileGuid)) && !TextUtils.isEmpty(this.mValidationCode)) {
                return true;
            }
            return false;
        } else if (!VALUE_PAGE_CONNECTION.equals(this.mPage)) {
            return StringUtils.equalsAny(this.mPage, VALUE_PAGE_BEAN_SHOP, VALUE_PAGE_CHAT, VALUE_PAGE_TODAY, VALUE_PAGE_INVITES, "photos", "prefs", VALUE_PAGE_PREFERENCES, "profile", VALUE_PAGE_SEEMORE, VALUE_PAGE_SETTINGS, VALUE_PAGE_BASICS, VALUE_PAGE_TIPS, VALUE_DISCOVER_FILTERS, VALUE_VIDEO_FEED, "education");
        } else {
            if (this.mBagelId > 0) {
                return true;
            }
            return false;
        }
    }

    public String toString() {
        return new d().u(this);
    }
}
