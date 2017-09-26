
    package hello;

    import static org.hamcrest.Matchers.equalTo;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    import org.junit.*;
    import org.junit.runner.*;
    import org.springframework.beans.factory.annotation.*;
    import org.springframework.boot.test.autoconfigure.web.servlet.*;
    import org.springframework.boot.test.context.*;
    import org.springframework.http.*;
    import org.springframework.test.context.junit4.*;
    import org.springframework.test.web.servlet.*;
    import org.springframework.test.web.servlet.request.*;

    @RunWith( SpringRunner.class )
    @SpringBootTest
    @AutoConfigureMockMvc
    public class HelloControllerTest
    {
        @Autowired
        private MockMvc mvc;

        @Test
        public void getHello() throws Exception
        {
            mvc.perform( MockMvcRequestBuilders.get( "/" ).accept( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() )
                .andExpect( content().string(equalTo( "Greetings from Spring Boot!"  ) ) );
        }
    }
