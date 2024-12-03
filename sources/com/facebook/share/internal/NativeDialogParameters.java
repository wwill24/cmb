package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0007J \u0010 \u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\""}, d2 = {"Lcom/facebook/share/internal/NativeDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "attachmentUrlsBundle", "dataErrorsFatal", "", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "mediaInfos", "", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "imageUrls", "", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "mediaInfo", "stickerInfo", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "videoUrl", "callId", "Ljava/util/UUID;", "shareContent", "Lcom/facebook/share/model/ShareContent;", "shouldFailOnDataError", "createBaseParameters", "content", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NativeDialogParameters {
    public static final NativeDialogParameters INSTANCE = new NativeDialogParameters();

    private NativeDialogParameters() {
    }

    public static final Bundle create(UUID uuid, ShareContent<?, ?> shareContent, boolean z10) {
        j.g(uuid, "callId");
        j.g(shareContent, "shareContent");
        if (shareContent instanceof ShareLinkContent) {
            return INSTANCE.create((ShareLinkContent) shareContent, z10);
        }
        if (shareContent instanceof SharePhotoContent) {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            List<String> photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid);
            if (photoUrls == null) {
                photoUrls = q.j();
            }
            return INSTANCE.create(sharePhotoContent, photoUrls, z10);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareInternalUtility shareInternalUtility2 = ShareInternalUtility.INSTANCE;
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return INSTANCE.create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, uuid), z10);
        } else if (shareContent instanceof ShareMediaContent) {
            ShareInternalUtility shareInternalUtility3 = ShareInternalUtility.INSTANCE;
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            List<Bundle> mediaInfos = ShareInternalUtility.getMediaInfos(shareMediaContent, uuid);
            if (mediaInfos == null) {
                mediaInfos = q.j();
            }
            return INSTANCE.create(shareMediaContent, mediaInfos, z10);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareInternalUtility shareInternalUtility4 = ShareInternalUtility.INSTANCE;
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return INSTANCE.create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid), z10);
        } else if (!(shareContent instanceof ShareStoryContent)) {
            return null;
        } else {
            ShareInternalUtility shareInternalUtility5 = ShareInternalUtility.INSTANCE;
            ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
            return INSTANCE.create(shareStoryContent, ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid), ShareInternalUtility.getStickerUrl(shareStoryContent, uuid), z10);
        }
    }

    private final Bundle createBaseParameters(ShareContent<?, ?> shareContent, boolean z10) {
        boolean z11;
        String str;
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z10);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (peopleIds == null || peopleIds.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList(peopleIds));
        }
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag == null) {
            str = null;
        } else {
            str = shareHashtag.getHashtag();
        }
        Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, str);
        return bundle;
    }

    private final Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z10) {
        Bundle createBaseParameters = createBaseParameters(shareCameraEffectContent, z10);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            createBaseParameters.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            CameraEffectJSONUtility cameraEffectJSONUtility = CameraEffectJSONUtility.INSTANCE;
            b convertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (convertToJSON != null) {
                Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ARGS, convertToJSON.toString());
            }
            return createBaseParameters;
        } catch (JSONException e10) {
            throw new FacebookException(j.p("Unable to create a JSON Object from the provided CameraEffectArguments: ", e10.getMessage()));
        }
    }

    private final Bundle create(ShareLinkContent shareLinkContent, boolean z10) {
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z10);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility.putUri(createBaseParameters, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility.putUri(createBaseParameters, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        return createBaseParameters;
    }

    private final Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z10) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z10);
        createBaseParameters.putStringArrayList(ShareConstants.PHOTOS, new ArrayList(list));
        return createBaseParameters;
    }

    private final Bundle create(ShareVideoContent shareVideoContent, String str, boolean z10) {
        Bundle createBaseParameters = createBaseParameters(shareVideoContent, z10);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.VIDEO_URL, str);
        return createBaseParameters;
    }

    private final Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z10) {
        Bundle createBaseParameters = createBaseParameters(shareMediaContent, z10);
        createBaseParameters.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList(list));
        return createBaseParameters;
    }

    private final Bundle create(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z10) {
        Bundle createBaseParameters = createBaseParameters(shareStoryContent, z10);
        if (bundle != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        List<String> backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (!(backgroundColorList == null || backgroundColorList.isEmpty())) {
            createBaseParameters.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList(backgroundColorList));
        }
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        return createBaseParameters;
    }
}
