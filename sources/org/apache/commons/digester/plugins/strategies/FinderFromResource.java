package org.apache.commons.digester.plugins.strategies;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromResource extends RuleFinder {
    public static String DFLT_RESOURCE_ATTR = "resource";
    private String resourceAttr;

    public FinderFromResource() {
        this(DFLT_RESOURCE_ATTR);
    }

    public static RuleLoader loadRules(Digester digester, Class cls, InputStream inputStream, String str) throws PluginException {
        try {
            LoaderFromStream loaderFromStream = new LoaderFromStream(inputStream);
            try {
                inputStream.close();
                return loaderFromStream;
            } catch (IOException e10) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable to close stream for resource [");
                stringBuffer.append(str);
                stringBuffer.append("]");
                throw new PluginException(stringBuffer.toString(), e10);
            }
        } catch (Exception e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to load xmlrules from resource [");
            stringBuffer2.append(str);
            stringBuffer2.append("]");
            throw new PluginException(stringBuffer2.toString(), e11);
        } catch (Throwable th2) {
            try {
                inputStream.close();
                throw th2;
            } catch (IOException e12) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Unable to close stream for resource [");
                stringBuffer3.append(str);
                stringBuffer3.append("]");
                throw new PluginException(stringBuffer3.toString(), e12);
            }
        }
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        String property = properties.getProperty(this.resourceAttr);
        if (property == null) {
            return null;
        }
        InputStream resourceAsStream = cls.getClassLoader().getResourceAsStream(property);
        if (resourceAsStream != null) {
            return loadRules(digester, cls, resourceAsStream, property);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource ");
        stringBuffer.append(property);
        stringBuffer.append(" not found.");
        throw new PluginException(stringBuffer.toString());
    }

    public FinderFromResource(String str) {
        this.resourceAttr = str;
    }
}
