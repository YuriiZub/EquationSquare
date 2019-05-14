package test.squareequation;

import com.squareequantion.config.MyConfig;
import com.squareequantion.controller.EquantionController;
import com.squareequantion.model.EquantionsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test of Main controller
 * Created by Yurii on 5/4/2019.
 *
 * @test of controller
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
@WebAppConfiguration
public class EquantionControllerTest {

    @InjectMocks
    EquantionController controller;

    private MockMvc mockMvc;

    EquantionsEntity entity;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        entity = new EquantionsEntity();
        entity.setParamA(1.0);
        entity.setParamB(2.0);
        entity.setParamC(1.0);
    }

    /**
     * Test of root route
     * @throws Exception
     */
    @Test
    public void getMainPage() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.TEXT_HTML))
                .andExpect(view().name("index"))
                .andExpect(status().isOk());
    }

    /**
     * Test of post form
     * @throws Exception
     */
    @Test
    public void calcSubmit() throws Exception {

        mockMvc.perform(post("/equation")
                .flashAttr("equantion", new EquantionsEntity())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("results"));
    }

    /**
     * Test of result route
     * @throws Exception
     */
    @Test
    public void calcForm() throws Exception {
        mockMvc.perform(get("/equation")
                .accept(MediaType.TEXT_HTML))
                .andExpect(view().name("equantion"))
                .andExpect(status().isOk());
    }
}