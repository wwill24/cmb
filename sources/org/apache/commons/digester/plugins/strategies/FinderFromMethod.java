package org.apache.commons.digester.plugins.strategies;

import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromMethod extends RuleFinder {
    public static String DFLT_METHOD_ATTR = "method";
    private String methodAttr;

    public FinderFromMethod() {
        this(DFLT_METHOD_ATTR);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        String property = properties.getProperty(this.methodAttr);
        if (property == null) {
            return null;
        }
        return new LoaderFromClass(cls, property);
    }

    public FinderFromMethod(String str) {
        this.methodAttr = str;
    }
}
