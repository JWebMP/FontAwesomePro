import com.guicedee.guicedinjection.*;

import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.angular.services.compiler.*;
import com.jwebmp.core.base.angular.services.interfaces.*;
import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.fontawesome5.*;
import com.jwebmp.plugins.fontawesome5.icons.*;
import com.jwebmp.plugins.fontawesome5.options.*;
import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.*;


@NgComponent(value = "fontawesome-kitchen-sink")
public class FontAwesomeKitchenSink extends DivSimple<FontAwesomeKitchenSink>
        implements INgComponent<FontAwesomeKitchenSink>
{
    @Override
    protected void init()
    {
        add(FontAwesome.icon(FontAwesomeIcons.star));
        add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeStyles.Duotone));
        add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.Lg));
        add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$5x)
                       .spin());
        add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$4x, FontAwesomeStyles.Filled)
                       .pullRight());
        add(FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeSizes.$3x, FontAwesomeStyles.Classic)
                       .border());
        add(FontAwesome.icon(FontAwesomeIcons.coffee, FontAwesomeSizes.$2x, FontAwesomeStyles.Duotone)
                       .fixedWidth());


        add(new FontAwesomeLayers()
                .addIcon(FontAwesome.icon(FontAwesomeBrandIcons.twitch, FontAwesomeStyles.Brand))
                .addText(new FontAwesomeLayerText().setText("Yo")
                                                   .transform(FontAwesomeTransforms.Shrink_4))
        );

        add(new FontAwesomeLayers()
                .fixedWidth()
                .setSize(FontAwesomeSizes.Lg)
                .addIcon(FontAwesome.icon(FontAwesomeBrandIcons.twitch, FontAwesomeStyles.Brand))
                .addCounter(new FontAwesomeLayerCounter().setText("99+")
                )
        );


        super.init();
    }

    @Test
    public void testAppSearch() throws IOException, InterruptedException
    {
        GuiceContext.instance()
                    .inject();

        FontAwesome5ProPageConfigurator.setProKey("149597AD-E9FB-4ECC-84B7-75CBE795841F");
        for (INgApp<?> app : JWebMPTypeScriptCompiler.getAllApps())
        {
            JWebMPTypeScriptCompiler compiler = new JWebMPTypeScriptCompiler(app);

            System.out.println("Generating @NgApp (" + getTsFilename(app.getClass()) + ") " +
                    "in folder " + IComponent.getClassDirectory(app.getClass()));
            System.out.println("================");
            //	compiler.renderAppTS(app);
            System.out.println("================");
        }
        TimeUnit.SECONDS.sleep(2L);
    }
}
