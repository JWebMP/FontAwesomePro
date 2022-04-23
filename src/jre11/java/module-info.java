import com.jwebmp.plugins.fontawesome5pro.*;

module com.jwebmp.plugins.fontawesome5pro {
	requires transitive com.jwebmp.plugins.fontawesome5;
	
	exports com.jwebmp.plugins.fontawesome5pro;
	
	provides com.jwebmp.core.services.IPageConfigurator with FontAwesome5ProPageConfigurator;
	
	opens com.jwebmp.plugins.fontawesome5pro to com.google.guice,com.jwebmp.core;
}
