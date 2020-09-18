package pl.kostrzynski.speechrecognitiontool.service;

import org.junit.jupiter.api.Test;
import pl.kostrzynski.speechrecognitiontool.model.Sens;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LexiconTest {

    @Test
    public void getLexiconInfoTest() {
        List<Sens> sensResults = new ArrayList<>();

        Lexicon lexicon = mock(Lexicon.class);
        when(lexicon.getLexiconInfo("en", "test")).thenReturn(new ArrayList<Sens>());

        assertEquals(sensResults, lexicon.getLexiconInfo("en", "test"));
    }
}