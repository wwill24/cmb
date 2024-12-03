package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.pubsub.Affiliation;
import org.jivesoftware.smackx.pubsub.AffiliationsExtension;

public class AffiliationsProvider extends EmbeddedExtensionProvider<AffiliationsExtension> {
    /* access modifiers changed from: protected */
    public AffiliationsExtension createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new AffiliationsExtension(Affiliation.AffiliationNamespace.fromXmlns(str2), (List<Affiliation>) list);
    }
}
