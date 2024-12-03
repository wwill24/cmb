package org.apache.commons.digester;

public interface RuleSet {
    void addRuleInstances(Digester digester);

    String getNamespaceURI();
}
