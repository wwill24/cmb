package org.apache.commons.digester.plugins.strategies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleFinder;
import org.apache.commons.digester.plugins.RuleLoader;

public class FinderFromFile extends RuleFinder {
    public static String DFLT_FILENAME_ATTR = "file";
    private String filenameAttr;

    public FinderFromFile() {
        this(DFLT_FILENAME_ATTR);
    }

    public RuleLoader findLoader(Digester digester, Class cls, Properties properties) throws PluginException {
        String property = properties.getProperty(this.filenameAttr);
        if (property == null) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(property);
            try {
                LoaderFromStream loaderFromStream = new LoaderFromStream(fileInputStream);
                try {
                    fileInputStream.close();
                    return loaderFromStream;
                } catch (IOException e10) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to close stream for file [");
                    stringBuffer.append(property);
                    stringBuffer.append("]");
                    throw new PluginException(stringBuffer.toString(), e10);
                }
            } catch (Exception e11) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Unable to load xmlrules from file [");
                stringBuffer2.append(property);
                stringBuffer2.append("]");
                throw new PluginException(stringBuffer2.toString(), e11);
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                    throw th2;
                } catch (IOException e12) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Unable to close stream for file [");
                    stringBuffer3.append(property);
                    stringBuffer3.append("]");
                    throw new PluginException(stringBuffer3.toString(), e12);
                }
            }
        } catch (IOException e13) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Unable to process file [");
            stringBuffer4.append(property);
            stringBuffer4.append("]");
            throw new PluginException(stringBuffer4.toString(), e13);
        }
    }

    public FinderFromFile(String str) {
        this.filenameAttr = str;
    }
}
