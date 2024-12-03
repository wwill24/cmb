package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import org.json.b;

public class Inspector implements ChromeDevtoolsDomain {
    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }
}
