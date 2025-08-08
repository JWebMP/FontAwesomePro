package com.jwebmp.plugins.fontawesome5pro;

import com.jwebmp.plugins.fontawesome5.options.IFontAwesomeStyle;

public enum FontAwesome5ProStyles implements IFontAwesomeStyle<FontAwesome5ProStyles>
{
    Duotone("fad", "duotone"),
    DuotoneSharp("fads", "sharp-duotone"),
    Solid("fas", "solid");
    /**
     * The duo tone is set for pro only
     * Configure with FontAwesomePageConfigurator
     */

    private String angularText;
    private String familyName;

    FontAwesome5ProStyles(String angularText, String familyName)
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
