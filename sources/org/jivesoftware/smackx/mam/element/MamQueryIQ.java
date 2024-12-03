package org.jivesoftware.smackx.mam.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class MamQueryIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:mam:2";
    private final DataForm dataForm;
    private final String node;
    private final String queryId;

    public MamQueryIQ(String str) {
        this(str, (String) null, (DataForm) null);
        setType(IQ.Type.get);
    }

    public DataForm getDataForm() {
        return this.dataForm;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute("queryid", this.queryId);
        iQChildElementXmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public String getNode() {
        return this.node;
    }

    public String getQueryId() {
        return this.queryId;
    }

    public MamQueryIQ(DataForm dataForm2) {
        this((String) null, (String) null, dataForm2);
    }

    public MamQueryIQ(String str, DataForm dataForm2) {
        this(str, (String) null, dataForm2);
    }

    public MamQueryIQ(String str, String str2, DataForm dataForm2) {
        super("query", "urn:xmpp:mam:2");
        this.queryId = str;
        this.node = str2;
        this.dataForm = dataForm2;
        if (dataForm2 != null) {
            String formType = dataForm2.getFormType();
            if (formType == null) {
                throw new IllegalArgumentException("If a data form is given it must posses a hidden form type field");
            } else if (formType.equals("urn:xmpp:mam:2")) {
                addExtension(dataForm2);
            } else {
                throw new IllegalArgumentException("Value of the hidden form type field must be 'urn:xmpp:mam:2'");
            }
        }
    }
}
