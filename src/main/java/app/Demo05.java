package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {

		// ******** ELIMINAR

		// obtener la conexion ->segun la unidad de persistencia
		// ESTO ES COMO EL DAOFACTORY fabrica=..
		// 1-fabrica de acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// 2-crear manejador de entidaddes
		// crea los dao usando la fabrica
		EntityManager em = fabrica.createEntityManager();

		// a partir de aca ya viene el proceso

		// proceso: eliminar usuario
		Usuario u = em.find(Usuario.class, 20);


		if(u==null) {
			System.out.println("El Usuario NO existe");
		}else {
			// 1-empieza la transaccion
			em.getTransaction().begin();

			// 2-si quiero eliminar indico .remove() metodo para eliminar
			//si el usuario que eliminaremos esta en otra tabla no se eliminara
			//por la famosa FK
			
			em.remove(u); // para eliminar (borrar de la tabla)/ lo recomendable es cambiar a un estado
			
			// 3-confirmo la transaccion
			em.getTransaction().commit();
			
			System.out.println("Eliminacion OK");
			
			// 4- cierro
			em.close();
		}
		

		

	}

}
