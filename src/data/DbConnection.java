package data;


import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

public class DbConnection {
	private static DbConnection INSTANCE = null;
	private final static String HOST ="localhost";
	private final static int PORT = 8080;
	private final static String USER = "user";
	private final static String PASSWORD = "user";
	private static ObjectContainer db;

	private DbConnection() {

	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DbConnection();
			DbConnection.getConnection();
		}
	}

	public static void getConnection() {

		ClientConfiguration dbConfig = Db4oClientServer.newClientConfiguration();
		db = Db4oClientServer.openClient(dbConfig,HOST, PORT, USER, PASSWORD);
	}

	public static ObjectContainer getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return db;
	}

	public static void closeConnection() {

	}
}
