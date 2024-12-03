package com.leanplum.internal;

import com.leanplum.internal.Request;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    public static final String ACTION_ADVANCE = "advance";
    public static final String ACTION_DELETE_INBOX_MESSAGE = "deleteNewsfeedMessage";
    public static final String ACTION_DOWNLOAD_FILE = "downloadFile";
    public static final String ACTION_GET_INBOX_MESSAGES = "getNewsfeedMessages";
    public static final String ACTION_GET_MIGRATE_STATE = "getMigrateState";
    public static final String ACTION_GET_VARS = "getVars";
    public static final String ACTION_HEARTBEAT = "heartbeat";
    public static final String ACTION_LOG = "log";
    public static final String ACTION_MARK_INBOX_MESSAGE_AS_READ = "markNewsfeedMessageAsRead";
    public static final String ACTION_MULTI = "multi";
    public static final String ACTION_PAUSE_SESSION = "pauseSession";
    public static final String ACTION_PAUSE_STATE = "pauseState";
    public static final String ACTION_REGISTER_FOR_DEVELOPMENT = "registerDevice";
    public static final String ACTION_RESTART = "restart";
    public static final String ACTION_RESUME_SESSION = "resumeSession";
    public static final String ACTION_RESUME_STATE = "resumeState";
    public static final String ACTION_SET_DEVICE_ATTRIBUTES = "setDeviceAttributes";
    public static final String ACTION_SET_TRAFFIC_SOURCE_INFO = "setTrafficSourceInfo";
    public static final String ACTION_SET_USER_ATTRIBUTES = "setUserAttributes";
    public static final String ACTION_SET_VARS = "setVars";
    public static final String ACTION_START = "start";
    public static final String ACTION_STOP = "stop";
    public static final String ACTION_TRACK = "track";
    public static final String ACTION_TRACK_GEOFENCE = "trackGeofence";
    public static final String ACTION_UPLOAD_FILE = "uploadFile";
    public static final String GET = "GET";
    public static final String POST = "POST";
    private String apiAction;
    private String httpMethod;
    private Map<String, Object> params;
    private Request.RequestType type = Request.RequestType.DEFAULT;

    protected RequestBuilder(String str, String str2) {
        this.httpMethod = str;
        this.apiAction = str2;
    }

    public static RequestBuilder withAdvanceAction() {
        return new RequestBuilder("POST", ACTION_ADVANCE);
    }

    public static RequestBuilder withDeleteInboxMessageAction() {
        return new RequestBuilder("POST", ACTION_DELETE_INBOX_MESSAGE);
    }

    public static RequestBuilder withDownloadFileAction() {
        return new RequestBuilder("GET", ACTION_DOWNLOAD_FILE);
    }

    public static RequestBuilder withGetInboxMessagesAction() {
        return new RequestBuilder("POST", ACTION_GET_INBOX_MESSAGES);
    }

    public static RequestBuilder withGetMigrateState() {
        return new RequestBuilder("POST", ACTION_GET_MIGRATE_STATE);
    }

    public static RequestBuilder withGetVarsAction() {
        return new RequestBuilder("POST", ACTION_GET_VARS);
    }

    public static RequestBuilder withHeartbeatAction() {
        return new RequestBuilder("POST", ACTION_HEARTBEAT);
    }

    public static RequestBuilder withLogAction() {
        return new RequestBuilder("POST", ACTION_LOG);
    }

    public static RequestBuilder withMarkInboxMessageAsReadAction() {
        return new RequestBuilder("POST", ACTION_MARK_INBOX_MESSAGE_AS_READ);
    }

    public static RequestBuilder withMultiAction() {
        return new RequestBuilder("POST", ACTION_MULTI);
    }

    public static RequestBuilder withPauseSessionAction() {
        return new RequestBuilder("POST", ACTION_PAUSE_SESSION);
    }

    public static RequestBuilder withPauseStateAction() {
        return new RequestBuilder("POST", ACTION_PAUSE_STATE);
    }

    public static RequestBuilder withRegisterForDevelopmentAction() {
        return new RequestBuilder("POST", ACTION_REGISTER_FOR_DEVELOPMENT);
    }

    public static RequestBuilder withRestartAction() {
        return new RequestBuilder("POST", ACTION_RESTART);
    }

    public static RequestBuilder withResumeSessionAction() {
        return new RequestBuilder("POST", ACTION_RESUME_SESSION);
    }

    public static RequestBuilder withResumeStateAction() {
        return new RequestBuilder("POST", ACTION_RESUME_STATE);
    }

    public static RequestBuilder withSetDeviceAttributesAction() {
        return new RequestBuilder("POST", ACTION_SET_DEVICE_ATTRIBUTES);
    }

    public static RequestBuilder withSetTrafficSourceInfoAction() {
        return new RequestBuilder("POST", ACTION_SET_TRAFFIC_SOURCE_INFO);
    }

    public static RequestBuilder withSetUserAttributesAction() {
        return new RequestBuilder("POST", ACTION_SET_USER_ATTRIBUTES);
    }

    public static RequestBuilder withSetVarsAction() {
        return new RequestBuilder("POST", ACTION_SET_VARS);
    }

    public static RequestBuilder withStartAction() {
        return new RequestBuilder("POST", "start");
    }

    public static RequestBuilder withStopAction() {
        return new RequestBuilder("POST", ACTION_STOP);
    }

    public static RequestBuilder withTrackAction() {
        return new RequestBuilder("POST", ACTION_TRACK);
    }

    public static RequestBuilder withTrackGeofenceAction() {
        return new RequestBuilder("POST", ACTION_TRACK_GEOFENCE);
    }

    public static RequestBuilder withUploadFileAction() {
        return new RequestBuilder("POST", ACTION_UPLOAD_FILE);
    }

    public RequestBuilder andParam(String str, Object obj) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(str, obj);
        return this;
    }

    public RequestBuilder andParams(Map<String, Object> map) {
        Map<String, Object> map2 = this.params;
        if (map2 == null) {
            this.params = map;
        } else {
            map2.putAll(map);
        }
        return this;
    }

    public RequestBuilder andType(Request.RequestType requestType) {
        this.type = requestType;
        return this;
    }

    public Request create() {
        Log.d("Will call API method: %s with params: %s", this.apiAction, this.params);
        return RequestFactory.getInstance().createRequest(this.httpMethod, this.apiAction, this.type, this.params);
    }

    public String getApiAction() {
        return this.apiAction;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public Request.RequestType getType() {
        return this.type;
    }
}
