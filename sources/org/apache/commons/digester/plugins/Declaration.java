package org.apache.commons.digester.plugins;

import java.util.Properties;
import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;

public class Declaration {

    /* renamed from: id  reason: collision with root package name */
    private String f33514id;
    private boolean initialized = false;
    private Class pluginClass;
    private String pluginClassName;
    private Properties properties = new Properties();
    private RuleLoader ruleLoader = null;

    public Declaration(String str) {
        this.pluginClassName = str;
    }

    public void configure(Digester digester, String str) throws PluginException {
        Log logger = digester.getLogger();
        if (logger.isDebugEnabled()) {
            logger.debug("configure being called!");
        }
        if (this.initialized) {
            RuleLoader ruleLoader2 = this.ruleLoader;
            if (ruleLoader2 != null) {
                ruleLoader2.addRules(digester, str);
                return;
            }
            return;
        }
        throw new PluginAssertionFailure("Not initialized.");
    }

    public String getId() {
        return this.f33514id;
    }

    public Class getPluginClass() {
        return this.pluginClass;
    }

    public void init(Digester digester, PluginManager pluginManager) throws PluginException {
        Log logger = digester.getLogger();
        boolean isDebugEnabled = logger.isDebugEnabled();
        if (isDebugEnabled) {
            logger.debug("init being called!");
        }
        if (!this.initialized) {
            if (this.pluginClass == null && this.pluginClassName != null) {
                try {
                    this.pluginClass = digester.getClassLoader().loadClass(this.pluginClassName);
                } catch (ClassNotFoundException e10) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to load class ");
                    stringBuffer.append(this.pluginClassName);
                    throw new PluginException(stringBuffer.toString(), e10);
                }
            }
            if (this.ruleLoader == null) {
                logger.debug("Searching for ruleloader...");
                this.ruleLoader = pluginManager.findLoader(digester, this.f33514id, this.pluginClass, this.properties);
            } else {
                logger.debug("This declaration has an explicit ruleLoader.");
            }
            if (isDebugEnabled) {
                if (this.ruleLoader == null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("No ruleLoader found for plugin declaration id [");
                    stringBuffer2.append(this.f33514id);
                    stringBuffer2.append("]");
                    stringBuffer2.append(", class [");
                    stringBuffer2.append(this.pluginClass.getClass().getName());
                    stringBuffer2.append("].");
                    logger.debug(stringBuffer2.toString());
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("RuleLoader of type [");
                    stringBuffer3.append(this.ruleLoader.getClass().getName());
                    stringBuffer3.append("] associated with plugin declaration");
                    stringBuffer3.append(" id [");
                    stringBuffer3.append(this.f33514id);
                    stringBuffer3.append("]");
                    stringBuffer3.append(", class [");
                    stringBuffer3.append(this.pluginClass.getClass().getName());
                    stringBuffer3.append("].");
                    logger.debug(stringBuffer3.toString());
                }
            }
            this.initialized = true;
            return;
        }
        throw new PluginAssertionFailure("Init called multiple times.");
    }

    public void setId(String str) {
        this.f33514id = str;
    }

    public void setProperties(Properties properties2) {
        this.properties.putAll(properties2);
    }

    public Declaration(Class cls) {
        this.pluginClass = cls;
        this.pluginClassName = cls.getName();
    }

    public Declaration(Class cls, RuleLoader ruleLoader2) {
        this.pluginClass = cls;
        this.pluginClassName = cls.getName();
        this.ruleLoader = ruleLoader2;
    }
}
