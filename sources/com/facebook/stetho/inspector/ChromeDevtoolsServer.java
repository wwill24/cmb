package com.facebook.stetho.inspector;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequest;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.CloseCodes;
import com.facebook.stetho.websocket.SimpleEndpoint;
import com.facebook.stetho.websocket.SimpleSession;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.JSONException;
import org.json.b;

public class ChromeDevtoolsServer implements SimpleEndpoint {
    public static final String PATH = "/inspector";
    private static final String TAG = "ChromeDevtoolsServer";
    private final MethodDispatcher mMethodDispatcher;
    private final ObjectMapper mObjectMapper;
    private final Map<SimpleSession, JsonRpcPeer> mPeers = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.facebook.stetho.inspector.ChromeDevtoolsServer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode;

        static {
            int[] iArr = new int[JsonRpcError.ErrorCode.values().length];
            $SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode = iArr;
            try {
                iArr[JsonRpcError.ErrorCode.METHOD_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ChromeDevtoolsServer(Iterable<ChromeDevtoolsDomain> iterable) {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mObjectMapper = objectMapper;
        this.mMethodDispatcher = new MethodDispatcher(objectMapper, iterable);
    }

    private void closeSafely(SimpleSession simpleSession, int i10, String str) {
        simpleSession.close(i10, str);
    }

    private void handleRemoteMessage(JsonRpcPeer jsonRpcPeer, String str) throws IOException, MessageHandlingException, JSONException {
        b bVar = new b(str);
        if (bVar.has(FirebaseAnalytics.Param.METHOD)) {
            handleRemoteRequest(jsonRpcPeer, bVar);
        } else if (bVar.has(MamElements.MamResultExtension.ELEMENT)) {
            handleRemoteResponse(jsonRpcPeer, bVar);
        } else {
            throw new MessageHandlingException("Improper JSON-RPC message: " + str);
        }
    }

    private void handleRemoteRequest(JsonRpcPeer jsonRpcPeer, b bVar) throws MessageHandlingException {
        b bVar2;
        b bVar3;
        String str;
        Class cls = b.class;
        JsonRpcRequest jsonRpcRequest = (JsonRpcRequest) this.mObjectMapper.convertValue(bVar, JsonRpcRequest.class);
        try {
            bVar3 = this.mMethodDispatcher.dispatch(jsonRpcPeer, jsonRpcRequest.method, jsonRpcRequest.params);
            bVar2 = null;
        } catch (JsonRpcException e10) {
            logDispatchException(e10);
            bVar2 = (b) this.mObjectMapper.convertValue(e10.getErrorMessage(), cls);
            bVar3 = null;
        }
        if (jsonRpcRequest.f37933id != null) {
            JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
            jsonRpcResponse.f37934id = jsonRpcRequest.f37933id.longValue();
            jsonRpcResponse.result = bVar3;
            jsonRpcResponse.error = bVar2;
            try {
                str = ((b) this.mObjectMapper.convertValue(jsonRpcResponse, cls)).toString();
            } catch (OutOfMemoryError e11) {
                jsonRpcResponse.result = null;
                jsonRpcResponse.error = (b) this.mObjectMapper.convertValue(e11.getMessage(), cls);
                str = ((b) this.mObjectMapper.convertValue(jsonRpcResponse, cls)).toString();
            }
            jsonRpcPeer.getWebSocket().sendText(str);
        }
    }

    private void handleRemoteResponse(JsonRpcPeer jsonRpcPeer, b bVar) throws MismatchedResponseException {
        JsonRpcResponse jsonRpcResponse = (JsonRpcResponse) this.mObjectMapper.convertValue(bVar, JsonRpcResponse.class);
        PendingRequest andRemovePendingRequest = jsonRpcPeer.getAndRemovePendingRequest(jsonRpcResponse.f37934id);
        if (andRemovePendingRequest != null) {
            PendingRequestCallback pendingRequestCallback = andRemovePendingRequest.callback;
            if (pendingRequestCallback != null) {
                pendingRequestCallback.onResponse(jsonRpcPeer, jsonRpcResponse);
                return;
            }
            return;
        }
        throw new MismatchedResponseException(jsonRpcResponse.f37934id);
    }

    private static void logDispatchException(JsonRpcException jsonRpcException) {
        JsonRpcError errorMessage = jsonRpcException.getErrorMessage();
        if (AnonymousClass1.$SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode[errorMessage.code.ordinal()] != 1) {
            LogRedirector.w(TAG, "Error processing remote message", jsonRpcException);
            return;
        }
        LogRedirector.d(TAG, "Method not implemented: " + errorMessage.message);
    }

    public void onClose(SimpleSession simpleSession, int i10, String str) {
        LogRedirector.d(TAG, "onClose: reason=" + i10 + " " + str);
        JsonRpcPeer remove = this.mPeers.remove(simpleSession);
        if (remove != null) {
            remove.invokeDisconnectReceivers();
        }
    }

    public void onError(SimpleSession simpleSession, Throwable th2) {
        LogRedirector.e(TAG, "onError: ex=" + th2.toString());
    }

    public void onMessage(SimpleSession simpleSession, byte[] bArr, int i10) {
        LogRedirector.d(TAG, "Ignoring binary message of length " + i10);
    }

    public void onOpen(SimpleSession simpleSession) {
        LogRedirector.d(TAG, "onOpen");
        this.mPeers.put(simpleSession, new JsonRpcPeer(this.mObjectMapper, simpleSession));
    }

    public void onMessage(SimpleSession simpleSession, String str) {
        if (LogRedirector.isLoggable(TAG, 2)) {
            LogRedirector.v(TAG, "onMessage: message=" + str);
        }
        try {
            JsonRpcPeer jsonRpcPeer = this.mPeers.get(simpleSession);
            Util.throwIfNull(jsonRpcPeer);
            handleRemoteMessage(jsonRpcPeer, str);
        } catch (IOException e10) {
            if (LogRedirector.isLoggable(TAG, 2)) {
                LogRedirector.v(TAG, "Unexpected I/O exception processing message: " + e10);
            }
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, e10.getClass().getSimpleName());
        } catch (MessageHandlingException e11) {
            LogRedirector.i(TAG, "Message could not be processed by implementation: " + e11);
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, e11.getClass().getSimpleName());
        } catch (JSONException e12) {
            LogRedirector.v(TAG, "Unexpected JSON exception processing message", e12);
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, e12.getClass().getSimpleName());
        }
    }
}
