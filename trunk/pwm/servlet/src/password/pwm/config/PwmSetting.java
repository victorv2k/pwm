/*
 * Password Management Servlets (PWM)
 * http://code.google.com/p/pwm/
 *
 * Copyright (c) 2006-2009 Novell, Inc.
 * Copyright (c) 2009-2010 The PWM Project
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package password.pwm.config;

import java.util.*;
import java.util.regex.Pattern;


/**
 * PwmConfiguration settings.
 * @author Jason D. Rivard
 */
public enum PwmSetting {
    // general settings
    APPLICATION_TILE(
            "title", Syntax.LOCALIZED_STRING, Category.GENERAL, true),
    URL_FORWARD(
            "forwardURL", Syntax.STRING, Category.GENERAL, true),
    URL_LOGOUT(
            "logoutURL", Syntax.STRING, Category.GENERAL, false),
    LOGOUT_AFTER_PASSWORD_CHANGE(
            "logoutAfterPasswordChange", Syntax.BOOLEAN, Category.GENERAL, true),
    EMAIL_SERVER_ADDRESS(
            "smtpServerAddress", Syntax.STRING, Category.GENERAL, false),
    ADMIN_ALERT_EMAIL_ADDRESS(
            "adminAlertToAddress", Syntax.STRING, Category.GENERAL, false),
    ADMIN_ALERT_FROM_ADDRESS(
            "adminAlertFromAddress", Syntax.STRING, Category.GENERAL, false),
    PASSWORD_EXPIRE_PRE_TIME(
            "expirePreTime", Syntax.NUMERIC, Category.GENERAL, true),
    PASSWORD_EXPIRE_WARN_TIME(
            "expireWarnTime", Syntax.NUMERIC, Category.GENERAL, true),
    EXPIRE_CHECK_DURING_AUTH(
            "expireCheckDuringAuth", Syntax.BOOLEAN, Category.GENERAL, true),
    PASSWORD_SYNC_MIN_WAIT_TIME(
            "passwordSyncMinWaitTime", Syntax.NUMERIC, Category.GENERAL, true),
    PASSWORD_SYNC_MAX_WAIT_TIME(
            "passwordSyncMaxWaitTime", Syntax.NUMERIC, Category.GENERAL, true),
    WORDLIST_FILENAME(
            "password.WordlistFile", Syntax.STRING, Category.GENERAL, false),
    SEEDLIST_FILENAME(
            "password.SeedlistFile", Syntax.STRING, Category.GENERAL, false),
    PASSWORD_SHAREDHISTORY_MAX_AGE(
            "password.sharedHistory.age", Syntax.NUMERIC, Category.GENERAL, true),
    GOOGLE_ANAYLTICS_TRACKER(
            "google.analytics.tracker", Syntax.STRING, Category.GENERAL, false),
    SHORTCUT_ITEMS(
            "shortCutItem", Syntax.LOCALIZED_STRING_ARRAY, Category.GENERAL, false),

    //ldap directory
    LDAP_SERVER_URLS(
            "ldapServerURLs", Syntax.STRING_ARRAY, Category.LDAP, true),
    LDAP_PROXY_USER_DN(
            "ldapProxyDN", Syntax.STRING, Category.LDAP, true),
    LDAP_PROXY_USER_PASSWORD(
            "ldapProxyPassword", Syntax.PASSWORD, Category.LDAP, true),
    LDAP_PROMISCUOUS_SSL(
            "ldapPromiscuousSSL", Syntax.BOOLEAN, Category.LDAP, true),
    LDAP_CONTEXTLESS_ROOT(
            "ldapContextlessLoginRoot", Syntax.STRING, Category.LDAP, false),
    LDAP_LOGIN_CONTEXTS(
            "ldapLoginContexts", Syntax.STRING_ARRAY, Category.LDAP, false),
    QUERY_MATCH_PWM_ADMIN(
            "pwmAdmin.queryMatch", Syntax.STRING, Category.LDAP, true),
    USERNAME_SEARCH_FILTER(
            "usernameSearchFilter", Syntax.STRING, Category.LDAP, true),
    AUTO_ADD_OBJECT_CLASSES(
            "autoAddObjectClasses", Syntax.STRING_ARRAY, Category.LDAP, false),
    QUERY_MATCH_CHANGE_PASSWORD(
            "password.allowChange.queryMatch", Syntax.STRING, Category.LDAP, true),
    LDAP_TIMEOUT(
            "ldapTimeout", Syntax.NUMERIC, Category.LDAP, true),
    LDAP_NAMING_ATTRIBUTE(
            "ldapNamingAttribute", Syntax.STRING, Category.LDAP, true),
    PASSWORD_LAST_UPDATE_ATTRIBUTE(
            "passwordLastUpdateAttribute", Syntax.STRING, Category.LDAP, true),


    //global password policy settings
    PASSWORD_POLICY_MINIMUM_LENGTH(
            "password.MinimumLength", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_LENGTH(
            "password.MaximumLength", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_REPEAT(
            "password.MaximumRepeat", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_SEQUENTIAL_REPEAT(
            "password.MaximumSequentialRepeat", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ALLOW_NUMERIC(
            "password.AllowNumeric", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ALLOW_FIRST_CHAR_NUMERIC(
            "password.AllowFirstCharNumeric", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ALLOW_LAST_CHAR_NUMERIC(
            "password.AllowLastCharNumeric", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_NUMERIC(
            "password.MaximumNumeric", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MINIMUM_NUMERIC(
            "password.MinimumNumeric", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ALLOW_SPECIAL(
            "password.AllowSpecial", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ALLOW_FIRST_CHAR_SPECIAL(
            "password.AllowFirstCharSpecial", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ALLOW_LAST_CHAR_SPECIAL(
            "password.AllowLastCharSpecial", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_SPECIAL(
            "password.MaximumSpecial", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MINIMUM_SPECIAL(
            "password.MinimumSpecial", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_ALPHA(
            "password.MaximumAlpha", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MINIMUM_ALPHA(
            "password.MinimumAlpha", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_UPPERCASE(
            "password.MaximumUpperCase", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MINIMUM_UPPERCASE(
            "password.MinimumUpperCase", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_LOWERCASE(
            "password.MaximumLowerCase", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MINIMUM_LOWERCASE(
            "password.MinimumLowerCase", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MINIMUM_UNIQUE(
            "password.MinimumUnique", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_MAXIMUM_OLD_PASSWORD_CHARS(
            "password.MaximumOldPasswordChars", Syntax.NUMERIC, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_ENABLE_WORDLIST(
            "password.checkWordlist", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_AD_COMPLEXITY(
            "password.ADComplexity", Syntax.BOOLEAN, Category.PASSWORD_POLICY, true),
    PASSWORD_POLICY_REGULAR_EXPRESSION_MATCH(
            "password.RegExMatch", Syntax.STRING_ARRAY, Category.PASSWORD_POLICY, false),
    PASSWORD_POLICY_REGULAR_EXPRESSION_NOMATCH(
            "password.RegExNoMatch", Syntax.STRING_ARRAY, Category.PASSWORD_POLICY, false),
    PASSWORD_POLICY_DISALLOWED_VALUES(
            "password.disallowedValues", Syntax.STRING_ARRAY, Category.PASSWORD_POLICY, false),
    PASSWORD_POLICY_DISALLOWED_ATTRIBUTES(
            "password.disallowedAttributes", Syntax.STRING_ARRAY, Category.PASSWORD_POLICY, false),
    PASSWORD_EMAIL_FROM(
            "password.email.from", Syntax.LOCALIZED_STRING, Category.PASSWORD_POLICY, false),
    PASSWORD_EMAIL_SUBJECT(
            "password.email.subject", Syntax.LOCALIZED_STRING, Category.PASSWORD_POLICY, false),
    PASSWORD_EMAIL_BODY(
            "password.email.body", Syntax.LOCALIZED_STRING, Category.PASSWORD_POLICY, false),


    // edirectory settings
    EDIRECTORY_ALWAYS_USE_PROXY(
            "ldap.edirectory.alwaysUseProxy", Syntax.BOOLEAN, Category.EDIRECTORY, true),
    EDIRECTORY_READ_PASSWORD_POLICY(
            "ldap.edirectory.readPasswordPolicies", Syntax.BOOLEAN, Category.EDIRECTORY, true),
    EDIRECTORY_ENABLE_NMAS(
            "ldap.edirectory.enableNmas", Syntax.BOOLEAN, Category.EDIRECTORY, true),
    EDIRECTORY_STORE_NMAS_RESPONSES(
            "ldap.edirectory.storeNmasResponses", Syntax.BOOLEAN, Category.EDIRECTORY, true),
    EDIRECTORY_READ_CHALLENGE_SET(
            "ldap.edirectory.readChallengeSets", Syntax.BOOLEAN, Category.EDIRECTORY, true),

    // intruder settings
    INTRUDER_USER_RESET_TIME(
            "intruder.user.resetTime", Syntax.NUMERIC, Category.INTRUDER, true),
    INTRUDER_USER_MAX_ATTEMPTS(
            "intruder.user.maxAttempts", Syntax.NUMERIC, Category.INTRUDER, true),
    INTRUDER_ADDRESS_RESET_TIME(
            "intruder.address.resetTime", Syntax.NUMERIC, Category.INTRUDER, true),
    INTRUDER_ADDRESS_MAX_ATTEMPTS(
            "intruder.address.maxAttempts", Syntax.NUMERIC, Category.INTRUDER, true),
    INTRUDER_SESSION_MAX_ATTEMPTS(
            "intruder.session.maxAttempts", Syntax.NUMERIC, Category.INTRUDER, true),

    // logger settings
    EVENT_LOG_MAX_LOCAL_EVENTS(
            "eventLog.localDbMaxEvents", Syntax.NUMERIC, Category.LOGGING, true),
    EVENT_LOG_MAX_LOCAL_AGE(
            "eventLog.localDbMaxAge", Syntax.NUMERIC, Category.LOGGING, true),
    EVENT_LOG_ATTRIBUTE(
            "eventLog.userAttribute", Syntax.STRING, Category.LOGGING, true),
    EVENT_LOG_MAX_EVENTS_USER(
            "eventLog.maxEvents", Syntax.NUMERIC, Category.LOGGING, true),
    EVENT_LOG_LOCAL_LEVEL(
            "eventLog.localDbLevel", Syntax.STRING, Category.LOGGING, true),

    // recovery settings
    CHALLANGE_FORCE_SETUP(
            "challenge.forceSetup", Syntax.BOOLEAN, Category.RECOVERY, true),
    QUERY_MATCH_SETUP_RESPONSE(
            "challenge.allowSetup.queryMatch", Syntax.STRING, Category.RECOVERY, true),
    CHALLENGE_USER_ATTRIBUTE(
            "challenge.userAttribute", Syntax.STRING, Category.RECOVERY, true),
    CHALLENGE_FORCE_ALL_RANDOMS(
            "challenge.forceAllRandoms", Syntax.BOOLEAN, Category.RECOVERY, true),
    CHALLENGE_ALLOW_UNLOCK(
            "challenge.allowUnlock", Syntax.BOOLEAN, Category.RECOVERY, true),
    CHALLENGE_STORAGE_HASHED(
            "challenge.storageHashed", Syntax.BOOLEAN, Category.RECOVERY, true),
    CASE_INSENSITIVE_CHALLENGE(
            "challenge.caseInsensitive", Syntax.BOOLEAN, Category.RECOVERY, true),
    ALLOW_DUPLICATE_RESPONSES(
            "challenge.allowDuplicateResponses", Syntax.BOOLEAN, Category.RECOVERY, true),
    CHALLENGE_APPLY_WORDLIST(
            "challenge.applyWorldlist", Syntax.BOOLEAN, Category.RECOVERY, true),
    CHALLENGE_SHOW_CONFIRMATION(
            "challenge.showConfirmation", Syntax.BOOLEAN, Category.RECOVERY, true),
    CHALLENGE_TOKEN_ATTRIBUTE(
            "challenge.tokenAttribute", Syntax.STRING, Category.RECOVERY, true),
    CHALLENGE_TOKEN_MAX_AGE(
            "challenge.tokenMaxAge", Syntax.NUMERIC, Category.RECOVERY, true),
    CHALLENGE_REQUIRED_CHALLENGES(
            "challenge.requiredChallenges", Syntax.LOCALIZED_STRING_ARRAY, Category.RECOVERY, false),
    CHALLENGE_RANDOM_CHALLENGES(
            "challenge.randomChallenges", Syntax.LOCALIZED_STRING_ARRAY, Category.RECOVERY, false),
    CHALLENGE_MIN_RANDOM_REQUIRED(
            "challenge.minRandomRequired", Syntax.NUMERIC, Category.RECOVERY, true),
    CHALLENGE_REQUIRED_ATTRIBUTES(
            "challenge.requiredAttributes", Syntax.LOCALIZED_STRING_ARRAY, Category.RECOVERY, false),
    QUERY_MATCH_CHECK_RESPONSES(
            "command.checkResponses.queryMatch", Syntax.STRING, Category.RECOVERY, true),

    // new user settings
    ENABLE_NEW_USER(
            "newUser.enable", Syntax.BOOLEAN, Category.NEWUSER, true),
    NEWUSER_CONTEXT(
            "newUser.createContext", Syntax.STRING, Category.NEWUSER, true),
    NEWUSER_FORM(
            "newUser.form", Syntax.LOCALIZED_STRING_ARRAY, Category.NEWUSER, true),
    NEWUSER_UNIQUE_ATTRIBUES(
            "newUser.creationUniqueAttributes", Syntax.STRING_ARRAY, Category.NEWUSER, false),
    NEWUSER_WRITE_ATTRIBUTES(
            "newUser.writeAttributes", Syntax.STRING_ARRAY, Category.NEWUSER, false),
    NEWUSER_EMAIL_SUBJECT(
            "newUser.email.subject", Syntax.LOCALIZED_STRING, Category.NEWUSER, false),
    NEWUSER_EMAIL_FROM(
            "newUser.email.from", Syntax.LOCALIZED_STRING, Category.NEWUSER, false),
    NEWUSER_EMAIL_BODY(
            "newUser.email.body", Syntax.LOCALIZED_STRING, Category.NEWUSER, false),

    // activation settings
    ENABLE_ACTIVATE_USER(
            "activateUser.enable", Syntax.BOOLEAN, Category.ACTIVATION, true),
    QUERY_MATCH_ACTIVATE_USER(
            "activateUser.queryMatch", Syntax.STRING, Category.ACTIVATION, true),
    ACTIVATE_USER_SEARCH_FILTER(
            "activateUser.searchFilter", Syntax.STRING, Category.ACTIVATION, true),
    ACTIVATE_USER_WRITE_ATTRIBUTES(
            "activateUser.writeAttributes", Syntax.STRING_ARRAY, Category.ACTIVATION, false),
    ACTIVATE_USER_FORM(
            "activateUser.form", Syntax.LOCALIZED_STRING_ARRAY, Category.ACTIVATION, true),

    // update attributes
    ENABLE_UPDATE_ATTRIBUTES(
            "updateAttributes.enable", Syntax.BOOLEAN, Category.UPDATE, true),
    QUERY_MATCH_UPDATE_USER(
            "updateAttributes.queryMatch", Syntax.STRING, Category.UPDATE, true),
    UPDATE_ATTRIBUTES_WRITE_ATTRIBUTES(
            "updateAttributes.writeAttributes", Syntax.STRING, Category.UPDATE, false),
    UPDATE_ATTRIBUTES_FORM(
            "updateAttributes.form", Syntax.LOCALIZED_STRING_ARRAY, Category.UPDATE, true),

    // captcha
    RECAPTCHA_KEY_PRIVATE(
            "captcha.recaptcha.privateKey", Syntax.STRING, Category.CAPTCHA, false),
    RECAPTCHA_KEY_PUBLIC(
            "captcha.recaptcha.publicKey", Syntax.STRING, Category.CAPTCHA, false),
    CAPTCHA_SKIP_PARAM(
            "captcha.skip.param", Syntax.STRING, Category.CAPTCHA, false),
    CAPTCHA_SKIP_COOKIE(
            "captcha.skip.cookie", Syntax.STRING, Category.CAPTCHA, false),

    // advanced
    URL_SERVET_RELATIVE(
            "servletRelativeURL", Syntax.STRING, Category.ADVANCED, true),
    EXTERNAL_PASSWORD_METHODS(
            "externalPasswordMethods", Syntax.STRING_ARRAY, Category.ADVANCED, false),
    DISALLOWED_HTTP_INPUTS(
            "disallowedInputs", Syntax.STRING_ARRAY, Category.ADVANCED, false),
    LDAP_CHAI_SETTINGS(
            "ldapChaiSettings", Syntax.STRING_ARRAY, Category.ADVANCED, false),
    USE_X_FORWARDED_FOR_HEADER(
            "useXForwardedForHeader", Syntax.BOOLEAN, Category.ADVANCED, true),
    ALLOW_URL_SESSIONS(
            "allowUrlSessions", Syntax.BOOLEAN, Category.ADVANCED, true),
    FORCE_BASIC_AUTH(
            "forceBasicAuth", Syntax.BOOLEAN, Category.ADVANCED, true),
    WORDLIST_CASE_SENSITIVE(
            "wordlistCaseSensitive", Syntax.BOOLEAN, Category.ADVANCED, true),

    ;
// ------------------------------ STATICS ------------------------------

    private static final Map<Category,List<PwmSetting>> VALUES_BY_CATEGORY;

    static {
        final Map<Category, List<PwmSetting>> returnMap = new LinkedHashMap<Category, List<PwmSetting>>();

        //setup nested lists
        for (final Category category : Category.values()) returnMap.put(category, new ArrayList<PwmSetting>());

        //populate map
        for (final PwmSetting setting : values()) returnMap.get(setting.getCategory()).add(setting);

        //make nested lists unmodifiable
        for (final Category category : Category.values()) returnMap.put(category, Collections.unmodifiableList(returnMap.get(category)));

        //assign unmodifable list
        VALUES_BY_CATEGORY = Collections.unmodifiableMap(returnMap);
    }

// ------------------------------ FIELDS ------------------------------

    private static class Static {
        private static final String RESOURCE_MISSING = "--RESOURCE MISSING--";
    }

    private final String key;
    private final Syntax syntax;
    private final Category category;
    private final boolean required;

// --------------------------- CONSTRUCTORS ---------------------------

    PwmSetting(
            final String key,
            final Syntax syntax,
            final Category category,
            final boolean required
    )
    {
        this.key = key;
        this.syntax = syntax;
        this.category = category;
        this.required = required;
    }

// --------------------- GETTER / SETTER METHODS ---------------------


    public String getKey()
    {
        return key;
    }

    public boolean isConfidential()
    {
        return Syntax.PASSWORD == this.getSyntax();
    }

    public Category getCategory() {
        return category;
    }

    public Syntax getSyntax() {
        return syntax;
    }

 

    // -------------------------- OTHER METHODS --------------------------

    public String getDefaultValue()
    {
        return readProps("DEFLT_" + this.getKey(), Locale.getDefault());
    }

    public String getLabel(final Locale locale) {
        return readProps("LABEL_" + this.getKey(), locale);
    }

    public String getDescription(final Locale locale) {
        return readProps("DESCR_" + this.getKey(), locale);
    }

    public boolean isRequired() {
        return required;
    }

    public Pattern getRegExPattern() {
        final String value = readProps("REGEX_" + this.getKey(), Locale.getDefault());

        if (value == null || value.length() < 1 || Static.RESOURCE_MISSING.equals(value) ) {
            return Pattern.compile(".*");
        }

        return Pattern.compile(value);
    }

    private static String readProps(final String key, final Locale locale) {
        try {
            final ResourceBundle bundle = ResourceBundle.getBundle(PwmSetting.class.getName(), locale);
            return bundle.getString(key);
        } catch (Exception e) {
            return Static.RESOURCE_MISSING;
        }
    }

    public enum Syntax {
        STRING,
        STRING_ARRAY,
        LOCALIZED_STRING,
        LOCALIZED_STRING_ARRAY,
        PASSWORD,
        NUMERIC,
        BOOLEAN,
    }

    public enum Category {
        GENERAL,
        LDAP,
        PASSWORD_POLICY,
        EDIRECTORY,
        INTRUDER,
        LOGGING,
        RECOVERY,
        NEWUSER,
        ACTIVATION,
        UPDATE,
        CAPTCHA,
        ADVANCED
        ;

        public String getLabel(final Locale locale)
        {
            return readProps("CATEGORY_LABEL_" + this.name(), locale);
        }

        public String getDescription(final Locale locale)
        {
            return readProps("CATEGORY_DESCR_" + this.name(), locale);
        }
    }

    public static Map<PwmSetting.Category, List<PwmSetting>> valuesByCategory() {
        return VALUES_BY_CATEGORY;
    }

    public static PwmSetting forKey(final String key) {
        for (final PwmSetting loopSetting : values()) {
            if (loopSetting.getKey().equals(key)) {
                return loopSetting;
            }
        }
        return null;
    }
}
