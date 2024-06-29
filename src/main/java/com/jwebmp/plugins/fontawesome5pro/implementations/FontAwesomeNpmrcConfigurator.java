package com.jwebmp.plugins.fontawesome5pro.implementations;

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.services.interfaces.NpmrcConfigurator;
import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;

import java.util.Set;

public class FontAwesomeNpmrcConfigurator implements NpmrcConfigurator
{
    @Override
    public Set<String> lines()
    {
        if (!Strings.isNullOrEmpty(FontAwesome5ProPageConfigurator.getProKey()))
        {
            return Set.of("""
                                  @fortawesome:registry=https://npm.fontawesome.com/
                                  @awesome.me:registry=https://npm.fontawesome.com/
                                  //npm.fontawesome.com/:_authToken=""" + FontAwesome5ProPageConfigurator.getProKey());
        }

        return Set.of();
    }
}
