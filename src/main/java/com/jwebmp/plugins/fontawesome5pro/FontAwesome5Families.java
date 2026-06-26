package com.jwebmp.plugins.fontawesome5pro;

import com.jwebmp.plugins.fontawesome5.options.IFontAwesomeFamilies;

public enum FontAwesome5Families implements IFontAwesomeFamilies<FontAwesome5Families>
{
    // ──────────────────────────────────────────────────────────────
    // Pro families
    // Configure with FontAwesomePageConfigurator
    // ──────────────────────────────────────────────────────────────
    /**
     * Duotone family (Pro). Styles: solid, regular, light, thin.
     */
    Duotone("fad", "duotone"),
    /**
     * Sharp family (Pro). Styles: solid, regular, light, thin.
     */
    Sharp("sharp", "sharp"),
    /**
     * Sharp Duotone family (Pro). Styles: solid, regular, light, thin.
     */
    SharpDuotone("sharp-duotone", "sharp-duotone"),

    // ──────────────────────────────────────────────────────────────
    // Pro Plus families (artistic / expressive)
    // ──────────────────────────────────────────────────────────────
    /**
     * Chisel family (Pro Plus). Styles: regular.
     */
    Chisel("chisel", "chisel"),
    /**
     * Etch family (Pro Plus). Styles: solid.
     */
    Etch("etch", "etch"),
    /**
     * Graphite family (Pro Plus). Styles: thin.
     */
    Graphite("graphite", "graphite"),
    /**
     * Jelly family (Pro Plus). Styles: regular.
     */
    Jelly("jelly", "jelly"),
    /**
     * Jelly Fill family (Pro Plus). Styles: regular.
     */
    JellyFill("jelly-fill", "jelly-fill"),
    /**
     * Jelly Duo family (Pro Plus). Styles: regular.
     */
    JellyDuo("jelly-duo", "jelly-duo"),
    /**
     * Notdog family (Pro Plus). Styles: solid.
     */
    NotDog("notdog", "notdog"),
    /**
     * Notdog Duo family (Pro Plus). Styles: solid.
     */
    NotDogDuo("notdog-duo", "notdog-duo"),
    /**
     * Slab family (Pro Plus). Styles: regular.
     */
    Slab("slab", "slab"),
    /**
     * Slab Press family (Pro Plus). Styles: regular.
     */
    SlabPress("slab-press", "slab-press"),
    /**
     * Thumbprint family (Pro Plus). Styles: light.
     */
    ThumbPrint("thumbprint", "thumbprint"),
    /**
     * Utility family (Pro Plus). Styles: semibold.
     */
    Utility("utility", "utility"),
    /**
     * Utility Fill family (Pro Plus). Styles: semibold.
     */
    UtilityFill("utility-fill", "utility-fill"),
    /**
     * Utility Duo family (Pro Plus). Styles: semibold.
     */
    UtilityDuo("utility-duo", "utility-duo"),
    /**
     * Whiteboard family (Pro Plus). Styles: semibold.
     */
    Whiteboard("whiteboard", "whiteboard"),
    ;

    /**
     * @deprecated Misnamed alias retained for backwards compatibility, use {@link #SharpDuotone}.
     */
    @Deprecated
    public static final FontAwesome5Families DuotoneSharp = SharpDuotone;

    private String angularText;
    private String familyName;

    FontAwesome5Families(String angularText, String familyName)
    {
        this.angularText = angularText;
        this.familyName = familyName;
    }

    @Override
    public String getAngularText()
    {
        return angularText;
    }

    @Override
    public String getFamilyName()
    {
        return familyName;
    }

    @Override
    public String toString()
    {
        return familyName;
    }
}
