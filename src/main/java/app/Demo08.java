 package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Producto;
import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		
		//********** EJERCICIO DE LOGIN

		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

	
		EntityManager em = fabrica.createEntityManager();

		//validar un Usuario segun su usuario y clave
		//Usuario u = em.find(Usuario.class,30); // find solo trabaja en base a la llave primaria

		String sql="select u from Usuario u where u.usuario=:xusr and u.clave=:xcla";
		
		TypedQuery<Usuario> query=em.createQuery(sql,Usuario.class);
		
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
			u = query.getSingleResult();
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
