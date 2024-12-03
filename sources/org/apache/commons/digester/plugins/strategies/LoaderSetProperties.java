package org.apache.commons.digester.plugins.strategies;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.RuleLoader;
import org.apache.commons.logging.Log;

public class LoaderSetProperties extends RuleLoader {
    public void addRules(Digester digester, String str) {
        Log logger = digester.getLogger();
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LoaderSetProperties loading rules for plugin at path [");
            stringBuffer.append(str);
            stringBuffer.append("]");
            logger.debug(stringBuffer.toString());
        }
        digester.addSetProperties(str);
    }
}
