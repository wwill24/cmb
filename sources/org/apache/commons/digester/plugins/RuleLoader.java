package org.apache.commons.digester.plugins;

import org.apache.commons.digester.Digester;

public abstract class RuleLoader {
    public abstract void addRules(Digester digester, String str) throws PluginException;
}
