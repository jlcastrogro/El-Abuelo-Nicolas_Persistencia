package elabuelonicolas.dao.venta;

import static org.junit.Assert.assertNotEquals;
import java.sql.Date;
import javax.inject.Inject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import elabuelonicolas.bd.domain.Venta;
import elabuelonicolas.dao.venta.VentaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UpdateTest {
	@Inject
	VentaDao ventaDao;
	private Venta venta;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		this.venta = new Venta();
		this.venta.setIdcliente(1);;
		this.venta.setIdlistaventa(1);
		this.venta.setFecha(new Date(2018, 1, 1));
		this.venta.setTotal(100.10);

		ventaDao.create(this.venta);

		this.venta.setId(ventaDao.last().getId());
	}

	@After
	public void tearDown() {
		this.venta = null;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void update() {
		Venta v = ventaDao.read(this.venta.getId());
		try {
			System.out.println("Update");
			v.setIdcliente(2);
			v.setIdlistaventa(2);
			v.setFecha(new Date(2019, 1, 1));
			v.setTotal(1920812.1);
			ventaDao.update(v);
		} catch (Exception e) {
			System.out.println("Error updateTest: " + e);
		}

		assertNotEquals(this.venta.getIdcliente(), v.getIdcliente());
		assertNotEquals(this.venta.getIdlistaventa(), v.getIdlistaventa());
		assertNotEquals(this.venta.getFecha(), v.getFecha());
		assertNotEquals(this.venta.getTotal(), v.getTotal());
	}

	@Test
	public void updateIdCliente() {
		try {
			System.out.println("UpdateIdCliente");
			ventaDao.updateIdCliente(this.venta.getId(), 10);
			Venta v = ventaDao.read(this.venta.getId());
			assertNotEquals(v.getIdcliente(), this.venta.getIdcliente());
		} catch (Exception e) {
			System.out.println("Error updateIdClienteTest: " + e);
		}
	}

	@Test
	public void updateIdListaVenta() {
		try {
			System.out.println("UpdateIdListaVenta");
			ventaDao.updateIdListaVenta(this.venta.getId(), 11);
			Venta v = ventaDao.read(this.venta.getId());
			assertNotEquals(v.getIdlistaventa(), this.venta.getIdlistaventa());
		} catch (Exception e) {
			System.out.println("Error updateIdListaVentaTest: " + e);
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void updateFecha() {
		try {
			System.out.println("UpdateFecha");
			ventaDao.updateFecha(this.venta.getId(), new Date(2018,12,1));
			Venta c = ventaDao.read(this.venta.getId());
			assertNotEquals(c.getFecha(), this.venta.getFecha());
		} catch (Exception e) {
			System.out.println("Error updateFechaTest: " + e);
		}
	}

	@Test
	public void updatePrecioTotal() {
		try {
			System.out.println("UpdatePrecioTotal");
			ventaDao.updateTotal(this.venta.getId(), 1000.1);
			Venta v = ventaDao.read(this.venta.getId());
			assertNotEquals(v.getTotal(), this.venta.getTotal());
		} catch (Exception e) {
			System.out.println("Error updatePrecioTotalTest: " + e);
		}
	}
}