package com.jwebmp.plugins.fontawesome5pro.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;

import java.util.Set;

public class FontAwesome5ProModuleInclusion implements IGuiceScanModuleInclusions<FontAwesome5ProModuleInclusion>
{
    @Override
    public Set<String> includeModules()
    {
        return Set.of("com.jwebmp.plugins.fontawesome5pro");
    }
}
