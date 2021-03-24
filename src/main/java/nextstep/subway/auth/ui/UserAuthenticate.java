package nextstep.subway.auth.ui;

import nextstep.subway.auth.domain.Authentication;
import nextstep.subway.auth.domain.AuthenticationToken;
import nextstep.subway.auth.dto.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public
class UserAuthenticate implements TokenAuthenticate {

    private UserLoader userLoader;

    public UserAuthenticate(UserLoader userLoader){
        this.userLoader = userLoader;
    }

    @Override
    public Authentication authenticate(AuthenticationToken authenticationToken) {
        UserPrincipal userPrincipal = userLoader.loadUserPrincipal(authenticationToken.getPrincipal());
//        checkAuthentication(userPrincipal, authenticationToken);
        return new Authentication(userPrincipal);
    }

//    private void checkAuthentication(UserPrincipal userDetails, AuthenticationToken token) {
//        if (userDetails == null) {
//            throw new RuntimeException();
//        }
//
//        if (!userDetails.checkCredentials(token.getCredentials())) {
//            throw new RuntimeException();
//        }
//    }
}