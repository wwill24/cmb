package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import org.json.b;

public class Profiler implements ChromeDevtoolsDomain {

    private static class ProfileHeader {
        @JsonProperty(required = true)
        String title;
        @JsonProperty(required = true)
        String typeId;
        @JsonProperty(required = true)
        int uid;

        private ProfileHeader() {
        }
    }

    private static class ProfileHeaderResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<ProfileHeader> headers;

        private ProfileHeaderResponse() {
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, b bVar) {
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getProfileHeaders(JsonRpcPeer jsonRpcPeer, b bVar) {
        ProfileHeaderResponse profileHeaderResponse = new ProfileHeaderResponse();
        profileHeaderResponse.headers = Collections.emptyList();
        return profileHeaderResponse;
    }

    @ChromeDevtoolsMethod
    public void setSamplingInterval(JsonRpcPeer jsonRpcPeer, b bVar) {
    }
}
