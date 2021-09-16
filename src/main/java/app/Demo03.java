package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
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
		Usuario u = new Usuario();
		u.setCodigo(20);


		// de mi manejador de entidades llamo a em
		// para registrar,actualizar,eliminar -< utilizo transacciones
		// como es una transaccion se tiene que confirmar o commitear

		// 1-empieza la transaccion
		em.getTransaction().begin();

		// 2-si quiero eliminar indico .remove() metodo para eliminar
		//si el usuario que eliminaremos esta en otra tabla no se eliminara
		//por la famosa FK
		
		em.remove(u); // para eliminar (borrar de la tabla)/ lo recomendable es cambiar a un estado
		
		// 3-confirmo la transaccion
		em.getTransaction().commit();

		// 5- para saber si se grabo lo muestro
		System.out.println("Eliminacion OK");

		// 4- cierro
		em.close();

	}

}
