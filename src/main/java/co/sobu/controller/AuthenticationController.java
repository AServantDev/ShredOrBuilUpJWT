package co.sobu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.sobu.model.ApiResponse;
import co.sobu.model.AuthToken;
import co.sobu.model.LoginUser;
import co.sobu.model.User;

import co.sobu.config.JwtTokenUtil;
import co.sobu.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/generate-token")
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(loginUser.getUsername());
        System.out.println(jwtTokenUtil.getUsernameFromToken(token));
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUsername()));
    }
    
    @GetMapping(value = "/getToken")
    public String getUserFromToken(String token){
//    	User user = new User();
//    	return user = userService.findOne(jwtTokenUtil.getUsernameFromToken(token.getUsername()));
    	String user = jwtTokenUtil.getUsernameFromToken(token);
    	System.out.println(user);
    	return user;
    			
    }
    
    

}
