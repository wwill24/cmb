package org.apache.commons.digester;

public abstract class RuleSetBase implements RuleSet {
    protected String namespaceURI = null;

    public abstract void addRuleInstances(Digester digester);

    public String getNamespaceURI() {
        return this.namespaceURI;
    }
}
