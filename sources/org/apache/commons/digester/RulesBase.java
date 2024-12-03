package org.apache.commons.digester;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RulesBase implements Rules {
    protected HashMap cache = new HashMap();
    protected Digester digester = null;
    protected String namespaceURI = null;
    protected ArrayList rules = new ArrayList();

    public void add(String str, Rule rule) {
        int length = str.length();
        if (length > 1 && str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = str.substring(0, length - 1);
        }
        List list = (List) this.cache.get(str);
        if (list == null) {
            list = new ArrayList();
            this.cache.put(str, list);
        }
        list.add(rule);
        this.rules.add(rule);
        Digester digester2 = this.digester;
        if (digester2 != null) {
            rule.setDigester(digester2);
        }
        String str2 = this.namespaceURI;
        if (str2 != null) {
            rule.setNamespaceURI(str2);
        }
    }

    public void clear() {
        this.cache.clear();
        this.rules.clear();
    }

    public Digester getDigester() {
        return this.digester;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    /* access modifiers changed from: protected */
    public List lookup(String str, String str2) {
        List<Rule> list = (List) this.cache.get(str2);
        if (list == null) {
            return null;
        }
        if (str == null || str.length() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Rule rule : list) {
            if (str.equals(rule.getNamespaceURI()) || rule.getNamespaceURI() == null) {
                arrayList.add(rule);
            }
        }
        return arrayList;
    }

    public List match(String str) {
        return match((String) null, str);
    }

    public List rules() {
        return this.rules;
    }

    public void setDigester(Digester digester2) {
        this.digester = digester2;
        Iterator it = this.rules.iterator();
        while (it.hasNext()) {
            ((Rule) it.next()).setDigester(digester2);
        }
    }

    public void setNamespaceURI(String str) {
        this.namespaceURI = str;
    }

    public List match(String str, String str2) {
        List lookup = lookup(str, str2);
        if (lookup == null || lookup.size() < 1) {
            String str3 = "";
            for (String str4 : this.cache.keySet()) {
                if (str4.startsWith("*/") && ((str2.equals(str4.substring(2)) || str2.endsWith(str4.substring(1))) && str4.length() > str3.length())) {
                    lookup = lookup(str, str4);
                    str3 = str4;
                }
            }
        }
        return lookup == null ? new ArrayList() : lookup;
    }
}
