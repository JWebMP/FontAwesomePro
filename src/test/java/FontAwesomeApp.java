import com.jwebmp.core.base.angular.services.*;
import com.jwebmp.core.base.angular.services.annotations.*;

@NgApp(name = "fontawesomePro", bootComponent = FontAwesomeKitchenSink.class)
public class FontAwesomeApp extends NGApplication<FontAwesomeApp>
{
	public FontAwesomeApp()
	{
		getOptions().setTitle("FontAwesome Kitchen Sink");
	}
	
}
