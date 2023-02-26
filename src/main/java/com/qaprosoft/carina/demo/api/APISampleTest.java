package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;

import static com.mongodb.util.MyAsserts.assertTrue;

/**

 This sample shows how create REST API tests.

 @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testPostComment() throws Exception {
        LOGGER.info("test");
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        postCommentMethod.addProperty("postId", "1");
        postCommentMethod.addProperty("name", "test comment");
        postCommentMethod.addProperty("email", "test@test.com");
        postCommentMethod.addProperty("body", "this is a test comment");
        postCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postCommentMethod.callAPIExpectSuccess();
        postCommentMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetPosts() throws Exception {
        LOGGER.info("test");
        GetPostMethods getPostMethods = new GetPostMethods();
        getPostMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPostMethods.callAPI();
        getPostMethods.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testPostUser() throws Exception {
        LOGGER.info("test");
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
    }

    @Test
    public void testGetUsers() {
        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethods.callAPIExpectSuccess();
        getUserMethods.validateResponse();

        // Ensure that the response contains at least one user
        assertTrue((Boolean) getUserMethods.getResponse());
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testDeleteUser() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

}
