package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class loginBean {
	
	
	
	public String login() {
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		String login = request.getParameter("loginBean:login");
		String senha = request.getParameter("loginBean:senha");
		System.out.println(login);
		System.out.println(senha);
		
		if(login.equals("admin") && senha.equals("123")) {
			return "Menu";
		}else {
			return "Login";
		}
		
		
	}
	

}
