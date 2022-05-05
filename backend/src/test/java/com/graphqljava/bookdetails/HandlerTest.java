package com.graphqljava.bookdetails;

import com.graphqljava.bookdetails.aws.Handler;
import com.graphqljava.bookdetails.aws.InputType;
import com.graphqljava.bookdetails.input.BookInput;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HandlerTest {

  @Test
  public void testGetBook() throws Exception {
    InputType data = new InputType();
    data.setQuery(getQueryJson());

    Map<String, Object> vars = new HashMap<>();
    vars.put("id", 0);

    data.setVariables(vars);

    String res = new Handler().handleRequest(data, null);

    System.out.println(res);
    //Assert.assertTrue(!res.contains("errors"));
  }


  @Test
  public void testAddBook() throws Exception {
    InputType data = new InputType();
    data.setQuery(getMutationJson());

    BookInput input = new BookInput();
    input.setBookId(0);
    input.setPageCount(123);
    input.setName("Book Name");
//    input.setAuthorFirstName("Blake");
//    input.setAuthorLastName("Bordovsky");

    Map<String, Object> vars = new HashMap<>();
    vars.put("newBook", getFieldHashmap(input));

    data.setVariables(vars);
    String res = new Handler().handleRequest(data, null);

    System.out.println(res);
    //Assert.assertTrue(!res.contains("errors"));
  }

  private Map<String, Object> getFieldHashmap(Object entity) throws IllegalAccessException, InvocationTargetException {
    Method[] methods = entity.getClass().getMethods();
    Map<String, Object> map = new HashMap<String, Object>();
    for(Method m : methods)
    {
      // Find all getters besides getClass
      if(m.getName().startsWith("get") && m.getName() != "getClass")
      {
        Object value = m.invoke(entity);
        // remove "get" prefix
        String name = m.getName().substring(3);
        // lowercase 1st character
        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
        map.put(name, value);
      }
    }
    return map;
  }


  private String getQueryJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("query.graphql");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }

  private String getMutationJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("mutation.graphql");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }
}
