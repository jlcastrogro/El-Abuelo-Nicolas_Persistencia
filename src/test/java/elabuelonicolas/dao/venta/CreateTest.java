package elabuelonicolas.dao.venta;

import static org.junit.Assert.assertEquals;
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
	
	@Before
	public void setUp() {
		this.venta = new Venta();
		this.venta.setIdcliente(2);
		this.venta.setTotal(100.10);
		this.venta.setTotalreal(100.10);
		this.venta.setGanancia(100.10);
	}

	@After
	public void tearDown() {
		ventaDao.delete(this.venta.getId());
	}
	
	@Test
	public void create() {
		try {
			ventaDao.create(this.venta);
			Venta v = ventaDao.last();
			assertEquals(v.getTotal(), this.venta.getTotal());
			
			this.venta.setId(v.getId());
		} catch (Exception e) {
			System.out.println("Error createVentaTest: " + e);
		}
	}
}
