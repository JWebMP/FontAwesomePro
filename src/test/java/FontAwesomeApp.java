import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.core.base.angular.services.*;

@NgApp(name = "fontawesomePro", bootComponent = FontAwesomeKitchenSink.class)
public class FontAwesomeApp extends NGApplication<FontAwesomeApp>
{
	public FontAwesomeApp()
	{
		getOptions().setTitle("FontAwesome Kitchen Sink");
	}
	
}
