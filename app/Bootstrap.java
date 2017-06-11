import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job{
	public void doJob() {
		if (MyUser.count()== 0){
			Fixtures.loadModels("initial-data.yml");
			System.out.println("Database populated with initial data.");
		}
	}
}