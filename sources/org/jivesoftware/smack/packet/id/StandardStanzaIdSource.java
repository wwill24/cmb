package org.jivesoftware.smack.packet.id;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smack.util.StringUtils;

public class StandardStanzaIdSource implements StanzaIdSource {
    public static final StandardStanzaIdSource DEFAULT = new StandardStanzaIdSource();

    /* renamed from: id  reason: collision with root package name */
    private final AtomicLong f24137id = new AtomicLong();
    private final String prefix = (StringUtils.randomString(5) + HelpFormatter.DEFAULT_OPT_PREFIX);

    public static class Factory implements StanzaIdSourceFactory {
        public StandardStanzaIdSource constructStanzaIdSource() {
            return new StandardStanzaIdSource();
        }
    }

    public String getNewStanzaId() {
        return this.prefix + Long.toString(this.f24137id.incrementAndGet());
    }
}
