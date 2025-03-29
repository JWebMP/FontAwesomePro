package com.jwebmp.plugins.fontawesome5pro;


import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.plugins.fontawesome5.FontAwesome;

@NgImportReference(value = "FaDuotoneIconComponent", reference = "@fortawesome/angular-fontawesome")
@NgImportModule("FaDuotoneIconComponent")
public class FontAwesomeDuotone<J extends FontAwesomeDuotone<J>> extends FontAwesome<J>
{
    public FontAwesomeDuotone()
    {
        setTag("fa-duotone-icon");
    }
    
}
