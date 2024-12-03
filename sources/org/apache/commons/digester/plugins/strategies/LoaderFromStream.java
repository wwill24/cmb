package org.apache.commons.digester.plugins.strategies;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleLoader;
import org.apache.commons.digester.xmlrules.FromXmlRuleSet;
import org.apache.commons.logging.Log;
import org.xml.sax.InputSource;

public class LoaderFromStream extends RuleLoader {
    private byte[] input;
    private FromXmlRuleSet ruleSet;

    public LoaderFromStream(InputStream inputStream) throws Exception {
        load(inputStream);
    }

    private void load(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[256];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                this.input = byteArrayOutputStream.toByteArray();
                return;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public void addRules(Digester digester, String str) throws PluginException {
        Log logger = digester.getLogger();
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LoaderFromStream: loading rules for plugin at path [");
            stringBuffer.append(str);
            stringBuffer.append("]");
            logger.debug(stringBuffer.toString());
        }
        new FromXmlRuleSet(new InputSource(new ByteArrayInputStream(this.input))).addRuleInstances(digester, str);
    }
}
