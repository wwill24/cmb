package org.apache.commons.digester.plugins;

import java.util.LinkedList;
import java.util.List;
import org.apache.commons.digester.plugins.strategies.FinderFromClass;
import org.apache.commons.digester.plugins.strategies.FinderFromDfltClass;
import org.apache.commons.digester.plugins.strategies.FinderFromDfltMethod;
import org.apache.commons.digester.plugins.strategies.FinderFromDfltResource;
import org.apache.commons.digester.plugins.strategies.FinderFromFile;
import org.apache.commons.digester.plugins.strategies.FinderFromMethod;
import org.apache.commons.digester.plugins.strategies.FinderFromResource;
import org.apache.commons.digester.plugins.strategies.FinderSetProperties;

public class PluginContext {
    public final String DFLT_PLUGIN_CLASS_ATTR = "plugin-class";
    public final String DFLT_PLUGIN_CLASS_ATTR_NS = null;
    public final String DFLT_PLUGIN_ID_ATTR = "plugin-id";
    public final String DFLT_PLUGIN_ID_ATTR_NS = null;
    private String pluginClassAttr = "plugin-class";
    private String pluginClassAttrNs = null;
    private String pluginIdAttr = "plugin-id";
    private String pluginIdAttrNs = null;
    private List ruleFinders;

    public String getPluginClassAttr() {
        return this.pluginClassAttr;
    }

    public String getPluginClassAttrNs() {
        return this.pluginClassAttrNs;
    }

    public String getPluginIdAttr() {
        return this.pluginIdAttr;
    }

    public String getPluginIdAttrNs() {
        return this.pluginIdAttrNs;
    }

    public List getRuleFinders() {
        if (this.ruleFinders == null) {
            LinkedList linkedList = new LinkedList();
            this.ruleFinders = linkedList;
            linkedList.add(new FinderFromFile());
            this.ruleFinders.add(new FinderFromResource());
            this.ruleFinders.add(new FinderFromClass());
            this.ruleFinders.add(new FinderFromMethod());
            this.ruleFinders.add(new FinderFromDfltMethod());
            this.ruleFinders.add(new FinderFromDfltClass());
            this.ruleFinders.add(new FinderFromDfltResource());
            this.ruleFinders.add(new FinderFromDfltResource(".xml"));
            this.ruleFinders.add(new FinderSetProperties());
        }
        return this.ruleFinders;
    }

    public void setPluginClassAttribute(String str, String str2) {
        this.pluginClassAttrNs = str;
        this.pluginClassAttr = str2;
    }

    public void setPluginIdAttribute(String str, String str2) {
        this.pluginIdAttrNs = str;
        this.pluginIdAttr = str2;
    }

    public void setRuleFinders(List list) {
        this.ruleFinders = list;
    }
}
