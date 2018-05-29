package elabuelonicolas.dao.venta;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import elabuelonicolas.bd.domain.Venta;

public interface VentaDao {
	List<Venta> findAll();

	void create(Venta venta);

	Venta read(int id);

	List<Venta> readByIdCliente(int idCliente);

	List<Venta> readByIdListaVenta(int idListaventa);

	List<Venta> readByFecha(Date fecha);

	List<Venta> readByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

	void update(Venta venta);

	void updateIdCliente(@Param("id") int id, @Param("idCliente") int idCliente);

	void updateIdListaVenta(@Param("id") int id, @Param("idListaventa") int idListaventa);

	void updateFecha(@Param("id") int id, @Param("fecha") Date fecha);

	void updateTotal(@Param("id") int id, @Param("total") Double total);

	void delete(int id);
	
	Venta last();
}