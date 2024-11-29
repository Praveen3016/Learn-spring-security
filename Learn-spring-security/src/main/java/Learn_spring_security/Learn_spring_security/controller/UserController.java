package Learn_spring_security.Learn_spring_security.controller;

import Learn_spring_security.Learn_spring_security.Services.UserService;
import Learn_spring_security.Learn_spring_security.models.ComanReqModel;
import Learn_spring_security.Learn_spring_security.models.CommonRespModal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping("/")
    public String CheckController()
    {
        System.out.println("hello praveen , whatsaap ");
        return "hello praveen" ;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCSRF(HttpServletRequest request)
    {

return (CsrfToken) request.getAttribute("_csrf");
    }



    @PostMapping("/addUser")
    public CommonRespModal addNewUser(@RequestBody ComanReqModel reqModel)
    {
      return   userService.addNewUser(reqModel);
    }

    @GetMapping("/getUser")
    public CommonRespModal addNewUser()
    {
        return   userService.getUser();
    }

}
