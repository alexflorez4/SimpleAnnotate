package com.example.simple.read;

import com.example.simple.model.Customer;
import com.example.simple.model.Customers;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Registry;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReadXMLWithSimple {
	
	public static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static void main(String[] args) throws Exception {

		DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
		RegistryMatcher m = new RegistryMatcher();
		m.bind(Date.class, new DateFormatTransformer(df));

		Serializer serializer = new Persister(m);
		File source = new File("C:\\Users\\alexf\\Documents\\FAU\\JavaProjects\\XML Integration\\07_Simple\\SimpleAnnotate\\data\\customers.xml");

		Customers customers = serializer.read(Customers.class, source);
		List<Customer> data = customers.getCustomers();
		for (Customer customer : data)
		{
			System.out.println(customer);
		}


		
	}

}
