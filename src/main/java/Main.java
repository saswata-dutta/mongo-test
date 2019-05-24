import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    try {
      ServerAddress serverAddress = new ServerAddress("localhost", 27017);
      MongoCredential credential =
          MongoCredential.createCredential("userName", "database", "password".toCharArray());
      MongoClient mongoClient =
          new MongoClient(serverAddress, Collections.singletonList(credential));

      DB db = mongoClient.getDB("mydb");
      DBCollection coll = db.getCollection("testCollection");
      DBObject myDoc = coll.findOne();
      System.out.println(myDoc);
      System.out.println(coll.getCount());

    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
}
