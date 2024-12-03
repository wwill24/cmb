package org.apache.commons.digester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegexRules extends AbstractRulesImpl {
    private RegexMatcher matcher;
    private ArrayList registeredRules = new ArrayList();

    private class RegisteredRule {
        String pattern;
        Rule rule;

        RegisteredRule(String str, Rule rule2) {
            this.pattern = str;
            this.rule = rule2;
        }
    }

    public RegexRules(RegexMatcher regexMatcher) {
        setRegexMatcher(regexMatcher);
    }

    public void clear() {
        this.registeredRules.clear();
    }

    public RegexMatcher getRegexMatcher() {
        return this.matcher;
    }

    public List match(String str, String str2) {
        ArrayList arrayList = new ArrayList(this.registeredRules.size());
        Iterator it = this.registeredRules.iterator();
        while (it.hasNext()) {
            RegisteredRule registeredRule = (RegisteredRule) it.next();
            if (this.matcher.match(str2, registeredRule.pattern)) {
                arrayList.add(registeredRule.rule);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void registerRule(String str, Rule rule) {
        this.registeredRules.add(new RegisteredRule(str, rule));
    }

    public List rules() {
        ArrayList arrayList = new ArrayList(this.registeredRules.size());
        Iterator it = this.registeredRules.iterator();
        while (it.hasNext()) {
            arrayList.add(((RegisteredRule) it.next()).rule);
        }
        return arrayList;
    }

    public void setRegexMatcher(RegexMatcher regexMatcher) {
        if (regexMatcher != null) {
            this.matcher = regexMatcher;
            return;
        }
        throw new IllegalArgumentException("RegexMatcher must not be null.");
    }
}
