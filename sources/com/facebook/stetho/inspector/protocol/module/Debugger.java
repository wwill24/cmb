package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import org.json.b;

public class Debugger implements ChromeDevtoolsDomain {
    @ChromeDevtoolsMethod
    public JsonRpcResult canSetScriptSource(JsonRpcPeer jsonRpcPeer, b bVar) {
        return new SimpleBooleanResult(false);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void setPauseOnExceptions(JsonRpcPeer jsonRpcPeer, b bVar) {
    }
}
