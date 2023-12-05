package com.ipartek.controlador.menu;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DAO_Constantes;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Producto;

@WebServlet("/MenuBebidas")
public class MenuBebidas extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
    public MenuBebidas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1: obtención de parámetros y atributos
		
		//2: maquetación de la información
		
		//3: conexion base de datos
		DB_Helper db=new DB_Helper();
		Connection con=db.Conectar();
				
		//4: operaciones con la BD
		List<Producto> listaBebidas =  db.obtenerTodasBebidas(con);
        
		//5: DESCONEXION DE LA BD
		db.desconectar(con);
		
		//6: MOCHILA
		request.setAttribute(ATR_LISTA_PRODUCTOS, listaBebidas);
		
		//7: viaje		
		request.getRequestDispatcher(JSP_BEBIDAS).forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
