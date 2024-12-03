package m8;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;

public class c implements StanzaFilter {
    public boolean accept(Stanza stanza) {
        return true;
    }
}
