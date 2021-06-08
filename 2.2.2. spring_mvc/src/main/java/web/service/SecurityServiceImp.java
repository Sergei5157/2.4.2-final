//package web.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityServiceImp implements SecurityService{
//
////    @Autowired
////    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public String findLoggedInUsername() {
//        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        if(userDetails instanceof UserDetails){
//            return ((UserDetails) userDetails).getUsername();
//        }
//        return null;
//    }
//
//    @Override
//    public void autoLogin(String login_name, String password) {
//        UserDetails userDetails =userDetailsService.loadUserByUsername(login_name);
//        UsernamePasswordAuthenticationToken upat =
//                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        //authenticationManager.authenticate(upat);
//        if(upat.isAuthenticated()){
//            SecurityContextHolder.getContext().setAuthentication(upat);
//        }
//    }
//}
