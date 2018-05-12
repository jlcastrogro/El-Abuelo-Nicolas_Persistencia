package elabuelonicolas.bd.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import elabuelonicolas.bd.domain.Cliente;;

public interface ClienteMapper {
	List<Cliente> findAll();

	void create(Cliente cliente);

	Cliente readById(int id);

	List<Cliente> readByName(String nombre);

	List<Cliente> readByAddress(String direccion);

	List<Cliente> readByContact(String nombre);

	List<Cliente> readByNumber(String numero);

	List<Cliente> readByEmail(String email);

	List<Cliente> readByRfc(String rfc);

	void update(Cliente cliente);

	void updateName(@Param("id") int id, @Param("nombre") String nombre);

	void updateAddress(@Param("id") int id, @Param("direccion") String direccion);

	void updateContact(@Param("id") int id, @Param("contacto") String contacto);

	void updateNumber(@Param("id") int id, @Param("telefono") String telefono);

	void updateEmail(@Param("id") int id, @Param("email") String email);

	void updateRfc(@Param("id") int id, @Param("rfc") String rfc);

	void delete(int id);
	
	Cliente lastClient();
}