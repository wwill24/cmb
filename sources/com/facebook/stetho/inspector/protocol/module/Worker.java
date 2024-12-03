package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import org.json.b;

public class Worker implements ChromeDevtoolsDomain {
    @ChromeDevtoolsMethod
    public JsonRpcResult canInspectWorkers(JsonRpcPeer jsonRpcPeer, b bVar) {
        return new SimpleBooleanResult(true);
    }
}
