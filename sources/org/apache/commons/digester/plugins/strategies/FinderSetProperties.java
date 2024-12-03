package org.apache.commons.digester.plugins.strategies;

import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderSetProperties extends RuleFinder {
    public static String DFLT_FALSEVAL = "false";
    public static String DFLT_PROPS_ATTR = "setprops";
    private String falseval;
    private String propsAttr;

    public FinderSetProperties() {
        this(DFLT_PROPS_ATTR, DFLT_FALSEVAL);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) {
        String property = properties.getProperty(this.propsAttr);
        if (property == null || !property.equals(this.falseval)) {
            return new LoaderSetProperties();
        }
        return null;
    }

    public FinderSetProperties(String str, String str2) {
        this.propsAttr = str;
        this.falseval = str2;
    }
}
