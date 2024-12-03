package com.mparticle;

import androidx.annotation.NonNull;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.ReportingMessage;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.a;

public class BaseEvent {
    private Map<String, Object> mCustomAttributes;
    private Map<String, List<String>> mCustomFlags;
    private boolean mShouldUploadEvent = true;
    private MessageType mType;

    public interface MessageType {
        String getMessageType();
    }

    public enum Type implements MessageType {
        SESSION_START(ReportingMessage.MessageType.SESSION_START),
        SESSION_END(ReportingMessage.MessageType.SESSION_END),
        EVENT(ReportingMessage.MessageType.EVENT),
        SCREEN_VIEW(ReportingMessage.MessageType.SCREEN_VIEW),
        COMMERCE_EVENT(ReportingMessage.MessageType.COMMERCE_EVENT),
        OPT_OUT(ReportingMessage.MessageType.OPT_OUT),
        ERROR("x"),
        PUSH_REGISTRATION(ReportingMessage.MessageType.PUSH_REGISTRATION),
        REQUEST_HEADER("h"),
        FIRST_RUN(ReportingMessage.MessageType.FIRST_RUN),
        APP_STATE_TRANSITION(ReportingMessage.MessageType.APP_STATE_TRANSITION),
        PUSH_RECEIVED(ReportingMessage.MessageType.PUSH_RECEIVED),
        BREADCRUMB(ReportingMessage.MessageType.BREADCRUMB),
        NETWORK_PERFORMNACE(ReportingMessage.MessageType.NETWORK_PERFORMNACE),
        PROFILE(ReportingMessage.MessageType.PROFILE),
        USER_ATTRIBUTE_CHANGE("uac"),
        USER_IDENTITY_CHANGE("uic"),
        MEDIA("media_event");
        
        private String messageType;

        private Type(String str) {
            this.messageType = str;
        }

        public String getMessageType() {
            return this.messageType;
        }
    }

    protected BaseEvent(MessageType messageType) {
        this.mType = messageType;
    }

    public Map<String, String> getCustomAttributeStrings() {
        String str;
        if (this.mCustomAttributes == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.mCustomAttributes.entrySet()) {
            Object value = next.getValue();
            String str2 = (String) next.getKey();
            if (value == null) {
                str = null;
            } else {
                str = value.toString();
            }
            hashMap.put(str2, str);
        }
        return hashMap;
    }

    public Map<String, Object> getCustomAttributes() {
        return this.mCustomAttributes;
    }

    public Map<String, List<String>> getCustomFlags() {
        return this.mCustomFlags;
    }

    public d getMessage() {
        return new d(getType().getMessageType());
    }

    @NonNull
    public MessageType getType() {
        return this.mType;
    }

    public boolean isShouldUploadEvent() {
        return this.mShouldUploadEvent;
    }

    public void setCustomAttributes(Map<String, ?> map) {
        if (map != null && MPUtility.containsNullKey(map)) {
            Logger.warning(String.format("disregarding \"Event.customFlag\" value of \"%s\". Key was found to be null", new Object[]{map.get((Object) null)}));
            map.remove((Object) null);
        }
        this.mCustomAttributes = map;
    }

    /* access modifiers changed from: protected */
    public void setCustomFlags(Map<String, List<String>> map) {
        if (map != null && MPUtility.containsNullKey(map)) {
            Logger.warning(String.format("disregarding \"MPEvent.customFlag\" value of %s. Key was found to be null", new Object[]{new a((Collection<?>) map.get((Object) null))}));
            map.remove((Object) null);
        }
        this.mCustomFlags = map;
    }

    /* access modifiers changed from: protected */
    public void setShouldUploadEvent(boolean z10) {
        this.mShouldUploadEvent = z10;
    }

    /* access modifiers changed from: protected */
    public void setType(MessageType messageType) {
        this.mType = messageType;
    }
}
