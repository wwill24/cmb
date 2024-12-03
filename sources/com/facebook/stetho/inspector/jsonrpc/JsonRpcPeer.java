package com.facebook.stetho.inspector.jsonrpc;

import android.database.Observable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleSession;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import org.json.b;

public class JsonRpcPeer {
    private final DisconnectObservable mDisconnectObservable = new DisconnectObservable();
    private long mNextRequestId;
    private final ObjectMapper mObjectMapper;
    private final SimpleSession mPeer;
    private final Map<Long, PendingRequest> mPendingRequests = new HashMap();

    private static class DisconnectObservable extends Observable<DisconnectReceiver> {
        private DisconnectObservable() {
        }

        public void onDisconnect() {
            int size = this.mObservers.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((DisconnectReceiver) this.mObservers.get(i10)).onDisconnect();
            }
        }
    }

    public JsonRpcPeer(ObjectMapper objectMapper, SimpleSession simpleSession) {
        this.mObjectMapper = objectMapper;
        this.mPeer = (SimpleSession) Util.throwIfNull(simpleSession);
    }

    private synchronized long preparePendingRequest(PendingRequestCallback pendingRequestCallback) {
        long j10;
        j10 = this.mNextRequestId;
        this.mNextRequestId = 1 + j10;
        this.mPendingRequests.put(Long.valueOf(j10), new PendingRequest(j10, pendingRequestCallback));
        return j10;
    }

    public synchronized PendingRequest getAndRemovePendingRequest(long j10) {
        return this.mPendingRequests.remove(Long.valueOf(j10));
    }

    public SimpleSession getWebSocket() {
        return this.mPeer;
    }

    public void invokeDisconnectReceivers() {
        this.mDisconnectObservable.onDisconnect();
    }

    public void invokeMethod(String str, Object obj, PendingRequestCallback pendingRequestCallback) throws NotYetConnectedException {
        Long l10;
        Class cls = b.class;
        Util.throwIfNull(str);
        if (pendingRequestCallback != null) {
            l10 = Long.valueOf(preparePendingRequest(pendingRequestCallback));
        } else {
            l10 = null;
        }
        this.mPeer.sendText(((b) this.mObjectMapper.convertValue(new JsonRpcRequest(l10, str, (b) this.mObjectMapper.convertValue(obj, cls)), cls)).toString());
    }

    public void registerDisconnectReceiver(DisconnectReceiver disconnectReceiver) {
        this.mDisconnectObservable.registerObserver(disconnectReceiver);
    }

    public void unregisterDisconnectReceiver(DisconnectReceiver disconnectReceiver) {
        this.mDisconnectObservable.unregisterObserver(disconnectReceiver);
    }
}
