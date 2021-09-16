package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {
	
public static void main(String[] args) {
		
		//********** EJERCICIO DE LOGIN CON PROCEDURE

		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

	
		EntityManager em = fabrica.createEntityManager();

		//validar un Usuario segun su usuario y clave ---> usar procedimiento almacenado
		//Usuario u = em.find(Usuario.class,30); // find solo trabaja en base a la llave primaria
		
		//JPA no soporta el llamado de procedimientos como JDBC
		
		//PROCEDIMIENTO ALMACENADO
		String sql="{call usp_validaAcceso(:xusr,:xcla)}";
		//Tambien se puede colocar asi
		//String sql="{call usp_validaAcceso(?,?)}";
		//query.setParameter(1,"10002");
		//query.setParameter(2,"10002");
		
		
		
		
		//ESTO ES PARA JPA
		//TypedQuery<Usuario> query=em.createQuery(sql,Usuario.class);
		
		//el query guarda el resultado lo guarda como un resultado de obajet
		Query query=em.createNativeQuery(sql,Usuario.class); // este resultado es como un objet
		
		//si tiene parametros lo puedo setear
		query.setParameter("xusr","U002@gmail.com");
		query.setParameter("xcla","10002");
		//parametro 2
		// parametro 3
		
		//ejecuto este query
		//como quiero que me devuelva solo 1 dato uso singlequery
		//el single me devuelve una excepcion
		Usuario u=null;
		try {
			//aca optengo el resultado del query
			u = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			
		}
		
		
		if(u==null) {
			System.out.println("Codigo NO existe");
		}else {

		System.out.println("Bienvenido : "+u.getNombre());
		System.out.println(u);
		}

		em.close();

	}

}
