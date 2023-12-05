package com.ipartek;

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

@WebServlet("/Inicio")
public class Inicio extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
	
    public Inicio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1: obtener parametros y atributos
		
		//2: maquetacion de la informacion
		
		//3: conexion base de datos
		DB_Helper db=new DB_Helper();
		Connection con=db.Conectar();
		
		
		//4: operaciones con la BD
		List<Producto> listaBocadillos =  db.obtenerTodosBocadillos(con);
		
		//5: DESCONEXION DE LA BD
		db.desconectar(con);
		
		//6: MOCHILA
		request.setAttribute(ATR_LISTA_PRODUCTOS, listaBocadillos);
		
		
		//7: viaje
		request.getRequestDispatcher(JSP_BOCADILLOS).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
