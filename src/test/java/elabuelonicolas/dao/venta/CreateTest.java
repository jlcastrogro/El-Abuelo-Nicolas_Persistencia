package elabuelonicolas.dao.venta;

import static org.junit.Assert.assertEquals;
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
public class CreateTest {

	@Inject
	VentaDao ventaDao;

	private Venta venta;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		this.venta = new Venta();
		this.venta.setIdcliente(2);
		this.venta.setIdlistaventa(1);
		this.venta.setFecha(new Date(2018, 1, 1));
		this.venta.setTotal(100.10);
	}

	@After
	public void tearDown() {
		this.venta = null;
	}
	
	@Test
	public void create() {
		try {
			ventaDao.create(this.venta);
			
			Venta v = ventaDao.last();

			assertEquals(v.getFecha(), this.venta.getFecha());
		} catch (Exception e) {
			System.out.println("Error createTest: " + e);
		}
	}
}