package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class FormNode extends NodeExtension {
    private final DataForm configForm;

    public FormNode(FormNodeType formNodeType, DataForm dataForm) {
        this(formNodeType, (String) null, dataForm);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        if (this.configForm == null) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Element) this.configForm);
        xmlStringBuilder.closeElement((NamedElement) this);
    }

    public DataForm getForm() {
        return this.configForm;
    }

    public FormNode(FormNodeType formNodeType, String str, DataForm dataForm) {
        super(formNodeType.getNodeElement(), str);
        this.configForm = dataForm;
    }
}
