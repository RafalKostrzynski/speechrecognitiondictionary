package pl.kostrzynski.speechrecognitiontool.service;

import org.junit.jupiter.api.Test;
import pl.kostrzynski.speechrecognitiontool.model.LexiconResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LexiconTest {

    @Test
    public void getLexiconInfoTest() {
        List<LexiconResult> lexiconResults = new ArrayList<>();

        Lexicon lexicon = mock(Lexicon.class);
        when(lexicon.getLexiconInfo("en", "test")).thenReturn(new ArrayList<LexiconResult>());

        assertEquals(lexiconResults, lexicon.getLexiconInfo("en", "test"));
    }
}