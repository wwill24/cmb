package org.jivesoftware.smackx.pubsub;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.Affiliation;

public class AffiliationsExtension extends NodeExtension {
    protected List<Affiliation> items;

    public AffiliationsExtension() {
        this((List<Affiliation>) null);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        List<Affiliation> list = this.items;
        if (list == null || list.size() == 0) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.items);
        xmlStringBuilder.closeElement((NamedElement) this);
    }

    public List<Affiliation> getAffiliations() {
        return this.items;
    }

    public AffiliationsExtension(List<Affiliation> list) {
        this(list, (String) null);
    }

    public AffiliationsExtension(Affiliation.AffiliationNamespace affiliationNamespace, List<Affiliation> list) {
        this(affiliationNamespace, list, (String) null);
    }

    public AffiliationsExtension(List<Affiliation> list, String str) {
        this(Affiliation.AffiliationNamespace.basic, list, str);
    }

    public AffiliationsExtension(Affiliation.AffiliationNamespace affiliationNamespace, List<Affiliation> list, String str) {
        super(affiliationNamespace.type, str);
        Collections.emptyList();
        this.items = list;
    }
}
