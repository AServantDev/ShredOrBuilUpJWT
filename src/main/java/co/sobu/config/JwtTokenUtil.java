package co.sobu.config;

import static co.sobu.model.Constants.SIGNING_KEY;
import static co.sobu.model.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static co.sobu.model.Constants.SIGNING_KEY;

import java.io.Serializable;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import co.sobu.model.User;
import org.joda.time.DateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}
	
	public String generateToken(String username) {
		Algorithm algorithm = Algorithm.HMAC256("secret");
		String jws = JWT.create().withIssuer("SoBu").withSubject(username).withClaim("role","admin").withIssuedAt(generateCurrentDate())
				.withExpiresAt(generateExpirationDate()).sign(algorithm);

		return jws;
	}

//	public String generateToken(String username) {
//		Claims claims = Jwts.claims();
//		claims.put("session", Arrays.asList(new SimpleGrantedAuthority("admin")));
//		String jws = Jwts.builder().setIssuer("SoBu").setSubject(username).setIssuedAt(generateCurrentDate())
//				.setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS256, SIGNING_KEY).compact();
//
//		return jws;
//	}

	public Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	private long getCurrentTimeMillis() {
		return new DateTime().getMillis();
	}

	private Date generateCurrentDate() {
		return new Date(getCurrentTimeMillis());
	}

	private Date generateExpirationDate() {
		return new Date(getCurrentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000);
	}
//	
//	
//	public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//	
//	public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(SIGNING_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//    
//    public String generateToken(User user) {
//        return doGenerateToken(user.getEmail());
//    }
//    
//    private String doGenerateToken(String subject) {
//
//        Claims claims = Jwts.claims().setSubject(subject);
//        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
//
//        return Jwts.builder()
//                .setClaims(claims)
////                .setIssuer("http://localhost:4200")
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
//                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
//                .compact();
//    }
//    
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getUsernameFromToken(token);
//        return (
//              username.equals(((User) userDetails).getUsername())
//                    && !isTokenExpired(token));
//    }
//    
//    

}
