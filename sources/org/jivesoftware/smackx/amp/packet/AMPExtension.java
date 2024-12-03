package org.jivesoftware.smackx.amp.packet;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;

public class AMPExtension implements ExtensionElement {
    public static final String ELEMENT = "amp";
    public static final String NAMESPACE = "http://jabber.org/protocol/amp";
    private final String from;
    private boolean perHop;
    private final CopyOnWriteArrayList<Rule> rules;
    private final Status status;
    private final String to;

    public enum Action {
        alert,
        drop,
        error,
        notify;
        
        public static final String ATTRIBUTE_NAME = "action";
    }

    public interface Condition {
        public static final String ATTRIBUTE_NAME = "condition";

        String getName();

        String getValue();
    }

    public static class Rule {
        public static final String ELEMENT = "rule";
        private final Action action;
        private final Condition condition;

        public Rule(Action action2, Condition condition2) {
            if (action2 == null) {
                throw new NullPointerException("Can't create Rule with null action");
            } else if (condition2 != null) {
                this.action = action2;
                this.condition = condition2;
            } else {
                throw new NullPointerException("Can't create Rule with null condition");
            }
        }

        /* access modifiers changed from: private */
        public String toXML() {
            return "<rule action=\"" + this.action.toString() + "\" " + Condition.ATTRIBUTE_NAME + "=\"" + this.condition.getName() + "\" value=\"" + this.condition.getValue() + "\"/>";
        }

        public Action getAction() {
            return this.action;
        }

        public Condition getCondition() {
            return this.condition;
        }
    }

    public enum Status {
        alert,
        error,
        notify
    }

    public AMPExtension(String str, String str2, Status status2) {
        this.rules = new CopyOnWriteArrayList<>();
        this.perHop = false;
        this.from = str;
        this.to = str2;
        this.status = status2;
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getFrom() {
        return this.from;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public List<Rule> getRules() {
        return Collections.unmodifiableList(this.rules);
    }

    public int getRulesCount() {
        return this.rules.size();
    }

    public Status getStatus() {
        return this.status;
    }

    public String getTo() {
        return this.to;
    }

    public synchronized boolean isPerHop() {
        return this.perHop;
    }

    public synchronized void setPerHop(boolean z10) {
        this.perHop = z10;
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('<');
        sb2.append(getElementName());
        sb2.append(" xmlns=\"");
        sb2.append(getNamespace());
        sb2.append('\"');
        if (this.status != null) {
            sb2.append(" status=\"");
            sb2.append(this.status.toString());
            sb2.append('\"');
        }
        if (this.to != null) {
            sb2.append(" to=\"");
            sb2.append(this.to);
            sb2.append('\"');
        }
        if (this.from != null) {
            sb2.append(" from=\"");
            sb2.append(this.from);
            sb2.append('\"');
        }
        if (this.perHop) {
            sb2.append(" per-hop=\"true\"");
        }
        sb2.append('>');
        for (Rule access$000 : getRules()) {
            sb2.append(access$000.toXML());
        }
        sb2.append("</");
        sb2.append(getElementName());
        sb2.append('>');
        return sb2.toString();
    }

    public AMPExtension() {
        this.rules = new CopyOnWriteArrayList<>();
        this.perHop = false;
        this.from = null;
        this.to = null;
        this.status = null;
    }
}
