package demo.demospringssl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
    @RequestMapping(value="/",method= RequestMethod.GET)
    public String sayHello(){
        return "hello";
    }
    
    @RequestMapping(value="/detail",method= RequestMethod.GET)
    public HomeMessage detail(){
    	
    	HomeMessage homeMessage = new HomeMessage();
    	homeMessage.setId(10);
    	homeMessage.setMessage("this is the message");
    	
        return homeMessage;
    }

}
