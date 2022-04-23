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

import com.jwebmp.core.*;
import com.jwebmp.core.base.angular.services.annotations.*;
import com.jwebmp.core.base.angular.services.annotations.references.*;
import com.jwebmp.core.base.angular.services.annotations.structures.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.core.services.*;
import com.jwebmp.plugins.fontawesome5.config.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import jakarta.validation.constraints.*;

/**
 * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
 * <p>
 * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries WARNING: Respond.js doesn't work if you view the page via
 * file://
 */
@PluginInformation(pluginName = "Component Template",
        pluginDescription = "ComponentTemplate does only one thing: replace the browser's default scrollbar with a custom CSS-styled one without losing performances. Unlike some popular plugins, ComponentTemplate doesn't mimic scroll with Javascript, causing janks and strange scrolling behaviours... You keep the awesomeness of native scrolling...with a custom scrollbar!\n" +
                "ComponentTemplate does NOT implement a custom scroll behaviour. It keeps the native overflow: auto scroll and only replace the scrollbar visual appearance.",
        pluginUniqueName = "jwebmp-componenttemplate",
        pluginVersion = "5.1.0",
        pluginCategories = "componenttemplate,ui,web ui, framework",
        pluginSubtitle = "ComponentTemplate makes sidebar development faster and easier.",
        pluginSourceUrl = "https://github.com/Grsmto/componenttemplate",
        pluginWikiUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro/wiki",
        pluginGitUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro",
        pluginIconUrl = "bower_components/componenttemplate/componenttemplateicon.jpg",
        pluginIconImageUrl = "bower_components/componenttemplate/componenttemplatelogo.jpg",
        pluginOriginalHomepage = "https://github.com/Grsmto/componenttemplate",
        pluginDownloadUrl = "https://github.com/GedMarc/JWebMP-FontAwesome5Pro")

//@NgBootImportReference(name = "fas", reference = "@fortawesome/pro-solid-svg-icons",overrides = true)
//@NgBootImportReference(name = "far", reference = "@fortawesome/pro-regular-svg-icons",overrides = true)
//@NgBootImportReference(name = "fad", reference = "@fortawesome/pro-duotone-svg-icons",overrides = true)
//@NgBootImportReference(name = "fal", reference = "@fortawesome/pro-light-svg-icons",overrides = true)
//@NgBootImportReference(name = "fat", reference = "@fortawesome/pro-thin-svg-icons",overrides = true)

@TsDependency(value = "@fortawesome/pro-solid-svg-icons", version = "^6.0.0", name = "fontawesome-svg-solid",overrides = true)
@TsDependency(value = "@fortawesome/pro-regular-svg-icons", version = "^6.0.0", name = "fontawesome-svg-regular")
@TsDependency(value = "@fortawesome/pro-light-svg-icons", version = "^6.0.0", name = "fontawesome-svg-light")
@TsDependency(value = "@fortawesome/pro-duotone-svg-icons", version = "^6.0.0", name = "fontawesome-svg-duotone")
@TsDependency(value = "@fortawesome/pro-thin-svg-icons", version = "^6.0.0", name = "fontawesome-svg-thin")

//@NgBootConstructorBody("library.addIconPacks(fad);")
//@NgBootConstructorBody("library.addIconPacks(fal);")
//@NgBootConstructorBody("library.addIconPacks(far);")
//@NgBootConstructorBody("library.addIconPacks(fat);")

public class FontAwesome5ProPageConfigurator implements IPageConfigurator<FontAwesome5ProPageConfigurator>
{
    static {
        FontAwesome5PageConfigurator.tsDependencies.put(FontAwesomeStyles.Solid,"@fortawesome/pro-solid-svg-icons");
        FontAwesome5PageConfigurator.tsDependencies.put(FontAwesomeStyles.Brand,"@fortawesome/free-brands-svg-icons");
        FontAwesome5PageConfigurator.tsDependencies.put(FontAwesomeStyles.Regular,"@fortawesome/pro-regular-svg-icons");
        FontAwesome5PageConfigurator.tsDependencies.put(FontAwesomeStyles.Duotone,"@fortawesome/pro-duotone-svg-icons");
        FontAwesome5PageConfigurator.tsDependencies.put(FontAwesomeStyles.Light,"@fortawesome/pro-light-svg-icons");
        FontAwesome5PageConfigurator.tsDependencies.put(FontAwesomeStyles.Thin,"@fortawesome/pro-thin-svg-icons");
    }
    
    /**
     * The default page configurator for componenttemplate
     */
    public FontAwesome5ProPageConfigurator() {
        //Nothing Needed
    }
    /**
     * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
     * <p>
     * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries WARNING: Respond.js doesn't work if you view the page
     * via file://
     *
     * @return
     */
    @NotNull
    @Override
    public Page<?> configure(Page<?> page) {
        return page;
    }

    @Override
    public boolean enabled() {
        return true;
    }
    
    @Override
    public Integer sortOrder()
    {
        return 50;
    }
}
