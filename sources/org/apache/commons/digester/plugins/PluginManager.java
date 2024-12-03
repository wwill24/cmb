package org.apache.commons.digester.plugins;

import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;

public class PluginManager {
    private HashMap declarationsByClass = new HashMap();
    private HashMap declarationsById = new HashMap();
    private PluginManager parent;
    private PluginContext pluginContext;

    public PluginManager(PluginContext pluginContext2) {
        this.pluginContext = pluginContext2;
    }

    public void addDeclaration(Declaration declaration) {
        Log logger = LogUtils.getLogger((Digester) null);
        boolean isDebugEnabled = logger.isDebugEnabled();
        Class pluginClass = declaration.getPluginClass();
        String id2 = declaration.getId();
        this.declarationsByClass.put(pluginClass.getName(), declaration);
        if (id2 != null) {
            this.declarationsById.put(id2, declaration);
            if (isDebugEnabled) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Indexing plugin-id [");
                stringBuffer.append(id2);
                stringBuffer.append("]");
                stringBuffer.append(" -> class [");
                stringBuffer.append(pluginClass.getName());
                stringBuffer.append("]");
                logger.debug(stringBuffer.toString());
            }
        }
    }

    public RuleLoader findLoader(Digester digester, String str, Class cls, Properties properties) throws PluginException {
        Log logger = LogUtils.getLogger(digester);
        boolean isDebugEnabled = logger.isDebugEnabled();
        logger.debug("scanning ruleFinders to locate loader..");
        try {
            Iterator it = this.pluginContext.getRuleFinders().iterator();
            RuleLoader ruleLoader = null;
            while (it.hasNext() && ruleLoader == null) {
                RuleFinder ruleFinder = (RuleFinder) it.next();
                if (isDebugEnabled) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("checking finder of type ");
                    stringBuffer.append(ruleFinder.getClass().getName());
                    logger.debug(stringBuffer.toString());
                }
                ruleLoader = ruleFinder.findLoader(digester, cls, properties);
            }
            logger.debug("scanned ruleFinders.");
            return ruleLoader;
        } catch (PluginException e10) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to locate plugin rules for plugin with id [");
            stringBuffer2.append(str);
            stringBuffer2.append("]");
            stringBuffer2.append(", and class [");
            stringBuffer2.append(cls.getName());
            stringBuffer2.append("]");
            stringBuffer2.append(CertificateUtil.DELIMITER);
            stringBuffer2.append(e10.getMessage());
            throw new PluginException(stringBuffer2.toString(), e10.getCause());
        }
    }

    public Declaration getDeclarationByClass(String str) {
        PluginManager pluginManager;
        Declaration declaration = (Declaration) this.declarationsByClass.get(str);
        if (declaration != null || (pluginManager = this.parent) == null) {
            return declaration;
        }
        return pluginManager.getDeclarationByClass(str);
    }

    public Declaration getDeclarationById(String str) {
        PluginManager pluginManager;
        Declaration declaration = (Declaration) this.declarationsById.get(str);
        if (declaration != null || (pluginManager = this.parent) == null) {
            return declaration;
        }
        return pluginManager.getDeclarationById(str);
    }

    public PluginManager(PluginManager pluginManager) {
        this.parent = pluginManager;
        this.pluginContext = pluginManager.pluginContext;
    }
}
