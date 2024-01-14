package com.eldar.business.jiraextractor.components;

import com.eldar.business.jiraextractor.domain.entities.AppUser;
import com.eldar.business.jiraextractor.domain.entities.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author claudio.vilas
 * date 01/2024
 * description configuracion JWT
 */

@Component
@Slf4j
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication){
        AppUser user = (AppUser) authentication.getPrincipal();
        int expiration = 3600000;
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .claim("roles", this.getRolesFromUser(user))
                .claim("email", user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(this.getKey(secret))
                .compact();

    }

    public String getUsernameFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(this.getKey(secret)).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(this.getKey(secret)).build()
                    .parseClaimsJws(token).getBody();
            return true;
        }catch (MalformedJwtException e){
            log.error("ERROR: token mal formado");
        }catch (UnsupportedJwtException e){
            log.error("ERROR: token no soportado");
        }catch (ExpiredJwtException e){
            log.error("ERROR: token expirado");
        }catch (IllegalArgumentException e){
            log.error("ERROR: token vacio");
        }
        return false;
    }

    private List<String> getRolesFromUser(AppUser user){
        return user.getRoles().stream().map(Role::getAuthority)
                .collect(Collectors.toList());
    }
    private Key getKey(String secret){
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }
}
