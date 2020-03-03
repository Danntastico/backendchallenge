package com.backendchallenge.service;


import com.backendchallenge.model.CTF;
import com.backendchallenge.repository.CTFRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CTFServiceTest {
    @Spy
    private CTFService ctfService;

    @MockBean
    private CTFRepository ctfRepository;

    private CTF dataTest;
    private CTF dataTest2;

    private final int testId1 = 1;
    private final int testId2 = 2;

    private final List<CTF> ctfList = new ArrayList<>();
    private final List<Integer> idList = new ArrayList<>();

    @Before
    public void setup(){
        dataTest = new CTF();
        dataTest.setAnimeId(testId1);
        dataTest.setName("AnimeTest1");
        dataTest.setGenre("genreTest");
        dataTest.setType("typeTest");
        dataTest.setEpisodes(999);
        dataTest.setRating(1.111);
        dataTest.setImg("imagetest");
        dataTest.setStudios("studiosTest");
        dataTest.setSource("sourceTest");
        dataTest.setMain_cast("mainCastTest");
        dataTest.setC1(999);
        dataTest.setC2(666);
        dataTest.setMembers(999);

        dataTest2 = new CTF();
        dataTest2.setAnimeId(testId2);
        dataTest2.setName("AnimeTest2");
        dataTest2.setGenre("genreTest2");
        dataTest2.setType("typeTest2");
        dataTest2.setEpisodes(99);
        dataTest2.setRating(1.1111);
        dataTest2.setImg("imagetest2");
        dataTest2.setStudios("studiosTest2");
        dataTest2.setSource("sourceTest2");
        dataTest2.setMain_cast("mainCastTest2");
        dataTest2.setC1(99);
        dataTest2.setC2(66);
        dataTest2.setMembers(99);

        ctfList.add(dataTest);
        ctfList.add(dataTest2);

        idList.add(testId1);
        idList.add(testId2);

        //Mockito.when(ctfService.findAll()).thenReturn(ctfList);

        Mockito.when(ctfService.getAllIdAnimes()).thenReturn(idList);

        Mockito.when(ctfService.findAnimeById(testId1)).thenReturn(dataTest);
    }
    /*
    @Test
    public void testFindAll_thenctfListShouldBeReturned(){
        List<CTF> foundCTF = ctfService.findAll();

        assertNotNull(foundCTF);
        assertEquals(2, foundCTF.size());
    }
*/

    @Test
    public void tesGetAllIdAnimes_thenIdListShouldBeReturned(){
        List<Integer> found = ctfService.getAllIdAnimes();

        assertNotNull(found);
        assertEquals(idList, found);
    }

    @Test
    public void testFindAnimeById(){
        CTF found = ctfService.findAnimeById(testId1);

        assertNotNull(found);
        assertEquals(dataTest.getName(), found.getName());
    }
}
