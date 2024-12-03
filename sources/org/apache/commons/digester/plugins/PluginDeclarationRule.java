package org.apache.commons.digester.plugins;

import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.xml.sax.Attributes;

public class PluginDeclarationRule extends Rule {
    public static void declarePlugin(Digester digester, Properties properties) throws PluginException {
        String property = properties.getProperty("id");
        String property2 = properties.getProperty("class");
        if (property == null) {
            throw new PluginInvalidInputException("mandatory attribute id not present on plugin declaration");
        } else if (property2 != null) {
            Declaration declaration = new Declaration(property2);
            declaration.setId(property);
            declaration.setProperties(properties);
            PluginManager pluginManager = ((PluginRules) digester.getRules()).getPluginManager();
            declaration.init(digester, pluginManager);
            pluginManager.addDeclaration(declaration);
        } else {
            throw new PluginInvalidInputException("mandatory attribute class not present on plugin declaration");
        }
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        int length = attributes.getLength();
        Properties properties = new Properties();
        for (int i10 = 0; i10 < length; i10++) {
            String localName = attributes.getLocalName(i10);
            if (localName == null || localName.length() == 0) {
                localName = attributes.getQName(i10);
            }
            properties.setProperty(localName, attributes.getValue(i10));
        }
        try {
            declarePlugin(this.digester, properties);
        } catch (PluginInvalidInputException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error on element [");
            stringBuffer.append(this.digester.getMatch());
            stringBuffer.append("]: ");
            stringBuffer.append(e10.getMessage());
            throw new PluginInvalidInputException(stringBuffer.toString());
        }
    }
}
