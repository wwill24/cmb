package org.apache.commons.digester.substitution;

import org.apache.commons.digester.Substitutor;
import org.xml.sax.Attributes;

public class VariableSubstitutor extends Substitutor {
    private VariableExpander attributesExpander;
    private VariableExpander bodyTextExpander;
    private VariableAttributes variableAttributes;

    public VariableSubstitutor(VariableExpander variableExpander) {
        this(variableExpander, variableExpander);
    }

    public Attributes substitute(Attributes attributes) {
        VariableExpander variableExpander = this.attributesExpander;
        if (variableExpander == null) {
            return attributes;
        }
        this.variableAttributes.init(attributes, variableExpander);
        return this.variableAttributes;
    }

    public VariableSubstitutor(VariableExpander variableExpander, VariableExpander variableExpander2) {
        this.attributesExpander = variableExpander;
        this.bodyTextExpander = variableExpander2;
        this.variableAttributes = new VariableAttributes();
    }

    public String substitute(String str) {
        VariableExpander variableExpander = this.bodyTextExpander;
        return variableExpander != null ? variableExpander.expand(str) : str;
    }
}
