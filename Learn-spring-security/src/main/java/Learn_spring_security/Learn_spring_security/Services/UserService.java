package Learn_spring_security.Learn_spring_security.Services;

import Learn_spring_security.Learn_spring_security.Repository.UserRepo;
import Learn_spring_security.Learn_spring_security.entity.user;
import Learn_spring_security.Learn_spring_security.models.ComanReqModel;
import Learn_spring_security.Learn_spring_security.models.CommonRespModal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.* ;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private CommonRespModal commonRespModal;


    public CommonRespModal addNewUser(ComanReqModel reqModel) {

        String statusCode = "99";
        String message = "user add failed.please try again";

        try{

            user user = new user();


            user.setUsername(reqModel.getUsername());
            user.setEmail(reqModel.getEmail());
            user.setPassword(reqModel.getPassword());
            user.setMobile(reqModel.getMobile());
            user.setCity(reqModel.getCity());

            userRepo.save(user);

             statusCode = "200";
             message = "User Created SuccessFully!!!!";
        } catch (Exception e) {
             log.error("fail to create user :  {}" , e);
        }

        commonRespModal.setMessage(message);
        commonRespModal.setStatusCode(statusCode);
        commonRespModal.setResponse(null);
        return commonRespModal ;

    }

    public CommonRespModal getUser() {
        String statusCode = "99";
        String message = "User retrieval failed. Please try again.";

        try {
            List<user> allUsers = userRepo.findAll();

            // Logging for debug purposes
            log.info("Retrieved users: {}", allUsers);

            statusCode = "200";
            message = "Users retrieved successfully.";
            commonRespModal.setResponse(allUsers);
        } catch (Exception e) {
            log.error("Failed to retrieve users: {}", e.getMessage(), e);
        }

        commonRespModal.setMessage(message);
        commonRespModal.setStatusCode(statusCode);
        return commonRespModal;
    }

}
