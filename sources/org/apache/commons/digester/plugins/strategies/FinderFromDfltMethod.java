package org.apache.commons.digester.plugins.strategies;

import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromDfltMethod extends RuleFinder {
    public static String DFLT_METHOD_NAME = "addRules";
    private String methodName;

    public FinderFromDfltMethod() {
        this(DFLT_METHOD_NAME);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        Method locateMethod = LoaderFromClass.locateMethod(cls, this.methodName);
        if (locateMethod == null) {
            return null;
        }
        return new LoaderFromClass(cls, locateMethod);
    }

    public FinderFromDfltMethod(String str) {
        this.methodName = str;
    }
}
