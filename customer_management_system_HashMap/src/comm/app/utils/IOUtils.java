package comm.app.utils;
import com.app.customer_management.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public interface IOUtils {
	
	static void writeDetails(Map<String,Customer> cust,String fileName) throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName)) )
		{
			out.writeObject(cust);
		}
	}
	
	@SuppressWarnings("unchecked")
	static Map<String,Customer> readDetails(String FileName) throws IOException, ClassNotFoundException
	{
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(FileName)) )
		{
			return (Map<String,Customer>) in.readObject();
		}
	}

}
