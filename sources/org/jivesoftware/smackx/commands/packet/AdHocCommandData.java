package org.jivesoftware.smackx.commands.packet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.AdHocCommandNote;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public class AdHocCommandData extends IQ {
    public static final String ELEMENT = "command";
    public static final String NAMESPACE = "http://jabber.org/protocol/commands";
    private AdHocCommand.Action action;
    private final ArrayList<AdHocCommand.Action> actions = new ArrayList<>();
    private AdHocCommand.Action executeAction;
    private DataForm form;

    /* renamed from: id  reason: collision with root package name */
    private Jid f24202id;
    private String name;
    private String node;
    private final List<AdHocCommandNote> notes = new ArrayList();
    private String sessionID;
    private AdHocCommand.Status status;

    public static class SpecificError implements ExtensionElement {
        public static final String namespace = "http://jabber.org/protocol/commands";
        public AdHocCommand.SpecificErrorCondition condition;

        public SpecificError(AdHocCommand.SpecificErrorCondition specificErrorCondition) {
            this.condition = specificErrorCondition;
        }

        public AdHocCommand.SpecificErrorCondition getCondition() {
            return this.condition;
        }

        public String getElementName() {
            return this.condition.toString();
        }

        public String getNamespace() {
            return "http://jabber.org/protocol/commands";
        }

        public String toXML(XmlEnvironment xmlEnvironment) {
            return '<' + getElementName() + " xmlns=\"" + getNamespace() + "\"/>";
        }
    }

    public AdHocCommandData() {
        super(ELEMENT, "http://jabber.org/protocol/commands");
    }

    public void addAction(AdHocCommand.Action action2) {
        this.actions.add(action2);
    }

    public void addNote(AdHocCommandNote adHocCommandNote) {
        this.notes.add(adHocCommandNote);
    }

    public AdHocCommand.Action getAction() {
        return this.action;
    }

    public List<AdHocCommand.Action> getActions() {
        return this.actions;
    }

    public AdHocCommand.Action getExecuteAction() {
        return this.executeAction;
    }

    public DataForm getForm() {
        return this.form;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.optAttribute("sessionid", this.sessionID);
        iQChildElementXmlStringBuilder.optAttribute("status", (Enum<?>) this.status);
        iQChildElementXmlStringBuilder.optAttribute("action", (Enum<?>) this.action);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (getType() == IQ.Type.result) {
            iQChildElementXmlStringBuilder.halfOpenElement("actions");
            iQChildElementXmlStringBuilder.optAttribute("execute", (Enum<?>) this.executeAction);
            if (this.actions.size() == 0) {
                iQChildElementXmlStringBuilder.closeEmptyElement();
            } else {
                iQChildElementXmlStringBuilder.rightAngleBracket();
                Iterator<AdHocCommand.Action> it = this.actions.iterator();
                while (it.hasNext()) {
                    iQChildElementXmlStringBuilder.emptyElement((Enum<?>) it.next());
                }
                iQChildElementXmlStringBuilder.closeElement("actions");
            }
        }
        DataForm dataForm = this.form;
        if (dataForm != null) {
            iQChildElementXmlStringBuilder.append(dataForm.toXML());
        }
        for (AdHocCommandNote next : this.notes) {
            iQChildElementXmlStringBuilder.halfOpenElement("note").attribute("type", next.getType().toString()).rightAngleBracket();
            iQChildElementXmlStringBuilder.append((CharSequence) next.getValue());
            iQChildElementXmlStringBuilder.closeElement("note");
        }
        return iQChildElementXmlStringBuilder;
    }

    public Jid getId() {
        return this.f24202id;
    }

    public String getName() {
        return this.name;
    }

    public String getNode() {
        return this.node;
    }

    public List<AdHocCommandNote> getNotes() {
        return this.notes;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public AdHocCommand.Status getStatus() {
        return this.status;
    }

    public void removeNote(AdHocCommandNote adHocCommandNote) {
        this.notes.remove(adHocCommandNote);
    }

    public void setAction(AdHocCommand.Action action2) {
        this.action = action2;
    }

    public void setExecuteAction(AdHocCommand.Action action2) {
        this.executeAction = action2;
    }

    public void setForm(DataForm dataForm) {
        this.form = dataForm;
    }

    public void setId(Jid jid) {
        this.f24202id = jid;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNode(String str) {
        this.node = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setStatus(AdHocCommand.Status status2) {
        this.status = status2;
    }
}
