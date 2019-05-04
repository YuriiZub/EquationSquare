package test.squareequation;


import com.squareequantion.config.MyConfig;
import com.squareequantion.controller.EquantionController;
import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.EquationSolution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test of Main controller
 * Created by Yurii on 5/4/2019.
 * @test of controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
@WebMvcTest(EquantionController.class)
public class EquantionControllerTest {

    private MockMvc mockMvc;
    @Mock
    private EquationSolution equationSolution;

    @InjectMocks
    private EquantionController equantionController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(equantionController)
                .build();
    }

    @Test
    public void getMainPage() throws Exception {
             mockMvc.perform(get("/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(view().name("index"))
                     .andExpect(status().isOk());
    }

    @Test
    public void calcSubmit() throws Exception {
        EquantionsEntity entity = new EquantionsEntity();
        entity.setParamA(1);
        entity.setParamB(6);
        entity.setParamC(1);

        mockMvc.perform(post("/equation")
                .contentType(MediaType.APPLICATION_JSON)
                //.content(toJson(entity)))
                .andExpect(status().isOk());

        doNothing().when(equationSolution).doSolution();
        mockMvc.perform(
                post("/equation")
                        .contentType(MediaType.TEXT_HTML)
                        .content(asJsonString(entity)))
                .andExpect(status().isCreated())
                .andExpect(view().name(git"results"))
                .andExpect(header().string("location", containsString("http://localhost/results")));
        verifyNoMoreInteractions(equationSolution);

    }

    @Test
    public void calcForm() throws Exception {
        mockMvc.perform(get("/equantion")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(view().name("results"))
                .andExpect(status().isOk());

    }

}