package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\ba\u0010bJ \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\"\u0010\u000b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J*\u0010\u000f\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J,\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010\u001d\u001a\u00020\u00192\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J$\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J*\u0010#\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010(2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&H\u0007J\u001c\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010'\u001a\u00020&H\u0007J\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010(2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010'\u001a\u00020&H\u0007J\u001c\u00102\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010'\u001a\u00020&H\u0007J\u0018\u00106\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u001bH\u0007J\u001c\u00109\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00105\u001a\u00020\u001bH\u0007J\u001e\u0010<\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\t0;2\u0006\u0010:\u001a\u00020\tH\u0007J\"\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010=\u001a\u00020&2\u000e\u0010?\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030>H\u0002J&\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010=\u001a\u00020&2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010E\u001a\u0004\u0018\u00010DH\u0002J\u0018\u0010F\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\"\u0010G\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0007J,\u0010J\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010H\u001a\u0004\u0018\u00010\r2\b\u0010I\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010J\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010I\u001a\u0004\u0018\u00010\tH\u0007J \u0010J\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010L\u001a\u00020KH\u0007J\u001a\u0010O\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010\tH\u0002J&\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010R\u001a\u0004\u0018\u00010D2\b\u0010\u0004\u001a\u0004\u0018\u00010SH\u0007J&\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\u0004\u001a\u0004\u0018\u00010SH\u0007J$\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010X\u001a\u00020B2\b\u0010\u0004\u001a\u0004\u0018\u00010SH\u0007J\u001c\u0010[\u001a\u0004\u0018\u00010\u00102\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010'\u001a\u00020&H\u0007J\u001c\u0010\\\u001a\u0004\u0018\u00010\u00102\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010'\u001a\u00020&H\u0007J\u0014\u0010]\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010BH\u0007R\u0014\u0010^\u001a\u00020\t8\u0006XT¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\t8\u0006XT¢\u0006\u0006\n\u0004\b`\u0010_¨\u0006c"}, d2 = {"Lcom/facebook/share/internal/ShareInternalUtility;", "", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/share/Sharer$Result;", "callback", "Ljava/lang/Exception;", "exception", "", "invokeCallbackWithException", "", "error", "invokeCallbackWithError", "postId", "Lcom/facebook/GraphResponse;", "graphResponse", "invokeCallbackWithResults", "Landroid/os/Bundle;", "result", "getNativeDialogCompletionGesture", "getShareDialogPostId", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "Lcom/facebook/share/internal/ResultProcessor;", "resultProcessor", "", "handleActivityResult", "getShareResultProcessor", "Lcom/facebook/internal/AppCall;", "getAppCallFromActivityResult", "registerStaticShareCallback", "Lcom/facebook/CallbackManager;", "callbackManager", "registerSharerCallback", "Lcom/facebook/share/model/SharePhotoContent;", "photoContent", "Ljava/util/UUID;", "appCallId", "", "getPhotoUrls", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "getVideoUrl", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "getMediaInfos", "Lcom/facebook/share/model/ShareCameraEffectContent;", "cameraEffectContent", "getTextureUrlBundle", "Lorg/json/a;", "jsonArray", "requireNamespace", "removeNamespacesFromOGJsonArray", "Lorg/json/b;", "jsonObject", "removeNamespacesFromOGJsonObject", "fullName", "Landroid/util/Pair;", "getFieldNameAndNamespaceFromFullName", "callId", "Lcom/facebook/share/model/ShareMedia;", "medium", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "getAttachment", "Landroid/net/Uri;", "uri", "Landroid/graphics/Bitmap;", "bitmap", "invokeOnCancelCallback", "invokeOnSuccessCallback", "response", "message", "invokeOnErrorCallback", "Lcom/facebook/FacebookException;", "ex", "shareOutcome", "errorMessage", "logShareResult", "Lcom/facebook/AccessToken;", "accessToken", "image", "Lcom/facebook/GraphRequest$Callback;", "Lcom/facebook/GraphRequest;", "newUploadStagingResourceWithImageRequest", "Ljava/io/File;", "file", "imageUri", "Lcom/facebook/share/model/ShareStoryContent;", "storyContent", "getStickerUrl", "getBackgroundAssetMediaInfo", "getUriExtension", "MY_STAGING_RESOURCES", "Ljava/lang/String;", "STAGING_PARAM", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class ShareInternalUtility {
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    private final AppCall getAppCallFromActivityResult(int i10, int i11, Intent intent) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.Companion.finishPendingCall(callIdFromIntent, i10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.graphics.Bitmap] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.internal.NativeAppCallAttachmentStore.Attachment getAttachment(java.util.UUID r4, com.facebook.share.model.ShareMedia<?, ?> r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof com.facebook.share.model.SharePhoto
            r1 = 0
            if (r0 == 0) goto L_0x0013
            com.facebook.share.model.SharePhoto r5 = (com.facebook.share.model.SharePhoto) r5
            android.graphics.Bitmap r1 = r5.getBitmap()
            android.net.Uri r5 = r5.getImageUrl()
        L_0x000f:
            r2 = r1
            r1 = r5
            r5 = r2
            goto L_0x001f
        L_0x0013:
            boolean r0 = r5 instanceof com.facebook.share.model.ShareVideo
            if (r0 == 0) goto L_0x001e
            com.facebook.share.model.ShareVideo r5 = (com.facebook.share.model.ShareVideo) r5
            android.net.Uri r5 = r5.getLocalUrl()
            goto L_0x000f
        L_0x001e:
            r5 = r1
        L_0x001f:
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r4 = r3.getAttachment(r4, r1, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.getAttachment(java.util.UUID, com.facebook.share.model.ShareMedia):com.facebook.internal.NativeAppCallAttachmentStore$Attachment");
    }

    public static final Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, UUID uuid) {
        j.g(uuid, "appCallId");
        Bundle bundle = null;
        if (!(shareStoryContent == null || shareStoryContent.getBackgroundAsset() == null)) {
            ShareMedia<?, ?> backgroundAsset = shareStoryContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString("type", backgroundAsset.getMediaType().name());
            bundle.putString("uri", attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(p.e(attachment));
        }
        return bundle;
    }

    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        String str2;
        int i10;
        j.g(str, "fullName");
        int a02 = StringsKt__StringsKt.a0(str, ':', 0, false, 6, (Object) null);
        if (a02 == -1 || str.length() <= (i10 = a02 + 1)) {
            str2 = null;
        } else {
            str2 = str.substring(0, a02);
            j.f(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str = str.substring(i10);
            j.f(str, "(this as java.lang.String).substring(startIndex)");
        }
        return new Pair<>(str2, str);
    }

    public static final List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, UUID uuid) {
        List<ShareMedia<?, ?>> list;
        Bundle bundle;
        j.g(uuid, "appCallId");
        if (shareMediaContent == null) {
            list = null;
        } else {
            list = shareMediaContent.getMedia();
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareMedia shareMedia : list) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString("uri", attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    public static final String getNativeDialogCompletionGesture(Bundle bundle) {
        j.g(bundle, MamElements.MamResultExtension.ELEMENT);
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    public static final List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, UUID uuid) {
        List<SharePhoto> list;
        j.g(uuid, "appCallId");
        if (sharePhotoContent == null) {
            list = null;
        } else {
            list = sharePhotoContent.getPhotos();
        }
        if (list == null) {
            return null;
        }
        ArrayList<NativeAppCallAttachmentStore.Attachment> arrayList = new ArrayList<>();
        for (SharePhoto attachment : list) {
            NativeAppCallAttachmentStore.Attachment attachment2 = INSTANCE.getAttachment(uuid, attachment);
            if (attachment2 != null) {
                arrayList.add(attachment2);
            }
        }
        ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
        for (NativeAppCallAttachmentStore.Attachment attachmentUrl : arrayList) {
            arrayList2.add(attachmentUrl.getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    public static final String getShareDialogPostId(Bundle bundle) {
        j.g(bundle, MamElements.MamResultExtension.ELEMENT);
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.RESULT_POST_ID);
        }
        if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    public static final ResultProcessor getShareResultProcessor(FacebookCallback<Sharer.Result> facebookCallback) {
        return new ShareInternalUtility$getShareResultProcessor$1(facebookCallback);
    }

    public static final Bundle getStickerUrl(ShareStoryContent shareStoryContent, UUID uuid) {
        j.g(uuid, "appCallId");
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(shareStoryContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, shareStoryContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uri", attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(p.e(attachment));
        return bundle;
    }

    public static final Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        CameraEffectTextures cameraEffectTextures;
        j.g(uuid, "appCallId");
        if (shareCameraEffectContent == null) {
            cameraEffectTextures = null;
        } else {
            cameraEffectTextures = shareCameraEffectContent.getTextures();
        }
        if (cameraEffectTextures == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String next : cameraEffectTextures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(uuid, cameraEffectTextures.getTextureUri(next), cameraEffectTextures.getTextureBitmap(next));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(next, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    public static final String getUriExtension(Uri uri) {
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        j.f(uri2, "uri.toString()");
        int f02 = StringsKt__StringsKt.f0(uri2, '.', 0, false, 6, (Object) null);
        if (f02 == -1) {
            return null;
        }
        String substring = uri2.substring(f02);
        j.f(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        Uri uri;
        ShareVideo video;
        j.g(uuid, "appCallId");
        if (shareVideoContent == null || (video = shareVideoContent.getVideo()) == null) {
            uri = null;
        } else {
            uri = video.getLocalUrl();
        }
        if (uri == null) {
            return null;
        }
        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        NativeAppCallAttachmentStore.addAttachments(p.e(createAttachment));
        return createAttachment.getAttachmentUrl();
    }

    public static final boolean handleActivityResult(int i10, int i11, Intent intent, ResultProcessor resultProcessor) {
        FacebookException facebookException;
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(i10, i11, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        Bundle bundle = null;
        if (intent != null) {
            facebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        } else {
            facebookException = null;
        }
        if (facebookException == null) {
            if (intent != null) {
                bundle = NativeProtocol.getSuccessResultsFromIntent(intent);
            }
            resultProcessor.onSuccess(appCallFromActivityResult, bundle);
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, facebookException);
        }
        return true;
    }

    public static final void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    public static final void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exc) {
        j.g(exc, "exception");
        if (exc instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exc);
        } else {
            invokeCallbackWithError(facebookCallback, j.p("Error preparing share content: ", exc.getLocalizedMessage()));
        }
    }

    public static final void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        j.g(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
    }

    public static final void invokeOnCancelCallback(FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (String) null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, GraphResponse graphResponse, String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
    }

    public static final void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        INSTANCE.logShareResult("succeeded", (String) null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    private final void logShareResult(String str, String str2) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
    }

    public static final void registerSharerCallback(int i10, CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i10, new b(i10, facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerSharerCallback$lambda-1  reason: not valid java name */
    public static final boolean m177registerSharerCallback$lambda1(int i10, FacebookCallback facebookCallback, int i11, Intent intent) {
        return handleActivityResult(i10, i11, intent, getShareResultProcessor(facebookCallback));
    }

    public static final void registerStaticShareCallback(int i10) {
        CallbackManagerImpl.Companion.registerStaticCallback(i10, new a(i10));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerStaticShareCallback$lambda-0  reason: not valid java name */
    public static final boolean m178registerStaticShareCallback$lambda0(int i10, int i11, Intent intent) {
        return handleActivityResult(i10, i11, intent, getShareResultProcessor((FacebookCallback<Sharer.Result>) null));
    }

    public static final a removeNamespacesFromOGJsonArray(a aVar, boolean z10) throws JSONException {
        j.g(aVar, "jsonArray");
        a aVar2 = new a();
        int o10 = aVar.o();
        if (o10 > 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                Object obj = aVar.get(i10);
                if (obj instanceof a) {
                    obj = removeNamespacesFromOGJsonArray((a) obj, z10);
                } else if (obj instanceof b) {
                    obj = removeNamespacesFromOGJsonObject((b) obj, z10);
                }
                aVar2.E(obj);
                if (i11 >= o10) {
                    break;
                }
                i10 = i11;
            }
        }
        return aVar2;
    }

    public static final b removeNamespacesFromOGJsonObject(b bVar, boolean z10) {
        if (bVar == null) {
            return null;
        }
        try {
            b bVar2 = new b();
            b bVar3 = new b();
            a names = bVar.names();
            if (names == null) {
                return null;
            }
            int i10 = 0;
            int o10 = names.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    String n10 = names.n(i10);
                    Object obj = bVar.get(n10);
                    if (obj instanceof b) {
                        obj = removeNamespacesFromOGJsonObject((b) obj, true);
                    } else if (obj instanceof a) {
                        obj = removeNamespacesFromOGJsonArray((a) obj, true);
                    }
                    j.f(n10, SDKConstants.PARAM_KEY);
                    Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(n10);
                    String str = (String) fieldNameAndNamespaceFromFullName.first;
                    String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                    if (z10) {
                        if (str == null || !j.b(str, DeviceRequestsHelper.SDK_HEADER)) {
                            if (str != null) {
                                if (!j.b(str, "og")) {
                                    bVar3.put(str2, obj);
                                }
                            }
                            bVar2.put(str2, obj);
                        } else {
                            bVar2.put(n10, obj);
                        }
                    } else if (str == null || !j.b(str, "fb")) {
                        bVar2.put(str2, obj);
                    } else {
                        bVar2.put(n10, obj);
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
            if (bVar3.length() > 0) {
                bVar2.put("data", (Object) bVar3);
            }
            return bVar2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
    }

    public static final void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, FacebookException facebookException) {
        j.g(facebookException, "ex");
        INSTANCE.logShareResult("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        return null;
    }

    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) throws FileNotFoundException {
        j.g(uri, "imageUri");
        String path = uri.getPath();
        if (Utility.isFileUri(uri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        if (Utility.isContentUri(uri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}
