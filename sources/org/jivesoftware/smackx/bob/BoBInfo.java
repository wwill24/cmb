package org.jivesoftware.smackx.bob;

import java.util.Set;

public class BoBInfo {
    private final BoBData data;
    private final Set<ContentId> hashes;

    BoBInfo(Set<ContentId> set, BoBData boBData) {
        this.hashes = set;
        this.data = boBData;
    }

    public BoBData getData() {
        return this.data;
    }

    public Set<ContentId> getHashes() {
        return this.hashes;
    }
}
