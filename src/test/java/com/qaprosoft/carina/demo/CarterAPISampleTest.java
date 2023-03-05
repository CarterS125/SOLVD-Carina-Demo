package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class CarterAPISampleTest {
    @Test
    public void testGetUsers() {
        GetUserMethod getUserMethod = new GetUserMethod(1);
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponse(JSONCompareMode.STRICT);
        getUserMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test
    public void testPostUser() {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.addProperty("title", "professor");
        postUserMethod.addProperty("body", "professor Le has taught computer science classes since 2007");
        postUserMethod.addProperty("userId", 1);
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse(JSONCompareMode.STRICT);
        postUserMethod.validateResponseAgainstSchema("api/users/_post/rs.schema");
    }

    @Test
    public void testPutUser() {
        PutUserMethod putUserMethod = new PutUserMethod("surgeon", "gabriel is a heart surgeon.", 1);
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse(JSONCompareMode.STRICT);
        putUserMethod.validateResponseAgainstSchema("api/users/_put/rs.schema");
    }

    @Test
    public void testDeleteUser() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(1);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse(JSONCompareMode.STRICT);
    }

    @Test
    public void testGetPost() {
        GetPostMethod getPostMethod = new GetPostMethod(1);
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse(JSONCompareMode.STRICT);
        getPostMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

}
