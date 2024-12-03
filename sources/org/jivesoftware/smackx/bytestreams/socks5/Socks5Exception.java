package org.jivesoftware.smackx.bytestreams.socks5;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;

public abstract class Socks5Exception extends SmackException {
    private static final long serialVersionUID = 1;

    public static final class CouldNotConnectToAnyProvidedSocks5Host extends Socks5Exception {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1;
        private final Map<Bytestream.StreamHost, Exception> streamHostsExceptions;

        static {
            Class<Socks5Exception> cls = Socks5Exception.class;
        }

        private CouldNotConnectToAnyProvidedSocks5Host(String str, Map<Bytestream.StreamHost, Exception> map) {
            super(str);
            this.streamHostsExceptions = Collections.unmodifiableMap(map);
        }

        static CouldNotConnectToAnyProvidedSocks5Host construct(Map<Bytestream.StreamHost, Exception> map) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("Could not establish socket with any provided SOCKS5 stream host.");
            Iterator<Bytestream.StreamHost> it = map.keySet().iterator();
            while (it.hasNext()) {
                Bytestream.StreamHost next = it.next();
                sb2.append(' ');
                sb2.append(next);
                sb2.append(" Exception: '");
                sb2.append(map.get(next));
                sb2.append('\'');
                if (it.hasNext()) {
                    sb2.append(',');
                }
            }
            return new CouldNotConnectToAnyProvidedSocks5Host(sb2.toString(), map);
        }

        public Map<Bytestream.StreamHost, Exception> getStreamHostsExceptions() {
            return this.streamHostsExceptions;
        }
    }

    public static final class NoSocks5StreamHostsProvided extends Socks5Exception {
        private static final long serialVersionUID = 1;

        NoSocks5StreamHostsProvided() {
            super("No SOCKS5 stream hosts provided.");
        }
    }

    protected Socks5Exception(String str) {
        super(str);
    }
}
