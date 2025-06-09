package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.entity.Edition;
import br.org.fenae.jogosfenae.exception.NoSuchElementFoundException;
import br.org.fenae.jogosfenae.repository.EditionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EditionServiceTest {

    @Mock
    private EditionRepository editionRepository;

    @InjectMocks
    private EditionService editionService;

    private Edition sampleEdition;

    @BeforeEach
    void setUp() {
        sampleEdition = Edition.builder()
                .editionId("ED1")
                .title("Title")
                .description("Description")
                .build();
    }

    @Test
    void saveEdition_generatesIdAndPersists() {
        when(editionRepository.save(any(Edition.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Edition toSave = Edition.builder()
                .title("New")
                .description("NewDesc")
                .build();

        Edition saved = editionService.saveEdition(toSave);

        assertNotNull(saved.getEditionId());
        verify(editionRepository).save(any(Edition.class));
    }

    @Test
    void findById_returnsEditionWhenExists() {
        when(editionRepository.findById("ED1"))
                .thenReturn(Optional.of(sampleEdition));

        Edition found = editionService.findById("ED1");

        assertEquals(sampleEdition, found);
    }

    @Test
    void findById_throwsWhenNotFound() {
        when(editionRepository.findById("NOID"))
                .thenReturn(Optional.empty());

        assertThrows(NoSuchElementFoundException.class, () ->
                editionService.findById("NOID"));
    }

    @Test
    void findByTitle_returnsEditionWhenExists() {
        when(editionRepository.findByTitleIgnoreCase("TITLE"))
                .thenReturn(Optional.of(sampleEdition));

        Edition found = editionService.findByTitle("TITLE");
        assertEquals(sampleEdition, found);
    }

    @Test
    void findByTitle_throwsWhenNotFound() {
        when(editionRepository.findByTitleIgnoreCase("MISSING"))
                .thenReturn(Optional.empty());

        assertThrows(NoSuchElementFoundException.class, () ->
                editionService.findByTitle("MISSING"));
    }

    @Test
    void findAll_returnsList() {
        List<Edition> list = Arrays.asList(sampleEdition);
        when(editionRepository.findAll()).thenReturn(list);

        List<Edition> result = editionService.findAll();

        assertEquals(list, result);
    }

    @Test
    void updateEdition_updatesFields() {
        when(editionRepository.findById("ED1"))
                .thenReturn(Optional.of(sampleEdition));
        when(editionRepository.save(any(Edition.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Edition newValues = Edition.builder()
                .title("Updated")
                .description("UpdatedDesc")
                .build();

        editionService.updateEdition("ED1", newValues);

        assertEquals("Updated", sampleEdition.getTitle());
        assertEquals("UpdatedDesc", sampleEdition.getDescription());
        verify(editionRepository).save(sampleEdition);
    }

    @Test
    void updateEdition_throwsWhenNotFound() {
        when(editionRepository.findById("UNKNOWN"))
                .thenReturn(Optional.empty());

        Edition newValues = Edition.builder().title("t").description("d").build();

        assertThrows(NoSuchElementFoundException.class, () ->
                editionService.updateEdition("UNKNOWN", newValues));
        verify(editionRepository, never()).save(any());
    }

    @Test
    void deleteEdition_deletesWhenPossible() {
        when(editionRepository.findById("ED1"))
                .thenReturn(Optional.of(sampleEdition));

        editionService.deleteEdition("ED1");

        verify(editionRepository).deleteById("ED1");
    }

    @Test
    void deleteEdition_throwsWhenNotFound() {
        when(editionRepository.findById("NONE"))
                .thenReturn(Optional.empty());

        assertThrows(NoSuchElementFoundException.class, () ->
                editionService.deleteEdition("NONE"));
        verify(editionRepository, never()).deleteById(anyString());
    }

    @Test
    void deleteEdition_throwsWhenViolation() {
        when(editionRepository.findById("ED1"))
                .thenReturn(Optional.of(sampleEdition));
        doThrow(new DataIntegrityViolationException("violation"))
                .when(editionRepository).deleteById("ED1");

        assertThrows(NoSuchElementFoundException.class, () ->
                editionService.deleteEdition("ED1"));
    }
}
