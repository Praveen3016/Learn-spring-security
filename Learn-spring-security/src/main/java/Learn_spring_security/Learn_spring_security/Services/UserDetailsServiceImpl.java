package Learn_spring_security.Learn_spring_security.Services;

import Learn_spring_security.Learn_spring_security.Repository.UserRepo;
import Learn_spring_security.Learn_spring_security.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public UserRepo userRepo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        System.out.println("User found: " + username + ", Password: " + user.getPassword());

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().toArray(new String[0]))
                .build();


    }
}
