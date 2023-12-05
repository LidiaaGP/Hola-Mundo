package com.ipartek.modelo;

public interface DAO_Constantes {
	
	
	//Constantes de
	String NOMBRE_BD = "bd_bar";
	String RUTA = "jdbc:mysql://localhost:3306/" + NOMBRE_BD;
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String USUARIO = "root";
	String PASS = "1234";
	
	//Nombres de las Vistas JSP
	String JSP_BEBIDAS="bebidas.jsp";
	String JSP_BOCADILLOS="index.jsp";
	String JSP_POSTRES="postres.jsp";
	
	//Constantes de Tablas
	String TABLA_CATEGORIAS="categorias";
	String CATEGORIAS_ID="id";
	String CATEGORIAS_CATEGORIA="categoria";
	
	String TABLA_PRODUCTOS="productos";
	String PRODUCTOS_ID="id";
	String PRODUCTOS_NOMBRE="nombre";
	String PRODUCTOS_PRECIO="precio";
	String PRODUCTOS_FK_CATEGORIA="FK_categoria";
	
	
	String VISTA_PRODUCTOS="v_productos";
	String V_PRODUCTOS_ID="id";
	String V_PRODUCTOS_NOMBRE="nombre";
	String V_PRODUCTOS_PRECIO="precio";
	String V_PRODUCTOS_FK_CATEGORIA="FK_categoria";
	String V_PRODUCTOS_CATEGORIA="categoria";
	
	//Atributos para el jsp
	String ATR_LISTA_PRODUCTOS="atr_lista_productos";
	
	//Procedimientos almacenados
	String SP_OBTENER_BOCADILLOS="call bd_bar.sp_obtenerTodosBocadillos();";
	String SP_OBTENER_POSTRES="call bd_bar.sp_obtenerTodosPostres();";
	String SP_OBTENER_BEBIDAS="call bd_bar.sp_obtenerTodasBebidas();";
	
	String SP_OBTENER_PRODUCTOS="call bd_bar.sp_obtenerProductosPorCateg(?);";
	
}
