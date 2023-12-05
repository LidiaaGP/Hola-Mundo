package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;


public class DB_Helper implements DAO_Constantes{
	
	public Connection Conectar() {
		
		Connection con=null;
		
		try {
			Class.forName(DRIVER);
			con= DriverManager.getConnection(RUTA,USUARIO,PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NO ENCONTRADO");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO CONECTAR A LA BD");
			e.printStackTrace();
		}
		
		return con;
		
	}
	public void desconectar(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
			e.printStackTrace();
		}
	}
	public List<Producto> obtenerTodosBocadillos(Connection con) {
		
		//1 crear una lista vacía para ir rellenando y cuando este, devolver
		List<Producto> lista=new ArrayList<Producto>();
		
		try {
			//2 preparar la sentencia SQL para lanzar la consulta
			CallableStatement cStmt=con.prepareCall(SP_OBTENER_BOCADILLOS);
			
			//3 ejecutar la sentencia para poder tener los resultados
			cStmt.execute();
			
			//4 el cStmt.getResultset lo guardamos en una variable
			//para poder trabajar comodamente
			ResultSet rs=cStmt.getResultSet();
			
			//5 el resultset siempre se recorre con un while
			while(rs.next()) {
				//5.1 creamos un objeto vacio para rellenarlo
				Producto prod=new Producto();
				
				//5.2 el objeto vacio se rellena con los set y
				//los datos del resultset
				//se obtienen TODOS LOS DATOS; aunque no los usemos luego
				prod.setId(rs.getInt(PRODUCTOS_ID));
				prod.setNombre(rs.getString(PRODUCTOS_NOMBRE));
				prod.setPrecio(rs.getDouble(PRODUCTOS_PRECIO));
				prod.setFk_categoria(rs.getInt(PRODUCTOS_FK_CATEGORIA));
				
				//5.3 el objeto relleno lo metemos en la lista
				lista.add(prod);
				
			}
			
			
		} catch (Exception e) {
			//6 si hay error la lista la vaciamos.
			System.out.println("NO SE PUDO OBETENR LA LISTA DE BOCADILLOS");
			lista=new ArrayList<Producto>();
			
			e.printStackTrace();
			
		}
		
		//7 devolvemos la lista, si esta vacia, es que no hay bocadillos o
		//hubo un error, si viene llena, se realizo la consulta ok
		return lista;
	}
	
	
	public List<Producto> obtenerTodasBebidas(Connection con) {
		
		//1 crear una lista vacía para ir rellenando y cuando este, devolver
		List<Producto> lista3=new ArrayList<Producto>();
		
		try {
			//2 preparar la sentencia SQL para lanzar la consulta
			CallableStatement cStmt=con.prepareCall(SP_OBTENER_BEBIDAS);
			
			//3 ejecutar la sentencia para poder tener los resultados
			cStmt.execute();
			
			//4 el cStmt.getResultset lo guardamos en una variable
			//para poder trabajar comodamente
			ResultSet rs=cStmt.getResultSet();
			
			//5 el resultset siempre se recorre con un while
			while(rs.next()) {
				//5.1 creamos un objeto vacio para rellenarlo
				Producto prod=new Producto();
				
				//5.2 el objeto vacio se rellena con los set y
				//los datos del resultset
				//se obtienen TODOS LOS DATOS; aunque no los usemos luego
				prod.setId(rs.getInt(PRODUCTOS_ID));
				prod.setNombre(rs.getString(PRODUCTOS_NOMBRE));
				prod.setPrecio(rs.getDouble(PRODUCTOS_PRECIO));
				prod.setFk_categoria(rs.getInt(PRODUCTOS_FK_CATEGORIA));
				
				//5.3 el objeto relleno lo metemos en la lista
				lista3.add(prod);
				
			}
			
			
		} catch (Exception e) {
			//6 si hay error la lista la vaciamos.
			System.out.println("NO SE PUDO OBETENR LA LISTA DE BEBIDAS");
			lista3=new ArrayList<Producto>();
			
			e.printStackTrace();
			
		}
		
		//7 devolvemos la lista, si esta vacia, es que no hay postres o
		//hubo un error, si viene llena, se realizo la consulta ok
		return lista3;
	}
		
	
	
	public List<V_Producto> obtenertodosProductos(Connection con,int i) {
		
		//1 crear una lista vacía para ir rellenando y cuando este, devolver
		List<V_Producto> lista2=new ArrayList<V_Producto>();
		
		try {
			//2 preparar la sentencia SQL para lanzar la consulta
			CallableStatement cStmt=con.prepareCall(SP_OBTENER_PRODUCTOS);
			
			cStmt.setInt(1, i);
			//3 ejecutar la sentencia para poder tener los resultados
			cStmt.execute();
			
			//4 el cStmt.getResultset lo guardamos en una variable
			//para poder trabajar comodamente
			ResultSet rs=cStmt.getResultSet();
			
			//5 el resultset siempre se recorre con un while
			while(rs.next()) {
				//5.1 creamos un objeto vacio para rellenarlo
				V_Producto v_prod=new V_Producto();
				
				//5.2 el objeto vacio se rellena con los set y
				//los datos del resultset
				//se obtienen TODOS LOS DATOS; aunque no los usemos luego
				v_prod.setId(rs.getInt(V_PRODUCTOS_ID));
				v_prod.setNombre(rs.getString(V_PRODUCTOS_NOMBRE));
				v_prod.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
				v_prod.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
				v_prod.setCategoria(rs.getString(V_PRODUCTOS_CATEGORIA));
				
				
				//5.3 el objeto relleno lo metemos en la lista
				lista2.add(v_prod);
				
			}
			
			
		} catch (Exception e) {
			//6 si hay error la lista la vaciamos.
			System.out.println("NO SE PUDO OBTENER LA LISTA DE POSTRES");
			lista2=new ArrayList<V_Producto>();
			
			e.printStackTrace();
			
		}
		
		//7 devolvemos la lista, si esta vacia, es que no hay postres o
		//hubo un error, si viene llena, se realizo la consulta ok
		return lista2;
	}
	
	
}
