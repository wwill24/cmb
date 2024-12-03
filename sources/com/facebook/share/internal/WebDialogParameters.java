package com.facebook.share.internal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/internal/WebDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "appGroupCreationContent", "Lcom/facebook/share/model/AppGroupCreationContent;", "gameRequestContent", "Lcom/facebook/share/model/GameRequestContent;", "shareLinkContent", "Lcom/facebook/share/model/ShareLinkContent;", "sharePhotoContent", "Lcom/facebook/share/model/SharePhotoContent;", "createBaseParameters", "shareContent", "Lcom/facebook/share/model/ShareContent;", "createForFeed", "shareFeedContent", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebDialogParameters {
    public static final WebDialogParameters INSTANCE = new WebDialogParameters();

    private WebDialogParameters() {
    }

    public static final Bundle create(AppGroupCreationContent appGroupCreationContent) {
        String obj;
        j.g(appGroupCreationContent, "appGroupCreationContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        AppGroupCreationContent.AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        String str = null;
        if (!(appGroupPrivacy == null || (obj = appGroupPrivacy.toString()) == null)) {
            Locale locale = Locale.ENGLISH;
            j.f(locale, ViewHierarchyConstants.ENGLISH);
            str = obj.toLowerCase(locale);
            j.f(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, str);
        return bundle;
    }

    public static final Bundle createBaseParameters(ShareContent<?, ?> shareContent) {
        String str;
        j.g(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag == null) {
            str = null;
        } else {
            str = shareHashtag.getHashtag();
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, str);
        return bundle;
    }

    @SuppressLint({"DeprecatedMethod"})
    public static final Bundle createForFeed(ShareLinkContent shareLinkContent) {
        j.g(shareLinkContent, "shareLinkContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        ShareHashtag shareHashtag = shareLinkContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    public static final Bundle create(GameRequestContent gameRequestContent) {
        String str;
        String obj;
        String obj2;
        j.g(gameRequestContent, "gameRequestContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "message", gameRequestContent.getMessage());
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        GameRequestContent.ActionType actionType = gameRequestContent.getActionType();
        String str2 = null;
        if (actionType == null || (obj2 = actionType.toString()) == null) {
            str = null;
        } else {
            Locale locale = Locale.ENGLISH;
            j.f(locale, ViewHierarchyConstants.ENGLISH);
            str = obj2.toLowerCase(locale);
            j.f(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        GameRequestContent.Filters filters = gameRequestContent.getFilters();
        if (!(filters == null || (obj = filters.toString()) == null)) {
            Locale locale2 = Locale.ENGLISH;
            j.f(locale2, ViewHierarchyConstants.ENGLISH);
            str2 = obj.toLowerCase(locale2);
            j.f(str2, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, "filters", str2);
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        return bundle;
    }

    public static final Bundle createForFeed(ShareFeedContent shareFeedContent) {
        j.g(shareFeedContent, "shareFeedContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, "caption", shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        return bundle;
    }

    public static final Bundle create(ShareLinkContent shareLinkContent) {
        j.g(shareLinkContent, "shareLinkContent");
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility utility = Utility.INSTANCE;
        Utility.putUri(createBaseParameters, "href", shareLinkContent.getContentUrl());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        return createBaseParameters;
    }

    public static final Bundle create(SharePhotoContent sharePhotoContent) {
        j.g(sharePhotoContent, "sharePhotoContent");
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null) {
            photos = q.j();
        }
        ArrayList arrayList = new ArrayList(r.t(photos, 10));
        for (SharePhoto imageUrl : photos) {
            arrayList.add(String.valueOf(imageUrl.getImageUrl()));
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        if (array2 != null) {
            createBaseParameters.putStringArray("media", (String[]) array2);
            return createBaseParameters;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
