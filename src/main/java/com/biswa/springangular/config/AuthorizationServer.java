package com.biswa.springangular.config;

import java.security.KeyPair;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.biswa.springangular.repository.UserRepository;

@Configuration
@EnableAuthorizationServer
@EnableWebSecurity
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JwtAccessTokenConverter tokenConverter() {
//		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
//		tokenConverter.setSigningKey("skaterik123");
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(
				new ClassPathResource("keystore.jks"), "skaterik123".toCharArray()).getKeyPair("selfsigned");
		tokenConverter.setKeyPair(keyPair);
		return tokenConverter;
	}
	
	/*@Bean
	public TokenStore tokenStore() { 
	    return new InMemoryTokenStore(); 
	}*/
	@Bean
	public TokenStore tokenStore() { 
	    return new JwtTokenStore(tokenConverter()); 
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		// TODO Auto-generated method stub
		endpoints.tokenStore(tokenStore())
		.authenticationManager(authenticationManager)
		.accessTokenConverter(tokenConverter());
	}
	
	/*@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
	    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	    defaultTokenServices.setTokenStore(tokenStore());
	    defaultTokenServices.setSupportRefreshToken(true);
	    return defaultTokenServices;
	}*/

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security)
			throws Exception {
		// TODO Auto-generated method stub
		security.tokenKeyAccess("permitAll()")
         .checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory().withClient("skaterik").secret("pass")
		.authorizedGrantTypes("authorization_code",
				"password", "client_credentials", "implicit", "refresh_token")
		.scopes("read","write")
		.accessTokenValiditySeconds(60)
		.refreshTokenValiditySeconds(300);
	}
}
