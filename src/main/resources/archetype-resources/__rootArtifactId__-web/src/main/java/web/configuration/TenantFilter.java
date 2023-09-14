package ${groupId}.web.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import  ${groupId}.model.dto.Region;
import  ${groupId}.model.dto.response.ErrorResponse;

@Component
@Order(1)
public class TenantFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try{
			String region = request.getHeader("x-region");
			if(region == null )
			   throw new IllegalArgumentException();
			 Region.valueOf(region);
		}catch(IllegalArgumentException e){
		  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		  final Map<String, Object> body = new HashMap<>();
		  body.put("code", ErrorResponse.ERROR_X_REGION.getCode());
		  body.put("title", ErrorResponse.ERROR_X_REGION.getTitle());
		  body.put("message", ErrorResponse.ERROR_X_REGION.getSuggestion());
		  final ObjectMapper mapper = new ObjectMapper();
		  mapper.writeValue(response.getOutputStream(), body);
		}
		
		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		
		return path.contains("/swagger") || path.contains("/api-docs") || path.contains("/springfox");
	}
	
}