package org.jivesoftware.smackx.iot.element;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class NodeInfo {
    public static final NodeInfo EMPTY = new NodeInfo();
    private final String cacheType;
    private final String nodeId;
    private final String sourceId;

    private NodeInfo() {
        this.nodeId = null;
        this.sourceId = null;
        this.cacheType = null;
    }

    public void appendTo(XmlStringBuilder xmlStringBuilder) {
        String str = this.nodeId;
        if (str != null) {
            xmlStringBuilder.attribute("nodeId", str).optAttribute("sourceId", this.sourceId).optAttribute("cacheType", this.cacheType);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NodeInfo)) {
            return false;
        }
        NodeInfo nodeInfo = (NodeInfo) obj;
        if (this.nodeId.equals(nodeInfo.nodeId) && StringUtils.nullSafeCharSequenceEquals(this.sourceId, nodeInfo.sourceId) && StringUtils.nullSafeCharSequenceEquals(this.cacheType, nodeInfo.cacheType)) {
            return true;
        }
        return false;
    }

    public String getCacheType() {
        return this.cacheType;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public int hashCode() {
        int i10;
        int i11 = 0;
        if (this == EMPTY) {
            return 0;
        }
        int hashCode = (this.nodeId.hashCode() + 31) * 31;
        String str = this.sourceId;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i12 = (hashCode + i10) * 31;
        String str2 = this.cacheType;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i12 + i11;
    }

    public NodeInfo(String str, String str2, String str3) {
        this.nodeId = (String) StringUtils.requireNotNullNorEmpty(str, "Node ID must not be null nor empty");
        this.sourceId = str2;
        this.cacheType = str3;
    }
}
