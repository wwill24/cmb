package org.apache.commons.digester;

import java.util.ArrayList;
import java.util.List;

public class WithDefaultsRulesWrapper implements Rules {
    private List allRules = new ArrayList();
    private List defaultRules = new ArrayList();
    private Rules wrappedRules;

    public WithDefaultsRulesWrapper(Rules rules) {
        if (rules != null) {
            this.wrappedRules = rules;
            return;
        }
        throw new IllegalArgumentException("Wrapped rules must not be null");
    }

    public void add(String str, Rule rule) {
        this.wrappedRules.add(str, rule);
        this.allRules.add(rule);
    }

    public void addDefault(Rule rule) {
        if (this.wrappedRules.getDigester() != null) {
            rule.setDigester(this.wrappedRules.getDigester());
        }
        if (this.wrappedRules.getNamespaceURI() != null) {
            rule.setNamespaceURI(this.wrappedRules.getNamespaceURI());
        }
        this.defaultRules.add(rule);
        this.allRules.add(rule);
    }

    public void clear() {
        this.wrappedRules.clear();
        this.allRules.clear();
        this.defaultRules.clear();
    }

    public List getDefaults() {
        return this.defaultRules;
    }

    public Digester getDigester() {
        return this.wrappedRules.getDigester();
    }

    public String getNamespaceURI() {
        return this.wrappedRules.getNamespaceURI();
    }

    public List match(String str) {
        return match("", str);
    }

    public List rules() {
        return this.allRules;
    }

    public void setDigester(Digester digester) {
        this.wrappedRules.setDigester(digester);
        for (Rule digester2 : this.defaultRules) {
            digester2.setDigester(digester);
        }
    }

    public void setNamespaceURI(String str) {
        this.wrappedRules.setNamespaceURI(str);
    }

    public List match(String str, String str2) {
        List match = this.wrappedRules.match(str, str2);
        if (match == null || match.isEmpty()) {
            return new ArrayList(this.defaultRules);
        }
        return match;
    }
}
