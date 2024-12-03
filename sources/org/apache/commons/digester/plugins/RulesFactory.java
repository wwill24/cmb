package org.apache.commons.digester.plugins;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rules;

public abstract class RulesFactory {
    public abstract Rules newRules(Digester digester, Class cls) throws PluginException;
}
