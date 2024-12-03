package org.apache.commons.digester.plugins;

import java.util.Properties;
import org.apache.commons.digester.Digester;

public abstract class RuleFinder {
    public abstract RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException;
}
