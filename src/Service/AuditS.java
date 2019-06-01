package Service;
import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;

public class AuditS
{
        public static void write_action(String actionName, String pathName) throws IOException
        {
            StringBuilder sb = new StringBuilder();
            /*
            sb.append("Name of action");
            sb.append(',');
            sb.append("Timestamp");
            sb.append('\n');
        */
           try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true)))
            {
                Date date=new Date();

                Timestamp ts = new Timestamp(date.getTime());
                sb.append(actionName);
                sb.append(',');
                sb.append(ts);
                sb.append('\n');

                writer.write(sb.toString());

            }
            catch (FileNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
}

