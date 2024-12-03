package org.apache.commons.digester.plugins;

import java.util.List;
import org.apache.commons.digester.Rule;
import org.apache.commons.logging.Log;
import org.apache.commons.validator.Validator;
import org.xml.sax.Attributes;

public class PluginCreateRule extends Rule implements InitializableRule {
    static /* synthetic */ Class class$java$lang$Object;
    private Class baseClass;
    private Declaration defaultPlugin;
    private PluginConfigurationException initException;
    private String pattern;
    private String pluginClassAttr = null;
    private String pluginClassAttrNs = null;
    private String pluginIdAttr = null;
    private String pluginIdAttrNs = null;

    public PluginCreateRule(Class cls) {
        this.baseClass = cls;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    private void fireBodyMethods(List list, String str, String str2, String str3) throws Exception {
        if (list != null && list.size() > 0) {
            Log logger = this.digester.getLogger();
            boolean isDebugEnabled = logger.isDebugEnabled();
            int i10 = 0;
            while (i10 < list.size()) {
                try {
                    Rule rule = (Rule) list.get(i10);
                    if (isDebugEnabled) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("  Fire body() for ");
                        stringBuffer.append(rule);
                        logger.debug(stringBuffer.toString());
                    }
                    rule.body(str, str2, str3);
                    i10++;
                } catch (Exception e10) {
                    throw this.digester.createSAXException(e10);
                } catch (Error e11) {
                    throw e11;
                }
            }
        }
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        String str3;
        String str4;
        Declaration declaration;
        Log logger = this.digester.getLogger();
        boolean isDebugEnabled = logger.isDebugEnabled();
        if (isDebugEnabled) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("PluginCreateRule.begin: pattern=[");
            stringBuffer.append(this.pattern);
            stringBuffer.append("]");
            stringBuffer.append(" match=[");
            stringBuffer.append(this.digester.getMatch());
            stringBuffer.append("]");
            logger.debug(stringBuffer.toString());
        }
        PluginConfigurationException pluginConfigurationException = this.initException;
        if (pluginConfigurationException == null) {
            PluginRules pluginRules = (PluginRules) this.digester.getRules();
            PluginManager pluginManager = pluginRules.getPluginManager();
            String str5 = this.pluginClassAttrNs;
            if (str5 == null) {
                str3 = attributes.getValue(this.pluginClassAttr);
            } else {
                str3 = attributes.getValue(str5, this.pluginClassAttr);
            }
            String str6 = this.pluginIdAttrNs;
            if (str6 == null) {
                str4 = attributes.getValue(this.pluginIdAttr);
            } else {
                str4 = attributes.getValue(str6, this.pluginIdAttr);
            }
            if (str3 != null) {
                declaration = pluginManager.getDeclarationByClass(str3);
                if (declaration == null) {
                    declaration = new Declaration(str3);
                    try {
                        declaration.init(this.digester, pluginManager);
                        pluginManager.addDeclaration(declaration);
                    } catch (PluginException e10) {
                        throw new PluginInvalidInputException(e10.getMessage(), e10.getCause());
                    }
                }
            } else if (str4 != null) {
                Declaration declarationById = pluginManager.getDeclarationById(str4);
                if (declarationById != null) {
                    declaration = declarationById;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Plugin id [");
                    stringBuffer2.append(str4);
                    stringBuffer2.append("] is not defined.");
                    throw new PluginInvalidInputException(stringBuffer2.toString());
                }
            } else {
                declaration = this.defaultPlugin;
                if (declaration == null) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("No plugin class specified for element ");
                    stringBuffer3.append(this.pattern);
                    throw new PluginInvalidInputException(stringBuffer3.toString());
                }
            }
            Class pluginClass = declaration.getPluginClass();
            String match = this.digester.getMatch();
            PluginRules pluginRules2 = new PluginRules(this.digester, match, pluginRules, pluginClass);
            this.digester.setRules(pluginRules2);
            if (isDebugEnabled) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("PluginCreateRule.begin: installing new plugin: oldrules=");
                stringBuffer4.append(pluginRules.toString());
                stringBuffer4.append(", newrules=");
                stringBuffer4.append(pluginRules2.toString());
                logger.debug(stringBuffer4.toString());
            }
            declaration.configure(this.digester, this.pattern);
            getDigester().push(pluginClass.newInstance());
            if (isDebugEnabled) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("PluginCreateRule.begin: pattern=[");
                stringBuffer5.append(this.pattern);
                stringBuffer5.append("]");
                stringBuffer5.append(" match=[");
                stringBuffer5.append(this.digester.getMatch());
                stringBuffer5.append("]");
                stringBuffer5.append(" pushed instance of plugin [");
                stringBuffer5.append(pluginClass.getName());
                stringBuffer5.append("]");
                logger.debug(stringBuffer5.toString());
            }
            fireBeginMethods(pluginRules2.getDecoratedRules().match(str, match), str, str2, attributes);
            return;
        }
        throw pluginConfigurationException;
    }

    public void body(String str, String str2, String str3) throws Exception {
        fireBodyMethods(((PluginRules) this.digester.getRules()).getDecoratedRules().match(str, this.digester.getMatch()), str, str2, str3);
    }

    public void end(String str, String str2) throws Exception {
        String match = this.digester.getMatch();
        PluginRules pluginRules = (PluginRules) this.digester.getRules();
        fireEndMethods(pluginRules.getDecoratedRules().match(str, match), str, str2);
        this.digester.setRules(pluginRules.getParent());
        this.digester.pop();
    }

    public void fireBeginMethods(List list, String str, String str2, Attributes attributes) throws Exception {
        if (list != null && list.size() > 0) {
            Log logger = this.digester.getLogger();
            boolean isDebugEnabled = logger.isDebugEnabled();
            int i10 = 0;
            while (i10 < list.size()) {
                try {
                    Rule rule = (Rule) list.get(i10);
                    if (isDebugEnabled) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("  Fire begin() for ");
                        stringBuffer.append(rule);
                        logger.debug(stringBuffer.toString());
                    }
                    rule.begin(str, str2, attributes);
                    i10++;
                } catch (Exception e10) {
                    throw this.digester.createSAXException(e10);
                } catch (Error e11) {
                    throw e11;
                }
            }
        }
    }

    public void fireEndMethods(List list, String str, String str2) throws Exception {
        if (list != null) {
            Log logger = this.digester.getLogger();
            boolean isDebugEnabled = logger.isDebugEnabled();
            int i10 = 0;
            while (i10 < list.size()) {
                try {
                    Rule rule = (Rule) list.get((list.size() - i10) - 1);
                    if (isDebugEnabled) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("  Fire end() for ");
                        stringBuffer.append(rule);
                        logger.debug(stringBuffer.toString());
                    }
                    rule.end(str, str2);
                    i10++;
                } catch (Exception e10) {
                    throw this.digester.createSAXException(e10);
                } catch (Error e11) {
                    throw e11;
                }
            }
        }
    }

    public String getPattern() {
        return this.pattern;
    }

    public void postRegisterInit(String str) throws PluginConfigurationException {
        Log logger = LogUtils.getLogger(this.digester);
        boolean isDebugEnabled = logger.isDebugEnabled();
        if (isDebugEnabled) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("PluginCreateRule.postRegisterInit: rule registered for pattern [");
            stringBuffer.append(str);
            stringBuffer.append("]");
            logger.debug(stringBuffer.toString());
        }
        if (this.digester == null) {
            PluginConfigurationException pluginConfigurationException = new PluginConfigurationException("Invalid invocation of postRegisterInit: digester not set.");
            this.initException = pluginConfigurationException;
            throw pluginConfigurationException;
        } else if (this.pattern != null) {
            PluginConfigurationException pluginConfigurationException2 = new PluginConfigurationException("A single PluginCreateRule instance has been mapped to multiple patterns; this is not supported.");
            this.initException = pluginConfigurationException2;
            throw pluginConfigurationException2;
        } else if (str.indexOf(42) == -1) {
            if (this.baseClass == null) {
                Class cls = class$java$lang$Object;
                if (cls == null) {
                    cls = class$(Validator.BEAN_PARAM);
                    class$java$lang$Object = cls;
                }
                this.baseClass = cls;
            }
            PluginRules pluginRules = (PluginRules) this.digester.getRules();
            PluginManager pluginManager = pluginRules.getPluginManager();
            Declaration declaration = this.defaultPlugin;
            if (declaration != null) {
                if (this.baseClass.isAssignableFrom(declaration.getPluginClass())) {
                    try {
                        this.defaultPlugin.init(this.digester, pluginManager);
                    } catch (PluginException e10) {
                        throw new PluginConfigurationException(e10.getMessage(), e10.getCause());
                    }
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Default class [");
                    stringBuffer2.append(this.defaultPlugin.getPluginClass().getName());
                    stringBuffer2.append("] does not inherit from [");
                    stringBuffer2.append(this.baseClass.getName());
                    stringBuffer2.append("].");
                    PluginConfigurationException pluginConfigurationException3 = new PluginConfigurationException(stringBuffer2.toString());
                    this.initException = pluginConfigurationException3;
                    throw pluginConfigurationException3;
                }
            }
            this.pattern = str;
            if (this.pluginClassAttr == null) {
                this.pluginClassAttrNs = pluginRules.getPluginClassAttrNs();
                this.pluginClassAttr = pluginRules.getPluginClassAttr();
                if (isDebugEnabled) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("init: pluginClassAttr set to per-digester values [ns=");
                    stringBuffer3.append(this.pluginClassAttrNs);
                    stringBuffer3.append(", name=");
                    stringBuffer3.append(this.pluginClassAttr);
                    stringBuffer3.append("]");
                    logger.debug(stringBuffer3.toString());
                }
            } else if (isDebugEnabled) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("init: pluginClassAttr set to rule-specific values [ns=");
                stringBuffer4.append(this.pluginClassAttrNs);
                stringBuffer4.append(", name=");
                stringBuffer4.append(this.pluginClassAttr);
                stringBuffer4.append("]");
                logger.debug(stringBuffer4.toString());
            }
            if (this.pluginIdAttr == null) {
                this.pluginIdAttrNs = pluginRules.getPluginIdAttrNs();
                this.pluginIdAttr = pluginRules.getPluginIdAttr();
                if (isDebugEnabled) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append("init: pluginIdAttr set to per-digester values [ns=");
                    stringBuffer5.append(this.pluginIdAttrNs);
                    stringBuffer5.append(", name=");
                    stringBuffer5.append(this.pluginIdAttr);
                    stringBuffer5.append("]");
                    logger.debug(stringBuffer5.toString());
                }
            } else if (isDebugEnabled) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("init: pluginIdAttr set to rule-specific values [ns=");
                stringBuffer6.append(this.pluginIdAttrNs);
                stringBuffer6.append(", name=");
                stringBuffer6.append(this.pluginIdAttr);
                stringBuffer6.append("]");
                logger.debug(stringBuffer6.toString());
            }
        } else {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("A PluginCreateRule instance has been mapped to pattern [");
            stringBuffer7.append(str);
            stringBuffer7.append("].");
            stringBuffer7.append(" This pattern includes a wildcard character.");
            stringBuffer7.append(" This is not supported by the plugin architecture.");
            PluginConfigurationException pluginConfigurationException4 = new PluginConfigurationException(stringBuffer7.toString());
            this.initException = pluginConfigurationException4;
            throw pluginConfigurationException4;
        }
    }

    public void setPluginClassAttribute(String str, String str2) {
        this.pluginClassAttrNs = str;
        this.pluginClassAttr = str2;
    }

    public void setPluginIdAttribute(String str, String str2) {
        this.pluginIdAttrNs = str;
        this.pluginIdAttr = str2;
    }

    public PluginCreateRule(Class cls, Class cls2) {
        this.baseClass = cls;
        if (cls2 != null) {
            this.defaultPlugin = new Declaration(cls2);
        }
    }

    public PluginCreateRule(Class cls, Class cls2, RuleLoader ruleLoader) {
        this.baseClass = cls;
        if (cls2 != null) {
            this.defaultPlugin = new Declaration(cls2, ruleLoader);
        }
    }
}
