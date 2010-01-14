
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2009, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.text.linguistic;

import java.util.Locale;
import java.util.Map;

import org.carrot2.util.StringUtils;

import com.google.common.collect.Maps;

/**
 * Codes for languages for which linguistic resources are available 
 * in {@link DefaultLanguageModelFactory}.
 * <p>
 * Notes about third-party or extra implementation needs.
 * <ul>
 *  <li>{@link #POLISH} makes use of Morfologik stemming library
 *  if it is available in the classpath.</li>
 *  <li>{@link #CHINESE_SIMPLIFIED} makes use of Lucene's smartcn tokenizer
 *  if it is available in the classpath.</li>
 * </ul> 
 */
public enum LanguageCode
{
    /*
     * When adding a language, check:
     * - language mappings in carrot2-source-(boss|microsoft).
     */

    ARABIC ("ar"),
    CHINESE_SIMPLIFIED ("zh_cn"),
    DANISH ("da"),
    DUTCH ("nl"),
    ENGLISH ("en"),
    FINNISH ("fi"),
    // PERSIAN ("fa"),
    FRENCH ("fr"),
    GERMAN ("de"),
    HUNGARIAN ("hu"),
    ITALIAN ("it"),
    KOREAN ("ko"),
    NORWEGIAN ("no"),
    POLISH ("pl"),
    PORTUGUESE ("pt"),
    ROMANIAN ("ro"),
    RUSSIAN ("ru"),
    SPANISH ("es"),
    SWEDISH ("sv"),
    TURKISH ("tr");

    /**
     * ISO 639-1 code for this language. An underscore may separate additional country/region
     * variant, should it be relevant (as in Simplified and Traditional Chinese).
     * 
     * @see "http://www.loc.gov/standards/iso639-2/php/code_list.php"
     */
    private final String isoCode;

    /**
     * Java {@link Locale} for this language (for case folding,
     * for example).
     */
    private final Locale locale;

    /**
     * A hash map of all ISO language codes.
     */
    private final static Map<String, LanguageCode> isoToLangCode;
    static
    {
        isoToLangCode = Maps.newHashMap();
        for (LanguageCode langCode : values())
        {
            isoToLangCode.put(langCode.getIsoCode(), langCode);
        }
    }
    
    /**
     * 
     */
    private LanguageCode(String isoCode)
    {
        this.isoCode = isoCode;
        this.locale = new Locale(isoCode);
    }

    /**
     * @return ISO code for this language.
     */
    public String getIsoCode()
    {
        return isoCode;
    }
    
    /**
     * @return Returns {@link Locale} associated with the given 
     * language.
     */
    public Locale getLocale()
    {
        return locale;
    }

    /**
     * Return a {@link LanguageCode} constant for a given ISO code (or <code>null</code>)
     * if not available.
     */
    public static LanguageCode forISOCode(String language)
    {
        language = language.toLowerCase();
        return isoToLangCode.get(language);
    }
    
    @Override
    public String toString()
    {
        return StringUtils.identifierToHumanReadable(name());
    }
}
