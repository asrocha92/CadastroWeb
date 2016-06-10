package br.univel;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cadastroWeb.model.Cliente;

import br.univel.ejbs.ClienteDao;


//colocar um caminhi para que o serverlet responsa basta colocar essa anotation
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ClienteDao dao;

    //solicitação e resposta dentre os paramentros
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pessar dados por parametros pessadas pela url
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setTelefone(telefone);
		
		dao.salvar(c);
		
		response.getWriter().append("Cliente " + c + ", Cadastrado com sucesso!");
	}

}
