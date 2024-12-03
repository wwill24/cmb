package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.screencast.ScreencastDispatcher;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.b;

public class Page implements ChromeDevtoolsDomain {
    public static final String BANNER = "_____/\\\\\\\\\\\\\\\\\\\\\\_______________________________________________/\\\\\\_______________________\n ___/\\\\\\/////////\\\\\\____________________________________________\\/\\\\\\_______________________\n  __\\//\\\\\\______\\///______/\\\\\\_________________________/\\\\\\______\\/\\\\\\_______________________\n   ___\\////\\\\\\__________/\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\_____________/\\\\\\\\\\____\n    ______\\////\\\\\\______\\////\\\\\\////____/\\\\\\/////\\\\\\_\\////\\\\\\////__\\/\\\\\\\\\\\\\\\\\\\\____/\\\\\\///\\\\\\__\n     _________\\////\\\\\\______\\/\\\\\\_______/\\\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\______\\/\\\\\\/////\\\\\\__/\\\\\\__\\//\\\\\\_\n      __/\\\\\\______\\//\\\\\\_____\\/\\\\\\_/\\\\__\\//\\\\///////______\\/\\\\\\_/\\\\__\\/\\\\\\___\\/\\\\\\_\\//\\\\\\__/\\\\\\__\n       _\\///\\\\\\\\\\\\\\\\\\\\\\/______\\//\\\\\\\\\\____\\//\\\\\\\\\\\\\\\\\\\\____\\//\\\\\\\\\\___\\/\\\\\\___\\/\\\\\\__\\///\\\\\\\\\\/___\n        ___\\///////////_________\\/////______\\//////////______\\/////____\\///____\\///_____\\/////_____\n         Welcome to Stetho";
    private final Context mContext;
    private final String mMessage;
    private final ObjectMapper mObjectMapper;
    private ScreencastDispatcher mScreencastDispatcher;

    private static class ExecutionContextCreatedParams {
        @JsonProperty(required = true)
        public ExecutionContextDescription context;

        private ExecutionContextCreatedParams() {
        }
    }

    private static class ExecutionContextDescription {
        @JsonProperty(required = true)
        public String frameId;
        @JsonProperty(required = true)

        /* renamed from: id  reason: collision with root package name */
        public int f37940id;

        private ExecutionContextDescription() {
        }
    }

    private static class Frame {
        @JsonProperty(required = true)

        /* renamed from: id  reason: collision with root package name */
        public String f37941id;
        @JsonProperty(required = true)
        public String loaderId;
        @JsonProperty(required = true)
        public String mimeType;
        @JsonProperty
        public String name;
        @JsonProperty
        public String parentId;
        @JsonProperty(required = true)
        public String securityOrigin;
        @JsonProperty(required = true)
        public String url;

        private Frame() {
        }
    }

    private static class FrameResourceTree {
        @JsonProperty
        public List<FrameResourceTree> childFrames;
        @JsonProperty(required = true)
        public Frame frame;
        @JsonProperty(required = true)
        public List<Resource> resources;

        private FrameResourceTree() {
        }
    }

    private static class GetResourceTreeParams implements JsonRpcResult {
        @JsonProperty(required = true)
        public FrameResourceTree frameTree;

        private GetResourceTreeParams() {
        }
    }

    private static class Resource {
        private Resource() {
        }
    }

    public enum ResourceType {
        DOCUMENT("Document"),
        STYLESHEET("Stylesheet"),
        IMAGE(Constants.Keys.INBOX_IMAGE),
        FONT("Font"),
        SCRIPT("Script"),
        XHR("XHR"),
        WEBSOCKET("WebSocket"),
        OTHER("Other");
        
        private final String mProtocolValue;

        private ResourceType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    public static class ScreencastFrameEvent {
        @JsonProperty(required = true)
        public String data;
        @JsonProperty(required = true)
        public ScreencastFrameEventMetadata metadata;
    }

    public static class ScreencastFrameEventMetadata {
        @JsonProperty(required = true)
        public int deviceHeight;
        @JsonProperty(required = true)
        public int deviceWidth;
        @JsonProperty(required = true)
        public int offsetTop;
        @JsonProperty(required = true)
        public int pageScaleFactor;
        @JsonProperty(required = true)
        public int scrollOffsetX;
        @JsonProperty(required = true)
        public int scrollOffsetY;
    }

    public static class StartScreencastRequest {
        @JsonProperty

        /* renamed from: format  reason: collision with root package name */
        public String f37942format;
        @JsonProperty
        public int maxHeight;
        @JsonProperty
        public int maxWidth;
        @JsonProperty
        public int quality;
    }

    public Page(Context context) {
        this(context, BANNER);
    }

    private static FrameResourceTree createSimpleFrameResourceTree(String str, String str2, String str3, String str4) {
        Frame frame = new Frame();
        frame.f37941id = str;
        frame.parentId = str2;
        frame.loaderId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        frame.name = str3;
        frame.url = "";
        frame.securityOrigin = str4;
        frame.mimeType = "text/plain";
        FrameResourceTree frameResourceTree = new FrameResourceTree();
        frameResourceTree.frame = frame;
        frameResourceTree.resources = Collections.emptyList();
        frameResourceTree.childFrames = null;
        return frameResourceTree;
    }

    private void notifyExecutionContexts(JsonRpcPeer jsonRpcPeer) {
        ExecutionContextDescription executionContextDescription = new ExecutionContextDescription();
        executionContextDescription.frameId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        executionContextDescription.f37940id = 1;
        ExecutionContextCreatedParams executionContextCreatedParams = new ExecutionContextCreatedParams();
        executionContextCreatedParams.context = executionContextDescription;
        jsonRpcPeer.invokeMethod("Runtime.executionContextCreated", executionContextCreatedParams, (PendingRequestCallback) null);
    }

    private void sendWelcomeMessage(JsonRpcPeer jsonRpcPeer) {
        Console.ConsoleMessage consoleMessage = new Console.ConsoleMessage();
        consoleMessage.source = Console.MessageSource.JAVASCRIPT;
        consoleMessage.level = Console.MessageLevel.LOG;
        consoleMessage.text = this.mMessage + "\n          Attached to " + ProcessUtil.getProcessName() + "\n";
        Console.MessageAddedRequest messageAddedRequest = new Console.MessageAddedRequest();
        messageAddedRequest.message = consoleMessage;
        jsonRpcPeer.invokeMethod("Console.messageAdded", messageAddedRequest, (PendingRequestCallback) null);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult canScreencast(JsonRpcPeer jsonRpcPeer, b bVar) {
        return new SimpleBooleanResult(true);
    }

    @ChromeDevtoolsMethod
    public void clearDeviceOrientationOverride(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void clearGeolocationOverride(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, b bVar) {
        notifyExecutionContexts(jsonRpcPeer);
        sendWelcomeMessage(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getResourceTree(JsonRpcPeer jsonRpcPeer, b bVar) {
        String str;
        Iterator<String> it = SharedPreferencesHelper.getSharedPreferenceTags(this.mContext).iterator();
        if (it.hasNext()) {
            str = it.next();
        } else {
            str = "";
        }
        FrameResourceTree createSimpleFrameResourceTree = createSimpleFrameResourceTree(AppEventsConstants.EVENT_PARAM_VALUE_YES, (String) null, "Stetho", str);
        if (createSimpleFrameResourceTree.childFrames == null) {
            createSimpleFrameResourceTree.childFrames = new ArrayList();
        }
        int i10 = 1;
        while (it.hasNext()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("1.");
            int i11 = i10 + 1;
            sb2.append(i10);
            String sb3 = sb2.toString();
            createSimpleFrameResourceTree.childFrames.add(createSimpleFrameResourceTree(sb3, AppEventsConstants.EVENT_PARAM_VALUE_YES, "Child #" + sb3, it.next()));
            i10 = i11;
        }
        GetResourceTreeParams getResourceTreeParams = new GetResourceTreeParams();
        getResourceTreeParams.frameTree = createSimpleFrameResourceTree;
        return getResourceTreeParams;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult hasTouchInputs(JsonRpcPeer jsonRpcPeer, b bVar) {
        return new SimpleBooleanResult(false);
    }

    @ChromeDevtoolsMethod
    public void screencastFrameAck(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void setDeviceMetricsOverride(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void setEmulatedMedia(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void setShowViewportSizeOnResize(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void setTouchEmulationEnabled(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void startScreencast(JsonRpcPeer jsonRpcPeer, b bVar) {
        StartScreencastRequest startScreencastRequest = (StartScreencastRequest) this.mObjectMapper.convertValue(bVar, StartScreencastRequest.class);
        if (this.mScreencastDispatcher == null) {
            ScreencastDispatcher screencastDispatcher = new ScreencastDispatcher();
            this.mScreencastDispatcher = screencastDispatcher;
            screencastDispatcher.startScreencast(jsonRpcPeer, startScreencastRequest);
        }
    }

    @ChromeDevtoolsMethod
    public void stopScreencast(JsonRpcPeer jsonRpcPeer, b bVar) {
        ScreencastDispatcher screencastDispatcher = this.mScreencastDispatcher;
        if (screencastDispatcher != null) {
            screencastDispatcher.stopScreencast();
            this.mScreencastDispatcher = null;
        }
    }

    public Page(Context context, String str) {
        this.mObjectMapper = new ObjectMapper();
        this.mContext = context;
        this.mMessage = str;
    }
}
