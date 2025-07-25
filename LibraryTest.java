import org.junit.jupiter.api.Test;

import okhttp3.OkhttpClient;
import okhttp3.Request;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

 class LibraryTest {

     String DB_URL = "jdbc:postgresql://localhost:55432/movies";
     String DB_USER = "postgres";
     String DB_PASSWORD = "postgress";

     @Test void someLibraryTrue() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod returt 'true'");
    }

     @Test void appReturnesMovieGenres() {
         OkHttpClient client = new OkHttpClient();

         Request request = new Request.Builder()
                 .url("http://localhost:4000/v1/genres").build();

         try {
             String response = client.newCall(request).execute().body().string();
             System.out.println(response);
             assertTrue(response.contains(s:"Adventure"));
         } catch (Exception e) {
             fail("Exception: " + e.getMessage());
         }
     }

     @Test void moviesListISNotEmpty() {
         String filmTitle = "";
         try {
             Class.forName("org.postgresql.Driver");
             Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql:"SELECT title FROM movies LIMIT 1");
             while (resultSet.next()) ;
             {
                 filmTitle = resultSet.getString(columnLabel:"title");

             }
             System.out.println("film title:" + filmTitle);
             connection.close();
         } catch (Exception e) {
             fail("Exception: " + e.getMessage());
         }

         }
         OkHttpClient client = new OkHttpClient();

         Request request = new Request.Builder()
                 .url("http://localhost:4000/v1/movies").build();

         try {
             String response = client.newCall(request).execute().body().string();
             System.out.println(response);
             assertTrue(response.contains("\"title\":\"" + filmTitle + "\""));
         } catch (Exception e) {
             fail("Exception: " + e.getMessage());
         }
     }

   @BeforeAll
   public void loginTest() {
     String userName = "userName";
     String password = "password";

   }
