package lt.codeacademy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	 @GetMapping("/login")
	    public String redirectTo(){
	        return "index/login";
	    }


		@GetMapping("/login?error")
		public String login(HttpServletRequest request, Model model) {
			HttpSession session = request.getSession(false);
			String errorMessage = null;
			if (session != null) {
				AuthenticationException ex = (AuthenticationException) session
						.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
				if (ex != null) {
					errorMessage = ex.getMessage();
				}
			}
	model.addAttribute("errorMessage", errorMessage);
			return "index/login";
		}

}
