import com.guicedee.client.services.config.IGuiceScanModuleInclusions;
import com.jwebmp.core.base.angular.services.interfaces.NpmrcConfigurator;
import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;
import com.jwebmp.plugins.fontawesome5pro.implementations.FontAwesome5ProModuleInclusion;
import com.jwebmp.plugins.fontawesome5pro.implementations.FontAwesomeNpmrcConfigurator;

module com.jwebmp.plugins.fontawesome5pro {
    requires transitive com.jwebmp.plugins.fontawesome5;
    requires com.guicedee.jsonrepresentation;
    requires com.jwebmp.client;
    requires com.jwebmp.core.angular;

    exports com.jwebmp.plugins.fontawesome5pro;

    provides com.jwebmp.core.services.IPageConfigurator with FontAwesome5ProPageConfigurator;
    provides IGuiceScanModuleInclusions with FontAwesome5ProModuleInclusion;
    provides NpmrcConfigurator with FontAwesomeNpmrcConfigurator;
    
    opens com.jwebmp.plugins.fontawesome5pro to com.google.guice, com.jwebmp.core;
}
