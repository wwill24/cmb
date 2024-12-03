package org.apache.commons.digester.plugins.strategies;

import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromClass extends RuleFinder {
    public static String DFLT_METHOD_ATTR = "method";
    public static String DFLT_METHOD_NAME = "addRules";
    public static String DFLT_RULECLASS_ATTR = "ruleclass";
    private String dfltMethodName;
    private String methodAttr;
    private String ruleClassAttr;

    public FinderFromClass() {
        this(DFLT_RULECLASS_ATTR, DFLT_METHOD_ATTR, DFLT_METHOD_NAME);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        String property = properties.getProperty(this.ruleClassAttr);
        String str = null;
        if (property == null) {
            return null;
        }
        String str2 = this.methodAttr;
        if (str2 != null) {
            str = properties.getProperty(str2);
        }
        if (str == null) {
            str = this.dfltMethodName;
        }
        if (str == null) {
            str = DFLT_METHOD_NAME;
        }
        try {
            return new LoaderFromClass((Class) digester.getClassLoader().loadClass(property), str);
        } catch (ClassNotFoundException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to load class ");
            stringBuffer.append(property);
            throw new PluginException(stringBuffer.toString(), e10);
        }
    }

    public FinderFromClass(String str, String str2, String str3) {
        this.ruleClassAttr = str;
        this.methodAttr = str2;
        this.dfltMethodName = str3;
    }
}
