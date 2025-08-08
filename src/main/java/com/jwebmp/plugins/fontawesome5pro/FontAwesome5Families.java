package com.jwebmp.plugins.fontawesome5pro;

import com.jwebmp.plugins.fontawesome5.options.IFontAwesomeFamilies;

public enum FontAwesome5Families implements IFontAwesomeFamilies<FontAwesome5Families>
{
    /**
     * The duo tone is set for pro only
     * Configure with FontAwesomePageConfigurator
     */
    Duotone("fad", "duotone"),
    Sharp("sharp", "sharp"),
    DuotoneSharp("sharp-duotone", "sharp-duotone"),
    Chisel("chisel", "chisel"),
    Etch("etch", "etch"),
    Jelly("jelly", "jelly"),
    NotDog("notdog", "notdog"),
    Slab("slab", "slab"),
    ThumbPrint("thumb-print", "thumb-print"),
    Whiteboard("whiteboard", "whiteboard"),
    ;

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
