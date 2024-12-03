package org.jivesoftware.smackx.httpfileupload;

import org.jivesoftware.smack.util.Objects;
import org.jxmpp.jid.DomainBareJid;

public class UploadService {
    private final DomainBareJid address;
    private final Long maxFileSize;
    private final Version version;

    public enum Version {
        v0_2,
        v0_3
    }

    UploadService(DomainBareJid domainBareJid, Version version2) {
        this(domainBareJid, version2, (Long) null);
    }

    public boolean acceptsFileOfSize(long j10) {
        if (hasMaxFileSizeLimit() && j10 > this.maxFileSize.longValue()) {
            return false;
        }
        return true;
    }

    public DomainBareJid getAddress() {
        return this.address;
    }

    public Long getMaxFileSize() {
        return this.maxFileSize;
    }

    public Version getVersion() {
        return this.version;
    }

    public boolean hasMaxFileSizeLimit() {
        return this.maxFileSize != null;
    }

    UploadService(DomainBareJid domainBareJid, Version version2, Long l10) {
        this.address = (DomainBareJid) Objects.requireNonNull(domainBareJid);
        this.version = version2;
        this.maxFileSize = l10;
    }
}
