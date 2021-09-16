package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	


	public static void main(String[] args) {

		// ******** ELIMINAR CON FIND

		// obtener la conexion ->segun la unidad de persistencia
		// ESTO ES COMO EL DAOFACTORY fabrica=..
		// 1-fabrica de acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// 2-crear manejador de entidaddes
		// crea los dao usando la fabrica
		EntityManager em = fabrica.createEntityManager();

		// a partir de aca ya viene el proceso
		
		System.out.println("Listado de los usuarios");
		
		//String sql="select * from tb_usuarios where idtipo= ? "; //no sirve para jpa sino para jdbc
		
		String sql="select u from Usuario u"; //u guarda la info de cada registro JPA
		String sql2="select u from Usuario u where u.tipo =:xtipo";
		
		/*
		//permite guardar consulta
		System.out.println("LISTADO POR XTIPO");
		TypedQuery<Usuario> query=em.createQuery(sql2,Usuario.class);
		query.setParameter("xtipo",1);
		List<Usuario> lstUsuarios2=query.getResultList();
		
		*/
		
		//gestresultlist obtiene la consulta de tipo typequery y lo convierte en un list de la clase ususario
		//u.codigo
		List<Usuario> lstUsuarios=em.createQuery(sql2,Usuario.class).setParameter("xtipo",2).getResultList();
		System.out.println("nro de usuarios :"+lstUsuarios.size());
		//nos va a mostrar siempre y cuando hallamos colocado el metodo String
		for(Usuario u:lstUsuarios) {
			System.out.println(">>>>>> "+u);
		}
		
		

	}

}
