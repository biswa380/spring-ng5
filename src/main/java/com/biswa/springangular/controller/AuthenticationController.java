/*package com.biswa.springangular.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biswa.springangular.models.UserModel;

@Controller
@EnableOAuth2Client
public class AuthenticationController {
	
	@Value("${oauth.resource:http://localhost:8081}")
    private String baseUrl;
    @Value("${oauth.authorize:http://localhost:8081/oauth/authorize}")
    private String authorizeUrl;
    @Value("${oauth.token:http://localhost:8081/oauth/token}")
    private String tokenUrl;
    
	@RequestMapping("/login")
	@ResponseBody
	public Object login(@RequestBody UserModel user) {
		AccessTokenRequest atr = new DefaultAccessTokenRequest();
        OAuth2RestOperations oro=new OAuth2RestTemplate(resource(user), new DefaultOAuth2ClientContext(atr));
		return oro.getAccessToken();
	}
	
	protected OAuth2ProtectedResourceDetails resource(UserModel user) {
    	ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
    	List<String>scopes = new ArrayList<String>();
    	
    	scopes.add("write");
        scopes.add("read");
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(user.getUsername());
        resource.setClientSecret(user.getPassword());
        resource.setGrantType("password");
        resource.setScope(scopes);

        resource.setUsername(user.getUsername());
        resource.setPassword(user.getPassword());

        return resource;
    	
    }
	
	@Resource(name="tokenServices")
	ConsumerTokenServices tokenServices;
	     
	@RequestMapping(method = RequestMethod.POST, value = "/tokens/revoke/{tokenId:.*}")
	@ResponseBody
	public String revokeToken(@PathVariable String tokenId) {
	    tokenServices.revokeToken(tokenId);
	    return tokenId;
	}

}
*/