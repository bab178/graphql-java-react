package com.graphqljava.bookdetails.aws;

import java.util.HashMap;
import java.util.Map;

public class InputType {
    private String query;
    private Map<String, Object> variables = new HashMap<>();

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }


    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    @Override
    public String toString() {
        String q = getQuery();
        String qS = q == null ? "no query" : q;
        
        Map<String, Object> v = getVariables();
        String vS = "no variables";
        if (v != null) {
            vS = "";
            for (Object item : v.entrySet()) {
                if (item != null && ((String) item).length() > 0) {
                    vS.concat(item.toString()).concat(",");
                }
            }
        }

        return super.toString().concat(qS).concat(" ").concat(vS);
    }
}
