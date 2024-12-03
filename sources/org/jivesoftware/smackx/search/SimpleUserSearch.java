package org.jivesoftware.smackx.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.search.ReportedData;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

class SimpleUserSearch extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:search";
    private ReportedData data;
    private DataForm form;

    SimpleUserSearch() {
        super("query", "jabber:iq:search");
    }

    private String getItemsToSearch() {
        StringBuilder sb2 = new StringBuilder();
        if (this.form == null) {
            this.form = DataForm.from(this);
        }
        DataForm dataForm = this.form;
        if (dataForm == null) {
            return "";
        }
        for (FormField next : dataForm.getFields()) {
            String fieldName = next.getFieldName();
            String singleValue = getSingleValue(next);
            if (singleValue.trim().length() > 0) {
                sb2.append('<');
                sb2.append(fieldName);
                sb2.append('>');
                sb2.append(singleValue);
                sb2.append("</");
                sb2.append(fieldName);
                sb2.append('>');
            }
        }
        return sb2.toString();
    }

    private static String getSingleValue(FormField formField) {
        List<String> valuesAsString = formField.getValuesAsString();
        if (valuesAsString.isEmpty()) {
            return "";
        }
        return valuesAsString.get(0);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((CharSequence) getItemsToSearch());
        return iQChildElementXmlStringBuilder;
    }

    public ReportedData getReportedData() {
        return this.data;
    }

    /* access modifiers changed from: protected */
    public void parseItems(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ReportedData reportedData = new ReportedData();
        reportedData.addColumn(new ReportedData.Column("JID", "jid", FormField.Type.text_single));
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        while (!z10) {
            if (xmlPullParser.getAttributeCount() > 0) {
                String attributeValue = xmlPullParser.getAttributeValue("", "jid");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(attributeValue);
                arrayList.add(new ReportedData.Field("jid", arrayList2));
            }
            XmlPullParser.Event next = xmlPullParser.next();
            XmlPullParser.Event event = XmlPullParser.Event.START_ELEMENT;
            boolean z11 = true;
            if (next != event || !xmlPullParser.getName().equals("item")) {
                XmlPullParser.Event event2 = XmlPullParser.Event.END_ELEMENT;
                if (next == event2 && xmlPullParser.getName().equals("item")) {
                    reportedData.addRow(new ReportedData.Row(arrayList));
                } else if (next == event) {
                    String name = xmlPullParser.getName();
                    String nextText = xmlPullParser.nextText();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(nextText);
                    arrayList.add(new ReportedData.Field(name, arrayList3));
                    Iterator<ReportedData.Column> it = reportedData.getColumns().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getVariable().equals(name)) {
                                break;
                            }
                        } else {
                            z11 = false;
                            break;
                        }
                    }
                    if (!z11) {
                        reportedData.addColumn(new ReportedData.Column(name, name, FormField.Type.text_single));
                    }
                } else if (next == event2 && xmlPullParser.getName().equals("query")) {
                    z10 = true;
                }
            } else {
                arrayList = new ArrayList();
            }
        }
        this.data = reportedData;
    }

    public void setForm(DataForm dataForm) {
        this.form = dataForm;
    }
}
