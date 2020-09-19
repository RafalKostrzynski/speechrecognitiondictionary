package pl.kostrzynski.speechrecognitiontool.api;

import com.detectlanguage.errors.APIError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiTest {

    @Autowired
    private MockMvc mockMvc;
    private Api api;

    @BeforeEach
    public void init() {
        api = Mockito.mock(Api.class);
    }

    @Test
    public void getPhraseInfoTest() throws Exception {

        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("alphabet")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("can I have some bread")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("can i have some bread")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("?")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("jd3 s ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void exceptionTest() throws Exception {
        when(api.getPhraseInfo("abc")).thenThrow(APIError.class);
        when(api.getPhraseInfo("cba")).thenThrow(IllegalArgumentException.class);

        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("abc")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/phrase/phraseinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("cba")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}