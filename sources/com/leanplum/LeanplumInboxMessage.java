package com.leanplum;

import android.net.Uri;
import android.text.TextUtils;
import com.leanplum.internal.CollectionUtil;
import com.leanplum.internal.Constants;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.Log;
import com.leanplum.internal.RequestBuilder;
import com.leanplum.internal.RequestSender;
import com.leanplum.internal.Util;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.b;

public class LeanplumInboxMessage {
    private ActionContext context;
    private Long deliveryTimestamp;
    private Long expirationTimestamp;
    private String imageFileName;
    private String imageUrl;
    private boolean isRead;
    private String messageId;

    private LeanplumInboxMessage(String str, Long l10, Long l11, boolean z10, ActionContext actionContext) {
        this.messageId = str;
        this.deliveryTimestamp = l10;
        this.expirationTimestamp = l11;
        this.isRead = z10;
        this.context = actionContext;
        String stringNamed = actionContext.stringNamed(Constants.Keys.INBOX_IMAGE);
        this.imageUrl = stringNamed;
        if (stringNamed != null) {
            try {
                this.imageFileName = Util.sha256(stringNamed);
            } catch (Exception unused) {
            }
        }
    }

    private Map<String, Object> actionArgs() {
        return this.context.getArgs();
    }

    static LeanplumInboxMessage constructMessage(String str, Long l10, Long l11, boolean z10, Map<String, Object> map) {
        if (!isValidMessageId(str)) {
            Log.e("Malformed inbox messageId: " + str, new Object[0]);
            return null;
        }
        ActionContext actionContext = new ActionContext((String) map.get(Constants.Values.ACTION_ARG), map, str.split("##")[0]);
        actionContext.preventRealtimeUpdating();
        actionContext.update();
        return new LeanplumInboxMessage(str, l10, l11, z10, actionContext);
    }

    static LeanplumInboxMessage createFromJsonMap(String str, Map<String, Object> map) {
        boolean z10;
        Map map2 = (Map) CollectionUtil.uncheckedCast(map.get(Constants.Keys.MESSAGE_DATA));
        Long l10 = (Long) CollectionUtil.uncheckedCast(map.get(Constants.Keys.DELIVERY_TIMESTAMP));
        Long l11 = (Long) CollectionUtil.uncheckedCast(map.get(Constants.Keys.EXPIRATION_TIMESTAMP));
        Boolean bool = (Boolean) CollectionUtil.uncheckedCast(map.get(Constants.Keys.IS_READ));
        if (bool != null) {
            z10 = bool.booleanValue();
        } else {
            z10 = false;
        }
        return constructMessage(str, l10, l11, z10, map2);
    }

    private static boolean isValidMessageId(String str) {
        return str.split("##").length == 2;
    }

    private void setIsRead(boolean z10) {
        this.isRead = z10;
    }

    /* access modifiers changed from: package-private */
    public boolean downloadImageIfPrefetchingEnabled() {
        if (!LeanplumInbox.isInboxImagePrefetchingEnabled || TextUtils.isEmpty(this.imageUrl) || LeanplumInbox.downloadedImageUrls.contains(this.imageUrl)) {
            return false;
        }
        String str = this.imageFileName;
        String str2 = this.imageUrl;
        FileManager.DownloadFileResult maybeDownloadFile = FileManager.maybeDownloadFile(true, str, str2, str2, (Runnable) null);
        LeanplumInbox.downloadedImageUrls.add(this.imageUrl);
        if (FileManager.DownloadFileResult.DOWNLOADING == maybeDownloadFile) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ActionContext getContext() {
        return this.context;
    }

    public b getData() {
        try {
            return JsonConverter.mapToJsonObject((Map) CollectionUtil.uncheckedCast(getContext().objectNamed(Constants.Keys.DATA)));
        } catch (Throwable unused) {
            Log.i("Unable to parse JSONObject for Data field of inbox message.", new Object[0]);
            return null;
        }
    }

    public Date getDeliveryTimestamp() {
        if (this.deliveryTimestamp == null) {
            return null;
        }
        return new Date(this.deliveryTimestamp.longValue());
    }

    public Date getExpirationTimestamp() {
        if (this.expirationTimestamp == null) {
            return null;
        }
        return new Date(this.expirationTimestamp.longValue());
    }

    public String getImageFilePath() {
        String fileValue = FileManager.fileValue(this.imageFileName);
        if (FileManager.fileExistsAtPath(fileValue)) {
            return new File(fileValue).getAbsolutePath();
        }
        if (LeanplumInbox.getInstance().isInboxImagePrefetchingEnabled()) {
            return null;
        }
        Log.i("Inbox Message image path is null because you're calling disableImagePrefetching. Consider using imageURL method or remove disableImagePrefetching.", new Object[0]);
        return null;
    }

    public Uri getImageUrl() {
        String fileValue = FileManager.fileValue(this.imageFileName);
        if (FileManager.fileExistsAtPath(fileValue)) {
            return Uri.fromFile(new File(fileValue));
        }
        if (TextUtils.isEmpty(this.imageUrl)) {
            return null;
        }
        return Uri.parse(this.imageUrl);
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getSubtitle() {
        return this.context.stringNamed(Constants.Keys.SUBTITLE);
    }

    public String getTitle() {
        return this.context.stringNamed("Title");
    }

    /* access modifiers changed from: package-private */
    public boolean isActive() {
        if (this.expirationTimestamp == null) {
            return true;
        }
        return new Date().before(new Date(this.expirationTimestamp.longValue()));
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void markAsRead() {
        try {
            if (!Constants.isNoop() && !this.isRead) {
                setIsRead(true);
                LeanplumInbox.getInstance().updateUnreadCount(LeanplumInbox.getInstance().unreadCount() - 1);
                RequestSender.getInstance().send(RequestBuilder.withMarkInboxMessageAsReadAction().andParam(Constants.Params.INBOX_MESSAGE_ID, this.messageId).create());
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void read() {
        try {
            if (!Constants.isNoop()) {
                markAsRead();
                getContext().runTrackedActionNamed(Constants.Values.DEFAULT_PUSH_ACTION);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void remove() {
        try {
            LeanplumInbox.getInstance().removeMessage(this.messageId);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> toJsonMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Keys.DELIVERY_TIMESTAMP, this.deliveryTimestamp);
        hashMap.put(Constants.Keys.EXPIRATION_TIMESTAMP, this.expirationTimestamp);
        hashMap.put(Constants.Keys.MESSAGE_DATA, actionArgs());
        hashMap.put(Constants.Keys.IS_READ, Boolean.valueOf(isRead()));
        return hashMap;
    }
}
