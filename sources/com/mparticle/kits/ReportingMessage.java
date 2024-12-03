package com.mparticle.kits;

import android.content.Intent;
import com.mparticle.BaseEvent;
import com.mparticle.MPEvent;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.internal.JsonReportingMessage;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.mappings.CustomMapping;
import java.util.LinkedList;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class ReportingMessage implements JsonReportingMessage {
    private Map<String, ?> attributes;
    private boolean devMode;
    private String eventName = null;
    private String eventType = null;
    private String exceptionClassName;
    private String mSessionId;
    private String messageType;
    private final int moduleId;
    private boolean optOut;
    private LinkedList<ProjectionReport> projectionReports;
    private String screenName;
    private final long timestamp;

    public interface MessageType {
        public static final String APP_STATE_TRANSITION = "ast";
        public static final String BREADCRUMB = "bc";
        public static final String COMMERCE_EVENT = "cm";
        public static final String ERROR = "x";
        public static final String EVENT = "e";
        public static final String FIRST_RUN = "fr";
        public static final String NETWORK_PERFORMNACE = "npe";
        public static final String OPT_OUT = "o";
        public static final String PROFILE = "pro";
        public static final String PUSH_RECEIVED = "pm";
        public static final String PUSH_REGISTRATION = "pr";
        public static final String REQUEST_HEADER = "h";
        public static final String SCREEN_VIEW = "v";
        public static final String SESSION_END = "se";
        public static final String SESSION_START = "ss";
    }

    public ReportingMessage(KitIntegration kitIntegration, String str, long j10, Map<String, ?> map) {
        this.moduleId = kitIntegration.getConfiguration().getKitId();
        this.messageType = str;
        this.timestamp = j10;
        this.attributes = map;
    }

    public static ReportingMessage fromEvent(KitIntegration kitIntegration, BaseEvent baseEvent) {
        ReportingMessage reportingMessage = new ReportingMessage(kitIntegration, baseEvent.getType().getMessageType(), System.currentTimeMillis(), baseEvent.getCustomAttributeStrings());
        if (baseEvent instanceof MPEvent) {
            MPEvent mPEvent = (MPEvent) baseEvent;
            reportingMessage.eventType = mPEvent.getEventType().name();
            reportingMessage.eventName = mPEvent.getEventName();
        } else if (baseEvent instanceof CommerceEvent) {
            reportingMessage.eventType = CommerceEventUtils.getEventTypeString((CommerceEvent) baseEvent);
        }
        return reportingMessage;
    }

    public static ReportingMessage fromPushMessage(KitIntegration kitIntegration, Intent intent) {
        return new ReportingMessage(kitIntegration, MessageType.PUSH_RECEIVED, System.currentTimeMillis(), (Map<String, ?>) null);
    }

    public static ReportingMessage fromPushRegistrationMessage(KitIntegration kitIntegration) {
        return new ReportingMessage(kitIntegration, MessageType.PUSH_REGISTRATION, System.currentTimeMillis(), (Map<String, ?>) null);
    }

    public static ReportingMessage logoutMessage(KitIntegration kitIntegration) {
        return new ReportingMessage(kitIntegration, MessageType.PROFILE, System.currentTimeMillis(), (Map<String, ?>) null);
    }

    public void addProjectionReport(ProjectionReport projectionReport) {
        if (this.projectionReports == null) {
            this.projectionReports = new LinkedList<>();
        }
        this.projectionReports.add(projectionReport);
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getEventTypeString() {
        return this.eventType;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public ReportingMessage setAttributes(Map<String, ?> map) {
        this.attributes = map;
        return this;
    }

    public void setDevMode(boolean z10) {
        this.devMode = z10;
    }

    public ReportingMessage setEventName(String str) {
        this.eventName = str;
        return this;
    }

    public void setExceptionClassName(String str) {
        this.exceptionClassName = str;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public ReportingMessage setOptOut(boolean z10) {
        this.optOut = z10;
        return this;
    }

    public ReportingMessage setScreenName(String str) {
        this.screenName = str;
        return this;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public b toJson() {
        Map<String, ?> map;
        b bVar = new b();
        try {
            bVar.put("mid", this.moduleId);
            bVar.put("dt", (Object) this.messageType);
            bVar.put("ct", this.timestamp);
            if (this.projectionReports != null) {
                a aVar = new a();
                for (int i10 = 0; i10 < this.projectionReports.size(); i10++) {
                    b bVar2 = new b();
                    bVar2.put("pid", this.projectionReports.get(i10).projectionId);
                    bVar2.put("dt", (Object) this.projectionReports.get(i10).messageType);
                    bVar2.put("name", (Object) this.projectionReports.get(i10).eventName);
                    bVar2.put("et", (Object) this.projectionReports.get(i10).eventType);
                    aVar.E(bVar2);
                }
                if (aVar.o() > 0) {
                    bVar.put("proj", (Object) aVar);
                }
            }
            if (this.devMode && (map = this.attributes) != null && map.size() > 0) {
                b bVar3 = new b();
                for (Map.Entry next : this.attributes.entrySet()) {
                    bVar3.put((String) next.getKey(), next.getValue());
                }
                bVar.put("attrs", (Object) bVar3);
            }
            if (this.messageType.equals(MessageType.EVENT)) {
                if (!MPUtility.isEmpty((CharSequence) this.eventName)) {
                    bVar.put("n", (Object) this.eventName);
                }
                if (!MPUtility.isEmpty((CharSequence) this.eventType)) {
                    bVar.put("et", (Object) this.eventType);
                }
            } else if (this.messageType.equals(MessageType.SCREEN_VIEW)) {
                if (!MPUtility.isEmpty((CharSequence) this.screenName)) {
                    bVar.put("n", (Object) this.screenName);
                }
            } else if (this.messageType.equals(MessageType.PUSH_REGISTRATION)) {
                bVar.put(StreamManagement.AckRequest.ELEMENT, true);
            } else if (this.messageType.equals(MessageType.OPT_OUT)) {
                bVar.put("s", this.optOut);
            } else if (this.messageType.equals("x")) {
                bVar.put("c", (Object) this.exceptionClassName);
            } else if (this.messageType.equals(MessageType.COMMERCE_EVENT) && !MPUtility.isEmpty((CharSequence) this.eventType)) {
                bVar.put("et", (Object) this.eventType);
            }
        } catch (JSONException unused) {
        }
        return bVar;
    }

    public static class ProjectionReport {
        /* access modifiers changed from: private */
        public final String eventName;
        /* access modifiers changed from: private */
        public final String eventType;
        /* access modifiers changed from: private */
        public final String messageType;
        /* access modifiers changed from: private */
        public final int projectionId;

        public ProjectionReport(int i10, String str, String str2, String str3) {
            this.projectionId = i10;
            this.messageType = str;
            this.eventName = str2;
            this.eventType = str3;
        }

        public static ProjectionReport fromEvent(int i10, MPEvent mPEvent) {
            return new ProjectionReport(i10, MessageType.EVENT, mPEvent.getEventName(), mPEvent.getEventType().name());
        }

        public static ProjectionReport fromProjectionResult(CustomMapping.ProjectionResult projectionResult) {
            if (projectionResult.getMPEvent() != null) {
                return fromEvent(projectionResult.getProjectionId(), projectionResult.getMPEvent());
            }
            return fromEvent(projectionResult.getProjectionId(), projectionResult.getCommerceEvent());
        }

        public static ProjectionReport fromEvent(int i10, CommerceEvent commerceEvent) {
            return new ProjectionReport(i10, MessageType.EVENT, commerceEvent.getEventName(), CommerceEventUtils.getEventTypeString(commerceEvent));
        }
    }
}
