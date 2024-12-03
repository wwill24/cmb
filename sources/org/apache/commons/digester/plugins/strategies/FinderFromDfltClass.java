package org.apache.commons.digester.plugins.strategies;

import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromDfltClass extends RuleFinder {
    public static String DFLT_METHOD_NAME = "addRules";
    public static String DFLT_RULECLASS_SUFFIX = "RuleInfo";
    private String methodName;
    private String rulesClassSuffix;

    public FinderFromDfltClass() {
        this(DFLT_RULECLASS_SUFFIX, DFLT_METHOD_NAME);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        Class<?> cls2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cls.getName());
        stringBuffer.append(this.rulesClassSuffix);
        try {
            cls2 = digester.getClassLoader().loadClass(stringBuffer.toString());
        } catch (ClassNotFoundException unused) {
            cls2 = null;
        }
        if (cls2 == null) {
            return null;
        }
        if (this.methodName == null) {
            this.methodName = DFLT_METHOD_NAME;
        }
        return new LoaderFromClass((Class) cls2, this.methodName);
    }

    public FinderFromDfltClass(String str, String str2) {
        this.rulesClassSuffix = str;
        this.methodName = str2;
    }
}
