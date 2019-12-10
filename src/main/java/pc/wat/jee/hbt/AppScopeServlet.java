
package pc.wat.jee.hbt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;



@ApplicationScoped
public class AppScopeServlet {
    
    private HiberManager dbManager = new HiberManager();
    
    public AppScopeServlet() {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println("YOLO");
        System.out.println(dtf.format(now));  
        DataEntity toAdd = new DataEntity.DataEntityBuilder().c1("yolo").c2("swag").id(dtf.format(now)).build();
        dbManager.saveEntity(toAdd);
        
        
    }
}
