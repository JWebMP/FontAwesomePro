package com.jwebmp.plugins.fontawesome5pro.tests;

import com.jwebmp.plugins.fontawesome5.options.IconFamily;
import com.jwebmp.plugins.fontawesome5.options.IconVariant;
import com.jwebmp.plugins.fontawesome5.IFontAwesomeIcon;
import com.jwebmp.plugins.fontawesome5pro.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyIconCatalogTest
{
    @Test
    void vellumContainsOnlyItsCanonicalCatalog()
    {
        assertEquals(240, FontAwesomeVellumIcons.values().length);
        assertEquals(IconFamily.Vellum, FontAwesomeVellumIcons.house.getFamily());
        assertEquals(IconVariant.Solid, FontAwesomeVellumIcons.house.getVariant());
        assertThrows(IllegalArgumentException.class, () -> FontAwesomeVellumIcons.valueOf("abacus"));
        assertNotNull(FontAwesomeClassicIcons.abacus);
    }

    @Test
    void rejectsUnavailableWeights()
    {
        assertThrows(IllegalArgumentException.class,
                () -> FontAwesomeVellumIcons.house.requireVariant(IconVariant.Regular));
        assertEquals(IconVariant.Thin, FontAwesomeSharpIcons.house.requireVariant(IconVariant.Thin));
        assertEquals(IconVariant.Semibold, FontAwesomeUtilityIcons.house.getVariant());
        assertThrows(UnsupportedOperationException.class,
                () -> FontAwesomeVellumIcons.house.getSupportedVariants().add(IconVariant.Thin));
    }

    @Test
    void namesAreSuitableForCssAngularAndSvgResolvers()
    {
        assertEquals("address-card", FontAwesomeVellumIcons.address_card.toAngularIconAttributeName());
        assertEquals("fa-address-card", FontAwesomeVellumIcons.address_card.toString());
        assertEquals("faAddressCard", FontAwesomeVellumIcons.address_card.toAngularIcon());
        assertEquals("0", FontAwesomeClassicIcons.$0.toAngularIconAttributeName());
        assertEquals("fa0", FontAwesomeClassicIcons.$0.toAngularIcon());
        assertEquals("fa-360-degrees", FontAwesomeClassicIcons.$360_degrees.toString());
    }

    @Test
    void legacyProEnumExposesNewNamesWithoutChangingOldConstants()
    {
        IFontAwesomeIcon added = FontAwesome5ProIcons.aeropress;
        assertSame(FontAwesomeClassicIcons.aeropress, added);
        assertEquals("fa-aeropress", added.toString());
        assertSame(FontAwesome5ProIcons.abacus, FontAwesome5ProIcons.valueOf("abacus"));
        assertEquals(4099, FontAwesome5ProIcons.values().length);
    }
}
