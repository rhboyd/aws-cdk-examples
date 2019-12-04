package software.amazon.awscdk.examples;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Stack;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.Before;
import org.junit.Test;
import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.examples.MyWidgetServiceStack;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static software.amazon.awscdk.examples.TestUtils.toCloudFormationJson;

public class MyWidgetServiceTest {
    private JsonNode actualStack;
    private JsonNode expectedStack;

    @Before
    public void setUp() throws IOException {
        App app = new App();
        Stack stack = new MyWidgetServiceStack(app, "MyWidgetServiceStack");
        actualStack = toCloudFormationJson(stack).path("Resources");
        expectedStack = TestUtils.fromFileResource(getClass().getResource("testMyWidgetServiceExpected.json")).path("Resources");
    }
    
    @Test
    public void testTypes() {
        List<String> actual = actualStack.findValues("Type")
                .stream().map(JsonNode::textValue).collect(Collectors.toList());
        String[] expected = expectedStack.findValues("Type")
                .stream().map(JsonNode::textValue).toArray(String[]::new);
        assertThat(actual, containsInAnyOrder(expected));
    }
	
}
