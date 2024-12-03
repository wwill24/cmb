package org.apache.commons.digester.plugins;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.List;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.apache.commons.digester.Rules;
import org.apache.commons.digester.RulesBase;
import org.apache.commons.logging.Log;

public class PluginRules implements Rules {
    private Rules decoratedRules;
    protected Digester digester;
    private String mountPoint;
    private PluginRules parent;
    private PluginContext pluginContext;
    private PluginManager pluginManager;
    private RulesFactory rulesFactory;

    public PluginRules() {
        this(new RulesBase());
    }

    public void add(String str, Rule rule) {
        Log logger = LogUtils.getLogger(this.digester);
        boolean isDebugEnabled = logger.isDebugEnabled();
        if (isDebugEnabled) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("add entry: mapping pattern [");
            stringBuffer.append(str);
            stringBuffer.append("]");
            stringBuffer.append(" to rule of type [");
            stringBuffer.append(rule.getClass().getName());
            stringBuffer.append("]");
            logger.debug(stringBuffer.toString());
        }
        if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = str.substring(1);
        }
        String str2 = this.mountPoint;
        if (str2 != null && !str.equals(str2)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.mountPoint);
            stringBuffer2.append(RemoteSettings.FORWARD_SLASH_STRING);
            if (!str.startsWith(stringBuffer2.toString())) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("An attempt was made to add a rule with a pattern thatis not at or below the mountpoint of the current PluginRules object. Rule pattern: ");
                stringBuffer3.append(str);
                stringBuffer3.append(", mountpoint: ");
                stringBuffer3.append(this.mountPoint);
                stringBuffer3.append(", rule type: ");
                stringBuffer3.append(rule.getClass().getName());
                logger.warn(stringBuffer3.toString());
                return;
            }
        }
        this.decoratedRules.add(str, rule);
        if (rule instanceof InitializableRule) {
            try {
                ((InitializableRule) rule).postRegisterInit(str);
            } catch (PluginConfigurationException e10) {
                if (isDebugEnabled) {
                    logger.debug("Rule initialisation failed", e10);
                    return;
                }
                return;
            }
        }
        if (isDebugEnabled) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("add exit: mapped pattern [");
            stringBuffer4.append(str);
            stringBuffer4.append("]");
            stringBuffer4.append(" to rule of type [");
            stringBuffer4.append(rule.getClass().getName());
            stringBuffer4.append("]");
            logger.debug(stringBuffer4.toString());
        }
    }

    public void clear() {
        this.decoratedRules.clear();
    }

    /* access modifiers changed from: package-private */
    public Rules getDecoratedRules() {
        return this.decoratedRules;
    }

    public Digester getDigester() {
        return this.digester;
    }

    public String getNamespaceURI() {
        return this.decoratedRules.getNamespaceURI();
    }

    public Rules getParent() {
        return this.parent;
    }

    public String getPluginClassAttr() {
        return this.pluginContext.getPluginClassAttr();
    }

    public String getPluginClassAttrNs() {
        return this.pluginContext.getPluginClassAttrNs();
    }

    public String getPluginIdAttr() {
        return this.pluginContext.getPluginIdAttr();
    }

    public String getPluginIdAttrNs() {
        return this.pluginContext.getPluginIdAttrNs();
    }

    public PluginManager getPluginManager() {
        return this.pluginManager;
    }

    public List getRuleFinders() {
        return this.pluginContext.getRuleFinders();
    }

    public RulesFactory getRulesFactory() {
        return this.rulesFactory;
    }

    public List match(String str) {
        return match((String) null, str);
    }

    public List rules() {
        return this.decoratedRules.rules();
    }

    public void setDigester(Digester digester2) {
        this.digester = digester2;
        this.decoratedRules.setDigester(digester2);
    }

    public void setNamespaceURI(String str) {
        this.decoratedRules.setNamespaceURI(str);
    }

    public void setPluginClassAttribute(String str, String str2) {
        this.pluginContext.setPluginClassAttribute(str, str2);
    }

    public void setPluginIdAttribute(String str, String str2) {
        this.pluginContext.setPluginIdAttribute(str, str2);
    }

    public void setRuleFinders(List list) {
        this.pluginContext.setRuleFinders(list);
    }

    public void setRulesFactory(RulesFactory rulesFactory2) {
        this.rulesFactory = rulesFactory2;
    }

    public PluginRules(Rules rules) {
        this.digester = null;
        this.mountPoint = null;
        this.parent = null;
        this.pluginContext = null;
        this.decoratedRules = rules;
        PluginContext pluginContext2 = new PluginContext();
        this.pluginContext = pluginContext2;
        this.pluginManager = new PluginManager(pluginContext2);
    }

    public List match(String str, String str2) {
        Log logger = LogUtils.getLogger(this.digester);
        boolean isDebugEnabled = logger.isDebugEnabled();
        if (isDebugEnabled) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Matching path [");
            stringBuffer.append(str2);
            stringBuffer.append("] on rules object ");
            stringBuffer.append(toString());
            logger.debug(stringBuffer.toString());
        }
        if (this.mountPoint == null || str2.length() > this.mountPoint.length()) {
            logger.debug("delegating to decorated rules.");
            return this.decoratedRules.match(str, str2);
        }
        if (isDebugEnabled) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Path [");
            stringBuffer2.append(str2);
            stringBuffer2.append("] delegated to parent.");
            logger.debug(stringBuffer2.toString());
        }
        return this.parent.match(str, str2);
    }

    PluginRules(Digester digester2, String str, PluginRules pluginRules, Class cls) throws PluginException {
        this.pluginContext = null;
        this.digester = digester2;
        this.mountPoint = str;
        this.parent = pluginRules;
        RulesFactory rulesFactory2 = pluginRules.rulesFactory;
        this.rulesFactory = rulesFactory2;
        if (rulesFactory2 == null) {
            this.decoratedRules = new RulesBase();
        } else {
            this.decoratedRules = rulesFactory2.newRules(digester2, cls);
        }
        this.pluginContext = pluginRules.pluginContext;
        this.pluginManager = new PluginManager(pluginRules.pluginManager);
    }
}
