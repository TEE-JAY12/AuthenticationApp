package authenticationapp.service;

import authenticationapp.dto.Userdto;
import authenticationapp.dto.Userdtoedit;
import authenticationapp.entity.User;
import authenticationapp.repository.UserRepository;
import authenticationapp.util.BaseResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
@Service
public class UserClassService {
    public static final String OPERATION_SUCCESSFUL = "Operation successful";
    @Autowired
    private UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public BaseResponse registerUser(Userdto user){
        BaseResponse response = new BaseResponse();

        String password = passwordEncoder.encode(user.getPassword());

//      User user1 = new User(user.getUserName(),password, user.getEmail(),)
        User user1 = User.builder()
                .userName(user.getUserName())
                .password(password)
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();

        User newuser =repository.save(user1);
        response.setData(newuser);
        response.setDescription(OPERATION_SUCCESSFUL);
        response.setStatusCode(HttpServletResponse.SC_OK);
        return response;
    }

    public BaseResponse updateDetails (Userdtoedit user){
        BaseResponse response = new BaseResponse();
        User userDetail = repository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("specified guarantee not found"));
//        User user2 = userDetail.builder()
//                .email(user.getEmail())
//                .phoneNumber(user.getPhoneNumber())
//                .build();
        BeanUtils.copyProperties(user,userDetail);
        User updateduser = repository.save(userDetail);

        response.setData(updateduser);
        response.setDescription(OPERATION_SUCCESSFUL);
        response.setStatusCode(HttpServletResponse.SC_OK);
        return response;

    }
}
