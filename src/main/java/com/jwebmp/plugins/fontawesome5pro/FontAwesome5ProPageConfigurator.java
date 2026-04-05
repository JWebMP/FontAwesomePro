/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.fontawesome5pro;

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;
import com.jwebmp.plugins.fontawesome5.options.IconFamily;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * Page configurator for Font Awesome Pro icon packages.
 * <p>
 * Supports two modes:
 * <ul>
 *   <li><strong>Kit mode</strong> — set {@link #setKitCode(String)} with your FA Kit ID.
 *       A {@code <script>} tag is injected into the page head and no SVG icon npm packages are added.
 *       Kit mode also supports custom uploaded icons (fak prefix).</li>
 *   <li><strong>Package mode</strong> — enable individual icon families via {@link #enableFamily(IconFamily)}.
 *       Only the corresponding {@code @fortawesome/pro-*-svg-icons} npm packages are added.</li>
 * </ul>
 */
@PluginInformation(pluginName = "Font Awesome Pro",
        pluginDescription = "Font Awesome Pro icon families for JWebMP. " +
                "Supports Kit-based cloud delivery or selective npm package installation per icon family.",
        pluginUniqueName = "jwebmp-fontawesome-pro",
        pluginVersion = "7.2.0",
        pluginCategories = "fonts, icons, ui, framework",
        pluginSubtitle = "Font Awesome Pro icon support with per-family dependency management.",
        pluginSourceUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro",
        pluginWikiUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro/wiki",
        pluginGitUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro",
        pluginOriginalHomepage = "https://fontawesome.com",
        pluginDownloadUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro")

public class FontAwesome5ProPageConfigurator implements IPageConfigurator<FontAwesome5ProPageConfigurator>
{
    private static final String FA_VERSION = "^7.2.0";

    /**
     * Maps each IconFamily to its npm package name and short alias.
     * Only families that have a corresponding {@code @fortawesome} npm package are included.
     */
    private static final Map<IconFamily, String[]> FAMILY_PACKAGES = new EnumMap<>(IconFamily.class);

    static
    {
        // ── Pro Classic (overrides free solid/regular with pro versions) ──
        FAMILY_PACKAGES.put(IconFamily.Classic,        new String[]{"@fortawesome/pro-solid-svg-icons",               "fontawesome-pro-solid"});

        // ── Pro Duotone ──
        FAMILY_PACKAGES.put(IconFamily.Duotone,        new String[]{"@fortawesome/pro-duotone-svg-icons",             "fontawesome-pro-duotone"});

        // ── Sharp ──
        FAMILY_PACKAGES.put(IconFamily.Sharp,          new String[]{"@fortawesome/sharp-solid-svg-icons",             "fontawesome-sharp-solid"});

        // ── Sharp Duotone ──
        FAMILY_PACKAGES.put(IconFamily.Sharp_Duotone,  new String[]{"@fortawesome/sharp-duotone-solid-svg-icons",     "fontawesome-sharp-duotone-solid"});

        // ── Pro+ Styles ──
        FAMILY_PACKAGES.put(IconFamily.Chisel,         new String[]{"@fortawesome/chisel-regular-svg-icons",          "fontawesome-chisel-regular"});
        FAMILY_PACKAGES.put(IconFamily.Etch,           new String[]{"@fortawesome/etch-solid-svg-icons",              "fontawesome-etch-solid"});
        FAMILY_PACKAGES.put(IconFamily.Graphite,       new String[]{"@fortawesome/graphite-thin-svg-icons",           "fontawesome-graphite-thin"});
        FAMILY_PACKAGES.put(IconFamily.Jelly,          new String[]{"@fortawesome/jelly-regular-svg-icons",           "fontawesome-jelly-regular"});
        FAMILY_PACKAGES.put(IconFamily.Jelly_Duo,      new String[]{"@fortawesome/jelly-duo-regular-svg-icons",       "fontawesome-jelly-duo-regular"});
        FAMILY_PACKAGES.put(IconFamily.Jelly_Fill,     new String[]{"@fortawesome/jelly-fill-regular-svg-icons",      "fontawesome-jelly-fill-regular"});
        FAMILY_PACKAGES.put(IconFamily.Notdog,         new String[]{"@fortawesome/notdog-solid-svg-icons",            "fontawesome-notdog-solid"});
        FAMILY_PACKAGES.put(IconFamily.Notdog_Duo,     new String[]{"@fortawesome/notdog-duo-solid-svg-icons",        "fontawesome-notdog-duo-solid"});
        FAMILY_PACKAGES.put(IconFamily.Slab,           new String[]{"@fortawesome/slab-regular-svg-icons",            "fontawesome-slab-regular"});
        FAMILY_PACKAGES.put(IconFamily.Slab_Press,     new String[]{"@fortawesome/slab-press-regular-svg-icons",      "fontawesome-slab-press-regular"});
        FAMILY_PACKAGES.put(IconFamily.Thumbprint,     new String[]{"@fortawesome/thumbprint-light-svg-icons",        "fontawesome-thumbprint-light"});
        FAMILY_PACKAGES.put(IconFamily.Utility,        new String[]{"@fortawesome/utility-semibold-svg-icons",        "fontawesome-utility-semibold"});
        FAMILY_PACKAGES.put(IconFamily.Utility_Duo,    new String[]{"@fortawesome/utility-duo-semibold-svg-icons",    "fontawesome-utility-duo-semibold"});
        FAMILY_PACKAGES.put(IconFamily.Utility_Fill,   new String[]{"@fortawesome/utility-fill-semibold-svg-icons",   "fontawesome-utility-fill-semibold"});
        FAMILY_PACKAGES.put(IconFamily.Whiteboard,     new String[]{"@fortawesome/whiteboard-semibold-svg-icons",     "fontawesome-whiteboard-semibold"});

        // Kit and Kit_Custom don't have npm packages — they're cloud-delivered via Kit script
    }

    /**
     * Enabled icon families. Only enabled families will have their npm packages added.
     */
    private static final Set<IconFamily> enabledFamilies = EnumSet.noneOf(IconFamily.class);

    private static String proKey;

    /**
     * The Font Awesome Kit code for cloud-configured icons (including custom uploaded icons).
     * When set, a {@code <script src="https://kit.fontawesome.com/{kitCode}.js">} tag
     * will be added to the page head, and no individual SVG icon packages will be installed.
     */
    private static String kitCode = "";

    /**
     * When true, all Pro variant packages (solid, regular, light, thin, duotone) are added.
     * Use this for convenience when you don't want to enable families individually.
     */
    private static boolean enableAllProVariants = false;

    public FontAwesome5ProPageConfigurator()
    {
        //Nothing Needed
    }

    // ── Configuration ────────────────────────────────────────

    @Override
    public IPage<?> configure(IPage<?> page)
    {
        if (!Strings.isNullOrEmpty(kitCode))
        {
            page.getHead()
                .add(new Script<>("https://kit.fontawesome.com/" + kitCode + ".js")
                        .addAttribute("crossorigin", "anonymous"));
        }
        return page;
    }

    /**
     * Adds Font Awesome Pro SVG icon npm dependencies based on enabled families.
     * Skipped entirely when Kit mode is active.
     */
    @Override
    public IPage<?> configureAngular(IPage<?> page)
    {
        if (!Strings.isNullOrEmpty(kitCode))
        {
            return page;
        }

        if (enableAllProVariants)
        {
            // Pro Classic — all four weight variants
            addDependency(page, "@fortawesome/pro-solid-svg-icons",    "fontawesome-pro-solid",    true);
            addDependency(page, "@fortawesome/pro-regular-svg-icons",  "fontawesome-pro-regular",  false);
            addDependency(page, "@fortawesome/pro-light-svg-icons",    "fontawesome-pro-light",    false);
            addDependency(page, "@fortawesome/pro-thin-svg-icons",     "fontawesome-pro-thin",     false);
            // Pro Duotone
            addDependency(page, "@fortawesome/pro-duotone-svg-icons",  "fontawesome-pro-duotone",  false);
            // Sharp — all four weight variants
            addDependency(page, "@fortawesome/sharp-solid-svg-icons",          "fontawesome-sharp-solid",          false);
            addDependency(page, "@fortawesome/sharp-regular-svg-icons",        "fontawesome-sharp-regular",        false);
            addDependency(page, "@fortawesome/sharp-light-svg-icons",          "fontawesome-sharp-light",          false);
            addDependency(page, "@fortawesome/sharp-thin-svg-icons",           "fontawesome-sharp-thin",           false);
            // Sharp Duotone
            addDependency(page, "@fortawesome/sharp-duotone-solid-svg-icons",  "fontawesome-sharp-duotone-solid",  false);
        }
        else
        {
            for (IconFamily family : enabledFamilies)
            {
                String[] pkg = FAMILY_PACKAGES.get(family);
                if (pkg != null)
                {
                    addDependency(page, pkg[0], pkg[1], family == IconFamily.Classic);
                }
            }
        }

        return page;
    }

    private void addDependency(IPage<?> page, String packageName, String alias, boolean overrides)
    {
        page.getBody().addConfiguration(
                AnnotationUtils.getTsDependency(packageName, FA_VERSION, alias, overrides));
    }

    // ── Lifecycle ────────────────────────────────────────────

    @Override
    public boolean enabled()
    {
        return true;
    }

    @Override
    public Integer sortOrder()
    {
        return 50;
    }

    // ── Family flags ─────────────────────────────────────────

    /**
     * Enables an icon family so its npm package will be added as a dependency.
     * Has no effect when Kit mode is active.
     *
     * @param family the icon family to enable
     */
    public static void enableFamily(IconFamily family)
    {
        enabledFamilies.add(family);
    }

    /**
     * Disables an icon family so its npm package will not be added.
     *
     * @param family the icon family to disable
     */
    public static void disableFamily(IconFamily family)
    {
        enabledFamilies.remove(family);
    }

    /**
     * Returns whether the given icon family is enabled.
     */
    public static boolean isFamilyEnabled(IconFamily family)
    {
        return enabledFamilies.contains(family);
    }

    /**
     * Returns the set of currently enabled icon families.
     */
    public static Set<IconFamily> getEnabledFamilies()
    {
        return EnumSet.copyOf(enabledFamilies);
    }

    // ── Kit code ─────────────────────────────────────────────

    public static String getKitCode()
    {
        return kitCode;
    }

    /**
     * Sets the Font Awesome Kit code. When set, the kit script tag will be
     * injected into the page head and individual SVG icon packages will NOT
     * be added — the Kit script fetches all icons from the cloud.
     * Also enables custom uploaded icons (fak prefix).
     *
     * @param kitCode the kit identifier, e.g. "cf4534f35c"
     */
    public static void setKitCode(String kitCode)
    {
        FontAwesome5ProPageConfigurator.kitCode = kitCode;
        // Also set on the free configurator so it skips its npm packages too
        FontAwesome5PageConfigurator.setKitCode(kitCode);
    }

    // ── Pro key ──────────────────────────────────────────────

    public static String getProKey()
    {
        return proKey;
    }

    public static void setProKey(String proKey)
    {
        FontAwesome5ProPageConfigurator.proKey = proKey;
    }

    // ── Convenience ──────────────────────────────────────────

    public static boolean isEnableAllProVariants()
    {
        return enableAllProVariants;
    }

    /**
     * When set to true, all five Pro variant packages (solid, regular, light, thin, duotone)
     * are added regardless of individual family flags. Has no effect when Kit mode is active.
     */
    public static void setEnableAllProVariants(boolean enableAll)
    {
        FontAwesome5ProPageConfigurator.enableAllProVariants = enableAll;
    }
}
