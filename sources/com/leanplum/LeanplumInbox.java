package com.leanplum;

import android.content.SharedPreferences;
import com.leanplum.callbacks.InboxChangedCallback;
import com.leanplum.callbacks.InboxSyncedCallback;
import com.leanplum.callbacks.VariablesChangedCallback;
import com.leanplum.internal.AESCrypt;
import com.leanplum.internal.APIConfig;
import com.leanplum.internal.CollectionUtil;
import com.leanplum.internal.Constants;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.Log;
import com.leanplum.internal.OperationQueue;
import com.leanplum.internal.Request;
import com.leanplum.internal.RequestBuilder;
import com.leanplum.internal.RequestSender;
import com.leanplum.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.b;

public class LeanplumInbox {
    static Set<String> downloadedImageUrls;
    private static LeanplumInbox instance = new LeanplumInbox();
    static boolean isInboxImagePrefetchingEnabled = true;
    private final List<InboxChangedCallback> changedCallbacks;
    private volatile boolean didLoad;
    private volatile Map<String, LeanplumInboxMessage> messages;
    private final List<InboxSyncedCallback> syncedCallbacks;
    private volatile int unreadCount;
    private final Object updatingLock;

    private LeanplumInbox() {
        this.didLoad = false;
        this.updatingLock = new Object();
        this.unreadCount = 0;
        this.messages = new HashMap();
        this.didLoad = false;
        this.changedCallbacks = new ArrayList();
        this.syncedCallbacks = new ArrayList();
        downloadedImageUrls = new HashSet();
    }

    public static void disableImagePrefetching() {
        isInboxImagePrefetchingEnabled = false;
    }

    static LeanplumInbox getInstance() {
        return instance;
    }

    public void addChangedHandler(InboxChangedCallback inboxChangedCallback) {
        synchronized (this.changedCallbacks) {
            this.changedCallbacks.add(inboxChangedCallback);
        }
        if (this.didLoad) {
            inboxChangedCallback.inboxChanged();
        }
    }

    public void addSyncedHandler(InboxSyncedCallback inboxSyncedCallback) {
        synchronized (this.syncedCallbacks) {
            this.syncedCallbacks.add(inboxSyncedCallback);
        }
    }

    public List<LeanplumInboxMessage> allMessages() {
        return allMessages(new ArrayList());
    }

    public int count() {
        return this.messages.size();
    }

    public void downloadMessages() {
        downloadMessages((InboxSyncedCallback) null);
    }

    /* access modifiers changed from: package-private */
    public boolean isInboxImagePrefetchingEnabled() {
        return isInboxImagePrefetchingEnabled;
    }

    /* access modifiers changed from: package-private */
    public void load() {
        int i10;
        if (!Constants.isNoop()) {
            SharedPreferences sharedPreferences = Leanplum.getContext().getSharedPreferences(Constants.Defaults.LEANPLUM, 0);
            if (APIConfig.getInstance().token() == null) {
                update(new HashMap(), 0, false);
                return;
            }
            String decodePreference = new AESCrypt(APIConfig.getInstance().appId(), APIConfig.getInstance().token()).decodePreference(sharedPreferences, Constants.Defaults.INBOX_KEY, "{}");
            Map<String, Object> fromJson = JsonConverter.fromJson(decodePreference);
            HashMap hashMap = new HashMap();
            if (fromJson == null) {
                Log.e("Could not parse newsfeed string: " + decodePreference, new Object[0]);
                i10 = 0;
            } else {
                i10 = 0;
                for (Map.Entry next : fromJson.entrySet()) {
                    String str = (String) next.getKey();
                    LeanplumInboxMessage createFromJsonMap = LeanplumInboxMessage.createFromJsonMap(str, (Map) CollectionUtil.uncheckedCast(next.getValue()));
                    if (createFromJsonMap != null && createFromJsonMap.isActive()) {
                        hashMap.put(str, createFromJsonMap);
                        if (!createFromJsonMap.isRead()) {
                            i10++;
                        }
                    }
                }
            }
            update(hashMap, i10, false);
        }
    }

    public LeanplumInboxMessage messageForId(String str) {
        return this.messages.get(str);
    }

    public List<String> messagesIds() {
        ArrayList arrayList = new ArrayList(this.messages.keySet());
        try {
            Collections.sort(arrayList, new Comparator<String>() {
                public int compare(String str, String str2) {
                    LeanplumInboxMessage messageForId = LeanplumInbox.this.messageForId(str);
                    if (messageForId == null) {
                        return -1;
                    }
                    LeanplumInboxMessage messageForId2 = LeanplumInbox.this.messageForId(str2);
                    if (messageForId2 == null) {
                        return 1;
                    }
                    Date deliveryTimestamp = messageForId.getDeliveryTimestamp();
                    if (deliveryTimestamp == null) {
                        return -1;
                    }
                    Date deliveryTimestamp2 = messageForId2.getDeliveryTimestamp();
                    if (deliveryTimestamp2 == null) {
                        return 1;
                    }
                    return deliveryTimestamp.compareTo(deliveryTimestamp2);
                }
            });
        } catch (Throwable th2) {
            Log.exception(th2);
        }
        return arrayList;
    }

    public void removeChangedHandler(InboxChangedCallback inboxChangedCallback) {
        synchronized (this.changedCallbacks) {
            this.changedCallbacks.remove(inboxChangedCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeMessage(String str) {
        int i10 = this.unreadCount;
        LeanplumInboxMessage messageForId = messageForId(str);
        if (messageForId != null && !messageForId.isRead()) {
            i10--;
        }
        this.messages.remove(str);
        update(this.messages, i10, true);
        if (!Constants.isNoop()) {
            RequestSender.getInstance().send(RequestBuilder.withDeleteInboxMessageAction().andParam(Constants.Params.INBOX_MESSAGE_ID, str).create());
        }
    }

    public void removeSyncedHandler(InboxSyncedCallback inboxSyncedCallback) {
        synchronized (this.syncedCallbacks) {
            this.syncedCallbacks.remove(inboxSyncedCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void save() {
        if (!Constants.isNoop() && APIConfig.getInstance().token() != null) {
            SharedPreferences.Editor edit = Leanplum.getContext().getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
            HashMap hashMap = new HashMap();
            for (Map.Entry next : this.messages.entrySet()) {
                hashMap.put((String) next.getKey(), ((LeanplumInboxMessage) next.getValue()).toJsonMap());
            }
            edit.putString(Constants.Defaults.INBOX_KEY, new AESCrypt(APIConfig.getInstance().appId(), APIConfig.getInstance().token()).encrypt(JsonConverter.toJson(hashMap)));
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    /* access modifiers changed from: package-private */
    public void triggerChanged() {
        synchronized (this.changedCallbacks) {
            for (InboxChangedCallback addUiOperation : this.changedCallbacks) {
                OperationQueue.sharedInstance().addUiOperation(addUiOperation);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void triggerInboxSyncedWithStatus(boolean z10) {
        synchronized (this.syncedCallbacks) {
            for (InboxSyncedCallback next : this.syncedCallbacks) {
                next.setSuccess(z10);
                OperationQueue.sharedInstance().addUiOperation(next);
            }
        }
    }

    public int unreadCount() {
        return this.unreadCount;
    }

    public List<LeanplumInboxMessage> unreadMessages() {
        return unreadMessages(new ArrayList());
    }

    /* access modifiers changed from: package-private */
    public void update(Map<String, LeanplumInboxMessage> map, int i10, boolean z10) {
        try {
            synchronized (this.updatingLock) {
                this.unreadCount = i10;
                if (map != null) {
                    this.messages = map;
                }
            }
            this.didLoad = true;
            if (z10) {
                save();
            }
            triggerChanged();
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateUnreadCount(int i10) {
        this.unreadCount = i10;
        save();
        triggerChanged();
    }

    private List<LeanplumInboxMessage> allMessages(List<LeanplumInboxMessage> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        try {
            for (String messageForId : messagesIds()) {
                LeanplumInboxMessage messageForId2 = messageForId(messageForId);
                if (messageForId2 != null) {
                    list.add(messageForId2);
                }
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
        return list;
    }

    private List<LeanplumInboxMessage> unreadMessages(List<LeanplumInboxMessage> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (LeanplumInboxMessage next : allMessages((List<LeanplumInboxMessage>) null)) {
            if (!next.isRead()) {
                list.add(next);
            }
        }
        return list;
    }

    public void downloadMessages(final InboxSyncedCallback inboxSyncedCallback) {
        if (!Constants.isNoop()) {
            Request create = RequestBuilder.withGetInboxMessagesAction().andType(Request.RequestType.IMMEDIATE).create();
            create.onResponse(new Request.ResponseCallback() {
                public void response(b bVar) {
                    if (bVar == null) {
                        try {
                            Log.e("No inbox response received from the server.", new Object[0]);
                        } catch (Throwable th2) {
                            LeanplumInbox.this.triggerInboxSyncedWithStatus(false, inboxSyncedCallback);
                            Log.exception(th2);
                        }
                    } else {
                        b optJSONObject = bVar.optJSONObject("newsfeedMessages");
                        if (optJSONObject == null) {
                            Log.e("No inbox messages found in the response from the server. %s", bVar);
                            return;
                        }
                        final HashMap hashMap = new HashMap();
                        Boolean bool = Boolean.FALSE;
                        Iterator<String> keys = optJSONObject.keys();
                        final int i10 = 0;
                        while (keys.hasNext()) {
                            String next = keys.next();
                            b jSONObject = optJSONObject.getJSONObject(next);
                            Map mapFromJson = JsonConverter.mapFromJson(jSONObject.getJSONObject(Constants.Keys.MESSAGE_DATA).getJSONObject("vars"));
                            Long valueOf = Long.valueOf(jSONObject.getLong(Constants.Keys.DELIVERY_TIMESTAMP));
                            Long l10 = null;
                            if (jSONObject.opt(Constants.Keys.EXPIRATION_TIMESTAMP) != null) {
                                l10 = Long.valueOf(jSONObject.getLong(Constants.Keys.EXPIRATION_TIMESTAMP));
                            }
                            boolean z10 = jSONObject.getBoolean(Constants.Keys.IS_READ);
                            LeanplumInboxMessage constructMessage = LeanplumInboxMessage.constructMessage(next, valueOf, l10, z10, mapFromJson);
                            if (constructMessage != null) {
                                bool = Boolean.valueOf(bool.booleanValue() | constructMessage.downloadImageIfPrefetchingEnabled());
                                if (!z10) {
                                    i10++;
                                }
                                hashMap.put(next, constructMessage);
                            }
                        }
                        if (!bool.booleanValue()) {
                            LeanplumInbox.this.update(hashMap, i10, true);
                            LeanplumInbox.this.triggerInboxSyncedWithStatus(true, inboxSyncedCallback);
                            return;
                        }
                        Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new VariablesChangedCallback() {
                            public void variablesChanged() {
                                LeanplumInbox.this.update(hashMap, i10, true);
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                LeanplumInbox.this.triggerInboxSyncedWithStatus(true, inboxSyncedCallback);
                            }
                        });
                    }
                }
            });
            create.onError(new Request.ErrorCallback() {
                public void error(Exception exc) {
                    LeanplumInbox.this.triggerInboxSyncedWithStatus(false, inboxSyncedCallback);
                }
            });
            RequestSender.getInstance().send(create);
        }
    }

    /* access modifiers changed from: private */
    public void triggerInboxSyncedWithStatus(boolean z10, InboxSyncedCallback inboxSyncedCallback) {
        if (inboxSyncedCallback != null) {
            addSyncedHandler(inboxSyncedCallback);
            triggerInboxSyncedWithStatus(z10);
            removeSyncedHandler(inboxSyncedCallback);
            return;
        }
        triggerInboxSyncedWithStatus(z10);
    }
}
