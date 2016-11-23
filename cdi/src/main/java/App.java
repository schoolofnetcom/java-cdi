import com.schoolofnet.cdi.Routers;
import com.schoolofnet.cdi.WeldContext;

public class App {

	public static void main(String[] args) {
		WeldContext.INSTANCE.getBean(Routers.class);
	}
}
