package johnnyzhang.bigdata.spark.mysql;

import java.util.List;
import java.util.Properties;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparkMysqlMain {

    protected final static Logger LOGGER = LoggerFactory.getLogger(SparkMysqlMain.class);

    private static final String MYSQL_CONNECTION_URL = "jdbc:mysql://icepg-dev-vm61.cisco.com:3306/example";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PWD = "P@ss123";

    private static final SparkSession sparkSession = SparkSession.builder().master("local[*]").appName("SparkMysql")
            .getOrCreate();

    public static void main(String[] args) {
        // JDBC connection properties
        final Properties connectionProperties = new Properties();
        connectionProperties.put("user", MYSQL_USERNAME);
        connectionProperties.put("password", MYSQL_PWD);

        final String dbTable = "(select a.id, name, email, bookname from people a , people_books b where a.id = b.peopleId) as people_book";

        // Load MySQL query result as Dataset from table people and table
        // people_books
        // Join by table a and table b
        Dataset<Row> peopeBooks = sparkSession.read().jdbc(MYSQL_CONNECTION_URL, dbTable, connectionProperties);

        List<Row> peopleBookRows = peopeBooks.collectAsList();

        for (Row peopleBook : peopleBookRows) {
            LOGGER.info(" Data is " + peopleBook);
        }

        // Load MySQL query result as Dataset
        Dataset<Row> bookPrice = sparkSession.read().jdbc(MYSQL_CONNECTION_URL, "book", connectionProperties);

        List<Row> bookPriceRow = bookPrice.collectAsList();

        for (Row price : bookPriceRow) {
            LOGGER.info(" price for each book is:  " + price);
        }

        // Join C with the reuslt of a and b

        Dataset<Row> result = peopeBooks.join(bookPrice, peopeBooks.col("bookname").equalTo(bookPrice.col("bookname")))
                .select(peopeBooks.col("id"), peopeBooks.col("email"), peopeBooks.col("bookname"), bookPrice.col("bookprice"))
                .orderBy(peopeBooks.col("id"));
        
        List<Row> resultList = result.collectAsList();

        for (Row row : resultList) {
            LOGGER.info(" Final Result:  " + row);
        }

    }
   

}
