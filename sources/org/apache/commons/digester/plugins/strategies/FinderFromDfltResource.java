package org.apache.commons.digester.plugins.strategies;

import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromDfltResource extends RuleFinder {
    public static String DFLT_RESOURCE_SUFFIX = "RuleInfo.xml";
    private String resourceSuffix;

    public FinderFromDfltResource() {
        this(DFLT_RESOURCE_SUFFIX);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cls.getName().replace('.', '/'));
        stringBuffer.append(this.resourceSuffix);
        String stringBuffer2 = stringBuffer.toString();
        InputStream resourceAsStream = cls.getClassLoader().getResourceAsStream(stringBuffer2);
        if (resourceAsStream == null) {
            return null;
        }
        return FinderFromResource.loadRules(digester, cls, resourceAsStream, stringBuffer2);
    }

    public FinderFromDfltResource(String str) {
        this.resourceSuffix = str;
    }
}
