package com.example.common;

import java.util.HashMap;
import java.util.Map;

public class DataForAPI {

    /**
     * {
     * "name": "aFm",
     * "email": "dev@krafttechexlab.com",
     * "password": "123467",
     * "about": "About Me",
     * "terms": "10"
     * }
     */


    public static Map<String, Object> registerUserBody(String name, String email, String password, String about, String terms) {

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", name);
        requestMap.put("email", email);
        requestMap.put("password", password);
        requestMap.put("about", about);
        requestMap.put("terms", terms);

        return requestMap;

    }

    /**
     * Update User Own Profile (PATCH Method)
     * {
     *   "name": "aFm",
     *   "password": "123456",
     *   "admin": "0 or 1",
     *   "about": "About",
     *   "terms": "2",
     *   "job": "Developer",
     *   "company": "Mrcn Software",
     *   "website": "https://www.krafttechexlab.com/",
     *   "location": "Turkey",
     *   "skills": "PHP,Java"
     *   }
     */

    public static String patchUserProfileBody(String name, String password, String admin, String about, String terms, String job, String company, String website, String location, String skills){

        String body= """
                {
                  "name": "%s",
                  "password": "%s",
                  "admin": "%s",
                  "about": "%s",
                  "terms": "%s",
                  "job": "%s",
                  "company": "%s",
                  "website": "%s",
                  "location": "%s",
                  "skills": "%s"
                  }
                """.formatted(name,password,admin,about,terms,job,company,website,location,skills);


        return body;
    }

    /**
     * User Add Experience to Himself (POST Method)
     * {
     *   "job": "Junior Developer",
     *   "company": "Kraft Techex",
     *   "location": "USA",
     *   "fromdate": "YYYY-MM-DD",
     *   "todate": "YYYY-MM-DD",
     *   "current": "false",
     *   "description": "Description"
     * }
     */

    public static String postExperienceBody(String job, String company, String location, String fromdate, String todate, String current, String description){
        String body = """
                {
                  "job": "%s",
                  "company": "%s",
                  "location": "%s",
                  "fromdate": "%s",
                  "todate": "%s",
                  "current": "%s",
                  "description": "%s"
                }
                """.formatted(job,company,location,fromdate, todate,current,description);

        return body;
    }


}
