package com.koreait.test;

import com.koreait.junittest.BoardVO;
import com.koreait.junittest.Query;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueryTest {

/*
    @BeforeAll
    public static void beforeAll() {
        System.out.println("모든 테스트 시작 전에 최초 1회 실행하는 메소드");
        Query.createTable();
    }


    @AfterAll
    public static void afterAll() {
        System.out.println("모든 테스트 종료 후에 최초 1회 실행되는 메소드");
        Query.dropTable();
    }
*/

    @BeforeEach
    public void beforeEach() {
        System.out.println("각 테스트 메소드 실행 전에 항상 실행되는 메소드");
        Query.boardDelete(0);

        BoardVO vo = new BoardVO();
        vo.setBtitle("야야야");
        vo.setBcontent("왜오왜");
        Query.boardInsert(vo);

        BoardVO vo1 = new BoardVO();
        vo1.setBtitle("히히히");
        vo1.setBcontent("호호호");
        Query.boardInsert(vo1);

    }

    @Test
    public void testA() {
        System.out.println("testA");
        List<BoardVO> list = Query.getAllBoardList();
        assertEquals(list.size(), 2);
    }

/*    @Test
    public void testB() {
        System.out.println("testB");
        Query.boardDelete(1);
        Query.boardDelete(2);
        List<BoardVO> list = Query.getAllBoardList();
        System.out.println(list.size());
    }*/

    @Test
    public void testC() {
        BoardVO vo3 = new BoardVO();
        vo3.setBid(1);
        vo3.setBtitle("회오리감자");
        vo3.setBcontent("먹기싫어");
        Query.boardUpdate(vo3);


        BoardVO vo4 = new BoardVO();
        vo4.setBid(2);
        vo4.setBtitle("통감자");
        vo4.setBcontent("설탕에찍어먹어");
        Query.boardUpdate(vo4);

        BoardVO vo5 = Query.getBoardDetail(1);
        BoardVO vo6 = Query.getBoardDetail(2);
        assertEquals(vo5.getBid(), vo3.getBid());
        assertEquals(vo6.getBid(), vo4.getBid());

    }

}
