package org.jivesoftware.smackx.iot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.iot.control.ThingControlRequest;
import org.jivesoftware.smackx.iot.data.ThingMomentaryReadOutRequest;
import org.jivesoftware.smackx.iot.discovery.element.Tag;
import org.jivesoftware.smackx.iot.element.NodeInfo;

public final class Thing {
    private final ThingControlRequest controlRequestHandler;
    private final HashMap<String, Tag> metaTags;
    private final ThingMomentaryReadOutRequest momentaryReadOutRequestHandler;
    private final NodeInfo nodeInfo;
    private final boolean selfOwned;
    private String toStringCache;

    public static class Builder {
        /* access modifiers changed from: private */
        public ThingControlRequest controlRequest;
        /* access modifiers changed from: private */
        public HashMap<String, Tag> metaTags = new HashMap<>();
        /* access modifiers changed from: private */
        public ThingMomentaryReadOutRequest momentaryReadOutRequest;
        /* access modifiers changed from: private */
        public NodeInfo nodeInfo = NodeInfo.EMPTY;
        /* access modifiers changed from: private */
        public boolean selfOwned;

        public Thing build() {
            return new Thing(this);
        }

        public Builder setControlRequestHandler(ThingControlRequest thingControlRequest) {
            this.controlRequest = thingControlRequest;
            return this;
        }

        public Builder setKey(String str) {
            this.metaTags.put("KEY", new Tag("KEY", Tag.Type.str, str));
            return this;
        }

        public Builder setManufacturer(String str) {
            this.metaTags.put("MAN", new Tag("MAN", Tag.Type.str, str));
            return this;
        }

        public Builder setModel(String str) {
            this.metaTags.put("MODEL", new Tag("MODEL", Tag.Type.str, str));
            return this;
        }

        public Builder setMomentaryReadOutRequestHandler(ThingMomentaryReadOutRequest thingMomentaryReadOutRequest) {
            this.momentaryReadOutRequest = thingMomentaryReadOutRequest;
            return this;
        }

        public Builder setSerialNumber(String str) {
            this.metaTags.put("SN", new Tag("SN", Tag.Type.str, str));
            return this;
        }

        public Builder setVersion(String str) {
            this.metaTags.put("V", new Tag("V", Tag.Type.num, str));
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCacheType() {
        return this.nodeInfo.getCacheType();
    }

    public ThingControlRequest getControlRequestHandler() {
        return this.controlRequestHandler;
    }

    public Collection<Tag> getMetaTags() {
        return this.metaTags.values();
    }

    public ThingMomentaryReadOutRequest getMomentaryReadOutRequestHandler() {
        return this.momentaryReadOutRequestHandler;
    }

    public String getNodeId() {
        return this.nodeInfo.getNodeId();
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public String getSourceId() {
        return this.nodeInfo.getSourceId();
    }

    public boolean isSelfOwened() {
        return this.selfOwned;
    }

    public String toString() {
        if (this.toStringCache == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thing " + this.nodeInfo + " [");
            Iterator<Tag> it = this.metaTags.values().iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                if (it.hasNext()) {
                    sb2.append(' ');
                }
            }
            sb2.append(PropertyUtils.INDEXED_DELIM2);
            this.toStringCache = sb2.toString();
        }
        return this.toStringCache;
    }

    private Thing(Builder builder) {
        this.metaTags = builder.metaTags;
        this.selfOwned = builder.selfOwned;
        this.nodeInfo = builder.nodeInfo;
        this.momentaryReadOutRequestHandler = builder.momentaryReadOutRequest;
        this.controlRequestHandler = builder.controlRequest;
    }
}
