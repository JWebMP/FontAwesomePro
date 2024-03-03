import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;

module com.jwebmp.plugins.fontawesome5pro {
    requires transitive com.jwebmp.plugins.fontawesome5;
    requires com.guicedee.jsonrepresentation;
    requires com.jwebmp.client;

    exports com.jwebmp.plugins.fontawesome5pro;

    provides com.jwebmp.core.services.IPageConfigurator with FontAwesome5ProPageConfigurator;

    opens com.jwebmp.plugins.fontawesome5pro to com.google.guice, com.jwebmp.core;
}
